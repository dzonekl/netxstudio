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
package com.netxforge.netxstudio.metrics.util;

import com.netxforge.netxstudio.metrics.*;

import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

import org.eclipse.emf.ecore.xml.type.util.XMLTypeValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see com.netxforge.netxstudio.metrics.MetricsPackage
 * @generated
 */
public class MetricsValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final MetricsValidator INSTANCE = new MetricsValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "com.netxforge.netxstudio.metrics";

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * The cached base package validator.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XMLTypeValidator xmlTypeValidator;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetricsValidator() {
		super();
		xmlTypeValidator = XMLTypeValidator.INSTANCE;
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return MetricsPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case MetricsPackage.DATA_KIND:
				return validateDataKind((DataKind)value, diagnostics, context);
			case MetricsPackage.IDENTIFIER_DATA_KIND:
				return validateIdentifierDataKind((IdentifierDataKind)value, diagnostics, context);
			case MetricsPackage.MAPPING:
				return validateMapping((Mapping)value, diagnostics, context);
			case MetricsPackage.MAPPING_COLUMN:
				return validateMappingColumn((MappingColumn)value, diagnostics, context);
			case MetricsPackage.MAPPING_CSV:
				return validateMappingCSV((MappingCSV)value, diagnostics, context);
			case MetricsPackage.MAPPING_EXTERNAL:
				return validateMappingExternal((MappingExternal)value, diagnostics, context);
			case MetricsPackage.MAPPING_RDBMS:
				return validateMappingRDBMS((MappingRDBMS)value, diagnostics, context);
			case MetricsPackage.MAPPING_RECORD:
				return validateMappingRecord((MappingRecord)value, diagnostics, context);
			case MetricsPackage.MAPPING_STATISTIC:
				return validateMappingStatistic((MappingStatistic)value, diagnostics, context);
			case MetricsPackage.MAPPING_XLS:
				return validateMappingXLS((MappingXLS)value, diagnostics, context);
			case MetricsPackage.METRIC:
				return validateMetric((Metric)value, diagnostics, context);
			case MetricsPackage.METRIC_AGGREGATION_RULE:
				return validateMetricAggregationRule((MetricAggregationRule)value, diagnostics, context);
			case MetricsPackage.METRIC_AGGREGATION_RULES:
				return validateMetricAggregationRules((MetricAggregationRules)value, diagnostics, context);
			case MetricsPackage.METRIC_RETENTION_PERIODS:
				return validateMetricRetentionPeriods((MetricRetentionPeriods)value, diagnostics, context);
			case MetricsPackage.METRIC_RETENTION_RULE:
				return validateMetricRetentionRule((MetricRetentionRule)value, diagnostics, context);
			case MetricsPackage.METRIC_RETENTION_RULES:
				return validateMetricRetentionRules((MetricRetentionRules)value, diagnostics, context);
			case MetricsPackage.METRIC_SOURCE:
				return validateMetricSource((MetricSource)value, diagnostics, context);
			case MetricsPackage.METRIC_VALUE_RANGE:
				return validateMetricValueRange((MetricValueRange)value, diagnostics, context);
			case MetricsPackage.VALUE_DATA_KIND:
				return validateValueDataKind((ValueDataKind)value, diagnostics, context);
			case MetricsPackage.DATABASE_TYPE_TYPE:
				return validateDatabaseTypeType((DatabaseTypeType)value, diagnostics, context);
			case MetricsPackage.FIXED_METRIC_RETENTION_PERIOD:
				return validateFixedMetricRetentionPeriod((FixedMetricRetentionPeriod)value, diagnostics, context);
			case MetricsPackage.KIND_HINT_TYPE:
				return validateKindHintType((KindHintType)value, diagnostics, context);
			case MetricsPackage.OBJECT_KIND_TYPE:
				return validateObjectKindType((ObjectKindType)value, diagnostics, context);
			case MetricsPackage.VALUE_KIND_TYPE:
				return validateValueKindType((ValueKindType)value, diagnostics, context);
			case MetricsPackage.DATABASE_TYPE_TYPE_OBJECT:
				return validateDatabaseTypeTypeObject((DatabaseTypeType)value, diagnostics, context);
			case MetricsPackage.FIXED_METRIC_RETENTION_PERIOD_OBJECT:
				return validateFixedMetricRetentionPeriodObject((FixedMetricRetentionPeriod)value, diagnostics, context);
			case MetricsPackage.KIND_HINT_TYPE_OBJECT:
				return validateKindHintTypeObject((KindHintType)value, diagnostics, context);
			case MetricsPackage.METRIC_RETENTION_PERIOD:
				return validateMetricRetentionPeriod(value, diagnostics, context);
			case MetricsPackage.OBJECT_KIND_TYPE_OBJECT:
				return validateObjectKindTypeObject((ObjectKindType)value, diagnostics, context);
			case MetricsPackage.USER_METRIC_RETENTION_PERIOD:
				return validateUserMetricRetentionPeriod((String)value, diagnostics, context);
			case MetricsPackage.VALUE_KIND_TYPE_OBJECT:
				return validateValueKindTypeObject((ValueKindType)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDataKind(DataKind dataKind, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(dataKind, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateIdentifierDataKind(IdentifierDataKind identifierDataKind, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(identifierDataKind, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMapping(Mapping mapping, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(mapping, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMappingColumn(MappingColumn mappingColumn, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(mappingColumn, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMappingCSV(MappingCSV mappingCSV, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(mappingCSV, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMappingExternal(MappingExternal mappingExternal, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(mappingExternal, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMappingRDBMS(MappingRDBMS mappingRDBMS, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(mappingRDBMS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMappingRecord(MappingRecord mappingRecord, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(mappingRecord, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMappingStatistic(MappingStatistic mappingStatistic, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(mappingStatistic, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMappingXLS(MappingXLS mappingXLS, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(mappingXLS, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMetric(Metric metric, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(metric, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMetricAggregationRule(MetricAggregationRule metricAggregationRule, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(metricAggregationRule, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMetricAggregationRules(MetricAggregationRules metricAggregationRules, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(metricAggregationRules, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMetricRetentionPeriods(MetricRetentionPeriods metricRetentionPeriods, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(metricRetentionPeriods, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMetricRetentionRule(MetricRetentionRule metricRetentionRule, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(metricRetentionRule, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMetricRetentionRules(MetricRetentionRules metricRetentionRules, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(metricRetentionRules, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMetricSource(MetricSource metricSource, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(metricSource, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMetricValueRange(MetricValueRange metricValueRange, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(metricValueRange, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateValueDataKind(ValueDataKind valueDataKind, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(valueDataKind, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDatabaseTypeType(DatabaseTypeType databaseTypeType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFixedMetricRetentionPeriod(FixedMetricRetentionPeriod fixedMetricRetentionPeriod, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateKindHintType(KindHintType kindHintType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateObjectKindType(ObjectKindType objectKindType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateValueKindType(ValueKindType valueKindType, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDatabaseTypeTypeObject(DatabaseTypeType databaseTypeTypeObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFixedMetricRetentionPeriodObject(FixedMetricRetentionPeriod fixedMetricRetentionPeriodObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateKindHintTypeObject(KindHintType kindHintTypeObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMetricRetentionPeriod(Object metricRetentionPeriod, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean result = validateMetricRetentionPeriod_MemberTypes(metricRetentionPeriod, diagnostics, context);
		return result;
	}

	/**
	 * Validates the MemberTypes constraint of '<em>Metric Retention Period</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateMetricRetentionPeriod_MemberTypes(Object metricRetentionPeriod, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (diagnostics != null) {
			BasicDiagnostic tempDiagnostics = new BasicDiagnostic();
			if (MetricsPackage.Literals.USER_METRIC_RETENTION_PERIOD.isInstance(metricRetentionPeriod)) {
				if (validateUserMetricRetentionPeriod((String)metricRetentionPeriod, tempDiagnostics, context)) return true;
			}
			if (MetricsPackage.Literals.FIXED_METRIC_RETENTION_PERIOD.isInstance(metricRetentionPeriod)) {
				if (validateFixedMetricRetentionPeriod((FixedMetricRetentionPeriod)metricRetentionPeriod, tempDiagnostics, context)) return true;
			}
			for (Diagnostic diagnostic : tempDiagnostics.getChildren()) {
				diagnostics.add(diagnostic);
			}
		}
		else {
			if (MetricsPackage.Literals.USER_METRIC_RETENTION_PERIOD.isInstance(metricRetentionPeriod)) {
				if (validateUserMetricRetentionPeriod((String)metricRetentionPeriod, null, context)) return true;
			}
			if (MetricsPackage.Literals.FIXED_METRIC_RETENTION_PERIOD.isInstance(metricRetentionPeriod)) {
				if (validateFixedMetricRetentionPeriod((FixedMetricRetentionPeriod)metricRetentionPeriod, null, context)) return true;
			}
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateObjectKindTypeObject(ObjectKindType objectKindTypeObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateUserMetricRetentionPeriod(String userMetricRetentionPeriod, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateValueKindTypeObject(ValueKindType valueKindTypeObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //MetricsValidator
