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

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.widgets.FormText;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.IMonitoringSummary;
import com.netxforge.netxstudio.common.model.IMonitoringSummary.RAG;
import com.netxforge.netxstudio.common.model.MonitoringStateEvent;
import com.netxforge.netxstudio.common.model.MonitoringStateModel;
import com.netxforge.netxstudio.common.model.MonitoringStateModel.JobCallBack;
import com.netxforge.netxstudio.common.model.MonitoringStateModel.MonitoringStateCallBack;
import com.netxforge.netxstudio.common.model.NodeTypeSummary;
import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.Operator;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.screens.editing.IScreen;
import com.netxforge.netxstudio.screens.editing.ScreenRefresher;
import com.netxforge.netxstudio.screens.editing.ScreenUtil;
import com.netxforge.netxstudio.services.RFSService;

/**
 * An injectable component showing the monitoring dashboard. </P> The dashboard
 * will present the monitor for the current selection. The dashboard adapts the
 * selection and presents the appropriate summary. </p>
 * 
 * @author Christophe Bouhier
 * 
 */
public class DashboardComponent implements MonitoringStateCallBack {

	private final FormToolkit formToolkit = new FormToolkit(
			Display.getCurrent());

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

	private Object[] injectedObjects;

	private ScreenRefresher refreshSummaryJob;

	private JobCallBack jobCallBack;

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
				if (refreshSummaryJob != null) {
					refreshSummaryJob.cancel();
				}
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
		cmpRed.setBackground(JFaceResources.getColorRegistry().get(
				ScreenUtil.RED_MARKER));
		GridData gd_cmpRed = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_cmpRed.heightHint = 18;
		gd_cmpRed.widthHint = 18;
		cmpRed.setLayoutData(gd_cmpRed);
		formToolkit.paintBordersFor(cmpRed);

		final Composite cmpAmber = formToolkit.createComposite(content,
				SWT.NONE);
		cmpAmber.setBackground(JFaceResources.getColorRegistry().get(
				ScreenUtil.AMBER_MARKER));
		GridData gd_cmpAmber = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_cmpAmber.widthHint = 18;
		gd_cmpAmber.heightHint = 18;
		cmpAmber.setLayoutData(gd_cmpAmber);
		formToolkit.paintBordersFor(cmpAmber);

		final Composite cmpGreen = formToolkit.createComposite(content,
				SWT.NONE);
		cmpGreen.setBackground(JFaceResources.getColorRegistry().get(
				ScreenUtil.GREEN_MARKER));
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

	public void injectData(Object... objects) {

		if (validSelection(objects) && objects.length == 1) {
			Object o = objects[0];

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

			// Being notified of ongoing summary job is needed when the
			// monitoring jobs are triggered by selection.
			// selection will also propagate to this component, and we will need
			// to wait and be notified for the
			// job to complete. However is the monitoring is processed by an
			// action, the monitoring will be updated
			// and waiting for completion is useless. we currently have no way
			// to differentiate so we do both.

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

	private ISummaryComponent summaryForSelection(Object o) {

		if (o instanceof Component) {
			return new ComponentSummaryComponent();
		} else if (o instanceof NetXResource) {
			return new NetXResourceSummaryComponent();
		} else if (o instanceof Node) {
			return new NodeSummaryComponent();
		} else if (o instanceof RFSService) {
			return new RFSServiceSummaryComponent();
		} else if (o instanceof Operator) {
			return new OperatorSummaryComponent();
		}
		return new NotActiveSummaryComponent();
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

	private void refreshSummaryUI(Collection<IMonitoringSummary> summaries) {

		if (!summaries.isEmpty()) {
			IMonitoringSummary summary = Lists.newArrayList(summaries).get(0);
			populateContent(summary);

			if (summary != null && summaryForSelection != null) {
				summaryForSelection.fillSummary(summary);
			} else {
				if (summaryForSelection != null) {
					summaryForSelection.dispose();
					summaryForSelection = null;
				}
			}
			refresh();
		}
	}

	private void refresh() {
		ScreenUtil.compositeFor(parentScreen).layout(true, true);
	}

	private void populateContent(IMonitoringSummary summary) {

		if (summary == null) {
			formTextLastMonitor.setText("No monitoring", false, false);
			formTextRed.setText("", false, false);
			formTextAmber.setText("", false, false);
			formTextGreen.setText("", false, false);
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

	private void resetContent() {
		formTextLastMonitor.setText("not active", false, false);

		formTextRed.setText("", false, false);
		formTextAmber.setText("", false, false);
		formTextGreen.setText("", false, false);

		if (summaryForSelection != null) {
			summaryForSelection.dispose();
		}
		summaryForSelection = summaryForSelection(null);
		summaryForSelection.buildUI(targetContent);

	}

	private void refreshSummary() {

		List<IMonitoringSummary> summariesToRefresh = Lists.newArrayList();
		for (Object injectedObject : getInjectedObjects()) {
			if (injectedObject instanceof Node) {
				Node n = (Node) injectedObject;
				if (n.eIsSet(OperatorsPackage.Literals.NODE__NODE_TYPE)) {
					NodeType nt = ((Node) injectedObject).getNodeType();
					if (MonitoringStateModel.isAdapted(nt)) {
						NodeTypeSummary summary = (NodeTypeSummary) MonitoringStateModel
								.getAdapted(nt);
						summariesToRefresh.add(summary);
					} else {
						System.out.println("target not adapted: " + nt);
					}
				} else {
					return;
				}

			} else if (injectedObject instanceof EObject) {
				EObject eo = (EObject) injectedObject;
				if (MonitoringStateModel.isAdapted(eo)) {
					IMonitoringSummary summary = MonitoringStateModel
							.getAdapted(eo);
					summariesToRefresh.add(summary);
				}
			} else {
				System.out.println("target not adapted: " + injectedObject);
			}
		}

		if(summariesToRefresh.isEmpty()){
			// Do not fire a refresh for not understood injections. 
			
		}
		
		if (refreshSummaryJob == null) {
			refreshSummaryJob = new ScreenRefresher() {
				@Override
				public void refreshSummaryUI(
						Collection<IMonitoringSummary> summaries) {
					DashboardComponent.this.refreshSummaryUI(summaries);
				}
			};
		}

		refreshSummaryJob.setSummary(summariesToRefresh);
		refreshSummaryJob.schedule(100);
	}

	public void reset() {
		// Deactiavate any monitoring job notification.
		if (jobCallBack != null) {
			monitoringState.deActivate(jobCallBack);
		}

		clearInjectedObjects();
		resetContent();
	}

	public void callBackEvent(MonitoringStateEvent event) {
		refreshSummary();
	}

	public synchronized void setInjectedObjects(Object[] objects) {
		this.injectedObjects = objects;

	}

	public synchronized Object[] getInjectedObjects() {
		return injectedObjects;
	}

	public synchronized void clearInjectedObjects() {
		injectedObjects = null;
	}

}
