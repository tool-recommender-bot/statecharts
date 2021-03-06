
package org.yakindu.sct.generator.java.test;

import org.junit.*;
import static org.junit.Assert.*;
import org.yakindu.scr.exitonselftransition.ExitOnSelfTransitionStatemachine;
import org.yakindu.scr.exitonselftransition.ExitOnSelfTransitionStatemachine.State;	
import org.yakindu.scr.VirtualTimer;
import org.yakindu.scr.VirtualTimer.VirtualTimeTask;
import org.yakindu.scr.VirtualTimer.CycleTimeEventTask;

/**
 * Unit TestCase for ExitOnSelfTransition
 */
@SuppressWarnings("all")
public class ExitOnSelfTransition {
	
	private ExitOnSelfTransitionStatemachine statemachine;	
	private VirtualTimer timer;
	
	
	@Before
	public void exitOnSelfTransition_setUp() {
		statemachine = new ExitOnSelfTransitionStatemachine();
		timer = new VirtualTimer(200);
		timer.schedulePeriodicalTask(new CycleTimeEventTask(statemachine), 200, 200);
		
		statemachine.init();
		
	}

	@After
	public void exitOnSelfTransition_tearDown() {
		statemachine = null;
		
		timer = null;
	}
	
	@Test
	public void exitOnSelfTransitionTest() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.main_region_A));
		assertTrue(statemachine.getEntryCount() == 1l);
		assertTrue(statemachine.getExitCount() == 0l);
		statemachine.getSCInterface().raiseE();
		timer.cycleLeap(1);
		assertTrue(statemachine.getEntryCount() == 2l);
		assertTrue(statemachine.getExitCount() == 1l);
		statemachine.getSCInterface().raiseF();
		timer.cycleLeap(1);
		assertTrue(statemachine.getEntryCount() == 2l);
		assertTrue(statemachine.getExitCount() == 2l);
	}
}
