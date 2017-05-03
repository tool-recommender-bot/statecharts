package org.yakindu.base.generator.templates

import org.yakindu.base.generator.Parameter

class ParameterTemplate extends Template {
	def generate(Parameter it) {
	'''«parameterType» «parameterName»'''
	}
}