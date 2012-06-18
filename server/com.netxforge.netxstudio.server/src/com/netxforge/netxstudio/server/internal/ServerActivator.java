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
package com.netxforge.netxstudio.server.internal;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.eclipse.osgi.service.debug.DebugOptions;
import org.eclipse.osgi.service.debug.DebugOptionsListener;
import org.eclipse.osgi.service.debug.DebugTrace;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.netxforge.netxstudio.server.ServerModule;
import com.netxforge.netxstudio.server.ServerUtils;

/**
 * The following tracing options are supported.
 * 
 * {@link #PLUGIN_ID }
 * 
 * @author Christophe
 * 
 */
public class ServerActivator implements BundleActivator, DebugOptionsListener {

	private static BundleContext context;

	private static ServerActivator INSTANCE;

	private static final String PLUGIN_ID = "com.netxforge.netxstudio.server";
	private static final String DEBUG_OPTION = "/debug";
	
	// public tracing options.
	public static final String TRACE_CDO_OPTION = "/trace.cdo";

	// fields to cache the debug flags
	public static boolean DEBUG = false;
	public static DebugTrace TRACE = null;

	public void optionsChanged(DebugOptions options) {
		DEBUG = options.getBooleanOption(PLUGIN_ID + DEBUG_OPTION, false);
		TRACE = options.newDebugTrace(PLUGIN_ID);
		
		// CB Experimental, set the trace.log file as this is not created.
//		if(options.getFile() == null){
//			File file = new File(this.workspaceLocation + File.separator + "trace.log");
//			if(!file.exists()){
//				try {
//					if( file.createNewFile()){
//						// creation succeeded. 
//					}
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}else{
//				options.setFile(file);
//			}
//		}
	}

	public static BundleContext getContext() {
		return context;
	}

	public static ServerActivator getInstance() {
		return INSTANCE;
	}

	private Injector injector;

	@SuppressWarnings("unused")
	private String workspaceLocation;

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
		
		// Set the Locale 
		
		Locale currentLocal = Locale.getDefault();
		System.out.println("CURRENT Locale: country = "
				+ currentLocal.getDisplayCountry() + "language = "
				+ currentLocal.getDisplayLanguage());
		Locale.setDefault(Locale.UK);
		currentLocal = Locale.getDefault();
		System.out.println("NEW Locale: country = "
				+ currentLocal.getDisplayCountry() + "language = "
				+ currentLocal.getDisplayLanguage());
		
		// Get the workspace location property
		workspaceLocation  = System.getProperty("osgi.instance.area");
		
		Dictionary<String, String> props = new Hashtable<String, String>(4);
		props.put(DebugOptions.LISTENER_SYMBOLICNAME, PLUGIN_ID);
		context.registerService(DebugOptionsListener.class.getName(), this,
				props);
		
		// Test log4J. Remove later...
		Logger logger = Logger.getLogger(ServerActivator.class);
        logger.info("Info starting");
        logger.warn("Warning starting");
        logger.error("Error starting");
        logger.debug("Debug starting");
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
