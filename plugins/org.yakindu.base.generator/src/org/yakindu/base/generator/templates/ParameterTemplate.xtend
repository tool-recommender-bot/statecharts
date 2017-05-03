package org.yakindu.base.generator.templates

import org.yakindu.base.generator.ParameterGen
import org.yakindu.base.types.TypeSpecifier

class ParameterTemplate extends Template {
	def generate(ParameterGen it) {
	'''«generateParameterType» «parameterName»'''
	}
	
	def generateParameterType(ParameterGen it) {
		generateTypeSpecifier(parameterType)
	}
	
	def CharSequence generateTypeSpecifier(TypeSpecifier it) {
		'''«type»«generateTypeParameters»'''
	}
	
	def generateTypeParameters(TypeSpecifier it) {
		if(typeArguments.nullOrEmpty) {
			return ""
		}
		else {
			return '''<«typeArguments.map([generateTypeSpecifier]).join(", ")»>'''
		}
	}
}