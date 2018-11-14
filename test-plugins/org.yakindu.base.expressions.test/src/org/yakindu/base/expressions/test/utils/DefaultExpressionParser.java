/**
 * Copyright (c) 2015 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.base.expressions.test.utils;

import java.io.StringReader;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.XtextFactory;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.linking.impl.Linker;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.impl.ListBasedDiagnosticConsumer;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class DefaultExpressionParser {

	@Inject
	private IParser parser;
	@Inject
	private Linker linker;
	@Inject
	private Provider<XtextResource> xtextResourceProvider;

	public EObject parseExpression(String expression, String ruleName) {
		XtextResource resource = xtextResourceProvider.get();
		resource.setURI(URI.createURI("test", true));
		ParserRule parserRule = XtextFactory.eINSTANCE.createParserRule();
		parserRule.setName(ruleName);
		IParseResult result = parser.parse(parserRule, new StringReader(expression));
		EObject rootASTElement = result.getRootASTElement();
		resource.getContents().add(rootASTElement);
		ListBasedDiagnosticConsumer diagnosticsConsumer = new ListBasedDiagnosticConsumer();
		linker.linkModel(rootASTElement, diagnosticsConsumer);
		EcoreUtil.resolveAll(resource);
		if (resource.getErrors().size() > 0) {
			throw new RuntimeException(resource.getErrors().toString());
		}
		if (result.hasSyntaxErrors()) {
			throw new RuntimeException(
					"Syntax errors: " + result.getSyntaxErrors().iterator().next().getSyntaxErrorMessage());
		}
		if (diagnosticsConsumer.hasConsumedDiagnostics(Severity.ERROR)) {
			throw new RuntimeException("Error during linking: " + diagnosticsConsumer.getResult(Severity.ERROR));
		}
		return rootASTElement;
	}
}
