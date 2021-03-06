package org.yakindu.sct.generator.cpp.test;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.yakindu.sct.generator.c.gtest.GTest;
import org.yakindu.sct.generator.c.gtest.GTestRunner;
import org.yakindu.sct.generator.c.gtest.GTestHelper;
import org.yakindu.sct.generator.c.gtest.GTestHelper.Compiler;
import org.yakindu.sct.generator.c.gtest.GMockHelper;

@GTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "gtests/ParentFirstOrthogonalReactions/ParentFirstOrthogonalReactionsTest.cc",
	program = "gtests/ParentFirstOrthogonalReactions/ParentFirstOrthogonalReactions",
	model = "testmodels/SCTUnit/executionorder/ParentFirstOrthogonalReactions.sct",
	additionalFilesToCopy = {
		"libraryTarget/sc_runner.h",
		"libraryTarget/sc_runner.cpp"
	},
	additionalFilesToCompile = {
		"ParentFirstOrthogonalReactions.cpp",
		"sc_runner.cpp"
	}
)
@RunWith(GTestRunner.class)
public class ParentFirstOrthogonalReactionsTest {
protected final GTestHelper helper = new GMockHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}

}
