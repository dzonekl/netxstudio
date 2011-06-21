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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import com.netxforge.netxstudio.generics.GenericsPackage;
import com.netxforge.netxstudio.generics.MultiImage;

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
public class MultiImageImpl extends BaseImpl implements MultiImage {
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
		return (String)eGet(GenericsPackage.Literals.MULTI_IMAGE__OBJ16, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObj16(String newObj16) {
		eSet(GenericsPackage.Literals.MULTI_IMAGE__OBJ16, newObj16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getObj32() {
		return (String)eGet(GenericsPackage.Literals.MULTI_IMAGE__OBJ32, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObj32(String newObj32) {
		eSet(GenericsPackage.Literals.MULTI_IMAGE__OBJ32, newObj32);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getObj48() {
		return (String)eGet(GenericsPackage.Literals.MULTI_IMAGE__OBJ48, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObj48(String newObj48) {
		eSet(GenericsPackage.Literals.MULTI_IMAGE__OBJ48, newObj48);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getObj96() {
		return (String)eGet(GenericsPackage.Literals.MULTI_IMAGE__OBJ96, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObj96(String newObj96) {
		eSet(GenericsPackage.Literals.MULTI_IMAGE__OBJ96, newObj96);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getObj128() {
		return (String)eGet(GenericsPackage.Literals.MULTI_IMAGE__OBJ128, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObj128(String newObj128) {
		eSet(GenericsPackage.Literals.MULTI_IMAGE__OBJ128, newObj128);
	}

} //MultiImageImpl
