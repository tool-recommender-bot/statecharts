package org.yakindu.base.generator.java.test

import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(XtextRunner)
@InjectWith(JavaGeneratorTestInjectorProvider)
class ClassTest extends AbstractJavaGeneratorTest {
	@Test
	def testSimpleClassLayout() {
		val testClass = helper.createClassGen("TestClass")
		val exp = '''
		class TestClass {
		}
		'''
		generatesTo(exp, testClass)
	}
	
	@Test
	def testVisibility() {
		val testClass = helper.createClassGen("PrivateClass", "private")
		val exp = '''
		private class PrivateClass {
		}
		'''
		generatesTo(exp, testClass)
	}
	
	@Test
	def testSuperclass() {
		val testClass = helper.createClassGen("ChildClass")
		val superClass = helper.createClassGen("SuperClass")
		testClass.superClass = superClass
		val exp = '''
		class ChildClass extends SuperClass {
		}
		'''
		generatesTo(exp, testClass)
	}
}