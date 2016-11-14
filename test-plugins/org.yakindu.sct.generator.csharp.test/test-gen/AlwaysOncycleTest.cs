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
 *  Unit TestCase for AlwaysOncycle
 */
using System;
namespace Yakindu.SCR.AlwaysOncycle {
	using NUnit.Framework;
	using Yakindu.SCR;
	
	[TestFixture]
	public class AlwaysOncycleTest {
		private AlwaysOncycleStatemachine sct;
	
	[SetUp]
	public void setup() {
		sct = new AlwaysOncycleStatemachine();
		sct.init();
	}
	
		[Test]
		public void testalwaysOncycleTest(){
			sct.enter();
			Assert.IsTrue(sct.isStateActive(AlwaysOncycleStatemachine.State.main_region_StateA));
			while(sct.getValue() < 5L) {
				sct.runCycle();
				Assert.IsTrue(sct.isStateActive(AlwaysOncycleStatemachine.State.main_region_StateA));
			}
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(AlwaysOncycleStatemachine.State.main_region_StateB));
			while(sct.getValue() < 5L) {
				sct.runCycle();
				Assert.IsTrue(sct.isStateActive(AlwaysOncycleStatemachine.State.main_region_StateB));
			}
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(AlwaysOncycleStatemachine.State.main_region_StateA));
		}
	}
}
