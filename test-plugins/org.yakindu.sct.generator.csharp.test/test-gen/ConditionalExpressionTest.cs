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
 *  Unit TestCase for ConditionalExpressions
 */
using System;
namespace Yakindu.SCR.ConditionalExpressions {
	using NUnit.Framework;
	using Yakindu.SCR;
	
	[TestFixture]
	public class ConditionalExpressionTest {
		private ConditionalExpressionsStatemachine sct;
	
	[SetUp]
	public void setup() {
		sct = new ConditionalExpressionsStatemachine();
		sct.init();
	}
	
		[Test]
		public void testConditionalExpressionTest(){
			sct.enter();
			Assert.IsTrue(sct.isStateActive(ConditionalExpressionsStatemachine.State.main_region_A));
			Assert.IsTrue(sct.getCondition() == 1L);
			sct.raiseE();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(ConditionalExpressionsStatemachine.State.main_region_B));
			Assert.IsTrue(sct.getCondition() == 2L);
		}
	}
}
