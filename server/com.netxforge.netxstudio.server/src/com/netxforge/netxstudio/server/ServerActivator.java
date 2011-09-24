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

import java.util.Locale;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class ServerActivator implements BundleActivator {

	private static BundleContext context;

	private static ServerActivator INSTANCE;
	
	static BundleContext getContext() {
		return context;
	}

	public static ServerActivator getInstance() {
		return INSTANCE;
	}
	
	private Injector injector;
	
	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		INSTANCE = this;
		ServerActivator.context = bundleContext;
		injector = Guice.createInjector(ServerModule.getModule());
		
		Locale currentLocal = Locale.getDefault();
		System.out.println("CURRENT Locale: country = " + currentLocal.getDisplayCountry() + "language = " + currentLocal.getDisplayLanguage());
		Locale.setDefault(Locale.UK);
		currentLocal = Locale.getDefault();
		System.out.println("NEW Locale: country = "  + currentLocal.getDisplayCountry() + "language = " + currentLocal.getDisplayLanguage());
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		ServerActivator.context = null;
		ServerUtils.getInstance().deActivate();
	}

	public Injector getInjector() {
		return injector;
	}

}