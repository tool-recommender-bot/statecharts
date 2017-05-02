/**
 */
package org.yakindu.base.generator.generator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.yakindu.base.generator.generator.generatorFactory
 * @model kind="package"
 * @generated
 */
public interface generatorPackage extends EPackage {
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
	String eNS_URI = "http://www.yakindu.org/base/generator";

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
	generatorPackage eINSTANCE = org.yakindu.base.generator.generator.impl.generatorPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.yakindu.base.generator.generator.impl.CodeElementImpl <em>Code Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.base.generator.generator.impl.CodeElementImpl
	 * @see org.yakindu.base.generator.generator.impl.generatorPackageImpl#getCodeElement()
	 * @generated
	 */
	int CODE_ELEMENT = 0;

	/**
	 * The number of structural features of the '<em>Code Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_ELEMENT_FEATURE_COUNT = 0;

	/**
	 * The operation id for the '<em>Generate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_ELEMENT___GENERATE = 0;

	/**
	 * The number of operations of the '<em>Code Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_ELEMENT_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.yakindu.base.generator.generator.impl.LineBasedCodeElementImpl <em>Line Based Code Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.base.generator.generator.impl.LineBasedCodeElementImpl
	 * @see org.yakindu.base.generator.generator.impl.generatorPackageImpl#getLineBasedCodeElement()
	 * @generated
	 */
	int LINE_BASED_CODE_ELEMENT = 1;

	/**
	 * The number of structural features of the '<em>Line Based Code Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_BASED_CODE_ELEMENT_FEATURE_COUNT = CODE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Generate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_BASED_CODE_ELEMENT___GENERATE = CODE_ELEMENT___GENERATE;

	/**
	 * The number of operations of the '<em>Line Based Code Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_BASED_CODE_ELEMENT_OPERATION_COUNT = CODE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.yakindu.base.generator.generator.impl.BlockBasedCodeElementImpl <em>Block Based Code Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.base.generator.generator.impl.BlockBasedCodeElementImpl
	 * @see org.yakindu.base.generator.generator.impl.generatorPackageImpl#getBlockBasedCodeElement()
	 * @generated
	 */
	int BLOCK_BASED_CODE_ELEMENT = 2;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_BASED_CODE_ELEMENT__CONTENTS = CODE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Block Based Code Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_BASED_CODE_ELEMENT_FEATURE_COUNT = CODE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Generate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_BASED_CODE_ELEMENT___GENERATE = CODE_ELEMENT___GENERATE;

	/**
	 * The operation id for the '<em>Generate Block Header</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_BASED_CODE_ELEMENT___GENERATE_BLOCK_HEADER = CODE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Generate Block Start</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_BASED_CODE_ELEMENT___GENERATE_BLOCK_START = CODE_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Generate Block End</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_BASED_CODE_ELEMENT___GENERATE_BLOCK_END = CODE_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Generate Block Contents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_BASED_CODE_ELEMENT___GENERATE_BLOCK_CONTENTS = CODE_ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The number of operations of the '<em>Block Based Code Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_BASED_CODE_ELEMENT_OPERATION_COUNT = CODE_ELEMENT_OPERATION_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.yakindu.base.generator.generator.impl.ClassImpl <em>Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.base.generator.generator.impl.ClassImpl
	 * @see org.yakindu.base.generator.generator.impl.generatorPackageImpl#getClass_()
	 * @generated
	 */
	int CLASS = 3;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__CONTENTS = BLOCK_BASED_CODE_ELEMENT__CONTENTS;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__VISIBILITY = BLOCK_BASED_CODE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__CLASS_NAME = BLOCK_BASED_CODE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Class Members</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__CLASS_MEMBERS = BLOCK_BASED_CODE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_FEATURE_COUNT = BLOCK_BASED_CODE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Generate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___GENERATE = BLOCK_BASED_CODE_ELEMENT___GENERATE;

