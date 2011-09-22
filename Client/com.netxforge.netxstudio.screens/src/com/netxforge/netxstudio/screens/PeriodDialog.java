package com.netxforge.netxstudio.screens;

import java.util.Date;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.nebula.widgets.cdatetime.CDT;
import org.eclipse.nebula.widgets.cdatetime.CDateTime;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.generics.DateTimeRange;

public class PeriodDialog extends Dialog {
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private CDateTime startDate;
	private CDateTime startTime;
	private CDateTime endDate;
	private CDateTime endTime;
	private ModelUtils modelUtils;
	
	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public PeriodDialog(Shell parentShell, ModelUtils modelUtils) {
		super(parentShell);
		setShellStyle(SWT.TITLE);
		this.modelUtils = modelUtils;
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Form frmPeriod = formToolkit.createForm(container);
		frmPeriod.setSeparatorVisible(true);
		formToolkit.paintBordersFor(frmPeriod);
		frmPeriod.setText("Period");
		frmPeriod.getBody().setLayout(new GridLayout(5, false));
		
		Label lblFrom = formToolkit.createLabel(frmPeriod.getBody(), "From:", SWT.NONE);
		lblFrom.setAlignment(SWT.RIGHT);
		GridData gd_lblFrom = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_lblFrom.widthHint = 70;
		lblFrom.setLayoutData(gd_lblFrom);
		
		startDate = new CDateTime(frmPeriod.getBody(), CDT.BORDER | CDT.DROP_DOWN | CDT.DATE_MEDIUM);
		startDate.setSelection(modelUtils.oneMonthAgo());
		formToolkit.adapt(startDate);
		formToolkit.paintBordersFor(startDate);
		
		Label lblAt = formToolkit.createLabel(frmPeriod.getBody(), "At:", SWT.NONE);
		lblAt.setAlignment(SWT.RIGHT);
		GridData gd_lblAt = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_lblAt.widthHint = 70;
		lblAt.setLayoutData(gd_lblAt);
		
		startTime = new CDateTime(frmPeriod.getBody(), CDT.BORDER | CDT.CLOCK_24_HOUR | CDT.DROP_DOWN | CDT.TIME_MEDIUM);
		startTime.setSelection(modelUtils.oneMonthAgo());
		formToolkit.adapt(startTime);
		formToolkit.paintBordersFor(startTime);
		new Label(frmPeriod.getBody(), SWT.NONE);
		
		Label lblTo = formToolkit.createLabel(frmPeriod.getBody(), "To:", SWT.NONE);
		lblTo.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblTo.setAlignment(SWT.RIGHT);
		
		endDate = new CDateTime(frmPeriod.getBody(), CDT.BORDER | CDT.DROP_DOWN | CDT.DATE_MEDIUM);
		endDate.setSelection(modelUtils.todayAndNow());
		GridData gd_dateTime_2 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_dateTime_2.heightHint = 19;
		endDate.setLayoutData(gd_dateTime_2);
		formToolkit.adapt(endDate);
		formToolkit.paintBordersFor(endDate);
		
		Label lblAt_1 = formToolkit.createLabel(frmPeriod.getBody(), "At:", SWT.NONE);
		lblAt_1.setAlignment(SWT.RIGHT);
		lblAt_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		
		endTime = new CDateTime(frmPeriod.getBody(), CDT.BORDER | CDT.CLOCK_24_HOUR | CDT.DROP_DOWN | CDT.TIME_MEDIUM);
		endTime.setSelection(modelUtils.todayAndNow());
		formToolkit.adapt(endTime);
		formToolkit.paintBordersFor(endTime);
		new Label(frmPeriod.getBody(), SWT.NONE);

		return container;
	}

	public DateTimeRange period(){
		
		Date sDate = startDate.getSelection();
		Date sTime = startTime.getSelection();
		
		Date start = modelUtils.mergeTimeIntoDate(sDate, sTime);
		
		Date eDate = endDate.getSelection();
		Date eTime = endTime.getSelection();
		
		Date end = modelUtils.mergeTimeIntoDate(eDate, eTime);
		
		return modelUtils.period(start, end);
	}
	
	
	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);
//		createButton(parent, IDialogConstants.CANCEL_ID,
//				IDialogConstants.CANCEL_LABEL, false);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(448, 181);
	}
}
