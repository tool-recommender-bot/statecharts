/**
 */
package org.yakindu.base.generator.generator.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.yakindu.base.generator.generator.ClassDeclarationGen;
import org.yakindu.base.generator.generator.ClassGen;
import org.yakindu.base.generator.generator.GeneratorPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class Declaration Gen</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.base.generator.generator.impl.ClassDeclarationGenImpl#getClassGen <em>Class Gen</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClassDeclarationGenImpl extends DeclarationImpl implements ClassDeclarationGen {
	/**
	 * The cached value of the '{@link #getClassGen() <em>Class Gen</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassGen()
	 * @generated
	 * @ordered
	 */
	protected ClassGen classGen;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassDeclarationGenImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneratorPackage.Literals.CLASS_DECLARATION_GEN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassGen getClassGen() {
		if (classGen != null && classGen.eIsProxy()) {
			InternalEObject oldClassGen = (InternalEObject)classGen;
			classGen = (ClassGen)eResolveProxy(oldClassGen);
			if (classGen != oldClassGen) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneratorPackage.CLASS_DECLARATION_GEN__CLASS_GEN, oldClassGen, classGen));
			}
		}
		return classGen;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassGen basicGetClassGen() {
		return classGen;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetClassGen(ClassGen newClassGen, NotificationChain msgs) {
		ClassGen oldClassGen = classGen;
		classGen = newClassGen;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GeneratorPackage.CLASS_DECLARATION_GEN__CLASS_GEN, oldClassGen, newClassGen);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClassGen(ClassGen newClassGen) {
		if (newClassGen != classGen) {
			NotificationChain msgs = null;
			if (classGen != null)
				msgs = ((InternalEObject)classGen).eInverseRemove(this, GeneratorPackage.CLASS_GEN__DECLARATION, ClassGen.class, msgs);
			if (newClassGen != null)
				msgs = ((InternalEObject)newClassGen).eInverseAdd(this, GeneratorPackage.CLASS_GEN__DECLARATION, ClassGen.class, msgs);
			msgs = basicSetClassGen(newClassGen, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratorPackage.CLASS_DECLARATION_GEN__CLASS_GEN, newClassGen, newClassGen));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GeneratorPackage.CLASS_DECLARATION_GEN__CLASS_GEN:
				if (classGen != null)
					msgs = ((InternalEObject)classGen).eInverseRemove(this, GeneratorPackage.CLASS_GEN__DECLARATION, ClassGen.class, msgs);
				return basicSetClassGen((ClassGen)otherEnd, msgs);
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
			case GeneratorPackage.CLASS_DECLARATION_GEN__CLASS_GEN:
				return basicSetClassGen(null, msgs);
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
			case GeneratorPackage.CLASS_DECLARATION_GEN__CLASS_GEN:
				if (resolve) return getClassGen();
				return basicGetClassGen();
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
			case GeneratorPackage.CLASS_DECLARATION_GEN__CLASS_GEN:
				setClassGen((ClassGen)newValue);
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
			case GeneratorPackage.CLASS_DECLARATION_GEN__CLASS_GEN:
				setClassGen((ClassGen)null);
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
			case GeneratorPackage.CLASS_DECLARATION_GEN__CLASS_GEN:
				return classGen != null;
		}
		return super.eIsSet(featureID);
	}

} //ClassDeclarationGenImpl
