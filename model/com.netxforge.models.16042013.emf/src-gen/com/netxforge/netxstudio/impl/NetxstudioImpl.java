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
package com.netxforge.netxstudio.impl;

import com.netxforge.netxstudio.Netxstudio;
import com.netxforge.netxstudio.NetxstudioPackage;

import com.netxforge.netxstudio.generics.Company;
import com.netxforge.netxstudio.generics.Person;
import com.netxforge.netxstudio.generics.Role;

import com.netxforge.netxstudio.geo.Country;

import com.netxforge.netxstudio.library.Library;
import com.netxforge.netxstudio.library.Vendor;

import com.netxforge.netxstudio.operators.Operator;

import com.netxforge.netxstudio.scheduling.Job;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

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
 *   <li>{@link com.netxforge.netxstudio.impl.NetxstudioImpl#getRoles <em>Roles</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.impl.NetxstudioImpl#getCountries <em>Countries</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.impl.NetxstudioImpl#getJobs <em>Jobs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NetxstudioImpl extends MinimalEObjectImpl.Container implements Netxstudio {
	/**
	 * The cached value of the '{@link #getOperators() <em>Operators</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperators()
	 * @generated
	 * @ordered
	 */
	protected EList<Operator> operators;

	/**
	 * The cached value of the '{@link #getLibraries() <em>Libraries</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLibraries()
	 * @generated
	 * @ordered
	 */
	protected EList<Library> libraries;

	/**
	 * The cached value of the '{@link #getCompanies() <em>Companies</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompanies()
	 * @generated
	 * @ordered
	 */
	protected EList<Company> companies;

	/**
	 * The cached value of the '{@link #getVendors() <em>Vendors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVendors()
	 * @generated
	 * @ordered
	 */
	protected EList<Vendor> vendors;

	/**
	 * The cached value of the '{@link #getUsers() <em>Users</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsers()
	 * @generated
	 * @ordered
	 */
	protected EList<Person> users;

	/**
	 * The cached value of the '{@link #getRoles() <em>Roles</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoles()
	 * @generated
	 * @ordered
	 */
	protected EList<Role> roles;

	/**
	 * The cached value of the '{@link #getCountries() <em>Countries</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCountries()
	 * @generated
	 * @ordered
	 */
	protected EList<Country> countries;

	/**
	 * The cached value of the '{@link #getJobs() <em>Jobs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJobs()
	 * @generated
	 * @ordered
	 */
	protected EList<Job> jobs;

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
	public EList<Operator> getOperators() {
		if (operators == null) {
			operators = new EObjectContainmentEList<Operator>(Operator.class, this, NetxstudioPackage.NETXSTUDIO__OPERATORS);
		}
		return operators;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Library> getLibraries() {
		if (libraries == null) {
			libraries = new EObjectContainmentEList<Library>(Library.class, this, NetxstudioPackage.NETXSTUDIO__LIBRARIES);
		}
		return libraries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Company> getCompanies() {
		if (companies == null) {
			companies = new EObjectContainmentEList<Company>(Company.class, this, NetxstudioPackage.NETXSTUDIO__COMPANIES);
		}
		return companies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Vendor> getVendors() {
		if (vendors == null) {
			vendors = new EObjectContainmentEList<Vendor>(Vendor.class, this, NetxstudioPackage.NETXSTUDIO__VENDORS);
		}
		return vendors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Person> getUsers() {
		if (users == null) {
			users = new EObjectContainmentEList<Person>(Person.class, this, NetxstudioPackage.NETXSTUDIO__USERS);
		}
		return users;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Role> getRoles() {
		if (roles == null) {
			roles = new EObjectContainmentEList<Role>(Role.class, this, NetxstudioPackage.NETXSTUDIO__ROLES);
		}
		return roles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Country> getCountries() {
		if (countries == null) {
			countries = new EObjectContainmentEList<Country>(Country.class, this, NetxstudioPackage.NETXSTUDIO__COUNTRIES);
		}
		return countries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Job> getJobs() {
		if (jobs == null) {
			jobs = new EObjectContainmentEList<Job>(Job.class, this, NetxstudioPackage.NETXSTUDIO__JOBS);
		}
		return jobs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NetxstudioPackage.NETXSTUDIO__OPERATORS:
				return ((InternalEList<?>)getOperators()).basicRemove(otherEnd, msgs);
			case NetxstudioPackage.NETXSTUDIO__LIBRARIES:
				return ((InternalEList<?>)getLibraries()).basicRemove(otherEnd, msgs);
			case NetxstudioPackage.NETXSTUDIO__COMPANIES:
				return ((InternalEList<?>)getCompanies()).basicRemove(otherEnd, msgs);
			case NetxstudioPackage.NETXSTUDIO__VENDORS:
				return ((InternalEList<?>)getVendors()).basicRemove(otherEnd, msgs);
			case NetxstudioPackage.NETXSTUDIO__USERS:
				return ((InternalEList<?>)getUsers()).basicRemove(otherEnd, msgs);
			case NetxstudioPackage.NETXSTUDIO__ROLES:
				return ((InternalEList<?>)getRoles()).basicRemove(otherEnd, msgs);
			case NetxstudioPackage.NETXSTUDIO__COUNTRIES:
				return ((InternalEList<?>)getCountries()).basicRemove(otherEnd, msgs);
			case NetxstudioPackage.NETXSTUDIO__JOBS:
				return ((InternalEList<?>)getJobs()).basicRemove(otherEnd, msgs);
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
			case NetxstudioPackage.NETXSTUDIO__OPERATORS:
				return getOperators();
			case NetxstudioPackage.NETXSTUDIO__LIBRARIES:
				return getLibraries();
			case NetxstudioPackage.NETXSTUDIO__COMPANIES:
				return getCompanies();
			case NetxstudioPackage.NETXSTUDIO__VENDORS:
				return getVendors();
			case NetxstudioPackage.NETXSTUDIO__USERS:
				return getUsers();
			case NetxstudioPackage.NETXSTUDIO__ROLES:
				return getRoles();
			case NetxstudioPackage.NETXSTUDIO__COUNTRIES:
				return getCountries();
			case NetxstudioPackage.NETXSTUDIO__JOBS:
				return getJobs();
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
			case NetxstudioPackage.NETXSTUDIO__OPERATORS:
				getOperators().clear();
				getOperators().addAll((Collection<? extends Operator>)newValue);
				return;
			case NetxstudioPackage.NETXSTUDIO__LIBRARIES:
				getLibraries().clear();
				getLibraries().addAll((Collection<? extends Library>)newValue);
				return;
			case NetxstudioPackage.NETXSTUDIO__COMPANIES:
				getCompanies().clear();
				getCompanies().addAll((Collection<? extends Company>)newValue);
				return;
			case NetxstudioPackage.NETXSTUDIO__VENDORS:
				getVendors().clear();
				getVendors().addAll((Collection<? extends Vendor>)newValue);
				return;
			case NetxstudioPackage.NETXSTUDIO__USERS:
				getUsers().clear();
				getUsers().addAll((Collection<? extends Person>)newValue);
				return;
			case NetxstudioPackage.NETXSTUDIO__ROLES:
				getRoles().clear();
				getRoles().addAll((Collection<? extends Role>)newValue);
				return;
			case NetxstudioPackage.NETXSTUDIO__COUNTRIES:
				getCountries().clear();
				getCountries().addAll((Collection<? extends Country>)newValue);
				return;
			case NetxstudioPackage.NETXSTUDIO__JOBS:
				getJobs().clear();
				getJobs().addAll((Collection<? extends Job>)newValue);
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
			case NetxstudioPackage.NETXSTUDIO__OPERATORS:
				getOperators().clear();
				return;
			case NetxstudioPackage.NETXSTUDIO__LIBRARIES:
				getLibraries().clear();
				return;
			case NetxstudioPackage.NETXSTUDIO__COMPANIES:
				getCompanies().clear();
				return;
			case NetxstudioPackage.NETXSTUDIO__VENDORS:
				getVendors().clear();
				return;
			case NetxstudioPackage.NETXSTUDIO__USERS:
				getUsers().clear();
				return;
			case NetxstudioPackage.NETXSTUDIO__ROLES:
				getRoles().clear();
				return;
			case NetxstudioPackage.NETXSTUDIO__COUNTRIES:
				getCountries().clear();
				return;
			case NetxstudioPackage.NETXSTUDIO__JOBS:
				getJobs().clear();
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
			case NetxstudioPackage.NETXSTUDIO__OPERATORS:
				return operators != null && !operators.isEmpty();
			case NetxstudioPackage.NETXSTUDIO__LIBRARIES:
				return libraries != null && !libraries.isEmpty();
			case NetxstudioPackage.NETXSTUDIO__COMPANIES:
				return companies != null && !companies.isEmpty();
			case NetxstudioPackage.NETXSTUDIO__VENDORS:
				return vendors != null && !vendors.isEmpty();
			case NetxstudioPackage.NETXSTUDIO__USERS:
				return users != null && !users.isEmpty();
			case NetxstudioPackage.NETXSTUDIO__ROLES:
				return roles != null && !roles.isEmpty();
			case NetxstudioPackage.NETXSTUDIO__COUNTRIES:
				return countries != null && !countries.isEmpty();
			case NetxstudioPackage.NETXSTUDIO__JOBS:
				return jobs != null && !jobs.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //NetxstudioImpl
