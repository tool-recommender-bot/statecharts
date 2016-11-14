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
 *  Unit TestCase for EntryChoice
 */
using System;
namespace Yakindu.SCR.EntryChoice {
	using NUnit.Framework;
	using Yakindu.SCR;
	
	[TestFixture]
	public class EntryChoiceTest {
		private EntryChoiceStatemachine sct;
	
	[SetUp]
	public void setup() {
		sct = new EntryChoiceStatemachine();
		sct.init();
	}
	
		[Test]
		public void testEntryChoiceTest(){
			sct.enter();
			sct.runCycle();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(EntryChoiceStatemachine.State.main_region_A));
		}
	}
}
