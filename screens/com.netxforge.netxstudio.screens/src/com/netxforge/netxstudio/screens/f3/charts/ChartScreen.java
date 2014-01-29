/*******************************************************************************
 * Copyright (c) 16 dec. 2012 NetXForge.
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
package com.netxforge.netxstudio.screens.f3.charts;

import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.IJobChangeListener;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.ColumnLayout;
import org.eclipse.ui.forms.widgets.ColumnLayoutData;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.part.ShowInContext;
import org.eclipse.ui.progress.UIJob;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.IChartModel;
import com.netxforge.netxstudio.common.model.IMonitoringSummary;
import com.netxforge.netxstudio.common.model.MonitoringStateModel;
import com.netxforge.netxstudio.common.model.NetxresourceSummary;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.operators.ResourceMonitor;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.editing.IDataScreenInjection;
import com.netxforge.netxstudio.screens.internal.ScreensActivator;
import com.netxforge.netxstudio.screens.showins.ChartInput;

/**
 * 
 * @author Christophe Bouhier
 */
public class ChartScreen extends AbstractScreen implements
		IDataScreenInjection, IJobChangeListener {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());

	private Form frmChartScreen;

	/** Holds model data together for the chart */
	@Inject
	private IChartModel chartModel;

	/**
	 * A specialized chart for {@link NetXResource} and {@link ResourceMonitor}
	 * objects
	 */
	private ChartNetXResource smartResourceChart;

	private ShellAdapter shellAdapter;

	/**
	 * Track the last selection.
	 */
	private Object[] latestSelection;

	@Inject
	private MonitoringStateModel monitoringState;

	private RefreshSummaryJob refreshSummaryJob = new RefreshSummaryJob();

	/**
	 * Refreshes the RFS Service Summary Section.
	 * 
	 * @author Christophe Bouhier
	 */
	class RefreshSummaryJob extends UIJob {

		private Collection<IMonitoringSummary> summaries;

		public void setSummary(Collection<IMonitoringSummary> summaries) {
			this.summaries = summaries;
		}

		/**
		 * Creates a new instance of the class.
		 */
		public RefreshSummaryJob() {
			super("refresh");
			// setSystem(true);
		}

		@Override
		public IStatus runInUIThread(IProgressMonitor monitor) {

			monitor.setTaskName("Refresh monitoring");

			if (monitor.isCanceled()) {
				return new Status(IStatus.OK, ScreensActivator.PLUGIN_ID,
						IStatus.OK, "Cancelled ", null);
			}

			if (summaries.isEmpty()) {
				return new Status(IStatus.WARNING, ScreensActivator.PLUGIN_ID,
						IStatus.ERROR, "No summaries to refresh", null);
			}

			refreshSummaryUI(summaries);

			return new Status(IStatus.OK, PlatformUI.PLUGIN_ID, IStatus.OK, "",
					null);
		}

		private void refreshSummaryUI(Collection<IMonitoringSummary> summaries) {

			chartModel.clear();

			for (IMonitoringSummary summary : summaries) {
				// Refactor
				if (summary instanceof NetxresourceSummary) {
					chartModel.addChartResource((NetxresourceSummary) summary);
				}
			}

			frmChartScreen.setText(chartModel.getChartText());
			smartResourceChart.initChartBinding(chartModel);
		}
	}

	public ChartScreen(Composite parent, int style) {
		super(parent, style);
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				deActivate();
				ChartScreen.this.getShell().removeShellListener(shellAdapter);
				toolkit.dispose();
				disposeData();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
	}

	public void buildUI() {
		setLayout(new FillLayout(SWT.HORIZONTAL));

		frmChartScreen = toolkit.createForm(this);
		frmChartScreen.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmChartScreen);

		frmChartScreen.getBody().setLayout(new FillLayout());

		// Composite for the chart.
		Composite cmChart = toolkit.createComposite(frmChartScreen.getBody(),
				SWT.BORDER);
		ColumnLayoutData columnLayoutData = new ColumnLayoutData();
		columnLayoutData.heightHint = 500;
		cmChart.setLayoutData(columnLayoutData);
		toolkit.paintBordersFor(cmChart);
		
		cmChart.setLayout(new GridLayout(2, false));
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		
		smartResourceChart = new ChartNetXResource(cmChart, SWT.NONE, gridData);
		smartResourceChart.setModelUtils(modelUtils);

		// buildScrollStick(cmChart);
		// buildZoom(cmChart);

		// registerFocus(this);
		shellAdapter = new ShellAdapter() {
			@Override
			public void shellDeactivated(ShellEvent e) {
				focusLost(null);
			}

		};
		getShell().addShellListener(shellAdapter);

	}

	/**
	 * @param cmChart
	 */
	@SuppressWarnings("unused")
	private void buildZoom(Composite cmChart) {

		// ZOOM etc... buttons.

		Button btnZoomIn = toolkit.createButton(cmChart, "Z+", SWT.NONE);
		btnZoomIn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getChart().getAxisSet().zoomIn();
				getChart().redraw();
			}
		});
		GridData gd_btnZoomIn = new GridData(SWT.CENTER, SWT.CENTER, false,
				false, 1, 1);
		gd_btnZoomIn.widthHint = 24;
		gd_btnZoomIn.heightHint = 18;
		btnZoomIn.setLayoutData(gd_btnZoomIn);

		Button btnZoomOut = toolkit.createButton(cmChart, "Z-", SWT.NONE);
		btnZoomOut.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getChart().getAxisSet().zoomOut();
				getChart().redraw();
			}
		});

		GridData gd_btnZoomOut = new GridData(SWT.CENTER, SWT.CENTER, false,
				false, 1, 1);
		gd_btnZoomOut.widthHint = 24;
		gd_btnZoomOut.heightHint = 18;
		btnZoomOut.setLayoutData(gd_btnZoomOut);
	}

	/**
	 * A Scroll stick which scrolls the Y-Axis up or down, and the X-Axis left
	 * and right.
	 * 
	 * @param parent
	 * @param gd
	 */
	@SuppressWarnings("unused")
	private void buildScrollStick(Composite parent) {

		GridData gridData = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1,
				1);

		Composite compositeScrollStick = toolkit.createComposite(parent,
				SWT.NONE);
		compositeScrollStick.setLayoutData(gridData);
		toolkit.paintBordersFor(compositeScrollStick);
		GridLayout gl_compositeScrollStick = new GridLayout(3, false);
		gl_compositeScrollStick.marginTop = 3;
		gl_compositeScrollStick.verticalSpacing = 0;
		gl_compositeScrollStick.marginWidth = 0;
		gl_compositeScrollStick.marginHeight = 0;
		gl_compositeScrollStick.horizontalSpacing = 0;
		compositeScrollStick.setLayout(gl_compositeScrollStick);

		new Label(compositeScrollStick, SWT.NONE);
		Button btnUpScroll = toolkit.createButton(compositeScrollStick, "",
				SWT.ARROW | SWT.UP);
		btnUpScroll.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getChart().getAxisSet().getYAxis(0).scrollUp();
				getChart().redraw();
			}
		});
		new Label(compositeScrollStick, SWT.NONE);

		Button btnLeftScroll = toolkit.createButton(compositeScrollStick, "",
				SWT.ARROW | SWT.LEFT);
		btnLeftScroll.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getChart().getAxisSet().getXAxis(0).scrollDown();
				getChart().redraw();
			}
		});
		new Label(compositeScrollStick, SWT.NONE);
		Button btnRightScroll = toolkit.createButton(compositeScrollStick, "",
				SWT.ARROW | SWT.RIGHT);
		btnRightScroll.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getChart().getAxisSet().getXAxis(0).scrollUp();
				getChart().redraw();
			}
		});

		new Label(compositeScrollStick, SWT.NONE);
		Button btnDownScroll = toolkit.createButton(compositeScrollStick, "",
				SWT.ARROW | SWT.DOWN);
		btnDownScroll.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getChart().getAxisSet().getYAxis(0).scrollDown();
				getChart().redraw();
			}
		});
		new Label(compositeScrollStick, SWT.NONE);
	}

	public ChartNetXResource getChart() {
		return smartResourceChart;
	}

	public Viewer getViewer() {
		return null;
	}

	@Override
	public void injectData(Object... selection) {
		processSelection(selection);
	}

	private void processSelection(Object... selection) {

		if (validSelection(selection)) {
			setLatestSelection(selection);
			updateLatestSelection();

			deActivate();
			activate();

		} else {
			// TODO, for multiple selections, we need a
			// IMonitoringSummaryComposite object.

		}
	}

	private synchronized void setLatestSelection(Object... selection) {
		latestSelection = selection;
	}

	private synchronized Object[] getLatestSelection() {
		return latestSelection;
	}

	/**
	 * remove the listener to the monitoring state jobs.
	 */
	public void deActivate() {
		monitoringState.removeJobNotifier(this);
	}

	/**
	 * Listen to the monitoring state jobs.
	 */
	public void activate() {
		monitoringState.addJobNotifier(this);
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

	public void addData() {
		// N/A this is a view screen.
	}

	public boolean isValid() {
		return true;
	}

	public EMFDataBindingContext initDataBindings_() {
		EMFDataBindingContext context = new EMFDataBindingContext();
		// CB FIXME refactor markers.
		// if (chartModel.hasMarkers()) {
		// initMarkersBindingCollection();
		// } else {
		// markersTableViewer.getTable().setSelection(-1);
		// markersTableViewer.getTable().clearAll();
		// }

		return context;
	}

	public Form getScreenForm() {
		return this.frmChartScreen;
	}

	public void disposeData() {
	}

	public String getScreenName() {
		return "Resource graph";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.screens.AbstractScreenImpl#handleShowIn(org.
	 * eclipse.ui.part.ShowInContext)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean handleShowIn(ShowInContext context) {
		if (context.getInput() instanceof ChartInput) {
			ISelection selection = context.getSelection();
			if (selection != null && !selection.isEmpty()
					&& selection instanceof StructuredSelection) {
				IStructuredSelection ss = (StructuredSelection) selection;
				injectData(Lists.newArrayList(ss.iterator()).toArray());
			}
			return true;
		}

		return false;
	}

	/**
	 * {@link IJobChangeListener}
	 */
	public void aboutToRun(IJobChangeEvent event) {
	}

	public void awake(IJobChangeEvent event) {
	}

	public void done(IJobChangeEvent event) {
		updateLatestSelection();
	}

	public void running(IJobChangeEvent event) {
	}

	public void scheduled(IJobChangeEvent event) {
	}

	public void sleeping(IJobChangeEvent event) {
	}

	private void updateLatestSelection() {
		List<IMonitoringSummary> summariesToRefresh = Lists.newArrayList();
		for (Object selection : getLatestSelection()) {
			if (selection instanceof NetXResource) {
				NetXResource target = (NetXResource) selection;
				if (MonitoringStateModel.isAdapted(target)) {

					NetxresourceSummary summary = (NetxresourceSummary) MonitoringStateModel
							.getAdapted(target);
					summariesToRefresh.add(summary);
				} else {
					System.out.println("target not adapted: " + target);
				}
			} else if (selection instanceof Component) {
				Component c = (Component) selection;
				for (NetXResource target : c.getResourceRefs()) {
					if (MonitoringStateModel.isAdapted(target)) {

						NetxresourceSummary summary = (NetxresourceSummary) MonitoringStateModel
								.getAdapted(target);
						summariesToRefresh.add(summary);
					} else {
						System.out.println("target not adapted: " + target);
					}

				}
			}
		}
		refreshSummaryJob.setSummary(summariesToRefresh);
		refreshSummaryJob.schedule(100);

	}

	@Override
	public void focusLost(FocusEvent e) {
		// remove the markers.
		smartResourceChart.hideHover();
	}

	public IChartModel getChartModel() {
		return chartModel;
	}

	public void reinit() {
		frmChartScreen.setText(chartModel.getChartText());
		this.getChart().initChartBinding(this.getChartModel());
	}
}
