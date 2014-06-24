package com.netxforge.netxstudio.server.test.dataprovider;

import org.junit.Before;
import org.junit.Test;

import com.netxforge.netxstudio.data.ICDODataService;
import com.netxforge.tests.AbstractInjectedTestJUnit4;

public abstract class AbstractDataServiceTest4 extends
		AbstractInjectedTestJUnit4 {

	protected ICDODataService service;

	@Before
	public void up() {
		service = super.getClientInjector().getInstance(ICDODataService.class);
	}

	@Test
	public void testConnection() throws Exception {
		// Open and close the session with an admin user.
		service.getCDOData().openSession("admin", "admin");
		service.getCDOData().closeSession();
	}

}
