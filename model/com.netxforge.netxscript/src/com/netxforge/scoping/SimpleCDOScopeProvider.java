package com.netxforge.scoping;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractGlobalScopeProvider;
import org.eclipse.xtext.scoping.impl.SelectableBasedScope;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.netxforge.netxstudio.data.IDataService;

/**
 * A simple CDOScope provider, which returns all potential references. (Without filtering). 
 * Uses a custom CDOLoadOnDemandResourceDescriptions.
 * 
 * @author dzonekl
 */
public class SimpleCDOScopeProvider extends AbstractGlobalScopeProvider {
	
	
	// Inject our data service. 
	@Inject
	IDataService dataService;
	
	@Inject
	private Provider<CDOLoadOnDemandResourceDescriptions> loadOnDemandDescriptions;

	
	@Override
	protected IScope getScope(Resource resource, boolean ignoreCase,
			EClass type, Predicate<IEObjectDescription> filter) {
		
		final LinkedHashSet<URI> uniqueImportURIs = new LinkedHashSet<URI>(10);
		
		// FIXME, perhaps we can find a better way to get CDO uri's, which will be 
		// resolved further on. 
		uniqueImportURIs.add(URI.createURI("cdo://repo1/library"));
		
		IResourceDescriptions descriptions = getResourceDescriptions(resource, uniqueImportURIs);

		List<URI> urisAsList = Lists.newArrayList(uniqueImportURIs);
		Collections.reverse(urisAsList);

		IScope scope = IScope.NULLSCOPE;
		for (URI uri : urisAsList) {
			scope = createLazyResourceScope(scope, uri, descriptions, type, filter, ignoreCase);
		}
		return scope;
		
	}
	
	
	/**
	 * Requires, a IResourceServiceProvider which can deal with the CDO URI.
	 * 
	 * @param parent
	 * @param uri
	 * @param descriptions
	 * @param type
	 * @param filter
	 * @param ignoreCase
	 * @return
	 */
	protected IScope createLazyResourceScope(IScope parent, final URI uri, final IResourceDescriptions descriptions,
			EClass type, final Predicate<IEObjectDescription> filter, boolean ignoreCase) {
		IResourceDescription description = descriptions.getResourceDescription(uri);
		
		return SelectableBasedScope.createScope(parent, description, filter, type, ignoreCase);
	}
	
	/**
	 * Get the resource descriptions, using a custom <code>CDOLoadOnDemandResourceDescriptions.</code> 
	 * @param resource
	 * @param importUris
	 * @return
	 */
	public IResourceDescriptions getResourceDescriptions(Resource resource, Collection<URI> importUris) {
		IResourceDescriptions result = getResourceDescriptions(resource);
		CDOLoadOnDemandResourceDescriptions demandResourceDescriptions = loadOnDemandDescriptions.get();
		demandResourceDescriptions.initialize(result, importUris, resource);
		return demandResourceDescriptions;
	}
	
}
