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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Addon</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.delta16042013.metrics.Addon#getMetrics <em>Metrics</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.delta16042013.metrics.Addon#getMetricSources <em>Metric Sources</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.delta16042013.metrics.Addon#getMetricRetentionRuleSets <em>Metric Retention Rule Sets</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.delta16042013.metrics.Addon#getMetricAggregationRuleSets <em>Metric Aggregation Rule Sets</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.delta16042013.metrics.MetricsPackage#getAddon()
 * @model extendedMetaData="name='Addon' kind='elementOnly'"
 * @generated
 */
public interface Addon extends EObject {
	/**
	 * Returns the value of the '<em><b>Metrics</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.delta16042013.metrics.Metric}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metrics</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metrics</em>' containment reference list.
	 * @see com.netxforge.netxstudio.delta16042013.metrics.MetricsPackage#getAddon_Metrics()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Metrics'"
	 * @generated
	 */
	EList<Metric> getMetrics();

	/**
	 * Returns the value of the '<em><b>Metric Sources</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.delta16042013.metrics.MetricSource}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metric Sources</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metric Sources</em>' containment reference list.
	 * @see com.netxforge.netxstudio.delta16042013.metrics.MetricsPackage#getAddon_MetricSources()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='MetricSources'"
	 * @generated
	 */
	EList<MetricSource> getMetricSources();

	/**
	 * Returns the value of the '<em><b>Metric Retention Rule Sets</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.delta16042013.metrics.MetricRetentionRules}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metric Retention Rule Sets</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metric Retention Rule Sets</em>' containment reference list.
	 * @see com.netxforge.netxstudio.delta16042013.metrics.MetricsPackage#getAddon_MetricRetentionRuleSets()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='MetricRetentionRuleSets'"
	 * @generated
	 */
	EList<MetricRetentionRules> getMetricRetentionRuleSets();

	/**
	 * Returns the value of the '<em><b>Metric Aggregation Rule Sets</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.delta16042013.metrics.MetricAggregationRules}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metric Aggregation Rule Sets</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metric Aggregation Rule Sets</em>' containment reference list.
	 * @see com.netxforge.netxstudio.delta16042013.metrics.MetricsPackage#getAddon_MetricAggregationRuleSets()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='MetricAggregationRuleSets'"
	 * @generated
	 */
	EList<MetricAggregationRules> getMetricAggregationRuleSets();

} // Addon
