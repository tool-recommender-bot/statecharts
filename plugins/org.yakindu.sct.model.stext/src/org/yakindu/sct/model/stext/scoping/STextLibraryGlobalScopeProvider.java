package org.yakindu.sct.model.stext.scoping;

import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.yakindu.base.expressions.scoping.AbstractLibraryGlobalScopeProvider;

import com.google.common.collect.Sets;
import com.google.inject.Singleton;

/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
@Singleton
public class STextLibraryGlobalScopeProvider extends AbstractLibraryGlobalScopeProvider {

	public static final URI STEXT_LIB = URI
			.createURI("platform:/plugin/org.yakindu.sct.model.stext.lib/lib/STextLib.xmi");

	public static final URI MSP430_LIB = URI
			.createURI("platform:/plugin/org.yakindu.sct.model.stext.lib/lib/MSP430.xmi");

	public static final URI STM32F_LIB = URI
			.createURI("platform:/plugin/org.yakindu.sct.model.stext.lib/lib/STM32F.xmi");

	@Override
	public Set<URI> getLibraries(Resource context) {
		return Sets.newHashSet(STEXT_LIB, MSP430_LIB, STM32F_LIB);
	}

}
