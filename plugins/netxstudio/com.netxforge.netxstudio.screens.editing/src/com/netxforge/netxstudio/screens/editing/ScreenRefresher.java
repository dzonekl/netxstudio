/*******************************************************************************
 * Copyright (c) 3 feb. 2014 NetXForge.
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
package com.netxforge.netxstudio.screens.editing;

import java.util.Collection;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.UIJob;

import com.netxforge.netxstudio.common.model.IMonitoringSummary;
import com.netxforge.netxstudio.screens.editing.internal.EditingActivator;
import com.netxforge.screens.editing.base.IScreen;

/**
 * A common {@link UIJob} for refreshing an {@link IScreen screen} with the for
 * a collection of {@link IMonitoringSummary}.
 * 
 * @author Christophe Bouhier
 */
public abstract class ScreenRefresher extends UIJob {

	private Collection<IMonitoringSummary> summaries;

	public void setSummary(Collection<IMonitoringSummary> summaries) {
		this.summaries = summaries;
	}

	/**
	 * Creates a new instance of the class.
	 */
	public ScreenRefresher() {
		super("refresh");
		// setSystem(true);
	}

	@Override
	public IStatus runInUIThread(IProgressMonitor monitor) {

		monitor.setTaskName("Refresh monitoring");

		if (monitor.isCanceled()) {
			return new Status(IStatus.OK, EditingActivator.PLUGIN_ID,
					IStatus.OK, "Cancelled ", null);
		}

		if (summaries.isEmpty()) {
			return new Status(IStatus.WARNING, EditingActivator.PLUGIN_ID,
					IStatus.ERROR, "No summaries to refresh", null);
		}

		refreshSummaryUI(summaries);

		return new Status(IStatus.OK, PlatformUI.PLUGIN_ID, IStatus.OK, "",
				null);
	}

	public abstract void refreshSummaryUI(
			Collection<IMonitoringSummary> summaries);

}
