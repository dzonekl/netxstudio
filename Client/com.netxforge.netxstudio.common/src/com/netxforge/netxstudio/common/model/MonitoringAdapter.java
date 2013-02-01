/*******************************************************************************
 * Copyright (c) 31 jan. 2013 NetXForge.
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

import org.eclipse.emf.cdo.CDOAdapter;
import org.eclipse.emf.cdo.CDODeltaNotification;
import org.eclipse.emf.cdo.util.CDOLazyContentAdapter;
import org.eclipse.emf.common.notify.Notification;

import com.google.inject.Inject;
import com.netxforge.netxstudio.generics.DateTimeRange;

/**
 * 
 * @author Christophe Bouhier
 * 
 */
public class MonitoringAdapter extends CDOLazyContentAdapter implements
		CDOAdapter, IMonitoringSummary {

	@Inject
	private ModelUtils modelUtils;

	boolean[] ragStatus = new boolean[] { false, false, false };

	/** The period for this summary */
	private DateTimeRange period;

	/** The period formated as String for this summary */
	private String periodFormattedString = "";

	public DateTimeRange getPeriod() {
		return period;
	}

	public void setPeriod(DateTimeRange period) {
		this.period = period;
		periodFormattedString = modelUtils.periodToStringMore(period);
	}

	public String getPeriodFormattedString() {
		return periodFormattedString;
	}
	

	@Override
	public void notifyChanged(Notification msg) {
		// Update ourselves with the notification.
		// super.notifyChanged(msg);
		System.out.println("We are adapted!" + this.toString() + " by: " + msg.getNotifier());

		if (msg instanceof CDODeltaNotification) {
			CDODeltaNotification delta = (CDODeltaNotification) msg;
			System.out.println("delta: " + delta.getRevisionDelta());
		}
	}

	@Override
	public boolean isAdapterForType(Object type) {
		// TODO, Support other types!
		return type == IMonitoringSummary.class;
	}

}
