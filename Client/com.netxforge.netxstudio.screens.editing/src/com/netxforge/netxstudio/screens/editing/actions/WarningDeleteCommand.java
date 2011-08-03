package com.netxforge.netxstudio.screens.editing.actions;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;

public class WarningDeleteCommand extends DeleteCommand {

	public WarningDeleteCommand(EditingDomain domain, Collection<?> collection) {
		super(domain, collection);
	}

	public static Command create(EditingDomain domain,
			final Collection<?> collection) {
		return domain.createCommand(WarningDeleteCommand.class,
				new CommandParameter(null, null, collection));
	}

	public Map<EObject, Collection<EStructuralFeature.Setting>> getUsage() {
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
		return findReferences(eObjects);
	}
}
