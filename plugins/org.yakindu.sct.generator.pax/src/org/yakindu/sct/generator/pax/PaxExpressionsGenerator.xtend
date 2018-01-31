package org.yakindu.sct.generator.pax

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.yakindu.base.expressions.expressions.AssignmentExpression
import org.yakindu.base.expressions.expressions.BinaryExpression
import org.yakindu.base.expressions.expressions.BinaryLiteral
import org.yakindu.base.expressions.expressions.BoolLiteral
import org.yakindu.base.expressions.expressions.ConditionalExpression
import org.yakindu.base.expressions.expressions.DoubleLiteral
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.Expression
import org.yakindu.base.expressions.expressions.FloatLiteral
import org.yakindu.base.expressions.expressions.HexLiteral
import org.yakindu.base.expressions.expressions.IntLiteral
import org.yakindu.base.expressions.expressions.Literal
import org.yakindu.base.expressions.expressions.LogicalAndExpression
import org.yakindu.base.expressions.expressions.LogicalNotExpression
import org.yakindu.base.expressions.expressions.LogicalOrExpression
import org.yakindu.base.expressions.expressions.LogicalRelationExpression
import org.yakindu.base.expressions.expressions.NullLiteral
import org.yakindu.base.expressions.expressions.ParenthesizedExpression
import org.yakindu.base.expressions.expressions.PostFixUnaryExpression
import org.yakindu.base.expressions.expressions.PrimitiveValueExpression
import org.yakindu.base.expressions.expressions.StringLiteral
import org.yakindu.base.expressions.expressions.TypeCastExpression
import org.yakindu.base.expressions.expressions.UnaryExpression
import org.yakindu.base.types.Event
import org.yakindu.base.types.inferrer.ITypeSystemInferrer
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.generator.core.templates.ExpressionsGenerator
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.model.stext.stext.VariableDefinition

class PaxExpressionsGenerator extends ExpressionsGenerator {

	@Inject extension ICodegenTypeSystemAccess
	@Inject extension PaxNaming
	@Inject extension PaxNavigation
	@Inject extension ITypeSystem
	@Inject extension ITypeSystemInferrer
	@Inject extension PaxNamingService

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
	
	// ab hier aus CExpressionCode
	
	def dispatch CharSequence code(ElementReferenceExpression it){
		it.code(it.definition)
	}
	
	def dispatch CharSequence code(Expression it, Event target) '''«target.access»'''
	
	def dispatch CharSequence code(Expression it, VariableDefinition target) '''«target.access»'''
	
	// ensure we obtain an expression of type sc_boolean
	def dispatch CharSequence sc_boolean_code(Expression it) '''«it.code»'''

	def dispatch CharSequence sc_boolean_code(LogicalOrExpression it) '''(«code») ? true : false;'''

	def dispatch CharSequence sc_boolean_code(LogicalAndExpression it) '''(«code») ? true : false;'''

	def dispatch CharSequence sc_boolean_code(LogicalNotExpression it) '''(«code») ? true : false;'''

	def dispatch CharSequence sc_boolean_code(LogicalRelationExpression it) '''(«code») ? true : false;'''
}
