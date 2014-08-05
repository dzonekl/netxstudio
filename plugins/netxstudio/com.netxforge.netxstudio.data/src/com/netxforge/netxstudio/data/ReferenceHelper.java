/*******************************************************************************
 * Copyright (c) 7 jan. 2013 NetXForge.
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
package com.netxforge.netxstudio.data;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.CDOObjectReference;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.netxforge.netxstudio.data.internal.DataActivator;

/**
 * 
 * @author Christophe Bouhier
 */
public class ReferenceHelper {

	/**
	 * Clients should implement and call {@link #collection(List)} to get a
	 * collection of crossReferenced objects of type T simply adding matching
	 * items. Alternatively clients can control which items are added to a
	 * self-managed collection, by implementing {@link #collectionSelf(List)}
	 * which returns nothing, but will force passed items to be of type T.
	 * 
	 * @author Christophe Bouhier
	 * 
	 * @param <T>
	 */
	public static abstract class CollectionFor<T> {
		private List<T> collection;

		private Predicate<T> predicate = new Predicate<T>() {
			public boolean apply(T input) {
				return delegateApply(input);
			}
		};

		public CollectionFor() {
			collection = Lists.newArrayList();
		}

		@SuppressWarnings("unchecked")
		public List<T> collection(List<CDOObjectReference> xRefs) {

			if (xRefs != null) {
				for (CDOObjectReference xref : xRefs) {
					EObject referencingEObject = xref.getSourceObject();
					try {
						if (predicate.apply((T) referencingEObject)) {
							collection.add((T) referencingEObject);
						}
					} catch (ClassCastException cce) {
						// obviously can't be casted,so is wrong type anyway.
					}
				}
			}

			return collection;
		}

		@SuppressWarnings("unchecked")
		public List<T> collectionSelf(List<CDOObjectReference> xRefs) {

			if (xRefs != null) {
				for (CDOObjectReference xref : xRefs) {
					EObject referencingEObject = xref.getSourceObject();
					try {
						delegateSelf((T) referencingEObject);
					} catch (ClassCastException cce) {
						// obviously can't be casted,so is wrong type anyway.
					}
				}
			}

			return collection;
		}

		public void delegateSelf(T referencingEObject) {
			// Perfectly do nothing..
		}

		public boolean delegateApply(T input) {
			return false;
		}

	}

	public static List<CDOObjectReference> findReferencesGlobally(
			Collection<? extends EObject> eObjects) {
		return findReferencesGlobally(eObjects, new EReference[] {});
	}

	public static List<CDOObjectReference> findReferencesGlobally(
			Collection<? extends EObject> eObjects, EReference[] refs) {
		List<CDOObjectReference> queryXRefs = Lists.newArrayList();

		// Query on the whole set in one go, we assume all objects have the same
		// CDOView.
		if (eObjects.size() > 0) {
			EObject next = eObjects.iterator().next();
			CDOView cdoView = ((CDOObject) next).cdoView();
			if (cdoView == null) {
				// We don't have a view for this object., which will have an
				// unset CDOView.
				if (DataActivator.DEBUG) {
					DataActivator.TRACE.trace(DataActivator.TRACE_DATA_OPTION,
							" object detached, can't query on it");
				}
				return queryXRefs;
			}
			HashSet<CDOObject> objectSet = Sets
					.newHashSet(transEObjectToCDOObjects(eObjects.iterator()));
			try {
				queryXRefs = cdoView.queryXRefs(objectSet, refs);
			} catch (Exception e) {
				// 1. The query sometimes throws exeception, if i.e an entity
				// can't be found..
				// EClass ExpressionResult does not have an entity name, has
				// it been mapped to Hibernate?
				// 2.
				if (DataActivator.DEBUG) {
					DataActivator.TRACE.trace(DataActivator.TRACE_DATA_OPTION,
							" xref on failed: ", e);
				}

			}
		}

		return queryXRefs;
	}

	public static List<CDOObjectReference> findReferencesGloballyOneByOne(
			Collection<EObject> eObjects) {
		return findReferencesGloballyOneByOne(eObjects, new EReference[] {});
	}

	public static List<CDOObjectReference> findReferencesGloballyOneByOne(
			Collection<EObject> eObjects, EReference[] refs) {
		List<CDOObjectReference> queryXRefs = Lists.newArrayList();

		// Query on the whole set in one go, we assume all objects have the same
		// CDOView.
		for (EObject o : eObjects) {
			if (o instanceof CDOObject) {
				CDOView cdoView = ((CDOObject) o).cdoView();
				try {
					List<CDOObjectReference> runRefs = cdoView.queryXRefs(
							(CDOObject) o, refs);

					for (CDOObjectReference runRef : runRefs) {
						// Iterate through the already found queryRefs, compare
						// source to look for double entries.
						// if(!exists(queryXRefs, runRef)){
						// queryXRefs.add(runRef);
						// }
						queryXRefs.add(runRef);
					}

				} catch (Exception e) {
					// The query sometimes throws exeception, if i.e an entity
					// can't be found..
					// EClass ExpressionResult does not have an entity name, has
					// it been mapped to Hibernate?
					if (DataActivator.DEBUG) {
						DataActivator.TRACE.trace(
								DataActivator.TRACE_DATA_OPTION,
								" xref on failed: ", e);
					}
				}
			}
		}
		return queryXRefs;
	}

	public static Iterator<CDOObject> transEObjectToCDOObjects(
			Iterator<? extends EObject> eObjects) {
		final Function<EObject, CDOObject> cdoObjectFromEObject = new Function<EObject, CDOObject>() {
			public CDOObject apply(EObject from) {
				return (CDOObject) from;
			}
		};
		return Iterators.transform(eObjects, cdoObjectFromEObject);
	}

	public static boolean exists(List<CDOObjectReference> refList,
			CDOObjectReference ref) {
		boolean found = false;
		// and target.
		for (CDOObjectReference qRef : refList) {
			if ((ref.getSourceObject() == qRef.getSourceObject())
					&& (ref.getTargetObject() == qRef.getTargetObject())) {
				found = true;
				break;
			}
		}
		return found;
	}
}
