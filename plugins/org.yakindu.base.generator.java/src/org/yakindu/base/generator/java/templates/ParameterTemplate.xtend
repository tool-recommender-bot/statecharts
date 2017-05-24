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