	/**
	 * The operation id for the '<em>Generate Block Header</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___GENERATE_BLOCK_HEADER = BLOCK_BASED_CODE_ELEMENT___GENERATE_BLOCK_HEADER;

	/**
	 * The operation id for the '<em>Generate Block Start</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___GENERATE_BLOCK_START = BLOCK_BASED_CODE_ELEMENT___GENERATE_BLOCK_START;

	/**
	 * The operation id for the '<em>Generate Block End</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___GENERATE_BLOCK_END = BLOCK_BASED_CODE_ELEMENT___GENERATE_BLOCK_END;

	/**
	 * The operation id for the '<em>Generate Block Contents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS___GENERATE_BLOCK_CONTENTS = BLOCK_BASED_CODE_ELEMENT___GENERATE_BLOCK_CONTENTS;

	/**
	 * The number of operations of the '<em>Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_OPERATION_COUNT = BLOCK_BASED_CODE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.yakindu.base.generator.generator.impl.ClassDeclarationImpl <em>Class Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.base.generator.generator.impl.ClassDeclarationImpl
	 * @see org.yakindu.base.generator.generator.impl.generatorPackageImpl#getClassDeclaration()
	 * @generated
	 */
	int CLASS_DECLARATION = 4;

	/**
	 * The feature id for the '<em><b>Parent Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DECLARATION__PARENT_CLASS = 0;

	/**
	 * The number of structural features of the '<em>Class Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DECLARATION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Class Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DECLARATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.yakindu.base.generator.generator.impl.MethodImpl <em>Method</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.base.generator.generator.impl.MethodImpl
	 * @see org.yakindu.base.generator.generator.impl.generatorPackageImpl#getMethod()
	 * @generated
	 */
	int METHOD = 5;

	/**
	 * The feature id for the '<em><b>Contents</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__CONTENTS = BLOCK_BASED_CODE_ELEMENT__CONTENTS;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__VISIBILITY = BLOCK_BASED_CODE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__ARGUMENTS = BLOCK_BASED_CODE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__TYPE = BLOCK_BASED_CODE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Method</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_FEATURE_COUNT = BLOCK_BASED_CODE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Generate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD___GENERATE = BLOCK_BASED_CODE_ELEMENT___GENERATE;

	/**
	 * The operation id for the '<em>Generate Block Header</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD___GENERATE_BLOCK_HEADER = BLOCK_BASED_CODE_ELEMENT___GENERATE_BLOCK_HEADER;

	/**
	 * The operation id for the '<em>Generate Block Start</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD___GENERATE_BLOCK_START = BLOCK_BASED_CODE_ELEMENT___GENERATE_BLOCK_START;

	/**
	 * The operation id for the '<em>Generate Block End</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD___GENERATE_BLOCK_END = BLOCK_BASED_CODE_ELEMENT___GENERATE_BLOCK_END;

	/**
	 * The operation id for the '<em>Generate Block Contents</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD___GENERATE_BLOCK_CONTENTS = BLOCK_BASED_CODE_ELEMENT___GENERATE_BLOCK_CONTENTS;

	/**
	 * The number of operations of the '<em>Method</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_OPERATION_COUNT = BLOCK_BASED_CODE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.yakindu.base.generator.generator.impl.MethodDeclarationImpl <em>Method Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.base.generator.generator.impl.MethodDeclarationImpl
	 * @see org.yakindu.base.generator.generator.impl.generatorPackageImpl#getMethodDeclaration()
	 * @generated
	 */
	int METHOD_DECLARATION = 6;

	/**
	 * The feature id for the '<em><b>Parent Method</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_DECLARATION__PARENT_METHOD = LINE_BASED_CODE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Method Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_DECLARATION_FEATURE_COUNT = LINE_BASED_CODE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Generate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_DECLARATION___GENERATE = LINE_BASED_CODE_ELEMENT___GENERATE;

	/**
	 * The number of operations of the '<em>Method Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_DECLARATION_OPERATION_COUNT = LINE_BASED_CODE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.yakindu.base.generator.generator.impl.VisibilityOwnerImpl <em>Visibility Owner</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.base.generator.generator.impl.VisibilityOwnerImpl
	 * @see org.yakindu.base.generator.generator.impl.generatorPackageImpl#getVisibilityOwner()
	 * @generated
	 */
	int VISIBILITY_OWNER = 8;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISIBILITY_OWNER__VISIBILITY = 0;

