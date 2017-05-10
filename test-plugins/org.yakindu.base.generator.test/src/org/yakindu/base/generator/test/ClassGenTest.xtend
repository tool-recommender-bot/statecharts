package org.yakindu.base.generator.test

import com.google.inject.Inject
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.yakindu.base.generator.Visibility
import org.yakindu.base.generator.test.util.GeneratorInjectorProvider
import org.yakindu.sct.model.stext.expressions.IExpressionParser

@RunWith(XtextRunner)
@InjectWith(GeneratorInjectorProvider)
class ClassGenTest extends AbstractGeneratorTest {
	@Inject protected IExpressionParser parser

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
	
	@Test
	def testSuperclass() {
		testClass.className = "ChildClass"
		val superClass = createClassGen()
		superClass.className = "SuperClass"
		testClass.superClass = superClass
		val exp = '''
		class ChildClass extends SuperClass {
		}
		'''
		generatesTo(exp, testClass)
	}
	
	@Test
	def testInterface() {
		testClass.className = "ImplClass"
		val interface = createClassGen()
		interface.className = "IInterface"
		testClass.interfaces.add(interface)
		val exp = '''
		class ImplClass implements IInterface {
		}
		'''
		generatesTo(exp, testClass)
	}
	
	@Test
	def testConstructor() {
		testClass.className = "hasConstructor"
		testClass.addConstructor(newArrayList)
		val exp = '''
		class hasConstructor {
			public hasConstructor() {
			}
		}
		'''
		generatesTo(exp, testClass)
	}
	
	@Test
	def testConstructorWithParameters() {
		testClass.className = "myFunc"
		val params = createTestParameters
		testClass.addConstructor(params.subList(0, 3))
		val exp = '''
		class myFunc {
			public myFunc(integer p1, boolean p2, string p3) {
				this.p1 = p1;
				this.p2 = p2;
				this.p3 = p3;
			}
		}
		'''
		generatesTo(exp, testClass)
	}
}
