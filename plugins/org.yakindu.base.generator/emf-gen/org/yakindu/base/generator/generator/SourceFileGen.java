/**
 */
package org.yakindu.base.generator.generator;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Source File Gen</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.base.generator.generator.SourceFileGen#getPackage <em>Package</em>}</li>
 *   <li>{@link org.yakindu.base.generator.generator.SourceFileGen#getImports <em>Imports</em>}</li>
 * </ul>
 *
 * @see org.yakindu.base.generator.generator.GeneratorPackage#getSourceFileGen()
 * @model
 * @generated
 */
public interface SourceFileGen extends CodeElement {
	/**
	 * Returns the value of the '<em><b>Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Package</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Package</em>' attribute.
	 * @see #setPackage(String)
	 * @see org.yakindu.base.generator.generator.GeneratorPackage#getSourceFileGen_Package()
	 * @model
	 * @generated
	 */
	String getPackage();

	/**
	 * Sets the value of the '{@link org.yakindu.base.generator.generator.SourceFileGen#getPackage <em>Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Package</em>' attribute.
	 * @see #getPackage()
	 * @generated
	 */
	void setPackage(String value);

	/**
	 * Returns the value of the '<em><b>Imports</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imports</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imports</em>' attribute list.
	 * @see org.yakindu.base.generator.generator.GeneratorPackage#getSourceFileGen_Imports()
	 * @model
	 * @generated
	 */
	EList<String> getImports();

} // SourceFileGen
