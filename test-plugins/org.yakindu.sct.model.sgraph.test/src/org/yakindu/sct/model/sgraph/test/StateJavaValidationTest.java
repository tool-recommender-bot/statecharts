package org.yakindu.sct.model.sgraph.test;

import static org.junit.Assert.assertFalse;
import static org.yakindu.sct.model.sgraph.validation.StateJavaValidator.*;

import java.util.HashMap;

import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(SGraphTestInjectorProvider.class)
public class StateJavaValidationTest extends AbstractSGraphJavaValidationTest {
	/**
	 * A regular state must have a name.
	 */
	@Test
	public void stateWithoutName() {
		prepareStateTest();

		state.setName(null);
		assertFalse(validator.validate(state, diagnostics, new HashMap<Object, Object>()));
		assertError(diagnostics, ISSUE_STATE_WITHOUT_NAME);
	}

	/**
	 * A states name must not be empty.
	 */
	@Test
	public void nameIsNotEmpty() {
		prepareStateTest();

		state.setName("");
		assertFalse(validator.validate(state, diagnostics, new HashMap<Object, Object>()));
		assertError(diagnostics, ISSUE_STATE_WITHOUT_NAME);
	}

	/**
	 * A state name with just white spaces is not valid.
	 */
	@Test
	public void stateWithWhitespaceName() {
		prepareStateTest();

		state.setName(" 	");
		assertFalse(validator.validate(state, diagnostics, new HashMap<Object, Object>()));
		assertError(diagnostics, ISSUE_STATE_WITHOUT_NAME);
	}
}
