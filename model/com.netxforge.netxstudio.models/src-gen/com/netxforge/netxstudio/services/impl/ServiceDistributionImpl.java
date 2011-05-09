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

import com.netxforge.netxstudio.library.Expression;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.services.ServiceDistribution;
import com.netxforge.netxstudio.services.ServicesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Service Distribution</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.services.impl.ServiceDistributionImpl#getServiceResources <em>Service Resources</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.services.impl.ServiceDistributionImpl#getExpressionRefs <em>Expression Refs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ServiceDistributionImpl extends CDOObjectImpl implements ServiceDistribution {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ServiceDistributionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ServicesPackage.Literals.SERVICE_DISTRIBUTION;
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
	public EList<NetXResource> getServiceResources() {
		return (EList<NetXResource>)eGet(ServicesPackage.Literals.SERVICE_DISTRIBUTION__SERVICE_RESOURCES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Expression> getExpressionRefs() {
		return (EList<Expression>)eGet(ServicesPackage.Literals.SERVICE_DISTRIBUTION__EXPRESSION_REFS, true);
	}

} //ServiceDistributionImpl
