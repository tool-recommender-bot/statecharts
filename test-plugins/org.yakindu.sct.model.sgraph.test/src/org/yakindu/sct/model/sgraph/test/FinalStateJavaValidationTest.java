package org.yakindu.sct.model.sgraph.test;

import static org.yakindu.sct.model.sgraph.validation.FinalStateJavaValidator.*;

import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.yakindu.sct.model.sgraph.FinalState;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.State;

@RunWith(XtextRunner.class)
@InjectWith(SGraphTestInjectorProvider.class)
public class FinalStateJavaValidationTest extends AbstractSGraphJavaValidationTest{
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

}
