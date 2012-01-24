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

import com.netxforge.netxstudio.server.ServerUtils;

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
		final Object ret = ServerUtils.getInstance().runService(parameters);
		resp.getWriter().write(ret.toString());
	}
}
