#include <string>
#include "gtest/gtest.h"
#include "SameNameDifferentRegion.h"
#include "sc_runner.h"
#include "sc_types.h"

namespace  {

SameNameDifferentRegion* statechart;



//! The timers are managed by a timer service. */
static SctUnitRunner * runner;

class SameNameDifferentRegionTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new SameNameDifferentRegion();
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


TEST_F(SameNameDifferentRegionTest, sameNameDifferenRegionTest) {
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(SameNameDifferentRegion::main_region_StateA));
	
	statechart->getDefaultSCI()->raise_e1();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(SameNameDifferentRegion::main_region_StateB));
	
	EXPECT_TRUE(statechart->isStateActive(SameNameDifferentRegion::main_region_StateB_r1_StateA));
	
	statechart->getDefaultSCI()->raise_e1();
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(SameNameDifferentRegion::main_region_StateB));
	
	EXPECT_TRUE(statechart->isStateActive(SameNameDifferentRegion::main_region_StateB_r1_StateB));
	
	
}

}

