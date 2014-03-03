package com.netxforge.netxstudio.screens.f1.support;

import java.util.Date;

import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.StudioUtils;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.screens.editing.util.MementoUtil;
import com.netxforge.netxstudio.screens.f3.PeriodComponent;

public class PeriodSelectionPage extends WizardPage {

	private final FormToolkit formToolkit = new FormToolkit(
			Display.getDefault());

	private static final String REPORTING_PERIOD_START = "reporting_period_start";
	private static final String REPORTING_PERIOD_END = "reporting_period_end";

	@Inject
	private PeriodComponent periodComponent;

	@Inject
	private MementoUtil mementoUtil;

	/**
	 * Create the wizard.
	 */
	public PeriodSelectionPage() {
		super("wizardPage");

		setTitle("Period Selection");
		setDescription("Specify the date and time for start and end time of the period.");
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

		restoreDialogSettings();

//		this.initiBinding();
	}

	private void restoreDialogSettings() {
		IDialogSettings ds = getDialogSettings();
		if (ds != null) {
			Date start = mementoUtil.retrieveDate(ds, REPORTING_PERIOD_START);
			Date end = mementoUtil.retrieveDate(ds, REPORTING_PERIOD_END);
			if (start != null && end != null) {
				setPeriod(start, end);
				return;
			}
		}
		initiBinding();
	}

	private void initiBinding() {

		periodComponent.presetLastQuarter();

	}

	public DateTimeRange period() {
		return periodComponent.getPeriod();
	}

	public void setPeriod(DateTimeRange dtr) {
		this.periodComponent.setPeriod(dtr);
	}

	public void setPeriod(Date from, Date to) {
		this.periodComponent.setPeriod(from, to);
	}

	public void finish() {

		DateTimeRange dtr = period();

		Date fromDate = StudioUtils.begin(dtr);
		Date toDate = StudioUtils.end(dtr);

		mementoUtil.rememberDate(this.getDialogSettings(), fromDate,
				REPORTING_PERIOD_START);
		mementoUtil.rememberDate(this.getDialogSettings(), toDate,
				REPORTING_PERIOD_END);

	}

}
