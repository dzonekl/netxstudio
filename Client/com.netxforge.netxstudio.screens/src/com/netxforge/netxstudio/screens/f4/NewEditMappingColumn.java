package com.netxforge.netxstudio.screens.f4;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.IEMFValueProperty;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.ReplaceCommand;
import org.eclipse.jface.databinding.swt.ISWTObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormText;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.forms.widgets.Section;

import com.netxforge.netxstudio.metrics.MappingColumn;
import com.netxforge.netxstudio.metrics.MappingXLS;
import com.netxforge.netxstudio.metrics.Metric;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.metrics.ValueDataKind;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.MetricFilterDialog;
import com.netxforge.netxstudio.screens.editing.selector.IDataScreenInjection;
import com.netxforge.netxstudio.screens.editing.selector.Screens;
import com.netxforge.netxstudio.screens.internal.ScreensActivator;

public class NewEditMappingColumn extends AbstractScreen implements
		IDataScreenInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Combo comboTimestampPattern;
	private Text txtIdentifierPattern;
	private Text txtMetricValuePattern;
	private Text txtIndentifier;
	private Text txtMetric;
	private MappingXLS owner;
	private MappingColumn mxlsColumn;
	private MappingColumn original;
	private Text txtColumn;
	private Button btnTimestamp;
	private Button btnIdentifier;
	private Button btnMetricValue;
	private Text txtPeriodPattern;
	private Button btnPeriod;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public NewEditMappingColumn(Composite parent, int style) {
		super(parent,style);
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
		setLayout(new FillLayout(SWT.HORIZONTAL));

		Form frmNewMappingColumn = toolkit.createForm(this);
		frmNewMappingColumn.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmNewMappingColumn);
		frmNewMappingColumn.setText("New Mapping Column");
		frmNewMappingColumn.getBody().setLayout(new FormLayout());

		Section sctnMappings = toolkit.createSection(
				frmNewMappingColumn.getBody(), Section.EXPANDED
						| Section.TITLE_BAR);
		FormData fd_sctnMappings = new FormData();
		fd_sctnMappings.top = new FormAttachment(0, 10);
		fd_sctnMappings.right = new FormAttachment(100, -12);
		fd_sctnMappings.left = new FormAttachment(0, 12);
		sctnMappings.setLayoutData(fd_sctnMappings);
		toolkit.paintBordersFor(sctnMappings);
		sctnMappings.setText("Info");

		Composite composite_1 = toolkit.createComposite(sctnMappings, SWT.NONE);
		toolkit.paintBordersFor(composite_1);
		sctnMappings.setClient(composite_1);
		composite_1.setLayout(new GridLayout(2, false));

		Label lblColumn = toolkit.createLabel(composite_1, "Column:", SWT.NONE);
		lblColumn.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));

		txtColumn = toolkit.createText(composite_1, "New Text", SWT.NONE);
		txtColumn.setText("");
		GridData gd_txtColumn = new GridData(SWT.LEFT, SWT.CENTER, true, false,
				1, 1);
		gd_txtColumn.widthHint = 20;
		txtColumn.setLayoutData(gd_txtColumn);

		Section sctnDataKind = toolkit.createSection(
				frmNewMappingColumn.getBody(), Section.EXPANDED
						| Section.TITLE_BAR);
		fd_sctnMappings.bottom = new FormAttachment(sctnDataKind, -6);
		FormData fd_sctnNewSection = new FormData();
		fd_sctnNewSection.bottom = new FormAttachment(100, -12);
		fd_sctnNewSection.top = new FormAttachment(0, 88);
		fd_sctnNewSection.left = new FormAttachment(0, 12);
		fd_sctnNewSection.right = new FormAttachment(100, -12);
		sctnDataKind.setLayoutData(fd_sctnNewSection);
		toolkit.paintBordersFor(sctnDataKind);
		sctnDataKind.setText("Mapping");
		sctnDataKind.setExpanded(true);

		Composite composite_2 = toolkit.createComposite(sctnDataKind,
				SWT.NONE);
		toolkit.paintBordersFor(composite_2);
		sctnDataKind.setClient(composite_2);
		GridLayout gl_composite_2 = new GridLayout(6, false);
		gl_composite_2.horizontalSpacing = 10;
		composite_2.setLayout(gl_composite_2);

		FormText formText_2 = toolkit.createFormText(composite_2, false);
		formText_2.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 2, 1));
		toolkit.paintBordersFor(formText_2);
		formText_2.setText("<form><p><b>Column Type</b></p></form>", true,
				false);

		FormText formText = toolkit.createFormText(composite_2, false);
		formText.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 2,
				1));
		toolkit.paintBordersFor(formText);
		formText.setText("<form><p><b>Pattern</b></p></form>", true, false);

		FormText formText_1 = toolkit.createFormText(composite_2, false);
		formText_1.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false,
				1, 1));
		toolkit.paintBordersFor(formText_1);
		formText_1.setText("<form><p><b>Object</b></p></form>", true, false);
		new Label(composite_2, SWT.NONE);

		btnTimestamp = toolkit.createButton(composite_2, "Time Stamp",
				SWT.RADIO);
		GridData gd_btnTimeStamp = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 2, 1);
		gd_btnTimeStamp.widthHint = 100;
		btnTimestamp.setLayoutData(gd_btnTimeStamp);

		comboTimestampPattern = new Combo(composite_2, SWT.NONE);
		GridData gd_txtTimestampPattern = new GridData(SWT.LEFT, SWT.CENTER,
				false, false, 1, 1);
		gd_txtTimestampPattern.widthHint = 100;
		comboTimestampPattern.setLayoutData(gd_txtTimestampPattern);
		comboTimestampPattern.setText("");
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);

		btnIdentifier = toolkit.createButton(composite_2, "Identifier",
				SWT.RADIO);
		btnIdentifier.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 2, 1));

		txtIdentifierPattern = toolkit.createText(composite_2, "New Text",
				SWT.NONE);
		txtIdentifierPattern.setText("");

		Hyperlink hprlnkSelectIdentifier = toolkit.createHyperlink(composite_2,
				"Select Identifier", SWT.NONE);
		hprlnkSelectIdentifier.addHyperlinkListener(new IHyperlinkListener() {
			public void linkActivated(HyperlinkEvent e) {
				// TODO Identifier selector. 
				
				
			}
			public void linkEntered(HyperlinkEvent e) {
			}
			public void linkExited(HyperlinkEvent e) {
			}
		});
		toolkit.paintBordersFor(hprlnkSelectIdentifier);

		txtIndentifier = toolkit.createText(composite_2, "New Text", SWT.NONE);
		txtIndentifier.setText("");
		GridData gd_txtIndentifier = new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1);
		gd_txtIndentifier.widthHint = 100;
		txtIndentifier.setLayoutData(gd_txtIndentifier);
		new Label(composite_2, SWT.NONE);

		btnMetricValue = toolkit.createButton(composite_2, "Metric Value",
				SWT.RADIO);
		btnMetricValue.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 2, 1));

		txtMetricValuePattern = toolkit.createText(composite_2, "New Text",
				SWT.NONE);
		txtMetricValuePattern.setLayoutData(new GridData(SWT.LEFT, SWT.TOP,
				false, false, 1, 1));
		txtMetricValuePattern.setText("");

		Hyperlink hprlnkSelectMetric = toolkit.createHyperlink(composite_2,
				"Select Metric", SWT.NONE);
		hprlnkSelectMetric.addHyperlinkListener(new IHyperlinkListener() {
			public void linkActivated(HyperlinkEvent e) {
				
				Resource unitResource = editingService
						.getData(MetricsPackage.Literals.METRIC);
				MetricFilterDialog dialog = new MetricFilterDialog(
						NewEditMappingColumn.this.getShell(), unitResource);

				if (dialog.open() == IDialogConstants.OK_ID) {
				
					Metric metric = (Metric) dialog.getFirstResult();
					if(mxlsColumn.getDataType() instanceof ValueDataKind){
						ValueDataKind vdk = (ValueDataKind)mxlsColumn.getDataType();
						vdk.setMetricRef(metric);
					}
					
				}
			}
			public void linkEntered(HyperlinkEvent e) {
			}
			public void linkExited(HyperlinkEvent e) {
			}
		});
		toolkit.paintBordersFor(hprlnkSelectMetric);

		txtMetric = toolkit.createText(composite_2, "New Text", SWT.NONE);
		txtMetric.setText("");
		txtMetric.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));
		new Label(composite_2, SWT.NONE);

		btnPeriod = toolkit.createButton(composite_2, "Radio", SWT.RADIO);
		btnPeriod.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 2, 1));

		txtPeriodPattern = toolkit.createText(composite_2, "New Text", SWT.NONE);
		txtPeriodPattern.setText("");

		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);

	}

	public EMFDataBindingContext initDataBindings_() {
		EMFDataBindingContext context = new EMFDataBindingContext();

		IObservableValue columnObservable = SWTObservables.observeText(txtColumn);
		IEMFValueProperty columnProperty = EMFProperties.value(MetricsPackage.Literals.MAPPING_COLUMN__COLUMN);
		context.bindValue(columnObservable, columnProperty.observe(mxlsColumn));
		
		IObservableValue dataKindWritableValue = new WritableValue();
		DatakindAggregate aggregate = new DatakindAggregate(
				dataKindWritableValue);

//		dataKindWritableValue.addValueChangeListener(aggregate);

		// final IObservableValue dataKindReturnValue = new WritableValue();

		IObservableValue identifierObservable = SWTObservables
				.observeSelection(btnIdentifier);
		identifierObservable.addValueChangeListener(aggregate);

		IObservableValue timestampObservable = SWTObservables
				.observeSelection(btnTimestamp);
		timestampObservable.addValueChangeListener(aggregate);

		IObservableValue metricvaluepObservable = SWTObservables
				.observeSelection(btnMetricValue);
		metricvaluepObservable.addValueChangeListener(aggregate);

		IObservableValue periodObservable = SWTObservables
				.observeSelection(this.btnPeriod);
		periodObservable.addValueChangeListener(aggregate);

		
		// Pattern fields observables. 
		// TODO, No model entry for pattern. 
		IObservableValue timeStampPatternObservable = SWTObservables
				.observeSelection(this.comboTimestampPattern);
		
		timeStampPatternObservable.addValueChangeListener(aggregate);
		
		IObservableValue identifierPatternObservable = SWTObservables
				.observeText(this.txtIdentifierPattern, SWT.Modify);
		identifierPatternObservable.addValueChangeListener(aggregate);
		
		IObservableValue valuePatternObservable = SWTObservables
				.observeText(this.txtMetricValuePattern, SWT.Modify);
		valuePatternObservable.addValueChangeListener(aggregate);
		
		IObservableValue periodPatternObservable = SWTObservables
				.observeText(this.txtPeriodPattern, SWT.Modify);
		periodPatternObservable.addValueChangeListener(aggregate);
		
		IEMFValueProperty datatypeValueProperty = EMFProperties
				.value(MetricsPackage.Literals.MAPPING_COLUMN__DATA_TYPE);
		
		IObservableValue dataTypeObservable = datatypeValueProperty.observe(mxlsColumn);
		dataTypeObservable.addValueChangeListener(aggregate);
		
		context.bindValue(dataKindWritableValue,
				dataTypeObservable);
		
		// Do the opposite binding. 
		
		IObservableValue btnIdentifierWritableValue = new WritableValue();
		
		context.bindValue(identifierObservable,btnIdentifierWritableValue, null, null);
		

		return context;
	}

	private class DatakindAggregate implements IValueChangeListener, IValidator {

		private IObservableValue dataKindObservable;
		private String pattern; // stores the pattern for the datakind.

		boolean timestamp = false;
		boolean identifier = false;
		boolean value = false;
		boolean period = false;

		DatakindAggregate(IObservableValue dataKindObservable) {
			this.dataKindObservable = dataKindObservable;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.core.databinding.observable.value.IValueChangeListener
		 * #handleValueChange
		 * (org.eclipse.core.databinding.observable.value.ValueChangeEvent)
		 */
		public void handleValueChange(ValueChangeEvent event) {
			System.out.println(event.getObservable());

			Object newValue = event.diff.getNewValue();
			System.out.println("New Value:" + event.diff.getNewValue());

			if (event.getObservable() instanceof ISWTObservableValue) {
				Control control = (Control) ((ISWTObservableValue) event
						.getObservable()).getWidget();
				System.out.println(control);
				if (control.equals(btnIdentifier)) {
					this.identifier = (Boolean) newValue;
				}
				if (control.equals(btnTimestamp)) {
					this.timestamp = (Boolean) newValue;
				}
				if (control.equals(btnMetricValue)) {
					this.value = (Boolean) newValue;
				}
				if (control.equals(btnPeriod)) {
					this.period = (Boolean) newValue;
				}

//				if(cont)
				
			}
			allSet();
		}

		private boolean allSet() {
			
			
			
			
			// Create the DataKindObject, actually only on save.
			System.out.println("I T V P=" + identifier + timestamp + value + period);
			return true;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.core.databinding.validation.IValidator#validate(java.
		 * lang.Object)
		 */
		public IStatus validate(Object value) {

			// Should we care about the value, we use the observable.
			if (allSet()) {
				return Status.OK_STATUS;
			}
			return new Status(IStatus.WARNING, ScreensActivator.PLUGIN_ID,
					"Please enter correct job scheduling data");
		}
	}

	public void disposeData() {
		// N/A

	}
	public void injectData(Object owner, Object object) {
		if (owner instanceof MappingXLS) {
			this.owner = (MappingXLS) owner;
		}
		if (object != null && object instanceof MappingColumn) {
			if (Screens.isEditOperation(this.getOperation())) {
				MappingColumn copy = EcoreUtil
						.copy((MappingColumn) object);
				mxlsColumn = copy;
				original = (MappingColumn) object;
			} else if (Screens.isNewOperation(getOperation())) {
				mxlsColumn = (MappingColumn) object;
			}
		}
		this.initDataBindings_();
	}

	public void addData() {
		if (Screens.isNewOperation(getOperation()) && owner != null) {
			// If new, we have been operating on an object not added yet.
			Command c = new AddCommand(editingService.getEditingDomain(),
					owner.getMappingColumns(), mxlsColumn);
			editingService.getEditingDomain().getCommandStack().execute(c);
		} else if (Screens.isEditOperation(getOperation())) {
			// If edit, we have been operating on a copy of the object, so we
			// have to replace. However if our original object is invalid, this
			// will
			// cause invalidity, so the action will not occure in case the
			// original is
			// invalid, and we should cancel the action and warn the user.
			if (original.cdoInvalid()) {
				MessageDialog
						.openWarning(Display.getDefault().getActiveShell(),
								"Conflict",
								"There is a conflict with another user. Your changes can't be saved.");
				return;
			}

			Command c = new ReplaceCommand(editingService.getEditingDomain(),
					owner.getMappingColumns(), original, mxlsColumn);
			editingService.getEditingDomain().getCommandStack().execute(c);

			System.out.println(mxlsColumn.cdoID() + "" + mxlsColumn.cdoState());

		}
		// After our edit, we shall be dirty
		if (editingService.isDirty()) {
			editingService.doSave(new NullProgressMonitor());
		}

	}

	@Override
	public Viewer getViewer() {
		return null; // N/A
	}

	@Override
	public boolean isValid() {
		return true;
	}

	@Override
	public Form getScreenForm() {
		// TODO Auto-generated method stub
		return null;
	}
}
