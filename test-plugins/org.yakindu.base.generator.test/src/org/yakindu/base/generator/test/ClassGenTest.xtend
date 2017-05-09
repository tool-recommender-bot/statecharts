package org.yakindu.base.generator.test

import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.yakindu.base.generator.Visibility
import org.yakindu.base.generator.test.util.GeneratorInjectorProvider
import org.yakindu.sct.model.stext.STextStandaloneSetup
import com.google.inject.Injector
import org.eclipse.xtext.parser.IParser
import org.yakindu.sct.model.stext.expressions.IExpressionParser

@RunWith(XtextRunner)
@InjectWith(GeneratorInjectorProvider)
class ClassGenTest extends AbstractGeneratorTest {
	protected IExpressionParser parser
	new() {
		val injector = new STextStandaloneSetup().createInjectorAndDoEMFRegistration();
		
		parser = injector.getInstance(IExpressionParser);
	}


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
		testClass.addConstructor(params)
		val exp = '''
		class myFunc {
			public myFunc(integer p1, boolean p2, string p3, cmplx<string> p4) {
				this.p1 = p1;
				this.p2 = p2;
				this.p3 = p3;
				this.p4 = p4;
			}
		}
		'''
		generatesTo(exp, testClass)
	}
}
