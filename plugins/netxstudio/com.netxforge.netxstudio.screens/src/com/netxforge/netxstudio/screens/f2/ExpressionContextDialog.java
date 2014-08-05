/*******************************************************************************
 * Copyright (c) Sep 22, 2012 NetXForge.
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

import java.util.Date;

import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.netxforge.base.NonModelUtils;
import com.netxforge.base.context.IComputationContext;
import com.netxforge.netxstudio.generics.DateTimeRange;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.screens.editing.base.IEditingService;

/**
 * Show an expression context in a dialog.
 * 
 * @author Christophe
 * 
 */
public class ExpressionContextDialog extends Dialog {

	private final FormToolkit toolkit = new FormToolkit(Display.getDefault());

	@SuppressWarnings("unused")
	private IEditingService editingService;

	// Our tableviewer.
	private TableViewer tblViewerContext;
	private TableColumn tblclmnType;
	private TableViewerColumn tblViewerClmnType;
	private TableColumn tblclmnValue;
	private TableViewerColumn tblViewerClmnValue;

	/**
	 * 
	 * Create the dialog.
	 * 
	 * @param parentShell
	 */
	public ExpressionContextDialog(Shell parentShell,
			IEditingService editingService) {
		super(parentShell);
		this.editingService = editingService;
	}

	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {

		Composite container = (Composite) super.createDialogArea(parent);
		container.setLayout(new FillLayout(SWT.HORIZONTAL));
		showContext(container);
		return container;
	}

	private void showContext(Composite parent) {

		// Remove the context
		tblViewerContext = new TableViewer(parent, SWT.BORDER
				| SWT.FULL_SELECTION);
		Table tblContext = tblViewerContext.getTable();
		tblContext.setHeaderVisible(true);
		tblContext.setLinesVisible(true);
		// gd_table.heightHint = 100;
		// tblContext.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true,
		// 1, 1));
		toolkit.paintBordersFor(tblContext);

		tblViewerClmnType = new TableViewerColumn(tblViewerContext, SWT.NONE);
		tblclmnType = tblViewerClmnType.getColumn();
		tblclmnType.setWidth(150);
		tblclmnType.setText("Type");

		tblViewerClmnValue = new TableViewerColumn(tblViewerContext, SWT.NONE);
		tblclmnValue = tblViewerClmnValue.getColumn();
		tblclmnValue.setWidth(250);
		tblclmnValue.setText("Value");
		this.initBindings();
	}

	public void injectData(WritableList currentContext) {
		tblViewerContext.setInput(currentContext);
	}

	public void initBindings() {
		// bind the result to a Writable value.
		ObservableListContentProvider contextListContentProvider = new ObservableListContentProvider();
		tblViewerContext.setContentProvider(contextListContentProvider);
		tblViewerContext.setLabelProvider(new CellLabelProvider() {

			@Override
			public void update(ViewerCell cell) {
				Object element = cell.getElement();

				if (element instanceof IComputationContext) {
					IComputationContext context = (IComputationContext) element;
					Object contextObject = context.getContext();
					if (contextObject != null) {
						int columnIndex = cell.getColumnIndex();
						switch (columnIndex) {
						case 0: {
							cell.setText(" "
									+ contextObject.getClass().getSimpleName());
						}
							break;
						case 1: {

							String text = "";

							if (contextObject instanceof Function) {
								text = ((Function) contextObject).getName();
							} else if (contextObject instanceof Equipment) {
								text = ((Equipment) contextObject)
										.getEquipmentCode();
							} else if (contextObject instanceof Node) {
								text = ((Node) contextObject).getNodeID();
							} else if (contextObject instanceof NetXResource) {
								text = ((NetXResource) contextObject)
										.getShortName();
							} else if (contextObject instanceof DateTimeRange) {
								DateTimeRange dtr = (DateTimeRange) contextObject;
								Date start = NonModelUtils.fromXMLDate(dtr
										.getBegin());
								Date end = NonModelUtils.fromXMLDate(dtr
										.getEnd());

								text = NonModelUtils.date(start) + " ("
										+ NonModelUtils.time(start) + ")"
										+ " --> " + NonModelUtils.date(end)
										+ " (" + NonModelUtils.time(end) + ")";
							}
							cell.setText(text);
						}
							break;
						}
					} else {
						cell.setText("Error, context object not set");
					}
				}
			}

		});
	}

	/**
	 * Create contents of the button bar.
	 * 
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);

		// createButton(parent, IDialogConstants.CANCEL_ID,
		// IDialogConstants.CANCEL_LABEL, false);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(600, 200);
	}

	@Override
	protected void configureShell(Shell newShell) {
		newShell.setText("Expression Context");
		super.configureShell(newShell);
	}
}
