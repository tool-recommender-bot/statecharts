/**
 */
package org.yakindu.base.generator.generator;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.base.generator.generator.VariableDeclaration#getParentVariable <em>Parent Variable</em>}</li>
 * </ul>
 *
 * @see org.yakindu.base.generator.generator.generatorPackage#getVariableDeclaration()
 * @model abstract="true"
 * @generated
 */
public interface VariableDeclaration extends LineBasedCodeElement {
	/**
	 * Returns the value of the '<em><b>Parent Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Variable</em>' reference.
	 * @see #setParentVariable(Variable)
	 * @see org.yakindu.base.generator.generator.generatorPackage#getVariableDeclaration_ParentVariable()
	 * @model
	 * @generated
	 */
	Variable getParentVariable();

	/**
	 * Sets the value of the '{@link org.yakindu.base.generator.generator.VariableDeclaration#getParentVariable <em>Parent Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Variable</em>' reference.
	 * @see #getParentVariable()
	 * @generated
	 */
	void setParentVariable(Variable value);

} // VariableDeclaration
