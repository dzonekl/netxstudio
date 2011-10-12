package com.netxforge.netxstudio.screens.f1.support;

import java.util.Date;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.nebula.widgets.cdatetime.CDT;
import org.eclipse.nebula.widgets.cdatetime.CDateTime;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.generics.DateTimeRange;

public class ReportSelectionPeriodPage extends WizardPage {

	private final FormToolkit formToolkit = new FormToolkit(
			Display.getDefault());

	private CDateTime startDate;
	private CDateTime startTime;
	private CDateTime endDate;
	private CDateTime endTime;
	private ModelUtils modelUtils;

	private Composite composite_1;

	/**
	 * Create the wizard.
	 */
	public ReportSelectionPeriodPage(ModelUtils modelUtils) {
		super("wizardPage");

		this.modelUtils = modelUtils;
		setTitle("Reporting period");
		setDescription("Specify the date and time for start and end time of the report.");
	}

	/**
	 * Create contents of the wizard.
	 * 
	 * @param parent
	 */
	public void createControl(Composite parent) {
		
		composite_1 = formToolkit.createComposite(parent, SWT.NONE);
		formToolkit.paintBordersFor(composite_1);
		composite_1.setLayout(new GridLayout(5, false));

		Label lblFrom = formToolkit.createLabel(composite_1, "From:",
				SWT.NONE);
		lblFrom.setAlignment(SWT.RIGHT);
		GridData gd_lblFrom = new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1);
		gd_lblFrom.widthHint = 70;
		lblFrom.setLayoutData(gd_lblFrom);

		startDate = new CDateTime(composite_1, CDT.BORDER
				| CDT.DROP_DOWN | CDT.DATE_MEDIUM);
		startDate.setSelection(modelUtils.oneMonthAgo());
		formToolkit.adapt(startDate);
		formToolkit.paintBordersFor(startDate);

		Label lblAt = formToolkit.createLabel(composite_1, "At:",
				SWT.NONE);
		lblAt.setAlignment(SWT.RIGHT);
		GridData gd_lblAt = new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1);
		gd_lblAt.widthHint = 70;
		lblAt.setLayoutData(gd_lblAt);

		startTime = new CDateTime(composite_1, CDT.BORDER
				| CDT.CLOCK_24_HOUR | CDT.DROP_DOWN | CDT.TIME_MEDIUM);
		startTime.setSelection(modelUtils.oneMonthAgo());
		formToolkit.adapt(startTime);
		formToolkit.paintBordersFor(startTime);
		new Label(composite_1, SWT.NONE);

		Label lblTo = formToolkit.createLabel(composite_1, "To:",
				SWT.NONE);
		lblTo.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1));
		lblTo.setAlignment(SWT.RIGHT);

		endDate = new CDateTime(composite_1, CDT.BORDER | CDT.DROP_DOWN
				| CDT.DATE_MEDIUM);
		endDate.setSelection(modelUtils.todayAndNow());
		GridData gd_dateTime_2 = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_dateTime_2.heightHint = 19;
		endDate.setLayoutData(gd_dateTime_2);
		formToolkit.adapt(endDate);
		formToolkit.paintBordersFor(endDate);

		Label lblAt_1 = formToolkit.createLabel(composite_1, "At:",
				SWT.NONE);
		lblAt_1.setAlignment(SWT.RIGHT);
		lblAt_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1));

		endTime = new CDateTime(composite_1, CDT.BORDER
				| CDT.CLOCK_24_HOUR | CDT.DROP_DOWN | CDT.TIME_MEDIUM);
		endTime.setSelection(modelUtils.todayAndNow());
		formToolkit.adapt(endTime);
		formToolkit.paintBordersFor(endTime);
		new Label(composite_1, SWT.NONE);
		setControl(composite_1);
	}

	public DateTimeRange period() {

		Date sDate = startDate.getSelection();
		Date sTime = startTime.getSelection();

		Date start = modelUtils.mergeTimeIntoDate(sDate, sTime);

		Date eDate = endDate.getSelection();
		Date eTime = endTime.getSelection();

		Date end = modelUtils.mergeTimeIntoDate(eDate, eTime);

		return modelUtils.period(start, end);
	}

}
