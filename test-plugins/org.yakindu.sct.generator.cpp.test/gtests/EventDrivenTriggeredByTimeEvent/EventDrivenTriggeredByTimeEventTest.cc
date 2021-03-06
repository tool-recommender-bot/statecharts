#include <string>
#include "gtest/gtest.h"
#include "EventDrivenTriggeredByTimeEvent.h"
#include "sc_runner_timed.h"
#include "sc_types.h"

namespace  {

eventdriven::EventDrivenTriggeredByTimeEvent* statechart;



//! The timers are managed by a timer service. */
static TimedSctUnitRunner * runner;

class EventDrivenTriggeredByTimeEventTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new eventdriven::EventDrivenTriggeredByTimeEvent();
		statechart->init();
		runner = new TimedSctUnitRunner(
			statechart,
			true,
			200
		);
		statechart->setTimer(runner);
	}
	virtual void TearDown() {
		delete statechart;
		delete runner;
	}
};


TEST_F(EventDrivenTriggeredByTimeEventTest, timeEventTriggersRunCycle) {
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(eventdriven::EventDrivenTriggeredByTimeEvent::EventDrivenTriggeredByTimeEvent_r_A));
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_x()== 0);
	
	runner->proceed_time(999);
	
	EXPECT_TRUE(statechart->isStateActive(eventdriven::EventDrivenTriggeredByTimeEvent::EventDrivenTriggeredByTimeEvent_r_A));
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_x()== 0);
	
	runner->proceed_time(1);
	
	EXPECT_TRUE(statechart->isStateActive(eventdriven::EventDrivenTriggeredByTimeEvent::EventDrivenTriggeredByTimeEvent_r_B));
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_x()== 0);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_transition_count()== 1);
	
	runner->proceed_time(1000);
	
	EXPECT_TRUE(statechart->isStateActive(eventdriven::EventDrivenTriggeredByTimeEvent::EventDrivenTriggeredByTimeEvent_r_A));
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_x()== 0);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_transition_count()== 2);
	
	runner->proceed_time(999000);
	
	EXPECT_TRUE(statechart->isStateActive(eventdriven::EventDrivenTriggeredByTimeEvent::EventDrivenTriggeredByTimeEvent_r_B));
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_x()== 0);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_transition_count()== 1001);
	
	runner->proceed_time(999000);
	
	EXPECT_TRUE(statechart->isStateActive(eventdriven::EventDrivenTriggeredByTimeEvent::EventDrivenTriggeredByTimeEvent_r_A));
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_x()== 0);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_transition_count()== 2000);
	
	statechart->exit();
	
	
}

}

