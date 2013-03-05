package com.netxforge.netxstudio.ui.activities.internal;


import static com.google.inject.util.Modules.override;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.netxforge.netxstudio.common.CommonModule;
import com.netxforge.netxstudio.data.cdo.CDODataServiceModule;
import com.netxforge.netxstudio.ui.activities.ActivityAndRoleServiceModule;

/**
 * The activator class controls the plug-in life cycle
 */
public class ActivitiesActivator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.netxforge.netxstudio.ui.activities"; //$NON-NLS-1$

	// The shared instance
	private static ActivitiesActivator plugin;

	private Injector injector;
	
	/**
	 * The constructor
	 */
	public ActivitiesActivator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		Module om = new ActivityAndRoleServiceModule();
		om = override(om).with(new CDODataServiceModule());
		om = override(om).with(new CommonModule());
		
		injector = Guice.createInjector(om);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
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
	public static ActivitiesActivator getDefault() {
		return plugin;
	}
	
	public Injector getInjector() {
		return injector;
	}


}
