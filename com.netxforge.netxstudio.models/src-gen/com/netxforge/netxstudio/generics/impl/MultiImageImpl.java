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
package com.netxforge.netxstudio.generics.impl;

import com.netxforge.netxstudio.generics.GenericsPackage;
import com.netxforge.netxstudio.generics.MultiImage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Multi Image</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.generics.impl.MultiImageImpl#getObj16 <em>Obj16</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.generics.impl.MultiImageImpl#getObj32 <em>Obj32</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.generics.impl.MultiImageImpl#getObj48 <em>Obj48</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.generics.impl.MultiImageImpl#getObj96 <em>Obj96</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.generics.impl.MultiImageImpl#getObj128 <em>Obj128</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MultiImageImpl extends EObjectImpl implements MultiImage {
	/**
	 * The default value of the '{@link #getObj16() <em>Obj16</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObj16()
	 * @generated
	 * @ordered
	 */
	protected static final String OBJ16_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getObj16() <em>Obj16</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObj16()
	 * @generated
	 * @ordered
	 */
	protected String obj16 = OBJ16_EDEFAULT;

	/**
	 * The default value of the '{@link #getObj32() <em>Obj32</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObj32()
	 * @generated
	 * @ordered
	 */
	protected static final String OBJ32_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getObj32() <em>Obj32</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObj32()
	 * @generated
	 * @ordered
	 */
	protected String obj32 = OBJ32_EDEFAULT;

	/**
	 * The default value of the '{@link #getObj48() <em>Obj48</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObj48()
	 * @generated
	 * @ordered
	 */
	protected static final String OBJ48_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getObj48() <em>Obj48</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObj48()
	 * @generated
	 * @ordered
	 */
	protected String obj48 = OBJ48_EDEFAULT;

	/**
	 * The default value of the '{@link #getObj96() <em>Obj96</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObj96()
	 * @generated
	 * @ordered
	 */
	protected static final String OBJ96_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getObj96() <em>Obj96</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObj96()
	 * @generated
	 * @ordered
	 */
	protected String obj96 = OBJ96_EDEFAULT;

	/**
	 * The default value of the '{@link #getObj128() <em>Obj128</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObj128()
	 * @generated
	 * @ordered
	 */
	protected static final String OBJ128_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getObj128() <em>Obj128</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObj128()
	 * @generated
	 * @ordered
	 */
	protected String obj128 = OBJ128_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MultiImageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GenericsPackage.Literals.MULTI_IMAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getObj16() {
		return obj16;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObj16(String newObj16) {
		String oldObj16 = obj16;
		obj16 = newObj16;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenericsPackage.MULTI_IMAGE__OBJ16, oldObj16, obj16));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getObj32() {
		return obj32;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObj32(String newObj32) {
		String oldObj32 = obj32;
		obj32 = newObj32;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenericsPackage.MULTI_IMAGE__OBJ32, oldObj32, obj32));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getObj48() {
		return obj48;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObj48(String newObj48) {
		String oldObj48 = obj48;
		obj48 = newObj48;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenericsPackage.MULTI_IMAGE__OBJ48, oldObj48, obj48));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getObj96() {
		return obj96;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObj96(String newObj96) {
		String oldObj96 = obj96;
		obj96 = newObj96;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenericsPackage.MULTI_IMAGE__OBJ96, oldObj96, obj96));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getObj128() {
		return obj128;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObj128(String newObj128) {
		String oldObj128 = obj128;
		obj128 = newObj128;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GenericsPackage.MULTI_IMAGE__OBJ128, oldObj128, obj128));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case GenericsPackage.MULTI_IMAGE__OBJ16:
				return getObj16();
			case GenericsPackage.MULTI_IMAGE__OBJ32:
				return getObj32();
			case GenericsPackage.MULTI_IMAGE__OBJ48:
				return getObj48();
			case GenericsPackage.MULTI_IMAGE__OBJ96:
				return getObj96();
			case GenericsPackage.MULTI_IMAGE__OBJ128:
				return getObj128();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case GenericsPackage.MULTI_IMAGE__OBJ16:
				setObj16((String)newValue);
				return;
			case GenericsPackage.MULTI_IMAGE__OBJ32:
				setObj32((String)newValue);
				return;
			case GenericsPackage.MULTI_IMAGE__OBJ48:
				setObj48((String)newValue);
				return;
			case GenericsPackage.MULTI_IMAGE__OBJ96:
				setObj96((String)newValue);
				return;
			case GenericsPackage.MULTI_IMAGE__OBJ128:
				setObj128((String)newValue);
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
			case GenericsPackage.MULTI_IMAGE__OBJ16:
				setObj16(OBJ16_EDEFAULT);
				return;
			case GenericsPackage.MULTI_IMAGE__OBJ32:
				setObj32(OBJ32_EDEFAULT);
				return;
			case GenericsPackage.MULTI_IMAGE__OBJ48:
				setObj48(OBJ48_EDEFAULT);
				return;
			case GenericsPackage.MULTI_IMAGE__OBJ96:
				setObj96(OBJ96_EDEFAULT);
				return;
			case GenericsPackage.MULTI_IMAGE__OBJ128:
				setObj128(OBJ128_EDEFAULT);
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
			case GenericsPackage.MULTI_IMAGE__OBJ16:
				return OBJ16_EDEFAULT == null ? obj16 != null : !OBJ16_EDEFAULT.equals(obj16);
			case GenericsPackage.MULTI_IMAGE__OBJ32:
				return OBJ32_EDEFAULT == null ? obj32 != null : !OBJ32_EDEFAULT.equals(obj32);
			case GenericsPackage.MULTI_IMAGE__OBJ48:
				return OBJ48_EDEFAULT == null ? obj48 != null : !OBJ48_EDEFAULT.equals(obj48);
			case GenericsPackage.MULTI_IMAGE__OBJ96:
				return OBJ96_EDEFAULT == null ? obj96 != null : !OBJ96_EDEFAULT.equals(obj96);
			case GenericsPackage.MULTI_IMAGE__OBJ128:
				return OBJ128_EDEFAULT == null ? obj128 != null : !OBJ128_EDEFAULT.equals(obj128);
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
		result.append(" (obj16: ");
		result.append(obj16);
		result.append(", obj32: ");
		result.append(obj32);
		result.append(", obj48: ");
		result.append(obj48);
		result.append(", obj96: ");
		result.append(obj96);
		result.append(", obj128: ");
		result.append(obj128);
		result.append(')');
		return result.toString();
	}

} //MultiImageImpl
