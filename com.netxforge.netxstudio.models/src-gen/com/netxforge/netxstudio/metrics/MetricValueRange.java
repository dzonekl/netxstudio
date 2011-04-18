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

import com.netxforge.netxstudio.generics.Value;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Metric Value Range</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A type representing a range of metricvalues. The range has a name and provides some hints on the expected
 * stored values.
 * 
 * It is expected the metric loading or derived values will consider the hints, on where to store the metric.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.metrics.MetricValueRange#getMetricValues <em>Metric Values</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.MetricValueRange#getKindHint <em>Kind Hint</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.MetricValueRange#getName <em>Name</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.MetricValueRange#getPeriodHint <em>Period Hint</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getMetricValueRange()
 * @model extendedMetaData="name='MetricValueRange' kind='elementOnly'"
 * @generated
 */
public interface MetricValueRange extends EObject {
	/**
	 * Returns the value of the '<em><b>Metric Values</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.generics.Value}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The MetricValue reference, contains 0 or more Value types
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Metric Values</em>' containment reference list.
	 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getMetricValueRange_MetricValues()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='MetricValues'"
	 * @generated
	 */
	EList<Value> getMetricValues();

	/**
	 * Returns the value of the '<em><b>Kind Hint</b></em>' attribute.
	 * The literals are from the enumeration {@link com.netxforge.netxstudio.metrics.KindHintType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The KindHint attribute, holds a hint for the metric kind of a metric value, it can be either BusyHour or AVG.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Kind Hint</em>' attribute.
	 * @see com.netxforge.netxstudio.metrics.KindHintType
	 * @see #isSetKindHint()
	 * @see #unsetKindHint()
	 * @see #setKindHint(KindHintType)
	 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getMetricValueRange_KindHint()
	 * @model unsettable="true"
	 *        extendedMetaData="kind='attribute' name='KindHint'"
	 * @generated
	 */
	KindHintType getKindHint();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.metrics.MetricValueRange#getKindHint <em>Kind Hint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind Hint</em>' attribute.
	 * @see com.netxforge.netxstudio.metrics.KindHintType
	 * @see #isSetKindHint()
	 * @see #unsetKindHint()
	 * @see #getKindHint()
	 * @generated
	 */
	void setKindHint(KindHintType value);

	/**
	 * Unsets the value of the '{@link com.netxforge.netxstudio.metrics.MetricValueRange#getKindHint <em>Kind Hint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetKindHint()
	 * @see #getKindHint()
	 * @see #setKindHint(KindHintType)
	 * @generated
	 */
	void unsetKindHint();

	/**
	 * Returns whether the value of the '{@link com.netxforge.netxstudio.metrics.MetricValueRange#getKindHint <em>Kind Hint</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Kind Hint</em>' attribute is set.
	 * @see #unsetKindHint()
	 * @see #getKindHint()
	 * @see #setKindHint(KindHintType)
	 * @generated
	 */
	boolean isSetKindHint();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Name attribute holds the name of the metricvaluerange.
	 * 				
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getMetricValueRange_Name()
	 * @model dataType="com.netxforge.netxstudio.generics.Name255"
	 *        extendedMetaData="kind='attribute' name='Name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.metrics.MetricValueRange#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Period Hint</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The PeriodHint attribute, holds a hint for the metric period between each metric value in minutes.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Period Hint</em>' attribute.
	 * @see #isSetPeriodHint()
	 * @see #unsetPeriodHint()
	 * @see #setPeriodHint(int)
	 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getMetricValueRange_PeriodHint()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='PeriodHint'"
	 * @generated
	 */
	int getPeriodHint();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.metrics.MetricValueRange#getPeriodHint <em>Period Hint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Period Hint</em>' attribute.
	 * @see #isSetPeriodHint()
	 * @see #unsetPeriodHint()
	 * @see #getPeriodHint()
	 * @generated
	 */
	void setPeriodHint(int value);

	/**
	 * Unsets the value of the '{@link com.netxforge.netxstudio.metrics.MetricValueRange#getPeriodHint <em>Period Hint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetPeriodHint()
	 * @see #getPeriodHint()
	 * @see #setPeriodHint(int)
	 * @generated
	 */
	void unsetPeriodHint();

	/**
	 * Returns whether the value of the '{@link com.netxforge.netxstudio.metrics.MetricValueRange#getPeriodHint <em>Period Hint</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Period Hint</em>' attribute is set.
	 * @see #unsetPeriodHint()
	 * @see #getPeriodHint()
	 * @see #setPeriodHint(int)
	 * @generated
	 */
	boolean isSetPeriodHint();

} // MetricValueRange
