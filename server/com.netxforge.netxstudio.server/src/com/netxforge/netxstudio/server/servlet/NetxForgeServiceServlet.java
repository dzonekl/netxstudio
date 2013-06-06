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
package com.netxforge.netxstudio.server.servlet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.framework.ServiceReference;

import com.netxforge.netxstudio.server.internal.ServerActivator;
import com.netxforge.netxstudio.server.service.NetxForgeService;

public class NetxForgeServiceServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		final Map<String, String> parameters = new HashMap<String, String>();
		final Enumeration<?> enumeration = req.getParameterNames();
		while (enumeration.hasMoreElements()) {
			final String name = (String) enumeration.nextElement();
			parameters.put(name, req.getParameter(name));
		}
		final Object ret = runService(parameters);
		resp.getWriter().write(ret.toString());
	}
	
	/**
	 * Run a service, which should be in the parameters. The Service Parameter
	 * should be the name of the class to invoke from registered OSGI services.
	 * 
	 * @param parameters
	 * @return
	 */
	public Object runService(Map<String, String> parameters) {

		if (!parameters.containsKey(NetxForgeService.SERVICE_PARAM_NAME)) {
			throw new IllegalStateException(
					"Missing mandatory service name parameter: "
							+ NetxForgeService.SERVICE_PARAM_NAME);
		}

		String serviceKey = parameters.get(NetxForgeService.SERVICE_PARAM_NAME);

		final ServiceReference<?> serviceReference = ServerActivator
				.getContext().getServiceReference(serviceKey);

		if (serviceReference == null) {
			throw new IllegalStateException(
					"Service not defined for key:"
							+ serviceKey
							+ "\nSee service definitions in Activators of the server plugins");

		}
		final Object service = ServerActivator.getContext().getService(
				serviceReference);
		if (!(service instanceof NetxForgeService)) {
			throw new IllegalStateException("Can not run service "
					+ service.getClass());
		}
		return ((NetxForgeService) service).run(parameters);
	}
}
