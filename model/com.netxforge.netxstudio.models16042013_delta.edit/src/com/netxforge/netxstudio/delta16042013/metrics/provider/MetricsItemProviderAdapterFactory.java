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
package com.netxforge.netxstudio.delta16042013.metrics.provider;

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

import com.netxforge.netxstudio.delta16042013.metrics.util.MetricsAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class MetricsItemProviderAdapterFactory extends MetricsAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
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
	public MetricsItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.netxforge.netxstudio.delta16042013.metrics.Addon} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AddonItemProvider addonItemProvider;

	/**
	 * This creates an adapter for a {@link com.netxforge.netxstudio.delta16042013.metrics.Addon}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createAddonAdapter() {
		if (addonItemProvider == null) {
			addonItemProvider = new AddonItemProvider(this);
		}

		return addonItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.netxforge.netxstudio.delta16042013.metrics.Metric} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MetricItemProvider metricItemProvider;

	/**
	 * This creates an adapter for a {@link com.netxforge.netxstudio.delta16042013.metrics.Metric}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMetricAdapter() {
		if (metricItemProvider == null) {
			metricItemProvider = new MetricItemProvider(this);
		}

		return metricItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.netxforge.netxstudio.delta16042013.metrics.MetricAggregationRule} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MetricAggregationRuleItemProvider metricAggregationRuleItemProvider;

	/**
	 * This creates an adapter for a {@link com.netxforge.netxstudio.delta16042013.metrics.MetricAggregationRule}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMetricAggregationRuleAdapter() {
		if (metricAggregationRuleItemProvider == null) {
			metricAggregationRuleItemProvider = new MetricAggregationRuleItemProvider(this);
		}

		return metricAggregationRuleItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.netxforge.netxstudio.delta16042013.metrics.MetricAggregationRules} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MetricAggregationRulesItemProvider metricAggregationRulesItemProvider;

	/**
	 * This creates an adapter for a {@link com.netxforge.netxstudio.delta16042013.metrics.MetricAggregationRules}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMetricAggregationRulesAdapter() {
		if (metricAggregationRulesItemProvider == null) {
			metricAggregationRulesItemProvider = new MetricAggregationRulesItemProvider(this);
		}

		return metricAggregationRulesItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.netxforge.netxstudio.delta16042013.metrics.MetricRetentionPeriods} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MetricRetentionPeriodsItemProvider metricRetentionPeriodsItemProvider;

	/**
	 * This creates an adapter for a {@link com.netxforge.netxstudio.delta16042013.metrics.MetricRetentionPeriods}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMetricRetentionPeriodsAdapter() {
		if (metricRetentionPeriodsItemProvider == null) {
			metricRetentionPeriodsItemProvider = new MetricRetentionPeriodsItemProvider(this);
		}

		return metricRetentionPeriodsItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.netxforge.netxstudio.delta16042013.metrics.MetricRetentionRule} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MetricRetentionRuleItemProvider metricRetentionRuleItemProvider;

	/**
	 * This creates an adapter for a {@link com.netxforge.netxstudio.delta16042013.metrics.MetricRetentionRule}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMetricRetentionRuleAdapter() {
		if (metricRetentionRuleItemProvider == null) {
			metricRetentionRuleItemProvider = new MetricRetentionRuleItemProvider(this);
		}

		return metricRetentionRuleItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.netxforge.netxstudio.delta16042013.metrics.MetricRetentionRules} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MetricRetentionRulesItemProvider metricRetentionRulesItemProvider;

	/**
	 * This creates an adapter for a {@link com.netxforge.netxstudio.delta16042013.metrics.MetricRetentionRules}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMetricRetentionRulesAdapter() {
		if (metricRetentionRulesItemProvider == null) {
			metricRetentionRulesItemProvider = new MetricRetentionRulesItemProvider(this);
		}

		return metricRetentionRulesItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link com.netxforge.netxstudio.delta16042013.metrics.MetricSource} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MetricSourceItemProvider metricSourceItemProvider;

	/**
	 * This creates an adapter for a {@link com.netxforge.netxstudio.delta16042013.metrics.MetricSource}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMetricSourceAdapter() {
		if (metricSourceItemProvider == null) {
			metricSourceItemProvider = new MetricSourceItemProvider(this);
		}

		return metricSourceItemProvider;
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
		if (addonItemProvider != null) addonItemProvider.dispose();
		if (metricItemProvider != null) metricItemProvider.dispose();
		if (metricAggregationRuleItemProvider != null) metricAggregationRuleItemProvider.dispose();
		if (metricAggregationRulesItemProvider != null) metricAggregationRulesItemProvider.dispose();
		if (metricRetentionPeriodsItemProvider != null) metricRetentionPeriodsItemProvider.dispose();
		if (metricRetentionRuleItemProvider != null) metricRetentionRuleItemProvider.dispose();
		if (metricRetentionRulesItemProvider != null) metricRetentionRulesItemProvider.dispose();
		if (metricSourceItemProvider != null) metricSourceItemProvider.dispose();
	}

}
