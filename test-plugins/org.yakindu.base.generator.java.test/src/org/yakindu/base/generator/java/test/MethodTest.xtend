package org.yakindu.base.generator.java.test

import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.yakindu.base.generator.java.test.util.AbstractJavaGeneratorTest
import org.yakindu.base.generator.java.test.util.JavaGeneratorTestInjectorProvider

@RunWith(XtextRunner)
@InjectWith(JavaGeneratorTestInjectorProvider)
class MethodTest extends AbstractJavaGeneratorTest {
	@Test
	def methodLayoutTest() {
		val testMethod = helper.createMethodGen("myFunc")
		val exp = '''
		myFunc() {
		}
		'''
		generatesTo(exp, testMethod)
	}
	
	@Test
	def methodVisibilityTest() {
		val testMethod = helper.createMethodGen("myFunc", "public")
		val exp = '''
		public myFunc() {
		}
		'''
		generatesTo(exp, testMethod)
	}
	
	@Test
	def abstractMethodTest() {
		val testMethod = helper.createMethodGen("myFunc", "public")
		testMethod.abstract = true
		val exp = '''
		public myFunc();
		'''
		generatesTo(exp, testMethod)
	}
	
	@Test
	def method1ParameterTest() {
		val testMethod = helper.createMethodGen("myFunc")
		testMethod.parameters.add(helper.createParameterGen("p1", "string"))
		val exp = '''
		myFunc(string p1) {
		}
		'''
		generatesTo(exp, testMethod)
	}
	
	@Test
	def method2ParameterTest() {
		val testMethod = helper.createMethodGen("myFunc")
		testMethod.parameters.add(helper.createParameterGen("p1", "string"))
		testMethod.parameters.add(helper.createParameterGen("p2", "integer"))
		val exp = '''
		myFunc(string p1, integer p2) {
		}
		'''
		generatesTo(exp, testMethod)
	}
}