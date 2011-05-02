package com.netxforge.netxstudio.navigator.resources;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.URI;

public interface INetXStudioRoot extends  IAdaptable {
	
	/**
	 * Return the DB as a URI. 
	 * @return
	 */
	public URI[] getDatabases();

	
 	public IProject[] getProjects();

}
