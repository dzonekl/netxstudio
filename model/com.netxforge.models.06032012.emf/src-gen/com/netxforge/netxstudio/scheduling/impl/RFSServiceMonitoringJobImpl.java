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
package com.netxforge.netxstudio.scheduling.impl;

import com.netxforge.netxstudio.scheduling.RFSServiceMonitoringJob;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;

import com.netxforge.netxstudio.services.RFSService;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>RFS Service Monitoring Job</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.scheduling.impl.RFSServiceMonitoringJobImpl#getRFSService <em>RFS Service</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RFSServiceMonitoringJobImpl extends JobImpl implements RFSServiceMonitoringJob {
	/**
	 * The cached value of the '{@link #getRFSService() <em>RFS Service</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRFSService()
	 * @generated
	 * @ordered
	 */
	protected RFSService rFSService;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RFSServiceMonitoringJobImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SchedulingPackage.Literals.RFS_SERVICE_MONITORING_JOB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RFSService getRFSService() {
		if (rFSService != null && rFSService.eIsProxy()) {
			InternalEObject oldRFSService = (InternalEObject)rFSService;
			rFSService = (RFSService)eResolveProxy(oldRFSService);
			if (rFSService != oldRFSService) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SchedulingPackage.RFS_SERVICE_MONITORING_JOB__RFS_SERVICE, oldRFSService, rFSService));
			}
		}
		return rFSService;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RFSService basicGetRFSService() {
		return rFSService;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRFSService(RFSService newRFSService) {
		RFSService oldRFSService = rFSService;
		rFSService = newRFSService;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulingPackage.RFS_SERVICE_MONITORING_JOB__RFS_SERVICE, oldRFSService, rFSService));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SchedulingPackage.RFS_SERVICE_MONITORING_JOB__RFS_SERVICE:
				if (resolve) return getRFSService();
				return basicGetRFSService();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SchedulingPackage.RFS_SERVICE_MONITORING_JOB__RFS_SERVICE:
				setRFSService((RFSService)newValue);
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
			case SchedulingPackage.RFS_SERVICE_MONITORING_JOB__RFS_SERVICE:
				setRFSService((RFSService)null);
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
			case SchedulingPackage.RFS_SERVICE_MONITORING_JOB__RFS_SERVICE:
				return rFSService != null;
		}
		return super.eIsSet(featureID);
	}

} //RFSServiceMonitoringJobImpl
