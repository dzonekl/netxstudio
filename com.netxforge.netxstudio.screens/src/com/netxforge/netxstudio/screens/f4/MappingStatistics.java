package com.netxforge.netxstudio.screens.f4;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormText;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

public class MappingStatistics extends Composite {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Table table;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public MappingStatistics(Composite parent, int style) {
		super(parent, SWT.BORDER);
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
		setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Form frmMappingStatistics = toolkit.createForm(this);
		frmMappingStatistics.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmMappingStatistics);
		frmMappingStatistics.setText("Mapping Statistics: <Metric Source>");
		frmMappingStatistics.getBody().setLayout(new FormLayout());
		
		Section sctnSummary = toolkit.createSection(frmMappingStatistics.getBody(), Section.EXPANDED | Section.TITLE_BAR);
		FormData fd_sctnSummary = new FormData();
		fd_sctnSummary.bottom = new FormAttachment(0, 105);
		fd_sctnSummary.right = new FormAttachment(100, -12);
		fd_sctnSummary.top = new FormAttachment(0, 12);
		fd_sctnSummary.left = new FormAttachment(0, 12);
		sctnSummary.setLayoutData(fd_sctnSummary);
		toolkit.paintBordersFor(sctnSummary);
		sctnSummary.setText("Summary");
		
		Composite composite = toolkit.createComposite(sctnSummary, SWT.NONE);
		toolkit.paintBordersFor(composite);
		sctnSummary.setClient(composite);
		composite.setLayout(new GridLayout(2, false));
		
		@SuppressWarnings("unused")
		Label lblTotalRecordsProcessed = toolkit.createLabel(composite, "Total records processed: ", SWT.NONE);
		
		FormText formText_1 = toolkit.createFormText(composite, false);
		toolkit.paintBordersFor(formText_1);
		formText_1.setText("<value>", false, false);
		
		Label lblStartDatetime = toolkit.createLabel(composite, "Start Date/Time:", SWT.NONE);
		lblStartDatetime.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		
		FormText formText = toolkit.createFormText(composite, false);
		GridData gd_formText = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_formText.heightHint = 37;
		formText.setLayoutData(gd_formText);
		toolkit.paintBordersFor(formText);
		formText.setText("<value>", false, false);
		
		Label lblEndDatetime = toolkit.createLabel(composite, "End Date/Time:", SWT.NONE);
		lblEndDatetime.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		
		FormText formText_2 = toolkit.createFormText(composite, false);
		toolkit.paintBordersFor(formText_2);
		formText_2.setText("<value>", false, false);
		
		ExpandableComposite xpndblcmpstFailedRecords = toolkit.createExpandableComposite(frmMappingStatistics.getBody(), ExpandableComposite.CLIENT_INDENT | ExpandableComposite.EXPANDED | ExpandableComposite.TREE_NODE);
		FormData fd_xpndblcmpstFailedRecords = new FormData();
		fd_xpndblcmpstFailedRecords.bottom = new FormAttachment(100, -12);
		fd_xpndblcmpstFailedRecords.right = new FormAttachment(100, -12);
		fd_xpndblcmpstFailedRecords.top = new FormAttachment(sctnSummary, 12);
		fd_xpndblcmpstFailedRecords.left = new FormAttachment(0, 12);
		xpndblcmpstFailedRecords.setLayoutData(fd_xpndblcmpstFailedRecords);
		toolkit.paintBordersFor(xpndblcmpstFailedRecords);
		xpndblcmpstFailedRecords.setText("Failed Records");
		
		Composite composite_1 = toolkit.createComposite(xpndblcmpstFailedRecords, SWT.NONE);
		toolkit.paintBordersFor(composite_1);
		xpndblcmpstFailedRecords.setClient(composite_1);
		composite_1.setLayout(null);
		
		TableViewer tableViewer = new TableViewer(composite_1, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setBounds(0, 0, 202, 102);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		toolkit.paintBordersFor(table);
		
		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn = tableViewerColumn.getColumn();
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("Row");
		
		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnColumn = tableViewerColumn_1.getColumn();
		tblclmnColumn.setWidth(100);
		tblclmnColumn.setText("Column");

	}
}
