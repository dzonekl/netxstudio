package com.netxforge.netxstudio.screens.f4;

import java.util.Date;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.core.databinding.conversion.Converter;
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
import org.eclipse.emf.databinding.EMFUpdateValueStrategy;
import org.eclipse.emf.databinding.IEMFValueProperty;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.ReplaceCommand;
import org.eclipse.jface.databinding.swt.ISWTObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.IViewerObservableValue;
import org.eclipse.jface.databinding.viewers.ViewersObservables;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.nebula.widgets.cdatetime.CDT;
import org.eclipse.nebula.widgets.cdatetime.CDateTime;
import org.eclipse.nebula.widgets.datechooser.DateChooserCombo;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
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
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.IMessage;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.scheduling.Job;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.CDateTimeObservableValue;
import com.netxforge.netxstudio.screens.DateChooserComboObservableValue;
import com.netxforge.netxstudio.screens.editing.observables.FormValidationEvent;
import com.netxforge.netxstudio.screens.editing.observables.IValidationListener;
import com.netxforge.netxstudio.screens.editing.observables.IValidationService;
import com.netxforge.netxstudio.screens.editing.observables.ValidationEvent;
import com.netxforge.netxstudio.screens.editing.observables.ValidationService;
import com.netxforge.netxstudio.screens.editing.selector.IDataScreenInjection;
import com.netxforge.netxstudio.screens.editing.selector.Screens;
import com.netxforge.netxstudio.screens.internal.ScreensActivator;

