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
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Metric Retention Rules</b></em>'.
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
 *   <li>{@link com.netxforge.netxstudio.metrics.MetricRetentionRules#getMetricRetentionRules <em>Metric Retention Rules</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getMetricRetentionRules()
 * @model extendedMetaData="name='MetricRetentionRules' kind='elementOnly'"
 * @extends CDOObject
 * @generated
 */
public interface MetricRetentionRules extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Metric Retention Rules</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.metrics.MetricRetentionRule}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Metric Retention Rules</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metric Retention Rules</em>' containment reference list.
	 * @see com.netxforge.netxstudio.metrics.MetricsPackage#getMetricRetentionRules_MetricRetentionRules()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='MetricRetentionRules'"
	 * @generated
	 */
	EList<MetricRetentionRule> getMetricRetentionRules();

} // MetricRetentionRules
