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
package com.netxforge.netxstudio.metrics.impl;

import com.netxforge.netxstudio.generics.DateTimeRange;

import com.netxforge.netxstudio.generics.impl.BaseImpl;

import com.netxforge.netxstudio.metrics.MappingRecord;
import com.netxforge.netxstudio.metrics.MappingStatistic;
import com.netxforge.netxstudio.metrics.MetricsPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping Statistic</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MappingStatisticImpl#getFailedRecords <em>Failed Records</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MappingStatisticImpl#getMappingDuration <em>Mapping Duration</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MappingStatisticImpl#getPeriodEstimate <em>Period Estimate</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MappingStatisticImpl#getSubStatistics <em>Sub Statistics</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MappingStatisticImpl#getIntervalEstimate <em>Interval Estimate</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MappingStatisticImpl#getMessage <em>Message</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.metrics.impl.MappingStatisticImpl#getTotalRecords <em>Total Records</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MappingStatisticImpl extends BaseImpl implements MappingStatistic {
	/**
	 * The cached value of the '{@link #getFailedRecords() <em>Failed Records</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFailedRecords()
	 * @generated
	 * @ordered
	 */
	protected EList<MappingRecord> failedRecords;

	/**
	 * The cached value of the '{@link #getMappingDuration() <em>Mapping Duration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappingDuration()
	 * @generated
	 * @ordered
	 */
	protected DateTimeRange mappingDuration;

	/**
	 * The cached value of the '{@link #getPeriodEstimate() <em>Period Estimate</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPeriodEstimate()
	 * @generated
	 * @ordered
	 */
	protected DateTimeRange periodEstimate;

	/**
	 * The cached value of the '{@link #getSubStatistics() <em>Sub Statistics</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubStatistics()
	 * @generated
	 * @ordered
	 */
	protected EList<MappingStatistic> subStatistics;

	/**
	 * The default value of the '{@link #getIntervalEstimate() <em>Interval Estimate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntervalEstimate()
	 * @generated
	 * @ordered
	 */
	protected static final int INTERVAL_ESTIMATE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getIntervalEstimate() <em>Interval Estimate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntervalEstimate()
	 * @generated
	 * @ordered
	 */
	protected int intervalEstimate = INTERVAL_ESTIMATE_EDEFAULT;

	/**
	 * This is true if the Interval Estimate attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean intervalEstimateESet;

	/**
	 * The default value of the '{@link #getMessage() <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessage()
	 * @generated
	 * @ordered
	 */
	protected static final String MESSAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMessage() <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessage()
	 * @generated
	 * @ordered
	 */
	protected String message = MESSAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTotalRecords() <em>Total Records</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalRecords()
	 * @generated
	 * @ordered
	 */
	protected static final int TOTAL_RECORDS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getTotalRecords() <em>Total Records</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalRecords()
	 * @generated
	 * @ordered
	 */
	protected int totalRecords = TOTAL_RECORDS_EDEFAULT;

	/**
	 * This is true if the Total Records attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean totalRecordsESet;

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
	public EList<MappingRecord> getFailedRecords() {
		if (failedRecords == null) {
			failedRecords = new EObjectContainmentEList<MappingRecord>(MappingRecord.class, this, MetricsPackage.MAPPING_STATISTIC__FAILED_RECORDS);
		}
		return failedRecords;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DateTimeRange getMappingDuration() {
		return mappingDuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMappingDuration(DateTimeRange newMappingDuration, NotificationChain msgs) {
		DateTimeRange oldMappingDuration = mappingDuration;
		mappingDuration = newMappingDuration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MetricsPackage.MAPPING_STATISTIC__MAPPING_DURATION, oldMappingDuration, newMappingDuration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMappingDuration(DateTimeRange newMappingDuration) {
		if (newMappingDuration != mappingDuration) {
			NotificationChain msgs = null;
			if (mappingDuration != null)
				msgs = ((InternalEObject)mappingDuration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MetricsPackage.MAPPING_STATISTIC__MAPPING_DURATION, null, msgs);
			if (newMappingDuration != null)
				msgs = ((InternalEObject)newMappingDuration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MetricsPackage.MAPPING_STATISTIC__MAPPING_DURATION, null, msgs);
			msgs = basicSetMappingDuration(newMappingDuration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetricsPackage.MAPPING_STATISTIC__MAPPING_DURATION, newMappingDuration, newMappingDuration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DateTimeRange getPeriodEstimate() {
		return periodEstimate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPeriodEstimate(DateTimeRange newPeriodEstimate, NotificationChain msgs) {
		DateTimeRange oldPeriodEstimate = periodEstimate;
		periodEstimate = newPeriodEstimate;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MetricsPackage.MAPPING_STATISTIC__PERIOD_ESTIMATE, oldPeriodEstimate, newPeriodEstimate);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPeriodEstimate(DateTimeRange newPeriodEstimate) {
		if (newPeriodEstimate != periodEstimate) {
			NotificationChain msgs = null;
			if (periodEstimate != null)
				msgs = ((InternalEObject)periodEstimate).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MetricsPackage.MAPPING_STATISTIC__PERIOD_ESTIMATE, null, msgs);
			if (newPeriodEstimate != null)
				msgs = ((InternalEObject)newPeriodEstimate).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MetricsPackage.MAPPING_STATISTIC__PERIOD_ESTIMATE, null, msgs);
			msgs = basicSetPeriodEstimate(newPeriodEstimate, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetricsPackage.MAPPING_STATISTIC__PERIOD_ESTIMATE, newPeriodEstimate, newPeriodEstimate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<MappingStatistic> getSubStatistics() {
		if (subStatistics == null) {
			subStatistics = new EObjectContainmentEList<MappingStatistic>(MappingStatistic.class, this, MetricsPackage.MAPPING_STATISTIC__SUB_STATISTICS);
		}
		return subStatistics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getIntervalEstimate() {
		return intervalEstimate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIntervalEstimate(int newIntervalEstimate) {
		int oldIntervalEstimate = intervalEstimate;
		intervalEstimate = newIntervalEstimate;
		boolean oldIntervalEstimateESet = intervalEstimateESet;
		intervalEstimateESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetricsPackage.MAPPING_STATISTIC__INTERVAL_ESTIMATE, oldIntervalEstimate, intervalEstimate, !oldIntervalEstimateESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetIntervalEstimate() {
		int oldIntervalEstimate = intervalEstimate;
		boolean oldIntervalEstimateESet = intervalEstimateESet;
		intervalEstimate = INTERVAL_ESTIMATE_EDEFAULT;
		intervalEstimateESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, MetricsPackage.MAPPING_STATISTIC__INTERVAL_ESTIMATE, oldIntervalEstimate, INTERVAL_ESTIMATE_EDEFAULT, oldIntervalEstimateESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetIntervalEstimate() {
		return intervalEstimateESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMessage(String newMessage) {
		String oldMessage = message;
		message = newMessage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetricsPackage.MAPPING_STATISTIC__MESSAGE, oldMessage, message));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getTotalRecords() {
		return totalRecords;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTotalRecords(int newTotalRecords) {
		int oldTotalRecords = totalRecords;
		totalRecords = newTotalRecords;
		boolean oldTotalRecordsESet = totalRecordsESet;
		totalRecordsESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetricsPackage.MAPPING_STATISTIC__TOTAL_RECORDS, oldTotalRecords, totalRecords, !oldTotalRecordsESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetTotalRecords() {
		int oldTotalRecords = totalRecords;
		boolean oldTotalRecordsESet = totalRecordsESet;
		totalRecords = TOTAL_RECORDS_EDEFAULT;
		totalRecordsESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, MetricsPackage.MAPPING_STATISTIC__TOTAL_RECORDS, oldTotalRecords, TOTAL_RECORDS_EDEFAULT, oldTotalRecordsESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetTotalRecords() {
		return totalRecordsESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MetricsPackage.MAPPING_STATISTIC__FAILED_RECORDS:
				return ((InternalEList<?>)getFailedRecords()).basicRemove(otherEnd, msgs);
			case MetricsPackage.MAPPING_STATISTIC__MAPPING_DURATION:
				return basicSetMappingDuration(null, msgs);
			case MetricsPackage.MAPPING_STATISTIC__PERIOD_ESTIMATE:
				return basicSetPeriodEstimate(null, msgs);
			case MetricsPackage.MAPPING_STATISTIC__SUB_STATISTICS:
				return ((InternalEList<?>)getSubStatistics()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetricsPackage.MAPPING_STATISTIC__FAILED_RECORDS:
				return getFailedRecords();
			case MetricsPackage.MAPPING_STATISTIC__MAPPING_DURATION:
				return getMappingDuration();
			case MetricsPackage.MAPPING_STATISTIC__PERIOD_ESTIMATE:
				return getPeriodEstimate();
			case MetricsPackage.MAPPING_STATISTIC__SUB_STATISTICS:
				return getSubStatistics();
			case MetricsPackage.MAPPING_STATISTIC__INTERVAL_ESTIMATE:
				return getIntervalEstimate();
			case MetricsPackage.MAPPING_STATISTIC__MESSAGE:
				return getMessage();
			case MetricsPackage.MAPPING_STATISTIC__TOTAL_RECORDS:
				return getTotalRecords();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MetricsPackage.MAPPING_STATISTIC__FAILED_RECORDS:
				getFailedRecords().clear();
				getFailedRecords().addAll((Collection<? extends MappingRecord>)newValue);
				return;
			case MetricsPackage.MAPPING_STATISTIC__MAPPING_DURATION:
				setMappingDuration((DateTimeRange)newValue);
				return;
			case MetricsPackage.MAPPING_STATISTIC__PERIOD_ESTIMATE:
				setPeriodEstimate((DateTimeRange)newValue);
				return;
			case MetricsPackage.MAPPING_STATISTIC__SUB_STATISTICS:
				getSubStatistics().clear();
				getSubStatistics().addAll((Collection<? extends MappingStatistic>)newValue);
				return;
			case MetricsPackage.MAPPING_STATISTIC__INTERVAL_ESTIMATE:
				setIntervalEstimate((Integer)newValue);
				return;
			case MetricsPackage.MAPPING_STATISTIC__MESSAGE:
				setMessage((String)newValue);
				return;
			case MetricsPackage.MAPPING_STATISTIC__TOTAL_RECORDS:
				setTotalRecords((Integer)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case MetricsPackage.MAPPING_STATISTIC__FAILED_RECORDS:
				getFailedRecords().clear();
				return;
			case MetricsPackage.MAPPING_STATISTIC__MAPPING_DURATION:
				setMappingDuration((DateTimeRange)null);
				return;
			case MetricsPackage.MAPPING_STATISTIC__PERIOD_ESTIMATE:
				setPeriodEstimate((DateTimeRange)null);
				return;
			case MetricsPackage.MAPPING_STATISTIC__SUB_STATISTICS:
				getSubStatistics().clear();
				return;
			case MetricsPackage.MAPPING_STATISTIC__INTERVAL_ESTIMATE:
				unsetIntervalEstimate();
				return;
			case MetricsPackage.MAPPING_STATISTIC__MESSAGE:
				setMessage(MESSAGE_EDEFAULT);
				return;
			case MetricsPackage.MAPPING_STATISTIC__TOTAL_RECORDS:
				unsetTotalRecords();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MetricsPackage.MAPPING_STATISTIC__FAILED_RECORDS:
				return failedRecords != null && !failedRecords.isEmpty();
			case MetricsPackage.MAPPING_STATISTIC__MAPPING_DURATION:
				return mappingDuration != null;
			case MetricsPackage.MAPPING_STATISTIC__PERIOD_ESTIMATE:
				return periodEstimate != null;
			case MetricsPackage.MAPPING_STATISTIC__SUB_STATISTICS:
				return subStatistics != null && !subStatistics.isEmpty();
			case MetricsPackage.MAPPING_STATISTIC__INTERVAL_ESTIMATE:
				return isSetIntervalEstimate();
			case MetricsPackage.MAPPING_STATISTIC__MESSAGE:
				return MESSAGE_EDEFAULT == null ? message != null : !MESSAGE_EDEFAULT.equals(message);
			case MetricsPackage.MAPPING_STATISTIC__TOTAL_RECORDS:
				return isSetTotalRecords();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (intervalEstimate: ");
		if (intervalEstimateESet) result.append(intervalEstimate); else result.append("<unset>");
		result.append(", message: ");
		result.append(message);
		result.append(", totalRecords: ");
		if (totalRecordsESet) result.append(totalRecords); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //MappingStatisticImpl
