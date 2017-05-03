package org.yakindu.base.generator;

import org.yakindu.base.types.typesystem.GenericTypeSystem;
import org.yakindu.base.types.typesystem.ITypeSystem;

import com.google.inject.AbstractModule;

public class GeneratorModule extends AbstractModule {
	@Override
	protected void configure() {
		bind(ClassGen.class);
		bind(MethodGen.class);
		bind(ParameterGen.class);
		bind(ITypeSystem.class).toInstance(GenericTypeSystem.getInstance());
	}
}
