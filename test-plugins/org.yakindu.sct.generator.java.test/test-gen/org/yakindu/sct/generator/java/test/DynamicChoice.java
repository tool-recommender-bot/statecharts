
package org.yakindu.sct.generator.java.test;

import org.junit.*;
import static org.junit.Assert.*;
import org.yakindu.scr.dynamicchoice.DynamicChoiceStatemachine;
import org.yakindu.scr.dynamicchoice.DynamicChoiceStatemachine.State;	
import org.yakindu.scr.VirtualTimer;
import org.yakindu.scr.VirtualTimer.VirtualTimeTask;
import org.yakindu.scr.VirtualTimer.CycleTimeEventTask;

/**
 * Unit TestCase for DynamicChoice
 */
@SuppressWarnings("all")
public class DynamicChoice {
	
	private DynamicChoiceStatemachine statemachine;	
	private VirtualTimer timer;
	
	
	@Before
	public void dynamicChoice_setUp() {
		statemachine = new DynamicChoiceStatemachine();
		timer = new VirtualTimer(200);
		timer.schedulePeriodicalTask(new CycleTimeEventTask(statemachine), 200, 200);
		
		statemachine.init();
		
	}

	@After
	public void dynamicChoice_tearDown() {
		statemachine = null;
		
		timer = null;
	}
	
	@Test
	public void dynamicChoiceTest() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.main_region_Start));
		timer.cycleLeap(1);
		assertTrue(statemachine.isStateActive(State.main_region_A));
	}
}
