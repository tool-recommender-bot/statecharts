package org.yakindu.scr.entryexitselftransition;


public class EntryExitSelfTransitionStatemachine implements IEntryExitSelfTransitionStatemachine {
	protected class SCInterfaceImpl implements SCInterface {
	
		private boolean e;
		
		public void raiseE() {
			e = true;
		}
		
		private boolean e1;
		
		public void raiseE1() {
			e1 = true;
		}
		
		private long exits;
		
		public long getExits() {
			return exits;
		}
		
		public void setExits(long value) {
			this.exits = value;
		}
		
		private long entries;
		
		public long getEntries() {
			return entries;
		}
		
		public void setEntries(long value) {
			this.entries = value;
		}
		
		protected void clearEvents() {
			e = false;
			e1 = false;
		}
	}
	
	protected SCInterfaceImpl sCInterface;
	
	private boolean initialized = false;
	
	public enum State {
		main_region_A,
		main_region_A__region0_B,
		main_region_A__region0_C,
		$NullState$
	};
	
	private final State[] stateVector = new State[1];
	
	private int nextStateIndex;
	
	
	public EntryExitSelfTransitionStatemachine() {
		sCInterface = new SCInterfaceImpl();
	}
	
	public void init() {
		this.initialized = true;
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}
		clearEvents();
		clearOutEvents();
		sCInterface.setExits(0);
		
		sCInterface.setEntries(0);
	}
	
	public void enter() {
		if (!initialized) {
			throw new IllegalStateException(
				"The state machine needs to be initialized first by calling the init() function."
			);
		}
		enterSequence_main_region_default();
	}
	
	public void runCycle() {
		if (!initialized)
			throw new IllegalStateException(
					"The state machine needs to be initialized first by calling the init() function.");
		clearOutEvents();
		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {
			switch (stateVector[nextStateIndex]) {
			case main_region_A__region0_B:
				main_region_A__region0_B_react(true);
				break;
			case main_region_A__region0_C:
				main_region_A__region0_C_react(true);
				break;
			default:
				// $NullState$
			}
		}
		clearEvents();
	}
	public void exit() {
		exitSequence_main_region();
	}
	
	/**
	 * @see IStatemachine#isActive()
	 */
	public boolean isActive() {
		return stateVector[0] != State.$NullState$;
	}
	
	/** 
	* Always returns 'false' since this state machine can never become final.
	*
	* @see IStatemachine#isFinal()
	*/
	public boolean isFinal() {
		return false;
	}
	/**
	* This method resets the incoming events (time events included).
	*/
	protected void clearEvents() {
		sCInterface.clearEvents();
	}
	
	/**
	* This method resets the outgoing events.
	*/
	protected void clearOutEvents() {
	}
	
	/**
	* Returns true if the given state is currently active otherwise false.
	*/
	public boolean isStateActive(State state) {
	
		switch (state) {
		case main_region_A:
			return stateVector[0].ordinal() >= State.
					main_region_A.ordinal()&& stateVector[0].ordinal() <= State.main_region_A__region0_C.ordinal();
		case main_region_A__region0_B:
			return stateVector[0] == State.main_region_A__region0_B;
		case main_region_A__region0_C:
			return stateVector[0] == State.main_region_A__region0_C;
		default:
			return false;
		}
	}
	
	public SCInterface getSCInterface() {
		return sCInterface;
	}
	
	public void raiseE() {
		sCInterface.raiseE();
	}
	
	public void raiseE1() {
		sCInterface.raiseE1();
	}
	
	public long getExits() {
		return sCInterface.getExits();
	}
	
	public void setExits(long value) {
		sCInterface.setExits(value);
	}
	
	public long getEntries() {
		return sCInterface.getEntries();
	}
	
	public void setEntries(long value) {
		sCInterface.setEntries(value);
	}
	
	/* Entry action for state 'A'. */
	private void entryAction_main_region_A() {
		sCInterface.setEntries(sCInterface.getEntries() + 1);
	}
	
	/* Exit action for state 'A'. */
	private void exitAction_main_region_A() {
		sCInterface.setExits(sCInterface.getExits() + 1);
	}
	
	/* 'default' enter sequence for state A */
	private void enterSequence_main_region_A_default() {
		entryAction_main_region_A();
		enterSequence_main_region_A__region0_default();
	}
	
	/* 'default' enter sequence for state B */
	private void enterSequence_main_region_A__region0_B_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_A__region0_B;
	}
	
	/* 'default' enter sequence for state C */
	private void enterSequence_main_region_A__region0_C_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_A__region0_C;
	}
	
	/* 'default' enter sequence for region main region */
	private void enterSequence_main_region_default() {
		react_EntryExitSelfTransition_main_region__entry_Default();
	}
	
	/* 'default' enter sequence for region  */
	private void enterSequence_main_region_A__region0_default() {
		react_EntryExitSelfTransition_main_region_A__region0__entry_Default();
	}
	
	/* Default exit sequence for state A */
	private void exitSequence_main_region_A() {
		exitSequence_main_region_A__region0();
		exitAction_main_region_A();
	}
	
	/* Default exit sequence for state B */
	private void exitSequence_main_region_A__region0_B() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state C */
	private void exitSequence_main_region_A__region0_C() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for region main region */
	private void exitSequence_main_region() {
		switch (stateVector[0]) {
		case main_region_A__region0_B:
			exitSequence_main_region_A__region0_B();
			exitAction_main_region_A();
			break;
		case main_region_A__region0_C:
			exitSequence_main_region_A__region0_C();
			exitAction_main_region_A();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region  */
	private void exitSequence_main_region_A__region0() {
		switch (stateVector[0]) {
		case main_region_A__region0_B:
			exitSequence_main_region_A__region0_B();
			break;
		case main_region_A__region0_C:
			exitSequence_main_region_A__region0_C();
			break;
		default:
			break;
		}
	}
	
	/* Default react sequence for initial entry  */
	private void react_EntryExitSelfTransition_main_region__entry_Default() {
		enterSequence_main_region_A_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_EntryExitSelfTransition_main_region_A__region0__entry_Default() {
		enterSequence_main_region_A__region0_B_default();
	}
	
	private boolean react() {
		return false;
	}
	
	private boolean main_region_A_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			if (react()==false) {
				if (sCInterface.e) {
					exitSequence_main_region_A();
					entryAction_main_region_A();
					enterSequence_main_region_A__region0_C_default();
				} else {
					did_transition = false;
				}
			}
		}
		return did_transition;
	}
	
	private boolean main_region_A__region0_B_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			if (main_region_A_react(try_transition)==false) {
				if (sCInterface.e1) {
					exitSequence_main_region_A__region0_B();
					enterSequence_main_region_A__region0_C_default();
				} else {
					did_transition = false;
				}
			}
		}
		return did_transition;
	}
	
	private boolean main_region_A__region0_C_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			if (main_region_A_react(try_transition)==false) {
				if (sCInterface.e1) {
					exitSequence_main_region_A();
					enterSequence_main_region_A_default();
				} else {
					did_transition = false;
				}
			}
		}
		return did_transition;
	}
	
}
