package org.yakindu.base.generator.test

import java.util.List
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.yakindu.base.generator.ParameterGen
import org.yakindu.base.generator.Visibility
import org.yakindu.base.generator.test.util.GeneratorInjectorProvider

@RunWith(XtextRunner)
@InjectWith(GeneratorInjectorProvider)
class MethodGenTest extends AbstractGeneratorTest {
	@Test
	def methodLayoutTest() {
		testMethod.methodName = "myFunc"
		val exp = '''
		myFunc() {
		}
		'''
		generatesTo(exp, testMethod)
	}
	
	@Test
	def methodVisibilityTest() {
		testMethod.methodName = "myFunc"
		testMethod.visibility = Visibility.PUBLIC
		val exp = '''
		public myFunc() {
		}
		'''
		generatesTo(exp, testMethod)
	}
	
	@Test
	def methodParamTest1() {
		testMethod.methodName = "paramFunc"
		val params = createTestParameters
		testMethod.addParameter(params.get(0))
		val exp = '''
		paramFunc(integer p1) {
		}
		'''
		generatesTo(exp, testMethod)
	}
	
	@Test
	def methodParamTest2() {
		testMethod.methodName = "paramFunc"
		val params = createTestParameters
		testMethod.addParameter(params.get(0))
		testMethod.addParameter(params.get(1))
		val exp = '''
		paramFunc(integer p1, boolean p2) {
		}
		'''
		generatesTo(exp, testMethod)
	}
	
	@Test
	def methodParamTest3() {
		testMethod.methodName = "paramFunc"
		val params = createTestParameters
		testMethod.addParameter(params.get(3))
		val exp = '''
		paramFunc(cmplx<string> p4) {
		}
		'''
		generatesTo(exp, testMethod)
	}
	
	@Test
	def methodConstParamTest1() {
		testMethod.methodName = "paramFunc"
		val params = createTestParameters.map([isConst = true; it])
		testMethod.addParameter(params.get(0))
		val exp = '''
		paramFunc(const integer p1) {
		}
		'''
		generatesTo(exp, testMethod)
	}
	
	@Test
	def methodConstParamTest2() {
		testMethod.methodName = "paramFunc"
		val params = createTestParameters.map([isConst = true; it])
		testMethod.addParameter(params.get(0))
		testMethod.addParameter(params.get(1))
		val exp = '''
		paramFunc(const integer p1, const boolean p2) {
		}
		'''
		generatesTo(exp, testMethod)
	}
	
	@Test
	def methodConstParamTest3() {
		testMethod.methodName = "paramFunc"
		val params = createTestParameters.map([isConst = true; it])
		testMethod.addParameter(params.get(3))
		val exp = '''
		paramFunc(const cmplx<string> p4) {
		}
		'''
		generatesTo(exp, testMethod)
	}
	
	@Test
	def methodReturnTypeTest() {
		testMethod.methodName = "returnFunc"
		val returnType = typesFactory.toTypeSpecifier("integer")
		testMethod.returnType = returnType
		val exp = '''
		integer returnFunc() {
		}
		'''
		generatesTo(exp, testMethod)
	}
	
	@Test
	def methodVisibilityReturnTypeTest() {
		testMethod.methodName = "returnFunc"
		val returnType = typesFactory.toTypeSpecifier("integer")
		testMethod.returnType = returnType
		testMethod.visibility = Visibility.PRIVATE
		val exp = '''
		private integer returnFunc() {
		}
		'''
		generatesTo(exp, testMethod)
	}
}