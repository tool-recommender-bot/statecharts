/**
 */
package org.yakindu.base.generator.generator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.yakindu.base.base.BasePackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.yakindu.base.generator.generator.GeneratorFactory
 * @model kind="package"
 * @generated
 */
public interface GeneratorPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "generator";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.yakindu.org/base/generator/Generator";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "generator";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GeneratorPackage eINSTANCE = org.yakindu.base.generator.generator.impl.GeneratorPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.yakindu.base.generator.generator.impl.CodeElementImpl <em>Code Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.base.generator.generator.impl.CodeElementImpl
	 * @see org.yakindu.base.generator.generator.impl.GeneratorPackageImpl#getCodeElement()
	 * @generated
	 */
	int CODE_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_ELEMENT__NAME = BasePackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_ELEMENT__DOCUMENTATION = BasePackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_ELEMENT__CHILDREN = BasePackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_ELEMENT__PARENT = BasePackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Code Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_ELEMENT_FEATURE_COUNT = BasePackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.yakindu.base.generator.generator.impl.SourceFileGenImpl <em>Source File Gen</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.base.generator.generator.impl.SourceFileGenImpl
	 * @see org.yakindu.base.generator.generator.impl.GeneratorPackageImpl#getSourceFileGen()
	 * @generated
	 */
	int SOURCE_FILE_GEN = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_FILE_GEN__NAME = CODE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_FILE_GEN__DOCUMENTATION = CODE_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_FILE_GEN__CHILDREN = CODE_ELEMENT__CHILDREN;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_FILE_GEN__PARENT = CODE_ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_FILE_GEN__PACKAGE = CODE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_FILE_GEN__IMPORTS = CODE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Source File Gen</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_FILE_GEN_FEATURE_COUNT = CODE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.yakindu.base.generator.generator.impl.ClassGenImpl <em>Class Gen</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.base.generator.generator.impl.ClassGenImpl
	 * @see org.yakindu.base.generator.generator.impl.GeneratorPackageImpl#getClassGen()
	 * @generated
	 */
	int CLASS_GEN = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_GEN__NAME = CODE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_GEN__DOCUMENTATION = CODE_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_GEN__CHILDREN = CODE_ELEMENT__CHILDREN;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_GEN__PARENT = CODE_ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_GEN__VISIBILITY = CODE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Super Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_GEN__SUPER_CLASS = CODE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Implements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_GEN__IMPLEMENTS = CODE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Class Gen</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_GEN_FEATURE_COUNT = CODE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.yakindu.base.generator.generator.impl.MethodGenImpl <em>Method Gen</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.base.generator.generator.impl.MethodGenImpl
	 * @see org.yakindu.base.generator.generator.impl.GeneratorPackageImpl#getMethodGen()
	 * @generated
	 */
	int METHOD_GEN = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_GEN__NAME = CODE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_GEN__DOCUMENTATION = CODE_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_GEN__CHILDREN = CODE_ELEMENT__CHILDREN;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_GEN__PARENT = CODE_ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_GEN__VISIBILITY = CODE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_GEN__PARAMETERS = CODE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Return Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_GEN__RETURN_TYPE = CODE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Method Gen</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_GEN_FEATURE_COUNT = CODE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.yakindu.base.generator.generator.impl.AccessRestrictedImpl <em>Access Restricted</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.base.generator.generator.impl.AccessRestrictedImpl
	 * @see org.yakindu.base.generator.generator.impl.GeneratorPackageImpl#getAccessRestricted()
	 * @generated
	 */
	int ACCESS_RESTRICTED = 4;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_RESTRICTED__VISIBILITY = 0;

	/**
	 * The number of structural features of the '<em>Access Restricted</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_RESTRICTED_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.yakindu.base.generator.generator.impl.VariableGenImpl <em>Variable Gen</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.base.generator.generator.impl.VariableGenImpl
	 * @see org.yakindu.base.generator.generator.impl.GeneratorPackageImpl#getVariableGen()
	 * @generated
	 */
	int VARIABLE_GEN = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_GEN__NAME = CODE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_GEN__DOCUMENTATION = CODE_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_GEN__CHILDREN = CODE_ELEMENT__CHILDREN;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_GEN__PARENT = CODE_ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_GEN__VISIBILITY = CODE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_GEN__TYPE = CODE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type Specifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_GEN__TYPE_SPECIFIER = CODE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Variable Gen</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_GEN_FEATURE_COUNT = CODE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.yakindu.base.generator.generator.impl.ParameterGenImpl <em>Parameter Gen</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.base.generator.generator.impl.ParameterGenImpl
	 * @see org.yakindu.base.generator.generator.impl.GeneratorPackageImpl#getParameterGen()
	 * @generated
	 */
	int PARAMETER_GEN = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_GEN__NAME = CODE_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Documentation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_GEN__DOCUMENTATION = CODE_ELEMENT__DOCUMENTATION;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_GEN__CHILDREN = CODE_ELEMENT__CHILDREN;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_GEN__PARENT = CODE_ELEMENT__PARENT;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_GEN__TYPE = CODE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type Specifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_GEN__TYPE_SPECIFIER = CODE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Parameter Gen</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_GEN_FEATURE_COUNT = CODE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.yakindu.base.generator.generator.VisibilityValues <em>Visibility Values</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.base.generator.generator.VisibilityValues
	 * @see org.yakindu.base.generator.generator.impl.GeneratorPackageImpl#getVisibilityValues()
	 * @generated
	 */
	int VISIBILITY_VALUES = 7;

	/**
	 * Returns the meta object for class '{@link org.yakindu.base.generator.generator.CodeElement <em>Code Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Code Element</em>'.
	 * @see org.yakindu.base.generator.generator.CodeElement
	 * @generated
	 */
	EClass getCodeElement();

	/**
	 * Returns the meta object for the containment reference list '{@link org.yakindu.base.generator.generator.CodeElement#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see org.yakindu.base.generator.generator.CodeElement#getChildren()
	 * @see #getCodeElement()
	 * @generated
	 */
	EReference getCodeElement_Children();

	/**
	 * Returns the meta object for the container reference '{@link org.yakindu.base.generator.generator.CodeElement#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see org.yakindu.base.generator.generator.CodeElement#getParent()
	 * @see #getCodeElement()
	 * @generated
	 */
	EReference getCodeElement_Parent();

	/**
	 * Returns the meta object for class '{@link org.yakindu.base.generator.generator.SourceFileGen <em>Source File Gen</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Source File Gen</em>'.
	 * @see org.yakindu.base.generator.generator.SourceFileGen
	 * @generated
	 */
	EClass getSourceFileGen();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.base.generator.generator.SourceFileGen#getPackage <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Package</em>'.
	 * @see org.yakindu.base.generator.generator.SourceFileGen#getPackage()
	 * @see #getSourceFileGen()
	 * @generated
	 */
	EAttribute getSourceFileGen_Package();

	/**
	 * Returns the meta object for the attribute list '{@link org.yakindu.base.generator.generator.SourceFileGen#getImports <em>Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Imports</em>'.
	 * @see org.yakindu.base.generator.generator.SourceFileGen#getImports()
	 * @see #getSourceFileGen()
	 * @generated
	 */
	EAttribute getSourceFileGen_Imports();

	/**
	 * Returns the meta object for class '{@link org.yakindu.base.generator.generator.ClassGen <em>Class Gen</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class Gen</em>'.
	 * @see org.yakindu.base.generator.generator.ClassGen
	 * @generated
	 */
	EClass getClassGen();

	/**
	 * Returns the meta object for the reference '{@link org.yakindu.base.generator.generator.ClassGen#getSuperClass <em>Super Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Super Class</em>'.
	 * @see org.yakindu.base.generator.generator.ClassGen#getSuperClass()
	 * @see #getClassGen()
	 * @generated
	 */
	EReference getClassGen_SuperClass();

	/**
	 * Returns the meta object for the reference list '{@link org.yakindu.base.generator.generator.ClassGen#getImplements <em>Implements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Implements</em>'.
	 * @see org.yakindu.base.generator.generator.ClassGen#getImplements()
	 * @see #getClassGen()
	 * @generated
	 */
	EReference getClassGen_Implements();

	/**
	 * Returns the meta object for class '{@link org.yakindu.base.generator.generator.MethodGen <em>Method Gen</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Method Gen</em>'.
	 * @see org.yakindu.base.generator.generator.MethodGen
	 * @generated
	 */
	EClass getMethodGen();

	/**
	 * Returns the meta object for the containment reference list '{@link org.yakindu.base.generator.generator.MethodGen#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see org.yakindu.base.generator.generator.MethodGen#getParameters()
	 * @see #getMethodGen()
	 * @generated
	 */
	EReference getMethodGen_Parameters();

	/**
	 * Returns the meta object for the reference '{@link org.yakindu.base.generator.generator.MethodGen#getReturnType <em>Return Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Return Type</em>'.
	 * @see org.yakindu.base.generator.generator.MethodGen#getReturnType()
	 * @see #getMethodGen()
	 * @generated
	 */
	EReference getMethodGen_ReturnType();

	/**
	 * Returns the meta object for class '{@link org.yakindu.base.generator.generator.AccessRestricted <em>Access Restricted</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Access Restricted</em>'.
	 * @see org.yakindu.base.generator.generator.AccessRestricted
	 * @generated
	 */
	EClass getAccessRestricted();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.base.generator.generator.AccessRestricted#getVisibility <em>Visibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Visibility</em>'.
	 * @see org.yakindu.base.generator.generator.AccessRestricted#getVisibility()
	 * @see #getAccessRestricted()
	 * @generated
	 */
	EAttribute getAccessRestricted_Visibility();

	/**
	 * Returns the meta object for class '{@link org.yakindu.base.generator.generator.VariableGen <em>Variable Gen</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Gen</em>'.
	 * @see org.yakindu.base.generator.generator.VariableGen
	 * @generated
	 */
	EClass getVariableGen();

	/**
	 * Returns the meta object for class '{@link org.yakindu.base.generator.generator.ParameterGen <em>Parameter Gen</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter Gen</em>'.
	 * @see org.yakindu.base.generator.generator.ParameterGen
	 * @generated
	 */
	EClass getParameterGen();

	/**
	 * Returns the meta object for enum '{@link org.yakindu.base.generator.generator.VisibilityValues <em>Visibility Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Visibility Values</em>'.
	 * @see org.yakindu.base.generator.generator.VisibilityValues
	 * @generated
	 */
	EEnum getVisibilityValues();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	GeneratorFactory getGeneratorFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.yakindu.base.generator.generator.impl.CodeElementImpl <em>Code Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.base.generator.generator.impl.CodeElementImpl
		 * @see org.yakindu.base.generator.generator.impl.GeneratorPackageImpl#getCodeElement()
		 * @generated
		 */
		EClass CODE_ELEMENT = eINSTANCE.getCodeElement();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CODE_ELEMENT__CHILDREN = eINSTANCE.getCodeElement_Children();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CODE_ELEMENT__PARENT = eINSTANCE.getCodeElement_Parent();

		/**
		 * The meta object literal for the '{@link org.yakindu.base.generator.generator.impl.SourceFileGenImpl <em>Source File Gen</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.base.generator.generator.impl.SourceFileGenImpl
		 * @see org.yakindu.base.generator.generator.impl.GeneratorPackageImpl#getSourceFileGen()
		 * @generated
		 */
		EClass SOURCE_FILE_GEN = eINSTANCE.getSourceFileGen();

		/**
		 * The meta object literal for the '<em><b>Package</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOURCE_FILE_GEN__PACKAGE = eINSTANCE.getSourceFileGen_Package();

		/**
		 * The meta object literal for the '<em><b>Imports</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOURCE_FILE_GEN__IMPORTS = eINSTANCE.getSourceFileGen_Imports();

		/**
		 * The meta object literal for the '{@link org.yakindu.base.generator.generator.impl.ClassGenImpl <em>Class Gen</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.base.generator.generator.impl.ClassGenImpl
		 * @see org.yakindu.base.generator.generator.impl.GeneratorPackageImpl#getClassGen()
		 * @generated
		 */
		EClass CLASS_GEN = eINSTANCE.getClassGen();

		/**
		 * The meta object literal for the '<em><b>Super Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_GEN__SUPER_CLASS = eINSTANCE.getClassGen_SuperClass();

		/**
		 * The meta object literal for the '<em><b>Implements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_GEN__IMPLEMENTS = eINSTANCE.getClassGen_Implements();

		/**
		 * The meta object literal for the '{@link org.yakindu.base.generator.generator.impl.MethodGenImpl <em>Method Gen</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.base.generator.generator.impl.MethodGenImpl
		 * @see org.yakindu.base.generator.generator.impl.GeneratorPackageImpl#getMethodGen()
		 * @generated
		 */
		EClass METHOD_GEN = eINSTANCE.getMethodGen();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METHOD_GEN__PARAMETERS = eINSTANCE.getMethodGen_Parameters();

		/**
		 * The meta object literal for the '<em><b>Return Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METHOD_GEN__RETURN_TYPE = eINSTANCE.getMethodGen_ReturnType();

		/**
		 * The meta object literal for the '{@link org.yakindu.base.generator.generator.impl.AccessRestrictedImpl <em>Access Restricted</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.base.generator.generator.impl.AccessRestrictedImpl
		 * @see org.yakindu.base.generator.generator.impl.GeneratorPackageImpl#getAccessRestricted()
		 * @generated
		 */
		EClass ACCESS_RESTRICTED = eINSTANCE.getAccessRestricted();

		/**
		 * The meta object literal for the '<em><b>Visibility</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACCESS_RESTRICTED__VISIBILITY = eINSTANCE.getAccessRestricted_Visibility();

		/**
		 * The meta object literal for the '{@link org.yakindu.base.generator.generator.impl.VariableGenImpl <em>Variable Gen</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.base.generator.generator.impl.VariableGenImpl
		 * @see org.yakindu.base.generator.generator.impl.GeneratorPackageImpl#getVariableGen()
		 * @generated
		 */
		EClass VARIABLE_GEN = eINSTANCE.getVariableGen();

		/**
		 * The meta object literal for the '{@link org.yakindu.base.generator.generator.impl.ParameterGenImpl <em>Parameter Gen</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.base.generator.generator.impl.ParameterGenImpl
		 * @see org.yakindu.base.generator.generator.impl.GeneratorPackageImpl#getParameterGen()
		 * @generated
		 */
		EClass PARAMETER_GEN = eINSTANCE.getParameterGen();

		/**
		 * The meta object literal for the '{@link org.yakindu.base.generator.generator.VisibilityValues <em>Visibility Values</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.base.generator.generator.VisibilityValues
		 * @see org.yakindu.base.generator.generator.impl.GeneratorPackageImpl#getVisibilityValues()
		 * @generated
		 */
		EEnum VISIBILITY_VALUES = eINSTANCE.getVisibilityValues();

	}

} //GeneratorPackage
