package com.netxforge.netxstudio.screens.editing.actions;

import java.util.Collection;
import java.util.Collections;
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

import com.google.common.collect.Lists;

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
		
		// For the objects, also delete the corresponding resource if a 1:1 CDOResource::Object.
		// Note: This also means, it can't be undone! 
		for(EObject eo : eObjects){
			
			
			
		}
		
		// The domain, might not contain the referenced object. 
		
		
		if (xRefs != null) {
			for (CDOObjectReference xref : xRefs) {

				EObject referencingEObject = xref.getSourceObject();
				EObject eObject = xref.getTargetObject();
				
				// Do not delete referring objects which are scheduled for deletion themselves.  
				if (!eObjects.contains(referencingEObject)) {
					EStructuralFeature eStructuralFeature = xref
							.getSourceFeature();
					if (eStructuralFeature.isMany()) {
						
						
						// Hack, has remove command doesn't work sometimes....
						Command cmd = RemoveCommand
								.create(domain, referencingEObject,
										eStructuralFeature, eObject);
						if(cmd.canExecute()){
							appendAndExecute(cmd);
						}else{
							Object eGet = referencingEObject.eGet(eStructuralFeature);
							if(eGet instanceof List<?>){
								((List<?>)eGet).remove(eObject);
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
				try {
					List<CDOObjectReference> runRefs = cdoView.queryXRefs(
							(CDOObject) o, new EReference[] {});

					for (CDOObjectReference runRef : runRefs) {
						// Iterate through the already found queryRefs, compare
						// source
//						if(!exists(queryXRefs, runRef)){
//							queryXRefs.add(runRef);
//						}
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

}
