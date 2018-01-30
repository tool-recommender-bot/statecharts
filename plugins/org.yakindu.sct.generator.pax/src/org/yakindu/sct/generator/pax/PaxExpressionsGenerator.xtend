package org.yakindu.sct.generator.pax

import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.sct.generator.core.templates.ExpressionsGenerator

class PaxExpressionsGenerator extends ExpressionsGenerator {

	def dispatch CharSequence code(ElementReferenceExpression it) {
		it.code(it.definition)
	}

//	
//	/* Referring to declared elements */
//	def dispatch CharSequence code(ElementReferenceExpression it) {
//		it.code(it.definition)
//	}
//	
//	/* Expressions */
//	def dispatch CharSequence code(Expression it, Event target) ''' tbd '''
//
//	def dispatch CharSequence code(Expression it, VariableDefinition target) ''' tbd '''
//
//	/* TODO: check if event is active */
//	def dispatch CharSequence code(EventValueReferenceExpression it) ''' tbd '''
//
//	def dispatch CharSequence code(ElementReferenceExpression it, VariableDefinition target) ''' tbd '''
//
//	def dispatch CharSequence code(ElementReferenceExpression it,
//		OperationDefinition target) ''' tbd '''
//
//	def dispatch CharSequence code(ElementReferenceExpression it,
//		Operation target) ''' tbd '''
//
//	def dispatch CharSequence code(ElementReferenceExpression it, Property target) ''' tbd '''
//
//	def dispatch CharSequence code(EventRaisingExpression it) ''' tbd '''
//
//	def dispatch CharSequence code(
//		ActiveStateReferenceExpression it)''' tbd '''
//
//	def dispatch CharSequence code(LogicalRelationExpression it) ''' tbd '''
//
//	override dispatch CharSequence code(AssignmentExpression it)''' tbd '''
//
//	def dispatch CharSequence code(NumericalMultiplyDivideExpression expression)''' tbd '''
//
//	/* Feature call */
//	def dispatch CharSequence code(FeatureCall it)''' tbd '''
//
//	def dispatch CharSequence code(FeatureCall it, VariableDefinition target)''' tbd '''
//
//	def dispatch CharSequence code(FeatureCall it,
//		OperationDefinition target) ''' tbd '''
//
//	def dispatch CharSequence code(FeatureCall it,
//		Operation target)''' tbd '''
//
//	def dispatch CharSequence code(FeatureCall it, Property target) ''' tbd '''
//
//	def dispatch CharSequence code(FeatureCall it, Enumerator target)''' tbd '''
//
//	/* Literals */
//	override dispatch CharSequence code(NullLiteral it)''' tbd '''
//
//	override dispatch CharSequence code(BoolLiteral it)''' tbd '''
//
//	// ensure we obtain an expression of type sc_boolean
//	def dispatch CharSequence sc_boolean_code(Expression it)''' tbd '''
//
//	def dispatch CharSequence sc_boolean_code(LogicalOrExpression it) ''' tbd '''
//
//	def dispatch CharSequence sc_boolean_code(LogicalAndExpression it)''' tbd '''
//
//	def dispatch CharSequence sc_boolean_code(LogicalNotExpression it) ''' tbd '''
//
//	def dispatch CharSequence sc_boolean_code(LogicalRelationExpression it) ''' tbd '''
}
