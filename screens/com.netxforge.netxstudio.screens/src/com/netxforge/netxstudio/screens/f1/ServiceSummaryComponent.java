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
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
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
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.common.model.RFSServiceSummary;
import com.netxforge.netxstudio.screens.editing.selector.IScreen;
import com.netxforge.netxstudio.screens.internal.ScreensActivator;
import com.netxforge.netxstudio.services.RFSService;

/**
 * An injectable component showing the Service Summary. Summaries are created in
 * the background.
 * 
 * 
 * 
 * 
 * @author Christophe Bouhier
 * 
 */
public class ServiceSummaryComponent {

	private final FormToolkit formToolkit = new FormToolkit(
			Display.getCurrent());

	/**
	 * Job which creates the summary.
	 */
	private RFSServiceSummaryJob job;

	/**
	 * Job which refreshs the UI for the created summary.
	 */
	private final RefreshSummaryJob refreshSummaryJob = new RefreshSummaryJob();

	private RFSServiceSummary summary;

	private ModelUtils modelUtils;

	private FormText formTextLastMonitor;

	private FormText formTextNumberOfNodes;

	private FormText formTextNumberOfResources;

	private FormText formTextRed;

	private FormText formTextAmber;

	private FormText formTextGreen;

	/*
	 * Defaults to show a border.
	 */
	private boolean showBorder = true;

	private Composite content;

	private Composite layourComponent;

	
	/** The parent IScreen needed to layout as this component will load in background **/ 
	@SuppressWarnings("unused")
	private IScreen parentScreen;


	@Inject
	public ServiceSummaryComponent(ModelUtils modelUtils) {
		super();
		this.modelUtils = modelUtils;
	}
	
	public  void setParentScreen(IScreen parentScreen){
		this.parentScreen = parentScreen; 
	}
	

	public void setShowBorder(boolean showBorder) {
		this.showBorder = showBorder;
	}

	public void buildUI(Composite parent, Object layoutData) {

		parent.addDisposeListener(new DisposeListener() {

			public void widgetDisposed(DisposeEvent e) {
				// Cancel running service summary job.
				if (job != null && job.isRunning()) {
					job.cancel();
				}
				refreshSummaryJob.cancel();
			}
		});

		layourComponent = parent.getParent(); // this is likely the component to
												// re-layout.

		content = formToolkit.createComposite(parent, showBorder ? SWT.BORDER
				: SWT.NONE);
		if (layoutData != null) {
			content.setLayoutData(layoutData);
		}
		
		formToolkit.paintBordersFor(content);
		content.setLayout(new GridLayout(4, false));

		Label label = formToolkit.createLabel(content, "Last Monitor:",
				SWT.NONE);
		label.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1));
		formTextLastMonitor = formToolkit.createFormText(content, false);
		formTextLastMonitor.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				true, false, 3, 1));

		Label lblMonitoredNodes = formToolkit.createLabel(content,
				"# Monitored NE's:", SWT.NONE);
		lblMonitoredNodes.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
				false, false, 1, 1));

		formTextNumberOfNodes = formToolkit.createFormText(content, false);
		formTextNumberOfNodes.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER,
				false, false, 3, 1));
		formToolkit.paintBordersFor(formTextNumberOfNodes);
		formTextNumberOfNodes.setText("", false, false);

		Label lblMonitoredRess = new Label(content, SWT.NONE);
		lblMonitoredRess.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
				false, false, 1, 1));
		formToolkit.adapt(lblMonitoredRess, true, true);
		lblMonitoredRess.setText("# Monitored RES's:");

		formTextNumberOfResources = formToolkit.createFormText(content, false);
		formTextNumberOfResources.setLayoutData(new GridData(SWT.LEFT,
				SWT.CENTER, false, false, 3, 1));
		formToolkit.paintBordersFor(formTextNumberOfResources);
		formTextNumberOfResources.setText("", false, false);

		Composite separator = formToolkit.createCompositeSeparator(content);
		GridData gd_separator = new GridData(SWT.FILL, SWT.CENTER, true, false,
				9, 1);
		gd_separator.heightHint = 2;
		separator.setLayoutData(gd_separator);
		formToolkit.paintBordersFor(separator);

		new Label(content, SWT.NONE);

		Composite cmpRed = formToolkit.createComposite(content, SWT.NONE);
		cmpRed.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
		GridData gd_cmpRed = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_cmpRed.heightHint = 18;
		gd_cmpRed.widthHint = 18;
		cmpRed.setLayoutData(gd_cmpRed);
		formToolkit.paintBordersFor(cmpRed);

		Composite cmpAmber = formToolkit.createComposite(content, SWT.NONE);
		cmpAmber.setBackground(SWTResourceManager.getColor(255, 140, 0));
		GridData gd_cmpAmber = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_cmpAmber.widthHint = 18;
		gd_cmpAmber.heightHint = 18;
		cmpAmber.setLayoutData(gd_cmpAmber);
		formToolkit.paintBordersFor(cmpAmber);

		Composite cmpGreen = formToolkit.createComposite(content, SWT.NONE);
		cmpGreen.setBackground(SWTResourceManager.getColor(173, 255, 47));
		GridData gd_cmpGreen = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_cmpGreen.widthHint = 18;
		gd_cmpGreen.heightHint = 18;
		cmpGreen.setLayoutData(gd_cmpGreen);
		formToolkit.paintBordersFor(cmpGreen);

		Label lblRagStatus = formToolkit.createLabel(content,
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
	 * Creates a summary in the background, update relevant UI bits when done.
	 */
	private void prepServiceSummary(RFSService service) {

		if (job == null) {

			job = new RFSServiceSummaryJob(modelUtils);

			job.addNotifier(new JobChangeAdapter() {
				@Override
				public void done(IJobChangeEvent event) {

					summary = job.getSummary();
					// Schedule a refresh.
					refreshSummaryJob.schedule(100);
				}
			});
		}
		if (job.isRunning()) {
			// This will abrupt the job but on demand, so we can't really start
			// a new job here.
			job.cancelMonitor();
		}

		job.setRFSServiceToProcess(service);
		job.go(); // Should spawn a job processing the xls.

	}

	/**
	 * Inject a {@link RFSService} into the component. This will first create
	 * the Service Summary Model Object.
	 * 
	 * @param service
	 */
	public void injectData(RFSService service) {
		prepServiceSummary(service);
	}

	private void refreshSummaryUI() {

		if (summary == null) {
			formTextLastMonitor.setText("no monitors", false, false);
//			content.layout();
			layourComponent.layout();
//			parentScreen.layout();
			return;
		}

		formTextLastMonitor.setText(summary.getPeriodFormattedString(), false,
				false);

		formTextNumberOfNodes.setText(
				new Integer(summary.getNodeCount()).toString(), false, false);
		formTextNumberOfResources.setText(
				new Integer(summary.getResourcesCount()).toString(), false,
				false);

		formTextRed.setText(
				new Integer(summary.getRedCountResources()).toString(), false,
				false);
		formTextAmber.setText(
				new Integer(summary.getAmberCountResources()).toString(),
				false, false);
		formTextGreen.setText(
				new Integer(summary.getGreenCountResources()).toString(),
				false, false);
		content.layout();
		layourComponent.layout();
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
			if (monitor.isCanceled() || content.isDisposed())
				return new Status(IStatus.OK, ScreensActivator.PLUGIN_ID,
						IStatus.OK, "", null);

			refreshSummaryUI();

			return new Status(IStatus.OK, PlatformUI.PLUGIN_ID, IStatus.OK, "",
					null);
		}

	}
}
