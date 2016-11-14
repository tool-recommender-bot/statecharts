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
 *  Unit TestCase for BitExpressions
 */
using System;
namespace Yakindu.SCR.BitExpressions {
	using NUnit.Framework;
	using Yakindu.SCR;
	
	[TestFixture]
	public class BitExpressionsTest {
		private BitExpressionsStatemachine sct;
	
	[SetUp]
	public void setup() {
		sct = new BitExpressionsStatemachine();
		sct.init();
	}
	
		[Test]
		public void testBitExpressions(){
			sct.enter();
			Assert.IsTrue(sct.isStateActive(BitExpressionsStatemachine.State.main_region_StateA));
			Assert.IsTrue(sct.getMyBit1() == 5L);
			Assert.IsTrue(sct.getMyBit2() == 7L);
			sct.raiseE1();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(BitExpressionsStatemachine.State.main_region_StateB));
			Assert.IsTrue(sct.getLeftBitshift() == 10L);
			Assert.IsTrue(sct.getRightBitshift() == 2L);
			Assert.IsTrue(sct.getComplementBitshift() == - 6L );
			Assert.IsTrue(sct.getBitwiseAnd() == 5L);
			Assert.IsTrue(sct.getBitwiseOr() == 7L);
			Assert.IsTrue(sct.getBitwiseXor() == 2L);
		}
	}
}
