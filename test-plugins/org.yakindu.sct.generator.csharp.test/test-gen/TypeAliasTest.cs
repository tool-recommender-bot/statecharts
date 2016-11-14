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
 *  Unit TestCase for TypeAlias
 */
using System;
namespace Yakindu.SCR.TypeAlias {
	using NUnit.Framework;
	using Yakindu.SCR;
	
	[TestFixture]
	public class TypeAliasTest {
		private TypeAliasStatemachine sct;
	
	[SetUp]
	public void setup() {
		sct = new TypeAliasStatemachine();
		sct.init();
	}
	
		[Test]
		public void testTypeAliasTest(){
			sct.enter();
			Assert.IsTrue(sct.isStateActive(TypeAliasStatemachine.State.main_region_Start));
			Assert.IsTrue(sct.getMyVar() == 1L);
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(TypeAliasStatemachine.State.main_region_Mid));
			Assert.IsTrue(sct.getMyString() == "TypeSystem");
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(TypeAliasStatemachine.State.main_region_Mid2));
			sct.raiseMyEvent();
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(TypeAliasStatemachine.State.main_region_End));
		}
	}
}
