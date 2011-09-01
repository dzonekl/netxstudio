package com.netxforge.netxstudio.screens.f4;

import java.util.List;

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.EMFUpdateValueStrategy;
import org.eclipse.emf.databinding.IEMFValueProperty;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.AddCommand;
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

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.netxforge.netxstudio.metrics.DataKind;
import com.netxforge.netxstudio.metrics.IdentifierDataKind;
import com.netxforge.netxstudio.metrics.MappingColumn;
import com.netxforge.netxstudio.metrics.Metric;
import com.netxforge.netxstudio.metrics.MetricsFactory;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.metrics.ObjectKindType;
import com.netxforge.netxstudio.metrics.ValueDataKind;
import com.netxforge.netxstudio.metrics.ValueKindType;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.MetricFilterDialog;
import com.netxforge.netxstudio.screens.editing.selector.IDataScreenInjection;
import com.netxforge.netxstudio.screens.editing.selector.Screens;
import com.netxforge.netxstudio.screens.f4.support.IdentifierDialog;
import com.netxforge.netxstudio.screens.internal.ScreensActivator;

public class NewEditMappingColumn extends AbstractScreen implements
		IDataScreenInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Combo cmbDatePattern;
	private Text txtIdentifierPattern;
	private Text txtMetricValuePattern;
	private Text txtObject;
	private Text txtMetric;
	private EList<?> owner;
	private MappingColumn mxlsColumn;
	private Text txtColumn;
	private Button btnDate;
	private Button btnIdentifier;
	private Button btnMetricValue;
