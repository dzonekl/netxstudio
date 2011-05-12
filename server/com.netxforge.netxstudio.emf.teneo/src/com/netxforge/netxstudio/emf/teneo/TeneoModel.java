package com.netxforge.netxstudio.emf.teneo;

import java.io.IOException;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.teneo.hibernate.resource.HibernateResource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Library;
import com.netxforge.netxstudio.library.LibraryFactory;
import com.netxforge.netxstudio.operators.Node;

/**
 * http://docs.jboss.org/hibernate/core/3.3/reference/en/html/queryhql.html
 * 
 * @author dzonekl
 * 
 */
public class TeneoModel {

	/**
	 * Convenience methods for dealing with the Teneo store.
	 * 
	 * @return
	 */
	public static Library getTeneoLibrary() {

		assert TeneoService.getInstance().getDataStore().isInitialized();

		Library lib = null;
		Session session = TeneoService.getInstance().getSession();
		if (!hasTeneoLibrary(session)) {
			// Create a Library.
			session.beginTransaction();
			lib = LibraryFactory.eINSTANCE.createLibrary();
			lib.setName("NetXLib");
//			lib.setDescription("netxstudio library");
//			lib.setVersion(new Double(0.01).doubleValue());
			session.save(lib);
			session.getTransaction().commit();
		} else {

			lib = firstTeneoLibrary(session);
		}

		session.close();
		return lib;
	}
	
//	public static MetricLibrary getTeneoMetricLibrary() {
//
//		assert TeneoService.getInstance().getDataStore().isInitialized();
//
//		MetricLibrary lib = null;
//		Session session = TeneoService.getInstance().getSession();
//		session.beginTransaction();
//		if (!hasTeneoMetricLibrary(session)) {
//			// Create a Library.
//			lib = MetricsFactory.eINSTANCE.createMetricLibrary();
//			lib.setName("NetXMetricLib");
//			session.save(lib);
//			session.getTransaction().commit();
//		} else {
//
//			lib = firstTeneoMetricLibrary(session);
//		}
//
//		session.close();
//		return lib;
//	}

	/**
	 * Provide an open session.
	 * 
	 * @param session
	 */
	public static boolean hasTeneoLibrary(Session session) {
		assert session != null && session.isConnected() && session.isOpen();
		Query query = session.createQuery("FROM Library");
		List<?> libraries = query.list();
		return !libraries.isEmpty();
	}

	
	public static boolean hasTeneoMetricLibrary(Session session) {
		assert session != null && session.isConnected() && session.isOpen();
		Query query = session.createQuery("FROM MetricLibrary");
		List<?> libraries = query.list();
		return !libraries.isEmpty();
	}

	// NOTE, this is only the library object, not a resource containing all
	// objects.

	public static Library firstTeneoLibrary(Session session) {
		assert session != null && session.isConnected() && session.isOpen();
		Query query = session.createQuery("FROM Library");
		List<?> libraries = query.list();
		if (!libraries.isEmpty()) {
			return (Library) libraries.get(0);
		}
		return null;
	}
	
//	public static MetricLibrary firstTeneoMetricLibrary(Session session) {
//		assert session != null && session.isConnected() && session.isOpen();
//		Query query = session.createQuery("FROM MetricLibrary");
//		List<?> metricLibraries = query.list();
//		if (!metricLibraries.isEmpty()) {
//			return (MetricLibrary) metricLibraries.get(0);
//		}
//		return null;
//	}

	public static Node getNode(String nodeID, Session session) {
		assert session != null && session.isConnected() && session.isOpen();
		String sQuery = "FROM Node WHERE nodeid='" + nodeID + "'";
		System.out.println("Query:" + sQuery);
		Query query = session.createQuery(sQuery);
		List<?> result = query.list();
		if (result.isEmpty()) {
			return null;
		}
		return (Node) result.get(0);
	}

	public static Equipment getEquipment(String position, Session session) {
		assert session != null && session.isConnected() && session.isOpen();
		String sQuery = "TODO";
		// System.out.println("Query:" + sQuery);
		Query query = session.createQuery(sQuery);
		List<?> result = query.list();
		if (result.isEmpty()) {
			return null;
		}
		return (Equipment) result.get(0);
	}

	/**
	 * We also commit.
	 * 
	 * @param session
	 * @param lib
	 */
	public static void flushTeneoLibrary(Session session, Library lib) {
		session.delete(lib);
		session.getTransaction().commit();
	}

