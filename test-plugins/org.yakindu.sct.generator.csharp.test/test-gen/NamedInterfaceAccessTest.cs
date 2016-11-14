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
 *  Unit TestCase for NamedInterfaceAccess
 */
using System;
namespace Yakindu.SCR.NamedInterfaceAccess {
	using NUnit.Framework;
	using Yakindu.SCR;
	
	[TestFixture]
	public class NamedInterfaceAccessTest {
		private NamedInterfaceAccessStatemachine sct;
	
	[SetUp]
	public void setup() {
		sct = new NamedInterfaceAccessStatemachine();
		sct.init();
	}
	
		[Test]
		public void testSafeOpenSuccess(){
			sct.enter();
			sct.runCycle();
			sct.getSCIUser().raiseNumberPressed(3L);
			sct.runCycle();
			sct.getSCIUser().raiseNumberPressed(7L);
			sct.runCycle();
			sct.getSCIUser().raiseNumberPressed(5L);
			sct.runCycle();
			Assert.IsTrue(sct.getSCISafe().isRaisedOpen());
		}
	}
}
