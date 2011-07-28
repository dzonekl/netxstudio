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
package com.netxforge.netxstudio.metrics.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import com.netxforge.netxstudio.generics.Base;
import com.netxforge.netxstudio.metrics.*;
import com.netxforge.netxstudio.metrics.DataKind;
import com.netxforge.netxstudio.metrics.IdentifierDataKind;
import com.netxforge.netxstudio.metrics.Mapping;
import com.netxforge.netxstudio.metrics.MappingCSV;
import com.netxforge.netxstudio.metrics.MappingColumn;
import com.netxforge.netxstudio.metrics.MappingRDBMS;
import com.netxforge.netxstudio.metrics.MappingRecord;
import com.netxforge.netxstudio.metrics.MappingStatistic;
import com.netxforge.netxstudio.metrics.MappingXLS;
import com.netxforge.netxstudio.metrics.Metric;
import com.netxforge.netxstudio.metrics.MetricRetentionRule;
import com.netxforge.netxstudio.metrics.MetricRetentionRules;
import com.netxforge.netxstudio.metrics.MetricSource;
import com.netxforge.netxstudio.metrics.MetricValueRange;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.metrics.ValueDataKind;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.netxforge.netxstudio.metrics.MetricsPackage
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
			public Adapter caseDataKind(DataKind object) {
				return createDataKindAdapter();
			}
			@Override
			public Adapter caseIdentifierDataKind(IdentifierDataKind object) {
				return createIdentifierDataKindAdapter();
			}
			@Override
			public Adapter caseMapping(Mapping object) {
				return createMappingAdapter();
			}
			@Override
			public Adapter caseMappingColumn(MappingColumn object) {
				return createMappingColumnAdapter();
			}
			@Override
			public Adapter caseMappingCSV(MappingCSV object) {
				return createMappingCSVAdapter();
			}
			@Override
			public Adapter caseMappingRDBMS(MappingRDBMS object) {
				return createMappingRDBMSAdapter();
			}
			@Override
			public Adapter caseMappingRecord(MappingRecord object) {
				return createMappingRecordAdapter();
			}
			@Override
			public Adapter caseMappingStatistic(MappingStatistic object) {
				return createMappingStatisticAdapter();
			}
			@Override
			public Adapter caseMappingXLS(MappingXLS object) {
				return createMappingXLSAdapter();
			}
			@Override
			public Adapter caseMetric(Metric object) {
				return createMetricAdapter();
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
			public Adapter caseMetricValueRange(MetricValueRange object) {
				return createMetricValueRangeAdapter();
			}
			@Override
			public Adapter caseValueDataKind(ValueDataKind object) {
				return createValueDataKindAdapter();
			}
			@Override
			public Adapter caseBase(Base object) {
				return createBaseAdapter();
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
	 * Creates a new adapter for an object of class '{@link com.netxforge.netxstudio.metrics.DataKind <em>Data Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.netxforge.netxstudio.metrics.DataKind
	 * @generated
	 */
	public Adapter createDataKindAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.netxforge.netxstudio.metrics.IdentifierDataKind <em>Identifier Data Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.netxforge.netxstudio.metrics.IdentifierDataKind
	 * @generated
	 */
	public Adapter createIdentifierDataKindAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.netxforge.netxstudio.metrics.Mapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.netxforge.netxstudio.metrics.Mapping
	 * @generated
	 */
	public Adapter createMappingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.netxforge.netxstudio.metrics.MappingColumn <em>Mapping Column</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.netxforge.netxstudio.metrics.MappingColumn
	 * @generated
	 */
	public Adapter createMappingColumnAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.netxforge.netxstudio.metrics.MappingCSV <em>Mapping CSV</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.netxforge.netxstudio.metrics.MappingCSV
	 * @generated
	 */
	public Adapter createMappingCSVAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.netxforge.netxstudio.metrics.MappingRDBMS <em>Mapping RDBMS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.netxforge.netxstudio.metrics.MappingRDBMS
	 * @generated
	 */
	public Adapter createMappingRDBMSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.netxforge.netxstudio.metrics.MappingRecord <em>Mapping Record</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.netxforge.netxstudio.metrics.MappingRecord
	 * @generated
	 */
	public Adapter createMappingRecordAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.netxforge.netxstudio.metrics.MappingStatistic <em>Mapping Statistic</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.netxforge.netxstudio.metrics.MappingStatistic
	 * @generated
	 */
	public Adapter createMappingStatisticAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.netxforge.netxstudio.metrics.MappingXLS <em>Mapping XLS</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.netxforge.netxstudio.metrics.MappingXLS
	 * @generated
	 */
	public Adapter createMappingXLSAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.netxforge.netxstudio.metrics.Metric <em>Metric</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.netxforge.netxstudio.metrics.Metric
	 * @generated
	 */
	public Adapter createMetricAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.netxforge.netxstudio.metrics.MetricRetentionRule <em>Metric Retention Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.netxforge.netxstudio.metrics.MetricRetentionRule
	 * @generated
	 */
	public Adapter createMetricRetentionRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.netxforge.netxstudio.metrics.MetricRetentionRules <em>Metric Retention Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.netxforge.netxstudio.metrics.MetricRetentionRules
	 * @generated
	 */
	public Adapter createMetricRetentionRulesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.netxforge.netxstudio.metrics.MetricSource <em>Metric Source</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.netxforge.netxstudio.metrics.MetricSource
	 * @generated
	 */
	public Adapter createMetricSourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.netxforge.netxstudio.metrics.MetricValueRange <em>Metric Value Range</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.netxforge.netxstudio.metrics.MetricValueRange
	 * @generated
	 */
	public Adapter createMetricValueRangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.netxforge.netxstudio.metrics.ValueDataKind <em>Value Data Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.netxforge.netxstudio.metrics.ValueDataKind
	 * @generated
	 */
	public Adapter createValueDataKindAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.netxforge.netxstudio.generics.Base <em>Base</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.netxforge.netxstudio.generics.Base
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
