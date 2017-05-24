package org.yakindu.base.generator.templates;

import org.yakindu.base.generator.generator.CodeElement;

public interface ITemplateProvider {
	public ITemplate get(CodeElement it);
}
