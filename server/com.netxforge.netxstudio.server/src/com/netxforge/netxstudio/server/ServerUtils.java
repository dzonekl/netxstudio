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

import java.util.Map;

import javax.xml.datatype.DatatypeFactory;

import org.eclipse.emf.cdo.common.commit.handler.AsyncCommitInfoHandler;
import org.eclipse.emf.cdo.net4j.CDONet4jUtil;
import org.eclipse.emf.cdo.net4j.CDOSessionConfiguration;
import org.eclipse.emf.cdo.server.IRepository;
import org.eclipse.emf.cdo.server.ISession;
import org.eclipse.emf.cdo.server.IStore;
import org.eclipse.emf.cdo.server.db.IDBStore;
import org.eclipse.emf.cdo.session.CDOSession;
import org.eclipse.emf.cdo.session.CDOSession.ExceptionHandler;
import org.eclipse.emf.cdo.spi.server.ISessionProtocol;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.net4j.connector.IConnector;
import org.eclipse.net4j.jvm.IJVMAcceptor;
import org.eclipse.net4j.jvm.JVMUtil;
import org.eclipse.net4j.signal.ISignalProtocol;
import org.eclipse.net4j.util.container.ContainerEventAdapter;
import org.eclipse.net4j.util.container.IContainer;
import org.eclipse.net4j.util.container.IElementProcessor;
import org.eclipse.net4j.util.container.IManagedContainer;
import org.eclipse.net4j.util.container.IPluginContainer;
import org.eclipse.net4j.util.lifecycle.ILifecycleEvent;
import org.eclipse.net4j.util.lifecycle.ILifecycleEvent.Kind;
import org.eclipse.net4j.util.lifecycle.LifecycleEventAdapter;
import org.eclipse.net4j.util.lifecycle.LifecycleState;
import org.eclipse.net4j.util.om.OMPlatform;
import org.eclipse.net4j.util.om.log.PrintLogHandler;
import org.eclipse.net4j.util.om.trace.PrintTraceHandler;
import org.eclipse.net4j.util.security.IPasswordCredentialsProvider;
import org.eclipse.net4j.util.security.PasswordCredentials;
import org.eclipse.net4j.util.security.PasswordCredentialsProvider;
import org.osgi.framework.ServiceReference;

import com.google.inject.Inject;
import com.netxforge.netxstudio.NetxstudioPackage;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.data.cdo.CDODataProvider;
import com.netxforge.netxstudio.data.fixtures.Fixtures;
import com.netxforge.netxstudio.generics.GenericsPackage;
import com.netxforge.netxstudio.geo.GeoPackage;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.protocols.ProtocolsPackage;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;
import com.netxforge.netxstudio.server.internal.ServerActivator;
import com.netxforge.netxstudio.server.service.NetxForgeService;
import com.netxforge.netxstudio.services.ServicesPackage;

/**
 * Contains convenience methods.
 * 
 * @author Martin Taal
 * @author Christophe Bouhier
 */
@SuppressWarnings("deprecation")
public class ServerUtils {

	private static final String REPO_NAME = "repo1";
	private static final String SKIP_PACKAGE_INIT = "skipInit";

	@SuppressWarnings("unused")
	private DatatypeFactory dataTypeFactory;

	// Control CDO Debugging using trace options.
	// Note that CDO Options will still set debugging, as the OM Activator
	// starts earlier thant this plugin, so change the configuration of the
	// product,
	// to have App plugins start earlier, or turn of the .options :-)
	static {
		OMPlatform.INSTANCE.addLogHandler(PrintLogHandler.CONSOLE);
		OMPlatform.INSTANCE.addTraceHandler(PrintTraceHandler.CONSOLE);
		OMPlatform.INSTANCE.setDebugging(ServerActivator.DEBUG);
	}

	private static ServerUtils instance = new ServerUtils();

	@Inject
	private CommitInfoHandler commitInfoHandler;

	public static ServerUtils getInstance() {
		return instance;
	}

	private IJVMAcceptor acceptor;
	private IConnector connector;
	private String serverSideLogin = "" + System.currentTimeMillis();
	private boolean initServerDone;
	private boolean isInitializing = false;

