package com.netxforge.netxstudio.screens.f4;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.DetailsPart;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.MasterDetailsBlock;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

public class MetricSourceMDBlock extends MasterDetailsBlock {

	private FormToolkit toolkit;
	private Table table;
	private Text txtNewText;
	private Section section;
	/**
	 * Create the master details block.
	 */
	public MetricSourceMDBlock() {
		// Create the master details block
	}

	/**
	 * Create contents of the master details block.
	 * @param managedForm
	 * @param parent
	 */
	@Override
	protected void createMasterPart(IManagedForm managedForm, Composite parent) {
		toolkit = managedForm.getToolkit();
		//		
		section = toolkit.createSection(parent,
				ExpandableComposite.EXPANDED | ExpandableComposite.TITLE_BAR);
		//
		Composite composite = toolkit.createComposite(section, SWT.NONE);
		toolkit.paintBordersFor(composite);
		section.setClient(composite);
		
		composite.setLayout(new GridLayout(2, false));
		
		Label lblNewLabel = toolkit.createLabel(composite, "Filter:", SWT.NONE);
		lblNewLabel.setAlignment(SWT.RIGHT);
		GridData gd_lblNewLabel = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_lblNewLabel.widthHint = 70;
		lblNewLabel.setLayoutData(gd_lblNewLabel);
		
		txtNewText = toolkit.createText(composite, "New Text", SWT.H_SCROLL | SWT.SEARCH | SWT.CANCEL);
		txtNewText.setText("");
		txtNewText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(composite, SWT.NONE);
		
		TableViewer tableViewer = new TableViewer(composite, SWT.BORDER | SWT.FULL_SELECTION);
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
		
		Button btnNewButton = toolkit.createButton(composite, "+", SWT.NONE);
		GridData gd_btnNewButton = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_btnNewButton.widthHint = 18;
		gd_btnNewButton.heightHint = 18;
		btnNewButton.setLayoutData(gd_btnNewButton);
		
		Button btnNewButton_1 = toolkit.createButton(composite, "-", SWT.NONE);
		GridData gd_btnNewButton_1 = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_btnNewButton_1.widthHint = 18;
		gd_btnNewButton_1.heightHint = 18;
		btnNewButton_1.setLayoutData(gd_btnNewButton_1);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		
	}

	/**
	 * Register the pages.
	 * @param part
	 */
	@Override
	protected void registerPages(DetailsPart part) {
		// Register the pages
	}

	/**
	 * Create the toolbar actions.
	 * @param managedForm
	 */
	@Override
	protected void createToolBarActions(IManagedForm managedForm) {
		// Create the toolbar actions
	}

	public Section getMasterSection() {
		return section;
	}
}
