package com.netxforge.netxstudio.data.cdo;

import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.data.DataService;
import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.data.IQueryService;

public class CDODataService extends DataService {
	
	
	@Inject
	public CDODataService(IDataProvider provider, IQueryService queryService, CDOQueryUtil queryUtil, ModelUtils modelUtils) {
		super(provider, queryService, modelUtils);
	}

}
