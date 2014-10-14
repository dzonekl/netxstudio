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
package com.netxforge.netxstudio.scheduling.impl;

import com.netxforge.netxstudio.scheduling.JobRunState;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;
import com.netxforge.netxstudio.scheduling.WorkFlowRun;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Work Flow Run</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.netxforge.netxstudio.scheduling.impl.WorkFlowRunImpl#getEnded <em>Ended</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.scheduling.impl.WorkFlowRunImpl#getLog <em>Log</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.scheduling.impl.WorkFlowRunImpl#getProgress <em>Progress</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.scheduling.impl.WorkFlowRunImpl#getProgressMessage <em>Progress Message</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.scheduling.impl.WorkFlowRunImpl#getProgressTask <em>Progress Task</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.scheduling.impl.WorkFlowRunImpl#getStarted <em>Started</em>}</li>
 *   <li>{@link com.netxforge.netxstudio.scheduling.impl.WorkFlowRunImpl#getState <em>State</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WorkFlowRunImpl extends MinimalEObjectImpl.Container implements WorkFlowRun {
	/**
	 * The default value of the '{@link #getEnded() <em>Ended</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnded()
	 * @generated
	 * @ordered
	 */
	protected static final XMLGregorianCalendar ENDED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEnded() <em>Ended</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnded()
	 * @generated
	 * @ordered
	 */
	protected XMLGregorianCalendar ended = ENDED_EDEFAULT;

	/**
	 * The default value of the '{@link #getLog() <em>Log</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLog()
	 * @generated
	 * @ordered
	 */
	protected static final String LOG_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLog() <em>Log</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLog()
	 * @generated
	 * @ordered
	 */
	protected String log = LOG_EDEFAULT;

	/**
	 * The default value of the '{@link #getProgress() <em>Progress</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProgress()
	 * @generated
	 * @ordered
	 */
	protected static final int PROGRESS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getProgress() <em>Progress</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProgress()
	 * @generated
	 * @ordered
	 */
	protected int progress = PROGRESS_EDEFAULT;

	/**
	 * This is true if the Progress attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean progressESet;

	/**
	 * The default value of the '{@link #getProgressMessage() <em>Progress Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProgressMessage()
	 * @generated
	 * @ordered
	 */
	protected static final String PROGRESS_MESSAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProgressMessage() <em>Progress Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProgressMessage()
	 * @generated
	 * @ordered
	 */
	protected String progressMessage = PROGRESS_MESSAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getProgressTask() <em>Progress Task</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProgressTask()
	 * @generated
	 * @ordered
	 */
	protected static final String PROGRESS_TASK_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProgressTask() <em>Progress Task</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProgressTask()
	 * @generated
	 * @ordered
	 */
	protected String progressTask = PROGRESS_TASK_EDEFAULT;

	/**
	 * The default value of the '{@link #getStarted() <em>Started</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStarted()
	 * @generated
	 * @ordered
	 */
	protected static final XMLGregorianCalendar STARTED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStarted() <em>Started</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStarted()
	 * @generated
	 * @ordered
	 */
	protected XMLGregorianCalendar started = STARTED_EDEFAULT;

	/**
	 * The default value of the '{@link #getState() <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected static final JobRunState STATE_EDEFAULT = JobRunState.RUNNING;

	/**
	 * The cached value of the '{@link #getState() <em>State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getState()
	 * @generated
	 * @ordered
	 */
	protected JobRunState state = STATE_EDEFAULT;

	/**
	 * This is true if the State attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean stateESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WorkFlowRunImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SchedulingPackage.Literals.WORK_FLOW_RUN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XMLGregorianCalendar getEnded() {
		return ended;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnded(XMLGregorianCalendar newEnded) {
		XMLGregorianCalendar oldEnded = ended;
		ended = newEnded;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulingPackage.WORK_FLOW_RUN__ENDED, oldEnded, ended));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLog() {
		return log;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLog(String newLog) {
		String oldLog = log;
		log = newLog;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulingPackage.WORK_FLOW_RUN__LOG, oldLog, log));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getProgress() {
		return progress;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProgress(int newProgress) {
		int oldProgress = progress;
		progress = newProgress;
		boolean oldProgressESet = progressESet;
		progressESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulingPackage.WORK_FLOW_RUN__PROGRESS, oldProgress, progress, !oldProgressESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetProgress() {
		int oldProgress = progress;
		boolean oldProgressESet = progressESet;
		progress = PROGRESS_EDEFAULT;
		progressESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, SchedulingPackage.WORK_FLOW_RUN__PROGRESS, oldProgress, PROGRESS_EDEFAULT, oldProgressESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetProgress() {
		return progressESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProgressMessage() {
		return progressMessage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProgressMessage(String newProgressMessage) {
		String oldProgressMessage = progressMessage;
		progressMessage = newProgressMessage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulingPackage.WORK_FLOW_RUN__PROGRESS_MESSAGE, oldProgressMessage, progressMessage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProgressTask() {
		return progressTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProgressTask(String newProgressTask) {
		String oldProgressTask = progressTask;
		progressTask = newProgressTask;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulingPackage.WORK_FLOW_RUN__PROGRESS_TASK, oldProgressTask, progressTask));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XMLGregorianCalendar getStarted() {
		return started;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStarted(XMLGregorianCalendar newStarted) {
		XMLGregorianCalendar oldStarted = started;
		started = newStarted;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulingPackage.WORK_FLOW_RUN__STARTED, oldStarted, started));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JobRunState getState() {
		return state;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setState(JobRunState newState) {
		JobRunState oldState = state;
		state = newState == null ? STATE_EDEFAULT : newState;
		boolean oldStateESet = stateESet;
		stateESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulingPackage.WORK_FLOW_RUN__STATE, oldState, state, !oldStateESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetState() {
		JobRunState oldState = state;
		boolean oldStateESet = stateESet;
		state = STATE_EDEFAULT;
		stateESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, SchedulingPackage.WORK_FLOW_RUN__STATE, oldState, STATE_EDEFAULT, oldStateESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetState() {
		return stateESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SchedulingPackage.WORK_FLOW_RUN__ENDED:
				return getEnded();
			case SchedulingPackage.WORK_FLOW_RUN__LOG:
				return getLog();
			case SchedulingPackage.WORK_FLOW_RUN__PROGRESS:
				return getProgress();
			case SchedulingPackage.WORK_FLOW_RUN__PROGRESS_MESSAGE:
				return getProgressMessage();
			case SchedulingPackage.WORK_FLOW_RUN__PROGRESS_TASK:
				return getProgressTask();
			case SchedulingPackage.WORK_FLOW_RUN__STARTED:
				return getStarted();
			case SchedulingPackage.WORK_FLOW_RUN__STATE:
				return getState();
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
			case SchedulingPackage.WORK_FLOW_RUN__ENDED:
				setEnded((XMLGregorianCalendar)newValue);
				return;
			case SchedulingPackage.WORK_FLOW_RUN__LOG:
				setLog((String)newValue);
				return;
			case SchedulingPackage.WORK_FLOW_RUN__PROGRESS:
				setProgress((Integer)newValue);
				return;
			case SchedulingPackage.WORK_FLOW_RUN__PROGRESS_MESSAGE:
				setProgressMessage((String)newValue);
				return;
			case SchedulingPackage.WORK_FLOW_RUN__PROGRESS_TASK:
				setProgressTask((String)newValue);
				return;
			case SchedulingPackage.WORK_FLOW_RUN__STARTED:
				setStarted((XMLGregorianCalendar)newValue);
				return;
			case SchedulingPackage.WORK_FLOW_RUN__STATE:
				setState((JobRunState)newValue);
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
			case SchedulingPackage.WORK_FLOW_RUN__ENDED:
				setEnded(ENDED_EDEFAULT);
				return;
			case SchedulingPackage.WORK_FLOW_RUN__LOG:
				setLog(LOG_EDEFAULT);
				return;
			case SchedulingPackage.WORK_FLOW_RUN__PROGRESS:
				unsetProgress();
				return;
			case SchedulingPackage.WORK_FLOW_RUN__PROGRESS_MESSAGE:
				setProgressMessage(PROGRESS_MESSAGE_EDEFAULT);
				return;
			case SchedulingPackage.WORK_FLOW_RUN__PROGRESS_TASK:
				setProgressTask(PROGRESS_TASK_EDEFAULT);
				return;
			case SchedulingPackage.WORK_FLOW_RUN__STARTED:
				setStarted(STARTED_EDEFAULT);
				return;
			case SchedulingPackage.WORK_FLOW_RUN__STATE:
				unsetState();
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
			case SchedulingPackage.WORK_FLOW_RUN__ENDED:
				return ENDED_EDEFAULT == null ? ended != null : !ENDED_EDEFAULT.equals(ended);
			case SchedulingPackage.WORK_FLOW_RUN__LOG:
				return LOG_EDEFAULT == null ? log != null : !LOG_EDEFAULT.equals(log);
			case SchedulingPackage.WORK_FLOW_RUN__PROGRESS:
				return isSetProgress();
			case SchedulingPackage.WORK_FLOW_RUN__PROGRESS_MESSAGE:
				return PROGRESS_MESSAGE_EDEFAULT == null ? progressMessage != null : !PROGRESS_MESSAGE_EDEFAULT.equals(progressMessage);
			case SchedulingPackage.WORK_FLOW_RUN__PROGRESS_TASK:
				return PROGRESS_TASK_EDEFAULT == null ? progressTask != null : !PROGRESS_TASK_EDEFAULT.equals(progressTask);
			case SchedulingPackage.WORK_FLOW_RUN__STARTED:
				return STARTED_EDEFAULT == null ? started != null : !STARTED_EDEFAULT.equals(started);
			case SchedulingPackage.WORK_FLOW_RUN__STATE:
				return isSetState();
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
		result.append(" (ended: ");
		result.append(ended);
		result.append(", log: ");
		result.append(log);
		result.append(", progress: ");
		if (progressESet) result.append(progress); else result.append("<unset>");
		result.append(", progressMessage: ");
		result.append(progressMessage);
		result.append(", progressTask: ");
		result.append(progressTask);
		result.append(", started: ");
		result.append(started);
		result.append(", state: ");
		if (stateESet) result.append(state); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //WorkFlowRunImpl
