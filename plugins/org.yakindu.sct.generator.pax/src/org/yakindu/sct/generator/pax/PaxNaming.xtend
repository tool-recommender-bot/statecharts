package org.yakindu.sct.generator.pax

import com.google.inject.Inject
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.eclipse.xtend.lib.annotations.Accessors

class PaxNaming {
	@Accessors String timeTrigger;

//	@Inject extension PaxNavigation
//	@Inject extension GenmodelEntries

	def enumName(ExecutionFlow it) {
		'States'
	}

	def application(ExecutionFlow it) {
		'application'
	}

	def x(String it) { it + ".x" }

	def functionPrefix() {"function"}

	
	def variablePrefix() { "var"}
	
	def initAndEnterFunctionName() {"initAndEnterFunction"}
	
	def runCycleFunctionName() {"runCycle"}
	
	def every(){"every"}
}
