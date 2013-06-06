/*******************************************************************************
 * Copyright (c) 28 dec. 2012 NetXForge.
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
package com.netxforge.scoping;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;

import com.google.inject.Inject;

/**
 * Defines a {@link ScopingJob} which initializes the
 * {@link IResourceDescriptions } in {@link DynamixCDOScopeProvider}.
 * 
 * @author Christophe Bouhier
 */
public class CDOScopeScheduler {

	private IGlobalScopeProvider scopeProvider;

	@Inject
	public CDOScopeScheduler(IGlobalScopeProvider scopeProvider) {
		this.scopeProvider = scopeProvider;
	}

	public void scheduleInitialLoading() {
		ScopingJob scopingJob = new ScopingJob("Indexing Configurations...");
		// j.addJobChangeListener(this);
		scopingJob.schedule(10000); // Run after 10 seconds, of launching the
									// client.
	}

	/**
	 * Job which invokes our Global scope provider.
	 * 
	 * @author Christophe Bouhier
	 */
	protected class ScopingJob extends Job {
		public ScopingJob(String name) {
			super(name);

			// Should not be a user job, if we are server.....
			if (scopeProvider instanceof DynamixCDOScopeProvider) {
				
				// TODO, Find an alternative for isServer, as this puts a dependency on the UI implementation. 
				if (!((DynamixCDOScopeProvider) scopeProvider).isServer()) {
					super.setUser(true);
				}
			}
		}

		@Override
		protected IStatus run(IProgressMonitor monitor) {

			scopingInitializeInternal();

			return Status.OK_STATUS;
		}

		private void scopingInitializeInternal() {
			if (scopeProvider == null) {
				throw new IllegalStateException(" Injection error");
			}

			if (scopeProvider instanceof DynamixCDOScopeProvider) {
				((DynamixCDOScopeProvider) scopeProvider).initDescriptions();
			}
		}
	}

}
