package org.yakindu.sct.generator.pax

import com.google.inject.Inject
import org.yakindu.sct.model.sexec.StateSwitch
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sgraph.State
import org.eclipse.emf.ecore.EObject
import org.yakindu.sct.model.sexec.Execution
import org.yakindu.sct.model.sexec.Check
import org.yakindu.sct.model.sexec.CheckRef
import org.yakindu.sct.model.sexec.Call
import org.yakindu.sct.model.sexec.Sequence
import org.yakindu.sct.model.sexec.If
import org.yakindu.sct.model.sexec.EnterState
import org.yakindu.sct.model.sexec.ExitState
import org.yakindu.sct.model.sexec.Trace
import org.yakindu.sct.model.sexec.TraceStateEntered
import org.yakindu.sct.model.sexec.TraceStateExited
import org.yakindu.sct.model.sexec.SaveHistory
import org.yakindu.sct.model.sexec.HistoryEntry
import org.yakindu.sct.model.sexec.ScheduleTimeEvent
import org.yakindu.sct.model.sexec.UnscheduleTimeEvent

class PaxFlowCode {
	@Inject extension PaxNaming
	@Inject extension PaxNavigation
	@Inject extension PaxExpressionsGenerator
	@Inject extension PaxNamingService

	def dispatch CharSequence code(Step it) '''
		//ActionCode for Step '«getClass().name»' not defined
	'''

	def dispatch CharSequence code(Trace it) '''
		//ActionCode for Trace '«getClass().name»' not defined
	'''

	def dispatch CharSequence code(TraceStateEntered it) '''
		//ActionCode for TraceStateEntered '«getClass().name»' not defined
	'''

	def dispatch CharSequence code(TraceStateExited it) '''
		//ActionCode for TraceStateExited '«getClass().name»' not defined
	'''

	def dispatch CharSequence code(SaveHistory it) '''
		//ActionCode for SaveHistory '«getClass().name»' not defined
	'''

	def dispatch CharSequence code(HistoryEntry it) '''
		//ActionCode for HistoryEntry '«getClass().name»' not defined
	'''

	def dispatch CharSequence code(StateSwitch it) '''
		«FOR caseid : cases»
			«IF caseid.isEnterSequence(it) == true»
				if	(«caseid.step.shortName») {
					// code
				}«»
			«ELSE»
				else if («caseid.step.shortName») {
					
				}
			«ENDIF»
		«ENDFOR»
	'''

	def dispatch CharSequence code(ScheduleTimeEvent it) '''
		//ActionCode for ScheduleTimeEvent '«getClass().name»' not defined
	'''

	def dispatch CharSequence code(UnscheduleTimeEvent it) '''
		//ActionCode for UnscheduleTimeEvent '«getClass().name»' not defined
	'''

	def dispatch CharSequence code(Execution it) 
		'''«statement.code»;'''

	def dispatch CharSequence code(Call it) '''
		«step.shortName»();
	'''

	def dispatch CharSequence code(Sequence it) '''
		«FOR s : steps»
			«s.code»
		«ENDFOR»
	'''

	def dispatch CharSequence code(Check it) 
	''''«IF condition != null»false«ELSE»true«ENDIF»'''

	def dispatch CharSequence code(CheckRef it) 
	'''«IF check !== null»«check.shortName»()«ELSE»true«ENDIF»'''

	def dispatch CharSequence code(If it) '''
		if («check.code» == true)
		{ 
			«thenStep.code»
		}«IF (elseStep !== null)» else
		{
			«elseStep.code»
		}
		«ENDIF»
	'''

	def dispatch CharSequence code(EnterState it) '''
		//ActionCode for EnterState '«getClass().name»' not defined
	'''

	def dispatch CharSequence code(ExitState it) '''
		//ActionCode for ExitState '«getClass().name»' not defined
	'''

}
