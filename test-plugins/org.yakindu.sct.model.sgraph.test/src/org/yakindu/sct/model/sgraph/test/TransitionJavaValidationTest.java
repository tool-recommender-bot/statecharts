package org.yakindu.sct.model.sgraph.test;

import static org.junit.Assert.assertFalse;
import static org.yakindu.sct.model.sgraph.util.SGgraphUtil.firstNamed;
import static org.yakindu.sct.model.sgraph.validation.TransitionJavaValidator.*;
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
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.test.models.AbstractTestModelsUtil;

@RunWith(XtextRunner.class)
@InjectWith(SGraphTestInjectorProvider.class)
public class TransitionJavaValidationTest extends AbstractSGraphJavaValidationTest {

	@Test
	public void orthogonalTransition_BetweenTopLevelRegions() {
		statechart = loadStatechart("OrthogonalTransition.sct");

		State state = firstNamed(EcoreUtil2.eAllOfType(statechart, State.class), "A");
		Transition trans = state.getOutgoingTransitions().get(0);

		assertFalse(validator.validate(trans, diagnostics, new HashMap<Object, Object>()));
		assertIssueCount(diagnostics, 1);
		assertError(diagnostics, ISSUE_TRANSITION_ORTHOGONAL);
	}

	@Test
	public void orthogonalTransition_BetweenStateRegions() {
		statechart = loadStatechart("OrthogonalTransition.sct");

		State state = firstNamed(EcoreUtil2.eAllOfType(statechart, State.class), "B1");
		Transition trans = state.getOutgoingTransitions().get(0);

		assertFalse(validator.validate(trans, diagnostics, new HashMap<Object, Object>()));
		assertIssueCount(diagnostics, 1);
		assertError(diagnostics, ISSUE_TRANSITION_ORTHOGONAL);
	}

	@Test
	public void initialEntryWithTransitionToContainer() {
		statechart = AbstractTestModelsUtil
				.loadStatechart(VALIDATION_TESTMODEL_DIR + "EntryTransitionToParentState.sct");
		Iterator<EObject> iter = statechart.eAllContents();
		while (iter.hasNext()) {
			EObject element = iter.next();
			if (element instanceof Transition) {
				validator.validate(element, diagnostics, new HashMap<Object, Object>());
			}
		}

		assertIssueCount(diagnostics, 1);
		assertError(diagnostics, ISSUE_INITIAL_ENTRY_WITH_TRANSITION_TO_CONTAINER);
	}

}
