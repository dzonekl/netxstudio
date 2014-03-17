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
package com.netxforge.netxstudio.scheduling;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Job Run Container</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.scheduling.JobRunContainer#getJob <em>Job</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.scheduling.JobRunContainer#getWorkFlowRuns <em>Work Flow Runs</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.scheduling.SchedulingPackage#getJobRunContainer()
 * @model extendedMetaData="name='JobRunContainer' kind='elementOnly'"
 * @generated
 */
public interface JobRunContainer extends EObject {
	/**
	 * Returns the value of the '<em><b>Job</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Job</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Job</em>' reference.
	 * @see #setJob(Job)
	 * @see com.netxforge.netxstudio.scheduling.SchedulingPackage#getJobRunContainer_Job()
	 * @model required="true"
	 *        extendedMetaData="kind='element' name='Job'"
	 * @generated
	 */
	Job getJob();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.scheduling.JobRunContainer#getJob <em>Job</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Job</em>' reference.
	 * @see #getJob()
	 * @generated
	 */
	void setJob(Job value);

	/**
	 * Returns the value of the '<em><b>Work Flow Runs</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.scheduling.WorkFlowRun}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Work Flow Runs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Work Flow Runs</em>' containment reference list.
	 * @see com.netxforge.netxstudio.scheduling.SchedulingPackage#getJobRunContainer_WorkFlowRuns()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='WorkFlowRuns'"
	 * @generated
	 */
	EList<WorkFlowRun> getWorkFlowRuns();

} // JobRunContainer
