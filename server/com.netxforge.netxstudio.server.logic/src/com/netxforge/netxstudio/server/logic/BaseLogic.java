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
import java.util.List;

import org.eclipse.emf.cdo.session.CDOSession;
import org.eclipse.emf.ecore.resource.Resource;

import com.google.inject.Inject;
import com.netxforge.netxstudio.NetxstudioPackage;
import com.netxforge.netxstudio.ServerSettings;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.data.IQueryService;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.Expression;
import com.netxforge.netxstudio.scheduling.ComponentFailure;
import com.netxforge.netxstudio.scheduling.ExpressionFailure;
import com.netxforge.netxstudio.scheduling.Failure;
import com.netxforge.netxstudio.scheduling.JobRunState;
import com.netxforge.netxstudio.server.Server;
import com.netxforge.netxstudio.server.job.ServerWorkFlowRunMonitor;
import com.netxforge.netxstudio.server.logic.internal.LogicActivator;

/**
 * Common code for all logic implementations. The Base Logic provides supporting
 * facilities.
 * 
 * 
 * @author Martin Taal
 * @author Christophe Bouhier
 */
public abstract class BaseLogic {

	private ServerWorkFlowRunMonitor jobMonitor;

	@Inject
	@Server
	private IDataProvider dataProvider;

	@Inject
	protected IQueryService queryService;

	@Inject
	private ModelUtils modelUtils;

	private List<Failure> failures = new ArrayList<Failure>();

	public void run() {
		try {
			doRun();
			if (getFailures().isEmpty()) {
				jobMonitor.setFinished(JobRunState.FINISHED_SUCCESSFULLY, null);
			} else {
				updateFailures();
				jobMonitor.setFinished(JobRunState.FINISHED_WITH_ERROR, null);
			}
		} catch (final Throwable t) {
			// 3 step, im the trace, on the console and in the log of the job
			// run.
			if (LogicActivator.DEBUG) {
				LogicActivator.TRACE.trace(LogicActivator.TRACE_LOGIC_OPTION,
						"Error in execution logic", t);
			}
			t.printStackTrace();
			jobMonitor.setFinished(JobRunState.FINISHED_WITH_ERROR, t);
		} finally {

			CDOSession session = this.getDataProvider().getSession();
			if (!session.isClosed()) {
				session.close();
			}
		}
	}

	/**
	 * 
	 */
	private void updateFailures() {
		// For each failure append the Message, Expression and Component
		// Name.
		for (Failure f : getFailures()) {

			StringBuilder sb = new StringBuilder();
			sb.append(f.getMessage());

			if (f instanceof ExpressionFailure) {
				final Expression expressionRef = ((ExpressionFailure) f)
						.getExpressionRef();
				final String expressionAsString = modelUtils
						.expressionAsString(expressionRef);
				sb.append(expressionAsString);
			}
			if (f instanceof ComponentFailure) {
				Component componentRef = ((ComponentFailure) f)
						.getComponentRef();
				sb.append(modelUtils.printModelObject(componentRef));
			}
			jobMonitor.updateLog(sb.toString());
		}
	}

	/**
	 * Doesn't close the sessions, so can be called multiple times. FIXME, The
	 * workflow won't be handled properly, as it is reset each time, and
	 * intermediate result is lost.
	 */
	public void runWithoutClosing() {
		try {
			doRun();
		} catch (final Throwable t) {
			// 3 step, im the trace, on the console and in the log of the job
			// run.
			if (LogicActivator.DEBUG) {
				LogicActivator.TRACE.trace(LogicActivator.TRACE_LOGIC_OPTION,
						"Error in execution logic", t);
			}
			t.printStackTrace();
			
			// ? Will continue with next section, so why set finished? 
			jobMonitor.setFinished(JobRunState.FINISHED_WITH_ERROR, t);
		} finally {
			// Update the monitor.

		}
	}
	
	/**
	 * Close the logic and the run monitor. 
	 * Use this if this is the single logic in the Job. 
	 * 
	 */
	public void close() {

		// Will close any open transaction.
		getDataProvider().commitTransaction();

		if (getFailures().isEmpty()) {
			jobMonitor.setFinished(JobRunState.FINISHED_SUCCESSFULLY, null);
		} else {
			jobMonitor.setFinished(JobRunState.FINISHED_WITH_ERROR, null);
		}
		getDataProvider().closeSession();
	}
	
	
	/**
	 * Close the logic, but now the run monitor, as it is meant to be used further on. 
	 */
	public void closeLogic() {
		// Will close any open transaction.
		getDataProvider().commitTransaction();
		getDataProvider().closeSession();
	}
	

	// Implementers should override.
	protected void doRun() {
	}

	protected abstract BaseEngine getEngine();

	public ServerWorkFlowRunMonitor getJobMonitor() {
		return jobMonitor;
	}

	public void setJobMonitor(ServerWorkFlowRunMonitor jobMonitor) {
		this.jobMonitor = jobMonitor;
	}

	public IDataProvider getDataProvider() {
		return dataProvider;
	}

	// public void setDataProvider(IDataProvider dataProvider) {
	// this.dataProvider = dataProvider;
	// }

	public List<Failure> getFailures() {
		return failures;
	}

	public ModelUtils getModelUtils() {
		return modelUtils;
	}

	public void setModelUtils(ModelUtils modelUtils) {
		this.modelUtils = modelUtils;
	}

	public ServerSettings getSettings() {
		// This piece goes in commons somewhere.
		Resource settingsResource = this.getDataProvider().getResource(
				NetxstudioPackage.Literals.SERVER_SETTINGS);
		ServerSettings settings = null;
		if (settingsResource != null
				&& settingsResource.getContents().size() == 1) {
			settings = (ServerSettings) settingsResource.getContents().get(0);
		}
		return settings;
	}
}
