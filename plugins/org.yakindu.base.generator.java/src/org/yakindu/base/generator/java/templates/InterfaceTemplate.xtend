package org.yakindu.base.generator.java.templates

import org.yakindu.base.generator.generator.CodeElement
import org.yakindu.base.generator.generator.InterfaceGen
import org.yakindu.base.generator.generator.MethodGen

class InterfaceTemplate extends ClassTemplate {
	def dispatch generate(InterfaceGen it) {'''
		«generateVisibility»interface «name» «generateExtends»{
			«generateContent»
		}
	'''
	}
	
	def protected generateContent(InterfaceGen it) {
		'''
		«FOR c:children»
		«generateChild(c)»
		«ENDFOR»
		'''
	}
	
	def generateChild(CodeElement it) {
		if(it instanceof MethodGen) {
			it.abstract = true
		}
		templateProvider.get(it).generate(it)
	}
	
	def protected generateExtends(InterfaceGen it) {
		if(superClass === null) {
			""
		} else {
			'''extends «superClass.name» '''
		}
	}
}