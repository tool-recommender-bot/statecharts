package org.yakindu.base.generator.templates;

import org.yakindu.base.generator.generator.CodeElement;

public interface ITemplate{
	/**
	 * Base operation that can be called on every template.
	 * Should only do something when the type of element matches
	 * the expected type - e.g. element should be a ClassGen when
	 * called on a IClassTemplate.
	 * @param element - the CodeElement to use.
	 * @return generated code.
	 */
	public String generate(CodeElement element);
}
