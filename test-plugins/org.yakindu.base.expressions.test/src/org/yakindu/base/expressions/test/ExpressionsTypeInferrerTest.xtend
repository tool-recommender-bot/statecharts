/** 
 * Copyright (c) 2011-2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 */
package org.yakindu.base.expressions.test

import com.google.inject.Inject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.yakindu.base.expressions.test.utils.ExpressionsInjectorProvider
import org.yakindu.base.expressions.test.utils.ExpressionsTestScopeProvider
import org.yakindu.base.expressions.test.utils.TypeInferrerTester
import org.yakindu.base.expressions.test.utils.TypesTestFactory
import static org.yakindu.base.expressions.inferrer.ExpressionsTypeInferrerMessages.*
import static java.lang.String.*

/** 
 * @author andreas muelder - Initial contribution and API
 * @author axel terfloth - additional tests
 * @author Alexander Nyssen - Adopted to changes in type system
 */
@RunWith(XtextRunner)
@InjectWith(ExpressionsInjectorProvider)
class ExpressionsTypeInferrerTest {

	@Inject
	protected extension TypeInferrerTester
	@Inject
	protected extension TypesTestFactory
	@Inject
	protected ExpressionsTestScopeProvider provider;

	@Before
	def setupScope() {
		provider.context = #[
			createEvent("boolEvent", "boolean"),
			createEvent("intEvent", "integer"),
			createProperty("intVar", "integer"),
			createProperty("realVar", "real"),
			createProperty("boolVar", "boolean"),
			createProperty("stringVar", "string"),
			createOperation("intOp", "integer")
		]
	}

// Unary
	@Test
	def void testNumericalUnaryExpressionSuccess() {
		// int
		assertInteger("1")
		assertInteger("0x0F")
		assertInteger("0b00001")
		assertInteger("-1")
		assertInteger("0")
		assertInteger("intVar")
		// real
		assertReal("1.0")
		assertReal("-1.0")
		assertReal("0.0")
		assertReal("realVar")
		// string
		assertString("'42'")
		assertString("stringVar")
		// boolean
		assertBoolean("true")
		assertBoolean("false")
		assertBoolean("boolVar")
		assertBoolean("boolEvent")
		// tilde
		assertInteger(" ~3")
	}

	@Test
	def void testNumericalUnaryExpressionFailure() {
		expectIssue("~true", format(BITWISE_OPERATOR, '~', 'boolean'))
		expectIssue("~9.0", format(BITWISE_OPERATOR, '~', 'real'))
		expectIssue("~stringVar", format(BITWISE_OPERATOR, '~', 'string'))
	}

// AddSubtract
	@Test
	def void testNumericalAddSubtractExpression() {
		// add
		assertInteger("1 + 2")
		assertInteger("1 + 0x0F")
		assertInteger("0x0F + 0x0F")
		assertInteger("intVar + 0x0F")
		assertInteger("1 + 0b11")
		assertInteger("0b01 + 0b1110")
		assertInteger("intVar + 0B101010")
		assertInteger("intVar + 2")
		assertReal("1.1 + 2")
		assertReal("2 + 1.0")
		assertReal("1 + 2 + 3.0")
		// subtract
		assertInteger("1 - 2")
		assertInteger("0x0F - 2")
		assertInteger("0x0F - 0x0F")
		assertInteger("0x0F- intVar")
		assertInteger("1 - 0b11")
		assertInteger("0b01 - 0b1110")
		assertInteger("intVar - 0B101010")
		assertInteger("intVar - 2")
		assertReal("1.0 - 2")
		assertReal("2 - 1.0")
		assertReal("realVar - 1.0")
		assertReal("1 - 2 - 3.0")
	}

	@Test
	def void testNumericalAddSubtractExpressionFailure() {
		// add
		expectIssue("true + 5", format(ARITHMETIC_OPERATORS, '+', 'boolean', 'integer'))
		expectIssue("false + 5", format(ARITHMETIC_OPERATORS, '+', 'boolean', 'integer'))
		expectIssue("5 + false", format(ARITHMETIC_OPERATORS, '+', 'integer', 'boolean'))
		expectIssue("true + (3 * 5)", format(ARITHMETIC_OPERATORS, '+', 'boolean', 'integer'))
		expectIssue("(3 * 5) + true", format(ARITHMETIC_OPERATORS, '+', 'integer', 'boolean'))
		expectIssue("3.0 +  true", format(ARITHMETIC_OPERATORS, '+', 'real', 'boolean'))
		expectIssue("3.0 + 'string'", format(ARITHMETIC_OPERATORS, '+', 'real', 'string'))
		expectIssue("intVar + 'string'", format(ARITHMETIC_OPERATORS, '+', 'integer', 'string'))
		// subtract
		expectIssue("true - 5", format(ARITHMETIC_OPERATORS, '-', 'boolean', 'integer'))
		expectIssue("false - 5", format(ARITHMETIC_OPERATORS, '-', 'boolean', 'integer'))
		expectIssue("5 - false", format(ARITHMETIC_OPERATORS, '-', 'integer', 'boolean'))
		expectIssue("true - (3 * 5)", format(ARITHMETIC_OPERATORS, '-', 'boolean', 'integer'))
		expectIssue("(3 * 5) - true", format(ARITHMETIC_OPERATORS, '-', 'integer', 'boolean'))
		expectIssue("3.0 -  true", format(ARITHMETIC_OPERATORS, '-', 'real', 'boolean'))
		expectIssue("3.0 -  'string'", format(ARITHMETIC_OPERATORS, '-', 'real', 'string'))
		expectIssue("intVar - 'string'", format(ARITHMETIC_OPERATORS, '-', 'integer', 'string'))
	}

