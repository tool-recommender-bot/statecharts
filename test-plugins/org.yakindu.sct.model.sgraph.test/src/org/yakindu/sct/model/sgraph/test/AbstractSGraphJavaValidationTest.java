package org.yakindu.sct.model.sgraph.test;

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
import static org.junit.Assert.*;
import static org.yakindu.sct.test.models.AbstractTestModelsUtil.VALIDATION_TESTMODEL_DIR;

import java.util.HashMap;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.junit.Before;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.Vertex;
import org.yakindu.sct.model.sgraph.validation.SGraphJavaValidator;
import org.yakindu.sct.model.stext.stext.StextFactory;
import org.yakindu.sct.test.models.AbstractTestModelsUtil;

import com.google.inject.Inject;

public abstract class AbstractSGraphJavaValidationTest {
	protected BasicDiagnostic diagnostics;

	protected Statechart statechart;
	protected Region region;
	protected State state;
	protected SGraphFactory factory;
	protected StextFactory sTextFactory;

	@Inject
	protected SGraphJavaValidator validator;

	@Before
	public void setUp() throws Exception {
		diagnostics = new BasicDiagnostic();
		factory = SGraphFactory.eINSTANCE;
		sTextFactory = StextFactory.eINSTANCE;
		statechart = factory.createStatechart();
		statechart.setName("SC");
	}

	protected void prepareStateTest() {
		region = factory.createRegion();
		statechart.getRegions().add(region);
		state = factory.createState();
		state.setName(getClass().getSimpleName());
		region.getVertices().add(state);
	}

	protected Transition createTransition(Vertex source, Vertex target) {
		Transition trans = factory.createTransition();
		trans.setSource(source);
		trans.setTarget(target);
		source.getOutgoingTransitions().add(trans);
		target.getIncomingTransitions().add(trans);
		return trans;
	}

	protected void assertError(BasicDiagnostic diag, String message) {
		Diagnostic d = issueByName(diag, message);
		assertNotNull("Issue '" + message + "' does not exist.", issueByName(diag, message));
		assertEquals("Issue '" + message + "' is no error.", Diagnostic.ERROR, d.getSeverity());
	}

	protected void assertWarning(BasicDiagnostic diag, String message) {
		Diagnostic d = issueByName(diag, message);
		assertNotNull("Issue '" + message + "' does not exist.", issueByName(diag, message));
		assertEquals("Issue '" + message + "' is no warning.", Diagnostic.WARNING, d.getSeverity());
	}

	protected Diagnostic issueByName(BasicDiagnostic diag, String message) {
		for (Diagnostic issue : diag.getChildren()) {
			if (message.equals(issue.getMessage()))
				return issue;
		}

		return null;
	}

	protected void assertIssueCount(BasicDiagnostic diag, int count) {
		int c = diagnostics.getChildren().size();
		assertEquals("expected " + count + " issue(s) but were " + c + " [" + diag.toString() + "]", count, c);
	}

	protected boolean validate(EObject obj) {
		return validator.validate(obj, diagnostics, new HashMap<Object, Object>());
	}

	protected Statechart loadStatechart(String modelName) {
		return AbstractTestModelsUtil.loadStatechart(VALIDATION_TESTMODEL_DIR + modelName);
	}

	protected void assertIssue(BasicDiagnostic diag, String message) {
		assertNotNull("Issue '" + message + "' does not exist.", issueByName(diag, message));
	}

	protected void assertNoIssue(BasicDiagnostic diag, String message) {
		assertNull("Issue '" + message + "' does exist.", issueByName(diag, message));
	}

	protected void assertNoIssues(BasicDiagnostic diag) {
		assertIssueCount(diag, 0);
	}
}
