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
 *  Unit TestCase for HistoryWithExitPoint
 */
using System;
namespace Yakindu.SCR.HistoryWithExitPoint {
	using NUnit.Framework;
	using Yakindu.SCR;
	
	[TestFixture]
	public class HistoryWithExitPointTest {
		private HistoryWithExitPointStatemachine sct;
	
	[SetUp]
	public void setup() {
		sct = new HistoryWithExitPointStatemachine();
		sct.init();
	}
	
		[Test]
		public void testhistoryEntryAfterExit(){
			sct.enter();
			Assert.IsTrue(sct.isStateActive(HistoryWithExitPointStatemachine.State.mr_A_r_X1));
			sct.raisePush();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(HistoryWithExitPointStatemachine.State.mr_B));
			sct.raiseBack();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(HistoryWithExitPointStatemachine.State.mr_A_r_X1));
			sct.raiseNext();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(HistoryWithExitPointStatemachine.State.mr_A_r_X2));
			sct.raisePush();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(HistoryWithExitPointStatemachine.State.mr_B));
			sct.raiseBack();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(HistoryWithExitPointStatemachine.State.mr_A_r_X2));
		}
	}
}
