/**
 */
package org.yakindu.base.generator.generator;

import org.eclipse.emf.common.util.EList;

import org.yakindu.base.types.Type;
import org.yakindu.base.types.TypeSpecifier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Method</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.base.generator.generator.Method#getArguments <em>Arguments</em>}</li>
 *   <li>{@link org.yakindu.base.generator.generator.Method#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see org.yakindu.base.generator.generator.generatorPackage#getMethod()
 * @model abstract="true"
 * @generated
 */
public interface Method extends BlockBasedCodeElement, ClassMember {
	/**
	 * Returns the value of the '<em><b>Arguments</b></em>' reference list.
	 * The list contents are of type {@link org.yakindu.base.types.TypeSpecifier}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arguments</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arguments</em>' reference list.
	 * @see org.yakindu.base.generator.generator.generatorPackage#getMethod_Arguments()
	 * @model
	 * @generated
	 */
	EList<TypeSpecifier> getArguments();

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
	 * @see org.yakindu.base.generator.generator.generatorPackage#getMethod_Type()
	 * @model
	 * @generated
	 */
	Type getType();

	/**
	 * Sets the value of the '{@link org.yakindu.base.generator.generator.Method#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(Type value);

} // Method
