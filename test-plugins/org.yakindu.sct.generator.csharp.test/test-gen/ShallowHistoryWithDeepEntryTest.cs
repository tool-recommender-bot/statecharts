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
 *  Unit TestCase for ShallowHistoryWithDeepEntry
 */
using System;
namespace Yakindu.SCR.ShallowHistoryWithDeepEntry {
	using NUnit.Framework;
	using Yakindu.SCR;
	
	[TestFixture]
	public class ShallowHistoryWithDeepEntryTest {
		private ShallowHistoryWithDeepEntryStatemachine sct;
	
	[SetUp]
	public void setup() {
		sct = new ShallowHistoryWithDeepEntryStatemachine();
		sct.init();
	}
	
		[Test]
		public void testnoDeepEntryWithinHistory(){
			sct.enter();
			Assert.IsTrue(sct.isStateActive(ShallowHistoryWithDeepEntryStatemachine.State.main_region_Y));
			sct.raiseToZ();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(ShallowHistoryWithDeepEntryStatemachine.State.main_region_Z__region0_A));
			sct.raiseToY();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(ShallowHistoryWithDeepEntryStatemachine.State.main_region_Y));
			sct.raiseToZ();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(ShallowHistoryWithDeepEntryStatemachine.State.main_region_Z__region0_A));
		}
		[Test]
		public void testdeepEntryWithinHistory(){
			sct.enter();
			Assert.IsTrue(sct.isStateActive(ShallowHistoryWithDeepEntryStatemachine.State.main_region_Y));
			sct.raiseToZ();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(ShallowHistoryWithDeepEntryStatemachine.State.main_region_Z__region0_A));
			sct.raiseToC();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(ShallowHistoryWithDeepEntryStatemachine.State.main_region_Z__region0_B__region0_C));
			Assert.IsTrue(sct.isStateActive(ShallowHistoryWithDeepEntryStatemachine.State.main_region_Z__region0_B));
			sct.raiseToY();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(ShallowHistoryWithDeepEntryStatemachine.State.main_region_Y));
			sct.raiseToZ();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(ShallowHistoryWithDeepEntryStatemachine.State.main_region_Z__region0_B__region0_C));
			Assert.IsTrue(sct.isStateActive(ShallowHistoryWithDeepEntryStatemachine.State.main_region_Z__region0_B));
		}
		[Test]
		public void testdirectDeepEntryIntoHistory(){
			sct.enter();
			Assert.IsTrue(sct.isStateActive(ShallowHistoryWithDeepEntryStatemachine.State.main_region_Y));
			sct.raiseToC();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(ShallowHistoryWithDeepEntryStatemachine.State.main_region_Z__region0_B__region0_C));
			Assert.IsTrue(sct.isStateActive(ShallowHistoryWithDeepEntryStatemachine.State.main_region_Z__region0_B));
			sct.raiseToY();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(ShallowHistoryWithDeepEntryStatemachine.State.main_region_Y));
			sct.raiseToZ();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(ShallowHistoryWithDeepEntryStatemachine.State.main_region_Z__region0_B__region0_C));
			Assert.IsTrue(sct.isStateActive(ShallowHistoryWithDeepEntryStatemachine.State.main_region_Z__region0_B));
		}
	}
}