	/**
	 * The number of structural features of the '<em>Visibility Owner</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISIBILITY_OWNER_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Visibility Owner</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISIBILITY_OWNER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.yakindu.base.generator.generator.impl.ClassMemberImpl <em>Class Member</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.base.generator.generator.impl.ClassMemberImpl
	 * @see org.yakindu.base.generator.generator.impl.generatorPackageImpl#getClassMember()
	 * @generated
	 */
	int CLASS_MEMBER = 7;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_MEMBER__VISIBILITY = VISIBILITY_OWNER__VISIBILITY;

	/**
	 * The number of structural features of the '<em>Class Member</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_MEMBER_FEATURE_COUNT = VISIBILITY_OWNER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Class Member</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_MEMBER_OPERATION_COUNT = VISIBILITY_OWNER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.yakindu.base.generator.generator.impl.VariableImpl <em>Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.base.generator.generator.impl.VariableImpl
	 * @see org.yakindu.base.generator.generator.impl.generatorPackageImpl#getVariable()
	 * @generated
	 */
	int VARIABLE = 9;

	/**
	 * The feature id for the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__VISIBILITY = CLASS_MEMBER__VISIBILITY;

	/**
	 * The number of structural features of the '<em>Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_FEATURE_COUNT = CLASS_MEMBER_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_OPERATION_COUNT = CLASS_MEMBER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.yakindu.base.generator.generator.impl.VariableDeclarationImpl <em>Variable Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.base.generator.generator.impl.VariableDeclarationImpl
	 * @see org.yakindu.base.generator.generator.impl.generatorPackageImpl#getVariableDeclaration()
	 * @generated
	 */
	int VARIABLE_DECLARATION = 10;

	/**
	 * The feature id for the '<em><b>Parent Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__PARENT_VARIABLE = LINE_BASED_CODE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Variable Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION_FEATURE_COUNT = LINE_BASED_CODE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Generate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION___GENERATE = LINE_BASED_CODE_ELEMENT___GENERATE;

	/**
	 * The number of operations of the '<em>Variable Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION_OPERATION_COUNT = LINE_BASED_CODE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.yakindu.base.generator.generator.impl.CommentImpl <em>Comment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.base.generator.generator.impl.CommentImpl
	 * @see org.yakindu.base.generator.generator.impl.generatorPackageImpl#getComment()
	 * @generated
	 */
	int COMMENT = 11;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT__TEXT = LINE_BASED_CODE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Comment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT_FEATURE_COUNT = LINE_BASED_CODE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Generate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT___GENERATE = LINE_BASED_CODE_ELEMENT___GENERATE;

	/**
	 * The operation id for the '<em>Generate Comment Start</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT___GENERATE_COMMENT_START = LINE_BASED_CODE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Generate Comment End</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT___GENERATE_COMMENT_END = LINE_BASED_CODE_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Generate Text</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT___GENERATE_TEXT = LINE_BASED_CODE_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Comment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT_OPERATION_COUNT = LINE_BASED_CODE_ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.yakindu.base.generator.generator.impl.SourceFileImpl <em>Source File</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.base.generator.generator.impl.SourceFileImpl
	 * @see org.yakindu.base.generator.generator.impl.generatorPackageImpl#getSourceFile()
	 * @generated
	 */
	int SOURCE_FILE = 12;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_FILE__IMPORTS = CODE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_FILE__FILE = CODE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Source File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_FILE_FEATURE_COUNT = CODE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Generate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_FILE___GENERATE = CODE_ELEMENT___GENERATE;

	/**
	 * The number of operations of the '<em>Source File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_FILE_OPERATION_COUNT = CODE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.yakindu.base.generator.generator.impl.CodeExpressionImpl <em>Code Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.base.generator.generator.impl.CodeExpressionImpl
	 * @see org.yakindu.base.generator.generator.impl.generatorPackageImpl#getCodeExpression()
	 * @generated
	 */
	int CODE_EXPRESSION = 13;

