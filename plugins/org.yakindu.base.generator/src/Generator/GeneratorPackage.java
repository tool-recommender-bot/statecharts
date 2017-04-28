/**
 */
package Generator;

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
 * @see Generator.GeneratorFactory
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
	String eNAME = "Generator";

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
	String eNS_PREFIX = "Generator";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GeneratorPackage eINSTANCE = Generator.impl.GeneratorPackageImpl.init();

	/**
	 * The meta object id for the '{@link Generator.impl.CodeElementImpl <em>Code Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Generator.impl.CodeElementImpl
	 * @see Generator.impl.GeneratorPackageImpl#getCodeElement()
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
	 * The meta object id for the '{@link Generator.impl.LineBasedCodeElementImpl <em>Line Based Code Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Generator.impl.LineBasedCodeElementImpl
	 * @see Generator.impl.GeneratorPackageImpl#getLineBasedCodeElement()
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
	 * The meta object id for the '{@link Generator.impl.BlockBasedCodeElementImpl <em>Block Based Code Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Generator.impl.BlockBasedCodeElementImpl
	 * @see Generator.impl.GeneratorPackageImpl#getBlockBasedCodeElement()
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
	 * The meta object id for the '{@link Generator.impl.ClassImpl <em>Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Generator.impl.ClassImpl
	 * @see Generator.impl.GeneratorPackageImpl#getClass_()
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
	 * The number of structural features of the '<em>Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_FEATURE_COUNT = BLOCK_BASED_CODE_ELEMENT_FEATURE_COUNT + 1;

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
	 * The meta object id for the '{@link Generator.impl.ClassDeclarationImpl <em>Class Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Generator.impl.ClassDeclarationImpl
	 * @see Generator.impl.GeneratorPackageImpl#getClassDeclaration()
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
	 * The meta object id for the '{@link Generator.impl.MethodImpl <em>Method</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Generator.impl.MethodImpl
	 * @see Generator.impl.GeneratorPackageImpl#getMethod()
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
	 * The number of structural features of the '<em>Method</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_FEATURE_COUNT = BLOCK_BASED_CODE_ELEMENT_FEATURE_COUNT + 1;

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
	 * The meta object id for the '{@link Generator.impl.MethodDeclarationImpl <em>Method Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Generator.impl.MethodDeclarationImpl
	 * @see Generator.impl.GeneratorPackageImpl#getMethodDeclaration()
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
	 * The meta object id for the '{@link Generator.impl.VisibilityOwnerImpl <em>Visibility Owner</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Generator.impl.VisibilityOwnerImpl
	 * @see Generator.impl.GeneratorPackageImpl#getVisibilityOwner()
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
	 * The meta object id for the '{@link Generator.impl.ClassMemberImpl <em>Class Member</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Generator.impl.ClassMemberImpl
	 * @see Generator.impl.GeneratorPackageImpl#getClassMember()
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
	 * The meta object id for the '{@link Generator.impl.VariableImpl <em>Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Generator.impl.VariableImpl
	 * @see Generator.impl.GeneratorPackageImpl#getVariable()
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
	 * The meta object id for the '{@link Generator.impl.VariableDeclarationImpl <em>Variable Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Generator.impl.VariableDeclarationImpl
	 * @see Generator.impl.GeneratorPackageImpl#getVariableDeclaration()
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
	 * The meta object id for the '{@link Generator.impl.CommentImpl <em>Comment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Generator.impl.CommentImpl
	 * @see Generator.impl.GeneratorPackageImpl#getComment()
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
	 * The meta object id for the '{@link Generator.impl.SourceFileImpl <em>Source File</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Generator.impl.SourceFileImpl
	 * @see Generator.impl.GeneratorPackageImpl#getSourceFile()
	 * @generated
	 */
	int SOURCE_FILE = 12;

	/**
	 * The number of structural features of the '<em>Source File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_FILE_FEATURE_COUNT = CODE_ELEMENT_FEATURE_COUNT + 0;

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
	 * The meta object id for the '{@link Generator.Visibility <em>Visibility</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see Generator.Visibility
	 * @see Generator.impl.GeneratorPackageImpl#getVisibility()
	 * @generated
	 */
	int VISIBILITY = 13;


	/**
	 * Returns the meta object for class '{@link Generator.CodeElement <em>Code Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Code Element</em>'.
	 * @see Generator.CodeElement
	 * @generated
	 */
	EClass getCodeElement();

	/**
	 * Returns the meta object for the '{@link Generator.CodeElement#generate() <em>Generate</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Generate</em>' operation.
	 * @see Generator.CodeElement#generate()
	 * @generated
	 */
	EOperation getCodeElement__Generate();

	/**
	 * Returns the meta object for class '{@link Generator.LineBasedCodeElement <em>Line Based Code Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Line Based Code Element</em>'.
	 * @see Generator.LineBasedCodeElement
	 * @generated
	 */
	EClass getLineBasedCodeElement();

	/**
	 * Returns the meta object for class '{@link Generator.BlockBasedCodeElement <em>Block Based Code Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Block Based Code Element</em>'.
	 * @see Generator.BlockBasedCodeElement
	 * @generated
	 */
	EClass getBlockBasedCodeElement();

	/**
	 * Returns the meta object for the reference list '{@link Generator.BlockBasedCodeElement#getContents <em>Contents</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Contents</em>'.
	 * @see Generator.BlockBasedCodeElement#getContents()
	 * @see #getBlockBasedCodeElement()
	 * @generated
	 */
	EReference getBlockBasedCodeElement_Contents();

	/**
	 * Returns the meta object for the '{@link Generator.BlockBasedCodeElement#generateBlockHeader() <em>Generate Block Header</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Generate Block Header</em>' operation.
	 * @see Generator.BlockBasedCodeElement#generateBlockHeader()
	 * @generated
	 */
	EOperation getBlockBasedCodeElement__GenerateBlockHeader();

	/**
	 * Returns the meta object for the '{@link Generator.BlockBasedCodeElement#generateBlockStart() <em>Generate Block Start</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Generate Block Start</em>' operation.
	 * @see Generator.BlockBasedCodeElement#generateBlockStart()
	 * @generated
	 */
	EOperation getBlockBasedCodeElement__GenerateBlockStart();

	/**
	 * Returns the meta object for the '{@link Generator.BlockBasedCodeElement#generateBlockEnd() <em>Generate Block End</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Generate Block End</em>' operation.
	 * @see Generator.BlockBasedCodeElement#generateBlockEnd()
	 * @generated
	 */
	EOperation getBlockBasedCodeElement__GenerateBlockEnd();

	/**
	 * Returns the meta object for the '{@link Generator.BlockBasedCodeElement#generateBlockContents() <em>Generate Block Contents</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Generate Block Contents</em>' operation.
	 * @see Generator.BlockBasedCodeElement#generateBlockContents()
	 * @generated
	 */
	EOperation getBlockBasedCodeElement__GenerateBlockContents();

	/**
	 * Returns the meta object for class '{@link Generator.Class <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class</em>'.
	 * @see Generator.Class
	 * @generated
	 */
	EClass getClass_();

	/**
	 * Returns the meta object for class '{@link Generator.ClassDeclaration <em>Class Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class Declaration</em>'.
	 * @see Generator.ClassDeclaration
	 * @generated
	 */
	EClass getClassDeclaration();

	/**
	 * Returns the meta object for the reference '{@link Generator.ClassDeclaration#getParentClass <em>Parent Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent Class</em>'.
	 * @see Generator.ClassDeclaration#getParentClass()
	 * @see #getClassDeclaration()
	 * @generated
	 */
	EReference getClassDeclaration_ParentClass();

	/**
	 * Returns the meta object for class '{@link Generator.Method <em>Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Method</em>'.
	 * @see Generator.Method
	 * @generated
	 */
	EClass getMethod();

	/**
	 * Returns the meta object for class '{@link Generator.MethodDeclaration <em>Method Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Method Declaration</em>'.
	 * @see Generator.MethodDeclaration
	 * @generated
	 */
	EClass getMethodDeclaration();

	/**
	 * Returns the meta object for the reference '{@link Generator.MethodDeclaration#getParentMethod <em>Parent Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent Method</em>'.
	 * @see Generator.MethodDeclaration#getParentMethod()
	 * @see #getMethodDeclaration()
	 * @generated
	 */
	EReference getMethodDeclaration_ParentMethod();

	/**
	 * Returns the meta object for class '{@link Generator.ClassMember <em>Class Member</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class Member</em>'.
	 * @see Generator.ClassMember
	 * @generated
	 */
	EClass getClassMember();

	/**
	 * Returns the meta object for class '{@link Generator.VisibilityOwner <em>Visibility Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Visibility Owner</em>'.
	 * @see Generator.VisibilityOwner
	 * @generated
	 */
	EClass getVisibilityOwner();

	/**
	 * Returns the meta object for the attribute '{@link Generator.VisibilityOwner#getVisibility <em>Visibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Visibility</em>'.
	 * @see Generator.VisibilityOwner#getVisibility()
	 * @see #getVisibilityOwner()
	 * @generated
	 */
	EAttribute getVisibilityOwner_Visibility();

	/**
	 * Returns the meta object for class '{@link Generator.Variable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable</em>'.
	 * @see Generator.Variable
	 * @generated
	 */
	EClass getVariable();

	/**
	 * Returns the meta object for class '{@link Generator.VariableDeclaration <em>Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Declaration</em>'.
	 * @see Generator.VariableDeclaration
	 * @generated
	 */
	EClass getVariableDeclaration();

	/**
	 * Returns the meta object for the reference '{@link Generator.VariableDeclaration#getParentVariable <em>Parent Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent Variable</em>'.
	 * @see Generator.VariableDeclaration#getParentVariable()
	 * @see #getVariableDeclaration()
	 * @generated
	 */
	EReference getVariableDeclaration_ParentVariable();

	/**
	 * Returns the meta object for class '{@link Generator.Comment <em>Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Comment</em>'.
	 * @see Generator.Comment
	 * @generated
	 */
	EClass getComment();

	/**
	 * Returns the meta object for the attribute '{@link Generator.Comment#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see Generator.Comment#getText()
	 * @see #getComment()
	 * @generated
	 */
	EAttribute getComment_Text();

	/**
	 * Returns the meta object for the '{@link Generator.Comment#generateCommentStart() <em>Generate Comment Start</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Generate Comment Start</em>' operation.
	 * @see Generator.Comment#generateCommentStart()
	 * @generated
	 */
	EOperation getComment__GenerateCommentStart();

	/**
	 * Returns the meta object for the '{@link Generator.Comment#generateCommentEnd() <em>Generate Comment End</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Generate Comment End</em>' operation.
	 * @see Generator.Comment#generateCommentEnd()
	 * @generated
	 */
	EOperation getComment__GenerateCommentEnd();

	/**
	 * Returns the meta object for the '{@link Generator.Comment#generateText() <em>Generate Text</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Generate Text</em>' operation.
	 * @see Generator.Comment#generateText()
	 * @generated
	 */
	EOperation getComment__GenerateText();

	/**
	 * Returns the meta object for class '{@link Generator.SourceFile <em>Source File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Source File</em>'.
	 * @see Generator.SourceFile
	 * @generated
	 */
	EClass getSourceFile();

	/**
	 * Returns the meta object for enum '{@link Generator.Visibility <em>Visibility</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Visibility</em>'.
	 * @see Generator.Visibility
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
		 * The meta object literal for the '{@link Generator.impl.CodeElementImpl <em>Code Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Generator.impl.CodeElementImpl
		 * @see Generator.impl.GeneratorPackageImpl#getCodeElement()
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
		 * The meta object literal for the '{@link Generator.impl.LineBasedCodeElementImpl <em>Line Based Code Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Generator.impl.LineBasedCodeElementImpl
		 * @see Generator.impl.GeneratorPackageImpl#getLineBasedCodeElement()
		 * @generated
		 */
		EClass LINE_BASED_CODE_ELEMENT = eINSTANCE.getLineBasedCodeElement();

		/**
		 * The meta object literal for the '{@link Generator.impl.BlockBasedCodeElementImpl <em>Block Based Code Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Generator.impl.BlockBasedCodeElementImpl
		 * @see Generator.impl.GeneratorPackageImpl#getBlockBasedCodeElement()
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
		 * The meta object literal for the '{@link Generator.impl.ClassImpl <em>Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Generator.impl.ClassImpl
		 * @see Generator.impl.GeneratorPackageImpl#getClass_()
		 * @generated
		 */
		EClass CLASS = eINSTANCE.getClass_();

		/**
		 * The meta object literal for the '{@link Generator.impl.ClassDeclarationImpl <em>Class Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Generator.impl.ClassDeclarationImpl
		 * @see Generator.impl.GeneratorPackageImpl#getClassDeclaration()
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
		 * The meta object literal for the '{@link Generator.impl.MethodImpl <em>Method</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Generator.impl.MethodImpl
		 * @see Generator.impl.GeneratorPackageImpl#getMethod()
		 * @generated
		 */
		EClass METHOD = eINSTANCE.getMethod();

		/**
		 * The meta object literal for the '{@link Generator.impl.MethodDeclarationImpl <em>Method Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Generator.impl.MethodDeclarationImpl
		 * @see Generator.impl.GeneratorPackageImpl#getMethodDeclaration()
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
		 * The meta object literal for the '{@link Generator.impl.ClassMemberImpl <em>Class Member</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Generator.impl.ClassMemberImpl
		 * @see Generator.impl.GeneratorPackageImpl#getClassMember()
		 * @generated
		 */
		EClass CLASS_MEMBER = eINSTANCE.getClassMember();

		/**
		 * The meta object literal for the '{@link Generator.impl.VisibilityOwnerImpl <em>Visibility Owner</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Generator.impl.VisibilityOwnerImpl
		 * @see Generator.impl.GeneratorPackageImpl#getVisibilityOwner()
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
		 * The meta object literal for the '{@link Generator.impl.VariableImpl <em>Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Generator.impl.VariableImpl
		 * @see Generator.impl.GeneratorPackageImpl#getVariable()
		 * @generated
		 */
		EClass VARIABLE = eINSTANCE.getVariable();

		/**
		 * The meta object literal for the '{@link Generator.impl.VariableDeclarationImpl <em>Variable Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Generator.impl.VariableDeclarationImpl
		 * @see Generator.impl.GeneratorPackageImpl#getVariableDeclaration()
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
		 * The meta object literal for the '{@link Generator.impl.CommentImpl <em>Comment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Generator.impl.CommentImpl
		 * @see Generator.impl.GeneratorPackageImpl#getComment()
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
		 * The meta object literal for the '{@link Generator.impl.SourceFileImpl <em>Source File</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Generator.impl.SourceFileImpl
		 * @see Generator.impl.GeneratorPackageImpl#getSourceFile()
		 * @generated
		 */
		EClass SOURCE_FILE = eINSTANCE.getSourceFile();

		/**
		 * The meta object literal for the '{@link Generator.Visibility <em>Visibility</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see Generator.Visibility
		 * @see Generator.impl.GeneratorPackageImpl#getVisibility()
		 * @generated
		 */
		EEnum VISIBILITY = eINSTANCE.getVisibility();

	}

} //GeneratorPackage
