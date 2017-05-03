package org.yakindu.base.generator.test

import java.util.List
import org.junit.Test
import org.yakindu.base.generator.Parameter
import org.yakindu.base.generator.Visibility
import org.yakindu.base.types.TypesFactory

class MethodGenTest extends AbstractGeneratorTest {
	val typesFactory = TypesFactory.eINSTANCE
	@Test
	def methodLayoutTest() {
		val testMethod = createMethodGen
		testMethod.methodName = "myFunc"
		val exp = '''
		myFunc() {
		}
		'''
		generatesTo(exp, testMethod)
	}
	
	@Test
	def methodVisibilityTest() {
		val testMethod = createMethodGen
		testMethod.methodName = "myFunc"
		testMethod.visibility = Visibility.PUBLIC
		val exp = '''
		public myFunc() {
		}
		'''
	}
	
	def createTestParameters() {
		val List<Parameter> params = newArrayList
		var type = TypesFactory.
	}
}