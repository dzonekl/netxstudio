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

import org.eclipse.emf.cdo.common.commit.handler.AsyncCommitInfoHandler;
import org.eclipse.emf.cdo.common.model.CDOPackageInfo;
import org.eclipse.emf.cdo.common.model.CDOPackageRegistry;
import org.eclipse.emf.cdo.common.revision.CDORevisionCache;
import org.eclipse.emf.cdo.common.revision.CDORevisionUtil;
import org.eclipse.emf.cdo.net4j.CDONet4jSession;
import org.eclipse.emf.cdo.net4j.CDONet4jSessionConfiguration;
import org.eclipse.emf.cdo.net4j.CDONet4jUtil;
import org.eclipse.emf.cdo.server.CDOServerUtil;
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
import org.eclipse.net4j.util.om.OMPlatform;
import org.eclipse.net4j.util.om.log.PrintLogHandler;
import org.eclipse.net4j.util.om.trace.PrintTraceHandler;
import org.eclipse.net4j.util.security.IPasswordCredentialsProvider;
import org.eclipse.net4j.util.security.PasswordCredentials;
import org.eclipse.net4j.util.security.PasswordCredentialsProvider;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.netxforge.base.cdo.ICDOData;
import com.netxforge.netxstudio.NetxstudioPackage;
import com.netxforge.netxstudio.data.cdo.CDOData;
import com.netxforge.netxstudio.data.fixtures.Fixtures;
import com.netxforge.netxstudio.generics.GenericsPackage;
import com.netxforge.netxstudio.geo.GeoPackage;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.protocols.ProtocolsPackage;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;
import com.netxforge.netxstudio.server.data.Server;
import com.netxforge.netxstudio.server.internal.ServerActivator;
import com.netxforge.netxstudio.services.ServicesPackage;

/**
 * Contains convenience methods.
 * 
 * @author Martin Taal
 * @author Christophe Bouhier
 */
@Singleton
public class ServerUtils implements IServerUtils {

	private static final String REPO_NAME = "repo1";
	private static final String SKIP_PACKAGE_INIT = "skipInit";

	// Control CDO Debugging using trace options.
	// Note that CDO Options will still set debugging, as the OM Activator
	// starts earlier thant this plugin, so change the configuration of the
	// product,
	// to have App plugins start earlier, or turn of the .options :-)
	static {
		OMPlatform.INSTANCE.addLogHandler(PrintLogHandler.CONSOLE);
		OMPlatform.INSTANCE.addTraceHandler(PrintTraceHandler.CONSOLE);
	}

	@Inject
	private CommitInfoHandler commitInfoHandler;

	private IJVMAcceptor acceptor;
	private IConnector connector;
	private String serverSideLogin = "" + System.currentTimeMillis();
	private boolean initServerDone;
	private boolean isInitializing = false;

