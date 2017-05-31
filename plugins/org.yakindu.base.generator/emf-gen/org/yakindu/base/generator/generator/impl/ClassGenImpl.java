/**
 */
package org.yakindu.base.generator.generator.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.yakindu.base.generator.generator.AbstractableElement;
import org.yakindu.base.generator.generator.AccessRestricted;
import org.yakindu.base.generator.generator.ClassDeclarationGen;
import org.yakindu.base.generator.generator.ClassGen;
import org.yakindu.base.generator.generator.Declarable;
import org.yakindu.base.generator.generator.GeneratorPackage;
import org.yakindu.base.generator.generator.InterfaceGen;
import org.yakindu.base.generator.generator.VisibilityValues;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class Gen</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.base.generator.generator.impl.ClassGenImpl#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link org.yakindu.base.generator.generator.impl.ClassGenImpl#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link org.yakindu.base.generator.generator.impl.ClassGenImpl#getSuperClass <em>Super Class</em>}</li>
 *   <li>{@link org.yakindu.base.generator.generator.impl.ClassGenImpl#getImplements <em>Implements</em>}</li>
 *   <li>{@link org.yakindu.base.generator.generator.impl.ClassGenImpl#getDeclaration <em>Declaration</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClassGenImpl extends CodeElementImpl implements ClassGen {
	/**
	 * The default value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisibility()
	 * @generated
	 * @ordered
	 */
	protected static final VisibilityValues VISIBILITY_EDEFAULT = VisibilityValues.NONE;

	/**
	 * The cached value of the '{@link #getVisibility() <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVisibility()
	 * @generated
	 * @ordered
	 */
	protected VisibilityValues visibility = VISIBILITY_EDEFAULT;

	/**
	 * The default value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAbstract()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ABSTRACT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAbstract()
	 * @generated
	 * @ordered
	 */
	protected boolean abstract_ = ABSTRACT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSuperClass() <em>Super Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperClass()
	 * @generated
	 * @ordered
	 */
	protected ClassGen superClass;

	/**
	 * The cached value of the '{@link #getImplements() <em>Implements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplements()
	 * @generated
	 * @ordered
	 */
	protected EList<InterfaceGen> implements_;

	/**
	 * The cached value of the '{@link #getDeclaration() <em>Declaration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeclaration()
	 * @generated
	 * @ordered
	 */
	protected ClassDeclarationGen declaration;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassGenImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneratorPackage.Literals.CLASS_GEN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VisibilityValues getVisibility() {
		return visibility;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVisibility(VisibilityValues newVisibility) {
		VisibilityValues oldVisibility = visibility;
		visibility = newVisibility == null ? VISIBILITY_EDEFAULT : newVisibility;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratorPackage.CLASS_GEN__VISIBILITY, oldVisibility, visibility));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAbstract() {
		return abstract_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAbstract(boolean newAbstract) {
		boolean oldAbstract = abstract_;
		abstract_ = newAbstract;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratorPackage.CLASS_GEN__ABSTRACT, oldAbstract, abstract_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassGen getSuperClass() {
		if (superClass != null && superClass.eIsProxy()) {
			InternalEObject oldSuperClass = (InternalEObject)superClass;
			superClass = (ClassGen)eResolveProxy(oldSuperClass);
			if (superClass != oldSuperClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneratorPackage.CLASS_GEN__SUPER_CLASS, oldSuperClass, superClass));
			}
		}
		return superClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassGen basicGetSuperClass() {
		return superClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSuperClass(ClassGen newSuperClass) {
		ClassGen oldSuperClass = superClass;
		superClass = newSuperClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratorPackage.CLASS_GEN__SUPER_CLASS, oldSuperClass, superClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InterfaceGen> getImplements() {
		if (implements_ == null) {
			implements_ = new EObjectResolvingEList<InterfaceGen>(InterfaceGen.class, this, GeneratorPackage.CLASS_GEN__IMPLEMENTS);
		}
		return implements_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassDeclarationGen getDeclaration() {
		return declaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDeclaration(ClassDeclarationGen newDeclaration, NotificationChain msgs) {
		ClassDeclarationGen oldDeclaration = declaration;
		declaration = newDeclaration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GeneratorPackage.CLASS_GEN__DECLARATION, oldDeclaration, newDeclaration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeclaration(ClassDeclarationGen newDeclaration) {
		if (newDeclaration != declaration) {
			NotificationChain msgs = null;
			if (declaration != null)
				msgs = ((InternalEObject)declaration).eInverseRemove(this, GeneratorPackage.CLASS_DECLARATION_GEN__CLASS_GEN, ClassDeclarationGen.class, msgs);
			if (newDeclaration != null)
				msgs = ((InternalEObject)newDeclaration).eInverseAdd(this, GeneratorPackage.CLASS_DECLARATION_GEN__CLASS_GEN, ClassDeclarationGen.class, msgs);
			msgs = basicSetDeclaration(newDeclaration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratorPackage.CLASS_GEN__DECLARATION, newDeclaration, newDeclaration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GeneratorPackage.CLASS_GEN__DECLARATION:
				if (declaration != null)
					msgs = ((InternalEObject)declaration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GeneratorPackage.CLASS_GEN__DECLARATION, null, msgs);
				return basicSetDeclaration((ClassDeclarationGen)otherEnd, msgs);
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
			case GeneratorPackage.CLASS_GEN__DECLARATION:
				return basicSetDeclaration(null, msgs);
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
			case GeneratorPackage.CLASS_GEN__VISIBILITY:
				return getVisibility();
			case GeneratorPackage.CLASS_GEN__ABSTRACT:
				return isAbstract();
			case GeneratorPackage.CLASS_GEN__SUPER_CLASS:
				if (resolve) return getSuperClass();
				return basicGetSuperClass();
			case GeneratorPackage.CLASS_GEN__IMPLEMENTS:
				return getImplements();
			case GeneratorPackage.CLASS_GEN__DECLARATION:
				return getDeclaration();
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
			case GeneratorPackage.CLASS_GEN__VISIBILITY:
				setVisibility((VisibilityValues)newValue);
				return;
			case GeneratorPackage.CLASS_GEN__ABSTRACT:
				setAbstract((Boolean)newValue);
				return;
			case GeneratorPackage.CLASS_GEN__SUPER_CLASS:
				setSuperClass((ClassGen)newValue);
				return;
			case GeneratorPackage.CLASS_GEN__IMPLEMENTS:
				getImplements().clear();
				getImplements().addAll((Collection<? extends InterfaceGen>)newValue);
				return;
			case GeneratorPackage.CLASS_GEN__DECLARATION:
				setDeclaration((ClassDeclarationGen)newValue);
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
			case GeneratorPackage.CLASS_GEN__VISIBILITY:
				setVisibility(VISIBILITY_EDEFAULT);
				return;
			case GeneratorPackage.CLASS_GEN__ABSTRACT:
				setAbstract(ABSTRACT_EDEFAULT);
				return;
			case GeneratorPackage.CLASS_GEN__SUPER_CLASS:
				setSuperClass((ClassGen)null);
				return;
			case GeneratorPackage.CLASS_GEN__IMPLEMENTS:
				getImplements().clear();
				return;
			case GeneratorPackage.CLASS_GEN__DECLARATION:
				setDeclaration((ClassDeclarationGen)null);
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
			case GeneratorPackage.CLASS_GEN__VISIBILITY:
				return visibility != VISIBILITY_EDEFAULT;
			case GeneratorPackage.CLASS_GEN__ABSTRACT:
				return abstract_ != ABSTRACT_EDEFAULT;
			case GeneratorPackage.CLASS_GEN__SUPER_CLASS:
				return superClass != null;
			case GeneratorPackage.CLASS_GEN__IMPLEMENTS:
				return implements_ != null && !implements_.isEmpty();
			case GeneratorPackage.CLASS_GEN__DECLARATION:
				return declaration != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == AccessRestricted.class) {
			switch (derivedFeatureID) {
				case GeneratorPackage.CLASS_GEN__VISIBILITY: return GeneratorPackage.ACCESS_RESTRICTED__VISIBILITY;
				default: return -1;
			}
		}
		if (baseClass == AbstractableElement.class) {
			switch (derivedFeatureID) {
				case GeneratorPackage.CLASS_GEN__ABSTRACT: return GeneratorPackage.ABSTRACTABLE_ELEMENT__ABSTRACT;
				default: return -1;
			}
		}
		if (baseClass == Declarable.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == AccessRestricted.class) {
			switch (baseFeatureID) {
				case GeneratorPackage.ACCESS_RESTRICTED__VISIBILITY: return GeneratorPackage.CLASS_GEN__VISIBILITY;
				default: return -1;
			}
		}
		if (baseClass == AbstractableElement.class) {
			switch (baseFeatureID) {
				case GeneratorPackage.ABSTRACTABLE_ELEMENT__ABSTRACT: return GeneratorPackage.CLASS_GEN__ABSTRACT;
				default: return -1;
			}
		}
		if (baseClass == Declarable.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (visibility: ");
		result.append(visibility);
		result.append(", abstract: ");
		result.append(abstract_);
		result.append(')');
		return result.toString();
	}

} //ClassGenImpl
