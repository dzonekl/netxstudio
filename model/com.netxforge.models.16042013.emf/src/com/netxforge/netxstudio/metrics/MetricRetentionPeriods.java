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
 * A representation of the model object '<em><b>Metric Retention Periods</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A container type with pre-defined and user defined
 * 				retention period definitions
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.metrics.MetricRetentionPeriods#getMetricRetentionPeriods <em>Metric Retention Periods</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getMetricRetentionPeriods()
 * @model extendedMetaData="name='MetricRetentionPeriods' kind='elementOnly'"
 * @generated
 */
public interface MetricRetentionPeriods extends EObject {
	/**
	 * Returns the value of the '<em><b>Metric Retention Periods</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Object}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metric Retention Periods</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metric Retention Periods</em>' attribute list.
	 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getMetricRetentionPeriods_MetricRetentionPeriods()
	 * @model unique="false" dataType="com.netxforge.netxstudio.metrics.MetricRetentionPeriod"
	 *        extendedMetaData="kind='element' name='MetricRetentionPeriods'"
	 * @generated
	 */
	EList<Object> getMetricRetentionPeriods();

} // MetricRetentionPeriods
