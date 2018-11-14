/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.base.expressions.test.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.yakindu.base.types.Expression;
import org.yakindu.base.types.Type;
import org.yakindu.base.types.inferrer.ITypeSystemInferrer;
import org.yakindu.base.types.inferrer.ITypeSystemInferrer.InferenceResult;
import org.yakindu.base.types.typesystem.ITypeSystem;
import org.yakindu.base.types.validation.IValidationIssueAcceptor.ListBasedValidationIssueAcceptor;

import com.google.inject.Inject;

import junit.framework.TestCase;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class TypeInferrerTester {

	@Inject
	protected ITypeSystem typeSystem;
	@Inject
	protected ITypeSystemInferrer inferrer;
	@Inject
	private DefaultExpressionParser expressionParser;

	private ListBasedValidationIssueAcceptor acceptor;

	public void assertInteger(String expression) {
		assertTrue(isType(inferType(expression), ITypeSystem.INTEGER));
	}

	public void assertReal(String expression) {
		assertTrue(isType(inferType(expression), ITypeSystem.REAL));
	}

	public void assertBoolean(String expression) {
		assertTrue(isType(inferType(expression), ITypeSystem.BOOLEAN));
	}

	public void assertString(String expression) {
		assertTrue(isType(inferType(expression), ITypeSystem.STRING));
	}

	protected boolean isType(Type type, String typeName) {
		return typeSystem.isSame(type, typeSystem.getType(typeName));
	}

	public Type inferType(String expression) {
		return inferType(expression, Expression.class.getSimpleName());
	}

	public Type inferType(String expression, String ruleName) {
		EObject parseResult = expressionParser.parseExpression(expression, Expression.class.getSimpleName());
		assertNotNull(parseResult);
		acceptor = new ListBasedValidationIssueAcceptor();
		InferenceResult result = inferrer.infer(parseResult, acceptor);
		if (result == null)
			return null;
		return result.getType();
	}

	public void expectIssue(String expression, String message) {
		@SuppressWarnings("unused")
		Type type = inferType(expression);
		if (acceptor
				.getTraces(org.yakindu.base.types.validation.IValidationIssueAcceptor.ValidationIssue.Severity.ERROR)
				.isEmpty()) {
			TestCase.fail("No issue detected.");
		}
		assertEquals(message, acceptor
				.getTraces(org.yakindu.base.types.validation.IValidationIssueAcceptor.ValidationIssue.Severity.ERROR)
				.iterator().next().getMessage());
	}

	public void expectNoIssues(String expression) {
		@SuppressWarnings("unused")
		Type type = inferType(expression);
		if (!acceptor
				.getTraces(org.yakindu.base.types.validation.IValidationIssueAcceptor.ValidationIssue.Severity.ERROR)
				.isEmpty()) {
			TestCase.fail("There are errors");
		}
	}
}
