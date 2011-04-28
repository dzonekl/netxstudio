package com.netxforge.netxstudio.screens.f4;

import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.nebula.widgets.cdatetime.CDT;
import org.eclipse.nebula.widgets.cdatetime.CDateTime;
import org.eclipse.nebula.widgets.datechooser.DateChooserCombo;
import org.eclipse.nebula.widgets.datechooser.DateChooserTheme;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.wb.swt.SWTResourceManager;

public class NewScheduledJob extends Composite {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Text text;
	private Text text_2;
	private Table table;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	@SuppressWarnings("unused")
	public NewScheduledJob(Composite parent, int style) {
		super(parent, SWT.BORDER);
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
		setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Form frmNewJob = toolkit.createForm(this);
		frmNewJob.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmNewJob);
		frmNewJob.setText("New Job");
		frmNewJob.getBody().setLayout(new FormLayout());
		
		Composite composite = toolkit.createComposite(frmNewJob.getBody(), SWT.NONE);
		composite.setLayout(new FillLayout(SWT.HORIZONTAL));
		FormData fd_composite = new FormData();
		fd_composite.left = new FormAttachment(0);
		fd_composite.right = new FormAttachment(100);
		fd_composite.bottom = new FormAttachment(0, 16);
		fd_composite.top = new FormAttachment(0);
		composite.setLayoutData(fd_composite);
		composite.setBounds(0, 0, 64, 64);
		toolkit.paintBordersFor(composite);
		
		Label lblNewLabel = toolkit.createLabel(composite, "Data Entry Feedback", SWT.NONE);
		lblNewLabel.setBackground(SWTResourceManager.getColor(154, 205, 50));
		lblNewLabel.setAlignment(SWT.CENTER);
		
		Section sctnDetails = toolkit.createSection(frmNewJob.getBody(), Section.EXPANDED | Section.TITLE_BAR);
		FormData fd_sctnDetails = new FormData();
		fd_sctnDetails.bottom = new FormAttachment(0, 120);
		fd_sctnDetails.right = new FormAttachment(0, 320);
		fd_sctnDetails.top = new FormAttachment(composite, 6);
		fd_sctnDetails.left = new FormAttachment(0, 12);
		sctnDetails.setLayoutData(fd_sctnDetails);
		toolkit.paintBordersFor(sctnDetails);
		sctnDetails.setText("Job Details");
		
		Composite composite_1 = toolkit.createComposite(sctnDetails, SWT.NONE);
		toolkit.paintBordersFor(composite_1);
		sctnDetails.setClient(composite_1);
		composite_1.setLayout(new GridLayout(2, false));
		
		Label lblNewLabel_1 = toolkit.createLabel(composite_1, "Name:", SWT.NONE);
		GridData gd_lblNewLabel_1 = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_lblNewLabel_1.widthHint = 70;
		lblNewLabel_1.setLayoutData(gd_lblNewLabel_1);
		lblNewLabel_1.setAlignment(SWT.RIGHT);
		
		text = toolkit.createText(composite_1, "New Text", SWT.NONE);
		text.setText("");
		GridData gd_text = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_text.widthHint = 200;
		text.setLayoutData(gd_text);
		
		Label lblType = toolkit.createLabel(composite_1, "Type:", SWT.NONE);
		lblType.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblType.setAlignment(SWT.RIGHT);
		
		ComboViewer comboViewer_2 = new ComboViewer(composite_1, SWT.NONE);
		Combo combo_2 = comboViewer_2.getCombo();
		combo_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		toolkit.paintBordersFor(combo_2);
		
		Section sctnNewSection = toolkit.createSection(frmNewJob.getBody(), Section.EXPANDED | Section.TITLE_BAR);
		FormData fd_sctnNewSection = new FormData();
		fd_sctnNewSection.bottom = new FormAttachment(0, 220);
		fd_sctnNewSection.right = new FormAttachment(100, -12);
		fd_sctnNewSection.left = new FormAttachment(sctnDetails, 12);
		fd_sctnNewSection.top = new FormAttachment(sctnDetails, 0, SWT.TOP);
		sctnNewSection.setLayoutData(fd_sctnNewSection);
		toolkit.paintBordersFor(sctnNewSection);
		sctnNewSection.setText("Recurring");
		
		Composite composite_2 = toolkit.createComposite(sctnNewSection, SWT.NONE);
		toolkit.paintBordersFor(composite_2);
		sctnNewSection.setClient(composite_2);
		composite_2.setLayout(new GridLayout(6, false));
		
		Label lblNewLabel_2 = toolkit.createLabel(composite_2, "On:", SWT.NONE);
		lblNewLabel_2.setAlignment(SWT.RIGHT);
		GridData gd_lblNewLabel_2 = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_lblNewLabel_2.widthHint = 70;
		lblNewLabel_2.setLayoutData(gd_lblNewLabel_2);
		
