package org.yakindu.sct.generator.c.test;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.yakindu.sct.generator.c.gtest.GTest;
import org.yakindu.sct.generator.c.gtest.GTestRunner;
import org.yakindu.sct.generator.c.gtest.GTestHelper;

@GTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "gtests/AssignmentAsExpression/AssignmentAsExpressionTest.cc",
	program = "gtests/AssignmentAsExpression/AssignmentAsExpression",
	model = "testmodels/SCTUnit/AssignmentAsExpression.sct",
	additionalFilesToCopy = {
		"libraryTarget/sc_timer_service.c",
		"libraryTarget/sc_timer_service.h"
	},
	additionalFilesToCompile = {
		"AssignmentAsExpression.c",
		"sc_timer_service.c"
	}
)
@RunWith(GTestRunner.class)
public class AssignmentAsExpressionTest {

	protected final GTestHelper helper = new GTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
