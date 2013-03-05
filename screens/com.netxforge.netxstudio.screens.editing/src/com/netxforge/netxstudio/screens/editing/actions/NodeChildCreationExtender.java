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
package com.netxforge.netxstudio.screens.editing.actions;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.OperatorsPackage;

/**
 * Custom child extender, capable to add conditional ( Type etc...) child
 * descriptors It works best, by disabling the generated EMF descriptors.
 * 
 * @author Christophe Bouhier
 */
public class NodeChildCreationExtender extends
		AbstractConditionalChildCreationExtender {

	protected ModelUtils modelUtils;

	@Inject
	public NodeChildCreationExtender(ModelUtils modelUtils) {
		this.modelUtils = modelUtils;
	}

	public Collection<?> getNewChildDescriptors(Object object,
			EditingDomain editingDomain) {

		Collection<Object> newChildDescriptors = Lists.newArrayList();

		if (object instanceof EObject) {
			EObject target = (EObject) object;
			Node node = modelUtils.resolveParentNode(target);
			if (node != null && node.getOriginalNodeTypeRef() != null) {
				NodeType ntRef = node.getOriginalNodeTypeRef();
				if (target.eClass() == OperatorsPackage.Literals.NODE) {
					EList<Equipment> directContent = ntRef.getEquipments();
					for (Equipment targetChild : directContent) {
						System.out.println("CreateChildExtender:  add child"
								+ targetChild);
						Equipment eqCopy = (Equipment) EcoreUtil
								.copy(targetChild);
						// Set the name as a sequence.
						String newSequenceNumber = modelUtils
								.getSequenceNumber(
										targetChild,
										LibraryPackage.Literals.EQUIPMENT__EQUIPMENTS,
										LibraryPackage.Literals.COMPONENT__NAME);
						eqCopy.setName(newSequenceNumber);
						newChildDescriptors.add(createChildParameter(
								LibraryPackage.Literals.EQUIPMENT__EQUIPMENTS,
								eqCopy));
					}
				}
			}
		}

		return newChildDescriptors;
	}
}
