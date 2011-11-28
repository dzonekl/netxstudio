/*******************************************************************************
 * Copyright (c) Nov 26, 2011 NetXForge.
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
package com.netxforge.netxstudio.screens.editing.actions;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.CDOObjectReference;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.EMFEditPlugin;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;

import com.google.common.base.Function;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class WarningDeleteCommand extends CompoundCommand {

	/**
	 * This constructs a command that deletes the objects in the given
	 * collection.
	 */
	public WarningDeleteCommand(EditingDomain domain, Collection<?> collection) {
		super(0, LABEL, DESCRIPTION);
		this.domain = domain;
		this.collection = collection;
	}

	/**
	 * This creates a command that deletes the given object.
	 */
	public static Command create(EditingDomain domain, Object object) {
		return create(domain, Collections.singleton(object));
	}

	/**
	 * This creates a command that deletes the objects in the given collection.
	 */
	public static Command create(EditingDomain domain,
			final Collection<?> collection) {
		return domain.createCommand(WarningDeleteCommand.class,
				new CommandParameter(null, null, collection));
	}

	/**
	 * This caches the label.
	 */
	protected static final String LABEL = EMFEditPlugin.INSTANCE
			.getString("_UI_DeleteCommand_label");

	/**
	 * This caches the description.
	 */
	protected static final String DESCRIPTION = EMFEditPlugin.INSTANCE
			.getString("_UI_DeleteCommand_description");

	/**
	 * This is the editing domain in which this command operates.
	 */
	protected EditingDomain domain;

	/**
	 * This is the collection of objects to be deleted.
	 */
	protected Collection<?> collection;

	/**
	 * This returns the collection of objects to be deleted.
	 */
	public Collection<?> getCollection() {
		return collection;
	}

	@Override
	protected boolean prepare() {
		prepareCommand();
		return super.prepare();
	}

	protected void prepareCommand() {
		append(RemoveCommand.create(domain, collection));
	}

	@Override
	public void execute() {
		Collection<EObject> eObjects = getObjects();

		List<CDOObjectReference> xRefs = this.findReferencesGlobally(eObjects);

		super.execute();

		if (xRefs != null) {
			for (CDOObjectReference xref : xRefs) {

				EObject referencingEObject = xref.getSourceObject();
				EObject eObject = xref.getTargetObject();

				// Do not delete referring objects which are scheduled for
				// deletion themselves.
				if (!eObjects.contains(referencingEObject)) {
					EStructuralFeature eStructuralFeature = xref
							.getSourceFeature();
					if (eStructuralFeature.isMany()) {

						// Hack, has remove command doesn't work sometimes....
						Command cmd = RemoveCommand
								.create(domain, referencingEObject,
										eStructuralFeature, eObject);
						if (cmd.canExecute()) {
							appendAndExecute(cmd);
						} else {
							Object eGet = referencingEObject
									.eGet(eStructuralFeature);
							if (eGet instanceof List<?>) {
								((List<?>) eGet).remove(eObject);
							}
						}

					} else {
						appendAndExecute(SetCommand.create(domain,
								referencingEObject, eStructuralFeature,
								SetCommand.UNSET_VALUE));
					}
				}

			}
		}
	}

	/**
	 * Creates a collection of contained objects to be deleted.
	 * 
	 * @return
	 */
	public Collection<EObject> getObjects() {

		Collection<EObject> eObjects = new LinkedHashSet<EObject>();
		for (Object wrappedObject : collection) {
			Object object = AdapterFactoryEditingDomain.unwrap(wrappedObject);
			if (object instanceof EObject) {
				eObjects.add((EObject) object);
				for (Iterator<EObject> j = ((EObject) object).eAllContents(); j
						.hasNext();) {
					eObjects.add(j.next());
				}
			} else if (object instanceof Resource) {
				for (Iterator<EObject> j = ((Resource) object).getAllContents(); j
						.hasNext();) {
					eObjects.add(j.next());
				}
			}
		}
		return eObjects;
	}

	public List<CDOObjectReference> getUsage(Collection<EObject> eObjects) {
		return findReferencesGlobally(eObjects);
	}

	private List<CDOObjectReference> findReferencesGlobally(
			Collection<EObject> eObjects) {
		List<CDOObjectReference> queryXRefs = Lists.newArrayList();

		// Query on the whole set in one go, we assume all objects have the same CDOView. 
		if (eObjects.size() > 0) {
			EObject next = eObjects.iterator().next();
			CDOView cdoView = ((CDOObject) next).cdoView();
			HashSet<CDOObject> objectSet = Sets.newHashSet(transEObjectToCDOObjects(eObjects.iterator()));
			queryXRefs = cdoView.queryXRefs(
				objectSet, new EReference[] {});
		}

//		for (EObject o : eObjects) {
//			if (o instanceof CDOObject) {
//				CDOView cdoView = ((CDOObject) o).cdoView();
//				try {
//					// EReference[] incomingRefs = this.incomingReferences(o);
//					List<CDOObjectReference> runRefs = cdoView.queryXRefs(
//							(CDOObject) o, new EReference[] {});
//
//					for (CDOObjectReference runRef : runRefs) {
//						// Iterate through the already found queryRefs, compare
//						// source to look for double entries.
//						// if(!exists(queryXRefs, runRef)){
//						// queryXRefs.add(runRef);
//						// }
//						queryXRefs.add(runRef);
//					}
//
//				} catch (Exception e) {
//					e.printStackTrace();
//					// The query sometimes throws exeception, if i.e an entity
//					// can't be found..
//					// EClass ExpressionResult does not have an entity name, has
//					// it been mapped to Hibernate?
//				}
//			}
//		}
		return queryXRefs;
	}

	boolean exists(List<CDOObjectReference> refList, CDOObjectReference ref) {
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

	// private EReference[] incomingReferences(EObject eo) {
	// ArrayList<EReference> incomingRefs = Lists.newArrayList();
	// // if (eo instanceof NetXResource) {
	// // incomingRefs.add(LibraryPackage.Literals.COMPONENT__RESOURCE_REFS);
	// // }
	// for (@SuppressWarnings("rawtypes")
	// EContentsEList.FeatureIterator featureIterator =
	// (EContentsEList.FeatureIterator) eo
	// .eCrossReferences().iterator(); featureIterator.hasNext();) {
	// // EObject eObject = (EObject) featureIterator.next();
	// EReference eReference = (EReference) featureIterator.feature();
	// incomingRefs.add(eReference);
	// }
	// return Iterables.toArray(incomingRefs, EReference.class);
	// }
	
	

	public Iterator<CDOObject> transEObjectToCDOObjects(Iterator<EObject> eObjects) {
		final Function<EObject, CDOObject> cdoObjectFromEObject = new Function<EObject, CDOObject>() {
			public CDOObject apply(EObject from) {
				return (CDOObject) from;
			}
		};
		return Iterators.transform(eObjects, cdoObjectFromEObject);
	}
	
}
