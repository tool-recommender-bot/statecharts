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
import org.yakindu.sct.generator.cpp.CppNaming
import org.yakindu.sct.generator.cpp.ErrorCode
import org.yakindu.sct.generator.cpp.FlowCode
import org.yakindu.sct.generator.cpp.features.GenmodelEntriesExtension
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.naming.INamingService
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.sct.model.stext.stext.InternalScope
import org.yakindu.sct.model.stext.stext.StatechartScope
import org.yakindu.sct.model.sexec.extensions.StateVectorExtensions

/**
 * @author rbeckmann
 *
 */
class APIGenerator {
	@Inject protected extension SExecExtensions
	@Inject protected extension GenmodelEntriesExtension
	@Inject protected extension StateVectorExtensions
	@Inject protected extension CppNaming
	@Inject protected extension FlowCode
	@Inject protected extension INamingService
	
	def runCycle(ExecutionFlow it) {
		'''
		«runCycleSignature»
		{
			
			clearOutEvents();
			«runCycleFunctionForLoop»
			clearInEvents();
		}
		'''
	}
	def runCycleSignature(ExecutionFlow it) '''void «module»::«runCycleFctID»()'''
	def declareRunCycle(ExecutionFlow it) {'''void «runCycleFctID»();'''}
	
	def runCycleFunctionForLoop(ExecutionFlow it) {
		'''
		for (stateConfVectorPosition = 0;
			stateConfVectorPosition < «orthogonalStatesConst»;
			stateConfVectorPosition++)
			{
				
			switch (stateConfVector[stateConfVectorPosition])
			{
			«FOR state : states»
				«IF state.reactSequence !== null»
				case «state.shortName.asEscapedIdentifier» :
				{
					«state.reactSequence.shortName»();
					break;
				}
				«ENDIF»
			«ENDFOR»
			default:
				break;
			}
		}
		'''
	}
	
	def init(ExecutionFlow it, GeneratorEntry entry) {
		'''
		«initSignature(it, entry)»
		{
			«IF entry.checkUnimplementedOCBs»
			sc_errorCode errorCode = 0;
			
			«unimplementedOCBErrors(entry)»«ENDIF»
			for (sc_ushort i = 0; i < «orthogonalStatesConst»; ++i)
				stateConfVector[i] = «null_state»;
			
			«IF hasHistory»
			for (sc_ushort i = 0; i < «historyStatesConst»; ++i)
				historyVector[i] = «null_state»;
			
			«ENDIF»
			stateConfVectorPosition = 0;
		
			clearInEvents();
			clearOutEvents();
			
			«initSequence.code»
			«IF entry.checkUnimplementedOCBs»
			return errorCode;
			«ENDIF»
		}
		'''
	}
	def initSignature(ExecutionFlow it, GeneratorEntry entry) '''«IF entry.checkUnimplementedOCBs»sc_errorCode«ELSE»void«ENDIF» «module»::«initFctID»()'''
	def declareInit(ExecutionFlow it, GeneratorEntry entry) '''«IF entry.checkUnimplementedOCBs»sc_errorCode«ELSE»void«ENDIF» «initFctID»();'''
	
	def enter(ExecutionFlow it) '''
		«enterSignature»
		{
			«enterSequences.defaultSequence.code»
		}
	'''
	def enterSignature(ExecutionFlow it) '''void «module»::«enterFctID»()'''
	def declareEnter(ExecutionFlow it) '''void «enterFctID»();'''
	
	def exit(ExecutionFlow it) '''
		«exitSignature»
		{
			«exitSequence.code»
		}
	'''
	def exitSignature(ExecutionFlow it) '''void «module»::«exitFctID»()'''
	def declareExit(ExecutionFlow it) '''void «exitFctID»();'''
	
	def isActive(ExecutionFlow it) '''
		«isActiveSignature»
		{
			return «FOR i : 0 ..< stateVector.size SEPARATOR '||'»stateConfVector[«i»] != «null_state»«ENDFOR»;
		}
	'''
	def isActiveSignature(ExecutionFlow it) '''sc_boolean «module»::«isActiveFctID»() const'''
	def declareIsActive(ExecutionFlow it) '''sc_boolean «isActiveFctID»() const;'''
	
