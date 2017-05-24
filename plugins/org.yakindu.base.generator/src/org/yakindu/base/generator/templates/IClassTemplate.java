package org.yakindu.base.generator.templates;

import org.yakindu.base.generator.generator.ClassGen;

public interface IClassTemplate extends ITemplate {
	public String generate(ClassGen it);
}
