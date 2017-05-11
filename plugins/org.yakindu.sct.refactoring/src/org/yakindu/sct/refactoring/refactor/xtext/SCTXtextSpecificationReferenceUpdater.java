package org.yakindu.sct.refactoring.refactor.xtext;

import java.util.Collection;
import java.util.function.Consumer;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ltk.core.refactoring.CompositeChange;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.ui.refactoring.ElementRenameArguments;
import org.eclipse.xtext.ui.refactoring.IRefactoringUpdateAcceptor;
import org.eclipse.xtext.ui.refactoring.impl.DefaultReferenceUpdater;
import org.eclipse.xtext.util.ITextRegion;
import org.yakindu.sct.model.sgraph.SpecificationElement;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * Introduced to apply rename refactorings, triggered from an Xtext language, to SCT specifications.
 * In difference to {@link DefaultReferenceUpdater} this implementation does not check if this is a XtextResource. The
 * references processed during execution have to be instantiated by Xtext before.
 */
@SuppressWarnings("restriction")
public class SCTXtextSpecificationReferenceUpdater extends DefaultReferenceUpdater {

    private Multimap<URI, SCTSpecificationChange> changesPerResource;

    @Inject
    Injector injector;

    @Override
    protected void createReferenceUpdates(final ElementRenameArguments elementRenameArguments,
            final Multimap<URI, IReferenceDescription> resource2references, final ResourceSet resourceSet,
            final IRefactoringUpdateAcceptor updateAcceptor, final IProgressMonitor monitor) {

        final SubMonitor progress =
                SubMonitor.convert(monitor, "Creating SCT specification updates", resource2references.keySet().size());

        resetChangesPerResource();

        collectChangesPerResource(elementRenameArguments, resource2references, resourceSet, updateAcceptor, progress);
        acceptChangesPerResource(resourceSet, updateAcceptor);
    }

    private void acceptChangesPerResource(final ResourceSet resourceSet,
            final IRefactoringUpdateAcceptor updateAcceptor) {
        for (final URI changedResource : changesPerResource.keySet()) {

            final CompositeChange compositeChange =
                    createResourceChange(resourceSet, changedResource, changesPerResource.get(changedResource));
            updateAcceptor.accept(changedResource, compositeChange);
        }
    }

    private void collectChangesPerResource(final ElementRenameArguments elementRenameArguments,
            final Multimap<URI, IReferenceDescription> resource2references, final ResourceSet resourceSet,
            final IRefactoringUpdateAcceptor updateAcceptor, final SubMonitor progress) {

        for (final URI referringResourceURI : resource2references.keySet()) {
            if (progress.isCanceled()) {
                return;
            }
            for (final IReferenceDescription referenceDescription : resource2references.get(referringResourceURI)) {
                createReferenceUpdate(referenceDescription, referringResourceURI, elementRenameArguments, resourceSet,
                        updateAcceptor);
            }

            progress.worked(1);
        }
    }

    protected CompositeChange createResourceChange(final ResourceSet resourceSet, final URI changedResource,
            Collection<SCTSpecificationChange> collection) {

        String changeName = String.format("%s - %s", changedResource.lastSegment(),
                changedResource.toPlatformString(true).replace("/" + changedResource.lastSegment(), ""));
        final CompositeChange resourceChange = new ResourceSavingChange(changeName, changedResource, resourceSet);

        // sorts by offsets descending to ensure multiple changes can be applied to the same specification feature
        collection.stream().sorted(new SCTSpecificationChange.DescendingOffsetComparator())
                .forEach(new Consumer<SCTSpecificationChange>() {
                    @Override
                    public void accept(SCTSpecificationChange change) {
                        resourceChange.add(change);
                    }
                });

        return resourceChange;
    }

    @Override
    protected void createTextChange(final ITextRegion referenceTextRegion, final String newReferenceText,
            final EObject referringElement, final EObject newTargetElement, final EReference reference,
            final URI referringResourceURI, final IRefactoringUpdateAcceptor updateAcceptor) {
        final SpecificationElement specificationElement =
                EcoreUtil2.getContainerOfType(referringElement, SpecificationElement.class);
        if (newReferenceText != null) {
            SCTSpecificationChange specificationChange =
                    new SCTSpecificationChange(referenceTextRegion, specificationElement, newReferenceText);
            injector.injectMembers(specificationChange);
            changesPerResource.put(referringResourceURI, specificationChange);
        }

    }

    /**
     * Resets the changes per resource. the data structure is used
     */
    protected void resetChangesPerResource() {
        changesPerResource = ArrayListMultimap.create();
    }

}
