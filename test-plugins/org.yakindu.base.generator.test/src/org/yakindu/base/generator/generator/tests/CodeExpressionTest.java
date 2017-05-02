/**
 */
package org.yakindu.base.generator.generator.tests;

import junit.textui.TestRunner;

import org.yakindu.base.generator.generator.CodeExpression;
import org.yakindu.base.generator.generator.generatorFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Code Expression</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class CodeExpressionTest extends LineBasedCodeElementTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(CodeExpressionTest.class);
	}

	/**
	 * Constructs a new Code Expression test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodeExpressionTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Code Expression test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected CodeExpression getFixture() {
		return (CodeExpression)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(generatorFactory.eINSTANCE.createCodeExpression());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //CodeExpressionTest