	public ServerUtils() {
		try {
			dataTypeFactory = DatatypeFactory.newInstance();
		} catch (final Exception e) {
			throw new IllegalStateException(e);
		}

		if (commitInfoHandler == null) {
			ServerActivator.getInstance().getInjector().injectMembers(this);
		}

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

	public void checkRepositorySupported(IRepository repository) {
		if (!repository.getName().equals(REPO_NAME)) {
			throw new IllegalArgumentException("Unexpected repository name "
					+ repository.getName() + " it must be " + REPO_NAME);
		}
	}

	public CDOSession openJVMSession() {
		final CDOSession cdoSession = createSessionConfiguration()
				.openSession();
		((org.eclipse.emf.cdo.net4j.CDOSession.Options) cdoSession.options())
				.setCommitTimeout(CDODataProvider.COMMIT_TIMEOUT);

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

	public CDOSessionConfiguration createSessionConfiguration() {
		// Prepare container
		final IManagedContainer container = IPluginContainer.INSTANCE;
		acceptor = JVMUtil.getAcceptor(container, "default");
		connector = JVMUtil.getConnector(container, "default");

		// Create configuration
		final CDOSessionConfiguration sessionConfiguration = CDONet4jUtil
				.createSessionConfiguration();

//		sessionConfiguration.setSignalTimeout(60L * 1000L);

		sessionConfiguration.setConnector(connector);
		sessionConfiguration.setRepositoryName(REPO_NAME);
		sessionConfiguration.setExceptionHandler(exceptionHandler);

		// TODO, Make the passive update mode optional.
		// When the mode is changes, we receive revision deltas which can be
		// used
		// to update more efficiently.
		// For indexes, we could limit the update to only the changed items.
		//

		// sessionConfiguration.setPassiveUpdateMode(PassiveUpdateMode.CHANGES);

		// Note: Option to disable caching, this was of for Hibernate store, but
		// back on for the DB Store.
		// sessionConfiguration.setRevisionManager(CDORevisionUtil
		// .createRevisionManager(CDORevisionCache.NOOP));

		final IPasswordCredentialsProvider credentialsProvider = new PasswordCredentialsProvider(
				new PasswordCredentials(serverSideLogin,
						serverSideLogin.toCharArray()));

		sessionConfiguration.getAuthenticator().setCredentialsProvider(
				credentialsProvider);
		// set to a minute

		return sessionConfiguration;
	}

	// A customer exception handler implementation.
	ServerExceptionHandler exceptionHandler = new ServerExceptionHandler();

	/*
	 * Types of exceptions we can expect. Commit exceptions, duplicate
	 * identifier on Join Tables. Timeout exceptions.
	 * 
	 * @author Christophe
	 */
	class ServerExceptionHandler implements ExceptionHandler {

		public void handleException(CDOSession session, int attempt,
				Exception exception) throws Exception {

			exception.printStackTrace();

		}
	}

	public String getServerSideLogin() {
		return serverSideLogin;
	}

	/**
	 * Initialize the server for the given {@link IRepository} This method is
	 * called from multiple plugins, whenever they become active and discover
	 * the repository has become {@link LifecycleState#ACTIVE active}
	 * 
	 * @param repository
	 */
	public synchronized void initializeServer(IRepository repository) {
		if (initServerDone) {
			return;
		}
		isInitializing = true;

		// TODO, Find out the DB schema name and table name to create queries.
		IStore store = repository.getStore();
		if (store instanceof IDBStore) {
			@SuppressWarnings("unused")
			IDBStore dbStore = (IDBStore) store;
		}

		// Increase the signal timeout.
		repository.getSessionManager().addListener(
				new ContainerEventAdapter<ISession>() {
					@Override
					protected void onAdded(IContainer<ISession> container,
							ISession session) {
						ISessionProtocol protocol = session.getProtocol();
						if (protocol instanceof ISignalProtocol) {
							ISignalProtocol<?> signalProtocol = (ISignalProtocol<?>) protocol;
							signalProtocol
									.setTimeout(IDataProvider.SIGNAL_TIME_OUT);
						}
					}
				});

		final boolean skipInitPackages;

		final String property = System.getProperty(SKIP_PACKAGE_INIT);
		if (property != null && property.equals(Boolean.TRUE.toString())) {
			skipInitPackages = true;
		} else {
			skipInitPackages = false;
		}

		if (!skipInitPackages) {
			// Skip init resources.
			final ServerInitializer resourceInitializer = ServerActivator
					.getInstance().getInjector()
					.getInstance(ServerInitializer.class);

			resourceInitializer.initialize();

		}
		// must be done after initializing the resources etc.
		final AsyncCommitInfoHandler asyncCommitInfoHandler = new AsyncCommitInfoHandler(
				commitInfoHandler);
		asyncCommitInfoHandler.activate();
		repository.addCommitInfoHandler(asyncCommitInfoHandler);

		initServerDone = true;
		isInitializing = false;
	}

	public boolean isInitializing() {
		return isInitializing;
	}

	static class ServerInitializer {

		@Inject
		@Server
		private IDataProvider dataProvider;

		@Inject
		private ModelUtils modelUtils;

		@Inject
		private Fixtures fixtures;

		private void initialize() {
			initPackages();
			initResources();
		}

		private void initPackages() {
			CDOSession cdoSession = dataProvider.openSession();
			cdoSession.getPackageRegistry().putEPackage(GeoPackage.eINSTANCE);
			cdoSession.getPackageRegistry().putEPackage(
					GenericsPackage.eINSTANCE);
			cdoSession.getPackageRegistry().putEPackage(
					NetxstudioPackage.eINSTANCE);
			cdoSession.getPackageRegistry().putEPackage(
					LibraryPackage.eINSTANCE);
			cdoSession.getPackageRegistry().putEPackage(
					MetricsPackage.eINSTANCE);
			cdoSession.getPackageRegistry().putEPackage(
					OperatorsPackage.eINSTANCE);
			cdoSession.getPackageRegistry().putEPackage(
					ProtocolsPackage.eINSTANCE);
			cdoSession.getPackageRegistry().putEPackage(
					SchedulingPackage.eINSTANCE);
			cdoSession.getPackageRegistry().putEPackage(
					ServicesPackage.eINSTANCE);
			cdoSession.close();

		}

		private void initResources() {
			dataProvider.openSession();
			dataProvider.getTransaction();
			dataProvider.getTransaction().getOrCreateResource("/");
			initResourcesForEPackage(GenericsPackage.eINSTANCE);
			initResourcesForEPackage(GeoPackage.eINSTANCE);
			initResourcesForEPackage(LibraryPackage.eINSTANCE);
			initResourcesForEPackage(MetricsPackage.eINSTANCE);
			initResourcesForEPackage(OperatorsPackage.eINSTANCE);
			initResourcesForEPackage(ProtocolsPackage.eINSTANCE);
			initResourcesForEPackage(SchedulingPackage.eINSTANCE);
			initResourcesForEPackage(ServicesPackage.eINSTANCE);

			fixtures.setDataProvider(dataProvider);
			// Load the fixtures.
			// fixtures.unloadFixtures(); // UNCOMMENT TO RELOAD FIXTURES.
			fixtures.loadFixtures();

			dataProvider.commitTransaction();
			dataProvider.closeSession();
		}

		// Creates or loads the CDOResources, which are entry points in the DB.
		private void initResourcesForEPackage(EPackage ePackage) {
			for (final EClassifier eClassifier : ePackage.getEClassifiers()) {
				if (eClassifier instanceof EClass) {
					final EClass eClass = (EClass) eClassifier;
					dataProvider.getResource(eClass);
				}
			}
		}
	}

	public static class ServerElementProcessor implements IElementProcessor {

		public Object process(IManagedContainer container, String productGroup,
				String factoryType, String description, Object element) {
			if (element instanceof IRepository) {
				// create all the resources at startup
				final IRepository repository = (IRepository) element;
				repository.addListener(new LifecycleEventAdapter() {
					@Override
					public void notifyLifecycleEvent(ILifecycleEvent event) {
						if (event.getKind() == Kind.ACTIVATED) {
							getInstance().initializeServer(repository);
						}
					}
				});

			}

			return element;
		}
	}

}
