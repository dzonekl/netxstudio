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

import org.eclipse.emf.ecore.EObject;

import com.netxforge.netxstudio.delta16042013.generics.Rule;

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
 *   <li>{@link com.netxforge.netxstudio.delta16042013.metrics.MetricAggregationRule#getAggregationExpression <em>Aggregation Expression</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.delta16042013.metrics.MetricAggregationRule#getIntervalHint <em>Interval Hint</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.delta16042013.metrics.MetricAggregationRule#getPeriod <em>Period</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.delta16042013.metrics.MetricsPackage#getMetricAggregationRule()
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
	 * @see #setAggregationExpression(EObject)
	 * @see com.netxforge.netxstudio.delta16042013.metrics.MetricsPackage#getMetricAggregationRule_AggregationExpression()
	 * @model extendedMetaData="kind='element' name='AggregationExpression'"
	 * @generated
	 */
	EObject getAggregationExpression();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.delta16042013.metrics.MetricAggregationRule#getAggregationExpression <em>Aggregation Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Aggregation Expression</em>' reference.
	 * @see #getAggregationExpression()
	 * @generated
	 */
	void setAggregationExpression(EObject value);

	/**
	 * Returns the value of the '<em><b>Interval Hint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The IntervalHint attribute, holds a hint for the
	 * 					metric interval between each metric value in minutes.
	 * 				
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Interval Hint</em>' attribute.
	 * @see #isSetIntervalHint()
	 * @see #unsetIntervalHint()
	 * @see #setIntervalHint(int)
	 * @see com.netxforge.netxstudio.delta16042013.metrics.MetricsPackage#getMetricAggregationRule_IntervalHint()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='IntervalHint'"
	 * @generated
	 */
	int getIntervalHint();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.delta16042013.metrics.MetricAggregationRule#getIntervalHint <em>Interval Hint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interval Hint</em>' attribute.
	 * @see #isSetIntervalHint()
	 * @see #unsetIntervalHint()
	 * @see #getIntervalHint()
	 * @generated
	 */
	void setIntervalHint(int value);

	/**
	 * Unsets the value of the '{@link com.netxforge.netxstudio.delta16042013.metrics.MetricAggregationRule#getIntervalHint <em>Interval Hint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIntervalHint()
	 * @see #getIntervalHint()
	 * @see #setIntervalHint(int)
	 * @generated
	 */
	void unsetIntervalHint();

	/**
	 * Returns whether the value of the '{@link com.netxforge.netxstudio.delta16042013.metrics.MetricAggregationRule#getIntervalHint <em>Interval Hint</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Interval Hint</em>' attribute is set.
	 * @see #unsetIntervalHint()
	 * @see #getIntervalHint()
	 * @see #setIntervalHint(int)
	 * @generated
	 */
	boolean isSetIntervalHint();

	/**
	 * Returns the value of the '<em><b>Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Period</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Period</em>' attribute.
	 * @see #isSetPeriod()
	 * @see #unsetPeriod()
	 * @see #setPeriod(int)
	 * @see com.netxforge.netxstudio.delta16042013.metrics.MetricsPackage#getMetricAggregationRule_Period()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 * @generated
	 */
	int getPeriod();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.delta16042013.metrics.MetricAggregationRule#getPeriod <em>Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Period</em>' attribute.
	 * @see #isSetPeriod()
	 * @see #unsetPeriod()
	 * @see #getPeriod()
	 * @generated
	 */
	void setPeriod(int value);

	/**
	 * Unsets the value of the '{@link com.netxforge.netxstudio.delta16042013.metrics.MetricAggregationRule#getPeriod <em>Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPeriod()
	 * @see #getPeriod()
	 * @see #setPeriod(int)
	 * @generated
	 */
	void unsetPeriod();

	/**
	 * Returns whether the value of the '{@link com.netxforge.netxstudio.delta16042013.metrics.MetricAggregationRule#getPeriod <em>Period</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Period</em>' attribute is set.
	 * @see #unsetPeriod()
	 * @see #getPeriod()
	 * @see #setPeriod(int)
	 * @generated
	 */
	boolean isSetPeriod();

} // MetricAggregationRule
