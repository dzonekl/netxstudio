package com.netxforge.netxstudio.navigator.resources;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.PlatformObject;
import org.eclipse.emf.common.util.URI;

public class NetXStudioRoot extends PlatformObject implements INetXStudioRoot {
	
	public static NetXStudioRoot INSTANCE = new NetXStudioRoot(); 
	
	private URI NETXFORGE_URI = URI.createURI("http://www.netxforge.com");
	private IWorkspaceRoot root;

//	protected NetXStudioRoot(IPath path, Workspace container) {
//		super(path, container);
//		// TODO Auto-generated constructor stub
//	}

	private NetXStudioRoot() {
	}

	public NetXStudioRoot(IWorkspaceRoot root) {
		this.root = root;
	}
	
	public URI[] getDatabases() {
		return new URI[]{NETXFORGE_URI};
	}

	public IProject[] getProjects() {
		return root.getProjects();
	}

}
