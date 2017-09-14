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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.yakindu.sct.model.sgraph.util.SGgraphUtil.firstNamed;
import static org.yakindu.sct.model.sgraph.validation.SynchronizationJavaValidator.*;
import static org.yakindu.sct.test.models.AbstractTestModelsUtil.VALIDATION_TESTMODEL_DIR;

import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Synchronization;
import org.yakindu.sct.test.models.AbstractTestModelsUtil;

@RunWith(XtextRunner.class)
@InjectWith(SGraphTestInjectorProvider.class)
public class SynchronizationJavaValidatorTest extends AbstractSGraphJavaValidationTest {

	@Test
	public void synchronizationTransitionCount() {
		statechart = AbstractTestModelsUtil
				.loadStatechart(VALIDATION_TESTMODEL_DIR + "SynchronizationTransitionCount.sct");
		Iterator<EObject> iter = statechart.eAllContents();
		while (iter.hasNext()) {
			EObject element = iter.next();
			if (element instanceof Synchronization) {
				assertTrue(validator.validate(element, diagnostics, new HashMap<Object, Object>()));
			}
		}

		assertIssueCount(diagnostics, 2);
		assertWarning(diagnostics, ISSUE_SYNCHRONIZATION_TRANSITION_COUNT);
	}
	@Test
	public void orthogonalSourceStates_StateInParentStateRegion() {
		statechart = loadStatechart("NotOrthogonalRegion01.sct");

		State b = firstNamed(EcoreUtil2.eAllOfType(statechart, State.class), "AA");
		Synchronization sync = (Synchronization) b.getOutgoingTransitions().get(0).getTarget();

		assertFalse(validator.validate(sync, diagnostics, new HashMap<Object, Object>()));
		assertIssueCount(diagnostics, 1);
		assertError(diagnostics, ISSUE_SYNCHRONIZATION_SOURCE_STATES_NOT_ORTHOGONAL);
	}

	@Test
	public void orthogonalSourceStates_StateInTopLevelRegion() {
		statechart = loadStatechart("NotOrthogonalRegion02.sct");

		State b = firstNamed(EcoreUtil2.eAllOfType(statechart, State.class), "AA");
		Synchronization sync = (Synchronization) b.getOutgoingTransitions().get(0).getTarget();

		assertFalse(validator.validate(sync, diagnostics, new HashMap<Object, Object>()));
		assertIssueCount(diagnostics, 1);
		assertError(diagnostics, ISSUE_SYNCHRONIZATION_SOURCE_STATES_NOT_ORTHOGONAL);
	}

	@Test
	public void orthogonalTargetStates_StateInParentStateRegion() {
		statechart = loadStatechart("NotOrthogonalRegion01.sct");

		State b = firstNamed(EcoreUtil2.eAllOfType(statechart, State.class), "B");
		Synchronization sync = (Synchronization) b.getOutgoingTransitions().get(0).getTarget();

		assertFalse(validator.validate(sync, diagnostics, new HashMap<Object, Object>()));
		assertIssueCount(diagnostics, 1);
		assertError(diagnostics, ISSUE_SYNCHRONIZATION_TARGET_STATES_NOT_ORTHOGONAL);
	}

	@Test
	public void orthogonalTargetStates_StateInTopLevelRegion() {
		statechart = loadStatechart("NotOrthogonalRegion02.sct");

		State b = firstNamed(EcoreUtil2.eAllOfType(statechart, State.class), "B");
		Synchronization sync = (Synchronization) b.getOutgoingTransitions().get(0).getTarget();

		assertFalse(validator.validate(sync, diagnostics, new HashMap<Object, Object>()));
		assertIssueCount(diagnostics, 1);
		assertError(diagnostics, ISSUE_SYNCHRONIZATION_TARGET_STATES_NOT_ORTHOGONAL);
	}

	@Test
	public void orthogonalSynchronizedTransition() {
		statechart = loadStatechart("NotOrthogonalRegion03.sct");

		State stateB = firstNamed(EcoreUtil2.eAllOfType(statechart, State.class), "B");
		Synchronization sync = (Synchronization) stateB.getOutgoingTransitions().get(0).getTarget();

		assertFalse(validator.validate(sync, diagnostics, new HashMap<Object, Object>()));
		assertIssueCount(diagnostics, 1);
		assertError(diagnostics, ISSUE_SYNCHRONIZATION_TARGET_STATES_NOT_WITHIN_SAME_PARENTSTATE);
	}

	@Test
	public void orthogonalSynchronizedTransition_Source() {
		statechart = loadStatechart("NotOrthogonalRegion03.sct");

		State stateC = firstNamed(EcoreUtil2.eAllOfType(statechart, State.class), "C");
		Synchronization sync = (Synchronization) stateC.getOutgoingTransitions().get(0).getTarget();

		assertFalse(validator.validate(sync, diagnostics, new HashMap<Object, Object>()));
		assertIssueCount(diagnostics, 1);
		assertError(diagnostics, ISSUE_SYNCHRONIZATION_SOURCE_STATES_NOT_WITHIN_SAME_PARENTSTATE);
	}

	@Test
	public void syncLocation_Issue58() {
		statechart = loadStatechart("SyncLocation_Issue58.sct");

		State state = firstNamed(EcoreUtil2.eAllOfType(statechart, State.class), "AA");
		Synchronization sync = (Synchronization) state.getOutgoingTransitions().get(0).getTarget();

		assertTrue(validator.validate(sync, diagnostics, new HashMap<Object, Object>()));
		assertNoIssues(diagnostics);
	}
}
