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

import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.operators.Marker;
import com.netxforge.netxstudio.operators.ResourceMonitor;

/**
 * Defines a model for retrieving what is needed from a {@link NetXResource resource}.
 * The model can be used in several ways. Implementors should implement the <code>has...</code>
 * methods to match what is set on the model. The method {@link IChartModel#isChartModelOk()}
 * should return if the model is in such a state that it can be used. 
 * 
 * 
 * @author Christophe Bouhier
 */
public interface IChartModel {

	public abstract boolean isChartModelOk();

	public abstract DateTimeRange getPeriod();

	public abstract int getInterval();

	public abstract NetXResource getNetXResource();

	public abstract ResourceMonitor getResMonitor();

	public abstract List<Value> getValues();

	public abstract boolean hasMonitor();

	public abstract boolean hasCapacity();

	public abstract boolean hasUtilization();

	public abstract boolean hasNetXResource();

	public abstract Date[] getTimeStampArray();

	public abstract double[] getCapDoubleArray();

	public abstract double[] getMetriDoubleArray();

	public abstract double[] getUtilDoubleArray();

	public abstract List<Marker> getMarkers();

	public abstract boolean hasMarkers();

}