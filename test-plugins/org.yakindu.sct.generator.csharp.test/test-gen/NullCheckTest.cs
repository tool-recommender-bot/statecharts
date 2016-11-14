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
 *  Unit TestCase for NullCheck
 */
using System;
namespace Yakindu.SCR.NullCheck {
	using NUnit.Framework;
	using Yakindu.SCR;
	
	[TestFixture]
	public class NullCheckTest {
		private NullCheckStatemachine sct;
	
	[SetUp]
	public void setup() {
		sct = new NullCheckStatemachine();
		sct.init();
	}
	
		[Test]
		public void testSimpleNullCheckTest(){
			sct.enter();
			Assert.IsTrue(sct.isStateActive(NullCheckStatemachine.State.main_region_A));
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(NullCheckStatemachine.State.main_region_B));
		}
	}
}
