package com.netxforge.netxstudio.models.export.internal;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.netxforge.netxstudio.m2t"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;
	
	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
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
	public static Activator getDefault() {
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
						Activator.PLUGIN_ID,
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
						Activator.PLUGIN_ID,
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
		getDefault().getLog()
				.log(
						new org.eclipse.core.runtime.Status(
								org.eclipse.core.runtime.IStatus.INFO,
								Activator.PLUGIN_ID,
								org.eclipse.core.runtime.IStatus.OK, message,
								throwable));
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

	/**
	 * Returns an image descriptor for the image file at the given plug-in
	 * relative path
	 * 
	 * @param path
	 *            the path
	 * @return the image descriptor
	 */
	public static org.eclipse.jface.resource.ImageDescriptor getImageDescriptor(
			String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}

}
