package org.yakindu.sct.generator.pax;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.xbase.lib.Extension;
import org.yakindu.sct.generator.core.IExecutionFlowGenerator;
import org.yakindu.sct.generator.core.filesystem.ISCTFileSystemAccess;
import org.yakindu.sct.generator.pax.IGenArtifactConfigurations;
import org.yakindu.sct.generator.pax.PaxApplication;
import org.yakindu.sct.generator.pax.PaxNaming;
import org.yakindu.sct.generator.pax.PaxNavigation;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sgen.GeneratorEntry;

@SuppressWarnings("all")
public class PaxGenerator implements IExecutionFlowGenerator {
  @Inject
  private IGenArtifactConfigurations configs;
  
  @Inject
  @Extension
  private PaxNavigation _paxNavigation;
  
  @Inject
  @Extension
  private PaxNaming _paxNaming;
  
  @Inject
  @Extension
  private PaxApplication application;
  
  @Override
  public void generate(final ExecutionFlow flow, final GeneratorEntry entry, final IFileSystemAccess fsa) {
    this.initGenerationArtifacts(flow, entry, this.configs);
    this.generateArtifacts(flow, entry, fsa, this.configs);
  }
  
  public void generateArtifacts(final ExecutionFlow flow, final GeneratorEntry entry, final IFileSystemAccess fsa, final IGenArtifactConfigurations locations) {
    List<IGenArtifactConfigurations.GenArtifactConfiguration> _configurations = locations.getConfigurations();
    for (final IGenArtifactConfigurations.GenArtifactConfiguration a : _configurations) {
      boolean _skip = a.getSkip();
      boolean _not = (!_skip);
      if (_not) {
        fsa.generateFile(a.getName(), a.getOutputName(), a.getContentTemplate().content(flow, entry, locations));
      }
    }
  }
  
  protected void initGenerationArtifacts(final ExecutionFlow it, final GeneratorEntry entry, final IGenArtifactConfigurations locations) {
    locations.configure(this._paxNaming.x(this._paxNaming.application(this._paxNavigation.flow(it))), this.getSourceOutput(entry), this.application);
  }
  
  protected String getSourceOutput(final GeneratorEntry entry) {
    return ISCTFileSystemAccess.TARGET_FOLDER_OUTPUT;
  }
}
