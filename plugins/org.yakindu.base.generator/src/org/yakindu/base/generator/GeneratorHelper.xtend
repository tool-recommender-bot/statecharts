package org.yakindu.base.generator

import org.yakindu.base.generator.generator.ClassGen
import org.yakindu.base.generator.generator.GeneratorFactory
import org.yakindu.base.generator.generator.VisibilityValues

class GeneratorHelper {
	protected GeneratorFactory factory = GeneratorFactory.eINSTANCE
	
	def ClassGen create factory.createClassGen() createClassGen() {
		factory.createClassGen()
	}
	
	def ClassGen create factory.createClassGen() createClassGen(String n) {
		name = n
	}
	
	def ClassGen create factory.createClassGen() createClassGen(String name, String visibility) {
		it.name = name
		val visibilityValue = VisibilityValues.get(visibility)
		if(visibilityValue !== null) {
			it.visibility = visibilityValue
		}
	}
}