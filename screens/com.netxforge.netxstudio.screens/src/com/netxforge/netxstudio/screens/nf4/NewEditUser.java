/*******************************************************************************
 * Copyright (c) 11 dec. 2012 NetXForge.
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details. You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors: Christophe Bouhier - initial API and implementation and/or
 * initial documentation
 *******************************************************************************/
package com.netxforge.netxstudio.screens.nf4;

import java.util.List;

import org.eclipse.core.databinding.conversion.Converter;
import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.databinding.EMFUpdateValueStrategy;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.databinding.IEMFValueProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.jface.databinding.swt.ISWTObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.nebula.widgets.formattedtext.FormattedText;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

import com.google.common.collect.Lists;
import com.netxforge.base.security.JCAService;
import com.netxforge.netxstudio.common.CommonService;
import com.netxforge.netxstudio.generics.GenericsPackage;
import com.netxforge.netxstudio.generics.GenericsPackage.Literals;
import com.netxforge.netxstudio.generics.Person;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.editing.IDataScreenInjection;
import com.netxforge.netxstudio.screens.editing.ScreenUtil;
import com.netxforge.netxstudio.screens.editing.util.ValidationService;
import com.netxforge.netxstudio.screens.internal.ScreensActivator;

/**
 * 
 * @author Christophe Bouhier
 */
public class NewEditUser extends AbstractScreen implements IDataScreenInjection {

	@SuppressWarnings("unused")
	private EMFDataBindingContext m_bindingContext;

	CommonService commonService = new CommonService(new JCAService());

	/**
	 * A new or copy of a object to edit.
	 */
	private Person user;

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Text txtLogin;
	private Text txtFirstName;
	private Text txtLastName;
	private Text txtPass;
	private Text txtConfirm;
	private Text txtEmail;
	private Resource owner;

	private ComboViewer comboViewer;
	private Combo combo;
	private Button btnCheck;
	private Form frmNewEditUser;

