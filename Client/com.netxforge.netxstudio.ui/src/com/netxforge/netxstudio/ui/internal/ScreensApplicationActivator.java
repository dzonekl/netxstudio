package com.netxforge.netxstudio.ui.internal;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.netxforge.netxstudio.ui.IWorkbenchWindowLifecycleService;

/**
 * The activator class controls the plug-in life cycle
 */
public class ScreensApplicationActivator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.netxforge.netxstudio.ui"; //$NON-NLS-1$

	// The shared instance
	private static ScreensApplicationActivator plugin;

//	private Injector injector;

	private IWorkbenchWindowLifecycleService wbWindowLifecycleService;

	public IWorkbenchWindowLifecycleService getWbWindowLifecycleService() {
		return wbWindowLifecycleService;
	}

//	public Injector getInjector() {
//		return injector;
//	}

	/**
	 * The constructor
	 */
	public ScreensApplicationActivator() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
	 * )
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		ServiceReference<IWorkbenchWindowLifecycleService> wbLifecycleServiceReference = context
				.getServiceReference(IWorkbenchWindowLifecycleService.class);
		if(wbLifecycleServiceReference != null){
			wbWindowLifecycleService = context.getService(wbLifecycleServiceReference);
		}

//		Module om = new ScreensApplicationModule();
//		injector = Guice.createInjector(om);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
	 * )
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static ScreensApplicationActivator getDefault() {
		return plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given plug-in
	 * relative path
	 * 
	 * @param path
	 *            the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}
}
