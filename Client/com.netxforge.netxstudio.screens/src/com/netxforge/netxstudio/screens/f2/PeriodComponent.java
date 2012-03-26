package com.netxforge.netxstudio.screens.f2;

import java.util.Date;

import org.eclipse.nebula.widgets.cdatetime.CDT;
import org.eclipse.nebula.widgets.cdatetime.CDateTime;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.generics.GenericsFactory;

/**
 * An injectable component showing a from and to Date layed out above each
 * other.
 * 
 * @author Christophe
 * 
 */
public class PeriodComponent {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());

	private CDateTime dateTimeTo;
	private CDateTime dateTimeFrom;

	private final DateTimeRange period = GenericsFactory.eINSTANCE
			.createDateTimeRange();

	private ModelUtils modelUtils;

	private Composite cmpPeriod;
	
	/*
	 * Defaults to show a border. 
	 */
	private boolean showBorder = true;

	@Inject
	public PeriodComponent(ModelUtils modelUtils) {
		super();
		this.modelUtils = modelUtils;
	}
	
	public void setShowBorder(boolean showBorder){
		this.showBorder = showBorder;
	}
	
	
	public void buildUI(Composite parent, Object layoutData) {

		cmpPeriod = toolkit.createComposite(parent, showBorder ? SWT.BORDER : SWT.NONE);

		toolkit.adapt(cmpPeriod);

		if (layoutData != null) {
			cmpPeriod.setLayoutData(layoutData);
		}

		GridLayout periodGridLayout = new GridLayout();
		periodGridLayout.numColumns = 4;
		cmpPeriod.setLayout(periodGridLayout);

		Label lblStart = toolkit.createLabel(cmpPeriod, "From:", SWT.NONE);
		GridData gd_lblStart = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		// gd_lblStart.widthHint = 70;
		lblStart.setLayoutData(gd_lblStart);
		lblStart.setAlignment(SWT.RIGHT);

		dateTimeFrom = new CDateTime(cmpPeriod, CDT.BORDER | CDT.DROP_DOWN
				| CDT.DATE_MEDIUM);
		GridData gd_dateTimeFrom = new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1);
		gd_dateTimeFrom.widthHint = 120;
		dateTimeFrom.setLayoutData(gd_dateTimeFrom);
		dateTimeFrom.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				updatePeriod();
			}
		});

		toolkit.adapt(dateTimeFrom);
		toolkit.paintBordersFor(dateTimeFrom);

		Label lblTo = toolkit.createLabel(cmpPeriod, "To:", SWT.NONE);
		lblTo.setAlignment(SWT.RIGHT);
		GridData gd_lblTo = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1,
				1);
		// gd_lblTo.widthHint = 70;
		lblTo.setLayoutData(gd_lblTo);

		dateTimeTo = new CDateTime(cmpPeriod, CDT.BORDER | CDT.DROP_DOWN
				| CDT.DATE_MEDIUM);
		GridData gd_dateTimeTo = new GridData(SWT.FILL, SWT.CENTER, false,
				false, 1, 1);
		gd_dateTimeTo.widthHint = 120;
		dateTimeTo.setLayoutData(gd_dateTimeTo);
		dateTimeTo.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				updatePeriod();
			}
		});

		toolkit.adapt(dateTimeTo);
		toolkit.paintBordersFor(dateTimeTo);
	}

	public Composite getCmpPeriod() {
		return cmpPeriod;
	}

	public CDateTime getDateTimeTo() {
		return dateTimeTo;
	}

	public CDateTime getDateTimeFrom() {
		return dateTimeFrom;
	}

	/**
	 * Revises the date to midnight.
	 */
	protected void updatePeriod() {

		Date from = this.dateTimeFrom.getSelection();
		modelUtils.setToDayStart(from);

		Date to = this.dateTimeTo.getSelection();
		modelUtils.setToDayEnd(to);

		period.setBegin(modelUtils.toXMLDate(from));
		period.setEnd(modelUtils.toXMLDate(to));
	}

	public DateTimeRange getPeriod() {
		return period;
	}

	public void updatePeriod(Date from, Date to) {

		if (from == null || to == null) {
			return;
		}

		// will this fire selection listeners?
		dateTimeFrom.setSelection(from);
		dateTimeTo.setSelection(to);
		period.setBegin(modelUtils.toXMLDate(from));
		period.setEnd(modelUtils.toXMLDate(to));

	}

	public void presetYesterday() {
		Date yesterday = modelUtils.yesterday();
		yesterday = modelUtils.setToDayStart(yesterday);
		this.updatePeriod(yesterday, modelUtils.todayAtDayEnd());
	}

	public void presetLastWeek() {
		Date oneWeekAgo = modelUtils.oneWeekAgo();
		oneWeekAgo = modelUtils.setToDayStart(oneWeekAgo);
		this.updatePeriod(oneWeekAgo, modelUtils.todayAtDayEnd());
	}

	public void presetLastMonth() {
		Date oneMonthAgo = modelUtils.oneMonthAgo();
		oneMonthAgo = modelUtils.setToDayStart(oneMonthAgo);
		this.updatePeriod(oneMonthAgo, modelUtils.todayAtDayEnd());
	}

	public void presetLastQuarter() {
		Date threeMonthsAgo = modelUtils.threeMonthsAgo();
		threeMonthsAgo = modelUtils.setToDayStart(threeMonthsAgo);
		this.updatePeriod(threeMonthsAgo, modelUtils.todayAtDayEnd());
	}

}
