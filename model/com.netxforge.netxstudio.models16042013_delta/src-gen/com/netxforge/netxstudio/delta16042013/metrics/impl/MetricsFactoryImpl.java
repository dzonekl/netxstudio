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
package com.netxforge.netxstudio.delta16042013.metrics.impl;

import com.netxforge.netxstudio.delta16042013.metrics.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import com.netxforge.netxstudio.delta16042013.metrics.Addon;
import com.netxforge.netxstudio.delta16042013.metrics.FixedMetricRetentionPeriod;
import com.netxforge.netxstudio.delta16042013.metrics.Metric;
import com.netxforge.netxstudio.delta16042013.metrics.MetricAggregationRule;
import com.netxforge.netxstudio.delta16042013.metrics.MetricAggregationRules;
import com.netxforge.netxstudio.delta16042013.metrics.MetricRetentionPeriods;
import com.netxforge.netxstudio.delta16042013.metrics.MetricRetentionRule;
import com.netxforge.netxstudio.delta16042013.metrics.MetricRetentionRules;
import com.netxforge.netxstudio.delta16042013.metrics.MetricSource;
import com.netxforge.netxstudio.delta16042013.metrics.MetricsFactory;
import com.netxforge.netxstudio.delta16042013.metrics.MetricsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MetricsFactoryImpl extends EFactoryImpl implements MetricsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MetricsFactory init() {
		try {
			MetricsFactory theMetricsFactory = (MetricsFactory)EPackage.Registry.INSTANCE.getEFactory(MetricsPackage.eNS_URI);
			if (theMetricsFactory != null) {
				return theMetricsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MetricsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetricsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case MetricsPackage.ADDON: return createAddon();
			case MetricsPackage.METRIC: return createMetric();
			case MetricsPackage.METRIC_AGGREGATION_RULE: return createMetricAggregationRule();
			case MetricsPackage.METRIC_AGGREGATION_RULES: return createMetricAggregationRules();
			case MetricsPackage.METRIC_RETENTION_PERIODS: return createMetricRetentionPeriods();
			case MetricsPackage.METRIC_RETENTION_RULE: return createMetricRetentionRule();
			case MetricsPackage.METRIC_RETENTION_RULES: return createMetricRetentionRules();
			case MetricsPackage.METRIC_SOURCE: return createMetricSource();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case MetricsPackage.FIXED_METRIC_RETENTION_PERIOD:
				return createFixedMetricRetentionPeriodFromString(eDataType, initialValue);
			case MetricsPackage.FIXED_METRIC_RETENTION_PERIOD_OBJECT:
				return createFixedMetricRetentionPeriodObjectFromString(eDataType, initialValue);
			case MetricsPackage.METRIC_RETENTION_PERIOD:
				return createMetricRetentionPeriodFromString(eDataType, initialValue);
			case MetricsPackage.USER_METRIC_RETENTION_PERIOD:
				return createUserMetricRetentionPeriodFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case MetricsPackage.FIXED_METRIC_RETENTION_PERIOD:
				return convertFixedMetricRetentionPeriodToString(eDataType, instanceValue);
			case MetricsPackage.FIXED_METRIC_RETENTION_PERIOD_OBJECT:
				return convertFixedMetricRetentionPeriodObjectToString(eDataType, instanceValue);
			case MetricsPackage.METRIC_RETENTION_PERIOD:
				return convertMetricRetentionPeriodToString(eDataType, instanceValue);
			case MetricsPackage.USER_METRIC_RETENTION_PERIOD:
				return convertUserMetricRetentionPeriodToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Addon createAddon() {
		AddonImpl addon = new AddonImpl();
		return addon;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Metric createMetric() {
		MetricImpl metric = new MetricImpl();
		return metric;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetricAggregationRule createMetricAggregationRule() {
		MetricAggregationRuleImpl metricAggregationRule = new MetricAggregationRuleImpl();
		return metricAggregationRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetricAggregationRules createMetricAggregationRules() {
		MetricAggregationRulesImpl metricAggregationRules = new MetricAggregationRulesImpl();
		return metricAggregationRules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetricRetentionPeriods createMetricRetentionPeriods() {
		MetricRetentionPeriodsImpl metricRetentionPeriods = new MetricRetentionPeriodsImpl();
		return metricRetentionPeriods;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetricRetentionRule createMetricRetentionRule() {
		MetricRetentionRuleImpl metricRetentionRule = new MetricRetentionRuleImpl();
		return metricRetentionRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetricRetentionRules createMetricRetentionRules() {
		MetricRetentionRulesImpl metricRetentionRules = new MetricRetentionRulesImpl();
		return metricRetentionRules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetricSource createMetricSource() {
		MetricSourceImpl metricSource = new MetricSourceImpl();
		return metricSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FixedMetricRetentionPeriod createFixedMetricRetentionPeriodFromString(EDataType eDataType, String initialValue) {
		FixedMetricRetentionPeriod result = FixedMetricRetentionPeriod.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFixedMetricRetentionPeriodToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FixedMetricRetentionPeriod createFixedMetricRetentionPeriodObjectFromString(EDataType eDataType, String initialValue) {
		return createFixedMetricRetentionPeriodFromString(MetricsPackage.Literals.FIXED_METRIC_RETENTION_PERIOD, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFixedMetricRetentionPeriodObjectToString(EDataType eDataType, Object instanceValue) {
		return convertFixedMetricRetentionPeriodToString(MetricsPackage.Literals.FIXED_METRIC_RETENTION_PERIOD, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object createMetricRetentionPeriodFromString(EDataType eDataType, String initialValue) {
		if (initialValue == null) return null;
		Object result = null;
		RuntimeException exception = null;
		try {
			result = createUserMetricRetentionPeriodFromString(MetricsPackage.Literals.USER_METRIC_RETENTION_PERIOD, initialValue);
			if (result != null && Diagnostician.INSTANCE.validate(eDataType, result, null, null)) {
				return result;
			}
		}
		catch (RuntimeException e) {
			exception = e;
		}
		try {
			result = createFixedMetricRetentionPeriodFromString(MetricsPackage.Literals.FIXED_METRIC_RETENTION_PERIOD, initialValue);
			if (result != null && Diagnostician.INSTANCE.validate(eDataType, result, null, null)) {
				return result;
			}
		}
		catch (RuntimeException e) {
			exception = e;
		}
		if (result != null || exception == null) return result;
    
		throw exception;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMetricRetentionPeriodToString(EDataType eDataType, Object instanceValue) {
		if (instanceValue == null) return null;
		if (MetricsPackage.Literals.USER_METRIC_RETENTION_PERIOD.isInstance(instanceValue)) {
			try {
				String value = convertUserMetricRetentionPeriodToString(MetricsPackage.Literals.USER_METRIC_RETENTION_PERIOD, instanceValue);
				if (value != null) return value;
			}
			catch (Exception e) {
				// Keep trying other member types until all have failed.
			}
		}
		if (MetricsPackage.Literals.FIXED_METRIC_RETENTION_PERIOD.isInstance(instanceValue)) {
			try {
				String value = convertFixedMetricRetentionPeriodToString(MetricsPackage.Literals.FIXED_METRIC_RETENTION_PERIOD, instanceValue);
				if (value != null) return value;
			}
			catch (Exception e) {
				// Keep trying other member types until all have failed.
			}
		}
		throw new IllegalArgumentException("Invalid value: '"+instanceValue+"' for datatype :"+eDataType.getName());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String createUserMetricRetentionPeriodFromString(EDataType eDataType, String initialValue) {
		return (String)XMLTypeFactory.eINSTANCE.createFromString(XMLTypePackage.Literals.STRING, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertUserMetricRetentionPeriodToString(EDataType eDataType, Object instanceValue) {
		return XMLTypeFactory.eINSTANCE.convertToString(XMLTypePackage.Literals.STRING, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetricsPackage getMetricsPackage() {
		return (MetricsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MetricsPackage getPackage() {
		return MetricsPackage.eINSTANCE;
	}

} //MetricsFactoryImpl
