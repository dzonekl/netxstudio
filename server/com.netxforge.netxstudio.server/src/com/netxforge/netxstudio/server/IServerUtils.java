package com.netxforge.netxstudio.server;

import org.eclipse.emf.cdo.net4j.CDONet4jSessionConfiguration;
import org.eclipse.emf.cdo.server.IRepository;
import org.eclipse.emf.cdo.session.CDOSession;
import org.eclipse.net4j.util.lifecycle.LifecycleState;

import com.netxforge.netxstudio.data.IData;

public interface IServerUtils {

	public abstract void checkRepositorySupported(IRepository repository);

	/**
	 * TODO, this is not very different from {@link IData#openSession() }
	 * as the session type is done by the Session config..
	 * 
	 * @return
	 */
	public abstract CDOSession openJVMSession();

	public abstract void deActivate();

	public abstract CDONet4jSessionConfiguration createSessionConfiguration();

	public abstract CDONet4jSessionConfiguration createSessionConfiguration(
			boolean caching);

	public abstract String getServerSideLogin();

	/**
	 * Initialize the server for the given {@link IRepository} This method is
	 * called from multiple plugins, whenever they become active and discover
	 * the repository has become {@link LifecycleState#ACTIVE active}
	 * 
	 * @param repository
	 */
	public abstract void initializeServer(IRepository repository);

	public abstract boolean isInitializing();

}