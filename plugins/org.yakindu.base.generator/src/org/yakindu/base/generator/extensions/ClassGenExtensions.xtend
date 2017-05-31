package org.yakindu.base.generator.extensions

import java.util.List
import org.yakindu.base.generator.generator.ClassGen
import org.yakindu.base.generator.generator.ParameterGen

class ClassGenExtensions extends GeneratorExtensions {
	def addConstructor(ClassGen it, List<ParameterGen> parameters) {
		val constructor = createMethodGen(getConstructorName, "public")
		constructor.parameters.addAll(parameters)
		val owner = createVariableGen(getThisName, "string")
		for(p: parameters) {
			val expressionGen = createExpressionGen
			val assignment = createAssignmentExpression
			val featureCall = createFeatureCall
			val elementReferenceVar = createElementReferenceExpression
			val elementReferenceOwner = createElementReferenceExpression
			
			elementReferenceVar.reference = createVariableGen(p)
			featureCall.feature = createVariableGen(p)
			featureCall.owner = elementReferenceOwner
			elementReferenceOwner.reference = owner
			assignment.varRef = featureCall
			assignment.expression = elementReferenceVar
			expressionGen.expression = assignment
			constructor.children.add(expressionGen)
		}
		it.children.add(constructor)
	}
	
	def getThisName() {
		/** Override per language as needed */
		return "this"
	}
	
	def getConstructorName(ClassGen it) {
		/** Override per language as needed */
		return name
	}
	
}