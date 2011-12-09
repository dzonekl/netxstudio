package com.netxforge.scoping;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.cdo.eresource.CDOResourceFolder;
import org.eclipse.emf.cdo.eresource.CDOResourceNode;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.common.util.EList;
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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.netxforge.internal.RuntimeActivator;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.services.ServicesPackage;

/**
 * 
 * A scope providers which attaches itself to some CDO resources, and performs
 * updates on the scope whenever the CDO targets invalidations are received. The
 * descriptions are build in the background.
 * 
 * @author dzonekl
 */
public class DynamixCDOScopeProvider extends AbstractGlobalScopeProvider {

	private static String REPO_NAME = "repo1";

	// @Inject
	private Provider<IResourceDescriptions> loadOnDemandDescriptions;

	private ModelUtils modelUtils;

	private CDOView view;

	/*
	 * Our fixed list of URI's for which we should resolve.
	 */
	private ImmutableMap<EClass, List<URI>> eClassToURIMap;

	/*
	 * 
	 */
	private IResourceDescriptions descriptions;

	private DynamixCDOScopeListener cdoScopeListener;

	@Inject
	public DynamixCDOScopeProvider(
			Provider<IResourceDescriptions> descriptionsProvider,
			ModelUtils modelUtils) {
		super();

		this.modelUtils = modelUtils;
		this.loadOnDemandDescriptions = descriptionsProvider;

		// Use a singleton transaction.
		if (view == null) {
			descriptions = loadOnDemandDescriptions.get();
			if (descriptions instanceof AbstractDynamixCDOResourceDescriptions) {
				view = ((AbstractDynamixCDOResourceDescriptions) descriptions)
						.getDataProvider().getView();
				eClassToURIMap = this.getClassToURIMap();

				registerURIs();
				((AbstractDynamixCDOResourceDescriptions) descriptions)
						.initialize(flattenMap(), view);
			}
		}
	}

	private void registerURIs() {
		cdoScopeListener = new DynamixCDOScopeListener(this);
		view.addListener(cdoScopeListener);
	}

	@Override
	protected IScope getScope(Resource resource, boolean ignoreCase,
			EClass type, Predicate<IEObjectDescription> filter) {
		if (RuntimeActivator.DEBUG) {
			System.err
					.println("NETXSCRIPT: Dynamix Global scope provider invoked");
		}
		IScope scope = IScope.NULLSCOPE;
		List<URI> urisForClass = urisForClass(type);
		if (urisForClass != null) {
			for (URI uri : urisForClass) {

				if (RuntimeActivator.DEBUG) {
					System.err.println("NETXSCRIPT: build an IScope for: "
							+ uri.toString());
				}

				// the parent scope is self, so all URI's are caught.
				scope = createLazyResourceScope(scope, uri, descriptions, type,
						filter, ignoreCase);
				if (RuntimeActivator.DEBUG) {
					int size = Iterables.size(scope.getAllElements());
					System.err.println("NETXSCRIPT: last scope = "
							+ scope.toString() + " , number of descriptions = "
							+ size);
				}

			}
		} else {
			if (RuntimeActivator.DEBUG) {
				System.err.println("NETXSCRIPT:, no URI's for target EClass:"
						+ type.getName());
			}
		}

		return scope;
	}

