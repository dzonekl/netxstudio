/*******************************************************************************
 * Copyright (c) Oct 10, 2012 NetXForge.
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details. You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors: Christophe Bouhier - initial API and implementation and/or
 * initial documentation
 *******************************************************************************/ 
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
import com.netxforge.netxstudio.screens.editing.internal.ScreensCommonModule;

public class ScreensCommonActivator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.netxforge.netxstudio.screens.common"; //$NON-NLS-1$

	// The shared instance
	private static ScreensCommonActivator plugin;
	
	private Injector injector;

	protected Injector getInjector() {
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
