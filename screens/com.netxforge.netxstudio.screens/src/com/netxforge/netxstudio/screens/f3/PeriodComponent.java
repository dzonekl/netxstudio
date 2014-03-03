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

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.EMFUpdateValueStrategy;
import org.eclipse.emf.databinding.IEMFValueProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.edit.domain.EditingDomain;
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
import com.netxforge.base.NonModelUtils;
import com.netxforge.netxstudio.common.model.StudioUtils;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.generics.GenericsFactory;
import com.netxforge.netxstudio.generics.GenericsPackage;
import com.netxforge.netxstudio.screens.CDateTimeObservableValue;

/**
 * An injectable component showing a from and to Date layed out next to each
 * other.The to and from dates are bound to a {@link DateTimeRange period} model object. 
 * 
 * @author Christophe Bouhier
 * 
 */
public class PeriodComponent {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());

	private CDateTime dateTimeTo;
	private CDateTime dateTimeFrom;

	/**
	 * The {@link DateTimeRange period} bound to the UI.
	 */
	private final DateTimeRange period = GenericsFactory.eINSTANCE
			.createDateTimeRange();

	private Composite cmpPeriod;

	/**
	 * An observable for the from selector.
	 */
	protected CDateTimeObservableValue fromObservableValue;

	/**
	 * An observable for the to selector.
	 */
	protected CDateTimeObservableValue toObservableValue;

	/*
	 * Defaults to show a border.
	 */
	private boolean showBorder = true;

	@Inject
	public PeriodComponent() {
		super();
	}

	public void setShowBorder(boolean showBorder) {
		this.showBorder = showBorder;
	}

	public void buildUI(Composite parent, Object layoutData) {

		cmpPeriod = toolkit.createComposite(parent, showBorder ? SWT.BORDER
				: SWT.NONE);

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

	public void initBindings(EditingDomain domain,
			EMFDataBindingContext bindingContext) {
		
		fromObservableValue = new CDateTimeObservableValue(dateTimeFrom);

		toObservableValue = new CDateTimeObservableValue(dateTimeTo);

		IEMFValueProperty bindFrom = EMFEditProperties.value(domain,
				GenericsPackage.Literals.DATE_TIME_RANGE__BEGIN);
		
		IEMFValueProperty bindTo = EMFEditProperties.value(domain,
				GenericsPackage.Literals.DATE_TIME_RANGE__END);

		
		// Update strategies from/to XMLDate. 
		
		EMFUpdateValueStrategy targetToModelUpdateStrategy = new EMFUpdateValueStrategy();
		targetToModelUpdateStrategy.setConverter(new IConverter() {

			public Object getFromType() {
				return Date.class;
			}

			public Object getToType() {
				return XMLGregorianCalendar.class;
			}

			public Object convert(Object fromObject) {
				if (fromObject == null) {
					return null;
				}
				return NonModelUtils.toXMLDate((Date) fromObject);
			}
		});

		EMFUpdateValueStrategy modelToTargetUpdateStrategy = new EMFUpdateValueStrategy();
		modelToTargetUpdateStrategy.setConverter(new IConverter() {

			public Object getFromType() {
				return XMLGregorianCalendar.class;
			}

			public Object getToType() {
				return Date.class;
			}

			public Object convert(Object fromObject) {
				if (fromObject == null) {
					return null;
				} else {
					return NonModelUtils
							.fromXMLDate((XMLGregorianCalendar) fromObject);
				}
			}
		});

		bindingContext.bindValue(fromObservableValue, bindFrom.observe(period),
				targetToModelUpdateStrategy, modelToTargetUpdateStrategy);
		
		bindingContext.bindValue(toObservableValue, bindTo.observe(period),
				targetToModelUpdateStrategy, modelToTargetUpdateStrategy);
		
		

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
	 * FIXME, It should be enough to set the new date on the model, check. 
	 * 
	 */
	protected void updatePeriod() {

		Date from = this.dateTimeFrom.getSelection();
		Date to = this.dateTimeTo.getSelection();

		NonModelUtils.adjustToDayStartAndEnd(from, to);

		period.setBegin(NonModelUtils.toXMLDate(from));
		period.setEnd(NonModelUtils.toXMLDate(to));
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
	 * Updates the period in the widget and model, optionally adjust to the day
	 * start for the start and day end for the end of the period.
	 * 
	 * @param from
	 * @param to
	 * @param setToDayStartAndEnd
	 */
	public void setPeriod(Date from, Date to, boolean setToDayStartAndEnd) {

		if (from == null || to == null) {
			return;
		}

		if (setToDayStartAndEnd) {
			NonModelUtils.adjustToDayStartAndEnd(from, to);
		}

		period.setBegin(NonModelUtils.toXMLDate(from));
		period.setEnd(NonModelUtils.toXMLDate(to));
	}

	public void setPeriod(DateTimeRange dtr) {
		this.setPeriod(StudioUtils.begin(dtr), StudioUtils.end(dtr));
	}

	public void presetYesterday() {
		Date yesterday = NonModelUtils.yesterday();
		yesterday = NonModelUtils.adjustToDayStart(yesterday);
		this.setPeriod(yesterday, NonModelUtils.todayAtDayEnd());
	}

	public void presetLastWeek() {
		Date oneWeekAgo = NonModelUtils.oneWeekAgo();
		oneWeekAgo = NonModelUtils.adjustToDayStart(oneWeekAgo);
		this.setPeriod(oneWeekAgo, NonModelUtils.todayAtDayEnd());
	}

	public void presetLastMonth() {
		Date oneMonthAgo = NonModelUtils.oneMonthAgo();
		oneMonthAgo = NonModelUtils.adjustToDayStart(oneMonthAgo);
		this.setPeriod(oneMonthAgo, NonModelUtils.todayAtDayEnd());
	}

	public void presetLastQuarter() {
		Date threeMonthsAgo = NonModelUtils.threeMonthsAgo();
		threeMonthsAgo = NonModelUtils.adjustToDayStart(threeMonthsAgo);
		this.setPeriod(threeMonthsAgo, NonModelUtils.todayAtDayEnd());
	}
	
	public void dispose(){
		// dispose our observalbles. 
		toObservableValue.dispose();
		fromObservableValue.dispose();
	}

	public CDateTimeObservableValue getFromObservableValue() {
		return fromObservableValue;
	}

	public CDateTimeObservableValue getToObservableValue() {
		return toObservableValue;
	}
	
}
