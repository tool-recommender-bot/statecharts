package org.yakindu.base.generator.java.templates

import org.yakindu.base.generator.generator.ParameterGen
import org.yakindu.base.types.TypeSpecifier

class ParameterTemplate extends Template {
	def dispatch generate(ParameterGen it) {
	'''«generateParameterType» «name»'''
	}
	
	def generateParameterType(ParameterGen it) {
		generateTypeSpecifier(typeSpecifier)
	}
}