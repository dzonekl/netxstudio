package com.netxforge.netxstudio.screens.f3.charts;

import java.util.List;

import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.generics.Value;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.operators.ResourceMonitor;

/**
 * Wraps model references:
 * 
 * @author Christophe Bouhier
 * 
 */
public class ChartModel {

	/** The period covering the chart */
	protected DateTimeRange dtr;

	/** The interval */
	protected int interval = -1;

	/** The NetXResource */
	protected NetXResource netXRes = null;

	/** The ResourceMonitor */
	protected ResourceMonitor resMonitor = null;

	/** A bunch of values */
	protected List<Value> values = null;

	public ChartModel(DateTimeRange dtr, int interval,
			NetXResource netXRes, ResourceMonitor resMonitor,
			List<Value> values) {
		super();
		this.dtr = dtr;
		this.interval = interval;
		this.netXRes = netXRes;
		this.resMonitor = resMonitor;
		this.values = values;
	}

	public DateTimeRange getDtr() {
		return dtr;
	}

	public void setDtr(DateTimeRange dtr) {
		this.dtr = dtr;
	}

	public int getInterval() {
		return interval;
	}

	public void setInterval(int interval) {
		this.interval = interval;
	}

	public NetXResource getNetXRes() {
		return netXRes;
	}

	public void setNetXRes(NetXResource netXRes) {
		this.netXRes = netXRes;
	}

	public ResourceMonitor getResMonitor() {
		return resMonitor;
	}

	public void setResMonitor(ResourceMonitor resMonitor) {
		this.resMonitor = resMonitor;
	}

	public List<Value> getValues() {
		return values;
	}

	public void setValues(List<Value> values) {
		this.values = values;
	}

}