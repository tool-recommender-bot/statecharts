package org.yakindu.base.generator

import com.google.inject.Inject
import org.yakindu.base.generator.generator.AccessRestricted
import org.yakindu.base.generator.generator.ClassGen
import org.yakindu.base.generator.generator.GeneratorFactory
import org.yakindu.base.generator.generator.InterfaceGen
import org.yakindu.base.generator.generator.MethodGen
import org.yakindu.base.generator.generator.ParameterGen
import org.yakindu.base.generator.generator.VisibilityValues
import org.yakindu.base.types.Type
import org.yakindu.sct.model.stext.test.util.TypesTestFactory

class GeneratorHelper {
	protected GeneratorFactory factory = GeneratorFactory.eINSTANCE
	@Inject extension TypesTestFactory typesFactory
	
	def ClassGen create factory.createClassGen() createClassGen() {
		factory.createClassGen()
	}
	
	def ClassGen create factory.createClassGen() createClassGen(String n) {
		name = n
	}
	
	def ClassGen create factory.createClassGen() createClassGen(String name, String visibility) {
		it.name = name
		it.setVisibility(visibility)
	}
	
	def setVisibility(AccessRestricted it, String s) {
		val visibilityValue = VisibilityValues.get(s)
		if(visibilityValue !== null) {
			it.visibility = visibilityValue
		}
	}
	
	def InterfaceGen create factory.createInterfaceGen createInterfaceGen() {
	}
	
	def InterfaceGen create factory.createInterfaceGen createInterfaceGen(String name) {
		it.name = name
	}
	
	def MethodGen create factory.createMethodGen() createMethodGen() {
	}
	
	def MethodGen create factory.createMethodGen() createMethodGen(String name) {
		it.name = name
	}
	
	def MethodGen create factory.createMethodGen() createMethodGen(String name, String visibility) {
		it.name = name
		it.setVisibility(visibility)
	}
	
	def ParameterGen create factory.createParameterGen createParameterGen() {
	}
	
	def ParameterGen create factory.createParameterGen createParameterGen(String name, Type type) {
		it.name = name
		it.typeSpecifier = type.toTypeSpecifier
	}
	
	def ParameterGen create factory.createParameterGen createParameterGen(String name, String typeName) {
		it.name = name
		it.typeSpecifier = typeName.toTypeSpecifier
	}
	
}