/**
 */
package org.yakindu.base.generator.generator.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.yakindu.base.generator.generator.BlockBasedCodeElement;
import org.yakindu.base.generator.generator.ClassDeclaration;
import org.yakindu.base.generator.generator.ClassMember;
import org.yakindu.base.generator.generator.CodeElement;
import org.yakindu.base.generator.generator.CodeExpression;
import org.yakindu.base.generator.generator.Comment;
import org.yakindu.base.generator.generator.LineBasedCodeElement;
import org.yakindu.base.generator.generator.Method;
import org.yakindu.base.generator.generator.MethodDeclaration;
import org.yakindu.base.generator.generator.SourceFile;
import org.yakindu.base.generator.generator.Variable;
import org.yakindu.base.generator.generator.VariableDeclaration;
import org.yakindu.base.generator.generator.VisibilityOwner;
import org.yakindu.base.generator.generator.generatorPackage;

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
 * @see org.yakindu.base.generator.generator.generatorPackage
 * @generated
 */
public class generatorSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static generatorPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public generatorSwitch() {
		if (modelPackage == null) {
			modelPackage = generatorPackage.eINSTANCE;
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
			case generatorPackage.CODE_ELEMENT: {
				CodeElement codeElement = (CodeElement)theEObject;
				T result = caseCodeElement(codeElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case generatorPackage.LINE_BASED_CODE_ELEMENT: {
				LineBasedCodeElement lineBasedCodeElement = (LineBasedCodeElement)theEObject;
				T result = caseLineBasedCodeElement(lineBasedCodeElement);
				if (result == null) result = caseCodeElement(lineBasedCodeElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case generatorPackage.BLOCK_BASED_CODE_ELEMENT: {
				BlockBasedCodeElement blockBasedCodeElement = (BlockBasedCodeElement)theEObject;
				T result = caseBlockBasedCodeElement(blockBasedCodeElement);
				if (result == null) result = caseCodeElement(blockBasedCodeElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case generatorPackage.CLASS: {
				org.yakindu.base.generator.generator.Class class_ = (org.yakindu.base.generator.generator.Class)theEObject;
				T result = caseClass(class_);
				if (result == null) result = caseBlockBasedCodeElement(class_);
				if (result == null) result = caseVisibilityOwner(class_);
				if (result == null) result = caseCodeElement(class_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case generatorPackage.CLASS_DECLARATION: {
				ClassDeclaration classDeclaration = (ClassDeclaration)theEObject;
				T result = caseClassDeclaration(classDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case generatorPackage.METHOD: {
				Method method = (Method)theEObject;
				T result = caseMethod(method);
				if (result == null) result = caseBlockBasedCodeElement(method);
				if (result == null) result = caseClassMember(method);
				if (result == null) result = caseCodeElement(method);
				if (result == null) result = caseVisibilityOwner(method);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case generatorPackage.METHOD_DECLARATION: {
				MethodDeclaration methodDeclaration = (MethodDeclaration)theEObject;
				T result = caseMethodDeclaration(methodDeclaration);
				if (result == null) result = caseLineBasedCodeElement(methodDeclaration);
				if (result == null) result = caseCodeElement(methodDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case generatorPackage.CLASS_MEMBER: {
				ClassMember classMember = (ClassMember)theEObject;
				T result = caseClassMember(classMember);
				if (result == null) result = caseVisibilityOwner(classMember);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case generatorPackage.VISIBILITY_OWNER: {
				VisibilityOwner visibilityOwner = (VisibilityOwner)theEObject;
				T result = caseVisibilityOwner(visibilityOwner);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case generatorPackage.VARIABLE: {
				Variable variable = (Variable)theEObject;
				T result = caseVariable(variable);
				if (result == null) result = caseClassMember(variable);
				if (result == null) result = caseVisibilityOwner(variable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case generatorPackage.VARIABLE_DECLARATION: {
				VariableDeclaration variableDeclaration = (VariableDeclaration)theEObject;
				T result = caseVariableDeclaration(variableDeclaration);
				if (result == null) result = caseLineBasedCodeElement(variableDeclaration);
				if (result == null) result = caseCodeElement(variableDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case generatorPackage.COMMENT: {
				Comment comment = (Comment)theEObject;
				T result = caseComment(comment);
				if (result == null) result = caseLineBasedCodeElement(comment);
				if (result == null) result = caseCodeElement(comment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case generatorPackage.SOURCE_FILE: {
				SourceFile sourceFile = (SourceFile)theEObject;
				T result = caseSourceFile(sourceFile);
				if (result == null) result = caseCodeElement(sourceFile);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case generatorPackage.CODE_EXPRESSION: {
				CodeExpression codeExpression = (CodeExpression)theEObject;
				T result = caseCodeExpression(codeExpression);
				if (result == null) result = caseLineBasedCodeElement(codeExpression);
				if (result == null) result = caseCodeElement(codeExpression);
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
	 * Returns the result of interpreting the object as an instance of '<em>Line Based Code Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Line Based Code Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLineBasedCodeElement(LineBasedCodeElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Block Based Code Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Block Based Code Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBlockBasedCodeElement(BlockBasedCodeElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClass(org.yakindu.base.generator.generator.Class object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassDeclaration(ClassDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Method</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Method</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMethod(Method object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Method Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Method Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMethodDeclaration(MethodDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class Member</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class Member</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassMember(ClassMember object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Visibility Owner</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Visibility Owner</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVisibilityOwner(VisibilityOwner object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariable(Variable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableDeclaration(VariableDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Comment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Comment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComment(Comment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Source File</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Source File</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSourceFile(SourceFile object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Code Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Code Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCodeExpression(CodeExpression object) {
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

} //generatorSwitch
