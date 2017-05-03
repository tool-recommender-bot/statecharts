package org.yakindu.base.generator.test;

import org.junit.Before;
import org.yakindu.base.generator.ClassGen;
import org.yakindu.base.generator.CodeElement;
import org.yakindu.base.generator.MethodGen;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

import static org.junit.Assert.assertEquals;

public class AbstractGeneratorTest {
	protected Injector injector;
	@Before
	public void setUp() {
		injector = Guice.createInjector(new AbstractModule() {
			@Override
			protected void configure() {
				bind(ClassGen.class);
				bind(MethodGen.class);
			}
		});
	}
	
	protected ClassGen createClassGen() {
		return injector.getInstance(ClassGen.class);
	}
	
	protected MethodGen createMethodGen() {
		return injector.getInstance(MethodGen.class);
	}
	
	protected void generatesTo(String expected, CodeElement underTest) {
		assertEquals(expected, underTest.generate().toString());
	}
}
