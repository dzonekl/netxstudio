package com.netxforge.netxstudio.server.test.dataprovider;

import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Inject;
import com.netxforge.netxstudio.NetxstudioPackage;
import com.netxforge.netxstudio.data.IDataService;
import com.netxforge.netxstudio.server.test.AbstractInjectedTestJUnit4;

public class BaseDataProviderTest extends AbstractInjectedTestJUnit4 {

	@Inject
	IDataService service;

	@Before
	public void setUp() throws Exception {
		getInjector().injectMembers(this);
	}

	@Test
	public void testConnection() throws Exception {
		// Open and close the session with an admin user.
		service.getProvider().openSession("admin", "admin");
		service.getProvider().closeSession();
	}

	@Test
	public void testFeatureAccessWithoutResourceSet() throws Exception {
		// Open and close the session with an admin user.
		service.getProvider().openSession("admin", "admin");

		Resource res = service.getProvider().getResource(
				NetxstudioPackage.Literals.NETXSTUDIO);

		Assert.assertNotNull(res);
		Assert.assertTrue(res instanceof CDOResource);

		URI uri = res.getURI();
		System.out.println(uri.toString());
		service.getProvider().closeSession();
	}

}
