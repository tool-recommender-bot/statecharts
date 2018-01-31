package org.yakindu.sct.generator.pax

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.yakindu.base.expressions.expressions.AssignmentExpression
import org.yakindu.base.expressions.expressions.BinaryExpression
import org.yakindu.base.expressions.expressions.BinaryLiteral
import org.yakindu.base.expressions.expressions.BoolLiteral
import org.yakindu.base.expressions.expressions.ConditionalExpression
import org.yakindu.base.expressions.expressions.DoubleLiteral
import org.yakindu.base.expressions.expressions.FloatLiteral
import org.yakindu.base.expressions.expressions.HexLiteral
import org.yakindu.base.expressions.expressions.IntLiteral
import org.yakindu.base.expressions.expressions.Literal
import org.yakindu.base.expressions.expressions.NullLiteral
import org.yakindu.base.expressions.expressions.ParenthesizedExpression
import org.yakindu.base.expressions.expressions.PostFixUnaryExpression
import org.yakindu.base.expressions.expressions.PrimitiveValueExpression
import org.yakindu.base.expressions.expressions.StringLiteral
import org.yakindu.base.expressions.expressions.TypeCastExpression
import org.yakindu.base.expressions.expressions.UnaryExpression
import org.yakindu.sct.generator.core.templates.ExpressionsGenerator
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess

class PaxExpressionsGenerator extends ExpressionsGenerator {

	@Inject protected extension ICodegenTypeSystemAccess

	override dispatch CharSequence code(EObject it) {
		throw new IllegalStateException("No dispatch function for " + getClass().name)
	}

	/* Expressions */
	override dispatch CharSequence code(BinaryExpression it) {
		leftOperand.code.toString.trim + " " + operator.literal.toString.trim + " " + rightOperand.code
	}

	override dispatch CharSequence code(UnaryExpression it) {
		operator.literal + operand.code
	}

	override dispatch CharSequence code(PostFixUnaryExpression it) {
		operand.code + operator.literal
	}

	override dispatch CharSequence code(AssignmentExpression it) '''«varRef.code» «operator.literal» «expression.code»'''

	override dispatch CharSequence code(ConditionalExpression it) '''«condition.code» ? «trueCase.code» : «falseCase.code»'''

	override dispatch CharSequence code(PrimitiveValueExpression it) '''«value.code»'''

	override dispatch CharSequence code(ParenthesizedExpression it) '''(«expression.code»)'''

	override dispatch CharSequence code(TypeCastExpression it) '''((«type.getTargetLanguageName») «operand.code»)'''

	/* Literals */
	override dispatch CharSequence code(Literal it){
		throw new IllegalStateException("No dispatch function for " + getClass().name)
	}

	override dispatch CharSequence code(StringLiteral it) '''"«value.escaped»"'''

	override protected String escaped(String it) {
		return it.replace("\"", "\\\"");
	}

	override dispatch CharSequence code(IntLiteral it) '''«value.toString»'''

	override dispatch CharSequence code(DoubleLiteral it) '''«value.toString»'''

	override dispatch CharSequence code(FloatLiteral it) '''«value.toString»'''

	override dispatch CharSequence code(HexLiteral it) '''0x«Integer::toHexString(value)»'''

	override dispatch CharSequence code(BinaryLiteral it) '''0b«Integer::toBinaryString(value)»'''

	override dispatch CharSequence code(BoolLiteral it) '''«value.toString»'''

	override dispatch CharSequence code(NullLiteral expression) {
		'null'
	}	
}
