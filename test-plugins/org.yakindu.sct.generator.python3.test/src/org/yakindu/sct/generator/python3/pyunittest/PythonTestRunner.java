/**
 * Copyright (c) 2016 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */

package org.yakindu.sct.generator.python3.pyunittest;

import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.InitializationError;

/**
 * @author rbeckmann
 *
 */
public class PythonTestRunner extends Runner {
	private Class<?> testClass;
	
	public PythonTestRunner(Class<?> testClass) throws InitializationError {
		this.testClass = testClass;
		PyTest annotation = testClass.getAnnotation(PyTest.class);
		if (annotation == null) {
			throw new InitializationError("Test class must specify " + PyTest.class.getCanonicalName() + " annotation");
		}
		
		String pythonModule = annotation.module();
		
		
	}
	/* (non-Javadoc)
	 * @see org.junit.runner.Runner#getDescription()
	 */
	@Override
	public Description getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.junit.runner.Runner#run(org.junit.runner.notification.RunNotifier)
	 */
	@Override
	public void run(RunNotifier notifier) {
		// TODO Auto-generated method stub

	}

}
