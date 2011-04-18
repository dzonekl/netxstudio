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
package com.netxforge.netxstudio.scheduling;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scheduling</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.scheduling.Scheduling#getJobs <em>Jobs</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.scheduling.SchedulingPackage#getScheduling()
 * @model extendedMetaData="name='Scheduling' kind='elementOnly'"
 * @generated
 */
public interface Scheduling extends EObject {
	/**
	 * Returns the value of the '<em><b>Jobs</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Jobs</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Jobs</em>' containment reference.
	 * @see #setJobs(Job)
	 * @see com.netxforge.netxstudio.scheduling.SchedulingPackage#getScheduling_Jobs()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='Jobs'"
	 * @generated
	 */
	Job getJobs();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.scheduling.Scheduling#getJobs <em>Jobs</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Jobs</em>' containment reference.
	 * @see #getJobs()
	 * @generated
	 */
	void setJobs(Job value);

} // Scheduling
