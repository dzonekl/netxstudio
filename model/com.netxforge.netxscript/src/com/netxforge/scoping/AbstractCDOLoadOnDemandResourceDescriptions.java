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
import com.netxforge.netxstudio.data.IDataProvider;

public abstract class AbstractCDOLoadOnDemandResourceDescriptions extends
		AbstractCompoundSelectable implements IResourceDescriptions {

	protected abstract IDataProvider getDataProvider();

	private IResourceDescriptions delegate;
	private Collection<URI> validUris;
	@SuppressWarnings("unused")
	private Resource context;

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
		
		
		// FIXME, We don't delegate, as we override the provider, and will otherwise delegate to self. 
		// 
		// IResourceDescription result = delegate.getResourceDescription(uri);
		// if (result == null) {
		IResourceDescription result = null;

		// Customized, version which get the original CDO resource from the
		// CDO URI through
		// a session, the original EcoreUtil2, tries also to resolve the URI
		// as an absolute URI, to the
		// provided context resource, which doesn't apply for a CDO
		// resource.

		// Resource resource = EcoreUtil2.getResource(context,
		// uri.toString());
		assert getDataProvider() != null : new java.lang.IllegalStateException(
				"Data Service should be initialized");

		Resource resource = null;
		try {

			// Setup a session, as we likely don't have one here.
			resource = getDataProvider().getResource(uri);

		} catch (IllegalStateException e) {
			// No connection, abort global scoping!
			e.printStackTrace();
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
		// }
		return result;
	}
}
