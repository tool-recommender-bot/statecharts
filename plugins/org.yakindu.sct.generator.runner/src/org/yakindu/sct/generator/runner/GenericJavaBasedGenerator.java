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
package org.yakindu.sct.generator.runner;

import static org.yakindu.sct.generator.runner.lib.IGenericJavaFeatureConstants.CONFIGURATION_MODULE;
import static org.yakindu.sct.generator.runner.lib.IGenericJavaFeatureConstants.GENERATOR_CLASS;
import static org.yakindu.sct.generator.runner.lib.IGenericJavaFeatureConstants.GENERATOR_PROJECT;
import static org.yakindu.sct.generator.runner.lib.IGenericJavaFeatureConstants.TEMPLATE_FEATURE;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.util.Strings;
import org.yakindu.sct.commons.WorkspaceClassLoaderFactory;
import org.yakindu.sct.generator.core.IExecutionFlowGenerator;
import org.yakindu.sct.generator.core.ISCTGenerator;
import org.yakindu.sct.generator.core.ISGraphGenerator;
import org.yakindu.sct.generator.core.execution.AbstractGenModelExecutor;
import org.yakindu.sct.generator.core.filesystem.ISCTFileSystemAccess;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sgen.FeatureConfiguration;
import org.yakindu.sct.model.sgen.FeatureParameterValue;
import org.yakindu.sct.model.sgen.GeneratorEntry;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;

public class GenericJavaBasedGenerator extends AbstractGenModelExecutor {

	@Inject
	protected Injector injector;

	@Override
	protected void execute(ISCTFileSystemAccess access, GeneratorEntry entry) {
		String templateClass = getClassName(entry);
		final ClassLoader classLoader = getClassLoader(entry);
		try {
			Class<?> generatorClass = (Class<?>) classLoader.loadClass(templateClass);
			ISCTGenerator generator = injector.getInstance(generatorClass);

			Class<?> iType_ = (Class<?>) getClass().getClassLoader()
					.loadClass("org.yakindu.sct.generator.core.impl.IExecutionFlowGenerator");
			Class<?> iType__ = IExecutionFlowGenerator.class;
			Class<?> iType = (Class<?>) classLoader
					.loadClass("org.yakindu.sct.generator.core.impl.IExecutionFlowGenerator");

			ExecutionFlow flow = createExecutionFlow(statechart, entry);

			if (coreFeatureHelper.serializeExecutionFlow(entry)) {
				dumpSexec(entry, flow);
			}

			if (delegate instanceof IExecutionFlowGenerator) {
				IExecutionFlowGenerator flowGenerator = (IExecutionFlowGenerator) delegate;
				flowGenerator.generate(flow, entry, sctFsa.getIFileSystemAccess());
			}
			if (iType.isInstance(delegate)) {
				IExecutionFlowGenerator flowGenerator = (IExecutionFlowGenerator) delegate;
				flowGenerator.generate(flow, entry, sctFsa.getIFileSystemAccess());
			}
			if (delegate instanceof ISGraphGenerator) {
				ISGraphGenerator graphGenerator = (ISGraphGenerator) delegate;
				graphGenerator.generate(statechart, entry, sctFsa.getIFileSystemAccess());
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.writeToConsole(e);
		}
	}

	public Module getOverridesModule(final GeneratorEntry entry) {
		String overridingModuleClass = null;
		FeatureConfiguration featureConfiguration = entry.getFeatureConfiguration(TEMPLATE_FEATURE);
		if (featureConfiguration != null) {
			FeatureParameterValue parameterValue = featureConfiguration.getParameterValue(CONFIGURATION_MODULE);
			if (parameterValue != null) {
				overridingModuleClass = parameterValue.getStringValue();
			}
		}
		if (!Strings.isEmpty(overridingModuleClass)) {
			try {
				Class<?> moduleClass = getClassLoader(entry).loadClass(overridingModuleClass);
				if (Module.class.isAssignableFrom(moduleClass)) {
					return (Module) moduleClass.newInstance();
				}
			} catch (Exception e) {
				e.printStackTrace();
				log.writeToConsole("Overriding module not found: " + overridingModuleClass);
			}
		}
		return null;
	}

	protected ClassLoader getClassLoader(GeneratorEntry entry) {
		IProject project = getGeneratorProject(entry);
		final ClassLoader classLoader = new WorkspaceClassLoaderFactory().createClassLoader(project,
				getClass().getClassLoader());
		return classLoader;
	}

	protected String getClassName(GeneratorEntry entry) {
		return entry.getFeatureConfiguration(TEMPLATE_FEATURE).getParameterValue(GENERATOR_CLASS).getStringValue();
	}

	protected IProject getGeneratorProject(GeneratorEntry entry) {
		IProject project = null;
		FeatureConfiguration templateConfig = entry.getFeatureConfiguration(TEMPLATE_FEATURE);
		FeatureParameterValue projectName = templateConfig.getParameterValue(GENERATOR_PROJECT);
		if (projectName != null) {
			project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName.getStringValue());
		} else {
			URI uri = entry.getElementRef().eResource().getURI();
			project = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(uri.toPlatformString(true)))
					.getProject();
		}
		return project;
	}

}
