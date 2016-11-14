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
 *  Unit TestCase for TriggerExpressionPrecedence
 */
using System;
namespace Yakindu.SCR.TriggerExpressionPrecedence {
	using NUnit.Framework;
	using Yakindu.SCR;
	
	[TestFixture]
	public class TriggerExpressionPrecedenceTest {
		private TriggerExpressionPrecedenceStatemachine sct;
	
	[SetUp]
	public void setup() {
		sct = new TriggerExpressionPrecedenceStatemachine();
		sct.init();
	}
	
		[Test]
		public void testunsatisfiedTriggerAndFGuardFalseOrFalse(){
			sct.enter();
			sct.setC1(false);
			sct.setC2(false);
			sct.runCycle();
			Assert.IsTrue(!sct.getE1_transition());
		}
		[Test]
		public void testunsatisfiedTriggerAndFGuardTrueOrFalse(){
			sct.enter();
			sct.setC1(true);
			sct.setC2(false);
			sct.runCycle();
			Assert.IsTrue(!sct.getE1_transition());
		}
		[Test]
		public void testunsatisfiedTriggerAndFGuardFalseOrTrue(){
			sct.enter();
			sct.setC1(false);
			sct.setC2(true);
			sct.runCycle();
			Assert.IsTrue(!sct.getE1_transition());
		}
		[Test]
		public void testunsatisfiedTriggerAndFGuardTrueOrTrue(){
			sct.enter();
			sct.setC1(true);
			sct.setC2(true);
			sct.runCycle();
			Assert.IsTrue(!sct.getE1_transition());
		}
	}
}
