package com.netxforge.netxstudio.common.internal;

import com.google.inject.Injector;

public class InjectorProxy {
	
	public Injector getInjector(){
		return CommonActivator.getInstance().getInjector();
	}
	
}
