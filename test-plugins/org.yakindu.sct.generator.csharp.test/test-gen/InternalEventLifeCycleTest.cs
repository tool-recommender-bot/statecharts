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
 *  Unit TestCase for InternalEventLifeCycle
 */
using System;
namespace Yakindu.SCR.InternalEventLifeCycle {
	using NUnit.Framework;
	using Yakindu.SCR;
	
	[TestFixture]
	public class InternalEventLifeCycleTest {
		private InternalEventLifeCycleStatemachine sct;
	
	[SetUp]
	public void setup() {
		sct = new InternalEventLifeCycleStatemachine();
		sct.init();
	}
	
		[Test]
		public void testInternalEventLifeCycleTest(){
			sct.enter();
			Assert.IsTrue(sct.isStateActive(InternalEventLifeCycleStatemachine.State.r1_A));
			Assert.IsTrue(sct.isStateActive(InternalEventLifeCycleStatemachine.State.r2_C));
			sct.raiseE();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(InternalEventLifeCycleStatemachine.State.r1_A));
			Assert.IsTrue(sct.isStateActive(InternalEventLifeCycleStatemachine.State.r2_D));
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(InternalEventLifeCycleStatemachine.State.r1_A));
			Assert.IsTrue(sct.isStateActive(InternalEventLifeCycleStatemachine.State.r2_D));
			sct.raiseF();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(InternalEventLifeCycleStatemachine.State.r1_A));
			Assert.IsTrue(sct.isStateActive(InternalEventLifeCycleStatemachine.State.r2_C));
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(InternalEventLifeCycleStatemachine.State.r1_A));
			Assert.IsTrue(sct.isStateActive(InternalEventLifeCycleStatemachine.State.r2_C));
		}
	}
}
