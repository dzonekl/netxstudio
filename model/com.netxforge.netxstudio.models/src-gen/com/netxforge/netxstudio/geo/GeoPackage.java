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
package com.netxforge.netxstudio.geo;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import com.netxforge.netxstudio.generics.GenericsPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * 
 * 
 * 			Network Data schema Copyright 2008 The schema uses
 * 			ecore
 * 			references syntax, but should easily map into an SQL schema.
 * 			The
 * 			ecore
 * 			references, are mapped into ORM specific DLL (See
 * 			Hibernate or
 * 			other
 * 			ORM. EMF/Hibernate
 * 			however uses a custom mechanism.
 * 
 * 			Don't use
 * 			the
 * 			word
 * 			"Item", as this is appended to the Object
 * 			name in the EMF
 * 			edit
 * 			model.
 * 
 * 			Validation with pattern is not used, considering the limited
 * 			capabilities of
 * 			XSD patterns.
 * 
 * 		
 * <!-- end-model-doc -->
 * @see com.netxforge.netxstudio.geo.GeoFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL' invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL'"
 * @generated
 */
public interface GeoPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "geo";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.netxforge.com/13042011/geo";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "geo";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GeoPackage eINSTANCE = com.netxforge.netxstudio.geo.impl.GeoPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.geo.impl.LocationImpl <em>Location</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.geo.impl.LocationImpl
	 * @see com.netxforge.netxstudio.geo.impl.GeoPackageImpl#getLocation()
	 * @generated
	 */
	int LOCATION = 1;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION__DELETED = GenericsPackage.BASE__DELETED;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION__NAME = GenericsPackage.BASE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Location</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATION_FEATURE_COUNT = GenericsPackage.BASE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.geo.impl.CountryImpl <em>Country</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.geo.impl.CountryImpl
	 * @see com.netxforge.netxstudio.geo.impl.GeoPackageImpl#getCountry()
	 * @generated
	 */
	int COUNTRY = 0;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTRY__DELETED = LOCATION__DELETED;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTRY__NAME = LOCATION__NAME;

	/**
	 * The feature id for the '<em><b>Sites</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTRY__SITES = LOCATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Icons</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTRY__ICONS = LOCATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Country Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTRY__COUNTRY_CODE = LOCATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Country</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COUNTRY_FEATURE_COUNT = LOCATION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.geo.impl.RoomImpl <em>Room</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.geo.impl.RoomImpl
	 * @see com.netxforge.netxstudio.geo.impl.GeoPackageImpl#getRoom()
	 * @generated
	 */
	int ROOM = 2;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOM__DELETED = LOCATION__DELETED;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOM__NAME = LOCATION__NAME;

	/**
	 * The feature id for the '<em><b>Shape</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOM__SHAPE = LOCATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Room</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOM_FEATURE_COUNT = LOCATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link com.netxforge.netxstudio.geo.impl.SiteImpl <em>Site</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.netxforge.netxstudio.geo.impl.SiteImpl
	 * @see com.netxforge.netxstudio.geo.impl.GeoPackageImpl#getSite()
	 * @generated
	 */
	int SITE = 3;

	/**
	 * The feature id for the '<em><b>Deleted</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SITE__DELETED = LOCATION__DELETED;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SITE__NAME = LOCATION__NAME;

	/**
	 * The feature id for the '<em><b>Rooms</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SITE__ROOMS = LOCATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Area</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SITE__AREA = LOCATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>City</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SITE__CITY = LOCATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Housenumber</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SITE__HOUSENUMBER = LOCATION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Latitude</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SITE__LATITUDE = LOCATION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Longitude</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SITE__LONGITUDE = LOCATION_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Postalcode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SITE__POSTALCODE = LOCATION_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Region</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SITE__REGION = LOCATION_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Sreet</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SITE__SREET = LOCATION_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Site</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SITE_FEATURE_COUNT = LOCATION_FEATURE_COUNT + 9;


	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.geo.Country <em>Country</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Country</em>'.
	 * @see com.netxforge.netxstudio.geo.Country
	 * @generated
	 */
	EClass getCountry();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.geo.Country#getSites <em>Sites</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sites</em>'.
	 * @see com.netxforge.netxstudio.geo.Country#getSites()
	 * @see #getCountry()
	 * @generated
	 */
	EReference getCountry_Sites();

	/**
	 * Returns the meta object for the containment reference '{@link com.netxforge.netxstudio.geo.Country#getIcons <em>Icons</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Icons</em>'.
	 * @see com.netxforge.netxstudio.geo.Country#getIcons()
	 * @see #getCountry()
	 * @generated
	 */
	EReference getCountry_Icons();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.geo.Country#getCountryCode <em>Country Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Country Code</em>'.
	 * @see com.netxforge.netxstudio.geo.Country#getCountryCode()
	 * @see #getCountry()
	 * @generated
	 */
	EAttribute getCountry_CountryCode();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.geo.Location <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Location</em>'.
	 * @see com.netxforge.netxstudio.geo.Location
	 * @generated
	 */
	EClass getLocation();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.geo.Location#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.netxforge.netxstudio.geo.Location#getName()
	 * @see #getLocation()
	 * @generated
	 */
	EAttribute getLocation_Name();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.geo.Room <em>Room</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Room</em>'.
	 * @see com.netxforge.netxstudio.geo.Room
	 * @generated
	 */
	EClass getRoom();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.geo.Room#getShape <em>Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Shape</em>'.
	 * @see com.netxforge.netxstudio.geo.Room#getShape()
	 * @see #getRoom()
	 * @generated
	 */
	EAttribute getRoom_Shape();

	/**
	 * Returns the meta object for class '{@link com.netxforge.netxstudio.geo.Site <em>Site</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Site</em>'.
	 * @see com.netxforge.netxstudio.geo.Site
	 * @generated
	 */
	EClass getSite();

	/**
	 * Returns the meta object for the containment reference list '{@link com.netxforge.netxstudio.geo.Site#getRooms <em>Rooms</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Rooms</em>'.
	 * @see com.netxforge.netxstudio.geo.Site#getRooms()
	 * @see #getSite()
	 * @generated
	 */
	EReference getSite_Rooms();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.geo.Site#getArea <em>Area</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Area</em>'.
	 * @see com.netxforge.netxstudio.geo.Site#getArea()
	 * @see #getSite()
	 * @generated
	 */
	EAttribute getSite_Area();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.geo.Site#getCity <em>City</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>City</em>'.
	 * @see com.netxforge.netxstudio.geo.Site#getCity()
	 * @see #getSite()
	 * @generated
	 */
	EAttribute getSite_City();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.geo.Site#getHousenumber <em>Housenumber</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Housenumber</em>'.
	 * @see com.netxforge.netxstudio.geo.Site#getHousenumber()
	 * @see #getSite()
	 * @generated
	 */
	EAttribute getSite_Housenumber();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.geo.Site#getLatitude <em>Latitude</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Latitude</em>'.
	 * @see com.netxforge.netxstudio.geo.Site#getLatitude()
	 * @see #getSite()
	 * @generated
	 */
	EAttribute getSite_Latitude();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.geo.Site#getLongitude <em>Longitude</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Longitude</em>'.
	 * @see com.netxforge.netxstudio.geo.Site#getLongitude()
	 * @see #getSite()
	 * @generated
	 */
	EAttribute getSite_Longitude();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.geo.Site#getPostalcode <em>Postalcode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Postalcode</em>'.
	 * @see com.netxforge.netxstudio.geo.Site#getPostalcode()
	 * @see #getSite()
	 * @generated
	 */
	EAttribute getSite_Postalcode();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.geo.Site#getRegion <em>Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Region</em>'.
	 * @see com.netxforge.netxstudio.geo.Site#getRegion()
	 * @see #getSite()
	 * @generated
	 */
	EAttribute getSite_Region();

	/**
	 * Returns the meta object for the attribute '{@link com.netxforge.netxstudio.geo.Site#getSreet <em>Sreet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sreet</em>'.
	 * @see com.netxforge.netxstudio.geo.Site#getSreet()
	 * @see #getSite()
	 * @generated
	 */
	EAttribute getSite_Sreet();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	GeoFactory getGeoFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.geo.impl.CountryImpl <em>Country</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.geo.impl.CountryImpl
		 * @see com.netxforge.netxstudio.geo.impl.GeoPackageImpl#getCountry()
		 * @generated
		 */
		EClass COUNTRY = eINSTANCE.getCountry();

		/**
		 * The meta object literal for the '<em><b>Sites</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COUNTRY__SITES = eINSTANCE.getCountry_Sites();

		/**
		 * The meta object literal for the '<em><b>Icons</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COUNTRY__ICONS = eINSTANCE.getCountry_Icons();

		/**
		 * The meta object literal for the '<em><b>Country Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COUNTRY__COUNTRY_CODE = eINSTANCE.getCountry_CountryCode();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.geo.impl.LocationImpl <em>Location</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.geo.impl.LocationImpl
		 * @see com.netxforge.netxstudio.geo.impl.GeoPackageImpl#getLocation()
		 * @generated
		 */
		EClass LOCATION = eINSTANCE.getLocation();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCATION__NAME = eINSTANCE.getLocation_Name();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.geo.impl.RoomImpl <em>Room</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.geo.impl.RoomImpl
		 * @see com.netxforge.netxstudio.geo.impl.GeoPackageImpl#getRoom()
		 * @generated
		 */
		EClass ROOM = eINSTANCE.getRoom();

		/**
		 * The meta object literal for the '<em><b>Shape</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROOM__SHAPE = eINSTANCE.getRoom_Shape();

		/**
		 * The meta object literal for the '{@link com.netxforge.netxstudio.geo.impl.SiteImpl <em>Site</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.netxforge.netxstudio.geo.impl.SiteImpl
		 * @see com.netxforge.netxstudio.geo.impl.GeoPackageImpl#getSite()
		 * @generated
		 */
		EClass SITE = eINSTANCE.getSite();

		/**
		 * The meta object literal for the '<em><b>Rooms</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SITE__ROOMS = eINSTANCE.getSite_Rooms();

		/**
		 * The meta object literal for the '<em><b>Area</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SITE__AREA = eINSTANCE.getSite_Area();

		/**
		 * The meta object literal for the '<em><b>City</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SITE__CITY = eINSTANCE.getSite_City();

		/**
		 * The meta object literal for the '<em><b>Housenumber</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SITE__HOUSENUMBER = eINSTANCE.getSite_Housenumber();

		/**
		 * The meta object literal for the '<em><b>Latitude</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SITE__LATITUDE = eINSTANCE.getSite_Latitude();

		/**
		 * The meta object literal for the '<em><b>Longitude</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SITE__LONGITUDE = eINSTANCE.getSite_Longitude();

		/**
		 * The meta object literal for the '<em><b>Postalcode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SITE__POSTALCODE = eINSTANCE.getSite_Postalcode();

		/**
		 * The meta object literal for the '<em><b>Region</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SITE__REGION = eINSTANCE.getSite_Region();

		/**
		 * The meta object literal for the '<em><b>Sreet</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SITE__SREET = eINSTANCE.getSite_Sreet();

	}

} //GeoPackage
