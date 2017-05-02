/**
 */
package Generator;

import org.yakindu.base.expressions.expressions.Expression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Code Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Generator.CodeExpression#getExp <em>Exp</em>}</li>
 * </ul>
 *
 * @see Generator.GeneratorPackage#getCodeExpression()
 * @model
 * @generated
 */
public interface CodeExpression extends LineBasedCodeElement {
	/**
	 * Returns the value of the '<em><b>Exp</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exp</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exp</em>' reference.
	 * @see #setExp(Expression)
	 * @see Generator.GeneratorPackage#getCodeExpression_Exp()
	 * @model
	 * @generated
	 */
	Expression getExp();

	/**
	 * Sets the value of the '{@link Generator.CodeExpression#getExp <em>Exp</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exp</em>' reference.
	 * @see #getExp()
	 * @generated
	 */
	void setExp(Expression value);

} // CodeExpression