//	private Text txtIntervalPattern;
	private Button btnInterval;
	private WritableValue btnIdentifierWritableValue;
	private WritableValue btnDateWritableValue;
	private WritableValue btnMetricWritableValue;
	private WritableValue btnIntervalWritableValue;
	private Combo cmbTimePattern;
	private Combo cmbDateTimePattern;
	private Button btnTime;
	private Button btnDatetime;
	private WritableValue btnDateTimeWritableValue;
	private WritableValue btnTimeWritableValue;
	private Text txtObjectAttribute;
	private EMFDataBindingContext context;
	private boolean showDataMapping;
	private Form frmNewMappingColumn;
	private Composite cmpColumnMapping;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public NewEditMappingColumn(Composite parent, int style) {
		super(parent, style);
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
//		buildUI();
	}

	private void buildUI() {
		setLayout(new FillLayout(SWT.HORIZONTAL));

		// New or Edit.
		boolean edit = Screens.isEditOperation(getOperation());
		String actionText = edit ? "Edit: " : "New: ";
		
		frmNewMappingColumn = toolkit.createForm(this);
		frmNewMappingColumn.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmNewMappingColumn);
		
		
		frmNewMappingColumn.setText(actionText + "Mapping Column");
		
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

		cmpColumnMapping = toolkit.createComposite(sctnDataKind, SWT.NONE);
		toolkit.paintBordersFor(cmpColumnMapping);
		sctnDataKind.setClient(cmpColumnMapping);
		GridLayout gl_composite_2 = new GridLayout(6, false);
		gl_composite_2.horizontalSpacing = 10;
		cmpColumnMapping.setLayout(gl_composite_2);

		FormText formText_2 = toolkit.createFormText(cmpColumnMapping, false);
		formText_2.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 2, 1));
		toolkit.paintBordersFor(formText_2);
		formText_2.setText("<form><p><b>Column Type</b></p></form>", true,
				false);

		FormText formText = toolkit.createFormText(cmpColumnMapping, false);
		formText.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 2,
				1));
		toolkit.paintBordersFor(formText);
		formText.setText("<form><p><b>Pattern</b></p></form>", true, false);

		FormText formText_1 = toolkit.createFormText(cmpColumnMapping, false);
		formText_1.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false,
				1, 1));
		toolkit.paintBordersFor(formText_1);
		formText_1.setText("<form><p><b>Object</b></p></form>", true, false);
		new Label(cmpColumnMapping, SWT.NONE);
	}

	private void buildDataMappingOptions(Composite cmpColumnMapping) {
		btnMetricValue = toolkit.createButton(cmpColumnMapping, "Metric Value",
				SWT.RADIO);
		new Label(cmpColumnMapping, SWT.NONE);

		txtMetricValuePattern = toolkit.createText(cmpColumnMapping,
				"New Text", SWT.NONE);
		txtMetricValuePattern.setLayoutData(new GridData(SWT.LEFT, SWT.TOP,
				false, false, 1, 1));
		txtMetricValuePattern.setText("");

		Hyperlink hprlnkSelectMetric = toolkit.createHyperlink(
				cmpColumnMapping, "Select Metric", SWT.NONE);
		hprlnkSelectMetric.addHyperlinkListener(new IHyperlinkListener() {
			public void linkActivated(HyperlinkEvent e) {

				Resource unitResource = editingService
						.getData(MetricsPackage.Literals.METRIC);
				MetricFilterDialog dialog = new MetricFilterDialog(
						NewEditMappingColumn.this.getShell(), unitResource);
				if (dialog.open() == IDialogConstants.OK_ID) {
					Metric metric = (Metric) dialog.getFirstResult();
					if (mxlsColumn.getDataType() instanceof ValueDataKind) {
						ValueDataKind vdk = (ValueDataKind) mxlsColumn
								.getDataType();
						vdk.setMetricRef(metric);
						context.updateTargets();
					}
				}
			}

			public void linkEntered(HyperlinkEvent e) {
			}

			public void linkExited(HyperlinkEvent e) {
			}
		});
		toolkit.paintBordersFor(hprlnkSelectMetric);

		txtMetric = toolkit.createText(cmpColumnMapping, "New Text", SWT.NONE);
		txtMetric.setText("");
		txtMetric.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));
		new Label(cmpColumnMapping, SWT.NONE);

	}

	private void buildHeaderMappingOptions(Composite parent) {
		btnDatetime = new Button(parent, SWT.RADIO);
		toolkit.adapt(btnDatetime, true, true);
		btnDatetime.setText("Date/Time");
		new Label(parent, SWT.NONE);

		cmbDateTimePattern = new Combo(parent, SWT.NONE);
		GridData gd_cmbDateTimePattern = new GridData(SWT.LEFT, SWT.CENTER,
				false, false, 1, 1);
		gd_cmbDateTimePattern.widthHint = 100;
		cmbDateTimePattern.setLayoutData(gd_cmbDateTimePattern);
		toolkit.adapt(cmbDateTimePattern);
		toolkit.paintBordersFor(cmbDateTimePattern);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);

		btnDate = toolkit.createButton(parent, "Date", SWT.RADIO);
		GridData gd_btnDate = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_btnDate.widthHint = 100;
		btnDate.setLayoutData(gd_btnDate);
		new Label(parent, SWT.NONE);

		cmbDatePattern = new Combo(parent, SWT.NONE);
		GridData gd_cmbDatePattern = new GridData(SWT.CENTER, SWT.CENTER,
				false, false, 1, 1);
		gd_cmbDatePattern.widthHint = 100;
		cmbDatePattern.setLayoutData(gd_cmbDatePattern);
		cmbDatePattern.setText("");
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);

		btnTime = toolkit.createButton(parent, "", SWT.RADIO);
		toolkit.adapt(btnTime, true, true);
		btnTime.setText("Time");
		new Label(parent, SWT.NONE);

		cmbTimePattern = new Combo(parent, SWT.NONE);
		GridData gd_cmbTimePattern = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_cmbTimePattern.widthHint = 100;
		cmbTimePattern.setLayoutData(gd_cmbTimePattern);
		toolkit.adapt(cmbTimePattern);
		toolkit.paintBordersFor(cmbTimePattern);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);

		btnIdentifier = toolkit.createButton(parent, "Identifier", SWT.RADIO);
		new Label(parent, SWT.NONE);

		txtIdentifierPattern = toolkit.createText(parent, "New Text", SWT.NONE);
		txtIdentifierPattern.setText("");

		Hyperlink hprlnkSelectIdentifier = toolkit.createHyperlink(parent,
				"Select Identifier", SWT.NONE);
		hprlnkSelectIdentifier.addHyperlinkListener(new IHyperlinkListener() {
			public void linkActivated(HyperlinkEvent e) {
				IdentifierDialog id = new IdentifierDialog(
						NewEditMappingColumn.this.getShell());
				if (id.open() == IDialogConstants.OK_ID) {

					if (mxlsColumn.getDataType() instanceof IdentifierDataKind) {
						IdentifierDataKind idk = (IdentifierDataKind) mxlsColumn
								.getDataType();
						int v = id.getObjectKind();
						idk.setObjectKind(ObjectKindType.get(v));
						idk.setObjectProperty(id.getObjectAttribute());
						context.updateTargets();
					}
				}
			}

			public void linkEntered(HyperlinkEvent e) {
			}

			public void linkExited(HyperlinkEvent e) {
			}
		});
		toolkit.paintBordersFor(hprlnkSelectIdentifier);

		txtObject = toolkit.createText(parent, "New Text", SWT.BORDER);
		txtObject.setText("");
		GridData gd_txtIndentifier = new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1);
		gd_txtIndentifier.widthHint = 100;
		txtObject.setLayoutData(gd_txtIndentifier);

		txtObjectAttribute = toolkit.createText(parent, "", SWT.BORDER);
		GridData gd_txtObjectAttribute = new GridData(SWT.LEFT, SWT.CENTER,
				false, false, 1, 1);
		gd_txtObjectAttribute.widthHint = 100;
		txtObjectAttribute.setLayoutData(gd_txtObjectAttribute);
		toolkit.adapt(txtObjectAttribute, true, true);
		
		btnInterval = toolkit.createButton(cmpColumnMapping, "Interval",
				SWT.RADIO);
		new Label(cmpColumnMapping, SWT.NONE);

