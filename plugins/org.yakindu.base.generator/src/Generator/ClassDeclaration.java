/**
 */
package Generator;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Generator.ClassDeclaration#getParentClass <em>Parent Class</em>}</li>
 * </ul>
 *
 * @see Generator.GeneratorPackage#getClassDeclaration()
 * @model
 * @generated
 */
public interface ClassDeclaration extends EObject {
	/**
	 * Returns the value of the '<em><b>Parent Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Class</em>' reference.
	 * @see #setParentClass(Generator.Class)
	 * @see Generator.GeneratorPackage#getClassDeclaration_ParentClass()
	 * @model
	 * @generated
	 */
	Generator.Class getParentClass();

	/**
	 * Sets the value of the '{@link Generator.ClassDeclaration#getParentClass <em>Parent Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Class</em>' reference.
	 * @see #getParentClass()
	 * @generated
	 */
	void setParentClass(Generator.Class value);

} // ClassDeclaration
