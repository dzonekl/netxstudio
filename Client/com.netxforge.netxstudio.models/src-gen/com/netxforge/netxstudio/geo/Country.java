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

import com.netxforge.netxstudio.generics.MultiImage;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Country</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A type representing the basic information points of a real Country. A Country is used for all geographical
 * related functions like maps, timezones etc...
 * 
 * Examples: 1. The Country type is used to determine the timezone and normalize incoming and outgoing timestamps
 * on metric or other values.
 * 
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.geo.Country#getSites <em>Sites</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.geo.Country#getIcons <em>Icons</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.geo.Country#getCountryCode <em>Country Code</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.geo.Country#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.geo.GeoPackage#getCountry()
 * @model extendedMetaData="name='Country' kind='elementOnly'"
 * @generated
 */
public interface Country extends EObject {
	/**
	 * Returns the value of the '<em><b>Sites</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.geo.Site}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Sites reference, contains 0 or more Site types.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Sites</em>' containment reference list.
	 * @see com.netxforge.netxstudio.geo.GeoPackage#getCountry_Sites()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Sites'"
	 * @generated
	 */
	EList<Site> getSites();

	/**
	 * Returns the value of the '<em><b>Icons</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Images reference, contains 0 or one MultiImage type.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Icons</em>' containment reference.
	 * @see #setIcons(MultiImage)
	 * @see com.netxforge.netxstudio.geo.GeoPackage#getCountry_Icons()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Icons'"
	 * @generated
	 */
	MultiImage getIcons();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.geo.Country#getIcons <em>Icons</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Icons</em>' containment reference.
	 * @see #getIcons()
	 * @generated
	 */
	void setIcons(MultiImage value);

	/**
	 * Returns the value of the '<em><b>Country Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The CountryCode attribute should be according to ISO
	 * definitions in:
	 * 
	 * 
	 * http://www.iso.org/iso/english_country_names_and_code_elements
	 * 				
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Country Code</em>' attribute.
	 * @see #setCountryCode(String)
	 * @see com.netxforge.netxstudio.geo.GeoPackage#getCountry_CountryCode()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='CountryCode'"
	 * @generated
	 */
	String getCountryCode();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.geo.Country#getCountryCode <em>Country Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Country Code</em>' attribute.
	 * @see #getCountryCode()
	 * @generated
	 */
	void setCountryCode(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Name attribute should be according to ISO
	 * definitions in:
	 * 
	 * 
	 * http://www.iso.org/iso/english_country_names_and_code_elements
	 * 				
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.netxforge.netxstudio.geo.GeoPackage#getCountry_Name()
	 * @model dataType="com.netxforge.netxstudio.generics.Name255"
	 *        extendedMetaData="kind='attribute' name='Name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.geo.Country#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Country
