package org.yakindu.sct.model.stext.resource

import org.eclipse.core.resources.IFile
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.resource.EObjectDescription
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionStrategy
import org.eclipse.xtext.util.IAcceptor
import org.yakindu.base.types.TypesFactory
import org.yakindu.base.types.typesystem.GenericTypeSystem
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer

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
		createPackage => [
			name = computePackageName(WorkspaceSynchronizer.getFile(sc.eResource))
			member += createComplexType => [ scType |
				scType.name = sc.name
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
				// Implicit operations
				scType.features += createOperation => [
					name = "init"
					typeSpecifier = createTypeSpecifier => [
						type = ts.getType(ITypeSystem.VOID)
					]
				]
				scType.features += createOperation => [
					name = "enter"
					typeSpecifier = createTypeSpecifier => [
						type = ts.getType(ITypeSystem.VOID)
					]
				]
				scType.features += createOperation => [
					name = "exit"
					typeSpecifier = createTypeSpecifier => [
						type = ts.getType(ITypeSystem.VOID)
					]
				]
				scType.features += createOperation => [
					name = "isActive"
					typeSpecifier = createTypeSpecifier => [
						type = ts.getType(ITypeSystem.BOOLEAN)
					]
				]
				scType.features += createOperation => [
					name = "isFinal"
					typeSpecifier = createTypeSpecifier => [
						type = ts.getType(ITypeSystem.BOOLEAN)
					]
				]

				scType.features += createOperation => [
					name = "runCycle"
					typeSpecifier = createTypeSpecifier => [
						type = ts.getType(ITypeSystem.BOOLEAN)
					]
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
