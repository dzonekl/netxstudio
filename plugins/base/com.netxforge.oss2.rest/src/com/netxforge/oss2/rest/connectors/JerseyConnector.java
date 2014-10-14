/*******************************************************************************
 * Copyright (c) 30 sep. 2014 NetXForge.
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
package com.netxforge.oss2.rest.connectors;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

import com.netxforge.oss2.rest.entity.EMFEntityProcessr;
import com.netxforge.oss2.rest.jersey.EMFMessageBodyReader;

/**
 * A connector for javax.ws.rs.
 * 
 * @author Christophe Bouhier
 * 
 */
public class JerseyConnector extends AbstractConnector {

	public void connect() {

		// Create an authentication feature.
		Client client = initClient();

		// Create a root target.
		WebTarget target = client.target(this.getRestSession().constructURI());

		System.out.println(target.getUri());

		// Media type mapping.
		String mediaType = null;
		switch (getRestSession().getMedia()) {
		case JSON: {
			mediaType = MediaType.APPLICATION_JSON;
		}
			break;
		case XML: {
			mediaType = MediaType.APPLICATION_XML;
		}
			break;

		}

		// Invocation
		Invocation.Builder invocationBuilder = target.request(mediaType);

		Response response = invocationBuilder.get();
		System.out.println(response.getStatus());

		if (this.getEntityProcessor() != null) {
			this.getEntityProcessor().processResult(response);
		} else {
			System.out.println(response.readEntity(String.class));
		}

	}

	private Client initClient() {
		HttpAuthenticationFeature authenticate = HttpAuthenticationFeature
				.basic(getRestSession().getUserid(), getRestSession()
						.getPassword());

		// The Jersey client.
		Client client = ClientBuilder.newClient();
		client.register(authenticate);
		
		// Need to match the entity processor.
		if (getEntityProcessor() != null) {
			client.register(
					new EMFMessageBodyReader(
							(EMFEntityProcessr) getEntityProcessor()));
		}

		return client;
	}

}
