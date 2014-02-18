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
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.CDOObjectReference;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.EMFEditPlugin;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;

import com.netxforge.netxstudio.data.ReferenceHelper;

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

	public boolean undo;

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

		for (Object o : collection) {
			if (o instanceof CDOObject) {
				CDOObject cdoO = (CDOObject) o;
				EObject eContainer = cdoO.eContainer();
				if (eContainer instanceof CDOResource) {
					CDOResource resource = (CDOResource) eContainer;
					resource.getContents().containsAll(collection);
				}
			}
		}

		append(RemoveCommand.create(domain, collection));
	}

	@Override
	public void execute() {
		Collection<EObject> eObjects = getObjects();
		List<CDOObjectReference> xRefs = ReferenceHelper
				.findReferencesGlobally(eObjects);

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
						// See forum:

						// http://www.eclipse.org/forums/index.php/t/249409/
						// https://bugs.eclipse.org/bugs/show_bug.cgi?id=316273

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
		return ReferenceHelper.findReferencesGlobally(eObjects);
	}

}
