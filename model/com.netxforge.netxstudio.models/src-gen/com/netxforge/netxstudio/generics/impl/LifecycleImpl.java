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

import com.netxforge.netxstudio.generics.GenericsPackage;
import com.netxforge.netxstudio.generics.Lifecycle;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Lifecycle</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.generics.impl.LifecycleImpl#getConstructionDate <em>Construction Date</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.generics.impl.LifecycleImpl#getInServiceDate <em>In Service Date</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.generics.impl.LifecycleImpl#getOutOfServiceDate <em>Out Of Service Date</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.generics.impl.LifecycleImpl#getPlannedDate <em>Planned Date</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.generics.impl.LifecycleImpl#getProposed <em>Proposed</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LifecycleImpl extends CDOObjectImpl implements Lifecycle {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LifecycleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return GenericsPackage.Literals.LIFECYCLE;
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
	public XMLGregorianCalendar getConstructionDate() {
		return (XMLGregorianCalendar)eGet(GenericsPackage.Literals.LIFECYCLE__CONSTRUCTION_DATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConstructionDate(XMLGregorianCalendar newConstructionDate) {
		eSet(GenericsPackage.Literals.LIFECYCLE__CONSTRUCTION_DATE, newConstructionDate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XMLGregorianCalendar getInServiceDate() {
		return (XMLGregorianCalendar)eGet(GenericsPackage.Literals.LIFECYCLE__IN_SERVICE_DATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInServiceDate(XMLGregorianCalendar newInServiceDate) {
		eSet(GenericsPackage.Literals.LIFECYCLE__IN_SERVICE_DATE, newInServiceDate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XMLGregorianCalendar getOutOfServiceDate() {
		return (XMLGregorianCalendar)eGet(GenericsPackage.Literals.LIFECYCLE__OUT_OF_SERVICE_DATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutOfServiceDate(XMLGregorianCalendar newOutOfServiceDate) {
		eSet(GenericsPackage.Literals.LIFECYCLE__OUT_OF_SERVICE_DATE, newOutOfServiceDate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XMLGregorianCalendar getPlannedDate() {
		return (XMLGregorianCalendar)eGet(GenericsPackage.Literals.LIFECYCLE__PLANNED_DATE, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlannedDate(XMLGregorianCalendar newPlannedDate) {
		eSet(GenericsPackage.Literals.LIFECYCLE__PLANNED_DATE, newPlannedDate);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XMLGregorianCalendar getProposed() {
		return (XMLGregorianCalendar)eGet(GenericsPackage.Literals.LIFECYCLE__PROPOSED, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProposed(XMLGregorianCalendar newProposed) {
		eSet(GenericsPackage.Literals.LIFECYCLE__PROPOSED, newProposed);
	}

} //LifecycleImpl
