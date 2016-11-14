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
 *  Unit TestCase for SimpleHierachy
 */
using System;
namespace Yakindu.SCR.SimpleHierachy {
	using NUnit.Framework;
	using Yakindu.SCR;
	
	[TestFixture]
	public class SimpleHierachyTest {
		private SimpleHierachyStatemachine sct;
	
	[SetUp]
	public void setup() {
		sct = new SimpleHierachyStatemachine();
		sct.init();
	}
	
		[Test]
		public void testsimpleHierachyTest(){
			sct.enter();
			Assert.IsTrue(sct.isStateActive(SimpleHierachyStatemachine.State.main_region_A));
			sct.raiseEvent1();
			sct.raiseEvent1();
			sct.raiseEvent1();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(SimpleHierachyStatemachine.State.main_region_B));
			Assert.IsTrue(sct.isStateActive(SimpleHierachyStatemachine.State.main_region_B_subregion1_B1));
		}
	}
}
