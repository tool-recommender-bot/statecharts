package org.yakindu.base.generator.java.test

import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.yakindu.base.generator.java.test.util.AbstractJavaGeneratorTest
import org.yakindu.base.generator.java.test.util.JavaGeneratorTestInjectorProvider

@RunWith(XtextRunner)
@InjectWith(JavaGeneratorTestInjectorProvider)
class InterfaceTest extends AbstractJavaGeneratorTest {
	@Test
	def simpleTest() {
		val interface = helper.createInterfaceGen("ITestInterface")
		val exp = '''
		interface ITestInterface {
		}
		'''
		generatesTo(exp, interface)
	}
	
	@Test
	def methodAbstractTest() {
		val interface = helper.createInterfaceGen("ITestInterface")
		val method = helper.createMethodGen("interfaceMethod", "public")
		interface.children.add(method)
		val exp = '''
		interface ITestInterface {
			public interfaceMethod();
		}
		'''
		generatesTo(exp, interface)
	}
}