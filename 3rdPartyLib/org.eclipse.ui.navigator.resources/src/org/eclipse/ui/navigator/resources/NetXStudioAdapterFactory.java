package org.eclipse.ui.navigator.resources;

import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.ui.model.IWorkbenchAdapter;

public class NetXStudioAdapterFactory implements IAdapterFactory {

	private Object rootAdapter = new NetXStudioRootResource();
	private Object uriAdapter = new URIAdapter();

	public Object getAdapter(Object o, Class adapterType) {
		if (adapterType == IWorkbenchAdapter.class) {
			return getWorkbenchElement(o);
		}
		
		return null;
	}

	public Class[] getAdapterList() {
		// For now, implement only IWorkbenchAdapter.
		return new Class[] { IWorkbenchAdapter.class };
		// return new Class[] { IWorkbenchAdapter.class, IElementFactory.class,
		// IPersistableElement.class, IActionFilter.class, IUndoContext.class };
	}

	/**
	 * Returns an object which is an instance of IWorkbenchAdapter associated
	 * with the given object. Returns <code>null</code> if no such object can be
	 * found.
	 */
	protected Object getWorkbenchElement(Object o) {
		if (o instanceof IWorkspaceRoot) {
			return rootAdapter;
		}
		if( o instanceof URI){
			return uriAdapter;
		}
		return null;
	}

}
