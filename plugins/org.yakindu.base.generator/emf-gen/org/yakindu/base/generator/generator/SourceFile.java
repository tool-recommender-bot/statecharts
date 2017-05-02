/**
 */
package org.yakindu.base.generator.generator;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Source File</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.base.generator.generator.SourceFile#getImports <em>Imports</em>}</li>
 *   <li>{@link org.yakindu.base.generator.generator.SourceFile#getFile <em>File</em>}</li>
 * </ul>
 *
 * @see org.yakindu.base.generator.generator.generatorPackage#getSourceFile()
 * @model
 * @generated
 */
public interface SourceFile extends CodeElement {
	/**
	 * Returns the value of the '<em><b>Imports</b></em>' reference list.
	 * The list contents are of type {@link org.yakindu.base.generator.generator.SourceFile}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imports</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imports</em>' reference list.
	 * @see org.yakindu.base.generator.generator.generatorPackage#getSourceFile_Imports()
	 * @model
	 * @generated
	 */
	EList<SourceFile> getImports();

	/**
	 * Returns the value of the '<em><b>File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File</em>' attribute.
	 * @see #setFile(String)
	 * @see org.yakindu.base.generator.generator.generatorPackage#getSourceFile_File()
	 * @model
	 * @generated
	 */
	String getFile();

	/**
	 * Sets the value of the '{@link org.yakindu.base.generator.generator.SourceFile#getFile <em>File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File</em>' attribute.
	 * @see #getFile()
	 * @generated
	 */
	void setFile(String value);

} // SourceFile
