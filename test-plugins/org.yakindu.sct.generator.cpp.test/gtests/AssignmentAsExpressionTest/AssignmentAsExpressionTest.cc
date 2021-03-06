#include <string>
#include "gtest/gtest.h"
#include "AssignmentAsExpression.h"
#include "sc_runner.h"
#include "sc_types.h"

namespace  {

AssignmentAsExpression* statechart;



//! The timers are managed by a timer service. */
static SctUnitRunner * runner;

class AssignmentAsExpressionTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new AssignmentAsExpression();
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


TEST_F(AssignmentAsExpressionTest, simpleAssignment) {
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(AssignmentAsExpression::main_region_Add));
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_b()== 5);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_a()== 9);
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(AssignmentAsExpression::main_region_Subtract));
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_d()== 6);
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(AssignmentAsExpression::main_region_Multiply));
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_e()== 15);
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(AssignmentAsExpression::main_region_Divide));
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_g()== 1);
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(AssignmentAsExpression::main_region_Modulo));
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_i()== 1);
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(AssignmentAsExpression::main_region_Shift));
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_j()== 16);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_k()== 4);
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(AssignmentAsExpression::main_region_boolean_And));
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_l()== 1);
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(AssignmentAsExpression::main_region_boolean_Or));
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_p()== 15);
	
	runner->proceed_cycles(1);
	
	EXPECT_TRUE(statechart->isStateActive(AssignmentAsExpression::main_region_boolean_Xor));
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_u()== 12);
	
	statechart->exit();
	
	
}

}

