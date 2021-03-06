
#include <algorithm>
#include <list>
#include "gtest/gtest.h"
#include "ChildFirstTransitionsInSubchart.h"

#include "ChildFirstTransitionsInSubchartRequired.h"
#include "sc_timer_service.h"

static ChildFirstTransitionsInSubchart statechart;


class ChildFirstTransitionsinSubchartTest : public ::testing::Test
{
public:
	/* All operations from the SCTUnit test class. */
	void set_up();
	sc_boolean checkA(sc_boolean ret);
	sc_boolean checkAA(sc_boolean ret);
	sc_boolean checkAB(sc_boolean ret);
	sc_boolean checkAC(sc_boolean ret);
	sc_boolean checkAD(sc_boolean ret);
	sc_boolean checkC(sc_boolean ret);
	sc_integer nextCounter();
	void executionOrderWithNoTransitionInOrthogonalSubstates();
	void executionOrderWithTransitionInFirstSubRegion();
	void executionOrderWithTransitionInLastSubRegion();
	void executionOrderWithTransitionInAllSubRegion();
	void setTimer(ChildFirstTransitionsInSubchart* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic);
	void unsetTimer(ChildFirstTransitionsInSubchart* handle, const sc_eventid evid);
protected:
	sc_unit_timer_service_t timer_service;
	virtual void SetUp();
};

static ChildFirstTransitionsinSubchartTest * tc;

void set_up();
sc_boolean checkA(sc_boolean ret);
sc_boolean checkAA(sc_boolean ret);
sc_boolean checkAB(sc_boolean ret);
sc_boolean checkAC(sc_boolean ret);
sc_boolean checkAD(sc_boolean ret);
sc_boolean checkC(sc_boolean ret);
sc_integer nextCounter();
class CheckMock{
	typedef sc_boolean (CheckMock::*functiontype)();
	struct parameters {
		const sc_string value;
		sc_boolean (CheckMock::*behavior)();
		inline bool operator==(const parameters& other) {
			return (this->value == other.value);
		}
	};
	public:
	std::list<CheckMock::parameters> mocks;
	sc_boolean (CheckMock::*checkBehaviorDefault)();

	sc_boolean check1(){
		return (tc->checkA(false));
	}

	sc_boolean check2(){
		return (tc->checkAA(false));
	}

	sc_boolean check3(){
		return (tc->checkAB(false));
	}

	sc_boolean check4(){
		return (tc->checkAC(false));
	}

	sc_boolean check5(){
		return (tc->checkAD(false));
	}

	sc_boolean check6(){
		return (tc->checkC(false));
	}

	sc_boolean check7(){
		return (tc->checkAA(true));
	}

	sc_boolean check8(){
		return (tc->checkAC(true));
	}

	sc_boolean checkDefault(){
		sc_boolean defaultValue = false;
		return (defaultValue);
	}

	void setCheckBehavior(const sc_string value,sc_boolean (CheckMock::*func)()){
		parameters p;
		p.value = value;
		p.behavior = func;
	
		std::list<CheckMock::parameters>::iterator i = std::find(mocks.begin(), mocks.end(), p);
		if(i != mocks.end()) {
			mocks.erase(i);
		}
		mocks.push_back(p);
	}

	functiontype getBehavior(const sc_string value){
		parameters p;
		p.value = value;
		
		std::list<CheckMock::parameters>::iterator i = std::find(mocks.begin(), mocks.end(), p);
		if(i != mocks.end()) {
			return  i->behavior;
		} else {
			return checkBehaviorDefault;
		}
	}
	
	void setDefaultBehavior(sc_boolean (CheckMock::*defaultBehavior)()){
		checkBehaviorDefault = defaultBehavior;
		mocks.clear();
	}
	
	void initializeBehavior() {
		setDefaultBehavior(&CheckMock::checkDefault);
	}
	
	void reset() {
		initializeBehavior();
		mocks.clear();
	}
};
static CheckMock* checkMock;

class NextMock{
	typedef sc_integer (NextMock::*functiontype)();
	public:
	sc_integer (NextMock::*nextBehaviorDefault)();

	sc_integer next1(){
		return (tc->nextCounter());
	}

	sc_integer nextDefault(){
		sc_integer defaultValue = 0;
		return (defaultValue);
	}