// multiply
	@Test def void testMultiplyDivideExpressionSuccess() {
		// multiply
		// integer
		assertInteger("1 * 2")
		assertInteger("1 * 0x0F")
		assertInteger("0x0F * intVar")
		assertInteger("1 * 0B11")
		assertInteger("0b01101 * intVar")
		// real
		assertReal("intVar * realVar")
		assertReal("1.0 * 2")
		assertReal("2 * 1.0")
		assertReal("1 * 2 * 3.0")
		// divide
		// integer
		assertInteger("1 / 2")
		assertInteger("1 / intVar")
		assertInteger("1 / 0x0F")
		assertInteger("0x0F / 0x0F")
		assertInteger("intVar / 0x0F")
		assertInteger("1 / 0b01")
		assertInteger("0x0F / 0b10")
		assertInteger("intVar / 0b011")
		// real
		assertReal("1.0 / 2")
		assertReal("2 / 1.0")
		assertReal("1 / 2 / 3.0")
		// modulo
		// integer
		assertInteger("1 % 2")
		assertInteger("1 % 0x0F")
		assertInteger("0x0F % 0x0F")
		assertInteger("intVar % 0x0F")
		assertInteger("1 % 0b0001")
		assertInteger("0x0F % 0b1")
		assertInteger("intVar % 0b001")
		// real
		assertReal("1.0 % 2")
		assertReal("2 % 1.0")
		assertReal("2 % realVar")
		assertReal("1 % 2 % 3.0")
	}

	@Test
	def void testMultiplyDivideExpressionFailure() {
		// multiply
		expectIssue("true * 5", format(ARITHMETIC_OPERATORS, '*', 'boolean', 'integer'))
		expectIssue("5 * false", format(ARITHMETIC_OPERATORS, '*', 'integer', 'boolean'))
		expectIssue("true * (3 - 5)", format(ARITHMETIC_OPERATORS, '*', 'boolean', 'integer'))
		expectIssue("(3 + 5) * true", format(ARITHMETIC_OPERATORS, '*', 'integer', 'boolean'))
		expectIssue("3.0 *  true", format(ARITHMETIC_OPERATORS, '*', 'real', 'boolean'))
		expectIssue("3.0 *  'string'", format(ARITHMETIC_OPERATORS, '*', 'real', 'string'))
		expectIssue("realVar *  'string'", format(ARITHMETIC_OPERATORS, '*', 'real', 'string'))
		// divide
		expectIssue("true / 5", format(ARITHMETIC_OPERATORS, '/', 'boolean', 'integer'))
		expectIssue("false / 5", format(ARITHMETIC_OPERATORS, '/', 'boolean', 'integer'))
		expectIssue("5 / false", format(ARITHMETIC_OPERATORS, '/', 'integer', 'boolean'))
		expectIssue("true / (3 - 5)", format(ARITHMETIC_OPERATORS, '/', 'boolean', 'integer'))
		expectIssue("(3 + 5) / true", format(ARITHMETIC_OPERATORS, '/', 'integer', 'boolean'))
		expectIssue("3.0 /  true", format(ARITHMETIC_OPERATORS, '/', 'real', 'boolean'))
		expectIssue("3.0 /  'string'", format(ARITHMETIC_OPERATORS, '/', 'real', 'string'))
		expectIssue("realVar /  stringVar", format(ARITHMETIC_OPERATORS, '/', 'real', 'string'))
		// mod
		expectIssue("true % 5", format(ARITHMETIC_OPERATORS, '%', 'boolean', 'integer'))
		expectIssue("false % 5", format(ARITHMETIC_OPERATORS, '%', 'boolean', 'integer'))
		expectIssue("5 % false", format(ARITHMETIC_OPERATORS, '%', 'integer', 'boolean'))
		expectIssue("true % (3 - 5)", format(ARITHMETIC_OPERATORS, '%', 'boolean', 'integer'))
		expectIssue("(3 + 5) % true", format(ARITHMETIC_OPERATORS, '%', 'integer', 'boolean'))
		expectIssue("3.0 % true", format(ARITHMETIC_OPERATORS, '%', 'real', 'boolean'))
		expectIssue("3.0 % 'string'", format(ARITHMETIC_OPERATORS, '%', 'real', 'string'))
		expectIssue("3.0 % stringVar", format(ARITHMETIC_OPERATORS, '%', 'real', 'string'))
		expectIssue("realVar % stringVar", format(ARITHMETIC_OPERATORS, '%', 'real', 'string'))
	}

	// LogicalAndExpression
	@Test
	def void testLogicalAndExpressionSuccess() {
		assertBoolean("true && false")
		assertBoolean("true && boolVar")
		assertBoolean("boolEvent && intEvent")
		// intEvent is a shortcut for isRaised(intEvent), thus of boolean type
		assertBoolean("boolEvent && boolEvent")
	}

	@Test
	def void testLogicalAndExpressionFailure() {
		expectIssue("true && 5", format(LOGICAL_OPERATORS, '&&', 'boolean', 'integer'))
		expectIssue("5 && false", format(LOGICAL_OPERATORS, '&&', 'integer', 'boolean'))
		expectIssue("3.0 &&  true", format(LOGICAL_OPERATORS, '&&', 'real', 'boolean'))
		expectIssue("5 && boolEvent", format(LOGICAL_OPERATORS, '&&', 'integer', 'boolean'))
		expectIssue("true && 'string'", format(LOGICAL_OPERATORS, '&&', 'boolean', 'string'))
		expectIssue("true && 1.2", format(LOGICAL_OPERATORS, '&&', 'boolean', 'real'))
	}

