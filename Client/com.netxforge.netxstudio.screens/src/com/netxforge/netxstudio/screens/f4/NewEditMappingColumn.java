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
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.EMFUpdateValueStrategy;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.databinding.IEMFValueProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.databinding.edit.IEMFEditValueProperty;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.jface.databinding.swt.ISWTObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.IViewerObservableValue;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.dialogs.IDialogConstants;
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
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.ColumnLayout;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormText;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.forms.widgets.Section;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.metrics.DataKind;
import com.netxforge.netxstudio.metrics.IdentifierDataKind;
import com.netxforge.netxstudio.metrics.KindHintType;
import com.netxforge.netxstudio.metrics.MappingColumn;
import com.netxforge.netxstudio.metrics.Metric;
import com.netxforge.netxstudio.metrics.MetricSource;
import com.netxforge.netxstudio.metrics.MetricsFactory;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.metrics.ObjectKindType;
import com.netxforge.netxstudio.metrics.ValueDataKind;
import com.netxforge.netxstudio.metrics.ValueKindType;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.MetricFilterDialog;
import com.netxforge.netxstudio.screens.editing.selector.IDataScreenInjection;
import com.netxforge.netxstudio.screens.editing.selector.ScreenUtil;
import com.netxforge.netxstudio.screens.f4.support.IdentifierDialog;
import com.netxforge.netxstudio.screens.internal.ScreensActivator;

