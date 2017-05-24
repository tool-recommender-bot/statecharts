/**
 */
package org.yakindu.base.generator.generator;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.yakindu.base.generator.generator.GeneratorPackage
 * @generated
 */
public interface GeneratorFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GeneratorFactory eINSTANCE = org.yakindu.base.generator.generator.impl.GeneratorFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Code Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Code Element</em>'.
	 * @generated
	 */
	CodeElement createCodeElement();

	/**
	 * Returns a new object of class '<em>Source File Gen</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Source File Gen</em>'.
	 * @generated
	 */
	SourceFileGen createSourceFileGen();

	/**
	 * Returns a new object of class '<em>Class Gen</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Class Gen</em>'.
	 * @generated
	 */
	ClassGen createClassGen();

	/**
	 * Returns a new object of class '<em>Class Declaration Gen</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Class Declaration Gen</em>'.
	 * @generated
	 */
	ClassDeclarationGen createClassDeclarationGen();

	/**
	 * Returns a new object of class '<em>Interface Gen</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Interface Gen</em>'.
	 * @generated
	 */
	InterfaceGen createInterfaceGen();

	/**
	 * Returns a new object of class '<em>Method Gen</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Method Gen</em>'.
	 * @generated
	 */
	MethodGen createMethodGen();

	/**
	 * Returns a new object of class '<em>Method Declaration Gen</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Method Declaration Gen</em>'.
	 * @generated
	 */
	MethodDeclarationGen createMethodDeclarationGen();

	/**
	 * Returns a new object of class '<em>Access Restricted</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Access Restricted</em>'.
	 * @generated
	 */
	AccessRestricted createAccessRestricted();

	/**
	 * Returns a new object of class '<em>Variable Gen</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable Gen</em>'.
	 * @generated
	 */
	VariableGen createVariableGen();

	/**
	 * Returns a new object of class '<em>Parameter Gen</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parameter Gen</em>'.
	 * @generated
	 */
	ParameterGen createParameterGen();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	GeneratorPackage getGeneratorPackage();

} //GeneratorFactory
