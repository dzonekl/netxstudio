/*******************************************************************************
 * Copyright (c) 3 jan. 2013 NetXForge.
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
package com.netxforge.netxstudio.screens.nf3;

import org.eclipse.core.databinding.observable.list.IListChangeListener;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.ListChangeEvent;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.IEMFValueProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.databinding.edit.IEMFEditListProperty;
import org.eclipse.emf.databinding.edit.IEMFEditValueProperty;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.databinding.swt.ISWTObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.ColumnLayout;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormText;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.wb.swt.ResourceManager;

import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.data.actions.ServerRequest;
import com.netxforge.netxstudio.library.Expression;
import com.netxforge.netxstudio.library.LibraryFactory;
import com.netxforge.netxstudio.metrics.MetricRetentionPeriod;
import com.netxforge.netxstudio.metrics.MetricRetentionRule;
import com.netxforge.netxstudio.metrics.MetricRetentionRules;
import com.netxforge.netxstudio.metrics.MetricsFactory;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.ch9.NewEditExpression;
import com.netxforge.netxstudio.screens.editing.selector.IDataServiceInjection;
import com.netxforge.netxstudio.screens.editing.selector.ScreenUtil;

/**
 * Data retention UI screen.
 * 
 * @author Christophe Bouhier
 * 
 */
