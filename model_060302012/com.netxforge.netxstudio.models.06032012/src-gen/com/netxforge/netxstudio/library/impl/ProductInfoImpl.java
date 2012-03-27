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
package com.netxforge.netxstudio.library.impl;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import com.netxforge.netxstudio.generics.impl.BaseImpl;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.library.ProductInfo;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Product Info</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.library.impl.ProductInfoImpl#getEquipmentRef <em>Equipment Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.ProductInfoImpl#getLicensedFunctionRef <em>Licensed Function Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.ProductInfoImpl#getNodeTypeRef <em>Node Type Ref</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.ProductInfoImpl#getAvailableDate <em>Available Date</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.ProductInfoImpl#getEndOfSalesDate <em>End Of Sales Date</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.ProductInfoImpl#getEndOfSupportDate <em>End Of Support Date</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.ProductInfoImpl#getProductCode <em>Product Code</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.ProductInfoImpl#getSalesCode <em>Sales Code</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.library.impl.ProductInfoImpl#getUnderDevelopmentDate <em>Under Development Date</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProductInfoImpl extends BaseImpl implements ProductInfo {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProductInfoImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LibraryPackage.Literals.PRODUCT_INFO;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Equipment> getEquipmentRef() {
		return (EList<Equipment>)eGet(LibraryPackage.Literals.PRODUCT_INFO__EQUIPMENT_REF, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<Function> getLicensedFunctionRef() {
		return (EList<Function>)eGet(LibraryPackage.Literals.PRODUCT_INFO__LICENSED_FUNCTION_REF, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EList<NodeType> getNodeTypeRef() {
		return (EList<NodeType>)eGet(LibraryPackage.Literals.PRODUCT_INFO__NODE_TYPE_REF, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XMLGregorianCalendar getAvailableDate() {
		return (XMLGregorianCalendar)eGet(LibraryPackage.Literals.PRODUCT_INFO__AVAILABLE_DATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAvailableDate(XMLGregorianCalendar newAvailableDate) {
		eSet(LibraryPackage.Literals.PRODUCT_INFO__AVAILABLE_DATE, newAvailableDate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XMLGregorianCalendar getEndOfSalesDate() {
		return (XMLGregorianCalendar)eGet(LibraryPackage.Literals.PRODUCT_INFO__END_OF_SALES_DATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndOfSalesDate(XMLGregorianCalendar newEndOfSalesDate) {
		eSet(LibraryPackage.Literals.PRODUCT_INFO__END_OF_SALES_DATE, newEndOfSalesDate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XMLGregorianCalendar getEndOfSupportDate() {
		return (XMLGregorianCalendar)eGet(LibraryPackage.Literals.PRODUCT_INFO__END_OF_SUPPORT_DATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndOfSupportDate(XMLGregorianCalendar newEndOfSupportDate) {
		eSet(LibraryPackage.Literals.PRODUCT_INFO__END_OF_SUPPORT_DATE, newEndOfSupportDate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProductCode() {
		return (String)eGet(LibraryPackage.Literals.PRODUCT_INFO__PRODUCT_CODE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProductCode(String newProductCode) {
		eSet(LibraryPackage.Literals.PRODUCT_INFO__PRODUCT_CODE, newProductCode);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSalesCode() {
		return (String)eGet(LibraryPackage.Literals.PRODUCT_INFO__SALES_CODE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSalesCode(String newSalesCode) {
		eSet(LibraryPackage.Literals.PRODUCT_INFO__SALES_CODE, newSalesCode);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XMLGregorianCalendar getUnderDevelopmentDate() {
		return (XMLGregorianCalendar)eGet(LibraryPackage.Literals.PRODUCT_INFO__UNDER_DEVELOPMENT_DATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnderDevelopmentDate(XMLGregorianCalendar newUnderDevelopmentDate) {
		eSet(LibraryPackage.Literals.PRODUCT_INFO__UNDER_DEVELOPMENT_DATE, newUnderDevelopmentDate);
	}

} //ProductInfoImpl
