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

import com.netxforge.netxstudio.generics.Rule;

import com.netxforge.netxstudio.library.Expression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Metric Aggregation Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A type with settings on aggregation of metric
 * 				values.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.metrics.MetricAggregationRule#getAggregationExpression <em>Aggregation Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getMetricAggregationRule()
 * @model extendedMetaData="name='MetricAggregationRule' kind='elementOnly'"
 * @generated
 */
public interface MetricAggregationRule extends Rule {
	/**
	 * Returns the value of the '<em><b>Aggregation Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Aggregation Expression</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aggregation Expression</em>' reference.
	 * @see #setAggregationExpression(Expression)
	 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getMetricAggregationRule_AggregationExpression()
	 * @model extendedMetaData="kind='element' name='AggregationExpression'"
	 * @generated
	 */
	Expression getAggregationExpression();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.metrics.MetricAggregationRule#getAggregationExpression <em>Aggregation Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Aggregation Expression</em>' reference.
	 * @see #getAggregationExpression()
	 * @generated
	 */
	void setAggregationExpression(Expression value);

} // MetricAggregationRule
