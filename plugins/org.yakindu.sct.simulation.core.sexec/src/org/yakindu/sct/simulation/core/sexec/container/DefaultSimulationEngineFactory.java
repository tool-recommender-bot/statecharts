/**
 * Copyright (c) 2013 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.simulation.core.sexec.container;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.yakindu.base.types.typesystem.AbstractTypeSystem;
import org.yakindu.base.types.typesystem.ITypeSystem;
import org.yakindu.sct.domain.extension.DomainRegistry;
import org.yakindu.sct.domain.extension.IDomain;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sruntime.ExecutionContext;
import org.yakindu.sct.model.stext.lib.StatechartAnnotations;
import org.yakindu.sct.model.stext.scoping.IPackageImport2URIMapper;
import org.yakindu.sct.model.stext.scoping.IPackageImport2URIMapper.PackageImport;
import org.yakindu.sct.simulation.core.engine.ISimulationEngine;
import org.yakindu.sct.simulation.core.sexec.launch.ISCTLaunchParameters;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class DefaultSimulationEngineFactory implements ISimulationEngineFactory {

	@Inject
	private Injector injector;
	@Inject
	private StatechartAnnotations annotations;
	@Inject
	private DefaultSimulationEngineFactoryHelper helper;
	@Inject
	private IPackageImport2URIMapper mapper;

	public List<ISimulationEngine> createExecutionContainer(Statechart statechart, ILaunch launch)
			throws CoreException {
		List<ISimulationEngine> engines = new ArrayList<ISimulationEngine>();
		ISimulationEngine controller = createController(statechart);
		injector.injectMembers(controller);
		engines.add(controller);

		// For restoring execution context
		String attribute = launch.getLaunchConfiguration().getAttribute(ISCTLaunchParameters.EXECUTION_CONTEXT, "");
		if (attribute != null && attribute.trim().length() > 0) {
			ExecutionContext context = restore(attribute, statechart);
			controller.setExecutionContext(context);
		}
		ResourceSet set = new ResourceSetImpl();
		Iterable<String> imports = helper.getStatechartImports(statechart);
		for (String currentImport : imports) {
			Optional<PackageImport> packImport = mapper.findPackageImport(statechart.eResource(), currentImport);
			if (!packImport.isPresent())
				continue;
			Statechart objectByType = (Statechart) EcoreUtil.getObjectByType(
					set.getResource(packImport.get().getUri(), true).getContents(), SGraphPackage.Literals.STATECHART);
			Assert.isNotNull(objectByType);
			ISimulationEngine importedController = createController(objectByType);
			injector.injectMembers(importedController);
			engines.add(importedController);
		}
		return engines;
	}

	protected ISimulationEngine createController(Statechart statechart) throws CoreException {
		if (annotations.isEventDriven(statechart)) {
			return new EventDrivenSimulationEngine(statechart);
		}
		return new CycleBasedSimulationEngine(statechart);
	}

	protected ExecutionContext restore(String context, Statechart statechart) {
		try {
			ResourceSet set = new ResourceSetImpl();
			Resource resource = set.createResource(URI.createURI("snapshot.xmi"));
			if (resource == null)
				return null;
			set.getResources().add(resource);
			resource.load(new URIConverter.ReadableInputStream(context, "UTF_8"), Collections.emptyMap());
			IDomain domain = DomainRegistry.getDomain(statechart);
			Injector injector = domain.getInjector(IDomain.FEATURE_SIMULATION);
			ITypeSystem typeSystem = injector.getInstance(ITypeSystem.class);
			if (typeSystem instanceof AbstractTypeSystem) {
				set.getResources().add(((AbstractTypeSystem) typeSystem).getResource());
			}
			EcoreUtil.resolveAll(resource);
			ExecutionContext result = (ExecutionContext) resource.getContents().get(0);
			result.setSnapshot(true);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
