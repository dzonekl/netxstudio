package com.netxforge.netxstudio.screens.f2.details;

import java.util.Date;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.EMFUpdateValueStrategy;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.databinding.IEMFValueProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.nebula.widgets.datechooser.DateChooserCombo;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.Section;

import com.netxforge.netxstudio.generics.ExpansionDuration;
import com.netxforge.netxstudio.generics.GenericsFactory;
import com.netxforge.netxstudio.generics.GenericsPackage;
import com.netxforge.netxstudio.generics.Lifecycle;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.screens.DateChooserComboObservableValue;
import com.netxforge.netxstudio.screens.editing.IEditingService;
import com.netxforge.netxstudio.screens.editing.selector.IScreen;
import com.netxforge.netxstudio.screens.editing.selector.Screens;

public class NewEditNodeEquipment extends NewEditComponent implements
		IScreen {

	private Text txtName;
	private Text txtDescription;
	private ComboViewer cmbViewerExpansionDuration;
	
	private DateChooserCombo dcProposed;
	private DateChooserCombo dcPlanned;
	private DateChooserCombo dcConstruction;
	private DateChooserCombo dcInService;
	private DateChooserCombo dcOutOfService;
	
	
	public NewEditNodeEquipment(Composite parent, int style,
			final IEditingService editingService) {
		super(parent, style, editingService);
//		buildUI();
	}

	public boolean isValid() {
		return false;
	}

	public void buildUI() {

		// Readonlyness.
		boolean readonly = Screens.isReadOnlyOperation(this.getOperation());
		int widgetStyle = readonly ? SWT.READ_ONLY : SWT.NONE;
		
		buildInfoSection(widgetStyle);
		buildLifeCycleSection(readonly);
		buildResourceSection(readonly);
		buildMetricSection(readonly);
		buildToleranceSection(readonly);
		
	}

	private void buildLifeCycleSection(boolean readonly) {
		
		Section sctnLifecycle = toolkit.createSection(this, Section.TITLE_BAR | Section.TWISTIE);
		toolkit.paintBordersFor(sctnLifecycle);
		sctnLifecycle.setText("Lifecycle");

		Composite cmpLifeCycle = toolkit
				.createComposite(sctnLifecycle, SWT.NONE);
		toolkit.paintBordersFor(cmpLifeCycle);
		sctnLifecycle.setClient(cmpLifeCycle);
		cmpLifeCycle.setLayout(new GridLayout(2, false));

		Label lblProposed = toolkit.createLabel(cmpLifeCycle, "Proposed:",
				SWT.NONE);
		lblProposed.setAlignment(SWT.RIGHT);
		GridData gd_lblProposed = new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblProposed.widthHint = 70;
		lblProposed.setLayoutData(gd_lblProposed);

		dcProposed = new DateChooserCombo(cmpLifeCycle, SWT.BORDER | SWT.FLAT);
		GridData gd_dcProposed = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_dcProposed.heightHint = 20;
		dcProposed.setLayoutData(gd_dcProposed);
		toolkit.adapt(dcProposed);
		toolkit.paintBordersFor(dcProposed);

		Label lblPlanned = toolkit.createLabel(cmpLifeCycle, "Planned:",
				SWT.NONE);
		lblPlanned.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		lblPlanned.setAlignment(SWT.RIGHT);

		dcPlanned = new DateChooserCombo(cmpLifeCycle, SWT.BORDER | SWT.FLAT);
		GridData gd_dcPlanned = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_dcPlanned.heightHint = 20;
		dcPlanned.setLayoutData(gd_dcPlanned);
		toolkit.adapt(dcPlanned);
		toolkit.paintBordersFor(dcPlanned);

		Label lblConstruction = toolkit.createLabel(cmpLifeCycle,
				"Construction:", SWT.NONE);
		lblConstruction.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
				false, false, 1, 1));

		dcConstruction = new DateChooserCombo(cmpLifeCycle, SWT.BORDER
				| SWT.FLAT);
		GridData gd_dcConstruction = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_dcConstruction.heightHint = 20;
		dcConstruction.setLayoutData(gd_dcConstruction);
		toolkit.adapt(dcConstruction);
		toolkit.paintBordersFor(dcConstruction);

		Label lblInService = toolkit.createLabel(cmpLifeCycle, "In Service:",
				SWT.NONE);
		lblInService.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		lblInService.setAlignment(SWT.RIGHT);

		dcInService = new DateChooserCombo(cmpLifeCycle, SWT.BORDER | SWT.FLAT);
		GridData gd_dcInService = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_dcInService.heightHint = 20;
		dcInService.setLayoutData(gd_dcInService);
		toolkit.adapt(dcInService);
		toolkit.paintBordersFor(dcInService);

		Label lblOutOfService = toolkit.createLabel(cmpLifeCycle,
				"Out of Service:", SWT.NONE);
		GridData gd_lblOutOfService = new GridData(SWT.RIGHT, SWT.CENTER,
				false, false, 1, 1);
		gd_lblOutOfService.widthHint = 80;
		lblOutOfService.setLayoutData(gd_lblOutOfService);

		dcOutOfService = new DateChooserCombo(cmpLifeCycle, SWT.BORDER
				| SWT.FLAT);
		GridData gd_dcOutOfService = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_dcOutOfService.heightHint = 20;
		dcOutOfService.setLayoutData(gd_dcOutOfService);
		dcOutOfService.setWeeksVisible(true);
		toolkit.adapt(dcOutOfService);
		toolkit.paintBordersFor(dcOutOfService);
	}

	private void buildInfoSection(int widgetStyle) {
		Section scnInfo = toolkit.createSection(this, Section.EXPANDED
				| Section.TITLE_BAR);
		toolkit.paintBordersFor(scnInfo);
		scnInfo.setText("Info");

		Composite composite = toolkit.createComposite(scnInfo, SWT.NONE);
		toolkit.paintBordersFor(composite);
		scnInfo.setClient(composite);
		composite.setLayout(new GridLayout(2, false));

		Label lblName = toolkit.createLabel(composite, "Name:", SWT.NONE);
		lblName.setAlignment(SWT.RIGHT);
		GridData gd_lblName = new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1);
		gd_lblName.widthHint = 70;
		lblName.setLayoutData(gd_lblName);

		txtName = toolkit.createText(composite, "New Text", SWT.NONE
				| widgetStyle);
		txtName.setText("");
		GridData gd_txtName = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_txtName.widthHint = 200;
		txtName.setLayoutData(gd_txtName);

		Label lblDescription = toolkit.createLabel(composite, "Description:",
				SWT.NONE);
		lblDescription.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false,
				false, 1, 1));
		lblDescription.setAlignment(SWT.RIGHT);

		txtDescription = toolkit.createText(composite, "New Text", SWT.BORDER
				| SWT.WRAP | SWT.MULTI | widgetStyle);
		txtDescription.setText("");
		GridData gd_text = new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1);
		gd_text.heightHint = 62;
		gd_text.widthHint = 200;
		txtDescription.setLayoutData(gd_text);

		Label lblExpansion = toolkit.createLabel(composite, "Expansion:",
				SWT.NONE);
		lblExpansion.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));

		cmbViewerExpansionDuration = new ComboViewer(composite, SWT.NONE);
		Combo cmbExpansionDuration = cmbViewerExpansionDuration.getCombo();
		cmbExpansionDuration.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				false, false, 1, 1));
		toolkit.paintBordersFor(cmbExpansionDuration);
	}

	public EMFDataBindingContext initDataBindings_() {
		EMFDataBindingContext context = super.initDataBindings_();
		
		super.bindResourcesSection(context);
		super.bindMetricSection();
		super.bindToleranceSection();
		
		bindInfo(context);
		bindLifeCycle(context);
		
		return context;
	}

	private void bindInfo(EMFDataBindingContext context) {
		// Binding of name and Description

		IObservableValue nameObservable = SWTObservables.observeDelayedValue(
				400, SWTObservables.observeText(txtName, SWT.Modify));

		IObservableValue descriptionObservable = SWTObservables
				.observeDelayedValue(400,
						SWTObservables.observeText(txtDescription, SWT.Modify));

		IEMFValueProperty componentNameProperty = EMFEditProperties.value(
				editingService.getEditingDomain(),
				LibraryPackage.Literals.COMPONENT__NAME);

		IEMFValueProperty componentDescriptionProperty = EMFEditProperties
				.value(editingService.getEditingDomain(),
						LibraryPackage.Literals.COMPONENT__DESCRIPTION);

		// Expansion duration binding. 
		cmbViewerExpansionDuration
				.setContentProvider(new ArrayContentProvider());
		cmbViewerExpansionDuration.setLabelProvider(new LabelProvider());
		cmbViewerExpansionDuration.setInput(ExpansionDuration.VALUES);

		IEMFValueProperty durationProperty = EMFEditProperties.value(
				editingService.getEditingDomain(),
				LibraryPackage.Literals.EQUIPMENT__DURATION);
		IValueProperty selectionProperty = ViewerProperties.singleSelection();
		IObservableValue expansionDurationObservable = selectionProperty
				.observe(cmbViewerExpansionDuration);
		context.bindValue(expansionDurationObservable,
				durationProperty.observe(comp), null, null);

		context.bindValue(nameObservable, componentNameProperty.observe(comp),
				null, null);
		context.bindValue(descriptionObservable,
				componentDescriptionProperty.observe(comp), null, null);
	}

	private void bindLifeCycle(EMFDataBindingContext context) {
		IObservableValue dcProposedObservable = new DateChooserComboObservableValue(
				dcProposed, SWT.Modify);

		IObservableValue dcPlannedObservable = new DateChooserComboObservableValue(
				dcPlanned, SWT.Modify);

		IObservableValue dcConstructionObservable = new DateChooserComboObservableValue(
				dcConstruction, SWT.Modify);

		IObservableValue dcInServiceObservable = new DateChooserComboObservableValue(
				dcInService, SWT.Modify);

		IObservableValue dcOutOfServiceObservable = new DateChooserComboObservableValue(
				dcOutOfService, SWT.Modify);

		IEMFValueProperty proposedProperty = EMFEditProperties.value(
				editingService.getEditingDomain(), FeaturePath.fromList(
						LibraryPackage.Literals.EQUIPMENT__LIFECYCLE,
						GenericsPackage.Literals.LIFECYCLE__PROPOSED));

		IEMFValueProperty plannedProperty = EMFEditProperties.value(
				editingService.getEditingDomain(), FeaturePath.fromList(
						LibraryPackage.Literals.EQUIPMENT__LIFECYCLE,
						GenericsPackage.Literals.LIFECYCLE__PLANNED_DATE));

		IEMFValueProperty constructionProperty = EMFEditProperties.value(
				editingService.getEditingDomain(), FeaturePath.fromList(
						LibraryPackage.Literals.EQUIPMENT__LIFECYCLE,
						GenericsPackage.Literals.LIFECYCLE__CONSTRUCTION_DATE));

		IEMFValueProperty inServiceProperty = EMFEditProperties.value(
				editingService.getEditingDomain(), FeaturePath.fromList(
						LibraryPackage.Literals.EQUIPMENT__LIFECYCLE,
						GenericsPackage.Literals.LIFECYCLE__IN_SERVICE_DATE));

		IEMFValueProperty outOfServiceProperty = EMFEditProperties
				.value(editingService.getEditingDomain(),
						FeaturePath
								.fromList(
										LibraryPackage.Literals.EQUIPMENT__LIFECYCLE,
										GenericsPackage.Literals.LIFECYCLE__OUT_OF_SERVICE_DATE));

		EMFUpdateValueStrategy modelToTargetUpdateStrategy = new EMFUpdateValueStrategy();
		modelToTargetUpdateStrategy.setConverter(new IConverter() {

			public Object getFromType() {
				return XMLGregorianCalendar.class;
			}

			public Object getToType() {
				return Date.class;
			}

			public Object convert(Object fromObject) {
				return modelUtils
						.fromXMLDate((XMLGregorianCalendar) fromObject);
			}
		});

		EMFUpdateValueStrategy targetToModelUpdateStrategy = new EMFUpdateValueStrategy();
		targetToModelUpdateStrategy.setConverter(new IConverter() {

			public Object getFromType() {
				return Date.class;
			}

			public Object getToType() {

				return XMLGregorianCalendar.class;
			}

			public Object convert(Object fromObject) {
				return modelUtils.toXMLDate((Date) fromObject);
			}
		});

		// Create a new lifecycle if non-existent.
		if (((Equipment) comp).getLifecycle() == null) {
			Lifecycle newLC = GenericsFactory.eINSTANCE.createLifecycle();
			((Equipment) comp).setLifecycle(newLC);
		}

		context.bindValue(dcProposedObservable, proposedProperty.observe(comp),
				targetToModelUpdateStrategy, modelToTargetUpdateStrategy);

		context.bindValue(dcPlannedObservable, plannedProperty.observe(comp),
				targetToModelUpdateStrategy, modelToTargetUpdateStrategy);

		context.bindValue(dcConstructionObservable,
				constructionProperty.observe(comp),
				targetToModelUpdateStrategy, modelToTargetUpdateStrategy);

		context.bindValue(dcInServiceObservable,
				inServiceProperty.observe(comp), targetToModelUpdateStrategy,
				modelToTargetUpdateStrategy);

		context.bindValue(dcOutOfServiceObservable,
				outOfServiceProperty.observe(comp),
				targetToModelUpdateStrategy, modelToTargetUpdateStrategy);
	}
}
