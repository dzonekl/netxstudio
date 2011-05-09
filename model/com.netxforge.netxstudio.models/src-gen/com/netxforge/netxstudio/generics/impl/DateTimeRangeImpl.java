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

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.generics.GenericsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Date Time Range</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.generics.impl.DateTimeRangeImpl#getBegin <em>Begin</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.generics.impl.DateTimeRangeImpl#getEnd <em>End</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DateTimeRangeImpl extends CDOObjectImpl implements DateTimeRange {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DateTimeRangeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GenericsPackage.Literals.DATE_TIME_RANGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XMLGregorianCalendar getBegin() {
		return (XMLGregorianCalendar)eGet(GenericsPackage.Literals.DATE_TIME_RANGE__BEGIN, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBegin(XMLGregorianCalendar newBegin) {
		eSet(GenericsPackage.Literals.DATE_TIME_RANGE__BEGIN, newBegin);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XMLGregorianCalendar getEnd() {
		return (XMLGregorianCalendar)eGet(GenericsPackage.Literals.DATE_TIME_RANGE__END, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnd(XMLGregorianCalendar newEnd) {
		eSet(GenericsPackage.Literals.DATE_TIME_RANGE__END, newEnd);
	}

} //DateTimeRangeImpl
