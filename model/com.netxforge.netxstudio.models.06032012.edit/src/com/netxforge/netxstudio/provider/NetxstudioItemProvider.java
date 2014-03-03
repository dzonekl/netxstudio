/**
 * Copyright (c) 2011 NetXForge
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
package com.netxforge.netxstudio.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;

import com.netxforge.netxstudio.Netxstudio;
import com.netxforge.netxstudio.NetxstudioPackage;
import com.netxforge.netxstudio.edit.MotherOfAllItemProvider;
import com.netxforge.netxstudio.generics.GenericsFactory;
import com.netxforge.netxstudio.geo.GeoFactory;
import com.netxforge.netxstudio.library.LibraryFactory;
import com.netxforge.netxstudio.operators.OperatorsFactory;
import com.netxforge.netxstudio.scheduling.SchedulingFactory;
import com.netxforge.netxstudio.scheduling.provider.NetxstudioEditPlugin;

/**
 * This is the item provider adapter for a {@link com.netxforge.netxstudio.Netxstudio} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class NetxstudioItemProvider
	extends MotherOfAllItemProvider
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
	public NetxstudioItemProvider(AdapterFactory adapterFactory) {
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
			childrenFeatures.add(NetxstudioPackage.Literals.NETXSTUDIO__OPERATORS);
			childrenFeatures.add(NetxstudioPackage.Literals.NETXSTUDIO__LIBRARIES);
			childrenFeatures.add(NetxstudioPackage.Literals.NETXSTUDIO__COMPANIES);
			childrenFeatures.add(NetxstudioPackage.Literals.NETXSTUDIO__VENDORS);
			childrenFeatures.add(NetxstudioPackage.Literals.NETXSTUDIO__USERS);
			childrenFeatures.add(NetxstudioPackage.Literals.NETXSTUDIO__ROLES);
			childrenFeatures.add(NetxstudioPackage.Literals.NETXSTUDIO__COUNTRIES);
			childrenFeatures.add(NetxstudioPackage.Literals.NETXSTUDIO__JOBS);
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
	 * This returns Netxstudio.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Netxstudio"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * CB Adapted 17-01-2012, to show the calculated label between quotes. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_Netxstudio_type");
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

		switch (notification.getFeatureID(Netxstudio.class)) {
			case NetxstudioPackage.NETXSTUDIO__OPERATORS:
			case NetxstudioPackage.NETXSTUDIO__LIBRARIES:
			case NetxstudioPackage.NETXSTUDIO__COMPANIES:
			case NetxstudioPackage.NETXSTUDIO__VENDORS:
			case NetxstudioPackage.NETXSTUDIO__USERS:
			case NetxstudioPackage.NETXSTUDIO__ROLES:
			case NetxstudioPackage.NETXSTUDIO__COUNTRIES:
			case NetxstudioPackage.NETXSTUDIO__JOBS:
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
				(NetxstudioPackage.Literals.NETXSTUDIO__OPERATORS,
				 OperatorsFactory.eINSTANCE.createOperator()));

		newChildDescriptors.add
			(createChildParameter
				(NetxstudioPackage.Literals.NETXSTUDIO__LIBRARIES,
				 LibraryFactory.eINSTANCE.createLibrary()));

		newChildDescriptors.add
			(createChildParameter
				(NetxstudioPackage.Literals.NETXSTUDIO__COMPANIES,
				 GenericsFactory.eINSTANCE.createCompany()));

		newChildDescriptors.add
			(createChildParameter
				(NetxstudioPackage.Literals.NETXSTUDIO__COMPANIES,
				 LibraryFactory.eINSTANCE.createVendor()));

		newChildDescriptors.add
			(createChildParameter
				(NetxstudioPackage.Literals.NETXSTUDIO__COMPANIES,
				 OperatorsFactory.eINSTANCE.createOperator()));

		newChildDescriptors.add
			(createChildParameter
				(NetxstudioPackage.Literals.NETXSTUDIO__VENDORS,
				 LibraryFactory.eINSTANCE.createVendor()));

		newChildDescriptors.add
			(createChildParameter
				(NetxstudioPackage.Literals.NETXSTUDIO__USERS,
				 GenericsFactory.eINSTANCE.createPerson()));

		newChildDescriptors.add
			(createChildParameter
				(NetxstudioPackage.Literals.NETXSTUDIO__ROLES,
				 GenericsFactory.eINSTANCE.createRole()));

		newChildDescriptors.add
			(createChildParameter
				(NetxstudioPackage.Literals.NETXSTUDIO__COUNTRIES,
				 GeoFactory.eINSTANCE.createCountry()));

		newChildDescriptors.add
			(createChildParameter
				(NetxstudioPackage.Literals.NETXSTUDIO__JOBS,
				 SchedulingFactory.eINSTANCE.createJob()));

		newChildDescriptors.add
			(createChildParameter
				(NetxstudioPackage.Literals.NETXSTUDIO__JOBS,
				 SchedulingFactory.eINSTANCE.createAnalyzerJob()));

		newChildDescriptors.add
			(createChildParameter
				(NetxstudioPackage.Literals.NETXSTUDIO__JOBS,
				 SchedulingFactory.eINSTANCE.createMetricSourceJob()));

		newChildDescriptors.add
			(createChildParameter
				(NetxstudioPackage.Literals.NETXSTUDIO__JOBS,
				 SchedulingFactory.eINSTANCE.createNodeReporterJob()));

		newChildDescriptors.add
			(createChildParameter
				(NetxstudioPackage.Literals.NETXSTUDIO__JOBS,
				 SchedulingFactory.eINSTANCE.createNodeTypeReporterJob()));

		newChildDescriptors.add
			(createChildParameter
				(NetxstudioPackage.Literals.NETXSTUDIO__JOBS,
				 SchedulingFactory.eINSTANCE.createOperatorReporterJob()));

		newChildDescriptors.add
			(createChildParameter
				(NetxstudioPackage.Literals.NETXSTUDIO__JOBS,
				 SchedulingFactory.eINSTANCE.createRetentionJob()));

		newChildDescriptors.add
			(createChildParameter
				(NetxstudioPackage.Literals.NETXSTUDIO__JOBS,
				 SchedulingFactory.eINSTANCE.createRFSServiceMonitoringJob()));

		newChildDescriptors.add
			(createChildParameter
				(NetxstudioPackage.Literals.NETXSTUDIO__JOBS,
				 SchedulingFactory.eINSTANCE.createRFSServiceReporterJob()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == NetxstudioPackage.Literals.NETXSTUDIO__OPERATORS ||
			childFeature == NetxstudioPackage.Literals.NETXSTUDIO__COMPANIES ||
			childFeature == NetxstudioPackage.Literals.NETXSTUDIO__VENDORS;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
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
