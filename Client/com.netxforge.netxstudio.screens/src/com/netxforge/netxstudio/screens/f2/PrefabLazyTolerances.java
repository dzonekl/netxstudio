/*******************************************************************************
 * Copyright (c) May 9, 2011 NetXForge.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  You should have received a copy of the GNU Lesser General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>
 *
 * Contributors:
 *    Christophe Bouhier - initial API and implementation and/or initial documentation
 *******************************************************************************/
package com.netxforge.netxstudio.screens.f2;

import java.util.List;

import org.eclipse.emf.cdo.eresource.CDOResource;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.screens.AbstractLazyTableScreen;
import com.netxforge.netxstudio.screens.editing.selector.ScreenUtil;

/**
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 */
public class PrefabLazyTolerances extends AbstractLazyTableScreen {

	private Form frmTolerances;
	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Resource toleranceResource;

	public PrefabLazyTolerances(Composite parent, int style) {
		super(parent, style);

		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
	}

	public void buildUI() {
		setLayout(new FillLayout(SWT.HORIZONTAL));

		// Readonlyness.
		boolean readonly = ScreenUtil.isReadOnlyOperation(this.getOperation());
		@SuppressWarnings("unused")
		int widgetStyle = readonly ? SWT.READ_ONLY : SWT.NONE;

		frmTolerances = toolkit.createForm(this);
		frmTolerances.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmTolerances);
		frmTolerances.setText(getOperationText() + "Tolerances");
		frmTolerances.getBody().setLayout(new GridLayout(3, false));
		super.buildUI(frmTolerances.getBody());

	}

	public Form getScreenForm() {
		return frmTolerances;
	}

	public EMFDataBindingContext initDataBindings_() {
		return null;
	}

	@Override
	public void injectData() {

		buildUI();
		toleranceResource = editingService
				.getData(LibraryPackage.Literals.TOLERANCE);

		if (toleranceResource instanceof CDOResource) {
			// CDOResource tolResource = (CDOResource) toleranceResource;
			// tolResource.cdoPrefetch(CDORevision.DEPTH_INFINITE);
		}

		// Should only apply the viewer filter here.

	}

	@Override
	protected List<?> delegateGetItems() {
		return toleranceResource.getContents();
	}

	protected void delegateBuildColumns(TableViewer viewer) {
		TableViewerColumn tableViewerColumn = new TableViewerColumn(viewer,
				SWT.NONE);
		TableColumn tblclmnName = tableViewerColumn.getColumn();
		tblclmnName.setWidth(143);
		tblclmnName.setText("Name");

		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(viewer,
				SWT.NONE);
		TableColumn tblclmnOwnedBy = tableViewerColumn_1.getColumn();
		tblclmnOwnedBy.setWidth(100);
		tblclmnOwnedBy.setText("Level");

		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(viewer,
				SWT.NONE);
		TableColumn tblclmnExpression = tableViewerColumn_2.getColumn();
		tblclmnExpression.setWidth(250);
		tblclmnExpression.setText("Expression");
	}

	@Override
	protected IBaseLabelProvider delegateGetListLabelProvider() {
		return new TolerancesLabelProvider();
	}
	
}
