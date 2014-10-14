/*******************************************************************************
 * Copyright (c) 23 sep. 2014 NetXForge.
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

import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.codec.binary.Base64;

public class JAXBConnector extends AbstractConnector {

	public void connect() {
		System.out.println("Starting Statistics JAXB client.");

		URL url;

		try {
			url = new java.net.URL(this.getRestSession().constructURI());

			String authString = this.getRestSession().getUserid() + ":"
					+ this.getRestSession().getPassword();
			byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
			String authStringEnc = new String(authEncBytes);
			URLConnection connection = url.openConnection();
			connection.setRequestProperty("Authorization", "Basic "
					+ authStringEnc);

			connection.setRequestProperty("Content-Type", "application/xml");
			connection.setRequestProperty("Accept", "application/xml");

			connection.connect();

			// JAXBContext context = JAXBContext
			// .newInstance(AllFlowStatistics.class);
			//
			// Unmarshaller unmarshaller = context.createUnmarshaller();
			//
			// InputStream inputStream = connection.getInputStream();

			// AllFlowStatistics result = (AllFlowStatistics) unmarshaller
			// .unmarshal(inputStream);

		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

}
