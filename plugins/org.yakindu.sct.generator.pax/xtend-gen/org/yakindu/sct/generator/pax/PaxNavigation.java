package org.yakindu.sct.generator.pax;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.yakindu.base.types.Declaration;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.TimeEvent;
import org.yakindu.sct.model.sexec.extensions.SExecExtensions;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.stext.stext.EventDefinition;
import org.yakindu.sct.model.stext.stext.InternalScope;
import org.yakindu.sct.model.stext.stext.OperationDefinition;

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
  
  public Iterable<EventDefinition> getAllEvents(final ExecutionFlow it) {
    final Function1<Scope, Iterable<EventDefinition>> _function = (Scope it_1) -> {
      return Iterables.<EventDefinition>filter(it_1.getDeclarations(), EventDefinition.class);
    };
    final Function2<Iterable<EventDefinition>, Iterable<EventDefinition>, Iterable<EventDefinition>> _function_1 = (Iterable<EventDefinition> i1, Iterable<EventDefinition> i2) -> {
      return Iterables.<EventDefinition>concat(i1, i2);
    };
    return IterableExtensions.<Iterable<EventDefinition>>reduce(ListExtensions.<Scope, Iterable<EventDefinition>>map(it.getScopes(), _function), _function_1);
  }
  
  public boolean hasValue(final EventDefinition it) {
    return ((!Objects.equal(it.getType(), null)) && (!Objects.equal(it.getType().getName(), "void")));
  }
  
  public ArrayList<OperationDefinition> operations(final ExecutionFlow it) {
    EList<Scope> _scopes = it.getScopes();
    ArrayList<OperationDefinition> _arrayList = new ArrayList<OperationDefinition>();
    final Function2<ArrayList<OperationDefinition>, Scope, ArrayList<OperationDefinition>> _function = (ArrayList<OperationDefinition> l, Scope s) -> {
      Iterables.<OperationDefinition>addAll(l, Iterables.<OperationDefinition>filter(s.getDeclarations(), OperationDefinition.class));
      return l;
    };
    return IterableExtensions.<Scope, ArrayList<OperationDefinition>>fold(_scopes, _arrayList, _function);
  }
  
  public Scope getTimeEventScope(final ExecutionFlow it) {
    final Function1<Scope, Boolean> _function = (Scope it_1) -> {
      int _size = IterableExtensions.size(Iterables.<TimeEvent>filter(it_1.getDeclarations(), TimeEvent.class));
      return Boolean.valueOf((_size > 0));
    };
    return IterableExtensions.<Scope>head(IterableExtensions.<Scope>filter(it.getScopes(), _function));
  }
  
  public boolean hasLocalScope(final ExecutionFlow it) {
    InternalScope _internalScope = this.getInternalScope(it);
    return (!Objects.equal(_internalScope, null));
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
