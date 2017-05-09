package org.yakindu.base.generator.test.util;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.junit4.IInjectorProvider;
import org.yakindu.base.base.BasePackage;
import org.yakindu.base.generator.GeneratorModule;
import org.yakindu.base.types.inferrer.ITypeSystemInferrer;
import org.yakindu.sct.domain.extension.DomainRegistry;
import org.yakindu.sct.domain.extension.IDomain;
import org.yakindu.sct.model.stext.inferrer.STextTypeInferrer;
import org.yakindu.sct.model.stext.test.util.STextRuntimeTestModule;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.name.Names;
import com.google.inject.util.Modules;

public class GeneratorInjectorProvider implements IInjectorProvider {
	protected Injector injector;
	@Override
	public Injector getInjector() {
		if (injector == null) {
			injector = Guice.createInjector(getModule());
		}
		
		return injector;
	}

	protected Module getModule() {
		return Modules.combine(new GeneratorModule(), new STextRuntimeTestModule(), new AbstractModule() {
			@Override
			protected void configure() {
				bind(String.class).annotatedWith(Names.named(DomainRegistry.DOMAIN_ID))
						.toInstance(BasePackage.Literals.DOMAIN_ELEMENT__DOMAIN_ID.getDefaultValueLiteral());
				bind(ITypeSystemInferrer.class).to(STextTypeInferrer.class);
			}
		});
	}
	
	public void register(Injector injector) {
		org.eclipse.xtext.resource.IResourceFactory resourceFactory = injector.getInstance(org.eclipse.xtext.resource.IResourceFactory.class);
		org.eclipse.xtext.resource.IResourceServiceProvider serviceProvider = injector.getInstance(org.eclipse.xtext.resource.IResourceServiceProvider.class);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("stext", resourceFactory);
		org.eclipse.xtext.resource.IResourceServiceProvider.Registry.INSTANCE.getExtensionToFactoryMap().put("stext", serviceProvider);
	}

}
