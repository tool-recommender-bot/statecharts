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

import static org.junit.Assert.assertTrue;
import static org.yakindu.sct.model.sgraph.validation.FinalStateJavaValidator.ISSUE_FINAL_STATE_OUTGOING_TRANSITION;

import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.yakindu.sct.model.sgraph.FinalState;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.State;

@RunWith(XtextRunner.class)
@InjectWith(SGraphTestInjectorProvider.class)
public class FinalStateJavaValidationTest extends AbstractSGraphJavaValidationTest {
	/**
	 * A final state should have no outgoing transitions
	 */
	@Test
	public void finalStateWithOutgoingTransition() {
		statechart = factory.createStatechart();
		Region region = factory.createRegion();
		statechart.getRegions().add(region);
		FinalState finalState = factory.createFinalState();
		region.getVertices().add(finalState);
		State state = factory.createState();
		region.getVertices().add(state);

		createTransition(state, finalState);
		createTransition(finalState, state);

		validate(finalState);

		assertIssueCount(diagnostics, 1);
		assertWarning(diagnostics, ISSUE_FINAL_STATE_OUTGOING_TRANSITION);
	}

	/**
	 * A positive case for a valid final state.
	 */
	@Test
	public void finalStateValid() {
		statechart = factory.createStatechart();
		Region region = factory.createRegion();
		statechart.getRegions().add(region);
		FinalState finalState = factory.createFinalState();
		region.getVertices().add(finalState);
		State state = factory.createState();
		region.getVertices().add(state);
		createTransition(state, finalState);

		assertTrue(validate(finalState));
		assertIssueCount(diagnostics, 0);
	}
}
