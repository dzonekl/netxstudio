/*******************************************************************************
 * Copyright (c) May 8, 2011 NetXForge.
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details. You should have received a copy of the GNU Lesser General Public
 * License along with this program. If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors: Christophe Bouhier - initial API and implementation and/or
 * initial documentation
 *******************************************************************************/ 
package com.netxforge.netxstudio.screens.parts;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

import com.netxforge.netxstudio.screens.f2.Resource;
import com.netxforge.netxstudio.screens.f2.ResourceCapacityRange;
import com.netxforge.netxstudio.screens.f4.MappingStatistics;
import com.netxforge.netxstudio.screens.f4.MetricSources;
import com.netxforge.netxstudio.screens.f4.MetricValueRange;
import com.netxforge.netxstudio.screens.f4.Metrics;
import com.netxforge.netxstudio.screens.f4.NewMappingColumn;
import com.netxforge.netxstudio.screens.f4.NewMetric;
import com.netxforge.netxstudio.screens.f4.NewMetricSource;
import com.netxforge.netxstudio.screens.f4.NewScheduledJob;
import com.netxforge.netxstudio.screens.f4.NewXLSMapping;
import com.netxforge.netxstudio.screens.f4.PurgeMetrics;
import com.netxforge.netxstudio.screens.f4.ResourceMonitor;
import com.netxforge.netxstudio.screens.f4.Scheduler;
import com.netxforge.netxstudio.screens.nf4.LoginDialog;
import com.netxforge.netxstudio.screens.nf4.NewEditUser;
import com.netxforge.netxstudio.screens.nf4.UsersAndRoles;

public class ScreenSelector extends AbstractScreenSelector {

