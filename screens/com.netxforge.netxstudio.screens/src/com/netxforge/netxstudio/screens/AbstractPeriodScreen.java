/*******************************************************************************
 * Copyright (c) 28 nov. 2013 NetXForge.
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
package com.netxforge.netxstudio.screens;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.google.inject.Inject;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.screens.f3.PeriodComponent;
import com.netxforge.screens.editing.base.util.MementoUtil;

/**
 * A screen with a period component.
 * 
 * @author Christophe Bouhier
 * 
 */
public abstract class AbstractPeriodScreen extends AbstractScreen implements
		IValueChangeListener {

	private static final String MEM_KEY_NODERESOURCEADVANCED_PERIOD_FROM = "MEM_KEY_NODERESOURCEADVANCED_PERIOD_FROM";

	private static final String MEM_KEY_NODERESOURCEADVANCED_PERIOD_TO = "MEM_KEY_NODERESOURCEADVANCED_PERIOD_TO";

	@Inject
	private PeriodComponent cmpPeriod;

	protected final FormToolkit toolkit = new FormToolkit(Display.getCurrent());

	private Form frmAbstractPeriod;

	public AbstractPeriodScreen(Composite parent, int style) {
		super(parent, style);
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				cmpPeriod.dispose();
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
	}

	protected void buildUI() {
		setLayout(new FillLayout(SWT.HORIZONTAL));

		// Create the form.
		frmAbstractPeriod = toolkit.createForm(this);
		frmAbstractPeriod.setSeparatorVisible(true);

		frmAbstractPeriod.getToolBarManager().update(true);
		frmAbstractPeriod.setToolBarVerticalAlignment(SWT.TOP);

		// Body of the form.
		FillLayout fl = new FillLayout();
		frmAbstractPeriod.getBody().setLayout(fl);

		cmpPeriod.buildUI(frmAbstractPeriod.getHead(), null);

		frmAbstractPeriod.setHeadClient(cmpPeriod.getCmpPeriod());

		toolkit.decorateFormHeading(frmAbstractPeriod);
		toolkit.paintBordersFor(frmAbstractPeriod);

	}

	public PeriodComponent getPeriodComponent() {
		return cmpPeriod;
	}

	public DateTimeRange getPeriod() {
		return cmpPeriod.getPeriod();
	}

	public EMFDataBindingContext initDataBindings_() {

		EMFDataBindingContext bindingContext = new EMFDataBindingContext();
		cmpPeriod.initBindings(editingService.getEditingDomain(),
				bindingContext);
		cmpPeriod.getFromObservableValue().addValueChangeListener(
				(IValueChangeListener) this);
		cmpPeriod.getToObservableValue().addValueChangeListener(
				(IValueChangeListener) this);
		return bindingContext;
	}

	@Override
	public void saveState(IMemento memento) {
		// from date.
		MementoUtil.rememberDate(memento, this.getPeriod().getBegin(),
				MEM_KEY_NODERESOURCEADVANCED_PERIOD_FROM);

		// to date.
		MementoUtil.rememberDate(memento, this.getPeriod().getEnd(),
				MEM_KEY_NODERESOURCEADVANCED_PERIOD_TO);
	}

	@Override
	public void restoreState(IMemento memento) {
		if (memento != null) {
			// Set the period prior to the Operator/Service, Network, Node &
			// Resource selection, as this will
			// trigger the loading
			// of values.
			cmpPeriod.setPeriod(MementoUtil.retrieveDate(memento,
					MEM_KEY_NODERESOURCEADVANCED_PERIOD_FROM), MementoUtil
					.retrieveDate(memento,
							MEM_KEY_NODERESOURCEADVANCED_PERIOD_TO));
		}
	}

	public Form getScreenForm() {
		return frmAbstractPeriod;
	}

	@Override
	public String getScreenName() {
		return "PeriodScreen";
	}

	public void handleValueChange(ValueChangeEvent event) {
		doHandleValueChange(event);
	}

	/**
	 * Clients can override to be notified of a change on the period
	 * {@link IObservableValue} values. The actual {@link DateTimeRange} is also
	 * bound to these observables and can get obtained with {@link #getPeriod()}
	 * tPeriod()
	 * 
	 * @param event
	 */
	protected void doHandleValueChange(ValueChangeEvent event) {
		// No OP.
	}

}