	/**
	 * Get/Create a library from our Hibernatestore. We assume a resource exist
	 * in this set.
	 * 
	 * @return
	 */
	public static Library getTeneoLibrary(TransactionalEditingDomain domain) {

		Resource res = null;
		for (Resource r : domain.getResourceSet().getResources()) {
			if (r instanceof HibernateResource) {
				res = r;
				break;
			}
		}

		// Check the contents (roughly), and set some if empty.
		if (res != null && res.getContents().size() > 0) {
			return (Library) res.getContents().get(0);
		} else {
			if (res != null) {
				// Execute in an abstract EMF Operation!
				final Resource initRes = res;
				IUndoableOperation operation = new AbstractEMFOperation(domain,
						"Init the library") {
					@Override
					protected IStatus doExecute(IProgressMonitor monitor,
							IAdaptable info) throws ExecutionException {
						ModelUtil.initializeLibrary(initRes);
						return Status.OK_STATUS;
					}
				};

				try {
					OperationHistoryFactory.getOperationHistory().execute(
							operation, new NullProgressMonitor(), null);
				} catch (ExecutionException e1) {
					e1.printStackTrace();
				}

				if (!res.getContents().isEmpty()) {
					try {
						res.save(null);
						return (Library) res.getContents().get(0);
					} catch (IOException e) {
						// TODO, report exception.
					}
				}
			}
		}
		return null;
	}

	public static Resource getTeneoResource(ResourceSet set) {
		for (Resource resource : set.getResources()) {
			if (resource instanceof HibernateResource) {
				return resource;
			}
		}
		return null;
	}
	
	public static void saveContent(EObject object, IProgressMonitor monitor){
		monitor.beginTask("Saving", 100);
		if( TeneoService.getInstance().initialized()){
			Session session = TeneoService.getInstance().getSession();
			Transaction tx = session.beginTransaction();
			// Save our copy.
			session.save(object);
			try {
				monitor.subTask("Committing... ");
				tx.commit();
				monitor.worked(90);
			} catch (Exception e) {
				monitor.subTask("Rollback... ");
				if (tx != null)
					tx.rollback();
				monitor.setCanceled(true);
				return;
			}
			monitor.subTask("Done... ");
			monitor.done();
			session.close();
		}else{
			monitor.setCanceled(true);
		}
	}
	
	
	// This object gets saved, without further check if we have it or not. 
	public static void addTeneoContent(EObject object, IProgressMonitor monitor) {
		monitor.beginTask("Adding...", 100);
		monitor.subTask("Fetching database...");
		// Init a session.
		if (TeneoService.getInstance().initialized()) {
			monitor.worked(40);
		} else {
			// No DB available.
			monitor.setCanceled(true);
			return;
		}

		Session session = TeneoService.getInstance().getSession();
		Transaction tx = session.beginTransaction();

		// Save our copy.
		session.save(object);

		try {
			monitor.subTask("Committing... ");
			tx.commit();
			monitor.worked(90);
		} catch (Exception e) {
			monitor.subTask("Rollback... ");
			if (tx != null)
				tx.rollback();
			monitor.setCanceled(true);
			return;
		}
		// Notify we succeeded.
		monitor.subTask("Done... ");
		monitor.done();
		session.close();
	}

	/**
	 * We flush our teneo content and replace it with the given root. Has to be
	 * of type {@link Library}
	 * 
	 * This method should be executed as a long running operation. TODO, provide
	 * a way to hook into the Hibernate Transaction and rollback on
	 * monitor.canceled()
	 * 
	 * @param root
	 */
	public static EObject setTeneoContent(EObject root, IProgressMonitor monitor) {

		monitor.beginTask("Creating a copy", 100);
		// Make a copy.
		EcoreUtil.Copier copier = new EcoreUtil.Copier();
		EObject copy = copier.copy(root);
		copier.copyReferences();
		if (copy == null || !(copy instanceof Library)) {
			// We need a copy to continue, notify that we failed.
			return null;
		}
		monitor.worked(30);
		monitor.subTask("Fetching database");
		// Init a session.
		if (TeneoService.getInstance().initialized()) {
			monitor.worked(40);
		} else {
			// No DB available.
			monitor.setCanceled(true);
			copy = null;
			return null;
		}
		
		Session session = TeneoService.getInstance().getSession();
		Transaction tx = session.beginTransaction();
		
		Library lib = null;
		// Check if we have data, invoke an export (silently) if we do.
		lib = TeneoModel.firstTeneoLibrary(session);
		if (lib != null) {
			monitor.subTask("Empty the library");
			TeneoModel.flushTeneoLibrary(session, lib);
		} else {
			// We have an empty Teneo.
		}
		
		monitor.subTask("Loading... ");
		monitor.worked(50);

		if (tx.wasCommitted()) {
			// Get a new transaction.
			tx = session.beginTransaction();
		}

		// Save our new copy.
		session.save(copy);

		try {
			monitor.subTask("Committing... ");
			tx.commit();
			monitor.worked(90);
		} catch (Exception e) {
			monitor.subTask("Rollback... ");
			if (tx != null)
				tx.rollback();
			monitor.setCanceled(true);
			return null;
		}

		lib = TeneoModel.firstTeneoLibrary(session);
		if (lib != null) {
			// Notify we succeeded.
			monitor.subTask("Done... ");
			monitor.done();
		}
		session.close();
		return lib;
	}
}
