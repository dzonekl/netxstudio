package com.netxforge.netxstudio.data.cdo;

import com.google.inject.Inject;
import com.netxforge.netxstudio.data.DataService;
import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.data.IRoleHandler;

public class CDODataService extends DataService {
	
	private CDOQueryUtil queryService;
	
	@Inject
	public CDODataService(IDataProvider provider, IRoleHandler roleHandler, CDOQueryUtil queryService) {
		super(provider, roleHandler);
	}

	public CDOQueryUtil getQueryService() {
		return queryService;
	}

}
