/**
 */
package org.yakindu.base.generator.generator.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.yakindu.base.generator.generator.ClassDeclaration;
import org.yakindu.base.generator.generator.generatorPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.base.generator.generator.impl.ClassDeclarationImpl#getParentClass <em>Parent Class</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClassDeclarationImpl extends MinimalEObjectImpl.Container implements ClassDeclaration {
	/**
	 * The cached value of the '{@link #getParentClass() <em>Parent Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentClass()
	 * @generated
	 * @ordered
	 */
	protected org.yakindu.base.generator.generator.Class parentClass;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassDeclarationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return generatorPackage.Literals.CLASS_DECLARATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.yakindu.base.generator.generator.Class getParentClass() {
		if (parentClass != null && parentClass.eIsProxy()) {
			InternalEObject oldParentClass = (InternalEObject)parentClass;
			parentClass = (org.yakindu.base.generator.generator.Class)eResolveProxy(oldParentClass);
			if (parentClass != oldParentClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, generatorPackage.CLASS_DECLARATION__PARENT_CLASS, oldParentClass, parentClass));
			}
		}
		return parentClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.yakindu.base.generator.generator.Class basicGetParentClass() {
		return parentClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentClass(org.yakindu.base.generator.generator.Class newParentClass) {
		org.yakindu.base.generator.generator.Class oldParentClass = parentClass;
		parentClass = newParentClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, generatorPackage.CLASS_DECLARATION__PARENT_CLASS, oldParentClass, parentClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case generatorPackage.CLASS_DECLARATION__PARENT_CLASS:
				if (resolve) return getParentClass();
				return basicGetParentClass();
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
			case generatorPackage.CLASS_DECLARATION__PARENT_CLASS:
				setParentClass((org.yakindu.base.generator.generator.Class)newValue);
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
			case generatorPackage.CLASS_DECLARATION__PARENT_CLASS:
				setParentClass((org.yakindu.base.generator.generator.Class)null);
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
			case generatorPackage.CLASS_DECLARATION__PARENT_CLASS:
				return parentClass != null;
		}
		return super.eIsSet(featureID);
	}

} //ClassDeclarationImpl
