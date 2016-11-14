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
 *  Unit TestCase for ReadOnlyVariable
 */
using System;
namespace Yakindu.SCR.ReadOnlyVariable {
	using NUnit.Framework;
	using Yakindu.SCR;
	
	[TestFixture]
	public class ReadOnlyVariableTest {
		private ReadOnlyVariableStatemachine sct;
	
	[SetUp]
	public void setup() {
		sct = new ReadOnlyVariableStatemachine();
		sct.init();
	}
	
		[Test]
		public void testReadOnlyVariableTest(){
			sct.enter();
			Assert.IsTrue(sct.isStateActive(ReadOnlyVariableStatemachine.State.main_region_StateA));
			Assert.IsTrue(sct.getMyInt() == 0L);
			Assert.IsTrue(sct.getMyString() == "testString");
			Assert.IsTrue(sct.getMyBool() == true);
			Assert.IsTrue(sct.getMyReal() == 1.1);
			Assert.IsTrue(sct.getSCIA().getMyInt() == 0L);
			Assert.IsTrue(sct.getSCIA().getMyString() == "testString");
			Assert.IsTrue(sct.getSCIA().getMyBool() == true);
			Assert.IsTrue(sct.getSCIA().getMyReal() == 1.1);
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(ReadOnlyVariableStatemachine.State.main_region_StateB));
			Assert.IsTrue(sct.getMyInt() == 100L);
			Assert.IsTrue(sct.getMyString() == "fail");
			Assert.IsTrue(sct.getMyBool() == false);
			Assert.IsTrue(sct.getMyReal() == 6.6);
			Assert.IsTrue(sct.getSCIA().getMyInt() == 200L);
			Assert.IsTrue(sct.getSCIA().getMyString() == "A_fail");
			Assert.IsTrue(sct.getSCIA().getMyBool() == false);
			Assert.IsTrue(sct.getSCIA().getMyReal() == 7.7);
		}
	}
}
