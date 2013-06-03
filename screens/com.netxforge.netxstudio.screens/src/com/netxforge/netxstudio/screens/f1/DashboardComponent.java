/*******************************************************************************
 * Copyright (c) 10 dec. 2012 NetXForge.
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
package com.netxforge.netxstudio.screens.f1;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.widgets.FormText;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.progress.UIJob;
import org.eclipse.wb.swt.SWTResourceManager;

import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.IMonitoringSummary;
import com.netxforge.netxstudio.common.model.IMonitoringSummary.RAG;
import com.netxforge.netxstudio.common.model.MonitoringStateEvent;
import com.netxforge.netxstudio.common.model.MonitoringStateModel;
import com.netxforge.netxstudio.common.model.MonitoringStateModel.MonitoringStateStateCallBack;
import com.netxforge.netxstudio.common.model.NetxresourceSummary;
import com.netxforge.netxstudio.common.model.RFSServiceSummary;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.screens.editing.selector.IScreen;
import com.netxforge.netxstudio.screens.editing.selector.ScreenUtil;
import com.netxforge.netxstudio.screens.internal.ScreensActivator;
import com.netxforge.netxstudio.services.RFSService;

/**
 * An injectable component showing the monitoring Dashboard.
 * 
 * @author Christophe Bouhier
 * 
 */
public class DashboardComponent {

	private final FormToolkit formToolkit = new FormToolkit(
			Display.getCurrent());

	// /**
	// * Job which creates the summary.
	// */
	// private MonitoringStateJob job;

	/**
	 * Job which refreshs the UI for the created summary.
	 */
	private final RefreshSummaryJob refreshSummaryJob = new RefreshSummaryJob();

	private RFSServiceSummary summary;

	private FormText formTextLastMonitor;

	private FormText formTextNumberOfNodes;

	private FormText formTextNumberOfResources;

	private FormText formTextRed;

	private FormText formTextAmber;

	private FormText formTextGreen;

	/*
	 * Defaults to show a border.
	 */
	private boolean showBorder = false;

	private Composite content;

	/**
	 * The parent IScreen needed to layout as this component will load in
	 * background
	 **/
	private IScreen parentScreen;

	private MonitoringStateModel monitoringState;

	@Inject
	public DashboardComponent(MonitoringStateModel ms) {
		super();
		this.monitoringState = ms;
	}

	public void setParentScreen(IScreen parentScreen) {
		this.parentScreen = parentScreen;
	}

	public void setShowBorder(boolean showBorder) {
		this.showBorder = showBorder;
	}

