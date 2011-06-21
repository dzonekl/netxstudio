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
package com.netxforge.netxstudio.geo.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import com.netxforge.netxstudio.generics.MultiImage;
import com.netxforge.netxstudio.generics.impl.BaseImpl;
import com.netxforge.netxstudio.geo.Country;
import com.netxforge.netxstudio.geo.GeoPackage;
import com.netxforge.netxstudio.geo.Site;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Country</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.geo.impl.CountryImpl#getSites <em>Sites</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.geo.impl.CountryImpl#getIcons <em>Icons</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.geo.impl.CountryImpl#getCountryCode <em>Country Code</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.geo.impl.CountryImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CountryImpl extends BaseImpl implements Country {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CountryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeoPackage.Literals.COUNTRY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Site> getSites() {
		return (EList<Site>)eGet(GeoPackage.Literals.COUNTRY__SITES, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiImage getIcons() {
		return (MultiImage)eGet(GeoPackage.Literals.COUNTRY__ICONS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIcons(MultiImage newIcons) {
		eSet(GeoPackage.Literals.COUNTRY__ICONS, newIcons);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCountryCode() {
		return (String)eGet(GeoPackage.Literals.COUNTRY__COUNTRY_CODE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCountryCode(String newCountryCode) {
		eSet(GeoPackage.Literals.COUNTRY__COUNTRY_CODE, newCountryCode);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String)eGet(GeoPackage.Literals.COUNTRY__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(GeoPackage.Literals.COUNTRY__NAME, newName);
	}

} //CountryImpl
