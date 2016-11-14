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
 *  Unit TestCase for PriorityValues
 */
using System;
namespace Yakindu.SCR.PriorityValues {
	using NUnit.Framework;
	using Yakindu.SCR;
	
	[TestFixture]
	public class PriorityValuesTest {
		private PriorityValuesStatemachine sct;
	
	[SetUp]
	public void setup() {
		sct = new PriorityValuesStatemachine();
		sct.init();
	}
	
		[Test]
		public void testtransitionPriority(){
			sct.enter();
			Assert.IsTrue(sct.isStateActive(PriorityValuesStatemachine.State.main_region_A));
			sct.raiseEvent1();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(PriorityValuesStatemachine.State.main_region_C));
		}
		[Test]
		public void testregionPriority(){
			sct.enter();
			Assert.IsTrue(sct.isStateActive(PriorityValuesStatemachine.State.someRegion_A));
			sct.raiseEvent2();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(PriorityValuesStatemachine.State.someRegion_B));
			Assert.IsTrue(!sct.isStateActive(PriorityValuesStatemachine.State.main_region_E));
		}
	}
}
