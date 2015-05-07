/**
 */
package org.yakindu.sct.model.stext.stext.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.yakindu.base.types.ComplexType;
import org.yakindu.base.types.Declaration;
import org.yakindu.base.types.MetaComposite;
import org.yakindu.base.types.TypesPackage;
import org.yakindu.base.types.impl.TypeAliasImpl;
import org.yakindu.sct.model.stext.stext.StextPackage;
import org.yakindu.sct.model.stext.stext.TypeAliasDefinition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type Alias Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.sct.model.stext.stext.impl.TypeAliasDefinitionImpl#getMetaFeatures <em>Meta Features</em>}</li>
 *   <li>{@link org.yakindu.sct.model.stext.stext.impl.TypeAliasDefinitionImpl#getOwningType <em>Owning Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TypeAliasDefinitionImpl extends TypeAliasImpl implements TypeAliasDefinition {
	/**
	 * The cached value of the '{@link #getMetaFeatures() <em>Meta Features</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetaFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<Declaration> metaFeatures;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypeAliasDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StextPackage.Literals.TYPE_ALIAS_DEFINITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Declaration> getMetaFeatures() {
		if (metaFeatures == null) {
			metaFeatures = new EObjectContainmentEList<Declaration>(Declaration.class, this, StextPackage.TYPE_ALIAS_DEFINITION__META_FEATURES);
		}
		return metaFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComplexType getOwningType() {
		if (eContainerFeatureID() != StextPackage.TYPE_ALIAS_DEFINITION__OWNING_TYPE) return null;
		return (ComplexType)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningType(ComplexType newOwningType, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningType, StextPackage.TYPE_ALIAS_DEFINITION__OWNING_TYPE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwningType(ComplexType newOwningType) {
		if (newOwningType != eInternalContainer() || (eContainerFeatureID() != StextPackage.TYPE_ALIAS_DEFINITION__OWNING_TYPE && newOwningType != null)) {
			if (EcoreUtil.isAncestor(this, newOwningType))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningType != null)
				msgs = ((InternalEObject)newOwningType).eInverseAdd(this, TypesPackage.COMPLEX_TYPE__FEATURES, ComplexType.class, msgs);
			msgs = basicSetOwningType(newOwningType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StextPackage.TYPE_ALIAS_DEFINITION__OWNING_TYPE, newOwningType, newOwningType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StextPackage.TYPE_ALIAS_DEFINITION__OWNING_TYPE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningType((ComplexType)otherEnd, msgs);
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
			case StextPackage.TYPE_ALIAS_DEFINITION__META_FEATURES:
				return ((InternalEList<?>)getMetaFeatures()).basicRemove(otherEnd, msgs);
			case StextPackage.TYPE_ALIAS_DEFINITION__OWNING_TYPE:
				return basicSetOwningType(null, msgs);
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
			case StextPackage.TYPE_ALIAS_DEFINITION__OWNING_TYPE:
				return eInternalContainer().eInverseRemove(this, TypesPackage.COMPLEX_TYPE__FEATURES, ComplexType.class, msgs);
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
			case StextPackage.TYPE_ALIAS_DEFINITION__META_FEATURES:
				return getMetaFeatures();
			case StextPackage.TYPE_ALIAS_DEFINITION__OWNING_TYPE:
				return getOwningType();
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
			case StextPackage.TYPE_ALIAS_DEFINITION__META_FEATURES:
				getMetaFeatures().clear();
				getMetaFeatures().addAll((Collection<? extends Declaration>)newValue);
				return;
			case StextPackage.TYPE_ALIAS_DEFINITION__OWNING_TYPE:
				setOwningType((ComplexType)newValue);
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
			case StextPackage.TYPE_ALIAS_DEFINITION__META_FEATURES:
				getMetaFeatures().clear();
				return;
			case StextPackage.TYPE_ALIAS_DEFINITION__OWNING_TYPE:
				setOwningType((ComplexType)null);
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
			case StextPackage.TYPE_ALIAS_DEFINITION__META_FEATURES:
				return metaFeatures != null && !metaFeatures.isEmpty();
			case StextPackage.TYPE_ALIAS_DEFINITION__OWNING_TYPE:
				return getOwningType() != null;
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
		if (baseClass == MetaComposite.class) {
			switch (derivedFeatureID) {
				case StextPackage.TYPE_ALIAS_DEFINITION__META_FEATURES: return TypesPackage.META_COMPOSITE__META_FEATURES;
				default: return -1;
			}
		}
		if (baseClass == Declaration.class) {
			switch (derivedFeatureID) {
				case StextPackage.TYPE_ALIAS_DEFINITION__OWNING_TYPE: return TypesPackage.DECLARATION__OWNING_TYPE;
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
		if (baseClass == MetaComposite.class) {
			switch (baseFeatureID) {
				case TypesPackage.META_COMPOSITE__META_FEATURES: return StextPackage.TYPE_ALIAS_DEFINITION__META_FEATURES;
				default: return -1;
			}
		}
		if (baseClass == Declaration.class) {
			switch (baseFeatureID) {
				case TypesPackage.DECLARATION__OWNING_TYPE: return StextPackage.TYPE_ALIAS_DEFINITION__OWNING_TYPE;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}


} //TypeAliasDefinitionImpl
