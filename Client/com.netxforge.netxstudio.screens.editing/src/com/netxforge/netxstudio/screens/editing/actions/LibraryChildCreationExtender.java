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
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.EditingDomain;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.generics.GenericsFactory;
import com.netxforge.netxstudio.generics.Lifecycle;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.LibraryFactory;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.operators.Node;

/**
 * Custom child extender, capable to add conditional ( Type etc...) child
 * descriptors It works best, by disabling the generated EMF descriptors.
 * 
 * Note: This is called for all EObject of the specified extender package, so
 * first check the target eclass.
 * 
 * @author dzonekl
 */
public class LibraryChildCreationExtender extends
		AbstractConditionalChildCreationExtender {

	protected ModelUtils modelUtils;

	@Inject
	public LibraryChildCreationExtender(ModelUtils modelUtils) {
		this.modelUtils = modelUtils;
	}

	public Collection<?> getNewChildDescriptors(Object object,
			EditingDomain editingDomain) {
		Collection<Object> newChildDescriptors = Lists.newArrayList();

		if (object instanceof EObject) {
			EObject target = (EObject) object;

			if (target instanceof Component || target instanceof NodeType) {
				Node node = modelUtils.resolveParentNode(target);
				if (node != null && node.getOriginalNodeTypeRef() != null) {
					NodeType ntRef = node.getOriginalNodeTypeRef();
					if (target.eClass() == LibraryPackage.Literals.NODE_TYPE) {
						// Handled by the Node child creation has NodeType is
						// not visible in the Design view.
					} else if (target.eClass() == LibraryPackage.Literals.EQUIPMENT) {
						Equipment targetEq = (Equipment) target;
						newChildDescriptors = newEquimentDescriptorsForTargetNodeType(
								ntRef, targetEq);
					} else if (target.eClass() == LibraryPackage.Literals.FUNCTION) {
						Function function = LibraryFactory.eINSTANCE.createFunction();
						
						Lifecycle newLC = GenericsFactory.eINSTANCE
								.createLifecycle();
						newLC.setProposed(modelUtils.toXMLDate(modelUtils
								.todayAndNow()));
						function.setLifecycle(newLC);
						
						newChildDescriptors.add(createChildParameter(
								LibraryPackage.Literals.FUNCTION__FUNCTIONS,function
								));
					}
				} else {
					if (target instanceof Equipment) {
						newChildDescriptors.add(createChildParameter(
								LibraryPackage.Literals.EQUIPMENT__EQUIPMENTS,
								LibraryFactory.eINSTANCE.createEquipment()));

					} else if (target instanceof Function) {
						newChildDescriptors.add(createChildParameter(
								LibraryPackage.Literals.FUNCTION__FUNCTIONS,
								LibraryFactory.eINSTANCE.createFunction()));
					}
				}
			} else {
				System.out
						.println("CreateChildExtender: no parent Node object found");
			}
		}

		return newChildDescriptors;
	}

	private Collection<Object> newEquimentDescriptorsForTargetNodeType(
			NodeType nodeType, Equipment targetEq) {
		// find the object from the ref and return all possible
		// creation references.
		// TODO, possibly optimize, by filtering non Equipments.

		Collection<Object> newChildDescriptors = Lists.newArrayList();

		TreeIterator<EObject> it = nodeType.eAllContents();
		while (it.hasNext()) {
			EObject next = it.next();
			if (next.eClass() == LibraryPackage.Literals.EQUIPMENT) {

				// Match on equipmentcode.
				Equipment eq = (Equipment) next;
				if (eq.getEquipmentCode().equals(targetEq.getEquipmentCode())) {
					System.out.println("CreateChildExtender:  target found");
					// get children and build descriptors.
					EList<EObject> directContent = next.eContents();
					for (EObject targetChild : directContent) {
						System.out.println("CreateChildExtender:  add child"
								+ targetChild);
						if (targetChild instanceof Equipment) {
							Equipment eqCopy = (Equipment) EcoreUtil
									.copy(targetChild);
							// Set the name as a sequence.
							String newSequenceNumber = modelUtils
									.getSequenceNumber(
											targetEq,
											LibraryPackage.Literals.EQUIPMENT__EQUIPMENTS,
											LibraryPackage.Literals.COMPONENT__NAME);
							eqCopy.setName(newSequenceNumber);

							Lifecycle newLC = GenericsFactory.eINSTANCE
									.createLifecycle();
							newLC.setProposed(modelUtils.toXMLDate(modelUtils
									.todayAndNow()));
							eqCopy.setLifecycle(newLC);

							newChildDescriptors
									.add(createChildParameter(
											LibraryPackage.Literals.EQUIPMENT__EQUIPMENTS,
											eqCopy));
						}
					}
				}
			}
		}

		return newChildDescriptors;

	}

}
