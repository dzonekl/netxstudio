/*******************************************************************************
 * Copyright (c) 22 sep. 2014 NetXForge.
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
package com.netxforge.oss2.inventory;

import com.netxforge.netxstudio.metrics.MetricSource;


/**
 * Process a {@link MetricSource} and map it our inventory model. 
 * 
 * @author Christophe Bouhier
 *
 */
public interface IInventoryService {
	
	
	/**
	 * Process a metric source 
	 * 
	 * @param metricSource
	 */
	public void processMetricSource(MetricSource metricSource);
	
	
	
	
	
	
	
}
