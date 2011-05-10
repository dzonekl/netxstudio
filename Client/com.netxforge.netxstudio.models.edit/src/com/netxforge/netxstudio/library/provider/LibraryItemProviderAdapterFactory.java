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
package com.netxforge.netxstudio.library.provider;

import com.netxforge.netxstudio.library.util.LibraryAdapterFactory;

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

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class LibraryItemProviderAdapterFactory extends LibraryAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
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
	public LibraryItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.netxforge.netxstudio.library.Equipment} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EquipmentItemProvider equipmentItemProvider;

	/**
	 * This creates an adapter for a {@link com.netxforge.netxstudio.library.Equipment}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEquipmentAdapter() {
		if (equipmentItemProvider == null) {
			equipmentItemProvider = new EquipmentItemProvider(this);
		}

		return equipmentItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.netxforge.netxstudio.library.EquipmentGroup} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EquipmentGroupItemProvider equipmentGroupItemProvider;

	/**
	 * This creates an adapter for a {@link com.netxforge.netxstudio.library.EquipmentGroup}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEquipmentGroupAdapter() {
		if (equipmentGroupItemProvider == null) {
			equipmentGroupItemProvider = new EquipmentGroupItemProvider(this);
		}

		return equipmentGroupItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.netxforge.netxstudio.library.Expression} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExpressionItemProvider expressionItemProvider;

	/**
	 * This creates an adapter for a {@link com.netxforge.netxstudio.library.Expression}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createExpressionAdapter() {
		if (expressionItemProvider == null) {
			expressionItemProvider = new ExpressionItemProvider(this);
		}

		return expressionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.netxforge.netxstudio.library.Function} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionItemProvider functionItemProvider;

	/**
	 * This creates an adapter for a {@link com.netxforge.netxstudio.library.Function}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createFunctionAdapter() {
		if (functionItemProvider == null) {
			functionItemProvider = new FunctionItemProvider(this);
		}

		return functionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.netxforge.netxstudio.library.Library} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LibraryItemProvider libraryItemProvider;

	/**
	 * This creates an adapter for a {@link com.netxforge.netxstudio.library.Library}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createLibraryAdapter() {
		if (libraryItemProvider == null) {
			libraryItemProvider = new LibraryItemProvider(this);
		}

		return libraryItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.netxforge.netxstudio.library.NetXResource} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NetXResourceItemProvider netXResourceItemProvider;

	/**
	 * This creates an adapter for a {@link com.netxforge.netxstudio.library.NetXResource}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createNetXResourceAdapter() {
		if (netXResourceItemProvider == null) {
			netXResourceItemProvider = new NetXResourceItemProvider(this);
		}

		return netXResourceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.netxforge.netxstudio.library.NodeType} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NodeTypeItemProvider nodeTypeItemProvider;

	/**
	 * This creates an adapter for a {@link com.netxforge.netxstudio.library.NodeType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createNodeTypeAdapter() {
		if (nodeTypeItemProvider == null) {
			nodeTypeItemProvider = new NodeTypeItemProvider(this);
		}

		return nodeTypeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.netxforge.netxstudio.library.Parameter} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParameterItemProvider parameterItemProvider;

	/**
	 * This creates an adapter for a {@link com.netxforge.netxstudio.library.Parameter}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createParameterAdapter() {
		if (parameterItemProvider == null) {
			parameterItemProvider = new ParameterItemProvider(this);
		}

		return parameterItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.netxforge.netxstudio.library.ProductInfo} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProductInfoItemProvider productInfoItemProvider;

	/**
	 * This creates an adapter for a {@link com.netxforge.netxstudio.library.ProductInfo}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createProductInfoAdapter() {
		if (productInfoItemProvider == null) {
			productInfoItemProvider = new ProductInfoItemProvider(this);
		}

		return productInfoItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.netxforge.netxstudio.library.Tolerance} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ToleranceItemProvider toleranceItemProvider;

	/**
	 * This creates an adapter for a {@link com.netxforge.netxstudio.library.Tolerance}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createToleranceAdapter() {
		if (toleranceItemProvider == null) {
			toleranceItemProvider = new ToleranceItemProvider(this);
		}

		return toleranceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.netxforge.netxstudio.library.Unit} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UnitItemProvider unitItemProvider;

	/**
	 * This creates an adapter for a {@link com.netxforge.netxstudio.library.Unit}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createUnitAdapter() {
		if (unitItemProvider == null) {
			unitItemProvider = new UnitItemProvider(this);
		}

		return unitItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.netxforge.netxstudio.library.Vendor} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VendorItemProvider vendorItemProvider;

	/**
	 * This creates an adapter for a {@link com.netxforge.netxstudio.library.Vendor}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createVendorAdapter() {
		if (vendorItemProvider == null) {
			vendorItemProvider = new VendorItemProvider(this);
		}

		return vendorItemProvider;
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
		if (equipmentItemProvider != null) equipmentItemProvider.dispose();
		if (equipmentGroupItemProvider != null) equipmentGroupItemProvider.dispose();
		if (expressionItemProvider != null) expressionItemProvider.dispose();
		if (functionItemProvider != null) functionItemProvider.dispose();
		if (libraryItemProvider != null) libraryItemProvider.dispose();
		if (netXResourceItemProvider != null) netXResourceItemProvider.dispose();
		if (nodeTypeItemProvider != null) nodeTypeItemProvider.dispose();
		if (parameterItemProvider != null) parameterItemProvider.dispose();
		if (productInfoItemProvider != null) productInfoItemProvider.dispose();
		if (toleranceItemProvider != null) toleranceItemProvider.dispose();
		if (unitItemProvider != null) unitItemProvider.dispose();
		if (vendorItemProvider != null) vendorItemProvider.dispose();
	}

}
