package com.netxforge.netxstudio.emf.teneo.ui.cnf;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.model.WorkbenchAdapter;

public class ResourceAdapter extends WorkbenchAdapter {
	
	@Override
	public String getLabel(Object object) {
		Resource res = ((Resource)object);
		
		StringBuffer buf = new StringBuffer();
		buf.append(res.isLoaded()? "(L) -" : "(U) -");
		buf.append(res.getURI().toString());
		return buf.toString();
	}

	@Override
	public Object getParent(Object object) {
		Resource res = ((Resource)object);
		return res.getResourceSet();
	}

	@Override
	public ImageDescriptor getImageDescriptor(Object object) {
		return PlatformUI.getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_OBJ_ELEMENT);
	}

}
