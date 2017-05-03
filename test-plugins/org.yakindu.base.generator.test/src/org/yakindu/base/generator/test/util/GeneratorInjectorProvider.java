package org.yakindu.base.generator.test.util;

import org.eclipse.xtext.junit4.IInjectorProvider;
import org.yakindu.base.generator.GeneratorModule;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

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
		return new GeneratorModule();
	}

}
