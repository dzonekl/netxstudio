/*******************************************************************************
 * Copyright (c) 1 jan. 2013 NetXForge.
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details. You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors: Christophe Bouhier - initial API and implementation and/or
 * initial documentation
 *******************************************************************************/
package com.netxforge.netxstudio.data.importer;

import java.util.Date;
import java.util.List;
import java.util.Properties;

import com.netxforge.netxstudio.data.IData;
import com.netxforge.netxstudio.data.index.IComponentLocator;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.metrics.KindHintType;
import com.netxforge.netxstudio.metrics.ValueDataKind;

/**
 * A Helper which holds various facilities to support the import process.
 * 
 * @author Christophe Bouhier
 * 
 */
public interface IImporterHelper {

	public abstract int addMetricValue(ValueDataKind vdk, Date timeStamp,
			Component networkElement, Double dblValue, int periodHint);

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

	public abstract void initializeProviders(IComponentLocator locator);

	/**
	 * A potential local dataprovider.
	 * 
	 * @return
	 */
	public abstract IData getDataProvider();

	/**
	 * Set the importer to be used.
	 * 
	 * @param importer
	 */
	public abstract void setImporter(AbstractMetricValuesImporter importer);

	/**
	 * Can be called to check the cancellation status. For scheduled imports,
	 * the implementation can check the Quartz scheduler status. For manually
	 * triggered imports, the implementation can check for manual cancellation
	 * events.
	 * 
	 * @return
	 */
	public abstract boolean cancelled();
	
	
	/**
	 * Get {@link Properties} used by an Importer.  
	 * 
	 * @return
	 */
	public abstract Properties properties(); 

}
