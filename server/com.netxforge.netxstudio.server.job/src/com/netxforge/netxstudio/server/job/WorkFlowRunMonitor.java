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
package com.netxforge.netxstudio.server.job;

import com.netxforge.netxstudio.scheduling.JobRunState;

/**
 * Allows executors of jobs to more easily set progress and log messages.
 * 
 * @author Martin Taal
 */
public class WorkFlowRunMonitor {
	private int totalWork;
	private int workDone;
	private String msg;
	private String task;
	private StringBuilder log = new StringBuilder();

	public void appendToLog(String logStatement) {
		log.append("\n" + logStatement);
	}

	public String getLog() {
		return log.toString();
	}

	public void incrementProgress(int inc, boolean update) {
		workDone += inc;
		if (update) {
			update();
		}
	}

	protected void update() {		
	}
	
	public int getProgress() {
		if (workDone > totalWork) {
			return 100;
		}
		return (100 * workDone / totalWork);
	}

	public int getTotalWork() {
		return totalWork;
	}

	public void setTotalWork(int totalWork) {
		this.totalWork = totalWork;
	}

	public int getWorkDone() {
		return workDone;
	}

	public void setWorkDone(int workDone) {
		this.workDone = workDone;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}
	
	public void setStartRunning() {
	}

	public void setFinished(JobRunState state, Throwable t) {
	}

}
