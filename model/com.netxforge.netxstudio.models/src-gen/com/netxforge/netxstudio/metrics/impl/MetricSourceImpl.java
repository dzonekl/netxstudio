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
package com.netxforge.netxstudio.metrics.impl;

import com.netxforge.netxstudio.generics.impl.BaseImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import com.netxforge.netxstudio.metrics.Mapping;
import com.netxforge.netxstudio.metrics.MappingStatistic;
import com.netxforge.netxstudio.metrics.Metric;
import com.netxforge.netxstudio.metrics.MetricSource;
import com.netxforge.netxstudio.metrics.MetricsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Metric Source</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MetricSourceImpl#getMetricRefs <em>Metric Refs</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MetricSourceImpl#getMetricMapping <em>Metric Mapping</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MetricSourceImpl#getStatistics <em>Statistics</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MetricSourceImpl#getMetricLocation <em>Metric Location</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MetricSourceImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MetricSourceImpl extends BaseImpl implements MetricSource {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MetricSourceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetricsPackage.Literals.METRIC_SOURCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Metric> getMetricRefs() {
		return (EList<Metric>)eGet(MetricsPackage.Literals.METRIC_SOURCE__METRIC_REFS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mapping getMetricMapping() {
		return (Mapping)eGet(MetricsPackage.Literals.METRIC_SOURCE__METRIC_MAPPING, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetricMapping(Mapping newMetricMapping) {
		eSet(MetricsPackage.Literals.METRIC_SOURCE__METRIC_MAPPING, newMetricMapping);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<MappingStatistic> getStatistics() {
		return (EList<MappingStatistic>)eGet(MetricsPackage.Literals.METRIC_SOURCE__STATISTICS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMetricLocation() {
		return (String)eGet(MetricsPackage.Literals.METRIC_SOURCE__METRIC_LOCATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMetricLocation(String newMetricLocation) {
		eSet(MetricsPackage.Literals.METRIC_SOURCE__METRIC_LOCATION, newMetricLocation);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String)eGet(MetricsPackage.Literals.METRIC_SOURCE__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(MetricsPackage.Literals.METRIC_SOURCE__NAME, newName);
	}

} //MetricSourceImpl
