/*******************************************************************************
 * Copyright (c) May 12, 2011 NetXForge.
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
 * Contributors:
 *    Christophe Bouhier - initial API and implementation and/or initial documentation
 *******************************************************************************/
package com.netxforge.netxstudio.server;

import java.util.Date;

import org.eclipse.emf.cdo.session.CDOSession;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.net4j.util.event.IEvent;
import org.eclipse.net4j.util.event.IListener;
import org.eclipse.net4j.util.lifecycle.ILifecycleEvent.Kind;
import org.eclipse.net4j.util.lifecycle.LifecycleEvent;

import com.google.inject.Inject;
import com.netxforge.netxstudio.data.cdo.CDODataProvider;
import com.netxforge.netxstudio.data.cdo.ICDOConnection;
import com.netxforge.netxstudio.server.internal.ServerActivator;

/**
 * Uses a jvm connection to connect to the repository.
 * 
 * @author Martin Taal
 */
public class ServerCDODataProvider extends CDODataProvider {

	// A cached session for this provider.
	private CDOSession session = null;

	// A cached session for this provider.
	private CDOTransaction transaction = null;

	// A cached view for this provider.
	private CDOView view = null;

	/**
	 * Log sessions information, adding caller information.
	 */
	private SessionLog sessionLog;

	@Inject
	public ServerCDODataProvider(@Server ICDOConnection conn) {
		super(conn);
		sessionLog = new SessionLog();
	}

