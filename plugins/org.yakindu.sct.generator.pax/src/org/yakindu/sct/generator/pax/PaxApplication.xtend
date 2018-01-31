package org.yakindu.sct.generator.pax

import com.google.inject.Inject
import java.util.List
import org.yakindu.sct.model.sexec.Check
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sexec.TimeEvent
import org.yakindu.sct.model.sexec.naming.INamingService
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.sgraph.Scope
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.VariableDefinition

class PaxApplication implements IContentTemplate {

	@Inject extension PaxNaming;
	@Inject extension INamingService
	@Inject extension PaxFlowCode
	@Inject extension PaxNavigation


	override content(ExecutionFlow it, GeneratorEntry entry, IGenArtifactConfigurations locations) {
		'''
		«statesEnum»
		
		«declareVariables»
		
		«globalVariables»
		
		«functionImplementations»
		
		«clearInEventsFunction»
		
		«clearOutEventsFunction»
		
		«initAndEnterFunctino»
		
		«runCycleFunction»
		
		«periodicRunCylceTrigger»
		
		
		«««			«Events»	}
		'''
	}
	
	def clearInEventsFunction(ExecutionFlow it){'''
		«functionPrefix» clearInEvents()
		{
			«FOR scope : it.scopes»
				«FOR event : scope.incomingEvents»
				«event.access» = false;
				«ENDFOR»
			«ENDFOR»
			«IF hasLocalScope»
				«FOR event : internalScope.events»
				«event.access» = false;
				«ENDFOR»
			«ENDIF»
		}
	'''
	}
	
	def clearOutEventsFunction(ExecutionFlow it){
		
	}

	def declareVariables(ExecutionFlow it) {
		'''
			«FOR s : scopes»
				«s.scopeVarDecl»
			«ENDFOR»		
		'''
	}

	def variableStruct(ExecutionFlow it) {
		'''
			struct «statechartVariablesName» {
				«FOR s : scopes»
					«s.scopeVarDecl»
			«««					«s.scopeConstDecl» TODO consts
				«ENDFOR»
			}
			
			«variablePrefix» «statechartVariables» : «statechartVariablesName»;
		'''
	}

	def globalVariables(ExecutionFlow it) {
		'''
			«variablePrefix» «initializedVariable» : uint32_t = 0;
			«variablePrefix» «activeState» : «enumName»;
		'''
	}

	def functionImplementations(ExecutionFlow it) '''
		«checkFunctions.toImplementation»
		
		«effectFunctions.toImplementation»
		
		«entryActionFunctions.toImplementation»
		
		«exitActionFunctions.toImplementation»
		
		«enterSequenceFunctions.toImplementation»
		
		«exitSequenceFunctions.toImplementation»
		
		«reactFunctions.toImplementation»
	'''

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
		function «shortName»() : bool
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
			«variablePrefix» activeState : «enumName»;
		'''
	}

	def initAndEnterFunctino(ExecutionFlow flow) {
		val defaultTimeTrigger = "100 " + PaxTypes.MS.unit;
//		TODO handle trigger time for Statemachine correctly
		'''
			«functionPrefix» «initAndEnterFunctionName»() {
				
				«timeTrigger = defaultTimeTrigger»
				«activeState» = ; //tbd
				clearInEvents();
				initialized = 1;
			}
		'''
	}

	def runCycleFunction(ExecutionFlow flow) {
		'''
			«functionPrefix» «runCycleFunctionName»() {
				if(initialized == 0) {
					«initAndEnterFunctionName»();
				}
				«runCycleIfElse(flow)»
				
				clearInEvents();
			}
		'''
	}

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
				«variablePrefix» «variable.name» : «variable.scopeTypeDeclMember»;
			«ENDFOR»
		'''
	}

	def dispatch scopeTypeDeclMember(EventDefinition it) {
		'''bool '''
	}

	def dispatch scopeTypeDeclMember(VariableDefinition it) {
		'''uint32_t'''
	// müsste eigentlich übers c type system gehen
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

	def statesEnum(ExecutionFlow it) {
		'''
			enum «enumName» {
				«FOR state : states SEPARATOR ","»
					«state.shortName»
				«ENDFOR»
			}
		'''
	}

}
