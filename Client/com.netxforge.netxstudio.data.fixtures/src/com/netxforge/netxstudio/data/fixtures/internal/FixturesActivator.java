package com.netxforge.netxstudio.data.fixtures.internal;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.google.inject.Injector;

/**
 * The activator class controls the plug-in life cycle
 */
public class FixturesActivator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.netxforge.netxstudio.data.fixtures"; //$NON-NLS-1$

	// The shared instance
	private static FixturesActivator plugin;

	private Injector injector;
	
	/**
	 * The constructor
	 */
	public FixturesActivator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
//		injector = Guice.createInjector(new FixturesModule());
	}

	public Injector getInjector() {
		return injector;
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
	public static FixturesActivator getDefault() {
		return plugin;
	}

	public static void logError(String error) {
		logError(error, null);
	}

	public static void logError(String error, Throwable throwable) {
		if (error == null && throwable != null) {
			error = throwable.getMessage();
		}
		getDefault().getLog().log(
				new org.eclipse.core.runtime.Status(
						org.eclipse.core.runtime.IStatus.ERROR,
						FixturesActivator.PLUGIN_ID,
						org.eclipse.core.runtime.IStatus.OK, error, throwable));
		debug(error, throwable);
	}

	public static void logWarning(String error) {
		logError(error, null);
	}

	public static void logWarning(String error, Throwable throwable) {
		if (error == null && throwable != null) {
			error = throwable.getMessage();
		}
		getDefault().getLog().log(
				new org.eclipse.core.runtime.Status(
						org.eclipse.core.runtime.IStatus.WARNING,
						FixturesActivator.PLUGIN_ID,
						org.eclipse.core.runtime.IStatus.OK, error, throwable));
		debug(error, throwable);
	}

	public static void logInfo(String message) {
		logInfo(message, null);
	}

	public static void logInfo(String message, Throwable throwable) {
		if (message == null && throwable != null) {
			message = throwable.getMessage();
		}
		getDefault()
				.getLog()
				.log(new org.eclipse.core.runtime.Status(
						org.eclipse.core.runtime.IStatus.INFO,
						FixturesActivator.PLUGIN_ID,
						org.eclipse.core.runtime.IStatus.OK, message, throwable));
		debug(message, throwable);
	}

	private static void debug(String message, Throwable throwable) {
		if (!getDefault().isDebugging()) {
			return;
		}
		if (message != null) {
			System.err.println(message);
		}
		if (throwable != null) {
			throwable.printStackTrace();
		}
	}
	
	
}