	@Override
	public void openSession(String uid, String passwd) throws SecurityException {
		if (session == null) {
			this.openSession();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.data.cdo.CDODataProvider#openSession()
	 */
	@Override
	public CDOSession openSession() {
		CDOSession s = super.openSession();
		sessionLog.logOpenSession(s);
		return s;
	}

	@Override
	public CDOSession getSession() {
		if (session == null) {
			this.openSession();
		}
		return session;
	}

	@Override
	public void closeSession() {
		if (session != null) {
			sessionLog.logCloseSession(session);
			session.close();
			session = null;
		}
	}

	@Override
	public CDOView getView() {

		if (view == null || view.isClosed()) {
			view = getSession().openView();
			sessionLog.logGetNewView(view);
		} else {
			sessionLog.logGetCachedView(view);
		}

		return view;
	}

	public void closeView() {
		if (view != null) {
			sessionLog.logCloseView(view);
			view.close();
			view = null;
		}
	}

	@Override
	protected boolean doGetResourceFromOwnTransaction() {
		return false;
	}

	@Override
	public CDOTransaction getTransaction() {

		if (transaction == null || transaction.isClosed()) {
			// This will open a new session.
			transaction = getSession().openTransaction();
			// In case we loose our sessions, clear the session.
			transaction.getSession().addListener(new IListener() {

				public void notifyEvent(IEvent event) {
					if (event instanceof LifecycleEvent) {
						final LifecycleEvent lfEvent = (LifecycleEvent) event;
						if (lfEvent.getKind() == Kind.ABOUT_TO_DEACTIVATE) {
							// OK our session will be closed.
							sessionLog.logLifecycle(lfEvent);
						}
					}
				}
			});
			sessionLog.logGetNewTransaction(transaction);
		} else {
			sessionLog.logGetCachedTransaction(transaction);
		}
		return transaction;
	}

	@Override
	public void commitTransactionThenClose() {
		sessionLog.logCommitTransactionThenClose(transaction);
		super.commitTransaction(SERVER_COMMIT_COMMENT, true);
	}

	@Override
	public void commitTransaction() {
		sessionLog.logCommitTransaction(transaction);
		super.commitTransaction(SERVER_COMMIT_COMMENT, false);
	}

	@Override
	protected void setSession(CDOSession session) {
		if (session == null) {
			this.session = session;
		} else if (this.session != null && !this.session.isClosed()) {
			if (ServerActivator.DEBUG) {
				ServerActivator.TRACE.trace(
						ServerActivator.TRACE_SERVER_CDO_OPTION,
						"SET a session ID=" + session.getSessionID());
			}
			this.session.close();
		}
		this.session = session;
	}

	@Override
	protected boolean isTransactionSet() {
		return transaction != null;
	}

	@Override
	protected void setTransaction(CDOTransaction transaction) {
		this.transaction = transaction;
	}

	class SessionLog {

		// Session
		void logOpenSession(CDOSession session) {
			if (ServerActivator.DEBUG) {
				logStack(ServerActivator.TRACE_SERVER_CDO_SESSION);
				ServerActivator.TRACE.trace(
						ServerActivator.TRACE_SERVER_CDO_SESSION,
						"OPEN session ID=" + session.getSessionID());
			}
		}

		public void logLifecycle(LifecycleEvent lfEvent) {
			if (ServerActivator.DEBUG) {
				logStack(ServerActivator.TRACE_SERVER_CDO_SESSION);
				ServerActivator.TRACE.trace(
						ServerActivator.TRACE_SERVER_CDO_SESSION,
						"DEACTIVATE lifecycle: " + lfEvent.toString());
			}
			
		}

		void logCloseSession(CDOSession session) {
			if (ServerActivator.DEBUG) {
				logStack(ServerActivator.TRACE_SERVER_CDO_SESSION);
				ServerActivator.TRACE.trace(
						ServerActivator.TRACE_SERVER_CDO_SESSION,
						"CLOSING session ID=" + session.getSessionID()
								+ " , Updated last on:"
								+ new Date(session.getLastUpdateTime()));
			}
		}

		// View
		void logGetNewView(CDOView view) {
			if (ServerActivator.DEBUG) {
				logStack(ServerActivator.TRACE_SERVER_CDO_VIEW);
				ServerActivator.TRACE.trace(
						ServerActivator.TRACE_SERVER_CDO_VIEW, "NEW view ID="
								+ view.getViewID());
			}
		}

		void logGetCachedView(CDOView view) {
			if (ServerActivator.DEBUG) {
				logStack(ServerActivator.TRACE_SERVER_CDO_VIEW);
				ServerActivator.TRACE.trace(
						ServerActivator.TRACE_SERVER_CDO_VIEW,
						"CACHED view ID=" + view.getViewID());
			}
		}

		public void logCloseView(CDOView view) {
			if (ServerActivator.DEBUG) {
				logStack(ServerActivator.TRACE_SERVER_CDO_VIEW);
				ServerActivator.TRACE.trace(
						ServerActivator.TRACE_SERVER_CDO_VIEW, "CLOSE view ID="
								+ view.getViewID());
			}
		}

		// Transaction

		void logGetNewTransaction(CDOTransaction transaction) {
			if (ServerActivator.DEBUG) {
				logStack(ServerActivator.TRACE_SERVER_CDO_TRANSACTION);
				ServerActivator.TRACE.trace(
						ServerActivator.TRACE_SERVER_CDO_TRANSACTION,
						"NEW transaction ID=" + transaction.getViewID());
			}
		}

		public void logGetCachedTransaction(CDOTransaction transaction) {
			if (ServerActivator.DEBUG) {
				logStack(ServerActivator.TRACE_SERVER_CDO_TRANSACTION);
				ServerActivator.TRACE.trace(
						ServerActivator.TRACE_SERVER_CDO_TRANSACTION,
						"CACHED transaction ID=" + transaction.getViewID());
			}
		}

		public void logCommitTransaction(CDOTransaction transaction) {
			if (ServerActivator.DEBUG) {
				if (transaction != null) {
					logStack(ServerActivator.TRACE_SERVER_CDO_TRANSACTION);
					ServerActivator.TRACE
							.trace(ServerActivator.TRACE_SERVER_CDO_TRANSACTION,
									"COMMIT transaction ID="
											+ transaction.getViewID()
											+ " , Updated last on:"
											+ new Date(transaction
													.getLastCommitTime()));
				} else {
					ServerActivator.TRACE.trace(
							ServerActivator.TRACE_SERVER_CDO_TRANSACTION,
							"COMMIT transaction ID="
									+ "? (New transaction will be created)");
				}
			}
		}

		void logCommitTransactionThenClose(CDOTransaction transaction) {
			if (ServerActivator.DEBUG) {
				logStack(ServerActivator.TRACE_SERVER_CDO_TRANSACTION);
				if (transaction != null) {
					ServerActivator.TRACE
							.trace(ServerActivator.TRACE_SERVER_CDO_TRANSACTION,
									"COMMIT transaction ID="
											+ transaction.getViewID()
											+ " , Updated last on:"
											+ new Date(transaction
													.getLastCommitTime()));
				} else {
					ServerActivator.TRACE.trace(
							ServerActivator.TRACE_SERVER_CDO_TRANSACTION,
							"COMMIT transaction ID="
									+ "? (New transaction will be created)");
				}
			}
		}

		private void logStack(String traceOption) {
			String thisName = ServerCDODataProvider.this.getClass().getName();
			String parentName = CDODataProvider.class.getName();
			String logName = SessionLog.class.getName();
			String thisNameNested = this.getClass().getName();
			StackTraceElement[] stackTrace = new Throwable().getStackTrace();
			// move up the trace until, we are not this.
			for (StackTraceElement e : stackTrace) {
				String stackEntryClassName = e.getClassName();
				if (!stackEntryClassName.equals(thisNameNested)
						&& !stackEntryClassName.equals(thisName)
						&& !stackEntryClassName.equals(parentName)
						&& !stackEntryClassName.equals(logName)) {
					String msg = e.toString();
					if (!msg.isEmpty()) {
						ServerActivator.TRACE.trace(traceOption, msg);
					}
					break;
				}
			}
		}
	}
}
