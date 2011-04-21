package com.netxforge.netxstudio.screens.f4;

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
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.ui.forms.widgets.FormText;
import org.eclipse.ui.forms.widgets.Hyperlink;

public class NewMappingColumn extends Composite {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Text txtNewText;
	private Text text;
	private Combo text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text txtNewText_1;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public NewMappingColumn(Composite parent, int style) {
		super(parent, SWT.BORDER);
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
		setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Form frmNewMappingColumn = toolkit.createForm(this);
		frmNewMappingColumn.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmNewMappingColumn);
		frmNewMappingColumn.setText("New Mapping Column");
		frmNewMappingColumn.getBody().setLayout(new FormLayout());
		
		Composite composite = toolkit.createComposite(frmNewMappingColumn.getBody(), SWT.NONE);
		composite.setLayout(new FillLayout(SWT.HORIZONTAL));
		FormData fd_composite = new FormData();
		fd_composite.right = new FormAttachment(100);
		fd_composite.bottom = new FormAttachment(0, 16);
		fd_composite.top = new FormAttachment(0);
		fd_composite.left = new FormAttachment(0);
		composite.setLayoutData(fd_composite);
		toolkit.paintBordersFor(composite);
		
		Label lblNewLabel = toolkit.createLabel(composite, "Data Entry Feedback", SWT.NONE);
		lblNewLabel.setBackground(SWTResourceManager.getColor(154, 205, 50));
		lblNewLabel.setAlignment(SWT.CENTER);
		
		Section sctnMappings = toolkit.createSection(frmNewMappingColumn.getBody(), Section.EXPANDED | Section.TITLE_BAR);
		FormData fd_sctnMappings = new FormData();
		fd_sctnMappings.top = new FormAttachment(composite, 12);
		fd_sctnMappings.bottom = new FormAttachment(0, 120);
		fd_sctnMappings.right = new FormAttachment(100, -12);
		fd_sctnMappings.left = new FormAttachment(0, 12);
		sctnMappings.setLayoutData(fd_sctnMappings);
		toolkit.paintBordersFor(sctnMappings);
		sctnMappings.setText("Info");
		
		Composite composite_1 = toolkit.createComposite(sctnMappings, SWT.NONE);
		toolkit.paintBordersFor(composite_1);
		sctnMappings.setClient(composite_1);
		composite_1.setLayout(new GridLayout(3, false));
		
		Label lblHeaderName = toolkit.createLabel(composite_1, "Header Name:", SWT.NONE);
		lblHeaderName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		
		txtNewText = toolkit.createText(composite_1, "New Text", SWT.NONE);
		txtNewText.setText("");
		GridData gd_txtNewText = new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1);
		gd_txtNewText.widthHint = 200;
		txtNewText.setLayoutData(gd_txtNewText);
		
		Label lblHeaderRow = toolkit.createLabel(composite_1, "Header Row:", SWT.NONE);
		lblHeaderRow.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		
		text = toolkit.createText(composite_1, "New Text", SWT.NONE);
		GridData gd_text = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_text.widthHint = 15;
		text.setLayoutData(gd_text);
		text.setText("");
		new Label(composite_1, SWT.NONE);
		
		Section sctnNewSection = toolkit.createSection(frmNewMappingColumn.getBody(), Section.EXPANDED | Section.TITLE_BAR);
		FormData fd_sctnNewSection = new FormData();
		fd_sctnNewSection.bottom = new FormAttachment(100, -12);
		fd_sctnNewSection.right = new FormAttachment(sctnMappings, 0, SWT.RIGHT);
		fd_sctnNewSection.top = new FormAttachment(sctnMappings, 6);
		fd_sctnNewSection.left = new FormAttachment(0, 12);
		sctnNewSection.setLayoutData(fd_sctnNewSection);
		toolkit.paintBordersFor(sctnNewSection);
		sctnNewSection.setText("Mapping");
		sctnNewSection.setExpanded(true);
		
		Composite composite_2 = toolkit.createComposite(sctnNewSection, SWT.NONE);
		toolkit.paintBordersFor(composite_2);
		sctnNewSection.setClient(composite_2);
		GridLayout gl_composite_2 = new GridLayout(6, false);
		gl_composite_2.horizontalSpacing = 10;
		composite_2.setLayout(gl_composite_2);
		
		FormText formText_2 = toolkit.createFormText(composite_2, false);
		formText_2.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		toolkit.paintBordersFor(formText_2);
		formText_2.setText("<form><p><b>Column Type</b></p></form>", true, false);
		new Label(composite_2, SWT.NONE);
		
		FormText formText = toolkit.createFormText(composite_2, false);
		formText.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
		toolkit.paintBordersFor(formText);
		formText.setText("<form><p><b>Pattern</b></p></form>", true, false);
		new Label(composite_2, SWT.NONE);
		
		FormText formText_1 = toolkit.createFormText(composite_2, false);
		formText_1.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1));
		toolkit.paintBordersFor(formText_1);
		formText_1.setText("<form><p><b>Object</b></p></form>", true, false);
		
		Button btnTimeStamp = toolkit.createButton(composite_2, "Time Stamp", SWT.RADIO);
		GridData gd_btnTimeStamp = new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1);
		gd_btnTimeStamp.widthHint = 100;
		btnTimeStamp.setLayoutData(gd_btnTimeStamp);
		new Label(composite_2, SWT.NONE);
		
		text_1 = new Combo(composite_2, SWT.NONE);
		GridData gd_text_1 = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_text_1.widthHint = 100;
		text_1.setLayoutData(gd_text_1);
		text_1.setText("");
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		
		Button btnIdentifier = toolkit.createButton(composite_2, "Identifier", SWT.RADIO);
		btnIdentifier.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		new Label(composite_2, SWT.NONE);
		
		text_2 = toolkit.createText(composite_2, "New Text", SWT.NONE);
		text_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		text_2.setText("");
		
		Hyperlink hprlnkSelectIdentifier = toolkit.createHyperlink(composite_2, "Select Identifier", SWT.NONE);
		toolkit.paintBordersFor(hprlnkSelectIdentifier);
		
		text_4 = toolkit.createText(composite_2, "New Text", SWT.NONE);
		text_4.setText("");
		GridData gd_text_4 = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_text_4.widthHint = 100;
		text_4.setLayoutData(gd_text_4);
		
		Button btnValue = toolkit.createButton(composite_2, "Metric Value", SWT.RADIO);
		btnValue.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		new Label(composite_2, SWT.NONE);
		
		text_3 = toolkit.createText(composite_2, "New Text", SWT.NONE);
		text_3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		text_3.setText("");
		
		Hyperlink hprlnkSelectMetric = toolkit.createHyperlink(composite_2, "Select Metric", SWT.NONE);
		toolkit.paintBordersFor(hprlnkSelectMetric);
		
		txtNewText_1 = toolkit.createText(composite_2, "New Text", SWT.NONE);
		txtNewText_1.setText("");
		txtNewText_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));

	}
}