public class NewEditJob extends AbstractScreen implements IDataScreenInjection,
		IValidationListener {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Text txtJobName;
	private Text txtOccurences;
	private Table table;
	private Job job;
	private Job original;
	private Resource owner;
	private ComboViewer comboViewerOn;
	private ComboViewer comboViewerEvery;

	@Inject
	ModelUtils modelUtils;
	private CDateTime cdateTimeStartTime;
	private DateChooserCombo dateChooserStartsOn;
	private DateChooserCombo dateChooserEndsOn;
	private Form frmNewJob;
	private Button btnOn;
	private Button btnAfter;
	private Button btnNever;
	private TableViewer occurencesTableViewer;

	// Not injected as this service is already injected in the ViePart.
	private IValidationService validationService = new ValidationService();
	private EMFDataBindingContext bindingContext;
	
	public NewEditJob(Composite parent, int style) {
		super(parent, style);

		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
				validationService.dispose();
				validationService.removeValidationListener(NewEditJob.this);
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
		setLayout(new FillLayout(SWT.HORIZONTAL));

		frmNewJob = toolkit.createForm(this);
		frmNewJob.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmNewJob);
		frmNewJob.setText("New Job");
		frmNewJob.getBody().setLayout(new FormLayout());

		Section sctnDetails = toolkit.createSection(frmNewJob.getBody(),
				Section.EXPANDED | Section.TITLE_BAR);
		FormData fd_sctnDetails = new FormData();
		fd_sctnDetails.top = new FormAttachment(0, 12);
		fd_sctnDetails.right = new FormAttachment(0, 201);
		fd_sctnDetails.left = new FormAttachment(0, 12);
		sctnDetails.setLayoutData(fd_sctnDetails);
		toolkit.paintBordersFor(sctnDetails);
		sctnDetails.setText("Job Details");

		Composite compositeDetails = toolkit.createComposite(sctnDetails,
				SWT.NONE);
		toolkit.paintBordersFor(compositeDetails);
		sctnDetails.setClient(compositeDetails);
		compositeDetails.setLayout(new GridLayout(2, false));

		Label lblJobName = toolkit
				.createLabel(compositeDetails, "Name:", SWT.NONE);
		lblJobName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1));
		lblJobName.setAlignment(SWT.RIGHT);

		txtJobName = toolkit.createText(compositeDetails, "New Text", SWT.NONE);
		txtJobName.setText("");
		GridData gd_txtJobName = new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1);
		gd_txtJobName.widthHint = 100;
		txtJobName.setLayoutData(gd_txtJobName);

		Label lblType = toolkit
				.createLabel(compositeDetails, "Type:", SWT.NONE);
		lblType.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1));
		lblType.setAlignment(SWT.RIGHT);

		ComboViewer comboViewerJobType = new ComboViewer(compositeDetails,
				SWT.NONE);
		Combo comboJobType = comboViewerJobType.getCombo();
		GridData gd_comboJobType = new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1);
		gd_comboJobType.widthHint = 100;
		comboJobType.setLayoutData(gd_comboJobType);
		toolkit.paintBordersFor(comboJobType);

		// SECTION START OF JOB

		Section sctnRecurrence = toolkit.createSection(frmNewJob.getBody(),
				Section.EXPANDED | Section.TITLE_BAR);
		FormData fd_sctnRecurrence = new FormData();
		fd_sctnRecurrence.left = new FormAttachment(sctnDetails, 6);
		fd_sctnRecurrence.right = new FormAttachment(100, -12);
		fd_sctnRecurrence.bottom = new FormAttachment(0, 129);
		fd_sctnRecurrence.top = new FormAttachment(0, 12);
		sctnRecurrence.setLayoutData(fd_sctnRecurrence);
		toolkit.paintBordersFor(sctnRecurrence);
		sctnRecurrence.setText("Start");

		Composite compositeRecurrence = toolkit.createComposite(sctnRecurrence,
				SWT.NONE);
		toolkit.paintBordersFor(compositeRecurrence);
		sctnRecurrence.setClient(compositeRecurrence);
		compositeRecurrence.setLayout(new GridLayout(6, false));

		Label lblOn = toolkit.createLabel(compositeRecurrence, "On:", SWT.NONE);
		lblOn.setAlignment(SWT.RIGHT);
		GridData gd_lblOn = new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1);
		gd_lblOn.widthHint = 70;
		lblOn.setLayoutData(gd_lblOn);

		comboViewerOn = new ComboViewer(compositeRecurrence, SWT.NONE);
		Combo comboOn = comboViewerOn.getCombo();
		GridData gd_comboOn = new GridData(SWT.FILL, SWT.CENTER, false, false,
				3, 1);
		gd_comboOn.widthHint = 150;
		comboOn.setLayoutData(gd_comboOn);
		toolkit.paintBordersFor(comboOn);

		Label lblAt = toolkit.createLabel(compositeRecurrence, "At:", SWT.NONE);
		lblAt.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1));

		cdateTimeStartTime = new CDateTime(compositeRecurrence, CDT.BORDER
				| CDT.CLOCK_24_HOUR | CDT.DROP_DOWN | CDT.TIME_SHORT);
		toolkit.adapt(cdateTimeStartTime);
		toolkit.paintBordersFor(cdateTimeStartTime);

		Label lblEvery = toolkit.createLabel(compositeRecurrence, "Every:",
				SWT.NONE);
		lblEvery.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		lblEvery.setAlignment(SWT.RIGHT);

		comboViewerEvery = new ComboViewer(compositeRecurrence, SWT.NONE);
		Combo comboEvery = comboViewerEvery.getCombo();
		GridData gd_comboEvery = new GridData(SWT.FILL, SWT.CENTER, false,
				false, 3, 1);
		gd_comboEvery.widthHint = 150;
		comboEvery.setLayoutData(gd_comboEvery);
		toolkit.paintBordersFor(comboEvery);
		new Label(compositeRecurrence, SWT.NONE);
		new Label(compositeRecurrence, SWT.NONE);

		Label lblStartsOn = toolkit.createLabel(compositeRecurrence,
				"Starts On:", SWT.NONE);
		GridData gd_lblStartsOn = new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblStartsOn.widthHint = 70;
		lblStartsOn.setLayoutData(gd_lblStartsOn);
		lblStartsOn.setAlignment(SWT.RIGHT);

		dateChooserStartsOn = new DateChooserCombo(compositeRecurrence,
				SWT.BORDER | SWT.FLAT);
		GridData gd_dateChooserStartsOn = new GridData(SWT.LEFT, SWT.CENTER,
				false, false, 3, 1);
		gd_dateChooserStartsOn.heightHint = 19;
		dateChooserStartsOn.setLayoutData(gd_dateChooserStartsOn);
		toolkit.adapt(dateChooserStartsOn);
		toolkit.paintBordersFor(dateChooserStartsOn);
		new Label(compositeRecurrence, SWT.NONE);
		new Label(compositeRecurrence, SWT.NONE);

		// SECTION END OF JOB

		Section sctnJobEnd = toolkit.createSection(frmNewJob.getBody(),
				Section.EXPANDED | Section.TITLE_BAR);
		FormData fd_sctnJobEnd = new FormData();
		fd_sctnJobEnd.bottom = new FormAttachment(sctnRecurrence, 230);
		fd_sctnJobEnd.top = new FormAttachment(sctnRecurrence, 12);
		fd_sctnJobEnd.left = new FormAttachment(sctnDetails, 6);
		fd_sctnJobEnd.right = new FormAttachment(100, -12);
		sctnJobEnd.setLayoutData(fd_sctnJobEnd);
		toolkit.paintBordersFor(sctnJobEnd);
		sctnJobEnd.setText("End");
		sctnJobEnd.setExpanded(true);

		Composite compositeEndsOn = toolkit.createComposite(sctnJobEnd,
				SWT.NONE);
		toolkit.paintBordersFor(compositeEndsOn);
		sctnJobEnd.setClient(compositeEndsOn);
		compositeEndsOn.setLayout(new GridLayout(3, false));

		btnOn = toolkit.createButton(compositeEndsOn, "On: ", SWT.RADIO);
		btnOn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		GridData gd_btnOn = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1,
				1);
		gd_btnOn.widthHint = 70;
		btnOn.setLayoutData(gd_btnOn);

		dateChooserEndsOn = new DateChooserCombo(compositeEndsOn, SWT.BORDER
				| SWT.FLAT);
		GridData gd_dateChooserEndsOn = new GridData(SWT.LEFT, SWT.CENTER,
				false, false, 2, 1);
		gd_dateChooserEndsOn.heightHint = 19;
		dateChooserEndsOn.setLayoutData(gd_dateChooserEndsOn);
		toolkit.adapt(dateChooserEndsOn);
		toolkit.paintBordersFor(dateChooserEndsOn);

		btnAfter = toolkit.createButton(compositeEndsOn, "After:", SWT.RADIO);

		txtOccurences = toolkit.createText(compositeEndsOn, "New Text",
				SWT.NONE);
		GridData gd_txtOccurences = new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1);
		gd_txtOccurences.widthHint = 15;
		txtOccurences.setLayoutData(gd_txtOccurences);
		txtOccurences.setText("");

		toolkit.createLabel(compositeEndsOn, "Occurences", SWT.NONE);

		btnNever = toolkit.createButton(compositeEndsOn, "Never", SWT.RADIO);
		btnNever.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false,
				2, 1));
		new Label(compositeEndsOn, SWT.NONE);
		btnNever.setSelection(true);

		// SECTION SUMMARY

		Section sctnSummary = toolkit.createSection(frmNewJob.getBody(),
				Section.EXPANDED | Section.TITLE_BAR);
		fd_sctnDetails.bottom = new FormAttachment(0, 100);
		FormData fd_sctnSummary = new FormData();
		fd_sctnSummary.top = new FormAttachment(sctnJobEnd, 6);
		fd_sctnSummary.bottom = new FormAttachment(100, -12);
		fd_sctnSummary.left = new FormAttachment(0, 12);
		fd_sctnSummary.right = new FormAttachment(100, -12);
		sctnSummary.setLayoutData(fd_sctnSummary);
		toolkit.paintBordersFor(sctnSummary);
		sctnSummary.setText("Summary");

		Composite composite_3 = toolkit.createComposite(sctnSummary, SWT.NONE);
		toolkit.paintBordersFor(composite_3);
		sctnSummary.setClient(composite_3);
		composite_3.setLayout(new GridLayout(1, false));

		occurencesTableViewer = new TableViewer(composite_3, SWT.BORDER
				| SWT.FULL_SELECTION);
		table = occurencesTableViewer.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 4));
		toolkit.paintBordersFor(table);

		TableViewerColumn tableViewerColumn = new TableViewerColumn(
				occurencesTableViewer, SWT.NONE);
		TableColumn tblclmnDate = tableViewerColumn.getColumn();
		tblclmnDate.setWidth(100);
		tblclmnDate.setText("Date");

		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(
				occurencesTableViewer, SWT.NONE);
		TableColumn tblclmnTime = tableViewerColumn_1.getColumn();
		tblclmnTime.setWidth(100);
		tblclmnTime.setText("Time");

		occurencesTableViewer.setContentProvider(new ArrayContentProvider());
		occurencesTableViewer.setLabelProvider(new OccurenceLabelProvider());
		
		validationService.registerAllDecorators(txtJobName, lblJobName);
		
	}

	/**
	 * Shows date occurences.
	 * 
	 * @author dzonekl
	 */
	class OccurenceLabelProvider extends LabelProvider implements
			ITableLabelProvider {

		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		public String getColumnText(Object element, int columnIndex) {
			Date d = (Date) element;
			switch (columnIndex) {
			case 0: {
				return modelUtils.date(d);
			}
			case 1: {
				return modelUtils.time(d);
			}
			}

			return null;
		}

	}

	public EMFDataBindingContext initDataBindings_() {
		EMFDataBindingContext bindingContext = new EMFDataBindingContext();

		
		// Strategies
		EMFUpdateValueStrategy nameStrategy = validationService
				.getUpdateValueStrategyBeforeSet("Name is required");
		
		// JOB_NAME
		IObservableValue textObserveJobName = SWTObservables
				.observeDelayedValue(400,
						SWTObservables.observeText(this.txtJobName, SWT.Modify));

		IEMFValueProperty textJobNameValue = EMFProperties
				.value(SchedulingPackage.Literals.JOB__NAME);
		bindingContext.bindValue(textObserveJobName,
				textJobNameValue.observe(job), nameStrategy, null);

		comboViewerOn.setContentProvider(new ArrayContentProvider());
		comboViewerOn.setLabelProvider(new LabelProvider() {

			@Override
			public String getText(Object element) {
				return modelUtils.weekDay((Integer) element);
			}

		});
		comboViewerOn.setInput(modelUtils.weekDaysAsInteger().toArray());

		comboViewerEvery.setContentProvider(new ArrayContentProvider());
		comboViewerEvery.setInput(new Object[] { "Week", "Day", "Hour",
				"Quarter" });

		// The following binding is indirect through a series of writableValues.
		// / The writables, which will be deduced from various widgets by our
		// aggregator.
		IObservableValue startTimeWritableValue = new WritableValue();
		IObservableValue endTimeWritableValue = new WritableValue();
		IObservableValue intervalWritableValue = new WritableValue();
		IObservableValue repeatWritableValue = new WritableValue();

		// The aggregator.
		JobInfoAggregate aggregate = new JobInfoAggregate(
				startTimeWritableValue, endTimeWritableValue,
				intervalWritableValue, repeatWritableValue);

		// Observe the widgets with our aggregator.
		IObservableValue comboViewerOnObserveSingleSelection = ViewersObservables
				.observeSingleSelection(comboViewerOn);
		comboViewerOnObserveSingleSelection.addValueChangeListener(aggregate);

		IObservableValue comboViewerEveryObserveSingleSelection = ViewersObservables
				.observeSingleSelection(comboViewerEvery);
		comboViewerEveryObserveSingleSelection
				.addValueChangeListener(aggregate);

		IObservableValue comboObserveStartTime = new CDateTimeObservableValue(
				this.cdateTimeStartTime);
		comboObserveStartTime.addValueChangeListener(aggregate);

		IObservableValue dateChooseObserveStartDate = new DateChooserComboObservableValue(
				dateChooserStartsOn, SWT.Modify);
		dateChooseObserveStartDate.addValueChangeListener(aggregate);

		IObservableValue dateChooseObserveEndDate = new DateChooserComboObservableValue(
				dateChooserEndsOn, SWT.Modify);
		dateChooseObserveEndDate.addValueChangeListener(aggregate);

		IObservableValue endOnObservable = SWTObservables
				.observeSelection(btnOn);
		endOnObservable.addValueChangeListener(aggregate);
		IObservableValue endOccurencesObservable = SWTObservables
				.observeSelection(btnAfter);
		endOccurencesObservable.addValueChangeListener(aggregate);

		IObservableValue endNeverObservable = SWTObservables
				.observeSelection(btnNever);
		endNeverObservable.addValueChangeListener(aggregate);

		IObservableValue occurenceObservable = SWTObservables
				.observeDelayedValue(400, SWTObservables.observeText(
						this.txtOccurences, SWT.Modify));
		occurenceObservable.addValueChangeListener(aggregate);

		// Here we have the observables on the model side, these could be
		// aggregate
		IEMFValueProperty startTimeObserveValue = EMFProperties
				.value(SchedulingPackage.Literals.JOB__START_TIME);

		IEMFValueProperty endTimeObserveValue = EMFProperties
				.value(SchedulingPackage.Literals.JOB__END_TIME);

		IEMFValueProperty intervalObserveValue = EMFProperties
				.value(SchedulingPackage.Literals.JOB__INTERVAL);

		IEMFValueProperty repeatObserveValue = EMFProperties
				.value(SchedulingPackage.Literals.JOB__REPEAT);

		EMFUpdateValueStrategy targetToModelStrategy = new EMFUpdateValueStrategy();
		targetToModelStrategy.setConverter(new WeekDaysConverter());

		// TODO, add converters and validators.
		bindingContext
				.bindValue(startTimeWritableValue,
						startTimeObserveValue.observe(job),
						targetToModelStrategy, null);
		bindingContext.bindValue(endTimeWritableValue,
				endTimeObserveValue.observe(job), targetToModelStrategy, null);
		bindingContext.bindValue(intervalWritableValue,
				intervalObserveValue.observe(job), targetToModelStrategy, null);
		bindingContext.bindValue(repeatWritableValue,
				repeatObserveValue.observe(job), targetToModelStrategy, null);

		return bindingContext;
	}

	/**
	 * We try to aggregate all info from widgets, and fill the writable
	 * observables corresponding to: <code>JOB__START_TIME</code>
	 * 
	 * 
	 * @author dzonekl
	 * 
	 */
	private class JobInfoAggregate implements IValueChangeListener, IValidator {

		private IObservableValue startTimeObservable;
		private IObservableValue endTimeObservable;
		private IObservableValue intervalObservable;
		private IObservableValue repeatObservable;

		private Date startDate = modelUtils.todayAndNow();
		private Date endDate = null; // goes on when nil.
		private int occurences = -1; // goes on when 0
		private String interval = null;

		JobInfoAggregate(IObservableValue startTime, IObservableValue endTime,
				IObservableValue interval, IObservableValue repeat) {
			this.startTimeObservable = startTime;
			this.endTimeObservable = endTime;
			this.intervalObservable = interval;
			this.repeatObservable = repeat;
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
				if (control.equals(btnOn)) {
					// read the end date value
					endDate = dateChooserEndsOn.getValue();
					occurences = 0;
				}
				if (control.equals(btnAfter)) {
					endDate = null;
					// repeat. 
					try {
						occurences = new Integer(txtOccurences.getText());
					} catch (NumberFormatException nfe) {
						nfe.printStackTrace();
					}
				}
				if (control.equals(btnNever)) {
					endDate = null;
					occurences = -1;
				}
				if (control.equals(txtOccurences)) {
					try {
						occurences = new Integer((String) newValue);
					} catch (NumberFormatException nfe) {
						nfe.printStackTrace();
					}
				}
			}

			if (event.getObservable() instanceof CDateTimeObservableValue) {
				Date dateWithTime = (Date) newValue;

				if (dateWithTime == null) {
					// It could be that clear has been pressed on the widget,
					// so we reset the time to the current time.
					dateWithTime = modelUtils.todayAndNow();
				}
				startDate = modelUtils.mergeTimeIntoDate(startDate,
						dateWithTime);
			}

			if (event.getObservable() instanceof DateChooserComboObservableValue) {
				DateChooserCombo dc = ((DateChooserComboObservableValue) event
						.getObservable()).getDateChooserCombo();

				if (dc.equals(dateChooserEndsOn)) {
					Date newEndDate = (Date) newValue;
					this.endDate = newEndDate;
				}

				if (dc.equals(dateChooserStartsOn)) {
					// So we have a start day, and time, now we have date, we
					// keep
					// the day and time, and merge with the new date.
					// NOTE: As we override the date set by this widget.
					// This will perhaps confuse the end-user.
					Date newStartDate = (Date) newValue;
					startDate = modelUtils.mergeDateIntoTime(startDate,
							newStartDate);
				}
			}

			if (event.getObservable() instanceof IViewerObservableValue) {
				Viewer viewer = (Viewer) ((IViewerObservableValue) event
						.getObservable()).getViewer();
				System.out.println(viewer);

				if (viewer.equals(comboViewerOn)) {
					int dayOfWeek = (Integer) newValue;
					startDate = modelUtils.mergeDayIntoDate(startDate,
							dayOfWeek);

				}
				if (viewer.equals(comboViewerEvery)) {
					interval = (String) newValue;
				}

				//
				// if (control.equals(comboViewerOn)) {
				// pass = (String) newValue;
				// }
				// if (allSet()) {
				// startTime.setValue(pass);
				// }
			}
			allSet();
		}

		private boolean allSet() {
			// Calculate the new writablevalues.
			System.out.println(startDate);

			startTimeObservable.setValue(startDate);
			endTimeObservable.setValue(endDate);
			intervalObservable.setValue(interval != null ? modelUtils
					.inSeconds(interval) : 0);
			repeatObservable.setValue(occurences - 1 ); // Job holds repear, not occurences.

			// It would be nicer to observe the job for this.
			List<Date> occurences = NewEditJob.this.generateOccurences(job);
			occurencesTableViewer.setInput(occurences.toArray());

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

	class WeekDaysConverter extends Converter {
		public WeekDaysConverter() {
			super(Date.class, XMLGregorianCalendar.class);
		}

		public Object convert(Object fromObject) {
			if (fromObject instanceof Date) {
				return modelUtils.toXMLDate((Date) fromObject);
			}
			return fromObject;
		}
	}

	public void handleValidationStateChange(ValidationEvent event) {
		if (event instanceof FormValidationEvent) {
			int type = ((FormValidationEvent) event).getMsgType();
			List<IMessage> list = ((FormValidationEvent) event).getMessages();
			if (frmNewJob.isDisposed()
					|| frmNewJob.getHead().isDisposed()) {
				return;
			}

			if (type != IMessage.NONE) {

				String errorType = "";
				if (type == IMessage.ERROR) {
					errorType = "Error:";
				}
				if (type == IMessage.WARNING) {
					errorType = "Required:";
				}

				StringBuffer msgBuffer = new StringBuffer();
				msgBuffer.append(errorType + "(" + list.size() + "), "
						+ list.get(0).getMessage());
				frmNewJob.setMessage(msgBuffer.toString(), type,
						list.toArray(new IMessage[list.size()]));

			} else {
				frmNewJob.setMessage(null);
			}
		}

	}

	public void injectData(Object owner, Object object) {

		if (owner instanceof Resource) {
			this.owner = (Resource) owner;
		}
		if (object != null && object instanceof Job) {
			if (Screens.isEditOperation(this.getOperation())) {
				Job copy = EcoreUtil.copy((Job) object);
				job = copy;
				original = (Job) object;
			} else if (Screens.isNewOperation(getOperation())) {
				job = (Job) object;
			}
		}
		
		bindingContext = initDataBindings_();
		
		if (!Screens.isReadOnlyOperation(getOperation())) {
			validationService.registerBindingContext(bindingContext);
			validationService.addValidationListener(this);
		}

	}

	public void addData() {
		if (Screens.isNewOperation(getOperation()) && owner != null) {
			// If new, we have been operating on an object not added yet.
			Command c = new AddCommand(editingService.getEditingDomain(),
					owner.getContents(), job);
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
					owner.getContents(), original, job);
			editingService.getEditingDomain().getCommandStack().execute(c);

		}
		// After our edit, we shall be dirty
		if (editingService.isDirty()) {
			editingService.doSave(new NullProgressMonitor());
		}
	}

	private List<Date> generateOccurences(Job job) {
		return ImmutableList.copyOf(modelUtils.occurences(
				modelUtils.fromXMLDate(job.getStartTime()),
				job.getEndTime() != null ? modelUtils.fromXMLDate(job
						.getEndTime()) : null, job.getInterval(), job
						.getRepeat()));
	}

	@Override
	public Viewer getViewer() {
		// We don't have a specific viewer.
		return null;
	}

	@Override
	public boolean isValid() {
		return validationService.isValid();
	}

	@Override
	public Form getScreenForm() {
		return frmNewJob;
	}
}
