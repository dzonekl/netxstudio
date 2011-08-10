package com.netxforge.netxstudio.screens.details;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.forms.widgets.ColumnLayout;
import org.eclipse.ui.forms.widgets.ColumnLayoutData;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

public class NewEditOperator extends Composite {
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private Table table;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public NewEditOperator(Composite parent, int style) {
		super(parent, style);
		setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Form frmNewEditOperator = formToolkit.createForm(this);
		formToolkit.paintBordersFor(frmNewEditOperator);
		frmNewEditOperator.setText("New Edit Operator");
		frmNewEditOperator.getBody().setLayout(new ColumnLayout());
		
		Section sctnInfo = formToolkit.createSection(frmNewEditOperator.getBody(), Section.TWISTIE | Section.TITLE_BAR);
		ColumnLayoutData cld_sctnInfo = new ColumnLayoutData();
		cld_sctnInfo.heightHint = 188;
		sctnInfo.setLayoutData(cld_sctnInfo);
		formToolkit.paintBordersFor(sctnInfo);
		sctnInfo.setText("Info");
		sctnInfo.setExpanded(true);
		
		Composite composite = formToolkit.createComposite(sctnInfo, SWT.NONE);
		formToolkit.paintBordersFor(composite);
		sctnInfo.setClient(composite);
		composite.setLayout(new GridLayout(1, false));
		
		TableViewer tableViewer = new TableViewer(composite, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		GridData gd_table = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_table.heightHint = 106;
		table.setLayoutData(gd_table);
		formToolkit.paintBordersFor(table);
		
		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn = tableViewerColumn.getColumn();
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("New Column");
		
		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_1 = tableViewerColumn_1.getColumn();
		tblclmnNewColumn_1.setWidth(100);
		tblclmnNewColumn_1.setText("New Column");
		
		Section sctnAnotherSection = formToolkit.createSection(frmNewEditOperator.getBody(), Section.TWISTIE | Section.TITLE_BAR);
		formToolkit.paintBordersFor(sctnAnotherSection);
		sctnAnotherSection.setText("Another section");
		sctnAnotherSection.setExpanded(true);
		
		Composite composite_1 = formToolkit.createComposite(sctnAnotherSection, SWT.NONE);
		formToolkit.paintBordersFor(composite_1);
		sctnAnotherSection.setClient(composite_1);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
