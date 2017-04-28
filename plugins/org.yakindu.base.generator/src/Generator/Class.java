/**
 */
package Generator;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Generator.Class#getClassName <em>Class Name</em>}</li>
 *   <li>{@link Generator.Class#getClassMembers <em>Class Members</em>}</li>
 * </ul>
 *
 * @see Generator.GeneratorPackage#getClass_()
 * @model abstract="true"
 * @generated
 */
public interface Class extends BlockBasedCodeElement, VisibilityOwner {

	/**
	 * Returns the value of the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class Name</em>' attribute.
	 * @see #setClassName(String)
	 * @see Generator.GeneratorPackage#getClass_ClassName()
	 * @model
	 * @generated
	 */
	String getClassName();

	/**
	 * Sets the value of the '{@link Generator.Class#getClassName <em>Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class Name</em>' attribute.
	 * @see #getClassName()
	 * @generated
	 */
	void setClassName(String value);

	/**
	 * Returns the value of the '<em><b>Class Members</b></em>' reference list.
	 * The list contents are of type {@link Generator.ClassMember}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class Members</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class Members</em>' reference list.
	 * @see Generator.GeneratorPackage#getClass_ClassMembers()
	 * @model
	 * @generated
	 */
	EList<ClassMember> getClassMembers();
} // Class
