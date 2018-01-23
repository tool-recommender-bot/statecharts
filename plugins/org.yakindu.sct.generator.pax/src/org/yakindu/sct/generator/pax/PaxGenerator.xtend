package org.yakindu.sct.generator.pax

import com.google.inject.Inject
import org.eclipse.xtext.generator.IFileSystemAccess
import org.yakindu.sct.generator.core.IExecutionFlowGenerator
import org.yakindu.sct.generator.pax.IGenArtifactConfigurations.GenArtifactConfiguration
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry

import static org.yakindu.sct.generator.core.filesystem.ISCTFileSystemAccess.*

class PaxGenerator implements IExecutionFlowGenerator {

	@Inject
	IGenArtifactConfigurations configs
	@Inject extension PaxNavigation
	@Inject extension PaxNaming
	@Inject extension PaxApplication application

	override generate(ExecutionFlow flow, GeneratorEntry entry, IFileSystemAccess fsa) {
		initGenerationArtifacts(flow, entry, configs)
		generateArtifacts(flow, entry, fsa, configs)
	}

	def generateArtifacts(ExecutionFlow flow, GeneratorEntry entry, IFileSystemAccess fsa,
		IGenArtifactConfigurations locations) {
		for (GenArtifactConfiguration a : locations.configurations) {
			if (!a.skip) {
				fsa.generateFile(a.getName, a.getOutputName, a.getContentTemplate.content(flow, entry, locations))
			}
		}
	}

	def protected initGenerationArtifacts(ExecutionFlow it, GeneratorEntry entry,
		IGenArtifactConfigurations locations) {
		locations.configure(flow.application.x, entry.sourceOutput, application);
	}

	def protected getSourceOutput(GeneratorEntry entry) {
		TARGET_FOLDER_OUTPUT
	} 

}
