/*******************************************************************************
 * Copyright (c) 20 apr. 2014 NetXForge.
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
package com.netxforge.scoping;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractGlobalScopeProvider;
import org.eclipse.xtext.scoping.impl.ImportUriResolver;
import org.eclipse.xtext.scoping.impl.LoadOnDemandResourceDescriptions;
import org.eclipse.xtext.scoping.impl.SelectableBasedScope;
import org.eclipse.xtext.util.IResourceScopeCache;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class SMIGlobalScopeProvider extends AbstractGlobalScopeProvider {

	@Inject
	private ImportUriResolver importResolver;

	@Inject
	private Provider<LoadOnDemandResourceDescriptions> loadOnDemandDescriptions;

	@Inject
	private IResourceScopeCache cache;

	public ImportUriResolver getImportUriResolver() {
		return importResolver;
	}

	public void setImportResolver(ImportUriResolver importResolver) {
		this.importResolver = importResolver;
	}

	public void setCache(IResourceScopeCache cache) {
		this.cache = cache;
	}

	public IResourceDescriptions getResourceDescriptions(Resource resource,
			Collection<URI> importUris) {
		IResourceDescriptions result = getResourceDescriptions(resource);
		LoadOnDemandResourceDescriptions demandResourceDescriptions = loadOnDemandDescriptions
				.get();
		demandResourceDescriptions.initialize(result, importUris, resource);
		return demandResourceDescriptions;
	}

	@Override
	protected IScope getScope(Resource resource, boolean ignoreCase,
			EClass type, Predicate<IEObjectDescription> filter) {
		final LinkedHashSet<URI> uniqueImportURIs = getImportedUris(resource);
		IResourceDescriptions descriptions = getResourceDescriptions(resource,
				uniqueImportURIs);
		List<URI> urisAsList = Lists.newArrayList(uniqueImportURIs);
		Collections.reverse(urisAsList);
		IScope scope = IScope.NULLSCOPE;
		for (URI uri : urisAsList) {
			scope = createLazyResourceScope(scope, uri, descriptions, type,
					filter, ignoreCase);
		}
		return scope;
	}

	protected LinkedHashSet<URI> getImportedUris(final Resource resource) {
		return cache.get(SMIGlobalScopeProvider.class.getName(), resource,
				new Provider<LinkedHashSet<URI>>() {
					public LinkedHashSet<URI> get() {
						TreeIterator<EObject> iterator = resource
								.getAllContents();
						final LinkedHashSet<URI> uniqueImportURIs = new LinkedHashSet<URI>(
								10);
						while (iterator.hasNext()) {
							EObject object = iterator.next();
							String uri = importResolver.apply(object);

							if (uri != null) {
								uri = uri.concat(".mib");
								URI importUri = URI.createURI(uri);
								uniqueImportURIs.add(importUri);
							}
						}
						Iterator<URI> uriIter = uniqueImportURIs.iterator();
						while (uriIter.hasNext()) {
							if (!EcoreUtil2.isValidUri(resource, uriIter.next()))
								uriIter.remove();
						}
						return uniqueImportURIs;
					}
				});
	}

	protected IScope createLazyResourceScope(IScope parent, final URI uri,
			final IResourceDescriptions descriptions, EClass type,
			final Predicate<IEObjectDescription> filter, boolean ignoreCase) {
		IResourceDescription description = descriptions
				.getResourceDescription(uri);
		return SelectableBasedScope.createScope(parent, description, filter,
				type, ignoreCase);
	}

	public void setLoadOnDemandDescriptions(
			Provider<LoadOnDemandResourceDescriptions> loadOnDemandDescriptions) {
		this.loadOnDemandDescriptions = loadOnDemandDescriptions;
	}

	public Provider<LoadOnDemandResourceDescriptions> getLoadOnDemandDescriptions() {
		return loadOnDemandDescriptions;
	}

}
