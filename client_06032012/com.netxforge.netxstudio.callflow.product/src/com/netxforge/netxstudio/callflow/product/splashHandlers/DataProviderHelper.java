package com.netxforge.netxstudio.callflow.product.splashHandlers;

import com.google.inject.Inject;
import com.netxforge.netxstudio.data.IDataService;
import com.netxforge.netxstudio.data.internal.DataActivator;

/**
 * Delay the instantiation, after the workspace is set. 
 * @author dzonekl
 *
 */
public class DataProviderHelper {
	
	// Will initiate various plugins requiring a workspace. 
	@Inject
	private IDataService dataService;
	
	public IDataService getDataService(){
		DataActivator.getInjector().injectMembers(this);
		return dataService;
	}
	
}
