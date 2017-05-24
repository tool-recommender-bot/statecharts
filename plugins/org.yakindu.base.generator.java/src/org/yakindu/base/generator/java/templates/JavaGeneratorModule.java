package org.yakindu.base.generator.java.templates;

import org.yakindu.base.generator.templates.TemplateProvider;

import com.google.inject.AbstractModule;

public class JavaGeneratorModule extends AbstractModule {
	@Override
	protected void configure() {
		bind(TemplateProvider.class).to(JavaTemplateProvider.class);
	}

}
