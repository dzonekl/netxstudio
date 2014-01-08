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
package com.netxforge.netxstudio.screens.editing.extenders;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.library.LibraryFactory;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.operators.Node;


/**
 * Custom child extender, capable to add conditional ( Type etc...) child descriptors
 * It works best, by disabling the generated EMF descriptors. 
 *  
 * @author Christophe Bouhier
 */
public class FunctionChildCreationExtender extends AbstractConditionalChildCreationExtender {
	
	
	protected ModelUtils modelUtils;

	@Inject
	public FunctionChildCreationExtender(ModelUtils modelUtils) {
		this.modelUtils = modelUtils;
	}

	public Collection<?> getNewChildDescriptors(Object object,
			EditingDomain editingDomain) {

		Collection<Object> newChildDescriptors = Lists.newArrayList();

		if (object instanceof EObject) {
			EObject target = (EObject) object;
			Node node = modelUtils.nodeFor(target);
			if (node != null && node.getOriginalNodeTypeRef() != null) {
				// Do nothing, we don't allow adding on Functions which have a parent node. 
			} else {
				System.out
						.println("CreateChildExtender: no parent Node object found");
				newChildDescriptors.add
				(createChildParameter
					(LibraryPackage.Literals.FUNCTION__FUNCTIONS,
					 LibraryFactory.eINSTANCE.createFunction()));

			}
		}

		return newChildDescriptors;
	}

}
