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

import com.netxforge.netxstudio.geo.GeoPackage;
import com.netxforge.netxstudio.geo.Room;
import com.netxforge.netxstudio.geo.Site;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

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
public class SiteImpl extends EObjectImpl implements Site {
	/**
	 * The cached value of the '{@link #getRooms() <em>Rooms</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRooms()
	 * @generated
	 * @ordered
	 */
	protected EList<Room> rooms;

	/**
	 * The default value of the '{@link #getArea() <em>Area</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArea()
	 * @generated
	 * @ordered
	 */
	protected static final String AREA_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getArea() <em>Area</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArea()
	 * @generated
	 * @ordered
	 */
	protected String area = AREA_EDEFAULT;

	/**
	 * The default value of the '{@link #getCity() <em>City</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCity()
	 * @generated
	 * @ordered
	 */
	protected static final String CITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCity() <em>City</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCity()
	 * @generated
	 * @ordered
	 */
	protected String city = CITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getHousenumber() <em>Housenumber</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHousenumber()
	 * @generated
	 * @ordered
	 */
	protected static final String HOUSENUMBER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getHousenumber() <em>Housenumber</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHousenumber()
	 * @generated
	 * @ordered
	 */
	protected String housenumber = HOUSENUMBER_EDEFAULT;

	/**
	 * The default value of the '{@link #getLatitude() <em>Latitude</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLatitude()
	 * @generated
	 * @ordered
	 */
	protected static final String LATITUDE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLatitude() <em>Latitude</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLatitude()
	 * @generated
	 * @ordered
	 */
	protected String latitude = LATITUDE_EDEFAULT;

	/**
	 * The default value of the '{@link #getLongitude() <em>Longitude</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLongitude()
	 * @generated
	 * @ordered
	 */
	protected static final String LONGITUDE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLongitude() <em>Longitude</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLongitude()
	 * @generated
	 * @ordered
	 */
	protected String longitude = LONGITUDE_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getPostalcode() <em>Postalcode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPostalcode()
	 * @generated
	 * @ordered
	 */
	protected static final String POSTALCODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPostalcode() <em>Postalcode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPostalcode()
	 * @generated
	 * @ordered
	 */
	protected String postalcode = POSTALCODE_EDEFAULT;

	/**
	 * The default value of the '{@link #getRegion() <em>Region</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegion()
	 * @generated
	 * @ordered
	 */
	protected static final String REGION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRegion() <em>Region</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegion()
	 * @generated
	 * @ordered
	 */
	protected String region = REGION_EDEFAULT;

