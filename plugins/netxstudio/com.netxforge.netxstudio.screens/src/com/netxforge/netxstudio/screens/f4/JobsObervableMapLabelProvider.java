/*******************************************************************************
 * Copyright (c) 2 apr. 2014 NetXForge.
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
package com.netxforge.netxstudio.screens.f4;

import java.util.Date;

import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.emf.cdo.common.id.CDOIDUtil;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.jface.viewers.ViewerCell;

import com.netxforge.base.NonModelUtils;
import com.netxforge.netxstudio.common.model.StudioUtils;
import com.netxforge.netxstudio.scheduling.ComponentWorkFlowRun;
import com.netxforge.netxstudio.scheduling.Job;
import com.netxforge.netxstudio.scheduling.JobRunState;
import com.netxforge.netxstudio.scheduling.JobState;
import com.netxforge.netxstudio.scheduling.MetricSourceJob;
import com.netxforge.netxstudio.scheduling.NodeReporterJob;
import com.netxforge.netxstudio.scheduling.OperatorReporterJob;
import com.netxforge.netxstudio.scheduling.RFSServiceMonitoringJob;
import com.netxforge.netxstudio.scheduling.RFSServiceReporterJob;
import com.netxforge.netxstudio.scheduling.RetentionJob;
import com.netxforge.netxstudio.screens.f4.Jobs.SchedulerStartStopAction;
import com.netxforge.netxstudio.screens.f4.Jobs.TriggerAddon;
import com.netxforge.screens.editing.base.util.ObservableMapStyledCellLabelProvider;

class JobsObervableMapLabelProvider extends
		ObservableMapStyledCellLabelProvider implements
		org.eclipse.jface.util.IPropertyChangeListener {

	/**
	 * Keep a reference to our {@link Jobs} screen.
	 */
	private final Jobs jobsScreen;

	public JobsObervableMapLabelProvider(Jobs jobs,
			IObservableMap[] attributeMaps) {
		super(attributeMaps);
		jobsScreen = jobs;
	}

	public String getColumnText(Object element, int columnIndex) {
		if (element instanceof Job) {
			Job j = (Job) element;
			switch (columnIndex) {
			case 0: {
				if (j instanceof MetricSourceJob) {
					return "Metric Import";
					// + ((MetricSourceJob) j).getMetricSource()
					// .getName();
				}
				if (j instanceof RFSServiceMonitoringJob) {
					return "Monitoring";
					// + ((RFSServiceJob) j).getRFSService()
					// .getServiceName();
				}
				if (j instanceof RetentionJob) {
					return "Data Retention";
					// + ((RFSServiceRetentionJob) j).getRFSService()
					// .getServiceName();
				}
				if (j instanceof RFSServiceReporterJob) {
					return "Service Reporting";
					// + ((ReporterJob) j).getRFSService()
					// .getServiceName();
				}
				if (j instanceof OperatorReporterJob) {
					return "Operator Reporting";
					// + ((ReporterJob) j).getRFSService()
					// .getServiceName();
				}
				if (j instanceof NodeReporterJob) {
					return "Node Reporting";
					// + ((ReporterJob) j).getRFSService()
					// .getServiceName();
				}

			}
			case 1: {
				return j.getName();
			}
			case 2: {
				JobState state = j.getJobState();
				if (state == JobState.ACTIVE) {
					return "Active";
				} else {
					return "Not Active";
				}
			}
			// Scheduled start time Column, not the starttime (creation time
			// of the job).
			case 3:
				TriggerAddon addon = (TriggerAddon) EcoreUtil.getAdapter(
						j.eAdapters(), TriggerAddon.class);
				if (addon != null) {
					
					// When running, the trigger time, will be the next time it will fire as if it ws not running. 
					// As we prevent the job to execute twice, we should give feedback about this case
					// with decoration of the text / styled...
					return addon.getTriggerTime();
				}
				return "";
				// End Column
			case 4:
				if (j.getEndTime() != null) {
					Date d = NonModelUtils.fromXMLDate(j.getEndTime());
					return NonModelUtils.date(d) + " @ "
							+ NonModelUtils.time(d);
				}
				break;
			case 5:
				return new Integer(j.getRepeat()).toString();
			case 6:
				if (j.getInterval() > 0) {
					String fromSeconds = NonModelUtils.fromSeconds(j
							.getInterval());
					return fromSeconds;
				}
				break;
			case 7:
				if (jobsScreen.getRunningWFR() != null) {
					ComponentWorkFlowRun cwfr = jobsScreen.getRunningWFR();

					Job jobForWorkflowRun = StudioUtils.jobForWorkflowRun(cwfr);
					if (CDOIDUtil.equals(jobForWorkflowRun.cdoID(), j.cdoID())) {

						if (cwfr.getState() == JobRunState.RUNNING) {
							// Start a job to update the cell.
							StringBuilder sb = new StringBuilder();
							sb.append(cwfr.getState().getLiteral());
							sb.append("- " + cwfr.getProgressMessage());
							return sb.toString();
						} else {
							return cwfr.getState().getLiteral();
						}

					} else {
						
					}
				}else{
					// waiting for update state, when the scheduler is
					// running and the Job is active.
					if (jobsScreen.isRunning
							&& j.getJobState() == JobState.ACTIVE) {
						return "waiting for update...";
					}

					return ""; // clear the label
				}

				break;
			}
		}
		return "";
	}

	public void propertyChange(PropertyChangeEvent event) {
		if (event.getSource() instanceof SchedulerStartStopAction) {
			Object newValue = event.getNewValue();
			// Guard for the object type?
			this.fireLabelProviderChanged(new LabelProviderChangedEvent(this,
					newValue));
		}
	}

	@Override
	public void update(ViewerCell cell) {
		int columnIndex = cell.getColumnIndex();
		Object element = cell.getElement();
		cell.setText(getColumnText(element, columnIndex));

		super.update(cell);
	}
}