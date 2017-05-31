package org.yakindu.base.generator.java.templates

import org.yakindu.base.generator.generator.VariableGen

class VariableTemplate extends Template {
	def dispatch generate(VariableGen it) {
		'''«name»'''
	}
}