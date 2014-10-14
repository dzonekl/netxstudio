/*******************************************************************************
 * Copyright (c) 7 okt. 2014 NetXForge.
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
package com.netxforge.oss2.rest.internal;

import org.osgi.framework.BundleContext;

import com.google.inject.Module;
import com.netxforge.base.di.OSS2Activator;

public class RestConnectorActivator extends OSS2Activator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}
	
	private static RestConnectorActivator self;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext
	 * )
	 */
	public void start(BundleContext bundleContext) throws Exception {
		RestConnectorActivator.context = bundleContext;
		self = this;
	}

	public static RestConnectorActivator getSelf() {
		return self;
	}

	public static void setSelf(RestConnectorActivator self) {
		RestConnectorActivator.self = self;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		RestConnectorActivator.context = null;
	}

	@Override
	protected Module getModule() {
		return new RestModule();
	}

}
