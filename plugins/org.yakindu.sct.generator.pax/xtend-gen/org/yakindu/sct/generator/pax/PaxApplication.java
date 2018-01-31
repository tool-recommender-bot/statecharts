package org.yakindu.sct.generator.pax;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.yakindu.base.types.Declaration;
import org.yakindu.base.types.Event;
import org.yakindu.sct.generator.pax.IContentTemplate;
import org.yakindu.sct.generator.pax.IGenArtifactConfigurations;
import org.yakindu.sct.generator.pax.PaxFlowCode;
import org.yakindu.sct.generator.pax.PaxNaming;
import org.yakindu.sct.generator.pax.PaxNavigation;
import org.yakindu.sct.generator.pax.PaxTypes;
import org.yakindu.sct.model.sexec.Check;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.ExecutionState;
import org.yakindu.sct.model.sexec.Step;
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
  
  @Inject
  @Extension
  private PaxFlowCode _paxFlowCode;
  
  @Inject
  @Extension
  private PaxNavigation _paxNavigation;
  
  @Override
  public String content(final ExecutionFlow it, final GeneratorEntry entry, final IGenArtifactConfigurations locations) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _statesEnum = this.statesEnum(it);
    _builder.append(_statesEnum);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _declareVariables = this.declareVariables(it);
    _builder.append(_declareVariables);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _globalVariables = this.globalVariables(it);
    _builder.append(_globalVariables);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _functionImplementations = this.functionImplementations(it);
    _builder.append(_functionImplementations);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _clearInEventsFunction = this.clearInEventsFunction(it);
    _builder.append(_clearInEventsFunction);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    Object _clearOutEventsFunction = this.clearOutEventsFunction(it);
    _builder.append(_clearOutEventsFunction);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _initAndEnterFunctino = this.initAndEnterFunctino(it);
    _builder.append(_initAndEnterFunctino);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _runCycleFunction = this.runCycleFunction(it);
    _builder.append(_runCycleFunction);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _periodicRunCylceTrigger = this.periodicRunCylceTrigger(it);
    _builder.append(_periodicRunCylceTrigger);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.newLine();
    return _builder.toString();
  }
  
  public CharSequence clearInEventsFunction(final ExecutionFlow it) {
    StringConcatenation _builder = new StringConcatenation();
    String _functionPrefix = this._paxNaming.functionPrefix();
    _builder.append(_functionPrefix);
    _builder.append(" clearInEvents()");
    _builder.newLineIfNotEmpty();
    _builder.append("{");
    _builder.newLine();
    {
      EList<Scope> _scopes = it.getScopes();
      for(final Scope scope : _scopes) {
        {
          List<EventDefinition> _incomingEvents = this._paxNavigation.getIncomingEvents(scope);
          for(final EventDefinition event : _incomingEvents) {
            _builder.append("\t");
            CharSequence _access = this._paxNaming.access(event);
            _builder.append(_access, "\t");
            _builder.append(" = false;");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    {
      boolean _hasLocalScope = this._paxNavigation.hasLocalScope(it);
      if (_hasLocalScope) {
        {
          EList<Event> _events = this._paxNavigation.getInternalScope(it).getEvents();
          for(final Event event_1 : _events) {
            _builder.append("\t");
            CharSequence _access_1 = this._paxNaming.access(event_1);
            _builder.append(_access_1, "\t");
            _builder.append(" = false;");
            _builder.newLineIfNotEmpty();
          }
        }
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public Object clearOutEventsFunction(final ExecutionFlow it) {
    return null;
  }
  
  public CharSequence declareVariables(final ExecutionFlow it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<Scope> _scopes = it.getScopes();
      for(final Scope s : _scopes) {
        CharSequence _scopeVarDecl = this.scopeVarDecl(s);
        _builder.append(_scopeVarDecl);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  public CharSequence variableStruct(final ExecutionFlow it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("struct ");
    String _statechartVariablesName = this._paxNaming.statechartVariablesName();
    _builder.append(_statechartVariablesName);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    {
      EList<Scope> _scopes = it.getScopes();
      for(final Scope s : _scopes) {
        _builder.append("\t");
        CharSequence _scopeVarDecl = this.scopeVarDecl(s);
        _builder.append(_scopeVarDecl, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    String _variablePrefix = this._paxNaming.variablePrefix();
    _builder.append(_variablePrefix);
    _builder.append(" ");
    String _statechartVariables = this._paxNaming.statechartVariables();
    _builder.append(_statechartVariables);
    _builder.append(" : ");
    String _statechartVariablesName_1 = this._paxNaming.statechartVariablesName();
    _builder.append(_statechartVariablesName_1);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence globalVariables(final ExecutionFlow it) {
    StringConcatenation _builder = new StringConcatenation();
    String _variablePrefix = this._paxNaming.variablePrefix();
    _builder.append(_variablePrefix);
    _builder.append(" ");
    String _initializedVariable = this._paxNaming.initializedVariable();
    _builder.append(_initializedVariable);
    _builder.append(" : uint32_t = 0;");
    _builder.newLineIfNotEmpty();
    String _variablePrefix_1 = this._paxNaming.variablePrefix();
    _builder.append(_variablePrefix_1);
    _builder.append(" ");
    String _activeState = this._paxNaming.activeState();
    _builder.append(_activeState);
    _builder.append(" : ");
    String _enumName = this._paxNaming.enumName();
    _builder.append(_enumName);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence functionImplementations(final ExecutionFlow it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _implementation = this.toImplementation(this._paxNavigation.checkFunctions(it));
    _builder.append(_implementation);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _implementation_1 = this.toImplementation(this._paxNavigation.effectFunctions(it));
    _builder.append(_implementation_1);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _implementation_2 = this.toImplementation(this._paxNavigation.entryActionFunctions(it));
    _builder.append(_implementation_2);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _implementation_3 = this.toImplementation(this._paxNavigation.exitActionFunctions(it));
    _builder.append(_implementation_3);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _implementation_4 = this.toImplementation(this._paxNavigation.enterSequenceFunctions(it));
    _builder.append(_implementation_4);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _implementation_5 = this.toImplementation(this._paxNavigation.exitSequenceFunctions(it));
    _builder.append(_implementation_5);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    CharSequence _implementation_6 = this.toImplementation(this._paxNavigation.reactFunctions(it));
    _builder.append(_implementation_6);
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence toImplementation(final List<Step> steps) {
    StringConcatenation _builder = new StringConcatenation();
    {
      for(final Step s : steps) {
        CharSequence _functionImplementation = this.functionImplementation(s);
        _builder.append(_functionImplementation);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  protected CharSequence _functionImplementation(final Step it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("function ");
    String _shortName = this._iNamingService.getShortName(it);
    _builder.append(_shortName);
    _builder.append("()");
    _builder.newLineIfNotEmpty();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _code = this._paxFlowCode.code(it);
    _builder.append(_code, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  protected CharSequence _functionImplementation(final Check it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("function ");
    String _shortName = this._iNamingService.getShortName(it);
    _builder.append(_shortName);
    _builder.append("() : bool");
    _builder.newLineIfNotEmpty();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("return ");
    CharSequence _code = this._paxFlowCode.code(it);
    _builder.append(_code, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence periodicRunCylceTrigger(final ExecutionFlow flow) {
    StringConcatenation _builder = new StringConcatenation();
    String _every = this._paxNaming.every();
    _builder.append(_every);
    _builder.append(" ");
    String _timeTrigger = this._paxNaming.getTimeTrigger();
    _builder.append(_timeTrigger);
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    String _runCycleFunctionName = this._paxNaming.runCycleFunctionName();
    _builder.append(_runCycleFunctionName, "\t");
    _builder.append("();");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence StatemachineVariables(final ExecutionFlow flow) {
    StringConcatenation _builder = new StringConcatenation();
    String _variablePrefix = this._paxNaming.variablePrefix();
    _builder.append(_variablePrefix);
    _builder.append(" initialized = 0;");
    _builder.newLineIfNotEmpty();
    String _variablePrefix_1 = this._paxNaming.variablePrefix();
    _builder.append(_variablePrefix_1);
    _builder.append(" activeState : ");
    String _enumName = this._paxNaming.enumName();
    _builder.append(_enumName);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence initAndEnterFunctino(final ExecutionFlow flow) {
    CharSequence _xblockexpression = null;
    {
      final String defaultTimeTrigger = ("100 " + PaxTypes.MS.unit);
      StringConcatenation _builder = new StringConcatenation();
      String _functionPrefix = this._paxNaming.functionPrefix();
      _builder.append(_functionPrefix);
      _builder.append(" ");
      String _initAndEnterFunctionName = this._paxNaming.initAndEnterFunctionName();
      _builder.append(_initAndEnterFunctionName);
      _builder.append("() {");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      this._paxNaming.setTimeTrigger(defaultTimeTrigger);
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      String _activeState = this._paxNaming.activeState();
      _builder.append(_activeState, "\t");
      _builder.append(" = ; //tbd");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("clearInEvents();");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("initialized = 1;");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _xblockexpression = _builder;
    }
    return _xblockexpression;
  }
  
  public CharSequence runCycleFunction(final ExecutionFlow flow) {
    StringConcatenation _builder = new StringConcatenation();
    String _functionPrefix = this._paxNaming.functionPrefix();
    _builder.append(_functionPrefix);
    _builder.append(" ");
    String _runCycleFunctionName = this._paxNaming.runCycleFunctionName();
    _builder.append(_runCycleFunctionName);
    _builder.append("() {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("if(initialized == 0) {");
    _builder.newLine();
    _builder.append("\t\t");
    String _initAndEnterFunctionName = this._paxNaming.initAndEnterFunctionName();
    _builder.append(_initAndEnterFunctionName, "\t\t");
    _builder.append("();");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _runCycleIfElse = this.runCycleIfElse(flow);
    _builder.append(_runCycleIfElse, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("clearInEvents();");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence runCycleIfElse(final ExecutionFlow it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<ExecutionState> _states = it.getStates();
      for(final ExecutionState state : _states) {
        _builder.append("else if (");
        String _enumName = this._paxNaming.enumName();
        _builder.append(_enumName);
        _builder.append(".");
        String _shortName = this._iNamingService.getShortName(state);
        _builder.append(_shortName);
        _builder.append(" == activeState){");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        String _shortName_1 = this._iNamingService.getShortName(state.getReactSequence());
        _builder.append(_shortName_1, "\t");
        _builder.append("();");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  public CharSequence scopeVarDecl(final Scope s) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("// Declare used variables");
    _builder.newLine();
    final Iterable<Declaration> vars = this.typeRelevantDeclarations(s);
    _builder.newLineIfNotEmpty();
    {
      for(final Declaration variable : vars) {
        String _variablePrefix = this._paxNaming.variablePrefix();
        _builder.append(_variablePrefix);
        _builder.append(" ");
        String _name = variable.getName();
        _builder.append(_name);
        _builder.append(" : ");
        CharSequence _scopeTypeDeclMember = this.scopeTypeDeclMember(variable);
        _builder.append(_scopeTypeDeclMember);
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  protected CharSequence _scopeTypeDeclMember(final EventDefinition it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("bool ");
    return _builder;
  }
  
  protected CharSequence _scopeTypeDeclMember(final VariableDefinition it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("uint32_t");
    return _builder;
  }
  
  public CharSequence scopeConstDecl(final Scope s) {
    StringConcatenation _builder = new StringConcatenation();
    final Iterable<VariableDefinition> consts = this.constDeclarations(s);
    _builder.newLineIfNotEmpty();
    {
      for(final VariableDefinition constant : consts) {
        String _variablePrefix = this._paxNaming.variablePrefix();
        _builder.append(_variablePrefix);
        _builder.append(" ");
        String _name = constant.getName();
        _builder.append(_name);
        _builder.append(" = ");
        _builder.append(constant);
        _builder.newLineIfNotEmpty();
      }
    }
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
  
  public CharSequence statesEnum(final ExecutionFlow it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("enum ");
    String _enumName = this._paxNaming.enumName();
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
  
  public CharSequence functionImplementation(final Step it) {
    if (it instanceof Check) {
      return _functionImplementation((Check)it);
    } else if (it != null) {
      return _functionImplementation(it);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
  
  public CharSequence scopeTypeDeclMember(final Declaration it) {
    if (it instanceof EventDefinition) {
      return _scopeTypeDeclMember((EventDefinition)it);
    } else if (it instanceof VariableDefinition) {
      return _scopeTypeDeclMember((VariableDefinition)it);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
}
