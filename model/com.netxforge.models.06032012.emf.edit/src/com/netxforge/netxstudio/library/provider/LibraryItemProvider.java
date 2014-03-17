/**
 * Copyright (c) 2014 NetXForge
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors:
 * Christophe Bouhier - initial API and implementation and/or initial documentation
 */
package com.netxforge.netxstudio.library.provider;


import com.netxforge.netxstudio.generics.GenericsFactory;

import com.netxforge.netxstudio.library.Library;
import com.netxforge.netxstudio.library.LibraryFactory;
import com.netxforge.netxstudio.library.LibraryPackage;

import com.netxforge.netxstudio.metrics.MetricsFactory;

import com.netxforge.scheduling.provider.NetxstudioEditPlugin;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link com.netxforge.netxstudio.library.Library} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class LibraryItemProvider
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LibraryItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addProtocolsPropertyDescriptor(object);
			addNamePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Protocols feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addProtocolsPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Library_protocols_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Library_protocols_feature", "_UI_Library_type"),
				 LibraryPackage.Literals.LIBRARY__PROTOCOLS,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_Library_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_Library_name_feature", "_UI_Library_type"),
				 LibraryPackage.Literals.LIBRARY__NAME,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
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
			childrenFeatures.add(LibraryPackage.Literals.LIBRARY__FUNCTIONS);
			childrenFeatures.add(LibraryPackage.Literals.LIBRARY__NODE_TYPES);
			childrenFeatures.add(LibraryPackage.Literals.LIBRARY__EQUIPMENTS);
			childrenFeatures.add(LibraryPackage.Literals.LIBRARY__METRICS);
			childrenFeatures.add(LibraryPackage.Literals.LIBRARY__METRIC_SOURCES);
			childrenFeatures.add(LibraryPackage.Literals.LIBRARY__PARAMETERS);
			childrenFeatures.add(LibraryPackage.Literals.LIBRARY__TOLERANCES);
			childrenFeatures.add(LibraryPackage.Literals.LIBRARY__EXPRESSIONS);
			childrenFeatures.add(LibraryPackage.Literals.LIBRARY__UNITS);
			childrenFeatures.add(LibraryPackage.Literals.LIBRARY__VERSION);
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
	 * This returns Library.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Library"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Library)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_Library_type") :
			getString("_UI_Library_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(Library.class)) {
			case LibraryPackage.LIBRARY__PROTOCOLS:
			case LibraryPackage.LIBRARY__NAME:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case LibraryPackage.LIBRARY__FUNCTIONS:
			case LibraryPackage.LIBRARY__NODE_TYPES:
			case LibraryPackage.LIBRARY__EQUIPMENTS:
			case LibraryPackage.LIBRARY__METRICS:
			case LibraryPackage.LIBRARY__METRIC_SOURCES:
			case LibraryPackage.LIBRARY__PARAMETERS:
			case LibraryPackage.LIBRARY__TOLERANCES:
			case LibraryPackage.LIBRARY__EXPRESSIONS:
			case LibraryPackage.LIBRARY__UNITS:
			case LibraryPackage.LIBRARY__VERSION:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(LibraryPackage.Literals.LIBRARY__FUNCTIONS,
				 LibraryFactory.eINSTANCE.createFunction()));

		newChildDescriptors.add
			(createChildParameter
				(LibraryPackage.Literals.LIBRARY__NODE_TYPES,
				 LibraryFactory.eINSTANCE.createNodeType()));

		newChildDescriptors.add
			(createChildParameter
				(LibraryPackage.Literals.LIBRARY__EQUIPMENTS,
				 LibraryFactory.eINSTANCE.createEquipment()));

		newChildDescriptors.add
			(createChildParameter
				(LibraryPackage.Literals.LIBRARY__METRICS,
				 MetricsFactory.eINSTANCE.createMetric()));

		newChildDescriptors.add
			(createChildParameter
				(LibraryPackage.Literals.LIBRARY__METRIC_SOURCES,
				 MetricsFactory.eINSTANCE.createMetricSource()));

		newChildDescriptors.add
			(createChildParameter
				(LibraryPackage.Literals.LIBRARY__PARAMETERS,
				 LibraryFactory.eINSTANCE.createParameter()));

		newChildDescriptors.add
			(createChildParameter
				(LibraryPackage.Literals.LIBRARY__TOLERANCES,
				 LibraryFactory.eINSTANCE.createTolerance()));

		newChildDescriptors.add
			(createChildParameter
				(LibraryPackage.Literals.LIBRARY__EXPRESSIONS,
				 LibraryFactory.eINSTANCE.createExpression()));

		newChildDescriptors.add
			(createChildParameter
				(LibraryPackage.Literals.LIBRARY__UNITS,
				 LibraryFactory.eINSTANCE.createUnit()));

		newChildDescriptors.add
			(createChildParameter
				(LibraryPackage.Literals.LIBRARY__VERSION,
				 GenericsFactory.eINSTANCE.createMeta()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return NetxstudioEditPlugin.INSTANCE;
	}

}
