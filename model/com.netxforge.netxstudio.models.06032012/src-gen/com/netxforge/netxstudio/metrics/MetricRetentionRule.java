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
package com.netxforge.netxstudio.metrics;

import org.eclipse.emf.cdo.CDOObject;

import com.netxforge.netxstudio.library.Expression;

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
 *   <li>{@link com.netxforge.netxstudio.metrics.MetricRetentionRule#getRetentionExpression <em>Retention Expression</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.MetricRetentionRule#getIntervalHint <em>Interval Hint</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.MetricRetentionRule#getName <em>Name</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.MetricRetentionRule#getPeriod <em>Period</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getMetricRetentionRule()
 * @model extendedMetaData="name='MetricRetentionRule' kind='elementOnly'"
 * @extends CDOObject
 * @generated
 */
public interface MetricRetentionRule extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Retention Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Retention Expression</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Retention Expression</em>' reference.
	 * @see #setRetentionExpression(Expression)
	 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getMetricRetentionRule_RetentionExpression()
	 * @model extendedMetaData="kind='element' name='RetentionExpression'"
	 * @generated
	 */
	Expression getRetentionExpression();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.metrics.MetricRetentionRule#getRetentionExpression <em>Retention Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Retention Expression</em>' reference.
	 * @see #getRetentionExpression()
	 * @generated
	 */
	void setRetentionExpression(Expression value);

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
	 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getMetricRetentionRule_IntervalHint()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='IntervalHint'"
	 * @generated
	 */
	int getIntervalHint();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.metrics.MetricRetentionRule#getIntervalHint <em>Interval Hint</em>}' attribute.
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
	 * Unsets the value of the '{@link com.netxforge.netxstudio.metrics.MetricRetentionRule#getIntervalHint <em>Interval Hint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetIntervalHint()
	 * @see #getIntervalHint()
	 * @see #setIntervalHint(int)
	 * @generated
	 */
	void unsetIntervalHint();

	/**
	 * Returns whether the value of the '{@link com.netxforge.netxstudio.metrics.MetricRetentionRule#getIntervalHint <em>Interval Hint</em>}' attribute is set.
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
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The name of this retention rule.
	 * 				
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getMetricRetentionRule_Name()
	 * @model dataType="com.netxforge.netxstudio.generics.Name255"
	 *        extendedMetaData="kind='attribute' name='Name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.metrics.MetricRetentionRule#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Period</b></em>' attribute.
	 * The literals are from the enumeration {@link com.netxforge.netxstudio.metrics.MetricRetentionPeriod}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Metric retention period.
	 * 				
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Period</em>' attribute.
	 * @see com.netxforge.netxstudio.metrics.MetricRetentionPeriod
	 * @see #isSetPeriod()
	 * @see #unsetPeriod()
	 * @see #setPeriod(MetricRetentionPeriod)
	 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getMetricRetentionRule_Period()
	 * @model unsettable="true"
	 *        extendedMetaData="kind='attribute' name='Period'"
	 * @generated
	 */
	MetricRetentionPeriod getPeriod();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.metrics.MetricRetentionRule#getPeriod <em>Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Period</em>' attribute.
	 * @see com.netxforge.netxstudio.metrics.MetricRetentionPeriod
	 * @see #isSetPeriod()
	 * @see #unsetPeriod()
	 * @see #getPeriod()
	 * @generated
	 */
	void setPeriod(MetricRetentionPeriod value);

	/**
	 * Unsets the value of the '{@link com.netxforge.netxstudio.metrics.MetricRetentionRule#getPeriod <em>Period</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPeriod()
	 * @see #getPeriod()
	 * @see #setPeriod(MetricRetentionPeriod)
	 * @generated
	 */
	void unsetPeriod();

	/**
	 * Returns whether the value of the '{@link com.netxforge.netxstudio.metrics.MetricRetentionRule#getPeriod <em>Period</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Period</em>' attribute is set.
	 * @see #unsetPeriod()
	 * @see #getPeriod()
	 * @see #setPeriod(MetricRetentionPeriod)
	 * @generated
	 */
	boolean isSetPeriod();

} // MetricRetentionRule
