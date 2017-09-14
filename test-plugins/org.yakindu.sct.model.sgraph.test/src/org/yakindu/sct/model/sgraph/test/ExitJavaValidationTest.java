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
import static org.yakindu.sct.model.sgraph.validation.ExitJavaValidator.*;

import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.yakindu.sct.model.sgraph.Exit;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Transition;

@RunWith(XtextRunner.class)
@InjectWith(SGraphTestInjectorProvider.class)
public class ExitJavaValidationTest extends AbstractSGraphJavaValidationTest {

	/**
	 * An exit node should have at leat one incoming transition.
	 */
	@Test
	public void exitWithoutIncomingTransition() {
		prepareStateTest();

		Region subRegion = factory.createRegion();
		state.getRegions().add(subRegion);
		Exit exit = factory.createExit();
		subRegion.getVertices().add(exit);

		assertFalse(validate(exit));

		assertWarning(diagnostics, ISSUE_EXIT_WITHOUT_IN_TRANS);
	}

	/**
	 * An exit node must have no outgoing transitions.
	 */
	@Test
	public void exitWithOutgoingTransition() {
		prepareStateTest();

		Region subRegion = factory.createRegion();
		state.getRegions().add(subRegion);
		Exit exit = factory.createExit();
		subRegion.getVertices().add(exit);

		State s = factory.createState();
		subRegion.getVertices().add(s);

		Transition t = factory.createTransition();
		t.setSource(exit);
		t.setTarget(s);

		assertFalse(validate(exit));

		assertError(diagnostics, ISSUE_EXIT_WITH_OUT_TRANS);
	}

	/**
	 * An exit node must not be used in top level regions.
	 */
	@Test
	public void exitOnStatechart() {
		prepareStateTest();

		Exit exit = factory.createExit();
		region.getVertices().add(exit);

		assertFalse(validate(exit));

		assertError(diagnostics, ISSUE_EXIT_ON_STATECHART);
	}
	
	/**
	 * Tests a scenario where no issues for an exit nodes exists.
	 */
	@Test
	public void cleanExit() {
		prepareStateTest();

		Region subRegion = factory.createRegion();
		state.getRegions().add(subRegion);
		Exit exit = factory.createExit();
		subRegion.getVertices().add(exit);

		State s = factory.createState();
		subRegion.getVertices().add(s);

		Transition t = factory.createTransition();
		t.setTarget(exit);
		t.setSource(s);

		assertTrue(validate(exit));
		assertNoIssues(diagnostics);
	}
}
