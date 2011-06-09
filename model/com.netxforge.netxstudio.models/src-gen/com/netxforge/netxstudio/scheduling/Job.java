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

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Job</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.scheduling.Job#getJobRuns <em>Job Runs</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.scheduling.Job#getInterval <em>Interval</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.scheduling.Job#getJobState <em>Job State</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.scheduling.Job#getLastRunTime <em>Last Run Time</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.scheduling.Job#getName <em>Name</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.scheduling.Job#getStartTime <em>Start Time</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.scheduling.SchedulingPackage#getJob()
 * @model extendedMetaData="name='Job' kind='elementOnly'"
 * @extends CDOObject
 * @generated
 */
public interface Job extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Job Runs</b></em>' containment reference list.
	 * The list contents are of type {@link com.netxforge.netxstudio.scheduling.JobRun}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Job Runs</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Job Runs</em>' containment reference list.
	 * @see com.netxforge.netxstudio.scheduling.SchedulingPackage#getJob_JobRuns()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='JobRuns'"
	 * @generated
	 */
	EList<JobRun> getJobRuns();

	/**
	 * Returns the value of the '<em><b>Interval</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interval</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interval</em>' attribute.
	 * @see #isSetInterval()
	 * @see #unsetInterval()
	 * @see #setInterval(long)
	 * @see com.netxforge.netxstudio.scheduling.SchedulingPackage#getJob_Interval()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Long"
	 *        extendedMetaData="kind='attribute' name='Interval'"
	 * @generated
	 */
	long getInterval();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.scheduling.Job#getInterval <em>Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interval</em>' attribute.
	 * @see #isSetInterval()
	 * @see #unsetInterval()
	 * @see #getInterval()
	 * @generated
	 */
	void setInterval(long value);

	/**
	 * Unsets the value of the '{@link com.netxforge.netxstudio.scheduling.Job#getInterval <em>Interval</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetInterval()
	 * @see #getInterval()
	 * @see #setInterval(long)
	 * @generated
	 */
	void unsetInterval();

	/**
	 * Returns whether the value of the '{@link com.netxforge.netxstudio.scheduling.Job#getInterval <em>Interval</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Interval</em>' attribute is set.
	 * @see #unsetInterval()
	 * @see #getInterval()
	 * @see #setInterval(long)
	 * @generated
	 */
	boolean isSetInterval();

	/**
	 * Returns the value of the '<em><b>Job State</b></em>' attribute.
	 * The literals are from the enumeration {@link com.netxforge.netxstudio.scheduling.JobState}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Job State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Job State</em>' attribute.
	 * @see com.netxforge.netxstudio.scheduling.JobState
	 * @see #isSetJobState()
	 * @see #unsetJobState()
	 * @see #setJobState(JobState)
	 * @see com.netxforge.netxstudio.scheduling.SchedulingPackage#getJob_JobState()
	 * @model unsettable="true"
	 *        extendedMetaData="kind='attribute' name='JobState'"
	 * @generated
	 */
	JobState getJobState();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.scheduling.Job#getJobState <em>Job State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Job State</em>' attribute.
	 * @see com.netxforge.netxstudio.scheduling.JobState
	 * @see #isSetJobState()
	 * @see #unsetJobState()
	 * @see #getJobState()
	 * @generated
	 */
	void setJobState(JobState value);

	/**
	 * Unsets the value of the '{@link com.netxforge.netxstudio.scheduling.Job#getJobState <em>Job State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetJobState()
	 * @see #getJobState()
	 * @see #setJobState(JobState)
	 * @generated
	 */
	void unsetJobState();

	/**
	 * Returns whether the value of the '{@link com.netxforge.netxstudio.scheduling.Job#getJobState <em>Job State</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Job State</em>' attribute is set.
	 * @see #unsetJobState()
	 * @see #getJobState()
	 * @see #setJobState(JobState)
	 * @generated
	 */
	boolean isSetJobState();

	/**
	 * Returns the value of the '<em><b>Last Run Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Last Run Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Last Run Time</em>' attribute.
	 * @see #setLastRunTime(XMLGregorianCalendar)
	 * @see com.netxforge.netxstudio.scheduling.SchedulingPackage#getJob_LastRunTime()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.DateTime"
	 *        extendedMetaData="kind='attribute' name='LastRunTime'"
	 * @generated
	 */
	XMLGregorianCalendar getLastRunTime();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.scheduling.Job#getLastRunTime <em>Last Run Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Run Time</em>' attribute.
	 * @see #getLastRunTime()
	 * @generated
	 */
	void setLastRunTime(XMLGregorianCalendar value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.netxforge.netxstudio.scheduling.SchedulingPackage#getJob_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='Name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.scheduling.Job#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Start Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Time</em>' attribute.
	 * @see #setStartTime(XMLGregorianCalendar)
	 * @see com.netxforge.netxstudio.scheduling.SchedulingPackage#getJob_StartTime()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.DateTime"
	 *        extendedMetaData="kind='attribute' name='StartTime'"
	 * @generated
	 */
	XMLGregorianCalendar getStartTime();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.scheduling.Job#getStartTime <em>Start Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Time</em>' attribute.
	 * @see #getStartTime()
	 * @generated
	 */
	void setStartTime(XMLGregorianCalendar value);

} // Job
