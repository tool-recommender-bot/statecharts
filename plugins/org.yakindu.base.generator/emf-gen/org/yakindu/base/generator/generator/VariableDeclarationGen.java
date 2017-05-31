/**
 */
package org.yakindu.base.generator.generator;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Declaration Gen</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.base.generator.generator.VariableDeclarationGen#getVariableGen <em>Variable Gen</em>}</li>
 * </ul>
 *
 * @see org.yakindu.base.generator.generator.GeneratorPackage#getVariableDeclarationGen()
 * @model
 * @generated
 */
public interface VariableDeclarationGen extends EObject {
	/**
	 * Returns the value of the '<em><b>Variable Gen</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.yakindu.base.generator.generator.VariableGen#getDeclaration <em>Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable Gen</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable Gen</em>' container reference.
	 * @see #setVariableGen(VariableGen)
	 * @see org.yakindu.base.generator.generator.GeneratorPackage#getVariableDeclarationGen_VariableGen()
	 * @see org.yakindu.base.generator.generator.VariableGen#getDeclaration
	 * @model opposite="declaration" transient="false"
	 * @generated
	 */
	VariableGen getVariableGen();

	/**
	 * Sets the value of the '{@link org.yakindu.base.generator.generator.VariableDeclarationGen#getVariableGen <em>Variable Gen</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable Gen</em>' container reference.
	 * @see #getVariableGen()
	 * @generated
	 */
	void setVariableGen(VariableGen value);

} // VariableDeclarationGen
