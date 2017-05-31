/**
 */
package org.yakindu.base.generator.generator.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

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
		if (eContainerFeatureID() != GeneratorPackage.VARIABLE_DECLARATION_GEN__VARIABLE_GEN) return null;
		return (VariableGen)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVariableGen(VariableGen newVariableGen, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newVariableGen, GeneratorPackage.VARIABLE_DECLARATION_GEN__VARIABLE_GEN, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVariableGen(VariableGen newVariableGen) {
		if (newVariableGen != eInternalContainer() || (eContainerFeatureID() != GeneratorPackage.VARIABLE_DECLARATION_GEN__VARIABLE_GEN && newVariableGen != null)) {
			if (EcoreUtil.isAncestor(this, newVariableGen))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
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
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
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
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case GeneratorPackage.VARIABLE_DECLARATION_GEN__VARIABLE_GEN:
				return eInternalContainer().eInverseRemove(this, GeneratorPackage.VARIABLE_GEN__DECLARATION, VariableGen.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
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
				return getVariableGen();
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
				return getVariableGen() != null;
		}
		return super.eIsSet(featureID);
	}

} //VariableDeclarationGenImpl
