package org.yakindu.sct.generator.java;

import org.yakindu.sct.generator.core.GeneratorModule;
import org.yakindu.sct.generator.core.IExecutionFlowGenerator;
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess;
import org.yakindu.sct.generator.java.types.JavaTypeSystemAccess;
import org.yakindu.sct.model.sexec.naming.INamingService;
import org.yakindu.sct.model.sgen.GeneratorEntry;

import com.google.inject.Binder;
import com.google.inject.Scopes;

public class JavaGeneratorModule implements GeneratorModule {

	@Override
	public void configure(GeneratorEntry entry, Binder binder) {
		binder.bind(IExecutionFlowGenerator.class).to(JavaGenerator.class);
		binder.bind(ICodegenTypeSystemAccess.class).to(JavaTypeSystemAccess.class);
		binder.bind(INamingService.class).to(JavaNamingService.class).in(Scopes.SINGLETON);
	}

}
