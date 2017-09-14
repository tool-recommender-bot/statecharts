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
package org.yakindu.sct.model.sgraph.validation;

import static org.yakindu.sct.model.sgraph.util.SGgraphUtil.areOrthogonal;
import static org.yakindu.sct.model.sgraph.util.SGgraphUtil.collectAncestors;
import static org.yakindu.sct.model.sgraph.util.SGgraphUtil.findCommonAncestor;
import static org.yakindu.sct.model.sgraph.util.SGgraphUtil.sources;
import static org.yakindu.sct.model.sgraph.util.SGgraphUtil.targets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.Synchronization;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.Vertex;

public class SynchronizationJavaValidator extends AbstractSGraphJavaValidator {

	public static final String ISSUE_SYNCHRONIZATION_TARGET_STATES_NOT_ORTHOGONAL = "The target states of a synchronization must be orthogonal!";
	public static final String ISSUE_SYNCHRONIZATION_TARGET_STATES_NOT_WITHIN_SAME_PARENTSTATE = "The target states of a synchronization have to be contained in the same parent state within different regions!";
	public static final String ISSUE_SYNCHRONIZATION_SOURCE_STATES_NOT_ORTHOGONAL = "The source states of a synchronization must be orthogonal!";
	public static final String ISSUE_SYNCHRONIZATION_SOURCE_STATES_NOT_WITHIN_SAME_PARENTSTATE = "The source states of a synchronization have to be contained in the same parent state within different regions!";
	public static final String ISSUE_SYNCHRONIZATION_TRANSITION_COUNT = "A synchronization should have at least two incoming or two outgoing transitions.";

	@Check(CheckType.FAST)
	public void synchronizationTransitionCount(Synchronization sync) {
		if (sync.getIncomingTransitions().size() < 2 && sync.getOutgoingTransitions().size() < 2) {
			warning(ISSUE_SYNCHRONIZATION_TRANSITION_COUNT, sync, null, -1);
		}
	}

	@Check
	public void orthogonalSourceStates(Synchronization sync) {

		List<Vertex> sourceVertices = sources(sync.getIncomingTransitions());

		if (!areOrthogonal(sourceVertices)) {
			error(ISSUE_SYNCHRONIZATION_SOURCE_STATES_NOT_ORTHOGONAL, sync, null, -1);
		}
	}

	@Check
	public void orthogonalTargetStates(Synchronization sync) {

		List<Vertex> sourceVertices = targets(sync.getOutgoingTransitions());

		if (!areOrthogonal(sourceVertices)) {
			error(ISSUE_SYNCHRONIZATION_TARGET_STATES_NOT_ORTHOGONAL, sync, null, -1);
		}
	}

	@Check
	public void orthogonalSynchronizedTransition(Synchronization sync) {

		List<Transition> incoming = sync.getIncomingTransitions();
		List<List<EObject>> inAncestorsList = new ArrayList<List<EObject>>();
		for (Transition trans : incoming) {
			inAncestorsList.add(collectAncestors(trans.getSource(), new ArrayList<EObject>()));
		}

		List<Transition> outgoing = sync.getOutgoingTransitions();
		List<List<EObject>> outAncestorsList = new ArrayList<List<EObject>>();
		for (Transition trans : outgoing) {
			outAncestorsList.add(collectAncestors(trans.getTarget(), new ArrayList<EObject>()));
		}

		Set<Transition> inOrthogonal = new HashSet<Transition>(incoming);
		Set<Transition> outOrthogonal = new HashSet<Transition>(outgoing);

		for (int i = 0; i < incoming.size(); i++) {
			for (int j = 0; j < outgoing.size(); j++) {

				EObject commonAncestor = findCommonAncestor(inAncestorsList.get(i), outAncestorsList.get(j));

				if (commonAncestor instanceof Region) {
					inOrthogonal.remove(incoming.get(i));
					outOrthogonal.remove(outgoing.get(j));
				}
			}
		}

		for (Transition trans : inOrthogonal) {
			error(ISSUE_SYNCHRONIZATION_SOURCE_STATES_NOT_WITHIN_SAME_PARENTSTATE, trans, null, -1);
		}

		for (Transition trans : outOrthogonal) {
			error(ISSUE_SYNCHRONIZATION_TARGET_STATES_NOT_WITHIN_SAME_PARENTSTATE, trans, null, -1);
		}

	}
}
