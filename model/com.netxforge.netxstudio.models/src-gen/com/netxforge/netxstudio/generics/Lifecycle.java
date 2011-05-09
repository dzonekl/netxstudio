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

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.cdo.CDOObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Lifecycle</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A type representing the lifecycle.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.generics.Lifecycle#getConstructionDate <em>Construction Date</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.generics.Lifecycle#getInServiceDate <em>In Service Date</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.generics.Lifecycle#getOutOfServiceDate <em>Out Of Service Date</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.generics.Lifecycle#getPlannedDate <em>Planned Date</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.generics.Lifecycle#getProposed <em>Proposed</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.generics.GenericsPackage#getLifecycle()
 * @model extendedMetaData="name='Lifecycle' kind='empty'"
 * @extends CDOObject
 * @generated
 */
public interface Lifecycle extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Construction Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The ConstructionDate attribute holds the date and time when constructed.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Construction Date</em>' attribute.
	 * @see #setConstructionDate(XMLGregorianCalendar)
	 * @see com.netxforge.netxstudio.generics.GenericsPackage#getLifecycle_ConstructionDate()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.DateTime"
	 *        extendedMetaData="kind='attribute' name='ConstructionDate'"
	 * @generated
	 */
	XMLGregorianCalendar getConstructionDate();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.generics.Lifecycle#getConstructionDate <em>Construction Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Construction Date</em>' attribute.
	 * @see #getConstructionDate()
	 * @generated
	 */
	void setConstructionDate(XMLGregorianCalendar value);

	/**
	 * Returns the value of the '<em><b>In Service Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The InServiceDate attribute holds the date and time when brought into service.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>In Service Date</em>' attribute.
	 * @see #setInServiceDate(XMLGregorianCalendar)
	 * @see com.netxforge.netxstudio.generics.GenericsPackage#getLifecycle_InServiceDate()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.DateTime"
	 *        extendedMetaData="kind='attribute' name='InServiceDate'"
	 * @generated
	 */
	XMLGregorianCalendar getInServiceDate();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.generics.Lifecycle#getInServiceDate <em>In Service Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>In Service Date</em>' attribute.
	 * @see #getInServiceDate()
	 * @generated
	 */
	void setInServiceDate(XMLGregorianCalendar value);

	/**
	 * Returns the value of the '<em><b>Out Of Service Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The OutOfServiceDate attribute holds the date and time when out of service.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Out Of Service Date</em>' attribute.
	 * @see #setOutOfServiceDate(XMLGregorianCalendar)
	 * @see com.netxforge.netxstudio.generics.GenericsPackage#getLifecycle_OutOfServiceDate()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.DateTime"
	 *        extendedMetaData="kind='attribute' name='OutOfServiceDate'"
	 * @generated
	 */
	XMLGregorianCalendar getOutOfServiceDate();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.generics.Lifecycle#getOutOfServiceDate <em>Out Of Service Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Out Of Service Date</em>' attribute.
	 * @see #getOutOfServiceDate()
	 * @generated
	 */
	void setOutOfServiceDate(XMLGregorianCalendar value);

	/**
	 * Returns the value of the '<em><b>Planned Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The PlannedDate attribute holds the date and time when planned.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Planned Date</em>' attribute.
	 * @see #setPlannedDate(XMLGregorianCalendar)
	 * @see com.netxforge.netxstudio.generics.GenericsPackage#getLifecycle_PlannedDate()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.DateTime"
	 *        extendedMetaData="kind='attribute' name='PlannedDate'"
	 * @generated
	 */
	XMLGregorianCalendar getPlannedDate();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.generics.Lifecycle#getPlannedDate <em>Planned Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Planned Date</em>' attribute.
	 * @see #getPlannedDate()
	 * @generated
	 */
	void setPlannedDate(XMLGregorianCalendar value);

	/**
	 * Returns the value of the '<em><b>Proposed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Proposed attribute holds the date and time when proposed.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Proposed</em>' attribute.
	 * @see #setProposed(XMLGregorianCalendar)
	 * @see com.netxforge.netxstudio.generics.GenericsPackage#getLifecycle_Proposed()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.DateTime"
	 *        extendedMetaData="kind='attribute' name='Proposed'"
	 * @generated
	 */
	XMLGregorianCalendar getProposed();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.generics.Lifecycle#getProposed <em>Proposed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Proposed</em>' attribute.
	 * @see #getProposed()
	 * @generated
	 */
	void setProposed(XMLGregorianCalendar value);

} // Lifecycle
