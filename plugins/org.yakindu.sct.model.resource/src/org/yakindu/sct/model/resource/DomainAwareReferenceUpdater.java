package org.yakindu.sct.model.resource;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.ui.refactoring.ElementRenameArguments;
import org.eclipse.xtext.ui.refactoring.IRefactoringUpdateAcceptor;
import org.eclipse.xtext.ui.refactoring.IReferenceUpdater;
import org.yakindu.sct.domain.extension.DomainRegistry;
import org.yakindu.sct.domain.extension.IDomain;
import org.yakindu.sct.model.sgraph.util.EmbeddedContextUtil;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;

@SuppressWarnings("restriction")
public class DomainAwareReferenceUpdater implements IReferenceUpdater {

    @Inject
    EmbeddedContextUtil contextUtil;

    @Override
    public void createReferenceUpdates(final ElementRenameArguments elementRenameArguments,
            final Iterable<IReferenceDescription> referenceDescriptions,
            final IRefactoringUpdateAcceptor updateAcceptor, final IProgressMonitor monitor) {

        final Multimap<String, IReferenceDescription> refDescriptionsPerDomain = ArrayListMultimap.create();

        for (final IReferenceDescription refDesc : referenceDescriptions) {
            final String determineDomainID =
                    DomainRegistry.determineDomainID(refDesc.getSourceEObjectUri().trimFragment());

            refDescriptionsPerDomain.put(determineDomainID, refDesc);
        }

        for (final String domainID : refDescriptionsPerDomain.keySet()) {
            final IDomain domain = DomainRegistry.getDomain(domainID);

            final IReferenceUpdater instance =
                    domain.getInjector(IDomain.FEATURE_RESOURCE).getInstance(IReferenceUpdater.class);

            instance.createReferenceUpdates(elementRenameArguments, refDescriptionsPerDomain.get(domainID),
                    updateAcceptor, monitor);
        }
    }

}
