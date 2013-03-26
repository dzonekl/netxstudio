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
import java.util.List;

import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.session.CDOSession;

import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.data.job.WorkFlowRunMonitor;
import com.netxforge.netxstudio.scheduling.ComponentWorkFlowRun;
import com.netxforge.netxstudio.scheduling.Failure;
import com.netxforge.netxstudio.scheduling.JobRunState;
import com.netxforge.netxstudio.scheduling.WorkFlowRun;
import com.netxforge.netxstudio.server.Server;
import com.netxforge.netxstudio.server.job.internal.JobActivator;

/**
 * The work flow monitor used on the server side. Exceptions (Related to CDO
 * interaction) are caught here. No try is made to retry any commits, if the
 * workflow update fails.
 * 
 * @author Martin Taal
 * @author Christophe Bouhier
 */
public class ServerWorkFlowRunMonitor extends WorkFlowRunMonitor {
	private CDOID workFlowRunId;

	@Inject
	@Server
	private IDataProvider dataProvider;

	@Inject
	private ModelUtils modelUtils;

	/** One single session for the workflow monitor */
	private CDOSession openSession;
	private WorkFlowRun wfRun;

	public CDOID getWorkFlowRunId() {
		return workFlowRunId;
	}

	public void setWorkFlowRunId(CDOID workFlowRunId) {
		this.workFlowRunId = workFlowRunId;
	}

	@Override
	public void setStartRunning() {
		new FailSafeCDOAction() {

			@Override
			protected boolean pre() {
				openSession = dataProvider.openSession();
				wfRun = (WorkFlowRun) dataProvider.getTransaction().getObject(
						workFlowRunId);
				return super.pre();
			}

			@Override
			protected void body(final WorkFlowRun wfRun) {
				wfRun.setState(JobRunState.RUNNING);
				wfRun.setStarted(modelUtils.toXMLDate(new Date()));
				wfRun.setProgress(0);
			}
			
			@Override
			protected void post() {
				dataProvider.commitTransaction();
			}

		}.act();
	}
	
	
	

	@Override
	public void setFinished(final JobRunState state, final Throwable t) {

		new FailSafeCDOAction() {

			@Override
			protected void post() {
				dataProvider.commitTransactionThenClose();
				dataProvider.closeSession();
			}

			@Override
			protected void body(final WorkFlowRun wfRun) {
				if (t != null) {
					wfRun.setState(JobRunState.FINISHED_WITH_ERROR);
					final StringWriter sw = new StringWriter();
					final PrintWriter pw = new PrintWriter(sw);

					t.printStackTrace(pw);

					// Truncate the exception to fix #. chars.
					String newLog = getLog() + "\n" + t.getMessage() + "\n"
							+ sw;
					if (newLog.length() > 0) {
						if (newLog.length() > 20000) {
							wfRun.setLog(newLog.substring(0, 19999)); // Truncate
																		// to
																		// slightly
																		// smaller
																		// than...
						} else {
							wfRun.setLog(newLog);
						}
					}
				} else {
					wfRun.setState(state);
					if (getLog().length() > 0) {
						String string = getLog().toString();
						if (string.length() > 20000) {
							wfRun.setLog(string.substring(0, 19999)); // Truncate
																		// to
																		// slightly
																		// smaller
																		// than...
						} else {
							wfRun.setLog(string);
						}
					}
					wfRun.setProgress(100);
				}
				wfRun.setEnded(modelUtils.toXMLDate(new Date()));
			}
		}.act();
	}

	@Override
	public void update() {

		new FailSafeCDOAction() {

			@Override
			protected void body(final WorkFlowRun wfRun) {
				wfRun.setProgress(getProgress());
				wfRun.setProgressMessage(getMsg());
				wfRun.setProgressTask(getTask());
			}
			
			@Override
			protected void post() {
				dataProvider.commitTransaction();
			}
		}.act();

	}

	@Override
	public void updateFailures(final List<Failure> failures) {
		new FailSafeCDOAction() {

			@Override
			protected void body(WorkFlowRun wfRun) {
				if (wfRun instanceof ComponentWorkFlowRun && failures != null
						&& !failures.isEmpty()) {
					ComponentWorkFlowRun compWfRun = (ComponentWorkFlowRun) wfRun;
					compWfRun.getFailureRefs().addAll(failures);
				} else {
					// Can't save failures in non-component run.
				}
			}
			@Override
			protected void post() {
				dataProvider.commitTransaction();
			}
		}.act();

	}

	@Override
	public void updateLog(final String string) {
		// Update the log.

		new FailSafeCDOAction() {

			@Override
			protected void body(final WorkFlowRun wfRun) {
				wfRun.setLog(getLog() + "\n" + string);
			}
			@Override
			protected void post() {
				dataProvider.commitTransaction();
			}
		}.act();

	}

	/**
	 * CDO session and transaction activities are caught, will not interrupt the
	 * permanent logic.
	 * 
	 * @author Christophe Bouhier
	 */
	abstract class FailSafeCDOAction {

		/**
		 * Calls {@link #pre()} , {@link #body()} , {@link #post()}
		 */
		public void act() {

			try {
				if (pre()) {
					body(wfRun);
					post();
				}else{
					throw new IllegalStateException("Should not happen, wrong state");
				}
			} catch (Throwable t) {
				// Workflow failures are simply ignored.
				if (JobActivator.DEBUG) {
					JobActivator.TRACE.trace(JobActivator.TRACE_JOBS_OPTION,
							"Failure updateing workflow: " + workFlowRunId, t);
				}
			}
		}

		protected abstract void body(final WorkFlowRun wfRun);

		protected boolean pre() {
			return openSession != null && !openSession.isClosed()
					&& wfRun != null && !wfRun.cdoView().isClosed();
		}

		protected void post() {
		}
	}

}
