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
 *  Unit TestCase for Guard
 */
using System;
namespace Yakindu.SCR.Guard {
	using NUnit.Framework;
	using Yakindu.SCR;
	
	[TestFixture]
	public class GuardTest {
		private GuardStatemachine sct;
	
	[SetUp]
	public void setup() {
		sct = new GuardStatemachine();
		sct.init();
	}
	
		[Test]
		public void testguardTest(){
			sct.enter();
			Assert.IsTrue(sct.isStateActive(GuardStatemachine.State.main_region_A));
			sct.raiseEvent1();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(GuardStatemachine.State.main_region_A));
			sct.raiseEvent2();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(GuardStatemachine.State.main_region_B));
			sct.raiseReturn();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(GuardStatemachine.State.main_region_A));
			sct.raiseEvent1();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(GuardStatemachine.State.main_region_B));
			sct.raiseReturn();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(GuardStatemachine.State.main_region_A));
		}
	}
}
