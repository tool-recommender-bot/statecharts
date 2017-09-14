/**
 */
package org.yakindu.base.expressions.expressions;

import org.yakindu.base.types.TypeSpecifier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>New Instance Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.base.expressions.expressions.NewInstanceExpression#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see org.yakindu.base.expressions.expressions.ExpressionsPackage#getNewInstanceExpression()
 * @model
 * @generated
 */
public interface NewInstanceExpression extends ElementReferenceExpression {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' containment reference.
	 * @see #setType(TypeSpecifier)
	 * @see org.yakindu.base.expressions.expressions.ExpressionsPackage#getNewInstanceExpression_Type()
	 * @model containment="true"
	 * @generated
	 */
	TypeSpecifier getType();

	/**
	 * Sets the value of the '{@link org.yakindu.base.expressions.expressions.NewInstanceExpression#getType <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' containment reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(TypeSpecifier value);

} // NewInstanceExpression
