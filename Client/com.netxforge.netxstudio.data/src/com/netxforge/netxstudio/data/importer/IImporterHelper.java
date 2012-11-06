package com.netxforge.netxstudio.data.importer;

import java.util.Date;
import java.util.List;

import org.osgi.framework.BundleActivator;

import com.netxforge.netxstudio.data.IDataProvider;
import com.netxforge.netxstudio.data.importer.ComponentLocator.IdentifierDescriptor;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.metrics.KindHintType;
import com.netxforge.netxstudio.metrics.MappingColumn;

public interface IImporterHelper {

	public abstract void addMetricValue(MappingColumn column, Date timeStamp,
			Component networkElement, Double dblValue, int periodHint, IdentifierDescriptor lastMatchingDescriptor);

	/**
	 * Add the resource value to the value range.
	 * 
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
	 * The sub engines like the element locator and other logics, needing a
	 * dataprovider.
	 */
	public abstract void initializeProviders(ComponentLocator locator);

	/**
	 * A potential local dataprovider.
	 * 
	 * @return
	 */
	public abstract IDataProvider getDataProvider();
	
	
	/**
	 * Set the importer to be used. 
	 * @param importer
	 */
	public abstract void setImporter(AbstractMetricValuesImporter importer);
	

	/**
	 * Can be called to check the cancellation status. 
	 * For scheduled imports, the implementation can check the Quartz scheduler status. 
	 * For manually triggered imports, the implementation can check for manual cancellation events. 
	 * 
	 * @return
	 */
	public abstract boolean cancelled();
	
	
	/**
	 * Get Activator.
	 * @return
	 */
	public abstract BundleActivator getActivator();
	
	
	/**
	 * Set Activator.
	 * @return
	 */
	public abstract void setActivator(BundleActivator p);
	
	
}