	/**
	 * The feature id for the '<em><b>Exp</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_EXPRESSION__EXP = LINE_BASED_CODE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Code Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_EXPRESSION_FEATURE_COUNT = LINE_BASED_CODE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Generate</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_EXPRESSION___GENERATE = LINE_BASED_CODE_ELEMENT___GENERATE;

	/**
	 * The number of operations of the '<em>Code Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_EXPRESSION_OPERATION_COUNT = LINE_BASED_CODE_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.yakindu.base.generator.generator.Visibility <em>Visibility</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.base.generator.generator.Visibility
	 * @see org.yakindu.base.generator.generator.impl.generatorPackageImpl#getVisibility()
	 * @generated
	 */
	int VISIBILITY = 14;


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
	 * Returns the meta object for the '{@link org.yakindu.base.generator.generator.CodeElement#generate() <em>Generate</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Generate</em>' operation.
	 * @see org.yakindu.base.generator.generator.CodeElement#generate()
	 * @generated
	 */
	EOperation getCodeElement__Generate();

	/**
	 * Returns the meta object for class '{@link org.yakindu.base.generator.generator.LineBasedCodeElement <em>Line Based Code Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Line Based Code Element</em>'.
	 * @see org.yakindu.base.generator.generator.LineBasedCodeElement
	 * @generated
	 */
	EClass getLineBasedCodeElement();

	/**
	 * Returns the meta object for class '{@link org.yakindu.base.generator.generator.BlockBasedCodeElement <em>Block Based Code Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Block Based Code Element</em>'.
	 * @see org.yakindu.base.generator.generator.BlockBasedCodeElement
	 * @generated
	 */
	EClass getBlockBasedCodeElement();

	/**
	 * Returns the meta object for the reference list '{@link org.yakindu.base.generator.generator.BlockBasedCodeElement#getContents <em>Contents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Contents</em>'.
	 * @see org.yakindu.base.generator.generator.BlockBasedCodeElement#getContents()
	 * @see #getBlockBasedCodeElement()
	 * @generated
	 */
	EReference getBlockBasedCodeElement_Contents();

	/**
	 * Returns the meta object for the '{@link org.yakindu.base.generator.generator.BlockBasedCodeElement#generateBlockHeader() <em>Generate Block Header</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Generate Block Header</em>' operation.
	 * @see org.yakindu.base.generator.generator.BlockBasedCodeElement#generateBlockHeader()
	 * @generated
	 */
	EOperation getBlockBasedCodeElement__GenerateBlockHeader();

	/**
	 * Returns the meta object for the '{@link org.yakindu.base.generator.generator.BlockBasedCodeElement#generateBlockStart() <em>Generate Block Start</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Generate Block Start</em>' operation.
	 * @see org.yakindu.base.generator.generator.BlockBasedCodeElement#generateBlockStart()
	 * @generated
	 */
	EOperation getBlockBasedCodeElement__GenerateBlockStart();

	/**
	 * Returns the meta object for the '{@link org.yakindu.base.generator.generator.BlockBasedCodeElement#generateBlockEnd() <em>Generate Block End</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Generate Block End</em>' operation.
	 * @see org.yakindu.base.generator.generator.BlockBasedCodeElement#generateBlockEnd()
	 * @generated
	 */
	EOperation getBlockBasedCodeElement__GenerateBlockEnd();

	/**
	 * Returns the meta object for the '{@link org.yakindu.base.generator.generator.BlockBasedCodeElement#generateBlockContents() <em>Generate Block Contents</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Generate Block Contents</em>' operation.
	 * @see org.yakindu.base.generator.generator.BlockBasedCodeElement#generateBlockContents()
	 * @generated
	 */
	EOperation getBlockBasedCodeElement__GenerateBlockContents();

	/**
	 * Returns the meta object for class '{@link org.yakindu.base.generator.generator.Class <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class</em>'.
	 * @see org.yakindu.base.generator.generator.Class
	 * @generated
	 */
	EClass getClass_();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.base.generator.generator.Class#getClassName <em>Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class Name</em>'.
	 * @see org.yakindu.base.generator.generator.Class#getClassName()
	 * @see #getClass_()
	 * @generated
	 */
	EAttribute getClass_ClassName();

