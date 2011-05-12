package com.netxforge.netxstudio.screens.nf4;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.databinding.IEMFValueProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.fieldassist.FieldDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.nebula.widgets.formattedtext.FormattedText;
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

import com.netxforge.netxstudio.data.IDataScreenInjection;
import com.netxforge.netxstudio.generics.GenericsPackage.Literals;
import com.netxforge.netxstudio.generics.Person;
import com.netxforge.netxstudio.screens.editing.IEditingService;
import com.netxforge.netxstudio.screens.selector.IScreenOperation;
import com.netxforge.netxstudio.screens.selector.Screens;

public class NewEditUser extends Composite implements IDataScreenInjection, IScreenOperation {

	// Databing object
	@SuppressWarnings("unused")
	private Binding loginBinding;
	@SuppressWarnings("unused")
	private DataBindingContext m_bindingContext;

	// Not injected as this service is already injected in the ViePart.
	private IEditingService editingService;

	private Person user;

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Text txtLogin;
	private Text txtFirstName;
	private Text txtLastName;
	private Text txtPass;
	private Text txtConfirm;
	private Text txtEmail;
	private Object owner;

	public NewEditUser(Composite parent, int style) {
		this(parent, style, null);
	}
	
	/**
	 * The type of operation expected from this screen. 
	 * Operatins can be either New or Edit. 
	 */
	private int operation;
	
	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public NewEditUser(Composite parent, int style, IEditingService eService) {
		super(parent, SWT.BORDER);
		
		operation = style & 0xFF00; // Ignore first bits, as we piggy back on the SWT style. 
		
		this.editingService = eService;
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

		String title =  Screens.isNewOperation(operation) ? "New" : "Edit";

		frmNewForm.setText(title + " User");
		frmNewForm.getBody().setLayout(new FormLayout());

		Composite composite = toolkit.createComposite(frmNewForm.getBody(),
				SWT.NONE);
		composite.setLayout(new FillLayout(SWT.HORIZONTAL));
		FormData fd_composite = new FormData();
		fd_composite.bottom = new FormAttachment(0, 16);
		fd_composite.right = new FormAttachment(100);
		fd_composite.top = new FormAttachment(0);
		fd_composite.left = new FormAttachment(0);
		composite.setLayoutData(fd_composite);
		toolkit.paintBordersFor(composite);

		Label lblNewLabel = toolkit.createLabel(composite,
				"Data Entry Feedback", SWT.NONE);
		lblNewLabel.setBackground(SWTResourceManager.getColor(154, 205, 50));
		lblNewLabel.setAlignment(SWT.CENTER);

		Section sctnInfo = toolkit.createSection(frmNewForm.getBody(),
				Section.EXPANDED | Section.TITLE_BAR);
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
		lblLogin.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));

		ControlDecoration controlDecoration_3 = new ControlDecoration(lblLogin,
				SWT.RIGHT | SWT.CENTER);
		controlDecoration_3.setDescriptionText("Some description");
		FieldDecoration fieldDecoration = FieldDecorationRegistry.getDefault()
				.getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);
		controlDecoration_3.setImage(fieldDecoration.getImage());

		txtLogin = toolkit.createText(composite_1, "New Text", SWT.NONE);
		txtLogin.setText("");
		GridData gd_txtLogin = new GridData(SWT.LEFT, SWT.CENTER, true, false,
				1, 1);
		gd_txtLogin.widthHint = 200;
		txtLogin.setLayoutData(gd_txtLogin);

		Label lblFirstName = toolkit.createLabel(composite_1, "First Name:",
				SWT.NONE);
		lblFirstName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));

		txtFirstName = toolkit.createText(composite_1, "New Text", SWT.NONE);
		GridData gd_txtFirstName = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_txtFirstName.widthHint = 200;
		txtFirstName.setLayoutData(gd_txtFirstName);
		txtFirstName.setText("");

		Label lblLastName = toolkit.createLabel(composite_1, "Last Name:",
				SWT.NONE);
		lblLastName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));

		txtLastName = toolkit.createText(composite_1, "New Text", SWT.NONE);
		txtLastName.setText("");
		GridData gd_txtLastName = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_txtLastName.widthHint = 200;
		txtLastName.setLayoutData(gd_txtLastName);

		Label lblEmail = toolkit.createLabel(composite_1, "Email:", SWT.NONE);
		lblEmail.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));

		FormattedText formattedText = new FormattedText(composite_1, SWT.BORDER);
		txtEmail = formattedText.getControl();
		GridData gd_txtEmail = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_txtEmail.widthHint = 200;
		txtEmail.setLayoutData(gd_txtEmail);

		Section sctnAuthentication = toolkit.createSection(
				frmNewForm.getBody(), Section.EXPANDED | Section.TITLE_BAR);
		FormData fd_sctnAuthentication = new FormData();
		fd_sctnAuthentication.bottom = new FormAttachment(0, 250);
		fd_sctnAuthentication.right = new FormAttachment(100, -12);
		fd_sctnAuthentication.top = new FormAttachment(sctnInfo);
		fd_sctnAuthentication.left = new FormAttachment(0, 12);
		sctnAuthentication.setLayoutData(fd_sctnAuthentication);
		toolkit.paintBordersFor(sctnAuthentication);
		sctnAuthentication.setText("Authentication");

		Composite composite_2 = toolkit.createComposite(sctnAuthentication,
				SWT.NONE);
		toolkit.paintBordersFor(composite_2);
		sctnAuthentication.setClient(composite_2);
		composite_2.setLayout(new GridLayout(2, false));

		Label lblPassword = toolkit.createLabel(composite_2, "Password:",
				SWT.NONE);
		lblPassword.setAlignment(SWT.RIGHT);
		lblPassword.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));

		txtPass = toolkit.createText(composite_2, "New Text", SWT.PASSWORD);
		GridData gd_txtPass = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_txtPass.widthHint = 200;
		txtPass.setLayoutData(gd_txtPass);
		txtPass.setText("");

		Label lblConfirm = toolkit.createLabel(composite_2, "Confirm:",
				SWT.NONE);
		lblConfirm.setAlignment(SWT.RIGHT);
		lblConfirm.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));

		txtConfirm = toolkit.createText(composite_2, "New Text", SWT.NONE);
		GridData gd_txtConfirm = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_txtConfirm.widthHint = 200;
		txtConfirm.setLayoutData(gd_txtConfirm);
		txtConfirm.setText("");

		Section sctnRoles = toolkit.createSection(frmNewForm.getBody(),
				Section.TITLE_BAR);
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

		Button btnAdministrator = toolkit.createButton(composite_3,
				"Administrator", SWT.CHECK);

		ControlDecoration controlDecoration = new ControlDecoration(
				btnAdministrator, SWT.LEFT | SWT.TOP);
		controlDecoration.setDescriptionText("Can perform all activities");

		Button btnCapacityPlanner = toolkit.createButton(composite_3,
				"Capacity Planner", SWT.CHECK);

		ControlDecoration controlDecoration_1 = new ControlDecoration(
				btnCapacityPlanner, SWT.LEFT | SWT.TOP);
		controlDecoration_1
				.setDescriptionText("Can perform most activities except the Admin tasts");

		Button btnViewer = toolkit.createButton(composite_3, "Viewer",
				SWT.CHECK);

		ControlDecoration controlDecoration_2 = new ControlDecoration(
				btnViewer, SWT.LEFT | SWT.TOP);
		controlDecoration_2
				.setDescriptionText("Has only View Access to activities");
	}

	protected DataBindingContext initDataBindings_() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue textObserveTextObserveWidget_1 = SWTObservables
				.observeDelayedValue(100,
						SWTObservables.observeText(txtLogin, SWT.Modify));

		IEMFValueProperty userLoginObserveValue_1 = EMFEditProperties.value(
				editingService.getEditingDomain(), Literals.PERSON__LOGIN);

		loginBinding = bindingContext.bindValue(textObserveTextObserveWidget_1,
				userLoginObserveValue_1.observe(user), null, null);

		IObservableValue txtFirstNameObserveTextObserveWidget = SWTObservables
				.observeDelayedValue(400,
						SWTObservables.observeText(txtFirstName, SWT.Modify));
		// IObservableValue userFirstNameObserveValue =
		// EMFObservables.observeValue(user, Literals.PERSON__FIRST_NAME);

		IEMFValueProperty userFirstNameObserveValue = EMFEditProperties.value(
				editingService.getEditingDomain(), Literals.PERSON__FIRST_NAME);

		bindingContext.bindValue(txtFirstNameObserveTextObserveWidget,
				userFirstNameObserveValue.observe(user), null, null);
		//
		IObservableValue txtLastNameObserveTextObserveWidget = SWTObservables
				.observeDelayedValue(400,
						SWTObservables.observeText(txtLastName, SWT.Modify));
		// IObservableValue userLastNameObserveValue = EMFObservables
		// .observeValue(user, Literals.PERSON__LAST_NAME);

		IEMFValueProperty userLastNameObserveValue = EMFEditProperties.value(
				editingService.getEditingDomain(), Literals.PERSON__LAST_NAME);

		bindingContext.bindValue(txtLastNameObserveTextObserveWidget,
				userLastNameObserveValue.observe(user), null, null);

		IObservableValue txtEmailObserveTextObserveWidget = SWTObservables
				.observeDelayedValue(400,
						SWTObservables.observeText(txtEmail, SWT.Modify));

		// IObservableValue userEmailObserveValue = EMFObservables.observeValue(
		// user, Literals.PERSON__EMAIL);

		IEMFValueProperty userEmailObserveValue = EMFEditProperties.value(
				editingService.getEditingDomain(), Literals.PERSON__EMAIL);

		bindingContext.bindValue(txtEmailObserveTextObserveWidget,
				userEmailObserveValue.observe(user), null, null);

		return bindingContext;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.data.IDataScreenInjection#injectData(org.eclipse
	 * .emf.ecore.EObject)
	 */
	@Override
	public void injectData(Object owner, Object object) {

		this.owner = owner;

		if (object != null && object instanceof Person) {
			user = (Person) object;
		}
		m_bindingContext = initDataBindings_();
	}

	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue textObserveTextObserveWidget_1 = SWTObservables
				.observeDelayedValue(100,
						SWTObservables.observeText(txtLogin, SWT.Modify));
		IObservableValue userLoginObserveValue_1 = EMFObservables.observeValue(
				user, Literals.PERSON__LOGIN);
		loginBinding = bindingContext.bindValue(textObserveTextObserveWidget_1,
				userLoginObserveValue_1, null, null);
		//
		IObservableValue txtFirstNameObserveTextObserveWidget = SWTObservables
				.observeDelayedValue(400,
						SWTObservables.observeText(txtFirstName, SWT.Modify));
		IObservableValue userFirstNameObserveValue = EMFObservables
				.observeValue(user, Literals.PERSON__FIRST_NAME);
		bindingContext.bindValue(txtFirstNameObserveTextObserveWidget,
				userFirstNameObserveValue, null, null);
		//
		IObservableValue txtLastNameObserveTextObserveWidget = SWTObservables
				.observeDelayedValue(400,
						SWTObservables.observeText(txtLastName, SWT.Modify));
		IObservableValue userLastNameObserveValue = EMFObservables
				.observeValue(user, Literals.PERSON__LAST_NAME);
		bindingContext.bindValue(txtLastNameObserveTextObserveWidget,
				userLastNameObserveValue, null, null);
		//
		IObservableValue txtEmailObserveTextObserveWidget = SWTObservables
				.observeDelayedValue(400,
						SWTObservables.observeText(txtEmail, SWT.Modify));
		IObservableValue userEmailObserveValue = EMFObservables.observeValue(
				user, Literals.PERSON__EMAIL);
		bindingContext.bindValue(txtEmailObserveTextObserveWidget,
				userEmailObserveValue, null, null);
		//
		return bindingContext;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.data.IDataScreenInjection#addData(java.lang.
	 * Object)
	 */
	@Override
	public void addData() {
		// Should not be called for an edit operation!
		if (Screens.isNewOperation(operation) && owner != null) {
			Command c = new AddCommand(editingService.getEditingDomain(),
					(EList<?>) owner, user);
			editingService.getEditingDomain().getCommandStack().execute(c);
		}else{
			// Databinding has done it's work. Don't need to do anything. 
		}
	}

	/* (non-Javadoc)
	 * @see com.netxforge.netxstudio.screens.selector.IScreenOperation#getOperation()
	 */
	@Override
	public int getOperation() {
		return this.operation;
	}
}
