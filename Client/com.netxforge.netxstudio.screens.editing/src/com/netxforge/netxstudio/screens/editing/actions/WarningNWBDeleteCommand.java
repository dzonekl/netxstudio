package com.netxforge.netxstudio.screens.editing.actions;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.CDOObjectReference;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.edit.EMFEditPlugin;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;

import com.google.common.collect.Lists;
import com.netxforge.netxstudio.library.NetXResource;

public class WarningNWBDeleteCommand extends NoWayBackCommand {

	/**
	 * This constructs a command that deletes the objects in the given
	 * collection.
	 */
	public WarningNWBDeleteCommand(Collection<?> collection) {
		// super(0, LABEL, DESCRIPTION);
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

		

		// Note, inferring the Owner and Feature for each object is embedded in
		// the
		// AdapterFactoryEditingDomain (createCommand) and the
		// IEditingDomainItemProvider (createCommand)
		// It's a lot of work to reproduce this functionality.
		// As an alternative, we simply use a hard delete method, not emulating
		// the low-level RemoveCommand.

		for (EObject eo : eObjects) {
			// Also delete the resource for certain types of objects, like
			// NetXResource.
//			EcoreUtil.remove(eo);
			if (eo instanceof NetXResource) {
				
				this.removeWithParentResource(eo);
			} else {
				EcoreUtil.remove(eo);
			}
			if(eo instanceof CDOObject){
				CDOObject cdoObject = (CDOObject) eo;
				System.out.println("Object: " + cdoObject +"State after delete:" + cdoObject.cdoState() );
				// Will be null in state TRANSIENT.
				if(cdoObject.cdoID() != null){
					
				}
				if( cdoObject.eResource() == null){
					// the object is dangling here. 
					System.out.println("Object: " + cdoObject +" is dangling after being delete "  );
				}
				
			}
		}

		// The domain, might not contain the referenced object.
		List<CDOObjectReference> xRefs = this.findReferencesGlobally(eObjects);
		if (xRefs != null) {
			for (CDOObjectReference xref : xRefs) {

				EObject referencingEObject = xref.getSourceObject();
				EObject eObject = xref.getTargetObject();
				if (!eObjects.contains(referencingEObject)) {
					EStructuralFeature eStructuralFeature = xref
							.getSourceFeature();

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
		}
		// TODO, also delete the historical nodes for Node and NodeType objects.

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
		for (EObject o : eObjects) {
			if (o instanceof CDOObject) {
				CDOView cdoView = ((CDOObject) o).cdoView();
				if(cdoView == null){
					// continue;
					continue;
				}
				try {
					List<CDOObjectReference> runRefs = cdoView.queryXRefs(
							(CDOObject) o, new EReference[] {});

					for (CDOObjectReference runRef : runRefs) {
						// Iterate through the already found queryRefs, compare
						// source
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

	public void removeWithParentResource(EObject eObject) {
		InternalEObject internalEObject = (InternalEObject) eObject;
		EObject container = internalEObject.eInternalContainer();
		if (container != null) {
			EReference feature = eObject.eContainmentFeature();
			if (FeatureMapUtil.isMany(container, feature)) {
				((EList<?>) container.eGet(feature)).remove(eObject);
			} else {
				container.eUnset(feature);
			}
		}

		Resource resource = eObject.eResource();
		if (resource != null) {
			if (resource instanceof CDOResource) {
				CDOResource cdoRes = (CDOResource) resource;
				EList<EObject> contents = cdoRes.getContents();
				
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
	 * @param collection
	 * @param target
	 * @return
	 */
	protected boolean removeExact(Collection<?> collection, Object target)
	  {
	    for (Iterator<?> i = collection.iterator(); i.hasNext(); )
	    {
	      if (i.next() == target)
	      {
	        i.remove();
	        return true;
	      }
	    }
	    return false;
	  }
	
}
