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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.metrics.MappingRecord;
import com.netxforge.netxstudio.metrics.MappingStatistic;
import com.netxforge.netxstudio.metrics.MetricsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping Statistic</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MappingStatisticImpl#getFailedRecords <em>Failed Records</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MappingStatisticImpl#getMappingDuration <em>Mapping Duration</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MappingStatisticImpl#getMessage <em>Message</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MappingStatisticImpl#getTotalRecords <em>Total Records</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MappingStatisticImpl extends CDOObjectImpl implements MappingStatistic {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingStatisticImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetricsPackage.Literals.MAPPING_STATISTIC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<MappingRecord> getFailedRecords() {
		return (EList<MappingRecord>)eGet(MetricsPackage.Literals.MAPPING_STATISTIC__FAILED_RECORDS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DateTimeRange getMappingDuration() {
		return (DateTimeRange)eGet(MetricsPackage.Literals.MAPPING_STATISTIC__MAPPING_DURATION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMappingDuration(DateTimeRange newMappingDuration) {
		eSet(MetricsPackage.Literals.MAPPING_STATISTIC__MAPPING_DURATION, newMappingDuration);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMessage() {
		return (String)eGet(MetricsPackage.Literals.MAPPING_STATISTIC__MESSAGE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMessage(String newMessage) {
		eSet(MetricsPackage.Literals.MAPPING_STATISTIC__MESSAGE, newMessage);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getTotalRecords() {
		return (Integer)eGet(MetricsPackage.Literals.MAPPING_STATISTIC__TOTAL_RECORDS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTotalRecords(int newTotalRecords) {
		eSet(MetricsPackage.Literals.MAPPING_STATISTIC__TOTAL_RECORDS, newTotalRecords);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTotalRecords() {
		eUnset(MetricsPackage.Literals.MAPPING_STATISTIC__TOTAL_RECORDS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTotalRecords() {
		return eIsSet(MetricsPackage.Literals.MAPPING_STATISTIC__TOTAL_RECORDS);
	}

} //MappingStatisticImpl
