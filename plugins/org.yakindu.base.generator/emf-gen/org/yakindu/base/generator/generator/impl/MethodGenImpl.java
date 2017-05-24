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

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.yakindu.base.generator.generator.AbstractableElement;
import org.yakindu.base.generator.generator.AccessRestricted;
import org.yakindu.base.generator.generator.GeneratorPackage;
import org.yakindu.base.generator.generator.MethodDeclarationGen;
import org.yakindu.base.generator.generator.MethodGen;
import org.yakindu.base.generator.generator.ParameterGen;
import org.yakindu.base.generator.generator.VisibilityValues;
import org.yakindu.base.types.TypeSpecifier;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Method Gen</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.base.generator.generator.impl.MethodGenImpl#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link org.yakindu.base.generator.generator.impl.MethodGenImpl#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link org.yakindu.base.generator.generator.impl.MethodGenImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link org.yakindu.base.generator.generator.impl.MethodGenImpl#getReturnType <em>Return Type</em>}</li>
 *   <li>{@link org.yakindu.base.generator.generator.impl.MethodGenImpl#getDeclaration <em>Declaration</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MethodGenImpl extends CodeElementImpl implements MethodGen {
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
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<ParameterGen> parameters;

	/**
	 * The cached value of the '{@link #getReturnType() <em>Return Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReturnType()
	 * @generated
	 * @ordered
	 */
	protected TypeSpecifier returnType;

	/**
	 * The cached value of the '{@link #getDeclaration() <em>Declaration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeclaration()
	 * @generated
	 * @ordered
	 */
	protected MethodDeclarationGen declaration;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MethodGenImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneratorPackage.Literals.METHOD_GEN;
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
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratorPackage.METHOD_GEN__VISIBILITY, oldVisibility, visibility));
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
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratorPackage.METHOD_GEN__ABSTRACT, oldAbstract, abstract_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ParameterGen> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<ParameterGen>(ParameterGen.class, this, GeneratorPackage.METHOD_GEN__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeSpecifier getReturnType() {
		if (returnType != null && returnType.eIsProxy()) {
			InternalEObject oldReturnType = (InternalEObject)returnType;
			returnType = (TypeSpecifier)eResolveProxy(oldReturnType);
			if (returnType != oldReturnType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneratorPackage.METHOD_GEN__RETURN_TYPE, oldReturnType, returnType));
			}
		}
		return returnType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeSpecifier basicGetReturnType() {
		return returnType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReturnType(TypeSpecifier newReturnType) {
		TypeSpecifier oldReturnType = returnType;
		returnType = newReturnType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratorPackage.METHOD_GEN__RETURN_TYPE, oldReturnType, returnType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MethodDeclarationGen getDeclaration() {
		return declaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDeclaration(MethodDeclarationGen newDeclaration, NotificationChain msgs) {
		MethodDeclarationGen oldDeclaration = declaration;
		declaration = newDeclaration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GeneratorPackage.METHOD_GEN__DECLARATION, oldDeclaration, newDeclaration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeclaration(MethodDeclarationGen newDeclaration) {
		if (newDeclaration != declaration) {
			NotificationChain msgs = null;
			if (declaration != null)
				msgs = ((InternalEObject)declaration).eInverseRemove(this, GeneratorPackage.METHOD_DECLARATION_GEN__METHOD_GEN, MethodDeclarationGen.class, msgs);
			if (newDeclaration != null)
				msgs = ((InternalEObject)newDeclaration).eInverseAdd(this, GeneratorPackage.METHOD_DECLARATION_GEN__METHOD_GEN, MethodDeclarationGen.class, msgs);
			msgs = basicSetDeclaration(newDeclaration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratorPackage.METHOD_GEN__DECLARATION, newDeclaration, newDeclaration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GeneratorPackage.METHOD_GEN__DECLARATION:
				if (declaration != null)
					msgs = ((InternalEObject)declaration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GeneratorPackage.METHOD_GEN__DECLARATION, null, msgs);
				return basicSetDeclaration((MethodDeclarationGen)otherEnd, msgs);
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
			case GeneratorPackage.METHOD_GEN__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
			case GeneratorPackage.METHOD_GEN__DECLARATION:
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
			case GeneratorPackage.METHOD_GEN__VISIBILITY:
				return getVisibility();
			case GeneratorPackage.METHOD_GEN__ABSTRACT:
				return isAbstract();
			case GeneratorPackage.METHOD_GEN__PARAMETERS:
				return getParameters();
			case GeneratorPackage.METHOD_GEN__RETURN_TYPE:
				if (resolve) return getReturnType();
				return basicGetReturnType();
			case GeneratorPackage.METHOD_GEN__DECLARATION:
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
			case GeneratorPackage.METHOD_GEN__VISIBILITY:
				setVisibility((VisibilityValues)newValue);
				return;
			case GeneratorPackage.METHOD_GEN__ABSTRACT:
				setAbstract((Boolean)newValue);
				return;
			case GeneratorPackage.METHOD_GEN__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends ParameterGen>)newValue);
				return;
			case GeneratorPackage.METHOD_GEN__RETURN_TYPE:
				setReturnType((TypeSpecifier)newValue);
				return;
			case GeneratorPackage.METHOD_GEN__DECLARATION:
				setDeclaration((MethodDeclarationGen)newValue);
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
			case GeneratorPackage.METHOD_GEN__VISIBILITY:
				setVisibility(VISIBILITY_EDEFAULT);
				return;
			case GeneratorPackage.METHOD_GEN__ABSTRACT:
				setAbstract(ABSTRACT_EDEFAULT);
				return;
			case GeneratorPackage.METHOD_GEN__PARAMETERS:
				getParameters().clear();
				return;
			case GeneratorPackage.METHOD_GEN__RETURN_TYPE:
				setReturnType((TypeSpecifier)null);
				return;
			case GeneratorPackage.METHOD_GEN__DECLARATION:
				setDeclaration((MethodDeclarationGen)null);
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
			case GeneratorPackage.METHOD_GEN__VISIBILITY:
				return visibility != VISIBILITY_EDEFAULT;
			case GeneratorPackage.METHOD_GEN__ABSTRACT:
				return abstract_ != ABSTRACT_EDEFAULT;
			case GeneratorPackage.METHOD_GEN__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case GeneratorPackage.METHOD_GEN__RETURN_TYPE:
				return returnType != null;
			case GeneratorPackage.METHOD_GEN__DECLARATION:
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
				case GeneratorPackage.METHOD_GEN__VISIBILITY: return GeneratorPackage.ACCESS_RESTRICTED__VISIBILITY;
				default: return -1;
			}
		}
		if (baseClass == AbstractableElement.class) {
			switch (derivedFeatureID) {
				case GeneratorPackage.METHOD_GEN__ABSTRACT: return GeneratorPackage.ABSTRACTABLE_ELEMENT__ABSTRACT;
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
				case GeneratorPackage.ACCESS_RESTRICTED__VISIBILITY: return GeneratorPackage.METHOD_GEN__VISIBILITY;
				default: return -1;
			}
		}
		if (baseClass == AbstractableElement.class) {
			switch (baseFeatureID) {
				case GeneratorPackage.ABSTRACTABLE_ELEMENT__ABSTRACT: return GeneratorPackage.METHOD_GEN__ABSTRACT;
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

} //MethodGenImpl
