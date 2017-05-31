package org.yakindu.base.generator.extensions

import java.util.List
import org.yakindu.base.generator.generator.ClassGen
import org.yakindu.base.generator.generator.ParameterGen

class ClassGenExtensions extends GeneratorExtensions {
	def addConstructor(ClassGen it, List<ParameterGen> parameters) {
		val constructorMethod = createMethodGen(getConstructorName, "public")
		for(p: parameters) {
			
		}
	}
	
	def getConstructorName(ClassGen it) {
		/** Override per language as needed */
		return name
	}
	
}