package org.yakindu.sct.generator.pax;

import com.google.inject.Inject;
import java.util.Arrays;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.yakindu.base.expressions.expressions.AssignmentExpression;
import org.yakindu.base.expressions.expressions.BinaryExpression;
import org.yakindu.base.expressions.expressions.BinaryLiteral;
import org.yakindu.base.expressions.expressions.BoolLiteral;
import org.yakindu.base.expressions.expressions.ConditionalExpression;
import org.yakindu.base.expressions.expressions.DoubleLiteral;
import org.yakindu.base.expressions.expressions.ElementReferenceExpression;
import org.yakindu.base.expressions.expressions.Expression;
import org.yakindu.base.expressions.expressions.FloatLiteral;
import org.yakindu.base.expressions.expressions.HexLiteral;
import org.yakindu.base.expressions.expressions.IntLiteral;
import org.yakindu.base.expressions.expressions.Literal;
import org.yakindu.base.expressions.expressions.LogicalAndExpression;
import org.yakindu.base.expressions.expressions.LogicalNotExpression;
import org.yakindu.base.expressions.expressions.LogicalOrExpression;
import org.yakindu.base.expressions.expressions.LogicalRelationExpression;
import org.yakindu.base.expressions.expressions.NullLiteral;
import org.yakindu.base.expressions.expressions.ParenthesizedExpression;
import org.yakindu.base.expressions.expressions.PostFixUnaryExpression;
import org.yakindu.base.expressions.expressions.PrimitiveValueExpression;
import org.yakindu.base.expressions.expressions.StringLiteral;
import org.yakindu.base.expressions.expressions.TypeCastExpression;
import org.yakindu.base.expressions.expressions.UnaryExpression;
import org.yakindu.base.types.Declaration;
import org.yakindu.base.types.Event;
import org.yakindu.base.types.inferrer.ITypeSystemInferrer;
import org.yakindu.base.types.typesystem.ITypeSystem;
import org.yakindu.sct.generator.core.templates.ExpressionsGenerator;
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess;
import org.yakindu.sct.generator.pax.PaxNaming;
import org.yakindu.sct.generator.pax.PaxNamingService;
import org.yakindu.sct.generator.pax.PaxNavigation;
import org.yakindu.sct.model.stext.stext.VariableDefinition;

@SuppressWarnings("all")
public class PaxExpressionsGenerator extends ExpressionsGenerator {
  @Inject
  @Extension
  private ICodegenTypeSystemAccess _iCodegenTypeSystemAccess;
  
  @Inject
  @Extension
  private PaxNaming _paxNaming;
  
  @Inject
  @Extension
  private PaxNavigation _paxNavigation;
  
  @Inject
  @Extension
  private ITypeSystem _iTypeSystem;
  
  @Inject
  @Extension
  private ITypeSystemInferrer _iTypeSystemInferrer;
  
  @Inject
  @Extension
  private PaxNamingService _paxNamingService;
  
  @Override
  protected CharSequence _code(final EObject it) {
    String _name = it.getClass().getName();
    String _plus = ("No dispatch function for " + _name);
    throw new IllegalStateException(_plus);
  }
  
  /**
   * Expressions
   */
  @Override
  protected CharSequence _code(final BinaryExpression it) {
    String _trim = this.code(it.getLeftOperand()).toString().trim();
    String _plus = (_trim + " ");
    String _trim_1 = it.getOperator().getLiteral().toString().trim();
    String _plus_1 = (_plus + _trim_1);
    String _plus_2 = (_plus_1 + " ");
    CharSequence _code = this.code(it.getRightOperand());
    return (_plus_2 + _code);
  }
  
  @Override
  protected CharSequence _code(final UnaryExpression it) {
    String _literal = it.getOperator().getLiteral();
    CharSequence _code = this.code(it.getOperand());
    return (_literal + _code);
  }
  
