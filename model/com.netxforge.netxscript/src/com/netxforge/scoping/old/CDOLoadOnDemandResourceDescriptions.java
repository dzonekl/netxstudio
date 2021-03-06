/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package com.netxforge.scoping.old;

import com.google.inject.Inject;
import com.netxforge.base.cdo.ICDOData;

/**
 * Customized version of LoadOnDemandDescriptions, the original version uses
 * ECoreUtil2 (From xtext) in method getResourceDescription to resolve the
 * resource from a URI. This works out to invoke the CDOResourceFactory, which
 * will create an "un-attached" resource. This implementation, use a data
 * provider instead.
 * 
 * 
 * Note: This xResourceDescriptions, is likely not capable to be notified of
 * model changes, and re-index based on this.
 * 
 * 
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 */
public class CDOLoadOnDemandResourceDescriptions extends
		AbstractCDOLoadOnDemandResourceDescriptions {

	public CDOLoadOnDemandResourceDescriptions() {
		super();
		System.out.println("Initialize ResourceDescriptions, we should be a singlton.");
	}


	@Inject
	private ICDOData dataProvider;
	
	
	@Override
	protected ICDOData getDataProvider() {
		return dataProvider;
	}
}
