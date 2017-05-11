package org.yakindu.sct.model.sgraph.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.yakindu.sct.domain.extension.DomainRegistry;
import org.yakindu.sct.domain.extension.IDomain;
import org.yakindu.sct.model.sgraph.SpecificationElement;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Transition;

import com.google.inject.Injector;

public class EmbeddedContextUtil {
    public Injector getDomainInjectorForEmbeddedElement(final EObject embeddedElement) {
        EObject specificationElement = getContextElement(embeddedElement);
        return getDomainInjectorForElement(specificationElement);
    }

    public Injector getDomainInjectorForElement(EObject sgraphElement) {
        if (EcoreUtil2.getContainerOfType(sgraphElement, Statechart.class) == null)
            throw new IllegalArgumentException("Given element is not contained in an SGraph model");

        String domainID = DomainRegistry.determineDomainID(sgraphElement.eResource().getURI());

        return DomainRegistry.getDomain(domainID).getInjector(IDomain.FEATURE_EDITOR,
                getLanguageFeature(sgraphElement));
    }

    public EObject getContextElement(final EObject embeddedElement) {
        ContextElementAdapter existingAdapter = (ContextElementAdapter) EcoreUtil
                .getExistingAdapter(embeddedElement.eResource(), ContextElementAdapter.class);

        if (existingAdapter == null)
            throw new IllegalArgumentException("Given element does not have a " + ContextElementAdapter.class);

        return existingAdapter.getElement();
    }

    public String getLanguageFeature(final EObject selectedElement) {

        if (!(selectedElement instanceof SpecificationElement)) {
            throw new IllegalArgumentException("Given element is not a " + SpecificationElement.class.getSimpleName());
        }

        if (selectedElement instanceof State) {
            return State.class.getName();
        }
        if (selectedElement instanceof Transition) {
            return Transition.class.getName();
        }
        if (selectedElement instanceof Statechart) {
            return Statechart.class.getName();
        }
        throw new IllegalArgumentException("unexpected case, implement me");
    }
}
