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

import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.yakindu.sct.model.sgraph.Exit;
import org.yakindu.sct.model.sgraph.Statechart;

public class ExitJavaValidator extends AbstractSGraphJavaValidator {

	public static final String ISSUE_EXIT_WITH_OUT_TRANS = "Exit node should have no outgoing transition.";
	public static final String ISSUE_EXIT_WITHOUT_IN_TRANS = "Exit node should have at least one incoming transition.";
	public static final String ISSUE_EXIT_ON_STATECHART = "Exit node in top level region not supported - use final states instead.";

	@Check(CheckType.FAST)
	public void exitWithoutIncomingTransition(Exit exit) {
		if (exit.getIncomingTransitions().size() == 0) {
			warning(ISSUE_EXIT_WITHOUT_IN_TRANS, exit, null, -1);
		}
	}

	@Check(CheckType.FAST)
	public void exitWithOutgoingTransition(Exit exit) {
		if (exit.getOutgoingTransitions().size() > 0) {
			error(ISSUE_EXIT_WITH_OUT_TRANS, exit, null, -1);
		}
	}

	@Check(CheckType.FAST)
	public void exitOnStatechart(Exit exit) {
		if (exit.getParentRegion().getComposite() instanceof Statechart) {
			error(ISSUE_EXIT_ON_STATECHART, exit, null, -1);
		}
	}
}
