package org.yakindu.base.generator.templates;

import org.yakindu.base.generator.generator.MethodGen;

public interface IMethodTemplate extends ITemplate {
	public String generate(MethodGen it);
}
