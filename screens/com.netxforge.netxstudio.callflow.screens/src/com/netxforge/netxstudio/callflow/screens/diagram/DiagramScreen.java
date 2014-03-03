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
package com.netxforge.netxstudio.callflow.screens.diagram;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.gef.SnapToGrid;
import org.eclipse.gef.editparts.ScalableFreeformRootEditPart;
import org.eclipse.gef.ui.parts.ScrollingGraphicalViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.part.ShowInContext;

import com.netxforge.netxstudio.callflow.screens.AbstractScreen;
import com.netxforge.netxstudio.callflow.screens.callflows.model.CanvasModel;
import com.netxforge.netxstudio.callflow.screens.callflows.parts.CallflowEditPartsFactory;
import com.netxforge.netxstudio.screens.editing.IDataServiceInjection;
import com.netxforge.netxstudio.screens.editing.ScreenUtil;
import com.netxforge.netxstudio.services.ServiceFlow;

public class DiagramScreen extends AbstractScreen implements
		IDataServiceInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());

	private Form frmDiagram;

	private ScrollingGraphicalViewer graphicalViewer;

	public DiagramScreen(Composite parent, int style) {
		super(parent, style);

		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
	}
	
	
	
	
	@Override
	public boolean handleShowIn(ShowInContext context) {
		ISelection selection = context.getSelection();
		if(selection instanceof IStructuredSelection){
			Object firstElement = ((IStructuredSelection) selection).getFirstElement();
			if(firstElement instanceof ServiceFlow){
				ServiceFlow sf = (ServiceFlow) firstElement;
				graphicalViewer.setEditPartFactory(new CallflowEditPartsFactory());
				graphicalViewer.setContents(new CanvasModel(sf));
				graphicalViewer.getRootEditPart().refresh();
				return true;
			}
		}
		return true;
	}


	public void buildUI() {

		setLayout(new FillLayout(SWT.HORIZONTAL));

		@SuppressWarnings("unused")
		int widgetStyle = SWT.None;
		if (ScreenUtil.isReadOnlyOperation(getOperation())) {
			widgetStyle |= SWT.READ_ONLY;
		}

		// Create the form.
		frmDiagram = toolkit.createForm(this);
		frmDiagram.setSeparatorVisible(true);

		frmDiagram.setText(this.getScreenName());
		frmDiagram.getToolBarManager().update(true);
		frmDiagram.setToolBarVerticalAlignment(SWT.TOP);

		toolkit.decorateFormHeading(frmDiagram);
		toolkit.paintBordersFor(frmDiagram);

		// Body of the form.
		FillLayout fl = new FillLayout();
		frmDiagram.getBody().setLayout(fl);
		
		ScalableFreeformRootEditPart rootEditPart = new ScalableFreeformRootEditPart();
		graphicalViewer = new ScrollingGraphicalViewer();
		graphicalViewer.setProperty(SnapToGrid.PROPERTY_GRID_VISIBLE, true);
		graphicalViewer.createControl(frmDiagram.getBody());
		graphicalViewer.getControl().setBackground(
				ColorConstants.listBackground);
		graphicalViewer.setRootEditPart(rootEditPart);
	}

	public Form getScreenForm() {
		return frmDiagram;
	}

	public EMFDataBindingContext initDataBindings_() {

		@SuppressWarnings("unused")
		EMFDataBindingContext emfDataBindingContext = new EMFDataBindingContext();

		return null;
	}

	public Viewer getViewer() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.callflow.screens.AbstractScreenImpl#getScreenName
	 * ()
	 */
	@Override
	public String getScreenName() {
		return "Diagram";
	}

}
