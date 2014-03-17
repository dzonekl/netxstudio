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
package com.netxforge.netxstudio.geo;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Site</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A type representing the basic information points of
 * 				a real physical site. A Site is part of a country.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.geo.Site#getRooms <em>Rooms</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.geo.Site#getArea <em>Area</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.geo.Site#getCity <em>City</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.geo.Site#getHousenumber <em>Housenumber</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.geo.Site#getLatitude <em>Latitude</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.geo.Site#getLongitude <em>Longitude</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.geo.Site#getPostalcode <em>Postalcode</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.geo.Site#getRegion <em>Region</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.geo.Site#getSreet <em>Sreet</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.geo.GeoPackage#getSite()
 * @model extendedMetaData="name='Site' kind='elementOnly'"
 * @generated
 */
public interface Site extends Location {
	/**
	 * Returns the value of the '<em><b>Rooms</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.geo.Room}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Room reference, contains 0 or more rooms
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Rooms</em>' containment reference list.
	 * @see com.netxforge.netxstudio.geo.GeoPackage#getSite_Rooms()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Rooms'"
	 * @generated
	 */
	EList<Room> getRooms();

	/**
	 * Returns the value of the '<em><b>Area</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Area attribute holds the area name of the
	 * 							site
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Area</em>' attribute.
	 * @see #setArea(String)
	 * @see com.netxforge.netxstudio.geo.GeoPackage#getSite_Area()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Area'"
	 * @generated
	 */
	String getArea();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.geo.Site#getArea <em>Area</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Area</em>' attribute.
	 * @see #getArea()
	 * @generated
	 */
	void setArea(String value);

	/**
	 * Returns the value of the '<em><b>City</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The City attribute holds the city/town name of
	 * 							the
	 * 							site
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>City</em>' attribute.
	 * @see #setCity(String)
	 * @see com.netxforge.netxstudio.geo.GeoPackage#getSite_City()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='City'"
	 * @generated
	 */
	String getCity();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.geo.Site#getCity <em>City</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>City</em>' attribute.
	 * @see #getCity()
	 * @generated
	 */
	void setCity(String value);

	/**
	 * Returns the value of the '<em><b>Housenumber</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Housenumber attribute holds the house or
	 * 							building number of the site
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Housenumber</em>' attribute.
	 * @see #setHousenumber(String)
	 * @see com.netxforge.netxstudio.geo.GeoPackage#getSite_Housenumber()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Housenumber'"
	 * @generated
	 */
	String getHousenumber();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.geo.Site#getHousenumber <em>Housenumber</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Housenumber</em>' attribute.
	 * @see #getHousenumber()
	 * @generated
	 */
	void setHousenumber(String value);

	/**
	 * Returns the value of the '<em><b>Latitude</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Latitude attribute holds the latitude of the
	 * 							site geo location.
	 * 
	 * 							See:
	 * 							http://en.wikipedia.org/wiki/Geographic_coordinates
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Latitude</em>' attribute.
	 * @see #setLatitude(String)
	 * @see com.netxforge.netxstudio.geo.GeoPackage#getSite_Latitude()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Latitude'"
	 * @generated
	 */
	String getLatitude();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.geo.Site#getLatitude <em>Latitude</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Latitude</em>' attribute.
	 * @see #getLatitude()
	 * @generated
	 */
	void setLatitude(String value);

	/**
	 * Returns the value of the '<em><b>Longitude</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Longitude attribute holds the longitude of
	 * 							the
	 * 							site geo location.
	 * 
	 * 							See:
	 * 							http://en.wikipedia.org/wiki/Geographic_coordinates
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Longitude</em>' attribute.
	 * @see #setLongitude(String)
	 * @see com.netxforge.netxstudio.geo.GeoPackage#getSite_Longitude()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Longitude'"
	 * @generated
	 */
	String getLongitude();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.geo.Site#getLongitude <em>Longitude</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Longitude</em>' attribute.
	 * @see #getLongitude()
	 * @generated
	 */
	void setLongitude(String value);

	/**
	 * Returns the value of the '<em><b>Postalcode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Postalcode attribute holds the postal code
	 * 							of
	 * 							the site
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Postalcode</em>' attribute.
	 * @see #setPostalcode(String)
	 * @see com.netxforge.netxstudio.geo.GeoPackage#getSite_Postalcode()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Postalcode'"
	 * @generated
	 */
	String getPostalcode();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.geo.Site#getPostalcode <em>Postalcode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Postalcode</em>' attribute.
	 * @see #getPostalcode()
	 * @generated
	 */
	void setPostalcode(String value);

	/**
	 * Returns the value of the '<em><b>Region</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The region attribute holds the area name of the
	 * 							site
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Region</em>' attribute.
	 * @see #setRegion(String)
	 * @see com.netxforge.netxstudio.geo.GeoPackage#getSite_Region()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Region'"
	 * @generated
	 */
	String getRegion();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.geo.Site#getRegion <em>Region</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Region</em>' attribute.
	 * @see #getRegion()
	 * @generated
	 */
	void setRegion(String value);

	/**
	 * Returns the value of the '<em><b>Sreet</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Street attribute holds the street name of
	 * 							the
	 * 							site
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Sreet</em>' attribute.
	 * @see #setSreet(String)
	 * @see com.netxforge.netxstudio.geo.GeoPackage#getSite_Sreet()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Sreet'"
	 * @generated
	 */
	String getSreet();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.geo.Site#getSreet <em>Sreet</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sreet</em>' attribute.
	 * @see #getSreet()
	 * @generated
	 */
	void setSreet(String value);

} // Site
