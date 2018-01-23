package org.yakindu.sct.generator.pax.features;
/**
 * Copyright (c) 2011, 2015 Committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Andreas Mülder    - Initial contribution and API
 *  Markus Mühlbrandt - Added support for 'IdentifierSettings' feature
 *  Alexander Nyßen   - Added support for 'Tracing' feature; general refactorings
 */


import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.yakindu.sct.generator.core.library.AbstractDefaultFeatureValueProvider;
import org.yakindu.sct.model.sgen.FeatureParameterValue;
import org.yakindu.sct.model.sgen.FeatureType;
import org.yakindu.sct.model.sgen.FeatureTypeLibrary;

/**
 * Provides default values and support for validating parameter values of C code
 * generator generator model.
 * 
 * @author Andreas Mülder
 * @author Markus Mühlbrandt
 * @author Alexander Nyßen
 */
public class PaxDefaultFeatureValueProvider extends AbstractDefaultFeatureValueProvider {

	@Override
	public IStatus validateParameterValue(FeatureParameterValue value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isProviderFor(FeatureTypeLibrary library) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void setDefaultValue(FeatureType featureType, FeatureParameterValue parameterValue,
			EObject contextElement) {
		// TODO Auto-generated method stub
		
	}


}
