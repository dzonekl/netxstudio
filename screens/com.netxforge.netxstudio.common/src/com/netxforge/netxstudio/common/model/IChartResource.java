/*******************************************************************************
 * Copyright (c) 24 aug. 2013 NetXForge.
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
package com.netxforge.netxstudio.common.model;

import java.util.Date;
import java.util.List;

import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.operators.Marker;

/**
 * Defines a model for retrieving what is needed from a {@link NetXResource resource}.
 * The model can be used in several ways. Implementors should implement the <code>has...</code>
 * methods to match what is set on the model. The method {@link IChartResource#isChartModelOk()}
 * should return if the model is in such a state that it can be used. 
 * 
 * 
 * @author Christophe Bouhier
 */
public interface IChartResource extends IFilteredChart {

	public abstract boolean isChartModelOk();

	public abstract NetXResource getNetXResource();

	public abstract boolean hasCapacity();

	public abstract boolean hasUtilization();

	public abstract boolean hasNetXResource();

	public abstract Date[] getTimeStampArray();

	public abstract double[] getCapDoubleArray();

	public abstract double[] getMetriDoubleArray();

	public abstract double[] getUtilDoubleArray();
	
	
	/**
	 * Get the trended values (Backwards for now). 
	 * @return
	 */
	public abstract double[] getTrendDoubleArray();
	

	public abstract List<Marker> getMarkers();

	public abstract boolean hasMarkers();
	
	/**
	 * A unique identifier for an {@link IChartResource}
	 * @return
	 */
	public abstract String getChartID(); 
	
	/**
	 *  A cached implementation can call this method to reset it 
	 *  and allow re-init. 
	 */
	public abstract void resetCaches();

}