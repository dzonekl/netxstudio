package com.netxforge.netxstudio.screens.nf3;

import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.IEMFValueProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.dialogs.MessageDialog;
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
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.ColumnLayout;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormText;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.ui.forms.widgets.Section;

import com.google.inject.Inject;
import com.netxforge.netxstudio.data.actions.ServerRequest;
import com.netxforge.netxstudio.library.Expression;
import com.netxforge.netxstudio.library.LibraryFactory;
import com.netxforge.netxstudio.metrics.MetricRetentionPeriod;
import com.netxforge.netxstudio.metrics.MetricRetentionRule;
import com.netxforge.netxstudio.metrics.MetricRetentionRules;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.ch9.NewEditExpression;
import com.netxforge.netxstudio.screens.editing.selector.IDataServiceInjection;
import com.netxforge.netxstudio.screens.editing.selector.Screens;

public class Retention extends AbstractScreen implements IDataServiceInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Resource retentionRulesResource;
	private MetricRetentionRules rules = null;
	private Form frmDataRetention;

	@Inject
	ServerRequest serverActions;
	private Composite cmpRules;

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
		frmDataRetention.setText("Data Retention");
		ColumnLayout columnLayout = new ColumnLayout();
		columnLayout.maxNumColumns = 1;
		frmDataRetention.getBody().setLayout(columnLayout);

		Section sctnControl = toolkit.createSection(frmDataRetention.getBody(),
				Section.TITLE_BAR);
		sctnControl.setText("Control");
//		FormData fd_sctnControl = new FormData();
//		fd_sctnControl.top = new FormAttachment(0, 10);
//		fd_sctnControl.left = new FormAttachment(0, 10);
//		sctnControl.setLayoutData(fd_sctnControl);
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
									.setCDOServer(editingService.getDataService()
											.getProvider().getServer());
							// TODO, We get the workflow run ID back, which
							// could be used
							// to link back to the screen showing the running
							// workflows.

							@SuppressWarnings("unused")
							String result = serverActions.callRetentionAction();
							MessageDialog.openInformation(
									Retention.this.getShell(),
									"Data retention action invoked",
									"Clear data invoked on the server");

						} catch (Exception e1) {
							e1.printStackTrace();
							MessageDialog.openError(Retention.this.getShell(),
									"Data retention action failed:", "Remote service is not available");

						}

					}

					public void linkEntered(HyperlinkEvent e) {
					}

					public void linkExited(HyperlinkEvent e) {
					}
				});
		toolkit.paintBordersFor(mghprlnkInvokeDataRetention);
		mghprlnkInvokeDataRetention.setText("Invoke data retention rules now");

		Section sctnRules = toolkit.createSection(frmDataRetention.getBody(),
				Section.TITLE_BAR);
//		fd_sctnControl.right = new FormAttachment(sctnRules, 0, SWT.RIGHT);
//		fd_sctnControl.bottom = new FormAttachment(sctnRules, -6);
//		FormData fd_sctnRules = new FormData();
//		fd_sctnRules.bottom = new FormAttachment(100, -10);
//		fd_sctnRules.top = new FormAttachment(0, 120);
//		fd_sctnRules.left = new FormAttachment(0, 10);
//		fd_sctnRules.right = new FormAttachment(100, -10);
//		sctnRules.setLayoutData(fd_sctnRules);
		toolkit.paintBordersFor(sctnRules);
		sctnRules.setText("Data retention rules");

		cmpRules = toolkit.createComposite(sctnRules, SWT.NONE);
		toolkit.paintBordersFor(cmpRules);
		sctnRules.setClient(cmpRules);
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
	}

	private void launchExpressionScreen(MetricRetentionRule retention) {
		if (retention != null) {
			NewEditExpression expressionScreen = new NewEditExpression(
					screenService.getScreenContainer(), SWT.NONE);
			Expression expression = null;
			if (retention.getRetentionExpression() == null) {
				expression = LibraryFactory.eINSTANCE.createExpression();
				expressionScreen.setOperation(Screens.OPERATION_NEW);
			} else {
				expression = retention.getRetentionExpression();
				expressionScreen.setOperation(Screens.OPERATION_EDIT);
			}
			expressionScreen.setScreenService(screenService);
			expressionScreen
					.injectData(
							null,
							retention,
							MetricsPackage.Literals.METRIC_RETENTION_RULE__RETENTION_EXPRESSION,
							expression);
			screenService.setActiveScreen(expressionScreen);
		}
	}

	public EMFDataBindingContext initDataBindings_() {

		EMFDataBindingContext context = new EMFDataBindingContext();

		IEMFValueProperty retentionPeriodProperty = EMFEditProperties.value(
				editingService.getEditingDomain(),
				MetricsPackage.Literals.METRIC_RETENTION_RULE__PERIOD);
		IValueProperty selectionProperty = ViewerProperties.singleSelection();

		for (MetricRetentionRule r : rules.getMetricRetentionRules()) {
			addRule(cmpRules, r, context, retentionPeriodProperty,
					selectionProperty);
		}

		return context;
	}

	private void addRule(Composite cmpRules, final MetricRetentionRule rule,
			EMFDataBindingContext context,
			IEMFValueProperty retentionPeriodProperty,
			IValueProperty selectionProperty) {

		Label lblMonthlyValues = toolkit.createLabel(cmpRules, rule.getName(),
				SWT.NONE);
		lblMonthlyValues.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
				false, false, 1, 1));

		ComboViewer cmbViewerTarget = new ComboViewer(cmpRules, SWT.NONE);
		Combo cmbMonthly = cmbViewerTarget.getCombo();
		GridData gd_cmbMonthly = new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1);
		gd_cmbMonthly.widthHint = 150;
		cmbMonthly.setLayoutData(gd_cmbMonthly);
		toolkit.paintBordersFor(cmbMonthly);

		ImageHyperlink mghprlnkEditRetentionExpression = toolkit
				.createImageHyperlink(cmpRules, SWT.NONE);
		mghprlnkEditRetentionExpression.setLayoutData(new GridData(SWT.LEFT,
				SWT.CENTER, false, false, 1, 1));
		mghprlnkEditRetentionExpression
				.addHyperlinkListener(new IHyperlinkListener() {
					public void linkActivated(HyperlinkEvent e) {
						launchExpressionScreen(rule);
					}

					public void linkEntered(HyperlinkEvent e) {
					}

					public void linkExited(HyperlinkEvent e) {
					}
				});
		toolkit.paintBordersFor(mghprlnkEditRetentionExpression);
		mghprlnkEditRetentionExpression.setText("Edit retention expression");

		cmbViewerTarget.setContentProvider(new ArrayContentProvider());
		cmbViewerTarget.setLabelProvider(new LabelProvider());
		cmbViewerTarget.setInput(MetricRetentionPeriod.values());

		context.bindValue(selectionProperty.observe(cmbViewerTarget),
				retentionPeriodProperty.observe(rule));

	}

	public void injectData() {
		retentionRulesResource = editingService
				.getData(MetricsPackage.Literals.METRIC_RETENTION_RULES);
		EList<EObject> contents = retentionRulesResource.getContents();
		if (contents.size() == 1) {
			rules = (MetricRetentionRules) contents.get(0);
			buildUI();
			initDataBindings_();
		}
	}

	public void disposeData() {
		editingService.disposeData(retentionRulesResource);
	}

	@Override
	public Viewer getViewer() {
		return null;
	}

	@Override
	public void setOperation(int operation) {
		this.operation = operation;
	}

	@Override
	public boolean isValid() {
		return true;
	}

	@Override
	public Form getScreenForm() {
		return this.frmDataRetention;
	}
}
