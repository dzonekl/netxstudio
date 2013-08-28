/*******************************************************************************
 * Copyright (c) 27 aug. 2013 NetXForge.
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
package com.netxforge.netxstudio.screens.editing.tables;

import java.util.Collection;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;

import com.netxforge.netxstudio.screens.editing.tables.CopyFeatureCommand.FeatureInitializer;
import com.netxforge.netxstudio.screens.editing.tables.CopyFeatureCommand.Helper;

/**
 * 
 * @author Christophe Bouhier
 */
public class CopyFeaturesActionHandler extends AbstractFocusBlockActionHandler {

	@Override
	public Command copyCommandFor(EditingDomain editingDomain, EObject element,
			Collection<EObject> targets, EStructuralFeature feature,
			Helper helper, FeatureInitializer featureInitializer,
			Resource resource) {
		return new CopyFeatureCommand(editingDomain, element, targets, feature,
				new CopyFeatureCommand.Helper(), featureInitializer, resource);

	}

	@Override
	public Command setCommandFor(EditingDomain editingDomain, EObject element,
			Collection<EObject> targets, EStructuralFeature feature) {
		return new SetFeatureCommand(editingDomain, element, targets, feature);
	}

}
