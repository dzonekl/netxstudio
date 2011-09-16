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
package com.netxforge.netxstudio.scheduling.impl;

import org.eclipse.emf.ecore.EClass;

import com.netxforge.netxstudio.scheduling.RFSServiceReporterJob;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;
import com.netxforge.netxstudio.services.RFSService;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>RFS Service Reporter Job</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.scheduling.impl.RFSServiceReporterJobImpl#getRFSService <em>RFS Service</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RFSServiceReporterJobImpl extends JobImpl implements RFSServiceReporterJob {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RFSServiceReporterJobImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SchedulingPackage.Literals.RFS_SERVICE_REPORTER_JOB;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RFSService getRFSService() {
		return (RFSService)eGet(SchedulingPackage.Literals.RFS_SERVICE_REPORTER_JOB__RFS_SERVICE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRFSService(RFSService newRFSService) {
		eSet(SchedulingPackage.Literals.RFS_SERVICE_REPORTER_JOB__RFS_SERVICE, newRFSService);
	}

} //RFSServiceReporterJobImpl
