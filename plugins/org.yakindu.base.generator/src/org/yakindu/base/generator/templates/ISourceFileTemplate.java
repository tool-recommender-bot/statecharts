package org.yakindu.base.generator.templates;

import org.yakindu.base.generator.generator.SourceFileGen;

public interface ISourceFileTemplate extends ITemplate {
	public String generate(SourceFileGen it);
}
