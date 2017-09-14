/**
 * Copyright (c) 2012 committers of YAKINDU and others.
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
import static org.yakindu.sct.model.sgraph.util.SGgraphUtil.firstNamed;
import static org.yakindu.sct.model.sgraph.validation.SGraphJavaValidator.*;
import static org.yakindu.sct.test.models.AbstractTestModelsUtil.VALIDATION_TESTMODEL_DIR;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.validation.Check;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.yakindu.base.base.NamedElement;
import org.yakindu.sct.model.sgraph.Choice;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.EntryKind;
import org.yakindu.sct.model.sgraph.Exit;
import org.yakindu.sct.model.sgraph.FinalState;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Synchronization;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.Vertex;
import org.yakindu.sct.model.sgraph.validation.SGraphJavaValidator;
import org.yakindu.sct.model.stext.stext.StextFactory;
import org.yakindu.sct.model.stext.validation.STextJavaValidator;
import org.yakindu.sct.test.models.AbstractTestModelsUtil;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * Test of all validation rules that test very basic properties of statecharts.
 * 
 * @author terfloth
 * @author muelder - additions
 * @author antony -additions
 */
@RunWith(XtextRunner.class)
@InjectWith(SGraphTestInjectorProvider.class)
public class SGraphJavaValidationTest extends AbstractSGraphJavaValidationTest {

	static {
		// set up EMF - the EPackage.Registry requires a context class loader
		// ...
		if (Thread.currentThread().getContextClassLoader() == null) {
			Thread.currentThread().setContextClassLoader(SGraphJavaValidationTest.class.getClassLoader());
		}
		SGraphPackage.eINSTANCE.eClass();
	}

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
	 * A transition to a sub entry is considered implies reachability.
	 */
	@Test
	public void vertexNotReachable_AcceptThroughSubstate() {
		prepareStateTest();

		State stateA = factory.createState();

		Region subRegion = factory.createRegion();
		state.getRegions().add(subRegion);

		State stateC = factory.createState();
		subRegion.getVertices().add(stateC);

		Transition t1 = factory.createTransition();
		t1.setSource(stateA);
		t1.setTarget(stateC);

		validate(state);
		assertNoIssues(diagnostics);
	}

	/**
	 * A transition to a sub entry is considered implies reachability.
	 */
	@Test
	public void vertexNotReachable_AcceptThroughSubentry() {
		prepareStateTest();

		State stateA = factory.createState();

		Region subRegion = factory.createRegion();
		state.getRegions().add(subRegion);

		State stateC = factory.createState();
		subRegion.getVertices().add(stateC);

		Entry entry = factory.createEntry();
		subRegion.getVertices().add(entry);

		Transition t1 = factory.createTransition();
		t1.setSource(stateA);
		t1.setTarget(entry);

		Transition t2 = factory.createTransition();
		t2.setSource(entry);
		t2.setTarget(stateC);

		validate(state);
		assertNoIssues(diagnostics);
	}

	/**
	 * A transition to a sub choice is considered implies reachability.
	 */
	@Test
	public void vertexNotReachable_AcceptThroughSubchoice() {
		prepareStateTest();

		State stateA = factory.createState();

		Region subRegion = factory.createRegion();
		state.getRegions().add(subRegion);

		State stateC = factory.createState();
		subRegion.getVertices().add(stateC);

		Choice choice = factory.createChoice();
		subRegion.getVertices().add(choice);

		Transition t1 = factory.createTransition();
		t1.setSource(stateA);
		t1.setTarget(choice);

		Transition t2 = factory.createTransition();
		t2.setSource(choice);
		t2.setTarget(stateC);

		validate(state);
		assertNoIssues(diagnostics);
	}

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
	 * A regular state may be a dead end.
	 */
	@Test
	public void stateDeadEnd() {
		prepareStateTest();

		validator.validate(state, diagnostics, new HashMap<Object, Object>());
		assertNoIssue(diagnostics, ISSUE_STATE_WITHOUT_OUTGOING_TRANSITION);
	}

	/**
	 * A valid regular state must produce no issues.
	 */
	@Test
	public void validState() {
		prepareStateTest();
		Entry entry = factory.createEntry();
		region.getVertices().add(entry);
		createTransition(entry, state);

		validate(state);
		// assertTrue(validator.validate(state, diagnostics,
		// new HashMap<Object, Object>()));
		assertIssueCount(diagnostics, 0);
	}

