package com.netxforge.netxstudio.server.test.dataprovider;

import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Inject;
import com.netxforge.netxstudio.NetxstudioPackage;
import com.netxforge.netxstudio.data.ICDODataService;
import com.netxforge.tests.AbstractInjectedTestJUnit4;

public class BaseDataProviderTest extends AbstractInjectedTestJUnit4 {

	@Inject
	ICDODataService service;

	@Before
	public void setUp() throws Exception {
		getClientInjector().injectMembers(this);
	}

	@Test
	public void testConnection() throws Exception {
		// Open and close the session with an admin user.
		service.getCDOData().openSession("admin", "admin");
		service.getCDOData().closeSession();
	}

	@Test
	public void testFeatureAccessWithoutResourceSet() throws Exception {
		// Open and close the session with an admin user.
		service.getCDOData().openSession("admin", "admin");

		Resource res = service.getCDOData().getResource(
				NetxstudioPackage.Literals.NETXSTUDIO);

		Assert.assertNotNull(res);
		Assert.assertTrue(res instanceof CDOResource);

		URI uri = res.getURI();
		System.out.println(uri.toString());
		service.getCDOData().closeSession();
	}

}
