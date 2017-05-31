package org.yakindu.base.generator.java.templates

import org.yakindu.base.expressions.expressions.BinaryExpression
import org.yakindu.base.expressions.expressions.Expression
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.generator.generator.ExpressionGen
import org.yakindu.base.expressions.expressions.AssignmentExpression

class ExpressionTemplate extends Template {
	def dispatch generate(ExpressionGen it) {
		'''«expression.code»'''
	}
	
	def dispatch CharSequence code(Expression it) {
		'''/* unsupported Expression «it.class.simpleName» */'''
	}
	
	def dispatch CharSequence code(BinaryExpression it) {
		'''«leftOperand.code» «operator» «rightOperand.code»'''
	}
	
	def dispatch CharSequence code(FeatureCall it) {
		'''«owner».«feature»'''
	}
	
	def dispatch CharSequence code(AssignmentExpression it) {
		'''«varRef.code» = «expression.code»'''
	}
}