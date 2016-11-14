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
 *  Unit TestCase for StatechartActive
 */
using System;
namespace Yakindu.SCR.StatechartActive {
	using NUnit.Framework;
	using Yakindu.SCR;
	
	[TestFixture]
	public class StatechartActiveTest {
		private StatechartActiveStatemachine sct;
	
	[SetUp]
	public void setup() {
		sct = new StatechartActiveStatemachine();
		sct.init();
	}
	
		[Test]
		public void testinactiveBeforeEnter(){
			Assert.IsTrue(!sct.isActive());
		}
		[Test]
		public void testactiveAfterEnter(){
			sct.enter();
			Assert.IsTrue(sct.isActive());
		}
		[Test]
		public void testinactiveAfterExit(){
			sct.enter();
			sct.exit();
			Assert.IsTrue(!sct.isActive());
		}
		[Test]
		public void testactiveAfterReenter(){
			sct.enter();
			sct.exit();
			sct.enter();
			Assert.IsTrue(sct.isActive());
		}
	}
}
