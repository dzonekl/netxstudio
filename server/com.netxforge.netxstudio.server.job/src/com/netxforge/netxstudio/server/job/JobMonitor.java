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

/**
 * Allows executors of jobs to more easily set progress and log messages.
 * 
 * @author Martin Taal
 */
public class JobMonitor {
	private NetxForgeJob job;
	private JobImplementation jobImplementation;
	private int totalWork;
	private int workDone;
	private String msg;
	private String task;

	public void appendToLog(String logStatement) {
		jobImplementation.appendToLog(logStatement);
	}

	public void update() {
		job.updateJobRun(getProgress(), msg, task);
	}

	public void incrementProgress(int inc, boolean update) {
		workDone += inc;
		if (update) {
			job.updateJobRun(getProgress(), msg, task);
		}
	}

	private int getProgress() {
		if (workDone > totalWork) {
			return 100;
		}
		return (workDone / totalWork) * 100;
	}
	
	public NetxForgeJob getJob() {
		return job;
	}

	public void setJob(NetxForgeJob job) {
		this.job = job;
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

}
