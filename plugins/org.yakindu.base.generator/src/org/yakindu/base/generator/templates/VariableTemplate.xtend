package org.yakindu.base.generator.templates

import org.yakindu.base.generator.VariableGen

class VariableTemplate extends Template {
	def generate(VariableGen it) {
		'''«generateVisibility»«generateStatic»«generateConstant»«generateVariable»«generateInitialValue»'''
	}
	
	def generateVisibility(VariableGen it) {
		if(!visibility.nullOrEmpty) {
			'''«visibility» '''
		} else {
			""
		}
	}
	
	def generateStatic(VariableGen it) {
		if(isStatic) {
			'''static '''
		} else {
			""
		}
	}
	
	def generateConstant(VariableGen it) {
		if(isConstant) {
			'''final '''
		} else {
			""
		}
	}
	
	def generateVariable(VariableGen it) {
		'''«varDef.type» «varDef.name»'''
	}
	
	def generateInitialValue(VariableGen it) {
		if(varDef.initialValue != null) {
			''' = «varDef.initialValue»;'''
		}
	}
}