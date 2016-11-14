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
 *  Unit TestCase for StringExpressions
 */
using System;
namespace Yakindu.SCR.StringExpressions {
	using NUnit.Framework;
	using Yakindu.SCR;
	
	[TestFixture]
	public class StringExpressionsTest {
		private StringExpressionsStatemachine sct;
	
	[SetUp]
	public void setup() {
		sct = new StringExpressionsStatemachine();
		sct.init();
	}
	
		[Test]
		public void testStringExpressionsTest(){
			Assert.IsTrue(sct.getQuotedStringX() == "\"X\"");
			Assert.IsTrue(sct.getQuotedStringY() == "\"Y\"");
			sct.enter();
			Assert.IsTrue(sct.isStateActive(StringExpressionsStatemachine.State.main_region_AssignmentChecked));
			sct.raiseE();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(StringExpressionsStatemachine.State.main_region_VarToVarCompareSucceeded));
			Assert.IsTrue(sct.getGuardStringEqual());
			Assert.IsTrue(sct.getGuardStringNotEqual());
			Assert.IsTrue(sct.getStringVarEqual());
			Assert.IsTrue(sct.getStringVarNotEqual());
			sct.raiseE();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(StringExpressionsStatemachine.State.main_region_VarToConstCompareSucceeded));
			Assert.IsTrue(sct.getGuardStringEqual());
			Assert.IsTrue(sct.getGuardStringNotEqual());
			Assert.IsTrue(sct.getStringVarEqual());
			Assert.IsTrue(sct.getStringVarNotEqual());
			sct.raiseE();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(StringExpressionsStatemachine.State.main_region_ConstToVarCompareSucceeded));
			Assert.IsTrue(sct.getGuardStringEqual());
			Assert.IsTrue(sct.getGuardStringNotEqual());
			Assert.IsTrue(sct.getStringVarEqual());
			Assert.IsTrue(sct.getStringVarNotEqual());
			sct.raiseE();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(StringExpressionsStatemachine.State.main_region_ConstToConstCompareSucceeded));
			Assert.IsTrue(sct.getGuardStringEqual());
			Assert.IsTrue(sct.getGuardStringNotEqual());
			Assert.IsTrue(sct.getStringVarEqual());
			Assert.IsTrue(sct.getStringVarNotEqual());
		}
	}
}
