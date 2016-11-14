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
 *  Unit TestCase for TimedTransitions
 */
using System;
namespace Yakindu.SCR.TimedTransitions {
	using NUnit.Framework;
	using Yakindu.SCR;
	
	[TestFixture]
	public class TimedTransitionsTest {
		private TimedTransitionsStatemachine sct;
	
	[SetUp]
	public void setup() {
		sct = new TimedTransitionsStatemachine();
		sct.init();
	}
	
		[Test]
		public void testTimer01(){
			sct.enter();
			Assert.IsTrue(sct.isStateActive(TimedTransitionsStatemachine.State.main_region_Start));
			System.Threading.Thread.Sleep(2030);
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(TimedTransitionsStatemachine.State.main_region_End));
		}
	}
}
