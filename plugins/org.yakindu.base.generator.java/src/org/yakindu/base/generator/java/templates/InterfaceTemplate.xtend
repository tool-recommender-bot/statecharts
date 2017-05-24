package org.yakindu.base.generator.java.templates

import org.yakindu.base.generator.generator.InterfaceGen

class InterfaceTemplate extends ClassTemplate {
	def dispatch generate(InterfaceGen it) {'''
		«generateVisibility»interface «name» «generateExtends»{
			«generateContent»
		}
	'''
	}
}