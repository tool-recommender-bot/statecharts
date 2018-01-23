package org.yakindu.sct.generator.pax;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.yakindu.base.types.Declaration;
import org.yakindu.sct.generator.pax.IContentTemplate;
import org.yakindu.sct.generator.pax.IGenArtifactConfigurations;
import org.yakindu.sct.generator.pax.PaxNaming;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sexec.TimeEvent;
import org.yakindu.sct.model.sexec.naming.INamingService;
import org.yakindu.sct.model.sgen.GeneratorEntry;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.stext.stext.EventDefinition;
import org.yakindu.sct.model.stext.stext.VariableDefinition;

@SuppressWarnings("all")
public class PaxApplication implements IContentTemplate {
  @Inject
  @Extension
  private PaxNaming _paxNaming;
  
  @Inject
  @Extension
  private INamingService _iNamingService;
  
  @Override
  public String content(final ExecutionFlow flow, final GeneratorEntry entry, final IGenArtifactConfigurations locations) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _StatesEnum = this.StatesEnum(flow);
    _builder.append(_StatesEnum);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      EList<Scope> _scopes = flow.getScopes();
      for(final Scope s : _scopes) {
        CharSequence _scopeVarDecl = this.scopeVarDecl(s);
        _builder.append(_scopeVarDecl);
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    CharSequence _Events = this.Events();
    _builder.append(_Events);
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
  
  public CharSequence scopeVarDecl(final Scope s) {
    StringConcatenation _builder = new StringConcatenation();
    final Iterable<Declaration> vars = this.typeRelevantDeclarations(s);
    _builder.newLineIfNotEmpty();
    {
      for(final Declaration variable : vars) {
        _builder.append("var ");
        String _name = variable.getName();
        _builder.append(_name);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public CharSequence scopeTypeDeclMember(final TimeEvent it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("sc_boolean ");
    String _shortName = this._iNamingService.getShortName(it);
    _builder.append(_shortName);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  private Iterable<Declaration> typeRelevantDeclarations(final Scope scope) {
    final Function1<Declaration, Boolean> _function = (Declaration it) -> {
      boolean _switchResult = false;
      boolean _matched = false;
      if (it instanceof EventDefinition) {
        _matched=true;
        _switchResult = true;
      }
      if (!_matched) {
        if (it instanceof TimeEvent) {
          _matched=true;
          _switchResult = true;
        }
      }
      if (!_matched) {
        if (it instanceof VariableDefinition) {
          _matched=true;
          boolean _isConst = ((VariableDefinition)it).isConst();
          _switchResult = (!_isConst);
        }
      }
      if (!_matched) {
        _switchResult = false;
      }
      return Boolean.valueOf(_switchResult);
    };
    return IterableExtensions.<Declaration>filter(scope.getDeclarations(), _function);
  }
  
  private Iterable<VariableDefinition> constDeclarations(final Scope scope) {
    final Function1<VariableDefinition, Boolean> _function = (VariableDefinition it) -> {
      return Boolean.valueOf(it.isConst());
    };
    return IterableExtensions.<VariableDefinition>filter(Iterables.<VariableDefinition>filter(scope.getDeclarations(), VariableDefinition.class), _function);
  }
  
  public CharSequence Events() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\t\t\t");
    _builder.newLine();
    return _builder;
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
