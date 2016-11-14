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
 *  Unit TestCase for Choice
 */
using System;
namespace Yakindu.SCR.Choice {
	using NUnit.Framework;
	using Yakindu.SCR;
	
	[TestFixture]
	public class ChoiceTest {
		private ChoiceStatemachine sct;
	
	[SetUp]
	public void setup() {
		sct = new ChoiceStatemachine();
		sct.init();
	}
	
		[Test]
		public void testelseChoiceUsingNonDefaultTransition(){
			sct.enter();
			Assert.IsTrue(sct.isStateActive(ChoiceStatemachine.State.main_region_A));
			sct.setC(true);
			sct.raiseE();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(ChoiceStatemachine.State.main_region_C));
		}
		[Test]
		public void testelseChoiceUsingDefaultTransition(){
			sct.enter();
			Assert.IsTrue(sct.isStateActive(ChoiceStatemachine.State.main_region_A));
			sct.setC(false);
			sct.raiseE();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(ChoiceStatemachine.State.main_region_B));
		}
		[Test]
		public void testdefaultChoiceUsingNonDefaultTransition(){
			sct.enter();
			Assert.IsTrue(sct.isStateActive(ChoiceStatemachine.State.main_region_A));
			sct.setC(true);
			sct.raiseG();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(ChoiceStatemachine.State.main_region_C));
		}
		[Test]
		public void testdefaultChoiceUsingDefaultTransition(){
			sct.enter();
			Assert.IsTrue(sct.isStateActive(ChoiceStatemachine.State.main_region_A));
			sct.setC(false);
			sct.raiseG();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(ChoiceStatemachine.State.main_region_B));
		}
		[Test]
		public void testuncheckedChoiceUsingNonDefaultTransition(){
			sct.enter();
			Assert.IsTrue(sct.isStateActive(ChoiceStatemachine.State.main_region_A));
			sct.setC(true);
			sct.raiseF();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(ChoiceStatemachine.State.main_region_C));
		}
		[Test]
		public void testuncheckedChoiceUsingDefaultTransition(){
			sct.enter();
			Assert.IsTrue(sct.isStateActive(ChoiceStatemachine.State.main_region_A));
			sct.setC(false);
			sct.raiseF();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(ChoiceStatemachine.State.main_region_B));
		}
		[Test]
		public void testalwaysTrueTransitionInChoice(){
			sct.enter();
			Assert.IsTrue(sct.isStateActive(ChoiceStatemachine.State.main_region_A));
			sct.setC(true);
			sct.raiseH();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(ChoiceStatemachine.State.main_region_C));
		}
	}
}
