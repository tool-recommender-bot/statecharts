/**
 */
package org.yakindu.base.generator.generator.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.yakindu.base.base.DocumentedElement;
import org.yakindu.base.base.NamedElement;

import org.yakindu.base.generator.generator.*;

import org.yakindu.base.types.TypedElement;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.yakindu.base.generator.generator.GeneratorPackage
 * @generated
 */
public class GeneratorSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static GeneratorPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneratorSwitch() {
		if (modelPackage == null) {
			modelPackage = GeneratorPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case GeneratorPackage.CODE_ELEMENT: {
				CodeElement codeElement = (CodeElement)theEObject;
				T result = caseCodeElement(codeElement);
				if (result == null) result = caseNamedElement(codeElement);
				if (result == null) result = caseDocumentedElement(codeElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratorPackage.SOURCE_FILE_GEN: {
				SourceFileGen sourceFileGen = (SourceFileGen)theEObject;
				T result = caseSourceFileGen(sourceFileGen);
				if (result == null) result = caseCodeElement(sourceFileGen);
				if (result == null) result = caseNamedElement(sourceFileGen);
				if (result == null) result = caseDocumentedElement(sourceFileGen);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratorPackage.CLASS_GEN: {
				ClassGen classGen = (ClassGen)theEObject;
				T result = caseClassGen(classGen);
				if (result == null) result = caseCodeElement(classGen);
				if (result == null) result = caseAccessRestricted(classGen);
				if (result == null) result = caseNamedElement(classGen);
				if (result == null) result = caseDocumentedElement(classGen);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratorPackage.CLASS_DECLARATION_GEN: {
				ClassDeclarationGen classDeclarationGen = (ClassDeclarationGen)theEObject;
				T result = caseClassDeclarationGen(classDeclarationGen);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratorPackage.INTERFACE_GEN: {
				InterfaceGen interfaceGen = (InterfaceGen)theEObject;
				T result = caseInterfaceGen(interfaceGen);
				if (result == null) result = caseCodeElement(interfaceGen);
				if (result == null) result = caseAccessRestricted(interfaceGen);
				if (result == null) result = caseNamedElement(interfaceGen);
				if (result == null) result = caseDocumentedElement(interfaceGen);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratorPackage.METHOD_GEN: {
				MethodGen methodGen = (MethodGen)theEObject;
				T result = caseMethodGen(methodGen);
				if (result == null) result = caseCodeElement(methodGen);
				if (result == null) result = caseAccessRestricted(methodGen);
				if (result == null) result = caseNamedElement(methodGen);
				if (result == null) result = caseDocumentedElement(methodGen);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratorPackage.METHOD_DECLARATION_GEN: {
				MethodDeclarationGen methodDeclarationGen = (MethodDeclarationGen)theEObject;
				T result = caseMethodDeclarationGen(methodDeclarationGen);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratorPackage.ACCESS_RESTRICTED: {
				AccessRestricted accessRestricted = (AccessRestricted)theEObject;
				T result = caseAccessRestricted(accessRestricted);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratorPackage.VARIABLE_GEN: {
				VariableGen variableGen = (VariableGen)theEObject;
				T result = caseVariableGen(variableGen);
				if (result == null) result = caseCodeElement(variableGen);
				if (result == null) result = caseAccessRestricted(variableGen);
				if (result == null) result = caseTypedElement(variableGen);
				if (result == null) result = caseNamedElement(variableGen);
				if (result == null) result = caseDocumentedElement(variableGen);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratorPackage.PARAMETER_GEN: {
				ParameterGen parameterGen = (ParameterGen)theEObject;
				T result = caseParameterGen(parameterGen);
				if (result == null) result = caseCodeElement(parameterGen);
				if (result == null) result = caseTypedElement(parameterGen);
				if (result == null) result = caseNamedElement(parameterGen);
				if (result == null) result = caseDocumentedElement(parameterGen);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case GeneratorPackage.ABSTRACTABLE_ELEMENT: {
				AbstractableElement abstractableElement = (AbstractableElement)theEObject;
				T result = caseAbstractableElement(abstractableElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Code Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Code Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCodeElement(CodeElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Source File Gen</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Source File Gen</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSourceFileGen(SourceFileGen object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class Gen</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class Gen</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassGen(ClassGen object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class Declaration Gen</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class Declaration Gen</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassDeclarationGen(ClassDeclarationGen object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Interface Gen</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Interface Gen</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInterfaceGen(InterfaceGen object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Method Gen</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Method Gen</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMethodGen(MethodGen object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Method Declaration Gen</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Method Declaration Gen</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMethodDeclarationGen(MethodDeclarationGen object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Access Restricted</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Access Restricted</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAccessRestricted(AccessRestricted object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Gen</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Gen</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableGen(VariableGen object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter Gen</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter Gen</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameterGen(ParameterGen object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstractable Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstractable Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractableElement(AbstractableElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElement(NamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Documented Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Documented Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDocumentedElement(DocumentedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Typed Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Typed Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypedElement(TypedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //GeneratorSwitch
