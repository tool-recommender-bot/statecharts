/**
 *   Copyright (c) 2012 committers of YAKINDU and others.
 *   All rights reserved. This program and the accompanying materials
 *   are made available under the terms of the Eclipse Public License v1.0
 *   which accompanies this distribution, and is available at
 *   http://www.eclipse.org/legal/epl-v10.html
 *   Contributors:
 *   	Markus Muehlbrandt - Initial contribution and API
 */
package org.yakindu.sct.generator.pax

import com.google.inject.Inject
import org.yakindu.sct.model.sgen.FeatureParameterValue
import org.yakindu.sct.model.sgen.GeneratorEntry

import static org.yakindu.sct.generator.core.library.ICoreLibraryConstants.*

class GenmodelEntries {

	@Inject extension PaxNaming 

	def private getLicenseFeature(GeneratorEntry it) {
		getFeatureConfiguration(LICENSE_HEADER)
	}

	def private getOutletFeatures(GeneratorEntry it) {
		getFeatureConfiguration(OUTLET_FEATURE)
	}

	def private FeatureParameterValue getOutletFeatureTargetProject(GeneratorEntry it) {
		outletFeatures.getParameterValue(OUTLET_FEATURE_TARGET_PROJECT)
	}

}
