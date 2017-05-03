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
	
	def List<ParameterGen> createTestParameters() {
		val List<ParameterGen> params = newArrayList
		var ts = typesFactory.toTypeSpecifier("integer")
		var p = createParameterGen(ts, "p1")
		params.add(p)
		ts = typesFactory.toTypeSpecifier("boolean")
		p = createParameterGen(ts, "p2")
		params.add(p)
		ts = typesFactory.toTypeSpecifier("string")
		p = createParameterGen(ts, "p3")
		params.add(p)
		var cmplx = typesFactory.toTypeSpecifier(typesFactory.createComplexType("cmplx"))
		cmplx.typeArguments.add(ts)
		p = createParameterGen(cmplx, "p4")
		params.add(p)
		return params
	}
}