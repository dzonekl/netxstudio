package com.netxforge.netxstudio.common;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.netxforge.netxstudio.common.internal.CommonModule;


/**
 * Required to run the test cases. 
 * @author Christophe Bouhier
 *
 */
public class CommonStandalone {
	
	Injector injector;
	
	public Injector getInjector() {
		if(injector == null)
			initialize();
		return injector;
	}

	public void initialize(){
		injector = Guice.createInjector(new CommonModule());
	}
	
	
	
}
