#include <string>
#include "gtest/gtest.h"
#include "SimpleEvent.h"
#include "sc_runner.h"
#include "sc_types.h"

namespace  {

SimpleEvent* statechart;



//! The timers are managed by a timer service. */
static SctUnitRunner * runner;

class SimpleEventTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new SimpleEvent();
		statechart->init();
		runner = new SctUnitRunner(
			statechart,
			false,
			200
		);
	}
	virtual void TearDown() {
		delete statechart;
		delete runner;
	}
};


TEST_F(SimpleEventTest, simpleEventTest) {
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(SimpleEvent::main_region_A)) << "Expected A to be active" ;
	
	EXPECT_TRUE(5== 5);
	
	statechart->getDefaultSCI()->raise_event1();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(SimpleEvent::main_region_B)) << "Expected B to be active" ;
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(!statechart->isStateActive(SimpleEvent::main_region_B));
	
	
}

}

