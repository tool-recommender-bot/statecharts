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
 *  Unit TestCase for StateIsActive
 */
using System;
namespace Yakindu.SCR.StateIsActive {
	using NUnit.Framework;
	using Yakindu.SCR;
	
	[TestFixture]
	public class StateIsActiveTest {
		private StateIsActiveStatemachine sct;
	
	[SetUp]
	public void setup() {
		sct = new StateIsActiveStatemachine();
		sct.init();
	}
	
		[Test]
		public void teststateIsActive(){
			sct.enter();
			Assert.IsTrue(sct.isStateActive(StateIsActiveStatemachine.State.r1_R1A));
			Assert.IsTrue(sct.isStateActive(StateIsActiveStatemachine.State.r2_R2A));
			sct.raiseEvent1();
			sct.runCycle();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(StateIsActiveStatemachine.State.r1_R1B));
			Assert.IsTrue(sct.isStateActive(StateIsActiveStatemachine.State.r2_R2B));
		}
	}
}
