package com.netxforge.netxstudio.screens.f1;

import java.util.List;

import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.databinding.IEMFValueProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.ColumnLayout;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.ui.forms.widgets.Section;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.netxforge.base.di.IInjectorProxy;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.xtext.embedded.EmbeddedSelectionExpression;
import com.netxforge.netxstudio.services.ServiceUser;
import com.netxforge.netxstudio.services.ServicesFactory;
import com.netxforge.netxstudio.services.ServicesPackage;
import com.netxforge.screens.editing.base.IDataScreenInjection;
import com.netxforge.screens.editing.base.ScreenUtil;

public class NewEditServiceUser extends AbstractScreen implements
		IDataScreenInjection {
	private final FormToolkit formToolkit = new FormToolkit(
			Display.getDefault());
	private Text txtName;
	private Text txtDescription;
	private Form frmServiceUser;
	private ServiceUser serviceUser;
	private Resource owner;
	private Table table;

	private TableViewer resourcesTableViewer;
	private EmbeddedSelectionExpression exp;

	@Inject
	@Named("Netxscript")
	private IInjectorProxy injectorProxy;

	public NewEditServiceUser(Composite parent, int style) {
		super(parent, style);
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				formToolkit.dispose();
			}
		});
		formToolkit.adapt(this);
		formToolkit.paintBordersFor(this);

		// buildUI();
	}

	private void buildUI() {

		// Readonlyness.
		boolean readonly = ScreenUtil.isReadOnlyOperation(this.getOperation());
		int widgetStyle = readonly ? SWT.READ_ONLY : SWT.NONE;

		setLayout(new FillLayout(SWT.HORIZONTAL));

		frmServiceUser = formToolkit.createForm(this);
		formToolkit.paintBordersFor(frmServiceUser);
		frmServiceUser.setText(this.getOperationText() + "Service User");
		ColumnLayout cl = new ColumnLayout();
		cl.maxNumColumns = 2;
		frmServiceUser.getBody().setLayout(cl);

		Section sctnInfo = formToolkit.createSection(frmServiceUser.getBody(),
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
				| SWT.MULTI | widgetStyle);
		txtDescription.setText("");
		GridData gd_txtDescription = new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1);
		gd_txtDescription.heightHint = 133;
		txtDescription.setLayoutData(gd_txtDescription);

		Section sctnResourceProfiles = formToolkit.createSection(
				frmServiceUser.getBody(), Section.TWISTIE | Section.TITLE_BAR);
		formToolkit.paintBordersFor(sctnResourceProfiles);
		sctnResourceProfiles.setText("Profile");
		sctnResourceProfiles.setExpanded(true);

		Composite composite_2 = formToolkit.createComposite(
				sctnResourceProfiles, SWT.NONE);
		formToolkit.paintBordersFor(composite_2);
		sctnResourceProfiles.setClient(composite_2);
		composite_2.setLayout(new GridLayout(5, false));

		if (!readonly) {
			ImageHyperlink mghprlnkAdd = formToolkit.createImageHyperlink(
					composite_2, SWT.NONE);
			mghprlnkAdd.addHyperlinkListener(new IHyperlinkListener() {
				public void linkEntered(HyperlinkEvent e) {

				}

				public void linkExited(HyperlinkEvent e) {

				}

				public void linkActivated(HyperlinkEvent e) {
					NewEditDerivedResource resourceScreen = new NewEditDerivedResource(
							screenService.getScreenContainer(), SWT.NONE);
					resourceScreen.setOperation(ScreenUtil.OPERATION_NEW);
					resourceScreen.setScreenService(screenService);
					resourceScreen.injectData(serviceUser.getServiceProfile(),
							ServicesFactory.eINSTANCE.createDerivedResource());
					screenService.setActiveScreen(resourceScreen);
				}
			});
			mghprlnkAdd.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true,
					false, 5, 1));
			formToolkit.paintBordersFor(mghprlnkAdd);
			mghprlnkAdd.setText("New");
		}

		resourcesTableViewer = new TableViewer(composite_2, SWT.BORDER
				| SWT.FULL_SELECTION | SWT.MULTI);
		table = resourcesTableViewer.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		GridData gd_table = new GridData(SWT.FILL, SWT.FILL, true, true, 5, 1);
		gd_table.heightHint = 112;
		table.setLayoutData(gd_table);
		formToolkit.paintBordersFor(table);

		TableViewerColumn tableViewerColumn = new TableViewerColumn(
				resourcesTableViewer, SWT.NONE);
		TableColumn tblclmnName = tableViewerColumn.getColumn();
		tblclmnName.setWidth(100);
		tblclmnName.setText("Name");

		Menu resourcesMenu = new Menu(table);
		table.setMenu(resourcesMenu);

		MenuItem mntmEditResource = new MenuItem(resourcesMenu, SWT.NONE);
		mntmEditResource.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ISelection s = resourcesTableViewer.getSelection();
				if (s instanceof IStructuredSelection) {
					final Object object = ((IStructuredSelection) s)
							.getFirstElement();
					NewEditDerivedResource editResourceScreen = new NewEditDerivedResource(
							screenService.getScreenContainer(), SWT.NONE);
					editResourceScreen.setScreenService(screenService);
					editResourceScreen.setOperation(getOperation());
					// We can probably get away without the resource....
					editResourceScreen.injectData(
							serviceUser.getServiceProfile(), object);
					screenService.setActiveScreen(editResourceScreen);

				}
			}
		});
		
		mntmEditResource.setText(ScreenUtil.isReadOnlyOperation(this.getOperation()) ? "View..." : "Edit...");

		MenuItem mntmRemoveResource = new MenuItem(resourcesMenu, SWT.NONE);
		mntmRemoveResource.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ISelection s = resourcesTableViewer.getSelection();
				if (s instanceof IStructuredSelection) {

					Object o = ((IStructuredSelection) s).toList();
					Command rc = DeleteCommand.create(
							editingService.getEditingDomain(), (List<?>) o);
					editingService.getEditingDomain().getCommandStack()
							.execute(rc);

					// Object o = ((IStructuredSelection) s).getFirstElement();
					// Command rc = new RemoveCommand(editingService
					// .getEditingDomain(),
					// serviceUser.getServiceProfile().getProfileResources(),
					// o);
					// editingService.getEditingDomain().getCommandStack()
					// .execute(rc);
				}
			}
		});
		mntmRemoveResource.setText("Remove");

		exp = new EmbeddedSelectionExpression(this.editingService,
				frmServiceUser.getBody(), null, getOperation());
		exp.setXtextInjector(injectorProxy
				.getInjector("com.netxforge.Netxscript"));
		exp.injectData("Profile Expression", serviceUser,
				ServicesPackage.Literals.SERVICE_USER__EXPRESSION_REF);

		if (readonly) {
			mntmRemoveResource.setEnabled(false);
		}
	}

	public EMFDataBindingContext initDataBindings_() {

		EMFDataBindingContext context = new EMFDataBindingContext();

		bindInfoSection(context);
		bindResourcesSection(context);

		// Also bind the embedded expression.
		exp.bind(context);

		return context;
	}

	private void bindInfoSection(EMFDataBindingContext context) {
		IObservableValue nameObservable = SWTObservables.observeDelayedValue(
				400, SWTObservables.observeText(txtName, SWT.Modify));

		IObservableValue descriptionObservable = SWTObservables
				.observeDelayedValue(400,
						SWTObservables.observeText(txtDescription, SWT.Modify));

		IEMFValueProperty nameProperty = EMFEditProperties.value(
				editingService.getEditingDomain(),
				ServicesPackage.Literals.SERVICE_USER__NAME);

		IEMFValueProperty descriptionProperty = EMFEditProperties.value(
				editingService.getEditingDomain(),
				ServicesPackage.Literals.SERVICE_USER__DESCRIPTION);

		context.bindValue(nameObservable, nameProperty.observe(serviceUser),
				null, null);
		context.bindValue(descriptionObservable,
				descriptionProperty.observe(serviceUser), null, null);
	}

	public void bindResourcesSection(EMFDataBindingContext context) {
		// binding of resources

		ObservableListContentProvider resourceListContentProvider = new ObservableListContentProvider();
		resourcesTableViewer.setContentProvider(resourceListContentProvider);
		IObservableMap[] observeResourceMaps = EMFObservables
				.observeMaps(
						resourceListContentProvider.getKnownElements(),
						new EStructuralFeature[] {
								LibraryPackage.Literals.BASE_RESOURCE__SHORT_NAME,
								LibraryPackage.Literals.BASE_RESOURCE__EXPRESSION_NAME });
		resourcesTableViewer.setLabelProvider(new ObservableMapLabelProvider(
				observeResourceMaps));
		IEMFListProperty resourcesListProperty = EMFEditProperties.list(
				editingService.getEditingDomain(),
				ServicesPackage.Literals.SERVICE_PROFILE__PROFILE_RESOURCES);
		resourcesTableViewer.setInput(resourcesListProperty.observe(serviceUser
				.getServiceProfile()));
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

	public Viewer getViewer() {
		return null;
	}

	@Override
	public boolean isValid() {
		return true;
	}

	public Form getScreenForm() {
		return frmServiceUser;
	}

	public void injectData(Object owner, Object object) {

		if (owner != null && owner instanceof Resource) {
			this.owner = (Resource) owner;
		} else {
			throw new java.lang.IllegalArgumentException(
					"Data injection for screen invalid");
		}

		if (object != null && object instanceof ServiceUser) {
			serviceUser = (ServiceUser) object;
		} else {
			throw new java.lang.IllegalArgumentException(
					"Data injection for screen invalid");
		}

		buildUI();

		// FIXME also set the name when we have the name of the Service User.
		// Note, creating the expression here, leads to other problems, don't do
		// for now.
		// if (!serviceUser
		// .eIsSet(ServicesPackage.Literals.SERVICE_USER__EXPRESSION_REF)) {
		// Expression expression = LibraryFactory.eINSTANCE.createExpression();
		// expression.setName("Service User Profile" +
		// modelUtils.dateAndTime(modelUtils.todayAndNow()));
		//
		// Resource expressionResource =
		// editingService.getData(LibraryPackage.Literals.EXPRESSION);
		// expressionResource.getContents().add(expression);
		// serviceUser.setExpressionRef(expression);
		// }
		// exp.injectData(serviceUser.getExpressionRef());
		this.initDataBindings_();

	}

	public void addData() {
		if (ScreenUtil.isNewOperation(getOperation()) && owner != null) {
			// If new, we have been operating on an object not added yet.

			AddCommand ac = new AddCommand(editingService.getEditingDomain(),
					owner.getContents(), serviceUser);
			editingService.getEditingDomain().getCommandStack().execute(ac);

			// We can't add this resource now, we need a referee.
		} else if (ScreenUtil.isEditOperation(getOperation())) {
			// If edit, we have been operating on a copy of the object, so we
			// have to replace. However if our original object is invalid, this
			// will
			// cause invalidity, so the action will not occure in case the
			// original is
			// invalid, and we should cancel the action and warn the user.
			if (serviceUser.cdoInvalid()) {
				MessageDialog
						.openWarning(Display.getDefault().getActiveShell(),
								"Conflict",
								"There is a conflict with another user. Your changes can't be saved.");
				return;
			}
			System.out.println(serviceUser.cdoID() + ""
					+ serviceUser.cdoState());

		}
		// After our edit, we shall be dirty
		if (editingService.isDirty()) {
			editingService.doSave(new NullProgressMonitor());
		}
	}

	public String getScreenName() {
		return "Service User";
	}

}
