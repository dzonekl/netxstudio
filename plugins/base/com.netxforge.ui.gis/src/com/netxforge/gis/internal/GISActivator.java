package com.netxforge.gis.internal;

import org.osgi.framework.BundleContext;

import com.google.inject.AbstractModule;
import com.google.inject.Module;
import com.netxforge.screens.editing.base.OSS2UIActivator;

/**
 * The activator class controls the plug-in life cycle
 */
public class GISActivator extends OSS2UIActivator {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.netxforge.gis"; //$NON-NLS-1$

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
	 * )
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
	 * )
	 */
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
	}

	@Override
	protected Module getModule() {

		return new AbstractModule() {

			@Override
			protected void configure() {
//				bind(NewEditGeoSite.class);
			}
		};
	}
	

}
