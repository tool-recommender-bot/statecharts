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
 *  Unit TestCase for EntryExitSelfTransition
 */
using System;
namespace Yakindu.SCR.EntryExitSelfTransition {
	using NUnit.Framework;
	using Yakindu.SCR;
	
	[TestFixture]
	public class EntryExitSelfTransitionTest {
		private EntryExitSelfTransitionStatemachine sct;
	
	[SetUp]
	public void setup() {
		sct = new EntryExitSelfTransitionStatemachine();
		sct.init();
	}
	
		[Test]
		public void testSelfTransitionToChildState(){
			sct.enter();
			sct.runCycle();
			Assert.IsTrue(sct.getEntries() == 1L);
			Assert.IsTrue(sct.isStateActive(EntryExitSelfTransitionStatemachine.State.main_region_A__region0_B));
			sct.setEntries(0L);
			sct.raiseE();
			sct.runCycle();
			Assert.IsTrue(sct.getEntries() == 1L);
			Assert.IsTrue(sct.getExits() == 1L);
			Assert.IsTrue(sct.isStateActive(EntryExitSelfTransitionStatemachine.State.main_region_A__region0_C));
		}
		[Test]
		public void testSelfTransitionFromChildState(){
			sct.enter();
			sct.runCycle();
			Assert.IsTrue(sct.getEntries() == 1L);
			sct.setEntries(0L);
			sct.raiseE1();
			sct.runCycle();
			Assert.IsTrue(sct.getEntries() == 0L);
			Assert.IsTrue(sct.getExits() == 0L);
			Assert.IsTrue(sct.isStateActive(EntryExitSelfTransitionStatemachine.State.main_region_A__region0_C));
			sct.raiseE1();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(EntryExitSelfTransitionStatemachine.State.main_region_A__region0_B));
			Assert.IsTrue(sct.getEntries() == 1L);
			Assert.IsTrue(sct.getExits() == 1L);
		}
	}
}
