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
 *  Unit TestCase for InEventLifeCycle
 */
using System;
namespace Yakindu.SCR.InEventLifeCycle {
	using NUnit.Framework;
	using Yakindu.SCR;
	
	[TestFixture]
	public class InEventLifeCycleTest {
		private InEventLifeCycleStatemachine sct;
	
	[SetUp]
	public void setup() {
		sct = new InEventLifeCycleStatemachine();
		sct.init();
	}
	
		[Test]
		public void testeventLifeCycle(){
			sct.enter();
			sct.raiseE();
			Assert.IsTrue(sct.getI() == 0L);
			sct.runCycle();
			Assert.IsTrue(sct.getI() == 1L);
		}
	}
}
