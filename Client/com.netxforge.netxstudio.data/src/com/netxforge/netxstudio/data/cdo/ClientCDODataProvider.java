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

import org.eclipse.emf.cdo.session.CDOSession;
import org.eclipse.emf.cdo.transaction.CDOTransaction;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * A CDO Data provider, for single threaded clients. The session and transaction
 * are stored in a static member and this object is a singleton.
 * 
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 */
@Singleton
public class ClientCDODataProvider extends CDODataProvider {

	@Inject
	public ClientCDODataProvider(ICDOConnection conn) {
		super(conn);
	}

	private static CDOSession session = null;

	private static CDOTransaction transaction = null;

	@Override
	public CDOSession getSession() {
		if (session == null) {
			// We can't get a session, which has not be opened and
			// authenticated.
			throw new java.lang.IllegalStateException();
		} else {
			// System.out.println("Currrent session instance:"
			// + clientSession.toString());
			return session;
		}
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
		ClientCDODataProvider.session = session;
	}

	@Override
	protected void setTransaction(CDOTransaction transaction) {
		ClientCDODataProvider.transaction = transaction;
	}

}