	public ServerUtils() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.server.IServerUtils#checkRepositorySupported
	 * (org.eclipse.emf.cdo.server.IRepository)
	 */
	public void checkRepositorySupported(IRepository repository) {
		if (!repository.getName().equals(REPO_NAME)) {
			throw new IllegalArgumentException("Unexpected repository name "
					+ repository.getName() + " it must be " + REPO_NAME);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.server.IServerUtils#openJVMSession()
	 */
	public CDOSession openJVMSession() {
		final CDONet4jSession cdoSession = createSessionConfiguration()
				.openNet4jSession();
		cdoSession.options().setCommitTimeout(CDOData.COMMIT_TIMEOUT);

		return cdoSession;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.server.IServerUtils#deActivate()
	 */
	public void deActivate() {
		if (acceptor != null) {
			acceptor.close();
		}
		if (connector != null) {
			connector.close();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.server.IServerUtils#createSessionConfiguration()
	 */
	public CDONet4jSessionConfiguration createSessionConfiguration() {
		return createSessionConfiguration(true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.server.IServerUtils#createSessionConfiguration
	 * (boolean)
	 */
	public CDONet4jSessionConfiguration createSessionConfiguration(
			boolean caching) {
		// Prepare container
		final IManagedContainer container = IPluginContainer.INSTANCE;
		acceptor = JVMUtil.getAcceptor(container, "default");
		connector = JVMUtil.getConnector(container, "default");

		// Create configuration
		final CDONet4jSessionConfiguration sessionConfiguration = CDONet4jUtil
				.createNet4jSessionConfiguration();

		sessionConfiguration.setConnector(connector);
		sessionConfiguration.setRepositoryName(REPO_NAME);
		sessionConfiguration.setExceptionHandler(exceptionHandler);

		if (!caching) {

			// Note: Option to disable caching, this was of for Hibernate store,
			// but
			// back on for the DB Store.
			sessionConfiguration.setRevisionManager(CDORevisionUtil
					.createRevisionManager(CDORevisionCache.NOOP));

			// Also turn-off passive updates for such a session.
			sessionConfiguration.setPassiveUpdateEnabled(false);

		}
		final IPasswordCredentialsProvider credentialsProvider = new PasswordCredentialsProvider(
				new PasswordCredentials(serverSideLogin,
						serverSideLogin.toCharArray()));

		sessionConfiguration.setCredentialsProvider(credentialsProvider);
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.server.IServerUtils#getServerSideLogin()
	 */
	public String getServerSideLogin() {
		return serverSideLogin;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.server.IServerUtils#initializeServer(org.eclipse
	 * .emf.cdo.server.IRepository)
	 */
	public synchronized void initializeServer(IRepository repository) {

		if (initServerDone) {
			return;
		}
		isInitializing = true;

		// Set based on setting of NetXStudio server debugging.
		OMPlatform.INSTANCE.setDebugging(true);

		// TODO, Find out the DB schema name and table name to create queries.

		IStore store = repository.getStore();
		if (store instanceof IDBStore) {
			@SuppressWarnings("unused")
			IDBStore dbStore = (IDBStore) store;
			// IDBAdapter dbAdapter = dbStore.getDBAdapter();
			// Map<String, String> properties = dbStore.getProperties();
			// IDBSchema dbSchema = dbStore.getDBSchema();
			// String fullName = dbSchema.getFullName();
			// System.out.println("Our Schema name (To use in Queries)"
			// + dbSchema.getName());
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
							signalProtocol.setTimeout(ICDOData.SIGNAL_TIME_OUT);
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

		// CB TODO, Do a lazy binding on the commit info handler.

		// must be done after initializing the resources etc.
		final AsyncCommitInfoHandler asyncCommitInfoHandler = new AsyncCommitInfoHandler(
				commitInfoHandler);
		asyncCommitInfoHandler.activate();

		repository.getCommitInfoManager().addCommitInfoHandler(
				asyncCommitInfoHandler);

		initServerDone = true;
		isInitializing = false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.server.IServerUtils#isInitializing()
	 */
	public boolean isInitializing() {
		return isInitializing;
	}

	public static class ServerInitializer {

		@Inject
		@Server
		private ICDOData dataProvider;

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

			dataProvider.commitTransactionThenClose();
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
							ServerUtils serverUtils = ServerActivator
									.getInstance().getInjector()
									.getInstance(ServerUtils.class);
							serverUtils.initializeServer(repository);
						}
					}
				});
			}
			return element;
		}
	}

	public boolean isLoaded(EPackage epack) {
		IPluginContainer instance = IPluginContainer.INSTANCE;
		IRepository repository = CDOServerUtil.getRepository(instance, REPO_NAME);
		CDOPackageInfo packageInfo = repository.getPackageRegistry()
				.getPackageInfo(epack);
		return packageInfo != null;
	}

	public boolean load(EPackage epack) {
		
		LocalSession localSession = new LocalSession();
		ServerActivator.getInstance().getInjector().injectMembers(localSession);
		
		localSession.getDataProvider().openSession();
		CDOPackageRegistry packageRegistry = localSession.getDataProvider().getSession().getPackageRegistry();
		
		CDOPackageInfo packageInfo = packageRegistry
				.getPackageInfo(epack);
		if (packageInfo == null) {
			packageRegistry.putEPackage(epack);
			localSession.getDataProvider().closeSession();
			return true;
		}
		return false;
		
	}
	
	
	class LocalSession{
		
		@Inject
		@Server
		private ICDOData dataProvider;
		
		public ICDOData getDataProvider() {
			return dataProvider;
		}
		
	}
	
	
	

}
