/**
 */
package Generator;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Method Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Generator.MethodDeclaration#getParentMethod <em>Parent Method</em>}</li>
 * </ul>
 *
 * @see Generator.GeneratorPackage#getMethodDeclaration()
 * @model
 * @generated
 */
public interface MethodDeclaration extends LineBasedCodeElement {
	/**
	 * Returns the value of the '<em><b>Parent Method</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Method</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Method</em>' reference.
	 * @see #setParentMethod(Method)
	 * @see Generator.GeneratorPackage#getMethodDeclaration_ParentMethod()
	 * @model
	 * @generated
	 */
	Method getParentMethod();

	/**
	 * Sets the value of the '{@link Generator.MethodDeclaration#getParentMethod <em>Parent Method</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Method</em>' reference.
	 * @see #getParentMethod()
	 * @generated
	 */
	void setParentMethod(Method value);

} // MethodDeclaration
