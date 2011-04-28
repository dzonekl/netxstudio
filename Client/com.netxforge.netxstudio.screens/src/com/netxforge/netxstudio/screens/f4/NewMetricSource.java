package com.netxforge.netxstudio.screens.f4;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
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
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.wb.swt.SWTResourceManager;

public class NewMetricSource extends Composite {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Text txtNewText;
	private Text txtNewText_1;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public NewMetricSource(Composite parent, int style) {
		super(parent, SWT.BORDER | SWT.EMBEDDED);
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
		setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Form frmNewForm = toolkit.createForm(this);
		frmNewForm.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmNewForm);
		frmNewForm.setText("New Metric Source");
		frmNewForm.getBody().setLayout(new FormLayout());
		
		Composite composite = toolkit.createComposite(frmNewForm.getBody(), SWT.NONE);
		composite.setLayout(new FillLayout(SWT.HORIZONTAL));
		FormData fd_composite = new FormData();
		fd_composite.bottom = new FormAttachment(0, 16);
		fd_composite.right = new FormAttachment(100);
		fd_composite.top = new FormAttachment(0);
		fd_composite.left = new FormAttachment(0);
		composite.setLayoutData(fd_composite);
		toolkit.paintBordersFor(composite);
		
		Label lblNewLabel = toolkit.createLabel(composite, "Data Entry Feedback", SWT.NONE);
		lblNewLabel.setBackground(SWTResourceManager.getColor(154, 205, 50));
		lblNewLabel.setAlignment(SWT.CENTER);
		
		Section sctnNewSection = toolkit.createSection(frmNewForm.getBody(), Section.EXPANDED | Section.TITLE_BAR);
		FormData fd_sctnNewSection = new FormData();
		fd_sctnNewSection.top = new FormAttachment(composite, 12);
		fd_sctnNewSection.bottom = new FormAttachment(0, 165);
		fd_sctnNewSection.right = new FormAttachment(100, -12);
		fd_sctnNewSection.left = new FormAttachment(0, 12);
		sctnNewSection.setLayoutData(fd_sctnNewSection);
		toolkit.paintBordersFor(sctnNewSection);
		sctnNewSection.setText("Info");
		
		Composite composite_1 = toolkit.createComposite(sctnNewSection, SWT.NONE);
		toolkit.paintBordersFor(composite_1);
		sctnNewSection.setClient(composite_1);
		composite_1.setLayout(new GridLayout(2, false));
		
		Label lblNewLabel_1 = toolkit.createLabel(composite_1, "Name:", SWT.NONE);
		lblNewLabel_1.setAlignment(SWT.RIGHT);
		GridData gd_lblNewLabel_1 = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_lblNewLabel_1.widthHint = 70;
		lblNewLabel_1.setLayoutData(gd_lblNewLabel_1);
		
		txtNewText = toolkit.createText(composite_1, "New Text", SWT.NONE);
		GridData gd_txtNewText = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_txtNewText.widthHint = 200;
		txtNewText.setLayoutData(gd_txtNewText);
		txtNewText.setText("");
		
		Label lblLocationUrl = toolkit.createLabel(composite_1, "Location URL:", SWT.NONE);
		lblLocationUrl.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblLocationUrl.setAlignment(SWT.RIGHT);
		
		txtNewText_1 = toolkit.createText(composite_1, "New Text", SWT.NONE);
		txtNewText_1.setText("");
		GridData gd_txtNewText_1 = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_txtNewText_1.widthHint = 200;
		txtNewText_1.setLayoutData(gd_txtNewText_1);
		
		Label lblNewLabel_2 = toolkit.createLabel(composite_1, "Mapping:", SWT.NONE);
		lblNewLabel_2.setAlignment(SWT.RIGHT);
		lblNewLabel_2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		
		Hyperlink hprlnkAddMapping = toolkit.createHyperlink(composite_1, "Add Mapping", SWT.NONE);
		toolkit.paintBordersFor(hprlnkAddMapping);
		
		Label lblNewLabel_3 = toolkit.createLabel(composite_1, "Schedule:", SWT.NONE);
		lblNewLabel_3.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		
		Hyperlink hprlnkScheduleTheData = toolkit.createHyperlink(composite_1, "Add a Job to schedule the metrics collection", SWT.NONE);
		toolkit.paintBordersFor(hprlnkScheduleTheData);
		
		Section sctnMetrics = toolkit.createSection(frmNewForm.getBody(), Section.EXPANDED | Section.TITLE_BAR);
		FormData fd_sctnMetrics = new FormData();
		fd_sctnMetrics.bottom = new FormAttachment(100, -12);
		fd_sctnMetrics.right = new FormAttachment(100, -12);
		fd_sctnMetrics.left = new FormAttachment(sctnNewSection, 0, SWT.LEFT);
		fd_sctnMetrics.top = new FormAttachment(sctnNewSection, 6);
		sctnMetrics.setLayoutData(fd_sctnMetrics);
		toolkit.paintBordersFor(sctnMetrics);
		sctnMetrics.setText("Metrics");
		
		Composite composite_2 = toolkit.createComposite(sctnMetrics, SWT.NONE);
		toolkit.paintBordersFor(composite_2);
		sctnMetrics.setClient(composite_2);
		composite_2.setLayout(new GridLayout(3, false));
		new Label(composite_2, SWT.NONE);
		
		Composite composite_3 = toolkit.createComposite(composite_2, SWT.NONE);
		GridData gd_composite_3 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_composite_3.widthHint = 70;
		gd_composite_3.heightHint = 18;
		composite_3.setLayoutData(gd_composite_3);
		toolkit.paintBordersFor(composite_3);
		
		TreeViewer treeViewer = new TreeViewer(composite_2, SWT.BORDER);
		treeViewer.setAutoExpandLevel(3);
		treeViewer.setColumnProperties(new String[] {});
		Tree tree = treeViewer.getTree();
		tree.setLinesVisible(true);
		tree.setHeaderVisible(true);
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 4));
		toolkit.paintBordersFor(tree);
		
		TreeViewerColumn treeViewerColumn = new TreeViewerColumn(treeViewer, SWT.NONE);
		TreeColumn trclmnName = treeViewerColumn.getColumn();
		trclmnName.setWidth(100);
		trclmnName.setText("Name");
		
		TreeViewerColumn treeViewerColumn_1 = new TreeViewerColumn(treeViewer, SWT.NONE);
		TreeColumn trclmnDescription = treeViewerColumn_1.getColumn();
		trclmnDescription.setWidth(100);
		trclmnDescription.setText("Description");
		new Label(composite_2, SWT.NONE);
		
		
		Button button = toolkit.createButton(composite_2, "+", SWT.NONE);
		button.setAlignment(SWT.RIGHT);
		GridData gd_button = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_button.widthHint = 18;
		gd_button.heightHint = 18;
		button.setLayoutData(gd_button);
		new Label(composite_2, SWT.NONE);
		
		Button button_1 = toolkit.createButton(composite_2, "-", SWT.NONE);
		GridData gd_button_1 = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_button_1.widthHint = 18;
		gd_button_1.heightHint = 18;
		button_1.setLayoutData(gd_button_1);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);

	}
}
