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
package com.netxforge.netxstudio.scheduling;

import com.netxforge.netxstudio.metrics.MetricSource;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Metric Source Job</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A job importing metric sources.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.scheduling.MetricSourceJob#getMetricSources <em>Metric Sources</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.scheduling.SchedulingPackage#getMetricSourceJob()
 * @model extendedMetaData="name='MetricSourceJob' kind='elementOnly'"
 * @generated
 */
public interface MetricSourceJob extends Job {
	/**
	 * Returns the value of the '<em><b>Metric Sources</b></em>' reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.metrics.MetricSource}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Reference to the metric source being imported
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Metric Sources</em>' reference list.
	 * @see com.netxforge.netxstudio.scheduling.SchedulingPackage#getMetricSourceJob_MetricSources()
	 * @model required="true"
	 *        extendedMetaData="kind='element' name='MetricSources'"
	 * @generated
	 */
	EList<MetricSource> getMetricSources();

} // MetricSourceJob
