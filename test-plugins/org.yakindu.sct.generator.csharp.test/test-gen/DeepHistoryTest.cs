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
 *  Unit TestCase for DeepHistory
 */
using System;
namespace Yakindu.SCR.DeepHistory {
	using NUnit.Framework;
	using Yakindu.SCR;
	
	[TestFixture]
	public class DeepHistoryTest {
		private DeepHistoryStatemachine sct;
	
	[SetUp]
	public void setup() {
		sct = new DeepHistoryStatemachine();
		sct.init();
	}
	
		[Test]
		public void testdeepHistoryTest(){
			sct.enter();
			sct.raiseEvent1();
			sct.runCycle();
			sct.raiseEvent3();
			sct.runCycle();
			sct.raiseEvent5();
			sct.runCycle();
			sct.raiseEvent7();
			sct.runCycle();
			Assert.IsTrue(!sct.isStateActive(DeepHistoryStatemachine.State.mainRegion_State1));
			Assert.IsTrue(sct.isStateActive(DeepHistoryStatemachine.State.mainRegion_State2__region0_State4__region0_State7__region0_State9));
			sct.raiseEvent2();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(DeepHistoryStatemachine.State.mainRegion_State1));
			Assert.IsTrue(!sct.isStateActive(DeepHistoryStatemachine.State.mainRegion_State2__region0_State4__region0_State7__region0_State9));
			sct.raiseEvent1();
			sct.runCycle();
			Assert.IsTrue(!sct.isStateActive(DeepHistoryStatemachine.State.mainRegion_State1));
			Assert.IsTrue(sct.isStateActive(DeepHistoryStatemachine.State.mainRegion_State2__region0_State4__region0_State7__region0_State9));
		}
	}
}
