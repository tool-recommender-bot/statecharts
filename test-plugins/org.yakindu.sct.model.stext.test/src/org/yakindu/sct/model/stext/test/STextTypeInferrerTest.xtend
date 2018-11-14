/** 
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.model.stext.test

import com.google.inject.Inject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.yakindu.base.expressions.test.utils.TypeInferrerTester
import org.yakindu.base.expressions.test.utils.TypesTestFactory
import org.yakindu.sct.model.stext.stext.EventRaisingExpression
import org.yakindu.sct.model.stext.stext.Guard
import org.yakindu.sct.model.stext.stext.TimeEventSpec
import org.yakindu.sct.model.stext.stext.VariableDefinition
import org.yakindu.sct.model.stext.test.util.AbstractSTextTest
import org.yakindu.sct.model.stext.test.util.STextInjectorProvider
import org.yakindu.sct.model.stext.test.util.STextTestScopeProvider

import static java.lang.String.*
import static org.junit.Assert.*
import static org.yakindu.base.expressions.inferrer.ExpressionsTypeInferrerMessages.*
import static org.yakindu.sct.model.stext.inferrer.STextTypeInferrer.*

/** 
 * @author andreas muelder - Initial contribution and API
 * @author axel terfloth - additional tests
 * @author Alexander Nyßen - Adopted to changes in type system
 */
@RunWith(XtextRunner)
@InjectWith(STextInjectorProvider)
class STextTypeInferrerTest extends AbstractSTextTest {

	@Inject
	protected extension TypesTestFactory
	@Inject extension TypeInferrerTester
	@Inject STextTestScopeProvider provider

