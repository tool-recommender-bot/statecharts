package org.yakindu.sct.generator.pax

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.lib.Property
import org.eclipse.xtend.lib.annotations.Accessors
import org.yakindu.base.types.Enumerator
import org.yakindu.base.types.Event
import org.yakindu.base.types.Operation
import org.yakindu.sct.generator.c.features.ICFeatureConstants
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.TimeEvent
import org.yakindu.sct.model.sexec.naming.INamingService
import org.yakindu.sct.model.sgen.FeatureParameterValue
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.stext.naming.StextNameProvider
import org.yakindu.sct.model.stext.stext.OperationDefinition
import org.yakindu.sct.model.stext.stext.VariableDefinition
import org.yakindu.sct.model.stext.stext.EventDefinition

class PaxNaming {
	@Accessors String timeTrigger;

	@Inject extension PaxNavigation

	@Inject extension ICodegenTypeSystemAccess

	@Inject private StextNameProvider provider

	@Inject extension INamingService

	@Inject GeneratorEntry entry

	def enumName() { "States" }

	def application(ExecutionFlow it) {
		'application'
	}

	def x(String it) { it + ".x" }

	def functionPrefix() { "function" }

	def variablePrefix() { "var" }

	def initAndEnterFunctionName() { "initAndEnterFunction" }

	def runCycleFunctionName() { "runCycle" }

	def every() { "every" }

	def isStateActiveFctID(ExecutionFlow it) {
		functionPrefix + "isStateActive"
	}
	
	def statechartVariablesName(){ "variables" }
	
	def statechartVariables() {"statechart" + statechartVariablesName.toFirstUpper}

	def initializedVariable() { "initialized" }
	
	def activeState() {"activeState"}

	def separator() {
		return "_"
	}

	def value(CharSequence it) { it + separator + 'value' }

	def dispatch access(VariableDefinition it) {
		'''«name.asEscapedIdentifier»'''
	}

//	def dispatch access(Property it) {
//		'''«name.asEscapedIdentifier»'''
//	}
	def dispatch access(Operation it) {
		'''«name.asEscapedIdentifier»'''
	}

	def dispatch access(Enumerator it) {
		'''«name.asEscapedIdentifier»'''
	}

//	def dispatch access(OperationDefinition it) '''«asFunction»'''

	def dispatch access(Event it) '''«name.asIdentifier»'''

//	def dispatch access(TimeEvent it) '''«shortName.raised»'''



	def dispatch access(EObject it) '''#error cannot access elements of type «getClass().name»'''

	def valueAccess(Event it) '''«name.asIdentifier.value»'''

//	def maxOrthogonalStates(ExecutionFlow it) '''«type.toUpperCase»_MAX_ORTHOGONAL_STATES'''

//	def maxHistoryStates(ExecutionFlow it) '''«type.toUpperCase»_MAX_HISTORY_STATES'''

//	def maxParallelTimeEvents(ExecutionFlow it) '''«type.toUpperCase»_MAX_PARALLEL_TIME_EVENTS'''
}
