package com.netxforge.ui.resource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.validation.IResourceValidator;

import com.google.inject.Inject;
import com.google.inject.internal.Nullable;

/**
 * Almost a literal copy from GenericResourceServiceProvider. 
 * @see {@link org.eclipse.xtext.resource.generic.AbstractGenericResourceRuntimeModule}
 * @author dzonekl
 *
 */
public class NetXScriptResourceServiceProvider implements
		IResourceServiceProvider {
	
	@Inject
	@Nullable
	private IContainer.Manager containerManager;
	
	public IContainer.Manager getContainerManager() {
		return containerManager;
	}
	
	@Inject
	private IResourceDescription.Manager resourceDescriptionManager;

	public IResourceDescription.Manager getResourceDescriptionManager() {
		return resourceDescriptionManager;
	}

	@Inject
	@Nullable
	private IResourceValidator resourceValidator = IResourceValidator.NULL;

	public IResourceValidator getResourceValidator() {
		return resourceValidator;
	}

	@Inject
	private FileExtensionProvider fileExtensionProvider;
	
	public boolean canHandle(URI uri) {
		return uri.fileExtension().equals("library");
//		return fileExtensionProvider.isValid(uri.fileExtension());
	}
	
	@Inject
	private IEncodingProvider encodingProvider;
	
	public IEncodingProvider getEncodingProvider() {
		return encodingProvider;
	}
	
	public <T> T get(Class<T> t) {
		return null;
	}

}
