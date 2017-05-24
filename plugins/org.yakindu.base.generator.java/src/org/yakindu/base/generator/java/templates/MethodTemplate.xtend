package org.yakindu.base.generator.java.templates

import org.yakindu.base.generator.generator.MethodGen

class MethodTemplate extends Template {
	def generate(MethodGen it) {'''
		«generateVisibility»«generateReturnType»«name»(«generateParameters») {
			«generateContent»
		}
		'''
	}
	
	def protected generateContent(MethodGen it) {
		'''
		«FOR c:children»
		«templateProvider.get(c).generate(c)»
		«ENDFOR»
		'''
	}
	
	def generateParameters(MethodGen it) {
		if(!parameters.nullOrEmpty) {
			return parameters?.map([generate]).join(', ')
		}
		return ""
	}
	
	def generateReturnType(MethodGen it) {
		if(returnType !== null) {
			returnType.type + " "
		} else {
			""
		}
	}
}