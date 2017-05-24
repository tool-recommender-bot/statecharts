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
}