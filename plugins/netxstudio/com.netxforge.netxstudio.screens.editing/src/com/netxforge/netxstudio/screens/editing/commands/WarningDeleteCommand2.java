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
package com.netxforge.netxstudio.screens.editing.commands;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

import org.eclipse.emf.cdo.CDOObjectReference;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;

import com.netxforge.netxstudio.data.ReferenceHelper;



/**
 * DOESN'T WORK. THIS WILL CALL BOTH CDO XREF as ECOREUTIL XREF, leading to very long waiting times
 * when deleting.....TO, FIX MAKE SURE WE DO NOT EXTEND the DeleteCommand. We did this in order
 * to  
 * 
 *  
 * 
 * @author Christophe
 *
 */
public class WarningDeleteCommand2 extends DeleteCommand {

	/**
	 * Controls if the command should undo or not, when prepared as an undo
	 * command, we can still override
	 **/
	public boolean undo = true;

	/**
	 * Cache our objects as we use them to prepare the command but also to show
	 * a Warning of which objects will be deleted.
	 */
	private Collection<EObject> eObjects;

	public WarningDeleteCommand2(EditingDomain domain, Collection<?> collection) {
		super(domain, collection);
	}

	@Override
	public void execute() {

		Collection<EObject> eObjects = getObjects();

		List<CDOObjectReference> xRefs = ReferenceHelper
				.findReferencesGlobally(eObjects);

		// Note the appended RemoveCommand goes waisted when not-undoing.
		if (undo) {
			// Because we have appended a RemoveCommand (We are a
			// CompoundCommand),
			// calling the super, will execute remaining commands in the command
			// list, which will actually remove our objects, what remains is
			// clearing the
			// references.
			
		    for (Object wrappedObject : collection)
		    {
		      Object object = AdapterFactoryEditingDomain.unwrap(wrappedObject);
		      if (object instanceof EObject)
		      {
		        eObjects.add((EObject)object);
		        for (Iterator<EObject> j = ((EObject)object).eAllContents(); j.hasNext(); )
		        {
		          eObjects.add(j.next());
		        }
		      }
		      else if (object instanceof Resource)
		      {
		        for (Iterator<EObject> j = ((Resource)object).getAllContents(); j.hasNext(); )
		        {
		          eObjects.add(j.next());
		        }
		      }
		    }
		    
			
		} else {
			for (EObject eo : eObjects) {
				EcoreUtil.remove(eo);
			}
		}

		if (xRefs != null) {
			for (CDOObjectReference xref : xRefs) {

				EObject referencingEObject = xref.getSourceObject();
				EObject eObject = xref.getTargetObject();
				EStructuralFeature eStructuralFeature = xref.getSourceFeature();

				if (undo) {
					removeReference(eObjects, eObject, referencingEObject,
							eStructuralFeature);

				} else {
					Object eGet = referencingEObject.eGet(eStructuralFeature);
					if (eGet instanceof List<?>) {
						((List<?>) eGet).remove(eObject);
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

		if (eObjects == null) {
			eObjects = new LinkedHashSet<EObject>();
			for (Object wrappedObject : collection) {
				Object object = AdapterFactoryEditingDomain
						.unwrap(wrappedObject);
				if (object instanceof EObject) {
					eObjects.add((EObject) object);
					for (Iterator<EObject> j = ((EObject) object)
							.eAllContents(); j.hasNext();) {
						eObjects.add(j.next());
					}
				} else if (object instanceof Resource) {
					for (Iterator<EObject> j = ((Resource) object)
							.getAllContents(); j.hasNext();) {
						eObjects.add(j.next());
					}
				}
			}
		}
		return eObjects;
	}

	public List<CDOObjectReference> getUsage(Collection<EObject> eObjects) {
		return ReferenceHelper.findReferencesGlobally(eObjects);
	}

	/**
	 * Remove a reference to an object.</br>
	 * 
	 * @param eObjects
	 *            A Collection of objects which should contain the target object
	 *            to remove.
	 * @param eObject
	 * @param referencingEObject
	 * @param eStructuralFeature
	 */
	public void removeReference(Collection<EObject> eObjects, EObject eObject,
			EObject referencingEObject, EStructuralFeature eStructuralFeature) {
		if (!eObjects.contains(referencingEObject)) {
			if (eStructuralFeature.isChangeable()) {
				if (eStructuralFeature.isMany()) {
					appendAndExecute(RemoveCommand.create(domain,
							referencingEObject, eStructuralFeature, eObject));
				} else {
					appendAndExecute(SetCommand.create(domain,
							referencingEObject, eStructuralFeature,
							SetCommand.UNSET_VALUE));
				}
			}
		}
	}

	public static Command create(EditingDomain domain,
			final Collection<?> collection) {
		return domain.createCommand(WarningDeleteCommand2.class,
				new CommandParameter(null, null, collection));
	}

	/**
	 * This is the base, if the command is executable. We want to capture the
	 * result. </br> See forum/bug:</br>
	 * http://www.eclipse.org/forums/index.php/t/249409/ //
	 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=316273
	 * 
	 * The super will also prepare the underlying RemoveCommand. When executing
	 * with no-undo, the RemoveCommand has no use.
	 */
	@Override
	protected boolean prepare() {
		boolean prepared = super.prepare();
//		System.out.println("The Delete command is: " + (prepared ? "" : "NOT")
//				+ " prepared and will " + (undo ? "" : "NOT ")
//				+ " be undoable");
		return prepared;
	}

	@Override
	public boolean canUndo() {
		if (undo) {
			return super.canUndo();
		} else {
			return false;
		}
	}

}
