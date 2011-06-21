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

import com.netxforge.netxstudio.generics.impl.BaseImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import com.netxforge.netxstudio.geo.GeoPackage;
import com.netxforge.netxstudio.geo.Room;
import com.netxforge.netxstudio.geo.Site;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Site</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.geo.impl.SiteImpl#getRooms <em>Rooms</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.geo.impl.SiteImpl#getArea <em>Area</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.geo.impl.SiteImpl#getCity <em>City</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.geo.impl.SiteImpl#getHousenumber <em>Housenumber</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.geo.impl.SiteImpl#getLatitude <em>Latitude</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.geo.impl.SiteImpl#getLongitude <em>Longitude</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.geo.impl.SiteImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.geo.impl.SiteImpl#getPostalcode <em>Postalcode</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.geo.impl.SiteImpl#getRegion <em>Region</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.geo.impl.SiteImpl#getSreet <em>Sreet</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SiteImpl extends BaseImpl implements Site {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SiteImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GeoPackage.Literals.SITE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Room> getRooms() {
		return (EList<Room>)eGet(GeoPackage.Literals.SITE__ROOMS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getArea() {
		return (String)eGet(GeoPackage.Literals.SITE__AREA, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArea(String newArea) {
		eSet(GeoPackage.Literals.SITE__AREA, newArea);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCity() {
		return (String)eGet(GeoPackage.Literals.SITE__CITY, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCity(String newCity) {
		eSet(GeoPackage.Literals.SITE__CITY, newCity);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHousenumber() {
		return (String)eGet(GeoPackage.Literals.SITE__HOUSENUMBER, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHousenumber(String newHousenumber) {
		eSet(GeoPackage.Literals.SITE__HOUSENUMBER, newHousenumber);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLatitude() {
		return (String)eGet(GeoPackage.Literals.SITE__LATITUDE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLatitude(String newLatitude) {
		eSet(GeoPackage.Literals.SITE__LATITUDE, newLatitude);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLongitude() {
		return (String)eGet(GeoPackage.Literals.SITE__LONGITUDE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLongitude(String newLongitude) {
		eSet(GeoPackage.Literals.SITE__LONGITUDE, newLongitude);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String)eGet(GeoPackage.Literals.SITE__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(GeoPackage.Literals.SITE__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPostalcode() {
		return (String)eGet(GeoPackage.Literals.SITE__POSTALCODE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPostalcode(String newPostalcode) {
		eSet(GeoPackage.Literals.SITE__POSTALCODE, newPostalcode);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRegion() {
		return (String)eGet(GeoPackage.Literals.SITE__REGION, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRegion(String newRegion) {
		eSet(GeoPackage.Literals.SITE__REGION, newRegion);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSreet() {
		return (String)eGet(GeoPackage.Literals.SITE__SREET, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSreet(String newSreet) {
		eSet(GeoPackage.Literals.SITE__SREET, newSreet);
	}

} //SiteImpl
