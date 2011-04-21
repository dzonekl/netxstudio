package com.netxforge.netxstudio.screens.nf4;

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
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;

public class UsersAndRoles extends Composite {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	
	private Table table;
	private Text txtNewText;
	
	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public UsersAndRoles(Composite parent, int style) {
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
		frmMetricSources.setText("Users and Roles");
		frmMetricSources.getBody().setLayout(new GridLayout(2, false));
		
		Label lblNewLabel = toolkit.createLabel(frmMetricSources.getBody(), "Filter:", SWT.NONE);
		lblNewLabel.setAlignment(SWT.RIGHT);
		GridData gd_lblNewLabel = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_lblNewLabel.widthHint = 70;
		lblNewLabel.setLayoutData(gd_lblNewLabel);
		
		txtNewText = toolkit.createText(frmMetricSources.getBody(), "New Text", SWT.H_SCROLL | SWT.SEARCH | SWT.CANCEL);
		GridData gd_txtNewText = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_txtNewText.widthHint = 200;
		txtNewText.setLayoutData(gd_txtNewText);
		txtNewText.setText("");
		new Label(frmMetricSources.getBody(), SWT.NONE);
		
		TableViewer tableViewer = new TableViewer(frmMetricSources.getBody(), SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
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
		tblclmnLocationUrl.setText("Location URL");
		
		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_1 = tableViewerColumn_2.getColumn();
		tblclmnNewColumn_1.setWidth(100);
		tblclmnNewColumn_1.setText("Statistics");
		
		Button btnNewButton = toolkit.createButton(frmMetricSources.getBody(), "+", SWT.NONE);
		GridData gd_btnNewButton = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_btnNewButton.widthHint = 18;
		gd_btnNewButton.heightHint = 18;
		btnNewButton.setLayoutData(gd_btnNewButton);
		
		Button btnNewButton_1 = toolkit.createButton(frmMetricSources.getBody(), "-", SWT.NONE);
		GridData gd_btnNewButton_1 = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_btnNewButton_1.widthHint = 18;
		gd_btnNewButton_1.heightHint = 18;
		btnNewButton_1.setLayoutData(gd_btnNewButton_1);
		
		Composite composite = toolkit.createComposite(frmMetricSources.getBody(), SWT.NONE);
		toolkit.paintBordersFor(composite);
	}

}