	public void buildUI(Composite parent, Object layoutData) {

		parent.addDisposeListener(new DisposeListener() {

			public void widgetDisposed(DisposeEvent e) {
				// Cancel running service summary job.
				// if (job != null && job.isRunning()) {
				// job.cancel();
				// }
				refreshSummaryJob.cancel();
			}
		});

		content = formToolkit.createComposite(parent, showBorder ? SWT.BORDER
				: SWT.NONE);

		if (layoutData != null) {
			content.setLayoutData(layoutData);
		}

		formToolkit.paintBordersFor(content);
		content.setLayout(new GridLayout(4, false));

		final Label periodLabel = formToolkit.createLabel(content, "Period:",
				SWT.NONE);
		periodLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));

		formTextLastMonitor = formToolkit.createFormText(content, false);
		formTextLastMonitor.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				true, false, 3, 1));

		final Label lblMonitoredNodes = formToolkit.createLabel(content,
				"# Monitored NE's:", SWT.NONE);
		lblMonitoredNodes.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
				false, false, 1, 1));

		formTextNumberOfNodes = formToolkit.createFormText(content, false);
		formTextNumberOfNodes.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER,
				false, false, 3, 1));
		formToolkit.paintBordersFor(formTextNumberOfNodes);
		formTextNumberOfNodes.setText("", false, false);

		final Label lblMonitoredRess = new Label(content, SWT.NONE);
		lblMonitoredRess.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
				false, false, 1, 1));
		formToolkit.adapt(lblMonitoredRess, true, true);
		lblMonitoredRess.setText("# Monitored RES's:");

		formTextNumberOfResources = formToolkit.createFormText(content, false);
		formTextNumberOfResources.setLayoutData(new GridData(SWT.LEFT,
				SWT.CENTER, false, false, 3, 1));
		formToolkit.paintBordersFor(formTextNumberOfResources);
		formTextNumberOfResources.setText("", false, false);

		final Composite separator = formToolkit
				.createCompositeSeparator(content);
		GridData gd_separator = new GridData(SWT.FILL, SWT.CENTER, true, false,
				9, 1);
		gd_separator.heightHint = 2;
		separator.setLayoutData(gd_separator);
		formToolkit.paintBordersFor(separator);

		new Label(content, SWT.NONE);

		final Composite cmpRed = formToolkit.createComposite(content, SWT.NONE);
		cmpRed.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
		GridData gd_cmpRed = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_cmpRed.heightHint = 18;
		gd_cmpRed.widthHint = 18;
		cmpRed.setLayoutData(gd_cmpRed);
		formToolkit.paintBordersFor(cmpRed);

		final Composite cmpAmber = formToolkit.createComposite(content,
				SWT.NONE);
		cmpAmber.setBackground(SWTResourceManager.getColor(255, 140, 0));
		GridData gd_cmpAmber = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_cmpAmber.widthHint = 18;
		gd_cmpAmber.heightHint = 18;
		cmpAmber.setLayoutData(gd_cmpAmber);
		formToolkit.paintBordersFor(cmpAmber);

		final Composite cmpGreen = formToolkit.createComposite(content,
				SWT.NONE);
		cmpGreen.setBackground(SWTResourceManager.getColor(173, 255, 47));
		GridData gd_cmpGreen = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_cmpGreen.widthHint = 18;
		gd_cmpGreen.heightHint = 18;
		cmpGreen.setLayoutData(gd_cmpGreen);
		formToolkit.paintBordersFor(cmpGreen);

		final Label lblRagStatus = formToolkit.createLabel(content,
				"RAG Status RES's:", SWT.NONE);
		lblRagStatus.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));

		formTextRed = formToolkit.createFormText(content, false);
		formToolkit.paintBordersFor(formTextRed);
		formTextRed.setText("R", false, false);

		formTextAmber = formToolkit.createFormText(content, false);
		formToolkit.paintBordersFor(formTextAmber);
		formTextAmber.setText("A", false, false);

		formTextGreen = formToolkit.createFormText(content, false);
		formToolkit.paintBordersFor(formTextGreen);
		formTextGreen.setText("G", false, false);
	}

	// Remove later, use the new MonitoringStateModel.

	// /**
	// * Creates a summary in the background, update relevant UI bits when done.
	// */
	// private void prepServiceSummary(RFSService service) {
	//
	// if (job == null) {
	//
	// job = new MonitoringStateJob(modelUtils);
	//
	// job.addNotifier(new JobChangeAdapter() {
	// @Override
	// public void done(IJobChangeEvent event) {
	//
	// IMonitoringSummary monitoringSummary = job.getMonitoringSummary();
	// if(monitoringSummary instanceof RFSServiceSummary ){
	// summary = (RFSServiceSummary) monitoringSummary;
	// }
	// // Schedule a refresh.
	// refreshSummaryJob.schedule(100);
	// }
	// });
	// }
	// if (job.isRunning()) {
	// // This will abrupt the job but on demand, so we can't really start
	// // a new job here.
	// job.cancelMonitor();
	// }
	//
	// job.setContextToSummarize(service);
	// job.go(); // Should spawn a job processing the xls.
	//
	// }

	/**
	 * Inject a {@link RFSService} into the component. This will first create
	 * the Service Summary Model Object.
	 * 
	 * @param service
	 */
	public void injectData(RFSService service, DateTimeRange period) {

		final SummaryCallBack callBack = new SummaryCallBack();
		monitoringState.summary(callBack, service, new Object[] { period });
	}

	public void injectData(Object... selection) {

		for (Object o : selection) {
			if (MonitoringStateModel.isAdapted((EObject) o)) {
				IMonitoringSummary adapted = MonitoringStateModel
						.getAdapted((EObject) o);
				if (adapted instanceof NetxresourceSummary) {
					final SummaryCallBack callBack = new SummaryCallBack();
					monitoringState.summary(callBack, adapted.getRFSService(),
							new Object[] { adapted.getPeriod() });
				}
			}
		}
	}

	class SummaryCallBack implements MonitoringStateStateCallBack {

		public void callBackEvent(MonitoringStateEvent event) {
			if (event.getResult() instanceof RFSServiceSummary) {
				summary = (RFSServiceSummary) event.getResult();
				refreshSummaryJob.schedule(100);
			} else if (event.getResult() == null) {
				summary = null;
				refreshSummaryJob.schedule(100);
			}
		}
	};

	private void refreshSummaryUI() {

		if (summary == null) {
			formTextLastMonitor.setText("no monitors", false, false);
			content.layout();
			// layourComponent.layout();
			ScreenUtil.compositeFor(parentScreen).layout();
			return;
		}

		formTextLastMonitor.setText(summary.getPeriodFormattedString(), false,
				false);

		formTextNumberOfNodes.setText(
				new Integer(summary.totalNodes()).toString(), false, false);
		formTextNumberOfResources.setText(
				new Integer(summary.totalResources()).toString(), false, false);

		formTextRed.setText(new Integer(summary.totalRag(RAG.RED)).toString(),
				false, false);
		formTextAmber.setText(
				new Integer(summary.totalRag(RAG.AMBER)).toString(), false,
				false);
		formTextGreen.setText(
				new Integer(summary.totalRag(RAG.GREEN)).toString(), false,
				false);
		content.layout();
		// layourComponent.layout();
		ScreenUtil.compositeFor(parentScreen).layout();
	}

	/**
	 * Refreshes the RFS Service Summary Section.
	 * 
	 * @author Christophe Bouhier
	 */
	class RefreshSummaryJob extends UIJob {

		/**
		 * Creates a new instance of the class.
		 */
		public RefreshSummaryJob() {
			super("refresh");
			setSystem(true);
		}

		@Override
		public IStatus runInUIThread(IProgressMonitor monitor) {
			if (monitor.isCanceled()) {
				return new Status(IStatus.OK, ScreensActivator.PLUGIN_ID,
						IStatus.OK, "Cancelled ", null);
			}
			// System.out.println("Checking:" + content.hashCode());
			if (content.isDisposed()) {
				return new Status(IStatus.OK, ScreensActivator.PLUGIN_ID,
						IStatus.OK, "Screen not valid", null);
			}

			refreshSummaryUI();

			return new Status(IStatus.OK, PlatformUI.PLUGIN_ID, IStatus.OK, "",
					null);
		}

	}
}
