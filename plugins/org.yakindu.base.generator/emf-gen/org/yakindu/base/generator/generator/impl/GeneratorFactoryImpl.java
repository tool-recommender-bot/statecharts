/**
 */
package org.yakindu.base.generator.generator.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.yakindu.base.generator.generator.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GeneratorFactoryImpl extends EFactoryImpl implements GeneratorFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static GeneratorFactory init() {
		try {
			GeneratorFactory theGeneratorFactory = (GeneratorFactory)EPackage.Registry.INSTANCE.getEFactory(GeneratorPackage.eNS_URI);
			if (theGeneratorFactory != null) {
				return theGeneratorFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new GeneratorFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneratorFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case GeneratorPackage.CODE_ELEMENT: return createCodeElement();
			case GeneratorPackage.SOURCE_FILE_GEN: return createSourceFileGen();
			case GeneratorPackage.CLASS_GEN: return createClassGen();
			case GeneratorPackage.METHOD_GEN: return createMethodGen();
			case GeneratorPackage.ACCESS_RESTRICTED: return createAccessRestricted();
			case GeneratorPackage.VARIABLE_GEN: return createVariableGen();
			case GeneratorPackage.PARAMETER_GEN: return createParameterGen();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodeElement createCodeElement() {
		CodeElementImpl codeElement = new CodeElementImpl();
		return codeElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceFileGen createSourceFileGen() {
		SourceFileGenImpl sourceFileGen = new SourceFileGenImpl();
		return sourceFileGen;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassGen createClassGen() {
		ClassGenImpl classGen = new ClassGenImpl();
		return classGen;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MethodGen createMethodGen() {
		MethodGenImpl methodGen = new MethodGenImpl();
		return methodGen;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AccessRestricted createAccessRestricted() {
		AccessRestrictedImpl accessRestricted = new AccessRestrictedImpl();
		return accessRestricted;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableGen createVariableGen() {
		VariableGenImpl variableGen = new VariableGenImpl();
		return variableGen;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterGen createParameterGen() {
		ParameterGenImpl parameterGen = new ParameterGenImpl();
		return parameterGen;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneratorPackage getGeneratorPackage() {
		return (GeneratorPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static GeneratorPackage getPackage() {
		return GeneratorPackage.eINSTANCE;
	}

} //GeneratorFactoryImpl
