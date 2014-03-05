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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.netxforge.base.NonModelUtils;
import com.netxforge.netxstudio.edit.EditUtils;
import com.netxforge.netxstudio.generics.GenericsFactory;
import com.netxforge.netxstudio.generics.Lifecycle;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.operators.Network;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.OperatorsFactory;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.screens.editing.base.extenders.AbstractConditionalChildCreationExtender;

/**
 * Custom child extender, capable to add conditional ( Type etc...) child
 * descriptors It works best, by disabling the generated EMF descriptors.
 * 
 * Note: This is called for all EObject of the specified extender package, so
 * first check the target eclass.
 * 
 * @author Christophe Bouhier
 */
public class OperatorChildCreationExtender extends
		AbstractConditionalChildCreationExtender {

	@Inject
	public OperatorChildCreationExtender() {
	}

	public Collection<?> getNewChildDescriptors(Object object,
			EditingDomain editingDomain) {
		Collection<Object> newChildDescriptors = Lists.newArrayList();

		if (object instanceof EObject) {
			EObject target = (EObject) object;

			if (target instanceof Node) {
				Node node = (Node) target;
				if (node != null && node.getOriginalNodeTypeRef() != null) {
					NodeType ntRef = node.getOriginalNodeTypeRef();
					newChildDescriptors
							.addAll(functionDescriptorsForTargetNodeType(
									editingDomain, ntRef));

					newChildDescriptors
							.addAll(equimentDescriptorsForTargetNodeType(
									editingDomain, ntRef));
				}
			} else if (target instanceof Network) {

				Node n = OperatorsFactory.eINSTANCE.createNode();
				Lifecycle newLC = GenericsFactory.eINSTANCE.createLifecycle();
				newLC.setProposed(NonModelUtils.toXMLDate(NonModelUtils.todayAndNow()));
				n.setLifecycle(newLC);

				String newSequenceNumber = EditUtils.INSTANCE
						.nextSequenceNumber(editingDomain, target,
								OperatorsPackage.Literals.NETWORK__NODES,
								OperatorsPackage.Literals.NODE__NODE_ID);

				n.setNodeID(newSequenceNumber);

				newChildDescriptors.add(createChildParameter(
						OperatorsPackage.Literals.NETWORK__NODES, n));
			} else if (target instanceof Function) {
				newChildDescriptors
						.addAll(functionDescriptorsForTargetFunction(
								editingDomain, (Function) target));
			} else if (target instanceof Equipment) {
				newChildDescriptors
						.addAll(equimentDescriptorsForTargetEquipment(
								editingDomain, (Equipment)target));
			}

		}

		return newChildDescriptors;
	}

	private Collection<? extends Object> functionDescriptorsForTargetFunction(
			EditingDomain domain, Function f) {
		Collection<Object> newChildDescriptors = Lists.newArrayList();
		for (Function function : f.getFunctions()) {
			Function eqCopy = (Function) EcoreUtil.copy(function);
			newChildDescriptors.add(createChildParameter(
					LibraryPackage.Literals.FUNCTION__FUNCTIONS, eqCopy));
		}

		return newChildDescriptors;
	}

	private Collection<Object> equimentDescriptorsForTargetEquipment(
			EditingDomain domain, Equipment target) {
		Collection<Object> newChildDescriptors = Lists.newArrayList();
		for (Equipment eq : target.getEquipments()) {
			Equipment eqCopy = (Equipment) EcoreUtil.copy(eq);

			// Set the name as a sequence.
			String newSequenceNumber = EditUtils.INSTANCE.nextSequenceNumber(
					domain, target,
					LibraryPackage.Literals.EQUIPMENT__EQUIPMENTS,
					LibraryPackage.Literals.COMPONENT__NAME);
			eqCopy.setName(newSequenceNumber);
			newChildDescriptors.add(createChildParameter(
					LibraryPackage.Literals.EQUIPMENT__EQUIPMENTS, eqCopy));
		}

		return newChildDescriptors;

	}

	private Collection<? extends Object> functionDescriptorsForTargetNodeType(
			EditingDomain domain, NodeType nodeType) {
		Collection<Object> newChildDescriptors = Lists.newArrayList();
		for (Function function : nodeType.getFunctions()) {
			Function eqCopy = (Function) EcoreUtil.copy(function);
			newChildDescriptors.add(createChildParameter(
					LibraryPackage.Literals.NODE_TYPE__FUNCTIONS, eqCopy));
		}

		return newChildDescriptors;
	}

	private Collection<Object> equimentDescriptorsForTargetNodeType(
			EditingDomain domain, NodeType nodeType) {
		Collection<Object> newChildDescriptors = Lists.newArrayList();
		for (Equipment eq : nodeType.getEquipments()) {
			Equipment eqCopy = (Equipment) EcoreUtil.copy(eq);

			// Set the name as a sequence.
			String newSequenceNumber = EditUtils.INSTANCE.nextSequenceNumber(
					domain, nodeType,
					LibraryPackage.Literals.NODE_TYPE__EQUIPMENTS,
					LibraryPackage.Literals.COMPONENT__NAME);
			eqCopy.setName(newSequenceNumber);
			newChildDescriptors.add(createChildParameter(
					LibraryPackage.Literals.NODE_TYPE__EQUIPMENTS, eqCopy));
		}

		return newChildDescriptors;

	}

}
