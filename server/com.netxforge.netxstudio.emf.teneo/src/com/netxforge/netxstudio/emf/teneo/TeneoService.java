package com.netxforge.netxstudio.emf.teneo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Properties;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.teneo.PersistenceOptions;
import org.eclipse.emf.teneo.hibernate.HbHelper;
import org.eclipse.emf.teneo.hibernate.HbSessionDataStore;
import org.hibernate.Session;

public class TeneoService {

	// This database uri ensures that the Hibernate XML Resource is used and
	// that the
	// Library and the Diagram are loaded in the top of the resource. The dsname
	// parameter
	// is the name of the datastore initialized below.
	public static final URI DATABASE_HBXML_URI = URI
			.createURI("hbxml://?dsname=netxstudio&query1=from Library");

	public static final URI DATABASE_DIAGRAM_URI = URI
			.createURI("hbxml://?dsname=netxstudio&query1=from Library&query2=from Diagram");

	public static final URI DATABASE_URI = URI
			.createURI("hibernate://?dsname=netxstudio");

	public static final URI DATABASE_LIBRARY_URI = URI
			.createURI("hibernate://?dsname=netxstudio&query1=from Library");

	public static final URI DATABASE_METRICSRC_URI = URI
			.createURI("hibernate://?dsname=netxstudio&query1=from MetricLibrary");

	public static final URI TEST_LIBRARY_URI = URI
			.createURI("hibernate://?dsname=test&query1=from Library");

	// provide easy access to the datastore
	private static TeneoService INSTANCE = new TeneoService();

	public static TeneoService getInstance() {
		return INSTANCE;
	}

	private HbSessionDataStore localDataStore = null;

	public Session getSession() {
		assert initialized();
		return getDataStore().getSessionFactory().openSession();
	}

	public HbSessionDataStore getDataStore() {
		return localDataStore;
	}

	public void closeDataStore() {
		localDataStore.close();
		localDataStore = null;
		fireServiceClosed();
	}
	
	public HbSessionDataStore initializeDataStore(EPackage[] ePackages,
			Properties props, String dbName) {

		localDataStore = new HbSessionDataStore();
		localDataStore.setName(dbName);
		HbHelper.INSTANCE.register(localDataStore);
		localDataStore.setEPackages(ePackages);

		if (props == null) {
			props = new Properties();
			try {
				props.load(this.getClass().getResourceAsStream(
						"/teneo.properties"));
			} catch (IOException e) {
				// Blow up!
				e.printStackTrace();
			}
		}
		if (props != null) {
			localDataStore.setProperties(props);
			localDataStore.initialize();
		}
		
		this.fireServiceInitialized();
		return localDataStore;
	}

	/**
	 * Is the target datastore initialized.
	 * 
	 * @return
	 */
	public boolean initialized() {
		return this.localDataStore != null
				&& this.localDataStore.isInitialized();
	}

	public void printMappings() {
		if (initialized())
			System.out.println(localDataStore.getMappingXML());
	}

	/**
	 * NOT USED
	 * 
	 * @param props
	 */
	@SuppressWarnings("unused")
	private void setGMFSpecific(Properties props) {
		// GMF Settings.
		// handle multiple inheritance in the GMF model
		props.setProperty(PersistenceOptions.PERSISTENCE_XML, "annotations.xml");

		// solve a specific issue with the GMF model
		// localDataStore.getExtensionManager().registerExtension(
		// EListPropertyHandler.class.getName(),
		// GMFEListPropertyHandler.class.getName());
	}

	/**
	 * NOT USED.
	 */
	@SuppressWarnings("unused")
	private void writeMappingFile() {
		String mappingFileName = URI.createFileURI("/netxstudio.hbm.xml")
				.toString();
		File mappingFile = new File(mappingFileName);
		try {
			if (!mappingFile.exists()) {
				if (mappingFile.createNewFile()) {
				}
			}
			FileWriter writer = new FileWriter(mappingFile);
			// writer.write(mappingContent);
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public URI appendLibraryQuery(URI inURI) {
		String query = inURI.query();
		query = query.concat("&query1=from Library");
		return inURI.appendQuery(query);
	}

	public URI appendMetricLibraryQuery(URI inURI) {
		String query = inURI.query();
		query = query.concat("&query1=from MetricLibrary");
		return inURI.appendQuery(query);
	}

	
	
	// Service Notifications
	
	Collection<ITeneoServiceListener> teneoListeners = new ArrayList<ITeneoServiceListener>();
	
	public void addTeneoListener(ITeneoServiceListener listener){
		teneoListeners.add(listener);
	}
	
	public void removeTeneoListener(ITeneoServiceListener listener){
		if(teneoListeners.contains(listener)){
			teneoListeners.remove((listener));	
		}
	}
	protected void fireServiceInitialized(){
		for(ITeneoServiceListener listener: teneoListeners){
			listener.teneoInitialized();
		}
	}
	
	protected void fireServiceClosed(){
		for(ITeneoServiceListener listener: teneoListeners){
			listener.teneoDisconnected();
		}
	}

}
