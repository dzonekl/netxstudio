package com.netxforge.netxstudio.common;

import com.google.inject.Guice;
import com.google.inject.Injector;


/**
 * Required to run the test cases. 
 * @author dzonekl
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
