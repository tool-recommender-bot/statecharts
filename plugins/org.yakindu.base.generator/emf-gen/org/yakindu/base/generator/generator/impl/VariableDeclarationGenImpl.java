/**
 */
package org.yakindu.base.generator.generator.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.yakindu.base.generator.generator.GeneratorPackage;
import org.yakindu.base.generator.generator.VariableDeclarationGen;
import org.yakindu.base.generator.generator.VariableGen;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable Declaration Gen</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.base.generator.generator.impl.VariableDeclarationGenImpl#getVariableGen <em>Variable Gen</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VariableDeclarationGenImpl extends DeclarationImpl implements VariableDeclarationGen {
	/**
	 * The cached value of the '{@link #getVariableGen() <em>Variable Gen</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariableGen()
	 * @generated
	 * @ordered
	 */
	protected VariableGen variableGen;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariableDeclarationGenImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneratorPackage.Literals.VARIABLE_DECLARATION_GEN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableGen getVariableGen() {
		if (variableGen != null && variableGen.eIsProxy()) {
			InternalEObject oldVariableGen = (InternalEObject)variableGen;
			variableGen = (VariableGen)eResolveProxy(oldVariableGen);
			if (variableGen != oldVariableGen) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneratorPackage.VARIABLE_DECLARATION_GEN__VARIABLE_GEN, oldVariableGen, variableGen));
			}
		}
		return variableGen;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableGen basicGetVariableGen() {
		return variableGen;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVariableGen(VariableGen newVariableGen, NotificationChain msgs) {
		VariableGen oldVariableGen = variableGen;
		variableGen = newVariableGen;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GeneratorPackage.VARIABLE_DECLARATION_GEN__VARIABLE_GEN, oldVariableGen, newVariableGen);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariableGen(VariableGen newVariableGen) {
		if (newVariableGen != variableGen) {
			NotificationChain msgs = null;
			if (variableGen != null)
				msgs = ((InternalEObject)variableGen).eInverseRemove(this, GeneratorPackage.VARIABLE_GEN__DECLARATION, VariableGen.class, msgs);
			if (newVariableGen != null)
				msgs = ((InternalEObject)newVariableGen).eInverseAdd(this, GeneratorPackage.VARIABLE_GEN__DECLARATION, VariableGen.class, msgs);
			msgs = basicSetVariableGen(newVariableGen, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratorPackage.VARIABLE_DECLARATION_GEN__VARIABLE_GEN, newVariableGen, newVariableGen));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GeneratorPackage.VARIABLE_DECLARATION_GEN__VARIABLE_GEN:
				if (variableGen != null)
					msgs = ((InternalEObject)variableGen).eInverseRemove(this, GeneratorPackage.VARIABLE_GEN__DECLARATION, VariableGen.class, msgs);
				return basicSetVariableGen((VariableGen)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GeneratorPackage.VARIABLE_DECLARATION_GEN__VARIABLE_GEN:
				return basicSetVariableGen(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GeneratorPackage.VARIABLE_DECLARATION_GEN__VARIABLE_GEN:
				if (resolve) return getVariableGen();
				return basicGetVariableGen();
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
			case GeneratorPackage.VARIABLE_DECLARATION_GEN__VARIABLE_GEN:
				setVariableGen((VariableGen)newValue);
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
			case GeneratorPackage.VARIABLE_DECLARATION_GEN__VARIABLE_GEN:
				setVariableGen((VariableGen)null);
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
			case GeneratorPackage.VARIABLE_DECLARATION_GEN__VARIABLE_GEN:
				return variableGen != null;
		}
		return super.eIsSet(featureID);
	}

} //VariableDeclarationGenImpl
