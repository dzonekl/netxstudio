package com.netxforge.netxstudio.emf.teneo.ui.cnf;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.teneo.hibernate.resource.HibernateResource;
import org.eclipse.ui.model.IWorkbenchAdapter;

public class TeneoAdapterFactory implements IAdapterFactory {

	private Object uriAdapter = new TeneoAdapter();
	private Object resourceSetAdapter = new ResourceSetAdapter();
	private Object resourceAdapter = new ResourceAdapter();
	private Object hibernateResourceAdapter = new HibernateResourceAdapter();

	@Override
	public Object getAdapter(Object o, Class adapterType) {
		if (adapterType == IWorkbenchAdapter.class) {
			return getWorkbenchElement(o);
		}
		
		return null;
	}

	@Override
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
		if( o instanceof URI){
			return uriAdapter;
		}
		if( o instanceof ResourceSet){
			return resourceSetAdapter;
		}
		if( o instanceof HibernateResource){
			return hibernateResourceAdapter;
		}
		if( o instanceof Resource){
			return resourceAdapter;
		}
		
		return null;
	}

}
