package org.yakindu.sct.refactoring.refactor.xtext;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.parsetree.reconstr.impl.DefaultTransientValueService;

public class SCTTransientValueService extends DefaultTransientValueService {

	
	@Override
	public boolean isTransient(EObject owner, EStructuralFeature feature, int index) {
		//TODO rename references of variable definitions fail
		if(feature.isTransient())
			System.out.println(owner.getClass().getSimpleName() +"."+feature.getName()+".isTransient = "+feature.isTransient());
		return feature.isTransient() || !owner.eIsSet(feature) || isContainerReferenceInSameResource(owner, feature);
	}
}
