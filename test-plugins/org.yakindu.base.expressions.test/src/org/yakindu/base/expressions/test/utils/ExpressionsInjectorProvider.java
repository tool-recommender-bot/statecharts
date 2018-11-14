/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.base.expressions.test.utils;

import org.eclipse.xtext.junit4.IInjectorProvider;
import org.eclipse.xtext.linking.LinkingScopeProviderBinding;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.yakindu.base.expressions.ExpressionsRuntimeModule;
import org.yakindu.base.expressions.inferrer.ExpressionsTypeInferrer;
import org.yakindu.base.types.inferrer.ITypeSystemInferrer;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.util.Modules;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class ExpressionsInjectorProvider implements IInjectorProvider {

	public Injector getInjector() {
		return Guice.createInjector(Modules.override(new ExpressionsRuntimeModule()).with(new AbstractModule() {
			@Override
			protected void configure() {
				bind(ITypeSystemInferrer.class).to(ExpressionsTypeInferrer.class);
				bind(IScopeProvider.class).annotatedWith(LinkingScopeProviderBinding.class)
						.to(ExpressionsTestScopeProvider.class);
			}
		}));
	}
}
