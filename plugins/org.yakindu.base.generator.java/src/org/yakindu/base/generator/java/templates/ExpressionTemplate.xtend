package org.yakindu.base.generator.java.templates

import org.eclipse.emf.ecore.EObject
import org.yakindu.base.expressions.expressions.AssignmentExpression
import org.yakindu.base.expressions.expressions.BinaryExpression
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.Expression
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.generator.generator.CodeElement
import org.yakindu.base.generator.generator.ExpressionGen

class ExpressionTemplate extends Template {
	def dispatch generate(ExpressionGen it) {
		'''«expression.code»;'''
	}
	
	def dispatch CharSequence code(EObject it) {
		'''/* unsupported EObject «it.class.simpleName» */'''
	}
	
	def dispatch CharSequence code(CodeElement it) {
		'''«templateProvider.get(it).generate(it)»'''
	}
	
	def dispatch CharSequence code(Expression it) {
		'''/* unsupported Expression «it.class.simpleName» */'''
	}
	
	def dispatch CharSequence code(BinaryExpression it) {
		'''«leftOperand.code» «operator» «rightOperand.code»'''
	}
	
	def dispatch CharSequence code(FeatureCall it) {
		'''«owner.code».«feature.code»'''
	}
	
	def dispatch CharSequence code(AssignmentExpression it) {
		'''«varRef.code» = «expression.code»'''
	}
	
	def dispatch CharSequence code(ElementReferenceExpression it) {
		'''«reference.code»'''
	}
}