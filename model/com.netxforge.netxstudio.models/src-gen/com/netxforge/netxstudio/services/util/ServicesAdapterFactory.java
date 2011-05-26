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

import com.netxforge.netxstudio.services.*;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import com.netxforge.netxstudio.services.CFSService;
import com.netxforge.netxstudio.services.CIID;
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
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.netxforge.netxstudio.services.ServicesPackage
 * @generated
 */
public class ServicesAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ServicesPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServicesAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ServicesPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ServicesSwitch<Adapter> modelSwitch =
		new ServicesSwitch<Adapter>() {
			@Override
			public Adapter caseCFSService(CFSService object) {
				return createCFSServiceAdapter();
			}
			@Override
			public Adapter caseCIID(CIID object) {
				return createCIIDAdapter();
			}
			@Override
			public Adapter caseRFSService(RFSService object) {
				return createRFSServiceAdapter();
			}
			@Override
			public Adapter caseService(Service object) {
				return createServiceAdapter();
			}
			@Override
			public Adapter caseServiceDistribution(ServiceDistribution object) {
				return createServiceDistributionAdapter();
			}
			@Override
			public Adapter caseServiceForecast(ServiceForecast object) {
				return createServiceForecastAdapter();
			}
			@Override
			public Adapter caseServiceForecastUsers(ServiceForecastUsers object) {
				return createServiceForecastUsersAdapter();
			}
			@Override
			public Adapter caseServiceMonitor(ServiceMonitor object) {
				return createServiceMonitorAdapter();
			}
			@Override
			public Adapter caseServiceProfile(ServiceProfile object) {
				return createServiceProfileAdapter();
			}
			@Override
			public Adapter caseServiceUser(ServiceUser object) {
				return createServiceUserAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link com.netxforge.netxstudio.services.CFSService <em>CFS Service</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.netxforge.netxstudio.services.CFSService
	 * @generated
	 */
	public Adapter createCFSServiceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.netxforge.netxstudio.services.CIID <em>CIID</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.netxforge.netxstudio.services.CIID
	 * @generated
	 */
	public Adapter createCIIDAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.netxforge.netxstudio.services.RFSService <em>RFS Service</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.netxforge.netxstudio.services.RFSService
	 * @generated
	 */
	public Adapter createRFSServiceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.netxforge.netxstudio.services.Service <em>Service</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.netxforge.netxstudio.services.Service
	 * @generated
	 */
	public Adapter createServiceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.netxforge.netxstudio.services.ServiceDistribution <em>Service Distribution</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.netxforge.netxstudio.services.ServiceDistribution
	 * @generated
	 */
	public Adapter createServiceDistributionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.netxforge.netxstudio.services.ServiceForecast <em>Service Forecast</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.netxforge.netxstudio.services.ServiceForecast
	 * @generated
	 */
	public Adapter createServiceForecastAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.netxforge.netxstudio.services.ServiceForecastUsers <em>Service Forecast Users</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.netxforge.netxstudio.services.ServiceForecastUsers
	 * @generated
	 */
	public Adapter createServiceForecastUsersAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.netxforge.netxstudio.services.ServiceMonitor <em>Service Monitor</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.netxforge.netxstudio.services.ServiceMonitor
	 * @generated
	 */
	public Adapter createServiceMonitorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.netxforge.netxstudio.services.ServiceProfile <em>Service Profile</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.netxforge.netxstudio.services.ServiceProfile
	 * @generated
	 */
	public Adapter createServiceProfileAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.netxforge.netxstudio.services.ServiceUser <em>Service User</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.netxforge.netxstudio.services.ServiceUser
	 * @generated
	 */
	public Adapter createServiceUserAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ServicesAdapterFactory
