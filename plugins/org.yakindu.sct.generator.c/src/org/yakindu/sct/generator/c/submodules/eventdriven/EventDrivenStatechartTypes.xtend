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
package org.yakindu.sct.generator.c.submodules.eventdriven

import com.google.inject.Inject
import com.google.inject.Singleton
import org.yakindu.sct.generator.c.extensions.EventNaming
import org.yakindu.sct.generator.c.submodules.StatechartTypes
import org.yakindu.sct.model.sexec.ExecutionFlow

import static org.yakindu.sct.generator.c.CGeneratorConstants.INT_TYPE
import static org.yakindu.sct.generator.c.CGeneratorConstants.BOOL_TYPE


/**
 * @author rbeckmann
 *
 */
@Singleton // Guice
class EventDrivenStatechartTypes extends StatechartTypes {
	@Inject protected extension EventNaming
	
	override statemachineStructContent(ExecutionFlow it) {
		'''
		«super.statemachineStructContent(it)»
		«IF hasLocalEvents»
		«eventQueueTypeName» «internalQueue»;
		«ENDIF»
		'''
	}
	
	def generateEventsEnum(ExecutionFlow it) {
		if(!hasLocalEvents) return ''''''
		'''
		/*
		 * Enum of event names in the statechart.
		 */
		typedef enum  {
			«invalidEventEnumName(it)» = «invalidEvent»,
			«FOR e : internalScope.getLocalEvents SEPARATOR ","»
				«eventEnumMemberName(e)»
			«ENDFOR»
		} «eventEnumName»;
		'''
	}
	
	def generateEventValueUnion(ExecutionFlow it) {
		if(!isEventValueUnionNeeded) return ''''''
		'''
		/*
		 * Union of all possible event value types.
		 */
		typedef union {
			«FOR e : valueUnionEvents»
			«e.typeSpecifier.targetLanguageName» «eventValueUnionMemberName(e)»;
			«ENDFOR»
		} «eventValueUnionName»;
		'''
	}
	
	def isEventValueUnionNeeded(ExecutionFlow it) {
		!valueUnionEvents.empty
	}
	
	def generateEventStruct(ExecutionFlow it) {
		'''
		/*
		 * Struct that represents a single event.
		 */
		typedef struct {
			«eventEnumName» name;
			«IF hasLocalEventsWithValue»
			«BOOL_TYPE» has_value;
			«eventValueUnionName» value;
			«ENDIF»
		} «internalEventStructTypeName»;
		'''
	}

	def generateEventQueue(ExecutionFlow it) {
		'''
		/*
		 * Queue that holds the raised events.
		 */
		typedef struct «eventQueueTypeName»_s {
			«internalEventStructTypeName» events[«bufferSize»];
			«INT_TYPE» pop_index;
			«INT_TYPE» push_index;
			«INT_TYPE» size;
		} «eventQueueTypeName»;
		'''
	}
	
	def valueUnionEvents(ExecutionFlow it) {
		localEvents.filter[hasValue]
	}
}