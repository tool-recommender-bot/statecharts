package org.yakindu.base.generator.test

import com.google.inject.AbstractModule
import com.google.inject.Guice
import org.junit.Before
import org.junit.Test
import org.yakindu.base.generator.ClassGen
import org.yakindu.base.generator.Visibility

import static org.junit.Assert.*

class ClassGenTest extends AbstractGeneratorTest {
	@Test
	def testSimpleClassLayout() {
		val testClass = createClassGen
		testClass.className = "testClass"
		val exp = '''
		class testClass {
		}
		'''
		generatesTo(exp, testClass)
	}
	
	@Test
	def testVisibility() {
		val testClass = createClassGen
		testClass.className = "PrivateClass"
		testClass.visibility = Visibility.PRIVATE
		val exp = '''
		private class PrivateClass {
		}
		'''
		generatesTo(exp, testClass)
	}
}
