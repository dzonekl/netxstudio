package com.netxforge.netxstudio.emf.teneo.ui.cnf;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.model.WorkbenchAdapter;

public class ResourceSetAdapter extends WorkbenchAdapter {
	
	
	@Override
	public String getLabel(Object object) {
		ResourceSet set = (ResourceSet)object;
		return "Remote (" + set.getResources().size() +")";
	}

	@Override
	public Object getParent(Object object) {
//		ResourceSet set = ((ResourceSet)object);
		return ResourcesPlugin.getWorkspace().getRoot();
	}

	@Override
	public Object[] getChildren(Object object) {
		ResourceSet set = (ResourceSet)object;
		return set.getResources().toArray();
	}

	@Override
	public ImageDescriptor getImageDescriptor(Object object) {
		return PlatformUI.getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_OBJ_FOLDER);
	}
	

}
