/*******************************************************************************
 * Copyright (c) 18 sep. 2014 NetXForge.
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
package com.netxforge.sites;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.IEMFValueProperty;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.dialogs.MessageDialog;
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
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

import com.netxforge.netxstudio.geo.Country;
import com.netxforge.netxstudio.geo.GeoPackage;
import com.netxforge.screens.editing.base.AbstractScreenImpl;
import com.netxforge.screens.editing.base.IDataScreenInjection;
import com.netxforge.screens.editing.base.ScreenUtil;

/**
 * Edit the {@link Country} object. 
 * 
 * @author Christophe Bouhier
 *
 */
public class NewEditCountry extends AbstractScreenImpl implements
		IDataScreenInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Text txtName;
	private Form frmNewCountry;
	private Resource owner;
	private Country country;
	
	
	@SuppressWarnings("unused")
	private EMFDataBindingContext m_bindingContext;
	private Text txtCountryCode;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public NewEditCountry(Composite parent, int style) {
		super(parent, style);
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
	}

	public EMFDataBindingContext initDataBindings_() {
		EMFDataBindingContext context = new EMFDataBindingContext();
		
		IObservableValue nameObservable = SWTObservables.observeDelayedValue(400, SWTObservables.observeText(txtName,
				SWT.Modify));
		IObservableValue shortNameObservable = SWTObservables.observeDelayedValue(400, SWTObservables.observeText(txtCountryCode,
				SWT.Modify));
		

		IEMFValueProperty nameProperty = EMFProperties
				.value(GeoPackage.Literals.LOCATION__NAME);
		IEMFValueProperty shortNameProperty = EMFProperties
				.value(GeoPackage.Literals.COUNTRY__COUNTRY_CODE);
		
		context.bindValue(nameObservable, nameProperty.observe(country),
				null, null);
		context.bindValue(shortNameObservable, shortNameProperty.observe(country),
				null, null);
		
		return context;
	}

	public void injectData(Object owner, Object object) {
		if (owner instanceof Resource) {
			this.owner = (Resource) owner;
		} else {
			// We need the right type of object for this screen.
			throw new java.lang.IllegalArgumentException();
		}
		if (object != null && object instanceof Country) {
			country = (Country) object;
		} else {
			// We need the right type of object for this screen.
			throw new java.lang.IllegalArgumentException();
		}
		buildUI();
		m_bindingContext = initDataBindings_();
	}

	
	private void buildUI() {
		setLayout(new FillLayout(SWT.HORIZONTAL));

		// Readonlyness.
		boolean readonly = ScreenUtil.isReadOnlyOperation(this.getOperation());
		int widgetStyle = readonly ? SWT.READ_ONLY : SWT.NONE;

		frmNewCountry = toolkit.createForm(this);
		frmNewCountry.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmNewCountry);

		frmNewCountry.setText(getOperationText() + "Country");
		frmNewCountry.getBody().setLayout(new FormLayout());

		Section sctnMappings = toolkit.createSection(frmNewCountry.getBody(),
				Section.EXPANDED | Section.TITLE_BAR);
		FormData fd_sctnMappings = new FormData();
		fd_sctnMappings.bottom = new FormAttachment(100, -10);
		fd_sctnMappings.left = new FormAttachment(0, 10);
		fd_sctnMappings.top = new FormAttachment(0, 10);
		fd_sctnMappings.right = new FormAttachment(100, -14);
		sctnMappings.setLayoutData(fd_sctnMappings);
		toolkit.paintBordersFor(sctnMappings);
		sctnMappings.setText("Info");

		Composite composite_1 = toolkit.createComposite(sctnMappings, SWT.NONE);
		toolkit.paintBordersFor(composite_1);
		sctnMappings.setClient(composite_1);
		composite_1.setLayout(new GridLayout(2, false));

		Label lblName = toolkit.createLabel(composite_1, "Name:", SWT.NONE);
		lblName.setAlignment(SWT.RIGHT);
		GridData gd_lblName = new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1);
		gd_lblName.widthHint = 90;
		lblName.setLayoutData(gd_lblName);

		txtName = toolkit.createText(composite_1, "New Text", widgetStyle);
		txtName.setText("");
		GridData gd_txtName = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_txtName.widthHint = 150;
		txtName.setLayoutData(gd_txtName);
		
		Label lblCountryCode = toolkit.createLabel(composite_1, "Country Code:", SWT.NONE);
		lblCountryCode.setAlignment(SWT.RIGHT);
		lblCountryCode.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		
		txtCountryCode = toolkit.createText(composite_1, "New Text", widgetStyle);
		txtCountryCode.setText("");
	}
	
	public void addData() {
		if (ScreenUtil.isNewOperation(getOperation()) && owner != null) {
			// If new, we have been operating on an object not added yet.
			Command c;

			c = new AddCommand(editingService.getEditingDomain(),
					owner.getContents(), country);

			editingService.getEditingDomain().getCommandStack().execute(c);
		} else if (ScreenUtil.isEditOperation(getOperation())) {
			// If edit, we have been operating on a copy of the object, so we
			// have to replace. However if our original object is invalid, this
			// will
			// cause invalidity, so the action will not occure in case the
			// original is
			// invalid, and we should cancel the action and warn the user.
			if (!this.getObjectValidationService().isValid(country)) {
				MessageDialog
						.openWarning(Display.getDefault().getActiveShell(),
								"Conflict",
								"There is a conflict with another user. Your changes can't be saved.");
				return;
			}

		}
		// After our edit, we shall be dirty
		if (editingService.isDirty()) {
			editingService.doSave(new NullProgressMonitor());
		}
	}

	public Viewer getViewer() {
		return null;
	}

	@Override
	public boolean isValid() {
		return true;
	}

	public Form getScreenForm() {
		return frmNewCountry;
	}

	public void disposeData() {
		// N/A
	}

	@Override
	public void setOperation(int operation) {
		this.operation = operation;
	}
	
	public String getScreenName() {
		return "Country";
	}
}
