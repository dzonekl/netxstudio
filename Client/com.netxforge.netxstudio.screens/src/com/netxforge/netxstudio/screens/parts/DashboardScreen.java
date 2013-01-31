/*******************************************************************************
 * Copyright (c) 31 jan. 2013 NetXForge.
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
package com.netxforge.netxstudio.screens.parts;

import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.widgets.ColumnLayout;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.editing.selector.IDataScreenInjection;

/**
 * Monitoring Dashboard 
 * 
 * @author Christophe Bouhier
 * 
 */
public class DashboardScreen extends AbstractScreen implements
		IDataScreenInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	
	/** The Form for this screen*/
	private Form frmDashBoardScreen;
	
	public DashboardScreen(Composite parent, int style) {
		super(parent, style);
	}

	public void buildUI(){
		setLayout(new FillLayout(SWT.HORIZONTAL));

		frmDashBoardScreen = toolkit.createForm(this);
		frmDashBoardScreen.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmDashBoardScreen);

		frmDashBoardScreen.getBody().setLayout(new ColumnLayout());
		
	}
	
	public Form getScreenForm() {
		return frmDashBoardScreen;
	}

	public EMFDataBindingContext initDataBindings_() {
		return null;
	}

	public Viewer getViewer() {
		return null;
	}

	public void addData() {
		// TODO Auto-generated method stub
		
	}

}
