/*******************************************************************************
 * Copyright (c) 11 mrt. 2014 NetXForge.
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
package com.netxforge.base.data;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.netxforge.base.DelegateComponentLifecycle;
import com.netxforge.base.IDelegateComponentLifecycle;

public class Data implements IBaseData {

	// Do not as we would require multiple inheritance.
	final IDelegateComponentLifecycle lcDelegate = new DelegateComponentLifecycle();

	public Resource getResource(ResourceSet set, EClass clazz) {
		throw new UnsupportedOperationException("TODO Implement");
	}

	public Resource getResource(ResourceSet set, String resourcePath) {
		throw new UnsupportedOperationException("TODO Implement");
	}

	public Resource getResource(ResourceSet set, int feature) {
		throw new UnsupportedOperationException("TODO Implement");
	}

	public Resource getResource(int feature) {
		throw new UnsupportedOperationException("TODO Implement");
	}

	public boolean hasResource(URI resourceURI) {
		throw new UnsupportedOperationException("TODO Implement");
	}

	public boolean hasResource(String resourcePath) {
		throw new UnsupportedOperationException("TODO Implement");
	}

	public Resource getResource(EClass clazz) {
		throw new UnsupportedOperationException("TODO Implement");
	}

	public Resource getResource(ResourceSet set, URI uri) {
		throw new UnsupportedOperationException("TODO Implement");
	}

	public Resource getResource(URI uri) {
		throw new UnsupportedOperationException("TODO Implement");
	}

	public Resource getResource(String resourcePath) {
		throw new UnsupportedOperationException("TODO Implement");
	}

	public List<Resource> getResources(ResourceSet set, String resourcePath) {
		throw new UnsupportedOperationException("TODO Implement");
	}

	public List<Resource> getResources(String resourcePath) {
		throw new UnsupportedOperationException("TODO Implement");
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
		lcDelegate.deregister(source);
	}

}
