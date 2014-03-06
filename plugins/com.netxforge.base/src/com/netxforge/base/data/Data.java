package com.netxforge.base.data;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

public class Data implements IBaseData {

	public Resource getResource(ResourceSet set, EClass clazz) {
		throw new UnsupportedOperationException("TODO Implement");
	}

	public Resource getResource(ResourceSet set, String resourcePath) {
		throw new UnsupportedOperationException("TODO Implement");
	}

	public Resource getResource(ResourceSet set, int feature) {
		throw new UnsupportedOperationException("TODO Implement");
	}

	public Resource getResource(int feature) {
		throw new UnsupportedOperationException("TODO Implement");
	}

	public boolean hasResource(URI resourceURI) {
		throw new UnsupportedOperationException("TODO Implement");
	}

	public boolean hasResource(String resourcePath) {
		throw new UnsupportedOperationException("TODO Implement");
	}

	public Resource getResource(EClass clazz) {
		throw new UnsupportedOperationException("TODO Implement");
	}

	public Resource getResource(ResourceSet set, URI uri) {
		throw new UnsupportedOperationException("TODO Implement");
	}

	public Resource getResource(URI uri) {
		throw new UnsupportedOperationException("TODO Implement");
	}

	public Resource getResource(String resourcePath) {
		throw new UnsupportedOperationException("TODO Implement");
	}

	public List<Resource> getResources(ResourceSet set, String resourcePath) {
		throw new UnsupportedOperationException("TODO Implement");
	}

	public List<Resource> getResources(String resourcePath) {
		throw new UnsupportedOperationException("TODO Implement");
	}

}
