/*******************************************************************************
 * Copyright (c) Feb 17, 2012 NetXForge.
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
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.DescriptionUtils;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IDefaultResourceDescriptionStrategy;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Delta;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionDelta;

import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.netxforge.netxstudio.common.model.ModelUtils;


/**
 * Resource Description manager which doesn't use a OnChangeEvictingCache like 
 * the default implementation, this cache has an EContentAdapter which would stick 
 * into the complete CDO Resource containment hierarchy. As CDO Caches objects,
 * we simply let CDO return the wanted objects. 
 * 
 * 
 * Also the exported objects and exported references are calculated not by walking the complete hierarchy, 
 * but really returning for interested objects only.
 * 
 * 
 * @author Christophe
 *
 */
@Singleton
public class CDOResourceDescriptionManager implements IResourceDescription.Manager {

	@Inject
	private IDefaultResourceDescriptionStrategy strategy;
	
	@Inject
	private IContainer.Manager containerManager;
	
	
	
	// Do not cache here, we do that ourselves. 
//	@Inject
//	private IResourceScopeCache cache = IResourceScopeCache.NullImpl.INSTANCE;
	
	@Inject
	private DescriptionUtils descriptionUtils;
	
	@Inject 
	private ModelUtils modelUtils;
	
//	private static final String CACHE_KEY = DefaultResourceDescriptionManager.class.getName() + "#getResourceDescription";
	
	public IResourceDescription getResourceDescription(final Resource resource) {
		
		return internalGetResourceDescription(resource, strategy);
		
//		return cache.get(CACHE_KEY, resource, new Provider<IResourceDescription>() {
//			public IResourceDescription get() {
//				return internalGetResourceDescription(resource, strategy);
//			}
//		});
	}
	
	public Delta createDelta(IResourceDescription oldDescription, IResourceDescription newDescription) {
		return new DefaultResourceDescriptionDelta(oldDescription, newDescription);
	}

	protected IResourceDescription internalGetResourceDescription(Resource resource, IDefaultResourceDescriptionStrategy strategy) {
		return new CDOResourceDescription(resource, strategy, modelUtils);
	}
	
	public IContainer.Manager getContainerManager() {
		return containerManager;
	}
	
	public void setContainerManager(IContainer.Manager containerManager) {
		this.containerManager = containerManager;
	}
	
//	public void setCache(IResourceScopeCache cache) {
//		this.cache = cache;
//	}
//	
//	public IResourceScopeCache getCache() {
//		return cache;
//	}
	

	public boolean isAffected(Delta delta, IResourceDescription candidate) throws IllegalArgumentException {
		if (!delta.haveEObjectDescriptionsChanged())
			return false;
		Set<QualifiedName> names = Sets.newHashSet();
		addExportedNames(names,delta.getOld());
		addExportedNames(names,delta.getNew());
		return !Collections.disjoint(names, getImportedNames(candidate));
	}

	protected Collection<QualifiedName> getImportedNames(IResourceDescription candidate) {
		return Sets.newHashSet(candidate.getImportedNames());
	}

	protected void addExportedNames(Set<QualifiedName> names, IResourceDescription resourceDescriptor) {
		if (resourceDescriptor==null)
			return;
		Iterable<IEObjectDescription> iterable = resourceDescriptor.getExportedObjects();
		for (IEObjectDescription ieObjectDescription : iterable) {
			names.add(ieObjectDescription.getName().toLowerCase());
		}
	}
	
    public boolean isAffected(Collection<Delta> deltas, IResourceDescription candidate, IResourceDescriptions context) {
        Set<URI> outgoingReferences = descriptionUtils.collectOutgoingReferences(candidate);
        if (!outgoingReferences.isEmpty()) {
	        for (IResourceDescription.Delta delta : deltas)
	            if (delta.haveEObjectDescriptionsChanged() && outgoingReferences.contains(delta.getUri()))
	                return true;
        }
        // this is a tradeoff - we could either check whether a given delta uri is contained
        // in a reachable container and check for intersecting names afterwards, or we can do
        // the other way round
        // unfortunately there is no way to decide reliably which algorithm scales better
        // note that this method is called for each description so we have something like a 
        // number of deltas x number of resources which is not really nice
        List<IContainer> containers = null;
        Collection<QualifiedName> importedNames = getImportedNames(candidate);
        for (IResourceDescription.Delta delta : deltas) {
			if (delta.haveEObjectDescriptionsChanged()) {
				// not a java resource - delta's resource should be contained in a visible container
				// as long as we did not delete the resource
				URI uri = delta.getUri();
				if ((uri.isPlatform() || uri.isArchive()) && delta.getNew() != null) { 
					if (containers == null)
						containers = containerManager.getVisibleContainers(candidate, context);
					boolean descriptionIsContained = false;
					for(int i = 0; i < containers.size() && !descriptionIsContained; i++) {
						descriptionIsContained = containers.get(i).hasResourceDescription(uri);
					}
					if (!descriptionIsContained)
						return false;
				}
				if (isAffected(importedNames, delta.getNew()) || isAffected(importedNames, delta.getOld())) {
					return true;
				}
			}
        }
        return false;
    }

	protected boolean isAffected(Collection<QualifiedName> importedNames, IResourceDescription description) {
		if (description != null) {
		    for (IEObjectDescription desc : description.getExportedObjects())
		        if (importedNames.contains(desc.getName().toLowerCase()))
		            return true;
		}
		return false;
	}
	
	public DescriptionUtils getDescriptionUtils() {
		return descriptionUtils;
	}
	
	public void setDescriptionUtils(DescriptionUtils descriptionUtils) {
		this.descriptionUtils = descriptionUtils;
	}
	
	public void setStrategy(IDefaultResourceDescriptionStrategy strategy) {
		this.strategy = strategy;
	}
}