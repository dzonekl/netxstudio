package com.netxforge.netxstudio.emf.teneo;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.teneo.hibernate.HbConstants;
import org.eclipse.emf.teneo.hibernate.HbDataStore;

/**
 * TODO OLD, migrate out usefull stuff to TeneoService. 
 * Singleton factory: The parameters to connect to hibernate are: 
 * <ul>
 * <li>DB driver</li>
 * <li>DB URL</li> 
 * <li>DB UserID</li>
 * <li>DB Password</li>
 * <li>DB Schema handling</li>
 * <li>DB Dialect</li>
 * </ul>
 * 
 * The hibernate settings are stored in the eclipse preference system. 
 * 
 * The factory, holds state of the Hibernate databasestore, so you can initialize
 * and check the status.
 * 
 * The driver (Or DB type) is hard coded for now. We could make this variable, 
 * but other DB drivers should be stored in the hibernate plugin. 
 * 
 * TODO, The logging mechanism, is set by the log4j.properties file in the
 * classpath. The appender, is to default system.out
 * 
 */
public class HibernateFactory {

	public static final int TEST_MODE = 1;

	protected static HibernateFactory self;
	protected final int mode;

	/**
	 * The datastore.
	 */
	protected HbDataStore hbds;

	/**
	 * This caches an instance of the model package.
	 */

	protected EPackage ePackage;
		
	/**
	 * Caches the names of the types that can be created as the root object.
	 */
	protected List<String> initialObjectNames;

	public static HibernateFactory getInstance(EPackage ePackage) {
		if (self == null) {
			self = new HibernateFactory(ePackage);
		}
		return self;
	}

	public HibernateFactory(EPackage ePackage) {
		mode = TEST_MODE;
		this.ePackage = ePackage;
	}

	/**
	 * Test the URI for a pattern, recognizing it as an hibernate URI.
	 * 
	 * @param testURI
	 * @return
	 */
	public boolean isHibernateURI(URI testURI) {
		if (testURI.scheme() != null && testURI.scheme().equals("hibernate")) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Get a file URI for an hibernate protocol URI.
	 * @param inputURI
	 * @return
	 */
	public URI getEquivalentURI(URI inputURI){
		if(isHibernateURI(inputURI)){
			return(URI.createFileURI(".icebreaker"));
		}
		else return inputURI;
	}
	
	/**
	 * Delegates and reports if the Hibernate datastore is not null and
	 * initialized. Can be used , to initiate a connection.
	 * 
	 * @return
	 */
	public boolean isConnected() {
		if (hbds != null && hbds.isInitialized()) {
			return true;
		} else
			return false;
	}

	public void disconnect() {
		if (hbds != null && hbds.isInitialized()) {
			
			hbds.close();
			
		}
	}

	/**
	 * @return the hbds
	 */
	public HbDataStore getHbds() {
		return hbds;
	}


	/**
	 * @param driver
	 *            The JDBC Drive. (The driver jar needs to be pre-loaded it
	 *            won't be here).
	 * @param user
	 *            The username of the database.
	 * @param url
	 *            The JDBC URL See hibernate.org
	 * @param password
	 *            The password of the database.
	 * @param schemhandling
	 *            Hibernate schema handling. (See hibernate.org).
	 * @param dialect
	 *            The Hibernate DB Dialect
	 */
	public void connectHibernate(String driver, String user, String url,
			String password, String schemhandling, String dialect) {
		// TODO 1. Validation and 2. create the properties.
	}

	/**
	 * Export using the hibernate function (Versus using an eclipse serializer).
	 * For testing purposes only. - Encoding is UTF-8 - Format is XML. - Output
	 * is a Byte stream.
	 */
	public void exportStore() {
		if (hbds != null) {
			ByteArrayOutputStream byOS = new ByteArrayOutputStream();
			hbds
					.exportDataStore(byOS, HbConstants.EXCHANGE_FORMAT_XML,
							"UTF-8");
			System.out.println(byOS.toString()); // TODO, shurly more than
			// printinh the stuff.
		}
	}

	/**
	 * Invokes URI variant. A new ResourceSet is created. TODO, Where does it
	 * go?
	 * 
	 * 
	 * @param resource
	 * @return
	 */
	public Resource getResourceFromString(String resource) {
		URI uri = URI.createURI(resource);
		return getResourceFromURI(uri);
	}

	public Resource getResourceFromURI(URI uri) {
		ResourceSet resourceSet = new ResourceSetImpl();
		return resourceSet.createResource(uri);
	}

	public EObject createDummyPlan(Resource resource) {
		return null;
	}

	/**
	 * Returns the names of the types that can be created as the root object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected Collection<String> getInitialObjectNames() {
		if (initialObjectNames == null) {
			initialObjectNames = new ArrayList<String>();
			for (EClassifier eClassifier : ePackage.getEClassifiers()) {
				if (eClassifier instanceof EClass) {
					EClass eClass = (EClass) eClassifier;
					if (!eClass.isAbstract()) {
						initialObjectNames.add(eClass.getName());
					}
				}
			}
			Collections.sort(initialObjectNames, java.text.Collator
					.getInstance());
		}
		return initialObjectNames;
	}

}
