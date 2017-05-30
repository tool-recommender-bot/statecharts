/**
 */
package org.yakindu.base.generator.generator;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression Gen</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.base.generator.generator.ExpressionGen#getExpression <em>Expression</em>}</li>
 * </ul>
 *
 * @see org.yakindu.base.generator.generator.GeneratorPackage#getExpressionGen()
 * @model
 * @generated
 */
public interface ExpressionGen extends CodeElement {

	/**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference.
	 * @see #setExpression(org.yakindu.base.expressions.expressions.Expression)
	 * @see org.yakindu.base.generator.generator.GeneratorPackage#getExpressionGen_Expression()
	 * @model containment="true"
	 * @generated
	 */
	org.yakindu.base.expressions.expressions.Expression getExpression();

	/**
	 * Sets the value of the '{@link org.yakindu.base.generator.generator.ExpressionGen#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' containment reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(org.yakindu.base.expressions.expressions.Expression value);
} // ExpressionGen