  @Override
  protected CharSequence _code(final PostFixUnaryExpression it) {
    CharSequence _code = this.code(it.getOperand());
    String _literal = it.getOperator().getLiteral();
    return (_code + _literal);
  }
  
  @Override
  protected CharSequence _code(final AssignmentExpression it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _code = this.code(it.getVarRef());
    _builder.append(_code);
    _builder.append(" ");
    String _literal = it.getOperator().getLiteral();
    _builder.append(_literal);
    _builder.append(" ");
    CharSequence _code_1 = this.code(it.getExpression());
    _builder.append(_code_1);
    return _builder;
  }
  
  @Override
  protected CharSequence _code(final ConditionalExpression it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _code = this.code(it.getCondition());
    _builder.append(_code);
    _builder.append(" ? ");
    CharSequence _code_1 = this.code(it.getTrueCase());
    _builder.append(_code_1);
    _builder.append(" : ");
    CharSequence _code_2 = this.code(it.getFalseCase());
    _builder.append(_code_2);
    return _builder;
  }
  
  @Override
  protected CharSequence _code(final PrimitiveValueExpression it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _code = this.code(it.getValue());
    _builder.append(_code);
    return _builder;
  }
  
  @Override
  protected CharSequence _code(final ParenthesizedExpression it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(");
    CharSequence _code = this.code(it.getExpression());
    _builder.append(_code);
    _builder.append(")");
    return _builder;
  }
  
  @Override
  protected CharSequence _code(final TypeCastExpression it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("((");
    String _targetLanguageName = this._iCodegenTypeSystemAccess.getTargetLanguageName(it.getType());
    _builder.append(_targetLanguageName);
    _builder.append(") ");
    CharSequence _code = this.code(it.getOperand());
    _builder.append(_code);
    _builder.append(")");
    return _builder;
  }
  
  /**
   * Literals
   */
  @Override
  protected CharSequence _code(final Literal it) {
    String _name = it.getClass().getName();
    String _plus = ("No dispatch function for " + _name);
    throw new IllegalStateException(_plus);
  }
  
  @Override
  protected CharSequence _code(final StringLiteral it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\"");
    String _escaped = this.escaped(it.getValue());
    _builder.append(_escaped);
    _builder.append("\"");
    return _builder;
  }
  
  @Override
  protected String escaped(final String it) {
    return it.replace("\"", "\\\"");
  }
  
  @Override
  protected CharSequence _code(final IntLiteral it) {
    StringConcatenation _builder = new StringConcatenation();
    String _string = Integer.valueOf(it.getValue()).toString();
    _builder.append(_string);
    return _builder;
  }
  
  @Override
  protected CharSequence _code(final DoubleLiteral it) {
    StringConcatenation _builder = new StringConcatenation();
    String _string = Double.valueOf(it.getValue()).toString();
    _builder.append(_string);
    return _builder;
  }
  
  @Override
  protected CharSequence _code(final FloatLiteral it) {
    StringConcatenation _builder = new StringConcatenation();
    String _string = Float.valueOf(it.getValue()).toString();
    _builder.append(_string);
    return _builder;
  }
  
  @Override
  protected CharSequence _code(final HexLiteral it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("0x");
    String _hexString = Integer.toHexString(it.getValue());
    _builder.append(_hexString);
    return _builder;
  }
  
  @Override
  protected CharSequence _code(final BinaryLiteral it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("0b");
    String _binaryString = Integer.toBinaryString(it.getValue());
    _builder.append(_binaryString);
    return _builder;
  }
  
  @Override
  protected CharSequence _code(final BoolLiteral it) {
    StringConcatenation _builder = new StringConcatenation();
    String _string = Boolean.valueOf(it.isValue()).toString();
    _builder.append(_string);
    return _builder;
  }
  
  @Override
  protected CharSequence _code(final NullLiteral expression) {
    return "null";
  }
  
  protected CharSequence _code(final ElementReferenceExpression it) {
    return this.code(it, this._paxNavigation.definition(it));
  }
  
