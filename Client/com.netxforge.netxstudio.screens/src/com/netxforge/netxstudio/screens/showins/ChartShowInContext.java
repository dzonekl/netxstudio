package com.netxforge.netxstudio.screens.showins;

import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.operators.ResourceMonitor;

public class ChartShowInContext {
	
	/*
	 * The time range for the chart to show. 
	 */
	private DateTimeRange dtr;
	
	/*
	 * The interval for the range we would like to see. 
	 */
	private int interval;

	/*
	 * 
	 */
	private ResourceMonitor resourceMonitor; 
	
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

}
