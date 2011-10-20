package com.netxforge.netxstudio.data.importer;

import java.util.Date;
import java.util.List;

import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.metrics.KindHintType;

public interface IImporterHelper {
	
	/**
	 * Add the resource value to the value range. 
	 * @param foundNetXResource
	 * @param periodHint
	 * @param kindHintType
	 * @param newValues
	 * @param start
	 * @param end
	 */
	public abstract void addToValueRange(NetXResource foundNetXResource,
			int periodHint, KindHintType kindHintType, List<Value> newValues,
			Date start, Date end);

	
	/**
	 * The sub engines like the element locator and other logics, 
	 * needing a dataprovider. 
	 */
	public abstract void initializeProviders(NetworkElementLocator locator);

	
	/**
	 * A potential local dataprovider. 
	 * @return
	 */
	public abstract IDataProvider getDataProvider();
		
	
	public abstract void setImporter(AbstractMetricValuesImporter importer);
	
}