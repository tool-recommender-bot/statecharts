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
 *  Unit TestCase for DeepEntry
 */
using System;
namespace Yakindu.SCR.DeepEntry {
	using NUnit.Framework;
	using Yakindu.SCR;
	
	[TestFixture]
	public class DeepEntryTest {
		private DeepEntryStatemachine sct;
	
	[SetUp]
	public void setup() {
		sct = new DeepEntryStatemachine();
		sct.init();
	}
	
		[Test]
		public void testenterToSubstate(){
			Assert.IsTrue(sct.getX() == 0L);
			Assert.IsTrue(sct.getY() == 0L);
			Assert.IsTrue(sct.getZ() == 0L);
			sct.enter();
			Assert.IsTrue(sct.getX() == 1L);
			Assert.IsTrue(sct.getY() == 1L);
			Assert.IsTrue(sct.getZ() == 2L);
			sct.raiseE();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(DeepEntryStatemachine.State.r2_B_r_BB));
			sct.raiseF();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(DeepEntryStatemachine.State.r2_C));
			sct.raiseF();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(DeepEntryStatemachine.State.r2_B_r_BB));
			Assert.IsTrue(sct.getY() == 1L);
		}
	}
}
