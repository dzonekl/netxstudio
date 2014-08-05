package com.netxforge.netxstudio.screens.xtext;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

public class EmbeddedXtext extends Composite {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public EmbeddedXtext(Composite parent, int style) {
		super(parent, SWT.BORDER);
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
		setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Form frmEditExpression = toolkit.createForm(this);
		frmEditExpression.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmEditExpression);
		frmEditExpression.setText("New/Update Expression");
		frmEditExpression.getBody().setLayout(new FormLayout());
		
		Section sctnNewSection = toolkit.createSection(frmEditExpression.getBody(), Section.EXPANDED | Section.TITLE_BAR);
		FormData fd_sctnNewSection = new FormData();
		fd_sctnNewSection.bottom = new FormAttachment(100, -12);
		fd_sctnNewSection.right = new FormAttachment(100, -12);
		fd_sctnNewSection.top = new FormAttachment(0, 12);
		fd_sctnNewSection.left = new FormAttachment(0, 12);
		sctnNewSection.setLayoutData(fd_sctnNewSection);
		toolkit.paintBordersFor(sctnNewSection);
		sctnNewSection.setText("Expression");
		sctnNewSection.setExpanded(true);
		
		Composite composite = toolkit.createComposite(sctnNewSection, SWT.NONE);
		toolkit.paintBordersFor(composite);
		sctnNewSection.setClient(composite);
		composite.setLayout(new GridLayout(1, false));

	}
}
