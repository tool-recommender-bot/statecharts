/**
 */
package org.yakindu.base.generator.generator.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

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
		if (eContainerFeatureID() != GeneratorPackage.CLASS_DECLARATION_GEN__CLASS_GEN) return null;
		return (ClassGen)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetClassGen(ClassGen newClassGen, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newClassGen, GeneratorPackage.CLASS_DECLARATION_GEN__CLASS_GEN, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClassGen(ClassGen newClassGen) {
		if (newClassGen != eInternalContainer() || (eContainerFeatureID() != GeneratorPackage.CLASS_DECLARATION_GEN__CLASS_GEN && newClassGen != null)) {
			if (EcoreUtil.isAncestor(this, newClassGen))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
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
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
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
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case GeneratorPackage.CLASS_DECLARATION_GEN__CLASS_GEN:
				return eInternalContainer().eInverseRemove(this, GeneratorPackage.CLASS_GEN__DECLARATION, ClassGen.class, msgs);
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
			case GeneratorPackage.CLASS_DECLARATION_GEN__CLASS_GEN:
				return getClassGen();
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
				return getClassGen() != null;
		}
		return super.eIsSet(featureID);
	}

} //ClassDeclarationGenImpl
