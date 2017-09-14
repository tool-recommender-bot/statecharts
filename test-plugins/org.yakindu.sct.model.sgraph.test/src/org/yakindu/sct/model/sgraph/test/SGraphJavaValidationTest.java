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
import static org.yakindu.sct.model.sgraph.validation.SGraphJavaValidator.ISSUE_STATE_WITHOUT_OUTGOING_TRANSITION;
import static org.yakindu.sct.test.models.AbstractTestModelsUtil.VALIDATION_TESTMODEL_DIR;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.validation.Check;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.yakindu.sct.model.sgraph.Choice;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.EntryKind;
import org.yakindu.sct.model.sgraph.Exit;
import org.yakindu.sct.model.sgraph.FinalState;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Synchronization;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.validation.SGraphJavaValidator;
import org.yakindu.sct.model.stext.validation.STextJavaValidator;
import org.yakindu.sct.test.models.AbstractTestModelsUtil;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

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

	@Test
	public void orthogonalTransition() {
		statechart = loadStatechart("OrthogonalTransition.sct");

		State state = firstNamed(EcoreUtil2.eAllOfType(statechart, State.class), "B2");
		Transition trans = state.getOutgoingTransitions().get(0);

		assertTrue(validator.validate(trans, diagnostics, new HashMap<Object, Object>()));
		assertNoIssues(diagnostics);
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