	def isStateActive(ExecutionFlow it) '''
		«isStateActiveSignature»
		{
			switch (state)
			{
				«FOR s : states»
				case «s.shortName.asEscapedIdentifier» : 
					return (sc_boolean) («IF s.leaf»stateConfVector[«s.stateVectorDefine»] == «s.shortName.asEscapedIdentifier»
					«ELSE»stateConfVector[«s.stateVectorDefine»] >= «s.shortName.asEscapedIdentifier»
						&& stateConfVector[«s.stateVectorDefine»] <= «s.subStates.last.shortName.asEscapedIdentifier»«ENDIF»);
				«ENDFOR»
				default: return false;
			}
		}
	'''
	def isStateActiveSignature(ExecutionFlow it) '''sc_boolean «module»::«stateActiveFctID»(«statesEnumType» state) const'''
	def declareIsStateActive(ExecutionFlow it) '''sc_boolean «stateActiveFctID»(«statesEnumType» state) const;'''
	
	def isFinal(ExecutionFlow it) {
		val finalStateImpactVector = flow.finalStateImpactVector
		'''
			«IF !finalStateImpactVector.isCompletelyCovered»
			/* 
			 * Always returns 'false' since this state machine can never become final.
			 */
			«ENDIF»
			sc_boolean «module»::isFinal() const
			{
		''' +
		// only if the impact vector is completely covered by final states the state machine 
		// can become final
		{if (finalStateImpactVector.isCompletelyCovered) {'''	return «FOR i : 0 ..<finalStateImpactVector.size SEPARATOR ' && '»(«FOR fs : finalStateImpactVector.get(i) SEPARATOR ' || '»stateConfVector[«i»] == «IF fs.stateVector.offset == i»«fs.shortName»«ELSE»«null_state»«ENDIF»«ENDFOR»)«ENDFOR»;
		'''} else {'''   return false;'''} }		
		+ '''
		}'''
	}
	def isFinalSignature(ExecutionFlow it) '''sc_boolean «module»::«isFinalFctID»() const'''
	def declareIsFinal(ExecutionFlow it) '''sc_boolean «isFinalFctID»() const;'''
	
	def raiseTimeEvent(ExecutionFlow it) '''
		«raiseTimeEventSignature»
		{
			if ((evid >= (sc_eventid)«timeEventsInstance») && (evid < (sc_eventid)(&«timeEventsInstance»[«timeEventsCountConst»])))
			{
				*(sc_boolean*)evid = true;
			}				
		}
	'''
	def raiseTimeEventSignature(ExecutionFlow it) '''void «module»::«raiseTimeEventFctID»(sc_eventid evid)'''
	def declareRaiseTimeEvent(ExecutionFlow it) '''void «raiseTimeEventFctID»(sc_eventid evid);'''
	
	
	def unimplementedOCBErrors(ExecutionFlow it, GeneratorEntry entry)'''
		«FOR iface : getInterfaces.filter[hasOperations && !entry.useStaticOPC]»
			«IF iface instanceof InternalScope»
				«checkInternalOCB(iface)»
			«ELSEIF iface instanceof InterfaceScope»
				«checkInterfaceOCB(iface)»
			«ENDIF»
		«ENDFOR»
	'''
	
	def checkInternalOCB(StatechartScope it) '''
		if (this->«OCB_Instance» == null) { 
			errorCode |= «ErrorCode.OCB_INTERNAL_INIT.getName()»;
		}
	'''
	
	def checkInterfaceOCB(StatechartScope it) '''
		«IF defaultInterface»
			if (this->«OCB_Instance» == null) { 
				errorCode |=  «ErrorCode.OCB_DEFAULT_INIT.getName()»;
			}
		«ELSE»
			if (this->«OCB_Instance» == null) { 
				errorCode |= «ErrorCode.OCB_NAMED_INIT.getName()»;
			}
		«ENDIF»
	'''
}