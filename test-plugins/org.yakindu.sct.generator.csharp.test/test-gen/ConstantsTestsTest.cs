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
 *  Unit TestCase for Constants
 */
using System;
namespace Yakindu.SCR.Constants {
	using NUnit.Framework;
	using Yakindu.SCR;
	
	[TestFixture]
	public class ConstantsTestsTest {
		private ConstantsStatemachine sct;
	
	[SetUp]
	public void setup() {
		sct = new ConstantsStatemachine();
		sct.init();
	}
	
		[Test]
		public void testconstantDefinition(){
			sct.enter();
			Assert.IsTrue(sct.isStateActive(ConstantsStatemachine.State.main_region_A));
			Assert.IsTrue(sct.getX() == 10L);
			Assert.IsTrue(sct.getY() == 20L);
			Assert.IsTrue(sct.getSCINamed().getY() == "Hello World");
			sct.raiseE();
			sct.runCycle();
			Assert.IsTrue(sct.getResult() == 20L);
			sct.raiseE();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(ConstantsStatemachine.State.main_region_C));
			Assert.IsTrue(sct.getResult() == 100L);
			sct.raiseE2(sct.getX());
			sct.runCycle();
			Assert.IsTrue(sct.getResult() == 1000L);
			Assert.IsTrue(sct.isStateActive(ConstantsStatemachine.State.main_region_A));
		}
	}
}
