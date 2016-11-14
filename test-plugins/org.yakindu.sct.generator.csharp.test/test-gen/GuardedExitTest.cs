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
 *  Unit TestCase for GuardedExit
 */
using System;
namespace Yakindu.SCR.GuardedExit {
	using NUnit.Framework;
	using Yakindu.SCR;
	
	[TestFixture]
	public class GuardedExitTest {
		private GuardedExitStatemachine sct;
	
	[SetUp]
	public void setup() {
		sct = new GuardedExitStatemachine();
		sct.init();
	}
	
		[Test]
		public void testExitTaken(){
			sct.enter();
			Assert.IsTrue(sct.isStateActive(GuardedExitStatemachine.State.main_region_A));
			Assert.IsTrue(!sct.getGuard());
			sct.raiseE();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(GuardedExitStatemachine.State.main_region_B));
			Assert.IsTrue(!sct.getDone());
		}
		[Test]
		public void testExitNotTaken(){
			sct.enter();
			Assert.IsTrue(sct.isStateActive(GuardedExitStatemachine.State.main_region_A));
			sct.setGuard(true);
			sct.raiseE();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(GuardedExitStatemachine.State.main_region_B));
			Assert.IsTrue(sct.getDone());
		}
	}
}
