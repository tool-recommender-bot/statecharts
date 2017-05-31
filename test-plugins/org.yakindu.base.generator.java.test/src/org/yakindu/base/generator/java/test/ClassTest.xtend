package org.yakindu.base.generator.java.test

import com.google.inject.Inject
import java.util.List
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.yakindu.base.generator.extensions.ClassGenExtensions
import org.yakindu.base.generator.generator.ParameterGen
import org.yakindu.base.generator.java.test.util.AbstractJavaGeneratorTest
import org.yakindu.base.generator.java.test.util.JavaGeneratorTestInjectorProvider

@RunWith(XtextRunner)
@InjectWith(JavaGeneratorTestInjectorProvider)
class ClassTest extends AbstractJavaGeneratorTest {
	@Inject extension ClassGenExtensions classExtensions
	
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
	def testAbstract() {
		val testClass = helper.createClassGen("PrivateClass")
		testClass.abstract = true
		val exp = '''
		abstract class PrivateClass {
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
	
	@Test
	def testConstructor() {
		val testClass = helper.createClassGen("HasConstructor")
		testClass.addConstructor(newArrayList())
		val exp = '''
		class HasConstructor {
			public HasConstructor() {
			}
		}
		'''
		generatesTo(exp, testClass)
	}
	
	@Test
	def testConstructorParameters() {
		val testClass = helper.createClassGen("HasConstructor")
		val List<ParameterGen> parameters = newArrayList()
		parameters.add(helper.createParameterGen("p1", "string"))
		testClass.addConstructor(parameters)
		val exp = '''
		class HasConstructor {
			public HasConstructor(string p1) {
				this.p1 = p1;
			}
		}
		'''
		generatesTo(exp, testClass)
	}
	
	@Test
	def testConstructor2Parameters() {
		val testClass = helper.createClassGen("HasConstructor")
		val List<ParameterGen> parameters = newArrayList()
		parameters.add(helper.createParameterGen("p1", "string"))
		parameters.add(helper.createParameterGen("p2", "integer"))
		testClass.addConstructor(parameters)
		val exp = '''
		class HasConstructor {
			public HasConstructor(string p1, integer p2) {
				this.p1 = p1;
				this.p2 = p2;
			}
		}
		'''
		generatesTo(exp, testClass)
	}
}