package org.yakindu.base.generator.java.test;

import static org.junit.Assert.assertEquals;

import org.yakindu.base.generator.GeneratorHelper;
import org.yakindu.base.generator.generator.CodeElement;
import org.yakindu.base.generator.templates.TemplateProvider;

import com.google.inject.Inject;

abstract public class AbstractJavaGeneratorTest {
	@Inject GeneratorHelper helper;
	
	@Inject TemplateProvider templateProvider;
	
	protected void generatesTo(String expected, CodeElement elem) {
		String result = templateProvider.get(elem).generate(elem).toString();
		try {
			assertEquals(expected, result);
		} catch(AssertionError e) {
			System.out.println("Expected:");
			System.out.println(expected);
			System.out.println("But got:");
			System.out.println(result);
			throw(e);
		}
	}
}