	/**
	 * Returns the meta object for the reference list '{@link org.yakindu.base.generator.generator.Class#getClassMembers <em>Class Members</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Class Members</em>'.
	 * @see org.yakindu.base.generator.generator.Class#getClassMembers()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_ClassMembers();

	/**
	 * Returns the meta object for class '{@link org.yakindu.base.generator.generator.ClassDeclaration <em>Class Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class Declaration</em>'.
	 * @see org.yakindu.base.generator.generator.ClassDeclaration
	 * @generated
	 */
	EClass getClassDeclaration();

	/**
	 * Returns the meta object for the reference '{@link org.yakindu.base.generator.generator.ClassDeclaration#getParentClass <em>Parent Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent Class</em>'.
	 * @see org.yakindu.base.generator.generator.ClassDeclaration#getParentClass()
	 * @see #getClassDeclaration()
	 * @generated
	 */
	EReference getClassDeclaration_ParentClass();

	/**
	 * Returns the meta object for class '{@link org.yakindu.base.generator.generator.Method <em>Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Method</em>'.
	 * @see org.yakindu.base.generator.generator.Method
	 * @generated
	 */
	EClass getMethod();

	/**
	 * Returns the meta object for the reference list '{@link org.yakindu.base.generator.generator.Method#getArguments <em>Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Arguments</em>'.
	 * @see org.yakindu.base.generator.generator.Method#getArguments()
	 * @see #getMethod()
	 * @generated
	 */
	EReference getMethod_Arguments();

	/**
	 * Returns the meta object for the reference '{@link org.yakindu.base.generator.generator.Method#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.yakindu.base.generator.generator.Method#getType()
	 * @see #getMethod()
	 * @generated
	 */
	EReference getMethod_Type();

	/**
	 * Returns the meta object for class '{@link org.yakindu.base.generator.generator.MethodDeclaration <em>Method Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Method Declaration</em>'.
	 * @see org.yakindu.base.generator.generator.MethodDeclaration
	 * @generated
	 */
	EClass getMethodDeclaration();

	/**
	 * Returns the meta object for the reference '{@link org.yakindu.base.generator.generator.MethodDeclaration#getParentMethod <em>Parent Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent Method</em>'.
	 * @see org.yakindu.base.generator.generator.MethodDeclaration#getParentMethod()
	 * @see #getMethodDeclaration()
	 * @generated
	 */
	EReference getMethodDeclaration_ParentMethod();

	/**
	 * Returns the meta object for class '{@link org.yakindu.base.generator.generator.ClassMember <em>Class Member</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class Member</em>'.
	 * @see org.yakindu.base.generator.generator.ClassMember
	 * @generated
	 */
	EClass getClassMember();

	/**
	 * Returns the meta object for class '{@link org.yakindu.base.generator.generator.VisibilityOwner <em>Visibility Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Visibility Owner</em>'.
	 * @see org.yakindu.base.generator.generator.VisibilityOwner
	 * @generated
	 */
	EClass getVisibilityOwner();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.base.generator.generator.VisibilityOwner#getVisibility <em>Visibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Visibility</em>'.
	 * @see org.yakindu.base.generator.generator.VisibilityOwner#getVisibility()
	 * @see #getVisibilityOwner()
	 * @generated
	 */
	EAttribute getVisibilityOwner_Visibility();

	/**
	 * Returns the meta object for class '{@link org.yakindu.base.generator.generator.Variable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable</em>'.
	 * @see org.yakindu.base.generator.generator.Variable
	 * @generated
	 */
	EClass getVariable();

	/**
	 * Returns the meta object for class '{@link org.yakindu.base.generator.generator.VariableDeclaration <em>Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Declaration</em>'.
	 * @see org.yakindu.base.generator.generator.VariableDeclaration
	 * @generated
	 */
	EClass getVariableDeclaration();

	/**
	 * Returns the meta object for the reference '{@link org.yakindu.base.generator.generator.VariableDeclaration#getParentVariable <em>Parent Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent Variable</em>'.
	 * @see org.yakindu.base.generator.generator.VariableDeclaration#getParentVariable()
	 * @see #getVariableDeclaration()
	 * @generated
	 */
	EReference getVariableDeclaration_ParentVariable();

	/**
	 * Returns the meta object for class '{@link org.yakindu.base.generator.generator.Comment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Comment</em>'.
	 * @see org.yakindu.base.generator.generator.Comment
	 * @generated
	 */
	EClass getComment();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.base.generator.generator.Comment#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.yakindu.base.generator.generator.Comment#getText()
	 * @see #getComment()
	 * @generated
	 */
	EAttribute getComment_Text();

