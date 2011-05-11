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
package com.netxforge.netxstudio.screens.ch9;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;

/**
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 * 
 */
public class Expressions extends Composite {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Text txtFilterText;
	private Table table;
	
	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public Expressions(Composite parent, int style) {
		super(parent, SWT.BORDER);
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
		setLayout(new FillLayout(SWT.HORIZONTAL));

		Form frmMetricSources = toolkit.createForm(this);
		frmMetricSources.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmMetricSources);
		frmMetricSources.setText("Expression");
		frmMetricSources.getBody().setLayout(new GridLayout(2, false));

		Label lblFilterLabel = toolkit.createLabel(frmMetricSources.getBody(),
				"Filter:", SWT.NONE);
		lblFilterLabel.setAlignment(SWT.RIGHT);
		GridData gd_lblFilterLabel = new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblFilterLabel.widthHint = 70;
		lblFilterLabel.setLayoutData(gd_lblFilterLabel);

		txtFilterText = toolkit.createText(frmMetricSources.getBody(),
				"New Text", SWT.H_SCROLL | SWT.SEARCH | SWT.CANCEL);
		txtFilterText.setText("");
		txtFilterText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));
		new Label(frmMetricSources.getBody(), SWT.NONE);
		

		TableViewer tableViewer = new TableViewer(frmMetricSources.getBody(), SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 4));
		toolkit.paintBordersFor(table);
		
		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn = tableViewerColumn.getColumn();
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("Name");
		
		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnLocationUrl = tableViewerColumn_1.getColumn();
		tblclmnLocationUrl.setWidth(100);
		tblclmnLocationUrl.setText("Owned by");
		
		Menu menu = new Menu(table);
		table.setMenu(menu);
		
		MenuItem mntmScheduleCollectionJob = new MenuItem(menu, SWT.NONE);
		mntmScheduleCollectionJob.setText("Edit...");
		
		Button btnAddButton = toolkit.createButton(frmMetricSources.getBody(), "+", SWT.NONE);
		GridData gd_btnAddButton = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_btnAddButton.widthHint = 18;
		gd_btnAddButton.heightHint = 18;
		btnAddButton.setLayoutData(gd_btnAddButton);
		
		Button btnRemoveButton_1 = toolkit.createButton(frmMetricSources.getBody(), "-", SWT.NONE);
		GridData gd_btnRemoveButton_1 = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_btnRemoveButton_1.widthHint = 18;
		gd_btnRemoveButton_1.heightHint = 18;
		btnRemoveButton_1.setLayoutData(gd_btnRemoveButton_1);
		new Label(frmMetricSources.getBody(), SWT.NONE);
		
	}

}