	/**
	 * The default value of the '{@link #getSreet() <em>Sreet</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSreet()
	 * @generated
	 * @ordered
	 */
	protected static final String SREET_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSreet() <em>Sreet</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSreet()
	 * @generated
	 * @ordered
	 */
	protected String sreet = SREET_EDEFAULT;

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
	public EList<Room> getRooms() {
		if (rooms == null) {
			rooms = new EObjectContainmentEList<Room>(Room.class, this, GeoPackage.SITE__ROOMS);
		}
		return rooms;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getArea() {
		return area;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArea(String newArea) {
		String oldArea = area;
		area = newArea;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeoPackage.SITE__AREA, oldArea, area));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCity() {
		return city;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCity(String newCity) {
		String oldCity = city;
		city = newCity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeoPackage.SITE__CITY, oldCity, city));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getHousenumber() {
		return housenumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHousenumber(String newHousenumber) {
		String oldHousenumber = housenumber;
		housenumber = newHousenumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeoPackage.SITE__HOUSENUMBER, oldHousenumber, housenumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLatitude() {
		return latitude;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLatitude(String newLatitude) {
		String oldLatitude = latitude;
		latitude = newLatitude;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeoPackage.SITE__LATITUDE, oldLatitude, latitude));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLongitude() {
		return longitude;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLongitude(String newLongitude) {
		String oldLongitude = longitude;
		longitude = newLongitude;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeoPackage.SITE__LONGITUDE, oldLongitude, longitude));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeoPackage.SITE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPostalcode() {
		return postalcode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPostalcode(String newPostalcode) {
		String oldPostalcode = postalcode;
		postalcode = newPostalcode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeoPackage.SITE__POSTALCODE, oldPostalcode, postalcode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRegion() {
		return region;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRegion(String newRegion) {
		String oldRegion = region;
		region = newRegion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeoPackage.SITE__REGION, oldRegion, region));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSreet() {
		return sreet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSreet(String newSreet) {
		String oldSreet = sreet;
		sreet = newSreet;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GeoPackage.SITE__SREET, oldSreet, sreet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case GeoPackage.SITE__ROOMS:
				return ((InternalEList<?>)getRooms()).basicRemove(otherEnd, msgs);
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
			case GeoPackage.SITE__ROOMS:
				return getRooms();
			case GeoPackage.SITE__AREA:
				return getArea();
			case GeoPackage.SITE__CITY:
				return getCity();
			case GeoPackage.SITE__HOUSENUMBER:
				return getHousenumber();
			case GeoPackage.SITE__LATITUDE:
				return getLatitude();
			case GeoPackage.SITE__LONGITUDE:
				return getLongitude();
			case GeoPackage.SITE__NAME:
				return getName();
			case GeoPackage.SITE__POSTALCODE:
				return getPostalcode();
			case GeoPackage.SITE__REGION:
				return getRegion();
			case GeoPackage.SITE__SREET:
				return getSreet();
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
			case GeoPackage.SITE__ROOMS:
				getRooms().clear();
				getRooms().addAll((Collection<? extends Room>)newValue);
				return;
			case GeoPackage.SITE__AREA:
				setArea((String)newValue);
				return;
			case GeoPackage.SITE__CITY:
				setCity((String)newValue);
				return;
			case GeoPackage.SITE__HOUSENUMBER:
				setHousenumber((String)newValue);
				return;
			case GeoPackage.SITE__LATITUDE:
				setLatitude((String)newValue);
				return;
			case GeoPackage.SITE__LONGITUDE:
				setLongitude((String)newValue);
				return;
			case GeoPackage.SITE__NAME:
				setName((String)newValue);
				return;
			case GeoPackage.SITE__POSTALCODE:
				setPostalcode((String)newValue);
				return;
			case GeoPackage.SITE__REGION:
				setRegion((String)newValue);
				return;
			case GeoPackage.SITE__SREET:
				setSreet((String)newValue);
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
			case GeoPackage.SITE__ROOMS:
				getRooms().clear();
				return;
			case GeoPackage.SITE__AREA:
				setArea(AREA_EDEFAULT);
				return;
			case GeoPackage.SITE__CITY:
				setCity(CITY_EDEFAULT);
				return;
			case GeoPackage.SITE__HOUSENUMBER:
				setHousenumber(HOUSENUMBER_EDEFAULT);
				return;
			case GeoPackage.SITE__LATITUDE:
				setLatitude(LATITUDE_EDEFAULT);
				return;
			case GeoPackage.SITE__LONGITUDE:
				setLongitude(LONGITUDE_EDEFAULT);
				return;
			case GeoPackage.SITE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case GeoPackage.SITE__POSTALCODE:
				setPostalcode(POSTALCODE_EDEFAULT);
				return;
			case GeoPackage.SITE__REGION:
				setRegion(REGION_EDEFAULT);
				return;
			case GeoPackage.SITE__SREET:
				setSreet(SREET_EDEFAULT);
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
			case GeoPackage.SITE__ROOMS:
				return rooms != null && !rooms.isEmpty();
			case GeoPackage.SITE__AREA:
				return AREA_EDEFAULT == null ? area != null : !AREA_EDEFAULT.equals(area);
			case GeoPackage.SITE__CITY:
				return CITY_EDEFAULT == null ? city != null : !CITY_EDEFAULT.equals(city);
			case GeoPackage.SITE__HOUSENUMBER:
				return HOUSENUMBER_EDEFAULT == null ? housenumber != null : !HOUSENUMBER_EDEFAULT.equals(housenumber);
			case GeoPackage.SITE__LATITUDE:
				return LATITUDE_EDEFAULT == null ? latitude != null : !LATITUDE_EDEFAULT.equals(latitude);
			case GeoPackage.SITE__LONGITUDE:
				return LONGITUDE_EDEFAULT == null ? longitude != null : !LONGITUDE_EDEFAULT.equals(longitude);
			case GeoPackage.SITE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case GeoPackage.SITE__POSTALCODE:
				return POSTALCODE_EDEFAULT == null ? postalcode != null : !POSTALCODE_EDEFAULT.equals(postalcode);
			case GeoPackage.SITE__REGION:
				return REGION_EDEFAULT == null ? region != null : !REGION_EDEFAULT.equals(region);
			case GeoPackage.SITE__SREET:
				return SREET_EDEFAULT == null ? sreet != null : !SREET_EDEFAULT.equals(sreet);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (area: ");
		result.append(area);
		result.append(", city: ");
		result.append(city);
		result.append(", housenumber: ");
		result.append(housenumber);
		result.append(", latitude: ");
		result.append(latitude);
		result.append(", longitude: ");
		result.append(longitude);
		result.append(", name: ");
		result.append(name);
		result.append(", postalcode: ");
		result.append(postalcode);
		result.append(", region: ");
		result.append(region);
		result.append(", sreet: ");
		result.append(sreet);
		result.append(')');
		return result.toString();
	}

} //SiteImpl
