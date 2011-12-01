package com.netxforge.netxstudio.screens.editing.actions;

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
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.netxforge.netxstudio.screens.editing.internal.EditingActivator;

public class ReferenceHelper {

	public static List<CDOObjectReference> findReferencesGlobally(
			Collection<EObject> eObjects) {
		return findReferencesGlobally(eObjects, new EReference[] {});
	}

	public static List<CDOObjectReference> findReferencesGlobally(
			Collection<EObject> eObjects, EReference[] refs) {
		List<CDOObjectReference> queryXRefs = Lists.newArrayList();

		// Query on the whole set in one go, we assume all objects have the same
		// CDOView.
		if (eObjects.size() > 0) {
			EObject next = eObjects.iterator().next();
			CDOView cdoView = ((CDOObject) next).cdoView();
			if(cdoView == null){
				// We don't have a view for this object, this should not occur, 
				// as an object should never be detached at this stage. 
				if(EditingActivator.DEBUG){
					System.out.println(" object detached, can't query on it");
				}
				return queryXRefs;
			}
			HashSet<CDOObject> objectSet = Sets
					.newHashSet(transEObjectToCDOObjects(eObjects.iterator()));
			try {
				queryXRefs = cdoView.queryXRefs(objectSet, refs);
			} catch (Exception e) {
				e.printStackTrace();
				// The query sometimes throws exeception, if i.e an entity
				// can't be found..
				// EClass ExpressionResult does not have an entity name, has
				// it been mapped to Hibernate?
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
					e.printStackTrace();
					// The query sometimes throws exeception, if i.e an entity
					// can't be found..
					// EClass ExpressionResult does not have an entity name, has
					// it been mapped to Hibernate?
				}
			}
		}
		return queryXRefs;
	}

	public static Iterator<CDOObject> transEObjectToCDOObjects(
			Iterator<EObject> eObjects) {
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
