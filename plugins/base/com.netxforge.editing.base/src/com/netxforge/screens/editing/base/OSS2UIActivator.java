/*******************************************************************************
 * Copyright (c) 31 aug. 2014 NetXForge.
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
package com.netxforge.screens.editing.base;

import static org.ops4j.peaberry.Peaberry.osgiModule;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.netxforge.base.di.AbstractGuiceAwareExecutableExtensionFactory;

/**
 * OSS2 Apps should implement. Clients should implement {@link #getModule()}.
 * The {@link Guice} injector will be provisioned with the defined (Mixin)
 * Modules.
 * 
 * @author Christophe Bouhier
 * 
 */
public abstract class OSS2UIActivator extends AbstractUIPlugin {

	// An injector for this bundle.

	private Injector oss2Injector;

	private static OSS2UIActivator oss2plugin;

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		oss2plugin = this;

		Module om = this.getModule();
		if (om != null) {
			oss2Injector = Guice.createInjector(osgiModule(context), om);

			// Inject our members, for peaberry this will inject our our
			// exported members.
			oss2Injector.injectMembers(this);
		}
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
	}

	/**
	 * Override to provide an implementation. The default returns
	 * <code>null</code>
	 * 
	 * @return
	 */
	protected Module getModule() {
		return null;
	}

	public Injector getInjector() {
		return oss2Injector;
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static OSS2UIActivator getDefault() {
		return oss2plugin;
	}

	/**
	 * Add this to an extension declaration (plugin.xml), for the {@link Guice}
	 * injector to instantiate the class.
	 * 
	 * @author Christophe Bouhier
	 */
	public class OSS2ExecutableExtensionFactory extends
			AbstractGuiceAwareExecutableExtensionFactory {

		@Override
		protected Bundle getBundle() {
			return oss2plugin.getBundle();
		}

		@Override
		protected Injector getInjector() {
			return oss2Injector;
		}
	}

}
