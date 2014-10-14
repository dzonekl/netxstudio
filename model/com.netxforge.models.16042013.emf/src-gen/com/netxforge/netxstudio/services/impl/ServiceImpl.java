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
package com.netxforge.netxstudio.services.impl;

import com.netxforge.netxstudio.generics.Lifecycle;

import com.netxforge.netxstudio.generics.impl.BaseImpl;

import com.netxforge.netxstudio.services.CIID;
import com.netxforge.netxstudio.services.Service;
import com.netxforge.netxstudio.services.ServiceClassType;
import com.netxforge.netxstudio.services.ServiceDistribution;
import com.netxforge.netxstudio.services.ServiceForecast;
import com.netxforge.netxstudio.services.ServiceMonitor;
import com.netxforge.netxstudio.services.ServiceUser;
import com.netxforge.netxstudio.services.ServicesPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Service</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.services.impl.ServiceImpl#getCIID <em>CIID</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.impl.ServiceImpl#getLifecycle <em>Lifecycle</em>}</li>
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
public class ServiceImpl extends BaseImpl implements Service {
	/**
	 * The cached value of the '{@link #getCIID() <em>CIID</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCIID()
	 * @generated
	 * @ordered
	 */
	protected EList<CIID> cIID;

	/**
	 * The cached value of the '{@link #getLifecycle() <em>Lifecycle</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLifecycle()
	 * @generated
	 * @ordered
	 */
	protected Lifecycle lifecycle;

	/**
	 * The cached value of the '{@link #getServices() <em>Services</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServices()
	 * @generated
	 * @ordered
	 */
	protected EList<Service> services;

	/**
	 * The cached value of the '{@link #getServiceForecasts() <em>Service Forecasts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceForecasts()
	 * @generated
	 * @ordered
	 */
	protected EList<ServiceForecast> serviceForecasts;

	/**
	 * The cached value of the '{@link #getServiceMonitors() <em>Service Monitors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceMonitors()
	 * @generated
	 * @ordered
	 */
	protected EList<ServiceMonitor> serviceMonitors;

	/**
	 * The cached value of the '{@link #getServiceUserRefs() <em>Service User Refs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceUserRefs()
	 * @generated
	 * @ordered
	 */
	protected EList<ServiceUser> serviceUserRefs;

	/**
	 * The cached value of the '{@link #getServiceDistribution() <em>Service Distribution</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceDistribution()
	 * @generated
	 * @ordered
	 */
	protected ServiceDistribution serviceDistribution;

	/**
	 * The default value of the '{@link #getServiceCategory() <em>Service Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceCategory()
	 * @generated
	 * @ordered
	 */
	protected static final String SERVICE_CATEGORY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getServiceCategory() <em>Service Category</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceCategory()
	 * @generated
	 * @ordered
	 */
	protected String serviceCategory = SERVICE_CATEGORY_EDEFAULT;

	/**
	 * The default value of the '{@link #getServiceClass() <em>Service Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceClass()
	 * @generated
	 * @ordered
	 */
	protected static final ServiceClassType SERVICE_CLASS_EDEFAULT = ServiceClassType.GOLD;

	/**
	 * The cached value of the '{@link #getServiceClass() <em>Service Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceClass()
	 * @generated
	 * @ordered
	 */
	protected ServiceClassType serviceClass = SERVICE_CLASS_EDEFAULT;

