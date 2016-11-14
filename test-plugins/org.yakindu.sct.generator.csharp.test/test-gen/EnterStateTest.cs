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
 *  Unit TestCase for EnterState
 */
using System;
namespace Yakindu.SCR.EnterState {
	using NUnit.Framework;
	using Yakindu.SCR;
	
	[TestFixture]
	public class EnterStateTest {
		private EnterStateStatemachine sct;
	
	[SetUp]
	public void setup() {
		sct = new EnterStateStatemachine();
		sct.init();
	}
	
		[Test]
		public void testdefaultEntry(){
			sct.enter();
			Assert.IsTrue(sct.isStateActive(EnterStateStatemachine.State.r_A));
			sct.raiseE();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(EnterStateStatemachine.State.r_B_r_E));
		}
		[Test]
		public void testnamedEntryThroughNamedTransition(){
			sct.enter();
			Assert.IsTrue(sct.isStateActive(EnterStateStatemachine.State.r_A));
			sct.raiseF();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(EnterStateStatemachine.State.r_B_r_F));
		}
		[Test]
		public void testnamedEntryThroughDefaultTransition(){
			sct.enter();
			Assert.IsTrue(sct.isStateActive(EnterStateStatemachine.State.r_A));
			sct.raiseG();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(EnterStateStatemachine.State.r_B_r_E));
		}
	}
}
