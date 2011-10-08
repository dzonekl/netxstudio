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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

import com.netxforge.netxstudio.NetxstudioPackage;
import com.netxforge.netxstudio.generics.GenericsPackage;
import com.netxforge.netxstudio.generics.impl.GenericsPackageImpl;
import com.netxforge.netxstudio.geo.GeoPackage;
import com.netxforge.netxstudio.geo.impl.GeoPackageImpl;
import com.netxforge.netxstudio.impl.NetxstudioPackageImpl;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.impl.LibraryPackageImpl;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.metrics.impl.MetricsPackageImpl;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.operators.impl.OperatorsPackageImpl;
import com.netxforge.netxstudio.protocols.ProtocolsPackage;
import com.netxforge.netxstudio.protocols.impl.ProtocolsPackageImpl;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;
import com.netxforge.netxstudio.scheduling.impl.SchedulingPackageImpl;
import com.netxforge.netxstudio.services.CFSService;
import com.netxforge.netxstudio.services.DerivedResource;
import com.netxforge.netxstudio.services.DistributionEntry;
import com.netxforge.netxstudio.services.RFSService;
import com.netxforge.netxstudio.services.ResourceOriginType;
import com.netxforge.netxstudio.services.Service;
import com.netxforge.netxstudio.services.ServiceClassType;
import com.netxforge.netxstudio.services.ServiceDistribution;
import com.netxforge.netxstudio.services.ServiceForecast;
import com.netxforge.netxstudio.services.ServiceForecastUsers;
import com.netxforge.netxstudio.services.ServiceMonitor;
import com.netxforge.netxstudio.services.ServiceProfile;
import com.netxforge.netxstudio.services.ServiceUser;
import com.netxforge.netxstudio.services.ServicesFactory;
import com.netxforge.netxstudio.services.ServicesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ServicesPackageImpl extends EPackageImpl implements ServicesPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cfsServiceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ciidEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass derivedResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass distributionEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rfsServiceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serviceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serviceDistributionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serviceForecastEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serviceForecastUsersEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serviceMonitorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serviceProfileEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serviceUserEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum resourceOriginTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum serviceClassTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType resourceOriginTypeObjectEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType serviceClassTypeObjectEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see com.netxforge.netxstudio.services.ServicesPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ServicesPackageImpl() {
		super(eNS_URI, ServicesFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link ServicesPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ServicesPackage init() {
		if (isInited) return (ServicesPackage)EPackage.Registry.INSTANCE.getEPackage(ServicesPackage.eNS_URI);

		// Obtain or create and register package
		ServicesPackageImpl theServicesPackage = (ServicesPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ServicesPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ServicesPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		XMLTypePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		SchedulingPackageImpl theSchedulingPackage = (SchedulingPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SchedulingPackage.eNS_URI) instanceof SchedulingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SchedulingPackage.eNS_URI) : SchedulingPackage.eINSTANCE);
		GenericsPackageImpl theGenericsPackage = (GenericsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(GenericsPackage.eNS_URI) instanceof GenericsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(GenericsPackage.eNS_URI) : GenericsPackage.eINSTANCE);
		LibraryPackageImpl theLibraryPackage = (LibraryPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(LibraryPackage.eNS_URI) instanceof LibraryPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(LibraryPackage.eNS_URI) : LibraryPackage.eINSTANCE);
		OperatorsPackageImpl theOperatorsPackage = (OperatorsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(OperatorsPackage.eNS_URI) instanceof OperatorsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(OperatorsPackage.eNS_URI) : OperatorsPackage.eINSTANCE);
		MetricsPackageImpl theMetricsPackage = (MetricsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MetricsPackage.eNS_URI) instanceof MetricsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MetricsPackage.eNS_URI) : MetricsPackage.eINSTANCE);
		ProtocolsPackageImpl theProtocolsPackage = (ProtocolsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ProtocolsPackage.eNS_URI) instanceof ProtocolsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ProtocolsPackage.eNS_URI) : ProtocolsPackage.eINSTANCE);
		GeoPackageImpl theGeoPackage = (GeoPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(GeoPackage.eNS_URI) instanceof GeoPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(GeoPackage.eNS_URI) : GeoPackage.eINSTANCE);
		NetxstudioPackageImpl theNetxstudioPackage = (NetxstudioPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(NetxstudioPackage.eNS_URI) instanceof NetxstudioPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(NetxstudioPackage.eNS_URI) : NetxstudioPackage.eINSTANCE);

		// Create package meta-data objects
		theServicesPackage.createPackageContents();
		theSchedulingPackage.createPackageContents();
		theGenericsPackage.createPackageContents();
		theLibraryPackage.createPackageContents();
		theOperatorsPackage.createPackageContents();
		theMetricsPackage.createPackageContents();
		theProtocolsPackage.createPackageContents();
		theGeoPackage.createPackageContents();
		theNetxstudioPackage.createPackageContents();

		// Initialize created meta-data
		theServicesPackage.initializePackageContents();
		theSchedulingPackage.initializePackageContents();
		theGenericsPackage.initializePackageContents();
		theLibraryPackage.initializePackageContents();
		theOperatorsPackage.initializePackageContents();
		theMetricsPackage.initializePackageContents();
		theProtocolsPackage.initializePackageContents();
		theGeoPackage.initializePackageContents();
		theNetxstudioPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theServicesPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ServicesPackage.eNS_URI, theServicesPackage);
		return theServicesPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCFSService() {
		return cfsServiceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCFSService_Provider() {
		return (EAttribute)cfsServiceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCFSService_Scenario() {
		return (EAttribute)cfsServiceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCIID() {
		return ciidEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCIID_CommonCIID() {
		return (EAttribute)ciidEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCIID_LocalCIID() {
		return (EAttribute)ciidEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDerivedResource() {
		return derivedResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDerivedResource_Values() {
		return (EReference)derivedResourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDerivedResource_ForecastValues() {
		return (EReference)derivedResourceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDerivedResource_TrendedValues() {
		return (EReference)derivedResourceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDistributionEntry() {
		return distributionEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDistributionEntry_ResourceRef() {
		return (EReference)distributionEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDistributionEntry_Distribution() {
		return (EReference)distributionEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDistributionEntry_ResourceOrigin() {
		return (EAttribute)distributionEntryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRFSService() {
		return rfsServiceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRFSService_Nodes() {
		return (EReference)rfsServiceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRFSService_ToleranceRefs() {
		return (EReference)rfsServiceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRFSService_FunctionalCategory() {
		return (EAttribute)rfsServiceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getService() {
		return serviceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getService_CIID() {
		return (EReference)serviceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getService_Lifecycle() {
		return (EReference)serviceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getService_Services() {
		return (EReference)serviceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getService_ServiceForecasts() {
		return (EReference)serviceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getService_ServiceMonitors() {
		return (EReference)serviceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getService_ServiceUserRefs() {
		return (EReference)serviceEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getService_ServiceDistribution() {
		return (EReference)serviceEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getService_ServiceCategory() {
		return (EAttribute)serviceEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getService_ServiceClass() {
		return (EAttribute)serviceEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getService_ServiceDescription() {
		return (EAttribute)serviceEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getService_ServiceName() {
		return (EAttribute)serviceEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServiceDistribution() {
		return serviceDistributionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServiceDistribution_DistributionEntries() {
		return (EReference)serviceDistributionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServiceDistribution_ExpressionRefs() {
		return (EReference)serviceDistributionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServiceForecast() {
		return serviceForecastEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServiceForecast_Period() {
		return (EReference)serviceForecastEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServiceForecast_ServiceForecastUsers() {
		return (EReference)serviceForecastEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServiceForecast_ResourceForecasts() {
		return (EReference)serviceForecastEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceForecast_Name() {
		return (EAttribute)serviceForecastEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceForecast_Revision() {
		return (EAttribute)serviceForecastEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServiceForecastUsers() {
		return serviceForecastUsersEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServiceForecastUsers_UserValues() {
		return (EReference)serviceForecastUsersEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServiceForecastUsers_ServiceUserRef() {
		return (EReference)serviceForecastUsersEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServiceMonitor() {
		return serviceMonitorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServiceMonitor_Period() {
		return (EReference)serviceMonitorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServiceMonitor_ResourceMonitors() {
		return (EReference)serviceMonitorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceMonitor_Name() {
		return (EAttribute)serviceMonitorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceMonitor_Revision() {
		return (EAttribute)serviceMonitorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServiceProfile() {
		return serviceProfileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServiceProfile_ProfileResources() {
		return (EReference)serviceProfileEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceProfile_Name() {
		return (EAttribute)serviceProfileEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServiceUser() {
		return serviceUserEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServiceUser_ServiceProfile() {
		return (EReference)serviceUserEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServiceUser_ExpressionRef() {
		return (EReference)serviceUserEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceUser_Description() {
		return (EAttribute)serviceUserEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceUser_Name() {
		return (EAttribute)serviceUserEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getResourceOriginType() {
		return resourceOriginTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getServiceClassType() {
		return serviceClassTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getResourceOriginTypeObject() {
		return resourceOriginTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getServiceClassTypeObject() {
		return serviceClassTypeObjectEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServicesFactory getServicesFactory() {
		return (ServicesFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		cfsServiceEClass = createEClass(CFS_SERVICE);
		createEAttribute(cfsServiceEClass, CFS_SERVICE__PROVIDER);
		createEAttribute(cfsServiceEClass, CFS_SERVICE__SCENARIO);

		ciidEClass = createEClass(CIID);
		createEAttribute(ciidEClass, CIID__COMMON_CIID);
		createEAttribute(ciidEClass, CIID__LOCAL_CIID);

		derivedResourceEClass = createEClass(DERIVED_RESOURCE);
		createEReference(derivedResourceEClass, DERIVED_RESOURCE__VALUES);
		createEReference(derivedResourceEClass, DERIVED_RESOURCE__FORECAST_VALUES);
		createEReference(derivedResourceEClass, DERIVED_RESOURCE__TRENDED_VALUES);

		distributionEntryEClass = createEClass(DISTRIBUTION_ENTRY);
		createEReference(distributionEntryEClass, DISTRIBUTION_ENTRY__RESOURCE_REF);
		createEReference(distributionEntryEClass, DISTRIBUTION_ENTRY__DISTRIBUTION);
		createEAttribute(distributionEntryEClass, DISTRIBUTION_ENTRY__RESOURCE_ORIGIN);

		rfsServiceEClass = createEClass(RFS_SERVICE);
		createEReference(rfsServiceEClass, RFS_SERVICE__NODES);
		createEReference(rfsServiceEClass, RFS_SERVICE__TOLERANCE_REFS);
		createEAttribute(rfsServiceEClass, RFS_SERVICE__FUNCTIONAL_CATEGORY);

		serviceEClass = createEClass(SERVICE);
		createEReference(serviceEClass, SERVICE__CIID);
		createEReference(serviceEClass, SERVICE__LIFECYCLE);
		createEReference(serviceEClass, SERVICE__SERVICES);
		createEReference(serviceEClass, SERVICE__SERVICE_FORECASTS);
		createEReference(serviceEClass, SERVICE__SERVICE_MONITORS);
		createEReference(serviceEClass, SERVICE__SERVICE_USER_REFS);
		createEReference(serviceEClass, SERVICE__SERVICE_DISTRIBUTION);
		createEAttribute(serviceEClass, SERVICE__SERVICE_CATEGORY);
		createEAttribute(serviceEClass, SERVICE__SERVICE_CLASS);
		createEAttribute(serviceEClass, SERVICE__SERVICE_DESCRIPTION);
		createEAttribute(serviceEClass, SERVICE__SERVICE_NAME);

		serviceDistributionEClass = createEClass(SERVICE_DISTRIBUTION);
		createEReference(serviceDistributionEClass, SERVICE_DISTRIBUTION__DISTRIBUTION_ENTRIES);
		createEReference(serviceDistributionEClass, SERVICE_DISTRIBUTION__EXPRESSION_REFS);

		serviceForecastEClass = createEClass(SERVICE_FORECAST);
		createEReference(serviceForecastEClass, SERVICE_FORECAST__PERIOD);
		createEReference(serviceForecastEClass, SERVICE_FORECAST__SERVICE_FORECAST_USERS);
		createEReference(serviceForecastEClass, SERVICE_FORECAST__RESOURCE_FORECASTS);
		createEAttribute(serviceForecastEClass, SERVICE_FORECAST__NAME);
		createEAttribute(serviceForecastEClass, SERVICE_FORECAST__REVISION);

		serviceForecastUsersEClass = createEClass(SERVICE_FORECAST_USERS);
		createEReference(serviceForecastUsersEClass, SERVICE_FORECAST_USERS__USER_VALUES);
		createEReference(serviceForecastUsersEClass, SERVICE_FORECAST_USERS__SERVICE_USER_REF);

		serviceMonitorEClass = createEClass(SERVICE_MONITOR);
		createEReference(serviceMonitorEClass, SERVICE_MONITOR__PERIOD);
		createEReference(serviceMonitorEClass, SERVICE_MONITOR__RESOURCE_MONITORS);
		createEAttribute(serviceMonitorEClass, SERVICE_MONITOR__NAME);
		createEAttribute(serviceMonitorEClass, SERVICE_MONITOR__REVISION);

		serviceProfileEClass = createEClass(SERVICE_PROFILE);
		createEReference(serviceProfileEClass, SERVICE_PROFILE__PROFILE_RESOURCES);
		createEAttribute(serviceProfileEClass, SERVICE_PROFILE__NAME);

		serviceUserEClass = createEClass(SERVICE_USER);
		createEReference(serviceUserEClass, SERVICE_USER__SERVICE_PROFILE);
		createEReference(serviceUserEClass, SERVICE_USER__EXPRESSION_REF);
		createEAttribute(serviceUserEClass, SERVICE_USER__DESCRIPTION);
		createEAttribute(serviceUserEClass, SERVICE_USER__NAME);

		// Create enums
		resourceOriginTypeEEnum = createEEnum(RESOURCE_ORIGIN_TYPE);
		serviceClassTypeEEnum = createEEnum(SERVICE_CLASS_TYPE);

		// Create data types
		resourceOriginTypeObjectEDataType = createEDataType(RESOURCE_ORIGIN_TYPE_OBJECT);
		serviceClassTypeObjectEDataType = createEDataType(SERVICE_CLASS_TYPE_OBJECT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);
		GenericsPackage theGenericsPackage = (GenericsPackage)EPackage.Registry.INSTANCE.getEPackage(GenericsPackage.eNS_URI);
		LibraryPackage theLibraryPackage = (LibraryPackage)EPackage.Registry.INSTANCE.getEPackage(LibraryPackage.eNS_URI);
		OperatorsPackage theOperatorsPackage = (OperatorsPackage)EPackage.Registry.INSTANCE.getEPackage(OperatorsPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		cfsServiceEClass.getESuperTypes().add(this.getService());
		ciidEClass.getESuperTypes().add(theGenericsPackage.getBase());
		derivedResourceEClass.getESuperTypes().add(theLibraryPackage.getBaseResource());
		distributionEntryEClass.getESuperTypes().add(theGenericsPackage.getBase());
		rfsServiceEClass.getESuperTypes().add(this.getService());
		serviceEClass.getESuperTypes().add(theGenericsPackage.getBase());
		serviceDistributionEClass.getESuperTypes().add(theGenericsPackage.getBase());
		serviceForecastEClass.getESuperTypes().add(theGenericsPackage.getBase());
		serviceForecastUsersEClass.getESuperTypes().add(theGenericsPackage.getBase());
		serviceMonitorEClass.getESuperTypes().add(theGenericsPackage.getBase());
		serviceProfileEClass.getESuperTypes().add(theGenericsPackage.getBase());
		serviceUserEClass.getESuperTypes().add(theGenericsPackage.getBase());

		// Initialize classes and features; add operations and parameters
		initEClass(cfsServiceEClass, CFSService.class, "CFSService", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCFSService_Provider(), theXMLTypePackage.getString(), "provider", null, 0, 1, CFSService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCFSService_Scenario(), theXMLTypePackage.getString(), "scenario", null, 0, 1, CFSService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ciidEClass, com.netxforge.netxstudio.services.CIID.class, "CIID", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCIID_CommonCIID(), theGenericsPackage.getName255(), "commonCIID", null, 0, 1, com.netxforge.netxstudio.services.CIID.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCIID_LocalCIID(), theGenericsPackage.getName255(), "localCIID", null, 0, 1, com.netxforge.netxstudio.services.CIID.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(derivedResourceEClass, DerivedResource.class, "DerivedResource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDerivedResource_Values(), theGenericsPackage.getValue(), null, "values", null, 0, -1, DerivedResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDerivedResource_ForecastValues(), theGenericsPackage.getValue(), null, "forecastValues", null, 0, -1, DerivedResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDerivedResource_TrendedValues(), theGenericsPackage.getValue(), null, "trendedValues", null, 0, -1, DerivedResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(distributionEntryEClass, DistributionEntry.class, "DistributionEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDistributionEntry_ResourceRef(), theLibraryPackage.getNetXResource(), null, "resourceRef", null, 0, 1, DistributionEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDistributionEntry_Distribution(), this.getDerivedResource(), null, "distribution", null, 0, 1, DistributionEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDistributionEntry_ResourceOrigin(), this.getResourceOriginType(), "resourceOrigin", null, 0, 1, DistributionEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rfsServiceEClass, RFSService.class, "RFSService", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRFSService_Nodes(), theOperatorsPackage.getNode(), null, "nodes", null, 0, -1, RFSService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRFSService_ToleranceRefs(), theLibraryPackage.getTolerance(), null, "toleranceRefs", null, 0, -1, RFSService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRFSService_FunctionalCategory(), theXMLTypePackage.getString(), "functionalCategory", null, 0, 1, RFSService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(serviceEClass, Service.class, "Service", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getService_CIID(), this.getCIID(), null, "cIID", null, 0, -1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getService_Lifecycle(), theGenericsPackage.getLifecycle(), null, "lifecycle", null, 0, 1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getService_Services(), this.getService(), null, "services", null, 0, -1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getService_ServiceForecasts(), this.getServiceForecast(), null, "serviceForecasts", null, 0, -1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getService_ServiceMonitors(), this.getServiceMonitor(), null, "serviceMonitors", null, 0, -1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getService_ServiceUserRefs(), this.getServiceUser(), null, "serviceUserRefs", null, 0, -1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getService_ServiceDistribution(), this.getServiceDistribution(), null, "serviceDistribution", null, 0, 1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getService_ServiceCategory(), theGenericsPackage.getName255(), "serviceCategory", null, 0, 1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getService_ServiceClass(), this.getServiceClassType(), "serviceClass", null, 0, 1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getService_ServiceDescription(), theGenericsPackage.getDescription2000(), "serviceDescription", null, 0, 1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getService_ServiceName(), theGenericsPackage.getName255(), "serviceName", null, 0, 1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(serviceDistributionEClass, ServiceDistribution.class, "ServiceDistribution", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getServiceDistribution_DistributionEntries(), this.getDistributionEntry(), null, "distributionEntries", null, 0, -1, ServiceDistribution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getServiceDistribution_ExpressionRefs(), theLibraryPackage.getExpression(), null, "expressionRefs", null, 0, -1, ServiceDistribution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(serviceForecastEClass, ServiceForecast.class, "ServiceForecast", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getServiceForecast_Period(), theGenericsPackage.getDateTimeRange(), null, "period", null, 0, 1, ServiceForecast.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getServiceForecast_ServiceForecastUsers(), this.getServiceForecastUsers(), null, "serviceForecastUsers", null, 0, -1, ServiceForecast.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getServiceForecast_ResourceForecasts(), theOperatorsPackage.getResourceForecast(), null, "resourceForecasts", null, 0, -1, ServiceForecast.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getServiceForecast_Name(), theGenericsPackage.getName255(), "name", null, 0, 1, ServiceForecast.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getServiceForecast_Revision(), theGenericsPackage.getName255(), "revision", null, 0, 1, ServiceForecast.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(serviceForecastUsersEClass, ServiceForecastUsers.class, "ServiceForecastUsers", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getServiceForecastUsers_UserValues(), theGenericsPackage.getValue(), null, "userValues", null, 0, -1, ServiceForecastUsers.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getServiceForecastUsers_ServiceUserRef(), this.getServiceUser(), null, "serviceUserRef", null, 0, 1, ServiceForecastUsers.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(serviceMonitorEClass, ServiceMonitor.class, "ServiceMonitor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getServiceMonitor_Period(), theGenericsPackage.getDateTimeRange(), null, "period", null, 0, 1, ServiceMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getServiceMonitor_ResourceMonitors(), theOperatorsPackage.getResourceMonitor(), null, "resourceMonitors", null, 0, -1, ServiceMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getServiceMonitor_Name(), theGenericsPackage.getName255(), "name", null, 0, 1, ServiceMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getServiceMonitor_Revision(), theGenericsPackage.getName255(), "revision", null, 0, 1, ServiceMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(serviceProfileEClass, ServiceProfile.class, "ServiceProfile", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getServiceProfile_ProfileResources(), this.getDerivedResource(), null, "profileResources", null, 0, -1, ServiceProfile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getServiceProfile_Name(), theGenericsPackage.getName255(), "name", null, 0, 1, ServiceProfile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(serviceUserEClass, ServiceUser.class, "ServiceUser", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getServiceUser_ServiceProfile(), this.getServiceProfile(), null, "serviceProfile", null, 0, 1, ServiceUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getServiceUser_ExpressionRef(), theLibraryPackage.getExpression(), null, "expressionRef", null, 0, 1, ServiceUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getServiceUser_Description(), theGenericsPackage.getDescription2000(), "description", null, 0, 1, ServiceUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getServiceUser_Name(), theGenericsPackage.getName255(), "name", null, 0, 1, ServiceUser.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(resourceOriginTypeEEnum, ResourceOriginType.class, "ResourceOriginType");
		addEEnumLiteral(resourceOriginTypeEEnum, ResourceOriginType.IN_BOUND);
		addEEnumLiteral(resourceOriginTypeEEnum, ResourceOriginType.OUT_BOUND);
		addEEnumLiteral(resourceOriginTypeEEnum, ResourceOriginType.INTERNAL);

		initEEnum(serviceClassTypeEEnum, ServiceClassType.class, "ServiceClassType");
		addEEnumLiteral(serviceClassTypeEEnum, ServiceClassType.GOLD);
		addEEnumLiteral(serviceClassTypeEEnum, ServiceClassType.SILVER);
		addEEnumLiteral(serviceClassTypeEEnum, ServiceClassType.BRONZE);

		// Initialize data types
		initEDataType(resourceOriginTypeObjectEDataType, ResourceOriginType.class, "ResourceOriginTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);
		initEDataType(serviceClassTypeObjectEDataType, ServiceClassType.class, "ServiceClassTypeObject", IS_SERIALIZABLE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore";			
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "validationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL\nhttp://www.eclipse.org/emf/2002/Ecore/OCL",
			 "settingDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL\nhttp://www.eclipse.org/emf/2002/Ecore/OCL",
			 "invocationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL\nhttp://www.eclipse.org/emf/2002/Ecore/OCL"
		   });																																																																																																																	
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";					
		addAnnotation
		  (cfsServiceEClass, 
		   source, 
		   new String[] {
			 "name", "CFSService",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getCFSService_Provider(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Provider"
		   });			
		addAnnotation
		  (getCFSService_Scenario(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Scenario"
		   });			
		addAnnotation
		  (ciidEClass, 
		   source, 
		   new String[] {
			 "name", "CI-ID",
			 "kind", "empty"
		   });			
		addAnnotation
		  (getCIID_CommonCIID(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "CommonCI_ID"
		   });			
		addAnnotation
		  (getCIID_LocalCIID(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "localCI_ID"
		   });			
		addAnnotation
		  (derivedResourceEClass, 
		   source, 
		   new String[] {
			 "name", "DerivedResource",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getDerivedResource_Values(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Values"
		   });			
		addAnnotation
		  (getDerivedResource_ForecastValues(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ForecastValues"
		   });			
		addAnnotation
		  (getDerivedResource_TrendedValues(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "TrendedValues"
		   });			
		addAnnotation
		  (distributionEntryEClass, 
		   source, 
		   new String[] {
			 "name", "DistributionEntry",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getDistributionEntry_ResourceRef(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ResourceRef"
		   });			
		addAnnotation
		  (getDistributionEntry_Distribution(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Distribution"
		   });		
		addAnnotation
		  (getDistributionEntry_ResourceOrigin(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "ResourceOrigin"
		   });		
		addAnnotation
		  (resourceOriginTypeEEnum, 
		   source, 
		   new String[] {
			 "name", "ResourceOrigin_._type"
		   });		
		addAnnotation
		  (resourceOriginTypeObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "ResourceOrigin_._type:Object",
			 "baseType", "ResourceOrigin_._type"
		   });			
		addAnnotation
		  (rfsServiceEClass, 
		   source, 
		   new String[] {
			 "name", "RFSService",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getRFSService_Nodes(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Nodes"
		   });			
		addAnnotation
		  (getRFSService_ToleranceRefs(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ToleranceRefs"
		   });			
		addAnnotation
		  (getRFSService_FunctionalCategory(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "functionalCategory"
		   });			
		addAnnotation
		  (serviceEClass, 
		   source, 
		   new String[] {
			 "name", "Service",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getService_CIID(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "CIID"
		   });			
		addAnnotation
		  (getService_Lifecycle(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Lifecycle"
		   });			
		addAnnotation
		  (getService_Services(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Services"
		   });			
		addAnnotation
		  (getService_ServiceForecasts(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ServiceForecasts"
		   });			
		addAnnotation
		  (getService_ServiceMonitors(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ServiceMonitors"
		   });			
		addAnnotation
		  (getService_ServiceUserRefs(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ServiceUserRefs"
		   });			
		addAnnotation
		  (getService_ServiceDistribution(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ServiceDistribution"
		   });			
		addAnnotation
		  (getService_ServiceCategory(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "ServiceCategory"
		   });			
		addAnnotation
		  (getService_ServiceClass(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "ServiceClass"
		   });			
		addAnnotation
		  (getService_ServiceDescription(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "ServiceDescription"
		   });			
		addAnnotation
		  (getService_ServiceName(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "ServiceName"
		   });		
		addAnnotation
		  (serviceClassTypeEEnum, 
		   source, 
		   new String[] {
			 "name", "ServiceClass_._type"
		   });		
		addAnnotation
		  (serviceClassTypeObjectEDataType, 
		   source, 
		   new String[] {
			 "name", "ServiceClass_._type:Object",
			 "baseType", "ServiceClass_._type"
		   });			
		addAnnotation
		  (serviceDistributionEClass, 
		   source, 
		   new String[] {
			 "name", "ServiceDistribution",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getServiceDistribution_DistributionEntries(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "DistributionEntries"
		   });			
		addAnnotation
		  (getServiceDistribution_ExpressionRefs(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ExpressionRefs"
		   });			
		addAnnotation
		  (serviceForecastEClass, 
		   source, 
		   new String[] {
			 "name", "ServiceForecast",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getServiceForecast_Period(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Period"
		   });			
		addAnnotation
		  (getServiceForecast_ServiceForecastUsers(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ServiceForecastUsers"
		   });			
		addAnnotation
		  (getServiceForecast_ResourceForecasts(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ResourceForecasts"
		   });			
		addAnnotation
		  (getServiceForecast_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Name"
		   });			
		addAnnotation
		  (getServiceForecast_Revision(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Revision"
		   });			
		addAnnotation
		  (serviceForecastUsersEClass, 
		   source, 
		   new String[] {
			 "name", "ServiceForecastUsers",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getServiceForecastUsers_UserValues(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "UserValues"
		   });			
		addAnnotation
		  (getServiceForecastUsers_ServiceUserRef(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ServiceUserRef"
		   });			
		addAnnotation
		  (serviceMonitorEClass, 
		   source, 
		   new String[] {
			 "name", "ServiceMonitor",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getServiceMonitor_Period(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "Period"
		   });			
		addAnnotation
		  (getServiceMonitor_ResourceMonitors(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ResourceMonitors"
		   });			
		addAnnotation
		  (getServiceMonitor_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Name"
		   });			
		addAnnotation
		  (getServiceMonitor_Revision(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Revision"
		   });			
		addAnnotation
		  (serviceProfileEClass, 
		   source, 
		   new String[] {
			 "name", "ServiceProfile",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getServiceProfile_ProfileResources(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ProfileResources"
		   });			
		addAnnotation
		  (getServiceProfile_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Name"
		   });			
		addAnnotation
		  (serviceUserEClass, 
		   source, 
		   new String[] {
			 "name", "ServiceUser",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getServiceUser_ServiceProfile(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ServiceProfile"
		   });			
		addAnnotation
		  (getServiceUser_ExpressionRef(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "ExpressionRef"
		   });			
		addAnnotation
		  (getServiceUser_Description(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Description"
		   });			
		addAnnotation
		  (getServiceUser_Name(), 
		   source, 
		   new String[] {
			 "kind", "attribute",
			 "name", "Name"
		   });
	}

} //ServicesPackageImpl
