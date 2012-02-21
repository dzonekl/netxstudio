/*******************************************************************************
 * Copyright (c) Nov 23, 2011 NetXForge.
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
package com.netxforge.netxstudio.server.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.emf.ecore.resource.Resource;

import com.google.inject.Inject;
import com.netxforge.netxstudio.NetxstudioPackage;
import com.netxforge.netxstudio.ServerSettings;
import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.server.Server;
import com.netxforge.netxstudio.server.internal.ServerActivator;

public class DirectWriteServlet implements Servlet {

	private static final String LAST_MODIFIED = "Last-Modified"; //$NON-NLS-1$
	private static final String IF_MODIFIED_SINCE = "If-Modified-Since"; //$NON-NLS-1$
	private static final String IF_NONE_MATCH = "If-None-Match"; //$NON-NLS-1$
	private static final String ETAG = "ETag"; //$NON-NLS-1$

	private String internalName;
	private ServletConfig config;

	@Inject
	@Server
	private IDataProvider provider;
	private ServerSettings settings;
	
	public DirectWriteServlet() {
		this.internalName = ""; //$NON-NLS-1$
	}
	
	public DirectWriteServlet(String internalName) {
		this.internalName = internalName;
		if (internalName == null || internalName.equals("/")) { //$NON-NLS-1$
			this.internalName = ""; //$NON-NLS-1$
		}
	}

	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		String baseName = config.getInitParameter("base-name"); //$NON-NLS-1$
		if (baseName != null) {
			if (baseName.equals("/")) //$NON-NLS-1$
				internalName = ""; //$NON-NLS-1$
			else
				internalName = baseName;
		}		
	}

	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		HttpServletRequest httpRequest = (HttpServletRequest) req;
		HttpServletResponse httpResponse = (HttpServletResponse) resp;
	
		String method = httpRequest.getMethod();
		if (method.equals("GET") || method.equals("POST") || method.equals("HEAD")) { //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$
			String resourcePath = internalName + httpRequest.getPathInfo();
			if (!writeResource(httpRequest, httpResponse, resourcePath)) {
				httpResponse.setStatus(HttpServletResponse.SC_NOT_FOUND);
			}
		} else
			httpResponse.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
	}

	public void destroy() {
		config = null;
	}

	public ServletConfig getServletConfig() {
		return config;
	}

	public String getServletInfo() {
		return ""; //$NON-NLS-1$
	}
	

	private void setSettings() {
		ServerActivator.getInstance().getInjector().injectMembers(this);
		provider.openSession();
		Resource res = provider.getResource(NetxstudioPackage.Literals.SERVER_SETTINGS);
		if(res.getContents().size() == 1){
			settings = (ServerSettings) res.getContents().get(0);
		}
	}

	
	private boolean writeResource(final HttpServletRequest req, final HttpServletResponse resp, final String resourcePath) throws IOException {
		ServletContext servletContext = config.getServletContext();
		
		if(settings == null){
			setSettings();
		}
		
		
		// TODO, No check on the URL here! 
		String expPath = settings.getExportPath();
		// Hack this, combine the expPath with the resource path.  
		URL url = new URL("file://" + expPath + resourcePath);
		
		
		URLConnection connection = url.openConnection();
		long lastModified = connection.getLastModified();
		int contentLength = connection.getContentLength();

		String etag = null;
		if (lastModified != -1 && contentLength != -1)
			etag = "W/\"" + contentLength + "-" + lastModified + "\""; //$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$

		// Check for cache revalidation.
		// We should prefer ETag validation as the guarantees are stronger and all HTTP 1.1 clients should be using it
		String ifNoneMatch = req.getHeader(IF_NONE_MATCH);
		if (ifNoneMatch != null && etag != null && ifNoneMatch.indexOf(etag) != -1) {
			resp.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
			return true;
		} else {
			long ifModifiedSince = req.getDateHeader(IF_MODIFIED_SINCE);
			// for purposes of comparison we add 999 to ifModifiedSince since the fidelity
			// of the IMS header generally doesn't include milli-seconds
			if (ifModifiedSince > -1 && lastModified > 0 && lastModified <= (ifModifiedSince + 999)) {
				resp.setStatus(HttpServletResponse.SC_NOT_MODIFIED);
				return true;
			}
		}

		// return the full contents regularly
		if (contentLength != -1)
			resp.setContentLength(contentLength);

		String contentType = servletContext.getMimeType(resourcePath);
		if (contentType == null)
			contentType = servletContext.getMimeType(resourcePath);

		if (contentType != null)
			resp.setContentType(contentType);

		if (lastModified > 0)
			resp.setDateHeader(LAST_MODIFIED, lastModified);

		if (etag != null)
			resp.setHeader(ETAG, etag);

		InputStream is = null;
		try {
			is = connection.getInputStream();
			OutputStream os = resp.getOutputStream();
			byte[] buffer = new byte[8192];
			int bytesRead = is.read(buffer);
			int writtenContentLength = 0;
			while (bytesRead != -1) {
				os.write(buffer, 0, bytesRead);
				writtenContentLength += bytesRead;
				bytesRead = is.read(buffer);
			}
			if (contentLength == -1 || contentLength != writtenContentLength)
				resp.setContentLength(writtenContentLength);
		} finally {
			if (is != null)
				is.close();
		}
		return true;
	}
}