public class NewEditMappingColumn extends AbstractScreen implements
		IDataScreenInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());

	private Text txtColumn;

	// Datakind selectors.
	private Button btnDate;
	private Button btnIdentifier;
	private Button btnMetricValue;
	private Button btnInterval;
	private Button btnTime;
	private Button btnDatetime;

	// Mapping column widgets.
	private Text txtObjectAttribute;
	private Text txtIdentifierPattern;
	private Text txtObject;
	private Text txtMetric;

	private Combo cmbTimePattern;
	private Combo cmbDateTimePattern;
	private Combo cmbDatePattern;
	private Combo cmbMetricHint;
	private ComboViewer cmbViewrMetricKindHint;

	// text decorations.
	private FormText formTextIdentifierMetric;
	private FormText formTextPattern;
	private FormText formTextInterval;

	// hyper links.
	private Hyperlink hprlnkSelectMetric;
	private Hyperlink hprlnkSelectIdentifier;

	// Writable kind state.
	private WritableValue btnIdentifierWritableValue;
	private WritableValue btnDateWritableValue;
	private WritableValue btnMetricWritableValue;
	private WritableValue btnIntervalWritableValue;
	private WritableValue btnDateTimeWritableValue;
	private WritableValue btnTimeWritableValue;

	// Widget observables.
	private ISWTObservableValue identifierObservable;
	private ISWTObservableValue dateTimeObservable;
	private ISWTObservableValue dateObservable;
	private ISWTObservableValue timeObservable;
	private ISWTObservableValue intervalObservable;
	private ISWTObservableValue dateTimePatternObservable;
	private ISWTObservableValue datePatternObservable;
	private ISWTObservableValue timePatternObservable;
	private ISWTObservableValue metricObservable;
	private ISWTObservableValue metricValueObservable;
	private IViewerObservableValue metricKindHintObservable;

	private EMFDataBindingContext context;
	private boolean showDataMapping;

	private Form frmNewMappingColumn;
	private Composite cmpColumnMapping;

	// Model objects.
	private EList<?> mappingColumns;
	private MappingColumn mxlsColumn;
	private MetricSource source;

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
				validationService.dispose();
				validationService
						.removeValidationListener(NewEditMappingColumn.this);
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);

		// Remove when runtime,.
		// buildUI();
		// buildHeaderMappingOptions(cmpColumnMapping);
		// buildDataMappingOptions(cmpColumnMapping);

	}

	private void buildUI() {
		setLayout(new FillLayout(SWT.HORIZONTAL));

		// New or Edit.
		boolean edit = ScreenUtil.isEditOperation(getOperation());
		String actionText = edit ? "Edit: " : "New: ";

		frmNewMappingColumn = toolkit.createForm(this);
		frmNewMappingColumn.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmNewMappingColumn);

		frmNewMappingColumn.setText(actionText + "Mapping Column: "
				+ this.source.getName());

		ColumnLayout cl = new ColumnLayout();
		cl.maxNumColumns = 1;
		frmNewMappingColumn.getBody().setLayout(cl);

		Section sctnMappings = toolkit.createSection(
				frmNewMappingColumn.getBody(), Section.EXPANDED
						| Section.TITLE_BAR);
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
		toolkit.paintBordersFor(sctnDataKind);
		sctnDataKind.setText("Mapping");
		sctnDataKind.setExpanded(true);

		cmpColumnMapping = toolkit.createComposite(sctnDataKind, SWT.NONE);
		toolkit.paintBordersFor(cmpColumnMapping);
		sctnDataKind.setClient(cmpColumnMapping);
		GridLayout gl_composite_2 = new GridLayout(5, false);
		gl_composite_2.horizontalSpacing = 10;
		cmpColumnMapping.setLayout(gl_composite_2);

	}

	private void buildDataMappingOptions(Composite cmpColumnMapping) {
		btnMetricValue = toolkit.createButton(cmpColumnMapping, "Metric Value",
				SWT.RADIO);
		new Label(cmpColumnMapping, SWT.NONE);

		hprlnkSelectMetric = toolkit.createHyperlink(cmpColumnMapping,
				"Select Metric", SWT.NONE);
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

		txtMetric = toolkit.createText(cmpColumnMapping, "New Text",
				SWT.READ_ONLY);
		txtMetric.setText("");
		txtMetric.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));

		cmbViewrMetricKindHint = new ComboViewer(cmpColumnMapping, SWT.NONE);
		cmbMetricHint = cmbViewrMetricKindHint.getCombo();
		cmbMetricHint.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1));
		toolkit.paintBordersFor(cmbMetricHint);
	}

	private void buildHeaderMappingOptions(Composite parent) {

		formTextInterval = toolkit.createFormText(cmpColumnMapping, false);
		toolkit.paintBordersFor(formTextInterval);
		formTextInterval.setText("<form><p><b>Interval</b></p></form>", true,
				false);
		new Label(cmpColumnMapping, SWT.NONE);
		new Label(cmpColumnMapping, SWT.NONE);
		new Label(cmpColumnMapping, SWT.NONE);
		new Label(cmpColumnMapping, SWT.NONE);

		btnInterval = toolkit.createButton(cmpColumnMapping, "Interval",
				SWT.RADIO);
		new Label(cmpColumnMapping, SWT.NONE);
		new Label(cmpColumnMapping, SWT.NONE);
		new Label(cmpColumnMapping, SWT.NONE);
		new Label(cmpColumnMapping, SWT.NONE);

		FormText formText_2 = toolkit.createFormText(cmpColumnMapping, false);
		GridData gd_formText_2 = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_formText_2.heightHint = 29;
		formText_2.setLayoutData(gd_formText_2);
		toolkit.paintBordersFor(formText_2);
		formText_2.setText("<form><p><b>Timestamp</b></p></form>", true, false);

		formTextPattern = toolkit.createFormText(cmpColumnMapping, false);
		formTextPattern.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 2, 1));
		toolkit.paintBordersFor(formTextPattern);
		formTextPattern.setText("<form><p><b>Pattern</b></p></form>", true,
				false);
		new Label(cmpColumnMapping, SWT.NONE);
		new Label(cmpColumnMapping, SWT.NONE);

		btnDatetime = new Button(parent, SWT.RADIO);
		toolkit.adapt(btnDatetime, true, true);
		btnDatetime.setText("Date/Time");

		cmbDateTimePattern = new Combo(parent, SWT.NONE);
		GridData gd_cmbDateTimePattern = new GridData(SWT.LEFT, SWT.CENTER,
				false, false, 1, 1);
		gd_cmbDateTimePattern.widthHint = 200;
		cmbDateTimePattern.setLayoutData(gd_cmbDateTimePattern);
		toolkit.adapt(cmbDateTimePattern);
		toolkit.paintBordersFor(cmbDateTimePattern);
		new Label(cmpColumnMapping, SWT.NONE);
		new Label(cmpColumnMapping, SWT.NONE);
		new Label(cmpColumnMapping, SWT.NONE);

		btnDate = toolkit.createButton(parent, "Date", SWT.RADIO);
		GridData gd_btnDate = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_btnDate.widthHint = 100;
		btnDate.setLayoutData(gd_btnDate);

		cmbDatePattern = new Combo(parent, SWT.NONE);
		GridData gd_cmbDatePattern = new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1);
		gd_cmbDatePattern.widthHint = 150;
		cmbDatePattern.setLayoutData(gd_cmbDatePattern);
		cmbDatePattern.setText("");
		toolkit.adapt(cmbDatePattern);
		toolkit.paintBordersFor(cmbDatePattern);
		new Label(parent, SWT.NONE);
		new Label(cmpColumnMapping, SWT.NONE);
		new Label(cmpColumnMapping, SWT.NONE);

		btnTime = toolkit.createButton(parent, "", SWT.RADIO);
		toolkit.adapt(btnTime, true, true);
		btnTime.setText("Time");

		cmbTimePattern = new Combo(parent, SWT.NONE);
		GridData gd_cmbTimePattern = new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1);
		gd_cmbTimePattern.widthHint = 150;
		cmbTimePattern.setLayoutData(gd_cmbTimePattern);
		toolkit.adapt(cmbTimePattern);
		toolkit.paintBordersFor(cmbTimePattern);
		new Label(cmpColumnMapping, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(cmpColumnMapping, SWT.NONE);

		formTextIdentifierMetric = toolkit.createFormText(cmpColumnMapping,
				false);
		toolkit.paintBordersFor(formTextIdentifierMetric);
		formTextIdentifierMetric.setText(
				"<form><p><b>Identifier/Metric</b></p></form>", true, false);

		FormText formText = toolkit.createFormText(cmpColumnMapping, false);
		formText.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1,
				1));
		toolkit.paintBordersFor(formText);
		formText.setText("<form><p><b>Pattern</b></p></form>", true, false);
		new Label(cmpColumnMapping, SWT.NONE);

		FormText formText_1 = toolkit.createFormText(cmpColumnMapping, false);
		formText_1.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false,
				1, 1));
		toolkit.paintBordersFor(formText_1);
		formText_1.setText("<form><p><b>Object</b></p></form>", true, false);
		new Label(cmpColumnMapping, SWT.NONE);

		btnIdentifier = toolkit.createButton(parent, "Identifier", SWT.RADIO);

		txtIdentifierPattern = toolkit.createText(parent, "New Text", SWT.NONE);
		GridData gd_txtIdentifierPattern = new GridData(SWT.FILL, SWT.CENTER,
				false, false, 1, 1);
		gd_txtIdentifierPattern.widthHint = 100;
		txtIdentifierPattern.setLayoutData(gd_txtIdentifierPattern);
		txtIdentifierPattern.setText("");

		hprlnkSelectIdentifier = toolkit.createHyperlink(parent,
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

						CompoundCommand cc = new CompoundCommand();
						{
							SetCommand sc = new SetCommand(
									editingService.getEditingDomain(),
									idk,
									MetricsPackage.Literals.IDENTIFIER_DATA_KIND__OBJECT_KIND,
									ObjectKindType.get(v));
							cc.append(sc);
						}
						{

							// Translate the literal "Network Element ID" to
							// NodeID.
							String objectAttribute = id.getObjectAttribute();
							if (ModelUtils.NETWORK_ELEMENT_ID
									.equals(objectAttribute)) {
								objectAttribute = ModelUtils.NODE_ID;
							}
							SetCommand sc = new SetCommand(
									editingService.getEditingDomain(),
									idk,
									MetricsPackage.Literals.IDENTIFIER_DATA_KIND__OBJECT_PROPERTY,
									objectAttribute);
							cc.append(sc);

						}

						// idk.setObjectKind(ObjectKindType.get(v));
						// idk.setObjectProperty(id.getObjectAttribute());
						// context.updateTargets();
						editingService.getEditingDomain().getCommandStack()
								.execute(cc);
					}
				}
			}

			public void linkEntered(HyperlinkEvent e) {
			}

			public void linkExited(HyperlinkEvent e) {
			}
		});
		toolkit.paintBordersFor(hprlnkSelectIdentifier);

		txtObject = toolkit.createText(parent, "New Text", SWT.BORDER
				| SWT.READ_ONLY);
		txtObject.setText("");
		GridData gd_txtIndentifier = new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1);
		gd_txtIndentifier.widthHint = 100;
		txtObject.setLayoutData(gd_txtIndentifier);

		txtObjectAttribute = toolkit.createText(parent, "", SWT.BORDER
				| SWT.READ_ONLY);
		GridData gd_txtObjectAttribute = new GridData(SWT.LEFT, SWT.CENTER,
				false, false, 1, 1);
		gd_txtObjectAttribute.widthHint = 120;
		txtObjectAttribute.setLayoutData(gd_txtObjectAttribute);
		toolkit.adapt(txtObjectAttribute, true, true);

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

		List<String> datePatterns = ImmutableList.of(ModelUtils.DATE_PATTERN_1,
				ModelUtils.DATE_PATTERN_2, ModelUtils.DATE_PATTERN_3);

		List<String> timePatterns = ImmutableList.of(ModelUtils.TIME_PATTERN_1,
				ModelUtils.TIME_PATTERN_2, ModelUtils.TIME_PATTERN_3,
				ModelUtils.TIME_PATTERN_4);

		// For datetime pattenrs, create combinations, add a space in between
		// date and time pattern.
		List<String> dateTimePatterns = Lists.newArrayList();
		for (String dp : datePatterns) {
			for (String tp : timePatterns) {
				dateTimePatterns.add(dp + " " + tp);
			}
		}

		// dateTimePatterns.addAll(datePatterns);
		// dateTimePatterns.addAll(timePatterns);

		for (String string : datePatterns) {
			cmbDatePattern.add(string);
		}

		for (String string : timePatterns) {
			cmbTimePattern.add(string);
		}

		for (String string : dateTimePatterns) {
			cmbDateTimePattern.add(string);
		}

	}

	public EMFDataBindingContext initDataBindings_() {
		EMFDataBindingContext context = new EMFDataBindingContext();

		IObservableValue columnObservable = SWTObservables.observeText(
				txtColumn, SWT.Modify);
		IEMFValueProperty columnProperty = EMFEditProperties.value(
				editingService.getEditingDomain(),
				MetricsPackage.Literals.MAPPING_COLUMN__COLUMN);
		context.bindValue(columnObservable, columnProperty.observe(mxlsColumn));

		// ///////////////////////////////////////////////////////////
		// AGGREGATOR
		// ///////////////////////////////////////////////////////////
		IObservableValue dataKindWritableValue = new WritableValue();
		IEMFValueProperty dataKindProperty = EMFEditProperties.value(
				editingService.getEditingDomain(),
				MetricsPackage.Literals.MAPPING_COLUMN__DATA_TYPE);
		// Should occure before the aggregator is created.

		IObservableValue dataKindObservable = dataKindProperty
				.observe(mxlsColumn);

		// Validation Strategies
		EMFUpdateValueStrategy dataKindStrategy = new EMFUpdateValueStrategy();
		dataKindStrategy.setBeforeSetValidator(new IValidator() {
			public IStatus validate(Object value) {
				boolean isInvalid = false;
				if (value == null) {
					isInvalid = true;
				} else {
					// Always valid here....
				}
				if (isInvalid) {
					return new Status(IStatus.WARNING,
							ScreensActivator.PLUGIN_ID, "Mapping Issue:");
				}
				return Status.OK_STATUS;
			}
		});

		context.bindValue(dataKindWritableValue, dataKindObservable,
				dataKindStrategy, null);

		// Aggregates all mutations on the current DataKind.
		// If none exists, a new one will be created based on the selected
		// button.
		DatakindAggregate aggregate = new DatakindAggregate(
				dataKindWritableValue);

		initDataBindingHeaderMappingColumn(context);
		if (showDataMapping) {
			initDataBindingDataMappingColumn(context, dataKindProperty);
		}

		setInitialHeaderMapping(dataKindObservable.getValue());

		this.enableHeaderAggregate(aggregate);
		if (showDataMapping) {
			setInitialDataMapping(dataKindObservable.getValue());
			this.enableDataAggregate(aggregate);
		}

		context.updateTargets();

		return context;
	}

	/*
	 * bind the part of the UI which deals with header mapping.
	 */
	private void initDataBindingHeaderMappingColumn(
			EMFDataBindingContext context) {

		// ///////////////////////////
		// WRITABLE OBSERVABLES MAPPING COLUMN KIND
		// ///////////////////////////

		btnIdentifierWritableValue = new WritableValue();
		btnDateTimeWritableValue = new WritableValue();
		btnDateWritableValue = new WritableValue();
		btnTimeWritableValue = new WritableValue();
		btnIntervalWritableValue = new WritableValue();

		identifierObservable = SWTObservables.observeSelection(btnIdentifier);
		dateTimeObservable = SWTObservables.observeSelection(btnDatetime);
		dateObservable = SWTObservables.observeSelection(btnDate);
		timeObservable = SWTObservables.observeSelection(btnTime);
		intervalObservable = SWTObservables.observeSelection(this.btnInterval);

		context.bindValue(identifierObservable, btnIdentifierWritableValue,
				null, null);
		context.bindValue(dateTimeObservable, btnDateTimeWritableValue, null,
				null);
		context.bindValue(dateObservable, btnDateWritableValue, null, null);
		context.bindValue(timeObservable, btnTimeWritableValue, null, null);
		context.bindValue(intervalObservable, btnIntervalWritableValue, null,
				null);

		// ///////////////////////////
		// PATTERN FIELD OBSERVABLES
		// ///////////////////////////
		dateTimePatternObservable = SWTObservables
				.observeText(this.cmbDateTimePattern);
		datePatternObservable = SWTObservables.observeText(this.cmbDatePattern);
		timePatternObservable = SWTObservables.observeText(this.cmbTimePattern);

		// ///////////////////////////
		// IDENTIFIER BINDING
		// ///////////////////////////

		IObservableValue identifierPatternObservable = SWTObservables
				.observeDelayedValue(400, SWTObservables.observeText(
						this.txtIdentifierPattern, SWT.Modify));

		IObservableValue objectKindObservable = SWTObservables.observeText(
				this.txtObject, SWT.Modify);

		IObservableValue objectAttributeObservable = SWTObservables
				.observeText(this.txtObjectAttribute, SWT.Modify);

		IEMFEditValueProperty objectPatternProperty = EMFEditProperties.value(
				editingService.getEditingDomain(), FeaturePath.fromList(
						MetricsPackage.Literals.MAPPING_COLUMN__DATA_TYPE,
						MetricsPackage.Literals.IDENTIFIER_DATA_KIND__PATTERN));

		IEMFEditValueProperty objectKindProperty = EMFEditProperties
				.value(editingService.getEditingDomain(),
						FeaturePath
								.fromList(
										MetricsPackage.Literals.MAPPING_COLUMN__DATA_TYPE,
										MetricsPackage.Literals.IDENTIFIER_DATA_KIND__OBJECT_KIND));

		IEMFEditValueProperty objectAttributeProperty = EMFEditProperties
				.value(editingService.getEditingDomain(),
						FeaturePath
								.fromList(
										MetricsPackage.Literals.MAPPING_COLUMN__DATA_TYPE,
										MetricsPackage.Literals.IDENTIFIER_DATA_KIND__OBJECT_PROPERTY));

		context.bindValue(identifierPatternObservable,
				objectPatternProperty.observe(mxlsColumn));

		EMFUpdateValueStrategy mttObjectKindStrategy = new EMFUpdateValueStrategy();
		mttObjectKindStrategy.setConverter(new MTTObjectKindStrategy());

		EMFUpdateValueStrategy ttmObjectKindStrategy = new EMFUpdateValueStrategy();
		ttmObjectKindStrategy.setConverter(new TTMObjectKindStrategy());

		context.bindValue(objectKindObservable,
				objectKindProperty.observe(mxlsColumn), ttmObjectKindStrategy,
				mttObjectKindStrategy);

		/*
		 * A default strategy to delegate to the default converter, for non
		 * specific cases.
		 */
		EMFUpdateValueStrategy mttObjectAttributeStrategy = new EMFUpdateValueStrategy();
		mttObjectAttributeStrategy
				.setConverter(new MTTObjectAttributeStrategy());

		EMFUpdateValueStrategy ttmObjectAttributeStrategy = new EMFUpdateValueStrategy();
		ttmObjectAttributeStrategy
				.setConverter(new TTMObjectAttributeConverter());

		context.bindValue(objectAttributeObservable,
				objectAttributeProperty.observe(mxlsColumn),
				ttmObjectAttributeStrategy, mttObjectAttributeStrategy);

	}

	private void enableHeaderAggregate(DatakindAggregate aggregate) {

		// Kind observables.
		identifierObservable.addValueChangeListener(aggregate);
		dateTimeObservable.addValueChangeListener(aggregate);
		dateObservable.addValueChangeListener(aggregate);
		timeObservable.addValueChangeListener(aggregate);
		intervalObservable.addValueChangeListener(aggregate);

		// Pattern observables.
		dateTimePatternObservable.addValueChangeListener(aggregate);
		datePatternObservable.addValueChangeListener(aggregate);
		timePatternObservable.addValueChangeListener(aggregate);
		// identifierPatternObservable.addValueChangeListener(aggregate);

	}

	private void enableDataAggregate(DatakindAggregate aggregate) {

		// metric selection
		metricObservable.addValueChangeListener(aggregate);

		// Value observables.
		// metricValueObservable.addValueChangeListener(aggregate);

		// Kind observable.
		metricKindHintObservable.addValueChangeListener(aggregate);
	}

	/*
	 * bind the part of the UI which deals with data mapping.
	 */
	private void initDataBindingDataMappingColumn(
			EMFDataBindingContext context, IEMFValueProperty dataKindProperty) {

		// Metric option selected.
		btnMetricWritableValue = new WritableValue();
		metricObservable = SWTObservables.observeSelection(btnMetricValue);
		context.bindValue(metricObservable, btnMetricWritableValue, null, null);

		// We should really observe the button.
		metricValueObservable = SWTObservables.observeText(txtMetric,
				SWT.Modify);

		// valuePatternObservable = SWTObservables.observeText(
		// this.txtMetricValuePattern, SWT.Modify);

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

		cmbViewrMetricKindHint.setContentProvider(new ArrayContentProvider());
		cmbViewrMetricKindHint.setLabelProvider(new LabelProvider());
		cmbViewrMetricKindHint.setInput(KindHintType.VALUES);

		metricKindHintObservable = ViewerProperties.singleSelection().observe(
				cmbViewrMetricKindHint);

		IEMFEditValueProperty KindHintProperty = EMFEditProperties.value(
				editingService.getEditingDomain(), FeaturePath.fromList(
						MetricsPackage.Literals.MAPPING_COLUMN__DATA_TYPE,
						MetricsPackage.Literals.VALUE_DATA_KIND__KIND_HINT));

		context.bindValue(metricKindHintObservable,
				KindHintProperty.observe(mxlsColumn), null, null);

	}

	// private void enableValueDataKindWidgets(boolean enableState){
	//
	//
	//
	// }
	//
	// private void enableIdentifierDataKindWidgets(boolean enableState){
	//
	//
	// }

	private final class MTTObjectKindStrategy implements IConverter {

		public Object getFromType() {
			return ObjectKindType.class;
		}

		public Object getToType() {
			return String.class;
		}

		public Object convert(Object fromObject) {
			if (fromObject instanceof ObjectKindType) {

				ObjectKindType okt = (ObjectKindType) fromObject;
				switch (okt.getValue()) {
				case ObjectKindType.NODE_VALUE: {
					return ModelUtils.NETWORK_ELEMENT;
				}
				default: {
					return okt.getName();
				}
				}
			}
			return fromObject;
		}
	}

	private final class TTMObjectKindStrategy implements IConverter {

		public Object getFromType() {
			return String.class;
		}

		public Object getToType() {
			return ObjectKindType.class;
		}

		public Object convert(Object fromObject) {
			if (fromObject != null
					&& fromObject.equals(ModelUtils.NETWORK_ELEMENT)) {
				return ModelUtils.NODE;
			} else {
				return fromObject;
			}
		}
	}

	private final class MTTObjectAttributeStrategy implements IConverter {
		public Object getFromType() {
			return String.class;
		}

		public Object getToType() {
			return String.class;
		}

		public Object convert(Object fromObject) {
			if (fromObject != null && fromObject.equals(ModelUtils.NODE_ID)) {
				return ModelUtils.NETWORK_ELEMENT_ID;
			}
			return fromObject;
		}
	}

	private final class TTMObjectAttributeConverter implements IConverter {
		public Object getFromType() {
			return String.class;
		}

		public Object getToType() {
			return String.class;
		}

		public Object convert(Object fromObject) {
			if (fromObject != null
					&& fromObject.equals(ModelUtils.NETWORK_ELEMENT_ID)) {
				return ModelUtils.NODE_ID;
			}
			return fromObject;
		}
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
			}
			if (vkt == ValueKindType.DATETIME) {
				btnDateTimeWritableValue.setValue(true);
				String pattern = vdk.getFormat();
				if (pattern != null) {
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
			// if (vkt == ValueKindType.METRIC) {
			// this.btnMetricWritableValue.setValue(true);
			// if (vdk.getFormat() != null) {
			// this.txtMetricValuePattern.setText(vdk.getFormat());
			// }
			// }
			return;
		}
		if (value instanceof IdentifierDataKind) {
			this.btnIdentifierWritableValue.setValue(true);
			// IdentifierDataKind idk = (IdentifierDataKind) value;
			// if (idk.getPattern() != null) {
			// this.txtIdentifierPattern.setText(idk.getPattern());
			// }
			// if(idk.eIsSet(MetricsPackage.Literals.IDENTIFIER_DATA_KIND__OBJECT_PROPERTY)){
			// this.txtObjectAttribute.setText(idk.getObjectProperty());
			// }
			return;
		}
	}

	private void setInitialDataMapping(Object value) {
		if (value instanceof ValueDataKind) {
			ValueDataKind vdk = (ValueDataKind) value;
			ValueKindType vkt = vdk.getValueKind();
			if (vkt == ValueKindType.METRIC) {
				this.btnMetricWritableValue.setValue(true);
				// if (vdk.getFormat() != null) {
				// this.txtMetricValuePattern.setText(vdk.getFormat());
				// }
				// if
				// (vdk.eIsSet(MetricsPackage.Literals.VALUE_DATA_KIND__KIND_HINT))
				// {
				// KindHintType kindHint = vdk.getKindHint();
				// cmbViewrMetricKindHint
				// .setSelection(new StructuredSelection(kindHint));
				// }
			}
		}
	}

	private class DatakindAggregate implements IValueChangeListener, IValidator {

		private IObservableValue dataKindObservable;

		private String pattern; // stores the pattern for the datakind.
		// private int metricKindHint = -1;

		private DataKindStateMachine dksm = new DataKindStateMachine();

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

			// DISPATCH ON OBSERVABLE TYPE.
			if (event.getObservable() instanceof ISWTObservableValue) {
				Control control = (Control) ((ISWTObservableValue) event
						.getObservable()).getWidget();
				System.out.println(control);

				// Also clear the non-bind UI widgets. these are:
				// cmbDatePattern
				// cmbTime

				if (control.equals(btnIdentifier)) {

					// Clear and disable anything else.
					cmbDatePattern.setText("");
					cmbDatePattern.setEnabled(false);
					cmbDateTimePattern.setText("");
					cmbDateTimePattern.setEnabled(false);
					cmbTimePattern.setText("");
					cmbTimePattern.setEnabled(false);
					// txtIdentifierPattern.setText("");
					txtIdentifierPattern.setEnabled(true);
					cmbMetricHint.setText("");
					cmbMetricHint.setEnabled(false);
					txtMetric.setText("");
					txtMetric.setEnabled(false);
					hprlnkSelectMetric.setEnabled(false);
					hprlnkSelectIdentifier.setEnabled(true);

					dksm.setIdentifier((Boolean) newValue);
				} else if (control.equals(btnDatetime)) {
					// Clear and disable anything else.
					cmbDatePattern.setText("");
					cmbDatePattern.setEnabled(false);
					// cmbDateTimePattern.setText("");
					cmbDateTimePattern.setEnabled(true);
					cmbTimePattern.setText("");
					cmbTimePattern.setEnabled(false);
					txtIdentifierPattern.setText("");
					txtIdentifierPattern.setEnabled(false);
					txtMetric.setText("");
					txtMetric.setEnabled(false);
					cmbMetricHint.setText("");
					cmbMetricHint.setEnabled(false);
					hprlnkSelectMetric.setEnabled(false);
					hprlnkSelectIdentifier.setEnabled(false);

					dksm.setDatetime((Boolean) newValue);
				} else if (control.equals(btnDate)) {
					// Clear and disable anything else.
					// cmbDatePattern.setText("");
					cmbDatePattern.setEnabled(true);
					cmbDateTimePattern.setText("");
					cmbDateTimePattern.setEnabled(false);
					cmbTimePattern.setText("");
					cmbTimePattern.setEnabled(false);
					txtIdentifierPattern.setText("");
					txtIdentifierPattern.setEnabled(false);
					txtMetric.setText("");
					txtMetric.setEnabled(false);
					cmbMetricHint.setText("");
					cmbMetricHint.setEnabled(false);
					hprlnkSelectMetric.setEnabled(false);
					hprlnkSelectIdentifier.setEnabled(false);

					dksm.setDate((Boolean) newValue);
				} else if (control.equals(btnTime)) {
					// Clear and disable anything else.
					cmbDatePattern.setText("");
					cmbDatePattern.setEnabled(false);
					cmbDateTimePattern.setText("");
					cmbDateTimePattern.setEnabled(true);
					// cmbTimePattern.setText("");
					cmbTimePattern.setEnabled(true);
					txtIdentifierPattern.setText("");
					txtIdentifierPattern.setEnabled(false);
					txtMetric.setText("");
					txtMetric.setEnabled(false);
					cmbMetricHint.setText("");
					cmbMetricHint.setEnabled(false);
					hprlnkSelectMetric.setEnabled(false);
					hprlnkSelectIdentifier.setEnabled(false);

					dksm.setTime((Boolean) newValue);
				} else if (btnMetricValue != null
						& control.equals(btnMetricValue)) {
					// Clear and disable anything else.
					cmbDatePattern.setText("");
					cmbDatePattern.setEnabled(false);
					cmbDateTimePattern.setText("");
					cmbDateTimePattern.setEnabled(false);
					cmbTimePattern.setText("");
					cmbTimePattern.setEnabled(false);
					txtIdentifierPattern.setText("");
					txtIdentifierPattern.setEnabled(false);
					// txtMetric.setText("");
					txtMetric.setEnabled(true);
					// cmbMetricHint.setText("");
					cmbMetricHint.setEnabled(true);
					dksm.setValue((Boolean) newValue);
					hprlnkSelectMetric.setEnabled(true);
					hprlnkSelectIdentifier.setEnabled(false);

				} else if (control.equals(btnInterval)) {
					// Clear and disable anything else.
					cmbDatePattern.setText("");
					cmbDatePattern.setEnabled(false);
					cmbDateTimePattern.setText("");
					cmbDateTimePattern.setEnabled(false);
					cmbTimePattern.setText("");
					cmbTimePattern.setEnabled(false);
					txtIdentifierPattern.setText("");
					txtIdentifierPattern.setEnabled(false);
					txtMetric.setText("");
					txtMetric.setEnabled(false);
					cmbMetricHint.setText("");
					cmbMetricHint.setEnabled(false);
					hprlnkSelectMetric.setEnabled(false);
					hprlnkSelectIdentifier.setEnabled(false);

					dksm.setInterval((Boolean) newValue);
				} else if (control.equals(cmbDatePattern)
						|| control.equals(cmbDateTimePattern)
						|| control.equals(cmbTimePattern)) {
					this.pattern = (String) newValue;
					attributeUpdate();
					return;
				} else if (control.equals(txtIdentifierPattern)) {
					// Regular expression patterns
					this.pattern = (String) newValue;
					attributeUpdate();
					return;
				}
				// We are only interrested in button selection (not
				// un-selection).
				if (newValue instanceof Boolean && (Boolean) newValue) {
					modelUpdate();
				}
			}

			// bind directly.

			// if (event.getObservable() instanceof IViewerObservableValue) {
			// Viewer viewer = (Viewer) ((IViewerObservableValue) event
			// .getObservable()).getViewer();
			// System.out.println(viewer.getControl());
			// if (newValue instanceof KindHintType) {
			// metricKindHint = ((KindHintType) newValue).getValue();
			// attributeUpdate();
			// }
			// }

		}

		/*
		 * Switches between objects if the dk state changed. tries to re-use
		 * existing
		 */
		private boolean modelUpdate() {

			DataKind dk = null;
			DataKind currentDk = (DataKind) this.dataKindObservable.getValue();
			// Check we switched, from the stated, we could still have a valid
			// object.
			if (currentDk != null) {
				if (dksm.isDataKindSwitched()) {
					// Clear the attributes, which will be reset:
					pattern = "";
					dksm.setDataKindSwitched(false);
					// create a new one.
					if (dksm.isValueDataKind()) {
						if (currentDk instanceof ValueDataKind) {
							((ValueDataKind) currentDk).setMetricRef(null);
							dk = currentDk;
						} else {
							dk = MetricsFactory.eINSTANCE.createValueDataKind();
						}
					} else if (dksm.isIdentifierDataKind()) {
						if (currentDk instanceof IdentifierDataKind) {
							// keep the metrc if set.
							dk = currentDk;
						} else {
							dk = MetricsFactory.eINSTANCE
									.createIdentifierDataKind();
						}
					}
				} else {
					dk = currentDk;
				}
			} else {
				// This is a new mapping, create a new DK if the state is valid.
				if (dksm.isValidState()) {
					dk = dksm.isValueDataKind() ? MetricsFactory.eINSTANCE
							.createValueDataKind() : MetricsFactory.eINSTANCE
							.createIdentifierDataKind();
				}
			}
			if (dk instanceof ValueDataKind) {
				((ValueDataKind) dk).setValueKind(dksm.valueDataKindForState());
			}
			dataKindObservable.setValue(dk);
			return true;
		}

		private boolean attributeUpdate() {

			DataKind dk = (DataKind) this.dataKindObservable.getValue();

			// Write the DataKind with attributes, note: some attributes are
			// directly bound, so we have
			// to re-use the existing object if any (This is why these are not
			// set here).
			if (dk instanceof ValueDataKind) {
				ValueDataKind vdk = (ValueDataKind) dk;
				vdk.setFormat(pattern);
				// SetCommand sc = new SetCommand(
				// editingService.getEditingDomain(), vdk,
				// MetricsPackage.Literals.VALUE_DATA_KIND__FORMAT,
				// pattern);
				//
				// editingService.getEditingDomain().getCommandStack().execute(sc);

				// if (metricKindHint != -1
				// && vdk.getValueKind() == ValueKindType.METRIC) {
				// vdk.setKindHint(KindHintType.get(metricKindHint));
				// }else{
				// // clear the metric attributes.
				// // vdk.setMetricRef(null);
				// vdk.setKindHint(null);
				// }
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

		/*
		 * State machine for which Datakind is selected in the screen. Operats
		 * parallel to the widget.
		 */
		class DataKindStateMachine {

			boolean date = false;
			boolean time = false;
			boolean identifier = false;
			boolean value = false;
			boolean interval = false;
			boolean datetime = false;

			// Keeps state if we switched the DataKind.
			boolean dataKindSwitched = false;

			public boolean isDataKindSwitched() {
				return dataKindSwitched;
			}

			public void setDataKindSwitched(boolean dataKindSwitched) {
				this.dataKindSwitched = dataKindSwitched;
			}

			private void invalidateState() {
				date = time = identifier = value = interval = datetime = false;
			}

			public boolean isValueDataKind() {
				return interval || value || datetime || date || time;
			}

			public ValueKindType valueDataKindForState() {
				if (interval) {
					return ValueKindType.INTERVAL;
				} else if (value) {
					return ValueKindType.METRIC;
				} else if (datetime) {
					return ValueKindType.DATETIME;
				} else if (date) {
					return ValueKindType.DATE;
				} else if (time) {
					return ValueKindType.TIME;
				}
				return null;
			}

			public boolean isIdentifierDataKind() {
				return identifier;
			}

			public boolean isValidState() {
				return interval || value || datetime || date || time
						|| identifier;
			}

			// Setters.
			public void setDate(boolean date) {
				invalidateState();
				this.date = date;
				if (!this.date) {
					setDataKindSwitched(true);
				}
			}

			public void setDatetime(boolean datetime) {
				invalidateState();
				this.datetime = datetime;
				if (!this.datetime) {
					setDataKindSwitched(true);
				}
			}

			public void setTime(boolean time) {
				invalidateState();
				this.time = time;
				if (!this.time) {
					setDataKindSwitched(true);
				}

			}

			public void setValue(boolean value) {
				invalidateState();
				this.value = value;
				if (!value) {
					setDataKindSwitched(true);
				}

			}

			public void setInterval(boolean interval) {
				invalidateState();
				this.interval = interval;
				if (!interval) {
					setDataKindSwitched(true);
				}

			}

			public void setIdentifier(boolean identifier) {
				invalidateState();
				this.identifier = identifier;

				if (!identifier) {
					setDataKindSwitched(true);
				}
			}

			public String toString() {
				return "I DT T D V P=" + identifier + datetime + date + time
						+ value + interval + "";
			}

		}
	}

	public void disposeData() {
		// N/A
	}

	public void injectData(MetricSource source, boolean showDataMapping,
			Object owner, Object object) {
		this.source = source;
		this.showDataMapping = showDataMapping;
		injectData(owner, object);
	}

	public void injectData(Object owner, Object object) {
		if (owner instanceof EList<?>) {
			this.mappingColumns = (EList<?>) owner;
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

		// Disable for now.
		// if (!Screens.isReadOnlyOperation(getOperation())) {
		// validationService.registerBindingContext(context);
		// validationService.addValidationListener(this);
		// }
	}

	public void addData() {
		if (ScreenUtil.isNewOperation(getOperation()) && mappingColumns != null) {
			// If new, we have been operating on an object not added yet.
			Command c = new AddCommand(editingService.getEditingDomain(),
					mappingColumns, mxlsColumn);

			editingService.getEditingDomain().getCommandStack().execute(c);
		} else if (ScreenUtil.isEditOperation(getOperation())) {
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

	public String getScreenName() {
		return "Mapping Column";
	}

	@SuppressWarnings("unused")
	private void enableOption() {
	}

}
