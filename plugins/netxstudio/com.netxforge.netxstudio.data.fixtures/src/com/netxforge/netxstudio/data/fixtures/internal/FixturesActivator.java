/*******************************************************************************
 * Copyright (c) 5 jun. 2013 NetXForge.
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
package com.netxforge.netxstudio.data.fixtures.internal;

import static com.google.inject.Guice.createInjector;
import static org.ops4j.peaberry.Peaberry.osgiModule;

import org.ops4j.peaberry.Export;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.google.inject.Inject;
import com.netxforge.netxstudio.data.fixtures.IFixtures;

/**
 * The activator class controls the plug-in life cycle
 */
public class FixturesActivator implements BundleActivator {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.netxforge.netxstudio.data.fixtures"; //$NON-NLS-1$

	// The shared instance
	private static FixturesActivator plugin;

	
	// Export our fixtures.
	@Inject
	Export<IFixtures> fixtures;
	
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext ctx) throws Exception {
		createInjector(osgiModule(ctx), new FixturesModule()).injectMembers(this);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static FixturesActivator getDefault() {
		return plugin;
	}
	
}
