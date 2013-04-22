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

import com.netxforge.netxstudio.delta16042013.generics.Rule;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Metric Retention Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A type with settings on retention of metric values
 * 				corresponding to the metric value range intervalhint.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.delta16042013.metrics.MetricRetentionRule#getIntervalHint <em>Interval Hint</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.delta16042013.metrics.MetricRetentionRule#getPeriod <em>Period</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.delta16042013.metrics.MetricsPackage#getMetricRetentionRule()
 * @model extendedMetaData="name='MetricRetentionRule' kind='empty'"
 * @generated
 */
public interface MetricRetentionRule extends Rule {
	/**
	 * Returns the value of the '<em><b>Interval Hint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The IntervalHint attribute, holds a hint for the
	 * 							metric interval between each metric value in minutes.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Interval Hint</em>' attribute.
	 * @see #isSetIntervalHint()
	 * @see #unsetIntervalHint()
	 * @see #setIntervalHint(int)
	 * @see com.netxforge.netxstudio.delta16042013.metrics.MetricsPackage#getMetricRetentionRule_IntervalHint()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='IntervalHint'"
	 * @generated
	 */
	int getIntervalHint();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.delta16042013.metrics.MetricRetentionRule#getIntervalHint <em>Interval Hint</em>}' attribute.
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
	 * Unsets the value of the '{@link com.netxforge.netxstudio.delta16042013.metrics.MetricRetentionRule#getIntervalHint <em>Interval Hint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIntervalHint()
	 * @see #getIntervalHint()
	 * @see #setIntervalHint(int)
	 * @generated
	 */
	void unsetIntervalHint();

	/**
	 * Returns whether the value of the '{@link com.netxforge.netxstudio.delta16042013.metrics.MetricRetentionRule#getIntervalHint <em>Interval Hint</em>}' attribute is set.
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
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Metric retention period.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Period</em>' attribute.
	 * @see #setPeriod(Object)
	 * @see com.netxforge.netxstudio.delta16042013.metrics.MetricsPackage#getMetricRetentionRule_Period()
	 * @model dataType="com.netxforge.netxstudio.delta16042013.metrics.MetricRetentionPeriod"
	 *        extendedMetaData="kind='attribute' name='Period'"
	 * @generated
	 */
	Object getPeriod();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.delta16042013.metrics.MetricRetentionRule#getPeriod <em>Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Period</em>' attribute.
	 * @see #getPeriod()
	 * @generated
	 */
	void setPeriod(Object value);

} // MetricRetentionRule
