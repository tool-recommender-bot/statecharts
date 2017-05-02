/**
 */
package org.yakindu.base.generator.generator.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.yakindu.base.generator.generator.Variable;
import org.yakindu.base.generator.generator.VariableDeclaration;
import org.yakindu.base.generator.generator.generatorPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.base.generator.generator.impl.VariableDeclarationImpl#getParentVariable <em>Parent Variable</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class VariableDeclarationImpl extends LineBasedCodeElementImpl implements VariableDeclaration {
	/**
	 * The cached value of the '{@link #getParentVariable() <em>Parent Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentVariable()
	 * @generated
	 * @ordered
	 */
	protected Variable parentVariable;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariableDeclarationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return generatorPackage.Literals.VARIABLE_DECLARATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable getParentVariable() {
		if (parentVariable != null && parentVariable.eIsProxy()) {
			InternalEObject oldParentVariable = (InternalEObject)parentVariable;
			parentVariable = (Variable)eResolveProxy(oldParentVariable);
			if (parentVariable != oldParentVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, generatorPackage.VARIABLE_DECLARATION__PARENT_VARIABLE, oldParentVariable, parentVariable));
			}
		}
		return parentVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable basicGetParentVariable() {
		return parentVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentVariable(Variable newParentVariable) {
		Variable oldParentVariable = parentVariable;
		parentVariable = newParentVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, generatorPackage.VARIABLE_DECLARATION__PARENT_VARIABLE, oldParentVariable, parentVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case generatorPackage.VARIABLE_DECLARATION__PARENT_VARIABLE:
				if (resolve) return getParentVariable();
				return basicGetParentVariable();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case generatorPackage.VARIABLE_DECLARATION__PARENT_VARIABLE:
				setParentVariable((Variable)newValue);
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
			case generatorPackage.VARIABLE_DECLARATION__PARENT_VARIABLE:
				setParentVariable((Variable)null);
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
			case generatorPackage.VARIABLE_DECLARATION__PARENT_VARIABLE:
				return parentVariable != null;
		}
		return super.eIsSet(featureID);
	}

} //VariableDeclarationImpl
