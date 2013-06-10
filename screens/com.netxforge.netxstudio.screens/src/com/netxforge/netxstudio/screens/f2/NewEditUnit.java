package com.netxforge.netxstudio.screens.f2;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.IEMFValueProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
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

import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.Unit;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.editing.IDataScreenInjection;
import com.netxforge.netxstudio.screens.editing.ScreenUtil;

public class NewEditUnit extends AbstractScreen implements
		IDataScreenInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Text txtName;
	private Form frmNewEditUnit;
	private Resource owner;
	private Unit unit;
	@SuppressWarnings("unused")
	private EMFDataBindingContext m_bindingContext;
	private Text txtCode;
	private Text txtDescription;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public NewEditUnit(Composite parent, int style) {
		super(parent, style);
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
//		buildUI();
	}

	public EMFDataBindingContext initDataBindings_() {
		EMFDataBindingContext context = new EMFDataBindingContext();
		
		IObservableValue nameObservable = SWTObservables.observeDelayedValue(400, SWTObservables.observeText(txtName,
				SWT.Modify));
		IObservableValue codeObservable = SWTObservables.observeDelayedValue(400, SWTObservables.observeText(txtCode,
				SWT.Modify));
		IObservableValue descriptionObservable = SWTObservables.observeDelayedValue(400, SWTObservables.observeText(txtDescription,
				SWT.Modify));
		

		IEMFValueProperty nameProperty = EMFEditProperties
				.value(editingService.getEditingDomain(), LibraryPackage.Literals.UNIT__NAME);
		IEMFValueProperty codeProperty = EMFEditProperties
				.value(editingService.getEditingDomain(), LibraryPackage.Literals.UNIT__CODE);
		IEMFValueProperty descriptionProperty = EMFEditProperties
				.value(editingService.getEditingDomain(), LibraryPackage.Literals.UNIT__DESCRIPTION);
		
		context.bindValue(nameObservable, nameProperty.observe(unit),
				null, null);
		context.bindValue(codeObservable, codeProperty.observe(unit),
				null, null);
		context.bindValue(descriptionObservable, descriptionProperty.observe(unit),
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
		if (object != null && object instanceof Unit) {
			unit = (Unit) object;
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
		int widgetStyle = readonly ? SWT.READ_ONLY : SWT.NONE;

		frmNewEditUnit = toolkit.createForm(this);
		frmNewEditUnit.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmNewEditUnit);

		frmNewEditUnit.setText(this.getOperationText() + " Unit");
		frmNewEditUnit.getBody().setLayout(new FormLayout());

		Section sctnMappings = toolkit.createSection(frmNewEditUnit.getBody(),
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

		Label lblCode = toolkit.createLabel(composite_1, "Code:", SWT.NONE);
		lblCode.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false, false,
				1, 1));
		
		txtCode = toolkit.createText(composite_1, "New Text", widgetStyle);
		GridData gd_txtCode = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_txtCode.widthHint = 30;
		txtCode.setLayoutData(gd_txtCode);
		txtCode.setText("");
		
		Label lblDescription = toolkit.createLabel(composite_1, "Description:", SWT.NONE);
		lblDescription.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblDescription.setAlignment(SWT.RIGHT);
		
		txtDescription = toolkit.createText(composite_1, "New Text", SWT.MULTI | widgetStyle);
		GridData gd_text_1 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_text_1.heightHint = 50;
		gd_text_1.widthHint = 150;
		txtDescription.setLayoutData(gd_text_1);
		txtDescription.setText("");
	}
	
	public void addData() {
		if (ScreenUtil.isNewOperation(getOperation()) && owner != null) {
			// If new, we have been operating on an object not added yet.
			Command c;

			c = new AddCommand(editingService.getEditingDomain(),
					owner.getContents(), unit);

			editingService.getEditingDomain().getCommandStack().execute(c);
		} else if (ScreenUtil.isEditOperation(getOperation())) {
			// If edit, we have been operating on a copy of the object, so we
			// have to replace. However if our original object is invalid, this
			// will
			// cause invalidity, so the action will not occure in case the
			// original is
			// invalid, and we should cancel the action and warn the user.
			if (unit.cdoInvalid()) {
				MessageDialog
						.openWarning(Display.getDefault().getActiveShell(),
								"Conflict",
								"There is a conflict with another user. Your changes can't be saved.");
				return;
			}
			System.out.println(unit.cdoID() + "" + unit.cdoState());

		}
		// After our edit, we shall be dirty
		if (editingService.isDirty()) {
			editingService.doSave(new NullProgressMonitor());
		}
	}

	public Viewer getViewer() {
		return null;
	}

	@Override
	public boolean isValid() {
		return true;
	}

	public Form getScreenForm() {
		return frmNewEditUnit;
	}

	public void disposeData() {
		// N/A
	}

	public String getScreenName() {
		return "Unit";
	}

}
