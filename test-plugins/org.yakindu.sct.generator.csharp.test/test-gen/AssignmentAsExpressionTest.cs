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
 *  Unit TestCase for AssignmentAsExpression
 */
using System;
namespace Yakindu.SCR.AssignmentAsExpression {
	using NUnit.Framework;
	using Yakindu.SCR;
	
	[TestFixture]
	public class AssignmentAsExpressionTest {
		private AssignmentAsExpressionStatemachine sct;
	
	[SetUp]
	public void setup() {
		sct = new AssignmentAsExpressionStatemachine();
		sct.init();
	}
	
		[Test]
		public void testsimpleAssignment(){
			sct.enter();
			Assert.IsTrue(sct.isStateActive(AssignmentAsExpressionStatemachine.State.main_region_Add));
			Assert.IsTrue(sct.getB() == 5L);
			Assert.IsTrue(sct.getA() == 9L);
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(AssignmentAsExpressionStatemachine.State.main_region_Subtract));
			Assert.IsTrue(sct.getD() == 6L);
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(AssignmentAsExpressionStatemachine.State.main_region_Multiply));
			Assert.IsTrue(sct.getE() == 15L);
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(AssignmentAsExpressionStatemachine.State.main_region_Divide));
			Assert.IsTrue(sct.getG() == 1L);
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(AssignmentAsExpressionStatemachine.State.main_region_Modulo));
			Assert.IsTrue(sct.getI() == 1L);
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(AssignmentAsExpressionStatemachine.State.main_region_Shift));
			Assert.IsTrue(sct.getJ() == 16L);
			Assert.IsTrue(sct.getK() == 4L);
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(AssignmentAsExpressionStatemachine.State.main_region_boolean_And));
			Assert.IsTrue(sct.getL() == 1L);
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(AssignmentAsExpressionStatemachine.State.main_region_boolean_Or));
			Assert.IsTrue(sct.getP() == 15L);
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(AssignmentAsExpressionStatemachine.State.main_region_boolean_Xor));
			Assert.IsTrue(sct.getU() == 12L);
			sct.exit();
		}
	}
}
