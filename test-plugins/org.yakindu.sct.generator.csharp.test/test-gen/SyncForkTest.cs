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
 *  Unit TestCase for SyncFork
 */
using System;
namespace Yakindu.SCR.SyncFork {
	using NUnit.Framework;
	using Yakindu.SCR;
	
	[TestFixture]
	public class SyncForkTest {
		private SyncForkStatemachine sct;
	
	[SetUp]
	public void setup() {
		sct = new SyncForkStatemachine();
		sct.init();
	}
	
		[Test]
		public void testsyncForkTest(){
			sct.enter();
			Assert.IsTrue(sct.isStateActive(SyncForkStatemachine.State.main_region_A));
			sct.raiseF();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(SyncForkStatemachine.State.main_region_B));
			Assert.IsTrue(sct.isStateActive(SyncForkStatemachine.State.main_region_B_r1_C1));
			Assert.IsTrue(sct.isStateActive(SyncForkStatemachine.State.main_region_B_r2_D1));
			sct.raiseF();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(SyncForkStatemachine.State.main_region_B));
			Assert.IsTrue(sct.isStateActive(SyncForkStatemachine.State.main_region_B_r1_C2));
			Assert.IsTrue(sct.isStateActive(SyncForkStatemachine.State.main_region_B_r2_D2));
			sct.raiseE();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(SyncForkStatemachine.State.main_region_A));
			sct.raiseF();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(SyncForkStatemachine.State.main_region_B));
			Assert.IsTrue(sct.isStateActive(SyncForkStatemachine.State.main_region_B_r1_C1));
			Assert.IsTrue(sct.isStateActive(SyncForkStatemachine.State.main_region_B_r2_D1));
		}
	}
}
