package com.netxforge.scoping;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.cdo.view.CDOView;
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
import com.netxforge.internal.RuntimeActivator;
import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.data.cdo.CDODataProvider;

public abstract class AbstractDynamixCDOResourceDescriptions extends
		AbstractCompoundSelectable implements IResourceDescriptions {

	public abstract IDataProvider getDataProvider();

	boolean initialized = false;

	@Inject
	private IResourceServiceProvider.Registry serviceProviderRegistry;

	private DynamixCache<URI, IResourceDescription> resourceDescriptionCache;

	public void initialize(Collection<URI> scopedURIs, final CDOView view) {

		if (!initialized) {
			initialized = true;

			resourceDescriptionCache = new DynamixCache<URI, IResourceDescription>(
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
									if (uri.segmentCount() > 1) {
										lookup = uri.path();

									} else {
										lookup = '/' + uri.lastSegment();
									}

									// This should attach our listener to the
									// resources.
									resource = ((CDODataProvider) provider)
											.getResource(view, lookup);

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
	
	
	/**
	 * Note as our cache will be initially empty, this will not return anything unless
	 */
	public Iterable<IResourceDescription> getAllResourceDescriptions() {
		
		List<URI> uris = this.resourceDescriptionCache.getKeys();
		return Iterables.filter(Iterables.transform(uris,
				new Function<URI, IResourceDescription>() {
					public IResourceDescription apply(URI from) {
						return getResourceDescription(from);
					}
				}), Predicates.notNull());
	}

	@Override
	public boolean isEmpty() {
		return this.resourceDescriptionCache.isEmpty();
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

		assert resourceDescriptionCache != null : "--- NETXSCRIPT: cache not initialized";

		if (RuntimeActivator.DEBUG) {
			System.out.println("--- NETXSCRIPT: Get description for URI: "
					+ uri.toString());
		}
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
			System.out
					.println("--- NETXSCRIPT: Building Description for resource: "
							+ resource.getURI().toString());
			return resourceDescriptionManager.getResourceDescription(resource);
		}
		return null;
	}

	public void update(List<URI> dirtyURIs) {

		for (URI dirtyURI : dirtyURIs) {
			if (resourceDescriptionCache.hasCachedValue(dirtyURI)) {
				resourceDescriptionCache.discard(dirtyURI);
				resourceDescriptionCache.get(dirtyURI); // should force an
														// apply() and reload.
			}
		}
	}

	public void add(URI addScopedURI) {
		if (!resourceDescriptionCache.hasCachedValue(addScopedURI)) {
			resourceDescriptionCache.get(addScopedURI); // should force an
														// apply() and initial
														// load.
		}
	}

	public void remove(URI removeScopedURI) {
		if (resourceDescriptionCache.hasCachedValue(removeScopedURI)) {
			resourceDescriptionCache.discard(removeScopedURI);
		}
	}

}
