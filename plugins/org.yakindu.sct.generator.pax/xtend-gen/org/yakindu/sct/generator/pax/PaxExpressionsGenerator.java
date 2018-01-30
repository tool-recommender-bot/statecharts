package org.yakindu.sct.generator.pax;

import java.util.Arrays;
import org.eclipse.emf.ecore.EObject;
import org.yakindu.base.expressions.expressions.AssignmentExpression;
import org.yakindu.base.expressions.expressions.BinaryExpression;
import org.yakindu.base.expressions.expressions.BinaryLiteral;
import org.yakindu.base.expressions.expressions.BoolLiteral;
import org.yakindu.base.expressions.expressions.ConditionalExpression;
import org.yakindu.base.expressions.expressions.DoubleLiteral;
import org.yakindu.base.expressions.expressions.ElementReferenceExpression;
import org.yakindu.base.expressions.expressions.FloatLiteral;
import org.yakindu.base.expressions.expressions.HexLiteral;
import org.yakindu.base.expressions.expressions.IntLiteral;
import org.yakindu.base.expressions.expressions.Literal;
import org.yakindu.base.expressions.expressions.NullLiteral;
import org.yakindu.base.expressions.expressions.ParenthesizedExpression;
import org.yakindu.base.expressions.expressions.PostFixUnaryExpression;
import org.yakindu.base.expressions.expressions.PrimitiveValueExpression;
import org.yakindu.base.expressions.expressions.StringLiteral;
import org.yakindu.base.expressions.expressions.TypeCastExpression;
import org.yakindu.base.expressions.expressions.UnaryExpression;
import org.yakindu.sct.generator.core.templates.ExpressionsGenerator;

@SuppressWarnings("all")
public class PaxExpressionsGenerator extends ExpressionsGenerator {
  protected CharSequence _code(final ElementReferenceExpression it) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field definition is undefined for the type ElementReferenceExpression"
      + "\nInvalid number of arguments. The method code(EObject) is not applicable for the arguments (ElementReferenceExpression,Object)");
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
}
