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

import org.eclipse.emf.ecore.EClass;

import com.netxforge.netxstudio.generics.impl.BaseImpl;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.services.DerivedResource;
import com.netxforge.netxstudio.services.DistributionEntry;
import com.netxforge.netxstudio.services.ResourceOriginType;
import com.netxforge.netxstudio.services.ServicesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Distribution Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.services.impl.DistributionEntryImpl#getResourceRef <em>Resource Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.impl.DistributionEntryImpl#getDistribution <em>Distribution</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.impl.DistributionEntryImpl#getResourceOrigin <em>Resource Origin</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DistributionEntryImpl extends BaseImpl implements DistributionEntry {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DistributionEntryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ServicesPackage.Literals.DISTRIBUTION_ENTRY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NetXResource getResourceRef() {
		return (NetXResource)eGet(ServicesPackage.Literals.DISTRIBUTION_ENTRY__RESOURCE_REF, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceRef(NetXResource newResourceRef) {
		eSet(ServicesPackage.Literals.DISTRIBUTION_ENTRY__RESOURCE_REF, newResourceRef);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DerivedResource getDistribution() {
		return (DerivedResource)eGet(ServicesPackage.Literals.DISTRIBUTION_ENTRY__DISTRIBUTION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDistribution(DerivedResource newDistribution) {
		eSet(ServicesPackage.Literals.DISTRIBUTION_ENTRY__DISTRIBUTION, newDistribution);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceOriginType getResourceOrigin() {
		return (ResourceOriginType)eGet(ServicesPackage.Literals.DISTRIBUTION_ENTRY__RESOURCE_ORIGIN, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceOrigin(ResourceOriginType newResourceOrigin) {
		eSet(ServicesPackage.Literals.DISTRIBUTION_ENTRY__RESOURCE_ORIGIN, newResourceOrigin);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetResourceOrigin() {
		eUnset(ServicesPackage.Literals.DISTRIBUTION_ENTRY__RESOURCE_ORIGIN);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetResourceOrigin() {
		return eIsSet(ServicesPackage.Literals.DISTRIBUTION_ENTRY__RESOURCE_ORIGIN);
	}

} //DistributionEntryImpl
