/**
 */
package org.yakindu.base.generator.generator.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.yakindu.base.generator.generator.GeneratorPackage;
import org.yakindu.base.generator.generator.MethodDeclarationGen;
import org.yakindu.base.generator.generator.MethodGen;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Method Declaration Gen</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.base.generator.generator.impl.MethodDeclarationGenImpl#getMethodGen <em>Method Gen</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MethodDeclarationGenImpl extends MinimalEObjectImpl.Container implements MethodDeclarationGen {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MethodDeclarationGenImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneratorPackage.Literals.METHOD_DECLARATION_GEN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MethodGen getMethodGen() {
		if (eContainerFeatureID() != GeneratorPackage.METHOD_DECLARATION_GEN__METHOD_GEN) return null;
		return (MethodGen)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMethodGen(MethodGen newMethodGen, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newMethodGen, GeneratorPackage.METHOD_DECLARATION_GEN__METHOD_GEN, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMethodGen(MethodGen newMethodGen) {
		if (newMethodGen != eInternalContainer() || (eContainerFeatureID() != GeneratorPackage.METHOD_DECLARATION_GEN__METHOD_GEN && newMethodGen != null)) {
			if (EcoreUtil.isAncestor(this, newMethodGen))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newMethodGen != null)
				msgs = ((InternalEObject)newMethodGen).eInverseAdd(this, GeneratorPackage.METHOD_GEN__DECLARATION, MethodGen.class, msgs);
			msgs = basicSetMethodGen(newMethodGen, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratorPackage.METHOD_DECLARATION_GEN__METHOD_GEN, newMethodGen, newMethodGen));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GeneratorPackage.METHOD_DECLARATION_GEN__METHOD_GEN:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetMethodGen((MethodGen)otherEnd, msgs);
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
			case GeneratorPackage.METHOD_DECLARATION_GEN__METHOD_GEN:
				return basicSetMethodGen(null, msgs);
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
			case GeneratorPackage.METHOD_DECLARATION_GEN__METHOD_GEN:
				return eInternalContainer().eInverseRemove(this, GeneratorPackage.METHOD_GEN__DECLARATION, MethodGen.class, msgs);
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
			case GeneratorPackage.METHOD_DECLARATION_GEN__METHOD_GEN:
				return getMethodGen();
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
			case GeneratorPackage.METHOD_DECLARATION_GEN__METHOD_GEN:
				setMethodGen((MethodGen)newValue);
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
			case GeneratorPackage.METHOD_DECLARATION_GEN__METHOD_GEN:
				setMethodGen((MethodGen)null);
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
			case GeneratorPackage.METHOD_DECLARATION_GEN__METHOD_GEN:
				return getMethodGen() != null;
		}
		return super.eIsSet(featureID);
	}

} //MethodDeclarationGenImpl
