/**
 */
package Generator.impl;

import Generator.ClassDeclaration;
import Generator.GeneratorPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link Generator.impl.ClassDeclarationImpl#getParentClass <em>Parent Class</em>}</li>
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
	protected Generator.Class parentClass;

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
		return GeneratorPackage.Literals.CLASS_DECLARATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Generator.Class getParentClass() {
		if (parentClass != null && parentClass.eIsProxy()) {
			InternalEObject oldParentClass = (InternalEObject)parentClass;
			parentClass = (Generator.Class)eResolveProxy(oldParentClass);
			if (parentClass != oldParentClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneratorPackage.CLASS_DECLARATION__PARENT_CLASS, oldParentClass, parentClass));
			}
		}
		return parentClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Generator.Class basicGetParentClass() {
		return parentClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentClass(Generator.Class newParentClass) {
		Generator.Class oldParentClass = parentClass;
		parentClass = newParentClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratorPackage.CLASS_DECLARATION__PARENT_CLASS, oldParentClass, parentClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GeneratorPackage.CLASS_DECLARATION__PARENT_CLASS:
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
			case GeneratorPackage.CLASS_DECLARATION__PARENT_CLASS:
				setParentClass((Generator.Class)newValue);
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
			case GeneratorPackage.CLASS_DECLARATION__PARENT_CLASS:
				setParentClass((Generator.Class)null);
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
			case GeneratorPackage.CLASS_DECLARATION__PARENT_CLASS:
				return parentClass != null;
		}
		return super.eIsSet(featureID);
	}

} //ClassDeclarationImpl
