/*******************************************************************************
 * Copyright (c) Aug 3, 2011 NetXForge.
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
package com.netxforge.netxstudio.callflow.screens.actions;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.netxforge.netxstudio.screens.editing.extenders.AbstractConditionalChildCreationExtender;
import com.netxforge.netxstudio.services.ServiceFlowRelationship;
import com.netxforge.netxstudio.services.ServicesFactory;
import com.netxforge.netxstudio.services.ServicesPackage;

/**
 * Custom child extender, capable to add conditional ( Type etc...) child
 * descriptors It works best, by disabling the generated EMF descriptors.
 * 
 * Note: This is called for all EObject of the specified extender package, so
 * first check the target eclass.
 * 
 * @author Christophe Bouhier
 */
public class ServicesChildCreationExtender extends
		AbstractConditionalChildCreationExtender {

	@Inject
	public ServicesChildCreationExtender() {
	}

	public Collection<?> getNewChildDescriptors(Object object,
			EditingDomain editingDomain) {
		Collection<Object> newChildDescriptors = Lists.newArrayList();

		if (object instanceof EObject) {
			EObject target = (EObject) object;

			if (target instanceof ServiceFlowRelationship ) {
				newChildDescriptors.add
				(createChildParameter
					(ServicesPackage.Literals.SERVICE_FLOW__SERVICE_FLOW_RELATIONSHIPS,
					 ServicesFactory.eINSTANCE.createServiceFlowRelationship()));

			}
		}

		return newChildDescriptors;
	}

}
