package com.netxforge.scoping;

import java.util.Collection;
import java.util.Date;
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

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.netxforge.netxstudio.data.IDataService;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.services.ServicesPackage;

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
	private Provider<IResourceDescriptions> loadOnDemandDescriptions;

	
	@Override
	protected IScope getScope(Resource resource, boolean ignoreCase,
			EClass type, Predicate<IEObjectDescription> filter) {
		
//		final LinkedHashSet<URI> uniqueImportURIs = new LinkedHashSet<URI>(10);
		
		final LinkedHashSet<EClass> uniqueReferencesEClasses = new LinkedHashSet<EClass>(10);
		
		uniqueReferencesEClasses.add(LibraryPackage.Literals.NODE_TYPE);
		uniqueReferencesEClasses.add(LibraryPackage.Literals.EQUIPMENT);
		uniqueReferencesEClasses.add(LibraryPackage.Literals.FUNCTION);
		uniqueReferencesEClasses.add(LibraryPackage.Literals.NET_XRESOURCE);
		uniqueReferencesEClasses.add(ServicesPackage.Literals.RFS_SERVICE);
		uniqueReferencesEClasses.add(OperatorsPackage.Literals.NETWORK);
		uniqueReferencesEClasses.add(OperatorsPackage.Literals.NODE);
		
		
		List<EClass> classesAsList = Lists.newArrayList(uniqueReferencesEClasses);
		
		// FIXME, the REPO name is hardcoded, get from the dataService. 
		List<URI> urisAsList = Lists.transform(classesAsList, new Function<EClass, URI>(){
			public URI apply(EClass from) {
				return URI.createURI("cdo://repo1/" + from.getName());
			}
		});
		
		IResourceDescriptions descriptions = getResourceDescriptions(resource,urisAsList);
		
		
//		Collections.reverse(urisAsList);
		System.err.print("Start producing scope: ");
		System.err.println(new Date(System.currentTimeMillis()));
		IScope scope = IScope.NULLSCOPE;
		for (URI uri : urisAsList) {
			scope = createLazyResourceScope(scope, uri, descriptions, type, filter, ignoreCase);
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
	protected IScope createLazyResourceScope(IScope parent, final URI uri, final IResourceDescriptions descriptions,
			EClass type, final Predicate<IEObjectDescription> filter, boolean ignoreCase) {
		IResourceDescription description = descriptions.getResourceDescription(uri);
		
		return SelectableBasedScope.createScope(parent, description, filter, type, ignoreCase);
	}
	
	/**
	 * Get the resource descriptions, using a custom <code>CDOLoadOnDemandResourceDescriptions.</code> 
	 * @param resource
	 * @param importEClasses
	 * @return
	 */
	public IResourceDescriptions getResourceDescriptions(Resource resource, Collection<URI> importEClasses) {
		IResourceDescriptions result = getResourceDescriptions(resource);
		IResourceDescriptions demandResourceDescriptions = loadOnDemandDescriptions.get();
		if(demandResourceDescriptions instanceof AbstractCDOLoadOnDemandResourceDescriptions ){
			((AbstractCDOLoadOnDemandResourceDescriptions) demandResourceDescriptions).initialize(result, importEClasses, resource);
		}
		return demandResourceDescriptions;
	}
	
}
