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
 *  Unit TestCase for IntegerExpressions
 */
using System;
namespace Yakindu.SCR.IntegerExpressions {
	using NUnit.Framework;
	using Yakindu.SCR;
	
	[TestFixture]
	public class IntegerExpressionsTest {
		private IntegerExpressionsStatemachine sct;
	
	[SetUp]
	public void setup() {
		sct = new IntegerExpressionsStatemachine();
		sct.init();
	}
	
		[Test]
		public void testintegerExpressions(){
			sct.enter();
			Assert.IsTrue(sct.isStateActive(IntegerExpressionsStatemachine.State.main_region_StateA));
			Assert.IsTrue(sct.getMyInt1() == 10L);
			Assert.IsTrue(sct.getMyInt2() == 5L);
			sct.raiseE1();
			sct.runCycle();
			Assert.IsTrue(sct.getLess() == false);
			Assert.IsTrue(sct.getGreater() == true);
			Assert.IsTrue(sct.getEqualOrLess() == false);
			Assert.IsTrue(sct.getEqualOrGreater() == true);
			Assert.IsTrue(sct.getEqual() == false);
			Assert.IsTrue(sct.getNotEqual() == true);
			Assert.IsTrue(sct.getPlus() == 15L);
			Assert.IsTrue(sct.getMinus() == 5L);
			Assert.IsTrue(sct.getMultiply() == 50L);
			Assert.IsTrue(sct.getDivision() == 2L);
			Assert.IsTrue(sct.getModulo() == 0L);
			Assert.IsTrue(sct.getNegat() == - 10L );
			Assert.IsTrue(sct.getMultiAssign() == 20L);
			Assert.IsTrue(sct.getDivAssign() == 2L);
			Assert.IsTrue(sct.getPlusAssign() == 12L);
			Assert.IsTrue(sct.getMinusAssign() == - 8L );
			Assert.IsTrue(sct.getModuloAssign() == 0L);
		}
	}
}
