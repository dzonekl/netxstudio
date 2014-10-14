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
package com.netxforge.netxstudio.library.impl;

import com.netxforge.netxstudio.generics.impl.BaseImpl;

import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.library.ProductInfo;

import java.util.Collection;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

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
	 * The cached value of the '{@link #getEquipmentRef() <em>Equipment Ref</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEquipmentRef()
	 * @generated
	 * @ordered
	 */
	protected EList<Equipment> equipmentRef;

	/**
	 * The cached value of the '{@link #getLicensedFunctionRef() <em>Licensed Function Ref</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLicensedFunctionRef()
	 * @generated
	 * @ordered
	 */
	protected EList<Function> licensedFunctionRef;

	/**
	 * The cached value of the '{@link #getNodeTypeRef() <em>Node Type Ref</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodeTypeRef()
	 * @generated
	 * @ordered
	 */
	protected EList<NodeType> nodeTypeRef;

	/**
	 * The default value of the '{@link #getAvailableDate() <em>Available Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAvailableDate()
	 * @generated
	 * @ordered
	 */
	protected static final XMLGregorianCalendar AVAILABLE_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAvailableDate() <em>Available Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAvailableDate()
	 * @generated
	 * @ordered
	 */
	protected XMLGregorianCalendar availableDate = AVAILABLE_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getEndOfSalesDate() <em>End Of Sales Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndOfSalesDate()
	 * @generated
	 * @ordered
	 */
	protected static final XMLGregorianCalendar END_OF_SALES_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEndOfSalesDate() <em>End Of Sales Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndOfSalesDate()
	 * @generated
	 * @ordered
	 */
	protected XMLGregorianCalendar endOfSalesDate = END_OF_SALES_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getEndOfSupportDate() <em>End Of Support Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndOfSupportDate()
	 * @generated
	 * @ordered
	 */
	protected static final XMLGregorianCalendar END_OF_SUPPORT_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEndOfSupportDate() <em>End Of Support Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndOfSupportDate()
	 * @generated
	 * @ordered
	 */
	protected XMLGregorianCalendar endOfSupportDate = END_OF_SUPPORT_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getProductCode() <em>Product Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProductCode()
	 * @generated
	 * @ordered
	 */
	protected static final String PRODUCT_CODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProductCode() <em>Product Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProductCode()
	 * @generated
	 * @ordered
	 */
	protected String productCode = PRODUCT_CODE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSalesCode() <em>Sales Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSalesCode()
	 * @generated
	 * @ordered
	 */
	protected static final String SALES_CODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSalesCode() <em>Sales Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSalesCode()
	 * @generated
	 * @ordered
	 */
	protected String salesCode = SALES_CODE_EDEFAULT;

	/**
	 * The default value of the '{@link #getUnderDevelopmentDate() <em>Under Development Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnderDevelopmentDate()
	 * @generated
	 * @ordered
	 */
	protected static final XMLGregorianCalendar UNDER_DEVELOPMENT_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUnderDevelopmentDate() <em>Under Development Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnderDevelopmentDate()
	 * @generated
	 * @ordered
	 */
	protected XMLGregorianCalendar underDevelopmentDate = UNDER_DEVELOPMENT_DATE_EDEFAULT;

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
	public EList<Equipment> getEquipmentRef() {
		if (equipmentRef == null) {
			equipmentRef = new EObjectResolvingEList<Equipment>(Equipment.class, this, LibraryPackage.PRODUCT_INFO__EQUIPMENT_REF);
		}
		return equipmentRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Function> getLicensedFunctionRef() {
		if (licensedFunctionRef == null) {
			licensedFunctionRef = new EObjectResolvingEList<Function>(Function.class, this, LibraryPackage.PRODUCT_INFO__LICENSED_FUNCTION_REF);
		}
		return licensedFunctionRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NodeType> getNodeTypeRef() {
		if (nodeTypeRef == null) {
			nodeTypeRef = new EObjectResolvingEList<NodeType>(NodeType.class, this, LibraryPackage.PRODUCT_INFO__NODE_TYPE_REF);
		}
		return nodeTypeRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XMLGregorianCalendar getAvailableDate() {
		return availableDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAvailableDate(XMLGregorianCalendar newAvailableDate) {
		XMLGregorianCalendar oldAvailableDate = availableDate;
		availableDate = newAvailableDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.PRODUCT_INFO__AVAILABLE_DATE, oldAvailableDate, availableDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XMLGregorianCalendar getEndOfSalesDate() {
		return endOfSalesDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndOfSalesDate(XMLGregorianCalendar newEndOfSalesDate) {
		XMLGregorianCalendar oldEndOfSalesDate = endOfSalesDate;
		endOfSalesDate = newEndOfSalesDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.PRODUCT_INFO__END_OF_SALES_DATE, oldEndOfSalesDate, endOfSalesDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XMLGregorianCalendar getEndOfSupportDate() {
		return endOfSupportDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndOfSupportDate(XMLGregorianCalendar newEndOfSupportDate) {
		XMLGregorianCalendar oldEndOfSupportDate = endOfSupportDate;
		endOfSupportDate = newEndOfSupportDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.PRODUCT_INFO__END_OF_SUPPORT_DATE, oldEndOfSupportDate, endOfSupportDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProductCode() {
		return productCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProductCode(String newProductCode) {
		String oldProductCode = productCode;
		productCode = newProductCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.PRODUCT_INFO__PRODUCT_CODE, oldProductCode, productCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSalesCode() {
		return salesCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSalesCode(String newSalesCode) {
		String oldSalesCode = salesCode;
		salesCode = newSalesCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.PRODUCT_INFO__SALES_CODE, oldSalesCode, salesCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XMLGregorianCalendar getUnderDevelopmentDate() {
		return underDevelopmentDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnderDevelopmentDate(XMLGregorianCalendar newUnderDevelopmentDate) {
		XMLGregorianCalendar oldUnderDevelopmentDate = underDevelopmentDate;
		underDevelopmentDate = newUnderDevelopmentDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LibraryPackage.PRODUCT_INFO__UNDER_DEVELOPMENT_DATE, oldUnderDevelopmentDate, underDevelopmentDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LibraryPackage.PRODUCT_INFO__EQUIPMENT_REF:
				return getEquipmentRef();
			case LibraryPackage.PRODUCT_INFO__LICENSED_FUNCTION_REF:
				return getLicensedFunctionRef();
			case LibraryPackage.PRODUCT_INFO__NODE_TYPE_REF:
				return getNodeTypeRef();
			case LibraryPackage.PRODUCT_INFO__AVAILABLE_DATE:
				return getAvailableDate();
			case LibraryPackage.PRODUCT_INFO__END_OF_SALES_DATE:
				return getEndOfSalesDate();
			case LibraryPackage.PRODUCT_INFO__END_OF_SUPPORT_DATE:
				return getEndOfSupportDate();
			case LibraryPackage.PRODUCT_INFO__PRODUCT_CODE:
				return getProductCode();
			case LibraryPackage.PRODUCT_INFO__SALES_CODE:
				return getSalesCode();
			case LibraryPackage.PRODUCT_INFO__UNDER_DEVELOPMENT_DATE:
				return getUnderDevelopmentDate();
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
			case LibraryPackage.PRODUCT_INFO__EQUIPMENT_REF:
				getEquipmentRef().clear();
				getEquipmentRef().addAll((Collection<? extends Equipment>)newValue);
				return;
			case LibraryPackage.PRODUCT_INFO__LICENSED_FUNCTION_REF:
				getLicensedFunctionRef().clear();
				getLicensedFunctionRef().addAll((Collection<? extends Function>)newValue);
				return;
			case LibraryPackage.PRODUCT_INFO__NODE_TYPE_REF:
				getNodeTypeRef().clear();
				getNodeTypeRef().addAll((Collection<? extends NodeType>)newValue);
				return;
			case LibraryPackage.PRODUCT_INFO__AVAILABLE_DATE:
				setAvailableDate((XMLGregorianCalendar)newValue);
				return;
			case LibraryPackage.PRODUCT_INFO__END_OF_SALES_DATE:
				setEndOfSalesDate((XMLGregorianCalendar)newValue);
				return;
			case LibraryPackage.PRODUCT_INFO__END_OF_SUPPORT_DATE:
				setEndOfSupportDate((XMLGregorianCalendar)newValue);
				return;
			case LibraryPackage.PRODUCT_INFO__PRODUCT_CODE:
				setProductCode((String)newValue);
				return;
			case LibraryPackage.PRODUCT_INFO__SALES_CODE:
				setSalesCode((String)newValue);
				return;
			case LibraryPackage.PRODUCT_INFO__UNDER_DEVELOPMENT_DATE:
				setUnderDevelopmentDate((XMLGregorianCalendar)newValue);
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
			case LibraryPackage.PRODUCT_INFO__EQUIPMENT_REF:
				getEquipmentRef().clear();
				return;
			case LibraryPackage.PRODUCT_INFO__LICENSED_FUNCTION_REF:
				getLicensedFunctionRef().clear();
				return;
			case LibraryPackage.PRODUCT_INFO__NODE_TYPE_REF:
				getNodeTypeRef().clear();
				return;
			case LibraryPackage.PRODUCT_INFO__AVAILABLE_DATE:
				setAvailableDate(AVAILABLE_DATE_EDEFAULT);
				return;
			case LibraryPackage.PRODUCT_INFO__END_OF_SALES_DATE:
				setEndOfSalesDate(END_OF_SALES_DATE_EDEFAULT);
				return;
			case LibraryPackage.PRODUCT_INFO__END_OF_SUPPORT_DATE:
				setEndOfSupportDate(END_OF_SUPPORT_DATE_EDEFAULT);
				return;
			case LibraryPackage.PRODUCT_INFO__PRODUCT_CODE:
				setProductCode(PRODUCT_CODE_EDEFAULT);
				return;
			case LibraryPackage.PRODUCT_INFO__SALES_CODE:
				setSalesCode(SALES_CODE_EDEFAULT);
				return;
			case LibraryPackage.PRODUCT_INFO__UNDER_DEVELOPMENT_DATE:
				setUnderDevelopmentDate(UNDER_DEVELOPMENT_DATE_EDEFAULT);
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
			case LibraryPackage.PRODUCT_INFO__EQUIPMENT_REF:
				return equipmentRef != null && !equipmentRef.isEmpty();
			case LibraryPackage.PRODUCT_INFO__LICENSED_FUNCTION_REF:
				return licensedFunctionRef != null && !licensedFunctionRef.isEmpty();
			case LibraryPackage.PRODUCT_INFO__NODE_TYPE_REF:
				return nodeTypeRef != null && !nodeTypeRef.isEmpty();
			case LibraryPackage.PRODUCT_INFO__AVAILABLE_DATE:
				return AVAILABLE_DATE_EDEFAULT == null ? availableDate != null : !AVAILABLE_DATE_EDEFAULT.equals(availableDate);
			case LibraryPackage.PRODUCT_INFO__END_OF_SALES_DATE:
				return END_OF_SALES_DATE_EDEFAULT == null ? endOfSalesDate != null : !END_OF_SALES_DATE_EDEFAULT.equals(endOfSalesDate);
			case LibraryPackage.PRODUCT_INFO__END_OF_SUPPORT_DATE:
				return END_OF_SUPPORT_DATE_EDEFAULT == null ? endOfSupportDate != null : !END_OF_SUPPORT_DATE_EDEFAULT.equals(endOfSupportDate);
			case LibraryPackage.PRODUCT_INFO__PRODUCT_CODE:
				return PRODUCT_CODE_EDEFAULT == null ? productCode != null : !PRODUCT_CODE_EDEFAULT.equals(productCode);
			case LibraryPackage.PRODUCT_INFO__SALES_CODE:
				return SALES_CODE_EDEFAULT == null ? salesCode != null : !SALES_CODE_EDEFAULT.equals(salesCode);
			case LibraryPackage.PRODUCT_INFO__UNDER_DEVELOPMENT_DATE:
				return UNDER_DEVELOPMENT_DATE_EDEFAULT == null ? underDevelopmentDate != null : !UNDER_DEVELOPMENT_DATE_EDEFAULT.equals(underDevelopmentDate);
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
		result.append(" (availableDate: ");
		result.append(availableDate);
		result.append(", endOfSalesDate: ");
		result.append(endOfSalesDate);
		result.append(", endOfSupportDate: ");
		result.append(endOfSupportDate);
		result.append(", productCode: ");
		result.append(productCode);
		result.append(", salesCode: ");
		result.append(salesCode);
		result.append(", underDevelopmentDate: ");
		result.append(underDevelopmentDate);
		result.append(')');
		return result.toString();
	}

} //ProductInfoImpl