public class Retention extends AbstractScreen implements IDataServiceInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Resource retentionRulesResource;
	private MetricRetentionRules rules = null;
	private Form frmDataRetention;

	@Inject
	ServerRequest serverActions;
	private Composite cmpRules;
	private EMFDataBindingContext context;
	private Section sctnRules;
	private Section sctnCustomRules;
	private Composite cmpCustomRules;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public Retention(Composite parent, int style) {
		super(parent, style);
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
	}

	private void buildUI() {
		setLayout(new FillLayout(SWT.HORIZONTAL));

		frmDataRetention = toolkit.createForm(this);
		frmDataRetention.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmDataRetention);
		frmDataRetention.setText(this.getScreenName());
		ColumnLayout columnLayout = new ColumnLayout();
		columnLayout.maxNumColumns = 1;
		frmDataRetention.getBody().setLayout(columnLayout);

		// buildRunRetentionRulesSection();

		sctnRules = toolkit.createSection(frmDataRetention.getBody(),
				Section.TITLE_BAR);
		toolkit.paintBordersFor(sctnRules);
		sctnRules.setText("Data retention rules");

		// final ToolBarManager createSectionToolbar =
		// createSectionToolbar(sctnRules);
		//
		// final ImageDescriptor addDescriptor = ResourceManager
		// .getPluginImageDescriptor(
		// "com.netxforge.netxstudio.screens.editing",
		// "/icons/full/obj16/add_obj.gif");
		//
		// createSectionToolbar.add(new NewRetentionRuleAction("",
		// addDescriptor));
		//
		// createSectionToolbar.update(true);

		cmpRules = toolkit.createComposite(sctnRules, SWT.NONE);
		toolkit.paintBordersFor(cmpRules);
		sctnRules.setClient(cmpRules);

		// 1 Name,3. Combo with period 4. Expression. 
		cmpRules.setLayout(new GridLayout(3, false));

		FormText ftMetricDataRetentionInstruction = toolkit.createFormText(
				cmpRules, false);
		GridData gd_ftMetricDataRetentionInstruction = new GridData(SWT.FILL,
				SWT.CENTER, true, false, 4, 1);
		gd_ftMetricDataRetentionInstruction.heightHint = 23;
		ftMetricDataRetentionInstruction
				.setLayoutData(gd_ftMetricDataRetentionInstruction);
		toolkit.paintBordersFor(ftMetricDataRetentionInstruction);
		ftMetricDataRetentionInstruction
				.setText(
						"<form><p>Settings for data retention, keep value data for:</p>\n<p/></form>",
						true, false);

		sctnCustomRules = toolkit.createSection(frmDataRetention.getBody(),
				Section.TITLE_BAR);
		toolkit.paintBordersFor(sctnCustomRules);
		sctnCustomRules.setText("Custom data retention rules");

		final ToolBarManager customRulesToolBar = createSectionToolbar(sctnCustomRules);

		final ImageDescriptor addDescriptor = ResourceManager
				.getPluginImageDescriptor(
						"com.netxforge.netxstudio.screens.editing",
						"/icons/full/obj16/add_obj.gif");

		customRulesToolBar.add(new NewRetentionRuleAction("", addDescriptor));
		customRulesToolBar.update(true);

		cmpCustomRules = toolkit.createComposite(sctnCustomRules, SWT.NONE);
		toolkit.paintBordersFor(sctnCustomRules);
		sctnCustomRules.setClient(cmpCustomRules);

		// 1 Name, 2 Interval 3. Combo with period 4. Expression. 5. Delete
		// rule.
		cmpCustomRules.setLayout(new GridLayout(5, false));

	}

	// CB 17-07 2012, Decided not to allow this operation in this screen.
	// It would start a server side job, without showing feedback, the job can
	// be scheduled instead.
	@SuppressWarnings("unused")
	private void buildRunRetentionRulesSection() {
		Section sctnControl = toolkit.createSection(frmDataRetention.getBody(),
				Section.TITLE_BAR);
		sctnControl.setText("Control");
		toolkit.paintBordersFor(sctnControl);

		Composite composite = toolkit.createComposite(sctnControl, SWT.NONE);
		toolkit.paintBordersFor(composite);
		sctnControl.setClient(composite);
		composite.setLayout(new GridLayout(1, false));

		ImageHyperlink mghprlnkInvokeDataRetention = toolkit
				.createImageHyperlink(composite, SWT.NONE);
		mghprlnkInvokeDataRetention
				.addHyperlinkListener(new IHyperlinkListener() {
					public void linkActivated(HyperlinkEvent e) {
						try {
							serverActions
									.setCDOServer(editingService
											.getDataService().getProvider()
											.getServer());
							// TODO, We get the workflow run ID back, which
							// could be used
							// to link back to the screen showing the running
							// workflows.
							String result = serverActions.callRetentionAction();
							MessageDialog.openInformation(
									Retention.this.getShell(),
									"Data retention action invoked",
									"Clear data invoked on the server");

						} catch (Exception e1) {
							e1.printStackTrace();
							MessageDialog.openError(Retention.this.getShell(),
									"Data retention action failed:",
									"Remote service is not available");

						}

					}

					public void linkEntered(HyperlinkEvent e) {
					}

					public void linkExited(HyperlinkEvent e) {
					}
				});
		toolkit.paintBordersFor(mghprlnkInvokeDataRetention);
		mghprlnkInvokeDataRetention.setText("Invoke data retention rules now");
	}

	private void launchExpressionScreen(MetricRetentionRule retention) {
		if (retention != null) {
			NewEditExpression expressionScreen = new NewEditExpression(
					screenService.getScreenContainer(), SWT.NONE);
			Expression expression = null;
			if (retention.getRetentionExpression() == null) {
				expression = LibraryFactory.eINSTANCE.createExpression();
				expressionScreen.setOperation(ScreenUtil.OPERATION_NEW);
			} else {
				expression = retention.getRetentionExpression();
				expressionScreen.setOperation(ScreenUtil.OPERATION_EDIT);
			}
			expressionScreen.setScreenService(screenService);
			expressionScreen.injectData(expression.eResource(), expression);
			screenService.setActiveScreen(expressionScreen);
		}
	}

	public EMFDataBindingContext initDataBindings_() {

		final EMFDataBindingContext context = new EMFDataBindingContext();

		buildRules(context);

		// Add an observer to refresh the UI when rules are added/removed.
		final IEMFEditListProperty metricRetentionRules = EMFEditProperties
				.list(editingService.getEditingDomain(),
						MetricsPackage.Literals.METRIC_RETENTION_RULES__METRIC_RETENTION_RULES);

		final IObservableList observe = metricRetentionRules.observe(rules);
		observe.addListChangeListener(new IListChangeListener() {
			public void handleListChange(ListChangeEvent event) {
//				System.out.println("value changed: " + event);
				// rebuild the rules:
				buildRules(context);
				sctnRules.layout();
				sctnCustomRules.layout();
				
				frmDataRetention.layout();
			}
		});

		return context;
	}

	/**
	 * @param context
	 */
	private void buildRules(EMFDataBindingContext context) {

		// Dispose all children from cmpRules.
		if (cmpRules.getChildren().length > 0) {
			for (Control c : cmpRules.getChildren()) {
				c.dispose();
			}
		}
		
		if (cmpCustomRules.getChildren().length > 0) {
			for (Control c : cmpCustomRules.getChildren()) {
				c.dispose();
			}
		}

		for (MetricRetentionRule r : rules.getMetricRetentionRules()) {
			int indexOf = rules.getMetricRetentionRules().indexOf(r);
			// All rules above 4 are editable.
			addUIRule(r, context, indexOf > 4);
		}
	}

	private void addUIRule(MetricRetentionRule r,
			EMFDataBindingContext context, boolean isEditable) {
		final IEMFValueProperty retentionPeriodProperty = EMFEditProperties
				.value(editingService.getEditingDomain(),
						MetricsPackage.Literals.METRIC_RETENTION_RULE__PERIOD);
		IValueProperty selectionProperty = ViewerProperties.singleSelection();

		if (!isEditable) {
			addUIRule(cmpRules, r, context, retentionPeriodProperty,
					selectionProperty);
		} else {
			addCustomUIRule(cmpCustomRules, r, context,
					retentionPeriodProperty, selectionProperty);

		}
	}

	private void addUIRule(final Composite cmpRules,
			final MetricRetentionRule rule, EMFDataBindingContext context,
			IEMFValueProperty retentionPeriodProperty,
			IValueProperty cmbSelectionProperty) {

		final Label lblMonthlyValues = toolkit.createLabel(cmpRules,
				rule.getName(), SWT.NONE);
		lblMonthlyValues.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
				false, false, 1, 1));

		final ComboViewer cmbViewerTarget = new ComboViewer(cmpRules, SWT.NONE);
		Combo cmbMonthly = cmbViewerTarget.getCombo();
		GridData gd_cmbMonthly = new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1);
		gd_cmbMonthly.widthHint = 150;
		cmbMonthly.setLayoutData(gd_cmbMonthly);
		toolkit.paintBordersFor(cmbMonthly);

		final ImageHyperlink mghprlnkEditRetentionExpression = toolkit
				.createImageHyperlink(cmpRules, SWT.NONE);
		mghprlnkEditRetentionExpression.setLayoutData(new GridData(SWT.LEFT,
				SWT.CENTER, false, false, 1, 1));
		mghprlnkEditRetentionExpression
				.addHyperlinkListener(new HyperlinkAdapter() {
					public void linkActivated(HyperlinkEvent e) {
						launchExpressionScreen(rule);
					}
				});
		toolkit.paintBordersFor(mghprlnkEditRetentionExpression);
		mghprlnkEditRetentionExpression.setText("Edit retention expression");

		cmbViewerTarget.setContentProvider(new ArrayContentProvider());
		cmbViewerTarget.setLabelProvider(new LabelProvider());
		cmbViewerTarget.setInput(MetricRetentionPeriod.values());

		context.bindValue(cmbSelectionProperty.observe(cmbViewerTarget),
				retentionPeriodProperty.observe(rule));
	}

	private void addCustomUIRule(final Composite cmpRules,
			final MetricRetentionRule rule, EMFDataBindingContext context,
			IEMFValueProperty retentionPeriodProperty,
			IValueProperty cmbSelectionProperty) {

		// Edit the name of the rule.
		final Text nameText = toolkit.createText(cmpRules, "");
		nameText.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));

		final ISWTObservableValue observeTextName = SWTObservables
				.observeDelayedValue(400,
						SWTObservables.observeText(nameText, SWT.Modify));

		final IEMFEditValueProperty nameProperty = EMFEditProperties.value(
				editingService.getEditingDomain(),
				MetricsPackage.Literals.METRIC_RETENTION_RULE__NAME);

		context.bindValue(observeTextName, nameProperty.observe(rule));

		// Edit the interval.
		final Text intervalText = toolkit.createText(cmpRules, "");
		intervalText.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));

		final ISWTObservableValue observeTextInterval = SWTObservables
				.observeDelayedValue(400,
						SWTObservables.observeText(intervalText, SWT.Modify));

		final IEMFEditValueProperty intervalModelProperty = EMFEditProperties.value(
				editingService.getEditingDomain(),
				MetricsPackage.Literals.METRIC_RETENTION_RULE__INTERVAL_HINT);

		context.bindValue(observeTextInterval,
				intervalModelProperty.observe(rule));

		final ComboViewer cmbViewerTarget = new ComboViewer(cmpRules, SWT.NONE);
		Combo cmbMonthly = cmbViewerTarget.getCombo();
		GridData gd_cmbMonthly = new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1);
		gd_cmbMonthly.widthHint = 150;
		cmbMonthly.setLayoutData(gd_cmbMonthly);
		toolkit.paintBordersFor(cmbMonthly);

		final ImageHyperlink mghprlnkEditRetentionExpression = toolkit
				.createImageHyperlink(cmpRules, SWT.NONE);
		mghprlnkEditRetentionExpression.setLayoutData(new GridData(SWT.LEFT,
				SWT.CENTER, false, false, 1, 1));
		mghprlnkEditRetentionExpression
				.addHyperlinkListener(new HyperlinkAdapter() {
					public void linkActivated(HyperlinkEvent e) {
						launchExpressionScreen(rule);
					}
				});
		toolkit.paintBordersFor(mghprlnkEditRetentionExpression);
		mghprlnkEditRetentionExpression.setText("Edit retention expression");

		final ImageHyperlink hypLnkRemove = toolkit.createImageHyperlink(cmpRules,
				SWT.NONE);
		hypLnkRemove.addHyperlinkListener(new HyperlinkAdapter() {
			public void linkActivated(HyperlinkEvent e) {

				final Command deleteRuleCommand = DeleteCommand.create(
						editingService.getEditingDomain(), rule);
				editingService.getEditingDomain().getCommandStack()
						.execute(deleteRuleCommand);
			}
		});

		GridData gd_HypLnkFunction1 = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_HypLnkFunction1.widthHint = 18;
		hypLnkRemove.setLayoutData(gd_HypLnkFunction1);
		hypLnkRemove.setImage(ResourceManager.getPluginImage("org.eclipse.ui",
				"/icons/full/etool16/delete.gif"));
		toolkit.paintBordersFor(hypLnkRemove);
		hypLnkRemove.setText("");

		cmbViewerTarget.setContentProvider(new ArrayContentProvider());
		cmbViewerTarget.setLabelProvider(new LabelProvider());
		cmbViewerTarget.setInput(MetricRetentionPeriod.values());

		context.bindValue(cmbSelectionProperty.observe(cmbViewerTarget),
				retentionPeriodProperty.observe(rule));

	}

	public void injectData() {
		retentionRulesResource = editingService
				.getData(MetricsPackage.Literals.METRIC_RETENTION_RULES);
		EList<EObject> contents = retentionRulesResource.getContents();
		if (contents.size() == 1) {
			rules = (MetricRetentionRules) contents.get(0);
			buildUI();
			context = initDataBindings_();
		}
	}

	public Viewer getViewer() {
		return null;
	}

	public boolean isValid() {
		return true;
	}

	public Form getScreenForm() {
		return this.frmDataRetention;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.screens.AbstractScreenImpl#getScreenName()
	 */
	@Override
	public String getScreenName() {
		return "Data Retention";
	}

	/**
	 * Add a retention rule Action.
	 * 
	 * @author Christophe Bouhier
	 */
	class NewRetentionRuleAction extends Action {

		public NewRetentionRuleAction(String text) {
			super(text);
		}

		public NewRetentionRuleAction(String text, ImageDescriptor image) {
			super(text, image);
			this.setToolTipText("Add retention rule");
		}

		@Override
		public void run() {

			final MetricRetentionRule rule = MetricsFactory.eINSTANCE
					.createMetricRetentionRule();
			rule.setIntervalHint(ModelUtils.MINUTES_IN_AN_HOUR);
			rule.setPeriod(MetricRetentionPeriod.ALWAYS);
			rule.setName("Custom Rule");

			addUIRule(rule, context, true);

			final Command addRuleCommand = AddCommand
					.create(editingService.getEditingDomain(),
							rules,
							MetricsPackage.Literals.METRIC_RETENTION_RULES__METRIC_RETENTION_RULES,
							rule);

			editingService.getEditingDomain().getCommandStack()
					.execute(addRuleCommand);

		}

	}

}
