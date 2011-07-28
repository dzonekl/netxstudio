package com.netxforge.netxstudio.screens.details;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.IEMFValueProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

import com.netxforge.netxstudio.operators.Network;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.screens.editing.IEditingService;
import com.netxforge.netxstudio.screens.editing.selector.IDataScreenInjection;
import com.netxforge.netxstudio.screens.editing.selector.IScreen;

public class NewEditNetwork extends AbstractDetailsComposite implements
		IScreen, IDataScreenInjection {

	private Network comp;
	private FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Text txtName;
	private Text txtDescription;
	private IEditingService editingService;

	public NewEditNetwork(Composite parent, int style,
			final IEditingService editingService) {
		super(parent, style);
		this.editingService = editingService;
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
		buildUI();
	}

	public void injectData(Object owner, Object object) {
		if (object instanceof Network) {
			this.comp = (Network) object;
		} else {
			return;
		}
		this.initDataBindings_();
	}

	public boolean isValid() {
		return false;
	}

	private void buildUI() {

		Section scnInfo = toolkit.createSection(this, Section.EXPANDED
				| Section.TITLE_BAR);
		FormData fd_scnInfo = new FormData();
		fd_scnInfo.top = new FormAttachment(0, 10);
		fd_scnInfo.left = new FormAttachment(0, 10);
		fd_scnInfo.bottom = new FormAttachment(0, 180);
		fd_scnInfo.right = new FormAttachment(100, -14);
		scnInfo.setLayoutData(fd_scnInfo);
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

		txtName = toolkit.createText(composite, "New Text", SWT.NONE);
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
				| SWT.WRAP | SWT.MULTI);
		txtDescription.setText("");
		GridData gd_text = new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1);
		gd_text.heightHint = 100;
		gd_text.widthHint = 200;
		txtDescription.setLayoutData(gd_text);
	}

	public EMFDataBindingContext initDataBindings_() {
		EMFDataBindingContext context = new EMFDataBindingContext();

		// Binding of name and Description

		IObservableValue nameObservable = SWTObservables.observeDelayedValue(
				400, SWTObservables.observeText(txtName, SWT.Modify));
		IObservableValue descriptionObservable = SWTObservables
				.observeDelayedValue(400,
						SWTObservables.observeText(txtDescription, SWT.Modify));

		IEMFValueProperty nameProperty = EMFEditProperties.value(
				editingService.getEditingDomain(),
				OperatorsPackage.Literals.NETWORK__NAME);

		IEMFValueProperty componentDescriptionProperty = EMFEditProperties
				.value(editingService.getEditingDomain(),
						OperatorsPackage.Literals.NETWORK__DESCRIPTION);

		context.bindValue(nameObservable, nameProperty.observe(comp), null,
				null);
		context.bindValue(descriptionObservable,
				componentDescriptionProperty.observe(comp), null, null);

		return context;
	}
}
