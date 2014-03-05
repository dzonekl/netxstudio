/*******************************************************************************
 * Copyright (c) 22 mei 2013 NetXForge.
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
package com.netxforge.netxstudio.screens.editing.commands;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.CDOObjectReference;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.util.CommitException;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.EMFEditPlugin;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;

import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.netxforge.netxstudio.data.ReferenceHelper;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.screens.editing.internal.EditingActivator;
import com.netxforge.screens.editing.base.commands.NoWayBackCommand;

/**
 * A command which 
 * 
 * @author Christophe Bouhier 
 */
public class WarningNWBDeleteCommand extends NoWayBackCommand {

	/**
	 * This constructs a command that deletes the objects in the given
	 * collection.
	 */
	public WarningNWBDeleteCommand(Collection<?> collection) {
//		 super(0, LABEL, DESCRIPTION);
		// this.domain = domain;
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
		return domain.createCommand(WarningNWBDeleteCommand.class,
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
	// protected EditingDomain domain;

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

	public void execute() {
		
		
		Collection<EObject> eObjects = getObjects();
		
		
		CDOTransaction cdoTransaction = null;
		// All modfications are commited with the first transaction we
		// encounter.
		for (EObject eo : eObjects) {
			if (eo instanceof CDOObject) {
				CDOObject cdoO = (CDOObject) eo;
				if (cdoO.cdoView() != null) {
					cdoTransaction = (CDOTransaction) cdoO.cdoView();
					break;
				}
			}
		}
		
		
		// QUERY INCOMING REFS.
		long nanoTime = System.nanoTime();
		List<CDOObjectReference> xRefs = ReferenceHelper
				.findReferencesGlobally(eObjects);
		long queryTime = (System.nanoTime() - nanoTime) / 1000000; // Should be
																	// mili
																	// seconds??

		if (EditingActivator.DEBUG) {
			System.out.println(" WarningCommand: time to query references ="
					+ queryTime + " (ms)");
		}

		
		
		
		// REMOVE OBJECTS.

		// Note, inferring the Owner and Feature for each object is embedded in
		// the
		// AdapterFactoryEditingDomain (createCommand) and the
		// IEditingDomainItemProvider (createCommand)
		// It's a lot of work to reproduce this functionality.
		// As an alternative, we simply use a hard delete method, not emulating
		// the low-level RemoveCommand.

		for (EObject eo : eObjects) {
			// NetXResource.
			EcoreUtil.remove(eo);
			// if (eo instanceof NetXResource) {
			// this.removeWithParentResource(eo);
			// } else {
			// EcoreUtil.remove(eo);
			// }

			if (EditingActivator.DEBUG) {
				if (eo instanceof CDOObject) {
					CDOObject cdoObject = (CDOObject) eo;
					System.out.println("Object: " + cdoObject
							+ "State after delete:" + cdoObject.cdoState());
					if (cdoObject.eResource() == null
							|| cdoObject.eContainer() == null) {
						System.out.println("Object: " + cdoObject
								+ " is not in a resource or container");
					}
				}
			}
		}

		if (xRefs != null) {

			if (EditingActivator.DEBUG) {
				System.out.println("WarningCommand: found references:"
						+ xRefs.size());
			}

			for (CDOObjectReference xref : xRefs) {
				EObject referencingEObject = xref.getSourceObject();
				EObject eObject = xref.getTargetObject();
				if (!eObjects.contains(referencingEObject)) {
					EStructuralFeature eStructuralFeature = xref
							.getSourceFeature();

					if (EditingActivator.DEBUG) {
						System.out.println("Removing reference:"
								+ eStructuralFeature + " for object "
								+ referencingEObject);
					}

					if (eStructuralFeature.isMany()) {
						Object eGet = referencingEObject
								.eGet(eStructuralFeature);
						if (eGet instanceof List<?>) {
							((List<?>) eGet).remove(eObject);
						}
					} else {
						referencingEObject.eSet(eStructuralFeature, null);
					}
				}
			}
		} else {
			if (EditingActivator.DEBUG) {
				System.out.println(" No references detected");
			}
		}

		if(cdoTransaction != null && cdoTransaction.isDirty()){
			try {
				cdoTransaction.commit();
			} catch (CommitException e) {
				e.printStackTrace();
			}
		}


		// Commit and remove the resource if needed.
		for (EObject eo : eObjects) {

			// NetXResource.
			if (eo instanceof NetXResource) {
				this.removeCDOResource(eo);
			}
			if (EditingActivator.DEBUG) {
				if (eo instanceof CDOObject) {
					CDOObject cdoObject = (CDOObject) eo;
					System.out.println("Object: " + cdoObject
							+ "State after delete:" + cdoObject.cdoState());
					if (cdoObject.eResource() == null
							|| cdoObject.eContainer() == null) {
						System.out.println("Object: " + cdoObject
								+ " is not in a resource or container");
					}
				}
			}
		}
		
		// Commit another time for deleting the resource. 
		
		if(cdoTransaction != null && cdoTransaction.isDirty()){
			try {
				cdoTransaction.commit();
			} catch (CommitException e) {
				e.printStackTrace();
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
		return ReferenceHelper.findReferencesGlobally(eObjects,
				incomingReferences());
	}

	public void removeCDOResource(EObject eObject) {
		Resource resource = eObject.eResource();
		if (resource != null) {
			if (resource instanceof CDOResource) {
				CDOResource cdoRes = (CDOResource) resource;
				// EList<EObject> contents = cdoRes.getContents();
				// contents.remove(eObject);
				try {
					cdoRes.delete(null);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * From Remove command...
	 * 
	 * @param collection
	 * @param target
	 * @return
	 */
	protected boolean removeExact(Collection<?> collection, Object target) {
		for (Iterator<?> i = collection.iterator(); i.hasNext();) {
			if (i.next() == target) {
				i.remove();
				return true;
			}
		}
		return false;
	}

	private EReference[] incomingReferences() {
		// We need ERefs for all objects including the children.
		List<EReference> eRefs = Lists.newArrayList();
		Collection<EObject> objects = this.getObjects();
		for (Iterator<EObject> j = objects.iterator(); j.hasNext();) {
			EObject eo = j.next();
			if (eo instanceof NetXResource) {
				eRefs.add(LibraryPackage.Literals.COMPONENT__RESOURCE_REFS);
			}
			if (eo instanceof Value) {
				eRefs.add(LibraryPackage.Literals.NET_XRESOURCE__CAPACITY_VALUES);
				eRefs.add(LibraryPackage.Literals.NET_XRESOURCE__UTILIZATION_VALUES);
				// Some other values ranges are not in use yet.

				eRefs.add(OperatorsPackage.Literals.MARKER__VALUE_REF);
				eRefs.add(MetricsPackage.Literals.METRIC_VALUE_RANGE__METRIC_VALUES);
			}
		}
		return Iterators.toArray(eRefs.iterator(), EReference.class);

	}

}
