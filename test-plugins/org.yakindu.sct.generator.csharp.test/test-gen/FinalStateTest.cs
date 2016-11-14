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
 *  Unit TestCase for FinalState
 */
using System;
namespace Yakindu.SCR.FinalState {
	using NUnit.Framework;
	using Yakindu.SCR;
	
	[TestFixture]
	public class FinalStateTest {
		private FinalStateStatemachine sct;
	
	[SetUp]
	public void setup() {
		sct = new FinalStateStatemachine();
		sct.init();
	}
	
		[Test]
		public void testStatechartNameTest(){
			sct.enter();
			sct.runCycle();
			Assert.IsTrue(sct.isFinal());
		}
	}
}
