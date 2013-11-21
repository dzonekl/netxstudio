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
package com.netxforge.netxstudio.server.logic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.data.IData;
import com.netxforge.netxstudio.data.job.IRunMonitor;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.scheduling.Failure;
import com.netxforge.netxstudio.server.job.ServerWorkFlowRunMonitor;

/**
 * Holds several attributes like {@link ModelUtils} and the current
 * {@link ServerWorkFlowRunMonitor}
 * 
 * @author Martin Taal
 * @author Christophe Bouhier
 */
public abstract class BaseEngine {

	private IRunMonitor jobMonitor;

	// contains context information to use when adding an error message to the
	// log
	private String engineContextInfo = "";

	// on purpose no @Inject as we need the same instance
	// as used in the job implementation
	private IData dataProvider;

	@Inject
	private ModelUtils modelUtils;

	private DateTimeRange period;
	private Date start;
	private Date end;

	private List<Failure> failures = new ArrayList<Failure>();

	public void execute() {
		doExecute();
	}

	public abstract void doExecute();

	public IData getDataProvider() {
		return dataProvider;
	}

	public void setDataProvider(IData dataProvider) {
		this.dataProvider = dataProvider;
	}

	public DateTimeRange getPeriod() {
		return period;
	}

	public void setPeriod(DateTimeRange range) {
		this.period = range;
		start = modelUtils.fromXMLDate(range.getBegin());
		end = modelUtils.fromXMLDate(range.getEnd());
	}

	public List<Failure> getFailures() {
		return failures;
	}

	public ModelUtils getModelUtils() {
		return modelUtils;
	}

	public Date getStart() {
		return start;
	}

	public Date getEnd() {
		return end;
	}

	public IRunMonitor getJobMonitor() {
		return jobMonitor;
	}

	public void setJobMonitor(IRunMonitor jobMonitor) {
		this.jobMonitor = jobMonitor;
	}

	public String getEngineContextInfo() {
		return engineContextInfo;
	}

	public void setEngineContextInfo(String engineContextInfo) {
		this.engineContextInfo = engineContextInfo;
	}

}
