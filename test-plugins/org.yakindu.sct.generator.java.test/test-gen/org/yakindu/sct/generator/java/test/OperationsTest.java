
package org.yakindu.sct.generator.java.test;

import static org.mockito.Mockito.*;
import static org.mockito.Matchers.*;
import static org.hamcrest.CoreMatchers.*;
import org.yakindu.scr.operations.IOperationsStatemachine.*;	
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.junit.*;
import static org.junit.Assert.*;
import org.yakindu.scr.operations.OperationsStatemachine;
import org.yakindu.scr.operations.OperationsStatemachine.State;	
import org.yakindu.scr.VirtualTimer;
import org.yakindu.scr.VirtualTimer.VirtualTimeTask;
import org.yakindu.scr.VirtualTimer.CycleTimeEventTask;

/**
 * Unit TestCase for Operations
 */
@SuppressWarnings("all")
public class OperationsTest {
	InternalOperationCallback internalMock;
	SCIInterface1OperationCallback interface1Mock;
	SCInterfaceOperationCallback defaultMock;
	
	private OperationsStatemachine statemachine;	
	private VirtualTimer timer;
	
	
	@Before
	public void operationsTest_setUp() {
		statemachine = new OperationsStatemachine();
		timer = new VirtualTimer(200);
		timer.schedulePeriodicalTask(new CycleTimeEventTask(statemachine), 200, 200);
		internalMock = mock(InternalOperationCallback.class);
		statemachine.setInternalOperationCallback(internalMock);
		interface1Mock = mock(SCIInterface1OperationCallback.class);
		statemachine.getSCIInterface1().setSCIInterface1OperationCallback(interface1Mock);
		defaultMock = mock(SCInterfaceOperationCallback.class);
		statemachine.getSCInterface().setSCInterfaceOperationCallback(defaultMock);
		
		statemachine.init();
		
	}

	@After
	public void operationsTest_tearDown() {
		statemachine.setInternalOperationCallback(null);
		statemachine.getSCIInterface1().setSCIInterface1OperationCallback(null);
		statemachine.getSCInterface().setSCInterfaceOperationCallback(null);
		statemachine = null;
		
		timer = null;
	}
	
	@Test
	public void operationsCalled() {
		when(defaultMock.alwaysTrue()).thenAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) {
				return true;
			}
		});
		 
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.main_region_A));
		timer.cycleLeap(1);
		assertTrue(statemachine.isStateActive(State.main_region_B));
		verify(internalMock, atLeastOnce()).internalOperation1();
		 
		verify(internalMock, atLeastOnce()).internalOperation2((4l));
		 
		verify(internalMock, atLeastOnce()).internalOperation3();
		 
		verify(internalMock, atLeastOnce()).internalOperation3a((1.0));
		 
		verify(internalMock, atLeastOnce()).internalOperation4();
		 
		verify(internalMock, atLeastOnce()).internalOperation4a((5l));
		 
		verify(internalMock, atLeastOnce()).internalOperation5();
		 
		verify(internalMock, atLeastOnce()).internalOperation5a(anyString());
		 
		statemachine.getSCInterface().raiseEv();
		timer.cycleLeap(1);
		assertTrue(statemachine.isStateActive(State.main_region_C));
		verify(interface1Mock, atLeastOnce()).interfaceOperation1();
		 
		verify(interface1Mock, atLeastOnce()).interfaceOperation2((4l));
		 
		verify(interface1Mock, atLeastOnce()).interfaceOperation3();
		 
		verify(interface1Mock, atLeastOnce()).interfaceOperation3a((1.0));
		 
		verify(interface1Mock, atLeastOnce()).interfaceOperation4();
		 
		verify(interface1Mock, atLeastOnce()).interfaceOperation4a((5l));
		 
		verify(interface1Mock, atLeastOnce()).interfaceOperation5();
		 
		verify(interface1Mock, atLeastOnce()).interfaceOperation5a(anyString());
		 
		statemachine.getSCInterface().raiseEv();
		timer.cycleLeap(1);
		assertTrue(statemachine.isStateActive(State.main_region_D));
		verify(defaultMock, atLeastOnce()).unnamedInterfaceOperation1();
		 
		verify(defaultMock, atLeastOnce()).unnamedInterfaceOperation2((4l));
		 
		verify(defaultMock, atLeastOnce()).unnamedOperation3();
		 
		verify(defaultMock, atLeastOnce()).unnamedOperation3a((1.0));
		 
		verify(defaultMock, atLeastOnce()).unnamedOperation4();
		 
		verify(defaultMock, atLeastOnce()).unnamedOperation4a((5l));
		 
		verify(defaultMock, atLeastOnce()).unnamedOperation5();
		 
		verify(defaultMock, atLeastOnce()).unnamedOperation5a(anyString());
		 
	}
	
	@Test
	public void operationsNotCalled() {
		when(defaultMock.alwaysTrue()).thenAnswer(new Answer<Boolean>() {
			@Override
			public Boolean answer(InvocationOnMock invocation) {
				return true;
			}
		});
		 
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.main_region_A));
		verify(internalMock, never()).internalOperation1();
		 
		verify(internalMock, never()).internalOperation2((4l));
		 
		verify(internalMock, never()).internalOperation3();
		 
		verify(internalMock, never()).internalOperation3a((1.0));
		 
		verify(internalMock, never()).internalOperation4();
		 
		verify(internalMock, never()).internalOperation4a((5l));
		 
		verify(internalMock, never()).internalOperation5();
		 
		verify(internalMock, never()).internalOperation5a(anyString());
		 
		statemachine.getSCInterface().raiseEv();
		timer.cycleLeap(1);
		assertTrue(statemachine.isStateActive(State.main_region_B));
		verify(interface1Mock, never()).interfaceOperation1();
		 
		verify(interface1Mock, never()).interfaceOperation2((4l));
		 
		verify(interface1Mock, never()).interfaceOperation3();
		 
		verify(interface1Mock, never()).interfaceOperation3a((1.0));
		 
		verify(interface1Mock, never()).interfaceOperation4();
		 
		verify(interface1Mock, never()).interfaceOperation4a((5l));
		 
		verify(interface1Mock, never()).interfaceOperation5();
		 
		verify(interface1Mock, never()).interfaceOperation5a(anyString());
		 
		statemachine.getSCInterface().raiseEv();
		timer.cycleLeap(1);
		assertTrue(statemachine.isStateActive(State.main_region_C));
		verify(defaultMock, never()).unnamedInterfaceOperation1();
		 
		verify(defaultMock, never()).unnamedInterfaceOperation2((4l));
		 
		verify(defaultMock, never()).unnamedOperation3();
		 
		verify(defaultMock, never()).unnamedOperation3a((1.0));
		 
		verify(defaultMock, never()).unnamedOperation4();
		 
		verify(defaultMock, never()).unnamedOperation4a((5l));
		 
		verify(defaultMock, never()).unnamedOperation5();
		 
		verify(defaultMock, never()).unnamedOperation5a(anyString());
		 
	}
}
