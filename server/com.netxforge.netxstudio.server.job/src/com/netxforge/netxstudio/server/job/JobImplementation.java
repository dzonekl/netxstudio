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

import java.util.HashMap;
import java.util.Map;

import com.google.inject.Inject;
import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.scheduling.Job;
import com.netxforge.netxstudio.scheduling.JobRunState;
import com.netxforge.netxstudio.server.Server;

/**
 * Defines the JobImplementation which can be implemented by other plugins.
 * Other plugins register a factory for the type of job which can be run.
 * 
 * @author Martin Taal
 */
public abstract class JobImplementation {

	public static final JobImplementationFactoryRegistry REGISTRY = new JobImplementationFactoryRegistry();

	@Inject
	@Server
	private IDataProvider dataProvider;

	private NetxForgeJob netxForgeJob;
	private StringBuilder log = new StringBuilder();

	public abstract void run();

	public NetxForgeJob getNetxForgeJob() {
		return netxForgeJob;
	}

	public void setNetxForgeJob(NetxForgeJob netxForgeJob) {
		this.netxForgeJob = netxForgeJob;
	}

	protected IDataProvider getDataProvider() {
		return dataProvider;
	}

	protected void appendToLog(String logStatement) {
		log.append("\n" + logStatement);
	}

	public String getLog() {
		return log.toString();
	}

	public JobRunState getJobRunState() {
		return JobRunState.FINISHED_SUCCESSFULLY;
	}

	public static abstract class JobImplementationFactory {
		public abstract JobImplementation create();
	}

	public static class JobImplementationFactoryRegistry {
		private Map<Class<? extends Job>, JobImplementationFactory> factories = new HashMap<Class<? extends Job>, JobImplementation.JobImplementationFactory>();

		public void register(Class<? extends Job> clz,
				JobImplementationFactory factory) {
			if (factories.containsKey(clz)) {
				throw new IllegalArgumentException(
						"Already a factory registered for job type " + clz);
			}
			factories.put(clz, factory);
		}

		public JobImplementationFactory getFactory(Class<? extends Job> clz) {
			final JobImplementationFactory factory = factories.get(clz);
			if (factory == null) {
				throw new IllegalArgumentException(
						"No factory found for job type " + clz);
			}
			return factory;
		}
	}

}