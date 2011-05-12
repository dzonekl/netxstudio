package org.eclipse.ui.navigator.resources;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IAdaptable;

public interface INetXStudioRoot extends  IAdaptable {
	
	/**
	 * Return the DB as a URI. 
	 * @return
	 */
//	public URI[] getDatabases();

	
 	public IProject[] getProjects();

}
