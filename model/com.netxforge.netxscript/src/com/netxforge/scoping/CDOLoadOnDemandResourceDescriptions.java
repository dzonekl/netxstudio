/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.netxforge.scoping;

import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Manager;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.ISelectable;
import org.eclipse.xtext.resource.impl.AbstractCompoundSelectable;

import com.google.common.base.Function;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.netxforge.netxstudio.data.IDataService;
import com.netxforge.netxstudio.library.LibraryPackage;

/**
 * Customized version of LoadOnDemandDescriptions, the original version uses
 * ECoreUtil2 (From xtext) in method getResourceDescription to resolve the
 * resource from a URI. This works out to invoke the CDOResourceFactory, which
 * will create an "un-attached" resource. This implementation, use a data
 * provider instead.
 * 
 * 
 * Note: This xResourceDescriptions, is likely not capable to be notified of 
 * model changes, and re-index based on this.  
 * 
 * 
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 */
public class CDOLoadOnDemandResourceDescriptions extends
		AbstractCompoundSelectable implements IResourceDescriptions {

	private IResourceDescriptions delegate;
	private Collection<URI> validUris;
	@SuppressWarnings("unused")
	private Resource context;

	@Inject
	private IDataService dataService;

	@Inject
	private IResourceServiceProvider.Registry serviceProviderRegistry;

	public void initialize(IResourceDescriptions delegate,
			Collection<URI> validUris, Resource context) {
		this.delegate = delegate;
		this.validUris = validUris;
		this.context = context;
	}

	public Iterable<IResourceDescription> getAllResourceDescriptions() {
		return Iterables.filter(Iterables.transform(validUris,
				new Function<URI, IResourceDescription>() {
					public IResourceDescription apply(URI from) {
						return getResourceDescription(from);
					}
				}), Predicates.notNull());
	}

	@Override
	public boolean isEmpty() {
		return validUris.isEmpty();
	}

	@Override
	protected Iterable<? extends ISelectable> getSelectables() {
		return getAllResourceDescriptions();
	}

	/**
	 * Get the ResourceServiceProvider manager, and get the resource description
	 * from it.
	 * 
	 */
	public IResourceDescription getResourceDescription(URI uri) {
		IResourceDescription result = delegate.getResourceDescription(uri);
		if (result == null) {

			// Customized, version which get the original CDO resource from the
			// CDO URI through
			// a session, the original EcoreUtil2, tries also to resolve the URI
			// as an absolute URI, to the
			// provided context resource, which doesn't apply for a CDO
			// resource.

			// Resource resource = EcoreUtil2.getResource(context,
			// uri.toString());
			assert dataService != null : new java.lang.IllegalStateException(
					"Data Service should be initialized");

			Resource resource = null;
			try {
				resource = dataService.getProvider().getResource(
						LibraryPackage.Literals.LIBRARY);
			} catch (IllegalStateException e) {
				// No connection, abort global scoping!
			}

			if (resource != null) {
				IResourceServiceProvider serviceProvider = serviceProviderRegistry
						.getResourceServiceProvider(uri);
				if (serviceProvider == null)
					throw new IllegalStateException("No "
							+ IResourceServiceProvider.class.getSimpleName()
							+ " found in registry for uri " + uri);
				final Manager resourceDescriptionManager = serviceProvider
						.getResourceDescriptionManager();
				if (resourceDescriptionManager == null)
					throw new IllegalStateException("No "
							+ IResourceDescription.Manager.class.getName()
							+ " provided by service provider for URI " + uri);
				result = resourceDescriptionManager
						.getResourceDescription(resource);
			}
		}
		return result;
	}

}
