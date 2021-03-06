
package org.yakindu.sct.generator.java.test;

import static org.mockito.Mockito.*;
import static org.mockito.Matchers.*;
import static org.hamcrest.CoreMatchers.*;
import org.yakindu.scr.operationswithoutbraces.IOperationsWithoutBracesStatemachine.*;	
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.junit.*;
import static org.junit.Assert.*;
import org.yakindu.scr.operationswithoutbraces.OperationsWithoutBracesStatemachine;
import org.yakindu.scr.operationswithoutbraces.OperationsWithoutBracesStatemachine.State;	
import org.yakindu.scr.VirtualTimer;
import org.yakindu.scr.VirtualTimer.VirtualTimeTask;
import org.yakindu.scr.VirtualTimer.CycleTimeEventTask;

/**
 * Unit TestCase for OperationsWithoutBraces
 */
@SuppressWarnings("all")
public class OperationsWithoutBraces {
	SCInterfaceOperationCallback defaultMock;
	
	private OperationsWithoutBracesStatemachine statemachine;	
	private VirtualTimer timer;
	
	
	@Before
	public void operationsWithoutBraces_setUp() {
		statemachine = new OperationsWithoutBracesStatemachine();
		timer = new VirtualTimer(200);
		timer.schedulePeriodicalTask(new CycleTimeEventTask(statemachine), 200, 200);
		defaultMock = mock(SCInterfaceOperationCallback.class);
		statemachine.getSCInterface().setSCInterfaceOperationCallback(defaultMock);
		
		statemachine.init();
		
	}

	@After
	public void operationsWithoutBraces_tearDown() {
		statemachine.getSCInterface().setSCInterfaceOperationCallback(null);
		statemachine = null;
		
		timer = null;
	}
	
	@Test
	public void operationsWithoutBracesTest() {
		when(defaultMock.myBoolOp()).thenAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) {
				return false;
			}
		});
		 
		when(defaultMock.myIntOp()).thenAnswer(new Answer<Long>() {
			@Override
			public Long answer(InvocationOnMock invocation) {
				return 0l;
			}
		});
		 
		when(defaultMock.myRealOp()).thenAnswer(new Answer<Double>() {
			@Override
			public Double answer(InvocationOnMock invocation) {
				return 0.0;
			}
		});
		 
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.another_region_A));
		assertTrue(statemachine.isStateActive(State.main_region_A));
		timer.cycleLeap(1);
		assertTrue(statemachine.isStateActive(State.another_region_C));
		assertTrue(statemachine.isStateActive(State.main_region_C));
		timer.cycleLeap(1);
		assertTrue(statemachine.isStateActive(State.main_region_D));
		assertTrue(statemachine.isStateActive(State.another_region_D));
	}
}
