package com.netxforge.netxstudio.screens.f4;

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
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;

public class Metrics extends Composite {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Text txtFilterText;
	
	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public Metrics(Composite parent, int style) {
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
		frmMetricSources.setText("Metrics");
		frmMetricSources.getBody().setLayout(new GridLayout(2, false));
		
		Label lblFilterLabel = toolkit.createLabel(frmMetricSources.getBody(), "Filter:", SWT.NONE);
		lblFilterLabel.setAlignment(SWT.RIGHT);
		GridData gd_lblFilterLabel = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_lblFilterLabel.widthHint = 70;
		lblFilterLabel.setLayoutData(gd_lblFilterLabel);
		
		txtFilterText = toolkit.createText(frmMetricSources.getBody(), "New Text", SWT.H_SCROLL | SWT.SEARCH | SWT.CANCEL);
		txtFilterText.setText("");
		txtFilterText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(frmMetricSources.getBody(), SWT.NONE);
			
		
		// TODO, Replace by a treeviewer, when hooking data binding. 
		
		Tree tree = new Tree(frmMetricSources.getBody(), SWT.BORDER);
		tree.setLinesVisible(true);
		tree.setHeaderVisible(true);
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 4));
		toolkit.adapt(tree);
		toolkit.paintBordersFor(tree);
		
		TreeColumn trclmnNewColumn = new TreeColumn(tree, SWT.NONE);
		trclmnNewColumn.setWidth(176);
		trclmnNewColumn.setText("Name");
		
		TreeColumn trclmnNewColumn_1 = new TreeColumn(tree, SWT.NONE);
		trclmnNewColumn_1.setWidth(239);
		trclmnNewColumn_1.setText("Description");
		
		TreeItem trtmNewTreeitem = new TreeItem(tree, SWT.NONE);
		trtmNewTreeitem.setText(new String[] {"SGSN Traffic 2G", "SGSN Traffic in 2G"});
		
		TreeItem trtmNewTreeitem_1 = new TreeItem(trtmNewTreeitem, SWT.NONE);
		trtmNewTreeitem_1.setText(new String[] {"", "Bytes of 2G downlink packets forwarded successfully from GTP"});
		trtmNewTreeitem_1.setText("Gb mode downlink");
		
		TreeItem trtmNewTreeitem_3 = new TreeItem(trtmNewTreeitem, SWT.NONE);
		trtmNewTreeitem_3.setText(new String[] {"", "Bytes of 2G uplink packets forwarded successfully from GTP"});
		trtmNewTreeitem_3.setText("Gb mode uplink");
		trtmNewTreeitem.setExpanded(true);
		
		TreeColumn trclmnUnit = new TreeColumn(tree, SWT.NONE);
		trclmnUnit.setWidth(100);
		trclmnUnit.setText("Unit");
		
		TreeColumn trclmnExpression = new TreeColumn(tree, SWT.NONE);
		trclmnExpression.setWidth(100);
		trclmnExpression.setText("Expression");
		
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