	/**
	 * Also for the supers of this class.
	 * 
	 * @return
	 */
	private List<URI> urisForClass(EClass eClass) {

		List<EClass> classesToCheck = Lists.newArrayList();
		classesToCheck.add(eClass);
		classesToCheck.addAll(eClass.getEAllSuperTypes());

		for (EClass eC : classesToCheck) {
			List<URI> urisForClass = this.eClassToURIMap.get(eC);
			if (urisForClass != null) {
				return urisForClass;
			}
		}
		return null;
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
	protected IScope createLazyResourceScope(IScope parent, final URI uri,
			final IResourceDescriptions descriptions, EClass type,
			final Predicate<IEObjectDescription> filter, boolean ignoreCase) {

		IResourceDescription description = descriptions
				.getResourceDescription(uri);

		return SelectableBasedScope.createScope(parent, description, filter,
				type, ignoreCase);
	}

	/*
	 * See NetXScript grammar for all possible model referenced objects.
	 */
	public ImmutableMap<EClass, List<URI>> getClassToURIMap() {

		final LinkedHashMap<EClass, List<URI>> classURIMap = Maps
				.newLinkedHashMap();

		URI nodeTypeURI = uri(LibraryPackage.Literals.NODE_TYPE);
		classURIMap.put(LibraryPackage.Literals.NODE_TYPE,
				ImmutableList.of(nodeTypeURI));

		classURIMap.put(LibraryPackage.Literals.PARAMETER,
				ImmutableList.of(uri(LibraryPackage.Literals.PARAMETER)));

		classURIMap.put(ServicesPackage.Literals.SERVICE_USER,
				ImmutableList.of(uri(ServicesPackage.Literals.SERVICE_USER)));

		URI operatorURI = uri(OperatorsPackage.Literals.OPERATOR);

		classURIMap.put(OperatorsPackage.Literals.OPERATOR,
				ImmutableList.of(operatorURI));
		classURIMap.put(OperatorsPackage.Literals.NETWORK,
				ImmutableList.of(operatorURI));
		classURIMap.put(OperatorsPackage.Literals.NODE,
				ImmutableList.of(operatorURI));

		// CB Equipment and Function do not have their own resource, but could
		// exist both in a type URI as in
		// an Operator URI
		classURIMap.put(LibraryPackage.Literals.COMPONENT,
				ImmutableList.of(operatorURI, nodeTypeURI));

		// CB NetXResource are held in a CDO Folder container, scan the
		// container
		URI nodeResourceURI = URI.createURI("cdo://" + REPO_NAME + "/Node_");
		URI nodeTypeResoureURI = URI.createURI("cdo://" + REPO_NAME
				+ "/NodeType_");

		// this list is mutable by intend.
		ArrayList<URI> urisAsList = Lists.newArrayList();

		{
			List<URI> allNodeURIs = resolveAllURIs(nodeResourceURI);
			urisAsList.addAll(allNodeURIs);
		}

		{
			List<URI> allNodeURIs = resolveAllURIs(nodeTypeResoureURI);
			urisAsList.addAll(allNodeURIs);
		}

		// first type init.
		classURIMap.put(LibraryPackage.Literals.NET_XRESOURCE, urisAsList);

		return ImmutableMap.copyOf(classURIMap);

	}

	public URI uri(EClass eClass) {
		return URI.createURI("cdo://" + REPO_NAME + "/" + eClass.getName());
	}

	/*
	 * Resolves all child URI's from the provider URI path.
	 * 
	 * @param nodeURI
	 * 
	 * @return
	 */
	private List<URI> resolveAllURIs(URI uri) {
		String resourcePath = "/" + uri.lastSegment();
		// return uriForPath(transaction.getRootResource().getFolder(),
		// resourcePath);
		return uriForPath(resourcePath);
	}

	/*
	 * Returns all URI as a child of the provided path. Consider moving this as
	 * a DataProvider Interface.
	 */
	private List<URI> uriForPath(String name) {
		List<URI> childURIs = Lists.newArrayList();
		if (view != null && view.hasResource(name)) {
			CDOResourceNode resourceNode = view.getResourceNode(name);
			if (resourceNode instanceof CDOResourceFolder) {
				List<Resource> resources = this
						.getResourcesFromNode((CDOResourceFolder) resourceNode);
				childURIs.addAll(modelUtils.transformResourceToURI(resources));
			}
		}
		return childURIs;
	}

	private List<Resource> getResourcesFromNode(CDOResourceFolder cdoFolder) {
		List<Resource> resources = Lists.newArrayList();
		EList<CDOResourceNode> nodes = cdoFolder.getNodes();
		for (CDOResourceNode n : nodes) {
			if (n instanceof CDOResourceFolder) {
				resources.addAll(getResourcesFromNode((CDOResourceFolder) n));
			} else {
				resources.add((Resource) n);
			}
		}
		return resources;
	}

	private ImmutableList<URI> flattenMap() {

		ArrayList<URI> flattenURIList = Lists.newArrayList();
		for (Iterator<EClass> it = eClassToURIMap.keySet().iterator(); it
				.hasNext();) {
			flattenURIList.addAll(eClassToURIMap.get(it.next()));
		}

		return ImmutableList.copyOf(flattenURIList);
	}

	public void updateURIMap(Set<CDOObject> dirtyDozen) {
		// tada our dirty objects, update the URI map, and instruct the cache to
		// invalid the current URI's.

		List<URI> urisToUpdate = Lists.newArrayList();
		for (CDOObject cdoO : dirtyDozen) {

			if (cdoO instanceof CDOResource) {
				CDOResource cdoRes = (CDOResource) cdoO;
				urisToUpdate.add(cdoRes.getURI());
			} else if (cdoO instanceof CDOObject) {
				EClass eClass = cdoO.eClass();
				if (RuntimeActivator.DEBUG) {
					System.out
							.println("NETXSCRIPT, updating descriptions for + "
									+ eClass.getName());
				}
				List<URI> list = this.getClassToURIMap().get(eClass);
				
				if(list != null){
					for (URI uri : list) {
						if (!urisToUpdate.contains(uri)) {
							urisToUpdate.add(uri);
						}
					}
				}else{
					// it could be that we are not interested in this class. 
				}
			}

			if (RuntimeActivator.DEBUG) {

				for (URI uri : urisToUpdate) {
					System.out
							.println("NETXSCRIPT, updating descriptions for URI "
									+ uri.toString());
				}
			}

			((AbstractDynamixCDOResourceDescriptions) descriptions)
					.update(urisToUpdate);

		}

	}

}
