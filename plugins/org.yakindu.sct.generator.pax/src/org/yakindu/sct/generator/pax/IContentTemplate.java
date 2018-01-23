package org.yakindu.sct.generator.pax;

import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sgen.GeneratorEntry;

public interface IContentTemplate {
	String content(ExecutionFlow flow, GeneratorEntry entry, IGenArtifactConfigurations locations);
}
 