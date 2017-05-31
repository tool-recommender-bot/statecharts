/**
 */
package org.yakindu.base.generator.generator.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.yakindu.base.base.DocumentedElement;
import org.yakindu.base.base.NamedElement;

import org.yakindu.base.generator.generator.*;

import org.yakindu.base.types.TypedElement;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.yakindu.base.generator.generator.GeneratorPackage
 * @generated
 */
public class GeneratorAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static GeneratorPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GeneratorAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = GeneratorPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GeneratorSwitch<Adapter> modelSwitch =
		new GeneratorSwitch<Adapter>() {
			@Override
			public Adapter caseCodeElement(CodeElement object) {
				return createCodeElementAdapter();
			}
			@Override
			public Adapter caseSourceFileGen(SourceFileGen object) {
				return createSourceFileGenAdapter();
			}
			@Override
			public Adapter caseClassGen(ClassGen object) {
				return createClassGenAdapter();
			}
			@Override
			public Adapter caseClassDeclarationGen(ClassDeclarationGen object) {
				return createClassDeclarationGenAdapter();
			}
			@Override
			public Adapter caseInterfaceGen(InterfaceGen object) {
				return createInterfaceGenAdapter();
			}
			@Override
			public Adapter caseMethodGen(MethodGen object) {
				return createMethodGenAdapter();
			}
			@Override
			public Adapter caseMethodDeclarationGen(MethodDeclarationGen object) {
				return createMethodDeclarationGenAdapter();
			}
			@Override
			public Adapter caseAccessRestricted(AccessRestricted object) {
				return createAccessRestrictedAdapter();
			}
			@Override
			public Adapter caseVariableGen(VariableGen object) {
				return createVariableGenAdapter();
			}
			@Override
			public Adapter caseVariableDeclarationGen(VariableDeclarationGen object) {
				return createVariableDeclarationGenAdapter();
			}
			@Override
			public Adapter caseParameterGen(ParameterGen object) {
				return createParameterGenAdapter();
			}
			@Override
			public Adapter caseAbstractableElement(AbstractableElement object) {
				return createAbstractableElementAdapter();
			}
			@Override
			public Adapter caseExpressionGen(ExpressionGen object) {
				return createExpressionGenAdapter();
			}
			@Override
			public Adapter caseDeclaration(Declaration object) {
				return createDeclarationAdapter();
			}
			@Override
			public Adapter caseDeclarable(Declarable object) {
				return createDeclarableAdapter();
			}
			@Override
			public Adapter caseNamedElement(NamedElement object) {
				return createNamedElementAdapter();
			}
			@Override
			public Adapter caseDocumentedElement(DocumentedElement object) {
				return createDocumentedElementAdapter();
			}
			@Override
			public Adapter caseTypedElement(TypedElement object) {
				return createTypedElementAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.generator.generator.CodeElement <em>Code Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.generator.generator.CodeElement
	 * @generated
	 */
	public Adapter createCodeElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.generator.generator.SourceFileGen <em>Source File Gen</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.generator.generator.SourceFileGen
	 * @generated
	 */
	public Adapter createSourceFileGenAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.generator.generator.ClassGen <em>Class Gen</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.generator.generator.ClassGen
	 * @generated
	 */
	public Adapter createClassGenAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.generator.generator.ClassDeclarationGen <em>Class Declaration Gen</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.generator.generator.ClassDeclarationGen
	 * @generated
	 */
	public Adapter createClassDeclarationGenAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.generator.generator.InterfaceGen <em>Interface Gen</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.generator.generator.InterfaceGen
	 * @generated
	 */
	public Adapter createInterfaceGenAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.generator.generator.MethodGen <em>Method Gen</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.generator.generator.MethodGen
	 * @generated
	 */
	public Adapter createMethodGenAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.generator.generator.MethodDeclarationGen <em>Method Declaration Gen</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.generator.generator.MethodDeclarationGen
	 * @generated
	 */
	public Adapter createMethodDeclarationGenAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.generator.generator.AccessRestricted <em>Access Restricted</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.generator.generator.AccessRestricted
	 * @generated
	 */
	public Adapter createAccessRestrictedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.generator.generator.VariableGen <em>Variable Gen</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.generator.generator.VariableGen
	 * @generated
	 */
	public Adapter createVariableGenAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.generator.generator.VariableDeclarationGen <em>Variable Declaration Gen</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.generator.generator.VariableDeclarationGen
	 * @generated
	 */
	public Adapter createVariableDeclarationGenAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.generator.generator.ParameterGen <em>Parameter Gen</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.generator.generator.ParameterGen
	 * @generated
	 */
	public Adapter createParameterGenAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.generator.generator.AbstractableElement <em>Abstractable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.generator.generator.AbstractableElement
	 * @generated
	 */
	public Adapter createAbstractableElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.generator.generator.ExpressionGen <em>Expression Gen</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.generator.generator.ExpressionGen
	 * @generated
	 */
	public Adapter createExpressionGenAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.generator.generator.Declaration <em>Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.generator.generator.Declaration
	 * @generated
	 */
	public Adapter createDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.generator.generator.Declarable <em>Declarable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.generator.generator.Declarable
	 * @generated
	 */
	public Adapter createDeclarableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.base.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.base.NamedElement
	 * @generated
	 */
	public Adapter createNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.base.DocumentedElement <em>Documented Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.base.DocumentedElement
	 * @generated
	 */
	public Adapter createDocumentedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.types.TypedElement <em>Typed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.types.TypedElement
	 * @generated
	 */
	public Adapter createTypedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //GeneratorAdapterFactory
