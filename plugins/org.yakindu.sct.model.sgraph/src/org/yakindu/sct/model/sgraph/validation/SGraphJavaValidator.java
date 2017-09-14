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

import org.eclipse.xtext.validation.ComposedChecks;

/**
 * This validator is intended to be used by a compositeValidator (See
 * {@link org.eclipse.xtext.validation.ComposedChecks}) of another language
 * specific validator. It does not register itself as an EValidator.
 * 
 * This validator checks for common graphical constraints for all kinds of state
 * charts.
 * 
 * @author terfloth
 * @author muelder
 * @author bohl - migrated to xtext infrastruture
 * @author schwertfeger
 * @author antony
 */
@ComposedChecks(validators = {ChoiceJavaValidator.class, EntryJavaValidator.class, ExitJavaValidator.class,
		FinalStateJavaValidator.class, StatechartJavaValidator.class, StateJavaValidator.class,
		SynchronizationJavaValidator.class, TransitionJavaValidator.class, VertexJavaValidator.class})
public class SGraphJavaValidator extends AbstractSGraphJavaValidator {

	public static final String ISSUE_STATE_WITHOUT_OUTGOING_TRANSITION = "A state should have at least one outgoing transition.";

	@Override
	public boolean isLanguageSpecific() {
		return false;
	}
}
