/** 
 * Copyright (c) 2015 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 * 
 */
 
package org.yakindu.sct.generator.cpp

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.yakindu.base.expressions.expressions.AdditiveOperator
import org.yakindu.base.expressions.expressions.AssignmentExpression
import org.yakindu.base.expressions.expressions.AssignmentOperator
import org.yakindu.base.expressions.expressions.BoolLiteral
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.Expression
import org.yakindu.base.expressions.expressions.ExpressionsFactory
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.expressions.expressions.StringLiteral
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.generator.c.CExpressionsGenerator
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.naming.INamingService
import org.yakindu.sct.model.stext.stext.ActiveStateReferenceExpression
import org.yakindu.sct.model.stext.stext.EventRaisingExpression
import org.yakindu.sct.model.stext.stext.OperationDefinition
import org.yakindu.sct.model.stext.stext.StatechartScope
import org.yakindu.sct.model.stext.stext.VariableDefinition
import org.yakindu.base.expressions.expressions.MultiplicativeOperator
import org.yakindu.base.expressions.expressions.ShiftOperator

class CppExpressionsGenerator extends CExpressionsGenerator {

	@Inject protected extension CppNaming
	@Inject protected extension SExecExtensions
	@Inject protected extension ITypeSystem
	@Inject protected extension INamingService
	protected ExpressionsFactory factory = ExpressionsFactory.eINSTANCE

	override dispatch CharSequence code(ElementReferenceExpression it,
		OperationDefinition target) '''«target.access»(«FOR arg : expressions SEPARATOR ', '»«arg.
		code»«ENDFOR»)'''

	override dispatch CharSequence code(EventRaisingExpression it) '''
	«IF value !== null»
		«event.definition.event.valueAccess» = «value.code»;
	«ENDIF»
	«event.definition.event.access» = true'''

	override dispatch CharSequence code(
		ActiveStateReferenceExpression it) '''«flow.stateActiveFctID»(«value.shortName»)'''

	/* Feature Call */
	override dispatch CharSequence code(FeatureCall it,
		OperationDefinition target) '''«target.access»(«FOR arg : expressions SEPARATOR ', '»«arg.code»«ENDFOR»)'''

	/* Literals */
	override dispatch CharSequence code(BoolLiteral it) '''«IF value»true«ELSE»false«ENDIF»'''
	
	override dispatch CharSequence code(StringLiteral it) '''(sc_string) «super._code(it)»'''
	
	override dispatch CharSequence code(AssignmentExpression it) {
		var CharSequence exp = ""
		if (it.operator.equals(AssignmentOperator.MOD_ASSIGN) && haveCommonTypeReal(it)) {
			exp = '''fmod(«varRef.code», «expression.code»)'''
		} else {
			val assExp = simplifiedAssignment
			exp = assExp.expression.code
		}
			'''«varRef.assign(exp)»'''
	}
	
	def dispatch CharSequence assign(ElementReferenceExpression it, CharSequence exp) {
		if(reference instanceof VariableDefinition && reference.eContainer instanceof StatechartScope)  {
			'''«(reference as VariableDefinition).asSetter»(«exp»)'''
		} else {
			super.code(it.eContainer)
		}
	}
	
	def dispatch CharSequence assign(Expression it, Expression exp) {
		assign(exp.code)
	}
	
	def AssignmentExpression getSimplifiedAssignment(AssignmentExpression it) {
		switch(operator) {
			case AssignmentOperator.ASSIGN: {
			}
			case AssignmentOperator.ADD_ASSIGN: {
				expression = factory.createNumericalAddSubtractExpression => [ e |
					e.operator = AdditiveOperator.PLUS
					e.leftOperand = varRef.copy
					e.rightOperand = expression.copy
				]
			}
			case SUB_ASSIGN: {
				expression = factory.createNumericalAddSubtractExpression => [ e |
					e.operator = AdditiveOperator.MINUS
					e.leftOperand = varRef.copy
					e.rightOperand = expression.copy
				]
			}
			case MULT_ASSIGN: {
				expression = factory.createNumericalMultiplyDivideExpression => [ e |
					e.operator = MultiplicativeOperator.MUL
					e.leftOperand = varRef.copy
					e.rightOperand = expression.copy
				]
			}
			case DIV_ASSIGN: {
				expression = factory.createNumericalMultiplyDivideExpression => [ e |
					e.operator = MultiplicativeOperator.DIV
					e.leftOperand = varRef.copy
					e.rightOperand = expression.copy
				]
			}
			case MOD_ASSIGN: {
			}
			case AND_ASSIGN: {
				expression = factory.createBitwiseAndExpression => [ e |
					e.leftOperand = varRef.copy
					e.rightOperand = expression.copy
				]
			}
			case OR_ASSIGN: {
				expression = factory.createBitwiseOrExpression => [ e |
					e.leftOperand = varRef.copy
					e.rightOperand = expression.copy
				]
			}
			case XOR_ASSIGN: {
				expression = factory.createBitwiseXorExpression => [ e |
					e.leftOperand = varRef.copy
					e.rightOperand = expression.copy
				]
			} 
			case LEFT_SHIFT_ASSIGN: {
				expression = factory.createShiftExpression=> [ e |
					e.operator = ShiftOperator.LEFT
					e.leftOperand = varRef.copy
					e.rightOperand = expression.copy
				]
			}
			case RIGHT_SHIFT_ASSIGN: {
				expression = factory.createShiftExpression=> [ e |
					e.operator = ShiftOperator.RIGHT
					e.leftOperand = varRef.copy
					e.rightOperand = expression.copy
				]
			}
		}
		operator = AssignmentOperator.ASSIGN
		it
	}
	
	def <T extends EObject> T copy(T it) {EcoreUtil.copy(it)}
}
