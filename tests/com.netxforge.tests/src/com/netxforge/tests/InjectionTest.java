package com.netxforge.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.data.IDataService;

public class InjectionTest extends AbstractInjectedTestJUnit4 {

	@Inject
	private ModelUtils modelUtils; 
	
	@Inject
	private IDataService dataService;
	
	@Before
	public void setup(){
		this.getClientInjector().injectMembers(this);
	}
	
	@Test
	public void testCommonServices() {
		Assert.assertNotNull(modelUtils);
		Assert.assertNotNull(dataService);
		Assert.assertNotNull(dataService.getProvider());
		Assert.assertNotNull(dataService.getQueryService());
	}

}