	/**
	 * Returns the meta object for the '{@link org.yakindu.base.generator.generator.Comment#generateCommentStart() <em>Generate Comment Start</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Generate Comment Start</em>' operation.
	 * @see org.yakindu.base.generator.generator.Comment#generateCommentStart()
	 * @generated
	 */
	EOperation getComment__GenerateCommentStart();

	/**
	 * Returns the meta object for the '{@link org.yakindu.base.generator.generator.Comment#generateCommentEnd() <em>Generate Comment End</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Generate Comment End</em>' operation.
	 * @see org.yakindu.base.generator.generator.Comment#generateCommentEnd()
	 * @generated
	 */
	EOperation getComment__GenerateCommentEnd();

	/**
	 * Returns the meta object for the '{@link org.yakindu.base.generator.generator.Comment#generateText() <em>Generate Text</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Generate Text</em>' operation.
	 * @see org.yakindu.base.generator.generator.Comment#generateText()
	 * @generated
	 */
	EOperation getComment__GenerateText();

	/**
	 * Returns the meta object for class '{@link org.yakindu.base.generator.generator.SourceFile <em>Source File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Source File</em>'.
	 * @see org.yakindu.base.generator.generator.SourceFile
	 * @generated
	 */
	EClass getSourceFile();

	/**
	 * Returns the meta object for the reference list '{@link org.yakindu.base.generator.generator.SourceFile#getImports <em>Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Imports</em>'.
	 * @see org.yakindu.base.generator.generator.SourceFile#getImports()
	 * @see #getSourceFile()
	 * @generated
	 */
	EReference getSourceFile_Imports();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.base.generator.generator.SourceFile#getFile <em>File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File</em>'.
	 * @see org.yakindu.base.generator.generator.SourceFile#getFile()
	 * @see #getSourceFile()
	 * @generated
	 */
	EAttribute getSourceFile_File();

	/**
	 * Returns the meta object for class '{@link org.yakindu.base.generator.generator.CodeExpression <em>Code Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Code Expression</em>'.
	 * @see org.yakindu.base.generator.generator.CodeExpression
	 * @generated
	 */
	EClass getCodeExpression();

	/**
	 * Returns the meta object for the reference '{@link org.yakindu.base.generator.generator.CodeExpression#getExp <em>Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Exp</em>'.
	 * @see org.yakindu.base.generator.generator.CodeExpression#getExp()
	 * @see #getCodeExpression()
	 * @generated
	 */
	EReference getCodeExpression_Exp();

	/**
	 * Returns the meta object for enum '{@link org.yakindu.base.generator.generator.Visibility <em>Visibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Visibility</em>'.
	 * @see org.yakindu.base.generator.generator.Visibility
	 * @generated
	 */
	EEnum getVisibility();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	generatorFactory getgeneratorFactory();

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
		 * @see org.yakindu.base.generator.generator.impl.generatorPackageImpl#getCodeElement()
		 * @generated
		 */
		EClass CODE_ELEMENT = eINSTANCE.getCodeElement();

		/**
		 * The meta object literal for the '<em><b>Generate</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CODE_ELEMENT___GENERATE = eINSTANCE.getCodeElement__Generate();

		/**
		 * The meta object literal for the '{@link org.yakindu.base.generator.generator.impl.LineBasedCodeElementImpl <em>Line Based Code Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.base.generator.generator.impl.LineBasedCodeElementImpl
		 * @see org.yakindu.base.generator.generator.impl.generatorPackageImpl#getLineBasedCodeElement()
		 * @generated
		 */
		EClass LINE_BASED_CODE_ELEMENT = eINSTANCE.getLineBasedCodeElement();

		/**
		 * The meta object literal for the '{@link org.yakindu.base.generator.generator.impl.BlockBasedCodeElementImpl <em>Block Based Code Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.base.generator.generator.impl.BlockBasedCodeElementImpl
		 * @see org.yakindu.base.generator.generator.impl.generatorPackageImpl#getBlockBasedCodeElement()
		 * @generated
		 */
		EClass BLOCK_BASED_CODE_ELEMENT = eINSTANCE.getBlockBasedCodeElement();

