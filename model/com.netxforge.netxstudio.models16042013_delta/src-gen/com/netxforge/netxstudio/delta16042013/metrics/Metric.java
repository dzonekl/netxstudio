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
package com.netxforge.netxstudio.delta16042013.metrics;

import com.netxforge.netxstudio.delta16042013.generics.Base;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Metric</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A type representing a metric in an a telecom
 * 				equipment. This is often also referred to as counter or KPI.
 * 				Metric
 * 				types can be nested to form a hiarchical structure in similar
 * 				fashion to a real KPI hiarchy.
 * 
 * 				The Metric type (and/or it's children)
 * 				is first part of the Library
 * 				type, and then referenced from a Node
 * 				type when
 * 				created.
 * 
 * 				Examples:
 * 				1. The Metric type "SGSN Attached
 * 				subscribers" reprents a KPI on a
 * 				SGSN function.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.delta16042013.metrics.Metric#getMetricAggregationRuleSet <em>Metric Aggregation Rule Set</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.delta16042013.metrics.Metric#getMetricRetentionRuleSet <em>Metric Retention Rule Set</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.delta16042013.metrics.Metric#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.delta16042013.metrics.MetricsPackage#getMetric()
 * @model extendedMetaData="name='Metric' kind='empty'"
 * @generated
 */
public interface Metric extends Base {
	/**
	 * Returns the value of the '<em><b>Metric Aggregation Rule Set</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The MetricRetentionRules reference, references a
	 * 							rule set.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Metric Aggregation Rule Set</em>' reference.
	 * @see #setMetricAggregationRuleSet(MetricAggregationRules)
	 * @see com.netxforge.netxstudio.delta16042013.metrics.MetricsPackage#getMetric_MetricAggregationRuleSet()
	 * @model extendedMetaData="kind='attribute' name='MetricAggregationRuleSet'"
	 * @generated
	 */
	MetricAggregationRules getMetricAggregationRuleSet();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.delta16042013.metrics.Metric#getMetricAggregationRuleSet <em>Metric Aggregation Rule Set</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metric Aggregation Rule Set</em>' reference.
	 * @see #getMetricAggregationRuleSet()
	 * @generated
	 */
	void setMetricAggregationRuleSet(MetricAggregationRules value);

	/**
	 * Returns the value of the '<em><b>Metric Retention Rule Set</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The MetricRetentionRules reference, references a
	 * 							rule set.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Metric Retention Rule Set</em>' reference.
	 * @see #setMetricRetentionRuleSet(MetricRetentionRules)
	 * @see com.netxforge.netxstudio.delta16042013.metrics.MetricsPackage#getMetric_MetricRetentionRuleSet()
	 * @model extendedMetaData="kind='attribute' name='MetricRetentionRuleSet'"
	 * @generated
	 */
	MetricRetentionRules getMetricRetentionRuleSet();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.delta16042013.metrics.Metric#getMetricRetentionRuleSet <em>Metric Retention Rule Set</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metric Retention Rule Set</em>' reference.
	 * @see #getMetricRetentionRuleSet()
	 * @generated
	 */
	void setMetricRetentionRuleSet(MetricRetentionRules value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Name attribute holds the name of the metric.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.netxforge.netxstudio.delta16042013.metrics.MetricsPackage#getMetric_Name()
	 * @model dataType="com.netxforge.netxstudio.delta16042013.generics.Name255"
	 *        extendedMetaData="kind='attribute' name='Name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.delta16042013.metrics.Metric#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Metric
