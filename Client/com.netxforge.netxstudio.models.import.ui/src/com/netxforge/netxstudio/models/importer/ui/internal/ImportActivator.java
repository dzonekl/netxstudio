package com.netxforge.netxstudio.models.importer.ui.internal;

import static com.google.inject.util.Modules.override;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.netxforge.netxstudio.common.CommonModule;
import com.netxforge.netxstudio.data.cdo.NonStaticCDODataServiceModule;
import com.netxforge.netxstudio.screens.editing.EditingServiceModule;

/**
 * The activator class controls the plug-in life cycle
 */
public class ImportActivator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.netxforge.netxstudio.m2m.ui"; //$NON-NLS-1$

	// The shared instance
	private static ImportActivator plugin;
	
	private Injector injector;

	public Injector getInjector() {
		return injector;
	}

	
	/**
	 * The constructor
	 */
	public ImportActivator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;

		// Bind our modules.
		Module om = new CommonModule();
		om = override(om).with(new EditingServiceModule());
		om = override(om).with(NonStaticCDODataServiceModule.getModule());
//		om = override(om).with(new CDODataServiceModule());
		injector = Guice.createInjector(om);
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
	public static ImportActivator getDefault() {
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
						ImportActivator.PLUGIN_ID,
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
						ImportActivator.PLUGIN_ID,
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
						ImportActivator.PLUGIN_ID,
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
