/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 *   All rights reserved. This program and the accompanying materials
 *   are made available under the terms of the Eclipse Public License v1.0
 *   which accompanies this distribution, and is available at
 *   http://www.eclipse.org/legal/epl-v10.html
 *   Contributors:
 *   	Markus Muehlbrandt - Initial contribution and API
 */
package org.yakindu.sct.generator.pax;

import com.google.inject.Inject;
import org.eclipse.xtext.xbase.lib.Extension;
import org.yakindu.sct.generator.core.library.ICoreLibraryConstants;
import org.yakindu.sct.generator.pax.PaxNaming;
import org.yakindu.sct.model.sgen.FeatureConfiguration;
import org.yakindu.sct.model.sgen.FeatureParameterValue;
import org.yakindu.sct.model.sgen.GeneratorEntry;

@SuppressWarnings("all")
public class GenmodelEntries {
  @Inject
  @Extension
  private PaxNaming _paxNaming;
  
  private FeatureConfiguration getLicenseFeature(final GeneratorEntry it) {
    return it.getFeatureConfiguration(ICoreLibraryConstants.LICENSE_HEADER);
  }
  
  private FeatureConfiguration getOutletFeatures(final GeneratorEntry it) {
    return it.getFeatureConfiguration(ICoreLibraryConstants.OUTLET_FEATURE);
  }
  
  private FeatureParameterValue getOutletFeatureTargetProject(final GeneratorEntry it) {
    return this.getOutletFeatures(it).getParameterValue(ICoreLibraryConstants.OUTLET_FEATURE_TARGET_PROJECT);
  }
}
