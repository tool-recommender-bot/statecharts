/**
 */
package org.yakindu.base.generator.generator.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.yakindu.base.base.BasePackage;

import org.yakindu.base.expressions.expressions.ExpressionsPackage;
import org.yakindu.base.generator.generator.AbstractableElement;
import org.yakindu.base.generator.generator.AccessRestricted;
import org.yakindu.base.generator.generator.ClassDeclarationGen;
import org.yakindu.base.generator.generator.ClassGen;
import org.yakindu.base.generator.generator.CodeElement;
import org.yakindu.base.generator.generator.Declarable;
import org.yakindu.base.generator.generator.Declaration;
import org.yakindu.base.generator.generator.ExpressionGen;
import org.yakindu.base.generator.generator.GeneratorFactory;
import org.yakindu.base.generator.generator.GeneratorPackage;
import org.yakindu.base.generator.generator.InterfaceGen;
import org.yakindu.base.generator.generator.MethodDeclarationGen;
import org.yakindu.base.generator.generator.MethodGen;
import org.yakindu.base.generator.generator.ParameterGen;
import org.yakindu.base.generator.generator.SourceFileGen;
import org.yakindu.base.generator.generator.VariableDeclarationGen;
import org.yakindu.base.generator.generator.VariableGen;
import org.yakindu.base.generator.generator.VisibilityValues;
import org.yakindu.base.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GeneratorPackageImpl extends EPackageImpl implements GeneratorPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass codeElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sourceFileGenEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classGenEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classDeclarationGenEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass interfaceGenEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass methodGenEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass methodDeclarationGenEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass accessRestrictedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableGenEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableDeclarationGenEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterGenEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractableElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expressionGenEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass declarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass declarableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum visibilityValuesEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.yakindu.base.generator.generator.GeneratorPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private GeneratorPackageImpl() {
		super(eNS_URI, GeneratorFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link GeneratorPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static GeneratorPackage init() {
		if (isInited) return (GeneratorPackage)EPackage.Registry.INSTANCE.getEPackage(GeneratorPackage.eNS_URI);

		// Obtain or create and register package
		GeneratorPackageImpl theGeneratorPackage = (GeneratorPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof GeneratorPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new GeneratorPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ExpressionsPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theGeneratorPackage.createPackageContents();

		// Initialize created meta-data
		theGeneratorPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theGeneratorPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(GeneratorPackage.eNS_URI, theGeneratorPackage);
		return theGeneratorPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCodeElement() {
		return codeElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCodeElement_Children() {
		return (EReference)codeElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCodeElement_Parent() {
		return (EReference)codeElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSourceFileGen() {
		return sourceFileGenEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSourceFileGen_Package() {
		return (EAttribute)sourceFileGenEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSourceFileGen_Imports() {
		return (EAttribute)sourceFileGenEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassGen() {
		return classGenEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassGen_SuperClass() {
		return (EReference)classGenEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassGen_Implements() {
		return (EReference)classGenEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassGen_Declaration() {
		return (EReference)classGenEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassDeclarationGen() {
		return classDeclarationGenEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassDeclarationGen_ClassGen() {
		return (EReference)classDeclarationGenEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInterfaceGen() {
		return interfaceGenEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterfaceGen_SuperClass() {
		return (EReference)interfaceGenEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMethodGen() {
		return methodGenEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMethodGen_Parameters() {
		return (EReference)methodGenEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMethodGen_ReturnType() {
		return (EReference)methodGenEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMethodGen_Declaration() {
		return (EReference)methodGenEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMethodDeclarationGen() {
		return methodDeclarationGenEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMethodDeclarationGen_MethodGen() {
		return (EReference)methodDeclarationGenEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAccessRestricted() {
		return accessRestrictedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAccessRestricted_Visibility() {
		return (EAttribute)accessRestrictedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariableGen() {
		return variableGenEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableGen_Declaration() {
		return (EReference)variableGenEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariableDeclarationGen() {
		return variableDeclarationGenEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableDeclarationGen_VariableGen() {
		return (EReference)variableDeclarationGenEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameterGen() {
		return parameterGenEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractableElement() {
		return abstractableElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractableElement_Abstract() {
		return (EAttribute)abstractableElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExpressionGen() {
		return expressionGenEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExpressionGen_Expression() {
		return (EReference)expressionGenEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeclaration() {
		return declarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeclarable() {
		return declarableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getVisibilityValues() {
		return visibilityValuesEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneratorFactory getGeneratorFactory() {
		return (GeneratorFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		codeElementEClass = createEClass(CODE_ELEMENT);
		createEReference(codeElementEClass, CODE_ELEMENT__CHILDREN);
		createEReference(codeElementEClass, CODE_ELEMENT__PARENT);

		sourceFileGenEClass = createEClass(SOURCE_FILE_GEN);
		createEAttribute(sourceFileGenEClass, SOURCE_FILE_GEN__PACKAGE);
		createEAttribute(sourceFileGenEClass, SOURCE_FILE_GEN__IMPORTS);

		classGenEClass = createEClass(CLASS_GEN);
		createEReference(classGenEClass, CLASS_GEN__SUPER_CLASS);
		createEReference(classGenEClass, CLASS_GEN__IMPLEMENTS);
		createEReference(classGenEClass, CLASS_GEN__DECLARATION);

		classDeclarationGenEClass = createEClass(CLASS_DECLARATION_GEN);
		createEReference(classDeclarationGenEClass, CLASS_DECLARATION_GEN__CLASS_GEN);

		interfaceGenEClass = createEClass(INTERFACE_GEN);
		createEReference(interfaceGenEClass, INTERFACE_GEN__SUPER_CLASS);

		methodGenEClass = createEClass(METHOD_GEN);
		createEReference(methodGenEClass, METHOD_GEN__PARAMETERS);
		createEReference(methodGenEClass, METHOD_GEN__RETURN_TYPE);
		createEReference(methodGenEClass, METHOD_GEN__DECLARATION);

		methodDeclarationGenEClass = createEClass(METHOD_DECLARATION_GEN);
		createEReference(methodDeclarationGenEClass, METHOD_DECLARATION_GEN__METHOD_GEN);

		accessRestrictedEClass = createEClass(ACCESS_RESTRICTED);
		createEAttribute(accessRestrictedEClass, ACCESS_RESTRICTED__VISIBILITY);

		variableGenEClass = createEClass(VARIABLE_GEN);
		createEReference(variableGenEClass, VARIABLE_GEN__DECLARATION);

		variableDeclarationGenEClass = createEClass(VARIABLE_DECLARATION_GEN);
		createEReference(variableDeclarationGenEClass, VARIABLE_DECLARATION_GEN__VARIABLE_GEN);

		parameterGenEClass = createEClass(PARAMETER_GEN);

		abstractableElementEClass = createEClass(ABSTRACTABLE_ELEMENT);
		createEAttribute(abstractableElementEClass, ABSTRACTABLE_ELEMENT__ABSTRACT);

		expressionGenEClass = createEClass(EXPRESSION_GEN);
		createEReference(expressionGenEClass, EXPRESSION_GEN__EXPRESSION);

		declarationEClass = createEClass(DECLARATION);

		declarableEClass = createEClass(DECLARABLE);

		// Create enums
		visibilityValuesEEnum = createEEnum(VISIBILITY_VALUES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		BasePackage theBasePackage = (BasePackage)EPackage.Registry.INSTANCE.getEPackage(BasePackage.eNS_URI);
		TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);
		ExpressionsPackage theExpressionsPackage = (ExpressionsPackage)EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		codeElementEClass.getESuperTypes().add(theBasePackage.getNamedElement());
		codeElementEClass.getESuperTypes().add(theBasePackage.getDocumentedElement());
		sourceFileGenEClass.getESuperTypes().add(this.getCodeElement());
		classGenEClass.getESuperTypes().add(this.getCodeElement());
		classGenEClass.getESuperTypes().add(this.getAccessRestricted());
		classGenEClass.getESuperTypes().add(this.getAbstractableElement());
		classGenEClass.getESuperTypes().add(this.getDeclarable());
		classDeclarationGenEClass.getESuperTypes().add(this.getDeclaration());
		interfaceGenEClass.getESuperTypes().add(this.getCodeElement());
		interfaceGenEClass.getESuperTypes().add(this.getAccessRestricted());
		methodGenEClass.getESuperTypes().add(this.getCodeElement());
		methodGenEClass.getESuperTypes().add(this.getAccessRestricted());
		methodGenEClass.getESuperTypes().add(this.getAbstractableElement());
		methodGenEClass.getESuperTypes().add(this.getDeclarable());
		methodDeclarationGenEClass.getESuperTypes().add(this.getDeclaration());
		variableGenEClass.getESuperTypes().add(this.getCodeElement());
		variableGenEClass.getESuperTypes().add(this.getAccessRestricted());
		variableGenEClass.getESuperTypes().add(theTypesPackage.getTypedElement());
		variableGenEClass.getESuperTypes().add(this.getDeclarable());
		variableDeclarationGenEClass.getESuperTypes().add(this.getDeclaration());
		parameterGenEClass.getESuperTypes().add(this.getCodeElement());
		parameterGenEClass.getESuperTypes().add(theTypesPackage.getTypedElement());
		expressionGenEClass.getESuperTypes().add(this.getCodeElement());
		declarationEClass.getESuperTypes().add(this.getCodeElement());

		// Initialize classes and features; add operations and parameters
		initEClass(codeElementEClass, CodeElement.class, "CodeElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCodeElement_Children(), this.getCodeElement(), this.getCodeElement_Parent(), "children", null, 0, -1, CodeElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCodeElement_Parent(), this.getCodeElement(), this.getCodeElement_Children(), "parent", null, 0, 1, CodeElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sourceFileGenEClass, SourceFileGen.class, "SourceFileGen", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSourceFileGen_Package(), ecorePackage.getEString(), "package", null, 0, 1, SourceFileGen.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSourceFileGen_Imports(), ecorePackage.getEString(), "imports", null, 0, -1, SourceFileGen.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(classGenEClass, ClassGen.class, "ClassGen", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClassGen_SuperClass(), this.getClassGen(), null, "superClass", null, 0, 1, ClassGen.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClassGen_Implements(), this.getInterfaceGen(), null, "implements", null, 0, -1, ClassGen.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClassGen_Declaration(), this.getClassDeclarationGen(), this.getClassDeclarationGen_ClassGen(), "declaration", null, 0, 1, ClassGen.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(classDeclarationGenEClass, ClassDeclarationGen.class, "ClassDeclarationGen", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClassDeclarationGen_ClassGen(), this.getClassGen(), this.getClassGen_Declaration(), "classGen", null, 0, 1, ClassDeclarationGen.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(interfaceGenEClass, InterfaceGen.class, "InterfaceGen", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInterfaceGen_SuperClass(), this.getInterfaceGen(), null, "superClass", null, 0, 1, InterfaceGen.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(methodGenEClass, MethodGen.class, "MethodGen", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMethodGen_Parameters(), this.getParameterGen(), null, "parameters", null, 0, -1, MethodGen.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMethodGen_ReturnType(), theTypesPackage.getTypeSpecifier(), null, "returnType", null, 0, 1, MethodGen.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMethodGen_Declaration(), this.getMethodDeclarationGen(), this.getMethodDeclarationGen_MethodGen(), "declaration", null, 0, 1, MethodGen.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(methodDeclarationGenEClass, MethodDeclarationGen.class, "MethodDeclarationGen", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMethodDeclarationGen_MethodGen(), this.getMethodGen(), this.getMethodGen_Declaration(), "methodGen", null, 0, 1, MethodDeclarationGen.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(accessRestrictedEClass, AccessRestricted.class, "AccessRestricted", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAccessRestricted_Visibility(), this.getVisibilityValues(), "visibility", "NONE", 0, 1, AccessRestricted.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variableGenEClass, VariableGen.class, "VariableGen", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVariableGen_Declaration(), this.getVariableDeclarationGen(), this.getVariableDeclarationGen_VariableGen(), "declaration", null, 0, 1, VariableGen.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variableDeclarationGenEClass, VariableDeclarationGen.class, "VariableDeclarationGen", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVariableDeclarationGen_VariableGen(), this.getVariableGen(), this.getVariableGen_Declaration(), "variableGen", null, 0, 1, VariableDeclarationGen.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parameterGenEClass, ParameterGen.class, "ParameterGen", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(abstractableElementEClass, AbstractableElement.class, "AbstractableElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractableElement_Abstract(), ecorePackage.getEBoolean(), "abstract", "false", 0, 1, AbstractableElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(expressionGenEClass, ExpressionGen.class, "ExpressionGen", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExpressionGen_Expression(), theExpressionsPackage.getExpression(), null, "expression", null, 0, 1, ExpressionGen.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(declarationEClass, Declaration.class, "Declaration", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(declarableEClass, Declarable.class, "Declarable", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(visibilityValuesEEnum, VisibilityValues.class, "VisibilityValues");
		addEEnumLiteral(visibilityValuesEEnum, VisibilityValues.NONE);
		addEEnumLiteral(visibilityValuesEEnum, VisibilityValues.PUBLIC);
		addEEnumLiteral(visibilityValuesEEnum, VisibilityValues.PROTECTED);
		addEEnumLiteral(visibilityValuesEEnum, VisibilityValues.PRIVATE);

		// Create resource
		createResource(eNS_URI);
	}

} //GeneratorPackageImpl
