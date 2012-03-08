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

import com.netxforge.netxstudio.services.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ServicesFactoryImpl extends EFactoryImpl implements ServicesFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ServicesFactory init() {
		try {
			ServicesFactory theServicesFactory = (ServicesFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.netxforge.com/13042011/services"); 
			if (theServicesFactory != null) {
				return theServicesFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ServicesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServicesFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ServicesPackage.CFS_SERVICE: return (EObject)createCFSService();
			case ServicesPackage.CIID: return (EObject)createCIID();
			case ServicesPackage.DERIVED_RESOURCE: return (EObject)createDerivedResource();
			case ServicesPackage.DISTRIBUTION_ENTRY: return (EObject)createDistributionEntry();
			case ServicesPackage.RFS_SERVICE: return (EObject)createRFSService();
			case ServicesPackage.SERVICE: return (EObject)createService();
			case ServicesPackage.SERVICE_DISTRIBUTION: return (EObject)createServiceDistribution();
			case ServicesPackage.SERVICE_FORECAST: return (EObject)createServiceForecast();
			case ServicesPackage.SERVICE_FORECAST_USERS: return (EObject)createServiceForecastUsers();
			case ServicesPackage.SERVICE_MONITOR: return (EObject)createServiceMonitor();
			case ServicesPackage.SERVICE_PROFILE: return (EObject)createServiceProfile();
			case ServicesPackage.SERVICE_USER: return (EObject)createServiceUser();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case ServicesPackage.RESOURCE_ORIGIN_TYPE:
				return createResourceOriginTypeFromString(eDataType, initialValue);
			case ServicesPackage.SERVICE_CLASS_TYPE:
				return createServiceClassTypeFromString(eDataType, initialValue);
			case ServicesPackage.RESOURCE_ORIGIN_TYPE_OBJECT:
				return createResourceOriginTypeObjectFromString(eDataType, initialValue);
			case ServicesPackage.SERVICE_CLASS_TYPE_OBJECT:
				return createServiceClassTypeObjectFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case ServicesPackage.RESOURCE_ORIGIN_TYPE:
				return convertResourceOriginTypeToString(eDataType, instanceValue);
			case ServicesPackage.SERVICE_CLASS_TYPE:
				return convertServiceClassTypeToString(eDataType, instanceValue);
			case ServicesPackage.RESOURCE_ORIGIN_TYPE_OBJECT:
				return convertResourceOriginTypeObjectToString(eDataType, instanceValue);
			case ServicesPackage.SERVICE_CLASS_TYPE_OBJECT:
				return convertServiceClassTypeObjectToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CFSService createCFSService() {
		CFSServiceImpl cfsService = new CFSServiceImpl();
		return cfsService;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CIID createCIID() {
		CIIDImpl ciid = new CIIDImpl();
		return ciid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DerivedResource createDerivedResource() {
		DerivedResourceImpl derivedResource = new DerivedResourceImpl();
		return derivedResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DistributionEntry createDistributionEntry() {
		DistributionEntryImpl distributionEntry = new DistributionEntryImpl();
		return distributionEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RFSService createRFSService() {
		RFSServiceImpl rfsService = new RFSServiceImpl();
		return rfsService;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Service createService() {
		ServiceImpl service = new ServiceImpl();
		return service;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceDistribution createServiceDistribution() {
		ServiceDistributionImpl serviceDistribution = new ServiceDistributionImpl();
		return serviceDistribution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceForecast createServiceForecast() {
		ServiceForecastImpl serviceForecast = new ServiceForecastImpl();
		return serviceForecast;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceForecastUsers createServiceForecastUsers() {
		ServiceForecastUsersImpl serviceForecastUsers = new ServiceForecastUsersImpl();
		return serviceForecastUsers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceMonitor createServiceMonitor() {
		ServiceMonitorImpl serviceMonitor = new ServiceMonitorImpl();
		return serviceMonitor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceProfile createServiceProfile() {
		ServiceProfileImpl serviceProfile = new ServiceProfileImpl();
		return serviceProfile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceUser createServiceUser() {
		ServiceUserImpl serviceUser = new ServiceUserImpl();
		return serviceUser;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceOriginType createResourceOriginTypeFromString(EDataType eDataType, String initialValue) {
		ResourceOriginType result = ResourceOriginType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertResourceOriginTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceClassType createServiceClassTypeFromString(EDataType eDataType, String initialValue) {
		ServiceClassType result = ServiceClassType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertServiceClassTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceOriginType createResourceOriginTypeObjectFromString(EDataType eDataType, String initialValue) {
		return createResourceOriginTypeFromString(ServicesPackage.Literals.RESOURCE_ORIGIN_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertResourceOriginTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertResourceOriginTypeToString(ServicesPackage.Literals.RESOURCE_ORIGIN_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceClassType createServiceClassTypeObjectFromString(EDataType eDataType, String initialValue) {
		return createServiceClassTypeFromString(ServicesPackage.Literals.SERVICE_CLASS_TYPE, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertServiceClassTypeObjectToString(EDataType eDataType, Object instanceValue) {
		return convertServiceClassTypeToString(ServicesPackage.Literals.SERVICE_CLASS_TYPE, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServicesPackage getServicesPackage() {
		return (ServicesPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ServicesPackage getPackage() {
		return ServicesPackage.eINSTANCE;
	}

} //ServicesFactoryImpl
