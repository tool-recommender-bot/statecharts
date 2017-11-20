package org.yakindu.sct.model.stext.ui;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.DocumentChange;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.text.edits.ReplaceEdit;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.text.edits.UndoEdit;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.TextRegion;
import org.yakindu.sct.model.sgraph.SpecificationElement;

import com.google.inject.Inject;

/**
 * Updates a specification as a result of an external refactoring of an element used within a specification.
 */
public class SCTSpecificationChange extends DocumentChange {

    private final ITextRegion referenceTextRegion;
    private final SpecificationElement specificationElement;

    @Inject
    IQualifiedNameProvider nameProvider;

    /**
     * @param referenceTextRegion
     *            the text region describing the relative location of a reference within a specification value.
     * @param specificationElement
     *            the Sgraph specification element
     * @param newReferenceText
     *            the text which will be replaced
     */
    public SCTSpecificationChange(final ITextRegion referenceTextRegion,
            final SpecificationElement specificationElement, final String newReferenceText) {
        super(SCTSpecificationChange.class.getSimpleName(), new Document(specificationElement.getSpecification()));
        this.referenceTextRegion = referenceTextRegion;
        this.specificationElement = specificationElement;
        super.setEdit(
                new ReplaceEdit(referenceTextRegion.getOffset(), referenceTextRegion.getLength(), newReferenceText));
    }

    @Override
    public RefactoringStatus isValid(final IProgressMonitor pm) throws CoreException, OperationCanceledException {
        return new RefactoringStatus();
    }

    @Override
    protected IDocument acquireDocument(IProgressMonitor pm) throws CoreException {
        IDocument acquireDocument = super.acquireDocument(pm);
        acquireDocument.set(specificationElement.getSpecification());
        return acquireDocument;
    }

    @Override
    protected void commit(IDocument document, IProgressMonitor pm) throws CoreException {
        super.commit(document, pm);
        
        specificationElement.setSpecification(document.get());
    }

    @Override
    protected Change createUndoChange(UndoEdit edit) {
        String oldName = null;

        TextEdit[] children = edit.getChildren();
        if (children.length > 1) {
            throw new IllegalStateException(
                    "A sct specification change instance should just include a single text modification");
        }
        for (TextEdit textEdit : children) {
            if (textEdit instanceof ReplaceEdit) {
                ReplaceEdit replaceEdit = (ReplaceEdit) textEdit;
                oldName = replaceEdit.getText();
                break;
            }
        }
        if (oldName == null) {
            throw new IllegalStateException("Can not determine old value for undo calculation");
        }

        return new SCTSpecificationChange(new TextRegion(edit.getOffset(), edit.getLength()), specificationElement,
                oldName);
    }

    @Override
    public void initializeValidationData(final IProgressMonitor pm) {
        // nothing to do...
    }

    @Override
    public String getName() {
        return nameProvider.getFullyQualifiedName(specificationElement) + ".specification";
    }

    @Override
    public SpecificationElement getModifiedElement() {
        return specificationElement;
    }

    public ITextRegion getReferenceTextRegion() {
        return referenceTextRegion;
    }

    /**
     * Compares SCT Specifications by their offset offset.Max -> offset.Min.
     */
    public static final class DescendingOffsetComparator implements java.util.Comparator<SCTSpecificationChange> {
        /**
         * used to ensure offset.MAX will be executed first, so last change (first occurrence in
         * expression/specification/text-sequence)
         * will still have a valid offset when previous changes are already applied.
         */
        @Override
        public int compare(final SCTSpecificationChange o1, final SCTSpecificationChange o2) {
            return Integer.compare(o2.getReferenceTextRegion().getOffset(), o1.getReferenceTextRegion().getOffset());
        }
    }

}