/**
 */
package org.yakindu.base.generator.generator;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.yakindu.base.generator.generator.generatorPackage
 * @generated
 */
public interface generatorFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	generatorFactory eINSTANCE = org.yakindu.base.generator.generator.impl.generatorFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Line Based Code Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Line Based Code Element</em>'.
	 * @generated
	 */
	LineBasedCodeElement createLineBasedCodeElement();

	/**
	 * Returns a new object of class '<em>Class Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Class Declaration</em>'.
	 * @generated
	 */
	ClassDeclaration createClassDeclaration();

	/**
	 * Returns a new object of class '<em>Method Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Method Declaration</em>'.
	 * @generated
	 */
	MethodDeclaration createMethodDeclaration();

	/**
	 * Returns a new object of class '<em>Source File</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Source File</em>'.
	 * @generated
	 */
	SourceFile createSourceFile();

	/**
	 * Returns a new object of class '<em>Code Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Code Expression</em>'.
	 * @generated
	 */
	CodeExpression createCodeExpression();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	generatorPackage getgeneratorPackage();

} //generatorFactory
