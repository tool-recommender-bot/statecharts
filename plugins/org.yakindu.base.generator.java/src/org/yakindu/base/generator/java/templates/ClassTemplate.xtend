package org.yakindu.base.generator.java.templates

import org.yakindu.base.generator.generator.ClassGen

class ClassTemplate extends Template {
	def dispatch String generate(ClassGen it) {'''
		«generateDocumentation»
		«generateVisibility»«generateAbstract»class «name» «generateExtends»«generateImplements»{
			«generateContent»
		}
	'''
	}
	
	def generateAbstract(ClassGen it) {
		if(abstract) {
			"abstract "
		} else {
			""
		}
	}
	
	def protected generateContent(ClassGen it) {
		'''
		«FOR c:children»
		«templateProvider.get(c).generate(c)»
		«ENDFOR»
		'''
	}
	
	def protected generateImplements(ClassGen it) {
		var ret = ""
		if(!implements.nullOrEmpty) {
			ret = "implements " + implements.join(", ")[name] + " "
		}
	}
	
	def protected generateExtends(ClassGen it) {
		if(superClass === null) {
			""
		} else {
			'''extends «superClass.name» '''
		}
	}
	
	
}