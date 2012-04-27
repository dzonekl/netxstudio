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
 * Contributors: 
 * 	Martin Taal - initial API and implementation and/or initial documentation
 *******************************************************************************/
package com.netxforge.netxstudio.server;

import java.util.Date;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.cdo.common.commit.CDOCommitInfo;
import org.eclipse.emf.cdo.common.commit.CDOCommitInfoHandler;
import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.common.model.CDOClassInfo;
import org.eclipse.emf.cdo.common.revision.CDOIDAndVersion;
import org.eclipse.emf.cdo.common.revision.CDORevisionKey;
import org.eclipse.emf.cdo.common.revision.delta.CDORevisionDelta;
import org.eclipse.emf.cdo.session.CDOSession;
import org.eclipse.emf.cdo.spi.common.revision.InternalCDORevision;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.ecore.resource.Resource;

import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.generics.ActionType;
import com.netxforge.netxstudio.generics.CommitLogEntry;
import com.netxforge.netxstudio.generics.GenericsFactory;
import com.netxforge.netxstudio.generics.GenericsPackage;
import com.netxforge.netxstudio.server.internal.ServerActivator;

/**
 * Implements the CDO {@link CDOCommitInfoHandler} which stores commit info in
 * the database using {@link CommitLogEntry}.
 * 
 * @author Martin Taal
 */
public class NetxForgeCommitInfoHandler implements CDOCommitInfoHandler {

	@Inject
	ModelUtils modelUtils;

	public synchronized void handleCommitInfo(CDOCommitInfo commitInfo) {
		// don't do this when the server is initializing
		if (ServerUtils.getInstance().isInitializing()) {
			return;
		}

		// don't save commit info
		// check if we are saving the commit info resource
		// if so bail
		for (final CDOIDAndVersion cdoIdAndVersion : commitInfo.getNewObjects()) {
			if (cdoIdAndVersion instanceof InternalCDORevision) {
				if (((InternalCDORevision) cdoIdAndVersion).getEClass() == GenericsPackage.eINSTANCE
						.getCommitLogEntry()) {
					return;
				}
			}
		}
		
		if (commitInfo.getComment() == null) {
			if (ServerActivator.DEBUG) {
				System.out
						.println("COMMIT HANDLER: transaction source unknown (comment not set) for transaction for commit="
								+ commitInfo.toString());
			}
			return;
		}

		// skip server side committing.
		if (commitInfo.getComment() != null
				&& commitInfo.getComment().equals(
						IDataProvider.SERVER_COMMIT_COMMENT)) {
			// do not log server side handling.
			return;
		}



		final XMLGregorianCalendar commitTimeStamp = modelUtils
				.toXMLDate(new Date(commitInfo.getTimeStamp()));
		
		// Do not use our dataprovider. 
		final CDOSession session = ServerUtils.getInstance().openJVMSession();
		final CDOTransaction transaction = session.openTransaction();

		final Resource resource = transaction
				.getOrCreateResource("/CDOCommitInfo_" + commitInfo.getUserID());

		// DELETE
		for (final CDOIDAndVersion cdoIdAndVersion : commitInfo
				.getDetachedObjects()) {
			final CommitLogEntry logEntry = GenericsFactory.eINSTANCE
					.createCommitLogEntry();
			logEntry.setUser(commitInfo.getUserID());
			logEntry.setTimeStamp(commitTimeStamp);
			logEntry.setAction(ActionType.DELETE);
			logEntry.setObjectId(cdoIdAndVersion.toString());
			resource.getContents().add(logEntry);
		}

		// ADD
		for (final CDOIDAndVersion cdoIdAndVersion : commitInfo.getNewObjects()) {
			final CommitLogEntry logEntry = GenericsFactory.eINSTANCE
					.createCommitLogEntry();
			logEntry.setUser(commitInfo.getUserID());
			logEntry.setTimeStamp(commitTimeStamp);
			logEntry.setAction(ActionType.ADD);

			

			if (cdoIdAndVersion instanceof InternalCDORevision) {
				InternalCDORevision icdoRev = (InternalCDORevision) cdoIdAndVersion;
				CDOClassInfo classInfo = icdoRev.getClassInfo();
				logEntry.setObjectId(classInfo.getEClass().getName() + " " + icdoRev.getID()  + "" + icdoRev.getVersion() );
				logEntry.setChange(modelUtils.cdoDumpNewObject(icdoRev));
			}
			resource.getContents().add(logEntry);
		}

		// UPDATE
		for (final CDORevisionKey key : commitInfo.getChangedObjects()) {
			final CDORevisionDelta delta = (CDORevisionDelta) key;

			final CommitLogEntry logEntry = GenericsFactory.eINSTANCE
					.createCommitLogEntry();
			logEntry.setUser(commitInfo.getUserID());
			logEntry.setTimeStamp(commitTimeStamp);
			logEntry.setAction(ActionType.UPDATE);

			CDOID id = delta.getID();

			logEntry.setObjectId(modelUtils.truncate(id.toString()));

			final StringBuilder sb = new StringBuilder();
			modelUtils.cdoDumpFeatureDeltas(sb, delta.getFeatureDeltas());

			logEntry.setChange(modelUtils.truncate(sb.toString()));
			resource.getContents().add(logEntry);
		}
		try {
			transaction.setCommitComment(IDataProvider.COMMITINFO_COMMIT_COMMENT);
			transaction.commit();
			transaction.close();
		} catch (final Exception e) {
			throw new IllegalStateException(e);
		} finally {
			session.close();
		}
	}

}
