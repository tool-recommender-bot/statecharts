package org.yakindu.sct.generator.pax

import com.google.inject.Inject
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.TimeEvent
import org.yakindu.sct.model.sexec.naming.INamingService
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.sgraph.Scope
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.InternalScope
import org.yakindu.sct.model.stext.stext.VariableDefinition

class PaxApplication implements IContentTemplate {

	@Inject extension PaxNaming;
	@Inject extension INamingService	

	override content(ExecutionFlow flow, GeneratorEntry entry, IGenArtifactConfigurations locations) {
		'''
			«StatesEnum(flow)»
			
			«FOR s : flow.scopes»
				«s.scopeVarDecl»
			«ENDFOR»
			
			«Events»
		'''
	}

	def scopeVarDecl(Scope s) {
		'''
		«val vars = s.typeRelevantDeclarations»
		«FOR variable : vars»
		var «variable.name»
		«ENDFOR»
		'''
	}
	
		def scopeTypeDeclMember(TimeEvent it) '''
		sc_boolean «shortName»;
	'''

	private def typeRelevantDeclarations(Scope scope) {
		return scope.declarations.filter [
			switch it {
				EventDefinition: true
				TimeEvent: true
				VariableDefinition: !it.const
				default: false
			}
		]
	}
	
	private def constDeclarations(Scope scope){
		return scope.declarations.filter(typeof(VariableDefinition)).filter[const]
	}

	def Events() {
		'''
			
		'''
	}

	def StatesEnum(ExecutionFlow it) {
		'''
			enum «enumName» {
				«FOR state : states SEPARATOR ","»
					«state.shortName»
				«ENDFOR»
			}
		'''
	}
}
