package com.netxforge.netxstudio.screens.f4;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.databinding.IEMFValueProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.ColumnLayout;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.wb.swt.ResourceManager;

import com.netxforge.netxstudio.library.Expression;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.Unit;
import com.netxforge.netxstudio.metrics.Metric;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.ExpressionFilterDialog;
import com.netxforge.netxstudio.screens.UnitFilterDialog;
import com.netxforge.netxstudio.screens.editing.selector.IDataScreenInjection;
import com.netxforge.netxstudio.screens.editing.selector.Screens;

public class NewEditMetric extends AbstractScreen implements
		IDataScreenInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Text txtDescription;
	private Text txtName;
	private Text txtUnit;
	private Text txtMeasurementPoint;
	private Text txtMeasurementKind;
	private Form frmNewEditMetric;
	private Resource owner;
	private Metric metric;
	@SuppressWarnings("unused")
	private EMFDataBindingContext m_bindingContext;
	private Metric subowner;
	private Text txtMetricExpression;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public NewEditMetric(Composite parent, int style) {
		super(parent, style);
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
		// buildUI();
	}

	private void buildUI() {
		setLayout(new FillLayout(SWT.HORIZONTAL));

		frmNewEditMetric = toolkit.createForm(this);
		frmNewEditMetric.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmNewEditMetric);

		String title = Screens.isNewOperation(getOperation()) ? "New: "
				: "Edit: ";

		frmNewEditMetric.setText(title + "Metric");
		ColumnLayout columnLayout = new ColumnLayout();
		columnLayout.maxNumColumns = 1;
		frmNewEditMetric.getBody().setLayout(columnLayout);

		Section sctnMappings = toolkit.createSection(
				frmNewEditMetric.getBody(), Section.EXPANDED
						| Section.TITLE_BAR);
//		FormData fd_sctnMappings = new FormData();
//		fd_sctnMappings.bottom = new FormAttachment(100, -10);
//		fd_sctnMappings.left = new FormAttachment(0, 10);
//		fd_sctnMappings.top = new FormAttachment(0, 10);
//		fd_sctnMappings.right = new FormAttachment(100, -14);
//		sctnMappings.setLayoutData(fd_sctnMappings);
		toolkit.paintBordersFor(sctnMappings);
		sctnMappings.setText("Info");

		Composite composite_1 = toolkit.createComposite(sctnMappings, SWT.NONE);
		toolkit.paintBordersFor(composite_1);
		sctnMappings.setClient(composite_1);
		composite_1.setLayout(new GridLayout(4, false));

		Label lblName = toolkit.createLabel(composite_1, "Name:", SWT.NONE);
		lblName.setAlignment(SWT.RIGHT);
		GridData gd_lblName = new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1);
		gd_lblName.widthHint = 83;
		lblName.setLayoutData(gd_lblName);

		txtName = toolkit.createText(composite_1, "New Text", SWT.NONE);
		txtName.setText("");
		GridData gd_txtName = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				3, 1);
		gd_txtName.widthHint = 150;
		txtName.setLayoutData(gd_txtName);

		Label lblDescription = toolkit.createLabel(composite_1, "Description:",
				SWT.NONE);
		lblDescription.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false,
				false, 1, 1));

		txtDescription = toolkit.createText(composite_1, "New Text", SWT.WRAP
				| SWT.MULTI);
		txtDescription.setText("");
		GridData gd_txtDescription = new GridData(SWT.FILL, SWT.CENTER, true,
				false, 3, 1);
		gd_txtDescription.heightHint = 57;
		txtDescription.setLayoutData(gd_txtDescription);

		Label lblNewLabel_1 = toolkit.createLabel(composite_1, "Unit:",
				SWT.NONE);
		lblNewLabel_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));

		txtUnit = toolkit.createText(composite_1, "New Text", SWT.READ_ONLY);
		txtUnit.setText("");
		GridData gd_txtUnit = new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1);
