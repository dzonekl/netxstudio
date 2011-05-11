package com.netxforge.netxstudio.emf.poi.ui.wizards;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;

import com.netxforge.netxstudio.emf.poi.ui.PoiTemplateRegistryImpl;

public class PoiSelectWizardPage extends WizardPage {

	@Override
	public IWizardPage getNextPage() {
		return ((PoiExportWizard)getWizard()).getPoiExportFilePage();
	}

	private FormToolkit toolkit;
	private ScrolledForm form;
	private Object selection;

	protected PoiSelectWizardPage(String pageName) {
		super(pageName);
	}

	@Override
	public void createControl(Composite parent) {
		toolkit = new FormToolkit(parent.getDisplay());
		form = toolkit.createScrolledForm(parent);
		form.setText(Messages.PoiSelectWizardPage_0);

		GridLayout layout = new GridLayout();
		form.getBody().setLayout(layout);

		Composite sectionClient = toolkit.createComposite(form.getBody());
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		sectionClient.setLayoutData(data);
		GridLayout layout1 = new GridLayout();
		layout1.numColumns = 2;
		sectionClient.setLayout(layout1);
		
		Label comboLabel = toolkit.createLabel(sectionClient,
				Messages.PoiSelectWizardPage_2);
		data = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
		comboLabel.setLayoutData(data);

		final CCombo combo = new CCombo(sectionClient, SWT.FLAT
				| SWT.READ_ONLY | SWT.BORDER);
		// combo.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		data = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
		data.grabExcessHorizontalSpace = true;
		data.widthHint = 300;
		combo.setLayoutData(data);
		// toolkit.paintBordersFor(parent);
		// combo.setSize(400, 18);

		combo.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				selection = combo.getItems()[combo.getSelectionIndex()];
				PoiTemplateRegistryImpl.INSTANCE.getTemplate((String)selection);
				// Good choice :-) 
			};
		});
		combo.setItems(PoiTemplateRegistryImpl.INSTANCE.getTemplateDescriptions());
		combo.select(0); // Doesn't fire selection change, so we set it manually.
		selection =  PoiTemplateRegistryImpl.INSTANCE.getTemplateDescriptions()[0];
		this.setControl(form);
	}
	
	
	// Forces finish to be enabled at the end of the wizard. 
	// Without completing this page, it would not be.
	@Override
	public boolean isPageComplete() {
		this.setErrorMessage(null);
		return true;
	}

	public String getPoiTemplateSelection() {
		return (String) selection;
	}

}
