package com.netxforge.netxstudio.screens.f2;

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
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormText;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.ui.forms.widgets.Section;

public class Resource extends Composite {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Text txtNewText;
	private Text text;
	private Text text_1;
	private Text txtNewText_1;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public Resource(Composite parent, int style) {
		super(parent, SWT.BORDER);
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
		setLayout(new FillLayout(SWT.HORIZONTAL));

		Form frmFunction = toolkit.createForm(this);
		frmFunction.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmFunction);
		frmFunction.setText("Resource");
		frmFunction.getBody().setLayout(new FormLayout());

		FormText formText = toolkit
				.createFormText(frmFunction.getBody(), false);
		FormData fd_formText = new FormData();
		fd_formText.bottom = new FormAttachment(0, 46);
		fd_formText.right = new FormAttachment(100, -12);
		fd_formText.top = new FormAttachment(0, 12);
		fd_formText.left = new FormAttachment(0, 12);
		formText.setLayoutData(fd_formText);
		toolkit.paintBordersFor(formText);
		formText.setText(
				"<form><p> A resource is either created from a metric by the <b>M</b>etric <b>C</b>ollection <b>E</b>ngine or a resource is defined and calculated from an expression.  </p></form>",
				true, false);

		Section sctnInfo = toolkit.createSection(frmFunction.getBody(),
				Section.EXPANDED | Section.TITLE_BAR);
		FormData fd_sctnInfo = new FormData();
		fd_sctnInfo.top = new FormAttachment(formText, 15);
		fd_sctnInfo.bottom = new FormAttachment(100, -12);
		fd_sctnInfo.right = new FormAttachment(0, 370);
		fd_sctnInfo.left = new FormAttachment(0, 12);
		sctnInfo.setLayoutData(fd_sctnInfo);
		toolkit.paintBordersFor(sctnInfo);
		sctnInfo.setText("Info");

		Composite composite = toolkit.createComposite(sctnInfo, SWT.NONE);
		toolkit.paintBordersFor(composite);
		sctnInfo.setClient(composite);
		composite.setLayout(new GridLayout(2, false));
		
		Label lblShortName = toolkit.createLabel(composite, "Short Name:", SWT.NONE);
		lblShortName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		
		txtNewText = toolkit.createText(composite, "New Text", SWT.NONE);
		txtNewText.setText("");
		
		Label lblLongName = toolkit.createLabel(composite, "Long Name:", SWT.NONE);
		lblLongName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		
		text = toolkit.createText(composite, "New Text", SWT.NONE);
		text.setText(" ");
		GridData gd_text = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_text.widthHint = 200;
		text.setLayoutData(gd_text);
		
		Label lblNameInExpression = toolkit.createLabel(composite, "Name In Expression:", SWT.NONE);
		lblNameInExpression.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		
		text_1 = toolkit.createText(composite, "New Text", SWT.NONE);
		text_1.setText("");
		
		Label lblUnit = toolkit.createLabel(composite, "Unit:", SWT.NONE);
		lblUnit.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		
		txtNewText_1 = toolkit.createText(composite, "New Text", SWT.NONE);
		txtNewText_1.setText("");
		
		Section sctnContents = toolkit.createSection(frmFunction.getBody(), Section.EXPANDED | Section.TITLE_BAR);
		FormData fd_sctnContents = new FormData();
		fd_sctnContents.bottom = new FormAttachment(100, -12);
		fd_sctnContents.right = new FormAttachment(formText, 0, SWT.RIGHT);
		fd_sctnContents.top = new FormAttachment(sctnInfo, 0, SWT.TOP);
		fd_sctnContents.left = new FormAttachment(0, 380);
		sctnContents.setLayoutData(fd_sctnContents);
		toolkit.paintBordersFor(sctnContents);
		sctnContents.setText("Contents");
		
		Composite composite_2 = toolkit.createComposite(sctnContents, SWT.NONE);
		toolkit.paintBordersFor(composite_2);
		sctnContents.setClient(composite_2);
		composite_2.setLayout(new GridLayout(2, false));
		
		ImageHyperlink mghprlnkMetricRanges = toolkit.createImageHyperlink(composite_2, SWT.NONE);
		mghprlnkMetricRanges.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		toolkit.paintBordersFor(mghprlnkMetricRanges);
		mghprlnkMetricRanges.setText("Metric Ranges");
		
		Composite composite_3 = toolkit.createComposite(composite_2, SWT.NONE);
		GridData gd_composite_3 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_composite_3.widthHint = 14;
		gd_composite_3.heightHint = 14;
		composite_3.setLayoutData(gd_composite_3);
		toolkit.paintBordersFor(composite_3);
		
		Hyperlink hprlnkHourly = toolkit.createHyperlink(composite_2, "Hourly", SWT.NONE);
		toolkit.paintBordersFor(hprlnkHourly);

		new Label(composite_2, SWT.NONE);
		Hyperlink hprlnkDaily = toolkit.createHyperlink(composite_2, "Daily", SWT.NONE);
		toolkit.paintBordersFor(hprlnkDaily);
		
		new Label(composite_2, SWT.NONE);
		Hyperlink hprlnkWeekly = toolkit.createHyperlink(composite_2, "Weekly", SWT.NONE);
		toolkit.paintBordersFor(hprlnkWeekly);

		new Label(composite_2, SWT.NONE);
		Hyperlink hprlnkMonthly = toolkit.createHyperlink(composite_2, "Monthly", SWT.NONE);
		toolkit.paintBordersFor(hprlnkMonthly);
		
		Hyperlink hprlnkNewHyperlink = toolkit.createHyperlink(composite_2, "Capacity Range", SWT.NONE);
		hprlnkNewHyperlink.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		toolkit.paintBordersFor(hprlnkNewHyperlink);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
	}
}
