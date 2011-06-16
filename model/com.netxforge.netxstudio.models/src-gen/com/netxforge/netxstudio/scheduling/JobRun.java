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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Job Run</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.scheduling.JobRun#getEnded <em>Ended</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.scheduling.JobRun#getLog <em>Log</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.scheduling.JobRun#getProgress <em>Progress</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.scheduling.JobRun#getProgressMessage <em>Progress Message</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.scheduling.JobRun#getProgressTask <em>Progress Task</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.scheduling.JobRun#getStarted <em>Started</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.scheduling.JobRun#getState <em>State</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.netxforge.netxstudio.scheduling.SchedulingPackage#getJobRun()
 * @model extendedMetaData="name='JobRun' kind='empty'"
 * @extends CDOObject
 * @generated
 */
public interface JobRun extends CDOObject {
	/**
	 * Returns the value of the '<em><b>Ended</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ended</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ended</em>' attribute.
	 * @see #setEnded(XMLGregorianCalendar)
	 * @see com.netxforge.netxstudio.scheduling.SchedulingPackage#getJobRun_Ended()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.DateTime"
	 *        extendedMetaData="kind='attribute' name='Ended'"
	 * @generated
	 */
	XMLGregorianCalendar getEnded();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.scheduling.JobRun#getEnded <em>Ended</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ended</em>' attribute.
	 * @see #getEnded()
	 * @generated
	 */
	void setEnded(XMLGregorianCalendar value);

	/**
	 * Returns the value of the '<em><b>Log</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Log</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Log</em>' attribute.
	 * @see #setLog(String)
	 * @see com.netxforge.netxstudio.scheduling.SchedulingPackage#getJobRun_Log()
	 * @model dataType="com.netxforge.netxstudio.generics.LongText"
	 *        extendedMetaData="kind='attribute' name='Log'"
	 * @generated
	 */
	String getLog();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.scheduling.JobRun#getLog <em>Log</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Log</em>' attribute.
	 * @see #getLog()
	 * @generated
	 */
	void setLog(String value);

	/**
	 * Returns the value of the '<em><b>Progress</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Progress</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Progress</em>' attribute.
	 * @see #isSetProgress()
	 * @see #unsetProgress()
	 * @see #setProgress(int)
	 * @see com.netxforge.netxstudio.scheduling.SchedulingPackage#getJobRun_Progress()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='attribute' name='Progress'"
	 * @generated
	 */
	int getProgress();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.scheduling.JobRun#getProgress <em>Progress</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Progress</em>' attribute.
	 * @see #isSetProgress()
	 * @see #unsetProgress()
	 * @see #getProgress()
	 * @generated
	 */
	void setProgress(int value);

	/**
	 * Unsets the value of the '{@link com.netxforge.netxstudio.scheduling.JobRun#getProgress <em>Progress</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetProgress()
	 * @see #getProgress()
	 * @see #setProgress(int)
	 * @generated
	 */
	void unsetProgress();

	/**
	 * Returns whether the value of the '{@link com.netxforge.netxstudio.scheduling.JobRun#getProgress <em>Progress</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Progress</em>' attribute is set.
	 * @see #unsetProgress()
	 * @see #getProgress()
	 * @see #setProgress(int)
	 * @generated
	 */
	boolean isSetProgress();

	/**
	 * Returns the value of the '<em><b>Progress Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Progress Message</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Progress Message</em>' attribute.
	 * @see #setProgressMessage(String)
	 * @see com.netxforge.netxstudio.scheduling.SchedulingPackage#getJobRun_ProgressMessage()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ProgressMessage'"
	 * @generated
	 */
	String getProgressMessage();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.scheduling.JobRun#getProgressMessage <em>Progress Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Progress Message</em>' attribute.
	 * @see #getProgressMessage()
	 * @generated
	 */
	void setProgressMessage(String value);

	/**
	 * Returns the value of the '<em><b>Progress Task</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Progress Task</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Progress Task</em>' attribute.
	 * @see #setProgressTask(String)
	 * @see com.netxforge.netxstudio.scheduling.SchedulingPackage#getJobRun_ProgressTask()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='ProgressTask'"
	 * @generated
	 */
	String getProgressTask();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.scheduling.JobRun#getProgressTask <em>Progress Task</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Progress Task</em>' attribute.
	 * @see #getProgressTask()
	 * @generated
	 */
	void setProgressTask(String value);

	/**
	 * Returns the value of the '<em><b>Started</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Started</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Started</em>' attribute.
	 * @see #setStarted(XMLGregorianCalendar)
	 * @see com.netxforge.netxstudio.scheduling.SchedulingPackage#getJobRun_Started()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.DateTime"
	 *        extendedMetaData="kind='attribute' name='Started'"
	 * @generated
	 */
	XMLGregorianCalendar getStarted();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.scheduling.JobRun#getStarted <em>Started</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Started</em>' attribute.
	 * @see #getStarted()
	 * @generated
	 */
	void setStarted(XMLGregorianCalendar value);

	/**
	 * Returns the value of the '<em><b>State</b></em>' attribute.
	 * The literals are from the enumeration {@link com.netxforge.netxstudio.scheduling.JobRunState}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State</em>' attribute.
	 * @see com.netxforge.netxstudio.scheduling.JobRunState
	 * @see #isSetState()
	 * @see #unsetState()
	 * @see #setState(JobRunState)
	 * @see com.netxforge.netxstudio.scheduling.SchedulingPackage#getJobRun_State()
	 * @model unsettable="true"
	 *        extendedMetaData="kind='attribute' name='State'"
	 * @generated
	 */
	JobRunState getState();

	/**
	 * Sets the value of the '{@link com.netxforge.netxstudio.scheduling.JobRun#getState <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State</em>' attribute.
	 * @see com.netxforge.netxstudio.scheduling.JobRunState
	 * @see #isSetState()
	 * @see #unsetState()
	 * @see #getState()
	 * @generated
	 */
	void setState(JobRunState value);

	/**
	 * Unsets the value of the '{@link com.netxforge.netxstudio.scheduling.JobRun#getState <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetState()
	 * @see #getState()
	 * @see #setState(JobRunState)
	 * @generated
	 */
	void unsetState();

	/**
	 * Returns whether the value of the '{@link com.netxforge.netxstudio.scheduling.JobRun#getState <em>State</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>State</em>' attribute is set.
	 * @see #unsetState()
	 * @see #getState()
	 * @see #setState(JobRunState)
	 * @generated
	 */
	boolean isSetState();

} // JobRun
