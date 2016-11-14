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
 *  Unit TestCase for LocalReactions
 */
using System;
namespace Yakindu.SCR.LocalReactions {
	using NUnit.Framework;
	using Yakindu.SCR;
	
	[TestFixture]
	public class LocalReactionsTest {
		private LocalReactionsStatemachine sct;
	
	[SetUp]
	public void setup() {
		sct = new LocalReactionsStatemachine();
		sct.init();
	}
	
		[Test]
		public void testLocalReactionsTest(){
			sct.enter();
			Assert.IsTrue(sct.isStateActive(LocalReactionsStatemachine.State.main_region_A));
			sct.runCycle();
			Assert.IsTrue(sct.getX() == 1L);
		}
	}
}
