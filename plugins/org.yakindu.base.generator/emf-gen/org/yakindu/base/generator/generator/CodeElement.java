/**
 */
package org.yakindu.base.generator.generator;

import org.eclipse.emf.common.util.EList;

import org.yakindu.base.base.DocumentedElement;
import org.yakindu.base.base.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Code Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.base.generator.generator.CodeElement#getChildren <em>Children</em>}</li>
 *   <li>{@link org.yakindu.base.generator.generator.CodeElement#getParent <em>Parent</em>}</li>
 * </ul>
 *
 * @see org.yakindu.base.generator.generator.GeneratorPackage#getCodeElement()
 * @model
 * @generated
 */
public interface CodeElement extends NamedElement, DocumentedElement {
	/**
	 * Returns the value of the '<em><b>Children</b></em>' reference list.
	 * The list contents are of type {@link org.yakindu.base.generator.generator.CodeElement}.
	 * It is bidirectional and its opposite is '{@link org.yakindu.base.generator.generator.CodeElement#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' reference list.
	 * @see org.yakindu.base.generator.generator.GeneratorPackage#getCodeElement_Children()
	 * @see org.yakindu.base.generator.generator.CodeElement#getParent
	 * @model opposite="parent"
	 * @generated
	 */
	EList<CodeElement> getChildren();

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.yakindu.base.generator.generator.CodeElement#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' reference.
	 * @see #setParent(CodeElement)
	 * @see org.yakindu.base.generator.generator.GeneratorPackage#getCodeElement_Parent()
	 * @see org.yakindu.base.generator.generator.CodeElement#getChildren
	 * @model opposite="children"
	 * @generated
	 */
	CodeElement getParent();

	/**
	 * Sets the value of the '{@link org.yakindu.base.generator.generator.CodeElement#getParent <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(CodeElement value);

} // CodeElement