	@Before
	def setupScope() {
		provider.context = #[
			createEvent("boolEvent", "boolean"),
			createEvent("intEvent", "integer"),
			createEvent("voidEvent", "void"),
			createEvent("realEvent", "real"),
			createEvent("stringEvent", "string"),
			createProperty("intVar", "integer"),
			createProperty("realVar", "real"),
			createProperty("boolVar", "boolean"),
			createProperty("stringVar", "string"),
			createOperation("intOp", "integer")
		]
	}

	@Test
	def void testValueOfExpressionSuccess() {
		assertInteger("valueof(intEvent)")
		assertBoolean("valueof(boolEvent)")
		assertReal("valueof(realEvent)")
		assertString("valueof(stringEvent)")
		assertVoid("valueof(voidEvent)")

		assertBoolean("boolEvent && valueof(boolEvent)")
		assertBoolean("boolEvent || valueof(boolEvent)")
		assertBoolean("!valueof(boolEvent)")
		assertBoolean("5.0 < valueof(intEvent)")
		assertBoolean("5.0 <= valueof(intEvent)")
		assertBoolean("5.0 > valueof(intEvent)")
		assertBoolean("5.0 >= valueof(intEvent)")
		assertBoolean("true == valueof(boolEvent)")
		assertBoolean("true != valueof(boolEvent)")
	}

	@Test
	def void testActiveStateReferenceExpressionSuccess() throws Exception {
		assertBoolean("active(chart.r1.A)")
		assertBoolean("!active(chart.r1.A)")
		assertBoolean("true || active(chart.r1.A)")
		assertBoolean("active(chart.r1.A) && false")
		assertBoolean("boolVar = active(chart.r1.A)")
	}

	@Test def void testActiveStateReferenceExpressionFailure() throws Exception {
		expectIssue("active(chart.r1.A) + 1", format(ARITHMETIC_OPERATORS, '+', 'boolean', 'integer'))
		expectIssue("active(chart.r1.A) - 1", format(ARITHMETIC_OPERATORS, '-', 'boolean', 'integer'))
		expectIssue("active(chart.r1.A) * 1", format(ARITHMETIC_OPERATORS, '*', 'boolean', 'integer'))
		expectIssue("active(chart.r1.A) / 1", format(ARITHMETIC_OPERATORS, '/', 'boolean', 'integer'))
		expectIssue("active(chart.r1.A) % true", format(ARITHMETIC_OPERATORS, '%', 'boolean', 'boolean'))
		expectIssue("active(chart.r1.A) && intVar", format(LOGICAL_OPERATORS, '&&', 'boolean', 'integer'))
		expectIssue("active(chart.r1.A) || stringVar", format(LOGICAL_OPERATORS, '||', 'boolean', 'string'))
	}

	@Test
	def void testEventRaisingExpressionSuccess() {
		assertTrue(isType(inferType("raise intEvent : 42", EventRaisingExpression.getSimpleName()), "integer"))
		assertTrue(isType(inferType("raise boolEvent : boolVar", EventRaisingExpression.getSimpleName()), "boolean"))
		assertTrue(isType(inferType("raise realEvent : 2.0 - 3.0", EventRaisingExpression.getSimpleName()), "real"))
		assertTrue(isType(inferType("raise stringEvent : 'string'", EventRaisingExpression.getSimpleName()), "string"))
		assertTrue(isType(inferType("raise voidEvent", EventRaisingExpression.getSimpleName()), "void"))
	}

	@Test
	def void testEventRaisingExpressionFailure() {
		expectIssue(inferType("raise intEvent : true", EventRaisingExpression.getSimpleName()),
			format(EVENT_DEFINITION, 'boolean', 'integer'))
		expectIssue(inferType("raise intEvent : boolVar", EventRaisingExpression.getSimpleName()),
			format(EVENT_DEFINITION, 'boolean', 'integer'))
		expectIssue(inferType("raise stringEvent", EventRaisingExpression.getSimpleName()),
			format(MISSING_VALUE, 'string'))
	}

	@Test
	def void testEventIsRaisedSuccess() {
		assertBoolean("boolVar = intEvent")
	}

	@Test
	def void testEventIsRaisedFailure() {
		expectIssue("intVar = intEvent", format(ASSIGNMENT_OPERATOR, '=', 'integer', 'boolean'))
		expectIssue("realVar = intEvent", format(ASSIGNMENT_OPERATOR, '=', 'real', 'boolean'))
		expectIssue("stringVar = intEvent", format(ASSIGNMENT_OPERATOR, '=', 'string', 'boolean'))
		expectIssue("intVar = (intEvent * 3)", format(ARITHMETIC_OPERATORS, '*', 'boolean', 'integer'))
	}

	@Test
	def void testVariableDefinitionSuccess() {
		assertTrue(isType(inferType("var boolVar : boolean = !true", VariableDefinition.getSimpleName()), "boolean"))
		assertTrue(isType(inferType("var intVar : integer = 5", VariableDefinition.getSimpleName()), "integer"))
		assertTrue(isType(inferType("var realVar : real = 0.5", VariableDefinition.getSimpleName()), "real"))
		assertTrue(isType(inferType("var realVar : real = 5", VariableDefinition.getSimpleName()), "real"))
		assertTrue(isType(inferType("var stringVar : string = 'test'", VariableDefinition.getSimpleName()), "string"))
	}

	@Test
	def void testVariableDefinitionFailure() {
		expectIssue(inferType("var boolVar : boolean = 5", VariableDefinition.getSimpleName()),
			format(PROPERTY_INITIAL_VALUE, 'integer', "boolean"))
		expectIssue(inferType("var boolVar : boolean = 0.5", VariableDefinition.getSimpleName()),
			format(PROPERTY_INITIAL_VALUE, 'real', "boolean"))
		expectIssue(inferType("var boolVar : boolean = 'text'", VariableDefinition.getSimpleName()),
			format(PROPERTY_INITIAL_VALUE, 'string', "boolean"))
		expectIssue(inferType("var intVar : integer = true", VariableDefinition.getSimpleName()),
			format(PROPERTY_INITIAL_VALUE, 'boolean', "integer"))
		expectIssue(inferType("var intVar : integer = 0.5", VariableDefinition.getSimpleName()),
			format(PROPERTY_INITIAL_VALUE, 'real', "integer"))
		expectIssue(inferType("var intVar : integer = 'text'", VariableDefinition.getSimpleName()),
			format(PROPERTY_INITIAL_VALUE, 'string', "integer"))
		expectIssue(inferType("var realVar : real = true", VariableDefinition.getSimpleName()),
			format(PROPERTY_INITIAL_VALUE, 'boolean', "real"))
		expectIssue(inferType("var realVar : real = 'text'", VariableDefinition.getSimpleName()),
			format(PROPERTY_INITIAL_VALUE, 'string', "real"))
		expectIssue(inferType("var stringVar : string = true", VariableDefinition.getSimpleName()),
			format(PROPERTY_INITIAL_VALUE, 'boolean', "string"))
		expectIssue(inferType("var stringVar : string = 5", VariableDefinition.getSimpleName()),
			format(PROPERTY_INITIAL_VALUE, 'integer', "string"))
		expectIssue(inferType("var stringVar : string = 0.5", VariableDefinition.getSimpleName()),
			format(PROPERTY_INITIAL_VALUE, 'real', "string"))
	}

	@Test
	def void testGuardSuccess() {
		expectNoIssues(inferType("true", Guard.getSimpleName()))
		expectNoIssues(inferType("(3 *3) > 3", Guard.getSimpleName()))
		expectNoIssues(inferType("intEvent", Guard.getSimpleName()))
	}

	@Test
	def void testGuardFailure() {
		expectIssue(inferType("5", Guard.getSimpleName()), GUARD)
		expectIssue(inferType("3 * 3", Guard.getSimpleName()), GUARD)
		expectIssue(inferType("intVar", Guard.getSimpleName()), GUARD)
	}

	@Test
	def void testTimeSpecSuccess() {
		expectNoIssues(inferType("after 5 s", TimeEventSpec.getSimpleName()))
		expectNoIssues(inferType("after 3 * 3 ms", TimeEventSpec.getSimpleName()))
		expectNoIssues(inferType("every intVar ms", TimeEventSpec.getSimpleName()))
	}

	@Test
	def void testTimeSpecFailure() {
		expectIssue(inferType("after boolVar ms", TimeEventSpec.getSimpleName()), TIME_SPEC)
		expectIssue(inferType("after true s", TimeEventSpec.getSimpleName()), TIME_SPEC)
		expectIssue(inferType("after true || false s", TimeEventSpec.getSimpleName()), TIME_SPEC)
	}
}
