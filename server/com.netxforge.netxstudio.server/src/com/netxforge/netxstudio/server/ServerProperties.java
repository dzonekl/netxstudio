/*******************************************************************************
 * Copyright (c) 14 jun. 2013 NetXForge.
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
package com.netxforge.netxstudio.server;

import java.util.Properties;

import org.eclipse.core.runtime.Platform;
import org.eclipse.osgi.service.datalocation.Location;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.netxforge.netxstudio.common.properties.IPropertiesProvider;
import com.netxforge.netxstudio.common.properties.PropertiesUtil;

/**
 * Provides {@link Properties} from the file name
 * &quot;netxserver.properties&quot; in the
 * {@link Platform#getInstanceLocation() Platform instance } location. The
 * properties can be written out, if the file doesn't exist by calling the
 * <code>put()</code> method.
 * 
 * @author Christophe
 * 
 */
public class ServerProperties implements Provider<Properties>,
		IPropertiesProvider {

	private static final String NETXSERVER_PROPERTIES_FILE_NAME = "netxserver.properties";
	private PropertiesUtil pu;
	private Properties properties;

	@Inject
	public ServerProperties(PropertiesUtil pu) {
		this.pu = pu;
	}

	public Properties get() {

		if (properties == null) {
			properties = new Properties();
			Location instanceLocation = Platform.getInstanceLocation();
			// Read the server properties
			// We don't have binding, in this module and still it works??
			// Because it's bound as a Singleton? Still different injectors.
			pu.readProperties(instanceLocation,
					NETXSERVER_PROPERTIES_FILE_NAME, properties);

		}
		return properties;
	}

	public void put() {
		if (properties == null) {
			properties = new Properties();
		}
		pu.writeProperties(Platform.getInstanceLocation(),
				NETXSERVER_PROPERTIES_FILE_NAME, properties);
	}

}
