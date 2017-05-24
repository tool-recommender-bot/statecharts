/**
 */
package org.yakindu.base.generator.generator;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Method Declaration Gen</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.base.generator.generator.MethodDeclarationGen#getMethodGen <em>Method Gen</em>}</li>
 * </ul>
 *
 * @see org.yakindu.base.generator.generator.GeneratorPackage#getMethodDeclarationGen()
 * @model
 * @generated
 */
public interface MethodDeclarationGen extends EObject {
	/**
	 * Returns the value of the '<em><b>Method Gen</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.yakindu.base.generator.generator.MethodGen#getDeclaration <em>Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Method Gen</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Method Gen</em>' container reference.
	 * @see #setMethodGen(MethodGen)
	 * @see org.yakindu.base.generator.generator.GeneratorPackage#getMethodDeclarationGen_MethodGen()
	 * @see org.yakindu.base.generator.generator.MethodGen#getDeclaration
	 * @model opposite="declaration" transient="false"
	 * @generated
	 */
	MethodGen getMethodGen();

	/**
	 * Sets the value of the '{@link org.yakindu.base.generator.generator.MethodDeclarationGen#getMethodGen <em>Method Gen</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Method Gen</em>' container reference.
	 * @see #getMethodGen()
	 * @generated
	 */
	void setMethodGen(MethodGen value);

} // MethodDeclarationGen
