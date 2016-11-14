/**
* Copyright (c) 2016 committers of YAKINDU and others.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*     committers of YAKINDU - initial API and implementation
*/
/**
 *  Unit TestCase for SyncJoin
 */
using System;
namespace Yakindu.SCR.SyncJoin {
	using NUnit.Framework;
	using Yakindu.SCR;
	
	[TestFixture]
	public class SyncJoinTest {
		private SyncJoinStatemachine sct;
	
	[SetUp]
	public void setup() {
		sct = new SyncJoinStatemachine();
		sct.init();
	}
	
		[Test]
		public void testsyncJoin_C2_Waits(){
			sct.enter();
			Assert.IsTrue(sct.isStateActive(SyncJoinStatemachine.State.main_region_B));
			Assert.IsTrue(sct.isStateActive(SyncJoinStatemachine.State.main_region_B_r1_C1));
			Assert.IsTrue(sct.isStateActive(SyncJoinStatemachine.State.main_region_B_r2_D1));
			sct.raiseE();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(SyncJoinStatemachine.State.main_region_B_r1_C2));
			Assert.IsTrue(sct.isStateActive(SyncJoinStatemachine.State.main_region_B_r2_D1));
			sct.raiseJc();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(SyncJoinStatemachine.State.main_region_B_r1_C2));
			Assert.IsTrue(sct.isStateActive(SyncJoinStatemachine.State.main_region_B_r2_D1));
			sct.raiseJd();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(SyncJoinStatemachine.State.main_region_B_r1_C2));
			Assert.IsTrue(sct.isStateActive(SyncJoinStatemachine.State.main_region_B_r2_D1));
			sct.raiseJc();
			sct.raiseJd();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(SyncJoinStatemachine.State.main_region_B_r1_C2));
			Assert.IsTrue(sct.isStateActive(SyncJoinStatemachine.State.main_region_B_r2_D1));
			sct.raiseF();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(SyncJoinStatemachine.State.main_region_B_r1_C2));
			Assert.IsTrue(sct.isStateActive(SyncJoinStatemachine.State.main_region_B_r2_D2));
			sct.raiseJc();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(SyncJoinStatemachine.State.main_region_B_r1_C2));
			Assert.IsTrue(sct.isStateActive(SyncJoinStatemachine.State.main_region_B_r2_D2));
			sct.raiseJd();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(SyncJoinStatemachine.State.main_region_B_r1_C2));
			Assert.IsTrue(sct.isStateActive(SyncJoinStatemachine.State.main_region_B_r2_D2));
			sct.raiseJc();
			sct.raiseJd();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(SyncJoinStatemachine.State.main_region_A));
		}
		[Test]
		public void testsyncJoin_D2_Waits(){
			sct.enter();
			Assert.IsTrue(sct.isStateActive(SyncJoinStatemachine.State.main_region_B));
			Assert.IsTrue(sct.isStateActive(SyncJoinStatemachine.State.main_region_B_r1_C1));
			Assert.IsTrue(sct.isStateActive(SyncJoinStatemachine.State.main_region_B_r2_D1));
			sct.raiseF();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(SyncJoinStatemachine.State.main_region_B_r1_C1));
			Assert.IsTrue(sct.isStateActive(SyncJoinStatemachine.State.main_region_B_r2_D2));
			sct.raiseJc();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(SyncJoinStatemachine.State.main_region_B_r1_C1));
			Assert.IsTrue(sct.isStateActive(SyncJoinStatemachine.State.main_region_B_r2_D2));
			sct.raiseJd();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(SyncJoinStatemachine.State.main_region_B_r1_C1));
			Assert.IsTrue(sct.isStateActive(SyncJoinStatemachine.State.main_region_B_r2_D2));
			sct.raiseJc();
			sct.raiseJd();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(SyncJoinStatemachine.State.main_region_B_r1_C1));
			Assert.IsTrue(sct.isStateActive(SyncJoinStatemachine.State.main_region_B_r2_D2));
			sct.raiseE();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(SyncJoinStatemachine.State.main_region_B_r1_C2));
			Assert.IsTrue(sct.isStateActive(SyncJoinStatemachine.State.main_region_B_r2_D2));
		}
		[Test]
		public void testdoubleEntryActionBug(){
			sct.enter();
			sct.raiseE();
			sct.raiseF();
			sct.runCycle();
			sct.raiseJc();
			sct.raiseJd();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(SyncJoinStatemachine.State.main_region_A));
			Assert.IsTrue(sct.getX() == 1L);
		}
	}
}
