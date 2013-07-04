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
package com.netxforge.netxstudio.screens.monitoring;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FillLayout;
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
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.operators.Network;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.Operator;
import com.netxforge.netxstudio.screens.editing.IScreen;
import com.netxforge.netxstudio.screens.editing.ScreenUtil;
import com.netxforge.netxstudio.screens.internal.ScreensActivator;
import com.netxforge.netxstudio.services.RFSService;

/**
 * An injectable component showing the monitoring dashboard. </P> The dashboard
 * will present the monitor for the current selection. The dashboard adapts the
 * selection and presents the appropriate summary. </p>
 * 
 * @author Christophe Bouhier
 * 
 */
public class DashboardComponent extends JobChangeAdapter {

	private final FormToolkit formToolkit = new FormToolkit(
			Display.getCurrent());

	/**
	 * Job which refreshs the UI for the created summary.
	 */
	private final RefreshSummaryJob refreshSummaryJob = new RefreshSummaryJob();

	private FormText formTextLastMonitor;

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

	/**
	 * A monitoring state model which can adapt objects, so monitoring
	 * information becomes available.
	 */
	private MonitoringStateModel monitoringState;

	private Composite targetContent;

	private ISummaryComponent summaryForSelection;

	private EObject latestSelection;

	@Inject
	public DashboardComponent(MonitoringStateModel ms) {
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
				SWT.RIGHT);

		GridData gd_lblPeriod = new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblPeriod.widthHint = 83;
		periodLabel.setLayoutData(gd_lblPeriod);

		formTextLastMonitor = formToolkit.createFormText(content, false);
		formTextLastMonitor.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				true, false, 3, 1));

		// This is the dynamic portion.

		targetContent = formToolkit.createComposite(content, SWT.NONE);
		targetContent.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, true,
				false, 4, 1));
		targetContent.setLayout(new FillLayout());

		// / RAG INFORMATION.
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

	/**
	 * Inject a {@link RFSService} into the component. This will first create
	 * the Service Summary Model Object.
	 * 
	 * @param service
	 */
	// public void injectData(RFSService service, DateTimeRange period) {
	//
	// final SummaryCallBack callBack = new SummaryCallBack();
	//
	// monitoringState.summary(callBack, service, new IComputation[] { period
	// });
	// }

	public void injectData(Object... selection) {

		processSelection(selection);
	}

	private void processSelection(Object... selection) {

		if (validSelection(selection) && selection.length == 1) {
			Object o = selection[0];

			ISummaryComponent proposedSummaryForSelection = summaryForSelection(o);
			if (summaryForSelection == null
					|| !proposedSummaryForSelection.getClass().getName()
							.equals(summaryForSelection.getClass().getName())) {

				// Prep. the summary UI if we are not the same.
				if (summaryForSelection != null) {
					summaryForSelection.dispose();
				}
				summaryForSelection = proposedSummaryForSelection;
				summaryForSelection.buildUI(targetContent);
			}
			// Prep the summary itself, as the monitoring job might still be
			// running, we delay until it's ready.
			if (o instanceof EObject) {
				setLatestSelection((EObject) o);
			}
			
			// We can't add a notifier until the 
			deActivate();
			activate();

		} else {
			// TODO, for multiple selections, we need a
			// IMonitoringSummaryComposite object.

		}
	}

	private ISummaryComponent summaryForSelection(Object o) {

		if (o instanceof Component) {
			return new ComponentSummaryComponent();
		} else if (o instanceof NetXResource) {
			return new NetXResourceSummaryComponent();
		} else if (o instanceof Node) {
			return new TODOSummaryComponent();
		} else if (o instanceof NodeType) {
			return new TODOSummaryComponent();
		} else if (o instanceof Network) {
			return new TODOSummaryComponent();
		} else if (o instanceof RFSService) {
			return new TODOSummaryComponent();
		} else if (o instanceof Operator) {
			return new TODOSummaryComponent();
		}
		return new NotSupportedSummaryComponent();
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

	class SummaryCallBack implements MonitoringStateStateCallBack {

		public void callBackEvent(MonitoringStateEvent event) {

			IMonitoringSummary summary = null;

			if (event.getResult() instanceof IMonitoringSummary) {
				summary = (IMonitoringSummary) event.getResult();
			}
			refreshSummaryJob.setSummary(summary);
			refreshSummaryJob.schedule(100);
		}
	};

	private void refreshSummaryUI(IMonitoringSummary summary) {

		populateContent(summary);

		if (summary != null && summaryForSelection != null) {
			summaryForSelection.fillSummary(summary);
		}
		refresh();
	}

	private void refresh() {
		// targetContent.layout();
		// content.layout();
		ScreenUtil.compositeFor(parentScreen).layout(true, true);
	}

	private void populateContent(IMonitoringSummary summary) {

		if (summary == null) {
			formTextLastMonitor.setText("no monitors", false, false);
			// layourComponent.layout();
		} else {

			formTextLastMonitor.setText(summary.getPeriodFormattedString(),
					false, false);

			formTextRed.setText(
					new Integer(summary.totalRag(RAG.RED)).toString(), false,
					false);
			formTextAmber.setText(
					new Integer(summary.totalRag(RAG.AMBER)).toString(), false,
					false);
			formTextGreen.setText(
					new Integer(summary.totalRag(RAG.GREEN)).toString(), false,
					false);
		}
	}

	/**
	 * Refreshes the RFS Service Summary Section.
	 * 
	 * @author Christophe Bouhier
	 */
	class RefreshSummaryJob extends UIJob {

		private IMonitoringSummary summary;

		public void setSummary(IMonitoringSummary summary) {
			this.summary = summary;
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
			// System.out.println("Checking:" + content.hashCode());
			if (content.isDisposed()) {
				return new Status(IStatus.OK, ScreensActivator.PLUGIN_ID,
						IStatus.OK, "Widget disposed", null);
			}
			if (summary == null) {
				return new Status(IStatus.WARNING, ScreensActivator.PLUGIN_ID,
						IStatus.ERROR, "No summary for this object", null);
			}

			refreshSummaryUI(summary);

			return new Status(IStatus.OK, PlatformUI.PLUGIN_ID, IStatus.OK, "",
					null);
		}

	}

	private void updateLatestSelection() {
		if (MonitoringStateModel.isAdapted(this.getLatestSelection())) {
			System.out.println("Dashboard: Good :-) already adapted: "
					+ (this.getLatestSelection()).toString());
			IMonitoringSummary adapted = MonitoringStateModel.getAdapted(this
					.getLatestSelection());
			refreshSummaryJob.setSummary(adapted);
			refreshSummaryJob.schedule(100);
		} else {
			//
			// final SummaryCallBack callBack = new SummaryCallBack();
			// monitoringState.summary(callBack, o, new Object[] {});
		}
	}

	private synchronized void setLatestSelection(EObject o) {
		this.latestSelection = o;

	}

	private synchronized EObject getLatestSelection() {
		return latestSelection;
	}

	@Override
	public void done(IJobChangeEvent event) {
		updateLatestSelection();
	}

	/**
	 * Listen to the monitoring state jobs.
	 */
	public void activate() {
		monitoringState.addJobNotifier(this);
	}

	/**
	 * remove the listener to the monitoring state jobs.
	 */
	public void deActivate() {
		monitoringState.removeJobNotifier(this);
	}

}
