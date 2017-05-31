package org.yakindu.base.generator.java.test

import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.yakindu.base.generator.java.test.util.JavaGeneratorTestInjectorProvider
import org.yakindu.base.generator.java.test.util.AbstractJavaGeneratorTest

@RunWith(XtextRunner)
@InjectWith(JavaGeneratorTestInjectorProvider)
class DocumentationTest extends AbstractJavaGeneratorTest {
	@Test
	def classDocumentationTest() {
		val testClass = helper.createClassGen("DocumentedClass")
		testClass.documentation = "Class that has a documentation."
		val exp = '''
		/** Class that has a documentation. */
		class DocumentedClass {
		}
		'''
		generatesTo(exp, testClass)
	}
	
	@Test
	def classMultilineDocumentationTest() {
		val testClass = helper.createClassGen("DocumentedClass")
		testClass.documentation = '''
			Class that has a documentation.
			The documentation has multiple lines.'''
		val exp = '''
		/**
		 * Class that has a documentation.
		 * The documentation has multiple lines.
		 */
		class DocumentedClass {
		}
		'''
		generatesTo(exp, testClass)
	}
	
	@Test
	def methodDocumentationTest() {
		val testMethod = helper.createMethodGen("myFunc")
		testMethod.documentation = "A method that does absolutely nothing."
		val exp = '''
		/** A method that does absolutely nothing. */
		myFunc() {
		}
		'''
		generatesTo(exp, testMethod)
	}
	
	@Test
	def methodMultilineDocumentationTest() {
		val testMethod = helper.createMethodGen("myFunc")
		testMethod.documentation = '''
			A method that does absolutely nothing.
			Those are the best methods - 
			methods that don't do anything don't do anything wrong.'''
		
		val exp = '''
		/**
		 * A method that does absolutely nothing.
		 * Those are the best methods - 
		 * methods that don't do anything don't do anything wrong.
		 */
		myFunc() {
		}
		'''
		generatesTo(exp, testMethod)
	}
}