//		gd_txtUnit.widthHint = 50;
		txtUnit.setLayoutData(gd_txtUnit);

		ImageHyperlink imageHyperlink_1 = toolkit.createImageHyperlink(
				composite_1, SWT.NONE);
		imageHyperlink_1.addHyperlinkListener(new IHyperlinkListener() {
			public void linkActivated(HyperlinkEvent e) {
				if (metric.getUnitRef() != null) {
					Command c = new SetCommand(editingService
							.getEditingDomain(), metric,
							MetricsPackage.Literals.METRIC__UNIT_REF, null);
					editingService.getEditingDomain().getCommandStack()
							.execute(c);
				}
			}

			public void linkEntered(HyperlinkEvent e) {
			}

			public void linkExited(HyperlinkEvent e) {
			}
		});
		GridData gd_imageHyperlink_1 = new GridData(SWT.LEFT, SWT.CENTER,
				false, false, 1, 1);
		gd_imageHyperlink_1.widthHint = 18;
		imageHyperlink_1.setLayoutData(gd_imageHyperlink_1);
		imageHyperlink_1.setImage(ResourceManager.getPluginImage(
				"org.eclipse.ui", "/icons/full/etool16/delete.gif"));
		toolkit.paintBordersFor(imageHyperlink_1);
		imageHyperlink_1.setText("");

		Button btnSelect = toolkit.createButton(composite_1, "Select...",
				SWT.NONE);
		btnSelect.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Resource unitResource = editingService
						.getData(LibraryPackage.Literals.UNIT);
				UnitFilterDialog dialog = new UnitFilterDialog(
						NewEditMetric.this.getShell(), unitResource);
				if (dialog.open() == IDialogConstants.OK_ID) {
					Unit u = (Unit) dialog.getFirstResult();
					metric.setUnitRef(u); // Should now show with databinding.
				}
			}
		});
		
		
		Section sctnMore = toolkit.createSection(
				frmNewEditMetric.getBody(), Section.EXPANDED
						| Section.TITLE_BAR | Section.TWISTIE);
//		FormData fd_sctnMappings = new FormData();
//		fd_sctnMappings.bottom = new FormAttachment(100, -10);
//		fd_sctnMappings.left = new FormAttachment(0, 10);
//		fd_sctnMappings.top = new FormAttachment(0, 10);
//		fd_sctnMappings.right = new FormAttachment(100, -14);
//		sctnMappings.setLayoutData(fd_sctnMappings);
		toolkit.paintBordersFor(sctnMore);
		sctnMore.setText("More");

