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
 *  Unit TestCase for TriggerGuardExpressions
 */
using System;
namespace Yakindu.SCR.TriggerGuardExpressions {
	using NUnit.Framework;
	using Yakindu.SCR;
	
	[TestFixture]
	public class TriggerGuardExpressionsTest {
		private TriggerGuardExpressionsStatemachine sct;
	
	[SetUp]
	public void setup() {
		sct = new TriggerGuardExpressionsStatemachine();
		sct.init();
	}
	
		[Test]
		public void testtrueGuard(){
			sct.enter();
			Assert.IsTrue(sct.isStateActive(TriggerGuardExpressionsStatemachine.State.main_region_A));
			sct.raiseE1();
			sct.setB(true);
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(TriggerGuardExpressionsStatemachine.State.main_region_B));
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(TriggerGuardExpressionsStatemachine.State.main_region_A));
			sct.raiseE2();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(TriggerGuardExpressionsStatemachine.State.main_region_B));
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(TriggerGuardExpressionsStatemachine.State.main_region_A));
			sct.raiseE1();
			sct.raiseE2();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(TriggerGuardExpressionsStatemachine.State.main_region_B));
		}
		[Test]
		public void testfalseGuard(){
			sct.enter();
			Assert.IsTrue(sct.isStateActive(TriggerGuardExpressionsStatemachine.State.main_region_A));
			sct.setB(false);
			sct.raiseE1();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(TriggerGuardExpressionsStatemachine.State.main_region_A));
			sct.raiseE2();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(TriggerGuardExpressionsStatemachine.State.main_region_A));
			sct.raiseE1();
			sct.raiseE2();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(TriggerGuardExpressionsStatemachine.State.main_region_A));
		}
	}
}
