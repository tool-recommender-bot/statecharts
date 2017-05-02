/**
 */
package org.yakindu.base.generator.generator.impl;

import java.lang.reflect.InvocationTargetException;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.yakindu.base.generator.generator.BlockBasedCodeElement;
import org.yakindu.base.generator.generator.CodeElement;
import org.yakindu.base.generator.generator.generatorPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Block Based Code Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.base.generator.generator.impl.BlockBasedCodeElementImpl#getContents <em>Contents</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class BlockBasedCodeElementImpl extends CodeElementImpl implements BlockBasedCodeElement {
	/**
	 * The cached value of the '{@link #getContents() <em>Contents</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContents()
	 * @generated
	 * @ordered
	 */
	protected EList<CodeElement> contents;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BlockBasedCodeElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return generatorPackage.Literals.BLOCK_BASED_CODE_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CodeElement> getContents() {
		if (contents == null) {
			contents = new EObjectResolvingEList<CodeElement>(CodeElement.class, this, generatorPackage.BLOCK_BASED_CODE_ELEMENT__CONTENTS);
		}
		return contents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String generateBlockHeader() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String generateBlockStart() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String generateBlockEnd() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String generateBlockContents() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case generatorPackage.BLOCK_BASED_CODE_ELEMENT__CONTENTS:
				return getContents();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case generatorPackage.BLOCK_BASED_CODE_ELEMENT__CONTENTS:
				getContents().clear();
				getContents().addAll((Collection<? extends CodeElement>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case generatorPackage.BLOCK_BASED_CODE_ELEMENT__CONTENTS:
				getContents().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case generatorPackage.BLOCK_BASED_CODE_ELEMENT__CONTENTS:
				return contents != null && !contents.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case generatorPackage.BLOCK_BASED_CODE_ELEMENT___GENERATE_BLOCK_HEADER:
				return generateBlockHeader();
			case generatorPackage.BLOCK_BASED_CODE_ELEMENT___GENERATE_BLOCK_START:
				return generateBlockStart();
			case generatorPackage.BLOCK_BASED_CODE_ELEMENT___GENERATE_BLOCK_END:
				return generateBlockEnd();
			case generatorPackage.BLOCK_BASED_CODE_ELEMENT___GENERATE_BLOCK_CONTENTS:
				return generateBlockContents();
		}
		return super.eInvoke(operationID, arguments);
	}

} //BlockBasedCodeElementImpl