	private Resource rolesResource;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public NewEditUser(Composite parent, int style) {
		super(parent, style);

		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				validationService.dispose();
				validationService.removeValidationListener(NewEditUser.this);
				toolkit.dispose();

			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);

	}

	private void buildUI() {
		setLayout(new FillLayout(SWT.HORIZONTAL));

		frmNewEditUser = toolkit.createForm(this);
		frmNewEditUser.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmNewEditUser);

		String title = ScreenUtil.isNewOperation(getOperation()) ? "New: "
				: "Edit: ";

		frmNewEditUser.setText(title + "User");
		frmNewEditUser.addMessageHyperlinkListener(new HyperlinkAdapter());
		frmNewEditUser.getBody().setLayout(new FormLayout());

		Section sctnInfo = toolkit.createSection(frmNewEditUser.getBody(),
				Section.EXPANDED | Section.TITLE_BAR);
		FormData fd_sctnInfo = new FormData();
		fd_sctnInfo.top = new FormAttachment(0, 12);
		fd_sctnInfo.bottom = new FormAttachment(0, 169);
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
		lblLogin.setAlignment(SWT.RIGHT);
		GridData gd_lblLogin = new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblLogin.widthHint = 70;
		lblLogin.setLayoutData(gd_lblLogin);

		txtLogin = toolkit.createText(composite_1, "New Text", SWT.NONE);
		txtLogin.setText("");
		GridData gd_txtLogin = new GridData(SWT.LEFT, SWT.CENTER, true, false,
				1, 1);
		gd_txtLogin.widthHint = 200;
		txtLogin.setLayoutData(gd_txtLogin);

		Label lblFirstName = toolkit.createLabel(composite_1, "First Name:",
				SWT.NONE);
		lblFirstName.setAlignment(SWT.RIGHT);
		GridData gd_lblFirstName = new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblFirstName.widthHint = 70;
		lblFirstName.setLayoutData(gd_lblFirstName);

		txtFirstName = toolkit.createText(composite_1, "New Text", SWT.NONE);
		GridData gd_txtFirstName = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_txtFirstName.widthHint = 200;
		txtFirstName.setLayoutData(gd_txtFirstName);
		txtFirstName.setText("");

		Label lblLastName = toolkit.createLabel(composite_1, "Last Name:",
				SWT.NONE);
		lblLastName.setAlignment(SWT.RIGHT);
		GridData gd_lblLastName = new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblLastName.widthHint = 70;
		lblLastName.setLayoutData(gd_lblLastName);

		txtLastName = toolkit.createText(composite_1, "New Text", SWT.NONE);
		txtLastName.setText("");
		GridData gd_txtLastName = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_txtLastName.widthHint = 200;
		txtLastName.setLayoutData(gd_txtLastName);

		Label lblEmail = toolkit.createLabel(composite_1, "Email:", SWT.NONE);
		lblEmail.setAlignment(SWT.RIGHT);
		GridData gd_lblEmail = new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblEmail.widthHint = 70;
		lblEmail.setLayoutData(gd_lblEmail);

		FormattedText formattedText = new FormattedText(composite_1, SWT.BORDER
				| SWT.NONE);
		txtEmail = formattedText.getControl();
		GridData gd_txtEmail = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_txtEmail.widthHint = 200;
		txtEmail.setLayoutData(gd_txtEmail);
		new Label(composite_1, SWT.NONE);

		btnCheck = toolkit.createButton(composite_1, "Active?", SWT.CHECK);

		// The Authentication section, in edit mode should ask to reset the
		// password,
		// as the set password will not be shown.

		Section sctnAuthentication = toolkit.createSection(
				frmNewEditUser.getBody(), Section.EXPANDED | Section.TREE_NODE
						| Section.TITLE_BAR);
		FormData fd_sctnAuthentication = new FormData();
		fd_sctnAuthentication.top = new FormAttachment(sctnInfo, 12);
		fd_sctnAuthentication.right = new FormAttachment(100, -12);
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
		GridData gd_lblPassword = new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblPassword.widthHint = 70;
		lblPassword.setLayoutData(gd_lblPassword);

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

		txtConfirm = toolkit.createText(composite_2, "New Text", SWT.PASSWORD);
		GridData gd_txtConfirm = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_txtConfirm.widthHint = 200;
		txtConfirm.setLayoutData(gd_txtConfirm);
		txtConfirm.setText("");

		Section sctnRoles = toolkit.createSection(frmNewEditUser.getBody(),
				Section.TITLE_BAR);
		fd_sctnAuthentication.bottom = new FormAttachment(sctnRoles, -12);
		FormData fd_sctnRoles = new FormData();
		fd_sctnRoles.top = new FormAttachment(0, 280);
		fd_sctnRoles.bottom = new FormAttachment(100, -12);
		fd_sctnRoles.right = new FormAttachment(100, -12);
		fd_sctnRoles.left = new FormAttachment(sctnAuthentication, 0, SWT.LEFT);
		sctnRoles.setLayoutData(fd_sctnRoles);
		toolkit.paintBordersFor(sctnRoles);
		sctnRoles.setText("Role");

		Composite composite_3 = toolkit.createComposite(sctnRoles, SWT.NONE);
		toolkit.paintBordersFor(composite_3);
		sctnRoles.setClient(composite_3);
		composite_3.setLayout(new GridLayout(2, false));

		Label lblRole = toolkit.createLabel(composite_3, "Role:", SWT.NONE);
		lblRole.setAlignment(SWT.RIGHT);
		GridData gd_lblRole = new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1);
		gd_lblRole.widthHint = 70;
		lblRole.setLayoutData(gd_lblRole);

		comboViewer = new ComboViewer(composite_3, SWT.READ_ONLY);
		combo = comboViewer.getCombo();
		GridData gd_combo = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1,
				1);
		gd_combo.widthHint = 200;
		combo.setLayoutData(gd_combo);
		toolkit.paintBordersFor(combo);

		// Register decorators for each control.
		// CB Decoration is done automatically by the Message Manager.
		// validationService.registerAllDecorators(txtLogin, lblLogin);
		// validationService.registerAllDecorators(txtFirstName, lblFirstName);
		// validationService.registerAllDecorators(txtLastName, lblLastName);
		// validationService.registerAllDecorators(txtEmail, lblEmail);
		// validationService.registerAllDecorators(btnCheck, btnCheck);
		// validationService.registerAllDecorators(txtPass, lblPassword);
		// validationService.registerAllDecorators(txtConfirm, lblConfirm);
		// validationService.registerAllDecorators(combo, lblRole);
	}

	protected void handleRoleSelection(SelectionEvent e) {

	}

	/**
	 * Converted to new EMF API.
	 * 
	 * @return
	 */
	public EMFDataBindingContext initDataBindings_() {

		EMFDataBindingContext bindingContext = new EMFDataBindingContext();
		validationService.registerBindingContext(bindingContext);

		// Validation Strategies
		EMFUpdateValueStrategy loginStrategy = ValidationService
				.getStrategyfactory().strategyBeforeSetStringNotEmpty(
						"Login is required");

		EMFUpdateValueStrategy firstNameStrategy = ValidationService
				.getStrategyfactory().strategyBeforeSetStringNotEmpty(
						"First name is required");

		EMFUpdateValueStrategy lastNameStrategy = ValidationService
				.getStrategyfactory().strategyBeforeSetStringNotEmpty(
						"Last name is required");

		EMFUpdateValueStrategy emailNameStrategy = ValidationService
				.getStrategyfactory().strategyBeforeSetStringNotEmpty(
						"Email is required");

		// The active strategy is merely a warning.
		EMFUpdateValueStrategy activeStrategy = ValidationService
				.getStrategyfactory().strategyAfterGet(new IValidator() {

					public IStatus validate(Object value) {
						if (value instanceof Boolean) {
							if (!((Boolean) value).booleanValue()) {
								// Not active, issue warning.
								return new Status(IStatus.WARNING,
										ScreensActivator.PLUGIN_ID,
										"Person not active, are you sure");
							} else {
								return Status.OK_STATUS;
							}
						} else {
							return new Status(IStatus.ERROR,
									ScreensActivator.PLUGIN_ID,
									"Should and will not occure");
						}
					}

				});

		EMFUpdateValueStrategy roleStrategy = ValidationService
				.getStrategyfactory().strategyAfterGet(new IValidator() {
					public IStatus validate(Object value) {
						if (value == null) {
							return new Status(IStatus.WARNING,
									ScreensActivator.PLUGIN_ID,
									"A role should be selected");
						} else {
							// Any other value should do.
							return Status.OK_STATUS;
						}

					}
				});

		// Bindings

		IObservableValue textObserveTextObserveWidget_1 = SWTObservables
				.observeDelayedValue(100,
						SWTObservables.observeText(txtLogin, SWT.Modify));

		IEMFValueProperty userLoginObserveValue_1 = EMFEditProperties.value(
				editingService.getEditingDomain(), Literals.PERSON__LOGIN);

		bindingContext.bindValue(textObserveTextObserveWidget_1,
				userLoginObserveValue_1.observe(user), loginStrategy, null);

		IObservableValue txtFirstNameObserveTextObserveWidget = SWTObservables
				.observeDelayedValue(400,
						SWTObservables.observeText(txtFirstName, SWT.Modify));
		// IObservableValue userFirstNameObserveValue =
		// EMFObservables.observeValue(user, Literals.PERSON__FIRST_NAME);

		IEMFValueProperty userFirstNameObserveValue = EMFEditProperties.value(
				editingService.getEditingDomain(), Literals.PERSON__FIRST_NAME);

		bindingContext.bindValue(txtFirstNameObserveTextObserveWidget,
				userFirstNameObserveValue.observe(user), firstNameStrategy,
				null);
		IObservableValue txtLastNameObserveTextObserveWidget = SWTObservables
				.observeDelayedValue(400,
						SWTObservables.observeText(txtLastName, SWT.Modify));
		// IObservableValue userLastNameObserveValue = EMFObservables
		// .observeValue(user, Literals.PERSON__LAST_NAME);

		IEMFValueProperty userLastNameObserveValue = EMFEditProperties.value(
				editingService.getEditingDomain(), Literals.PERSON__LAST_NAME);

		bindingContext.bindValue(txtLastNameObserveTextObserveWidget,
				userLastNameObserveValue.observe(user), lastNameStrategy, null);

		IObservableValue txtEmailObserveTextObserveWidget = SWTObservables
				.observeDelayedValue(400,
						SWTObservables.observeText(txtEmail, SWT.Modify));

		// IObservableValue userEmailObserveValue = EMFObservables.observeValue(
		// user, Literals.PERSON__EMAIL);

		IEMFValueProperty userEmailObserveValue = EMFEditProperties.value(
				editingService.getEditingDomain(), Literals.PERSON__EMAIL);

		bindingContext.bindValue(txtEmailObserveTextObserveWidget,
				userEmailObserveValue.observe(user), emailNameStrategy, null);

		IObservableValue btnCheckObserveSelectionObserveWidget = SWTObservables
				.observeSelection(btnCheck);
		IEMFValueProperty userActiveObserveValue = EMFEditProperties.value(
				editingService.getEditingDomain(), Literals.PERSON__ACTIVE);
		bindingContext.bindValue(btnCheckObserveSelectionObserveWidget,
				userActiveObserveValue.observe(user), activeStrategy, null);

		IObservableValue passwordObservableValue = new WritableValue();

		IObservableValue txtPasswordObserveTextObserveWidget = SWTObservables
				.observeDelayedValue(400,
						SWTObservables.observeText(txtPass, SWT.Modify));
		IObservableValue txtConfirmObserveTextObserveWidget = SWTObservables
				.observeDelayedValue(400,
						SWTObservables.observeText(txtConfirm, SWT.Modify));

		// NEW CODE, Use a custom MultiValidator, it produces

		NewPasswordConfirmed newPasswordConfirmed = new NewPasswordConfirmed(
				bindingContext, new IObservableValue[] {
						txtPasswordObserveTextObserveWidget,
						txtConfirmObserveTextObserveWidget });

		passwordObservableValue = newPasswordConfirmed
				.observeValidatedValue(newPasswordConfirmed.getMiddletons()
						.get(0));
		
		// OLD CODE.
		// Special writable case for password and confirmation,
		// both share the value changed listener, which only sets the model.
		// when both passwords are the same. 2 x widgets -> model

		// PasswordConfirmed confirmedHandler = new PasswordConfirmed(
		// passwordObservableValue);

		// txtPasswordObserveTextObserveWidget
		// .addValueChangeListener(confirmedHandler);

		// txtConfirmObserveTextObserveWidget
		// .addValueChangeListener(confirmedHandler);

		// EMFUpdateValueStrategy passStrategy = ValidationService
		// .getStrategyfactory().strategyAfterGet(confirmedHandler);

		EMFUpdateValueStrategy passStrategy = new EMFUpdateValueStrategy();
		passStrategy.setConverter(new PasswordConverter());

		IEMFValueProperty passwordObserveValue = EMFEditProperties.value(
				editingService.getEditingDomain(), Literals.PERSON__PASSWORD);

		// Password, can not be presented (Ok it can but we don't want to), so only target to model.
		bindingContext.bindValue(passwordObservableValue,
				passwordObserveValue.observe(user), passStrategy, null);
		
		newPasswordConfirmed.revalidateExternal();
		
		// Hand coded binding for a combo.

		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		this.getComboViewerWidget().setContentProvider(listContentProvider);

		IObservableMap observeMap = EMFObservables.observeMap(
				listContentProvider.getKnownElements(), Literals.ROLE__NAME);
		this.getComboViewerWidget().setLabelProvider(
				new ObservableMapLabelProvider(observeMap));

		rolesResource = editingService.getData(GenericsPackage.Literals.ROLE);
		IEMFListProperty l = EMFEditProperties.resource(editingService
				.getEditingDomain());
		IObservableList rolesObservableList = l.observe(rolesResource);

		// obm.addObservable(rolesObservableList);

		this.getComboViewerWidget().setInput(rolesObservableList);

		IObservableValue comboObserveProxy = ViewerProperties.singleSelection()
				.observe(comboViewer);

		IEMFValueProperty roleObserveValue = EMFEditProperties.value(
				editingService.getEditingDomain(), Literals.PERSON__ROLES);

		bindingContext.bindValue(comboObserveProxy,
				roleObserveValue.observe(user), roleStrategy, null);

		return bindingContext;
	}

	private class PasswordConverter extends Converter {

		/**
		 * @param fromType
		 * @param toType
		 */
		public PasswordConverter() {
			super(String.class, String.class);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.core.databinding.conversion.IConverter#convert(java.lang
		 * .Object)
		 */
		public Object convert(Object fromObject) {

			if (fromObject instanceof String) {
				// Return a digest using the commons services.
				String toObject = commonService.getJcasService().digest(
						(String) fromObject);
				return toObject;
			}
			return fromObject;
		}
	}

	/**
	 * Produces Middleton WritableValues for the provided targets, binds them
	 * together and adds to the context.
	 * 
	 * @author Christophe
	 * 
	 */
	private class NewPasswordConfirmed extends
			ValidationService.ValidationWithTargetStatusProvider {

		private EMFDataBindingContext ctx;

		private List<IObservableValue> middletons = Lists.newArrayList();

		@SuppressWarnings("unused")
		public NewPasswordConfirmed(IObservableValue... targets) {
			this(null, targets);
		}

		public NewPasswordConfirmed(EMFDataBindingContext ctx,
				IObservableValue... targets) {
			super(targets);
			this.ctx = ctx;

			if (this.ctx != null) {
				for (IObservable iObservable : targets) {
					IObservableValue writableValue = new WritableValue();
					middletons.add(writableValue);
					this.ctx.bindValue((IObservableValue) iObservable,
							writableValue);
				}
			}
			ctx.addValidationStatusProvider(this);
		}

		public List<IObservableValue> getMiddletons() {
			return middletons;
		}

		@Override
		protected IStatus validate() {
			// Works for 2 middletons only!
			if (middletons.size() == 2) {
				String first = (String) middletons.get(0).getValue();
				String second = (String) middletons.get(1).getValue();

				if (!checkNotSet(first, second)) {
					if (!checkEmpty(first, second)) {
						if (checkPassConfirmed(first, second)) {
							return Status.OK_STATUS;
						} else {
							return new Status(IStatus.ERROR,
									ScreensActivator.PLUGIN_ID,
									"Password should be equal");

						}
					} else {
						return new Status(IStatus.INFO,
								ScreensActivator.PLUGIN_ID,
								"Enter a new password to (re)set");
					}
				} else {
					return new Status(IStatus.INFO, ScreensActivator.PLUGIN_ID,
							"Enter a new password to (re)set");
				}
			} else {
				return new Status(IStatus.ERROR, ScreensActivator.PLUGIN_ID,
						"Programming error");
			}
		}

		/*
		 * Password is confirmed when both the pass and the confirm are set,
		 * non-empty and equal.
		 */
		private boolean checkPassConfirmed(String v1, String v2) {
			return (v1 != null) && (v2 != null) && !v1.isEmpty()
					&& !v2.isEmpty() && v1.equals(v2);
		}

		/*
		 * Set when one of the
		 */
		private boolean checkNotSet(String v1, String v2) {
			return (v1 == null) && (v2 == null);
		}

		private boolean checkEmpty(String v1, String v2) {
			return (v1 != null) && (v2 != null)
					&& (v1.isEmpty() && v2.isEmpty());
		}

	}

	/**
	 * Combines the password and confirm value into a single update. Acts as a
	 * validator to make sure both password are the same.
	 * 
	 * @author Christophe Bouhier christophe.bouhier@netxforge.com
	 * 
	 */
	@SuppressWarnings("unused")
	private class PasswordConfirmed implements IValueChangeListener, IValidator {

		private String pass;
		private String confirm;
		private IObservableValue toObserve;

		PasswordConfirmed(IObservableValue obsv) {
			this.toObserve = obsv;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.core.databinding.observable.value.IValueChangeListener
		 * #handleValueChange
		 * (org.eclipse.core.databinding.observable.value.ValueChangeEvent)
		 */
		public void handleValueChange(ValueChangeEvent event) {
			Object newValue = event.diff.getNewValue();

			// As we use one single observable, we need to clear it first,
			// otherwise equality will prevent it from being set by the binding,
			// so it will not be validated.
			// At the end, the

			if (event.getObservable() instanceof ISWTObservableValue) {
				Control control = (Control) ((ISWTObservableValue) event
						.getObservable()).getWidget();
				if (control.equals(txtPass)) {
					pass = (String) newValue;
					toObserve.setValue("");
					toObserve.setValue(pass);
				}
				if (control.equals(txtConfirm)) {
					confirm = (String) newValue;
					toObserve.setValue("");
					toObserve.setValue(confirm);
				}
			}
		}

		/*
		 * Password is confirmed when both the pass and the confirm are set,
		 * non-empty and equal.
		 */
		private boolean checkPassConfirmed() {
			return (pass != null) && (confirm != null) && !pass.isEmpty()
					&& !confirm.isEmpty() && pass.equals(confirm);
		}

		/*
		 * Set when one of the
		 */
		private boolean checkNotSet() {
			return (pass == null) && (confirm == null);
		}

		private boolean checkEmpty() {
			return (pass != null) && (confirm != null)
					&& (pass.isEmpty() && confirm.isEmpty());
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.core.databinding.validation.IValidator#validate(java.
		 * lang.Object)
		 */
		public IStatus validate(Object value) {

			System.out.println(" validate + " + value + "pass: " + pass
					+ " confirm: " + confirm);

			// Should we care about the value, we use the observable.
			if (!checkNotSet()) {
				if (!checkEmpty()) {
					if (checkPassConfirmed()) {
						return Status.OK_STATUS;
					} else {
						return new Status(IStatus.ERROR,
								ScreensActivator.PLUGIN_ID,
								"Password should be equal");

					}
				} else {
					return new Status(IStatus.INFO, ScreensActivator.PLUGIN_ID,
							"Enter a new password to (re)set");
				}
			} else {
				return new Status(IStatus.INFO, ScreensActivator.PLUGIN_ID,
						"Enter a new password to (re)set");
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.data.IDataScreenInjection#injectData(org.eclipse
	 * .emf.ecore.EObject)
	 */
	public void injectData(Object owner, Object object) {

		if (owner instanceof Resource) {
			this.owner = (Resource) owner;
		} else {
			// We need the right type of object for this screen.
			throw new java.lang.IllegalArgumentException();
		}
		if (object != null && object instanceof Person) {
			user = (Person) object;
		} else {
			// We need the right type of object for this screen.
			throw new java.lang.IllegalArgumentException();
		}

		buildUI();
		if (!ScreenUtil.isReadOnlyOperation(getOperation())) {
			validationService.addValidationListener(this);

		}
		m_bindingContext = initDataBindings_();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.netxforge.netxstudio.data.IDataScreenInjection#addData(java.lang.
	 * Object)
	 */
	public void addData() {
		if (ScreenUtil.isNewOperation(getOperation()) && owner != null) {
			// If new, we have been operating on an object not added yet.
			Command c = new AddCommand(editingService.getEditingDomain(),
					owner.getContents(), user);
			editingService.getEditingDomain().getCommandStack().execute(c);
		} else if (ScreenUtil.isEditOperation(getOperation())) {
			// If edit, we have been operating on a copy of the object, so we
			// have to replace. However if our original object is invalid, this
			// will
			// cause invalidity, so the action will not occure in case the
			// original is
			// invalid, and we should cancel the action and warn the user.
			if (user.cdoInvalid()) {
				MessageDialog
						.openWarning(Display.getDefault().getActiveShell(),
								"Conflict",
								"There is a conflict with another user. Your changes can't be saved.");
				return;
			}
			System.out.println(user.cdoID() + "" + user.cdoState());

		}
		// After our edit, we shall be dirty
		if (editingService.isDirty()) {
			editingService.doSave(new NullProgressMonitor());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.common.ui.viewer.IViewerProvider#getViewer()
	 */
	public Viewer getViewer() {
		return null;
	}

	public ComboViewer getComboViewerWidget() {
		return comboViewer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.screens.editing.selector.IScreen#isValid()
	 */
	public boolean isValid() {
		return validationService.isValid();
	}

	public Form getScreenForm() {
		return this.frmNewEditUser;
	}

	public String getScreenName() {
		return "User";
	}

}
