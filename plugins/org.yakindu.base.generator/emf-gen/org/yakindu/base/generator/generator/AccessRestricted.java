/**
 */
package org.yakindu.base.generator.generator;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Access Restricted</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.base.generator.generator.AccessRestricted#getVisibility <em>Visibility</em>}</li>
 * </ul>
 *
 * @see org.yakindu.base.generator.generator.GeneratorPackage#getAccessRestricted()
 * @model
 * @generated
 */
public interface AccessRestricted extends EObject {

	/**
	 * Returns the value of the '<em><b>Visibility</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Visibility</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visibility</em>' reference.
	 * @see #setVisibility(Visibility)
	 * @see org.yakindu.base.generator.generator.GeneratorPackage#getAccessRestricted_Visibility()
	 * @model
	 * @generated
	 */
	Visibility getVisibility();

	/**
	 * Sets the value of the '{@link org.yakindu.base.generator.generator.AccessRestricted#getVisibility <em>Visibility</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visibility</em>' reference.
	 * @see #getVisibility()
	 * @generated
	 */
	void setVisibility(Visibility value);
} // AccessRestricted
