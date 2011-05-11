package com.netxforge.netxstudio.screens.f4;

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
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.netxforge.netxstudio.screens.selector.ScreenFormService;

public class Scheduler extends Composite {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Table table;
	private Text txtFilterText;
	// TODO we will need this later. 
	
	@SuppressWarnings("unused")
	final private ScreenFormService service;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public Scheduler(Composite parent, int style) {
		this(parent, style, null);
	}

	public Scheduler(Composite parent, int style,
			ScreenFormService selectorService) {
		super(parent, SWT.BORDER);
		this.service = selectorService;
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
		setLayout(new FillLayout(SWT.HORIZONTAL));

		Form frmScheduledJobs = toolkit.createForm(this);
		frmScheduledJobs.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmScheduledJobs);
		frmScheduledJobs.setText("Scheduled Jobs");
		frmScheduledJobs.getBody().setLayout(new GridLayout(2, false));

		Label lblFilterLabel = toolkit.createLabel(frmScheduledJobs.getBody(),
				"Filter:", SWT.NONE);
		lblFilterLabel.setAlignment(SWT.RIGHT);
		GridData gd_lblFilterLabel = new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblFilterLabel.widthHint = 70;
		lblFilterLabel.setLayoutData(gd_lblFilterLabel);

		txtFilterText = toolkit.createText(frmScheduledJobs.getBody(),
				"New Text", SWT.H_SCROLL | SWT.SEARCH | SWT.CANCEL);
		txtFilterText.setText("");
		txtFilterText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));
		new Label(frmScheduledJobs.getBody(), SWT.NONE);

		TableViewer tableViewer = new TableViewer(frmScheduledJobs.getBody(),
				SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 4));
		toolkit.paintBordersFor(table);

		TableViewerColumn tableViewerColumn = new TableViewerColumn(
				tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn = tableViewerColumn.getColumn();
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("Name");

		TableViewerColumn tableViewerColumn_3 = new TableViewerColumn(
				tableViewer, SWT.NONE);
		TableColumn tblclmnType = tableViewerColumn_3.getColumn();
		tblclmnType.setWidth(100);
		tblclmnType.setText("Type");

		TableViewerColumn tableViewerColumn_4 = new TableViewerColumn(
				tableViewer, SWT.NONE);
		TableColumn tblclmnActive = tableViewerColumn_4.getColumn();
		tblclmnActive.setWidth(100);
		tblclmnActive.setText("Active");

		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(
				tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_1 = tableViewerColumn_2.getColumn();
		tblclmnNewColumn_1.setWidth(81);
		tblclmnNewColumn_1.setText("Log");

		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(
				tableViewer, SWT.NONE);
		TableColumn tblclmnLocationUrl = tableViewerColumn_1.getColumn();
		tblclmnLocationUrl.setWidth(100);
		tblclmnLocationUrl.setText("History");

		TableItem tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText(new String[] { "SGSN Attached", "Datacollection",
				"Yes" });

		Button btnAddButton = toolkit.createButton(frmScheduledJobs.getBody(),
				"+", SWT.NONE);
		GridData gd_btnAddButton = new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1);
		gd_btnAddButton.widthHint = 18;
		gd_btnAddButton.heightHint = 18;
		btnAddButton.setLayoutData(gd_btnAddButton);

		Button btnRemoveButton = toolkit.createButton(
				frmScheduledJobs.getBody(), "-", SWT.NONE);
		GridData gd_btnRemoveButton = new GridData(SWT.RIGHT, SWT.CENTER,
				false, false, 1, 1);
		gd_btnRemoveButton.widthHint = 18;
		gd_btnRemoveButton.heightHint = 18;
		btnRemoveButton.setLayoutData(gd_btnRemoveButton);
		new Label(frmScheduledJobs.getBody(), SWT.NONE);
	}

}
