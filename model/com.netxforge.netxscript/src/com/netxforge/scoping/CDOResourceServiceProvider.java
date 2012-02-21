package com.netxforge.scoping;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.impl.DefaultResourceServiceProvider;

/**
 * Almost a literal copy from GenericResourceServiceProvider. 
 * @see {@link org.eclipse.xtext.resource.generic.AbstractGenericResourceRuntimeModule}
 * @author dzonekl
 *
 */
public class CDOResourceServiceProvider extends DefaultResourceServiceProvider
		 {
	

	public boolean canHandle(URI uri) {
		boolean canHandle = super.canHandle(uri);
		if(canHandle){
			return true;
		}
		System.out.println(uri.toString());
		
		String scheme = uri.scheme(); // Same as protocol.
		if("cdo".equals(scheme)){
			return true;
		}else{
			return false;
		}
	}
	
	
	
	
}
