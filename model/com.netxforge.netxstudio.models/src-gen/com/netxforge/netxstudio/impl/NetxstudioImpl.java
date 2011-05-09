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
package com.netxforge.netxstudio.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import com.netxforge.netxstudio.Netxstudio;
import com.netxforge.netxstudio.NetxstudioPackage;
import com.netxforge.netxstudio.generics.Company;
import com.netxforge.netxstudio.generics.Person;
import com.netxforge.netxstudio.geo.Country;
import com.netxforge.netxstudio.library.Library;
import com.netxforge.netxstudio.library.Vendor;
import com.netxforge.netxstudio.operators.Operator;
import com.netxforge.netxstudio.scheduling.Job;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Netxstudio</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.impl.NetxstudioImpl#getOperators <em>Operators</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.impl.NetxstudioImpl#getLibraries <em>Libraries</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.impl.NetxstudioImpl#getCompanies <em>Companies</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.impl.NetxstudioImpl#getVendors <em>Vendors</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.impl.NetxstudioImpl#getUsers <em>Users</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.impl.NetxstudioImpl#getCountries <em>Countries</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.impl.NetxstudioImpl#getJobs <em>Jobs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NetxstudioImpl extends CDOObjectImpl implements Netxstudio {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NetxstudioImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NetxstudioPackage.Literals.NETXSTUDIO;
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
	public EList<Operator> getOperators() {
		return (EList<Operator>)eGet(NetxstudioPackage.Literals.NETXSTUDIO__OPERATORS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Library> getLibraries() {
		return (EList<Library>)eGet(NetxstudioPackage.Literals.NETXSTUDIO__LIBRARIES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Company> getCompanies() {
		return (EList<Company>)eGet(NetxstudioPackage.Literals.NETXSTUDIO__COMPANIES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Vendor> getVendors() {
		return (EList<Vendor>)eGet(NetxstudioPackage.Literals.NETXSTUDIO__VENDORS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Person> getUsers() {
		return (EList<Person>)eGet(NetxstudioPackage.Literals.NETXSTUDIO__USERS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Country> getCountries() {
		return (EList<Country>)eGet(NetxstudioPackage.Literals.NETXSTUDIO__COUNTRIES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Job> getJobs() {
		return (EList<Job>)eGet(NetxstudioPackage.Literals.NETXSTUDIO__JOBS, true);
	}

} //NetxstudioImpl
