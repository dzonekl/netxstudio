/*******************************************************************************
 * Copyright (c) Jul 11, 2011 NetXForge.
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
package com.netxforge.netxstudio.screens.f2;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.IEMFValueProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormText;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.ui.forms.widgets.Section;

import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.editing.selector.IDataScreenInjection;

public class NewEditResource extends AbstractScreen implements IDataScreenInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Text txtShortName;
	private Text txtLongName;
	private Text txtExpressionName;
	private Text txtUnit;
	private NetXResource netxResource;
	private Form frmResource;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public NewEditResource(Composite parent, int style) {
		super(parent, style);
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
		setLayout(new FillLayout(SWT.HORIZONTAL));

		frmResource = toolkit.createForm(this);
		frmResource.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmResource);
		frmResource.setText("Resource");
		frmResource.getBody().setLayout(new FormLayout());

		FormText formText = toolkit
				.createFormText(frmResource.getBody(), false);
		FormData fd_formText = new FormData();
		fd_formText.bottom = new FormAttachment(0, 46);
		fd_formText.right = new FormAttachment(100, -12);
		fd_formText.top = new FormAttachment(0, 12);
		fd_formText.left = new FormAttachment(0, 12);
		formText.setLayoutData(fd_formText);
		toolkit.paintBordersFor(formText);
		formText.setText(
				"<form><p> A resource is either created from a metric by the <b>M</b>etric <b>C</b>ollection <b>E</b>ngine or a resource is defined and calculated from an expression.  </p></form>",
				true, false);

		Section sctnInfo = toolkit.createSection(frmResource.getBody(),
				Section.EXPANDED | Section.TITLE_BAR);
		FormData fd_sctnInfo = new FormData();
		fd_sctnInfo.top = new FormAttachment(formText, 15);
		fd_sctnInfo.bottom = new FormAttachment(100, -12);
		fd_sctnInfo.right = new FormAttachment(0, 370);
		fd_sctnInfo.left = new FormAttachment(0, 12);
		sctnInfo.setLayoutData(fd_sctnInfo);
		toolkit.paintBordersFor(sctnInfo);
		sctnInfo.setText("Info");

		Composite composite = toolkit.createComposite(sctnInfo, SWT.NONE);
		toolkit.paintBordersFor(composite);
		sctnInfo.setClient(composite);
		composite.setLayout(new GridLayout(2, false));
		
		Label lblShortName = toolkit.createLabel(composite, "Short Name:", SWT.NONE);
		lblShortName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		
		txtShortName = toolkit.createText(composite, "New Text", SWT.NONE);
		txtShortName.setText("");
		
		Label lblLongName = toolkit.createLabel(composite, "Long Name:", SWT.NONE);
		lblLongName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		
		txtLongName = toolkit.createText(composite, "New Text", SWT.NONE);
		txtLongName.setText(" ");
		GridData gd_txtLongName = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_txtLongName.widthHint = 200;
		txtLongName.setLayoutData(gd_txtLongName);
		
		Label lblNameInExpression = toolkit.createLabel(composite, "Name In Expression:", SWT.NONE);
		lblNameInExpression.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		
		txtExpressionName = toolkit.createText(composite, "New Text", SWT.NONE);
		txtExpressionName.setText("");
		
		Label lblUnit = toolkit.createLabel(composite, "Unit:", SWT.NONE);
		lblUnit.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		
		txtUnit = toolkit.createText(composite, "New Text", SWT.NONE);
		txtUnit.setText("");
		
		Section sctnContents = toolkit.createSection(frmResource.getBody(), Section.EXPANDED | Section.TITLE_BAR);
		FormData fd_sctnContents = new FormData();
		fd_sctnContents.bottom = new FormAttachment(100, -12);
		fd_sctnContents.right = new FormAttachment(formText, 0, SWT.RIGHT);
		fd_sctnContents.top = new FormAttachment(sctnInfo, 0, SWT.TOP);
		fd_sctnContents.left = new FormAttachment(0, 380);
		sctnContents.setLayoutData(fd_sctnContents);
		toolkit.paintBordersFor(sctnContents);
		sctnContents.setText("Contents");
		
		Composite composite_2 = toolkit.createComposite(sctnContents, SWT.NONE);
		toolkit.paintBordersFor(composite_2);
		sctnContents.setClient(composite_2);
		composite_2.setLayout(new GridLayout(2, false));
		
		ImageHyperlink mghprlnkMetricRanges = toolkit.createImageHyperlink(composite_2, SWT.NONE);
		mghprlnkMetricRanges.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		toolkit.paintBordersFor(mghprlnkMetricRanges);
		mghprlnkMetricRanges.setText("Metric Ranges");
		
		Composite composite_3 = toolkit.createComposite(composite_2, SWT.NONE);
		GridData gd_composite_3 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_composite_3.widthHint = 14;
		gd_composite_3.heightHint = 14;
		composite_3.setLayoutData(gd_composite_3);
		toolkit.paintBordersFor(composite_3);
		
		Hyperlink hprlnkHourly = toolkit.createHyperlink(composite_2, "Hourly", SWT.NONE);
		toolkit.paintBordersFor(hprlnkHourly);

		new Label(composite_2, SWT.NONE);
		Hyperlink hprlnkDaily = toolkit.createHyperlink(composite_2, "Daily", SWT.NONE);
		toolkit.paintBordersFor(hprlnkDaily);
		
		new Label(composite_2, SWT.NONE);
		Hyperlink hprlnkWeekly = toolkit.createHyperlink(composite_2, "Weekly", SWT.NONE);
		toolkit.paintBordersFor(hprlnkWeekly);

		new Label(composite_2, SWT.NONE);
		Hyperlink hprlnkMonthly = toolkit.createHyperlink(composite_2, "Monthly", SWT.NONE);
		toolkit.paintBordersFor(hprlnkMonthly);
		
		Hyperlink hprlnkNewHyperlink = toolkit.createHyperlink(composite_2, "Capacity Range", SWT.NONE);
		hprlnkNewHyperlink.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		toolkit.paintBordersFor(hprlnkNewHyperlink);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
	}

	public EMFDataBindingContext initDataBindings_() {
		EMFDataBindingContext context = new EMFDataBindingContext();
		
		// Widget observables. 
		IObservableValue shortNameTargetObservable = SWTObservables.observeDelayedValue(400, SWTObservables.observeText(this.txtShortName));
		IObservableValue longNameTargetObservable = SWTObservables.observeDelayedValue(400, SWTObservables.observeText(this.txtLongName));
		IObservableValue  expressionNameTargetObservable = SWTObservables.observeDelayedValue(400, SWTObservables.observeText(this.txtExpressionName));
		IObservableValue  unitTargetObservable = SWTObservables.observeDelayedValue(400, SWTObservables.observeText(this.txtUnit));
		
		IEMFValueProperty shortNameProperty = EMFEditProperties.value(editingService.getEditingDomain(), LibraryPackage.Literals.NET_XRESOURCE__SHORT_NAME);
		IEMFValueProperty longNameProperty = EMFEditProperties.value(editingService.getEditingDomain(), LibraryPackage.Literals.NET_XRESOURCE__LONG_NAME);
		IEMFValueProperty expressionNameProperty = EMFEditProperties.value(editingService.getEditingDomain(), LibraryPackage.Literals.NET_XRESOURCE__EXPRESSION_NAME);
		IEMFValueProperty unitProperty = EMFEditProperties.value(editingService.getEditingDomain(), LibraryPackage.Literals.NET_XRESOURCE__UNIT_REF);
		
		context.bindValue(shortNameTargetObservable, shortNameProperty.observe(netxResource), null, null);
		context.bindValue(longNameTargetObservable, longNameProperty.observe(netxResource), null, null);
		context.bindValue(expressionNameTargetObservable, expressionNameProperty.observe(netxResource), null, null);
		context.bindValue(unitTargetObservable, unitProperty.observe(netxResource), null, null);
		
		return context;
	}

	public void disposeData() {
		// N/A
	}

	public void injectData(Object owner, Object object) {
		if(object instanceof NetXResource){
			netxResource = (NetXResource)object;
		}
		
		this.initDataBindings_();
	}

	public void addData() {
		// We don't allow editing yet. 
	}

	@Override
	public Viewer getViewer() {
		return null;
	}

	@Override
	public void setOperation(int operation) {
		this.operation = operation;
	}

	@Override
	public boolean isValid() {
		return true;
	}

	@Override
	public Form getScreenForm() {
		return this.frmResource;
	}
}
