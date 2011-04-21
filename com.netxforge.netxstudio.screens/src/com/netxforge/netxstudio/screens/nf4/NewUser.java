package com.netxforge.netxstudio.screens.nf4;

import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.fieldassist.FieldDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
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
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.nebula.widgets.formattedtext.FormattedText;

public class NewUser extends Composite {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Text text;
	private Text txtNewText;
	private Text txtNewText_1;
	private Text text_2;
	private Text text_3;
	private Text text_1;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public NewUser(Composite parent, int style) {
		super(parent, SWT.BORDER);
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
		frmNewForm.setText("New User");
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
		
		Section sctnInfo = toolkit.createSection(frmNewForm.getBody(), Section.EXPANDED | Section.TITLE_BAR);
		FormData fd_sctnInfo = new FormData();
		fd_sctnInfo.top = new FormAttachment(composite, 12);
		fd_sctnInfo.bottom = new FormAttachment(0, 165);
		fd_sctnInfo.right = new FormAttachment(100, -12);
		fd_sctnInfo.left = new FormAttachment(0, 12);
		sctnInfo.setLayoutData(fd_sctnInfo);
		toolkit.paintBordersFor(sctnInfo);
		sctnInfo.setText("Info");
		
		Composite composite_1 = toolkit.createComposite(sctnInfo, SWT.NONE);
		toolkit.paintBordersFor(composite_1);
		sctnInfo.setClient(composite_1);
		GridLayout gl_composite_1 = new GridLayout(2, false);
		gl_composite_1.horizontalSpacing = 8;
		composite_1.setLayout(gl_composite_1);
		
		Label lblLogin = toolkit.createLabel(composite_1, "Login:", SWT.NONE);
		lblLogin.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		
		ControlDecoration controlDecoration_3 = new ControlDecoration(lblLogin, SWT.RIGHT | SWT.CENTER);
		controlDecoration_3.setDescriptionText("Some description");
		FieldDecoration fieldDecoration = FieldDecorationRegistry.getDefault()
				.getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
		controlDecoration_3.setImage(fieldDecoration.getImage());
		
		
		text = toolkit.createText(composite_1, "New Text", SWT.NONE);
		text.setText("");
		GridData gd_text = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
		gd_text.widthHint = 200;
		text.setLayoutData(gd_text);
		
		Label lblFirstName = toolkit.createLabel(composite_1, "First Name:", SWT.NONE);
		lblFirstName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		
		txtNewText = toolkit.createText(composite_1, "New Text", SWT.NONE);
		GridData gd_txtNewText = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_txtNewText.widthHint = 200;
		txtNewText.setLayoutData(gd_txtNewText);
		txtNewText.setText("");
		
		Label lblLastName = toolkit.createLabel(composite_1, "Last Name:", SWT.NONE);
		lblLastName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		
		txtNewText_1 = toolkit.createText(composite_1, "New Text", SWT.NONE);
		txtNewText_1.setText("");
		GridData gd_txtNewText_1 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_txtNewText_1.widthHint = 200;
		txtNewText_1.setLayoutData(gd_txtNewText_1);
		
		Label lblEmail = toolkit.createLabel(composite_1, "Email:", SWT.NONE);
		lblEmail.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		
		FormattedText formattedText = new FormattedText(composite_1, SWT.BORDER);
		text_1 = formattedText.getControl();
		GridData gd_text_1 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_text_1.widthHint = 200;
		text_1.setLayoutData(gd_text_1);
		
		Section sctnAuthentication = toolkit.createSection(frmNewForm.getBody(), Section.EXPANDED | Section.TITLE_BAR);
		FormData fd_sctnAuthentication = new FormData();
		fd_sctnAuthentication.bottom = new FormAttachment(0, 250);
		fd_sctnAuthentication.right = new FormAttachment(100, -12);
		fd_sctnAuthentication.top = new FormAttachment(sctnInfo);
		fd_sctnAuthentication.left = new FormAttachment(0, 12);
		sctnAuthentication.setLayoutData(fd_sctnAuthentication);
		toolkit.paintBordersFor(sctnAuthentication);
		sctnAuthentication.setText("Authentication");
		
		Composite composite_2 = toolkit.createComposite(sctnAuthentication, SWT.NONE);
		toolkit.paintBordersFor(composite_2);
		sctnAuthentication.setClient(composite_2);
		composite_2.setLayout(new GridLayout(2, false));
		
		Label lblPassword = toolkit.createLabel(composite_2, "Password:", SWT.NONE);
		lblPassword.setAlignment(SWT.RIGHT);
		lblPassword.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		
		text_2 = toolkit.createText(composite_2, "New Text", SWT.PASSWORD);
		GridData gd_text_2 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_text_2.widthHint = 200;
		text_2.setLayoutData(gd_text_2);
		text_2.setText("");
		
		Label lblConfirm = toolkit.createLabel(composite_2, "Confirm:", SWT.NONE);
		lblConfirm.setAlignment(SWT.RIGHT);
		lblConfirm.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		
		text_3 = toolkit.createText(composite_2, "New Text", SWT.NONE);
		GridData gd_text_3 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_text_3.widthHint = 200;
		text_3.setLayoutData(gd_text_3);
		text_3.setText("");
		
		Section sctnRoles = toolkit.createSection(frmNewForm.getBody(), Section.TITLE_BAR);
		FormData fd_sctnRoles = new FormData();
		fd_sctnRoles.bottom = new FormAttachment(100, -12);
		fd_sctnRoles.top = new FormAttachment(sctnAuthentication, 12);
		fd_sctnRoles.right = new FormAttachment(100, -12);
		fd_sctnRoles.left = new FormAttachment(sctnAuthentication, 0, SWT.LEFT);
		sctnRoles.setLayoutData(fd_sctnRoles);
		toolkit.paintBordersFor(sctnRoles);
		sctnRoles.setText("Roles");
		
		Composite composite_3 = toolkit.createComposite(sctnRoles, SWT.NONE);
		toolkit.paintBordersFor(composite_3);
		sctnRoles.setClient(composite_3);
		composite_3.setLayout(new GridLayout(1, false));
		
		Button btnAdministrator = toolkit.createButton(composite_3, "Administrator", SWT.CHECK);
		
		ControlDecoration controlDecoration = new ControlDecoration(btnAdministrator, SWT.LEFT | SWT.TOP);
		controlDecoration.setDescriptionText("Can perform all activities");
		
		Button btnCapacityPlanner = toolkit.createButton(composite_3, "Capacity Planner", SWT.CHECK);
		
		ControlDecoration controlDecoration_1 = new ControlDecoration(btnCapacityPlanner, SWT.LEFT | SWT.TOP);
		controlDecoration_1.setDescriptionText("Can perform most activities except the Admin tasts");
		
		Button btnViewer = toolkit.createButton(composite_3, "Viewer", SWT.CHECK);
		
		ControlDecoration controlDecoration_2 = new ControlDecoration(btnViewer, SWT.LEFT | SWT.TOP);
		controlDecoration_2.setDescriptionText("Has only View Access to activities");
		
	}
}
