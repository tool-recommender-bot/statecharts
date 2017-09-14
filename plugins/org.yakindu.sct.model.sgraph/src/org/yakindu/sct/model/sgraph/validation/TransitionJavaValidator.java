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

import static org.yakindu.sct.model.sgraph.util.SGgraphUtil.commonAncestor;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.yakindu.sct.model.sgraph.CompositeElement;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.Synchronization;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.Vertex;

public class TransitionJavaValidator extends AbstractSGraphJavaValidator {

	public static final String ISSUE_TRANSITION_ORTHOGONAL = "Source and target of a transition must not be located in orthogonal regions!";
	public static final String ISSUE_INITIAL_ENTRY_WITH_TRANSITION_TO_CONTAINER = "Outgoing transitions from entries can only target to sibling or inner states.";

	@Check
	public void orthogonalTransition(Transition transition) {

		Vertex source = transition.getSource();
		Vertex target = transition.getTarget();

		if ((source instanceof Synchronization) || (target instanceof Synchronization))
			return; // ... the check does not apply.

		EObject commonAncestor = commonAncestor(source, target);

		if (commonAncestor instanceof CompositeElement) {

			error(ISSUE_TRANSITION_ORTHOGONAL, transition, null, -1);
		}
	}

	@Check(CheckType.FAST)
	public void initialEntryWithTransitionToContainer(Transition t) {
		if (t.getSource() instanceof Entry && !isChildOrSibling(t.getSource(), t.getTarget())) {
			error(ISSUE_INITIAL_ENTRY_WITH_TRANSITION_TO_CONTAINER, t, null, -1);
		}
	}

	private boolean isChildOrSibling(Vertex source, Vertex target) {
		TreeIterator<EObject> iter = source.getParentRegion().eAllContents();
		while (iter.hasNext()) {
			if (target == iter.next()) {
				return true;
			}
		}
		return false;
	}

}