	public static final String ID = "com.netxforge.netxstudio.screens.screen.ScreenSelector"; //$NON-NLS-1$
	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());

	public ScreenSelector() {
	}

	/**
	 * A dynamic selector screen selector. 
	 * Extends an Editor view part for dirtyness, editing domain, command stack etc...
	 * 
	 * 
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);
	}

	public void buildSelector(final Composite container){
		
		Section sctnNewSection = toolkit.createSection(getSelectorForm().getBody(),
				Section.COMPACT | Section.EXPANDED | Section.TREE_NODE
						| Section.TITLE_BAR);
		FormData fd_sctnNewSection = new FormData();
		fd_sctnNewSection.bottom = new FormAttachment(0, 170);
		fd_sctnNewSection.right = new FormAttachment(0, 161);
		fd_sctnNewSection.top = new FormAttachment(0);
		fd_sctnNewSection.left = new FormAttachment(0);
		sctnNewSection.setLayoutData(fd_sctnNewSection);
		toolkit.paintBordersFor(sctnNewSection);
		sctnNewSection.setText("Iteration #1");

		Composite composite_1 = toolkit.createComposite(sctnNewSection,
				SWT.NONE);
		toolkit.paintBordersFor(composite_1);
		sctnNewSection.setClient(composite_1);
		composite_1.setLayout(new GridLayout(1, false));
		
		Section sctnNewSection_1 = toolkit.createSection(super.getSelectorForm().getBody(),
				Section.TREE_NODE | Section.TITLE_BAR);
		FormData fd_sctnNewSection_1 = new FormData();
		fd_sctnNewSection_1.bottom = new FormAttachment(100, -12);
		fd_sctnNewSection_1.right = new FormAttachment(sctnNewSection, 0,
				SWT.RIGHT);
		fd_sctnNewSection_1.top = new FormAttachment(sctnNewSection);
		fd_sctnNewSection_1.left = new FormAttachment(0);
		sctnNewSection_1.setLayoutData(fd_sctnNewSection_1);
		toolkit.paintBordersFor(sctnNewSection_1);
		sctnNewSection_1.setText("Iteration #2");
		sctnNewSection_1.setExpanded(true);

		Composite composite = toolkit.createComposite(sctnNewSection_1,
				SWT.NONE);
		toolkit.paintBordersFor(composite);
		sctnNewSection_1.setClient(composite);
		composite.setLayout(new GridLayout(1, false));
			
		
		
		Button btnLogin = new Button(composite_1, SWT.FLAT);
		btnLogin.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));
		btnLogin.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				LoginDialog ld = new LoginDialog(ScreenSelector.this
						.getSite().getShell());
				ld.open();

			}
		});
		toolkit.adapt(btnLogin, true, true);
		btnLogin.setText("Login");

		Button btnUsersAndRoles = toolkit.createButton(composite_1,
				"Users and Roles", SWT.NONE);
		btnUsersAndRoles.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				
				// TODO, consider if this is the correct API. 
				if(isActiveScreen(UsersAndRoles.class))
					return;
				updateComposite(new UsersAndRoles(container,
						SWT.NONE));
			}
		});
		btnUsersAndRoles.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));

		Button btnNewUser = toolkit.createButton(composite_1, "New User",
				SWT.NONE);
		btnNewUser.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
//				if (currentComposite instanceof NewUser)
//					return;
				updateComposite(new NewEditUser(container, SWT.NONE));
			}
		});
		btnNewUser.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));

		Button btnJobs = new Button(composite_1, SWT.FLAT);
		btnJobs.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false,
				1, 1));
		btnJobs.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
//				if (currentComposite instanceof Scheduler)
//					return;
				updateComposite(new Scheduler(container, SWT.NONE));
			}
		});
		toolkit.adapt(btnJobs, true, true);
		btnJobs.setText("Scheduler Jobs");

		Button btnNewJob = new Button(composite_1, SWT.FLAT);
		btnNewJob.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
//				if (currentComposite instanceof NewScheduledJob)
//					return;
				updateComposite(new NewScheduledJob(container,
						SWT.NONE));
			}
		});
		btnNewJob.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));
		toolkit.adapt(btnNewJob, true, true);
		btnNewJob.setText("New Job");

		

		Button btnNewButton = toolkit.createButton(composite, "Metrics",
				SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
//				if (currentComposite instanceof Metrics)
//					return;
				updateComposite(new Metrics(container, SWT.NONE));
			}
		});
		btnNewButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));

		Button btnNewButton_1 = toolkit.createButton(composite, "New Metric",
				SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
//				if (currentComposite instanceof NewMetric)
//					return;
				updateComposite(new NewMetric(container, SWT.NONE));

			}
		});
		btnNewButton_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));

		Button btnMetricSources = new Button(composite, SWT.FLAT);
		btnMetricSources.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));
		btnMetricSources.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Launch the editor.
//				if (currentComposite instanceof MetricSources)
//					return;
				updateComposite( new MetricSources(container,
						SWT.NONE));
			}
		});
		toolkit.adapt(btnMetricSources, true, true);
		btnMetricSources.setText("Metric Sources");

		Button btnNewMetricSource = toolkit.createButton(composite,
				"New Metric Source", SWT.NONE);
		btnNewMetricSource.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				false, false, 1, 1));

		Button btnPurgeMetrics = toolkit.createButton(composite,
				"Purge Metrics", SWT.NONE);
		btnPurgeMetrics.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));

		Button btnNewXlsMapping = toolkit.createButton(composite,
				"New XLS Mapping", SWT.NONE);
		btnNewXlsMapping.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				false, false, 1, 1));

		Button btnNewMappingColumn = toolkit.createButton(composite,
				"New Mapping Column", SWT.NONE);
		btnNewMappingColumn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
//				if (currentComposite instanceof NewMappingColumn)
//					return;
				updateComposite(new NewMappingColumn(container,
						SWT.NONE));
			}
		});
		btnNewMappingColumn.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				false, false, 1, 1));

		Button btnXlsMappingStatistics = toolkit.createButton(composite,
				"XLS Mapping Statistics", SWT.NONE);
		btnXlsMappingStatistics.setLayoutData(new GridData(SWT.FILL,
				SWT.CENTER, false, false, 1, 1));

		Button btnResource = toolkit.createButton(composite, "Resource",
				SWT.NONE);
		btnResource.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
//				if (currentComposite instanceof Resource)
//					return;
				updateComposite(new Resource(container, SWT.NONE));

			}
		});
		btnResource.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));

		Button btnMetricValueRange = toolkit.createButton(composite,
				"Metric Value Range", SWT.NONE);
		btnMetricValueRange.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
//				if (currentComposite instanceof MetricValueRange)
//					return;
				updateComposite(new MetricValueRange(container,
						SWT.NONE));

			}
		});
		btnMetricValueRange.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				false, false, 1, 1));

		Button btnCapacityRange = toolkit.createButton(composite,
				"Capacity Range", SWT.NONE);
		btnCapacityRange.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
//				if (currentComposite instanceof ResourceCapacityRange)
//					return;
				updateComposite(new ResourceCapacityRange(container,
						SWT.NONE));
			}
		});
		btnCapacityRange.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				false, false, 1, 1));
		
		Button btnResourceMonitor = toolkit.createButton(composite, "Resource Monitor", SWT.NONE);
		btnResourceMonitor.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
//				if (currentComposite instanceof ResourceMonitor)
//					return;
				updateComposite(new ResourceMonitor(container,
						SWT.NONE));
			}
		});
		btnResourceMonitor.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnXlsMappingStatistics.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

//				if (currentComposite instanceof MappingStatistics)
//					return;
				updateComposite(new MappingStatistics(container,
						SWT.NONE));
			}
		});
		btnNewXlsMapping.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
//				if (currentComposite instanceof NewXLSMapping)
//					return;
				updateComposite(new NewXLSMapping(container,
						SWT.NONE));
			}
		});
		btnPurgeMetrics.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
//				if (currentComposite instanceof PurgeMetrics)
//					return;
				updateComposite(new PurgeMetrics(container, SWT.NONE));
			}
		});
		btnNewMetricSource.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
//				if (currentComposite instanceof NewMetricSource)
//					return;
				updateComposite(new NewMetricSource(container,
						SWT.NONE));
			}
		});
	}
	
	
	public void dispose() {
		toolkit.dispose();
		super.dispose();
	}

	@Override
	public void setFocus() {
		// Set the focus
	}

	/* (non-Javadoc)
	 * @see com.netxforge.netxstudio.screens.editing.AbstractEditorViewPart#initBindings()
	 */
	
	@Override
	protected void initBindings() {
		// TODO Auto-generated method stub
		// Static initialization of bindings. We need a dynamic form for this. 
		// 
		
	}
}
