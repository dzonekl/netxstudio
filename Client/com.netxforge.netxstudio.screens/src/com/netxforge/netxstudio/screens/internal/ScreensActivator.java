package com.netxforge.netxstudio.screens.internal;

import static com.google.inject.util.Modules.override;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.netxforge.netxstudio.common.CommonModule;
import com.netxforge.netxstudio.data.cdo.CDODataServiceModule;
import com.netxforge.netxstudio.screens.ScreensModule;
import com.netxforge.netxstudio.screens.editing.EditingServiceModule;

/**
 * The activator class controls the plug-in life cycle
 */
public class ScreensActivator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.netxforge.netxstudio.screens"; //$NON-NLS-1$

	// The shared instance
	private static ScreensActivator plugin;

	private Injector injector;

	public Injector getInjector() {
		return injector;
	}

	/**
	 * The constructor
	 */
	public ScreensActivator() {
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

		// Bind our modules.
		Module om = new ScreensModule();
		om = override(om).with(new CommonModule());
		om = override(om).with(new CDODataServiceModule());
		om = override(om).with(new EditingServiceModule());
		injector = Guice.createInjector(om);

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
	public static ScreensActivator getDefault() {
		return plugin;
	}

	public static IPreferenceStore doGetPreferenceStore() {
		return getDefault().getPreferenceStore();
	}
}
