package com.netxforge.netxstudio.screens.f2;

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
 * An injectable component showing a from and to Date layed out above each other. 
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

	@Inject
	public PeriodComponent(ModelUtils modelUtils) {
		super();
		this.modelUtils = modelUtils;
	}

	public void buildUI(Composite parent, Object layoutData) {

		Composite cmpPeriod = toolkit.createComposite(parent, SWT.NONE);
		toolkit.adapt(cmpPeriod);
		cmpPeriod.setLayoutData(layoutData);
		
		GridLayout periodGridLayout = new GridLayout();
		periodGridLayout.numColumns = 2;
		cmpPeriod.setLayout(periodGridLayout);
		
		
		Label lblStart = toolkit.createLabel(cmpPeriod, "From:",
				SWT.NONE);
		GridData gd_lblStart = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_lblStart.widthHint = 70;
		lblStart.setLayoutData(gd_lblStart);
		lblStart.setAlignment(SWT.RIGHT);

		dateTimeFrom = new CDateTime(cmpPeriod, CDT.BORDER
				| CDT.DROP_DOWN | CDT.DATE_SHORT);
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
		gd_lblTo.widthHint = 70;
		lblTo.setLayoutData(gd_lblTo);

		dateTimeTo = new CDateTime(cmpPeriod, CDT.BORDER | CDT.DROP_DOWN
				| CDT.DATE_SHORT);
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

	protected void updatePeriod() {
		period.setBegin(modelUtils.toXMLDate(this.dateTimeFrom
				.getSelection()));
		period.setEnd(modelUtils.toXMLDate(this.dateTimeTo
				.getSelection()));
	}

	public DateTimeRange getPeriod() {
		return period;
	}

}
