/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	rbeckmann - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.cpp.submodules

import com.google.inject.Inject
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.c.IHeaderContentFragment
import org.yakindu.sct.generator.c.IncludeProvider
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.generator.cpp.CppNaming
import org.yakindu.sct.generator.cpp.features.GenmodelEntriesExtension
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.naming.INamingService
import org.yakindu.sct.model.sgen.GeneratorEntry

/**
 * @author rbeckmann
 *
 */
class StatemachineHeaderContentFragment implements IHeaderContentFragment {
	@Inject protected extension CppNaming
	@Inject protected extension SExecExtensions
	@Inject protected extension ICodegenTypeSystemAccess
	@Inject protected extension GenmodelEntriesExtension
	@Inject protected extension INamingService
	@Inject protected extension IncludeProvider
	
	override defines(ExecutionFlow it, GeneratorEntry entry, IGenArtifactConfigurations artifactConfigs) {
		'''
		/*! Define indices of states in the StateConfVector */
		«FOR state : states»
			#define «state.stateVectorDefine» «state.stateVector.offset»
		«ENDFOR»
		'''
	}
	
	override fileComment(ExecutionFlow it, GeneratorEntry entry, IGenArtifactConfigurations artifactConfigs) {
		''''''
	}
	
	override functions(ExecutionFlow it, GeneratorEntry entry, IGenArtifactConfigurations artifactConfigs) {
		''''''
	}
	
	override includes(ExecutionFlow it, GeneratorEntry entry, IGenArtifactConfigurations artifactConfigs) {
		'''
		«FOR i : getIncludes(newArrayList, artifactConfigs)»
		  «i»
		«ENDFOR»
		'''
	}
	
	override types(ExecutionFlow it, GeneratorEntry entry, IGenArtifactConfigurations artifactConfigs) {
		''''''
	}
	
}