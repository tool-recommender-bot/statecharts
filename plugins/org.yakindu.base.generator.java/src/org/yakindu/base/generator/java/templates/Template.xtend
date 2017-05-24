package org.yakindu.base.generator.java.templates

import com.google.inject.Inject
import org.yakindu.base.generator.generator.AccessRestricted
import org.yakindu.base.generator.generator.CodeElement
import org.yakindu.base.generator.templates.ITemplate
import org.yakindu.base.generator.templates.TemplateProvider

abstract class Template implements ITemplate {
	@Inject protected TemplateProvider templateProvider

	/**
	 * Dispatch function that gets extended by the child classes.
	 */
	def dispatch generate(CodeElement it) {
		throw new UnsupportedOperationException(
			"Trying to generate a  " + it.class.simpleName + "with a " + this.class.simpleName
		)
	}

	def generateVisibility(AccessRestricted it) {
		switch (visibility) {
			case null:
				""
			case NONE:
				""
			case PRIVATE: {
				"private "
			}
			case PROTECTED: {
				"protected "
			}
			case PUBLIC: {
				"public "
			}
		}
	}
}
