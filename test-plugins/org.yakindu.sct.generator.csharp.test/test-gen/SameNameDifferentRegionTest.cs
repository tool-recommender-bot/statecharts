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
 *  Unit TestCase for SameNameDifferentRegion
 */
using System;
namespace Yakindu.SCR.SameNameDifferentRegion {
	using NUnit.Framework;
	using Yakindu.SCR;
	
	[TestFixture]
	public class SameNameDifferentRegionTest {
		private SameNameDifferentRegionStatemachine sct;
	
	[SetUp]
	public void setup() {
		sct = new SameNameDifferentRegionStatemachine();
		sct.init();
	}
	
		[Test]
		public void testsameNameDifferenRegionTest(){
			sct.enter();
			Assert.IsTrue(sct.isStateActive(SameNameDifferentRegionStatemachine.State.main_region_StateA));
			sct.raiseE1();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(SameNameDifferentRegionStatemachine.State.main_region_StateB));
			Assert.IsTrue(sct.isStateActive(SameNameDifferentRegionStatemachine.State.main_region_StateB_r1_StateA));
			sct.raiseE1();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(SameNameDifferentRegionStatemachine.State.main_region_StateB));
			Assert.IsTrue(sct.isStateActive(SameNameDifferentRegionStatemachine.State.main_region_StateB_r1_StateB));
		}
	}
}
