/**
 */
package Generator.impl;

import Generator.GeneratorPackage;
import Generator.Method;
import Generator.MethodDeclaration;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Method Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link Generator.impl.MethodDeclarationImpl#getParentMethod <em>Parent Method</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MethodDeclarationImpl extends LineBasedCodeElementImpl implements MethodDeclaration {
	/**
	 * The cached value of the '{@link #getParentMethod() <em>Parent Method</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentMethod()
	 * @generated
	 * @ordered
	 */
	protected Method parentMethod;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MethodDeclarationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeneratorPackage.Literals.METHOD_DECLARATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Method getParentMethod() {
		if (parentMethod != null && parentMethod.eIsProxy()) {
			InternalEObject oldParentMethod = (InternalEObject)parentMethod;
			parentMethod = (Method)eResolveProxy(oldParentMethod);
			if (parentMethod != oldParentMethod) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, GeneratorPackage.METHOD_DECLARATION__PARENT_METHOD, oldParentMethod, parentMethod));
			}
		}
		return parentMethod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Method basicGetParentMethod() {
		return parentMethod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentMethod(Method newParentMethod) {
		Method oldParentMethod = parentMethod;
		parentMethod = newParentMethod;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeneratorPackage.METHOD_DECLARATION__PARENT_METHOD, oldParentMethod, parentMethod));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GeneratorPackage.METHOD_DECLARATION__PARENT_METHOD:
				if (resolve) return getParentMethod();
				return basicGetParentMethod();
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
			case GeneratorPackage.METHOD_DECLARATION__PARENT_METHOD:
				setParentMethod((Method)newValue);
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
			case GeneratorPackage.METHOD_DECLARATION__PARENT_METHOD:
				setParentMethod((Method)null);
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
			case GeneratorPackage.METHOD_DECLARATION__PARENT_METHOD:
				return parentMethod != null;
		}
		return super.eIsSet(featureID);
	}

} //MethodDeclarationImpl
