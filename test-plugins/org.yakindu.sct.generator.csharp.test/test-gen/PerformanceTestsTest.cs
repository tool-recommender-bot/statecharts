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
 *  Unit TestCase for PerformanceTest
 */
using System;
namespace Yakindu.SCR.PerformanceTest {
	using NUnit.Framework;
	using Yakindu.SCR;
	
	[TestFixture]
	public class PerformanceTestsTest {
		private PerformanceTestStatemachine sct;
	
	[SetUp]
	public void setup() {
		sct = new PerformanceTestStatemachine();
		sct.init();
	}
	
		[Test]
		public void testtest_100_000(){
			sct.enter();
			Assert.IsTrue(sct.isStateActive(PerformanceTestStatemachine.State.mr_A));
			while(sct.getC() < 100000L) {
				if(sct.isStateActive(PerformanceTestStatemachine.State.mr_A)) {
							sct.raiseE1();;
						  }
						else {
							if(sct.getC()%2L == 0L) {
										sct.raiseE2();;
									  }
									else {
										sct.raiseE3();;
									}
							;
						}
				sct.runCycle();
			}
			Assert.IsTrue(sct.getA() > 2L);
		}
		[Test]
		public void testtest_1_000_000(){
			sct.enter();
			Assert.IsTrue(sct.isStateActive(PerformanceTestStatemachine.State.mr_A));
			while(sct.getC() < 1000000L) {
				if(sct.isStateActive(PerformanceTestStatemachine.State.mr_A)) {
							sct.raiseE1();;
						  }
						else {
							if(sct.getC()%2L == 0L) {
										sct.raiseE2();;
									  }
									else {
										sct.raiseE3();;
									}
							;
						}
				sct.runCycle();
			}
			Assert.IsTrue(sct.getA() > 2L);
		}
		[Test]
		public void testtest_10_000_000(){
			sct.enter();
			Assert.IsTrue(sct.isStateActive(PerformanceTestStatemachine.State.mr_A));
			while(sct.getC() < 10000000L) {
				if(sct.isStateActive(PerformanceTestStatemachine.State.mr_A)) {
							sct.raiseE1();;
						  }
						else {
							if(sct.getC()%2L == 0L) {
										sct.raiseE2();;
									  }
									else {
										sct.raiseE3();;
									}
							;
						}
				sct.runCycle();
			}
			Assert.IsTrue(sct.getA() > 2L);
		}
	}
}
