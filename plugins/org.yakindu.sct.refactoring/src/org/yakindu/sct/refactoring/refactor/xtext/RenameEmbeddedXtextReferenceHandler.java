package org.yakindu.sct.refactoring.refactor.xtext;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.ui.refactoring.ui.IRenameElementContext;
import org.eclipse.xtext.ui.refactoring.ui.IRenameSupport;
import org.yakindu.base.types.PrimitiveType;
import org.yakindu.sct.model.sgraph.util.EmbeddedContextUtil;

import com.google.inject.Injector;

/**
 * Renames elements outgoing from SCTs embedded context.
 */
@SuppressWarnings("restriction")
public class RenameEmbeddedXtextReferenceHandler extends AbstractHandler {

    // own executable extension factory?
    EmbeddedContextUtil contextUtil = new EmbeddedContextUtil();

    @Override
    public boolean isEnabled() {
        EObject selectedEObject = getSelectedEObject();
        EObject referredElement = getReferringElement(selectedEObject);
        // ensure the selection includes a resolved cross reference
        if (referredElement == null || referredElement.eIsProxy())
            return false;
        EObject contextElement = contextUtil.getContextElement(selectedEObject);
        if (contextElement == null)
            return false;
        return super.isEnabled();
    }

    @Override
    public Object execute(final ExecutionEvent event) throws ExecutionException {
        final EObject selectedCrossReferenceElement = getSelectedEObject();

        Injector injector = contextUtil.getDomainInjectorForEmbeddedElement(selectedCrossReferenceElement);

        IQualifiedNameProvider qualifiedNameProvider = injector.getInstance(IQualifiedNameProvider.class);

        final EObject referredElement = getReferringElement(selectedCrossReferenceElement);

        if (referredElement == null) {
            return null;
        }
        final URI referredElementUri = EcoreUtil.getURI(referredElement);
        final IRenameElementContext renameElementContext =
                new IRenameElementContext.Impl(referredElementUri, referredElement.eClass(), getActiveEditor(),
                        getCurrentSelection(), selectedCrossReferenceElement.eResource().getURI());

        String originalName = getOriginalName(referredElement, qualifiedNameProvider);

        IRenameSupport create =
                injector.getInstance(IRenameSupport.Factory.class).create(renameElementContext, originalName);

        try {
            create.startRefactoringWithDialog(false);
        } catch (InterruptedException e1) {
            throw new RuntimeException(e1);
        }

        return null;
    }

    private EObject getSelectedEObject() {
        Object firstElement = getSelectedElement();
        if (!(firstElement instanceof EObject)) {
            throw new IllegalArgumentException(
                    "cannot handle selections of type other than " + EObject.class.getSimpleName());
        }
        return (EObject) firstElement;
    }

    protected String getOriginalName(EObject referredElement, IQualifiedNameProvider qualifiedNameProvider) {
        QualifiedName fullyQualifiedName = qualifiedNameProvider.getFullyQualifiedName(referredElement);
        if (fullyQualifiedName == null)
            return null;
        return fullyQualifiedName.getLastSegment();
    }

    protected Object getSelectedElement() {
        final ISelection currentSelection = getCurrentSelection();
        if (currentSelection != null && currentSelection instanceof IStructuredSelection)
            return ((IStructuredSelection) currentSelection).getFirstElement();
        else
            return null;
    }

    private ISelection getCurrentSelection() {
        IEditorPart activeEditor = getActiveEditor();
        if (activeEditor == null)
            return null;
        final IWorkbenchPartSite site = activeEditor.getSite();
        if (site == null) {
            return null;
        }
        final ISelectionProvider selectionProvider = site.getSelectionProvider();
        if (selectionProvider == null) {
            return null;
        }
        return selectionProvider.getSelection();
    }

    private IEditorPart getActiveEditor() {
        final IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
        if (window == null) {
            return null;
        }
        IWorkbenchPage activePage = window.getActivePage();
        if (activePage == null)
            return null;
        return activePage.getActiveEditor();
    }

    protected EObject getReferringElement(final EObject selectedElement) {
        EObject firstWithReference = null;
        if (!selectedElement.eCrossReferences().isEmpty()) {
            firstWithReference = selectedElement;
        }
        else {
            while (selectedElement.eAllContents().hasNext()) {
                EObject withRef = selectedElement.eAllContents().next();
                if (!withRef.eCrossReferences().isEmpty()) {
                    firstWithReference = withRef;
                    break;
                }

            }
        }

        if (firstWithReference == null) {
            return null;
        }
        EList<EObject> eCrossReferences = firstWithReference.eCrossReferences();
        if (eCrossReferences.isEmpty()) {
            return null;
        }
        EObject next = eCrossReferences.iterator().next();
		return next instanceof PrimitiveType ? null : next;
    }

    protected Shell getShell() {
        try {
            return PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
        } catch (final Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    protected void applyChanges(final Change compositeChange) {
        final IRunnableWithProgress iRunnableWithProgress = new IRunnableWithProgress() {
            @Override
            public void run(final IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
                try {
                    compositeChange.perform(monitor);
                } catch (final CoreException ex) {
                    throw new RuntimeException(ex);
                } finally {
                    monitor.done();

                }
            }
        };

        final ProgressMonitorDialog progressMonitorDialog = new ProgressMonitorDialog(getShell());

        Display.getDefault().syncExec(new Runnable() {

            @Override
            public void run() {
                try {
                    progressMonitorDialog.run(false, false, iRunnableWithProgress);
                } catch (InvocationTargetException | InterruptedException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
    }
}