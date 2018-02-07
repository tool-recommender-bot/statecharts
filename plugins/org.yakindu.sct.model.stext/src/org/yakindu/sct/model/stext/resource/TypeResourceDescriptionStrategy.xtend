package org.yakindu.sct.model.stext.resource

import org.eclipse.core.resources.IFile
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.resource.EObjectDescription
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionStrategy
import org.eclipse.xtext.util.IAcceptor
import org.yakindu.base.types.Type
import org.yakindu.base.types.TypesFactory
import org.yakindu.base.types.typesystem.GenericTypeSystem
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.model.sgraph.RegularState
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.stext.stext.InterfaceScope

class TypeResourceDescriptionStrategy extends DefaultResourceDescriptionStrategy {

	extension TypesFactory factory = TypesFactory.eINSTANCE
	extension ITypeSystem ts = GenericTypeSystem.instance

	override boolean createEObjectDescriptions(EObject eObject, IAcceptor<IEObjectDescription> acceptor) {
		if (eObject instanceof Statechart) {
			val pack = createTypeDescription(eObject as Statechart)
			pack.member.forEach[acceptor.accept(EObjectDescription.create(name, it))]
			return false
		}
		return false
	}

	def protected createTypeDescription(Statechart sc) {
		createPackage => [ package |
			package.name = computePackageName(WorkspaceSynchronizer.getFile(sc.eResource))
			package.member += createEnumerationType => [
				name = "States"
				sc.eAllContents.filter(RegularState).forEach [ state |
					enumerator += createEnumerator => [
						name = state.name
					]
				]
			]

			package.member += createComplexType => [ scType |
				scType.name = sc.name
				scType.superTypes += createStatemachineType
				// Named Interfaces
				sc.scopes.filter(InterfaceScope).filter[name !== null].forEach [ iface |
					scType.features += createProperty => [ prop |
						prop.name = iface.name
						prop.typeSpecifier = createTypeSpecifier => [
							type = createComplexType => [
								name = iface.name
								iface.declarations.forEach[decl|features += EcoreUtil.copy(decl)]
							]
						]
					]
				]
				// Unnamed interfaces
				sc.scopes.filter(InterfaceScope).filter[name === null].forEach [ iface |
					iface.declarations.forEach[decl|scType.features += EcoreUtil.copy(decl)]
				]
				// State enumerations
				// isStateActive Operation
				scType.features += createOperation => [
					name = "isStateActive"
					parameters += createParameter => [
						name = "state"
						typeSpecifier = createTypeSpecifier => [
							type = package.member.head as Type

						]
					]
					typeSpecifier = createTypeSpecifier => [
						type = ts.getType(ITypeSystem.BOOLEAN)
					]
				]
			]
		]
	}

	def createStatemachineType() {
		createComplexType => [
			name = "Statemachine"
			// Implicit operations
			features += createOperation => [
				name = "init"
				typeSpecifier = createTypeSpecifier => [
					type = ts.getType(ITypeSystem.VOID)
				]
			]
			features += createOperation => [
				name = "enter"
				typeSpecifier = createTypeSpecifier => [
					type = ts.getType(ITypeSystem.VOID)
				]
			]
			features += createOperation => [
				name = "exit"
				typeSpecifier = createTypeSpecifier => [
					type = ts.getType(ITypeSystem.VOID)
				]
			]
			features += createOperation => [
				name = "isActive"
				typeSpecifier = createTypeSpecifier => [
					type = ts.getType(ITypeSystem.BOOLEAN)
				]
			]
			features += createOperation => [
				name = "isFinal"
				typeSpecifier = createTypeSpecifier => [
					type = ts.getType(ITypeSystem.BOOLEAN)
				]
			]

			features += createOperation => [
				name = "runCycle"
				typeSpecifier = createTypeSpecifier => [
					type = ts.getType(ITypeSystem.BOOLEAN)
				]
			]
		]
	}

	// Copied From CHeader Resource TODO
	def static public computePackageName(IFile headerFile) {
		val pathToHeader = headerFile.projectRelativePath.removeFileExtension
		val result = QualifiedName.create(pathToHeader.segments.map[it]).toString
		println(result)
		result
	}

}
