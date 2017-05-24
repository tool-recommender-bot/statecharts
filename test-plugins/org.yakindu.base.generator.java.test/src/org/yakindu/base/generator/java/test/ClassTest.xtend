package org.yakindu.base.generator.java.test

import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.yakindu.base.generator.java.test.util.AbstractJavaGeneratorTest
import org.yakindu.base.generator.java.test.util.JavaGeneratorTestInjectorProvider

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
	
	@Test
	def testInterface() {
		val testClass = helper.createClassGen("ImplClass")
		val interface = helper.createInterfaceGen("ITestInterface")
		testClass.implements.add(interface)
		val exp = '''
		class ImplClass implements ITestInterface {
		}
		'''
		generatesTo(exp, testClass)
	}
	
	@Test
	def testMultipleInterface() {
		val testClass = helper.createClassGen("ImplClass")
		val interface = helper.createInterfaceGen("ITestInterface")
		val interface2 = helper.createInterfaceGen("ITestable")
		testClass.implements.add(interface)
		testClass.implements.add(interface2)
		val exp = '''
		class ImplClass implements ITestInterface, ITestable {
		}
		'''
		generatesTo(exp, testClass)
	}
	
	@Test
	def testContainedMethod() {
		val testClass = helper.createClassGen("MyClass")
		val method = helper.createMethodGen("classMethod")
		testClass.children.add(method)
		val exp = '''
		class MyClass {
			classMethod() {
			}
		}
		'''
		generatesTo(exp, testClass)
	}
}