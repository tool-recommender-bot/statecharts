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
 *  Unit TestCase for StatechartLocalReactions
 */
using System;
namespace Yakindu.SCR.StatechartLocalReactions {
	using NUnit.Framework;
	using Yakindu.SCR;
	
	[TestFixture]
	public class StatechartLocalReactionsTest {
		private StatechartLocalReactionsStatemachine sct;
	
	[SetUp]
	public void setup() {
		sct = new StatechartLocalReactionsStatemachine();
		sct.init();
	}
	
		[Test]
		public void teststatechartLocalReactionsTest(){
			sct.enter();
			Assert.IsTrue(sct.isStateActive(StatechartLocalReactionsStatemachine.State.main_region_S1));
			Assert.IsTrue(sct.isStateActive(StatechartLocalReactionsStatemachine.State.region2_a));
			while(sct.getMyInt() < 10L) {
				Assert.IsTrue(sct.isStateActive(StatechartLocalReactionsStatemachine.State.region2_a));
				if(sct.getMyInt()%2L == 0L) {
							Assert.IsTrue(sct.isStateActive(StatechartLocalReactionsStatemachine.State.main_region_S1));;
						  }
						else {
							Assert.IsTrue(sct.isStateActive(StatechartLocalReactionsStatemachine.State.main_region_S2));;
						}
				sct.runCycle();
			}
		}
	}
}
