package org.yakindu.base.generator.test

import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.yakindu.base.generator.Visibility
import org.yakindu.base.generator.test.util.GeneratorInjectorProvider

@RunWith(XtextRunner)
@InjectWith(GeneratorInjectorProvider)
class ClassGenTest extends AbstractGeneratorTest {
	@Test
	def testSimpleClassLayout() {
		testClass.className = "testClass"
		val exp = '''
		class testClass {
		}
		'''
		generatesTo(exp, testClass)
	}
	
	@Test
	def testVisibility() {
		testClass.className = "PrivateClass"
		testClass.visibility = Visibility.PRIVATE
		val exp = '''
		private class PrivateClass {
		}
		'''
		generatesTo(exp, testClass)
	}
}
