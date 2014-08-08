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

import static org.ops4j.peaberry.Peaberry.osgiModule;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Locale;
import java.util.TimeZone;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.osgi.framework.console.CommandInterpreter;
import org.eclipse.osgi.framework.console.CommandProvider;
import org.eclipse.osgi.service.datalocation.Location;
import org.eclipse.osgi.service.debug.DebugOptions;
import org.eclipse.osgi.service.debug.DebugOptionsListener;
import org.eclipse.osgi.service.debug.DebugTrace;
import org.ops4j.peaberry.Export;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.netxforge.base.properties.IPropertiesProvider;
import com.netxforge.netxstudio.server.IServerUtils;
import com.netxforge.netxstudio.server.ServerDataPackages;
import com.netxforge.netxstudio.server.ServerIntegrity;
import com.netxforge.netxstudio.server.ServerUtils;
import com.netxforge.netxstudio.server.data.IServerDataProvider;
import com.netxforge.netxstudio.server.data.IServerNoCacheDataProvider;
import com.netxforge.netxstudio.server.data.Server;
import com.netxforge.netxstudio.server.data.ServerNoCache;

/**
 * @author Christophe Bouhier
 * 
 */
public class ServerActivator implements BundleActivator, DebugOptionsListener,
		CommandProvider {

	private static BundleContext context;

	private static ServerActivator INSTANCE;

	private static final String PLUGIN_ID = "com.netxforge.netxstudio.server";
	private static final String DEBUG_OPTION = "/debug";

	// public tracing options.
	public static final String TRACE_SERVER_CDO_OPTION = "/trace.server.cdo";
	public static final String TRACE_SERVER_CDO_SESSION = "/trace.server.cdo.session";
	public static final String TRACE_SERVER_CDO_TRANSACTION = "/trace.server.cdo.transaction";
	public static final String TRACE_SERVER_CDO_VIEW = "/trace.server.cdo.view";

	public static final String TRACE_SERVER_COMMIT_INFO_CDO_OPTION = "/trace.server.commitinfo";

	// fields to cache the debug flags
	public static boolean DEBUG = false;
	public static DebugTrace TRACE = null;

	@Inject
	private IServerUtils serverUtils;

	public void optionsChanged(DebugOptions options) {
		DEBUG = options.getBooleanOption(PLUGIN_ID + DEBUG_OPTION, false);
		TRACE = options.newDebugTrace(PLUGIN_ID);
	}

	public static BundleContext getContext() {
		return context;
	}

	public static ServerActivator getInstance() {
		return INSTANCE;
	}

	private Injector injector;

	// Export our services.
	@Inject
	Export<IServerUtils> serverUtilsService;

	@Inject
	@Server
	Export<IServerDataProvider> dpService;

	@Inject
	@ServerNoCache
	Export<IServerNoCacheDataProvider> dpNoCacheService;

	@Inject
	Export<IPropertiesProvider> propsProvider;

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
		injector = Guice.createInjector(osgiModule(bundleContext),
				new ServerModule());
		injector.injectMembers(this);

		// Set the Locale
		Locale currentLocal = Locale.getDefault();
		System.out.println("CURRENT Locale: country = "
				+ currentLocal.getDisplayCountry() + "language = "
				+ currentLocal.getDisplayLanguage());
		Locale.setDefault(Locale.UK);

		currentLocal = Locale.getDefault();

		// System.out.println("NEW Locale: country = "
		// + currentLocal.getDisplayCountry() + "language = "
		// + currentLocal.getDisplayLanguage() + " timezone = " +
		// currentLocal.get);

		TimeZone defaultTZ = TimeZone.getDefault();

		System.out.println(" timezone = " + defaultTZ.getDisplayName()
				+ " ID = " + defaultTZ.getID() + " DayLightSaving (sec) "
				+ defaultTZ.getDSTSavings() / 1000);

		// Get the workspace location property
		String workspaceLocation = System.getProperty("osgi.instance.area");
		System.out.println("Workspace location: " + workspaceLocation);

		// Get the Instance location property (Same as workspace).
		Location instanceLocation = Platform.getInstanceLocation();
		System.out.println("Instance location: "
				+ instanceLocation.getURL().toExternalForm());

		// Get the Configuration location property
		Location configurationLocation = Platform.getConfigurationLocation();
		System.out.println("Configuration location: "
				+ configurationLocation.getURL().toExternalForm());

		// Note: The DataArea is never initialized, as we have no knowledge of
		// the Platform,
		// As we are an OSGI bundle, we need to explicitly invoke a platform
		// call, which initializes
		// the DataArea class. This state location method does the job for us.
		IPath stateLocation = Platform.getStateLocation(context.getBundle());
		System.out.println("State location for:"
				+ context.getBundle().getSymbolicName() + " = "
				+ stateLocation.toString());

		String bundleLocation = context.getBundle().getLocation();
		System.out.println("Bundle location for:"
				+ context.getBundle().getSymbolicName() + " = "
				+ bundleLocation);

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

		// register our command provider.
		context.registerService(CommandProvider.class.getName(), this, null);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {

		ServerActivator.context = null;

		IServerUtils serverUtils = this.getInjector().getInstance(
				ServerUtils.class);
		serverUtils.deActivate();
	}

	public Injector getInjector() {
		return injector;
	}

	public String getHelp() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("---NetXStudio Server commands---\n\n");
		buffer.append("\tserver report [actions] [options]\n\n");
		buffer.append("\tReport the Data Integrity status of the data on the server. Depending on the options, this is a potentially\n");
		buffer.append("\tlong-running operation, therefor actions exist to query the progress and cancel the process all togehter\n");
		buffer.append("\tFixing actions are applied on the last produced (partial) report. \n");
		buffer.append("\n\toptions:\n");
		buffer.append("\t======= \n");
		buffer.append("\t --duplicates => Reports Value objects which belong to the same range and have the equal timeStamp.\n");
		buffer.append("\t                This is a long running operation. The progress is monitored by the 'progres' action.\n");
		buffer.append("\n\tactions:\n");
		buffer.append("\t======= \n");
		buffer.append("\t  progress    => Show the progress of the reporting process\n");
		buffer.append("\t  cancel      => Cancel the reporting process\n");
		buffer.append("\t  fix         => Fix the integrity of the data on the server, which deletes duplicate value entries, if any were generated\n");

		return buffer.toString();
	}

	public Object _server(CommandInterpreter interpreter) {
		try {
			String cmd = interpreter.nextArgument();
			if ("cdo".equals(cmd)) {
				String nextArgument = interpreter.nextArgument();

				// Process Actions:
				if ("packages".equals(nextArgument)) {
					return ServerDataPackages.INSTANCE.getRegisteredPackages();
				} else if ("package".equals(nextArgument)) {
					String nextNextArgument = interpreter.nextArgument();

					if ("show".equals(nextNextArgument)) {
						String next3Argument = interpreter.nextArgument();
						try {
							Integer integer = new Integer(next3Argument);
							EPackage epack = ServerDataPackages.INSTANCE
									.getPackageForIndex(integer.intValue());

							if (serverUtils.isLoaded(epack)) {
								// Get package info from the repo?
								return epack.toString();
							} else {
								return "Sorry package ["
										+ integer
										+ "], not loaded in our package store :-(";
							}
						} catch (NumberFormatException nfe) {
							return "expected an index for the package registry";
						}
					} else if ("load".equals(nextNextArgument)) {
						String next3Argument = interpreter.nextArgument();
						try {
							Integer integer = new Integer(next3Argument);
							EPackage epack = ServerDataPackages.INSTANCE
									.getPackageForIndex(integer.intValue());
							if (epack != null) {
								if (serverUtils.isLoaded(epack)) {
									return "this package is already loaded";
								} else {
									if (serverUtils.load(epack)) {
										return "loaded: " + epack.toString();
									} else {
										return "this package is already loaded";
									}
								}

							}
						} catch (NumberFormatException nfe) {
							return "expected an index for the package registry";
						}
					}
				}

			}
			if ("report".equals(cmd)) {
				String nextArgument = interpreter.nextArgument();

				// Process Actions:
				if ("last".equals(nextArgument)) {
					ServerIntegrity.reportIntegrityLast(interpreter);
					return null;
				}
				if ("progress".equals(nextArgument)) {
					ServerIntegrity.reportIntegrityProgress(interpreter);
					return null;
				} else if ("cancel".equals(nextArgument)) {
					ServerIntegrity.reportIntegrityCancel(interpreter);
					return null;
				} else if ("fix".equals(cmd)) {
					ServerIntegrity.restoreIntegrity(interpreter);
					return null;
				}

				// Process Options:
				if ("--duplicates".equals(nextArgument)) {
					ServerIntegrity.reportIntegrity(interpreter, true);
				} else {
					if (nextArgument != null && !nextArgument.isEmpty()) {
						interpreter.println("I don't know: " + nextArgument
								+ "\n\n");
						interpreter.println(getHelp());
						return null;
					}
					ServerIntegrity.reportIntegrity(interpreter);
				}
				return null;
			}
			interpreter.println(getHelp());
		} catch (Exception ex) {
			interpreter.printStackTrace(ex);
		}

		return null;
	}
}
