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
package com.netxforge.netxstudio.library;

import com.netxforge.netxstudio.generics.Base;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Product Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A type representing the basic information points of
 * 				a Product as perceived by a manufacturer.
 * 
 * 				Examples: 1. The product
 * 				code for Equipment board UAB is 12CXSUY, the Sales
 * 				Code is another
 * 				code used in a
 * 				pricelist.
 * 			
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.library.ProductInfo#getEquipmentRef <em>Equipment Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.ProductInfo#getLicensedFunctionRef <em>Licensed Function Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.ProductInfo#getNodeTypeRef <em>Node Type Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.ProductInfo#getAvailableDate <em>Available Date</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.ProductInfo#getEndOfSalesDate <em>End Of Sales Date</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.ProductInfo#getEndOfSupportDate <em>End Of Support Date</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.ProductInfo#getProductCode <em>Product Code</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.ProductInfo#getSalesCode <em>Sales Code</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.ProductInfo#getUnderDevelopmentDate <em>Under Development Date</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.library.LibraryPackage#getProductInfo()
 * @model extendedMetaData="name='ProductInfo' kind='elementOnly'"
 * @generated
 */
public interface ProductInfo extends Base {
	/**
	 * Returns the value of the '<em><b>Equipment Ref</b></em>' reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.library.Equipment}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The EquipmentRef reference, references 0 or
	 * 								more
	 * 								Equipment types.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Equipment Ref</em>' reference list.
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getProductInfo_EquipmentRef()
	 * @model extendedMetaData="kind='element' name='EquipmentRef'"
	 * @generated
	 */
	EList<Equipment> getEquipmentRef();

	/**
	 * Returns the value of the '<em><b>Licensed Function Ref</b></em>' reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.library.Function}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The LicensedFunctionRef reference, references 0
	 * 								or more Function types.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Licensed Function Ref</em>' reference list.
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getProductInfo_LicensedFunctionRef()
	 * @model extendedMetaData="kind='element' name='LicensedFunctionRef'"
	 * @generated
	 */
	EList<Function> getLicensedFunctionRef();

	/**
	 * Returns the value of the '<em><b>Node Type Ref</b></em>' reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.library.NodeType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The LicensedFunctionRef reference, references 0
	 * 								or more Function types.
	 * 							
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Node Type Ref</em>' reference list.
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getProductInfo_NodeTypeRef()
	 * @model extendedMetaData="kind='element' name='NodeTypeRef'"
	 * @generated
	 */
	EList<NodeType> getNodeTypeRef();

	/**
	 * Returns the value of the '<em><b>Available Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The AvailableDate attribute holds the date and
	 * 							time when the node is available (for sale).
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Available Date</em>' attribute.
	 * @see #setAvailableDate(XMLGregorianCalendar)
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getProductInfo_AvailableDate()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.DateTime"
	 *        extendedMetaData="kind='attribute' name='AvailableDate'"
	 * @generated
	 */
	XMLGregorianCalendar getAvailableDate();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.ProductInfo#getAvailableDate <em>Available Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Available Date</em>' attribute.
	 * @see #getAvailableDate()
	 * @generated
	 */
	void setAvailableDate(XMLGregorianCalendar value);

	/**
	 * Returns the value of the '<em><b>End Of Sales Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The EndOfSaleDate attribute holds the date and
	 * 							time when the node is not for sale anymore.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>End Of Sales Date</em>' attribute.
	 * @see #setEndOfSalesDate(XMLGregorianCalendar)
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getProductInfo_EndOfSalesDate()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.DateTime"
	 *        extendedMetaData="kind='attribute' name='EndOfSalesDate'"
	 * @generated
	 */
	XMLGregorianCalendar getEndOfSalesDate();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.ProductInfo#getEndOfSalesDate <em>End Of Sales Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Of Sales Date</em>' attribute.
	 * @see #getEndOfSalesDate()
	 * @generated
	 */
	void setEndOfSalesDate(XMLGregorianCalendar value);

	/**
	 * Returns the value of the '<em><b>End Of Support Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The EndOfSupportDate attribute holds the date
	 * 							and
	 * 							time when the node is not supported by the
	 * 							manufacturer
	 * 							anymore.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>End Of Support Date</em>' attribute.
	 * @see #setEndOfSupportDate(XMLGregorianCalendar)
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getProductInfo_EndOfSupportDate()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.DateTime"
	 *        extendedMetaData="kind='attribute' name='EndOfSupportDate'"
	 * @generated
	 */
	XMLGregorianCalendar getEndOfSupportDate();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.ProductInfo#getEndOfSupportDate <em>End Of Support Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Of Support Date</em>' attribute.
	 * @see #getEndOfSupportDate()
	 * @generated
	 */
	void setEndOfSupportDate(XMLGregorianCalendar value);

	/**
	 * Returns the value of the '<em><b>Product Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ProductCode attribute holds the product code
	 * 							as defined by the manufacturer.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Product Code</em>' attribute.
	 * @see #setProductCode(String)
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getProductInfo_ProductCode()
	 * @model dataType="com.netxforge.netxstudio.generics.Name255"
	 *        extendedMetaData="kind='attribute' name='ProductCode'"
	 * @generated
	 */
	String getProductCode();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.ProductInfo#getProductCode <em>Product Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Product Code</em>' attribute.
	 * @see #getProductCode()
	 * @generated
	 */
	void setProductCode(String value);

	/**
	 * Returns the value of the '<em><b>Sales Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The SalesCode attribute holds the sales code as
	 * 							defined by the manufacturer.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Sales Code</em>' attribute.
	 * @see #setSalesCode(String)
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getProductInfo_SalesCode()
	 * @model dataType="com.netxforge.netxstudio.generics.Name255"
	 *        extendedMetaData="kind='attribute' name='SalesCode'"
	 * @generated
	 */
	String getSalesCode();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.ProductInfo#getSalesCode <em>Sales Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sales Code</em>' attribute.
	 * @see #getSalesCode()
	 * @generated
	 */
	void setSalesCode(String value);

	/**
	 * Returns the value of the '<em><b>Under Development Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The UnderDevelopmentDate attribute holds the
	 * 							date
	 * 							and time when the node is developed.
	 * 						
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Under Development Date</em>' attribute.
	 * @see #setUnderDevelopmentDate(XMLGregorianCalendar)
	 * @see com.netxforge.netxstudio.library.LibraryPackage#getProductInfo_UnderDevelopmentDate()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.DateTime"
	 *        extendedMetaData="kind='attribute' name='UnderDevelopmentDate'"
	 * @generated
	 */
	XMLGregorianCalendar getUnderDevelopmentDate();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.library.ProductInfo#getUnderDevelopmentDate <em>Under Development Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Under Development Date</em>' attribute.
	 * @see #getUnderDevelopmentDate()
	 * @generated
	 */
	void setUnderDevelopmentDate(XMLGregorianCalendar value);

} // ProductInfo
