package org.yakindu.sct.generator.pax;

import java.util.Arrays;
import org.eclipse.emf.ecore.EObject;
import org.yakindu.base.types.Declaration;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.extensions.SExecExtensions;
import org.yakindu.sct.model.sgraph.Scope;

@SuppressWarnings("all")
public class PaxNavigation extends SExecExtensions {
  protected ExecutionFlow _flow(final Scope scope) {
    ExecutionFlow _xifexpression = null;
    EObject _eContainer = scope.eContainer();
    if ((_eContainer instanceof ExecutionFlow)) {
      EObject _eContainer_1 = scope.eContainer();
      _xifexpression = ((ExecutionFlow) _eContainer_1);
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }
  
  protected ExecutionFlow _flow(final Declaration it) {
    Scope _scope = this.scope(it);
    ExecutionFlow _flow = null;
    if (_scope!=null) {
      _flow=this.flow(_scope);
    }
    return _flow;
  }
  
  protected ExecutionFlow _flow(final EObject it) {
    return this.flow(it.eContainer());
  }
  
  protected ExecutionFlow _flow(final ExecutionFlow it) {
    return it;
  }
  
  public Scope scope(final Declaration it) {
    Scope _xifexpression = null;
    EObject _eContainer = it.eContainer();
    if ((_eContainer instanceof Scope)) {
      EObject _eContainer_1 = it.eContainer();
      _xifexpression = ((Scope) _eContainer_1);
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }
  
  public ExecutionFlow flow(final EObject it) {
    if (it instanceof Declaration) {
      return _flow((Declaration)it);
    } else if (it instanceof ExecutionFlow) {
      return _flow((ExecutionFlow)it);
    } else if (it instanceof Scope) {
      return _flow((Scope)it);
    } else if (it != null) {
      return _flow(it);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
}
