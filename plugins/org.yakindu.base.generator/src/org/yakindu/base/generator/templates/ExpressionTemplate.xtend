package org.yakindu.base.generator.templates

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.yakindu.base.expressions.expressions.AssignmentExpression
import org.yakindu.base.expressions.expressions.AssignmentOperator
import org.yakindu.base.expressions.expressions.BinaryExpression
import org.yakindu.base.expressions.expressions.BoolLiteral
import org.yakindu.base.expressions.expressions.ConditionalExpression
import org.yakindu.base.expressions.expressions.DoubleLiteral
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.Expression
import org.yakindu.base.expressions.expressions.FloatLiteral
import org.yakindu.base.expressions.expressions.HexLiteral
import org.yakindu.base.expressions.expressions.IntLiteral
import org.yakindu.base.expressions.expressions.LogicalRelationExpression
import org.yakindu.base.expressions.expressions.NullLiteral
import org.yakindu.base.expressions.expressions.PrimitiveValueExpression
import org.yakindu.base.expressions.expressions.RelationalOperator
import org.yakindu.base.expressions.expressions.StringLiteral
import org.yakindu.base.expressions.expressions.UnaryExpression
import org.yakindu.base.generator.ExpressionGen
import org.yakindu.base.types.Property
import org.yakindu.base.types.inferrer.ITypeSystemInferrer
import org.yakindu.base.types.typesystem.GenericTypeSystem
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.model.sexec.extensions.SExecExtensions

class ExpressionTemplate extends Template {
	@Inject extension SExecExtensions
	@Inject extension ITypeSystem
	@Inject extension ITypeSystemInferrer
		
	def generate(ExpressionGen it) {
		expression.code
	}
	
	def dispatch CharSequence code(BinaryExpression expression) {
		expression.leftOperand.code.toString.trim + " " + expression.operator.literal.toString.trim + " " + expression.rightOperand.code
	}

	def dispatch CharSequence code(UnaryExpression expression) {
		expression.operator.literal + expression.operand.code
	}
	
	def dispatch CharSequence code(EObject it) {
		throw new IllegalStateException("No dispatch function for " + getClass().name)
	}
	
	/* Literals */
	def dispatch String code(BoolLiteral expression) {
		expression.value.toString()
	}

	def dispatch String code(IntLiteral expression) {
		expression.value.toString();
	}

	def dispatch String code(HexLiteral expression) {
		expression.value.toString();
	}

	def dispatch String code(DoubleLiteral expression) {
		expression.value.toString();
	}

	def dispatch String code(FloatLiteral expression) {
		expression.value.toString();
	}

	def dispatch String code(NullLiteral expression) {
		'null'
	}

	def dispatch String code(StringLiteral expression) {
		"\"" + expression.value.toString().escaped + "\""
	}

	def String escaped(String it) {
		return it.replace("\"", "\\\"");
	}
	
	def dispatch String code(ConditionalExpression expression) {
		expression.condition.code + ' ? ' + expression.trueCase.code + ' : ' + expression.falseCase.code
	}

	def dispatch String code(LogicalRelationExpression expression) {
		if (isSame(expression.leftOperand.infer.type, getType(GenericTypeSystem.STRING))) {
			expression.logicalString
		} else
			expression.leftOperand.code + expression.operator.literal + expression.rightOperand.code;
	}

	def String logicalString(LogicalRelationExpression expression) {
		if (expression.operator == RelationalOperator::EQUALS) {
			"(" + expression.leftOperand.code + "== null?" + expression.rightOperand.code + " ==null :" +
				expression.leftOperand.code + ".equals(" + expression.rightOperand.code + "))"
		} else if (expression.operator == RelationalOperator::NOT_EQUALS) {
			"(" + expression.leftOperand.code + "== null?" + expression.rightOperand.code + " !=null : !" +
				expression.leftOperand.code + ".equals(" + expression.rightOperand.code + "))"
		}
	}
	
	/* Assignment */
	def dispatch String code(AssignmentExpression it) {
		'''«varRef.code» «operator» «expression»'''
	}

	def dispatch String getContext(EObject it) {
		return "//ERROR: No context for " + it
	}

	def dispatch String getStaticContext(EObject it) {
		return "//ERROR: No context for " + it
	}

	def boolean isAssignmentContained(Expression it) {
		if (it instanceof AssignmentExpression) {
			return true
		} else if (eContainer instanceof Expression) {
			return isAssignmentContained(eContainer as Expression)
		}
		return false // default
	}

	def boolean isPropertyContained(Expression it) {
		if (eContainer instanceof Property) {
			return true
		} else if (eContainer instanceof Expression) {
			return isPropertyContained(eContainer as Expression)
		}
		return false // default
	}
}