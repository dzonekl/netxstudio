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
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.cdo.common.commit.CDOCommitInfo;
import org.eclipse.emf.cdo.common.commit.CDOCommitInfoHandler;
import org.eclipse.emf.cdo.common.revision.CDOIDAndVersion;
import org.eclipse.emf.cdo.common.revision.CDORevisionKey;
import org.eclipse.emf.cdo.common.revision.delta.CDOFeatureDelta;
import org.eclipse.emf.cdo.common.revision.delta.CDOListFeatureDelta;
import org.eclipse.emf.cdo.common.revision.delta.CDORevisionDelta;
import org.eclipse.emf.cdo.session.CDOSession;
import org.eclipse.emf.cdo.spi.common.revision.InternalCDORevision;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

import com.netxforge.netxstudio.generics.ActionType;
import com.netxforge.netxstudio.generics.CommitLogEntry;
import com.netxforge.netxstudio.generics.GenericsFactory;
import com.netxforge.netxstudio.generics.GenericsPackage;

/**
 * Implements the CDO {@link CDOCommitInfoHandler} which stores commit info in
 * the database using {@link CommitLogEntry}.
 * 
 * @author Martin Taal
 */
public class NetxForgeCommitInfoHandler implements CDOCommitInfoHandler {

	private static final int MAX_CHANGE_LENGTH = 2000;

	@Override
	public synchronized void handleCommitInfo(CDOCommitInfo commitInfo) {
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

		final XMLGregorianCalendar commitTimeStamp = ServerUtils.getInstance()
				.getXMLGregorianCalendarDate(
						new Date(commitInfo.getTimeStamp()));
		final CDOSession session = ServerUtils.getInstance().openJVMSession();
		final CDOTransaction transaction = session.openTransaction();
		final Resource resource = transaction
				.getOrCreateResource("CDOCommitInfo_" + commitInfo.getUserID());
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

		for (final CDOIDAndVersion cdoIdAndVersion : commitInfo.getNewObjects()) {
			final CommitLogEntry logEntry = GenericsFactory.eINSTANCE
					.createCommitLogEntry();
			logEntry.setUser(commitInfo.getUserID());
			logEntry.setTimeStamp(commitTimeStamp);
			logEntry.setAction(ActionType.ADD);
			logEntry.setObjectId(cdoIdAndVersion.toString());
			if (cdoIdAndVersion instanceof InternalCDORevision) {
				logEntry.setChange(dumpNewObject((InternalCDORevision) cdoIdAndVersion));
			}
			resource.getContents().add(logEntry);
		}

		for (final CDORevisionKey key : commitInfo.getChangedObjects()) {
			final CDORevisionDelta delta = (CDORevisionDelta) key;
			final CommitLogEntry logEntry = GenericsFactory.eINSTANCE
					.createCommitLogEntry();
			logEntry.setUser(commitInfo.getUserID());
			logEntry.setTimeStamp(commitTimeStamp);
			logEntry.setAction(ActionType.UPDATE);
			logEntry.setObjectId(key.toString());
			final StringBuilder sb = new StringBuilder();
			dumpFeatureDeltas(sb, delta.getFeatureDeltas());
			logEntry.setChange(trunc(sb.toString()));
			resource.getContents().add(logEntry);
		}
		try {
			transaction.commit();
			transaction.close();
		} catch (final Exception e) {
			throw new IllegalStateException(e);
		} finally {
			session.close();
		}
	}

	private String dumpNewObject(InternalCDORevision revision) {
		final StringBuilder sb = new StringBuilder();
		for (final EStructuralFeature feature : revision.getClassInfo()
				.getAllPersistentFeatures()) {
			final Object value = revision.getValue(feature);
			dumpFeature(sb, feature, value);
		}
		return trunc(sb.toString());
	}

	private void dumpFeatureDeltas(StringBuilder sb,
			List<CDOFeatureDelta> featureDeltas) {
		for (final CDOFeatureDelta featureDelta : featureDeltas) {
			if (featureDelta instanceof CDOListFeatureDelta) {
				final CDOListFeatureDelta list = (CDOListFeatureDelta) featureDelta;
				dumpFeatureDeltas(sb, list.getListChanges());
			} else {
				dumpFeature(sb, featureDelta.getFeature(), featureDelta);
			}
		}
	}

	private void dumpFeature(StringBuilder sb, EStructuralFeature feature,
			Object value) {
		addNewLine(sb);
		sb.append(feature.getName() + " = " + value);
	}

	private void dumpFeature(StringBuilder sb, EStructuralFeature feature,
			CDOFeatureDelta value) {
		addNewLine(sb);
		sb.append(feature.getName() + " = " + printCDOFeatureDelta(value));
	}
	
	private String printCDOFeatureDelta(CDOFeatureDelta delta) {
		String str = delta.toString();
		if (str.indexOf(",") != -1) {
			// do + 2 to get of one space
			str= str.substring(str.indexOf(",") + 2);
		}
		// and get rid of the ] at the end
		return str.substring(0, str.length() - 1);
	}
	
	
	private void addNewLine(StringBuilder sb) {
		if (sb.length() > 0) {
			sb.append("\n");
		}
	}

	private String trunc(String value) {
		if (value.length() >= MAX_CHANGE_LENGTH) {
			return value.substring(0, MAX_CHANGE_LENGTH);
		}
		return value;
	}
}
