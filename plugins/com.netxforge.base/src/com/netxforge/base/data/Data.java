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
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Factory;
import org.eclipse.emf.ecore.resource.Resource.Factory.Registry;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.netxforge.base.DelegateComponentLifecycle;
import com.netxforge.base.IDelegateComponentLifecycle;

public class Data implements IBaseData {

	// Do not as we would require multiple inheritance.
	final IDelegateComponentLifecycle lcDelegate = new DelegateComponentLifecycle();
	static String user_home_path = System.getProperty("user.home");

	public Resource getResource(ResourceSet set, EClass clazz) {

		// TODO Build a dynamic Map<EClass, Extension> to avoid lookup each
		// time.
		String packageName = clazz.getEPackage().getName();
		String extension = extensionForFactory(packageName);

		URI uri = uriForEClassName(packageName, extension);
		try{
			return getResource(set, uri);
		}catch(Exception e){
			return createResource(set, uri);
		}
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
		// Does the file exist?
		Resource resource = set.getResource(uri, true);
		return resource;
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

	/**
	 * @param name
	 * @param extension2
	 * @return
	 */
	private URI uriForEClassName(String name, String extension) {
		// Generate the URI, take the path from the properties.

		String path = user_home_path;
		URI uri = URI.createFileURI(path + "/" + name + "." + extension);
		return uri;
	}
	
	/**
	 * Resolve the extension from the {@link Registry}
	 * 
	 * @param packageName
	 */
	public String extensionForFactory(final String packageName) {
		Registry instance = Resource.Factory.Registry.INSTANCE;

		Map<String, Object> extensionToFactoryMap = instance
				.getExtensionToFactoryMap();
		for (Entry<String, Object> entry : extensionToFactoryMap.entrySet()) {
			Object value = entry.getValue();
			if (value instanceof Resource.Factory) {
				if (packageNameMatchesFactory((Factory) value, packageName)) {
					return entry.getKey();
				}
			} else if (value instanceof Resource.Factory.Descriptor) {
				Resource.Factory factory = ((Resource.Factory.Descriptor) value)
						.createFactory();
				if (packageNameMatchesFactory(factory, packageName)) {
					return entry.getKey();
				}
			}
		}
		throw new IllegalStateException(
				"Expected to find an extension for factory:" + packageName);
	}

	private boolean packageNameMatchesFactory(Resource.Factory factory,
			String packageName) {
		// Hack, use the name of the factory which will be the same as
		// the package name.
		String simpleName = factory.getClass().getSimpleName();
		simpleName = simpleName.toLowerCase();
		return simpleName.startsWith(packageName);
	}

	/**
	 * 
	 * @param set
	 * @param uri
	 * @return
	 */
	private Resource createResource(ResourceSet set, URI uri) {
		Resource resource = set.createResource(uri);
		return resource;
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
