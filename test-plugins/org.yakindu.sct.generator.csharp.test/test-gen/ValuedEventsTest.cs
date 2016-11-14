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
 *  Unit TestCase for ValuedEvents
 */
using System;
namespace Yakindu.SCR.ValuedEvents {
	using NUnit.Framework;
	using Yakindu.SCR;
	
	[TestFixture]
	public class ValuedEventsTest {
		private ValuedEventsStatemachine sct;
	
	[SetUp]
	public void setup() {
		sct = new ValuedEventsStatemachine();
		sct.init();
	}
	
		[Test]
		public void testvaluedEventsTest(){
			sct.enter();
			sct.runCycle();
			Assert.IsTrue(sct.getMyString() == "sct");
			sct.raiseIntegerEvent(23L);
			sct.raiseBooleanEvent(false);
			sct.raiseRealEvent(20L);
			sct.raiseStringEvent("tool");
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(ValuedEventsStatemachine.State.integer_region_D));
			Assert.IsTrue(sct.isStateActive(ValuedEventsStatemachine.State.string_region_D));
			Assert.IsTrue(sct.isStateActive(ValuedEventsStatemachine.State.boolean_region_D));
			Assert.IsTrue(sct.isStateActive(ValuedEventsStatemachine.State.real_region_D));
			Assert.IsTrue(sct.getMyInt() == 23L);
			Assert.IsTrue(sct.getMyBool() == false);
			Assert.IsTrue(sct.getMyReal() == 20L);
			Assert.IsTrue(sct.getMyString() == "tool");
		}
	}
}
