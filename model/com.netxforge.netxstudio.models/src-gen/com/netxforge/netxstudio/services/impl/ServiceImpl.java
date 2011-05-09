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
package com.netxforge.netxstudio.services.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import com.netxforge.netxstudio.services.CIID;
import com.netxforge.netxstudio.services.Service;
import com.netxforge.netxstudio.services.ServiceClassType;
import com.netxforge.netxstudio.services.ServiceDistribution;
import com.netxforge.netxstudio.services.ServiceForecast;
import com.netxforge.netxstudio.services.ServiceMonitor;
import com.netxforge.netxstudio.services.ServiceUser;
import com.netxforge.netxstudio.services.ServicesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Service</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.services.impl.ServiceImpl#getCIID <em>CIID</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.impl.ServiceImpl#getServices <em>Services</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.impl.ServiceImpl#getServiceForecasts <em>Service Forecasts</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.impl.ServiceImpl#getServiceMonitors <em>Service Monitors</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.impl.ServiceImpl#getServiceUserRefs <em>Service User Refs</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.impl.ServiceImpl#getServiceDistribution <em>Service Distribution</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.impl.ServiceImpl#getServiceCategory <em>Service Category</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.impl.ServiceImpl#getServiceClass <em>Service Class</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.impl.ServiceImpl#getServiceDescription <em>Service Description</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.impl.ServiceImpl#getServiceName <em>Service Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ServiceImpl extends CDOObjectImpl implements Service {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ServiceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ServicesPackage.Literals.SERVICE;
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
	public EList<CIID> getCIID() {
		return (EList<CIID>)eGet(ServicesPackage.Literals.SERVICE__CIID, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Service> getServices() {
		return (EList<Service>)eGet(ServicesPackage.Literals.SERVICE__SERVICES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ServiceForecast> getServiceForecasts() {
		return (EList<ServiceForecast>)eGet(ServicesPackage.Literals.SERVICE__SERVICE_FORECASTS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ServiceMonitor> getServiceMonitors() {
		return (EList<ServiceMonitor>)eGet(ServicesPackage.Literals.SERVICE__SERVICE_MONITORS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<ServiceUser> getServiceUserRefs() {
		return (EList<ServiceUser>)eGet(ServicesPackage.Literals.SERVICE__SERVICE_USER_REFS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceDistribution getServiceDistribution() {
		return (ServiceDistribution)eGet(ServicesPackage.Literals.SERVICE__SERVICE_DISTRIBUTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServiceDistribution(ServiceDistribution newServiceDistribution) {
		eSet(ServicesPackage.Literals.SERVICE__SERVICE_DISTRIBUTION, newServiceDistribution);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getServiceCategory() {
		return (String)eGet(ServicesPackage.Literals.SERVICE__SERVICE_CATEGORY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServiceCategory(String newServiceCategory) {
		eSet(ServicesPackage.Literals.SERVICE__SERVICE_CATEGORY, newServiceCategory);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceClassType getServiceClass() {
		return (ServiceClassType)eGet(ServicesPackage.Literals.SERVICE__SERVICE_CLASS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServiceClass(ServiceClassType newServiceClass) {
		eSet(ServicesPackage.Literals.SERVICE__SERVICE_CLASS, newServiceClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetServiceClass() {
		eUnset(ServicesPackage.Literals.SERVICE__SERVICE_CLASS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetServiceClass() {
		return eIsSet(ServicesPackage.Literals.SERVICE__SERVICE_CLASS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getServiceDescription() {
		return (String)eGet(ServicesPackage.Literals.SERVICE__SERVICE_DESCRIPTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServiceDescription(String newServiceDescription) {
		eSet(ServicesPackage.Literals.SERVICE__SERVICE_DESCRIPTION, newServiceDescription);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getServiceName() {
		return (String)eGet(ServicesPackage.Literals.SERVICE__SERVICE_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServiceName(String newServiceName) {
		eSet(ServicesPackage.Literals.SERVICE__SERVICE_NAME, newServiceName);
	}

} //ServiceImpl
