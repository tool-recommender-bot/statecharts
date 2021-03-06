
package org.yakindu.sct.generator.java.test;

import org.junit.*;
import static org.junit.Assert.*;
import org.yakindu.scr.localevents.LocalEventsStatemachine;
import org.yakindu.scr.localevents.LocalEventsStatemachine.State;	
import org.yakindu.scr.VirtualTimer;

/**
 * Unit TestCase for localEvents
 */
@SuppressWarnings("all")
public class LocalEvents {
	
	private LocalEventsStatemachine statemachine;	
	
	
	@Before
	public void localEvents_setUp() {
		statemachine = new LocalEventsStatemachine();
		
		statemachine.init();
		
	}

	@After
	public void localEvents_tearDown() {
		statemachine = null;
		
	}
	
	@Test
	public void test() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.localEvents_r1_Comp1_r_A1));
		assertTrue(statemachine.isStateActive(State.localEvents_r2_Comp2_r_A2));
		statemachine.getSCInterface().raiseE();
		assertTrue(statemachine.isStateActive(State.localEvents_r1_Comp1_r_D1));
		assertTrue(statemachine.isStateActive(State.localEvents_r2_Comp2_r_D2));
		assertTrue(statemachine.getCycleCountSm() == 5l);
		assertTrue(statemachine.getCycleCount1() == 5l);
		assertTrue(statemachine.getCycleCount2() == 5l);
		assertTrue(statemachine.getChecksum() == 3l);
		statemachine.exit();
	}
}
