/**
 */
package org.yakindu.base.generator.generator;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Visibility</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.base.generator.generator.Visibility#getVisibility <em>Visibility</em>}</li>
 * </ul>
 *
 * @see org.yakindu.base.generator.generator.GeneratorPackage#getVisibility()
 * @model abstract="true"
 * @generated
 */
public interface Visibility extends EObject {

	/**
	 * Returns the value of the '<em><b>Visibility</b></em>' attribute.
	 * The literals are from the enumeration {@link org.yakindu.base.generator.generator.VisbilityValues}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Visibility</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visibility</em>' attribute.
	 * @see org.yakindu.base.generator.generator.VisbilityValues
	 * @see #setVisibility(VisbilityValues)
	 * @see org.yakindu.base.generator.generator.GeneratorPackage#getVisibility_Visibility()
	 * @model
	 * @generated
	 */
	VisbilityValues getVisibility();

	/**
	 * Sets the value of the '{@link org.yakindu.base.generator.generator.Visibility#getVisibility <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visibility</em>' attribute.
	 * @see org.yakindu.base.generator.generator.VisbilityValues
	 * @see #getVisibility()
	 * @generated
	 */
	void setVisibility(VisbilityValues value);
} // Visibility