//		ExpandableComposite xpndblcmpstMore = toolkit
//				.createExpandableComposite(frmNewEditMetric.getBody(),
//						ExpandableComposite.TWISTIE);
//		xpndblcmpstMore.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
//				true, 4, 1));
//		toolkit.paintBordersFor(xpndblcmpstMore);
//		xpndblcmpstMore.setText("more...");
		sctnMore.setExpanded(false);

		Composite composite_3 = toolkit.createComposite(sctnMore,
				SWT.NONE);
		toolkit.paintBordersFor(composite_3);
		sctnMore.setClient(composite_3);
		composite_3.setLayout(new GridLayout(4, false));

		Label lblMeasurementPoint = toolkit.createLabel(composite_3,
				"Measurement Point:", SWT.WRAP);
		GridData gd_lblMeasurementPoint = new GridData(SWT.LEFT, SWT.TOP,
				false, false, 1, 1);
		gd_lblMeasurementPoint.widthHint = 78;
		lblMeasurementPoint.setLayoutData(gd_lblMeasurementPoint);

		txtMeasurementPoint = toolkit.createText(composite_3, "New Text",
				SWT.WRAP | SWT.MULTI);
		GridData gd_txtMeasurementPoint = new GridData(SWT.FILL, SWT.FILL,
				true, false, 3, 1);
		gd_txtMeasurementPoint.heightHint = 70;
		txtMeasurementPoint.setLayoutData(gd_txtMeasurementPoint);
		txtMeasurementPoint.setText("");

		Label lblMeasurementKind = toolkit.createLabel(composite_3,
				"Measurement Kind:", SWT.WRAP);
		GridData gd_lblMeasurementKind = new GridData(SWT.RIGHT, SWT.TOP,
				false, false, 1, 1);
		gd_lblMeasurementKind.widthHint = 78;
		lblMeasurementKind.setLayoutData(gd_lblMeasurementKind);

		txtMeasurementKind = toolkit.createText(composite_3, "New Text",
				SWT.WRAP | SWT.MULTI);
		txtMeasurementKind.setText("");
		GridData gd_measurementKind = new GridData(SWT.FILL, SWT.FILL, true,
				false, 3, 1);
		gd_measurementKind.heightHint = 70;
		txtMeasurementKind.setLayoutData(gd_measurementKind);

		Label lblExpression = toolkit.createLabel(composite_3, "Expression:",
				SWT.NONE);
		lblExpression.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false,
				false, 1, 1));

		txtMetricExpression = toolkit.createText(composite_3, "New Text",
				SWT.READ_ONLY);
		GridData gd_txtMetricExpression = new GridData(SWT.FILL, SWT.CENTER,
				true, false, 1, 1);
		txtMetricExpression.setLayoutData(gd_txtMetricExpression);
		txtMetricExpression.setText("");

		ImageHyperlink imageHyperlink = toolkit.createImageHyperlink(
				composite_3, SWT.NONE);
		imageHyperlink.addHyperlinkListener(new IHyperlinkListener() {
			public void linkActivated(HyperlinkEvent e) {
				if (metric.getExpressionRef() != null) {
					Command c = new SetCommand(editingService
							.getEditingDomain(), metric,
							MetricsPackage.Literals.METRIC__EXPRESSION_REF,
							null);
					editingService.getEditingDomain().getCommandStack()
							.execute(c);
				}

			}

			public void linkEntered(HyperlinkEvent e) {
			}

			public void linkExited(HyperlinkEvent e) {
			}
		});
		GridData gd_imageHyperlink = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_imageHyperlink.widthHint = 18;
		imageHyperlink.setLayoutData(gd_imageHyperlink);
		imageHyperlink.setImage(ResourceManager.getPluginImage(
				"org.eclipse.ui", "/icons/full/etool16/delete.gif"));
		toolkit.paintBordersFor(imageHyperlink);
		imageHyperlink.setText("");

		Button btnSelect_1 = toolkit.createButton(composite_3, "Select...",
				SWT.NONE);
		btnSelect_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Resource expressionResource = editingService
						.getData(LibraryPackage.Literals.EXPRESSION);
				ExpressionFilterDialog dialog = new ExpressionFilterDialog(
						NewEditMetric.this.getShell(), expressionResource);
				if (dialog.open() == IDialogConstants.OK_ID) {
					Expression expression = (Expression) dialog
							.getFirstResult();
					Command c = new SetCommand(editingService
							.getEditingDomain(), metric,
							MetricsPackage.Literals.METRIC__EXPRESSION_REF,
							expression);
					editingService.getEditingDomain().getCommandStack()
							.execute(c);
				}
			}
		});
	}

	public EMFDataBindingContext initDataBindings_() {
		EMFDataBindingContext context = new EMFDataBindingContext();

		IObservableValue nameObservable = SWTObservables.observeText(txtName,
				SWT.Modify);
		IObservableValue descriptionObservable = SWTObservables.observeText(
				txtDescription, SWT.Modify);
		IObservableValue unitObservable = SWTObservables.observeText(txtUnit,
				SWT.Modify);
		IObservableValue measurementPointObservable = SWTObservables
				.observeText(txtMeasurementPoint, SWT.Modify);
		IObservableValue measurementKindObservable = SWTObservables
				.observeText(txtMeasurementKind, SWT.Modify);
		IObservableValue expressionObservable = SWTObservables.observeText(
				txtMetricExpression, SWT.Modify);

		IEMFValueProperty nameProperty = EMFEditProperties.value(
				editingService.getEditingDomain(),
				MetricsPackage.Literals.METRIC__NAME);
		IEMFValueProperty descriptionProperty = EMFEditProperties.value(
				editingService.getEditingDomain(),
				MetricsPackage.Literals.METRIC__DESCRIPTION);
		IEMFValueProperty unitProperty = EMFEditProperties.value(editingService.getEditingDomain(), FeaturePath
				.fromList(MetricsPackage.Literals.METRIC__UNIT_REF,
						LibraryPackage.Literals.UNIT__NAME));

		IEMFValueProperty measurementPointProperty = EMFEditProperties.value(
				editingService.getEditingDomain(),
				MetricsPackage.Literals.METRIC__MEASUREMENT_POINT);
		IEMFValueProperty measurementKindProperty = EMFEditProperties.value(
				editingService.getEditingDomain(),
				MetricsPackage.Literals.METRIC__MEASUREMENT_KIND);

		IEMFValueProperty expressionProperty = EMFProperties.value(FeaturePath
				.fromList(MetricsPackage.Literals.METRIC__EXPRESSION_REF,
						LibraryPackage.Literals.EXPRESSION__NAME));

		context.bindValue(nameObservable, nameProperty.observe(metric), null,
				null);
		context.bindValue(descriptionObservable,
				descriptionProperty.observe(metric), null, null);
		context.bindValue(unitObservable, unitProperty.observe(metric), null,
				null);
		context.bindValue(measurementPointObservable,
				measurementPointProperty.observe(metric), null, null);
		context.bindValue(measurementKindObservable,
				measurementKindProperty.observe(metric), null, null);
		context.bindValue(expressionObservable,
				expressionProperty.observe(metric), null, null);

		return context;
	}

	public void injectData(Object owner, Object subowner, Object object) {
		if (subowner != null && subowner instanceof Metric) {
			this.subowner = (Metric) subowner;
		}
		injectData(owner, object);
	}

	public void injectData(Object owner, Object object) {
		if (owner instanceof Resource) {
			this.owner = (Resource) owner;
		} else {
			// We need the right type of object for this screen.
			throw new java.lang.IllegalArgumentException();
		}
		if (object != null && object instanceof Metric) {
			metric = (Metric) object;
		} else {
			// We need the right type of object for this screen.
			throw new java.lang.IllegalArgumentException();
		}

		buildUI();
		m_bindingContext = initDataBindings_();
	}

	public void addData() {
		if (Screens.isNewOperation(getOperation()) && owner != null) {
			// If new, we have been operating on an object not added yet.
			Command c;
			if (subowner != null) {
				c = new AddCommand(editingService.getEditingDomain(),
						subowner.getMetrics(), metric);
			} else {
				c = new AddCommand(editingService.getEditingDomain(),
						owner.getContents(), metric);
			}

			editingService.getEditingDomain().getCommandStack().execute(c);
		} else if (Screens.isEditOperation(getOperation())) {
			// If edit, we have been operating on a copy of the object, so we
			// have to replace. However if our original object is invalid, this
			// will
			// cause invalidity, so the action will not occure in case the
			// original is
			// invalid, and we should cancel the action and warn the user.
			if (metric.cdoInvalid()) {
				MessageDialog
						.openWarning(Display.getDefault().getActiveShell(),
								"Conflict",
								"There is a conflict with another user. Your changes can't be saved.");
				return;
			}
			System.out.println(metric.cdoID() + "" + metric.cdoState());

		}
		// After our edit, we shall be dirty
		if (editingService.isDirty()) {
			editingService.doSave(new NullProgressMonitor());
		}

	}

	@Override
	public Viewer getViewer() {
		return null;
	}

	@Override
	public boolean isValid() {
		// TODO, Validation
		return true;
	}

	@Override
	public Form getScreenForm() {
		return frmNewEditMetric;
	}

	public void disposeData() {
		// N/A
	}

	@Override
	public void setOperation(int operation) {
		this.operation = operation;
	}
	
	public String getScreenName() {
		return "Metric";
	}

}
