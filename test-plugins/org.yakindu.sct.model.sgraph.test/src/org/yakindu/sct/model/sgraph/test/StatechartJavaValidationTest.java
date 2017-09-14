/**
 * Copyright (c) 2012-2017 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.model.sgraph.test;

import static org.yakindu.sct.model.sgraph.validation.StatechartJavaValidator.ISSUE_STATECHART_NAME_NO_IDENTIFIER;

import java.util.HashMap;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.Statechart;

@RunWith(XtextRunner.class)
@InjectWith(SGraphTestInjectorProvider.class)
public class StatechartJavaValidationTest extends AbstractSGraphJavaValidationTest {
	@Test
	public void checkStatechartNameIsIdentifier() {
		Statechart statechart = SGraphFactory.eINSTANCE.createStatechart();
		statechart.setName("Not a valid identifier");
		validator.validate(statechart, diagnostics, new HashMap<Object, Object>());
		assertIssueCount(diagnostics, 1);
		assertError(diagnostics, String.format(ISSUE_STATECHART_NAME_NO_IDENTIFIER, statechart.getName()));

		diagnostics = new BasicDiagnostic();
		statechart.setName("0Notavalididentifier");
		validator.validate(statechart, diagnostics, new HashMap<Object, Object>());
		assertIssueCount(diagnostics, 1);
		assertError(diagnostics, String.format(ISSUE_STATECHART_NAME_NO_IDENTIFIER, statechart.getName()));

		diagnostics = new BasicDiagnostic();
		statechart.setName("ValidIdentifier");
		validator.validate(statechart, diagnostics, new HashMap<Object, Object>());
		assertIssueCount(diagnostics, 0);
	}
}
