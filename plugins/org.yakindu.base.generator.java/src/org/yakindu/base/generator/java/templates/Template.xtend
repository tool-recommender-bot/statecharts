package org.yakindu.base.generator.java.templates

import com.google.inject.Inject
import org.yakindu.base.generator.generator.CodeElement
import org.yakindu.base.generator.templates.ITemplate

abstract class Template implements ITemplate {
	@Inject JavaTemplateProvider provider
	
	/**
	 * Helper function to generate contents of unknown Type (extends CodeElement)
	 */
	def ITemplate getTemplate(CodeElement it) {
		return provider.get(it)
	}

	/**
	 * Dispatch function that gets extended by the child classes.
	 */
	def dispatch generate(CodeElement it) {
		throw new UnsupportedOperationException(
			"Trying to generate a  " + it.class.simpleName + "with a " + this.class.simpleName
		)
	}
}
