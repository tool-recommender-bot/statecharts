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
 *  Unit TestCase for EmptyTransition
 */
using System;
namespace Yakindu.SCR.EmptyTransition {
	using NUnit.Framework;
	using Yakindu.SCR;
	
	[TestFixture]
	public class EmptyTransitionTest {
		private EmptyTransitionStatemachine sct;
	
	[SetUp]
	public void setup() {
		sct = new EmptyTransitionStatemachine();
		sct.init();
	}
	
		[Test]
		public void testEmptyTransitionTest(){
			sct.enter();
			sct.runCycle();
			Assert.IsTrue(!sct.isStateActive(EmptyTransitionStatemachine.State.main_region_B));
			Assert.IsTrue(sct.isStateActive(EmptyTransitionStatemachine.State.main_region_A));
		}
	}
}
