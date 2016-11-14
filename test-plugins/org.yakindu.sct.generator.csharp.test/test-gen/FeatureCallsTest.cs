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
 *  Unit TestCase for FeatureCalls
 */
using System;
namespace Yakindu.SCR.FeatureCalls {
	using NUnit.Framework;
	using Yakindu.SCR;
	
	[TestFixture]
	public class FeatureCallsTest {
		private FeatureCallsStatemachine sct;
	
	[SetUp]
	public void setup() {
		sct = new FeatureCallsStatemachine();
		sct.init();
	}
	
		[Test]
		public void testFeatureCalls(){
			sct.enter();
			Assert.IsTrue(sct.isStateActive(FeatureCallsStatemachine.State.main_region_A));
			sct.runCycle();
			Assert.IsTrue(sct.isStateActive(FeatureCallsStatemachine.State.main_region_A));
		}
	}
}
