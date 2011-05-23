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
package com.netxforge.nextstudio.server;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.cdo.net4j.CDONet4jUtil;
import org.eclipse.emf.cdo.net4j.CDOSessionConfiguration;
import org.eclipse.emf.cdo.server.IRepository;
import org.eclipse.emf.cdo.session.CDOSession;
import org.eclipse.net4j.connector.IConnector;
import org.eclipse.net4j.jvm.IJVMAcceptor;
import org.eclipse.net4j.jvm.JVMUtil;
import org.eclipse.net4j.util.container.IManagedContainer;
import org.eclipse.net4j.util.container.IPluginContainer;
import org.eclipse.net4j.util.security.IPasswordCredentialsProvider;
import org.eclipse.net4j.util.security.PasswordCredentials;
import org.eclipse.net4j.util.security.PasswordCredentialsProvider;
import org.osgi.framework.ServiceReference;

import com.netxforge.nextstudio.server.service.NetxForgeService;

/**
 * Contains convenience methods.
 * 
 * @author Martin Taal
 */
public class ServerUtils {

	private static final String REPO_NAME = "repo1";

	private DatatypeFactory dataTypeFactory;

	private static ServerUtils instance = new ServerUtils();

	public static ServerUtils getInstance() {
		return instance;
	}

	public static void setInstance(ServerUtils instance) {
		ServerUtils.instance = instance;
	}

	private CDOSessionConfiguration sessionConfiguration = null;
	private IJVMAcceptor acceptor;
	private IConnector connector;
	private String serverSideLogin = null;

	public ServerUtils() {
		try {
			dataTypeFactory = DatatypeFactory.newInstance();
		} catch (final Exception e) {
			throw new IllegalStateException(e);
		}
	}

	public Object runService(Map<String, String> parameters) {
		if (!parameters.containsKey(NetxForgeService.SERVICE_PARAM_NAME)) {
			throw new IllegalStateException(
					"Missing mandatory service name parameter: "
							+ NetxForgeService.SERVICE_PARAM_NAME);
		}
		final ServiceReference<?> serviceReference = Activator.getContext()
				.getServiceReference(
						parameters.get(NetxForgeService.SERVICE_PARAM_NAME));
		final Object service = Activator.getContext().getService(
				serviceReference);
		if (!(service instanceof NetxForgeService)) {
			throw new IllegalStateException("Can not run service "
					+ service.getClass());
		}
		return ((NetxForgeService) service).run(parameters);
	}

	public void checkRepositorySupported(IRepository repository) {
		if (!repository.getName().equals(REPO_NAME)) {
			throw new IllegalArgumentException("Unexpected repository name "
					+ repository.getName() + " it must be " + REPO_NAME);
		}
	}

	public CDOSession openJVMSession() {
		if (sessionConfiguration == null) {
			initialize();
		}

		final IPasswordCredentialsProvider credentialsProvider = new PasswordCredentialsProvider(
				new PasswordCredentials(serverSideLogin,
						serverSideLogin.toCharArray()));
		sessionConfiguration.getAuthenticator().setCredentialsProvider(
				credentialsProvider);

		final CDOSession cdoSession = sessionConfiguration.openSession();
		return cdoSession;
	}

	public void deActivate() {
		if (acceptor != null) {
			acceptor.close();
		}
		if (connector != null) {
			connector.close();
		}
	}

	protected void initialize() {
		// Prepare container
		final IManagedContainer container = IPluginContainer.INSTANCE;
		acceptor = JVMUtil.getAcceptor(container, "default");
		connector = JVMUtil.getConnector(container, "default");

		// Create configuration
		sessionConfiguration = CDONet4jUtil.createSessionConfiguration();
		sessionConfiguration.setConnector(connector);
		sessionConfiguration.setRepositoryName(REPO_NAME);
	}

	public XMLGregorianCalendar getXMLGregorianCalendarDate(Date date) {
		final XMLGregorianCalendar gregCalendar = dataTypeFactory
				.newXMLGregorianCalendar();
		final Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		gregCalendar.setYear(calendar.get(Calendar.YEAR));
		gregCalendar.setMonth(calendar.get(Calendar.MONTH) + 1); // correct with
																	// 1 on
																	// purpose
		gregCalendar.setDay(calendar.get(Calendar.DAY_OF_MONTH));

		gregCalendar.setHour(calendar.get(Calendar.HOUR_OF_DAY));
		gregCalendar.setMinute(calendar.get(Calendar.MINUTE));
		gregCalendar.setSecond(calendar.get(Calendar.SECOND));
		gregCalendar.setMillisecond(calendar.get(Calendar.MILLISECOND));
		// gregCalendar.setTimezone(calendar.get(Calendar.ZONE_OFFSET));

		return gregCalendar;
	}

	public String getServerSideLogin() {
		return serverSideLogin;
	}

	public void setServerSideLogin(String serverSideLogin) {
		this.serverSideLogin = serverSideLogin;
	}
}
