package org.yakindu.sct.generator.pax;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.yakindu.sct.generator.pax.IContentTemplate;
import org.yakindu.sct.generator.pax.IGenArtifactConfigurations;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sgen.GeneratorEntry;

@SuppressWarnings("all")
public class PaxApplication implements IContentTemplate {
  @Override
  public String content(final ExecutionFlow flow, final GeneratorEntry entry, final IGenArtifactConfigurations locations) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder.toString();
  }
  
  public CharSequence StatesEnum(final ExecutionFlow it) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder;
  }
}
