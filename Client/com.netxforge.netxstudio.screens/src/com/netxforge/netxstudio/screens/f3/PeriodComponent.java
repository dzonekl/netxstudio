/*******************************************************************************
 * Copyright (c) Jul 1, 2012 NetXForge.
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details. You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors: Christophe Bouhier - initial API and implementation and/or
 * initial documentation
 *******************************************************************************/ 
package com.netxforge.netxstudio.screens.f3;

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
		Date to = this.dateTimeTo.getSelection();

		modelUtils.adjustToDayStartAndEnd(from, to);

		period.setBegin(modelUtils.toXMLDate(from));
		period.setEnd(modelUtils.toXMLDate(to));
	}
	

	public DateTimeRange getPeriod() {
		return period;
	}
	
	
	/**
	 * Updates the period in the widget and model.
	 *  
	 * @param from
	 * @param to
	 */
	public void setPeriod(Date from, Date to) {
		this.setPeriod(from, to, false);
	}
	
	/**
	 * Updates the period in the widget and model, optionally adjust to the day start for 
	 * the start and day end for the end of the period. 
	 * 
	 * @param from
	 * @param to
	 * @param setToDayStartAndEnd
	 */
	public void setPeriod(Date from, Date to, boolean setToDayStartAndEnd) {

		if (from == null || to == null) {
			return;
		}
		
		if(setToDayStartAndEnd){
			modelUtils.adjustToDayStartAndEnd(from, to);
		}
		
		// Achtung! Selection listeners not fired....update your databinding writables manually. 
		dateTimeFrom.setSelection(from);
		dateTimeTo.setSelection(to);
		
		period.setBegin(modelUtils.toXMLDate(from));
		period.setEnd(modelUtils.toXMLDate(to));

	}
	
	public void setPeriod(DateTimeRange dtr) {
		this.setPeriod(modelUtils.begin(dtr), modelUtils.end(dtr));
	}
	
	public void presetYesterday() {
		Date yesterday = modelUtils.yesterday();
		yesterday = modelUtils.adjustToDayStart(yesterday);
		this.setPeriod(yesterday, modelUtils.todayAtDayEnd());
	}

	public void presetLastWeek() {
		Date oneWeekAgo = modelUtils.oneWeekAgo();
		oneWeekAgo = modelUtils.adjustToDayStart(oneWeekAgo);
		this.setPeriod(oneWeekAgo, modelUtils.todayAtDayEnd());
	}

	public void presetLastMonth() {
		Date oneMonthAgo = modelUtils.oneMonthAgo();
		oneMonthAgo = modelUtils.adjustToDayStart(oneMonthAgo);
		this.setPeriod(oneMonthAgo, modelUtils.todayAtDayEnd());
	}

	public void presetLastQuarter() {
		Date threeMonthsAgo = modelUtils.threeMonthsAgo();
		threeMonthsAgo = modelUtils.adjustToDayStart(threeMonthsAgo);
		this.setPeriod(threeMonthsAgo, modelUtils.todayAtDayEnd());
	}

}
