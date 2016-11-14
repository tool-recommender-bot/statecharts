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
 *  Unit TestCase for TransitionWithoutCondition
 */
using System;
namespace Yakindu.SCR.TransitionWithoutCondition {
	using NUnit.Framework;
	using Yakindu.SCR;
	
	[TestFixture]
	public class TransitionWithoutConditionTest {
		private TransitionWithoutConditionStatemachine sct;
	
	[SetUp]
	public void setup() {
		sct = new TransitionWithoutConditionStatemachine();
		sct.init();
	}
	
		[Test]
		public void testTransitionWithoutConditionTest(){
			sct.enter();
			Assert.IsTrue(sct.isStateActive(TransitionWithoutConditionStatemachine.State.main_region_A));
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(TransitionWithoutConditionStatemachine.State.main_region_B));
		}
	}
}
