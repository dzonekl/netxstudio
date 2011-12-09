package com.netxforge.scoping.old;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;

import org.eclipse.emf.cdo.eresource.CDOResourceFolder;
import org.eclipse.emf.cdo.eresource.CDOResourceNode;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
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

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.services.ServicesPackage;
import com.netxforge.scoping.AbstractDynamixCDOResourceDescriptions;

/**
 * A simple CDOScope provider, which returns all potential references. (Without
 * filtering). Uses a custom CDOLoadOnDemandResourceDescriptions.
 * 
 * @author dzonekl
 */
public class FixedSetCDOScopeProvider extends AbstractGlobalScopeProvider {

	private static String REPO_NAME = "repo1";

	// @Inject
	private Provider<IResourceDescriptions> loadOnDemandDescriptions;

	private ModelUtils modelUtils;

	/*
	 * Our single use transaction.
	 */
	private CDOTransaction transaction;

	/*
	 * Our fixed list of URI's for which we should resolve.
	 */
	private ImmutableList<URI> fixedURIs;

	/*
	 * 
	 */
	private IResourceDescriptions descriptions;

	@Inject
	public FixedSetCDOScopeProvider(
			Provider<IResourceDescriptions> descriptionsProvider, ModelUtils modelUtils) {
		super();

		this.modelUtils = modelUtils;
		this.loadOnDemandDescriptions = descriptionsProvider;

		// Use a singleton transaction.
		if (transaction == null) {

			descriptions = loadOnDemandDescriptions.get();
			if (descriptions instanceof AbstractDynamixCDOResourceDescriptions) {
				transaction = ((AbstractDynamixCDOResourceDescriptions) descriptions)
						.getDataProvider().getTransaction();
				fixedURIs = this.getFixedURIs();
				((AbstractDynamixCDOResourceDescriptions) descriptions)
						.initialize(fixedURIs, transaction);
			}
		}
	}

	@Override
	protected IScope getScope(Resource resource, boolean ignoreCase,
			EClass type, Predicate<IEObjectDescription> filter) {
		System.err.println("Fixed Global scope provider invoked");
		System.err.println(new Date(System.currentTimeMillis()));

		IScope scope = IScope.NULLSCOPE;
		
		
		// Builds the scope for all registered URI's, while the type is Equipment. 
		// Iterate through the fixed of URI's. Perhaps we can map the EClass type to a
		// URI. 
		for (URI uri : fixedURIs) {
			scope = createLazyResourceScope(scope, uri, descriptions, type,
					filter, ignoreCase);
		}
		System.err.print("End producing scope: ");
		System.err.println(new Date(System.currentTimeMillis()));
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
	protected IScope createLazyResourceScope(IScope parent, final URI uri,
			final IResourceDescriptions descriptions, EClass type,
			final Predicate<IEObjectDescription> filter, boolean ignoreCase) {
		IResourceDescription description = descriptions
				.getResourceDescription(uri);

		return SelectableBasedScope.createScope(parent, description, filter,
				type, ignoreCase);
	}

	/*
	 * The fixed set of URI's.
	 */
	public ImmutableList<URI> getFixedURIs() {

		final LinkedHashSet<EClass> uniqueReferencesEClasses = new LinkedHashSet<EClass>(
				10);

		uniqueReferencesEClasses.add(LibraryPackage.Literals.NODE_TYPE);
		uniqueReferencesEClasses.add(LibraryPackage.Literals.EQUIPMENT);
		uniqueReferencesEClasses.add(LibraryPackage.Literals.FUNCTION);
		uniqueReferencesEClasses.add(LibraryPackage.Literals.PARAMETER);

		uniqueReferencesEClasses.add(ServicesPackage.Literals.SERVICE_USER);

		// CB NetXResource object, have their own CDO Resources, See ModelUtils
		// for the naming convention.
		// uniqueReferencesEClasses.add(LibraryPackage.Literals.NET_XRESOURCE);
		uniqueReferencesEClasses.add(OperatorsPackage.Literals.OPERATOR);
		uniqueReferencesEClasses.add(OperatorsPackage.Literals.NETWORK);
		uniqueReferencesEClasses.add(OperatorsPackage.Literals.NODE);

		List<EClass> classesAsList = Lists
				.newArrayList(uniqueReferencesEClasses);

		// FIXME, the REPO name is hardcoded, get from the dataService.
		List<URI> fixedUrisAsList = Lists.transform(classesAsList,
				new Function<EClass, URI>() {
					public URI apply(EClass from) {
						return URI.createURI("cdo://" + REPO_NAME + "/"
								+ from.getName());
					}
				});

		List<URI> urisAsList = Lists.newArrayList();
		urisAsList.addAll(fixedUrisAsList);

		// add adiditional uri's from the NET_XRESOURCE class type.

		URI nodeURI = URI.createURI("cdo://" + REPO_NAME + "/Node_");
		URI nodeTypeURI = URI.createURI("cdo://" + REPO_NAME + "/NodeType_");

		{
			List<URI> allNodeURIs = resolveAllURIs(nodeURI);
			urisAsList.addAll(allNodeURIs);
		}

		{
			List<URI> allNodeURIs = resolveAllURIs(nodeTypeURI);
			urisAsList.addAll(allNodeURIs);
		}

		return ImmutableList.copyOf(urisAsList);
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
		if (transaction != null && transaction.hasResource(name)) {
			CDOResourceNode resourceNode = transaction.getResourceNode(name);
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

}
