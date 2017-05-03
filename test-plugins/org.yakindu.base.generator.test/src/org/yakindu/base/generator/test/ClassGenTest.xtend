package org.yakindu.base.generator.test

import com.google.inject.AbstractModule
import com.google.inject.Guice
import org.junit.Before
import org.junit.Test
import org.yakindu.base.generator.ClassGen
import org.yakindu.base.generator.Visibility

import static org.junit.Assert.*

class ClassGenTest {
	ClassGen testclass

	@Before
	def void setUp() {
		val injector = Guice.createInjector(new AbstractModule() {
			override configure() {
				bind(ClassGen)
			}
		})
		testclass = injector.getInstance(ClassGen)
	}

	@Test
	def testSimpleClassLayout() {
		testclass.className = "testClass"
		val exp = '''
		class testClass {
		}
		'''
		assertEquals(exp, testclass.generate)
	}
	
	@Test
	def testVisibility() {
		testclass.className = "PrivateClass"
		testclass.visibility = Visibility.PRIVATE
		val exp = '''
		private class PrivateClass {
		}
		'''
		assertEquals(exp, testclass.generate)
	}
}
