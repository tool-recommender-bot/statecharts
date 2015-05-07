/**
 */
package org.yakindu.sct.model.stext.stext;

import org.yakindu.base.base.NamedElement;

import org.yakindu.base.types.Type;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Port Scope</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.sct.model.stext.stext.PortScope#getDirection <em>Direction</em>}</li>
 *   <li>{@link org.yakindu.sct.model.stext.stext.PortScope#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see org.yakindu.sct.model.stext.stext.StextPackage#getPortScope()
 * @model
 * @generated
 */
public interface PortScope extends StatechartScope, NamedElement {
	/**
	 * Returns the value of the '<em><b>Direction</b></em>' attribute.
	 * The literals are from the enumeration {@link org.yakindu.sct.model.stext.stext.PortDirection}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Direction</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Direction</em>' attribute.
	 * @see org.yakindu.sct.model.stext.stext.PortDirection
	 * @see #setDirection(PortDirection)
	 * @see org.yakindu.sct.model.stext.stext.StextPackage#getPortScope_Direction()
	 * @model
	 * @generated
	 */
	PortDirection getDirection();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.stext.stext.PortScope#getDirection <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Direction</em>' attribute.
	 * @see org.yakindu.sct.model.stext.stext.PortDirection
	 * @see #getDirection()
	 * @generated
	 */
	void setDirection(PortDirection value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(Type)
	 * @see org.yakindu.sct.model.stext.stext.StextPackage#getPortScope_Type()
	 * @model
	 * @generated
	 */
	Type getType();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.stext.stext.PortScope#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(Type value);

} // PortScope
