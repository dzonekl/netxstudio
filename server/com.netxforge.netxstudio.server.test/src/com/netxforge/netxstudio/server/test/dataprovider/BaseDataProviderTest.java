package com.netxforge.netxstudio.server.test.dataprovider;

import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

import com.netxforge.netxstudio.NetxstudioPackage;
import com.netxforge.netxstudio.data.IDataService;

public class BaseDataProviderTest extends AbstractDataProviderTest {

	IDataService service;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		 service = super.getInjector().getInstance(IDataService.class);
	}
	public void testConnection() throws Exception {
		// Open and close the session with an admin user. 
		service.getProvider().openSession("admin", "admin");
		service.getProvider().closeSession();
	}
	
	public void testFeatureAccessWithoutResourceSet() throws Exception {
		// Open and close the session with an admin user. 
		service.getProvider().openSession("admin", "admin");
		
		Resource res = service.getProvider().getResource(NetxstudioPackage.Literals.NETXSTUDIO);
		
		assertNotNull(res);
		assertTrue(res instanceof CDOResource);
		
		URI uri = res.getURI();
		System.out.println(uri.toString());
		service.getProvider().closeSession();
	}
	
}
