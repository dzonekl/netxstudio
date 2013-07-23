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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import com.netxforge.netxstudio.delta16042013.generics.GenericsPackage;
import com.netxforge.netxstudio.delta16042013.generics.impl.GenericsPackageImpl;
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
import com.netxforge.netxstudio.delta16042013.metrics.util.MetricsValidator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MetricsPackageImpl extends EPackageImpl implements MetricsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addonEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass metricEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass metricAggregationRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass metricAggregationRulesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass metricRetentionPeriodsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass metricRetentionRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass metricRetentionRulesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass metricSourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum fixedMetricRetentionPeriodEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType fixedMetricRetentionPeriodObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType metricRetentionPeriodEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType userMetricRetentionPeriodEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see com.netxforge.netxstudio.delta16042013.metrics.MetricsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MetricsPackageImpl() {
		super(eNS_URI, MetricsFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link MetricsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static MetricsPackage init() {
		if (isInited) return (MetricsPackage)EPackage.Registry.INSTANCE.getEPackage(MetricsPackage.eNS_URI);

		// Obtain or create and register package
		MetricsPackageImpl theMetricsPackage = (MetricsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof MetricsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new MetricsPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		XMLTypePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		GenericsPackageImpl theGenericsPackage = (GenericsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(GenericsPackage.eNS_URI) instanceof GenericsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(GenericsPackage.eNS_URI) : GenericsPackage.eINSTANCE);

		// Create package meta-data objects
		theMetricsPackage.createPackageContents();
		theGenericsPackage.createPackageContents();

		// Initialize created meta-data
		theMetricsPackage.initializePackageContents();
		theGenericsPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theMetricsPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return MetricsValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theMetricsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(MetricsPackage.eNS_URI, theMetricsPackage);
		return theMetricsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAddon() {
		return addonEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAddon_Metrics() {
		return (EReference)addonEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAddon_MetricSources() {
		return (EReference)addonEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAddon_MetricRetentionRuleSets() {
		return (EReference)addonEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAddon_MetricAggregationRuleSets() {
		return (EReference)addonEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMetric() {
		return metricEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMetric_MetricAggregationRuleSet() {
		return (EReference)metricEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMetric_MetricRetentionRuleSet() {
		return (EReference)metricEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMetric_Name() {
		return (EAttribute)metricEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMetricAggregationRule() {
		return metricAggregationRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMetricAggregationRule_AggregationExpression() {
		return (EReference)metricAggregationRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMetricAggregationRule_IntervalHint() {
		return (EAttribute)metricAggregationRuleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMetricAggregationRule_Period() {
		return (EAttribute)metricAggregationRuleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMetricAggregationRules() {
		return metricAggregationRulesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMetricAggregationRules_MetricAggregationRules() {
		return (EReference)metricAggregationRulesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMetricRetentionPeriods() {
		return metricRetentionPeriodsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMetricRetentionPeriods_MetricRetentionPeriods() {
		return (EAttribute)metricRetentionPeriodsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMetricRetentionRule() {
		return metricRetentionRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMetricRetentionRule_IntervalHint() {
		return (EAttribute)metricRetentionRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMetricRetentionRule_Period() {
		return (EAttribute)metricRetentionRuleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMetricRetentionRules() {
		return metricRetentionRulesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMetricRetentionRules_MetricRetentionRules() {
		return (EReference)metricRetentionRulesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMetricSource() {
		return metricSourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMetricSource_MetricAggregationRuleSet() {
		return (EReference)metricSourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMetricSource_MetricRetentionRuleSet() {
		return (EReference)metricSourceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMetricSource_Name() {
		return (EAttribute)metricSourceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getFixedMetricRetentionPeriod() {
		return fixedMetricRetentionPeriodEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getFixedMetricRetentionPeriodObject() {
		return fixedMetricRetentionPeriodObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getMetricRetentionPeriod() {
		return metricRetentionPeriodEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getUserMetricRetentionPeriod() {
		return userMetricRetentionPeriodEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetricsFactory getMetricsFactory() {
		return (MetricsFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		addonEClass = createEClass(ADDON);
		createEReference(addonEClass, ADDON__METRICS);
		createEReference(addonEClass, ADDON__METRIC_SOURCES);
		createEReference(addonEClass, ADDON__METRIC_RETENTION_RULE_SETS);
		createEReference(addonEClass, ADDON__METRIC_AGGREGATION_RULE_SETS);

		metricEClass = createEClass(METRIC);
		createEReference(metricEClass, METRIC__METRIC_AGGREGATION_RULE_SET);
		createEReference(metricEClass, METRIC__METRIC_RETENTION_RULE_SET);
		createEAttribute(metricEClass, METRIC__NAME);

		metricAggregationRuleEClass = createEClass(METRIC_AGGREGATION_RULE);
		createEReference(metricAggregationRuleEClass, METRIC_AGGREGATION_RULE__AGGREGATION_EXPRESSION);
		createEAttribute(metricAggregationRuleEClass, METRIC_AGGREGATION_RULE__INTERVAL_HINT);
		createEAttribute(metricAggregationRuleEClass, METRIC_AGGREGATION_RULE__PERIOD);

		metricAggregationRulesEClass = createEClass(METRIC_AGGREGATION_RULES);
		createEReference(metricAggregationRulesEClass, METRIC_AGGREGATION_RULES__METRIC_AGGREGATION_RULES);

		metricRetentionPeriodsEClass = createEClass(METRIC_RETENTION_PERIODS);
		createEAttribute(metricRetentionPeriodsEClass, METRIC_RETENTION_PERIODS__METRIC_RETENTION_PERIODS);

		metricRetentionRuleEClass = createEClass(METRIC_RETENTION_RULE);
		createEAttribute(metricRetentionRuleEClass, METRIC_RETENTION_RULE__INTERVAL_HINT);
		createEAttribute(metricRetentionRuleEClass, METRIC_RETENTION_RULE__PERIOD);

		metricRetentionRulesEClass = createEClass(METRIC_RETENTION_RULES);
		createEReference(metricRetentionRulesEClass, METRIC_RETENTION_RULES__METRIC_RETENTION_RULES);

		metricSourceEClass = createEClass(METRIC_SOURCE);
		createEReference(metricSourceEClass, METRIC_SOURCE__METRIC_AGGREGATION_RULE_SET);
		createEReference(metricSourceEClass, METRIC_SOURCE__METRIC_RETENTION_RULE_SET);
		createEAttribute(metricSourceEClass, METRIC_SOURCE__NAME);

		// Create enums
		fixedMetricRetentionPeriodEEnum = createEEnum(FIXED_METRIC_RETENTION_PERIOD);

		// Create data types
		fixedMetricRetentionPeriodObjectEDataType = createEDataType(FIXED_METRIC_RETENTION_PERIOD_OBJECT);
		metricRetentionPeriodEDataType = createEDataType(METRIC_RETENTION_PERIOD);
		userMetricRetentionPeriodEDataType = createEDataType(USER_METRIC_RETENTION_PERIOD);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		GenericsPackage theGenericsPackage = (GenericsPackage)EPackage.Registry.INSTANCE.getEPackage(GenericsPackage.eNS_URI);
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		metricEClass.getESuperTypes().add(theGenericsPackage.getBase());
		metricAggregationRuleEClass.getESuperTypes().add(theGenericsPackage.getRule());
		metricRetentionRuleEClass.getESuperTypes().add(theGenericsPackage.getRule());
		metricSourceEClass.getESuperTypes().add(theGenericsPackage.getBase());

		// Initialize classes and features; add operations and parameters
		initEClass(addonEClass, Addon.class, "Addon", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAddon_Metrics(), this.getMetric(), null, "metrics", null, 0, -1, Addon.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAddon_MetricSources(), this.getMetricSource(), null, "metricSources", null, 0, -1, Addon.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAddon_MetricRetentionRuleSets(), this.getMetricRetentionRules(), null, "metricRetentionRuleSets", null, 0, -1, Addon.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAddon_MetricAggregationRuleSets(), this.getMetricAggregationRules(), null, "metricAggregationRuleSets", null, 0, -1, Addon.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(metricEClass, Metric.class, "Metric", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMetric_MetricAggregationRuleSet(), this.getMetricAggregationRules(), null, "metricAggregationRuleSet", null, 0, 1, Metric.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMetric_MetricRetentionRuleSet(), this.getMetricRetentionRules(), null, "metricRetentionRuleSet", null, 0, 1, Metric.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMetric_Name(), theGenericsPackage.getName255(), "name", null, 0, 1, Metric.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(metricAggregationRuleEClass, MetricAggregationRule.class, "MetricAggregationRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMetricAggregationRule_AggregationExpression(), ecorePackage.getEObject(), null, "aggregationExpression", null, 0, 1, MetricAggregationRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMetricAggregationRule_IntervalHint(), theXMLTypePackage.getInt(), "intervalHint", null, 0, 1, MetricAggregationRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMetricAggregationRule_Period(), theXMLTypePackage.getInt(), "period", null, 0, 1, MetricAggregationRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(metricAggregationRulesEClass, MetricAggregationRules.class, "MetricAggregationRules", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMetricAggregationRules_MetricAggregationRules(), this.getMetricAggregationRule(), null, "metricAggregationRules", null, 0, -1, MetricAggregationRules.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(metricRetentionPeriodsEClass, MetricRetentionPeriods.class, "MetricRetentionPeriods", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMetricRetentionPeriods_MetricRetentionPeriods(), this.getMetricRetentionPeriod(), "metricRetentionPeriods", null, 0, -1, MetricRetentionPeriods.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(metricRetentionRuleEClass, MetricRetentionRule.class, "MetricRetentionRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMetricRetentionRule_IntervalHint(), theXMLTypePackage.getInt(), "intervalHint", null, 0, 1, MetricRetentionRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMetricRetentionRule_Period(), this.getMetricRetentionPeriod(), "period", null, 0, 1, MetricRetentionRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(metricRetentionRulesEClass, MetricRetentionRules.class, "MetricRetentionRules", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMetricRetentionRules_MetricRetentionRules(), this.getMetricRetentionRule(), null, "metricRetentionRules", null, 0, -1, MetricRetentionRules.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(metricSourceEClass, MetricSource.class, "MetricSource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMetricSource_MetricAggregationRuleSet(), this.getMetricAggregationRules(), null, "metricAggregationRuleSet", null, 0, 1, MetricSource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMetricSource_MetricRetentionRuleSet(), this.getMetricRetentionRules(), null, "metricRetentionRuleSet", null, 0, 1, MetricSource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMetricSource_Name(), theGenericsPackage.getName255(), "name", null, 0, 1, MetricSource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(fixedMetricRetentionPeriodEEnum, FixedMetricRetentionPeriod.class, "FixedMetricRetentionPeriod");
		addEEnumLiteral(fixedMetricRetentionPeriodEEnum, FixedMetricRetentionPeriod.ALWAYS);
		addEEnumLiteral(fixedMetricRetentionPeriodEEnum, FixedMetricRetentionPeriod.ONE_YEAR);
		addEEnumLiteral(fixedMetricRetentionPeriodEEnum, FixedMetricRetentionPeriod.ONE_MONTH);
		addEEnumLiteral(fixedMetricRetentionPeriodEEnum, FixedMetricRetentionPeriod.ONE_WEEK);

		// Initialize data types
		initEDataType(fixedMetricRetentionPeriodObjectEDataType, FixedMetricRetentionPeriod.class, "FixedMetricRetentionPeriodObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
		initEDataType(metricRetentionPeriodEDataType, Object.class, "MetricRetentionPeriod", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(userMetricRetentionPeriodEDataType, String.class, "UserMetricRetentionPeriod", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";		
		addAnnotation
		  (addonEClass, 
		   source, 
		   new String[] {
			 "name", "Addon",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getAddon_Metrics(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Metrics"
		   });		
		addAnnotation
		  (getAddon_MetricSources(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "MetricSources"
		   });		
		addAnnotation
		  (getAddon_MetricRetentionRuleSets(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "MetricRetentionRuleSets"
		   });		
		addAnnotation
		  (getAddon_MetricAggregationRuleSets(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "MetricAggregationRuleSets"
		   });		
		addAnnotation
		  (fixedMetricRetentionPeriodEEnum, 
		   source, 
		   new String[] {
			 "name", "FixedMetricRetentionPeriod"
		   });		
		addAnnotation
		  (fixedMetricRetentionPeriodObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "FixedMetricRetentionPeriod:Object",
			 "baseType", "FixedMetricRetentionPeriod"
		   });			
		addAnnotation
		  (metricEClass, 
		   source, 
		   new String[] {
			 "name", "Metric",
			 "kind", "empty"
		   });			
		addAnnotation
		  (getMetric_MetricAggregationRuleSet(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "MetricAggregationRuleSet"
		   });			
		addAnnotation
		  (getMetric_MetricRetentionRuleSet(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "MetricRetentionRuleSet"
		   });			
		addAnnotation
		  (getMetric_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Name"
		   });			
		addAnnotation
		  (metricAggregationRuleEClass, 
		   source, 
		   new String[] {
			 "name", "MetricAggregationRule",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getMetricAggregationRule_AggregationExpression(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "AggregationExpression"
		   });			
		addAnnotation
		  (getMetricAggregationRule_IntervalHint(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "IntervalHint"
		   });			
		addAnnotation
		  (metricAggregationRulesEClass, 
		   source, 
		   new String[] {
			 "name", "MetricAggregationRules",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getMetricAggregationRules_MetricAggregationRules(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "MetricAggregationRules"
		   });		
		addAnnotation
		  (metricRetentionPeriodEDataType, 
		   source, 
		   new String[] {
			 "name", "MetricRetentionPeriod",
			 "memberTypes", "UserMetricRetentionPeriod FixedMetricRetentionPeriod"
		   });			
		addAnnotation
		  (metricRetentionPeriodsEClass, 
		   source, 
		   new String[] {
			 "name", "MetricRetentionPeriods",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getMetricRetentionPeriods_MetricRetentionPeriods(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "MetricRetentionPeriods"
		   });			
		addAnnotation
		  (metricRetentionRuleEClass, 
		   source, 
		   new String[] {
			 "name", "MetricRetentionRule",
			 "kind", "empty"
		   });			
		addAnnotation
		  (getMetricRetentionRule_IntervalHint(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "IntervalHint"
		   });			
		addAnnotation
		  (getMetricRetentionRule_Period(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Period"
		   });			
		addAnnotation
		  (metricRetentionRulesEClass, 
		   source, 
		   new String[] {
			 "name", "MetricRetentionRules",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getMetricRetentionRules_MetricRetentionRules(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "MetricRetentionRules"
		   });			
		addAnnotation
		  (metricSourceEClass, 
		   source, 
		   new String[] {
			 "name", "MetricSource",
			 "kind", "empty"
		   });			
		addAnnotation
		  (getMetricSource_MetricAggregationRuleSet(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "MetricAggregationRuleSet"
		   });			
		addAnnotation
		  (getMetricSource_MetricRetentionRuleSet(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "MetricRetentionRuleSet"
		   });			
		addAnnotation
		  (getMetricSource_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Name"
		   });		
		addAnnotation
		  (userMetricRetentionPeriodEDataType, 
		   source, 
		   new String[] {
			 "name", "UserMetricRetentionPeriod",
			 "baseType", "http://www.eclipse.org/emf/2003/XMLType#string"
		   });
	}

} //MetricsPackageImpl
