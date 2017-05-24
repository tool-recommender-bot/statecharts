package org.yakindu.base.generator.java.test.util;

import org.eclipse.xtext.junit4.IInjectorProvider;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class JavaGeneratorTestInjectorProvider implements IInjectorProvider {
	protected Injector injector;
	@Override
	public Injector getInjector() {
		if (injector == null) {
			injector = Guice.createInjector(new JavaGeneratorTestModule());
		}
		return injector;
	}
}
