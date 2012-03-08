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
package com.netxforge.netxstudio.metrics.impl;

import com.netxforge.netxstudio.metrics.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

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
			MetricsFactory theMetricsFactory = (MetricsFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.netxforge.com/13042011/metrics"); 
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
			case MetricsPackage.DATA_KIND: return (EObject)createDataKind();
			case MetricsPackage.IDENTIFIER_DATA_KIND: return (EObject)createIdentifierDataKind();
			case MetricsPackage.MAPPING: return (EObject)createMapping();
			case MetricsPackage.MAPPING_COLUMN: return (EObject)createMappingColumn();
			case MetricsPackage.MAPPING_CSV: return (EObject)createMappingCSV();
			case MetricsPackage.MAPPING_RDBMS: return (EObject)createMappingRDBMS();
			case MetricsPackage.MAPPING_RECORD: return (EObject)createMappingRecord();
			case MetricsPackage.MAPPING_STATISTIC: return (EObject)createMappingStatistic();
			case MetricsPackage.MAPPING_XLS: return (EObject)createMappingXLS();
			case MetricsPackage.METRIC: return (EObject)createMetric();
			case MetricsPackage.METRIC_RETENTION_RULE: return (EObject)createMetricRetentionRule();
			case MetricsPackage.METRIC_RETENTION_RULES: return (EObject)createMetricRetentionRules();
			case MetricsPackage.METRIC_SOURCE: return (EObject)createMetricSource();
			case MetricsPackage.METRIC_VALUE_RANGE: return (EObject)createMetricValueRange();
			case MetricsPackage.VALUE_DATA_KIND: return (EObject)createValueDataKind();
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
			case MetricsPackage.DATABASE_TYPE_TYPE:
				return createDatabaseTypeTypeFromString(eDataType, initialValue);
			case MetricsPackage.KIND_HINT_TYPE:
				return createKindHintTypeFromString(eDataType, initialValue);
			case MetricsPackage.METRIC_RETENTION_PERIOD:
				return createMetricRetentionPeriodFromString(eDataType, initialValue);
			case MetricsPackage.OBJECT_KIND_TYPE:
				return createObjectKindTypeFromString(eDataType, initialValue);
			case MetricsPackage.VALUE_KIND_TYPE:
				return createValueKindTypeFromString(eDataType, initialValue);
			case MetricsPackage.DATABASE_TYPE_TYPE_OBJECT:
				return createDatabaseTypeTypeObjectFromString(eDataType, initialValue);
			case MetricsPackage.KIND_HINT_TYPE_OBJECT:
				return createKindHintTypeObjectFromString(eDataType, initialValue);
			case MetricsPackage.METRIC_RETENTION_PERIOD_OBJECT:
				return createMetricRetentionPeriodObjectFromString(eDataType, initialValue);
			case MetricsPackage.OBJECT_KIND_TYPE_OBJECT:
				return createObjectKindTypeObjectFromString(eDataType, initialValue);
			case MetricsPackage.VALUE_KIND_TYPE_OBJECT:
				return createValueKindTypeObjectFromString(eDataType, initialValue);
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
			case MetricsPackage.DATABASE_TYPE_TYPE:
				return convertDatabaseTypeTypeToString(eDataType, instanceValue);
			case MetricsPackage.KIND_HINT_TYPE:
				return convertKindHintTypeToString(eDataType, instanceValue);
			case MetricsPackage.METRIC_RETENTION_PERIOD:
				return convertMetricRetentionPeriodToString(eDataType, instanceValue);
			case MetricsPackage.OBJECT_KIND_TYPE:
				return convertObjectKindTypeToString(eDataType, instanceValue);
			case MetricsPackage.VALUE_KIND_TYPE:
				return convertValueKindTypeToString(eDataType, instanceValue);
			case MetricsPackage.DATABASE_TYPE_TYPE_OBJECT:
				return convertDatabaseTypeTypeObjectToString(eDataType, instanceValue);
			case MetricsPackage.KIND_HINT_TYPE_OBJECT:
				return convertKindHintTypeObjectToString(eDataType, instanceValue);
			case MetricsPackage.METRIC_RETENTION_PERIOD_OBJECT:
				return convertMetricRetentionPeriodObjectToString(eDataType, instanceValue);
			case MetricsPackage.OBJECT_KIND_TYPE_OBJECT:
				return convertObjectKindTypeObjectToString(eDataType, instanceValue);
			case MetricsPackage.VALUE_KIND_TYPE_OBJECT:
				return convertValueKindTypeObjectToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataKind createDataKind() {
		DataKindImpl dataKind = new DataKindImpl();
		return dataKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IdentifierDataKind createIdentifierDataKind() {
		IdentifierDataKindImpl identifierDataKind = new IdentifierDataKindImpl();
		return identifierDataKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mapping createMapping() {
		MappingImpl mapping = new MappingImpl();
		return mapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingColumn createMappingColumn() {
		MappingColumnImpl mappingColumn = new MappingColumnImpl();
		return mappingColumn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingCSV createMappingCSV() {
		MappingCSVImpl mappingCSV = new MappingCSVImpl();
		return mappingCSV;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingRDBMS createMappingRDBMS() {
		MappingRDBMSImpl mappingRDBMS = new MappingRDBMSImpl();
		return mappingRDBMS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingRecord createMappingRecord() {
		MappingRecordImpl mappingRecord = new MappingRecordImpl();
		return mappingRecord;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingStatistic createMappingStatistic() {
		MappingStatisticImpl mappingStatistic = new MappingStatisticImpl();
		return mappingStatistic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingXLS createMappingXLS() {
		MappingXLSImpl mappingXLS = new MappingXLSImpl();
		return mappingXLS;
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
	public MetricValueRange createMetricValueRange() {
		MetricValueRangeImpl metricValueRange = new MetricValueRangeImpl();
		return metricValueRange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueDataKind createValueDataKind() {
		ValueDataKindImpl valueDataKind = new ValueDataKindImpl();
		return valueDataKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DatabaseTypeType createDatabaseTypeTypeFromString(EDataType eDataType, String initialValue) {
		DatabaseTypeType result = DatabaseTypeType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDatabaseTypeTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KindHintType createKindHintTypeFromString(EDataType eDataType, String initialValue) {
		KindHintType result = KindHintType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertKindHintTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetricRetentionPeriod createMetricRetentionPeriodFromString(EDataType eDataType, String initialValue) {
		MetricRetentionPeriod result = MetricRetentionPeriod.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMetricRetentionPeriodToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectKindType createObjectKindTypeFromString(EDataType eDataType, String initialValue) {
		ObjectKindType result = ObjectKindType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertObjectKindTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueKindType createValueKindTypeFromString(EDataType eDataType, String initialValue) {
		ValueKindType result = ValueKindType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertValueKindTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DatabaseTypeType createDatabaseTypeTypeObjectFromString(EDataType eDataType, String initialValue) {
		return createDatabaseTypeTypeFromString(MetricsPackage.Literals.DATABASE_TYPE_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDatabaseTypeTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertDatabaseTypeTypeToString(MetricsPackage.Literals.DATABASE_TYPE_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public KindHintType createKindHintTypeObjectFromString(EDataType eDataType, String initialValue) {
		return createKindHintTypeFromString(MetricsPackage.Literals.KIND_HINT_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertKindHintTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertKindHintTypeToString(MetricsPackage.Literals.KIND_HINT_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetricRetentionPeriod createMetricRetentionPeriodObjectFromString(EDataType eDataType, String initialValue) {
		return createMetricRetentionPeriodFromString(MetricsPackage.Literals.METRIC_RETENTION_PERIOD, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMetricRetentionPeriodObjectToString(EDataType eDataType, Object instanceValue) {
		return convertMetricRetentionPeriodToString(MetricsPackage.Literals.METRIC_RETENTION_PERIOD, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectKindType createObjectKindTypeObjectFromString(EDataType eDataType, String initialValue) {
		return createObjectKindTypeFromString(MetricsPackage.Literals.OBJECT_KIND_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertObjectKindTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertObjectKindTypeToString(MetricsPackage.Literals.OBJECT_KIND_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueKindType createValueKindTypeObjectFromString(EDataType eDataType, String initialValue) {
		return createValueKindTypeFromString(MetricsPackage.Literals.VALUE_KIND_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertValueKindTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertValueKindTypeToString(MetricsPackage.Literals.VALUE_KIND_TYPE, instanceValue);
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
