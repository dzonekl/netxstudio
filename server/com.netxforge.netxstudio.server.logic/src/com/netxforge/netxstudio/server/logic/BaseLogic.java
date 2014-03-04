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
import com.netxforge.base.NonModelUtils;
import com.netxforge.base.cdo.ICDOData;
import com.netxforge.netxstudio.NetxstudioPackage;
import com.netxforge.netxstudio.ServerSettings;
import com.netxforge.netxstudio.common.model.StudioUtils;
import com.netxforge.netxstudio.data.IQueryService;
import com.netxforge.netxstudio.data.job.IRunMonitor;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.Expression;
import com.netxforge.netxstudio.scheduling.ComponentFailure;
import com.netxforge.netxstudio.scheduling.ExpressionFailure;
import com.netxforge.netxstudio.scheduling.Failure;
import com.netxforge.netxstudio.scheduling.JobRunState;
import com.netxforge.netxstudio.server.data.IServerDataProvider;
import com.netxforge.netxstudio.server.data.Server;
import com.netxforge.netxstudio.server.job.ServerWorkFlowRunMonitor;
import com.netxforge.netxstudio.server.logic.internal.LogicActivator;

/**
 * Common code for all logic implementations. The Base Logic can be run once or
 * continued on the same {@link ServerWorkFlowRunMonitor monitor}.
 * 
 * @author Martin Taal
 * @author Christophe Bouhier
 */
public abstract class BaseLogic {

	@Inject
	@Server
	private IServerDataProvider dataProvider;

	private ICDOData data;

	@Inject
	protected IQueryService queryService;

	private IRunMonitor jobMonitor;

	private List<Failure> failures = new ArrayList<Failure>();

	protected long durationThisInstance = 0;

	/** The number of times we have completed the run */
	protected int numOfCompletedRuns = 0;

	private long startTime = 0;

	public void run() {

		try {
			// Guard so we don't mix using this logic as a one off or re-use.
			if (numOfCompletedRuns != 0) {
				throw new IllegalAccessException("Not allowed to run logic: "
						+ this.getClass().getName() + " more than once");
			}

			startTime = System.currentTimeMillis();
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
			numOfCompletedRuns = 1;
			CDOSession session = this.getData().getSession();
			if (!session.isClosed()) {
				session.close();
			}
			durationThisInstance = System.currentTimeMillis() - startTime;
			reportStats();
		}
	}

	/**
	 * Doesn't close the sessions, so can be called multiple times. FIXME, The
	 * workflow won't be handled properly, as it is reset each time, and
	 * intermediate result is lost.
	 */
	public void runWithoutClosing() {

		try {
			if (numOfCompletedRuns == 0) {
				startTime = System.currentTimeMillis();
			}

			doRun();
		} catch (final Throwable t) {

			// The types of errors here are from the logic and delegation to the
			// engine.
			// failures from the run-monitor are isolated. Failures fromt the
			// Expression Engine are also isolated and will
			// result in a failure object.

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
			numOfCompletedRuns++;
		}
	}

	/**
	 * Close the logic and the run monitor. Use this if this is the single logic
	 * in the Job.
	 */
	public void close() {

		closeLogic();

		// Update the monitor.
		if (getFailures().isEmpty()) {
			jobMonitor.setFinished(JobRunState.FINISHED_SUCCESSFULLY, null);
		} else {
			jobMonitor.setFinished(JobRunState.FINISHED_WITH_ERROR, null);
		}

		durationThisInstance = System.currentTimeMillis() - startTime;
		reportStats();

	}

	/**
	 * Close the logic, but not the run monitor, as it is meant to be used
	 * further on.
	 */
	public void closeLogic() {
		// Will close any open transaction.
		getData().commitTransactionThenClose();
		getData().closeSession();
	}

	protected void reportStats() {
		// report the duration;
		if (LogicActivator.DEBUG) {
			LogicActivator.TRACE.trace(LogicActivator.TRACE_LOGIC_OPTION,
					"Done executing logic: " + this.getClass().getName());
			LogicActivator.TRACE.trace(LogicActivator.TRACE_LOGIC_OPTION,
					"Logic Completed Runs: " + numOfCompletedRuns);

			LogicActivator.TRACE.trace(
					LogicActivator.TRACE_LOGIC_OPTION,
					"Logic Duration: "
							+ NonModelUtils.timeDuration(durationThisInstance));
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
				final String expressionAsString = StudioUtils
						.expressionAsString(expressionRef);
				sb.append(expressionAsString);
			}
			if (f instanceof ComponentFailure) {
				Component componentRef = ((ComponentFailure) f)
						.getComponentRef();
				sb.append(StudioUtils.printModelObject(componentRef));
			}
			jobMonitor.updateLog(sb.toString());
		}
	}

	// Implementers should override.
	protected void doRun() {
	}

	protected abstract BaseEngine getEngine();

	public IRunMonitor getJobMonitor() {
		return jobMonitor;
	}

	public void setJobMonitor(IRunMonitor jobMonitor) {
		this.jobMonitor = jobMonitor;
	}

	/**
	 * Lazy load our {@link ICDOData} from a {@link IServerDataProvider Provider}
	 * 
	 * @return
	 */
	public ICDOData getData() {

		if (data == null) {
			data = dataProvider.get();
		}
		return data;
	}

	// public void setDataProvider(IDataProvider dataProvider) {
	// this.dataProvider = dataProvider;
	// }

	public List<Failure> getFailures() {
		return failures;
	}

	public ServerSettings getSettings() {
		// This piece goes in commons somewhere.
		Resource settingsResource = this.getData().getResource(
				NetxstudioPackage.Literals.SERVER_SETTINGS);
		ServerSettings settings = null;
		if (settingsResource != null
				&& settingsResource.getContents().size() == 1) {
			settings = (ServerSettings) settingsResource.getContents().get(0);
		}
		return settings;
	}
}
