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
package com.netxforge.netxstudio.delta16042013.metrics.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import com.netxforge.netxstudio.delta16042013.generics.Base;
import com.netxforge.netxstudio.delta16042013.generics.Rule;
import com.netxforge.netxstudio.delta16042013.metrics.*;
import com.netxforge.netxstudio.delta16042013.metrics.Addon;
import com.netxforge.netxstudio.delta16042013.metrics.Metric;
import com.netxforge.netxstudio.delta16042013.metrics.MetricAggregationRule;
import com.netxforge.netxstudio.delta16042013.metrics.MetricAggregationRules;
import com.netxforge.netxstudio.delta16042013.metrics.MetricRetentionPeriods;
import com.netxforge.netxstudio.delta16042013.metrics.MetricRetentionRule;
import com.netxforge.netxstudio.delta16042013.metrics.MetricRetentionRules;
import com.netxforge.netxstudio.delta16042013.metrics.MetricSource;
import com.netxforge.netxstudio.delta16042013.metrics.MetricsPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.netxforge.netxstudio.delta16042013.metrics.MetricsPackage
 * @generated
 */
public class MetricsAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static MetricsPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetricsAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = MetricsPackage.eINSTANCE;
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
	protected MetricsSwitch<Adapter> modelSwitch =
		new MetricsSwitch<Adapter>() {
			@Override
			public Adapter caseAddon(Addon object) {
				return createAddonAdapter();
			}
			@Override
			public Adapter caseMetric(Metric object) {
				return createMetricAdapter();
			}
			@Override
			public Adapter caseMetricAggregationRule(MetricAggregationRule object) {
				return createMetricAggregationRuleAdapter();
			}
			@Override
			public Adapter caseMetricAggregationRules(MetricAggregationRules object) {
				return createMetricAggregationRulesAdapter();
			}
			@Override
			public Adapter caseMetricRetentionPeriods(MetricRetentionPeriods object) {
				return createMetricRetentionPeriodsAdapter();
			}
			@Override
			public Adapter caseMetricRetentionRule(MetricRetentionRule object) {
				return createMetricRetentionRuleAdapter();
			}
			@Override
			public Adapter caseMetricRetentionRules(MetricRetentionRules object) {
				return createMetricRetentionRulesAdapter();
			}
			@Override
			public Adapter caseMetricSource(MetricSource object) {
				return createMetricSourceAdapter();
			}
			@Override
			public Adapter caseBase(Base object) {
				return createBaseAdapter();
			}
			@Override
			public Adapter caseRule(Rule object) {
				return createRuleAdapter();
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
	 * Creates a new adapter for an object of class '{@link com.netxforge.netxstudio.delta16042013.metrics.Addon <em>Addon</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.netxforge.netxstudio.delta16042013.metrics.Addon
	 * @generated
	 */
	public Adapter createAddonAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.netxforge.netxstudio.delta16042013.metrics.Metric <em>Metric</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.netxforge.netxstudio.delta16042013.metrics.Metric
	 * @generated
	 */
	public Adapter createMetricAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.netxforge.netxstudio.delta16042013.metrics.MetricAggregationRule <em>Metric Aggregation Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.netxforge.netxstudio.delta16042013.metrics.MetricAggregationRule
	 * @generated
	 */
	public Adapter createMetricAggregationRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.netxforge.netxstudio.delta16042013.metrics.MetricAggregationRules <em>Metric Aggregation Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.netxforge.netxstudio.delta16042013.metrics.MetricAggregationRules
	 * @generated
	 */
	public Adapter createMetricAggregationRulesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.netxforge.netxstudio.delta16042013.metrics.MetricRetentionPeriods <em>Metric Retention Periods</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.netxforge.netxstudio.delta16042013.metrics.MetricRetentionPeriods
	 * @generated
	 */
	public Adapter createMetricRetentionPeriodsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.netxforge.netxstudio.delta16042013.metrics.MetricRetentionRule <em>Metric Retention Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.netxforge.netxstudio.delta16042013.metrics.MetricRetentionRule
	 * @generated
	 */
	public Adapter createMetricRetentionRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.netxforge.netxstudio.delta16042013.metrics.MetricRetentionRules <em>Metric Retention Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.netxforge.netxstudio.delta16042013.metrics.MetricRetentionRules
	 * @generated
	 */
	public Adapter createMetricRetentionRulesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.netxforge.netxstudio.delta16042013.metrics.MetricSource <em>Metric Source</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.netxforge.netxstudio.delta16042013.metrics.MetricSource
	 * @generated
	 */
	public Adapter createMetricSourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.netxforge.netxstudio.delta16042013.generics.Rule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.netxforge.netxstudio.delta16042013.generics.Rule
	 * @generated
	 */
	public Adapter createRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.netxforge.netxstudio.delta16042013.generics.Base <em>Base</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.netxforge.netxstudio.delta16042013.generics.Base
	 * @generated
	 */
	public Adapter createBaseAdapter() {
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

} //MetricsAdapterFactory
