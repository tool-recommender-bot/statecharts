package org.yakindu.sct.generator.pax;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.yakindu.sct.model.sexec.ExecutionFlow;

@SuppressWarnings("all")
public class PaxNaming {
  @Accessors
  private String timeTrigger;
  
  public String enumName(final ExecutionFlow it) {
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
  
  @Pure
  public String getTimeTrigger() {
    return this.timeTrigger;
  }
  
  public void setTimeTrigger(final String timeTrigger) {
    this.timeTrigger = timeTrigger;
  }
}
