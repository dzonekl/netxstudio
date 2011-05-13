/**
 * Copyright (c) ${date} NetXForge
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
package com.netxforge.netxstudio.operators.provider;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

import com.netxforge.netxstudio.operators.util.OperatorsAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class OperatorsItemProviderAdapterFactory extends OperatorsAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperatorsItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.netxforge.netxstudio.operators.EquipmentRelationship} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EquipmentRelationshipItemProvider equipmentRelationshipItemProvider;

	/**
	 * This creates an adapter for a {@link com.netxforge.netxstudio.operators.EquipmentRelationship}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEquipmentRelationshipAdapter() {
		if (equipmentRelationshipItemProvider == null) {
			equipmentRelationshipItemProvider = new EquipmentRelationshipItemProvider(this);
		}

		return equipmentRelationshipItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.netxforge.netxstudio.operators.ExpansionExperience} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExpansionExperienceItemProvider expansionExperienceItemProvider;

	/**
	 * This creates an adapter for a {@link com.netxforge.netxstudio.operators.ExpansionExperience}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createExpansionExperienceAdapter() {
		if (expansionExperienceItemProvider == null) {
			expansionExperienceItemProvider = new ExpansionExperienceItemProvider(this);
		}

		return expansionExperienceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.netxforge.netxstudio.operators.FunctionRelationship} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionRelationshipItemProvider functionRelationshipItemProvider;

	/**
	 * This creates an adapter for a {@link com.netxforge.netxstudio.operators.FunctionRelationship}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createFunctionRelationshipAdapter() {
		if (functionRelationshipItemProvider == null) {
			functionRelationshipItemProvider = new FunctionRelationshipItemProvider(this);
		}

		return functionRelationshipItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.netxforge.netxstudio.operators.Marker} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MarkerItemProvider markerItemProvider;

	/**
	 * This creates an adapter for a {@link com.netxforge.netxstudio.operators.Marker}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMarkerAdapter() {
		if (markerItemProvider == null) {
			markerItemProvider = new MarkerItemProvider(this);
		}

		return markerItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.netxforge.netxstudio.operators.Network} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NetworkItemProvider networkItemProvider;

	/**
	 * This creates an adapter for a {@link com.netxforge.netxstudio.operators.Network}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createNetworkAdapter() {
		if (networkItemProvider == null) {
			networkItemProvider = new NetworkItemProvider(this);
		}

		return networkItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.netxforge.netxstudio.operators.Node} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NodeItemProvider nodeItemProvider;

	/**
	 * This creates an adapter for a {@link com.netxforge.netxstudio.operators.Node}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createNodeAdapter() {
		if (nodeItemProvider == null) {
			nodeItemProvider = new NodeItemProvider(this);
		}

		return nodeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.netxforge.netxstudio.operators.Operator} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperatorItemProvider operatorItemProvider;

	/**
	 * This creates an adapter for a {@link com.netxforge.netxstudio.operators.Operator}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createOperatorAdapter() {
		if (operatorItemProvider == null) {
			operatorItemProvider = new OperatorItemProvider(this);
		}

		return operatorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.netxforge.netxstudio.operators.Relationship} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RelationshipItemProvider relationshipItemProvider;

	/**
	 * This creates an adapter for a {@link com.netxforge.netxstudio.operators.Relationship}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRelationshipAdapter() {
		if (relationshipItemProvider == null) {
			relationshipItemProvider = new RelationshipItemProvider(this);
		}

		return relationshipItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.netxforge.netxstudio.operators.ResourceExpansion} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceExpansionItemProvider resourceExpansionItemProvider;

	/**
	 * This creates an adapter for a {@link com.netxforge.netxstudio.operators.ResourceExpansion}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createResourceExpansionAdapter() {
		if (resourceExpansionItemProvider == null) {
			resourceExpansionItemProvider = new ResourceExpansionItemProvider(this);
		}

		return resourceExpansionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.netxforge.netxstudio.operators.ResourceForecast} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceForecastItemProvider resourceForecastItemProvider;

	/**
	 * This creates an adapter for a {@link com.netxforge.netxstudio.operators.ResourceForecast}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createResourceForecastAdapter() {
		if (resourceForecastItemProvider == null) {
			resourceForecastItemProvider = new ResourceForecastItemProvider(this);
		}

		return resourceForecastItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.netxforge.netxstudio.operators.ResourceMonitor} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceMonitorItemProvider resourceMonitorItemProvider;

	/**
	 * This creates an adapter for a {@link com.netxforge.netxstudio.operators.ResourceMonitor}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createResourceMonitorAdapter() {
		if (resourceMonitorItemProvider == null) {
			resourceMonitorItemProvider = new ResourceMonitorItemProvider(this);
		}

		return resourceMonitorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.netxforge.netxstudio.operators.Warehouse} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WarehouseItemProvider warehouseItemProvider;

	/**
	 * This creates an adapter for a {@link com.netxforge.netxstudio.operators.Warehouse}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createWarehouseAdapter() {
		if (warehouseItemProvider == null) {
			warehouseItemProvider = new WarehouseItemProvider(this);
		}

		return warehouseItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (equipmentRelationshipItemProvider != null) equipmentRelationshipItemProvider.dispose();
		if (expansionExperienceItemProvider != null) expansionExperienceItemProvider.dispose();
		if (functionRelationshipItemProvider != null) functionRelationshipItemProvider.dispose();
		if (markerItemProvider != null) markerItemProvider.dispose();
		if (networkItemProvider != null) networkItemProvider.dispose();
		if (nodeItemProvider != null) nodeItemProvider.dispose();
		if (operatorItemProvider != null) operatorItemProvider.dispose();
		if (relationshipItemProvider != null) relationshipItemProvider.dispose();
		if (resourceExpansionItemProvider != null) resourceExpansionItemProvider.dispose();
		if (resourceForecastItemProvider != null) resourceForecastItemProvider.dispose();
		if (resourceMonitorItemProvider != null) resourceMonitorItemProvider.dispose();
		if (warehouseItemProvider != null) warehouseItemProvider.dispose();
	}

}
