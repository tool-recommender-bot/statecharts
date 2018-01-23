package org.yakindu.sct.generator.pax;

import com.google.inject.Inject;
import org.eclipse.xtext.xbase.lib.Extension;
import org.yakindu.sct.generator.pax.PaxNavigation;
import org.yakindu.sct.model.sexec.ExecutionFlow;

@SuppressWarnings("all")
public class PaxNaming {
  @Inject
  @Extension
  private PaxNavigation _paxNavigation;
  
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
