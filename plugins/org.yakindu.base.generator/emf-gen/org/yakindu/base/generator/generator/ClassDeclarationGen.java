/**
 */
package org.yakindu.base.generator.generator;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class Declaration Gen</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.base.generator.generator.ClassDeclarationGen#getClassGen <em>Class Gen</em>}</li>
 * </ul>
 *
 * @see org.yakindu.base.generator.generator.GeneratorPackage#getClassDeclarationGen()
 * @model
 * @generated
 */
public interface ClassDeclarationGen extends Declaration {
	/**
	 * Returns the value of the '<em><b>Class Gen</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.yakindu.base.generator.generator.ClassGen#getDeclaration <em>Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class Gen</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class Gen</em>' reference.
	 * @see #setClassGen(ClassGen)
	 * @see org.yakindu.base.generator.generator.GeneratorPackage#getClassDeclarationGen_ClassGen()
	 * @see org.yakindu.base.generator.generator.ClassGen#getDeclaration
	 * @model opposite="declaration"
	 * @generated
	 */
	ClassGen getClassGen();

	/**
	 * Sets the value of the '{@link org.yakindu.base.generator.generator.ClassDeclarationGen#getClassGen <em>Class Gen</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class Gen</em>' reference.
	 * @see #getClassGen()
	 * @generated
	 */
	void setClassGen(ClassGen value);

} // ClassDeclarationGen
