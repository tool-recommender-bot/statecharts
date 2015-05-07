/**
 */
package org.yakindu.sct.model.stext.stext.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.yakindu.base.types.TypeAlias;
import org.yakindu.base.types.TypesFactory;
import org.yakindu.base.types.TypesPackage;
import org.yakindu.base.types.provider.TypeAliasItemProvider;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.stext.stext.StextFactory;
import org.yakindu.sct.model.stext.stext.StextPackage;
import org.yakindu.sct.model.stext.stext.TypeAliasDefinition;

/**
 * This is the item provider adapter for a
 * {@link org.yakindu.sct.model.stext.stext.TypeAliasDefinition} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class TypeAliasDefinitionItemProvider extends TypeAliasItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TypeAliasDefinitionItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

		}
		return itemPropertyDescriptors;
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(TypesPackage.Literals.META_COMPOSITE__META_FEATURES);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns TypeAliasDefinition.gif.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/TypeAliasDefinition"));
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		TypeAlias alias = (TypeAlias) object;
		String label = ((TypeAlias) object).getName();

		StringBuilder builder = null;
		if (label != null) {
			builder = new StringBuilder(label);
			if (alias.getOriginType() != null) {
				builder.append(" : ");
				builder.append(alias.getOriginType().getName());
			}
		} else {
			builder = new StringBuilder();
			builder.append(getString("_UI_TypeAlias_type"));
		}
		return builder.toString();
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(TypeAliasDefinition.class)) {
			case StextPackage.TYPE_ALIAS_DEFINITION__META_FEATURES:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s
	 * describing the children that can be created under this object. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.META_COMPOSITE__META_FEATURES,
				 StextFactory.eINSTANCE.createEventDefinition()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.META_COMPOSITE__META_FEATURES,
				 StextFactory.eINSTANCE.createVariableDefinition()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.META_COMPOSITE__META_FEATURES,
				 StextFactory.eINSTANCE.createOperationDefinition()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.META_COMPOSITE__META_FEATURES,
				 StextFactory.eINSTANCE.createTypeAliasDefinition()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.META_COMPOSITE__META_FEATURES,
				 StextFactory.eINSTANCE.createLocalReaction()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.META_COMPOSITE__META_FEATURES,
				 TypesFactory.eINSTANCE.createOperation()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.META_COMPOSITE__META_FEATURES,
				 TypesFactory.eINSTANCE.createProperty()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.META_COMPOSITE__META_FEATURES,
				 TypesFactory.eINSTANCE.createEvent()));

		newChildDescriptors.add
			(createChildParameter
				(TypesPackage.Literals.META_COMPOSITE__META_FEATURES,
				 SGraphFactory.eINSTANCE.createImportDeclaration()));
	}

	/**
	 * Return the resource locator for this item provider's resources. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return STextEditPlugin.INSTANCE;
	}

}
