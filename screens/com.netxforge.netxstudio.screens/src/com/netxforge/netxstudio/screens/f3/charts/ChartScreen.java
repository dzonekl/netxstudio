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

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Notifier;
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
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.part.ShowInContext;

import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.IChartModel;
import com.netxforge.netxstudio.common.model.IChartResource;
import com.netxforge.netxstudio.common.model.IMonitoringSummary;
import com.netxforge.netxstudio.common.model.MonitoringStateEvent;
import com.netxforge.netxstudio.common.model.MonitoringStateModel;
import com.netxforge.netxstudio.common.model.MonitoringStateModel.JobCallBack;
import com.netxforge.netxstudio.common.model.MonitoringStateModel.MonitoringStateCallBack;
import com.netxforge.netxstudio.common.model.NetxresourceSummary;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.operators.ResourceMonitor;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.editing.IDataScreenInjection;
import com.netxforge.netxstudio.screens.editing.IScreen;
import com.netxforge.netxstudio.screens.editing.ScreenRefresher;
import com.netxforge.netxstudio.screens.showins.ChartInput;
import com.netxforge.netxstudio.screens.showins.ChartMergeInput;

/**
 * 
 * @author Christophe Bouhier
 */
public class ChartScreen extends AbstractScreen implements
		IDataScreenInjection, MonitoringStateCallBack {

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
	private Object[] injectedObjects;

	@Inject
	private MonitoringStateModel monitoringState;

	private FormToolkit toolkit;

	/**
	 * Monitoring callback job
	 */
	private JobCallBack jobCallBack;

	private ModeScreenRefresher refreshSummaryJob;

	/**
	 * In this mode new objects are merged in the chart. Existing settings (i.e.
	 * visibility) are maintained.
	 */
	public static int MODE_MERGE_CHART = 1 << 1;

	/**
	 * In this mode new objects are processed in a new {@link IChartModel}. All
	 * specific settings will disappear as the {@link IChartModel} is cleared.
	 */
	public static int MODE_REINIT_MODEL = 1 << 2;

	/**
	 * Refreshes the Chart UI.
	 * 
	 * @author Christophe Bouhier
	 */

	private void refreshSummaryUI(int mode,
			Collection<IMonitoringSummary> summaries) {

		System.out.println("updating for mode: " + mode);

		if ((mode & MODE_REINIT_MODEL) > 0) {
			chartModel.clear();
			for (IMonitoringSummary summary : summaries) {
				// Refactor
				if (summary instanceof NetxresourceSummary) {
					chartModel.addChartResource((NetxresourceSummary) summary);
				}
			}
		} else if ((mode & MODE_MERGE_CHART) > 0) {
			List<NetxresourceSummary> toAdd = Lists.newArrayList();
			for (IMonitoringSummary summary : summaries) {
				if (summary instanceof NetxresourceSummary) {
					NetxresourceSummary netxSummary = (NetxresourceSummary) summary;
					boolean found = false;
					for (IChartResource r : chartModel.getChartResources()) {
						if (r.getNetXResource() == summary.getTarget()) {
							// not found break and continue to the next summary.
							found = true;
							break;
						}
					}
					if (!found) {
						toAdd.add(netxSummary);
					}

				}
			}
			// now add them.
			System.out.println("adding " + toAdd.size() + " chart(s)");
			for (NetxresourceSummary s : toAdd) {
				chartModel.addChartResource(s);
			}

		}

		smartResourceChart.initChartBinding(chartModel);
	}

	public ChartScreen(Composite parent, int style) {
		super(parent, style);
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				if (jobCallBack != null) {
					monitoringState.deActivate(jobCallBack);
				}
				ChartScreen.this.getShell().removeShellListener(shellAdapter);
				disposeData();
			}
		});

	}

	public void buildUI(FormToolkit toolkit) {
		this.toolkit = toolkit;
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);

		setLayout(new GridLayout(2, false));
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gridData.heightHint = 400;
		gridData.widthHint = 600;
		smartResourceChart = new ChartNetXResource(this, SWT.NONE, gridData);

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
	public void injectData(Object... objects) {
		internalInjectData(MODE_REINIT_MODEL, objects);
	}

	private void internalInjectData(int mode, Object... objects) {
		if (validSelection(objects)) {

			if ((mode & MODE_REINIT_MODEL) > 0) {
				setInjectedObjects(objects);
			} else if ((mode & MODE_MERGE_CHART) > 0) {
				// merge the objects, but instruct the refresher to only process
				// delta/added IMonitoringSummaries.
				mergeInjectedObjects(objects);
			}
			refreshSummary(mode);
			if (jobCallBack == null) {
				jobCallBack = monitoringState.new JobCallBack();
				jobCallBack.setCallBack(this);
			}

			monitoringState.deActivate(jobCallBack);

			// This will inform us of many monitoring events, but not necessarly
			// for our target injected object.
			// so make sure the call back analyses which objects this concerns.
			monitoringState.activate(jobCallBack);
		} else {
			// System.out.println("invalid selection: " + objects);
		}
	}

	/**
	 * The selection should be objects of the type {@link EObject} and not be
	 * already the currently injected objects in the {@link IScreen}.
	 * 
	 * @param selection
	 * @return
	 */
	private boolean validSelection(Object[] selection) {

		// Check if we are the same as previously injected.
		// Same length, same objects.
		if (injectedObjects != null
				&& (selection.length == injectedObjects.length)) {
			boolean allEqual = false;
			final Iterator<Object> currentObjects = Lists.newArrayList(
					injectedObjects).iterator();
			for (Object o : selection) {
				allEqual |= Iterators.contains(currentObjects, o);
			}
			if (allEqual) {
				return false;
			}
		}

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
		return null;
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

		ISelection selection = context.getSelection();
		if (selection != null && !selection.isEmpty()
				&& selection instanceof StructuredSelection) {
			IStructuredSelection ss = (StructuredSelection) selection;
			final Object[] objects = Lists.newArrayList(ss.iterator())
					.toArray();
			if (context.getInput() instanceof ChartMergeInput) {
				internalInjectData(MODE_MERGE_CHART, objects);
				return true;
			} else if (context.getInput() instanceof ChartInput) {
				internalInjectData(MODE_REINIT_MODEL, objects);
				return true;
			} else if (context.getInput() instanceof ChartMergeInput) {

			}
		}

		return false;
	}

	/**
	 * process the injected object, obtains the {@link IMonitoringSummary} for
	 * eligible objects and files a UI refresh job to reload the chart model or
	 * add charts to the existing model.
	 */
	private void refreshSummary(int mode) {

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
			} else if (injectedObject instanceof Component) {
				Component c = (Component) injectedObject;
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

		if (summariesToRefresh.isEmpty()) {
			// Do not refresh the UI for not understood injections. (Should have
			// happened in validation!).
			return;
		}

		// Do the refresh.
		if (refreshSummaryJob == null) {
			refreshSummaryJob = new ModeScreenRefresher();
		}
		refreshSummaryJob.setSummary(summariesToRefresh);
		refreshSummaryJob.setMode(mode);
		refreshSummaryJob.schedule(100);

	}

	class ModeScreenRefresher extends ScreenRefresher {

		private int mode;

		@Override
		public void refreshSummaryUI(Collection<IMonitoringSummary> summaries) {

			// This clears the chart model.
			ChartScreen.this.refreshSummaryUI(mode, summaries);
		}

		public int getMode() {
			return mode;
		}

		public void setMode(int mode) {
			this.mode = mode;
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		// remove the markers.
		smartResourceChart.hideHover();
	}

	public IChartModel getChartModel() {
		return chartModel;
	}

	/**
	 * Reconstruct the chart for the given {@link IChartModel}. The
	 */
	public void reinit() {
		this.getChart().initChartBinding(this.getChartModel());
	}

	public void toggleSum(boolean checked) {
		chartModel.setShouldSum(checked);
		smartResourceChart.updateSumStatus();
	}

	public void callBackEvent(MonitoringStateEvent event) {

		// We are called back for monitoring events.
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

			// The mode is depending on how it was initially requested.
			// It would be better to embed the model in the adapter, so
			// it always stays with the object to be processed.
			// for now, use a default, which is reinit the chart model.
			refreshSummary(MODE_REINIT_MODEL);
		}
		monitoringState.deActivate(jobCallBack);
	}

	// Screen model.

	public synchronized void setInjectedObjects(Object[] objects) {
		injectedObjects = objects;
	}

	public synchronized Object[] getInjectedObjects() {
		if (editingService.isDataAlive(injectedObjects)) {
			return injectedObjects;
		} else {
			// An empty array.
			return new Object[] {};
		}

	}

	public synchronized void clearInjectedObjects() {
		injectedObjects = null;
	}

	public void mergeInjectedObjects(Object[] objects) {
		List<Object> mergedObjects = Lists.newArrayList(this
				.getInjectedObjects());
		mergedObjects.addAll(Arrays.asList(objects));
		setInjectedObjects(mergedObjects.toArray());
		System.out.println("objects size: " + getInjectedObjects().length);
	}

	@Override
	public String toString() {
		if (chartModel != null) {
			return chartModel.getChartText();
		} else {
			return super.toString();
		}
	}
}
