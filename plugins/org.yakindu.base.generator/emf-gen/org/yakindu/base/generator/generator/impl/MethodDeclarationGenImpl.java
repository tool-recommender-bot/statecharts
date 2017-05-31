/**
 */
package org.yakindu.base.generator.generator.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
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
public class MethodDeclarationGenImpl extends DeclarationImpl implements MethodDeclarationGen {
	/**
	 * The cached value of the '{@link #getMethodGen() <em>Method Gen</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMethodGen()
	 * @generated
	 * @ordered
	 */
	protected MethodGen methodGen;

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
		if (methodGen != null && methodGen.eIsProxy()) {
			InternalEObject oldMethodGen = (InternalEObject)methodGen;
			methodGen = (MethodGen)eResolveProxy(oldMethodGen);
			if (methodGen != oldMethodGen) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneratorPackage.METHOD_DECLARATION_GEN__METHOD_GEN, oldMethodGen, methodGen));
			}
		}
		return methodGen;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MethodGen basicGetMethodGen() {
		return methodGen;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMethodGen(MethodGen newMethodGen, NotificationChain msgs) {
		MethodGen oldMethodGen = methodGen;
		methodGen = newMethodGen;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GeneratorPackage.METHOD_DECLARATION_GEN__METHOD_GEN, oldMethodGen, newMethodGen);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMethodGen(MethodGen newMethodGen) {
		if (newMethodGen != methodGen) {
			NotificationChain msgs = null;
			if (methodGen != null)
				msgs = ((InternalEObject)methodGen).eInverseRemove(this, GeneratorPackage.METHOD_GEN__DECLARATION, MethodGen.class, msgs);
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
				if (methodGen != null)
					msgs = ((InternalEObject)methodGen).eInverseRemove(this, GeneratorPackage.METHOD_GEN__DECLARATION, MethodGen.class, msgs);
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GeneratorPackage.METHOD_DECLARATION_GEN__METHOD_GEN:
				if (resolve) return getMethodGen();
				return basicGetMethodGen();
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
				return methodGen != null;
		}
		return super.eIsSet(featureID);
	}

} //MethodDeclarationGenImpl
