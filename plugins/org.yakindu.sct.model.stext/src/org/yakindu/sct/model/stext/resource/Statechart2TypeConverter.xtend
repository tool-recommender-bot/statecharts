/**
 * Copyright (c) 2017 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.model.stext.resource

import com.google.inject.Inject
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.TypesFactory
import org.yakindu.base.types.typesystem.GenericTypeSystem
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.model.sgraph.Statechart

import static extension org.eclipse.emf.ecore.util.EcoreUtil.*

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
class Statechart2TypeConverter {

	TypesFactory f = TypesFactory.eINSTANCE

	@Inject
	GenericTypeSystem ts

	def ComplexType convert(Statechart sc) {
		return f.createComplexType => [
			name = "Type"
			features += sc.scopes.map[declarations].flatten.map [ decl |
				decl.copy
			]
			features += f.createOperation => [
				name = "enter"
				typeSpecifier = f.createTypeSpecifier => [
					type = ts.getType(ITypeSystem.VOID)
				]
			]

			features += f.createOperation => [
				name = "exit"
				typeSpecifier = f.createTypeSpecifier => [
					type = ts.getType(ITypeSystem.VOID)
				]
			]

			features += f.createOperation => [
				name = "cycle"
				typeSpecifier = f.createTypeSpecifier => [
					type = ts.getType(ITypeSystem.VOID)
				]
			]

			features += f.createOperation => [
				name = "isActive"
				typeSpecifier = f.createTypeSpecifier => [
					type = ts.getType(ITypeSystem.BOOLEAN)
				]
			]

		]
	}
}
