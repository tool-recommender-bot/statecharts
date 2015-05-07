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
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.yakindu.base.base.BasePackage;
import org.yakindu.base.base.NamedElement;
import org.yakindu.base.types.ComplexType;
import org.yakindu.base.types.Declaration;
import org.yakindu.base.types.MetaComposite;
import org.yakindu.base.types.Type;
import org.yakindu.base.types.TypedElement;
import org.yakindu.base.types.TypesPackage;
import org.yakindu.sct.model.sgraph.impl.ReactionImpl;
import org.yakindu.sct.model.stext.stext.LocalReaction;
import org.yakindu.sct.model.stext.stext.StextPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Local Reaction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.sct.model.stext.stext.impl.LocalReactionImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.yakindu.sct.model.stext.stext.impl.LocalReactionImpl#getTypeArguments <em>Type Arguments</em>}</li>
 *   <li>{@link org.yakindu.sct.model.stext.stext.impl.LocalReactionImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.yakindu.sct.model.stext.stext.impl.LocalReactionImpl#getMetaFeatures <em>Meta Features</em>}</li>
 *   <li>{@link org.yakindu.sct.model.stext.stext.impl.LocalReactionImpl#getOwningType <em>Owning Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LocalReactionImpl extends ReactionImpl implements LocalReaction {
	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected Type type;

	/**
	 * The cached value of the '{@link #getTypeArguments() <em>Type Arguments</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeArguments()
	 * @generated
	 * @ordered
	 */
	protected EList<Type> typeArguments;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

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
	protected LocalReactionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StextPackage.Literals.LOCAL_REACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (Type)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StextPackage.LOCAL_REACTION__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(Type newType) {
		Type oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StextPackage.LOCAL_REACTION__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Type> getTypeArguments() {
		if (typeArguments == null) {
			typeArguments = new EObjectResolvingEList<Type>(Type.class, this, StextPackage.LOCAL_REACTION__TYPE_ARGUMENTS);
		}
		return typeArguments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StextPackage.LOCAL_REACTION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Declaration> getMetaFeatures() {
		if (metaFeatures == null) {
			metaFeatures = new EObjectContainmentEList<Declaration>(Declaration.class, this, StextPackage.LOCAL_REACTION__META_FEATURES);
		}
		return metaFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComplexType getOwningType() {
		if (eContainerFeatureID() != StextPackage.LOCAL_REACTION__OWNING_TYPE) return null;
		return (ComplexType)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningType(ComplexType newOwningType, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningType, StextPackage.LOCAL_REACTION__OWNING_TYPE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwningType(ComplexType newOwningType) {
		if (newOwningType != eInternalContainer() || (eContainerFeatureID() != StextPackage.LOCAL_REACTION__OWNING_TYPE && newOwningType != null)) {
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
			eNotify(new ENotificationImpl(this, Notification.SET, StextPackage.LOCAL_REACTION__OWNING_TYPE, newOwningType, newOwningType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StextPackage.LOCAL_REACTION__OWNING_TYPE:
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
			case StextPackage.LOCAL_REACTION__META_FEATURES:
				return ((InternalEList<?>)getMetaFeatures()).basicRemove(otherEnd, msgs);
			case StextPackage.LOCAL_REACTION__OWNING_TYPE:
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
			case StextPackage.LOCAL_REACTION__OWNING_TYPE:
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
			case StextPackage.LOCAL_REACTION__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case StextPackage.LOCAL_REACTION__TYPE_ARGUMENTS:
				return getTypeArguments();
			case StextPackage.LOCAL_REACTION__NAME:
				return getName();
			case StextPackage.LOCAL_REACTION__META_FEATURES:
				return getMetaFeatures();
			case StextPackage.LOCAL_REACTION__OWNING_TYPE:
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
			case StextPackage.LOCAL_REACTION__TYPE:
				setType((Type)newValue);
				return;
			case StextPackage.LOCAL_REACTION__TYPE_ARGUMENTS:
				getTypeArguments().clear();
				getTypeArguments().addAll((Collection<? extends Type>)newValue);
				return;
			case StextPackage.LOCAL_REACTION__NAME:
				setName((String)newValue);
				return;
			case StextPackage.LOCAL_REACTION__META_FEATURES:
				getMetaFeatures().clear();
				getMetaFeatures().addAll((Collection<? extends Declaration>)newValue);
				return;
			case StextPackage.LOCAL_REACTION__OWNING_TYPE:
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
			case StextPackage.LOCAL_REACTION__TYPE:
				setType((Type)null);
				return;
			case StextPackage.LOCAL_REACTION__TYPE_ARGUMENTS:
				getTypeArguments().clear();
				return;
			case StextPackage.LOCAL_REACTION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case StextPackage.LOCAL_REACTION__META_FEATURES:
				getMetaFeatures().clear();
				return;
			case StextPackage.LOCAL_REACTION__OWNING_TYPE:
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
			case StextPackage.LOCAL_REACTION__TYPE:
				return type != null;
			case StextPackage.LOCAL_REACTION__TYPE_ARGUMENTS:
				return typeArguments != null && !typeArguments.isEmpty();
			case StextPackage.LOCAL_REACTION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case StextPackage.LOCAL_REACTION__META_FEATURES:
				return metaFeatures != null && !metaFeatures.isEmpty();
			case StextPackage.LOCAL_REACTION__OWNING_TYPE:
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
		if (baseClass == TypedElement.class) {
			switch (derivedFeatureID) {
				case StextPackage.LOCAL_REACTION__TYPE: return TypesPackage.TYPED_ELEMENT__TYPE;
				case StextPackage.LOCAL_REACTION__TYPE_ARGUMENTS: return TypesPackage.TYPED_ELEMENT__TYPE_ARGUMENTS;
				default: return -1;
			}
		}
		if (baseClass == NamedElement.class) {
			switch (derivedFeatureID) {
				case StextPackage.LOCAL_REACTION__NAME: return BasePackage.NAMED_ELEMENT__NAME;
				default: return -1;
			}
		}
		if (baseClass == MetaComposite.class) {
			switch (derivedFeatureID) {
				case StextPackage.LOCAL_REACTION__META_FEATURES: return TypesPackage.META_COMPOSITE__META_FEATURES;
				default: return -1;
			}
		}
		if (baseClass == Declaration.class) {
			switch (derivedFeatureID) {
				case StextPackage.LOCAL_REACTION__OWNING_TYPE: return TypesPackage.DECLARATION__OWNING_TYPE;
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
		if (baseClass == TypedElement.class) {
			switch (baseFeatureID) {
				case TypesPackage.TYPED_ELEMENT__TYPE: return StextPackage.LOCAL_REACTION__TYPE;
				case TypesPackage.TYPED_ELEMENT__TYPE_ARGUMENTS: return StextPackage.LOCAL_REACTION__TYPE_ARGUMENTS;
				default: return -1;
			}
		}
		if (baseClass == NamedElement.class) {
			switch (baseFeatureID) {
				case BasePackage.NAMED_ELEMENT__NAME: return StextPackage.LOCAL_REACTION__NAME;
				default: return -1;
			}
		}
		if (baseClass == MetaComposite.class) {
			switch (baseFeatureID) {
				case TypesPackage.META_COMPOSITE__META_FEATURES: return StextPackage.LOCAL_REACTION__META_FEATURES;
				default: return -1;
			}
		}
		if (baseClass == Declaration.class) {
			switch (baseFeatureID) {
				case TypesPackage.DECLARATION__OWNING_TYPE: return StextPackage.LOCAL_REACTION__OWNING_TYPE;
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //LocalReactionImpl
