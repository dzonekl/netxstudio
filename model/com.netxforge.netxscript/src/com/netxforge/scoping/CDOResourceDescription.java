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
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.linking.impl.ImportedNamesAdapter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IDefaultResourceDescriptionStrategy;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.impl.AbstractResourceDescription;
import org.eclipse.xtext.resource.impl.DefaultResourceDescription;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.IAcceptor;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.NetXResource;
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
public class CDOResourceDescription extends AbstractResourceDescription {

	private final static Logger log = Logger
			.getLogger(DefaultResourceDescription.class);
	private IDefaultResourceDescriptionStrategy strategy;
	private ModelUtils modelUtils;

	private final Resource resource;
	private URI uri;

	public CDOResourceDescription(Resource resource,
			IDefaultResourceDescriptionStrategy strategy, ModelUtils modelUtils) {
		this.strategy = strategy;
		this.modelUtils = modelUtils;
		this.resource = resource;
		this.uri = getNormalizedURI(resource);
	}

	public Resource getResource() {
		return resource;
	}

	@Override
	protected List<IEObjectDescription> computeExportedObjects() {

		System.out.println("NETXSCRIPT: Computing exported objects: "
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

		if (getResource() instanceof CDOResource) {

			CDOResource cdoRes = (CDOResource) getResource();
			String repo_name = cdoRes.cdoView().getSession()
					.getRepositoryInfo().getName();

			// ////////////////////////////////////////////////////////////////
			// SPECIAL PROCESSING: OPERATOR RESOURCE, get relevant objects
			// instead
			// of the tree iterator.
			//
			if (normalizedURI.equals(URI.createURI("cdo://" + repo_name
					+ "/Operator"))) {

				// Do a custom walk, to process only functions and equipments.
				EList<EObject> contents = getResource().getContents();
				for (EObject eo : contents) {
					if (eo instanceof Operator) {
						List<Component> componentsForOperator = modelUtils
								.componentsForOperator((Operator) eo);
						for (Component c : componentsForOperator) {
							strategy.createEObjectDescriptions(c, acceptor);
						}
					}
				}
			} else if (normalizedURI.toString().startsWith(
					"cdo://" + repo_name + "/Node_")) {
				// NetXResource pattern:
				EList<EObject> contents = getResource().getContents();
				for (EObject eo : contents) {
					if (eo instanceof NetXResource) {
						strategy.createEObjectDescriptions(eo, acceptor);
					}
				}

			} else {
				// As a last resource, iterate.
				TreeIterator<EObject> allProperContents = EcoreUtil
						.getAllProperContents(getResource(), false);
				while (allProperContents.hasNext()) {
					EObject content = allProperContents.next();
					if (!strategy.createEObjectDescriptions(content, acceptor))
						allProperContents.prune();
				}
			}
		} else {
			// As a last resource, iterate.
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

	public Iterable<QualifiedName> getImportedNames() {
		EcoreUtil2.resolveLazyCrossReferences(resource,
				CancelIndicator.NullImpl);
		ImportedNamesAdapter adapter = ImportedNamesAdapter.find(getResource());
		if (adapter != null) {
			ImmutableSet<QualifiedName> result = ImmutableSet.copyOf(adapter
					.getImportedNames());
			return result;
		}
		return Collections.emptySet();
	}

	public Iterable<IReferenceDescription> getReferenceDescriptions() {
		// return cache.get(REFERENCE_DESCRIPTIONS_CACHE_KEY, getResource(), new
		// Provider<List<IReferenceDescription>>(){
		// public List<IReferenceDescription> get() {
		return computeReferenceDescriptions();
		// }});
	}

	protected List<IReferenceDescription> computeReferenceDescriptions() {
		final List<IReferenceDescription> referenceDescriptions = Lists
				.newArrayList();
		IAcceptor<IReferenceDescription> acceptor = new IAcceptor<IReferenceDescription>() {
			public void accept(IReferenceDescription referenceDescription) {
				referenceDescriptions.add(referenceDescription);
			}
		};
		EcoreUtil2.resolveLazyCrossReferences(resource,
				CancelIndicator.NullImpl);
		Map<EObject, IEObjectDescription> eObject2exportedEObjects = createEObject2ExportedEObjectsMap(getExportedObjects());
		TreeIterator<EObject> contents = EcoreUtil.getAllProperContents(
				this.resource, true);
		while (contents.hasNext()) {
			EObject eObject = contents.next();
			URI exportedContainerURI = findExportedContainerURI(eObject,
					eObject2exportedEObjects);
			if (!strategy.createReferenceDescriptions(eObject,
					exportedContainerURI, acceptor))
				contents.prune();
		}
		return referenceDescriptions;
	}

	protected Map<EObject, IEObjectDescription> createEObject2ExportedEObjectsMap(
			Iterable<IEObjectDescription> exportedObjects) {
		Map<EObject, IEObjectDescription> uri2exportedEObjects = Maps
				.newHashMap();
		for (IEObjectDescription eObjectDescription : exportedObjects) {
			uri2exportedEObjects.put(eObjectDescription.getEObjectOrProxy(),
					eObjectDescription);
		}
		return uri2exportedEObjects;
	}

	protected URI findExportedContainerURI(EObject referenceOwner,
			Map<EObject, IEObjectDescription> eObject2exportedEObjects) {
		EObject currentContainer = referenceOwner;
		while (currentContainer != null) {
			IEObjectDescription currentContainerEObjectDescription = eObject2exportedEObjects
					.get(currentContainer);
			if (currentContainerEObjectDescription != null) {
				return currentContainerEObjectDescription.getEObjectURI();
			}
			currentContainer = currentContainer.eContainer();
		}
		return null;
	}

	public URI getURI() {
		return uri;
	}

}
