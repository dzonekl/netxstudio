/*******************************************************************************
 * Copyright (c) May 20, 2011 NetXForge.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  You should have received a copy of the GNU Lesser General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors: 
 * 	Martin Taal - initial API and implementation and/or initial documentation
 *******************************************************************************/
package com.netxforge.netxstudio.server;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Locale;

import org.eclipse.osgi.service.debug.DebugOptions;
import org.eclipse.osgi.service.debug.DebugOptionsListener;
import org.eclipse.osgi.service.debug.DebugTrace;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class ServerActivator implements BundleActivator, DebugOptionsListener {

	private static BundleContext context;

	private static ServerActivator INSTANCE;
	
	private static final String PLUGIN_ID = "com.netxforge.netxstudio.server";
	
	// fields to cache the debug flags
	public static boolean DEBUG = false;
	public static DebugTrace TRACE = null;

	public void optionsChanged(DebugOptions options) {
		DEBUG = options.getBooleanOption(PLUGIN_ID + "/debug", true);
		TRACE = options.newDebugTrace(PLUGIN_ID);
	}

	static BundleContext getContext() {
		return context;
	}

	public static ServerActivator getInstance() {
		return INSTANCE;
	}

	private Injector injector;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext
	 * )
	 */
	public void start(BundleContext bundleContext) throws Exception {
		INSTANCE = this;
		ServerActivator.context = bundleContext;
		injector = Guice.createInjector(ServerModule.getModule());

		Locale currentLocal = Locale.getDefault();
		System.out.println("CURRENT Locale: country = "
				+ currentLocal.getDisplayCountry() + "language = "
				+ currentLocal.getDisplayLanguage());
		Locale.setDefault(Locale.UK);
		currentLocal = Locale.getDefault();
		System.out.println("NEW Locale: country = "
				+ currentLocal.getDisplayCountry() + "language = "
				+ currentLocal.getDisplayLanguage());
		
		Dictionary<String, String> props = new Hashtable<String,String>(4);
		props.put(DebugOptions.LISTENER_SYMBOLICNAME, PLUGIN_ID);
	 	context.registerService(DebugOptionsListener.class.getName(), this, props);
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		ServerActivator.context = null;
		ServerUtils.getInstance().deActivate();
	}

	public Injector getInjector() {
		return injector;
	}

}
