package com.netxforge.netxstudio.common.tests;

import junit.framework.TestCase;

import com.google.inject.Injector;
import com.netxforge.netxstudio.common.CommonStandalone;

public abstract class AbstractCommonTest extends TestCase {
	
	Injector injector;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		injector = new CommonStandalone().getInjector();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
}
