/*******************************************************************************
 * Copyright (c) 18 dec. 2012 NetXForge.
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
package com.netxforge.netxstudio.screens.showins;

import java.util.List;

import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.metrics.KindHintType;
import com.netxforge.netxstudio.operators.Marker;
import com.netxforge.netxstudio.operators.ResourceMonitor;

/**
 * 
 * @author Christophe Bouhier
 *
 */
public class ChartShowInContext {
	
	/*
	 * The time range for the chart to show. 
	 */
	private DateTimeRange dtr;
	
	/*
	 * The interval for the range we would like. 
	 */
	private int interval;
	
	
	/*
	 * The kind for the range we would like.  
	 */
	private KindHintType kind;
	
	/*
	 * As an alternative, we can point to a resource monitor to resolve the resource. 
	 */
	private ResourceMonitor resourceMonitor;
	
	/*
	 * A bunch of markers. 
	 */
	private List<Marker> markers;
	
	
	
	public List<Marker> getMarkers() {
		return markers;
	}

	public void setMarkers(List<Marker> markers) {
		this.markers = markers;
	}

	/**
	 * @return the dtr
	 */
	public DateTimeRange getPeriod() {
		return dtr;
	}

	/**
	 * @param dtr the dtr to set
	 */
	public void setPeriod(DateTimeRange dtr) {
		this.dtr = dtr;
	}

	/**
	 * @return the interval
	 */
	public int getInterval() {
		return interval;
	}

	/**
	 * @param interval the interval to set
	 */
	public void setInterval(int interval) {
		this.interval = interval;
	}

	public void setResourceMonitor(ResourceMonitor resourceMonitor) {
		this.resourceMonitor = resourceMonitor;
	}

	
	public ResourceMonitor getResourceMonitor() {
		return this.resourceMonitor;
	}

	/**
	 * @return the kind
	 */
	public KindHintType getKind() {
		return kind;
	}

	/**
	 * @param kind the kind to set
	 */
	public void setKind(KindHintType kind) {
		this.kind = kind;
	}

}
