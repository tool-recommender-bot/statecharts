package org.yakindu.base.generator.test;

import static org.junit.Assert.assertEquals;

import org.yakindu.base.generator.ClassGen;
import org.yakindu.base.generator.CodeElement;
import org.yakindu.base.generator.MethodGen;
import org.yakindu.base.generator.ParameterGen;
import org.yakindu.base.types.TypeSpecifier;
import org.yakindu.base.types.util.TypesTestFactory;

import com.google.inject.Inject;
import com.google.inject.Injector;

public class AbstractGeneratorTest {
	@Inject TypesTestFactory typesFactory;
	@Inject ClassGen testClass;
	@Inject MethodGen testMethod;
	@Inject Injector injector;
	
	protected void generatesTo(String expected, CodeElement underTest) {
		assertEquals(expected, underTest.generate().toString());
	}
	
	protected ClassGen createClassGen() {
		return injector.getInstance(ClassGen.class);
	}
	
	protected ParameterGen createParameterGen() {
		return injector.getInstance(ParameterGen.class);
	}
	
	protected ParameterGen createParameterGen(TypeSpecifier ts, String name) {
		ParameterGen p = createParameterGen();
		p.setParameterType(ts);
		p.setParameterName(name);
		return p;
	}
}
