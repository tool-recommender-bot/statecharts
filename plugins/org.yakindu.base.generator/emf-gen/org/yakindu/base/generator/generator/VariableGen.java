/**
 */
package org.yakindu.base.generator.generator;

import org.yakindu.base.types.TypedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Gen</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.base.generator.generator.VariableGen#getDeclaration <em>Declaration</em>}</li>
 * </ul>
 *
 * @see org.yakindu.base.generator.generator.GeneratorPackage#getVariableGen()
 * @model
 * @generated
 */
public interface VariableGen extends CodeElement, AccessRestricted, TypedElement, Declarable {

	/**
	 * Returns the value of the '<em><b>Declaration</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.yakindu.base.generator.generator.VariableDeclarationGen#getVariableGen <em>Variable Gen</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Declaration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Declaration</em>' containment reference.
	 * @see #setDeclaration(VariableDeclarationGen)
	 * @see org.yakindu.base.generator.generator.GeneratorPackage#getVariableGen_Declaration()
	 * @see org.yakindu.base.generator.generator.VariableDeclarationGen#getVariableGen
	 * @model opposite="variableGen" containment="true"
	 * @generated
	 */
	VariableDeclarationGen getDeclaration();

	/**
	 * Sets the value of the '{@link org.yakindu.base.generator.generator.VariableGen#getDeclaration <em>Declaration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Declaration</em>' containment reference.
	 * @see #getDeclaration()
	 * @generated
	 */
	void setDeclaration(VariableDeclarationGen value);
} // VariableGen
