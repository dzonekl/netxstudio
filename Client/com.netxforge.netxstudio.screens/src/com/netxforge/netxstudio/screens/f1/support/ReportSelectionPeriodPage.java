package com.netxforge.netxstudio.screens.f1.support;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.google.inject.Inject;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.screens.f2.PeriodComponent;

public class ReportSelectionPeriodPage extends WizardPage {

	private final FormToolkit formToolkit = new FormToolkit(
			Display.getDefault());

	@Inject
	private PeriodComponent periodComponent;

	/**
	 * Create the wizard.
	 */
	public ReportSelectionPeriodPage() {
		super("wizardPage");

		setTitle("Reporting period");
		setDescription("Specify the date and time for start and end time of the report.");
	}

	/**
	 * Create contents of the wizard.
	 * 
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite placeHolder = formToolkit.createComposite(parent, SWT.NONE);
		formToolkit.paintBordersFor(placeHolder);
		placeHolder.setLayout(new GridLayout(2, false));

		periodComponent.setShowBorder(false);
		periodComponent.buildUI(placeHolder, new GridData(SWT.LEFT, SWT.CENTER,
				true, false));
		setControl(placeHolder);

		this.initiBinding();
	}

	private void initiBinding() {

		periodComponent.presetLastQuarter();

	}

	public DateTimeRange period() {

		return periodComponent.getPeriod();
	}

}