// LogicalOrExpression
	@Test
	def void testLogicalOrExpressionSuccess() {
		assertBoolean("true || false")
		assertBoolean("true || boolVar")
		assertBoolean("boolEvent || intEvent")
		assertBoolean("boolEvent || boolEvent")
	}

	@Test
	def void testLogicalOrExpressionFailure() {
		expectIssue("false || 5", format(LOGICAL_OPERATORS, '||', 'boolean', 'integer'))
		expectIssue("5 || true", format(LOGICAL_OPERATORS, '||', 'integer', 'boolean'))
		expectIssue("3.0 ||  true", format(LOGICAL_OPERATORS, '||', 'real', 'boolean'))
		expectIssue("5 || boolEvent", format(LOGICAL_OPERATORS, '||', 'integer', 'boolean'))
		expectIssue("5 || 'string'", format(LOGICAL_OPERATORS, '||', 'integer', 'string'))
		expectIssue("5 || 1.2", format(LOGICAL_OPERATORS, '||', 'integer', 'real'))
	}

	// LogicalNotExpression
	@Test
	def void testLogicalNotExpressionSuccess() {
		assertBoolean("!true")
		assertBoolean("!boolVar")
		assertBoolean("!intEvent")
		assertBoolean("!boolEvent")
	}

	@Test
	def void testLogicalNotExpressionFailure() {
		expectIssue("!3", format(LOGICAL_OPERATOR, '!', 'integer'))
		expectIssue("!1.2", format(LOGICAL_OPERATOR, '!', 'real'))
		expectIssue("!'Test'", format(LOGICAL_OPERATOR, '!', 'string'))
	}

	// LogicalRelation
	@Test
	def void testLogicalRelationExpressionSuccess() {
		// smaller
		assertBoolean("5 < 3")
		assertBoolean("5.0 < 3")
		assertBoolean("5.0 < intVar")
		// smallerEqual
		assertBoolean("5 <= 3")
		assertBoolean("5.0 <= 3")
		assertBoolean("5.0 <= intVar")
		// greater
		assertBoolean("5 > 3")
		assertBoolean("5.0 > 3")
		assertBoolean("5.0 > intVar")
		// greaterEqual
		assertBoolean("5 >= 3")
		assertBoolean("5.0 >= 3")
		assertBoolean("5.0 >= intVar")
		// equal
		assertBoolean("5 == 3")
		assertBoolean("'string' == 'string'")
		assertBoolean("5.0 == 3")
		assertBoolean("true == boolVar")
		assertBoolean("true == boolEvent")
		// not equal
		assertBoolean("5 != 3")
		assertBoolean("'string' != 'string'")
		assertBoolean("5.0 != 3")
		assertBoolean("true != boolVar")
		assertBoolean("true != boolEvent")
	}

	@Test
	def void testLogicalRelationExpressionFailure() {
		// smaller
		expectIssue("3.0 < true", format(COMPARSION_OPERATOR, '<', 'real', 'boolean'))
		expectIssue("'string' < 5", format(COMPARSION_OPERATOR, '<', 'string', 'integer'))
		expectIssue("1.0 < false", format(COMPARSION_OPERATOR, '<', 'real', 'boolean'))
		expectIssue("1.0 < boolEvent", format(COMPARSION_OPERATOR, '<', 'real', 'boolean'))
		expectIssue("5 < intEvent", format(COMPARSION_OPERATOR, '<', 'integer', 'boolean'))
		// smallerEqual
		expectIssue("3.0 <= true", format(COMPARSION_OPERATOR, '<=', 'real', 'boolean'))
		expectIssue("'string' <= 5", format(COMPARSION_OPERATOR, '<=', 'string', 'integer'))
		expectIssue("1.0 <= false", format(COMPARSION_OPERATOR, '<=', 'real', 'boolean'))
		expectIssue("1.0 <= boolEvent", format(COMPARSION_OPERATOR, '<=', 'real', 'boolean'))
		expectIssue("5 <= intEvent", format(COMPARSION_OPERATOR, '<=', 'integer', 'boolean'))
		// greater
		expectIssue("3.0 > true", format(COMPARSION_OPERATOR, '>', 'real', 'boolean'))
		expectIssue("'string' > 5", format(COMPARSION_OPERATOR, '>', 'string', 'integer'))
		expectIssue("1.0 > false", format(COMPARSION_OPERATOR, '>', 'real', 'boolean'))
		expectIssue("5 > intEvent", format(COMPARSION_OPERATOR, '>', 'integer', 'boolean'))
		// greaterEqual
		expectIssue("3.0 >= true", format(COMPARSION_OPERATOR, '>=', 'real', 'boolean'))
		expectIssue("'string' >= 5", format(COMPARSION_OPERATOR, '>=', 'string', 'integer'))
		expectIssue("1.0 >= false", format(COMPARSION_OPERATOR, '>=', 'real', 'boolean'))
		expectIssue("5 >= intEvent", format(COMPARSION_OPERATOR, '>=', 'integer', 'boolean'))
		// equal
		expectIssue("3.0 == true", format(COMPARSION_OPERATOR, '==', 'real', 'boolean'))
		expectIssue("'string' == 5", format(COMPARSION_OPERATOR, '==', 'string', 'integer'))
		expectIssue("1.0 == false", format(COMPARSION_OPERATOR, '==', 'real', 'boolean'))
		expectIssue("5 == intEvent", format(COMPARSION_OPERATOR, '==', 'integer', 'boolean'))
		// not equal
		expectIssue("3.0 != true", format(COMPARSION_OPERATOR, '!=', 'real', 'boolean'))
		expectIssue("'string' != 5", format(COMPARSION_OPERATOR, '!=', 'string', 'integer'))
		expectIssue("1.0 != false", format(COMPARSION_OPERATOR, '!=', 'real', 'boolean'))
		expectIssue("intVar != 'string'", format(COMPARSION_OPERATOR, '!=', 'integer', 'string'))
		expectIssue("5 != intEvent", format(COMPARSION_OPERATOR, '!=', 'integer', 'boolean'))
	}

	@Test
	def void testAssignmentExpressionSuccess() {
		// assignment without operator
		// integer
		assertInteger("intVar = 5 * 3")
		assertInteger("intVar = 0x0F * 3")
		assertInteger("intVar = intVar * 0x0F")
		assertInteger("intVar = 0b01 * 3")
		assertInteger("intVar = intVar * 0b01111")
		// boolean
		assertBoolean("boolVar = true || false")
		assertBoolean("boolVar = boolEvent")
		// string
		assertString("stringVar = 'string'")
		// real
		assertReal("realVar = 2.0 - 7")
		// assignment with operator
		assertInteger("intVar += 2")
		assertInteger("intVar -= 7")
		assertInteger("intVar *= 25")
		assertInteger("intVar /= 2")
		assertInteger("intVar %= 5")
		// bitwise
		assertInteger("intVar &= 12")
		assertInteger("intVar |= 25")
		assertInteger("intVar ^=  6")
		assertInteger("intVar <<= 215")
		assertInteger("intVar >>= 215")
	}

	@Test
	def void testAssignmentExpressionFailure() {
		// integer and real
		expectIssue("intVar += 2.0", format(ASSIGNMENT_OPERATOR, '+=', 'integer', 'real'))
		expectIssue("intVar -= 2.0", format(ASSIGNMENT_OPERATOR, '-=', 'integer', 'real'))
		expectIssue("intVar /= 2.0", format(ASSIGNMENT_OPERATOR, '/=', 'integer', 'real'))
		expectIssue("intVar *= 2.0", format(ASSIGNMENT_OPERATOR, '*=', 'integer', 'real'))
		expectIssue("intVar = 2.0", format(ASSIGNMENT_OPERATOR, '=', 'integer', 'real'))
		// integer and boolean
		expectIssue("intVar = boolVar", format(ASSIGNMENT_OPERATOR, '=', 'integer', 'boolean'))
		expectIssue("intVar &= boolVar", format(ASSIGNMENT_OPERATOR, '&=', 'integer', 'boolean'))
		expectIssue("intVar |= boolVar", format(ASSIGNMENT_OPERATOR, '|=', 'integer', 'boolean'))
		expectIssue("intVar ^= boolVar", format(ASSIGNMENT_OPERATOR, '^=', 'integer', 'boolean'))
		expectIssue("intVar >>= boolVar", format(ASSIGNMENT_OPERATOR, '>>=', 'integer', 'boolean'))
		expectIssue("intVar <<= boolVar", format(ASSIGNMENT_OPERATOR, '<<=', 'integer', 'boolean'))
		// integer and string
		expectIssue("intVar &= 'string'", format(ASSIGNMENT_OPERATOR, '&=', 'integer', 'string'))
		expectIssue("intVar |= 'string'", format(ASSIGNMENT_OPERATOR, '|=', 'integer', 'string'))
		expectIssue("intVar ^= 'string'", format(ASSIGNMENT_OPERATOR, '^=', 'integer', 'string'))
		expectIssue("intVar >>= 'string'", format(ASSIGNMENT_OPERATOR, '>>=', 'integer', 'string'))
		expectIssue("intVar <<= 'string'", format(ASSIGNMENT_OPERATOR, '<<=', 'integer', 'string'))
	}

	// bitwise
	@Test
	def void testBitwiseXorExpressionSuccess() {
		assertInteger(" 5 ^ 3")
	}

	@Test
	def void testBitwiseXorExpressionFailure() {
		expectIssue("5 ^ true", format(BITWISE_OPERATORS, '^', 'integer', 'boolean'))
		expectIssue("5 ^ 1.0", format(BITWISE_OPERATORS, '^', 'integer', 'real'))
		expectIssue("5 ^ 'stringVar'", format(BITWISE_OPERATORS, '^', 'integer', 'string'))
	}

	@Test
	def void testBitwiseOrExpressionSuccess() {
		assertInteger(" 5 | 3")
	}

	@Test
	def void testBitwiseOrExpressionFailure() {
		expectIssue("5 | true", format(BITWISE_OPERATORS, '|', 'integer', 'boolean'))
		expectIssue("5 | 1.0", format(BITWISE_OPERATORS, '|', 'integer', 'real'))
		expectIssue("5 | 'stringVar'", format(BITWISE_OPERATORS, '|', 'integer', 'string'))
	}

	@Test
	def void testBitwiseAndExpressionSuccess() {
		assertInteger(" 5 & 3")
	}

	@Test
	def void testBitwiseAndExpressionFailure() {
		expectIssue("5 & true", format(BITWISE_OPERATORS, '&', 'integer', 'boolean'))
		expectIssue("5 & 1.0", format(BITWISE_OPERATORS, '&', 'integer', 'real'))
		expectIssue("5 & 'stringVar'", format(BITWISE_OPERATORS, '&', 'integer', 'string'))
	}

	@Test
	def void testShiftExpressionSuccess() {
		assertInteger("3 << 2")
		assertInteger("5 >> 2")
		assertInteger("intVar << 4")
		assertInteger("intVar >> 4")
	}

	@Test
	def void testShiftExpressionFailure() {
		expectIssue("5 << true", format(BITWISE_OPERATORS, '<<', 'integer', 'boolean'))
		expectIssue("5 << 7.0", format(BITWISE_OPERATORS, '<<', 'integer', 'real'))
		expectIssue("5 << stringVar", format(BITWISE_OPERATORS, '<<', 'integer', 'string'))
		expectIssue("5 >> true", format(BITWISE_OPERATORS, '>>', 'integer', 'boolean'))
		expectIssue("5 >> 7.0", format(BITWISE_OPERATORS, '>>', 'integer', 'real'))
		expectIssue("5 >> stringVar", format(BITWISE_OPERATORS, '>>', 'integer', 'string'))
	}

	@Test
	def void testPostfixIncrementDecrementSuccess() {
		assertInteger("intVar++")
		assertReal("realVar++")
		assertInteger("intVar--")
		assertReal("realVar--")
	}

	@Test
	def void testPostfixIncrementDecrementFailure() {
		expectIssue("boolVar++", format(INCOMPATIBLE_TYPES, 'boolean', 'real'))
		expectIssue("stringVar++", format(INCOMPATIBLE_TYPES, 'string', 'real'))
		expectIssue("boolVar--", format(INCOMPATIBLE_TYPES, 'boolean', 'real'))
		expectIssue("stringVar--", format(INCOMPATIBLE_TYPES, 'string', 'real'))
	}

	@Test
	def void testComplexExpressionsSuccess() {
		assertBoolean("((((3 * intVar) + 5) % 2) > 97) || false")
		assertBoolean("!true != boolVar && (3 > (realVar * 5 + 3))")
		assertInteger("3 * 3 + 7 / (3 * intVar % 8)")
	}

	@Test
	def void testOperationSuccess() {
		assertInteger("intVar = intOp()")
	}

	@Test
	def void testOperationFailure() {
		expectIssue("boolVar = intOp()", format(ASSIGNMENT_OPERATOR, '=', 'boolean', 'integer'))
	}

	@Test
	def void testParenthesizedExpression() {
		assertBoolean("( true || false )")
		assertInteger("( 5 )")
		assertReal("( 7.5 / 1.2 )")
		assertString("( 'abc' )")
	}

	@Test
	def void testTypeCastExpressionSuccess() {
		assertBoolean("( true as boolean)")
		assertInteger("( 7.5 as integer )")
		assertReal(" 7 as real ")
		assertString("( 'abc' as string )")
	}

	@Test
	def void testTypeCastExpressionFailure() {
		expectIssue("true as integer", format(CAST_OPERATORS, 'boolean', 'integer'))
		expectIssue("true as string", format(CAST_OPERATORS, 'boolean', 'string'))
		expectIssue("5 as string", format(CAST_OPERATORS, 'integer', 'string'))
		expectIssue("5.5 as string", format(CAST_OPERATORS, 'real', 'string'))
	}

	@Test
	def void testTernaryExpression() {
		assertInteger("(1 < 2) ? 4 : 5")
		assertBoolean("(true) ? false : true")
		expectIssue("(true) ? 4 : false", "Could not determine a common type for integer and boolean.")
	}
	
	//TBD: Introduce TypesTypeInferrer?
	//
