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
 *  Unit TestCase for RaiseEvent
 */
using System;
namespace Yakindu.SCR.RaiseEvent {
	using NUnit.Framework;
	using Yakindu.SCR;
	
	[TestFixture]
	public class RaiseEventTest {
		private RaiseEventStatemachine sct;
	
	[SetUp]
	public void setup() {
		sct = new RaiseEventStatemachine();
		sct.init();
	}
	
		[Test]
		public void testraiseEvent(){
			sct.enter();
			Assert.IsTrue(sct.isStateActive(RaiseEventStatemachine.State.second_region_SateA));
			Assert.IsTrue(sct.isStateActive(RaiseEventStatemachine.State.main_region_StateA));
			sct.raiseE2();
			sct.runCycle();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(RaiseEventStatemachine.State.second_region_StateB));
			Assert.IsTrue(sct.isStateActive(RaiseEventStatemachine.State.main_region_StateB));
		}
	}
}
