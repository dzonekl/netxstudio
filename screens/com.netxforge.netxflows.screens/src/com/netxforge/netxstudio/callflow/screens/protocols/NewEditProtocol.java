/*******************************************************************************
 * Copyright (c) 21 mrt. 2014 NetXForge.
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
package com.netxforge.netxstudio.callflow.screens.protocols;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.IEMFValueProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.ColumnLayout;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

import com.netxforge.netxstudio.callflow.screens.AbstractScreen;
import com.netxforge.netxstudio.protocols.OSIType;
import com.netxforge.netxstudio.protocols.Protocol;
import com.netxforge.netxstudio.protocols.ProtocolsPackage;
import com.netxforge.screens.editing.base.IDataScreenInjection;
import com.netxforge.screens.editing.base.ScreenUtil;

public class NewEditProtocol extends AbstractScreen implements
		IDataScreenInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Text txtName;
	private Form frmNewProtocol;
	private Resource owner;
	private Protocol protocol;
	@SuppressWarnings("unused")
	private EMFDataBindingContext m_bindingContext;
	private ComboViewer cmbLevelViewer;
	private Text txtSpecification;
	private Text txtDescription;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public NewEditProtocol(Composite parent, int style) {
		super(parent, style);
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
//		buildUI();
	}

	private void buildUI() {
		setLayout(new FillLayout(SWT.HORIZONTAL));

		// Readonlyness.
		boolean readonly = ScreenUtil.isReadOnlyOperation(this.getOperation());
		int widgetStyle = readonly ? SWT.READ_ONLY : SWT.NONE;

		frmNewProtocol = toolkit.createForm(this);
		frmNewProtocol.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmNewProtocol);

		frmNewProtocol.setText(this.getOperationText() + "Protocol");
		ColumnLayout cl = new ColumnLayout();
		cl.maxNumColumns =1 ;
		frmNewProtocol.getBody().setLayout(cl);

		Section sctnMappings = toolkit.createSection(frmNewProtocol.getBody(),
				Section.EXPANDED | Section.TITLE_BAR);
		toolkit.paintBordersFor(sctnMappings);
		sctnMappings.setText("Info");

		Composite composite_1 = toolkit.createComposite(sctnMappings, SWT.NONE);
		toolkit.paintBordersFor(composite_1);
		sctnMappings.setClient(composite_1);
		composite_1.setLayout(new GridLayout(4, false));

		Label lblName = toolkit.createLabel(composite_1, "Name:", SWT.NONE);
		lblName.setAlignment(SWT.RIGHT);
		GridData gd_lblName = new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1);
		gd_lblName.widthHint = 70;
		lblName.setLayoutData(gd_lblName);

		txtName = toolkit.createText(composite_1, "New Text", widgetStyle);
		txtName.setText("");
		GridData gd_txtName = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_txtName.widthHint = 150;
		txtName.setLayoutData(gd_txtName);
		new Label(composite_1, SWT.NONE);
		new Label(composite_1, SWT.NONE);

		Label lblDescription = toolkit.createLabel(composite_1, "Description:",
				SWT.NONE);
		lblDescription.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		lblDescription.setAlignment(SWT.RIGHT);

		txtDescription = toolkit.createText(composite_1, "New Text", SWT.WRAP
				| SWT.MULTI | widgetStyle);
		txtDescription.setText("");
		GridData gd_txtNewText = new GridData(SWT.FILL, SWT.CENTER, true,
				false, 3, 1);
		gd_txtNewText.heightHint = 89;
		txtDescription.setLayoutData(gd_txtNewText);

		Section sctnProtocol = toolkit.createSection(frmNewProtocol.getBody(),
				Section.TWISTIE | Section.TITLE_BAR);
		toolkit.paintBordersFor(sctnProtocol);
		sctnProtocol.setText("Details");
		sctnProtocol.setExpanded(true);

		Composite composite = toolkit.createComposite(sctnProtocol, SWT.NONE);
		toolkit.paintBordersFor(composite);
		sctnProtocol.setClient(composite);
		composite.setLayout(new GridLayout(2, false));

		Label lblOSI = toolkit.createLabel(composite, "OSI:", SWT.NONE);
		GridData gd_lblOSI = new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1);
		gd_lblOSI.widthHint = 70;
		lblOSI.setLayoutData(gd_lblOSI);
		lblOSI.setAlignment(SWT.RIGHT);

		cmbLevelViewer = new ComboViewer(composite, widgetStyle);
		Combo cmbOSI = cmbLevelViewer.getCombo();
		GridData gd_cmbOSI = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1,
				1);
		gd_cmbOSI.widthHint = 200;
		cmbOSI.setLayoutData(gd_cmbOSI);
		toolkit.paintBordersFor(cmbOSI);
		
		if(readonly){
			cmbOSI.setEnabled(false);
		}

		Label lblSpecification = toolkit.createLabel(composite,
				"Specification:", SWT.NONE);
		lblSpecification.setAlignment(SWT.RIGHT);

		txtSpecification = toolkit.createText(composite, "New Text", widgetStyle);
		txtSpecification.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));
		txtSpecification.setText("");
	}

	public EMFDataBindingContext initDataBindings_() {
		EMFDataBindingContext context = new EMFDataBindingContext();
		
		
		// text widgets. 
		
		IObservableValue nameObservable = SWTObservables.observeText(txtName,
				SWT.Modify);

		IObservableValue specificationObservable = SWTObservables.observeText(
				this.txtSpecification, SWT.Modify);

		IObservableValue descriptionObservable = SWTObservables.observeText(
				txtDescription, SWT.Modify);

		// Properties
		IEMFValueProperty nameProperty = EMFEditProperties.value(
				editingService.getEditingDomain(),
				ProtocolsPackage.Literals.PROTOCOL__NAME);

		IEMFValueProperty descriptionProperty = EMFEditProperties.value(
				editingService.getEditingDomain(),
				ProtocolsPackage.Literals.PROTOCOL__DESCRIPTION);

		IEMFValueProperty specificationProperty = EMFEditProperties.value(
				editingService.getEditingDomain(),
				ProtocolsPackage.Literals.PROTOCOL__SPECIFICATION);

		context.bindValue(nameObservable, nameProperty.observe(protocol), null,
				null);
		context.bindValue(descriptionObservable,
				descriptionProperty.observe(protocol), null, null);
		context.bindValue(specificationObservable,
				specificationProperty.observe(protocol), null, null);
		
		
		// Combo viewer. 
		
		cmbLevelViewer.setContentProvider(new ArrayContentProvider());
		cmbLevelViewer.setLabelProvider(new LabelProvider());
		cmbLevelViewer.setInput(OSIType.VALUES);

		IEMFValueProperty osiProperty = EMFEditProperties.value(
				editingService.getEditingDomain(),
				ProtocolsPackage.Literals.PROTOCOL__OSI);
		IValueProperty selectionProperty = ViewerProperties.singleSelection();

		context.bindValue(selectionProperty.observe(cmbLevelViewer),
				osiProperty.observe(protocol), null, null);

		return context;
	}

	public void injectData(Object owner, Object object) {
		if (owner instanceof Resource) {
			this.owner = (Resource) owner;
		} else {
			// We need the right type of object for this screen.
			throw new java.lang.IllegalArgumentException();
		}
		if (object != null && object instanceof Protocol) {
			protocol = (Protocol) object;
		} else {
			// We need the right type of object for this screen.
			throw new java.lang.IllegalArgumentException();
		}
		buildUI();
		m_bindingContext = initDataBindings_();
	}

	public void addData() {
		if (ScreenUtil.isNewOperation(getOperation()) && owner != null) {
			// If new, we have been operating on an object not added yet.
			Command c;

			c = new AddCommand(editingService.getEditingDomain(),
					owner.getContents(), protocol);

			editingService.getEditingDomain().getCommandStack().execute(c);
		} else if (ScreenUtil.isEditOperation(getOperation())) {

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
		return frmNewProtocol;
	}

	public void disposeData() {
		// N/A
	}

	public String getScreenName() {
		return "Protocol";
	}

}
