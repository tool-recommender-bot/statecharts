/**
 */
package org.yakindu.base.generator.generator.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.yakindu.base.generator.generator.AccessRestricted;
import org.yakindu.base.generator.generator.Declarable;
import org.yakindu.base.generator.generator.GeneratorPackage;
import org.yakindu.base.generator.generator.VariableDeclarationGen;
import org.yakindu.base.generator.generator.VariableGen;
import org.yakindu.base.generator.generator.VisibilityValues;
import org.yakindu.base.types.Type;
import org.yakindu.base.types.TypeSpecifier;
import org.yakindu.base.types.TypedElement;
import org.yakindu.base.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable Gen</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.base.generator.generator.impl.VariableGenImpl#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link org.yakindu.base.generator.generator.impl.VariableGenImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.yakindu.base.generator.generator.impl.VariableGenImpl#getTypeSpecifier <em>Type Specifier</em>}</li>
 *   <li>{@link org.yakindu.base.generator.generator.impl.VariableGenImpl#getDeclaration <em>Declaration</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VariableGenImpl extends CodeElementImpl implements VariableGen {
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
	 * The cached value of the '{@link #getTypeSpecifier() <em>Type Specifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeSpecifier()
	 * @generated
	 * @ordered
	 */
	protected TypeSpecifier typeSpecifier;

	/**
	 * The cached value of the '{@link #getDeclaration() <em>Declaration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeclaration()
	 * @generated
	 * @ordered
	 */
	protected VariableDeclarationGen declaration;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariableGenImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneratorPackage.Literals.VARIABLE_GEN;
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
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratorPackage.VARIABLE_GEN__VISIBILITY, oldVisibility, visibility));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type getType() {
		Type type = basicGetType();
		return type != null && type.eIsProxy() ? (Type)eResolveProxy((InternalEObject)type) : type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type basicGetType() {
		// TODO: implement this method to return the 'Type' reference
		// -> do not perform proxy resolution
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeSpecifier getTypeSpecifier() {
		return typeSpecifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTypeSpecifier(TypeSpecifier newTypeSpecifier, NotificationChain msgs) {
		TypeSpecifier oldTypeSpecifier = typeSpecifier;
		typeSpecifier = newTypeSpecifier;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GeneratorPackage.VARIABLE_GEN__TYPE_SPECIFIER, oldTypeSpecifier, newTypeSpecifier);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeSpecifier(TypeSpecifier newTypeSpecifier) {
		if (newTypeSpecifier != typeSpecifier) {
			NotificationChain msgs = null;
			if (typeSpecifier != null)
				msgs = ((InternalEObject)typeSpecifier).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GeneratorPackage.VARIABLE_GEN__TYPE_SPECIFIER, null, msgs);
			if (newTypeSpecifier != null)
				msgs = ((InternalEObject)newTypeSpecifier).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - GeneratorPackage.VARIABLE_GEN__TYPE_SPECIFIER, null, msgs);
			msgs = basicSetTypeSpecifier(newTypeSpecifier, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratorPackage.VARIABLE_GEN__TYPE_SPECIFIER, newTypeSpecifier, newTypeSpecifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableDeclarationGen getDeclaration() {
		return declaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDeclaration(VariableDeclarationGen newDeclaration, NotificationChain msgs) {
		VariableDeclarationGen oldDeclaration = declaration;
		declaration = newDeclaration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, GeneratorPackage.VARIABLE_GEN__DECLARATION, oldDeclaration, newDeclaration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeclaration(VariableDeclarationGen newDeclaration) {
		if (newDeclaration != declaration) {
			NotificationChain msgs = null;
			if (declaration != null)
				msgs = ((InternalEObject)declaration).eInverseRemove(this, GeneratorPackage.VARIABLE_DECLARATION_GEN__VARIABLE_GEN, VariableDeclarationGen.class, msgs);
			if (newDeclaration != null)
				msgs = ((InternalEObject)newDeclaration).eInverseAdd(this, GeneratorPackage.VARIABLE_DECLARATION_GEN__VARIABLE_GEN, VariableDeclarationGen.class, msgs);
			msgs = basicSetDeclaration(newDeclaration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratorPackage.VARIABLE_GEN__DECLARATION, newDeclaration, newDeclaration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GeneratorPackage.VARIABLE_GEN__DECLARATION:
				if (declaration != null)
					msgs = ((InternalEObject)declaration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - GeneratorPackage.VARIABLE_GEN__DECLARATION, null, msgs);
				return basicSetDeclaration((VariableDeclarationGen)otherEnd, msgs);
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
			case GeneratorPackage.VARIABLE_GEN__TYPE_SPECIFIER:
				return basicSetTypeSpecifier(null, msgs);
			case GeneratorPackage.VARIABLE_GEN__DECLARATION:
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
			case GeneratorPackage.VARIABLE_GEN__VISIBILITY:
				return getVisibility();
			case GeneratorPackage.VARIABLE_GEN__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case GeneratorPackage.VARIABLE_GEN__TYPE_SPECIFIER:
				return getTypeSpecifier();
			case GeneratorPackage.VARIABLE_GEN__DECLARATION:
				return getDeclaration();
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
			case GeneratorPackage.VARIABLE_GEN__VISIBILITY:
				setVisibility((VisibilityValues)newValue);
				return;
			case GeneratorPackage.VARIABLE_GEN__TYPE_SPECIFIER:
				setTypeSpecifier((TypeSpecifier)newValue);
				return;
			case GeneratorPackage.VARIABLE_GEN__DECLARATION:
				setDeclaration((VariableDeclarationGen)newValue);
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
			case GeneratorPackage.VARIABLE_GEN__VISIBILITY:
				setVisibility(VISIBILITY_EDEFAULT);
				return;
			case GeneratorPackage.VARIABLE_GEN__TYPE_SPECIFIER:
				setTypeSpecifier((TypeSpecifier)null);
				return;
			case GeneratorPackage.VARIABLE_GEN__DECLARATION:
				setDeclaration((VariableDeclarationGen)null);
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
			case GeneratorPackage.VARIABLE_GEN__VISIBILITY:
				return visibility != VISIBILITY_EDEFAULT;
			case GeneratorPackage.VARIABLE_GEN__TYPE:
				return basicGetType() != null;
			case GeneratorPackage.VARIABLE_GEN__TYPE_SPECIFIER:
				return typeSpecifier != null;
			case GeneratorPackage.VARIABLE_GEN__DECLARATION:
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
				case GeneratorPackage.VARIABLE_GEN__VISIBILITY: return GeneratorPackage.ACCESS_RESTRICTED__VISIBILITY;
				default: return -1;
			}
		}
		if (baseClass == TypedElement.class) {
			switch (derivedFeatureID) {
				case GeneratorPackage.VARIABLE_GEN__TYPE: return TypesPackage.TYPED_ELEMENT__TYPE;
				case GeneratorPackage.VARIABLE_GEN__TYPE_SPECIFIER: return TypesPackage.TYPED_ELEMENT__TYPE_SPECIFIER;
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
				case GeneratorPackage.ACCESS_RESTRICTED__VISIBILITY: return GeneratorPackage.VARIABLE_GEN__VISIBILITY;
				default: return -1;
			}
		}
		if (baseClass == TypedElement.class) {
			switch (baseFeatureID) {
				case TypesPackage.TYPED_ELEMENT__TYPE: return GeneratorPackage.VARIABLE_GEN__TYPE;
				case TypesPackage.TYPED_ELEMENT__TYPE_SPECIFIER: return GeneratorPackage.VARIABLE_GEN__TYPE_SPECIFIER;
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
		result.append(')');
		return result.toString();
	}

} //VariableGenImpl
