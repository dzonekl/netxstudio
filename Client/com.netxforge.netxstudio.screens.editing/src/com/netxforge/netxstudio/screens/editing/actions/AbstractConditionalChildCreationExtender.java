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

import java.text.DecimalFormat;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.EMFEditPlugin;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IChildCreationExtender;

import com.google.common.collect.Lists;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.operators.Node;


/**
 * Custom child extender, capable to add conditional ( Type etc...) child descriptors
 * It works best, by disabling the generated EMF descriptors. 
 *  
 * @author dzonekl
 */
public abstract class AbstractConditionalChildCreationExtender implements IChildCreationExtender {

	public Collection<?> getNewChildDescriptors(Object object,
			EditingDomain editingDomain) {

		Collection<Object> newChildDescriptors = Lists.newArrayList();
		return newChildDescriptors;
	}

	public void setSequenceNumber(Equipment targetEq, Equipment eqCopy) {
		int size = targetEq.getEquipments().size();
		String newName = null;
		if (size > 0) {
			Equipment lastChild = targetEq.getEquipments().get(size - 1);
			if (lastChild.eIsSet(LibraryPackage.Literals.COMPONENT__NAME)) {
				String lastName = lastChild.getName();
				// See if the last 2 chars are a digit.
				try {

					Pattern MY_PATTERN = Pattern.compile("[0-9]*");
					Matcher m = MY_PATTERN.matcher(lastName);
					String lastDigits = null;
					while (m.find()) {
						String match = m.group();
						if (!match.isEmpty())
							lastDigits = match;
					}
					if (lastDigits != null) {
						String nameWithNoDigits = lastName.substring(0,
								lastName.indexOf(lastDigits));
						try {
							Integer ld = new Integer(lastDigits);
							ld++;
							// Perhaps format with 0...
							
							// Do a simple text format. 
							DecimalFormat format = new DecimalFormat();
							format.applyPattern("###");
							newName = nameWithNoDigits + format.format(ld);

						} catch (NumberFormatException nfe) {
							System.err
									.println("ChildCreationExtender: Can't formart"
											+ lastDigits);
						}
					}
				} catch (PatternSyntaxException pse) {
					System.err.println("ChildCreationExtender: Wrong syntax");
				}
			}
		}
		if (newName == null) {
			newName = "1";
		}
		eqCopy.setName(newName);

	}

	public ResourceLocator getResourceLocator() {
		return EMFEditPlugin.INSTANCE;
	}

	protected CommandParameter createChildParameter(Object feature, Object child) {
		return new CommandParameter(null, feature, child);
	}

	public Node resolveParentNode(EObject current) {
		if (current != null && current.eContainer() != null) {
			if (current.eContainer() instanceof Node) {
				return (Node) current.eContainer();
			} else {
				return resolveParentNode(current.eContainer());
			}
		} else {
			return null;
		}
	}

}
