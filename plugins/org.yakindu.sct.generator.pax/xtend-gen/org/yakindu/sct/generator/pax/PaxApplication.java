package org.yakindu.sct.generator.pax;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.yakindu.sct.generator.pax.IContentTemplate;
import org.yakindu.sct.generator.pax.IGenArtifactConfigurations;
import org.yakindu.sct.generator.pax.PaxNaming;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sexec.naming.INamingService;
import org.yakindu.sct.model.sgen.GeneratorEntry;

@SuppressWarnings("all")
public class PaxApplication implements IContentTemplate {
  @Inject
  @Extension
  protected PaxNaming _paxNaming;
  
  @Inject
  @Extension
  protected INamingService _iNamingService;
  
  @Override
  public String content(final ExecutionFlow flow, final GeneratorEntry entry, final IGenArtifactConfigurations locations) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _StatesEnum = this.StatesEnum(flow);
    _builder.append(_StatesEnum);
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  public CharSequence StatesEnum(final ExecutionFlow it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("enum ");
    String _enumName = this._paxNaming.enumName(it);
    _builder.append(_enumName);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    {
      EList<ExecutionState> _states = it.getStates();
      boolean _hasElements = false;
      for(final ExecutionState state : _states) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(",", "\t");
        }
        _builder.append("\t");
        String _shortName = this._iNamingService.getShortName(state);
        _builder.append(_shortName, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
}
