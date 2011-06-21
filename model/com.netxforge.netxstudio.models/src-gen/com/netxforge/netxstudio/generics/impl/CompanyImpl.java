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

import com.netxforge.netxstudio.generics.Company;
import com.netxforge.netxstudio.generics.GenericsPackage;
import com.netxforge.netxstudio.generics.MultiImage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Company</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.generics.impl.CompanyImpl#getIcons <em>Icons</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.generics.impl.CompanyImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.generics.impl.CompanyImpl#getRSSurl <em>RS Surl</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.generics.impl.CompanyImpl#getShortName <em>Short Name</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.generics.impl.CompanyImpl#getSymbol <em>Symbol</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.generics.impl.CompanyImpl#getWebsite <em>Website</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CompanyImpl extends BaseImpl implements Company {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompanyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GenericsPackage.Literals.COMPANY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiImage getIcons() {
		return (MultiImage)eGet(GenericsPackage.Literals.COMPANY__ICONS, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIcons(MultiImage newIcons) {
		eSet(GenericsPackage.Literals.COMPANY__ICONS, newIcons);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return (String)eGet(GenericsPackage.Literals.COMPANY__NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		eSet(GenericsPackage.Literals.COMPANY__NAME, newName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRSSurl() {
		return (String)eGet(GenericsPackage.Literals.COMPANY__RS_SURL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRSSurl(String newRSSurl) {
		eSet(GenericsPackage.Literals.COMPANY__RS_SURL, newRSSurl);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getShortName() {
		return (String)eGet(GenericsPackage.Literals.COMPANY__SHORT_NAME, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setShortName(String newShortName) {
		eSet(GenericsPackage.Literals.COMPANY__SHORT_NAME, newShortName);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSymbol() {
		return (String)eGet(GenericsPackage.Literals.COMPANY__SYMBOL, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSymbol(String newSymbol) {
		eSet(GenericsPackage.Literals.COMPANY__SYMBOL, newSymbol);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getWebsite() {
		return (String)eGet(GenericsPackage.Literals.COMPANY__WEBSITE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWebsite(String newWebsite) {
		eSet(GenericsPackage.Literals.COMPANY__WEBSITE, newWebsite);
	}

} //CompanyImpl
