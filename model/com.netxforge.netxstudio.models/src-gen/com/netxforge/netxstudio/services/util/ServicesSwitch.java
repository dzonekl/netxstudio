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
package com.netxforge.netxstudio.services.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

import com.netxforge.netxstudio.generics.Base;
import com.netxforge.netxstudio.library.BaseResource;
import com.netxforge.netxstudio.services.CFSService;
import com.netxforge.netxstudio.services.CIID;
import com.netxforge.netxstudio.services.DerivedResource;
import com.netxforge.netxstudio.services.RFSService;
import com.netxforge.netxstudio.services.Service;
import com.netxforge.netxstudio.services.ServiceDistribution;
import com.netxforge.netxstudio.services.ServiceForecast;
import com.netxforge.netxstudio.services.ServiceForecastUsers;
import com.netxforge.netxstudio.services.ServiceMonitor;
import com.netxforge.netxstudio.services.ServiceProfile;
import com.netxforge.netxstudio.services.ServiceUser;
import com.netxforge.netxstudio.services.ServicesPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see com.netxforge.netxstudio.services.ServicesPackage
 * @generated
 */
public class ServicesSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ServicesPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServicesSwitch() {
		if (modelPackage == null) {
			modelPackage = ServicesPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ServicesPackage.CFS_SERVICE: {
				CFSService cfsService = (CFSService)theEObject;
				T result = caseCFSService(cfsService);
				if (result == null) result = caseService(cfsService);
				if (result == null) result = caseBase(cfsService);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ServicesPackage.CIID: {
				CIID ciid = (CIID)theEObject;
				T result = caseCIID(ciid);
				if (result == null) result = caseBase(ciid);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ServicesPackage.DERIVED_RESOURCE: {
				DerivedResource derivedResource = (DerivedResource)theEObject;
				T result = caseDerivedResource(derivedResource);
				if (result == null) result = caseBaseResource(derivedResource);
				if (result == null) result = caseBase(derivedResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ServicesPackage.RFS_SERVICE: {
				RFSService rfsService = (RFSService)theEObject;
				T result = caseRFSService(rfsService);
				if (result == null) result = caseService(rfsService);
				if (result == null) result = caseBase(rfsService);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ServicesPackage.SERVICE: {
				Service service = (Service)theEObject;
				T result = caseService(service);
				if (result == null) result = caseBase(service);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ServicesPackage.SERVICE_DISTRIBUTION: {
				ServiceDistribution serviceDistribution = (ServiceDistribution)theEObject;
				T result = caseServiceDistribution(serviceDistribution);
				if (result == null) result = caseBase(serviceDistribution);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ServicesPackage.SERVICE_FORECAST: {
				ServiceForecast serviceForecast = (ServiceForecast)theEObject;
				T result = caseServiceForecast(serviceForecast);
				if (result == null) result = caseBase(serviceForecast);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ServicesPackage.SERVICE_FORECAST_USERS: {
				ServiceForecastUsers serviceForecastUsers = (ServiceForecastUsers)theEObject;
				T result = caseServiceForecastUsers(serviceForecastUsers);
				if (result == null) result = caseBase(serviceForecastUsers);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ServicesPackage.SERVICE_MONITOR: {
				ServiceMonitor serviceMonitor = (ServiceMonitor)theEObject;
				T result = caseServiceMonitor(serviceMonitor);
				if (result == null) result = caseBase(serviceMonitor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ServicesPackage.SERVICE_PROFILE: {
				ServiceProfile serviceProfile = (ServiceProfile)theEObject;
				T result = caseServiceProfile(serviceProfile);
				if (result == null) result = caseBase(serviceProfile);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ServicesPackage.SERVICE_USER: {
				ServiceUser serviceUser = (ServiceUser)theEObject;
				T result = caseServiceUser(serviceUser);
				if (result == null) result = caseBase(serviceUser);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CFS Service</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CFS Service</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCFSService(CFSService object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CIID</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CIID</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCIID(CIID object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Derived Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Derived Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDerivedResource(DerivedResource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>RFS Service</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>RFS Service</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRFSService(RFSService object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Service</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Service</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseService(Service object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Service Distribution</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Service Distribution</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseServiceDistribution(ServiceDistribution object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Service Forecast</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Service Forecast</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseServiceForecast(ServiceForecast object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Service Forecast Users</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Service Forecast Users</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseServiceForecastUsers(ServiceForecastUsers object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Service Monitor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Service Monitor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseServiceMonitor(ServiceMonitor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Service Profile</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Service Profile</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseServiceProfile(ServiceProfile object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Service User</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Service User</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseServiceUser(ServiceUser object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Base</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Base</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBase(Base object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Base Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Base Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBaseResource(BaseResource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //ServicesSwitch
