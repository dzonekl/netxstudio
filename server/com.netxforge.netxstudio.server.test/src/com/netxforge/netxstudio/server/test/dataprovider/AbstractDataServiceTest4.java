package com.netxforge.netxstudio.server.test.dataprovider;

import org.junit.Before;
import org.junit.Test;

import com.netxforge.netxstudio.data.IDataService;
import com.netxforge.tests.AbstractInjectedTestJUnit4;

public abstract class AbstractDataServiceTest4 extends AbstractInjectedTestJUnit4 {

	protected IDataService service;
	
	@Before
	public void up() {
		service = super.getInjector().getInstance(IDataService.class);
	}
	
	@Test
	public void testConnection() throws Exception {
		// Open and close the session with an admin user. 
		service.getProvider().openSession("admin", "admin");
		service.getProvider().closeSession();
	}
	
}
