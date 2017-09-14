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

import static org.junit.Assert.*;
import static org.yakindu.sct.model.sgraph.validation.EntryJavaValidator.*;
import static org.yakindu.sct.test.models.AbstractTestModelsUtil.VALIDATION_TESTMODEL_DIR;

import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.yakindu.base.base.NamedElement;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.EntryKind;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.test.models.AbstractTestModelsUtil;

@RunWith(XtextRunner.class)
@InjectWith(SGraphTestInjectorProvider.class)
public class EntryJavaValidationTest extends AbstractSGraphJavaValidationTest {

	/**
	 * An initial entry should have no incoming transition
	 */
	@Test
	public void initialEntryWithoutIncomingTransitions() {
		prepareStateTest();

		Entry entry = factory.createEntry();
		region.getVertices().add(entry);
		createTransition(state, entry);

		assertEquals(EntryKind.INITIAL, entry.getKind());
		validator.validate(entry, diagnostics, new HashMap<Object, Object>());
		assertWarning(diagnostics, ISSUE_INITIAL_ENTRY_WITH_IN_TRANS);
	}

	/**
	 * An initial entry should have an outgoing transition
	 */
	@Test
	public void initialEntryWithoutOutgoingTransition() {
		prepareStateTest();

		Entry entry = factory.createEntry();
		region.getVertices().add(entry);

		assertEquals(EntryKind.INITIAL, entry.getKind());
		validator.validate(entry, diagnostics, new HashMap<Object, Object>());
		assertWarning(diagnostics, ISSUE_INITIAL_ENTRY_WITHOUT_OUT_TRANS);
	}

	/**
	 * An entry should not have more than one outgoing transition
	 */
	@Test
	public void initialEntryWithMultipleOutgoingTransition() {
		prepareStateTest();

		Entry entry = factory.createEntry();
		region.getVertices().add(entry);
		createTransition(entry, state);
		createTransition(entry, state);

		assertEquals(EntryKind.INITIAL, entry.getKind());
		assertFalse(validator.validate(entry, diagnostics, new HashMap<Object, Object>()));
		assertError(diagnostics, ISSUE_ENTRY_WITH_MULTIPLE_OUT_TRANS);

		entry.setKind(EntryKind.SHALLOW_HISTORY);

		diagnostics = new BasicDiagnostic();
		assertFalse(validator.validate(entry, diagnostics, new HashMap<Object, Object>()));
		assertError(diagnostics, ISSUE_ENTRY_WITH_MULTIPLE_OUT_TRANS);

		entry.setKind(EntryKind.DEEP_HISTORY);

		diagnostics = new BasicDiagnostic();
		assertFalse(validator.validate(entry, diagnostics, new HashMap<Object, Object>()));
		assertError(diagnostics, ISSUE_ENTRY_WITH_MULTIPLE_OUT_TRANS);

	}

	@Test
	public void disallowTrigger() {
		prepareStateTest();

		Entry entry = factory.createEntry();
		region.getVertices().add(entry);
		Transition trans = createTransition(entry, state);
		trans.setTrigger(sTextFactory.createReactionTrigger());
		diagnostics = new BasicDiagnostic();
		assertFalse(validator.validate(entry, diagnostics, new HashMap<Object, Object>()));
		assertError(diagnostics, ISSUE_ENTRY_WITH_TRIGGER);
	}
	@Test
	public void regionCantBeEnteredUsingShallowHistory() {
		statechart = AbstractTestModelsUtil
				.loadStatechart(VALIDATION_TESTMODEL_DIR + "RegionCantBeEnteredUsingShallowHistory.sct");
		Iterator<EObject> iter = statechart.eAllContents();
		while (iter.hasNext()) {
			EObject element = iter.next();
			if (element instanceof Entry) {
				validator.validate(element, diagnostics, new HashMap<Object, Object>());
			}
		}

		assertIssueCount(diagnostics, 2);

		Diagnostic issue = issueByName(diagnostics,
				ISSUE_REGION_CANT_BE_ENTERED_USING_SHALLOW_HISTORY_NO_DEFAULT_ENTRY);
		assertTrue(issue.getSeverity() == Diagnostic.ERROR);
		assertEquals("r_a", ((NamedElement) issue.getData().get(0)).getName());

		issue = issueByName(diagnostics,
				ISSUE_REGION_CANT_BE_ENTERED_USING_SHALLOW_HISTORY_NON_CONNECTED_DEFAULT_ENTRY);
		assertTrue(issue.getSeverity() == Diagnostic.ERROR);
		assertEquals("r_c", ((NamedElement) issue.getData().get(0)).getName());
	}
}
