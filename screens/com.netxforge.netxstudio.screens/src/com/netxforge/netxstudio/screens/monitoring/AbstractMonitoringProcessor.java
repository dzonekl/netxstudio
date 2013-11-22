/*******************************************************************************
 * Copyright (c) 13 aug. 2013 NetXForge.
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
package com.netxforge.netxstudio.screens.monitoring;

import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.databinding.viewers.IViewerObservableValue;
import org.eclipse.swt.widgets.Display;

import com.netxforge.netxstudio.common.context.IComputationContext;
import com.netxforge.netxstudio.common.context.ObjectContext;
import com.netxforge.netxstudio.common.model.IMonitoringSummary;
import com.netxforge.netxstudio.common.model.MonitoringStateEvent;
import com.netxforge.netxstudio.common.model.MonitoringStateModel;
import com.netxforge.netxstudio.common.model.MonitoringStateModel.MonitoringStateCallBack;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.generics.GenericsFactory;
import com.netxforge.netxstudio.screens.editing.util.IValidationListener;
import com.netxforge.netxstudio.screens.editing.util.ValidationEvent;
import com.netxforge.netxstudio.screens.internal.ScreensActivator;
import com.netxforge.netxstudio.screens.preferences.ScreenConstants;
import com.netxforge.netxstudio.services.RFSService;
import com.netxforge.netxstudio.services.Service;

/**
 * An abstract implementation of a monitoring processor. Clients should
 * implement and add to one or more widget selection observable who implement
 * {@link IViewerObservableValue} the concrete implementation of
 * {@link IValidationListener#handleValidationStateChange(ValidationEvent)}
 * should set the period and service before updating the monitoring data. The
 * client is responsible to call {@link #updateResourceMon(EObject)} and
 * {@link AbstractMonitoringProcessor#cleanResourceMon(EObject)}.
 * 
 */
public abstract class AbstractMonitoringProcessor implements
		IValueChangeListener {

	private MonitoringStateModel monitoringStateModel;

	public AbstractMonitoringProcessor(MonitoringStateModel monitoringStateModel) {
		this.monitoringStateModel = monitoringStateModel;
	}

	/*
	 * The current observed monitoring period. A period not clearly at
	 * monitoring boundaries of Month, Week, Day might contain Monitoring
	 * information (Like Markers) before and/or after the period.
	 */
	protected DateTimeRange currentPeriod = GenericsFactory.eINSTANCE
			.createDateTimeRange();

	/*
	 * The current monitored service.
	 */
	protected Service currentService = null;

	public DateTimeRange getCurrentPeriod() {
		return currentPeriod;
	}

	public Service getCurrentService() {
		return currentService;
	}

	final class WritableCallBack implements MonitoringStateCallBack {

		private EObject target;

		public WritableCallBack(EObject target) {
			this.target = target;
		}

		public void callBackEvent(MonitoringStateEvent event) {
			Object result = event.getResult();
			if (result instanceof IMonitoringSummary) {

				// We can't process the result, so fire a change for
				// this
				// object, which should
				// force the viewer to query the alreayd installed and
				// computed adapter.

				Display.getDefault().asyncExec(new Runnable() {
					public void run() {
						updateValues(target);
					}
				});

			}
		}
	};

	protected void cleanResourceMon(EObject monitoredObject) {
		if (monitoredObject != null) {

			// Remove the adapter for the previous resource.
			if (MonitoringStateModel.isAdapted(monitoredObject)) {

				IMonitoringSummary adapted = MonitoringStateModel
						.getAdapted(monitoredObject);
				monitoredObject.eAdapters().remove(adapted);
			}
		}
	}

	protected void updateResourceMon(EObject monitoredObject) {

		// The context not being set, has only implications on the
		// the computation of the summary...
		if (monitoredObject != null && isActive()) {
			// Do the summary, we might still be loading objects...
			monitoringStateModel
					.summary(new WritableCallBack(monitoredObject),
							monitoredObject, new IComputationContext[] {
									new ObjectContext<RFSService>(
											(RFSService) getCurrentService()),
									new ObjectContext<DateTimeRange>(
											getCurrentPeriod()) });
		}
	}

	protected abstract void updateValues(EObject target);

	/**
	 * When the preference {@link ScreenConstants#PREFERENCE_DYN_MONITORING} is
	 * set, we will be active.
	 * 
	 * @return
	 */
	private boolean isActive() {
		return ScreensActivator.getInstance().getPreferenceStore()
				.getBoolean(ScreenConstants.PREFERENCE_DYN_MONITORING);
	}

}