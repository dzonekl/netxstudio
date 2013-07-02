/*******************************************************************************
 * Copyright (c) Sep 26, 2012 NetXForge.
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details. You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors: Christophe Bouhier - initial API and implementation and/or
 * initial documentation
 *******************************************************************************/ 
package com.netxforge.netxstudio.data.job;

import java.util.List;

import org.eclipse.emf.cdo.common.id.CDOID;

import com.netxforge.netxstudio.scheduling.Failure;
import com.netxforge.netxstudio.scheduling.JobRunState;

public interface IRunMonitor {

	public abstract void appendToLog(String logStatement);

	public abstract String getLog();

	public abstract void incrementProgress(int inc, boolean update);

	public abstract int getProgress();

	public abstract int getTotalWork();

	public abstract void setTotalWork(int totalWork);

	public abstract int getWorkDone();

	public abstract void setWorkDone(int workDone);

	public abstract String getMsg();

	public abstract void setMsg(String msg);

	public abstract String getTask();

	public abstract void setTask(String task);

	public abstract void setStartRunning();

	public abstract void setFinished(JobRunState state, Throwable t);
	
	public abstract void updateLog(String string);
	
	public abstract void updateFailures(List<Failure> failure);

	public abstract CDOID getWorkFlowRunId();
	
	public abstract void setWorkFlowRunId(CDOID cdoID);
	
	
}