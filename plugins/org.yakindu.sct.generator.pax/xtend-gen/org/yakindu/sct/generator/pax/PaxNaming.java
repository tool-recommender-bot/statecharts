package org.yakindu.sct.generator.pax;

import org.yakindu.sct.model.sexec.ExecutionFlow;

@SuppressWarnings("all")
public class PaxNaming {
  public String enumName(final ExecutionFlow it) {
    return "States";
  }
  
  public String application(final ExecutionFlow it) {
    return "application";
  }
  
  public String x(final String it) {
    return (it + ".x");
  }
}
