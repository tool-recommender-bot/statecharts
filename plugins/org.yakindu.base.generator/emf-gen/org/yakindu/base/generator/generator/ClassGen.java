/**
 */
package org.yakindu.base.generator.generator;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class Gen</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.base.generator.generator.ClassGen#getSuperClass <em>Super Class</em>}</li>
 *   <li>{@link org.yakindu.base.generator.generator.ClassGen#getImplements <em>Implements</em>}</li>
 *   <li>{@link org.yakindu.base.generator.generator.ClassGen#getDeclaration <em>Declaration</em>}</li>
 * </ul>
 *
 * @see org.yakindu.base.generator.generator.GeneratorPackage#getClassGen()
 * @model
 * @generated
 */
public interface ClassGen extends CodeElement, AccessRestricted, AbstractableElement {
	/**
	 * Returns the value of the '<em><b>Super Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super Class</em>' reference.
	 * @see #setSuperClass(ClassGen)
	 * @see org.yakindu.base.generator.generator.GeneratorPackage#getClassGen_SuperClass()
	 * @model
	 * @generated
	 */
	ClassGen getSuperClass();

	/**
	 * Sets the value of the '{@link org.yakindu.base.generator.generator.ClassGen#getSuperClass <em>Super Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Super Class</em>' reference.
	 * @see #getSuperClass()
	 * @generated
	 */
	void setSuperClass(ClassGen value);

	/**
	 * Returns the value of the '<em><b>Implements</b></em>' reference list.
	 * The list contents are of type {@link org.yakindu.base.generator.generator.InterfaceGen}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implements</em>' reference list.
	 * @see org.yakindu.base.generator.generator.GeneratorPackage#getClassGen_Implements()
	 * @model
	 * @generated
	 */
	EList<InterfaceGen> getImplements();

	/**
	 * Returns the value of the '<em><b>Declaration</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.yakindu.base.generator.generator.ClassDeclarationGen#getClassGen <em>Class Gen</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Declaration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Declaration</em>' containment reference.
	 * @see #setDeclaration(ClassDeclarationGen)
	 * @see org.yakindu.base.generator.generator.GeneratorPackage#getClassGen_Declaration()
	 * @see org.yakindu.base.generator.generator.ClassDeclarationGen#getClassGen
	 * @model opposite="classGen" containment="true"
	 * @generated
	 */
	ClassDeclarationGen getDeclaration();

	/**
	 * Sets the value of the '{@link org.yakindu.base.generator.generator.ClassGen#getDeclaration <em>Declaration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Declaration</em>' containment reference.
	 * @see #getDeclaration()
	 * @generated
	 */
	void setDeclaration(ClassDeclarationGen value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model parametersMany="true"
	 * @generated
	 */
	void addConstructor(EList<ParameterGen> parameters);

} // ClassGen
