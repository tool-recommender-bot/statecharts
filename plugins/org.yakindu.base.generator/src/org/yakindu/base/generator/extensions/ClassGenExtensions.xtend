package org.yakindu.base.generator.extensions

import java.util.List
import org.yakindu.base.generator.generator.ClassGen
import org.yakindu.base.generator.generator.MethodGen
import org.yakindu.base.generator.generator.ParameterGen
import org.yakindu.base.generator.generator.VariableDeclarationGen
import org.yakindu.base.types.TypedElement

class ClassGenExtensions extends GeneratorExtensions {
	def addConstructor(ClassGen it, List<ParameterGen> parameters) {
		val constructor = createMethodGen(getConstructorName, "public")
		constructor.parameters.addAll(parameters)
		it.addMemberVariables(parameters)
		for (p : parameters) {
			val v = children.filter(VariableDeclarationGen).findFirst[variableGen.name == p.name]
			assignParameterToMemberVariable(v.variableGen, p, constructor)
		}
		it.children.add(constructor)
	}

	def assignParameterToMemberVariable(TypedElement v, TypedElement p, MethodGen it) {
		val owner = createVariableGen(getThisName, "string")
		val expressionGen = createExpressionGen
		val assignment = createAssignmentExpression
		val featureCall = createFeatureCall
		val elementReferenceVar = createElementReferenceExpression
		val elementReferenceOwner = createElementReferenceExpression

		elementReferenceVar.reference = createVariableGen(p)
		featureCall.feature = copy(v)
		featureCall.owner = elementReferenceOwner
		elementReferenceOwner.reference = owner
		assignment.varRef = featureCall
		assignment.expression = elementReferenceVar
		expressionGen.expression = assignment
		children.add(expressionGen)
	}

	def getThisName() {
		/** Override per language as needed */
		return "this"
	}

	def getConstructorName(ClassGen it) {
		/** Override per language as needed */
		return name
	}

	def addMemberVariables(ClassGen it, List<ParameterGen> parameters) {
		val existingMemberVariables = children.filter(VariableDeclarationGen).toList
		for (p : parameters) {
			if (existingMemberVariables.filter([variableGen.name == p.name]).nullOrEmpty) {
				val variable = createVariableGen(p, "protected")
				children.add(getDeclaration(variable))
			}
		}
	}

	def addAllGettersAndSetters(ClassGen it) {
		val members = children.filter(VariableDeclarationGen).toList
		val methods = children.filter(MethodGen).toList

		for (member : members) {
			val getterName = generateGetterName(member).toString
			val setterName = generateSetterName(member).toString

			if (methods.filter([name == getterName]).nullOrEmpty) {
				val getter = createMethodGen(getterName, "public")
				getter.returnType = member.variableGen.typeSpecifier
				children.add(getter)
			}

			if (methods.filter([name == setterName]).nullOrEmpty) {
				val setter = createMethodGen(setterName, "public")
				setter.returnType = createTypeSpecifier("void")
				val p = createParameterGen("value", member.variableGen.typeSpecifier)
				setter.parameters.add(p)
				assignParameterToMemberVariable(member.variableGen, p, setter)
				children.add(setter)
			}
		}
	}

	def generateGetterName(VariableDeclarationGen it) {
		/** Override per language as needed */
		'''get«variableGen.name.toFirstUpper»'''
	}

	def generateSetterName(VariableDeclarationGen it) {
		/** Override per language as needed */
		'''set«variableGen.name.toFirstUpper»'''
	}

}
