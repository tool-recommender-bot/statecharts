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
 *  Unit TestCase for GuardedEntry
 */
using System;
namespace Yakindu.SCR.GuardedEntry {
	using NUnit.Framework;
	using Yakindu.SCR;
	
	[TestFixture]
	public class GuardedEntryTest {
		private GuardedEntryStatemachine sct;
	
	[SetUp]
	public void setup() {
		sct = new GuardedEntryStatemachine();
		sct.init();
	}
	
		[Test]
		public void testEntryNotTakenOnStatechartEnter(){
			Assert.IsTrue(sct.getGuard() == false);
			sct.enter();
			Assert.IsTrue(sct.isStateActive(GuardedEntryStatemachine.State.main_region_A));
			Assert.IsTrue(sct.getDone() == false);
		}
		[Test]
		public void testEntryTakenOnStatechartEnter(){
			sct.setGuard(true);
			sct.enter();
			Assert.IsTrue(sct.isStateActive(GuardedEntryStatemachine.State.main_region_A));
			Assert.IsTrue(sct.getDone() == true);
		}
		[Test]
		public void testEntryTakenInTransition(){
			sct.enter();
			Assert.IsTrue(sct.isStateActive(GuardedEntryStatemachine.State.main_region_A));
			sct.raiseE();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(GuardedEntryStatemachine.State.main_region_B));
			sct.setGuard(true);
			sct.setDone(false);
			sct.raiseE();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(GuardedEntryStatemachine.State.main_region_A));
			Assert.IsTrue(sct.getDone());
		}
		[Test]
		public void testEntryNotTakenInTransition(){
			sct.enter();
			Assert.IsTrue(sct.isStateActive(GuardedEntryStatemachine.State.main_region_A));
			sct.raiseE();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(GuardedEntryStatemachine.State.main_region_B));
			sct.setGuard(false);
			sct.setDone(false);
			sct.raiseE();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(GuardedEntryStatemachine.State.main_region_A));
			Assert.IsTrue(!sct.getDone());
		}
	}
}