//	@Test def void testParameterizedType() {
//		assertTrue(
//			assertBoolean(
//				inferTypeResultForExpression("t.prop1", "internal var t:ComplexParameterizedType<boolean, integer>").
//					getType()))
//		assertTrue(
//			assertInteger(
//				inferTypeResultForExpression("t.prop2", "internal var t:ComplexParameterizedType<boolean, integer>").
//					getType()))
//		assertTrue(
//			assertBoolean(
//				inferTypeResultForExpression("t.prop1.prop1",
//					"internal var t:ComplexParameterizedType<ComplexParameterizedType<boolean, integer>, integer>").
//					getType()))
//		expectNoIssues("b = t.op(true, 10)", "internal var t:ComplexParameterizedType<boolean, integer> var b:boolean")
//		expectErrors("b = t.op(true, 10.5)", "internal var t:ComplexParameterizedType<boolean, integer> var b:boolean",
//			ITypeSystemInferrer.NOT_COMPATIBLE_CODE, 1)
//		assertTrue(
//			assertBoolean(
//				inferTypeResultForExpression("b = t.op(true, 10)",
//					"internal var t:ComplexParameterizedType<integer> var b:boolean").getType()))
//		assertTrue(
//			isAnyType(inferTypeResultForExpression("t.prop1", "internal var t:ComplexParameterizedType<>").getType()))
//		assertTrue(
//			isAnyType(inferTypeResultForExpression("t.prop1", "internal var t:ComplexParameterizedType").getType()))
//		assertTrue(
//			assertInteger(
//				inferTypeResultForExpression("t.op(1, 2)", "internal var t:ComplexParameterizedType").getType()))
//		expectNoIssues("b = t.op2()", "internal: var t:ComplexParameterizedType<integer, boolean> var b: boolean")
//		assertTrue(
//			isAnyType(
//				inferTypeResultForExpression("t.prop1.prop1",
//					"internal var t:ComplexParameterizedType<ComplexParameterizedType<>, integer>").getType()))
//		expectNoIssues(
//			"t2 = t.prop3", '''internal var t:ComplexParameterizedType<boolean, integer> var t2:ComplexParameterizedType<integer, boolean>''')
//		expectErrors(
//			"t = t.prop3", '''internal var t:ComplexParameterizedType<boolean, integer> var t2:ComplexParameterizedType<integer, boolean>''',
//			ITypeSystemInferrer.NOT_SAME_CODE, 2)
//	}
//
//	@Test def void testOperationWithParameterizedType() {
//		var String scopes = '''internal var t1:ComplexParameterizedType<boolean, integer>var t2:ComplexParameterizedType<integer, boolean>operation op(p:ComplexParameterizedType<boolean, integer>) : void'''
//		expectNoIssues("op(t1)", scopes)
//		expectErrors("op(t2)", scopes, ITypeSystemInferrer.NOT_SAME_CODE, 2)
//	}
//
//	@Test def void testNullType() {
//		var String scope = "internal var cp:ComplexType var i:integer"
//		expectNoIssues("cp == null", scope)
//		expectNoIssues("null != cp", scope)
//		expectNoIssues("cp = null", scope)
//		expectIssue(inferTypeResult("null = cp", Expression.getSimpleName(), scope).getType(),
//			"Assignment operator '=' may only be applied on compatible types, not on null and ComplexType.")
//		expectIssue(inferTypeResult("i == null", Expression.getSimpleName(), scope).getType(),
//			"Comparison operator '==' may only be applied on compatible types, not on integer and null.")
//		expectIssue(inferTypeResult("i = null", Expression.getSimpleName(), scope).getType(),
//			"Assignment operator '=' may only be applied on compatible types, not on integer and null.")
//	}
//
//	/** 
//	 * Uses a model of the following function:
//	 * template <typename T>
//	 * T templateOp(T a, T b) {
//	 * return a > b ? a : b;
//	 * }
//	 */
//	@Test def void testOperationWithTypeParameters() {
//		var String scopes = '''internal var myI : integer var myF : real var myB: boolean var myCPT: ComplexParameterizedType<boolean, integer> var myCPT2: ComplexParameterizedType<integer, boolean> '''
//		expectNoIssues("myI = templateOp(myI, myI)", scopes)
//		assertTrue(assertInteger(inferTypeResultForExpression("myI = templateOp(myI, myI)", scopes).getType()))
//		expectNoIssues("myF = templateOp(3+5, 2.3)", scopes)
//		assertTrue(isRealType(inferTypeResultForExpression("myF = templateOp(3+5, 2.3)", scopes).getType()))
//		expectNoIssues("myCPT = templateOp(myCPT, myCPT)", scopes)
//		expectError("myB = templateOp(myI, myI)", scopes, ITypeSystemInferrer.NOT_COMPATIBLE_CODE)
//		expectError("myB = templateOp(3+5, boolean)", scopes, ITypeSystemInferrer.NOT_INFERRABLE_TYPE_PARAMETER_CODE)
//		expectErrors("myCPT2 = templateOp(myCPT, myCPT)", scopes, ITypeSystemInferrer.NOT_SAME_CODE, 2)
//		expectErrors("myCPT = templateOp(myCPT, myCPT2)", scopes, ITypeSystemInferrer.NOT_SAME_CODE, 2)
//	}
//
//	@Test def void testNestedGenericElementInferrer() {
//		var String scope = '''import nestedTemplate internal: var nestedCPT: ComplexParameterizedType<boolean, integer> var myI: integer var myB: boolean '''
//		expectError("myI = nestedOp(3)", scope, ITypeSystemInferrer.NOT_COMPATIBLE_CODE)
//		expectNoIssues("myI = nestedOp(nestedCPT)", scope)
//		expectError("myB = nestedOp(nestedCPT)", scope, ITypeSystemInferrer.NOT_COMPATIBLE_CODE)
//	}
//
//	@Test def void testNestedNestedGenericElementInferrer() {
//		var String scope = '''import nestedNestedTemplate internal: var nestedCPT: ComplexParameterizedType<ComplexParameterizedType<boolean, string>, integer> var myS: string var b: boolean '''
//		expectNoIssues("myS = nestedNestedOp(nestedCPT)", scope)
//		expectError("b = nestedNestedOp(nestedCPT)", scope, ITypeSystemInferrer.NOT_COMPATIBLE_CODE)
//	}
//
//	@Test def void testGenericFeatureCall() {
//		var String scope = '''internal: var cmo: ParameterizedMethodOwner var i: integer var r: real var b: boolean '''
//		expectNoIssues("i = cmo.genericOp(1, 2)", scope)
//		expectNoIssues("r = cmo.genericOp(1.3, 2)", scope)
//		expectNoIssues("r = cmo.genericOp(1, 2)", scope)
//		expectNoIssues("b = cmo.genericOp(true, 2)", scope)
//		expectNoIssues("b = cmo.genericOp(true, 2)", scope)
//		expectError("i = cmo.genericOp(1.3, 2)", scope, ITypeSystemInferrer.NOT_COMPATIBLE_CODE)
//		expectError("r = cmo.genericOp(false, 2)", scope, ITypeSystemInferrer.NOT_COMPATIBLE_CODE)
//		expectError("b = cmo.genericOp(1.3, 2)", scope, ITypeSystemInferrer.NOT_COMPATIBLE_CODE)
//	}
//
//	@Test def void testOperationOverloading() {
//		var String scopes = '''internal var b : boolean var i : integer var owner: ComplexTypeWithOverloadedOperations '''
//		expectNoIssues("i = owner.overloaded(1)", scopes)
//		assertTrue(assertInteger(inferTypeResultForExpression("i = owner.overloaded(1)", scopes).getType()))
//		expectNoIssues("b = owner.overloaded(true)", scopes)
//		assertTrue(assertBoolean(inferTypeResultForExpression("b = owner.overloaded(true)", scopes).getType()))
//	}
//
//	@Test
//	def void testOperationCall() {
//		expectNoIssues("opInt(1)")
//		expectNoIssues("opInt(vi)")
//		expectNoIssues("opInt(vsi)")
//		expectNoIssues("opReal(1.1)")
//		expectNoIssues("opReal(1)")
//		expectNoIssues("opReal(vr)")
//		expectNoIssues("opReal(vsr)")
//		expectNoIssues("opString(\"hello\")")
//		expectNoIssues("opString(vs)")
//		expectNoIssues("opString(vss)")
//		expectNoIssues("opBoolean(true)")
//		expectNoIssues("opBoolean(vb)")
//		expectNoIssues("opBoolean(vsb)")
//		expectIssue("opInt(1.1)", ITypeSystemInferrer.NOT_COMPATIBLE_CODE, 1)
//		expectIssue("opInt(vr)", ITypeSystemInferrer.NOT_COMPATIBLE_CODE, 1)
//		expectIssue("opInt(vsr)", ITypeSystemInferrer.NOT_COMPATIBLE_CODE, 1)
//		expectIssue("opSubInt(vi)", ITypeSystemInferrer.NOT_COMPATIBLE_CODE, 1)
//		expectIssue("opSubReal(vr)", ITypeSystemInferrer.NOT_COMPATIBLE_CODE, 1)
//		expectIssue("opSubBool(vb)", ITypeSystemInferrer.NOT_COMPATIBLE_CODE, 1)
//		expectIssue("opSubString(vs)", ITypeSystemInferrer.NOT_COMPATIBLE_CODE, 1) // TODO: actually one would expect these to work
//		expectNoIssues("opSubInt(1)");
//		expectNoIssues("opSubReal(1.1)");
//		expectNoIssues("opSubBool(true)");
//		expectNoIssues("opSubString(\"hello\")");
//	}
//
//	@Test
//	def void testOperationCallVarArgs() {
//		expectNoIssues("opInt(1)")
//		expectNoIssues("opInt(vi)")
//		expectNoIssues("opInt(vsi)")
//		expectNoIssues("opInt(1, vi, vsi)")
//		expectNoIssues("opReal(1.1)")
//		expectNoIssues("opReal(1)")
//		expectNoIssues("opReal(vr)")
//		expectNoIssues("opReal(vsr)")
//		expectNoIssues("opReal(1.1, 1, vr, vsr)")
//		expectNoIssues("opString(\"hello\")")
//		expectNoIssues("opString(vs)")
//		expectNoIssues("opString(vss)")
//		expectNoIssues("opString(\"hello\", vs, vss)")
//		expectNoIssues("opBoolean(true)")
//		expectNoIssues("opBoolean(vb)")
//		expectNoIssues("opBoolean(vsb)")
//		expectNoIssues("opBoolean(true, vb, vsb)")
////		expectErrors("opInt(1.1)", ITypeSystemInferrer.NOT_COMPATIBLE_CODE, 1)
////		expectErrors("opInt(vr)", ITypeSystemInferrer.NOT_COMPATIBLE_CODE, 1)
////		expectErrors("opInt(vsr)", ITypeSystemInferrer.NOT_COMPATIBLE_CODE, 1)
////		expectErrors("opInt(1.1, vr, vsr)", ITypeSystemInferrer.NOT_COMPATIBLE_CODE, 3)
////		expectErrors("opSubInt(vi, vi)", ITypeSystemInferrer.NOT_COMPATIBLE_CODE, 2)
////		expectErrors("opSubReal(vr, vr)", ITypeSystemInferrer.NOT_COMPATIBLE_CODE, 2)
////		expectErrors("opSubBool(vb, vb)", ITypeSystemInferrer.NOT_COMPATIBLE_CODE, 2)
////		expectErrors("opSubString(vs, vs)", ITypeSystemInferrer.NOT_COMPATIBLE_CODE, 2)
//	}
//
////	@Test
////	def void testOperationCallWithOptionalParameter() {
////		var OperationDefinition opDef = StextTestFactory._createOperation("opWithOptionals",
////			StextFactory.eINSTANCE.createInternalScope())
////		var Parameter pReq = typesFactory.createParameter("pReq", ITypeSystem.INTEGER, false)
////		var Parameter pOpt = typesFactory.createParameter("pOpt", ITypeSystem.INTEGER, true)
////		opDef.getParameters().add(pReq)
////		opDef.getParameters().add(pOpt)
////		var Argument boolArg = (parseExpression("true", Argument.getSimpleName()) as Argument)
////		var Argument intArg = (parseExpression("17", Argument.getSimpleName()) as Argument)
////		// opWithOptionals(17, 17) => valid
////		var ElementReferenceExpression opCall1 = StextTestFactory._createOperationCall(opDef, intArg, intArg)
////		expectNoIssues(opCall1)
////		// opWithOptionals(17) => valid, because of optional parameter
////		var ElementReferenceExpression opCall2 = StextTestFactory._createOperationCall(opDef, intArg)
////		expectNoIssues(opCall2)
////		// opWithOptionals(true) => invalid
////		var ElementReferenceExpression opCall3 = StextTestFactory._createOperationCall(opDef, boolArg)
////		expectError(opCall3, ITypeSystemInferrer.NOT_COMPATIBLE_CODE)
////	}
	

}