		/**
		 * The meta object literal for the '<em><b>Contents</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCK_BASED_CODE_ELEMENT__CONTENTS = eINSTANCE.getBlockBasedCodeElement_Contents();

		/**
		 * The meta object literal for the '<em><b>Generate Block Header</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BLOCK_BASED_CODE_ELEMENT___GENERATE_BLOCK_HEADER = eINSTANCE.getBlockBasedCodeElement__GenerateBlockHeader();

		/**
		 * The meta object literal for the '<em><b>Generate Block Start</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BLOCK_BASED_CODE_ELEMENT___GENERATE_BLOCK_START = eINSTANCE.getBlockBasedCodeElement__GenerateBlockStart();

		/**
		 * The meta object literal for the '<em><b>Generate Block End</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BLOCK_BASED_CODE_ELEMENT___GENERATE_BLOCK_END = eINSTANCE.getBlockBasedCodeElement__GenerateBlockEnd();

		/**
		 * The meta object literal for the '<em><b>Generate Block Contents</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BLOCK_BASED_CODE_ELEMENT___GENERATE_BLOCK_CONTENTS = eINSTANCE.getBlockBasedCodeElement__GenerateBlockContents();

		/**
		 * The meta object literal for the '{@link org.yakindu.base.generator.generator.impl.ClassImpl <em>Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.base.generator.generator.impl.ClassImpl
		 * @see org.yakindu.base.generator.generator.impl.generatorPackageImpl#getClass_()
		 * @generated
		 */
		EClass CLASS = eINSTANCE.getClass_();

		/**
		 * The meta object literal for the '<em><b>Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLASS__CLASS_NAME = eINSTANCE.getClass_ClassName();

		/**
		 * The meta object literal for the '<em><b>Class Members</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__CLASS_MEMBERS = eINSTANCE.getClass_ClassMembers();

		/**
		 * The meta object literal for the '{@link org.yakindu.base.generator.generator.impl.ClassDeclarationImpl <em>Class Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.base.generator.generator.impl.ClassDeclarationImpl
		 * @see org.yakindu.base.generator.generator.impl.generatorPackageImpl#getClassDeclaration()
		 * @generated
		 */
		EClass CLASS_DECLARATION = eINSTANCE.getClassDeclaration();

		/**
		 * The meta object literal for the '<em><b>Parent Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_DECLARATION__PARENT_CLASS = eINSTANCE.getClassDeclaration_ParentClass();

		/**
		 * The meta object literal for the '{@link org.yakindu.base.generator.generator.impl.MethodImpl <em>Method</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.base.generator.generator.impl.MethodImpl
		 * @see org.yakindu.base.generator.generator.impl.generatorPackageImpl#getMethod()
		 * @generated
		 */
		EClass METHOD = eINSTANCE.getMethod();

		/**
		 * The meta object literal for the '<em><b>Arguments</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METHOD__ARGUMENTS = eINSTANCE.getMethod_Arguments();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METHOD__TYPE = eINSTANCE.getMethod_Type();

		/**
		 * The meta object literal for the '{@link org.yakindu.base.generator.generator.impl.MethodDeclarationImpl <em>Method Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.base.generator.generator.impl.MethodDeclarationImpl
		 * @see org.yakindu.base.generator.generator.impl.generatorPackageImpl#getMethodDeclaration()
		 * @generated
		 */
		EClass METHOD_DECLARATION = eINSTANCE.getMethodDeclaration();

		/**
		 * The meta object literal for the '<em><b>Parent Method</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METHOD_DECLARATION__PARENT_METHOD = eINSTANCE.getMethodDeclaration_ParentMethod();

		/**
		 * The meta object literal for the '{@link org.yakindu.base.generator.generator.impl.ClassMemberImpl <em>Class Member</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.base.generator.generator.impl.ClassMemberImpl
		 * @see org.yakindu.base.generator.generator.impl.generatorPackageImpl#getClassMember()
		 * @generated
		 */
		EClass CLASS_MEMBER = eINSTANCE.getClassMember();

