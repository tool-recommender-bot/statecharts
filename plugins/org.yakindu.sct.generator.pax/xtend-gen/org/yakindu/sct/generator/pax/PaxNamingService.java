package org.yakindu.sct.generator.pax;

import java.util.Map;
import org.yakindu.base.base.NamedElement;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.naming.INamingService;
import org.yakindu.sct.model.sgraph.Statechart;

@SuppressWarnings("all")
public class PaxNamingService implements INamingService {
  @Override
  public String asEscapedIdentifier(final String string) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public String asIdentifier(final String string) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public int getMaxLength() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public char getSeparator() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public String getShortName(final NamedElement element) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public Map<NamedElement, String> getShortNameMap(final Statechart statechart) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public Map<NamedElement, String> getShortNameMap(final ExecutionFlow flow) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public void initializeNamingService(final Statechart statechart) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public void initializeNamingService(final ExecutionFlow flow) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public boolean isKeyword(final String string) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public void setMaxLength(final int length) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public void setSeparator(final char sep) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
}
