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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.InitializationError;

import junit.framework.AssertionFailedError;

/**
 * @author rbeckmann
 *
 */
public class PythonTestRunner extends Runner {
	/*
	 * Regex Patterns
	 */
	private static final Pattern TESTNAME_PATTERN = Pattern.compile(
			"([\\D]+[\\w]*) \\(([\\D]+[\\w]*)[.]([\\D]+[\\w]*)\\s*\\)");
	private static final Pattern TRACEBACK_PATTERN = Pattern.compile(
			"(?s)-*\\s(Traceback.*)\\s*-{70}.*-*");
	private static final Pattern TEST_FAIL_PATTERN = Pattern.compile(
			"FAIL");
	private static final Pattern TEST_ERROR_PATTERN = Pattern.compile(
			"ERROR");
	/*
	 * 
	 */
	private Class<?> testClass;
	private PyTest annotation;
	private ArrayList<String> tests;

	public PythonTestRunner(Class<?> testClass) throws InitializationError {
		this.testClass = testClass;
		this.tests = new ArrayList<String>();
		this.annotation = testClass.getAnnotation(PyTest.class);
		if (annotation == null) {
			throw new InitializationError("Test class must specify " + PyTest.class.getCanonicalName() + " annotation");
		}
		try {
			discover();
		} catch (IOException e) {
			throw new InitializationError("Tests could not be discovered: " + e.getMessage());
		}
		if(tests.isEmpty()) {
			throw new InitializationError("No Tests found.");
		}
	}

	private void discover() throws IOException {
		String pythonModule = annotation.path();
		String scriptpath = "src/python/TestDiscovery/discovery.py";

		Process process = new ProcessBuilder("python3", scriptpath, pythonModule).directory(null).start();
		BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		String line;
		while ((line = reader.readLine()) != null) {
			Matcher matcher = TESTNAME_PATTERN.matcher(line);
			if(matcher.find()) {
				String s = matcher.group(2) + "." + matcher.group(3) + "." + matcher.group(1);
				tests.add(s);
			}
		}
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.junit.runner.Runner#getDescription()
	 */
	@Override
	public Description getDescription() {
		Description suiteDesc = Description.createSuiteDescription(testClass);
		for(String name: tests) {
			suiteDesc.addChild(Description.createTestDescription(testClass, name));
		}
		
		return suiteDesc;
	}
	
	private void runPyTests(RunNotifier notifier) throws IOException {
		String pythonModule = annotation.path().replace('/', '.');
		
		for(String test: tests) {
			Description tcDescription = Description.createTestDescription(testClass, test);
			notifier.fireTestStarted(tcDescription);
			String testpath = pythonModule + "." + test;
			Process process = new ProcessBuilder("python3", "-m", "unittest", testpath).redirectErrorStream(true).directory(null).start();
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;
			StringBuilder b = new StringBuilder();
			while((line = reader.readLine()) != null) {
				b.append(line + "\n");
			}
			
			// Handle test output
			TestOutput out = parseTestOutput(b.toString());
			
			if(!out.getPass()) {
				Failure failure = new Failure(tcDescription, new AssertionFailedError(out.getTraceback().toString()));
				notifier.fireTestFailure(failure);
			}
			notifier.fireTestFinished(tcDescription);
			
		}
		
	}
	
	private TestOutput parseTestOutput(String s) {
		Matcher matcher_fail = TEST_FAIL_PATTERN.matcher(s);
		Matcher matcher_error = TEST_ERROR_PATTERN.matcher(s);
		int status = TestOutput.PASS;
		String traceback = "";
		if(matcher_fail.find()) {
			status = TestOutput.FAIL;
		} else if(matcher_error.find()) {
			status = TestOutput.ERROR;
		}
		Matcher matcher_traceback = TRACEBACK_PATTERN.matcher(s);
		if(matcher_traceback.find()) {
			traceback = matcher_traceback.group(1);
		}
		
		return new TestOutput(status, traceback);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.junit.runner.Runner#run(org.junit.runner.notification.RunNotifier)
	 */
	@Override
	public void run(RunNotifier notifier) {
		try {
			runPyTests(notifier);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private class TestOutput
	{
		public static final int PASS = 0;
		public static final int FAIL = 1;
		public static final int ERROR = 2;
		private int status; // 0 - pass, 1 - fail, 2 - error
		private String traceback;
		
		public TestOutput(int status, String traceback)
		{
			this.status = status;
			this.traceback = (traceback == null ? "" : traceback);
		}
		
		public boolean getFailed()
		{
			return this.status == FAIL;
		}
		
		public boolean getError()
		{
			return this.status == ERROR;
		}
		
		public boolean getPass()
		{
			return this.status == PASS;
		}
		
		public String getTraceback()
		{
			return this.traceback;
		}
	}

}