		/**
		 * The meta object literal for the '{@link org.yakindu.base.generator.generator.impl.VisibilityOwnerImpl <em>Visibility Owner</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.base.generator.generator.impl.VisibilityOwnerImpl
		 * @see org.yakindu.base.generator.generator.impl.generatorPackageImpl#getVisibilityOwner()
		 * @generated
		 */
		EClass VISIBILITY_OWNER = eINSTANCE.getVisibilityOwner();

		/**
		 * The meta object literal for the '<em><b>Visibility</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VISIBILITY_OWNER__VISIBILITY = eINSTANCE.getVisibilityOwner_Visibility();

		/**
		 * The meta object literal for the '{@link org.yakindu.base.generator.generator.impl.VariableImpl <em>Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.base.generator.generator.impl.VariableImpl
		 * @see org.yakindu.base.generator.generator.impl.generatorPackageImpl#getVariable()
		 * @generated
		 */
		EClass VARIABLE = eINSTANCE.getVariable();

		/**
		 * The meta object literal for the '{@link org.yakindu.base.generator.generator.impl.VariableDeclarationImpl <em>Variable Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.base.generator.generator.impl.VariableDeclarationImpl
		 * @see org.yakindu.base.generator.generator.impl.generatorPackageImpl#getVariableDeclaration()
		 * @generated
		 */
		EClass VARIABLE_DECLARATION = eINSTANCE.getVariableDeclaration();

		/**
		 * The meta object literal for the '<em><b>Parent Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_DECLARATION__PARENT_VARIABLE = eINSTANCE.getVariableDeclaration_ParentVariable();

		/**
		 * The meta object literal for the '{@link org.yakindu.base.generator.generator.impl.CommentImpl <em>Comment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.base.generator.generator.impl.CommentImpl
		 * @see org.yakindu.base.generator.generator.impl.generatorPackageImpl#getComment()
		 * @generated
		 */
		EClass COMMENT = eINSTANCE.getComment();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMMENT__TEXT = eINSTANCE.getComment_Text();

		/**
		 * The meta object literal for the '<em><b>Generate Comment Start</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COMMENT___GENERATE_COMMENT_START = eINSTANCE.getComment__GenerateCommentStart();

		/**
		 * The meta object literal for the '<em><b>Generate Comment End</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COMMENT___GENERATE_COMMENT_END = eINSTANCE.getComment__GenerateCommentEnd();

		/**
		 * The meta object literal for the '<em><b>Generate Text</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation COMMENT___GENERATE_TEXT = eINSTANCE.getComment__GenerateText();

		/**
		 * The meta object literal for the '{@link org.yakindu.base.generator.generator.impl.SourceFileImpl <em>Source File</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.base.generator.generator.impl.SourceFileImpl
		 * @see org.yakindu.base.generator.generator.impl.generatorPackageImpl#getSourceFile()
		 * @generated
		 */
		EClass SOURCE_FILE = eINSTANCE.getSourceFile();

		/**
		 * The meta object literal for the '<em><b>Imports</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOURCE_FILE__IMPORTS = eINSTANCE.getSourceFile_Imports();

		/**
		 * The meta object literal for the '<em><b>File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOURCE_FILE__FILE = eINSTANCE.getSourceFile_File();

		/**
		 * The meta object literal for the '{@link org.yakindu.base.generator.generator.impl.CodeExpressionImpl <em>Code Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.base.generator.generator.impl.CodeExpressionImpl
		 * @see org.yakindu.base.generator.generator.impl.generatorPackageImpl#getCodeExpression()
		 * @generated
		 */
		EClass CODE_EXPRESSION = eINSTANCE.getCodeExpression();

		/**
		 * The meta object literal for the '<em><b>Exp</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CODE_EXPRESSION__EXP = eINSTANCE.getCodeExpression_Exp();

		/**
		 * The meta object literal for the '{@link org.yakindu.base.generator.generator.Visibility <em>Visibility</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.base.generator.generator.Visibility
		 * @see org.yakindu.base.generator.generator.impl.generatorPackageImpl#getVisibility()
		 * @generated
		 */
		EEnum VISIBILITY = eINSTANCE.getVisibility();

	}

} //generatorPackage
