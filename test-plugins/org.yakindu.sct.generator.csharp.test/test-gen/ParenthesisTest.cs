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
 *  Unit TestCase for Parenthesis
 */
using System;
namespace Yakindu.SCR.Parenthesis {
	using NUnit.Framework;
	using Yakindu.SCR;
	
	[TestFixture]
	public class ParenthesisTest {
		private ParenthesisStatemachine sct;
	
	[SetUp]
	public void setup() {
		sct = new ParenthesisStatemachine();
		sct.init();
	}
	
		[Test]
		public void testsimple(){
			sct.enter();
			Assert.IsTrue(sct.isStateActive(ParenthesisStatemachine.State.mainRegion_A));
			Assert.IsTrue(sct.getErg() == 8L);
		}
	}
}
