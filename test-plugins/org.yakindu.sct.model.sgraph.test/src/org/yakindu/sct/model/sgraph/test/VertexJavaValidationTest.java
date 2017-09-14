package org.yakindu.sct.model.sgraph.test;

import static org.junit.Assert.assertFalse;
import static org.yakindu.sct.model.sgraph.validation.VertexJavaValidator.*;

import java.util.HashMap;

import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.yakindu.sct.model.sgraph.Choice;
import org.yakindu.sct.model.sgraph.FinalState;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.State;

@RunWith(XtextRunner.class)
@InjectWith(SGraphTestInjectorProvider.class)
public class VertexJavaValidationTest extends AbstractSGraphJavaValidationTest {
	/**
	 * If an incoming transitions is part of an external transition path that
	 * only consists of pseudo states and only has state predecessors within the
	 * state then the state is not reachable and the validation must fail with
	 * an error.
	 */
	@Test
	public void vertexNotReachable_FailOnExternalPseudoPath() {
		prepareStateTest();

		Choice choice = factory.createChoice();
		region.getVertices().add(choice);

		createTransition(state, choice);
		createTransition(choice, state);

		validate(state);
		assertIssue(diagnostics, ISSUE_NODE_NOT_REACHABLE);
	}

	/**
	 * If an incoming transitions is part of an external transition path to an
	 * internal state that only consists of pseudo states and only has state
	 * predecessors within the state then the state is not reachable and the
	 * validation must fail with an error.
	 */
	@Test
	public void vertexNotReachable_FailOnExternalPseudoPathToSubstate() {
		prepareStateTest();

		Region subRegion = factory.createRegion();
		state.getRegions().add(subRegion);

		State stateA = factory.createState();
		subRegion.getVertices().add(stateA);

		Choice choice = factory.createChoice();
		region.getVertices().add(choice);

		createTransition(stateA, choice);
		createTransition(choice, stateA);

		validate(state);
		assertIssue(diagnostics, ISSUE_NODE_NOT_REACHABLE);
	}

	/**
	 * A state must be reachable.
	 */
	@Test
	public void vertexNotReachable() {
		prepareStateTest();

		assertFalse(validator.validate(state, diagnostics, new HashMap<Object, Object>()));
		assertError(diagnostics, ISSUE_NODE_NOT_REACHABLE);
	}

	/**
	 * A final state should have at least one incoming transition.
	 */
	@Test
	public void finalStateIsolated() {
		statechart = factory.createStatechart();
		Region region = factory.createRegion();
		statechart.getRegions().add(region);
		FinalState finalState = factory.createFinalState();
		region.getVertices().add(finalState);

		assertFalse(validate(finalState));

		assertIssueCount(diagnostics, 1);
		assertError(diagnostics, ISSUE_NODE_NOT_REACHABLE);
	}
}
