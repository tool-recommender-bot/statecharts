package org.yakindu.base.generator

import com.google.inject.Inject
import org.eclipse.xtext.EcoreUtil2
import org.yakindu.base.generator.generator.AccessRestricted
import org.yakindu.base.generator.generator.ClassGen
import org.yakindu.base.generator.generator.ExpressionGen
import org.yakindu.base.generator.generator.GeneratorFactory
import org.yakindu.base.generator.generator.InterfaceGen
import org.yakindu.base.generator.generator.MethodGen
import org.yakindu.base.generator.generator.ParameterGen
import org.yakindu.base.generator.generator.SourceFileGen
import org.yakindu.base.generator.generator.VariableGen
import org.yakindu.base.generator.generator.VisibilityValues
import org.yakindu.base.types.Type
import org.yakindu.base.types.TypeSpecifier
import org.yakindu.sct.model.stext.test.util.TypesTestFactory

class GeneratorHelper {
	protected GeneratorFactory factory = GeneratorFactory.eINSTANCE
	@Inject extension TypesTestFactory typesFactory
	
	def SourceFileGen createSourceFileGen() {
		val it = factory.createSourceFileGen
		it
	}
	
	def SourceFileGen createSourceFileGen(String name) {
		val it = factory.createSourceFileGen
		it.name = name
		it
	}
	
	def ClassGen createClassGen() {
		val it = factory.createClassGen()
		it
	}
	
	def ClassGen createClassGen(String name) {
		val it = factory.createClassGen()
		it.name = name
		it
	}
	
	def ClassGen createClassGen(String name, String visibility) {
		val it = factory.createClassGen()
		it.name = name
		it.setVisibility(visibility)
		it
	}
	
	def setVisibility(AccessRestricted it, String s) {
		val visibilityValue = VisibilityValues.get(s)
		if(visibilityValue !== null) {
			it.visibility = visibilityValue
		}
	}
	
	def InterfaceGen createInterfaceGen() {
		val it = factory.createInterfaceGen
		it
	}
	
	def InterfaceGen createInterfaceGen(String name) {
		val it = factory.createInterfaceGen
		it.name = name
		it
	}
	
	def MethodGen createMethodGen() {
		val it = factory.createMethodGen()
		it
	}
	
	def MethodGen createMethodGen(String name) {
		val it = factory.createMethodGen()
		it.name = name
		it
	}
	
	def MethodGen createMethodGen(String name, String visibility) {
		val it = factory.createMethodGen()
		it.name = name
		it.setVisibility(visibility)
		it
	}
	
	def ParameterGen createParameterGen() {
		val it = factory.createParameterGen
		it
	}
	
	def ParameterGen createParameterGen(String name, Type type) {
		val it = factory.createParameterGen
		it.name = name
		it.typeSpecifier = type.toTypeSpecifier
		it
	}
	
	def ParameterGen createParameterGen(String name, String typeName) {
		val it = factory.createParameterGen
		it.name = name
		it.typeSpecifier = typeName.toTypeSpecifier
		it
	}
	
	def ExpressionGen createExpressionGen() {
		val it = factory.createExpressionGen
		it
	}
	
	def VariableGen createVariableGen() {
		val it = factory.createVariableGen
		it
	}
	
	def VariableGen createVariableGen(String name, String typeName) {
		val it = factory.createVariableGen
		it.name = name
		it.typeSpecifier = typeName.toTypeSpecifier
		it
	}
	
	def VariableGen createVariableGen(String name, TypeSpecifier ts) {
		val it = factory.createVariableGen
		it.name = name
		it.typeSpecifier = ts
		it
	}
	
	def VariableGen createVariableGen(ParameterGen p) {
		val it = factory.createVariableGen
		it.name = p.name
		it.typeSpecifier = EcoreUtil2.copy(p.typeSpecifier)
		it
	}
}