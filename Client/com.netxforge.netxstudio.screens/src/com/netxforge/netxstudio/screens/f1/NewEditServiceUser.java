package com.netxforge.netxstudio.screens.f1;

import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.IEMFValueProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.ColumnLayout;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.editing.selector.IDataScreenInjection;
import com.netxforge.netxstudio.screens.editing.selector.Screens;
import com.netxforge.netxstudio.services.ServiceUser;
import com.netxforge.netxstudio.services.ServicesPackage;

public class NewEditServiceUser extends AbstractScreen implements
		IDataScreenInjection {
	private final FormToolkit formToolkit = new FormToolkit(
			Display.getDefault());
	private Text txtName;
	private Text txtDescription;
	private Form frmService;
	private ServiceUser service;
	private Resource owner;
	private Table table;

	public NewEditServiceUser(Composite parent, int style) {
		super(parent, style);
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				formToolkit.dispose();
			}
		});
		formToolkit.adapt(this);
		formToolkit.paintBordersFor(this);

//		buildUI();
	}

	private void buildUI() {
		setLayout(new FillLayout(SWT.HORIZONTAL));

		// Readonlyness.
		boolean readonly = Screens.isReadOnlyOperation(this.getOperation());
		String actionText = readonly ? "View: " : "Edit: ";
		int widgetStyle = readonly ? SWT.READ_ONLY : SWT.NONE;

		frmService = formToolkit.createForm(this);
		formToolkit.paintBordersFor(frmService);

		frmService.setText(actionText + "Service");
		ColumnLayout cl = new ColumnLayout();
		cl.maxNumColumns = 2;
		frmService.getBody().setLayout(cl);

		Section sctnInfo = formToolkit.createSection(frmService.getBody(),
				Section.EXPANDED | Section.TWISTIE | Section.TITLE_BAR);
		formToolkit.paintBordersFor(sctnInfo);
		sctnInfo.setText("Info");
		sctnInfo.setExpanded(true);

		Composite composite = formToolkit.createComposite(sctnInfo, SWT.NONE);
		formToolkit.paintBordersFor(composite);
		sctnInfo.setClient(composite);
		composite.setLayout(new GridLayout(2, false));

		Label lblName = formToolkit.createLabel(composite, " Name:", SWT.NONE);
		lblName.setAlignment(SWT.RIGHT);
		GridData gd_lblName = new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1);
		gd_lblName.widthHint = 70;
		lblName.setLayoutData(gd_lblName);
		lblName.setBounds(0, 0, 59, 14);

		txtName = formToolkit.createText(composite, "New Text", widgetStyle);
		txtName.setText("");
		GridData gd_txtName = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_txtName.widthHint = 150;
		txtName.setLayoutData(gd_txtName);

		Label lblDescription = formToolkit.createLabel(composite,
				"Description:", SWT.NONE);
		lblDescription.setAlignment(SWT.RIGHT);
		lblDescription.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false,
				false, 1, 1));

		txtDescription = formToolkit.createText(composite, "New Text", SWT.WRAP
				| SWT.MULTI);
		txtDescription.setText("");
		GridData gd_txtDescription = new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1);
		gd_txtDescription.heightHint = 133;
		txtDescription.setLayoutData(gd_txtDescription);

		Section sctnResourceProfiles = formToolkit.createSection(
				frmService.getBody(), Section.TWISTIE | Section.TITLE_BAR);
		formToolkit.paintBordersFor(sctnResourceProfiles);
		sctnResourceProfiles.setText("Profile");
		sctnResourceProfiles.setExpanded(true);

		Composite composite_2 = formToolkit.createComposite(sctnResourceProfiles,
				SWT.NONE);
		formToolkit.paintBordersFor(composite_2);
		sctnResourceProfiles.setClient(composite_2);
		composite_2.setLayout(new GridLayout(1, false));
		
		TableViewer tableViewer = new TableViewer(composite_2, SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		formToolkit.paintBordersFor(table);
		
		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnName = tableViewerColumn.getColumn();
		tblclmnName.setWidth(100);
		tblclmnName.setText("Name");

		if (readonly) {
			
			
			// TODO, add other actions here. 
			
		}

	}

	public EMFDataBindingContext initDataBindings_() {

		EMFDataBindingContext context = new EMFDataBindingContext();

		bindInfoSection(context);

		return context;
	}

	private void bindInfoSection(EMFDataBindingContext context) {
		IObservableValue nameObservable = SWTObservables.observeDelayedValue(
				400, SWTObservables.observeText(txtName, SWT.Modify));

//		IObservableValue descriptionObservable = SWTObservables
//				.observeDelayedValue(400,
//						SWTObservables.observeText(txtDescription, SWT.Modify));

		IEMFValueProperty nameProperty = EMFEditProperties.value(
				editingService.getEditingDomain(),
				ServicesPackage.Literals.SERVICE_USER__NAME);

//		IEMFValueProperty descriptionProperty = EMFEditProperties.value(
//				editingService.getEditingDomain(),
//				ServicesPackage.Literals.SERVICE__SERVICE_DESCRIPTION);

		context.bindValue(nameObservable, nameProperty.observe(service), null,
				null);
//		context.bindValue(descriptionObservable,
//				descriptionProperty.observe(service), null, null);
	}

	
	
	public class NodeInServiceObservableMapLabelProvider extends
			ObservableMapLabelProvider {

		public NodeInServiceObservableMapLabelProvider(
				IObservableMap[] attributeMaps) {
			super(attributeMaps);
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			if (element instanceof Node) {
				Node t = (Node) element;
				switch (columnIndex) {
				case 0: {
					if (t.getNodeType() != null) {
						NodeType e = t.getNodeType();
						return e.getName();
					}
				}
					break;
				case 1: {
					return ((Node) element).getNodeID();
				}
				}
			}

			return super.getColumnText(element, columnIndex);
		}
	}

	public void disposeData() {
	}

	@Override
	public Viewer getViewer() {
		return null;
	}

	@Override
	public void setOperation(int operation) {
		this.operation = operation;

	}

	@Override
	public boolean isValid() {
		return true;
	}

	@Override
	public Form getScreenForm() {
		return frmService;
	}

	public void injectData(Object owner, Object object) {

		if (owner != null && owner instanceof Resource) {
			this.owner = (Resource) owner;
		} else {
			throw new java.lang.IllegalArgumentException(
					"Data injection for screen invalid");
		}

		if (object != null && object instanceof ServiceUser) {
			service = (ServiceUser) object;
		} else {
			throw new java.lang.IllegalArgumentException(
					"Data injection for screen invalid");
		}

		buildUI();
		this.initDataBindings_();

	}

	public void addData() {
		if (Screens.isNewOperation(getOperation()) && owner != null) {
			// If new, we have been operating on an object not added yet.

			AddCommand ac = new AddCommand(editingService.getEditingDomain(),
					owner.getContents(), service);
			editingService.getEditingDomain().getCommandStack().execute(ac);

			// We can't add this resource now, we need a referee.
		} else if (Screens.isEditOperation(getOperation())) {
			// If edit, we have been operating on a copy of the object, so we
			// have to replace. However if our original object is invalid, this
			// will
			// cause invalidity, so the action will not occure in case the
			// original is
			// invalid, and we should cancel the action and warn the user.
			if (service.cdoInvalid()) {
				MessageDialog
						.openWarning(Display.getDefault().getActiveShell(),
								"Conflict",
								"There is a conflict with another user. Your changes can't be saved.");
				return;
			}
			System.out.println(service.cdoID() + "" + service.cdoState());

		}
		// After our edit, we shall be dirty
		if (editingService.isDirty()) {
			editingService.doSave(new NullProgressMonitor());
		}

	}
}
