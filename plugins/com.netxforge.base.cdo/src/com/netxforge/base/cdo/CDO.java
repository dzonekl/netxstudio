/*******************************************************************************
 * Copyright (c) Nov 2, 2012 NetXForge.
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
package com.netxforge.base.cdo;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.CDOState;
import org.eclipse.emf.cdo.common.branch.CDOBranchVersion;
import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.common.id.CDOIDUtil;
import org.eclipse.emf.cdo.common.model.CDOClassifierRef;
import org.eclipse.emf.cdo.common.revision.CDORevision;
import org.eclipse.emf.cdo.common.revision.delta.CDOAddFeatureDelta;
import org.eclipse.emf.cdo.common.revision.delta.CDOFeatureDelta;
import org.eclipse.emf.cdo.common.revision.delta.CDOFeatureDelta.Type;
import org.eclipse.emf.cdo.common.revision.delta.CDOListFeatureDelta;
import org.eclipse.emf.cdo.common.revision.delta.CDORemoveFeatureDelta;
import org.eclipse.emf.cdo.common.revision.delta.CDORevisionDelta;
import org.eclipse.emf.cdo.common.revision.delta.CDOSetFeatureDelta;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.spi.common.revision.InternalCDORevision;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.util.CDOUtil;
import org.eclipse.emf.cdo.util.ObjectNotFoundException;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.spi.cdo.FSMUtil;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.netxforge.base.NonModelUtils;

public class CDO {

	/**
	 * CDO Object equality, is not customized {@link CDOObject#equals(Object)
	 * see equals()} when two CDOObjects with same OID are compared with '=='
	 * will result in false if either is read by a different CDOTransaction. A
	 * dedicated comparator will compare the OID's, even if from different
	 * transactions. </br> The {@link CDOState} of the objects is required to be
	 * {@link CDOState#CLEAN clean} (Object is state {@link CDOState#NEW new}
	 * and {@link CDOState#TRANSIENT transient} have a temporary OID} which
	 * makes comparison superfluous)
	 * 
	 * @author Christophe Bouhier
	 */
	public static boolean cdoOIDEquals(CDOObject o1, CDOObject o2) {
		if (FSMUtil.isClean(o1) && FSMUtil.isClean(o2)) {
			return o1.cdoID().equals(o2.cdoID());
		}
		return false;
	}

	/**
	 * A Predicate which checks equality of a target {@link CDOObject object}
	 * which delegates to {@link #cdoOIDEquals}
	 * 
	 * @author Christophe Bouhier
	 * 
	 */
	public static class CDOObjectEqualsPredicate implements
			Predicate<CDOObject> {
		private final CDOObject target;

		public CDOObjectEqualsPredicate(CDOObject target) {
			this.target = target;
		}

		public boolean apply(CDOObject test) {
			return cdoOIDEquals(target, test);
		}
	}

	/**
	 * Cleans state references by iterating over a collection and
	 * 
	 * @param eo
	 * @param feature
	 */
	public static void findAndCleanONFE(EObject eo, EStructuralFeature feature) {

		if (feature instanceof EReference) {
			Object eGet = eo.eGet(feature);

			if (feature.isMany()) {
				if (eGet instanceof List<?>) {
					List<?> refs = (List<?>) eGet;
					boolean stillONF = true;

					// Keeps going until no more stale references.
					RESTART_ONFE_CHECK: while (stillONF) {
						for (int i = 0; i < refs.size(); i++) {
							try {
								Object object = refs.get(i);
								System.out.println("ONFE check for: " + object
										+ " is it proxy?");
								if (object instanceof CDOObject) {
								}
								// catch the onfe.
							} catch (ObjectNotFoundException exception) {

								System.out.println("ONFE detected, Reference: "
										+ eo + " feature: " + feature
										+ " index: " + i);

								CDOUtil.cleanStaleReference(eo, feature, i);

								System.out.println("ONFE cleaned, Reference: "
										+ eo + " feature: " + feature
										+ " index: " + i);
								break RESTART_ONFE_CHECK;
							}
						}
						stillONF = false;
					}
				}
			}
		}
	}

	/**
	 * calls {@link CDOIDUtil#getLong(CDOID)} on the {@link CDOID}.
	 * 
	 * @param cdoObject
	 * @return
	 */
	public static String cdoLongIDAsString(CDOObject cdoObject) {
		return cdoLongIDAsString(cdoObject.cdoID());
	}

	/**
	 * calls {@link CDOIDUtil#getLong(CDOID)} on the {@link CDOID}.
	 * 
	 * @param cdoObject
	 * @return
	 */
	public static String cdoLongIDAsString(CDOID cdoID) {
		long lValue = CDOIDUtil.getLong(cdoID);
		return new Long(lValue).toString();
	}

	/**
	 * 
	 * @param eClass
	 * @param cdoString
	 * @return
	 */
	public static CDOID cdoLongIDFromString(EClass eClass, String cdoString) {
		return CDOIDUtil.createLongWithClassifier(new CDOClassifierRef(eClass),
				Long.parseLong(cdoString));
	}

	public static CDOID cdoLongIDFromString(String idString) {
		return CDOIDUtil.createLong(Long.parseLong(idString));
	}

	/**
	 * Get a CDOID for a String representing the Object ID.
	 * 
	 * @param s
	 * @return
	 */
	public static CDOID cdoStringAsCDOID(String s) {
		return CDOIDUtil.createLong(Long.parseLong(s));
	}

	public static String cdoResourcePath(CDOObject cdoObject) {
		if (cdoObject.eResource() != null) {
			Resource eResource = cdoObject.eResource();
			if (eResource instanceof CDOResource) {
				CDOResource cdoR = (CDOResource) eResource;
				return cdoR.getPath();
			}
		}
		return null;
	}

	/**
	 * Get all revisions from this object.
	 * 
	 * @param cdoObject
	 * @return
	 */
	public static Iterator<CDORevision> cdoRevisions(CDOObject cdoObject) {

		List<CDORevision> revisions = Lists.newArrayList();

		CDORevision cdoRevision = cdoObject.cdoRevision();
		// get the previous.
		for (int version = cdoRevision.getVersion(); version > 0; version--) {

			CDOBranchVersion branchVersion = cdoRevision.getBranch()
					.getVersion(version);

			CDORevision revision = cdoObject
					.cdoView()
					.getSession()
					.getRevisionManager()
					.getRevisionByVersion(cdoObject.cdoID(), branchVersion, 0,
							true);
			revisions.add(revision);
		}
		return revisions.iterator();
	}

	/**
	 * Make a string representation of a CDO Object.
	 * 
	 * @param next
	 * @return
	 */
	public static String cdoObjectToString(CDOObject cdoObject,
			String objectText) {
		StringBuffer sb = new StringBuffer();

		CDORevision cdoRevision = cdoObject.cdoRevision();
		int version = -1;
		if (cdoRevision != null) {
			version = cdoRevision.getVersion();
		}
		CDOID cdoID = cdoObject.cdoID();
		CDOResource cdoResource = cdoObject.cdoResource();

		sb.append(objectText + " ");

		// Depending on the state, transient don't have an Object. ID>
		if (cdoID != null) {
			sb.append("OID: " + cdoID + " ");
		}
		if (version != -1) {
			sb.append("version: " + version + " ");
		}

		sb.append("state: " + cdoObject.cdoState() + " ");

		if (cdoResource != null) {
			sb.append("path: " + cdoResource.getPath());
		}

		return sb.toString();
	}

	/**
	 * Dump the content of a CDORevision. Iterates through the features of the
	 * revision, and gets the value of the object. The String will not exceed a
	 * maximum change length.
	 * 
	 * @param revision
	 * @return
	 */
	public static String cdoDumpNewObject(InternalCDORevision revision) {
		final StringBuilder sb = new StringBuilder();
		for (final EStructuralFeature feature : revision.getClassInfo()
				.getAllPersistentFeatures()) {
			final Object value = revision.getValue(feature);
			NonModelUtils.cdoDumpFeature(sb, feature, value);
		}
		return NonModelUtils.truncate(sb.toString());
	}

	/**
	 * For each {@link CDOFeatureDelta} in the collection, dump the feature
	 * delta content to the StringBuffer.
	 * 
	 * @param sb
	 * @param featureDeltas
	 */
	public static void cdoDumpFeatureDeltas(StringBuilder sb,
			List<CDOFeatureDelta> featureDeltas) {
		for (final CDOFeatureDelta featureDelta : featureDeltas) {
			if (featureDelta instanceof CDOListFeatureDelta) {
				final CDOListFeatureDelta list = (CDOListFeatureDelta) featureDelta;
				cdoDumpFeatureDeltas(sb, list.getListChanges());
			} else {
				cdoDumpFeature(sb, featureDelta);
			}
		}
	}

	public static void cdoDumpFeature(StringBuilder sb,
			CDOFeatureDelta featureDelta) {
		NonModelUtils.addNewLine(sb);
		sb.append(featureDelta.getFeature().getName() + " = "
				+ cdoPrintFeatureDelta(featureDelta));
	}

	public static String cdoPrintFeatureDelta(CDOFeatureDelta delta) {
		String str = delta.toString();
		if (str.indexOf(",") != -1) {
			// do + 2 to get of one space
			str = str.substring(str.indexOf(",") + 2);
		}
		// and get rid of the ] at the end
		return str.substring(0, str.length() - 1);
	}

	public static CDOObject cdoObject(CDOObject currentObject,
			CDORevision cdoRevision) {
		CDOView revView = currentObject.cdoView().getSession().openView();
		boolean revViewOk = revView.setTimeStamp(cdoRevision.getTimeStamp());
		if (revViewOk) {
			CDOObject object = revView.getObject(cdoRevision.getID());
			return object;
		}
		return null;
	}

	public static void cdoDumpRevisionDelta(CDORevisionDelta delta) {
		for (CDOFeatureDelta fd : delta.getFeatureDeltas()) {
			System.out.println("-- delta=" + fd);
		}
	}

	/**
	 * Print the {@link CDORevisionDelta Revision delta} to a
	 * {@link StringBuffer}, for a {@link CDOTransaction transaction}. The
	 * content will contain information from {@link CDOFeatureDelta the feature
	 * delta(s)}
	 * 
	 * @param sb
	 * @param transaction
	 */
	public static void cdoPrintRevisionDeltas(StringBuffer sb,
			CDOTransaction transaction) {
		Map<CDOID, CDORevisionDelta> revisionDeltas = transaction
				.getRevisionDeltas();
		for (CDORevisionDelta delta : revisionDeltas.values()) {
			for (CDOFeatureDelta fd : delta.getFeatureDeltas()) {
				sb.append("\n delta: " + fd);
			}
		}
	}

	public static void cdoPrintFeatureDeltas(StringBuffer sb,
			List<CDOFeatureDelta> deltas) {

		for (CDOFeatureDelta fd : deltas) {
			Type type = fd.getType();
			sb.append("\n    delta: " + " type:" + type);
			sb.append("\n     feature: " + fd.getFeature().getName());
			switch (type) {
			case LIST: {
				CDOListFeatureDelta castedFd = (CDOListFeatureDelta) fd;
				// Dependency on CDO 4.2
				// sb.append("\n     original size: " +
				// castedFd.getOriginSize());
				cdoPrintFeatureDeltas(sb, castedFd.getListChanges());
			}
				break;
			case ADD: {
				CDOAddFeatureDelta castedFd = (CDOAddFeatureDelta) fd;
				sb.append("\n     index: " + castedFd.getIndex());
				if (castedFd.getFeature().isMany()) {
					// castedFd.getFeature().
				}
			}
				break;
			case SET: {
				CDOSetFeatureDelta castedFd = (CDOSetFeatureDelta) fd;

				sb.append("\n     index: " + castedFd.getIndex());
				sb.append("\n     old: " + castedFd.getOldValue() + " new: "
						+ castedFd.getValue());
			}

				break;
			case REMOVE: {
				CDORemoveFeatureDelta castedFd = (CDORemoveFeatureDelta) fd;
				sb.append("\n     index: " + castedFd.getIndex());
			}
				break;

			default: {
				sb.append(" TODO create an entry for  type " + type
						+ " entry for feature delta attributes of this type");
			}
			}

		}
	}

	public static void cdoPrintRevisionDelta(StringBuffer sb,
			CDORevisionDelta delta) {
		for (CDOFeatureDelta fd : delta.getFeatureDeltas()) {
			sb.append("-- delta=" + fd);
		}
	}

	/**
	 * Appends the cdo Object ID to the actual object resource name.
	 * 
	 * @param object
	 * @return
	 */
	public static String resolveHistoricalResourceName(Object object) {

		if (!(object instanceof CDOObject)) {
			return null;
		}

		// TODO, keep a cache of CDOObject ID, and resource path.
		String affectedPath = cdoResourcePath((CDOObject) object);

		// The object needs to be in the correct state, if not persisted (CLEAN,
		// DIRTY etc..),
		// no cdoID will be present.
		CDOID id = ((CDOObject) object).cdoID();
		if (id != null) {
			URI idURI = URI.createURI(id.toURIFragment());
			String fragment = idURI.fragment();
			if (fragment != null) {
				String[] fragments = fragment.split("#");
				affectedPath = affectedPath + "_"
						+ fragments[fragments.length - 1];
			}
			return affectedPath;
		} else
			return null;
	}

	public static Iterator<CDOObject> transformEObjectToCDOObjects(
			Iterator<EObject> eObjects) {
		final Function<EObject, CDOObject> cdoObjectFromEObject = new Function<EObject, CDOObject>() {
			public CDOObject apply(EObject from) {
				return (CDOObject) from;
			}
		};
		return Iterators.transform(eObjects, cdoObjectFromEObject);
	}

	/**
	 * look down the containment tree, and find the most recenrt date.
	 * 
	 * @param object
	 * @return
	 */
	public static long mostRecentContainedDated(CDOObject object) {

		long ts = object.cdoRevision().getTimeStamp();

		TreeIterator<EObject> eAllContents = object.eAllContents();
		while (eAllContents.hasNext()) {
			EObject eo = eAllContents.next();
			if (eo.eContainer() != null) {
				// We are contained, so we might have been updated.
				if (eo instanceof CDOObject) {
					long leafTS = ((CDOObject) eo).cdoRevision().getTimeStamp();
					if (leafTS > ts) {
						ts = leafTS;
					}
				}

			}
		}
		return ts;
	}

}
