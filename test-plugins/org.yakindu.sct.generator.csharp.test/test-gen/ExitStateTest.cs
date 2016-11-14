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
 *  Unit TestCase for ExitState
 */
using System;
namespace Yakindu.SCR.ExitState {
	using NUnit.Framework;
	using Yakindu.SCR;
	
	[TestFixture]
	public class ExitStateTest {
		private ExitStateStatemachine sct;
	
	[SetUp]
	public void setup() {
		sct = new ExitStateStatemachine();
		sct.init();
	}
	
		[Test]
		public void testdefaultExit(){
			sct.enter();
			Assert.IsTrue(sct.isStateActive(ExitStateStatemachine.State.r_A));
			sct.raiseE();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(ExitStateStatemachine.State.r_E));
		}
		[Test]
		public void testnamedExitThroughNamedTransition(){
			sct.enter();
			Assert.IsTrue(sct.isStateActive(ExitStateStatemachine.State.r_A));
			sct.raiseF();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(ExitStateStatemachine.State.r_F));
		}
		[Test]
		public void testnamedExitThroughDefaultTransition(){
			sct.enter();
			Assert.IsTrue(sct.isStateActive(ExitStateStatemachine.State.r_A));
			sct.raiseG();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(ExitStateStatemachine.State.r_E));
		}
		[Test]
		public void testremainInA(){
			sct.enter();
			Assert.IsTrue(sct.isStateActive(ExitStateStatemachine.State.r_A));
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(ExitStateStatemachine.State.r_A));
		}
	}
}
