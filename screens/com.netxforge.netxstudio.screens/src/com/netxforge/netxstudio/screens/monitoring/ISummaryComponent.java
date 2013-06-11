package com.netxforge.netxstudio.screens.monitoring;

import org.eclipse.swt.widgets.Composite;

import com.netxforge.netxstudio.common.model.IMonitoringSummary;

public interface ISummaryComponent {

	public abstract void buildUI(Composite parent, Object layoutData);

	/**
	 * Dispose the children of the summary content. 
	 */
	public abstract void dispose();

	/**
	 * Fill the UI for the summary
	 * </p>
	 * @param nonCastedSummary
	 */
	public abstract void fillSummary(IMonitoringSummary nonCastedSummary);

}