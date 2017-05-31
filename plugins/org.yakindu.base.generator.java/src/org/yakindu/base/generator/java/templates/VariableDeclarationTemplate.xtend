package org.yakindu.base.generator.java.templates

import org.yakindu.base.generator.generator.VariableDeclarationGen

class VariableDeclarationTemplate extends Template {
	def dispatch generate(VariableDeclarationGen it) {
		'''«variableGen.generateVisibility»«variableGen.typeSpecifier.generateTypeSpecifier» «variableGen.name»;'''
	}
}