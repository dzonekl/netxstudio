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

	@Override
	public void commitTransaction() {
		super.commitTransaction(SERVER_COMMIT_COMMENT);
	}

	@Inject
	public ServerCDODataProvider(@Server ICDOConnection conn) {
		super(conn);
	}

	@Override
	public void openSession(String uid, String passwd) throws SecurityException {
		if (session == null) {
			this.openSession();
		}
	}

	@Override
	protected boolean doGetResourceFromOwnTransaction() {
		return false;
	}
	
	
	// A cached session for this provider. 
	private CDOSession session = null;
	
	// A cached session for this provider. 
	private CDOTransaction transaction = null;
	
	// A cached view for this provider. 
	private CDOView view = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.data.cdo.CDODataProvider#openSession()
	 */
	@Override
	public CDOSession openSession() {
		CDOSession s = super.openSession();
		if (ServerActivator.DEBUG) {
			ServerActivator.TRACE.trace(
					ServerActivator.TRACE_CDO_OPTION,
					"OPEN session ID=" + s.getSessionID()
							+ " , Updated last on:"
							+ new Date(s.getLastUpdateTime()));
		}

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
	public CDOTransaction getTransaction() {
		if (transaction == null) {
			transaction = getSession().openTransaction();
		}
		return transaction;
	}

	@Override
	protected boolean isTransactionSet() {
		return transaction != null;
	}

	@Override
	protected void setSession(CDOSession session) {
		if (session == null) {
			this.session = session;
		}
		if (this.session != null && !this.session.isClosed()) {
			if (ServerActivator.DEBUG) {
				ServerActivator.TRACE.trace(
						ServerActivator.TRACE_CDO_OPTION,
						"SET a session ID="
								+ session.getSessionID());
			}
			this.session.close();
		}
		this.session = session;
	}

	@Override
	protected void setTransaction(CDOTransaction transaction) {
		this.transaction = transaction;
	}
	
	

	/* (non-Javadoc)
	 * @see com.netxforge.netxstudio.data.IDataProvider#closeView()
	 */
	public void closeView() {
		if(this.view != null){
			this.view.close();
			view = null;
		}
	}

	@Override
	public void closeSession() {
		if (session != null) {
			if (ServerActivator.DEBUG) {
				ServerActivator.TRACE.trace(
						ServerActivator.TRACE_CDO_OPTION,
						"CLOSING session ID="
								+ session.getSessionID()
								+ " , Updated last on:"
								+ new Date(session.getLastUpdateTime()));
				// Thread.dumpStack();
			}
			session.close();
		}
	}

	@Override
	public CDOView getView() {
		if (view == null) {
			this.view = this.getSession().openView();
		}
		return view;
	}

}
