
#include "gtest/gtest.h"
#include "SyncFork.h"

#include "sc_timer_service.h"

static SyncFork statechart;


class SyncForkTest : public ::testing::Test
{
public:
	/* All operations from the SCTUnit test class. */
	void syncForkTest();
	void setTimer(SyncFork* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic);
	void unsetTimer(SyncFork* handle, const sc_eventid evid);
protected:
	sc_unit_timer_service_t timer_service;
	virtual void SetUp();
};

static SyncForkTest * tc;


void SyncForkTest::SetUp()
{
	syncFork_init(&statechart);
	sc_timer_service_init(
		&timer_service,
		0,
		(sc_run_cycle_fp) &syncFork_runCycle,
		false,
		200,
		&statechart
	);
	
	
	tc = this;
}
void SyncForkTest::syncForkTest()
{
	syncFork_enter(&statechart);
	EXPECT_TRUE(syncFork_isStateActive(&statechart, SyncFork_main_region_A));
	syncForkIface_raise_f(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(syncFork_isStateActive(&statechart, SyncFork_main_region_B));
	EXPECT_TRUE(syncFork_isStateActive(&statechart, SyncFork_main_region_B_r1_C1));
	EXPECT_TRUE(syncFork_isStateActive(&statechart, SyncFork_main_region_B_r2_D1));
	syncForkIface_raise_f(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(syncFork_isStateActive(&statechart, SyncFork_main_region_B));
	EXPECT_TRUE(syncFork_isStateActive(&statechart, SyncFork_main_region_B_r1_C2));
	EXPECT_TRUE(syncFork_isStateActive(&statechart, SyncFork_main_region_B_r2_D2));
	syncForkIface_raise_e(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(syncFork_isStateActive(&statechart, SyncFork_main_region_A));
	syncForkIface_raise_f(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(syncFork_isStateActive(&statechart, SyncFork_main_region_B));
	EXPECT_TRUE(syncFork_isStateActive(&statechart, SyncFork_main_region_B_r1_C1));
	EXPECT_TRUE(syncFork_isStateActive(&statechart, SyncFork_main_region_B_r2_D1));
}

void SyncForkTest::setTimer(SyncFork* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic){
	sc_timer_t timer;
	sc_timer_init(&timer, time_ms, periodic, evid);
	insert_timer(&(tc->timer_service), timer);
}

void SyncForkTest::unsetTimer(SyncFork* handle, const sc_eventid evid){
	delete_task(&(tc->timer_service), find_time_event(&timer_service, evid));
}

TEST_F(SyncForkTest, syncForkTest) {
	syncForkTest();
}