	functiontype getBehavior(){
		return nextBehaviorDefault;
	}
	
	void setDefaultBehavior(sc_integer (NextMock::*defaultBehavior)()){
		nextBehaviorDefault = defaultBehavior;
	}
	
	void initializeBehavior() {
		setDefaultBehavior(&NextMock::nextDefault);
	}
	
	void reset() {
		initializeBehavior();
	}
};
static NextMock* nextMock;


void ChildFirstTransitionsinSubchartTest::SetUp()
{
	childFirstTransitionsInSubchart_init(&statechart);
	sc_timer_service_init(
		&timer_service,
		0,
		(sc_run_cycle_fp) &childFirstTransitionsInSubchart_runCycle,
		false,
		200,
		&statechart
	);
	
	checkMock = new CheckMock();
	checkMock->initializeBehavior();
	nextMock = new NextMock();
	nextMock->initializeBehavior();
	
	tc = this;
}
void ChildFirstTransitionsinSubchartTest::set_up()
{
	childFirstTransitionsInSubchartIface_set_cnt(&statechart,0);
}
sc_boolean ChildFirstTransitionsinSubchartTest::checkA(sc_boolean ret)
{
	childFirstTransitionsInSubchartIface_set_cnt(&statechart,childFirstTransitionsInSubchartIface_get_cnt(&statechart)+1);
	childFirstTransitionsInSubchartIface_set_a_check(&statechart,childFirstTransitionsInSubchartIface_get_cnt(&statechart));
	return ret;
}
sc_boolean ChildFirstTransitionsinSubchartTest::checkAA(sc_boolean ret)
{
	childFirstTransitionsInSubchartIface_set_cnt(&statechart,childFirstTransitionsInSubchartIface_get_cnt(&statechart)+1);
	childFirstTransitionsInSubchartIface_set_aa_check(&statechart,childFirstTransitionsInSubchartIface_get_cnt(&statechart));
	return ret;
}
sc_boolean ChildFirstTransitionsinSubchartTest::checkAB(sc_boolean ret)
{
	childFirstTransitionsInSubchartIface_set_cnt(&statechart,childFirstTransitionsInSubchartIface_get_cnt(&statechart)+1);
	childFirstTransitionsInSubchartIface_set_ab_check(&statechart,childFirstTransitionsInSubchartIface_get_cnt(&statechart));
	return ret;
}
sc_boolean ChildFirstTransitionsinSubchartTest::checkAC(sc_boolean ret)
{
	childFirstTransitionsInSubchartIface_set_cnt(&statechart,childFirstTransitionsInSubchartIface_get_cnt(&statechart)+1);
	childFirstTransitionsInSubchartIface_set_ac_check(&statechart,childFirstTransitionsInSubchartIface_get_cnt(&statechart));
	return ret;
}
sc_boolean ChildFirstTransitionsinSubchartTest::checkAD(sc_boolean ret)
{
	childFirstTransitionsInSubchartIface_set_cnt(&statechart,childFirstTransitionsInSubchartIface_get_cnt(&statechart)+1);
	childFirstTransitionsInSubchartIface_set_ad_check(&statechart,childFirstTransitionsInSubchartIface_get_cnt(&statechart));
	return ret;
}
sc_boolean ChildFirstTransitionsinSubchartTest::checkC(sc_boolean ret)
{
	childFirstTransitionsInSubchartIface_set_cnt(&statechart,childFirstTransitionsInSubchartIface_get_cnt(&statechart)+1);
	childFirstTransitionsInSubchartIface_set_c_check(&statechart,childFirstTransitionsInSubchartIface_get_cnt(&statechart));
	return ret;
}
sc_integer ChildFirstTransitionsinSubchartTest::nextCounter()
{
	childFirstTransitionsInSubchartIface_set_cnt(&statechart,childFirstTransitionsInSubchartIface_get_cnt(&statechart)+1);
	return childFirstTransitionsInSubchartIface_get_cnt(&statechart);
}
void ChildFirstTransitionsinSubchartTest::executionOrderWithNoTransitionInOrthogonalSubstates()
{
	set_up();
	checkMock->setCheckBehavior("A",&CheckMock::check1);
	checkMock->setCheckBehavior("AA",&CheckMock::check2);
	checkMock->setCheckBehavior("AB",&CheckMock::check3);
	checkMock->setCheckBehavior("AC",&CheckMock::check4);
	checkMock->setCheckBehavior("AD",&CheckMock::check5);
	checkMock->setCheckBehavior("C",&CheckMock::check6);
	nextMock->setDefaultBehavior(&NextMock::next1);
	childFirstTransitionsInSubchart_enter(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(childFirstTransitionsInSubchartIface_get_aa_check(&statechart)== 1);
	EXPECT_TRUE(childFirstTransitionsInSubchartIface_get_aa_local(&statechart)== 2);
	EXPECT_TRUE(childFirstTransitionsInSubchartIface_get_ac_check(&statechart)== 3);
	EXPECT_TRUE(childFirstTransitionsInSubchartIface_get_ac_local(&statechart)== 4);
	EXPECT_TRUE(childFirstTransitionsInSubchartIface_get_a_check(&statechart)== 5);
	EXPECT_TRUE(childFirstTransitionsInSubchartIface_get_a_local(&statechart)== 6);
	EXPECT_TRUE(childFirstTransitionsInSubchartIface_get_c_check(&statechart)== 7);
	EXPECT_TRUE(childFirstTransitionsInSubchartIface_get_c_local(&statechart)== 8);
	EXPECT_TRUE(childFirstTransitionsInSubchartIface_get_sm_local(&statechart)== 9);
}
void ChildFirstTransitionsinSubchartTest::executionOrderWithTransitionInFirstSubRegion()
{
	set_up();
	checkMock->setCheckBehavior("A",&CheckMock::check1);
	checkMock->setCheckBehavior("AA",&CheckMock::check7);
	checkMock->setCheckBehavior("AB",&CheckMock::check3);
	checkMock->setCheckBehavior("AC",&CheckMock::check4);
	checkMock->setCheckBehavior("AD",&CheckMock::check5);
	checkMock->setCheckBehavior("C",&CheckMock::check6);
	nextMock->setDefaultBehavior(&NextMock::next1);
	childFirstTransitionsInSubchart_enter(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(childFirstTransitionsInSubchartIface_get_aa_check(&statechart)== 1);
	EXPECT_TRUE(childFirstTransitionsInSubchartIface_get_aa_local(&statechart)== 0);
	EXPECT_TRUE(childFirstTransitionsInSubchartIface_get_ac_check(&statechart)== 2);
	EXPECT_TRUE(childFirstTransitionsInSubchartIface_get_ac_local(&statechart)== 3);
	EXPECT_TRUE(childFirstTransitionsInSubchartIface_get_a_check(&statechart)== 4);
	EXPECT_TRUE(childFirstTransitionsInSubchartIface_get_a_local(&statechart)== 5);
	EXPECT_TRUE(childFirstTransitionsInSubchartIface_get_c_check(&statechart)== 6);
	EXPECT_TRUE(childFirstTransitionsInSubchartIface_get_c_local(&statechart)== 7);
	EXPECT_TRUE(childFirstTransitionsInSubchartIface_get_sm_local(&statechart)== 8);
}
void ChildFirstTransitionsinSubchartTest::executionOrderWithTransitionInLastSubRegion()
{
	set_up();
	checkMock->setCheckBehavior("A",&CheckMock::check1);
	checkMock->setCheckBehavior("AA",&CheckMock::check2);
	checkMock->setCheckBehavior("AB",&CheckMock::check3);
	checkMock->setCheckBehavior("AC",&CheckMock::check8);
	checkMock->setCheckBehavior("AD",&CheckMock::check5);
	checkMock->setCheckBehavior("C",&CheckMock::check6);
	nextMock->setDefaultBehavior(&NextMock::next1);
	childFirstTransitionsInSubchart_enter(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(childFirstTransitionsInSubchartIface_get_aa_check(&statechart)== 1);
	EXPECT_TRUE(childFirstTransitionsInSubchartIface_get_aa_local(&statechart)== 2);
	EXPECT_TRUE(childFirstTransitionsInSubchartIface_get_ac_check(&statechart)== 3);
	EXPECT_TRUE(childFirstTransitionsInSubchartIface_get_ac_local(&statechart)== 0);
	EXPECT_TRUE(childFirstTransitionsInSubchartIface_get_a_check(&statechart)== 0);
	EXPECT_TRUE(childFirstTransitionsInSubchartIface_get_a_local(&statechart)== 4);
	EXPECT_TRUE(childFirstTransitionsInSubchartIface_get_c_check(&statechart)== 5);
	EXPECT_TRUE(childFirstTransitionsInSubchartIface_get_c_local(&statechart)== 6);
	EXPECT_TRUE(childFirstTransitionsInSubchartIface_get_sm_local(&statechart)== 7);
}
void ChildFirstTransitionsinSubchartTest::executionOrderWithTransitionInAllSubRegion()
{
	set_up();
	checkMock->setCheckBehavior("A",&CheckMock::check1);
	checkMock->setCheckBehavior("AA",&CheckMock::check7);
	checkMock->setCheckBehavior("AB",&CheckMock::check3);
	checkMock->setCheckBehavior("AC",&CheckMock::check8);
	checkMock->setCheckBehavior("AD",&CheckMock::check5);
	checkMock->setCheckBehavior("C",&CheckMock::check6);
	nextMock->setDefaultBehavior(&NextMock::next1);
	childFirstTransitionsInSubchart_enter(&statechart);
	sc_timer_service_proceed_cycles(&timer_service, 1);
	EXPECT_TRUE(childFirstTransitionsInSubchartIface_get_aa_check(&statechart)== 1);
	EXPECT_TRUE(childFirstTransitionsInSubchartIface_get_aa_local(&statechart)== 0);
	EXPECT_TRUE(childFirstTransitionsInSubchartIface_get_a_local(&statechart)== 3);
	EXPECT_TRUE(childFirstTransitionsInSubchartIface_get_ac_check(&statechart)== 2);
	EXPECT_TRUE(childFirstTransitionsInSubchartIface_get_ac_local(&statechart)== 0);
	EXPECT_TRUE(childFirstTransitionsInSubchartIface_get_a_check(&statechart)== 0);
	EXPECT_TRUE(childFirstTransitionsInSubchartIface_get_a_local(&statechart)== 3);
	EXPECT_TRUE(childFirstTransitionsInSubchartIface_get_c_check(&statechart)== 4);
	EXPECT_TRUE(childFirstTransitionsInSubchartIface_get_c_local(&statechart)== 5);
	EXPECT_TRUE(childFirstTransitionsInSubchartIface_get_sm_local(&statechart)== 6);
}

void ChildFirstTransitionsinSubchartTest::setTimer(ChildFirstTransitionsInSubchart* statechart, const sc_eventid evid, const sc_integer time_ms, const sc_boolean periodic){
	sc_timer_t timer;
	sc_timer_init(&timer, time_ms, periodic, evid);
	insert_timer(&(tc->timer_service), timer);
}

void ChildFirstTransitionsinSubchartTest::unsetTimer(ChildFirstTransitionsInSubchart* handle, const sc_eventid evid){
	delete_task(&(tc->timer_service), find_time_event(&timer_service, evid));
}

TEST_F(ChildFirstTransitionsinSubchartTest, executionOrderWithNoTransitionInOrthogonalSubstates) {
	executionOrderWithNoTransitionInOrthogonalSubstates();
}
TEST_F(ChildFirstTransitionsinSubchartTest, executionOrderWithTransitionInFirstSubRegion) {
	executionOrderWithTransitionInFirstSubRegion();
}
TEST_F(ChildFirstTransitionsinSubchartTest, executionOrderWithTransitionInLastSubRegion) {
	executionOrderWithTransitionInLastSubRegion();
}
TEST_F(ChildFirstTransitionsinSubchartTest, executionOrderWithTransitionInAllSubRegion) {
	executionOrderWithTransitionInAllSubRegion();
}


sc_boolean childFirstTransitionsInSubchartIface_check(const ChildFirstTransitionsInSubchart* statechart, const sc_string value) {
	return (checkMock->*(checkMock->getBehavior(value)))();
}
sc_integer childFirstTransitionsInSubchartIface_next(const ChildFirstTransitionsInSubchart* statechart) {
	return (nextMock->*(nextMock->getBehavior()))();
}
