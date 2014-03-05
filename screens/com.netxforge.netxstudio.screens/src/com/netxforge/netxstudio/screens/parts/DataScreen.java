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
package com.netxforge.netxstudio.screens.parts;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.netxforge.base.cdo.MonitoringStateEvent;
import com.netxforge.netxstudio.common.model.IMonitoringSummary;
import com.netxforge.netxstudio.common.model.MonitoringStateModel;
import com.netxforge.netxstudio.common.model.MonitoringStateModel.JobCallBack;
import com.netxforge.netxstudio.common.model.MonitoringStateModel.MonitoringStateCallBack;
import com.netxforge.netxstudio.common.model.NetxresourceSummary;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.operators.Marker;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.editing.ScreenRefresher;
import com.netxforge.netxstudio.screens.f3.SmartValueComponent;
import com.netxforge.netxstudio.services.RFSService;
import com.netxforge.screens.editing.base.IDataScreenInjection;

/**
 * Data Screen
 * 
 * @author Christophe Bouhier
 * 
 */
public class DataScreen extends AbstractScreen implements IDataScreenInjection,
		MonitoringStateCallBack {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());

	/** The Form for this screen */
	private Form frmDataScreen;

	@Inject
	private SmartValueComponent cmpValues;

	@Inject
	private MonitoringStateModel monitoringState;

	private ScreenRefresher refreshSummaryJob;

	private JobCallBack jobCallBack;

	/**
	 * The injected objects, which will be processed and used for UI refresh.
	 */
	private Object[] objects;

	public DataScreen(Composite parent, int style) {
		super(parent, style);
		this.addDisposeListener(new DisposeListener() {

			public void widgetDisposed(DisposeEvent e) {
				cmpValues.clearData();
			}
		});
	}

	public void buildUI() {
		setLayout(new FillLayout(SWT.HORIZONTAL));

		frmDataScreen = toolkit.createForm(this);
		frmDataScreen.setSeparatorVisible(true);
		frmDataScreen.setText("Data");
		toolkit.paintBordersFor(frmDataScreen);

		frmDataScreen.getBody().setLayout(new FillLayout());

		final Composite content = toolkit.createComposite(
				frmDataScreen.getBody(), SWT.NONE);
		toolkit.paintBordersFor(content);
		content.setLayout(new FillLayout());

		cmpValues.configure(screenService);
		cmpValues.buildUI(content, null);

	}

	public Form getScreenForm() {
		return frmDataScreen;
	}

	public EMFDataBindingContext initDataBindings_() {
		return null;
	}

	public Viewer getViewer() {
		return null;
	}

	public void addData() {
	}

	@Override
	public void injectData(Object... objects) {

		if (validSelection(objects)) {
			setInjectedObjects(objects);
			refreshSummary();

			if (jobCallBack == null) {
				jobCallBack = monitoringState.new JobCallBack();
				jobCallBack.setCallBack(this);
			}

			monitoringState.deActivate(jobCallBack);
			monitoringState.activate(jobCallBack);
		}

	}

	public void reset() {
		// dashboardComponent.reset();
	}
	
	protected void updateValues(EObject target) {
		IMonitoringSummary adapted = MonitoringStateModel.getAdapted(target);
		if (adapted instanceof NetxresourceSummary) {
			NetxresourceSummary netxSummary = (NetxresourceSummary) adapted;
			RFSService rfsService = netxSummary.getRFSService();
			if (rfsService != null) {
				List<Marker> markers = netxSummary.markers();
				cmpValues.applyMarkers(markers);
			} else {
				// System.out.println(" Context not set for summary:"
				// + netxSummary);
			}
		}
	}

	public void callBackEvent(MonitoringStateEvent event) {
		Object result = event.getResult();
		boolean shouldRefresh = false;
		if (result instanceof IMonitoringSummary) {
			Notifier target = ((IMonitoringSummary) result).getTarget();
			final Iterator<Object> currentObjects = Lists.newArrayList(
					getInjectedObjects()).iterator();
			if (Iterators.contains(currentObjects, target)) {
				shouldRefresh = true;
			}
		}
		if (shouldRefresh) {
			refreshSummary();
		}		
		monitoringState.deActivate(jobCallBack);
	}

	private void refreshSummary() {
		List<IMonitoringSummary> summariesToRefresh = Lists.newArrayList();
		for (Object injectedObject : getInjectedObjects()) {
			if (injectedObject instanceof NetXResource) {
				NetXResource target = (NetXResource) injectedObject;
				if (MonitoringStateModel.isAdapted(target)) {
					NetxresourceSummary summary = (NetxresourceSummary) MonitoringStateModel
							.getAdapted(target);
					summariesToRefresh.add(summary);
				} else {
					System.out.println("target not adapted: " + target);
				}
			}
		}
		
		if(summariesToRefresh.isEmpty()){
		}
		// Do the refresh.
		if (refreshSummaryJob == null) {

			refreshSummaryJob = new ScreenRefresher() {

				@Override
				public void refreshSummaryUI(
						Collection<IMonitoringSummary> summaries) {
					DataScreen.this.refreshSummaryUI(summaries);
				}

			};
		}
		refreshSummaryJob.setSummary(summariesToRefresh);
		refreshSummaryJob.schedule(100);

	}

	/**
	 * The selection should be similar objects.
	 * 
	 * @param selection
	 * @return
	 */
	private boolean validSelection(Object[] selection) {

		for (Object o : selection) {
			if (o instanceof EObject) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

	protected void refreshSummaryUI(Collection<IMonitoringSummary> summaries) {

		// We deal with a single summary in this view.
		if (!summaries.isEmpty()) {
			IMonitoringSummary s = Lists.newArrayList(summaries).get(0);
			if (s instanceof NetxresourceSummary) {
				NetxresourceSummary netXSummary = (NetxresourceSummary) s;
				NetXResource target = netXSummary.getTarget();
				cmpValues.applyDateFilter(netXSummary.getPeriod(), false);
				cmpValues.injectData(target);
			}
		}
	}
	
	public synchronized void setInjectedObjects(Object[] params) {
		this.objects = params;
	}

	public synchronized Object[] getInjectedObjects() {
		return objects;
	}
	
	public synchronized void clearInjectedObjects(){
		objects = null;
	}

}
