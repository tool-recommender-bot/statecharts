package org.yakindu.base.generator.java.templates

import org.yakindu.base.generator.generator.ClassGen
import org.yakindu.base.generator.generator.CodeElement
import org.yakindu.base.generator.generator.MethodGen
import org.yakindu.base.generator.generator.VariableDeclarationGen

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
		val vars = generateVariables
		val methods = generateMethods
		'''
		«vars»
		«IF !vars.nullOrEmpty && !methods.nullOrEmpty»
		
		«ENDIF»
		«methods»
		'''
	}
	
	def generateVariables(ClassGen it) {
		children.filter(VariableDeclarationGen).map([it as CodeElement]).generateElements.toString

	}
	
	def generateMethods(ClassGen it) {
		children.filter(MethodGen).map([templateProvider.get(it).generate(it)]).join("\n")
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