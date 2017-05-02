/**
 */
package org.yakindu.base.generator.generator;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.base.generator.generator.ClassDeclaration#getParentClass <em>Parent Class</em>}</li>
 * </ul>
 *
 * @see org.yakindu.base.generator.generator.generatorPackage#getClassDeclaration()
 * @model
 * @generated
 */
public interface ClassDeclaration extends EObject {
	/**
	 * Returns the value of the '<em><b>Parent Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Class</em>' reference.
	 * @see #setParentClass(org.yakindu.base.generator.generator.Class)
	 * @see org.yakindu.base.generator.generator.generatorPackage#getClassDeclaration_ParentClass()
	 * @model
	 * @generated
	 */
	org.yakindu.base.generator.generator.Class getParentClass();

	/**
	 * Sets the value of the '{@link org.yakindu.base.generator.generator.ClassDeclaration#getParentClass <em>Parent Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Class</em>' reference.
	 * @see #getParentClass()
	 * @generated
	 */
	void setParentClass(org.yakindu.base.generator.generator.Class value);

} // ClassDeclaration
