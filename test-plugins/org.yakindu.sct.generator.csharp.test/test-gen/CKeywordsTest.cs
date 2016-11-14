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
 *  Unit TestCase for CKeywords
 */
using System;
namespace Yakindu.SCR.CKeywords {
	using NUnit.Framework;
	using Yakindu.SCR;
	
	[TestFixture]
	public class CKeywordsTest {
		private CKeywordsStatemachine sct;
	
	[SetUp]
	public void setup() {
		sct = new CKeywordsStatemachine();
		sct.init();
	}
	
		[Test]
		public void testCKeywordsTest(){
			sct.enter();
			Assert.IsTrue(sct.isStateActive(CKeywordsStatemachine.State.auto_char));
			sct.raiseAuto();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(CKeywordsStatemachine.State.auto_loop));
			Assert.IsTrue(sct.isStateActive(CKeywordsStatemachine.State.auto_loop_switch_case));
			Assert.IsTrue(sct.isStateActive(CKeywordsStatemachine.State.auto_loop_switch_case_enum_asm));
		}
	}
}
