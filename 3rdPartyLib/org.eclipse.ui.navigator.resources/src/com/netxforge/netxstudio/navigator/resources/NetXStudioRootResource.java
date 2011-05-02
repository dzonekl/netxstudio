package com.netxforge.netxstudio.navigator.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.ui.internal.ide.model.WorkbenchRootResource;

/**
 * Our root resource returns the children from IWorkspaceRoot and from INetXStudioRoot
 *  
 * @author dzonekl
 *
 */
public class NetXStudioRootResource extends WorkbenchRootResource {

	@Override
	public Object[] getChildren(Object o) {
		List<Object> children = new ArrayList<Object>(); 
		IWorkspaceRoot root = (IWorkspaceRoot)o;
		
		// FIXME later. 
		// Sets are created dynamicly in the editor for now. 
//		children.add(TeneoUI.INSTANCE.getSet());
//		children.addAll(Arrays.asList(NetXStudioRoot.INSTANCE.getDatabases()));
		children.addAll(Arrays.asList(root.getProjects()));
		return children.toArray();
	}
	
}
