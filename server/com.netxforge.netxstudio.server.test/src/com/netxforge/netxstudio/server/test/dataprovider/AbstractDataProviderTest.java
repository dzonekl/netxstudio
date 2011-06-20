package com.netxforge.netxstudio.server.test.dataprovider;

import junit.framework.TestCase;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.netxforge.netxstudio.common.CommonModule;
import com.netxforge.netxstudio.data.cdo.CDODataServiceModule;

public abstract class AbstractDataProviderTest extends TestCase {

	
	private Injector injector;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		injector = Guice.createInjector(new CommonModule(), new CDODataServiceModule());
	}

	@Override
	protected void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();
	}

	
	public Injector getInjector() {
		if (injector==null)
			throw new IllegalStateException("No injector set.");
		return injector;
	}
	
	
}