		ComboViewer comboViewer = new ComboViewer(composite_2, SWT.NONE);
		Combo combo = comboViewer.getCombo();
		GridData gd_combo = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1);
		gd_combo.widthHint = 150;
		combo.setLayoutData(gd_combo);
		toolkit.paintBordersFor(combo);
		
		Label lblAt = toolkit.createLabel(composite_2, "At:", SWT.NONE);
		lblAt.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		
		CDateTime dateTime = new CDateTime(composite_2, CDT.BORDER | CDT.CLOCK_24_HOUR | CDT.DROP_DOWN | CDT.TIME_SHORT);
		toolkit.adapt(dateTime);
		toolkit.paintBordersFor(dateTime);
		
		Label lblEvery = toolkit.createLabel(composite_2, "Every:", SWT.NONE);
		lblEvery.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblEvery.setAlignment(SWT.RIGHT);
		
		ComboViewer comboViewer_1 = new ComboViewer(composite_2, SWT.NONE);
		Combo combo_1 = comboViewer_1.getCombo();
		GridData gd_combo_1 = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1);
		gd_combo_1.widthHint = 150;
		combo_1.setLayoutData(gd_combo_1);
		toolkit.paintBordersFor(combo_1);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		
		Label lblStartsOn = toolkit.createLabel(composite_2, "Starts On:", SWT.NONE);
		lblStartsOn.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 2, 1));
		lblStartsOn.setAlignment(SWT.RIGHT);
		
		DateChooserCombo dateChooserCombo = new DateChooserCombo(composite_2, SWT.BORDER | SWT.FLAT);
		GridData gd_dateChooserCombo = new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1);
		gd_dateChooserCombo.heightHint = 19;
		dateChooserCombo.setLayoutData(gd_dateChooserCombo);
		dateChooserCombo.setTheme(DateChooserTheme.YELLOW);
		toolkit.adapt(dateChooserCombo);
		toolkit.paintBordersFor(dateChooserCombo);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		
		Label lblNewLabel_3 = toolkit.createLabel(composite_2, "Ends", SWT.NONE);
		lblNewLabel_3.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		
		Button btnOn = toolkit.createButton(composite_2, "On: ", SWT.RADIO);
		
		DateChooserCombo dateChooserCombo_1 = new DateChooserCombo(composite_2, SWT.BORDER | SWT.FLAT);
		GridData gd_dateChooserCombo_1 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1);
		gd_dateChooserCombo_1.heightHint = 19;
		dateChooserCombo_1.setLayoutData(gd_dateChooserCombo_1);
		toolkit.adapt(dateChooserCombo_1);
		toolkit.paintBordersFor(dateChooserCombo_1);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		
		Button btnAfter = toolkit.createButton(composite_2, "After:", SWT.RADIO);
		
		text_2 = toolkit.createText(composite_2, "New Text", SWT.NONE);
		GridData gd_text_2 = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_text_2.widthHint = 15;
		text_2.setLayoutData(gd_text_2);
		text_2.setText("");
		
		Label lblOccurences = toolkit.createLabel(composite_2, "Occurences", SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		
		Button btnNever = toolkit.createButton(composite_2, "Never", SWT.RADIO);
		btnNever.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		
		Section sctnSummary = toolkit.createSection(frmNewJob.getBody(), Section.EXPANDED | Section.TITLE_BAR);
		FormData fd_sctnSummary = new FormData();
		fd_sctnSummary.top = new FormAttachment(sctnNewSection, 6);
		fd_sctnSummary.bottom = new FormAttachment(100, -12);
		fd_sctnSummary.right = new FormAttachment(100, -12);
		fd_sctnSummary.left = new FormAttachment(sctnDetails, 0, SWT.LEFT);
		sctnSummary.setLayoutData(fd_sctnSummary);
		toolkit.paintBordersFor(sctnSummary);
		sctnSummary.setText("Summary");
		
		Composite composite_3 = toolkit.createComposite(sctnSummary, SWT.NONE);
		toolkit.paintBordersFor(composite_3);
		sctnSummary.setClient(composite_3);
		composite_3.setLayout(new GridLayout(2, false));
		
		Composite composite_4 = toolkit.createComposite(composite_3, SWT.NONE);
		GridData gd_composite_4 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_composite_4.heightHint = 18;
		gd_composite_4.widthHint = 70;
		composite_4.setLayoutData(gd_composite_4);
		toolkit.paintBordersFor(composite_4);
		
		TableViewer tableViewer = new TableViewer(composite_3, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 4));
		toolkit.paintBordersFor(table);
		
		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnDate = tableViewerColumn.getColumn();
		tblclmnDate.setWidth(100);
		tblclmnDate.setText("Date");
		
		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnTime = tableViewerColumn_1.getColumn();
		tblclmnTime.setWidth(100);
		tblclmnTime.setText("Time");
		
		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnType = tableViewerColumn_2.getColumn();
		tblclmnType.setWidth(100);
		tblclmnType.setText("Type");
		
		Button button = toolkit.createButton(composite_3, "+", SWT.NONE);
		button.setAlignment(SWT.RIGHT);
		GridData gd_button = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_button.heightHint = 18;
		gd_button.widthHint = 18;
		button.setLayoutData(gd_button);
		
		Button button_1 = toolkit.createButton(composite_3, "-", SWT.NONE);
		GridData gd_button_1 = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_button_1.widthHint = 18;
		gd_button_1.heightHint = 18;
		button_1.setLayoutData(gd_button_1);
		new Label(composite_3, SWT.NONE);
		new Label(composite_3, SWT.NONE);
		new Label(composite_3, SWT.NONE);

	}
}
