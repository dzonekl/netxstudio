package com.netxforge.netxstudio.screens.editing.internal;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.netxforge.netxstudio.screens.editing.EditingServiceModule;

/**
 * The activator class controls the plug-in life cycle
 */
public class EditingActivator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.netxforge.netxstudio.screens.editing"; //$NON-NLS-1$

	// The shared instance
	private static EditingActivator plugin;

	private static Injector injector;

	/**
	 * The constructor
	 */
	public EditingActivator() {
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
		injector = Guice.createInjector(new EditingServiceModule());
//		injector.getInstance(CDOEditingService.class);
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
	public static EditingActivator getDefault() {
		return plugin;
	}

	public static Injector getInjector() {
		return injector;
	}

}
