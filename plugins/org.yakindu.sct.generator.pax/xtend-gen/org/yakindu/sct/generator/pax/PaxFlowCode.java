package org.yakindu.sct.generator.pax;

import com.google.inject.Inject;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.yakindu.sct.generator.pax.PaxExpressionsGenerator;
import org.yakindu.sct.generator.pax.PaxNaming;
import org.yakindu.sct.generator.pax.PaxNamingService;
import org.yakindu.sct.generator.pax.PaxNavigation;
import org.yakindu.sct.model.sexec.StateCase;
import org.yakindu.sct.model.sexec.StateSwitch;
import org.yakindu.sct.model.sexec.Step;

@SuppressWarnings("all")
public class PaxFlowCode {
  @Inject
  @Extension
  private PaxNaming _paxNaming;
  
  @Inject
  @Extension
  private PaxNavigation _paxNavigation;
  
  @Inject
  @Extension
  private PaxExpressionsGenerator _paxExpressionsGenerator;
  
  @Inject
  @Extension
  private PaxNamingService _paxNamingService;
  
  protected CharSequence _code(final Step it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("//ActionCode for Step \'");
    String _name = it.getClass().getName();
    _builder.append(_name);
    _builder.append("\' not defined");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected CharSequence _code(final StateSwitch it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<StateCase> _cases = it.getCases();
      for(final StateCase caseid : _cases) {
        {
          boolean _isEnterSequence = this._paxNavigation.isEnterSequence(caseid, it);
          boolean _equals = (_isEnterSequence == true);
          if (_equals) {
            _builder.append("if\t(");
            String _shortName = this._paxNamingService.getShortName(caseid.getStep());
            _builder.append(_shortName);
            _builder.append(") {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.append("// code");
            _builder.newLine();
            _builder.append("}");
            _builder.newLine();
          } else {
            _builder.append("else if (");
            String _shortName_1 = this._paxNamingService.getShortName(caseid.getStep());
            _builder.append(_shortName_1);
            _builder.append(") {");
            _builder.newLineIfNotEmpty();
            _builder.append("\t");
            _builder.newLine();
            _builder.append("}");
            _builder.newLine();
          }
        }
      }
    }
    return _builder;
  }
  
  public CharSequence code(final Step it) {
    if (it instanceof StateSwitch) {
      return _code((StateSwitch)it);
    } else if (it != null) {
      return _code(it);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
}