  protected CharSequence _code(final Expression it, final Event target) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _access = this._paxNaming.access(target);
    _builder.append(_access);
    return _builder;
  }
  
  protected CharSequence _code(final Expression it, final VariableDefinition target) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _access = this._paxNaming.access(target);
    _builder.append(_access);
    return _builder;
  }
  
  protected CharSequence _sc_boolean_code(final Expression it) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _code = this.code(it);
    _builder.append(_code);
    return _builder;
  }
  
  protected CharSequence _sc_boolean_code(final LogicalOrExpression it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(");
    CharSequence _code = this.code(it);
    _builder.append(_code);
    _builder.append(") ? true : false;");
    return _builder;
  }
  
  protected CharSequence _sc_boolean_code(final LogicalAndExpression it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(");
    CharSequence _code = this.code(it);
    _builder.append(_code);
    _builder.append(") ? true : false;");
    return _builder;
  }
  
  protected CharSequence _sc_boolean_code(final LogicalNotExpression it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(");
    CharSequence _code = this.code(it);
    _builder.append(_code);
    _builder.append(") ? true : false;");
    return _builder;
  }
  
  protected CharSequence _sc_boolean_code(final LogicalRelationExpression it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("(");
    CharSequence _code = this.code(it);
    _builder.append(_code);
    _builder.append(") ? true : false;");
    return _builder;
  }
  
  public CharSequence code(final EObject it) {
    if (it instanceof BinaryLiteral) {
      return _code((BinaryLiteral)it);
    } else if (it instanceof ElementReferenceExpression) {
      return _code((ElementReferenceExpression)it);
    } else if (it instanceof HexLiteral) {
      return _code((HexLiteral)it);
    } else if (it instanceof PostFixUnaryExpression) {
      return _code((PostFixUnaryExpression)it);
    } else if (it instanceof AssignmentExpression) {
      return _code((AssignmentExpression)it);
    } else if (it instanceof BinaryExpression) {
      return _code((BinaryExpression)it);
    } else if (it instanceof BoolLiteral) {
      return _code((BoolLiteral)it);
    } else if (it instanceof ConditionalExpression) {
      return _code((ConditionalExpression)it);
    } else if (it instanceof DoubleLiteral) {
      return _code((DoubleLiteral)it);
    } else if (it instanceof FloatLiteral) {
      return _code((FloatLiteral)it);
    } else if (it instanceof IntLiteral) {
      return _code((IntLiteral)it);
    } else if (it instanceof NullLiteral) {
      return _code((NullLiteral)it);
    } else if (it instanceof ParenthesizedExpression) {
      return _code((ParenthesizedExpression)it);
    } else if (it instanceof PrimitiveValueExpression) {
      return _code((PrimitiveValueExpression)it);
    } else if (it instanceof StringLiteral) {
      return _code((StringLiteral)it);
    } else if (it instanceof TypeCastExpression) {
      return _code((TypeCastExpression)it);
    } else if (it instanceof UnaryExpression) {
      return _code((UnaryExpression)it);
    } else if (it instanceof Literal) {
      return _code((Literal)it);
    } else if (it != null) {
      return _code(it);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
  
  public CharSequence code(final Expression it, final Declaration target) {
    if (target instanceof VariableDefinition) {
      return _code(it, (VariableDefinition)target);
    } else if (target instanceof Event) {
      return _code(it, (Event)target);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, target).toString());
    }
  }
  
  public CharSequence sc_boolean_code(final Expression it) {
    if (it instanceof LogicalAndExpression) {
      return _sc_boolean_code((LogicalAndExpression)it);
    } else if (it instanceof LogicalNotExpression) {
      return _sc_boolean_code((LogicalNotExpression)it);
    } else if (it instanceof LogicalOrExpression) {
      return _sc_boolean_code((LogicalOrExpression)it);
    } else if (it instanceof LogicalRelationExpression) {
      return _sc_boolean_code((LogicalRelationExpression)it);
    } else if (it != null) {
      return _sc_boolean_code(it);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
}
