package com.netxforge.scoping;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;

import com.google.inject.Inject;

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
	 * @author Christophe
	 */
	protected class ScopingJob extends Job {
		public ScopingJob(String name) {
			super(name);
			
			// Should not be a user job, if we are server.....
			if(scopeProvider instanceof DynamixCDOScopeProvider){
				if( !((DynamixCDOScopeProvider) scopeProvider).isServer()){
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
