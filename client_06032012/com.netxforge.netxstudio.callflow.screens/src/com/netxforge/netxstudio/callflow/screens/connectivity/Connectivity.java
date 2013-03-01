/*******************************************************************************
 * Copyright (c) 1 mrt. 2013 NetXForge.
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
package com.netxforge.netxstudio.callflow.screens.connectivity;

import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.editing.selector.IDataServiceInjection;
import com.netxforge.netxstudio.screens.editing.selector.ScreenUtil;

public class Connectivity extends AbstractScreen implements IDataServiceInjection {
	
	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	
	private Form frmConnectivity;
	
	public Connectivity(Composite parent, int style) {
		super(parent, style);
		
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
		buildUI();
	}

	private void buildUI() {
		
setLayout(new FillLayout(SWT.HORIZONTAL));
		
		@SuppressWarnings("unused")
		int widgetStyle = SWT.None;
		if (ScreenUtil.isReadOnlyOperation(getOperation())) {
			widgetStyle |= SWT.READ_ONLY;
		}

		// Create the form.
		frmConnectivity = toolkit.createForm(this);
		frmConnectivity.setSeparatorVisible(true);

		frmConnectivity.setText(this.getScreenName());
		frmConnectivity.getToolBarManager().update(true);
		frmConnectivity.setToolBarVerticalAlignment(SWT.TOP);

		
		toolkit.decorateFormHeading(frmConnectivity);
		toolkit.paintBordersFor(frmConnectivity);

		// Body of the form.
		FillLayout fl = new FillLayout();
		frmConnectivity.getBody().setLayout(fl); 
		
	}

	public Form getScreenForm() {
		return frmConnectivity;
	}

	public EMFDataBindingContext initDataBindings_() {
		
		@SuppressWarnings("unused")
		EMFDataBindingContext emfDataBindingContext = new EMFDataBindingContext();
		
		
		return null;
	}

	public Viewer getViewer() {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.netxforge.netxstudio.callflow.screens.AbstractScreenImpl#getScreenName()
	 */
	@Override
	public String getScreenName() {
		return "Connectivity";
	}

}
