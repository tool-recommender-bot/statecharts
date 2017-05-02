/**
 */
package org.yakindu.base.generator.generator.tests;

import junit.textui.TestRunner;

import org.yakindu.base.generator.generator.LineBasedCodeElement;
import org.yakindu.base.generator.generator.generatorFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Line Based Code Element</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class LineBasedCodeElementTest extends CodeElementTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(LineBasedCodeElementTest.class);
	}

	/**
	 * Constructs a new Line Based Code Element test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LineBasedCodeElementTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Line Based Code Element test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected LineBasedCodeElement getFixture() {
		return (LineBasedCodeElement)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(generatorFactory.eINSTANCE.createLineBasedCodeElement());
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

} //LineBasedCodeElementTest
