package com.netxforge.netxstudio.screens.f3;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.IEMFValueProperty;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.Viewer;
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
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

import com.netxforge.netxstudio.generics.GenericsPackage;
import com.netxforge.netxstudio.operators.Operator;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.editing.selector.IDataScreenInjection;
import com.netxforge.netxstudio.screens.editing.selector.ScreenUtil;

public class NewEditOperator extends AbstractScreen implements
		IDataScreenInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Text txtName;
	private Form frmNewOperator;
	private Resource owner;
	private Operator operator;
	@SuppressWarnings("unused")
	private EMFDataBindingContext m_bindingContext;
	private Text txtShortName;
	private Text txtWebsite;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public NewEditOperator(Composite parent, int style) {
		super(parent, style);
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
	}

	public EMFDataBindingContext initDataBindings_() {
		EMFDataBindingContext context = new EMFDataBindingContext();
		
		IObservableValue nameObservable = SWTObservables.observeDelayedValue(400, SWTObservables.observeText(txtName,
				SWT.Modify));
		IObservableValue shortNameObservable = SWTObservables.observeDelayedValue(400, SWTObservables.observeText(txtShortName,
				SWT.Modify));
		IObservableValue websiteObservable = SWTObservables.observeDelayedValue(400, SWTObservables.observeText(txtWebsite,
				SWT.Modify));
		

		IEMFValueProperty nameProperty = EMFProperties
				.value(GenericsPackage.Literals.COMPANY__NAME);
		IEMFValueProperty shortNameProperty = EMFProperties
				.value(GenericsPackage.Literals.COMPANY__SHORT_NAME);
		IEMFValueProperty websiteProperty = EMFProperties
				.value(GenericsPackage.Literals.COMPANY__WEBSITE);
		
		context.bindValue(nameObservable, nameProperty.observe(operator),
				null, null);
		context.bindValue(shortNameObservable, shortNameProperty.observe(operator),
				null, null);
		context.bindValue(websiteObservable, websiteProperty.observe(operator),
				null, null);
		
		return context;
	}

	public void injectData(Object owner, Object object) {
		if (owner instanceof Resource) {
			this.owner = (Resource) owner;
		} else {
			// We need the right type of object for this screen.
			throw new java.lang.IllegalArgumentException();
		}
		if (object != null && object instanceof Operator) {
			operator = (Operator) object;
		} else {
			// We need the right type of object for this screen.
			throw new java.lang.IllegalArgumentException();
		}
		buildUI();
		m_bindingContext = initDataBindings_();
	}

	
	private void buildUI() {
		setLayout(new FillLayout(SWT.HORIZONTAL));

		// Readonlyness.
		boolean readonly = ScreenUtil.isReadOnlyOperation(this.getOperation());
		String actionText = readonly ? "View: " : "Edit: ";
		int widgetStyle = readonly ? SWT.READ_ONLY : SWT.NONE;

		frmNewOperator = toolkit.createForm(this);
		frmNewOperator.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmNewOperator);

		frmNewOperator.setText(actionText + "Operator");
		frmNewOperator.getBody().setLayout(new FormLayout());

		Section sctnMappings = toolkit.createSection(frmNewOperator.getBody(),
				Section.EXPANDED | Section.TITLE_BAR);
		FormData fd_sctnMappings = new FormData();
		fd_sctnMappings.bottom = new FormAttachment(100, -10);
		fd_sctnMappings.left = new FormAttachment(0, 10);
		fd_sctnMappings.top = new FormAttachment(0, 10);
		fd_sctnMappings.right = new FormAttachment(100, -14);
		sctnMappings.setLayoutData(fd_sctnMappings);
		toolkit.paintBordersFor(sctnMappings);
		sctnMappings.setText("Info");

		Composite composite_1 = toolkit.createComposite(sctnMappings, SWT.NONE);
		toolkit.paintBordersFor(composite_1);
		sctnMappings.setClient(composite_1);
		composite_1.setLayout(new GridLayout(2, false));

		Label lblName = toolkit.createLabel(composite_1, "Name:", SWT.NONE);
		lblName.setAlignment(SWT.RIGHT);
		GridData gd_lblName = new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1);
		gd_lblName.widthHint = 83;
		lblName.setLayoutData(gd_lblName);

		txtName = toolkit.createText(composite_1, "New Text", widgetStyle);
		txtName.setText("");
		GridData gd_txtName = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_txtName.widthHint = 150;
		txtName.setLayoutData(gd_txtName);

		Label lblLevel = toolkit.createLabel(composite_1, "Short Name:", SWT.NONE);
		lblLevel.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false, false,
				1, 1));
		
		txtShortName = toolkit.createText(composite_1, "New Text", widgetStyle);
		txtShortName.setText("");
		
		Label lblWebsite = toolkit.createLabel(composite_1, "Website:", SWT.NONE);
		lblWebsite.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblWebsite.setAlignment(SWT.RIGHT);
		
		txtWebsite = toolkit.createText(composite_1, "New Text", widgetStyle);
		GridData gd_text_1 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_text_1.widthHint = 150;
		txtWebsite.setLayoutData(gd_text_1);
		txtWebsite.setText("");
	}
	
	public void addData() {
		if (ScreenUtil.isNewOperation(getOperation()) && owner != null) {
			// If new, we have been operating on an object not added yet.
			Command c;

			c = new AddCommand(editingService.getEditingDomain(),
					owner.getContents(), operator);

			editingService.getEditingDomain().getCommandStack().execute(c);
		} else if (ScreenUtil.isEditOperation(getOperation())) {
			// If edit, we have been operating on a copy of the object, so we
			// have to replace. However if our original object is invalid, this
			// will
			// cause invalidity, so the action will not occure in case the
			// original is
			// invalid, and we should cancel the action and warn the user.
			if (operator.cdoInvalid()) {
				MessageDialog
						.openWarning(Display.getDefault().getActiveShell(),
								"Conflict",
								"There is a conflict with another user. Your changes can't be saved.");
				return;
			}
			System.out.println(operator.cdoID() + "" + operator.cdoState());

		}
		// After our edit, we shall be dirty
		if (editingService.isDirty()) {
			editingService.doSave(new NullProgressMonitor());
		}
	}

	@Override
	public Viewer getViewer() {
		return null;
	}

	@Override
	public boolean isValid() {
		return true;
	}

	@Override
	public Form getScreenForm() {
		return frmNewOperator;
	}

	public void disposeData() {
		// N/A
	}

	@Override
	public void setOperation(int operation) {
		this.operation = operation;
	}
	
	public String getScreenName() {
		return "Operator";
	}

}
