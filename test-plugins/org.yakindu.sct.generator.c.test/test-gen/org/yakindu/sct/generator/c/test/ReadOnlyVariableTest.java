package org.yakindu.sct.generator.c.test;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.yakindu.sct.generator.c.gtest.GTest;
import org.yakindu.sct.generator.c.gtest.GTestRunner;
import org.yakindu.sct.generator.c.gtest.GTestHelper;

@GTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "gtests/ReadOnlyVariable/ReadOnlyVariableTest.cc",
	program = "gtests/ReadOnlyVariable/ReadOnlyVariable",
	model = "testmodels/SCTUnit/ReadOnlyVariable.sct",
	additionalFilesToCopy = {
		"libraryTarget/sc_timer_service.c",
		"libraryTarget/sc_timer_service.h"
	},
	additionalFilesToCompile = {
		"ReadOnlyVariable.c",
		"sc_timer_service.c"
	}
)
@RunWith(GTestRunner.class)
public class ReadOnlyVariableTest {

	protected final GTestHelper helper = new GTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
