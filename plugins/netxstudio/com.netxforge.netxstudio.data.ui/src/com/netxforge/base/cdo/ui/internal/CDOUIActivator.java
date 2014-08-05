/*******************************************************************************
 * Copyright (c) 10 mrt. 2014 NetXForge.
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
package com.netxforge.base.cdo.ui.internal;

import static org.ops4j.peaberry.Peaberry.osgiModule;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

public class CDOUIActivator extends AbstractUIPlugin {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	private Injector injector;
	
	
	private static CDOUIActivator plugin;

	
	public Injector getInjector() {
		return injector;
	}
	
	
	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static CDOUIActivator getInstance() {
		return plugin;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext ctx) throws Exception {
		CDOUIActivator.context = ctx;
		plugin = this;
		Module om = new CDOUIModule();
		injector = Guice.createInjector(osgiModule(ctx), om);
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		CDOUIActivator.context = null;
	}

}
