/*******************************************************************************
 * Copyright (c) May 22, 2011 NetXForge.
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
 *    Christophe Bouhier - initial API and implementation and/or initial documentation
 *******************************************************************************/
package com.netxforge.base.internal;

import static org.ops4j.peaberry.Peaberry.service;
import static org.ops4j.peaberry.util.Attributes.objectClass;
import static org.ops4j.peaberry.util.TypeLiterals.export;

import com.google.inject.Singleton;
import com.netxforge.base.NonModelUtils;
import com.netxforge.base.properties.PropertiesUtil;
import com.netxforge.base.security.JCAServiceModule;

/**
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 * 
 */
public class BaseModule extends JCAServiceModule {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.inject.AbstractModule#configure()
	 */
	@Override
	protected void configure() {
		super.configure();

		// ///////////////////////////////
		// EXPORT SERVICES

		// Bind our model Utilities for export
		// http://code.google.com/p/peaberry/issues/detail?id=70
		bind(export(NonModelUtils.class)).toProvider(
				service(new NonModelUtils()).attributes(
						objectClass(NonModelUtils.class)).export());

		// ///////////////////////////////
		// IMPORT SERVICES
		// (Copy to modules in other OSGI bundles to import the service).

		// CB TODO Migrate to what?
		this.bind(PropertiesUtil.class).in(Singleton.class);

	}
}
