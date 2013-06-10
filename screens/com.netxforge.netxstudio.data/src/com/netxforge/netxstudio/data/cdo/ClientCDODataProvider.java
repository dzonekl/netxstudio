/*******************************************************************************
 * Copyright (c) May 3, 2011 NetXForge.
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
package com.netxforge.netxstudio.data.cdo;

import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.session.CDOSession;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.ecore.resource.Resource;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.data.internal.DataActivator;

/**
 * A CDO Data provider, for single threaded clients. The session and transaction
 * are stored in a static member and this object is a singleton.
 * 
 * CB TODO If a singleton, why a static session, we will always return the same
 * session?
 * 
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 */
@Singleton
public class ClientCDODataProvider extends CDODataProvider {

	@Inject
	ModelUtils modelUtils;

	@Inject
	public ClientCDODataProvider(ICDOConnection conn) {
		super(conn);
	}

	private static CDOSession session = null;

	private static CDOTransaction transaction = null;

	private CDOView view = null;

	@Override
	public CDOSession getSession() {
		if (session == null || session.isClosed()) {
			// We can't get a session, which has not be opened and
			// authenticated.

			throw new java.lang.IllegalStateException(
					session == null ? "Session closed" : "Session not set");
		} else {
			if (DataActivator.DEBUG) {
				this.printSession();
			}
			return session;
		}
	}

	@Override
	public CDOTransaction getTransaction() {
		if (transaction == null) {
			transaction = getSession().openTransaction();
			if(DataActivator.DEBUG){
				DataActivator.TRACE.trace(DataActivator.TRACE_DATA_OPTION, "Created transaction with ID: " + transaction.getViewID());
			}
		}else{
			if(DataActivator.DEBUG){
				DataActivator.TRACE.trace(DataActivator.TRACE_DATA_OPTION, "Accessing transaction with ID: " + transaction.getViewID());
			}
		}
		return transaction;
	}

	@Override
	protected boolean isTransactionSet() {
		return transaction != null;
	}

	@Override
	protected void setSession(CDOSession session) {
		ClientCDODataProvider.session = session;
	}

	@Override
	protected void setTransaction(CDOTransaction transaction) {
		ClientCDODataProvider.transaction = transaction;
	}

	public void printSession() {

		if (session.isClosed()) {
			DataActivator.TRACE.trace(DataActivator.TRACE_DATA_DETAILS_OPTION,
					"Session closed!, can not provide views or transactions");
			return;
		}

		// Report the transactions on our session:
		CDOView[] views = session.getElements();
		for (int i = 0; i < views.length; i++) {
			CDOView v = views[i];
			if (v instanceof CDOTransaction) {
				CDOTransaction t = (CDOTransaction) v;
				DataActivator.TRACE.trace(
						DataActivator.TRACE_DATA_DETAILS_OPTION,
						"transaction ID: " + t.getViewID()
								+ " ResourceSet hashcode:"
								+ v.getResourceSet().hashCode());
			} else {
				DataActivator.TRACE.trace(
						DataActivator.TRACE_DATA_DETAILS_OPTION, "view ID: "
								+ v.getViewID() + " ResourceSet hashcode:"
								+ v.getResourceSet().hashCode());

			}
			for (Resource res : v.getResourceSet().getResources()) {
				if (res instanceof CDOResource) {
					DataActivator.TRACE.trace(
							DataActivator.TRACE_DATA_DETAILS_OPTION,
							"  Resource for set = " + res.getURI());
				}
			}
		}
		if (views.length > 0) {
			DataActivator.TRACE.trace(DataActivator.TRACE_DATA_DETAILS_OPTION,
					"Number of views/transactions:"
							+ session.getElements().length);
		}
	}
	
	@Override
	public CDOView getView() {
		if (view == null) {
			view = this.getSession().openView();
		}
		return view;
	}

	public void closeView() {
		if (this.view != null) {
			this.view.close();
			view = null;
		}
	}

}
