package com.netxforge.netxstudio.screens.f2;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.property.value.IValueProperty;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.IEMFValueProperty;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.ReplaceCommand;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.LabelProvider;
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
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

import com.netxforge.netxstudio.library.LevelType;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.Tolerance;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.editing.selector.IDataScreenInjection;
import com.netxforge.netxstudio.screens.editing.selector.Screens;

public class NewEditTolerance extends AbstractScreen implements
		IDataScreenInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Text txtName;
	private Form frmNewTolerance;
	private Resource owner;
	private Tolerance tolerance;
	private Tolerance original;
	@SuppressWarnings("unused")
	private EMFDataBindingContext m_bindingContext;
	private ComboViewer cmbLevelViewer;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public NewEditTolerance(Composite parent, int style) {
		super(parent, style);
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
		setLayout(new FillLayout(SWT.HORIZONTAL));

		frmNewTolerance = toolkit.createForm(this);
		frmNewTolerance.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmNewTolerance);

		String title = Screens.isNewOperation(getOperation()) ? "New" : "Edit";

		frmNewTolerance.setText(title + " Tolerance");
		frmNewTolerance.getBody().setLayout(new FormLayout());

		Section sctnMappings = toolkit.createSection(frmNewTolerance.getBody(),
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
		composite_1.setLayout(new GridLayout(3, false));

		Label lblName = toolkit.createLabel(composite_1, "Name:", SWT.NONE);
		lblName.setAlignment(SWT.RIGHT);
		GridData gd_lblName = new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1);
		gd_lblName.widthHint = 83;
		lblName.setLayoutData(gd_lblName);

		txtName = toolkit.createText(composite_1, "New Text", SWT.NONE);
		txtName.setText("");
		GridData gd_txtName = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_txtName.widthHint = 150;
		txtName.setLayoutData(gd_txtName);
		new Label(composite_1, SWT.NONE);

		Label lblLevel = toolkit.createLabel(composite_1, "Level:", SWT.NONE);
		lblLevel.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false, false,
				1, 1));

		cmbLevelViewer = new ComboViewer(composite_1, SWT.NONE);
		Combo combo = cmbLevelViewer.getCombo();
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1,
				1));
		toolkit.paintBordersFor(combo);
		new Label(composite_1, SWT.NONE);
	}

	public EMFDataBindingContext initDataBindings_() {
		EMFDataBindingContext context = new EMFDataBindingContext();
		IObservableValue nameObservable = SWTObservables.observeText(txtName,
				SWT.Modify);

		IEMFValueProperty nameProperty = EMFProperties
				.value(LibraryPackage.Literals.TOLERANCE__NAME);
		context.bindValue(nameObservable, nameProperty.observe(tolerance),
				null, null);

		cmbLevelViewer.setContentProvider(new ArrayContentProvider());
		cmbLevelViewer.setLabelProvider(new LabelProvider());
		cmbLevelViewer.setInput(LevelType.VALUES);

		
		IEMFValueProperty toleranceLevelProperty = EMFProperties
				.value(LibraryPackage.Literals.TOLERANCE__LEVEL);
		IValueProperty selectionProperty = ViewerProperties.singleSelection();
		context.bindValue(selectionProperty.observe(cmbLevelViewer),
				toleranceLevelProperty.observe(tolerance),
				null, null);

		// And something for the expressions.

		return context;
	}

	public void injectData(Object owner, Object object) {
		if (owner instanceof Resource) {
			this.owner = (Resource) owner;
		} else {
			// We need the right type of object for this screen.
			throw new java.lang.IllegalArgumentException();
		}
		if (object != null && object instanceof Tolerance) {
			if (Screens.isEditOperation(this.getOperation())) {
				Tolerance copy = EcoreUtil.copy((Tolerance) object);
				tolerance = copy;
				original = (Tolerance) object;
			} else if (Screens.isNewOperation(getOperation())) {
				tolerance = (Tolerance) object;
			}
		}

		m_bindingContext = initDataBindings_();
	}

	public void addData() {
		if (Screens.isNewOperation(getOperation()) && owner != null) {
			// If new, we have been operating on an object not added yet.
			Command c;

			c = new AddCommand(editingService.getEditingDomain(),
					owner.getContents(), tolerance);

			editingService.getEditingDomain().getCommandStack().execute(c);
		} else if (Screens.isEditOperation(getOperation())) {
			// If edit, we have been operating on a copy of the object, so we
			// have to replace. However if our original object is invalid, this
			// will
			// cause invalidity, so the action will not occure in case the
			// original is
			// invalid, and we should cancel the action and warn the user.
			if (original.cdoInvalid()) {
				MessageDialog
						.openWarning(Display.getDefault().getActiveShell(),
								"Conflict",
								"There is a conflict with another user. Your changes can't be saved.");
				return;
			}

			Command c;
			c = new ReplaceCommand(editingService.getEditingDomain(),
					owner.getContents(), original, tolerance);
			editingService.getEditingDomain().getCommandStack().execute(c);

			System.out.println(tolerance.cdoID() + "" + tolerance.cdoState());

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
		// TODO, Validation
		return true;
	}

	@Override
	public Form getScreenForm() {
		return frmNewTolerance;
	}

	public void disposeData() {
		// N/A
	}

	@Override
	public void setOperation(int operation) {
		this.operation = operation;

	}
}
