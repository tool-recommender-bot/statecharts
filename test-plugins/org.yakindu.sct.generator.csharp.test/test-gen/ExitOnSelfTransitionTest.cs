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
 *  Unit TestCase for ExitOnSelfTransition
 */
using System;
namespace Yakindu.SCR.ExitOnSelfTransition {
	using NUnit.Framework;
	using Yakindu.SCR;
	
	[TestFixture]
	public class ExitOnSelfTransitionTest {
		private ExitOnSelfTransitionStatemachine sct;
	
	[SetUp]
	public void setup() {
		sct = new ExitOnSelfTransitionStatemachine();
		sct.init();
	}
	
		[Test]
		public void testExitOnSelfTransitionTest(){
			sct.enter();
			Assert.IsTrue(sct.isStateActive(ExitOnSelfTransitionStatemachine.State.main_region_A));
			Assert.IsTrue(sct.getEntryCount() == 1L);
			Assert.IsTrue(sct.getExitCount() == 0L);
			sct.raiseE();
			sct.runCycle();
			Assert.IsTrue(sct.getEntryCount() == 2L);
			Assert.IsTrue(sct.getExitCount() == 1L);
			sct.raiseF();
			sct.runCycle();
			Assert.IsTrue(sct.getEntryCount() == 2L);
			Assert.IsTrue(sct.getExitCount() == 2L);
		}
	}
}
