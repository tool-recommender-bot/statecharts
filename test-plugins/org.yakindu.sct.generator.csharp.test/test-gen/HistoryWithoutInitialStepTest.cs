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
 *  Unit TestCase for HistoryWithoutInitialStep
 */
using System;
namespace Yakindu.SCR.HistoryWithoutInitialStep {
	using NUnit.Framework;
	using Yakindu.SCR;
	
	[TestFixture]
	public class HistoryWithoutInitialStepTest {
		private HistoryWithoutInitialStepStatemachine sct;
	
	[SetUp]
	public void setup() {
		sct = new HistoryWithoutInitialStepStatemachine();
		sct.init();
	}
	
		[Test]
		public void testenterThroughInitialEntry(){
			sct.enter();
			Assert.IsTrue(sct.isStateActive(HistoryWithoutInitialStepStatemachine.State.main_region_A));
			sct.raiseToB();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(HistoryWithoutInitialStepStatemachine.State.main_region_B_r1_C));
			sct.raiseNext();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(HistoryWithoutInitialStepStatemachine.State.main_region_B_r1_D));
		}
		[Test]
		public void testenterCThroughHistory(){
			sct.enter();
			Assert.IsTrue(sct.isStateActive(HistoryWithoutInitialStepStatemachine.State.main_region_A));
			sct.raiseToB();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(HistoryWithoutInitialStepStatemachine.State.main_region_B_r1_C));
			sct.raiseToA();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(HistoryWithoutInitialStepStatemachine.State.main_region_A));
			sct.raiseToHistory();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(HistoryWithoutInitialStepStatemachine.State.main_region_B_r1_C));
		}
		[Test]
		public void testenterDThroughHistory(){
			sct.enter();
			Assert.IsTrue(sct.isStateActive(HistoryWithoutInitialStepStatemachine.State.main_region_A));
			sct.raiseToB();
			sct.runCycle();
			sct.raiseNext();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(HistoryWithoutInitialStepStatemachine.State.main_region_B_r1_D));
			sct.raiseToA();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(HistoryWithoutInitialStepStatemachine.State.main_region_A));
			sct.raiseToHistory();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(HistoryWithoutInitialStepStatemachine.State.main_region_B_r1_D));
		}
	}
}
