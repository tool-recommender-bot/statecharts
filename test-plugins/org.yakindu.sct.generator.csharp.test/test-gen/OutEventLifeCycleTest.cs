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
 *  Unit TestCase for OutEventLifeCycle
 */
using System;
namespace Yakindu.SCR.OutEventLifeCycle {
	using NUnit.Framework;
	using Yakindu.SCR;
	
	[TestFixture]
	public class OutEventLifeCycleTest {
		private OutEventLifeCycleStatemachine sct;
	
	[SetUp]
	public void setup() {
		sct = new OutEventLifeCycleStatemachine();
		sct.init();
	}
	
		[Test]
		public void testavailableAfterCycle(){
			sct.enter();
			sct.raiseE();
			sct.runCycle();
			Assert.IsTrue(sct.isRaisedF());
		}
		[Test]
		public void testavailableWithinCycle(){
			sct.enter();
			sct.raiseE();
			sct.runCycle();
			Assert.IsTrue(sct.getF_available_in_cycle());
		}
		[Test]
		public void testunvailableWithin2ndCycle(){
			sct.enter();
			sct.raiseE();
			sct.runCycle();
			sct.runCycle();
			Assert.IsTrue(!sct.getF_available_in_next_cycle());
		}
		[Test]
		public void testunvailableAfter2ndCycle(){
			sct.enter();
			sct.raiseE();
			sct.runCycle();
			sct.runCycle();
			Assert.IsTrue(!sct.isRaisedF());
		}
	}
}