	/**
	 * This is true if the Service Class attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean serviceClassESet;

	/**
	 * The default value of the '{@link #getServiceDescription() <em>Service Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String SERVICE_DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getServiceDescription() <em>Service Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceDescription()
	 * @generated
	 * @ordered
	 */
	protected String serviceDescription = SERVICE_DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getServiceName() <em>Service Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceName()
	 * @generated
	 * @ordered
	 */
	protected static final String SERVICE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getServiceName() <em>Service Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceName()
	 * @generated
	 * @ordered
	 */
	protected String serviceName = SERVICE_NAME_EDEFAULT;

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
	public EList<CIID> getCIID() {
		if (cIID == null) {
			cIID = new EObjectContainmentEList<CIID>(CIID.class, this, ServicesPackage.SERVICE__CIID);
		}
		return cIID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Lifecycle getLifecycle() {
		return lifecycle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLifecycle(Lifecycle newLifecycle, NotificationChain msgs) {
		Lifecycle oldLifecycle = lifecycle;
		lifecycle = newLifecycle;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ServicesPackage.SERVICE__LIFECYCLE, oldLifecycle, newLifecycle);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLifecycle(Lifecycle newLifecycle) {
		if (newLifecycle != lifecycle) {
			NotificationChain msgs = null;
			if (lifecycle != null)
				msgs = ((InternalEObject)lifecycle).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ServicesPackage.SERVICE__LIFECYCLE, null, msgs);
			if (newLifecycle != null)
				msgs = ((InternalEObject)newLifecycle).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ServicesPackage.SERVICE__LIFECYCLE, null, msgs);
			msgs = basicSetLifecycle(newLifecycle, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicesPackage.SERVICE__LIFECYCLE, newLifecycle, newLifecycle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Service> getServices() {
		if (services == null) {
			services = new EObjectContainmentEList<Service>(Service.class, this, ServicesPackage.SERVICE__SERVICES);
		}
		return services;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ServiceForecast> getServiceForecasts() {
		if (serviceForecasts == null) {
			serviceForecasts = new EObjectContainmentEList<ServiceForecast>(ServiceForecast.class, this, ServicesPackage.SERVICE__SERVICE_FORECASTS);
		}
		return serviceForecasts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ServiceMonitor> getServiceMonitors() {
		if (serviceMonitors == null) {
			serviceMonitors = new EObjectContainmentEList<ServiceMonitor>(ServiceMonitor.class, this, ServicesPackage.SERVICE__SERVICE_MONITORS);
		}
		return serviceMonitors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ServiceUser> getServiceUserRefs() {
		if (serviceUserRefs == null) {
			serviceUserRefs = new EObjectResolvingEList<ServiceUser>(ServiceUser.class, this, ServicesPackage.SERVICE__SERVICE_USER_REFS);
		}
		return serviceUserRefs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceDistribution getServiceDistribution() {
		return serviceDistribution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetServiceDistribution(ServiceDistribution newServiceDistribution, NotificationChain msgs) {
		ServiceDistribution oldServiceDistribution = serviceDistribution;
		serviceDistribution = newServiceDistribution;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ServicesPackage.SERVICE__SERVICE_DISTRIBUTION, oldServiceDistribution, newServiceDistribution);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServiceDistribution(ServiceDistribution newServiceDistribution) {
		if (newServiceDistribution != serviceDistribution) {
			NotificationChain msgs = null;
			if (serviceDistribution != null)
				msgs = ((InternalEObject)serviceDistribution).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ServicesPackage.SERVICE__SERVICE_DISTRIBUTION, null, msgs);
			if (newServiceDistribution != null)
				msgs = ((InternalEObject)newServiceDistribution).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ServicesPackage.SERVICE__SERVICE_DISTRIBUTION, null, msgs);
			msgs = basicSetServiceDistribution(newServiceDistribution, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicesPackage.SERVICE__SERVICE_DISTRIBUTION, newServiceDistribution, newServiceDistribution));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getServiceCategory() {
		return serviceCategory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServiceCategory(String newServiceCategory) {
		String oldServiceCategory = serviceCategory;
		serviceCategory = newServiceCategory;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicesPackage.SERVICE__SERVICE_CATEGORY, oldServiceCategory, serviceCategory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceClassType getServiceClass() {
		return serviceClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServiceClass(ServiceClassType newServiceClass) {
		ServiceClassType oldServiceClass = serviceClass;
		serviceClass = newServiceClass == null ? SERVICE_CLASS_EDEFAULT : newServiceClass;
		boolean oldServiceClassESet = serviceClassESet;
		serviceClassESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicesPackage.SERVICE__SERVICE_CLASS, oldServiceClass, serviceClass, !oldServiceClassESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetServiceClass() {
		ServiceClassType oldServiceClass = serviceClass;
		boolean oldServiceClassESet = serviceClassESet;
		serviceClass = SERVICE_CLASS_EDEFAULT;
		serviceClassESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, ServicesPackage.SERVICE__SERVICE_CLASS, oldServiceClass, SERVICE_CLASS_EDEFAULT, oldServiceClassESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetServiceClass() {
		return serviceClassESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getServiceDescription() {
		return serviceDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServiceDescription(String newServiceDescription) {
		String oldServiceDescription = serviceDescription;
		serviceDescription = newServiceDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicesPackage.SERVICE__SERVICE_DESCRIPTION, oldServiceDescription, serviceDescription));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getServiceName() {
		return serviceName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServiceName(String newServiceName) {
		String oldServiceName = serviceName;
		serviceName = newServiceName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ServicesPackage.SERVICE__SERVICE_NAME, oldServiceName, serviceName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ServicesPackage.SERVICE__CIID:
				return ((InternalEList<?>)getCIID()).basicRemove(otherEnd, msgs);
			case ServicesPackage.SERVICE__LIFECYCLE:
				return basicSetLifecycle(null, msgs);
			case ServicesPackage.SERVICE__SERVICES:
				return ((InternalEList<?>)getServices()).basicRemove(otherEnd, msgs);
			case ServicesPackage.SERVICE__SERVICE_FORECASTS:
				return ((InternalEList<?>)getServiceForecasts()).basicRemove(otherEnd, msgs);
			case ServicesPackage.SERVICE__SERVICE_MONITORS:
				return ((InternalEList<?>)getServiceMonitors()).basicRemove(otherEnd, msgs);
			case ServicesPackage.SERVICE__SERVICE_DISTRIBUTION:
				return basicSetServiceDistribution(null, msgs);
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
			case ServicesPackage.SERVICE__CIID:
				return getCIID();
			case ServicesPackage.SERVICE__LIFECYCLE:
				return getLifecycle();
			case ServicesPackage.SERVICE__SERVICES:
				return getServices();
			case ServicesPackage.SERVICE__SERVICE_FORECASTS:
				return getServiceForecasts();
			case ServicesPackage.SERVICE__SERVICE_MONITORS:
				return getServiceMonitors();
			case ServicesPackage.SERVICE__SERVICE_USER_REFS:
				return getServiceUserRefs();
			case ServicesPackage.SERVICE__SERVICE_DISTRIBUTION:
				return getServiceDistribution();
			case ServicesPackage.SERVICE__SERVICE_CATEGORY:
				return getServiceCategory();
			case ServicesPackage.SERVICE__SERVICE_CLASS:
				return getServiceClass();
			case ServicesPackage.SERVICE__SERVICE_DESCRIPTION:
				return getServiceDescription();
			case ServicesPackage.SERVICE__SERVICE_NAME:
				return getServiceName();
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
			case ServicesPackage.SERVICE__CIID:
				getCIID().clear();
				getCIID().addAll((Collection<? extends CIID>)newValue);
				return;
			case ServicesPackage.SERVICE__LIFECYCLE:
				setLifecycle((Lifecycle)newValue);
				return;
			case ServicesPackage.SERVICE__SERVICES:
				getServices().clear();
				getServices().addAll((Collection<? extends Service>)newValue);
				return;
			case ServicesPackage.SERVICE__SERVICE_FORECASTS:
				getServiceForecasts().clear();
				getServiceForecasts().addAll((Collection<? extends ServiceForecast>)newValue);
				return;
			case ServicesPackage.SERVICE__SERVICE_MONITORS:
				getServiceMonitors().clear();
				getServiceMonitors().addAll((Collection<? extends ServiceMonitor>)newValue);
				return;
			case ServicesPackage.SERVICE__SERVICE_USER_REFS:
				getServiceUserRefs().clear();
				getServiceUserRefs().addAll((Collection<? extends ServiceUser>)newValue);
				return;
			case ServicesPackage.SERVICE__SERVICE_DISTRIBUTION:
				setServiceDistribution((ServiceDistribution)newValue);
				return;
			case ServicesPackage.SERVICE__SERVICE_CATEGORY:
				setServiceCategory((String)newValue);
				return;
			case ServicesPackage.SERVICE__SERVICE_CLASS:
				setServiceClass((ServiceClassType)newValue);
				return;
			case ServicesPackage.SERVICE__SERVICE_DESCRIPTION:
				setServiceDescription((String)newValue);
				return;
			case ServicesPackage.SERVICE__SERVICE_NAME:
				setServiceName((String)newValue);
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
			case ServicesPackage.SERVICE__CIID:
				getCIID().clear();
				return;
			case ServicesPackage.SERVICE__LIFECYCLE:
				setLifecycle((Lifecycle)null);
				return;
			case ServicesPackage.SERVICE__SERVICES:
				getServices().clear();
				return;
			case ServicesPackage.SERVICE__SERVICE_FORECASTS:
				getServiceForecasts().clear();
				return;
			case ServicesPackage.SERVICE__SERVICE_MONITORS:
				getServiceMonitors().clear();
				return;
			case ServicesPackage.SERVICE__SERVICE_USER_REFS:
				getServiceUserRefs().clear();
				return;
			case ServicesPackage.SERVICE__SERVICE_DISTRIBUTION:
				setServiceDistribution((ServiceDistribution)null);
				return;
			case ServicesPackage.SERVICE__SERVICE_CATEGORY:
				setServiceCategory(SERVICE_CATEGORY_EDEFAULT);
				return;
			case ServicesPackage.SERVICE__SERVICE_CLASS:
				unsetServiceClass();
				return;
			case ServicesPackage.SERVICE__SERVICE_DESCRIPTION:
				setServiceDescription(SERVICE_DESCRIPTION_EDEFAULT);
				return;
			case ServicesPackage.SERVICE__SERVICE_NAME:
				setServiceName(SERVICE_NAME_EDEFAULT);
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
			case ServicesPackage.SERVICE__CIID:
				return cIID != null && !cIID.isEmpty();
			case ServicesPackage.SERVICE__LIFECYCLE:
				return lifecycle != null;
			case ServicesPackage.SERVICE__SERVICES:
				return services != null && !services.isEmpty();
			case ServicesPackage.SERVICE__SERVICE_FORECASTS:
				return serviceForecasts != null && !serviceForecasts.isEmpty();
			case ServicesPackage.SERVICE__SERVICE_MONITORS:
				return serviceMonitors != null && !serviceMonitors.isEmpty();
			case ServicesPackage.SERVICE__SERVICE_USER_REFS:
				return serviceUserRefs != null && !serviceUserRefs.isEmpty();
			case ServicesPackage.SERVICE__SERVICE_DISTRIBUTION:
				return serviceDistribution != null;
			case ServicesPackage.SERVICE__SERVICE_CATEGORY:
				return SERVICE_CATEGORY_EDEFAULT == null ? serviceCategory != null : !SERVICE_CATEGORY_EDEFAULT.equals(serviceCategory);
			case ServicesPackage.SERVICE__SERVICE_CLASS:
				return isSetServiceClass();
			case ServicesPackage.SERVICE__SERVICE_DESCRIPTION:
				return SERVICE_DESCRIPTION_EDEFAULT == null ? serviceDescription != null : !SERVICE_DESCRIPTION_EDEFAULT.equals(serviceDescription);
			case ServicesPackage.SERVICE__SERVICE_NAME:
				return SERVICE_NAME_EDEFAULT == null ? serviceName != null : !SERVICE_NAME_EDEFAULT.equals(serviceName);
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
		result.append(" (serviceCategory: ");
		result.append(serviceCategory);
		result.append(", serviceClass: ");
		if (serviceClassESet) result.append(serviceClass); else result.append("<unset>");
		result.append(", serviceDescription: ");
		result.append(serviceDescription);
		result.append(", serviceName: ");
		result.append(serviceName);
		result.append(')');
		return result.toString();
	}

} //ServiceImpl
