package org.yakindu.sct.generator.pax

import com.google.inject.Inject
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sexec.StateSwitch

class PaxFlowCode {
	@Inject extension PaxNaming
	@Inject extension PaxNavigation
	@Inject extension PaxExpressionsGenerator
	@Inject extension PaxNamingService

	def dispatch CharSequence code(Step it) '''
		//ActionCode for Step '«getClass().name»' not defined
	'''

	def dispatch CharSequence code(StateSwitch it) {
		'''
			«FOR caseid : cases»
			«IF caseid.isEnterSequence(it) == true»
			if	(«caseid.step.shortName») {
				// code
			}
			«ELSE»
			else if («caseid.step.shortName») {
				
			}
			«ENDIF»
			«ENDFOR»
		'''
	}
}
