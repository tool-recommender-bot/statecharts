/** 
 * Copyright (c) 2018 itemis AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * itemis AG - initial API and implementation
 */
package org.yakindu.sct.model.stext.validation

import com.google.inject.Inject
import org.eclipse.core.runtime.OperationCanceledException
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.validation.AbstractDeclarativeValidator
import org.eclipse.xtext.validation.Check
import org.eclipse.xtext.validation.CheckType
import org.eclipse.xtext.validation.EValidatorRegistrar
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.Expression
import org.yakindu.base.expressions.interpreter.IExpressionInterpreter
import org.yakindu.sct.model.sruntime.ExecutionContext
import org.yakindu.sct.model.sruntime.ExecutionSlot
import org.yakindu.sct.model.sruntime.impl.ExecutionContextImpl
import org.yakindu.sct.model.stext.stext.Guard
import org.yakindu.sct.model.stext.stext.VariableDefinition
import org.yakindu.sct.model.sruntime.SRuntimeFactory

/** 
 * @author andreas muelder - Initial contribution and API
 */
class StaticExpressionValidator extends AbstractDeclarativeValidator {

	@Inject IExpressionInterpreter interpreter
	@Inject extension IQualifiedNameProvider fqnProvider
	extension SRuntimeFactory

	protected static class StaticExecutionContext extends ExecutionContextImpl {
		override ExecutionSlot getSlot(String fqName) {
			val ExecutionSlot slot = super.getSlot(fqName)
			if (slot === null || slot.isWritable())
				throw new OperationCanceledException("");
			return slot
		}
	}

	@Check(CheckType.NORMAL)
	def void checkGuardExpression(Guard guard) {
		val staticContext = new StaticExecutionContext
		try {
			guard.expression.initializeExecutionContext(staticContext)
			var Object result = interpreter.evaluate(guard.getExpression(), staticContext)
			if (!(result instanceof Boolean)) {
				return
			}
			val value = (result as Boolean).booleanValue()
			if (!value) {
				warning('''The guard expression '«NodeModelUtils.getNode(guard).text»' can never be 'true''', guard,
					null)
			} else
				warning('''The guard expression '«NodeModelUtils.getNode(guard).text»' is always 'true''', guard, null)
		} catch (OperationCanceledException e) {
			// Access to variable, expression can not be checked statically
		}
	}

	def protected void initializeExecutionContext(Expression expression, ExecutionContext context) {
		expression.eAllContents.filter(ElementReferenceExpression).forEach [ ele |
			if (ele.reference instanceof VariableDefinition && (ele.reference as VariableDefinition).isConst) {
				val definition = ele.reference as VariableDefinition
				context.slots += createExecutionVariable => [
					name = definition.name
					value = interpreter.evaluate(definition.initialValue, context)
					writable = false
					fqName = definition.getFullyQualifiedName().toString
				]
			}
		]
	}

	override void register(EValidatorRegistrar registrar) { // Registered as composite
	}
}
