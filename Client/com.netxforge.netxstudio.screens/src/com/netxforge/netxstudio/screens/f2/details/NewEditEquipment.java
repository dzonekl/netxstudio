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

public class NewEditEquipment extends AbstractNewEditComponent implements IScreen {

	private Text txtDescription;
	private Text txtCode;
	private ComboViewer cmbViewerExpansionDuration;

	public NewEditEquipment(Composite parent, int style,
			final IEditingService editingService) {
		super(parent, style, editingService);
		// buildUI();
	}

	public boolean isValid() {
		return false;
	}

	public void buildUI() {
		super.buildUI();
		buildInfoSection();
		buildResourceSection();
		buildMetricSection();
		buildToleranceSection();
	}

	private void buildInfoSection() {
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

		cmbViewerExpansionDuration = new ComboViewer(composite, widgetStyle);
		Combo cmbExpansionDuration = cmbViewerExpansionDuration.getCombo();
		cmbExpansionDuration.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				false, false, 1, 1));
		toolkit.paintBordersFor(cmbExpansionDuration);

		if(readOnly){
			cmbExpansionDuration.setEnabled(false);
		}
	}

	public EMFDataBindingContext initDataBindings_() {
		EMFDataBindingContext context = super.initDataBindings_();

		bindResourcesSection(context);
		bindToleranceSection();
		bindMetricSection();

		IObservableValue codeObservable = SWTObservables.observeDelayedValue(
				400, SWTObservables.observeText(txtCode, SWT.Modify));

		IEMFValueProperty codeProperty = EMFEditProperties.value(
				editingService.getEditingDomain(),
				LibraryPackage.Literals.EQUIPMENT__EQUIPMENT_CODE);

		context.bindValue(codeObservable, codeProperty.observe(comp), null,
				null);

		IObservableValue descriptionObservable = SWTObservables
				.observeDelayedValue(400,
						SWTObservables.observeText(txtDescription, SWT.Modify));

		IEMFValueProperty componentDescriptionProperty = EMFEditProperties
				.value(editingService.getEditingDomain(),
						LibraryPackage.Literals.COMPONENT__DESCRIPTION);

		context.bindValue(descriptionObservable,
				componentDescriptionProperty.observe(comp), null, null);

		bindDurationSection(context);

		return context;
	}

	protected void bindDurationSection(EMFDataBindingContext context) {

		IObservableValue expansionDurationObservable;
		// Expansion duration binding.
		cmbViewerExpansionDuration
				.setContentProvider(new ArrayContentProvider());
		cmbViewerExpansionDuration.setLabelProvider(new LabelProvider());
		cmbViewerExpansionDuration.setInput(ExpansionDuration.VALUES);

		IValueProperty selectionProperty = ViewerProperties.singleSelection();
		expansionDurationObservable = selectionProperty
				.observe(cmbViewerExpansionDuration);

		IEMFValueProperty durationProperty = EMFEditProperties.value(
				editingService.getEditingDomain(),
				LibraryPackage.Literals.COMPONENT__DURATION);

		context.bindValue(expansionDurationObservable,
				durationProperty.observe(comp), null, null);
	}

}
