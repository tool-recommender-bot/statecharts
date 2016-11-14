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
 *  Unit TestCase for SimpleEvent
 */
using System;
namespace Yakindu.SCR.SimpleEvent {
	using NUnit.Framework;
	using Yakindu.SCR;
	
	[TestFixture]
	public class SimpleEventTest {
		private SimpleEventStatemachine sct;
	
	[SetUp]
	public void setup() {
		sct = new SimpleEventStatemachine();
		sct.init();
	}
	
		[Test]
		public void testsimpleEventTest(){
			sct.enter();
			Assert.IsTrue(sct.isStateActive(SimpleEventStatemachine.State.main_region_A));
			Assert.IsTrue(5L == 5L);
			sct.raiseEvent1();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(SimpleEventStatemachine.State.main_region_B));
			sct.runCycle();
			Assert.IsTrue(!sct.isStateActive(SimpleEventStatemachine.State.main_region_B));
		}
	}
}
