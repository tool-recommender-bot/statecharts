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
 *  Unit TestCase for BooleanExpressions
 */
using System;
namespace Yakindu.SCR.BooleanExpressions {
	using NUnit.Framework;
	using Yakindu.SCR;
	
	[TestFixture]
	public class BooleanExpressionsTest {
		private BooleanExpressionsStatemachine sct;
	
	[SetUp]
	public void setup() {
		sct = new BooleanExpressionsStatemachine();
		sct.init();
	}
	
		[Test]
		public void testbooleanExpressions(){
			sct.enter();
			Assert.IsTrue(sct.isStateActive(BooleanExpressionsStatemachine.State.main_region_StateA));
			Assert.IsTrue(sct.getMyBool1() == true);
			Assert.IsTrue(sct.getMyBool2() == false);
			sct.raiseE1();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(BooleanExpressionsStatemachine.State.main_region_StateB));
			Assert.IsTrue(sct.getAnd() == false);
			Assert.IsTrue(sct.getOr() == true);
			Assert.IsTrue(sct.getNot() == false);
			Assert.IsTrue(sct.getEqual() == false);
			Assert.IsTrue(sct.getNotequal() == true);
		}
	}
}
