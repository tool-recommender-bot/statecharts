/**
 */
package org.yakindu.base.generator.generator.impl;

import org.eclipse.emf.ecore.EClass;

import org.yakindu.base.generator.generator.ClassMember;
import org.yakindu.base.generator.generator.generatorPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class Member</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class ClassMemberImpl extends VisibilityOwnerImpl implements ClassMember {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassMemberImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return generatorPackage.Literals.CLASS_MEMBER;
	}

} //ClassMemberImpl
