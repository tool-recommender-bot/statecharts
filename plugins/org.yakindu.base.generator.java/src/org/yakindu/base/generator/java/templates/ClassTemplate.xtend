package org.yakindu.base.generator.java.templates

import org.yakindu.base.generator.templates.IClassTemplate
import org.yakindu.base.generator.generator.ClassGen

class ClassTemplate implements IClassTemplate {
	override generate(ClassGen it) {'''
		«generateVisibility»class «className» «generateExtends»«generateImplements»{
			«generateContent»
		}
	'''
	}
	
	def generateContent(ClassGen it) {
		'''
		«FOR cm:classMembers»
		«cm.generate()»
		«ENDFOR»
		'''
	}
	
	def generateImplements(ClassGen it) {
		var ret = ""
		if(!interfaces.nullOrEmpty) {
			ret = "implements "
			var first = true
			for(i : interfaces) {
				if(first) {
					first = false
					ret += i.className
				} else {
					ret += ", " + i.className
				}
			}
			ret += " "
		}
	}
	
	def generateVisibility(ClassGen it) {
		if(!visibility.nullOrEmpty) {
			return visibility + " "
		}
		""
	}
	
	def generateExtends(ClassGen it) {
		if(superClass == null) {
			""
		} else {
			'''extends «superClass.className» '''
		}
	}
}