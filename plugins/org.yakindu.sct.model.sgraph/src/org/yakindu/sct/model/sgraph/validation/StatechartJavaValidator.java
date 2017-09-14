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
import org.yakindu.base.base.BasePackage;
import org.yakindu.sct.model.sgraph.Statechart;

public class StatechartJavaValidator extends AbstractSGraphJavaValidator{

	public static final String ISSUE_STATECHART_NAME_NO_IDENTIFIER = "%s is not a valid identifier!";

	@Check
	public void checkStatechartNameIsIdentifier(Statechart statechart) {
		if (!isValidJavaIdentifier(statechart.getName())) {
			error(String.format(ISSUE_STATECHART_NAME_NO_IDENTIFIER, statechart.getName()), statechart,
					BasePackage.Literals.NAMED_ELEMENT__NAME, -1);

		}
	}

	protected boolean isValidJavaIdentifier(String s) {
		if (s == null || s.length() == 0) {
			return false;
		}

		char[] c = s.toCharArray();
		if (!Character.isJavaIdentifierStart(c[0])) {
			return false;
		}

		for (int i = 1; i < c.length; i++) {
			if (!Character.isJavaIdentifierPart(c[i])) {
				return false;
			}
		}
		return true;
	}
}