//		txtIntervalPattern = toolkit.createText(cmpColumnMapping, "New Text",
//				SWT.NONE);
//		txtIntervalPattern.setText("");
		
		new Label(cmpColumnMapping, SWT.NONE);
		new Label(cmpColumnMapping, SWT.NONE);
		new Label(cmpColumnMapping, SWT.NONE);
		
		
	}

	// Simpleformat patterns:

	// Letter Date or Time Component Presentation Examples
	// G Era designator Text AD
	// y Year Year 1996; 96
	// M Month in year Month July; Jul; 07
	// w Week in year Number 27
	// W Week in month Number 2
	// D Day in year Number 189
	// d Day in month Number 10
	// F Day of week in month Number 2
	// E Day in week Text Tuesday; Tue
	// a Am/pm marker Text PM
	// H Hour in day (0-23) Number 0
	// k Hour in day (1-24) Number 24
	// K Hour in am/pm (0-11) Number 0
	// h Hour in am/pm (1-12) Number 12
	// m Minute in hour Number 30
	// s Second in minute Number 55
	// S Millisecond Number 978
	// z Time zone General time zone Pacific Standard Time; PST; GMT-08:00
	// Z Time zone RFC 822 time zone -0800
	private void populatePatterns() {
		List<String> datePatterns = ImmutableList
				.of("dd/MM/yyyy", "dd-MM-yyyy");
		List<String> timePatterns = ImmutableList.of("HH:mm:ss", "HH:mm", "kk");
		List<String> dateTimePatterns = Lists.newArrayList();
		dateTimePatterns.addAll(datePatterns);
		dateTimePatterns.addAll(timePatterns);
		for (String string : datePatterns) {
			cmbDatePattern.add(string);
		}

		for (String string : timePatterns) {
			cmbTimePattern.add(string);
		}
	}

	public EMFDataBindingContext initDataBindings_() {
		EMFDataBindingContext context = new EMFDataBindingContext();

		IObservableValue columnObservable = SWTObservables.observeText(
				txtColumn, SWT.Modify);
		IEMFValueProperty columnProperty = EMFProperties
				.value(MetricsPackage.Literals.MAPPING_COLUMN__COLUMN);
		context.bindValue(columnObservable, columnProperty.observe(mxlsColumn));

		// ///////////////////////////////////////////////////////////
		// AGGREGATOR
		// ///////////////////////////////////////////////////////////
		IObservableValue dataKindWritableValue = new WritableValue();
		DatakindAggregate aggregate = new DatakindAggregate(
				dataKindWritableValue);

		IEMFValueProperty dataKindProperty = EMFProperties
				.value(MetricsPackage.Literals.MAPPING_COLUMN__DATA_TYPE);

		initDataBindingHeaderMappingColumn(context, aggregate, dataKindProperty);
		if (showDataMapping) {
			initDataBindingDataMappingColumn(context, aggregate,
					dataKindProperty);
		}

		IObservableValue dataKindObservable = dataKindProperty
				.observe(mxlsColumn);

		setInitialHeaderMapping(dataKindObservable.getValue());
		if (showDataMapping) {
			setInitialDataMapping(dataKindObservable.getValue());
		}

		context.bindValue(dataKindWritableValue, dataKindObservable);
		context.updateTargets();

		return context;
	}

	/*
	 * bind the part of the UI which deals with header mapping.
	 */
	private void initDataBindingHeaderMappingColumn(
			EMFDataBindingContext context, DatakindAggregate aggregate,
			IEMFValueProperty dataKindProperty) {
		// ///////////////////////////
		// WRITABLE OBSERVABLES
		// ///////////////////////////

		btnIdentifierWritableValue = new WritableValue();
		btnDateTimeWritableValue = new WritableValue();
		btnDateWritableValue = new WritableValue();
		btnTimeWritableValue = new WritableValue();
		btnIntervalWritableValue = new WritableValue();

		// ///////////////////////////
		// AGGREGATED WIDGETS.
		// ///////////////////////////

		IObservableValue identifierObservable = SWTObservables
				.observeSelection(btnIdentifier);
		identifierObservable.addValueChangeListener(aggregate);

		IObservableValue dateTimeObservable = SWTObservables
				.observeSelection(btnDatetime);
		dateTimeObservable.addValueChangeListener(aggregate);

		IObservableValue dateObservable = SWTObservables
				.observeSelection(btnDate);
		dateObservable.addValueChangeListener(aggregate);

		IObservableValue timeObservable = SWTObservables
				.observeSelection(btnTime);
		timeObservable.addValueChangeListener(aggregate);

		IObservableValue intervalObservable = SWTObservables
				.observeSelection(this.btnInterval);
		intervalObservable.addValueChangeListener(aggregate);

		// ///////////////////////////
		// REGULAR WIDGETS.
		// ///////////////////////////

		IObservableValue objectAttributeObservable = SWTObservables
				.observeText(this.txtObjectAttribute, SWT.Modify);
		IObservableValue objectObservable = SWTObservables.observeText(
				this.txtObject, SWT.Modify);

		// ///////////////////////////
		// PATTERN FIELD OBSERVABLES
		// ///////////////////////////
		IObservableValue dateTimePatternObservable = SWTObservables
				.observeText(this.cmbDateTimePattern);
		dateTimePatternObservable.addValueChangeListener(aggregate);

		IObservableValue datePatternObservable = SWTObservables
				.observeText(this.cmbDatePattern);
		datePatternObservable.addValueChangeListener(aggregate);

		IObservableValue timePatternObservable = SWTObservables
				.observeText(this.cmbTimePattern);
		timePatternObservable.addValueChangeListener(aggregate);

		IObservableValue identifierPatternObservable = SWTObservables
				.observeText(this.txtIdentifierPattern, SWT.Modify);
		identifierPatternObservable.addValueChangeListener(aggregate);

//		IObservableValue periodPatternObservable = SWTObservables.observeText(
//				this.txtIntervalPattern, SWT.Modify);
//		
//		periodPatternObservable.addValueChangeListener(aggregate);

		// ///////////////////////////
		// STRATEGIES
		// ///////////////////////////

		EMFUpdateValueStrategy objectAttributeStrategy = new EMFUpdateValueStrategy();
		objectAttributeStrategy
				.setConverter(new DataKindModelToTargetConverter() {
					public Object convert(Object fromObject) {
						if (fromObject instanceof IdentifierDataKind) {
							return ((IdentifierDataKind) fromObject)
									.getObjectProperty();
						}
						return null;
					}
				});

		EMFUpdateValueStrategy objectStrategy = new EMFUpdateValueStrategy();
		objectStrategy.setConverter(new DataKindModelToTargetConverter() {
			public Object convert(Object fromObject) {
				if (fromObject instanceof IdentifierDataKind) {
					return ((IdentifierDataKind) fromObject).getObjectKind()
							.getName();
				}
				return null;
			}
		});

		context.bindValue(objectAttributeObservable,
				dataKindProperty.observe(mxlsColumn), null,
				objectAttributeStrategy);

		context.bindValue(objectObservable,
				dataKindProperty.observe(mxlsColumn), null, objectStrategy);
		// Do the opposite binding.
		context.bindValue(identifierObservable, btnIdentifierWritableValue,
				null, null);
		context.bindValue(dateTimeObservable, btnDateTimeWritableValue, null,
				null);

		context.bindValue(dateObservable, btnDateWritableValue, null, null);
		context.bindValue(timeObservable, btnTimeWritableValue, null, null);

		context.bindValue(intervalObservable, btnIntervalWritableValue, null,
				null);
	}

	/*
	 * bind the part of the UI which deals with data mapping.
	 */
	private void initDataBindingDataMappingColumn(
			EMFDataBindingContext context, DatakindAggregate aggregate,
			IEMFValueProperty dataKindProperty) {

		btnMetricWritableValue = new WritableValue();

		IObservableValue metricObservable = SWTObservables
				.observeSelection(btnMetricValue);
		metricObservable.addValueChangeListener(aggregate);

		IObservableValue metricValueObservable = SWTObservables.observeText(
				txtMetric, SWT.Modify);

		IObservableValue valuePatternObservable = SWTObservables.observeText(
				this.txtMetricValuePattern, SWT.Modify);
		valuePatternObservable.addValueChangeListener(aggregate);

		EMFUpdateValueStrategy metricModelToTargetStrategy = new EMFUpdateValueStrategy();
		metricModelToTargetStrategy
				.setConverter(new DataKindModelToTargetConverter() {
					public Object convert(Object fromObject) {
						if (fromObject instanceof ValueDataKind) {
							Metric metric = ((ValueDataKind) fromObject)
									.getMetricRef();
							if (metric != null) {
								return metric.getName();
							}
						}
						return null;
					}
				});
		context.bindValue(metricValueObservable,
				dataKindProperty.observe(mxlsColumn), null,
				metricModelToTargetStrategy);
		context.bindValue(metricObservable, btnMetricWritableValue, null, null);
	}

	abstract class DataKindModelToTargetConverter implements IConverter {
		public Object getFromType() {
			return DataKind.class;
		}

		public Object getToType() {
			return String.class;
		}
	}

	abstract class DataKindTargetToModelConverter implements IConverter {
		public Object getFromType() {
			return String.class;
		}

		public Object getToType() {
			return DataKind.class;
		}
	}

	private void setInitialHeaderMapping(Object value) {
		if (value instanceof ValueDataKind) {
			ValueDataKind vdk = (ValueDataKind) value;
			ValueKindType vkt = vdk.getValueKind();
			if (vkt == ValueKindType.INTERVAL) {
				btnIntervalWritableValue.setValue(true);
				// TODO, Remove later no pattern for interval. 
//				if (vdk.getFormat() != null) {
//					txtIntervalPattern.setText(vdk.getFormat());
//				}
			}
			if (vkt == ValueKindType.DATETIME) {
				btnDateTimeWritableValue.setValue(true);
				if (vdk.getFormat() != null) {
					cmbDateTimePattern.setText(vdk.getFormat());
				}
			}
			if (vkt == ValueKindType.DATE) {
				btnDateWritableValue.setValue(true);
				if (vdk.getFormat() != null) {
					cmbDatePattern.setText(vdk.getFormat());
				}
			}
			if (vkt == ValueKindType.TIME) {
				btnTimeWritableValue.setValue(true);
				if (vdk.getFormat() != null) {
					cmbTimePattern.setText(vdk.getFormat());
				}
			}
			if (vkt == ValueKindType.METRIC) {
				this.btnMetricWritableValue.setValue(true);
				if (vdk.getFormat() != null) {
					this.txtMetricValuePattern.setText(vdk.getFormat());
				}
			}
		}
		if (value instanceof IdentifierDataKind) {
			this.btnIdentifierWritableValue.setValue(true);
			IdentifierDataKind idk = (IdentifierDataKind) value;
			if (idk.getPattern() != null) {
				this.txtIdentifierPattern.setText(idk.getPattern());
			}
		}
	}

	private void setInitialDataMapping(Object value) {
		if (value instanceof ValueDataKind) {
			ValueDataKind vdk = (ValueDataKind) value;
			ValueKindType vkt = vdk.getValueKind();

			if (vkt == ValueKindType.METRIC) {
				this.btnMetricWritableValue.setValue(true);
				if (vdk.getFormat() != null) {
					this.txtMetricValuePattern.setText(vdk.getFormat());
				}
			}
		}
	}

	private class DatakindAggregate implements IValueChangeListener, IValidator {

		private IObservableValue dataKindObservable;

		private String pattern; // stores the pattern for the datakind.

		boolean datetime = false;
		boolean date = false;
		boolean time = false;
		boolean identifier = false;
		boolean value = false;
		boolean interval = false;

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
			System.out.println(event.getSource());
			Object newValue = event.diff.getNewValue();

			System.out.println("New Value:" + event.diff.getNewValue());

			if (event.getObservable() instanceof ISWTObservableValue) {
				Control control = (Control) ((ISWTObservableValue) event
						.getObservable()).getWidget();
				System.out.println(control);
				if (control.equals(btnIdentifier)) {
					this.identifier = (Boolean) newValue;
					modelUpdate();
				}
				if (control.equals(btnDatetime)) {
					this.datetime = (Boolean) newValue;
					modelUpdate();
				}
				if (control.equals(btnDate)) {
					this.date = (Boolean) newValue;
					modelUpdate();
				}
				if (control.equals(btnTime)) {
					this.time = (Boolean) newValue;
					modelUpdate();
				}

				if (btnMetricValue != null & control.equals(btnMetricValue)) {
					this.value = (Boolean) newValue;
					modelUpdate();
				}
				if (control.equals(btnInterval)) {
					this.interval = (Boolean) newValue;
					modelUpdate();
				}
				if (control.equals(cmbDatePattern)
						|| control.equals(cmbDateTimePattern)
						|| control.equals(cmbTimePattern)
						|| control.equals(txtIdentifierPattern)
						|| control.equals(txtMetricValuePattern)
						) {
					this.pattern = (String) newValue;
					modelUpdate();
				}
			}
		}

		private boolean modelUpdate() {
			// Create the DataKindObject, actually only on save.
			System.out.println("I DT T D V P=" + identifier + datetime + date
					+ time + value + interval);

			// TODO, We can't switch the type, as an object would have been
			// created
			DataKind dk = null;
			if (mxlsColumn.getDataType() != null) {
				dk = mxlsColumn.getDataType();
				// Check for type switching.
				if (identifier && (dk instanceof ValueDataKind)) {
					dk = null;
				}
				if (!identifier && (dk instanceof IdentifierDataKind)) {
					dk = null;
				}
			}

			if (dk == null) {
				if (interval || value || datetime || date || time) {
					dk = MetricsFactory.eINSTANCE.createValueDataKind();
				}
				if (identifier) {
					dk = MetricsFactory.eINSTANCE.createIdentifierDataKind();
				}
			}

			if (interval) {
				((ValueDataKind) dk).setValueKind(ValueKindType.INTERVAL);
			}
			if (value) {
				((ValueDataKind) dk).setValueKind(ValueKindType.METRIC);
			}
			if (datetime) {
				((ValueDataKind) dk).setValueKind(ValueKindType.DATETIME);
			}
			if (date) {
				((ValueDataKind) dk).setValueKind(ValueKindType.DATE);
			}
			if (time) {
				((ValueDataKind) dk).setValueKind(ValueKindType.TIME);
			}

			if (dk instanceof ValueDataKind) {
				
				// Note: Interval don't have patterns. 
				((ValueDataKind) dk).setFormat(pattern);
			}
			if (dk instanceof IdentifierDataKind) {
				((IdentifierDataKind) dk).setPattern(pattern);
			}

			dataKindObservable.setValue(dk);
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
			if (modelUpdate()) {
				return Status.OK_STATUS;
			}
			return new Status(IStatus.WARNING, ScreensActivator.PLUGIN_ID,
					"Please enter correct job scheduling data");
		}
	}

	public void disposeData() {
		// N/A
	}

	public void injectData(boolean showDataMapping, Object owner, Object object) {
		this.showDataMapping = showDataMapping;
		injectData(owner, object);
	}

	public void injectData(Object owner, Object object) {
		if (owner instanceof EList<?>) {
			this.owner = (EList<?>) owner;
		} else {
			throw new IllegalArgumentException();
		}
		if (object != null && object instanceof MappingColumn) {
			mxlsColumn = (MappingColumn) object;
		} else {
			throw new IllegalArgumentException();
		}

		buildUI();
		
		buildHeaderMappingOptions(cmpColumnMapping);
		if (showDataMapping) {
			buildDataMappingOptions(cmpColumnMapping);
		}
		populatePatterns();
		
		
		context = this.initDataBindings_();
	}

	public void addData() {
		if (Screens.isNewOperation(getOperation()) && owner != null) {
			// If new, we have been operating on an object not added yet.
			Command c = new AddCommand(editingService.getEditingDomain(),
					owner, mxlsColumn);

			editingService.getEditingDomain().getCommandStack().execute(c);
		} else if (Screens.isEditOperation(getOperation())) {
			// If edit, we have been operating on a copy of the object, so we
			// have to replace. However if our original object is invalid, this
			// will
			// cause invalidity, so the action will not occure in case the
			// original is
			// invalid, and we should cancel the action and warn the user.
			if (mxlsColumn.cdoInvalid()) {
				MessageDialog
						.openWarning(Display.getDefault().getActiveShell(),
								"Conflict",
								"There is a conflict with another user. Your changes can't be saved.");
				return;
			}
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
		return frmNewMappingColumn;
	}

	@Override
	public void setOperation(int operation) {
		this.operation = operation;
	}
}
