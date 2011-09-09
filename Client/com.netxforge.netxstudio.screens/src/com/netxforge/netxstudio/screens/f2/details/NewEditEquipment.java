package com.netxforge.netxstudio.screens.f2.details;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.IEMFValueProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.Section;

import com.netxforge.netxstudio.generics.ExpansionDuration;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.screens.editing.IEditingService;
import com.netxforge.netxstudio.screens.editing.selector.IScreen;
import com.netxforge.netxstudio.screens.editing.selector.Screens;

public class NewEditEquipment extends NewEditComponent implements
		IScreen {

	private Text txtDescription;
	private Text txtCode;
	private ComboViewer cmbViewerExpansionDuration;

	public NewEditEquipment(Composite parent, int style,
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
		buildResourceSection(readonly);
		buildMetricSection(readonly);
		buildToleranceSection(readonly);
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

		Label lblCode = toolkit.createLabel(composite, "Code:", SWT.NONE);
		lblCode.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1));

		txtCode = toolkit.createText(composite, "New Text", SWT.NONE
				| widgetStyle);
		txtCode.setText("");
		txtCode.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false,
				1, 1));

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
		
		bindResourcesSection(context);
		bindToleranceSection();
		bindMetricSection();
		
		IObservableValue codeObservable = SWTObservables.observeDelayedValue(
				400, SWTObservables.observeText(txtCode, SWT.Modify));

		IObservableValue descriptionObservable = SWTObservables
				.observeDelayedValue(400,
						SWTObservables.observeText(txtDescription, SWT.Modify));


		IEMFValueProperty codeProperty = EMFEditProperties.value(
				editingService.getEditingDomain(),
				LibraryPackage.Literals.EQUIPMENT__EQUIPMENT_CODE);

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

		context.bindValue(codeObservable, codeProperty.observe(comp), null,
				null);
		context.bindValue(descriptionObservable,
				componentDescriptionProperty.observe(comp), null, null);
		

		return context;
	}
}
