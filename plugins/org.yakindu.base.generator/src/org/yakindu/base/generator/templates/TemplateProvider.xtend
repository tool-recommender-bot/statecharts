package org.yakindu.base.generator.templates

import com.google.inject.Injector
import org.yakindu.base.generator.generator.CodeElement

abstract class TemplateProvider implements ITemplateProvider {
	override get(CodeElement it) {
		doGet()
	}
	
	def dispatch ITemplate doGet(CodeElement it) {
		return null
	}
}