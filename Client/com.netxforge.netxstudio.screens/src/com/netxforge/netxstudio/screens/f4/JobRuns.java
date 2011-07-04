/*******************************************************************************
 * Copyright (c) May 16, 2011 NetXForge.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  You should have received a copy of the GNU Lesser General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>
 *
 * Contributors:
 *    Christophe Bouhier - initial API and implementation and/or initial documentation
 *******************************************************************************/
package com.netxforge.netxstudio.screens.f4;

import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

import com.netxforge.netxstudio.scheduling.Job;
import com.netxforge.netxstudio.scheduling.JobRunContainer;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.editing.selector.IDataScreenInjection;

/**
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 * 
 */
public class JobRuns extends AbstractScreen implements IDataScreenInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Table table;

	public JobRuns(Composite parent, int style) {
		super(parent, style);

		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);

		setLayout(new FillLayout(SWT.HORIZONTAL));

		frmJobRuns = toolkit.createForm(this);
		frmJobRuns.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmJobRuns);

		frmJobRuns.setText("Job: \"Job name\"");
		frmJobRuns.getBody().setLayout(new FormLayout());

		Section sctnInfo = toolkit.createSection(frmJobRuns.getBody(),
				Section.EXPANDED | Section.TITLE_BAR);
		FormData fd_sctnInfo = new FormData();
		fd_sctnInfo.top = new FormAttachment(frmJobRuns.getBody(), 12);
		fd_sctnInfo.bottom = new FormAttachment(100, -12);
		fd_sctnInfo.right = new FormAttachment(100, -12);
		fd_sctnInfo.left = new FormAttachment(0, 12);
		sctnInfo.setLayoutData(fd_sctnInfo);
		toolkit.paintBordersFor(sctnInfo);
		sctnInfo.setText("Runs");

		Composite composite_1 = toolkit.createComposite(sctnInfo, SWT.NONE);
		toolkit.paintBordersFor(composite_1);
		sctnInfo.setClient(composite_1);
		GridLayout gl_composite_1 = new GridLayout(1, false);
		gl_composite_1.horizontalSpacing = 8;
		composite_1.setLayout(gl_composite_1);

		jobRunsTableViewer = new TableViewer(composite_1, SWT.BORDER
				| SWT.FULL_SELECTION);
		table = jobRunsTableViewer.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		toolkit.paintBordersFor(table);

		TableViewerColumn tableViewerColumn = new TableViewerColumn(
				jobRunsTableViewer, SWT.NONE);
		TableColumn tblclmnStatus = tableViewerColumn.getColumn();
		tblclmnStatus.setWidth(97);
		tblclmnStatus.setText("Status");

		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(
				jobRunsTableViewer, SWT.NONE);
		TableColumn tblclmnProgress = tableViewerColumn_1.getColumn();
		tblclmnProgress.setWidth(116);
		tblclmnProgress.setText("Progress");

		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(
				jobRunsTableViewer, SWT.NONE);
		TableColumn tblclmnTask = tableViewerColumn_2.getColumn();
		tblclmnTask.setWidth(114);
		tblclmnTask.setText("Task");

		TableViewerColumn tableViewerColumn_6 = new TableViewerColumn(
				jobRunsTableViewer, SWT.NONE);
		TableColumn tblclmnMessage = tableViewerColumn_6.getColumn();
		tblclmnMessage.setWidth(100);
		tblclmnMessage.setText("Message");

		TableViewerColumn tableViewerColumn_4 = new TableViewerColumn(
				jobRunsTableViewer, SWT.NONE);
		TableColumn tblclmnStarted = tableViewerColumn_4.getColumn();
		tblclmnStarted.setWidth(100);
		tblclmnStarted.setText("Started");

		TableViewerColumn tableViewerColumn_5 = new TableViewerColumn(
				jobRunsTableViewer, SWT.NONE);
		TableColumn tblclmnEnded = tableViewerColumn_5.getColumn();
		tblclmnEnded.setWidth(100);
		tblclmnEnded.setText("Ended");

		Menu menu = new Menu(table);
		table.setMenu(menu);

		MenuItem mntmShowLog = new MenuItem(menu, SWT.NONE);
		mntmShowLog.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO, A popup showing the log.

			}
		});
		mntmShowLog.setText("Show Log...");

		TableViewerColumn tableViewerColumn_3 = new TableViewerColumn(
				jobRunsTableViewer, SWT.NONE);
		TableColumn tblclmnLog = tableViewerColumn_3.getColumn();
		tblclmnLog.setWidth(100);
		tblclmnLog.setText("Log");
	}

	private TableViewer jobRunsTableViewer;
	private Form frmJobRuns;
	private Job job;
	private JobRunContainer currentJonContainer;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.data.IDataScreenInjection#injectData(java.lang
	 * .Object, java.lang.Object)
	 */
	public void injectData(Object owner, Object object) {

		// Ignore the owner, we don't add data.

		if (object instanceof Job) {
			job = (Job) object;
			// TODO Make a fancy string for a job.
			this.getScreenForm().setText("Job:" + job.getName());

			// Get the job container:
			Resource jobRunContainerResource = editingService
					.getData(SchedulingPackage.Literals.JOB_RUN_CONTAINER);
			// find our jobcontainer .
			for (final EObject eObject : jobRunContainerResource.getContents()) {
				final JobRunContainer container = (JobRunContainer) eObject;
				final Job containerJob = container.getJob();
				final CDOID containerJobId = ((CDOObject) containerJob).cdoID();
				if (job.cdoID().equals(containerJobId)) {
					// Container found.
					currentJonContainer = container;
					this.initDataBindings_();
					return;
				}
			}
			// There is no container, TODO should really do this test before
			// showing the runs.
			// Do not initiate data binding.
			MessageDialog.openInformation(this.getShell(), "Job runs",
					"This job has not run yet.");

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.data.IDataScreenInjection#addData()
	 */
	public void addData() {
		throw new java.lang.UnsupportedOperationException();
	}

	public EMFDataBindingContext initDataBindings_() {

		EMFDataBindingContext bindingContext = new EMFDataBindingContext();

		// TODO, We would need some ordering the workflow runs by date, and
		// perhaps some custom cell viewers to show the
		// log for a run.

		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		jobRunsTableViewer.setContentProvider(listContentProvider);
		IObservableMap[] observeMaps = EMFObservables
				.observeMaps(
						listContentProvider.getKnownElements(),
						new EStructuralFeature[] {
								SchedulingPackage.Literals.WORK_FLOW_RUN__STATE,
								SchedulingPackage.Literals.WORK_FLOW_RUN__PROGRESS,
								SchedulingPackage.Literals.WORK_FLOW_RUN__PROGRESS_TASK,
								SchedulingPackage.Literals.WORK_FLOW_RUN__PROGRESS_MESSAGE,
								SchedulingPackage.Literals.WORK_FLOW_RUN__STARTED,
								SchedulingPackage.Literals.WORK_FLOW_RUN__ENDED,
								SchedulingPackage.Literals.WORK_FLOW_RUN__LOG });
		jobRunsTableViewer
				.setLabelProvider(new WorkflowRunObservableMapLabelProvider(
						observeMaps));

		IEMFListProperty l = EMFProperties
				.list(SchedulingPackage.Literals.JOB_RUN_CONTAINER__WORK_FLOW_RUNS);
		jobRunsTableViewer.setInput(l.observe(currentJonContainer));
		return bindingContext;
	}

	class WorkflowRunObservableMapLabelProvider extends
			ObservableMapLabelProvider {

		public WorkflowRunObservableMapLabelProvider(
				IObservableMap[] attributeMaps) {
			super(attributeMaps);
		}

		public WorkflowRunObservableMapLabelProvider(IObservableMap attributeMap) {
			super(attributeMap);
		}

		@Override
		public String getText(Object element) {

			((EObject) element).eContainmentFeature();

			return super.getText(element);
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			return super.getColumnText(element, columnIndex);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.common.ui.viewer.IViewerProvider#getViewer()
	 */
	public Viewer getViewer() {
		return this.getTableViewerWidget();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.screens.editing.selector.IScreen#isValid()
	 */
	public boolean isValid() {
		return true;
	}

	public TableViewer getTableViewerWidget() {
		return jobRunsTableViewer;
	}

	@Override
	public Form getScreenForm() {
		return frmJobRuns;
	}

	public void disposeData() {
		// N/A
	}

	@Override
	public void setOperation(int operation) {
		this.operation = operation;
	}
}
