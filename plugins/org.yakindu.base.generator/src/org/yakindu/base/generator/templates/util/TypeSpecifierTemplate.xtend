package org.yakindu.base.generator.templates.util

import org.yakindu.base.generator.templates.Template
import org.yakindu.base.types.TypeSpecifier

class TypeSpecifierTemplate extends Template {
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
