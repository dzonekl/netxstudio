/*******************************************************************************
 * Copyright (c) May 20, 2011 NetXForge.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  You should have received a copy of the GNU Lesser General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors: Martin Taal - initial API and implementation and/or
 * initial documentation
 *******************************************************************************/
package com.netxforge.netxstudio.data.job;

import com.netxforge.netxstudio.scheduling.JobRunState;

/**
 * Allows executors of jobs to more easily set progress and log messages.
 * 
 * @author Martin Taal
 */
public abstract class WorkFlowRunMonitor implements IRunMonitor {

	private int totalWork;
	private int workDone;
	private String msg;
	private String task;
	private StringBuilder log = new StringBuilder();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.server.job.IRunMonitor#appendToLog(java.lang
	 * .String)
	 */
	public void appendToLog(String logStatement) {
		log.append("\n" + logStatement);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.server.job.IRunMonitor#getLog()
	 */
	public String getLog() {
		return log.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.server.job.IRunMonitor#incrementProgress(int,
	 * boolean)
	 */
	public void incrementProgress(int inc, boolean update) {
		workDone += inc;
		if (update) {
			update();
		}
	}

	protected void update() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.server.job.IRunMonitor#getProgress()
	 */
	public int getProgress() {
		if (workDone > totalWork) {
			return 100;
		}
		return (100 * workDone / totalWork);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.server.job.IRunMonitor#getTotalWork()
	 */
	public int getTotalWork() {
		return totalWork;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.server.job.IRunMonitor#setTotalWork(int)
	 */
	public void setTotalWork(int totalWork) {
		this.totalWork = totalWork;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.server.job.IRunMonitor#getWorkDone()
	 */
	public int getWorkDone() {
		return workDone;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.server.job.IRunMonitor#setWorkDone(int)
	 */
	public void setWorkDone(int workDone) {
		this.workDone = workDone;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.server.job.IRunMonitor#getMsg()
	 */
	public String getMsg() {
		return msg;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.server.job.IRunMonitor#setMsg(java.lang.String)
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.server.job.IRunMonitor#getTask()
	 */
	public String getTask() {
		return task;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.server.job.IRunMonitor#setTask(java.lang.String)
	 */
	public void setTask(String task) {
		this.task = task;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.server.job.IRunMonitor#setStartRunning()
	 */
	public void setStartRunning() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.data.job.IRunMonitor#setFinished(com.netxforge
	 * .netxstudio.scheduling.JobRunState, java.lang.Throwable)
	 */
	public void setFinished(JobRunState state, Throwable t) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.data.job.IRunMonitor#updateFailures(java.lang
	 * .String)
	 */
	public void updateLog(String string) {

	}
}
