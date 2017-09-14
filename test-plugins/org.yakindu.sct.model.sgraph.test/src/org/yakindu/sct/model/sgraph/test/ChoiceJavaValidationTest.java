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
import static org.yakindu.sct.model.sgraph.validation.ChoiceJavaValidator.ISSUE_CHOICE_WITHOUT_OUTGOING_TRANSITION;

import java.util.HashMap;

import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.yakindu.sct.model.sgraph.Choice;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.State;

@RunWith(XtextRunner.class)
@InjectWith(SGraphTestInjectorProvider.class)
public class ChoiceJavaValidationTest extends AbstractSGraphJavaValidationTest {
	/**
	 * A choice must have at least one outgoing transition
	 */
	@Test
	public void choiceWithoutOutgoingTransition() {
		statechart = factory.createStatechart();
		Region region = factory.createRegion();
		statechart.getRegions().add(region);
		Choice choice = factory.createChoice();
		region.getVertices().add(choice);
		State state = factory.createState();
		region.getVertices().add(state);

		createTransition(state, choice);

		assertFalse(validator.validate(choice, diagnostics, new HashMap<Object, Object>()));

		assertIssueCount(diagnostics, 1);
		assertError(diagnostics, ISSUE_CHOICE_WITHOUT_OUTGOING_TRANSITION);
	}

}
