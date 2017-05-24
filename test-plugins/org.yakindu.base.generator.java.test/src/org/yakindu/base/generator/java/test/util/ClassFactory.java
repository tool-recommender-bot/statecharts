package org.yakindu.base.generator.java.test.util;

import org.yakindu.base.generator.generator.ClassGen;
import org.yakindu.base.generator.generator.GeneratorFactory;

public class ClassFactory {
	protected GeneratorFactory factory = GeneratorFactory.eINSTANCE;
	
	public ClassGen getClassGen() {
		ClassGen ret = factory.createClassGen();
		ret.setName("name");
		return ret;
	}
}
