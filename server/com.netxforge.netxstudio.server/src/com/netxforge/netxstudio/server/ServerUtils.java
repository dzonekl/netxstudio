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

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.emf.cdo.common.commit.handler.AsyncCommitInfoHandler;
import org.eclipse.emf.cdo.net4j.CDONet4jUtil;
import org.eclipse.emf.cdo.net4j.CDOSessionConfiguration;
import org.eclipse.emf.cdo.server.IRepository;
import org.eclipse.emf.cdo.session.CDOSession;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.net4j.connector.IConnector;
import org.eclipse.net4j.jvm.IJVMAcceptor;
import org.eclipse.net4j.jvm.JVMUtil;
import org.eclipse.net4j.util.container.IElementProcessor;
import org.eclipse.net4j.util.container.IManagedContainer;
import org.eclipse.net4j.util.container.IPluginContainer;
import org.eclipse.net4j.util.lifecycle.ILifecycleEvent;
import org.eclipse.net4j.util.lifecycle.ILifecycleEvent.Kind;
import org.eclipse.net4j.util.lifecycle.LifecycleEventAdapter;
import org.eclipse.net4j.util.security.IPasswordCredentialsProvider;
import org.eclipse.net4j.util.security.PasswordCredentials;
import org.eclipse.net4j.util.security.PasswordCredentialsProvider;
import org.osgi.framework.ServiceReference;

import com.google.inject.Inject;
import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.generics.GenericsPackage;
import com.netxforge.netxstudio.geo.GeoPackage;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.protocols.ProtocolsPackage;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;
import com.netxforge.netxstudio.server.service.NetxForgeService;
import com.netxforge.netxstudio.services.ServicesPackage;

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
	private String serverSideLogin = "" + System.currentTimeMillis();
	private boolean initResourcesDone;
	
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

	public CDOSessionConfiguration getSessionConfiguration() {
		if (sessionConfiguration == null) {
			initialize();
		}
		return sessionConfiguration;
	}
	
	public CDOSession openJVMSession() {
		final CDOSession cdoSession = getSessionConfiguration().openSession();
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

		final IPasswordCredentialsProvider credentialsProvider = new PasswordCredentialsProvider(
				new PasswordCredentials(serverSideLogin,
						serverSideLogin.toCharArray()));
		sessionConfiguration.getAuthenticator().setCredentialsProvider(
				credentialsProvider);

	}

	public XMLGregorianCalendar toXmlDate(Date date) {
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
	
	public synchronized void initResources() {
		if (initResourcesDone) {
			return;
		}
		
		final ResourceInitializer resourceInitializer = Activator.getInstance().getInjector().getInstance(ResourceInitializer.class);
		resourceInitializer.initResources();
		initResourcesDone = true;
	}
	
	static class ResourceInitializer {
		@Inject
		private IDataProvider dataProvider;
		
		private void initResources() {
			dataProvider.openSession();
			dataProvider.getTransaction();
			initResourcesForEPackage(GenericsPackage.eINSTANCE);
			initResourcesForEPackage(GeoPackage.eINSTANCE);
			initResourcesForEPackage(LibraryPackage.eINSTANCE);
			initResourcesForEPackage(MetricsPackage.eINSTANCE);
			initResourcesForEPackage(OperatorsPackage.eINSTANCE);
			initResourcesForEPackage(ProtocolsPackage.eINSTANCE);
			initResourcesForEPackage(SchedulingPackage.eINSTANCE);
			initResourcesForEPackage(ServicesPackage.eINSTANCE);
			dataProvider.commitTransaction();
		}
		
		private void initResourcesForEPackage(EPackage ePackage) {
			for (final EClassifier eClassifier : ePackage.getEClassifiers()) {
				if (eClassifier instanceof EClass) {
					final EClass eClass = (EClass)eClassifier;
					dataProvider.getResource(eClass);
				}
			}
		}
	}
	
	public static class ServerInitializer implements IElementProcessor {
		
		@Override
		public Object process(IManagedContainer container, String productGroup,
				String factoryType, String description, Object element) {
			if (element instanceof IRepository) {
				final AsyncCommitInfoHandler asyncCommitInfoHandler = new AsyncCommitInfoHandler(
						new NetxForgeCommitInfoHandler());
				asyncCommitInfoHandler.activate();
				((IRepository) element)
						.addCommitInfoHandler(asyncCommitInfoHandler);
				
				// create all the resources at startup
				final IRepository repository = (IRepository) element;
				repository.addListener(new LifecycleEventAdapter() {
					@Override
					public void notifyLifecycleEvent(ILifecycleEvent event) {
						if (event.getKind() == Kind.ACTIVATED) {
							getInstance().initResources();
						}
					}
				});

			}

			return element;
		}
	}

}
