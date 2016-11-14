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
 *  Unit TestCase for CastExpressions
 */
using System;
namespace Yakindu.SCR.CastExpressions {
	using NUnit.Framework;
	using Yakindu.SCR;
	
	[TestFixture]
	public class CastExpressionsTest {
		private CastExpressionsStatemachine sct;
	
	[SetUp]
	public void setup() {
		sct = new CastExpressionsStatemachine();
		sct.init();
	}
	
		[Test]
		public void testCastExpressionTest(){
			sct.enter();
			Assert.IsTrue(sct.getRealValue() == 5L);
			Assert.IsTrue(sct.getIntValue() == 5L);
			sct.runCycle();
			Assert.IsTrue(sct.getRealValue() == 15L);
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(CastExpressionsStatemachine.State.main_region_C));
			Assert.IsTrue(sct.getRealValue() == 757L);
		}
	}
}
