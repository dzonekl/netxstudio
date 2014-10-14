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
package com.netxforge.netxstudio.metrics;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Metric Aggregation Rules</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The metric retention rules.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.metrics.MetricAggregationRules#getMetricAggregationRules <em>Metric Aggregation Rules</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getMetricAggregationRules()
 * @model extendedMetaData="name='MetricAggregationRules' kind='elementOnly'"
 * @generated
 */
public interface MetricAggregationRules extends EObject {
	/**
	 * Returns the value of the '<em><b>Metric Aggregation Rules</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.metrics.MetricAggregationRule}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metric Aggregation Rules</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metric Aggregation Rules</em>' containment reference list.
	 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getMetricAggregationRules_MetricAggregationRules()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='MetricAggregationRules'"
	 * @generated
	 */
	EList<MetricAggregationRule> getMetricAggregationRules();

} // MetricAggregationRules
