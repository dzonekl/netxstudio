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

import static com.google.common.collect.Lists.newArrayList;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.IDefaultResourceDescriptionStrategy;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.impl.DefaultResourceDescription;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.IResourceScopeCache;

import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.operators.Operator;

/**
 * Override the default behavior, which uses a TreeIterator to get all potential
 * objects, we are more selective knowing the resource we deal with.
 * 
 * We are not sure we need the descriptions for the references???
 * 
 * 
 * @author Christophe
 * 
 */
public class CDOResourceDescription extends DefaultResourceDescription {

	private final static Logger log = Logger
			.getLogger(DefaultResourceDescription.class);
	private IDefaultResourceDescriptionStrategy strategy;
	private ModelUtils modelUtils;

	public CDOResourceDescription(Resource resource,
			IDefaultResourceDescriptionStrategy strategy,
			IResourceScopeCache cache, ModelUtils modelUtils) {
		super(resource, strategy, cache);
		this.strategy = strategy;
		this.modelUtils = modelUtils;
	}

	public CDOResourceDescription(Resource resource,
			IDefaultResourceDescriptionStrategy strategy) {
		super(resource, strategy, new IResourceScopeCache.NullImpl());
	}

	@Override
	protected List<IEObjectDescription> computeExportedObjects() {

		System.out.println("Computing exported objects: "
				+ getNormalizedURI(getResource()).toString());
		
		if (!getResource().isLoaded()) {
			try {
				getResource().load(null);
			} catch (IOException e) {
				log.error(e.getMessage(), e);
				return Collections.<IEObjectDescription> emptyList();
			}
		}
		final List<IEObjectDescription> exportedEObjects = newArrayList();
		IAcceptor<IEObjectDescription> acceptor = new IAcceptor<IEObjectDescription>() {
			public void accept(IEObjectDescription eObjectDescription) {
				exportedEObjects.add(eObjectDescription);
			}
		};

		URI normalizedURI = getNormalizedURI(getResource());
		
		
		
		//////////////////////////////////////////////////////////////////
		// SPECIAL PROCESSING: OPERATOR RESOURCE. 
		if (normalizedURI.equals(URI.createURI("cdo://repo1/Operator"))) {
			
			// Do a custom walk, to process only functions and equipments.
			EList<EObject> contents = getResource().getContents();
			for (EObject eo : contents) {
				if (eo instanceof Operator) {
					List<Component> componentsForOperator = modelUtils.componentsForOperator((Operator) eo);
					for( Component c : componentsForOperator){
						strategy.createEObjectDescriptions(c, acceptor);	
					}
				}
			}
		} else {

			TreeIterator<EObject> allProperContents = EcoreUtil
					.getAllProperContents(getResource(), false);
			while (allProperContents.hasNext()) {
				EObject content = allProperContents.next();
				if (!strategy.createEObjectDescriptions(content, acceptor))
					allProperContents.prune();
			}
		}
		return exportedEObjects;
	}
	
	
	

}
