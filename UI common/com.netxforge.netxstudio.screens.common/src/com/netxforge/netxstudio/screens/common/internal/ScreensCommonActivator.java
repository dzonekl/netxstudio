package com.netxforge.netxstudio.screens.common.internal;

import static com.google.inject.util.Modules.override;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.netxforge.netxstudio.common.CommonModule;
import com.netxforge.netxstudio.data.cdo.CDODataServiceModule;
import com.netxforge.netxstudio.screens.editing.EditingServiceModule;

public class ScreensCommonActivator extends AbstractUIPlugin {

	
	// The shared instance
	private static ScreensCommonActivator plugin;
	
	private Injector injector;

	public Injector getInjector() {
		return injector;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext
	 * )
	 */
	public void start(BundleContext bundleContext) throws Exception {
		plugin = this;
		
		// Bind our modules.
		Module om = new ScreensCommonModule();
		om = override(om).with(new CommonModule());
		om = override(om).with(new CDODataServiceModule());
		om = override(om).with(new EditingServiceModule());
		injector = Guice.createInjector(om);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
	}
	
	
	/**
	 * Returns the shared instance
	 * @return the shared instance
	 */
	public static ScreensCommonActivator getDefault() {
		return plugin;
	}

	
	public static IPreferenceStore doGetPreferenceStore() {
		return getDefault().getPreferenceStore();
	}
	
}
