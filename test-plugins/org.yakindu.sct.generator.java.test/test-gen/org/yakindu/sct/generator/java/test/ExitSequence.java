
package org.yakindu.sct.generator.java.test;

import org.junit.*;
import static org.junit.Assert.*;
import org.yakindu.scr.exitsequence.ExitSequenceStatemachine;
import org.yakindu.scr.exitsequence.ExitSequenceStatemachine.State;	
import org.yakindu.scr.VirtualTimer;

/**
 * Unit TestCase for ExitSequence
 */
@SuppressWarnings("all")
public class ExitSequence {
	
	private ExitSequenceStatemachine statemachine;	
	
	
	@Before
	public void exitSequence_setUp() {
		statemachine = new ExitSequenceStatemachine();
		
		statemachine.init();
		
	}

	@After
	public void exitSequence_tearDown() {
		statemachine = null;
		
	}
	
	@Test
	public void exitStatechartFromLeafSlimState() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.main_region_A_r_AA));
		assertTrue((statemachine.getA_exit() == 0l));
		assertTrue((statemachine.getAa_exit() == 0l));
		assertTrue((statemachine.getAb_exit() == 0l));
		assertTrue((statemachine.getAba_exit() == 0l));
		assertTrue((statemachine.getAbb_exit() == 0l));
		assertTrue((statemachine.getAc_exit() == 0l));
		assertTrue((statemachine.getAca_exit() == 0l));
		assertTrue((statemachine.getAcaa_exit() == 0l));
		assertTrue((statemachine.getAcaa_exit() == 0l));
		assertTrue((statemachine.getAd_exit() == 0l));
		assertTrue((statemachine.getAda_exit() == 0l));
		assertTrue((statemachine.getAdb_exit() == 0l));
		assertTrue((statemachine.getAdc_exit() == 0l));
		statemachine.exit();
		assertTrue(!statemachine.isStateActive(State.main_region_A));
		assertTrue((statemachine.getA_exit() == 2l));
		assertTrue((statemachine.getAa_exit() == 1l));
		assertTrue((statemachine.getAb_exit() == 0l));
		assertTrue((statemachine.getAba_exit() == 0l));
		assertTrue((statemachine.getAbb_exit() == 0l));
		assertTrue((statemachine.getAc_exit() == 0l));
		assertTrue((statemachine.getAca_exit() == 0l));
		assertTrue((statemachine.getAcaa_exit() == 0l));
		assertTrue((statemachine.getAcaa_exit() == 0l));
		assertTrue((statemachine.getAd_exit() == 0l));
		assertTrue((statemachine.getAda_exit() == 0l));
		assertTrue((statemachine.getAdb_exit() == 0l));
		assertTrue((statemachine.getAdc_exit() == 0l));
	}
	
	@Test
	public void exitLeafSlimStateByTransition() {
		statemachine.enter();
		statemachine.getSCInterface().raiseE();
		assertTrue(statemachine.isStateActive(State.main_region_A_r_AB));
		assertTrue((statemachine.getA_exit() == 0l));
		assertTrue((statemachine.getAa_exit() == 1l));
		assertTrue((statemachine.getAb_exit() == 0l));
		assertTrue((statemachine.getAba_exit() == 0l));
		assertTrue((statemachine.getAbb_exit() == 0l));
		assertTrue((statemachine.getAc_exit() == 0l));
		assertTrue((statemachine.getAca_exit() == 0l));
		assertTrue((statemachine.getAcaa_exit() == 0l));
		assertTrue((statemachine.getAcaa_exit() == 0l));
		assertTrue((statemachine.getAd_exit() == 0l));
		assertTrue((statemachine.getAda_exit() == 0l));
		assertTrue((statemachine.getAdb_exit() == 0l));
		assertTrue((statemachine.getAdc_exit() == 0l));
	}
	
	@Test
	public void exitLeafSlimStateByTransitionFromParent() {
		statemachine.enter();
		statemachine.getSCInterface().raiseF();
		assertTrue(statemachine.isStateActive(State.main_region_A_r_AA));
		assertTrue((statemachine.getA_exit() == 2l));
		assertTrue((statemachine.getAa_exit() == 1l));
		assertTrue((statemachine.getAb_exit() == 0l));
		assertTrue((statemachine.getAba_exit() == 0l));
		assertTrue((statemachine.getAbb_exit() == 0l));
		assertTrue((statemachine.getAc_exit() == 0l));
		assertTrue((statemachine.getAca_exit() == 0l));
		assertTrue((statemachine.getAcaa_exit() == 0l));
		assertTrue((statemachine.getAcaa_exit() == 0l));
		assertTrue((statemachine.getAd_exit() == 0l));
		assertTrue((statemachine.getAda_exit() == 0l));
		assertTrue((statemachine.getAdb_exit() == 0l));
		assertTrue((statemachine.getAdc_exit() == 0l));
	}
	
	@Test
	public void exitStatechartFromLeafSlimOrthogonalState() {
		statemachine.enter();
		statemachine.getSCInterface().raiseE();
		assertTrue(statemachine.isStateActive(State.main_region_A_r_AB));
		statemachine.exit();
		assertTrue(!statemachine.isStateActive(State.main_region_A));
		assertTrue((statemachine.getA_exit() == 5l));
		assertTrue((statemachine.getAa_exit() == 1l));
		assertTrue((statemachine.getAb_exit() == 4l));
		assertTrue((statemachine.getAba_exit() == 2l));
		assertTrue((statemachine.getAbb_exit() == 3l));
		assertTrue((statemachine.getAc_exit() == 0l));
		assertTrue((statemachine.getAca_exit() == 0l));
		assertTrue((statemachine.getAcaa_exit() == 0l));
		assertTrue((statemachine.getAcaa_exit() == 0l));
		assertTrue((statemachine.getAd_exit() == 0l));
		assertTrue((statemachine.getAda_exit() == 0l));
		assertTrue((statemachine.getAdb_exit() == 0l));
		assertTrue((statemachine.getAdc_exit() == 0l));
	}
	
	@Test
	public void exitLeafSlimOrthogonaleStateByTransition() {
		statemachine.enter();
		statemachine.getSCInterface().raiseE();
		statemachine.getSCInterface().raiseE();
		assertTrue(statemachine.isStateActive(State.main_region_A_r_AC));
		assertTrue((statemachine.getA_exit() == 0l));
		assertTrue((statemachine.getAa_exit() == 1l));
		assertTrue((statemachine.getAb_exit() == 4l));
		assertTrue((statemachine.getAba_exit() == 2l));
		assertTrue((statemachine.getAbb_exit() == 3l));
		assertTrue((statemachine.getAc_exit() == 0l));
		assertTrue((statemachine.getAca_exit() == 0l));
		assertTrue((statemachine.getAcaa_exit() == 0l));
		assertTrue((statemachine.getAcaa_exit() == 0l));
		assertTrue((statemachine.getAd_exit() == 0l));
		assertTrue((statemachine.getAda_exit() == 0l));
		assertTrue((statemachine.getAdb_exit() == 0l));
		assertTrue((statemachine.getAdc_exit() == 0l));
	}
	
	@Test
	public void exitLeafSlimOrthogonalStateByTransitionFromParent() {
		statemachine.enter();
		statemachine.getSCInterface().raiseE();
		assertTrue(statemachine.isStateActive(State.main_region_A_r_AB));
		statemachine.getSCInterface().raiseF();
		assertTrue(statemachine.isStateActive(State.main_region_A_r_AA));
		assertTrue((statemachine.getA_exit() == 5l));
		assertTrue((statemachine.getAa_exit() == 1l));
		assertTrue((statemachine.getAb_exit() == 4l));
		assertTrue((statemachine.getAba_exit() == 2l));
		assertTrue((statemachine.getAbb_exit() == 3l));
		assertTrue((statemachine.getAc_exit() == 0l));
		assertTrue((statemachine.getAca_exit() == 0l));
		assertTrue((statemachine.getAcaa_exit() == 0l));
		assertTrue((statemachine.getAd_exit() == 0l));
		assertTrue((statemachine.getAda_exit() == 0l));
		assertTrue((statemachine.getAdb_exit() == 0l));
		assertTrue((statemachine.getAdc_exit() == 0l));
	}
	
	@Test
	public void exitStatechartFromLeafSlimDeepState() {
		statemachine.enter();
		statemachine.getSCInterface().raiseE();
		statemachine.getSCInterface().raiseE();
		assertTrue(statemachine.isStateActive(State.main_region_A_r_AC));
		statemachine.exit();
		assertTrue(!statemachine.isStateActive(State.main_region_A));
		assertTrue((statemachine.getA_exit() == 8l));
		assertTrue((statemachine.getAa_exit() == 1l));
		assertTrue((statemachine.getAb_exit() == 4l));
		assertTrue((statemachine.getAba_exit() == 2l));
		assertTrue((statemachine.getAbb_exit() == 3l));
		assertTrue((statemachine.getAc_exit() == 7l));
		assertTrue((statemachine.getAca_exit() == 6l));
		assertTrue((statemachine.getAcaa_exit() == 5l));
		assertTrue((statemachine.getAd_exit() == 0l));
		assertTrue((statemachine.getAda_exit() == 0l));
		assertTrue((statemachine.getAdb_exit() == 0l));
		assertTrue((statemachine.getAdc_exit() == 0l));
	}
	
	@Test
	public void exitLeafSlimDeepStateByTransition() {
		statemachine.enter();
		statemachine.getSCInterface().raiseE();
		statemachine.getSCInterface().raiseE();
		statemachine.getSCInterface().raiseE();
		assertTrue(statemachine.isStateActive(State.main_region_A_r_AD));
		assertTrue((statemachine.getA_exit() == 0l));
		assertTrue((statemachine.getAa_exit() == 1l));
		assertTrue((statemachine.getAb_exit() == 4l));
		assertTrue((statemachine.getAba_exit() == 2l));
		assertTrue((statemachine.getAbb_exit() == 3l));
		assertTrue((statemachine.getAc_exit() == 7l));
		assertTrue((statemachine.getAca_exit() == 6l));
		assertTrue((statemachine.getAcaa_exit() == 5l));
		assertTrue((statemachine.getAd_exit() == 0l));
		assertTrue((statemachine.getAda_exit() == 0l));
		assertTrue((statemachine.getAdb_exit() == 0l));
		assertTrue((statemachine.getAdc_exit() == 0l));
	}
	
	@Test
	public void exitLeafSlimDeepStateByTransitionFromParent() {
		statemachine.enter();
		statemachine.getSCInterface().raiseE();
		statemachine.getSCInterface().raiseE();
		assertTrue(statemachine.isStateActive(State.main_region_A_r_AC));
		statemachine.getSCInterface().raiseF();
		assertTrue(statemachine.isStateActive(State.main_region_A_r_AA));
		assertTrue((statemachine.getA_exit() == 8l));
		assertTrue((statemachine.getAa_exit() == 1l));
		assertTrue((statemachine.getAb_exit() == 4l));
		assertTrue((statemachine.getAba_exit() == 2l));
		assertTrue((statemachine.getAbb_exit() == 3l));
		assertTrue((statemachine.getAc_exit() == 7l));
		assertTrue((statemachine.getAca_exit() == 6l));
		assertTrue((statemachine.getAcaa_exit() == 5l));
		assertTrue((statemachine.getAd_exit() == 0l));
		assertTrue((statemachine.getAda_exit() == 0l));
		assertTrue((statemachine.getAdb_exit() == 0l));
		assertTrue((statemachine.getAdc_exit() == 0l));
	}
	
	@Test
	public void exitStatechartFromFatState() {
		statemachine.enter();
		statemachine.getSCInterface().raiseE();
		statemachine.getSCInterface().raiseE();
		statemachine.getSCInterface().raiseE();
		assertTrue(statemachine.isStateActive(State.main_region_A_r_AD));
		statemachine.exit();
		assertTrue(!statemachine.isStateActive(State.main_region_A));
		assertTrue((statemachine.getA_exit() == 12l));
		assertTrue((statemachine.getAa_exit() == 1l));
		assertTrue((statemachine.getAb_exit() == 4l));
		assertTrue((statemachine.getAba_exit() == 2l));
		assertTrue((statemachine.getAbb_exit() == 3l));
		assertTrue((statemachine.getAc_exit() == 7l));
		assertTrue((statemachine.getAca_exit() == 6l));
		assertTrue((statemachine.getAcaa_exit() == 5l));
		assertTrue((statemachine.getAd_exit() == 11l));
		assertTrue((statemachine.getAda_exit() == 8l));
		assertTrue((statemachine.getAdb_exit() == 9l));
		assertTrue((statemachine.getAdc_exit() == 10l));
	}
	
	@Test
	public void exitFatStateByTransition() {
		statemachine.enter();
		statemachine.getSCInterface().raiseE();
		statemachine.getSCInterface().raiseE();
		statemachine.getSCInterface().raiseE();
		assertTrue(statemachine.isStateActive(State.main_region_A_r_AD));
		statemachine.getSCInterface().raiseE();
		assertTrue(statemachine.isStateActive(State.main_region_A_r_AA));
		assertTrue((statemachine.getA_exit() == 0l));
		assertTrue((statemachine.getAa_exit() == 1l));
		assertTrue((statemachine.getAb_exit() == 4l));
		assertTrue((statemachine.getAba_exit() == 2l));
		assertTrue((statemachine.getAbb_exit() == 3l));
		assertTrue((statemachine.getAc_exit() == 7l));
		assertTrue((statemachine.getAca_exit() == 6l));
		assertTrue((statemachine.getAcaa_exit() == 5l));
		assertTrue((statemachine.getAd_exit() == 11l));
		assertTrue((statemachine.getAda_exit() == 8l));
		assertTrue((statemachine.getAdb_exit() == 9l));
		assertTrue((statemachine.getAdc_exit() == 10l));
	}
	
	@Test
	public void exitFatStateByTransitionFromParent() {
		statemachine.enter();
		statemachine.getSCInterface().raiseE();
		statemachine.getSCInterface().raiseE();
		statemachine.getSCInterface().raiseE();
		assertTrue(statemachine.isStateActive(State.main_region_A_r_AD));
		statemachine.getSCInterface().raiseF();
		assertTrue(statemachine.isStateActive(State.main_region_A_r_AA));
		assertTrue((statemachine.getA_exit() == 12l));
		assertTrue((statemachine.getAa_exit() == 1l));
		assertTrue((statemachine.getAb_exit() == 4l));
		assertTrue((statemachine.getAba_exit() == 2l));
		assertTrue((statemachine.getAbb_exit() == 3l));
		assertTrue((statemachine.getAc_exit() == 7l));
		assertTrue((statemachine.getAca_exit() == 6l));
		assertTrue((statemachine.getAcaa_exit() == 5l));
		assertTrue((statemachine.getAd_exit() == 11l));
		assertTrue((statemachine.getAda_exit() == 8l));
		assertTrue((statemachine.getAdb_exit() == 9l));
		assertTrue((statemachine.getAdc_exit() == 10l));
	}
}
