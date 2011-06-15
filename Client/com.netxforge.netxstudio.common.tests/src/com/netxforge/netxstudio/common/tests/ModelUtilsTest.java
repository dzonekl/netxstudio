package com.netxforge.netxstudio.common.tests;

import java.util.Date;

import com.netxforge.netxstudio.common.model.ModelUtils;

public class ModelUtilsTest extends AbstractCommonTest {
	
	ModelUtils modelUtils;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		modelUtils = this.injector.getInstance(ModelUtils.class);
		
	}

	public void testModelUtils() throws Exception {
		
		Date today = modelUtils.today();
		Date lastWeek = modelUtils.lastWeek();
		
		modelUtils.toString(today);
		modelUtils.toString(lastWeek);
		
	}
	
}
