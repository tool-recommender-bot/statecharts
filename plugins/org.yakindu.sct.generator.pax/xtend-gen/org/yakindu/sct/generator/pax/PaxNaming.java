package org.yakindu.sct.generator.pax;

import com.google.inject.Inject;
import java.util.Arrays;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.yakindu.base.types.Enumerator;
import org.yakindu.base.types.Event;
import org.yakindu.base.types.Operation;
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess;
import org.yakindu.sct.generator.pax.PaxNavigation;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.naming.INamingService;
import org.yakindu.sct.model.sgen.GeneratorEntry;
import org.yakindu.sct.model.stext.naming.StextNameProvider;
import org.yakindu.sct.model.stext.stext.VariableDefinition;

@SuppressWarnings("all")
public class PaxNaming {
  @Accessors
  private String timeTrigger;
  
  @Inject
  @Extension
  private PaxNavigation _paxNavigation;
  
  @Inject
  @Extension
  private ICodegenTypeSystemAccess _iCodegenTypeSystemAccess;
  
  @Inject
  private StextNameProvider provider;
  
  @Inject
  @Extension
  private INamingService _iNamingService;
  
  @Inject
  private GeneratorEntry entry;
  
  public String enumName() {
    return "States";
  }
  
  public String application(final ExecutionFlow it) {
    return "application";
  }
  
  public String x(final String it) {
    return (it + ".x");
  }
  
  public String functionPrefix() {
    return "function";
  }
  
  public String variablePrefix() {
    return "var";
  }
  
  public String initAndEnterFunctionName() {
    return "initAndEnterFunction";
  }
  
  public String runCycleFunctionName() {
    return "runCycle";
  }
  
  public String every() {
    return "every";
  }
  
  public String isStateActiveFctID(final ExecutionFlow it) {
    String _functionPrefix = this.functionPrefix();
    return (_functionPrefix + "isStateActive");
  }
  
  public String statechartVariablesName() {
    return "variables";
  }
  
  public String statechartVariables() {
    String _firstUpper = StringExtensions.toFirstUpper(this.statechartVariablesName());
    return ("statechart" + _firstUpper);
  }
  
  public String initializedVariable() {
    return "initialized";
  }
  
  public String activeState() {
    return "activeState";
  }
  
  public String separator() {
    return "_";
  }
  
  public String value(final CharSequence it) {
    String _separator = this.separator();
    String _plus = (it + _separator);
    return (_plus + "value");
  }
  
  protected CharSequence _access(final VariableDefinition it) {
    StringConcatenation _builder = new StringConcatenation();
    String _asEscapedIdentifier = this._iNamingService.asEscapedIdentifier(it.getName());
    _builder.append(_asEscapedIdentifier);
    return _builder;
  }
  
  protected CharSequence _access(final Operation it) {
    StringConcatenation _builder = new StringConcatenation();
    String _asEscapedIdentifier = this._iNamingService.asEscapedIdentifier(it.getName());
    _builder.append(_asEscapedIdentifier);
    return _builder;
  }
  
  protected CharSequence _access(final Enumerator it) {
    StringConcatenation _builder = new StringConcatenation();
    String _asEscapedIdentifier = this._iNamingService.asEscapedIdentifier(it.getName());
    _builder.append(_asEscapedIdentifier);
    return _builder;
  }
  
  protected CharSequence _access(final Event it) {
    StringConcatenation _builder = new StringConcatenation();
    String _asIdentifier = this._iNamingService.asIdentifier(it.getName());
    _builder.append(_asIdentifier);
    return _builder;
  }
  
  protected CharSequence _access(final EObject it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("#error cannot access elements of type ");
    String _name = it.getClass().getName();
    _builder.append(_name);
    return _builder;
  }
  
  public CharSequence valueAccess(final Event it) {
    StringConcatenation _builder = new StringConcatenation();
    String _value = this.value(this._iNamingService.asIdentifier(it.getName()));
    _builder.append(_value);
    return _builder;
  }
  
  public CharSequence access(final EObject it) {
    if (it instanceof VariableDefinition) {
      return _access((VariableDefinition)it);
    } else if (it instanceof Enumerator) {
      return _access((Enumerator)it);
    } else if (it instanceof Event) {
      return _access((Event)it);
    } else if (it instanceof Operation) {
      return _access((Operation)it);
    } else if (it != null) {
      return _access(it);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
  
  @Pure
  public String getTimeTrigger() {
    return this.timeTrigger;
  }
  
  public void setTimeTrigger(final String timeTrigger) {
    this.timeTrigger = timeTrigger;
  }
}
