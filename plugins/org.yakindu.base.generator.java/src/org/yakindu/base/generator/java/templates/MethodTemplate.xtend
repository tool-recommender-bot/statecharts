package org.yakindu.base.generator.java.templates

import org.yakindu.base.generator.generator.MethodGen

class MethodTemplate extends Template {
	def dispatch String generate(MethodGen it) {
		'''
		«generateDocumentation»
		«generateVisibility»«generateReturnType»«name»(«generateParameters»)«generateBody»
		'''
	}
	
	def protected generateBody(MethodGen it) {
		if(!abstract) { 
		''' 
		 {
			«generateContent»
		}
		'''
		} else {
		''';'''
		}
	}
	
	def generateParameters(MethodGen it) {
		if(!parameters.nullOrEmpty) {
			return parameters?.map([templateProvider.get(it).generate(it)]).join(', ')
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