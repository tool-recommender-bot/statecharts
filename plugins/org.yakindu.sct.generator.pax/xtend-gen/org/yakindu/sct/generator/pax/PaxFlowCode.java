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
import org.yakindu.sct.model.sexec.Call;
import org.yakindu.sct.model.sexec.Check;
import org.yakindu.sct.model.sexec.CheckRef;
import org.yakindu.sct.model.sexec.EnterState;
import org.yakindu.sct.model.sexec.Execution;
import org.yakindu.sct.model.sexec.ExitState;
import org.yakindu.sct.model.sexec.HistoryEntry;
import org.yakindu.sct.model.sexec.If;
import org.yakindu.sct.model.sexec.SaveHistory;
import org.yakindu.sct.model.sexec.ScheduleTimeEvent;
import org.yakindu.sct.model.sexec.Sequence;
import org.yakindu.sct.model.sexec.StateCase;
import org.yakindu.sct.model.sexec.StateSwitch;
import org.yakindu.sct.model.sexec.Step;
import org.yakindu.sct.model.sexec.Trace;
import org.yakindu.sct.model.sexec.TraceStateEntered;
import org.yakindu.sct.model.sexec.TraceStateExited;
import org.yakindu.sct.model.sexec.UnscheduleTimeEvent;

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
  
  protected CharSequence _code(final Trace it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("//ActionCode for Trace \'");
    String _name = it.getClass().getName();
    _builder.append(_name);
    _builder.append("\' not defined");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected CharSequence _code(final TraceStateEntered it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("//ActionCode for TraceStateEntered \'");
    String _name = it.getClass().getName();
    _builder.append(_name);
    _builder.append("\' not defined");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected CharSequence _code(final TraceStateExited it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("//ActionCode for TraceStateExited \'");
    String _name = it.getClass().getName();
    _builder.append(_name);
    _builder.append("\' not defined");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected CharSequence _code(final SaveHistory it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("//ActionCode for SaveHistory \'");
    String _name = it.getClass().getName();
    _builder.append(_name);
    _builder.append("\' not defined");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected CharSequence _code(final HistoryEntry it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("//ActionCode for HistoryEntry \'");
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
  
  protected CharSequence _code(final ScheduleTimeEvent it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("//ActionCode for ScheduleTimeEvent \'");
    String _name = it.getClass().getName();
    _builder.append(_name);
    _builder.append("\' not defined");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected CharSequence _code(final UnscheduleTimeEvent it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("//ActionCode for UnscheduleTimeEvent \'");
    String _name = it.getClass().getName();
    _builder.append(_name);
    _builder.append("\' not defined");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected CharSequence _code(final Execution it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _code = this._paxExpressionsGenerator.code(it.getStatement());
    _builder.append(_code);
    _builder.append(";");
    return _builder;
  }
  
  protected CharSequence _code(final Call it) {
    StringConcatenation _builder = new StringConcatenation();
    String _shortName = this._paxNamingService.getShortName(it.getStep());
    _builder.append(_shortName);
    _builder.append("();");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected CharSequence _code(final Sequence it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<Step> _steps = it.getSteps();
      for(final Step s : _steps) {
        CharSequence _code = this.code(s);
        _builder.append(_code);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }
  
  protected CharSequence _code(final Check it) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field sc_boolean_code is undefined for the type Expression");
  }
  
  protected CharSequence _code(final CheckRef it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Check _check = it.getCheck();
      boolean _tripleNotEquals = (_check != null);
      if (_tripleNotEquals) {
        String _shortName = this._paxNamingService.getShortName(it.getCheck());
        _builder.append(_shortName);
        _builder.append("()");
      } else {
        _builder.append("true");
      }
    }
    return _builder;
  }
  
  protected CharSequence _code(final If it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("if (");
    CharSequence _code = this.code(it.getCheck());
    _builder.append(_code);
    _builder.append(" == true)");
    _builder.newLineIfNotEmpty();
    _builder.append("{ ");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _code_1 = this.code(it.getThenStep());
    _builder.append(_code_1, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    {
      Step _elseStep = it.getElseStep();
      boolean _tripleNotEquals = (_elseStep != null);
      if (_tripleNotEquals) {
        _builder.append(" else");
        _builder.newLineIfNotEmpty();
        _builder.append("{");
        _builder.newLine();
        _builder.append("\t");
        CharSequence _code_2 = this.code(it.getElseStep());
        _builder.append(_code_2, "\t");
        _builder.newLineIfNotEmpty();
        _builder.append("}");
        _builder.newLine();
      }
    }
    return _builder;
  }
  
  protected CharSequence _code(final EnterState it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("//ActionCode for EnterState \'");
    String _name = it.getClass().getName();
    _builder.append(_name);
    _builder.append("\' not defined");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  protected CharSequence _code(final ExitState it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("//ActionCode for ExitState \'");
    String _name = it.getClass().getName();
    _builder.append(_name);
    _builder.append("\' not defined");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence code(final Step it) {
    if (it instanceof CheckRef) {
      return _code((CheckRef)it);
    } else if (it instanceof TraceStateEntered) {
      return _code((TraceStateEntered)it);
    } else if (it instanceof TraceStateExited) {
      return _code((TraceStateExited)it);
    } else if (it instanceof Call) {
      return _code((Call)it);
    } else if (it instanceof Check) {
      return _code((Check)it);
    } else if (it instanceof EnterState) {
      return _code((EnterState)it);
    } else if (it instanceof Execution) {
      return _code((Execution)it);
    } else if (it instanceof ExitState) {
      return _code((ExitState)it);
    } else if (it instanceof HistoryEntry) {
      return _code((HistoryEntry)it);
    } else if (it instanceof If) {
      return _code((If)it);
    } else if (it instanceof SaveHistory) {
      return _code((SaveHistory)it);
    } else if (it instanceof ScheduleTimeEvent) {
      return _code((ScheduleTimeEvent)it);
    } else if (it instanceof Sequence) {
      return _code((Sequence)it);
    } else if (it instanceof StateSwitch) {
      return _code((StateSwitch)it);
    } else if (it instanceof Trace) {
      return _code((Trace)it);
    } else if (it instanceof UnscheduleTimeEvent) {
      return _code((UnscheduleTimeEvent)it);
    } else if (it != null) {
      return _code(it);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
}
