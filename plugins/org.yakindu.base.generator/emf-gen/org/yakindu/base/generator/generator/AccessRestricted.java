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
	 * Returns the value of the '<em><b>Visibility</b></em>' attribute.
	 * The default value is <code>"NONE"</code>.
	 * The literals are from the enumeration {@link org.yakindu.base.generator.generator.VisibilityValues}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Visibility</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visibility</em>' attribute.
	 * @see org.yakindu.base.generator.generator.VisibilityValues
	 * @see #setVisibility(VisibilityValues)
	 * @see org.yakindu.base.generator.generator.GeneratorPackage#getAccessRestricted_Visibility()
	 * @model default="NONE"
	 * @generated
	 */
	VisibilityValues getVisibility();

	/**
	 * Sets the value of the '{@link org.yakindu.base.generator.generator.AccessRestricted#getVisibility <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visibility</em>' attribute.
	 * @see org.yakindu.base.generator.generator.VisibilityValues
	 * @see #getVisibility()
	 * @generated
	 */
	void setVisibility(VisibilityValues value);
} // AccessRestricted
