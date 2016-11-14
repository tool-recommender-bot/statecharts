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
 *  Unit TestCase for EntryReactionAction
 */
using System;
namespace Yakindu.SCR.EntryReactionAction {
	using NUnit.Framework;
	using Yakindu.SCR;
	
	[TestFixture]
	public class EntryReactionActionTest {
		private EntryReactionActionStatemachine sct;
	
	[SetUp]
	public void setup() {
		sct = new EntryReactionActionStatemachine();
		sct.init();
	}
	
		[Test]
		public void testentryTransitionActionOnStatechartEnter(){
			sct.enter();
			Assert.IsTrue(sct.getEnteredR1());
			Assert.IsTrue(sct.getEnteredR2());
			Assert.IsTrue(sct.getEnteredBdefault());
			Assert.IsTrue(!sct.getEnteredBother());
		}
		[Test]
		public void testentryOnRTS(){
			sct.enter();
			sct.raiseB();
			sct.runCycle();
			sct.raiseD();
			sct.runCycle();
			sct.setEnteredR1(false);
			sct.setEnteredR2(false);
			sct.setEnteredBdefault(false);
			sct.setEnteredBother(false);
			sct.raiseB();
			sct.runCycle();
			Assert.IsTrue(!sct.getEnteredR1());
			Assert.IsTrue(!sct.getEnteredR2());
			Assert.IsTrue(!sct.getEnteredBdefault());
			Assert.IsTrue(sct.getEnteredBother());
		}
		[Test]
		public void testnoEntryTransitionActionOnHistory(){
			sct.enter();
			sct.raiseB();
			sct.runCycle();
			sct.raiseD();
			sct.runCycle();
			sct.setEnteredR1(false);
			sct.setEnteredR2(false);
			sct.setEnteredBdefault(false);
			sct.setEnteredBother(false);
			sct.raiseD();
			sct.runCycle();
			Assert.IsTrue(!sct.getEnteredR1());
			Assert.IsTrue(!sct.getEnteredR2());
			Assert.IsTrue(!sct.getEnteredBdefault());
			Assert.IsTrue(!sct.getEnteredBother());
		}
	}
}
