package org.yakindu.sct.generator.pax

import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry

class PaxApplication implements IContentTemplate{

//	@Inject extension PaxNaming;
//	@Inject extension INamingService

	override content(ExecutionFlow flow, GeneratorEntry entry, IGenArtifactConfigurations locations) {
		'''
«««			«StatesEnum(flow)»
		'''
	}

	def StatesEnum(ExecutionFlow it) {
		'''
«««			enum «enumName» {
«««				«FOR state : states SEPARATOR ","»
«««					«state.shortName»
«««				«ENDFOR»
«««			}
		'''
	}
}
