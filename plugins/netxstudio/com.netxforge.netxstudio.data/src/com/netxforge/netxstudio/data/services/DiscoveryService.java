/*******************************************************************************
 * Copyright (c) 8 apr. 2014 NetXForge.
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
package com.netxforge.netxstudio.data.services;

import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.netxforge.base.DelegateComponentLifecycle;
import com.netxforge.base.IComponentLifecycle;
import com.netxforge.base.IDelegateComponentLifecycle;
import com.netxforge.netxstudio.data.index.IComponentLocator.IdentifierDescriptor;
import com.netxforge.netxstudio.data.index.IComponentLocator.MetricDescriptor;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.operators.Node;

/**
 * Persists {@link IdentifierDescriptor descriptors} for further processing,
 * like creating {@link Component} under a specified {@link Node}.
 * 
 * Participates in {@link IComponentLifecycle}
 * 
 * @author Christophe Bouhier
 */
public class DiscoveryService implements IComponentLifecycle {

	final IDelegateComponentLifecycle lcDelegate = new DelegateComponentLifecycle();

	public DiscoveryService() {

	}

	public void addComponentCandidate(
			List<IdentifierDescriptor> identifierDescriptors,
			MetricDescriptor md) {

		for (IdentifierDescriptor descriptor : identifierDescriptors) {

			String identifier = descriptor.getIdentifier();
			System.out.println("Descriptor value:" + identifier);

			EStructuralFeature propertyFeature = descriptor
					.getPropertyFeature();

			if (propertyFeature instanceof EAttribute) {
				EAttribute attrib = (EAttribute) propertyFeature;
				System.out.println("Descriptor feature:" + attrib);
			}
		}
	}

	public void activate(Object source) {
		lcDelegate.activate(source, this);
	}

	public void deactivate(Object source) {
		lcDelegate.deactivate(source, this);

	}

	public void register(Object source) {
		lcDelegate.register(source);
	}

	public void deregister(Object source) {
		lcDelegate.register(source);
	}

}
