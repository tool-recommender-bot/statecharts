package org.yakindu.base.generator.templates

import org.yakindu.base.generator.MethodGen

class MethodTemplate extends ContentTemplate {
	def generate(MethodGen it) {'''
		«generateVisibility»«methodName»(«generateParameters») {
			«generateContent»
		}
		'''
	}
	
	def generateParameters(MethodGen it) {
		if(!parameters.nullOrEmpty) {
			return parameters?.map([generate]).join(', ')
		}
		return ""
	}
	
	def generateVisibility(MethodGen it) {
		if(visibility.nullOrEmpty) {
			""
		} else {
			'''«visibility» '''
		}
	}
}