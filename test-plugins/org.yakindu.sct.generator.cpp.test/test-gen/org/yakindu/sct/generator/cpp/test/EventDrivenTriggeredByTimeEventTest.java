package org.yakindu.sct.generator.cpp.test;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.yakindu.sct.generator.c.gtest.GTest;
import org.yakindu.sct.generator.c.gtest.GTestRunner;
import org.yakindu.sct.generator.c.gtest.GTestHelper;
import org.yakindu.sct.generator.c.gtest.GTestHelper.Compiler;

@GTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "gtests/EventDrivenTriggeredByTimeEvent/EventDrivenTriggeredByTimeEventTest.cc",
	program = "gtests/EventDrivenTriggeredByTimeEvent/EventDrivenTriggeredByTimeEvent",
	model = "testmodels/SCTUnit/eventdriven/EventDrivenTriggeredByTimeEvent.sct",
	additionalFilesToCopy = {
		"libraryTarget/sc_runner_timed.h",
		"libraryTarget/sc_runner_timed.cpp"
	},
	additionalFilesToCompile = {
		"EventDrivenTriggeredByTimeEvent.cpp",
		"sc_runner_timed.cpp"
	}
)
@RunWith(GTestRunner.class)
public class EventDrivenTriggeredByTimeEventTest {
protected final GTestHelper helper = new GTestHelper(this, Compiler.GPLUSPLUS);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}

}
