package com.netxforge.scoping;

import java.util.Collection;

import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Manager;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.ISelectable;
import org.eclipse.xtext.resource.impl.AbstractCompoundSelectable;
import org.eclipse.xtext.util.SimpleCache;

import com.google.common.base.Function;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.data.cdo.CDODataProvider;

public abstract class AbstractFixedSetCDOResourceDescriptions extends
		AbstractCompoundSelectable implements IResourceDescriptions {

	protected abstract IDataProvider getDataProvider();

	private Collection<URI> validUris;
	
	boolean initialized = false;

	@Inject
	private IResourceServiceProvider.Registry serviceProviderRegistry;

	private SimpleCache<URI, IResourceDescription> resourceDescriptionCache;


	public void initialize(Collection<URI> validUris,
			final CDOTransaction transaction) {
		if (!initialized) {
			this.validUris = validUris;
			initialized = true;

			resourceDescriptionCache = new SimpleCache<URI, IResourceDescription>(
					new Function<URI, IResourceDescription>() {
						public IResourceDescription apply(URI uri) {

							assert getDataProvider() != null : new java.lang.IllegalStateException(
									"Data Service should be initialized");

							Resource resource = null;
							System.out.println("cached not used");
							try {
								// System.out.println("--Run Scope builder Reading resource: "
								// +
								// uri.toString());
								// Setup a session, as we likely don't have one
								// here.
								IDataProvider provider = getDataProvider();
								if (provider instanceof CDODataProvider) {
									
									String lookup;
									if(uri.segmentCount() > 1 ){
										lookup = uri.path();
										
									}else{
										lookup = '/' + uri
												.lastSegment();
									}
									
									resource = ((CDODataProvider) provider)
											.getResource((CDOView) transaction,
													lookup);
									// System.out.println("--Done Scope builder Reading resource: "
									// +
									// uri.toString());
									IResourceDescription description = getDescription(
											uri, resource);
									return description;
								}
							} catch (IllegalStateException e) {
								// No connection, abort global scoping!
								e.printStackTrace();
							}

							return null;
						}
					});
		}
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
		return resourceDescriptionCache.get(uri);
	}

	private IResourceDescription getDescription(URI uri, Resource resource) {
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

			// Do we cache our resource description?
			// System.out.println("---Building Description for resource: " +
			// resource.getURI().toString());
			return resourceDescriptionManager.getResourceDescription(resource);
			// System.out.println("---Done building description for resource: "
			// + resource.getURI().toString());
		}
		return null;
	}
}
