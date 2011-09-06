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

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

import org.eclipse.emf.cdo.common.id.CDOID;

import com.google.inject.Inject;
import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.scheduling.JobRunState;
import com.netxforge.netxstudio.scheduling.WorkFlowRun;
import com.netxforge.netxstudio.server.Server;
import com.netxforge.netxstudio.server.ServerUtils;

/**
 * The work flow monitor used on the server side.
 * 
 * @author Martin Taal
 */
public class ServerWorkFlowRunMonitor extends WorkFlowRunMonitor {
	private CDOID workFlowRunId;
	
	@Inject
	@Server
	private IDataProvider dataProvider;

	@Override
	public void update() {
		dataProvider.openSession();
		final WorkFlowRun wfRun = (WorkFlowRun)dataProvider.getTransaction().getObject(workFlowRunId);
		wfRun.setProgress(getProgress());
		wfRun.setProgressMessage(getMsg());
		wfRun.setProgressTask(getTask());
		dataProvider.commitTransaction();
		dataProvider.closeSession();
	}

	public CDOID getWorkFlowRunId() {
		return workFlowRunId;
	}

	public void setWorkFlowRunId(CDOID workFlowRunId) {
		this.workFlowRunId = workFlowRunId;
	}
	
	@Override
	public void setStartRunning() {
		dataProvider.openSession();
		dataProvider.getTransaction();
		final WorkFlowRun wfRun = (WorkFlowRun)dataProvider.getTransaction().getObject(workFlowRunId);
		wfRun.setState(JobRunState.RUNNING);
		wfRun.setStarted(ServerUtils.getInstance().toXmlDate(new Date()));
		wfRun.setProgress(0);
		dataProvider.commitTransaction();
		dataProvider.closeSession();
	}

	@Override
	public void setFinished(JobRunState state, Throwable t) {
		dataProvider.openSession();
		final WorkFlowRun wfRun = (WorkFlowRun)dataProvider.getTransaction().getObject(workFlowRunId);
		if (t != null) {
			wfRun.setState(JobRunState.FINISHED_WITH_ERROR);
			final StringWriter sw = new StringWriter();
			final PrintWriter pw = new PrintWriter(sw);					
			t.printStackTrace(pw);
			wfRun.setLog(getLog() + "\n" + t.getMessage() + "\n" + sw.toString());
		} else {
			wfRun.setState(state);
			if (getLog().length() > 0) {
				wfRun.setLog(getLog().toString());				
			}
			wfRun.setProgress(100);
		}
		wfRun.setEnded(ServerUtils.getInstance().toXmlDate(new Date()));
		dataProvider.commitTransaction();
		dataProvider.closeSession();
	}

}