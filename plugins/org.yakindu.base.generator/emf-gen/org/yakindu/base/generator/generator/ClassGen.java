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
 * </ul>
 *
 * @see org.yakindu.base.generator.generator.GeneratorPackage#getClassGen()
 * @model
 * @generated
 */
public interface ClassGen extends CodeElement, AccessRestricted {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model parametersMany="true"
	 * @generated
	 */
	void addConstructor(EList<ParameterGen> parameters);

} // ClassGen
