/** 
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 */
package org.yakindu.base.expressions.test.utils

import com.google.common.collect.Lists
import com.google.inject.Inject
import com.google.inject.Singleton
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionStrategy
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.scoping.impl.SimpleScope
import org.yakindu.base.expressions.scoping.ExpressionsScopeProvider
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Declaration
import org.yakindu.base.types.typesystem.ITypeSystem

/** 
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@Singleton
class ExpressionsTestScopeProvider extends ExpressionsScopeProvider {

	@Inject
	protected IQualifiedNameProvider qfnProvider
	@Inject
	protected DefaultResourceDescriptionStrategy descriptionStrategy
	@Inject
	protected ITypeSystem typeSystem

	List<IEObjectDescription> descriptions = Lists.newArrayList

	def setContext(EObject ... objects) {
		descriptions.clear
		typeSystem.concreteTypes.forEach[addToIndex(descriptions, it)]
		addToIndex(descriptions, objects)
	}

	override IScope getScope(EObject context, EReference reference) {
		var IScope parentScope = super.getScope(context, reference)
		val List<IEObjectDescription> descriptions = Lists.newArrayList(parentScope.getAllElements())
		descriptions += this.descriptions
		return new SimpleScope(descriptions)
	}

	def protected void addToIndex(List<IEObjectDescription> descriptions, EObject ... elements) {
		elements.forEach [ element |
			descriptionStrategy.createEObjectDescriptions(element, [descriptions += it])
			if (element instanceof ComplexType) {
				for (Declaration feature : element.features) {
					descriptionStrategy.createEObjectDescriptions(element, [descriptions += it])
				}
			}
		]
	}
}