	/**
	 * A valid entry should have No issues
	 */
	@Test
	public void validInitialEntry() {
		prepareStateTest();

		Entry entry = factory.createEntry();
		region.getVertices().add(entry);
		createTransition(entry, state);

		assertEquals(EntryKind.INITIAL, entry.getKind());
		assertTrue(validator.validate(entry, diagnostics, new HashMap<Object, Object>()));
		assertIssueCount(diagnostics, 0);
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

	@Test
	public void orthogonalTransition() {
		statechart = loadStatechart("OrthogonalTransition.sct");

		State state = firstNamed(EcoreUtil2.eAllOfType(statechart, State.class), "B2");
		Transition trans = state.getOutgoingTransitions().get(0);

		assertTrue(validator.validate(trans, diagnostics, new HashMap<Object, Object>()));
		assertNoIssues(diagnostics);
	}

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
	public void orthogonalSourceStates() {
		statechart = loadStatechart("OrthogonalRegion01.sct");

		State b = firstNamed(EcoreUtil2.eAllOfType(statechart, State.class), "AA");
		Synchronization sync = (Synchronization) b.getOutgoingTransitions().get(0).getTarget();

		assertTrue(validator.validate(sync, diagnostics, new HashMap<Object, Object>()));
		assertNoIssues(diagnostics);
	}

	@Test
	public void orthogonalTargetStates() {
		statechart = loadStatechart("OrthogonalRegion01.sct");

		State b = firstNamed(EcoreUtil2.eAllOfType(statechart, State.class), "B");
		Synchronization sync = (Synchronization) b.getOutgoingTransitions().get(0).getTarget();

		assertTrue(validator.validate(sync, diagnostics, new HashMap<Object, Object>()));
		assertNoIssues(diagnostics);
	}

	@Test
	public void validTransitionToInnerChoice() {
		statechart = AbstractTestModelsUtil
				.loadStatechart(VALIDATION_TESTMODEL_DIR + "ValidTransitionToInnerChoice.sct");
		Iterator<EObject> iter = statechart.eAllContents();
		while (iter.hasNext()) {
			EObject element = iter.next();
			if (element instanceof State) {
				validator.validate(element, diagnostics, new HashMap<Object, Object>());
			}
		}

		assertIssueCount(diagnostics, 0);
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

	@Test
	public void checkStatechartNameIsIdentifier() {
		Statechart statechart = SGraphFactory.eINSTANCE.createStatechart();
		statechart.setName("Not a valid identifier");
		validator.validate(statechart, diagnostics, new HashMap<Object, Object>());
		assertIssueCount(diagnostics, 1);
		assertError(diagnostics, String.format(ISSUE_STATECHART_NAME_NO_IDENTIFIER, statechart.getName()));

		diagnostics = new BasicDiagnostic();
		statechart.setName("0Notavalididentifier");
		validator.validate(statechart, diagnostics, new HashMap<Object, Object>());
		assertIssueCount(diagnostics, 1);
		assertError(diagnostics, String.format(ISSUE_STATECHART_NAME_NO_IDENTIFIER, statechart.getName()));

		diagnostics = new BasicDiagnostic();
		statechart.setName("ValidIdentifier");
		validator.validate(statechart, diagnostics, new HashMap<Object, Object>());
		assertIssueCount(diagnostics, 0);
	}

	/**
	 * checks that each @Check method of {@link STextJavaValidator} has a @Test
	 * method in this class with the same name
	 */
	// TODO: Create abstract test class for SGraphJavaValidatorTest and
	// STextJAvaValidatorTest
	@Test
	public void testAllChecksHaveTests() throws Exception {
		Iterable<Method> methods = Lists.newArrayList(SGraphJavaValidator.class.getMethods());
		methods = Iterables.filter(methods, new Predicate<Method>() {
			public boolean apply(Method input) {
				return input.getAnnotation(Check.class) != null;
			}
		});
		for (Method checkMethod : methods) {
			Method testMethod = getClass().getMethod(checkMethod.getName());
			assertNotNull("Missing @Test Annotation for method " + checkMethod.getName(),
					testMethod.getAnnotation(Test.class));
		}
	}

	/**
	 * checks that no two @Check method of {@link STextJavaValidator} have the
	 * same name. Avoiding overloaded check methods in the validator class
	 * allows to check it tests methods are explicilty written for all elelemnt
	 * types. It this is not checked than a single test implementation may
	 * satisfy the previous test for all overloaded functions.
	 */
	@Test
	public void testOverloadedCheckMethods() throws Exception {
		Iterable<Method> methods = Lists.newArrayList(SGraphJavaValidator.class.getMethods());
		methods = Iterables.filter(methods, new Predicate<Method>() {
			public boolean apply(Method input) {
				return input.getAnnotation(Check.class) != null;
			}

		});
		for (Method methodToCheck : methods) {
			for (Method method : methods) {
				if (methodToCheck != method) {
					assertFalse("@Check method '" + methodToCheck + "' is overloaded.",
							methodToCheck.getName().equals(method.getName()));
				}
			}
		}
	}

}
