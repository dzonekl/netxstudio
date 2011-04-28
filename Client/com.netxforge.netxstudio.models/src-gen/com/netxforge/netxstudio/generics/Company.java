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
package com.netxforge.netxstudio.generics;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Company</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A type representing the basic information points of a real company. 
 * A Company can be a commercial vendor of equipment, a telecommunication service provider or other
 * institution i.e. industry cooperation bodies to promote usage of standards. It is required to organise objects
 * by Company.
 * 
 * Examples: 
 * 1. The company type is used to organize reports like an expansion Bill of Quantity by vendor. 
 * 2. The company type is used in a UI widget to show equipments from a certain company. 
 * 3. The company type is used in a UI widget to show protocols from a certain standardisation body. 
 * 4. The company type is used in a UI widget to show RSS feed news from a certain company.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.generics.Company#getIcons <em>Icons</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.generics.Company#getName <em>Name</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.generics.Company#getRSSurl <em>RS Surl</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.generics.Company#getShortName <em>Short Name</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.generics.Company#getSymbol <em>Symbol</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.generics.Company#getWebsite <em>Website</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.generics.GenericsPackage#getCompany()
 * @model extendedMetaData="name='Company' kind='elementOnly'"
 * @generated
 */
public interface Company extends EObject {
	/**
	 * Returns the value of the '<em><b>Icons</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Images reference, contains 0 or one MultiImage type.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Icons</em>' containment reference.
	 * @see #setIcons(MultiImage)
	 * @see com.netxforge.netxstudio.generics.GenericsPackage#getCompany_Icons()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='Icons'"
	 * @generated
	 */
	MultiImage getIcons();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.generics.Company#getIcons <em>Icons</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Icons</em>' containment reference.
	 * @see #getIcons()
	 * @generated
	 */
	void setIcons(MultiImage value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Name attribute is a free form text.
	 * 				
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.netxforge.netxstudio.generics.GenericsPackage#getCompany_Name()
	 * @model dataType="com.netxforge.netxstudio.generics.Name255"
	 *        extendedMetaData="kind='attribute' name='Name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.generics.Company#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>RS Surl</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The RSSurl attribute should contain a URL to a so-called RSS feed. 
	 * 
	 * The RSS format is defined here: http://en.wikipedia.org/wiki/RSS
	 * 
	 * Examples: 
	 * 1. The following URL is an RSS URL: http://isoc.org/wp/ietfjournal/?feed=rss2
	 * 				
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>RS Surl</em>' attribute.
	 * @see #setRSSurl(String)
	 * @see com.netxforge.netxstudio.generics.GenericsPackage#getCompany_RSSurl()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnyURI"
	 *        extendedMetaData="kind='attribute' name='RSSurl'"
	 * @generated
	 */
	String getRSSurl();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.generics.Company#getRSSurl <em>RS Surl</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>RS Surl</em>' attribute.
	 * @see #getRSSurl()
	 * @generated
	 */
	void setRSSurl(String value);

	/**
	 * Returns the value of the '<em><b>Short Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ShortName attribute is a free form text, but should generally be kept short (3 characters).
	 * 
	 * Examples: 1. The ShortName is used in UI widgets where space is limited.
	 * 				
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Short Name</em>' attribute.
	 * @see #setShortName(String)
	 * @see com.netxforge.netxstudio.generics.GenericsPackage#getCompany_ShortName()
	 * @model dataType="com.netxforge.netxstudio.generics.Name255"
	 *        extendedMetaData="kind='attribute' name='ShortName'"
	 * @generated
	 */
	String getShortName();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.generics.Company#getShortName <em>Short Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Short Name</em>' attribute.
	 * @see #getShortName()
	 * @generated
	 */
	void setShortName(String value);

	/**
	 * Returns the value of the '<em><b>Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The financial Symbol or ticker attribute, is according to financial market ticker definitions.
	 * 
	 * Examples: 1. The Symbol type can be used to lookup financial information of a Company.
	 * 				
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Symbol</em>' attribute.
	 * @see #setSymbol(String)
	 * @see com.netxforge.netxstudio.generics.GenericsPackage#getCompany_Symbol()
	 * @model dataType="com.netxforge.netxstudio.generics.Name255"
	 *        extendedMetaData="kind='attribute' name='Symbol'"
	 * @generated
	 */
	String getSymbol();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.generics.Company#getSymbol <em>Symbol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Symbol</em>' attribute.
	 * @see #getSymbol()
	 * @generated
	 */
	void setSymbol(String value);

	/**
	 * Returns the value of the '<em><b>Website</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Website attribute should contain the main web URL of the website. It should be according to
	 * 
	 * http://en.wikipedia.org/wiki/Uniform_Resource_Locator
	 * 
	 * Examples: 1. http://www.ietf.org
	 * 				
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Website</em>' attribute.
	 * @see #setWebsite(String)
	 * @see com.netxforge.netxstudio.generics.GenericsPackage#getCompany_Website()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.AnyURI"
	 *        extendedMetaData="kind='attribute' name='Website'"
	 * @generated
	 */
	String getWebsite();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.generics.Company#getWebsite <em>Website</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Website</em>' attribute.
	 * @see #getWebsite()
	 * @generated
	 */
	void setWebsite(String value);

} // Company
