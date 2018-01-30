package org.yakindu.sct.generator.pax

import com.google.inject.Inject
import java.util.List
import org.yakindu.sct.model.sexec.Check
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sexec.TimeEvent
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.naming.INamingService
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.sgraph.Scope
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.VariableDefinition

class PaxApplication implements IContentTemplate {

	@Inject extension PaxNaming;
	@Inject extension INamingService
	@Inject extension SExecExtensions
	@Inject extension PaxFlowCode

	override content(ExecutionFlow it, GeneratorEntry entry, IGenArtifactConfigurations locations) {
		'''
		«StatesEnum»
		
		«StatemachineVariables»
		 
		«FOR s : scopes»
			«s.scopeVarDecl»
			«s.scopeConstDecl»
		«ENDFOR»
		
		«initAndEnterFunctino»
		
		«runCycleFunction»
		
		«periodicRunCylceTrigger»
		
		«functionImplementations»
		
		«««			«Events»
		'''
	}

	def functionImplementations(ExecutionFlow it) {
		checkFunctions.toImplementation
		effectFunctions.toImplementation
		entryActionFunctions.toImplementation
		exitActionFunctions.toImplementation
		enterSequenceFunctions.toImplementation
		exitSequenceFunctions.toImplementation
		reactFunctions.toImplementation
		
		exitSequenceFunctions
	}

	def toImplementation(List<Step> steps) '''
		«FOR s : steps»
			«s.functionImplementation»
		«ENDFOR»
	'''

	def dispatch functionImplementation(Step it) '''
		function «shortName»()
		{
			«code»
		}
	'''

	def dispatch functionImplementation(Check it) '''
		bool function «shortName»()
		{
			return «code»
		}
	'''

	def periodicRunCylceTrigger(ExecutionFlow flow) {
		'''
			«every» «timeTrigger» {
				«runCycleFunctionName»();
			}
		'''
	}

	def StatemachineVariables(ExecutionFlow flow) {
		'''
			«variablePrefix» initialized = 0;
			«variablePrefix» activeState : «enumName(flow)»;
		'''
	}

	def initAndEnterFunctino(ExecutionFlow flow) {
		val defaultTimeTrigger = "100 " + PaxTypes.MS.unit;
//		TODO handle trigger time for Statemachine correctly
		'''
			«functionPrefix» «initAndEnterFunctionName»() {
				
				«timeTrigger = defaultTimeTrigger»
				initialized = 1;
			}
		'''
	}

	def runCycleFunction(ExecutionFlow flow) {
		'''
			«functionPrefix» «runCycleFunctionName»() {
				if(initialized == 0) {
					«initAndEnterFunctionName»()
				}
				«runCycleIfElse(flow)»
			}
		'''
	}
	
//	def isStateActiveFunction(ExecutionFlow it) '''
//		sc_boolean «stateActiveFctID»()
//		{
//			sc_boolean result = bool_false;
//			switch (state)
//			{
//				«FOR s : states»
//				case «s.shortName» :
//					result = (sc_boolean) («IF s.leaf» == «s.shortName»
//					«ELSE»«s.shortName»
//						«s.subStates.last.shortName»«ENDIF»);
//					break;
//				«ENDFOR»
//				default:
//					result = bool_false;
//					break;
//			}
//			return result;
//		}
//	'''

	def runCycleIfElse(ExecutionFlow it) {
		'''
			«FOR state : states»
				else if («enumName».«state.shortName» == activeState){
					«state.reactSequence.shortName»();
				}
			«ENDFOR»
		'''
	}

	def scopeVarDecl(Scope s) {
		'''
			// Declare used variables
			«val vars = s.typeRelevantDeclarations»
			«FOR variable : vars»
				«variablePrefix» «variable.name»
			«««					TODO add initial values
		«ENDFOR»
		'''
	}

	def scopeConstDecl(Scope s) {
		'''
			«val consts = s.constDeclarations»
			«FOR constant : consts»
				«variablePrefix» «constant.name» = «constant»
			«««				TODO add initial values
		«ENDFOR»
		'''
	}

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

	private def constDeclarations(Scope scope) {
		return scope.declarations.filter(typeof(VariableDefinition)).filter[const]
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
