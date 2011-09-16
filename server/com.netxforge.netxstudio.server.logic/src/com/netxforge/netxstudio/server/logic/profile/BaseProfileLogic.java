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
package com.netxforge.netxstudio.server.logic.profile;

import java.util.List;

import com.netxforge.netxstudio.scheduling.ComponentWorkFlowRun;
import com.netxforge.netxstudio.scheduling.Failure;
import com.netxforge.netxstudio.scheduling.JobRunState;
import com.netxforge.netxstudio.server.logic.BasePeriodLogic;
import com.netxforge.netxstudio.server.logic.LogicActivator;
import com.netxforge.netxstudio.services.ServiceUser;

/**
 * Performs the resource monitoring logic execution for a RFSService.
 * 
 * @author Martin Taal
 */
public abstract class BaseProfileLogic extends BasePeriodLogic {

	private ProfileEngine engine;

	@Override
	protected ProfileEngine getEngine() {
		if (engine == null) {
			engine = LogicActivator.getInstance().getInjector()
					.getInstance(ProfileEngine.class);
		}
		return engine;
	}

	public void run() {
		try {
			doRun();
			if (getFailures().isEmpty()) {
				this.getJobMonitor().setFinished(
						JobRunState.FINISHED_SUCCESSFULLY, null);
			} else {
				this.getJobMonitor().setFinished(
						JobRunState.FINISHED_WITH_ERROR, null);
			}
		} catch (final Throwable t) {
			this.getJobMonitor()
					.setFinished(JobRunState.FINISHED_WITH_ERROR, t);
		}
	}

	protected void doRun() {
		// start a transaction
		this.getDataProvider().getTransaction();
		final List<ServiceUser> serviceUsers = this.getServiceUsersToExecuteFor();

		this.getJobMonitor().setTotalWork(serviceUsers.size());
		this.getJobMonitor().setTask("Performing resource monitoring");

		for (final ServiceUser su : serviceUsers) {

			getJobMonitor().appendToLog(
					"Computing for service user "
							+ su.getName());

			getJobMonitor().setTask("Profile for service users");
			processServiceUser(su);
		}
		if (!getFailures().isEmpty()) {
			final ComponentWorkFlowRun run = (ComponentWorkFlowRun) this
					.getDataProvider().getTransaction()
					.getObject(this.getJobMonitor().getWorkFlowRunId());
			for (Failure f : getFailures()) {
					run.getFailureRefs().add(f);
			}

		}
		this.getDataProvider().commitTransaction();
	}

	protected abstract List<ServiceUser> getServiceUsersToExecuteFor();
	
	protected void processServiceUser(ServiceUser serviceUser) {
		
		this.getJobMonitor().setTask("Computing for " + serviceUser.getName());
		this.getJobMonitor().incrementProgress(1, false);
		final ProfileEngine engine = getEngine();
		engine.setJobMonitor(getJobMonitor());
		engine.setServiceUser(serviceUser);
		engine.setDataProvider(this.getDataProvider());
		engine.setPeriod(getTimeRange());
		engine.execute();
		if (engine.getFailures().size() > 0) {
			for (final Failure failure : engine.getFailures()) {
				
				// TODO Add the Service User here. 
//				failure.setComponentRef(component);
				this.getFailures().add(failure);
			}
		}
	}
	
}
