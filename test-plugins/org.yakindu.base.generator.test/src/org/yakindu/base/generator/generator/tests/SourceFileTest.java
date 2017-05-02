/**
 */
package org.yakindu.base.generator.generator.tests;

import junit.textui.TestRunner;

import org.yakindu.base.generator.generator.SourceFile;
import org.yakindu.base.generator.generator.generatorFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Source File</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class SourceFileTest extends CodeElementTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SourceFileTest.class);
	}

	/**
	 * Constructs a new Source File test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceFileTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Source File test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected SourceFile getFixture() {
		return (SourceFile)fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(generatorFactory.eINSTANCE.createSourceFile());
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

} //SourceFileTest
