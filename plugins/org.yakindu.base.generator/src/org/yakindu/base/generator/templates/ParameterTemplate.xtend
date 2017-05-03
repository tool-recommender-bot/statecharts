package org.yakindu.base.generator.templates

import com.google.inject.Inject
import org.yakindu.base.generator.ParameterGen
import org.yakindu.base.generator.templates.util.TypeSpecifierTemplate

class ParameterTemplate extends Template {
	@Inject extension TypeSpecifierTemplate
	def generate(ParameterGen it) {
	'''«IF isConst»const «ENDIF»«generateParameterType» «parameterName»'''
	}
	
	def generateParameterType(ParameterGen it) {
		generateTypeSpecifier(parameterType)
	}
}