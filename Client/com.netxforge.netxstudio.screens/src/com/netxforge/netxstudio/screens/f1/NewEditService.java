package com.netxforge.netxstudio.screens.f1;

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
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.dialogs.IDialogConstants;
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
import org.eclipse.ui.forms.widgets.ColumnLayoutData;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.ui.forms.widgets.Section;

import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.library.Tolerance;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.NodeFilterDialog;
import com.netxforge.netxstudio.screens.ServiceUserFilterDialog;
import com.netxforge.netxstudio.screens.ToleranceFilterDialog;
import com.netxforge.netxstudio.screens.editing.selector.IDataScreenInjection;
import com.netxforge.netxstudio.screens.editing.selector.Screens;
import com.netxforge.netxstudio.screens.f2.support.ToleranceObservableMapLabelProvider;
import com.netxforge.netxstudio.services.RFSService;
import com.netxforge.netxstudio.services.ServiceUser;
import com.netxforge.netxstudio.services.ServicesPackage;

public class NewEditService extends AbstractScreen implements
		IDataScreenInjection {
	private final FormToolkit formToolkit = new FormToolkit(
			Display.getDefault());
	private Text txtName;
	private Text txtDescription;
	private Table table;
	private TableViewer tolerancesTableViewer;
	private Form frmService;
	private RFSService service;
	private Resource owner;
	private Table tblNetworkElements;
	private TableViewer networkElementsTableViewer;
	private TableViewer serviceUserTableViewer;

	public NewEditService(Composite parent, int style) {
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

		Section sctnStatistics = formToolkit.createSection(
				frmService.getBody(), Section.TWISTIE | Section.TITLE_BAR);
		formToolkit.paintBordersFor(sctnStatistics);
		sctnStatistics.setText("Statistics");
		sctnStatistics.setExpanded(true);

		Composite composite_2 = formToolkit.createComposite(sctnStatistics,
				SWT.NONE);
		formToolkit.paintBordersFor(composite_2);
		sctnStatistics.setClient(composite_2);
		composite_2.setLayout(new GridLayout(1, false));

		@SuppressWarnings("unused")
		Label lblMonitoredNodes = formToolkit.createLabel(composite_2,
				"# Monitored NE's", SWT.NONE);

		Section sctnNetworkElements = formToolkit.createSection(
				frmService.getBody(), Section.TWISTIE | Section.TITLE_BAR);
		ColumnLayoutData cld_sctnNetworkElements = new ColumnLayoutData();
		cld_sctnNetworkElements.heightHint = 38;
		sctnNetworkElements.setLayoutData(cld_sctnNetworkElements);
		formToolkit.paintBordersFor(sctnNetworkElements);
		sctnNetworkElements.setText("Network Elements");
		sctnNetworkElements.setExpanded(true);

		Composite composite_3 = formToolkit.createComposite(
				sctnNetworkElements, SWT.NONE);
		formToolkit.paintBordersFor(composite_3);
		sctnNetworkElements.setClient(composite_3);
		composite_3.setLayout(new GridLayout(1, false));

		ImageHyperlink mghprlnkAddNetworkElement = formToolkit
				.createImageHyperlink(composite_3, SWT.NONE);
		mghprlnkAddNetworkElement
				.addHyperlinkListener(new IHyperlinkListener() {
					public void linkActivated(HyperlinkEvent e) {

						Resource operatorResource = editingService
								.getData(OperatorsPackage.Literals.OPERATOR);

						NodeFilterDialog dialog = new NodeFilterDialog(
								NewEditService.this.getShell(),
								operatorResource);

						if (dialog.open() == IDialogConstants.OK_ID) {
							ServiceUser u = (ServiceUser) dialog
									.getFirstResult();
							if (!service.getNodes().contains(u)) {
								Command c = new AddCommand(editingService
										.getEditingDomain(),
										service.getNodes(), u);
								editingService.getEditingDomain()
										.getCommandStack().execute(c);
							}
						}

					}

					public void linkEntered(HyperlinkEvent e) {
					}

					public void linkExited(HyperlinkEvent e) {
					}
				});
		mghprlnkAddNetworkElement.setLayoutData(new GridData(SWT.RIGHT,
				SWT.CENTER, true, false, 1, 1));
		formToolkit.paintBordersFor(mghprlnkAddNetworkElement);
		mghprlnkAddNetworkElement.setText("Add");

		networkElementsTableViewer = new TableViewer(composite_3, SWT.BORDER
				| SWT.FULL_SELECTION);
		tblNetworkElements = networkElementsTableViewer.getTable();
		tblNetworkElements.setLinesVisible(true);
		tblNetworkElements.setHeaderVisible(true);
		GridData gd_table_1 = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_table_1.heightHint = 146;
		tblNetworkElements.setLayoutData(gd_table_1);
		formToolkit.paintBordersFor(tblNetworkElements);

		TableViewerColumn tbvClmnType = new TableViewerColumn(
				networkElementsTableViewer, SWT.NONE);
		TableColumn tblclmnNodeId = tbvClmnType.getColumn();
		tblclmnNodeId.setWidth(79);
		tblclmnNodeId.setText("Type");

		TableViewerColumn tbvClmnNodeID = new TableViewerColumn(
				networkElementsTableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_1 = tbvClmnNodeID.getColumn();
		tblclmnNewColumn_1.setWidth(64);
		tblclmnNewColumn_1.setText("Node ID");

		Menu menu_2 = new Menu(tblNetworkElements);
		tblNetworkElements.setMenu(menu_2);

		MenuItem mntmRemoveNetworkElement = new MenuItem(menu_2, SWT.NONE);
		mntmRemoveNetworkElement.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ISelection s = networkElementsTableViewer.getSelection();
				if (s instanceof IStructuredSelection) {
					Object o = ((IStructuredSelection) s).getFirstElement();
					Command rc = new RemoveCommand(editingService
							.getEditingDomain(), service.getNodes(), o);
					editingService.getEditingDomain().getCommandStack()
							.execute(rc);
				}
			}
		});
		mntmRemoveNetworkElement.setText("Remove");

		Section sctnHiarchy = formToolkit.createSection(frmService.getBody(),
				Section.TWISTIE | Section.TITLE_BAR);
		formToolkit.paintBordersFor(sctnHiarchy);
		sctnHiarchy.setText("Hierarchy");
		sctnHiarchy.setExpanded(true);

		Composite composite_4 = formToolkit.createComposite(sctnHiarchy,
				SWT.NONE);
		formToolkit.paintBordersFor(composite_4);
		sctnHiarchy.setClient(composite_4);
		composite_4.setLayout(new GridLayout(1, false));

		ImageHyperlink mghprlnkShowHiararchy = formToolkit
				.createImageHyperlink(composite_4, SWT.NONE);
		mghprlnkShowHiararchy.addHyperlinkListener(new IHyperlinkListener() {
			public void linkActivated(HyperlinkEvent e) {

				ServiceHierarchy sh = new ServiceHierarchy(screenService.getScreenContainer(), SWT.NONE);
				sh.setScreenService(screenService);
				sh.setOperation(getOperation());
				sh.injectData(null,service);
				screenService.setActiveScreen(sh);
			}

			public void linkEntered(HyperlinkEvent e) {
			}

			public void linkExited(HyperlinkEvent e) {
			}
		});
		formToolkit.paintBordersFor(mghprlnkShowHiararchy);
		mghprlnkShowHiararchy.setText("Show Hierarchy");

		Section sctnServiceUsers = formToolkit.createSection(
				frmService.getBody(), Section.EXPANDED | Section.TWISTIE
						| Section.TITLE_BAR);
		ColumnLayoutData cld_sctnServiceUsers = new ColumnLayoutData();
		cld_sctnServiceUsers.heightHint = 150;
		sctnServiceUsers.setLayoutData(cld_sctnServiceUsers);
		formToolkit.paintBordersFor(sctnServiceUsers);
		sctnServiceUsers.setText("Service Users");
		sctnServiceUsers.setExpanded(true);

		Composite composite_1 = formToolkit.createComposite(sctnServiceUsers,
				SWT.NONE);
		formToolkit.paintBordersFor(composite_1);
		sctnServiceUsers.setClient(composite_1);
		composite_1.setLayout(new GridLayout(1, false));

		ImageHyperlink mghprlnkAddServiceUser = formToolkit
				.createImageHyperlink(composite_1, SWT.NONE);
		mghprlnkAddServiceUser.setImage(null);
		mghprlnkAddServiceUser.addHyperlinkListener(new IHyperlinkListener() {
			public void linkActivated(HyperlinkEvent e) {
				Resource serviceUserResource = editingService
						.getData(ServicesPackage.Literals.SERVICE_USER);

				ServiceUserFilterDialog dialog = new ServiceUserFilterDialog(
						NewEditService.this.getShell(), serviceUserResource);

				if (dialog.open() == IDialogConstants.OK_ID) {
					ServiceUser u = (ServiceUser) dialog.getFirstResult();
					if (!service.getServiceUserRefs().contains(u)) {
						Command c = new AddCommand(editingService
								.getEditingDomain(), service
								.getServiceUserRefs(), u);
						editingService.getEditingDomain().getCommandStack()
								.execute(c);
					}
				}
			}

			public void linkEntered(HyperlinkEvent e) {
			}

			public void linkExited(HyperlinkEvent e) {
			}
		});
		mghprlnkAddServiceUser.setLayoutData(new GridData(SWT.RIGHT,
				SWT.CENTER, true, false, 1, 1));
		formToolkit.paintBordersFor(mghprlnkAddServiceUser);
		mghprlnkAddServiceUser.setText("Add");

		serviceUserTableViewer = new TableViewer(composite_1, SWT.BORDER
				| SWT.FULL_SELECTION);
		table = serviceUserTableViewer.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		GridData gd_table = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_table.heightHint = 120;
		table.setLayoutData(gd_table);
		formToolkit.paintBordersFor(table);

		TableViewerColumn tableViewerColumn = new TableViewerColumn(
				serviceUserTableViewer, SWT.NONE);
		TableColumn tblclmnName = tableViewerColumn.getColumn();
		tblclmnName.setWidth(68);
		tblclmnName.setText("Name");

		Menu menu_1 = new Menu(table);
		table.setMenu(menu_1);

		MenuItem mntmRemove = new MenuItem(menu_1, SWT.NONE);
		mntmRemove.setText("Remove");

		Section sctnTolerances = formToolkit.createSection(
				frmService.getBody(), Section.TWISTIE | Section.TITLE_BAR);

		formToolkit.paintBordersFor(sctnTolerances);
		sctnTolerances.setText("Tolerances");
		sctnTolerances.setExpanded(false);

		Composite cmpTolerances = formToolkit.createComposite(sctnTolerances,
				SWT.NONE);
		formToolkit.paintBordersFor(cmpTolerances);
		sctnTolerances.setClient(cmpTolerances);
		cmpTolerances.setLayout(new GridLayout(1, false));

		ImageHyperlink hypLnkAddTolerance = formToolkit.createImageHyperlink(
				cmpTolerances, SWT.NONE);
		hypLnkAddTolerance.addHyperlinkListener(new IHyperlinkListener() {
			public void linkActivated(HyperlinkEvent e) {
				Resource toleranceResource = editingService
						.getData(LibraryPackage.Literals.TOLERANCE);
				ToleranceFilterDialog dialog = new ToleranceFilterDialog(
						NewEditService.this.getShell(), toleranceResource);
				if (dialog.open() == IDialogConstants.OK_ID) {
					Tolerance tol = (Tolerance) dialog.getFirstResult();
					if (!service.getToleranceRefs().contains(tol)) {
						Command c = new AddCommand(editingService
								.getEditingDomain(),
								service.getToleranceRefs(), tol);
						editingService.getEditingDomain().getCommandStack()
								.execute(c);
					}
				}
			}

			public void linkEntered(HyperlinkEvent e) {
			}

			public void linkExited(HyperlinkEvent e) {
			}
		});
		hypLnkAddTolerance.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
				false, false, 1, 1));
		formToolkit.paintBordersFor(hypLnkAddTolerance);
		hypLnkAddTolerance.setText("Add");

		tolerancesTableViewer = new TableViewer(cmpTolerances, SWT.BORDER
				| SWT.FULL_SELECTION);
		Table metricsTable = tolerancesTableViewer.getTable();
		metricsTable.setHeaderVisible(true);
		metricsTable.setLinesVisible(true);

		GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd.heightHint = 100;
		metricsTable.setLayoutData(gd);
		formToolkit.paintBordersFor(metricsTable);

		TableViewerColumn tableViewerColumn_4 = new TableViewerColumn(
				tolerancesTableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn = tableViewerColumn_4.getColumn();
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("Name");

		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(
				tolerancesTableViewer, SWT.NONE);
		TableColumn tblclmnLevel = tableViewerColumn_1.getColumn();
		tblclmnLevel.setWidth(69);
		tblclmnLevel.setText("Level");

		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(
				tolerancesTableViewer, SWT.NONE);
		TableColumn tblclmnExpression = tableViewerColumn_2.getColumn();
		tblclmnExpression.setWidth(100);
		tblclmnExpression.setText("Expression");

		Menu menu = new Menu(metricsTable);
		metricsTable.setMenu(menu);

		MenuItem mntmRemoveTolerance = new MenuItem(menu, SWT.NONE);
		mntmRemoveTolerance.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ISelection s = tolerancesTableViewer.getSelection();
				if (s instanceof IStructuredSelection) {
					Object o = ((IStructuredSelection) s).getFirstElement();
					Command rc = new RemoveCommand(editingService
							.getEditingDomain(), service.getToleranceRefs(), o);
					editingService.getEditingDomain().getCommandStack()
							.execute(rc);
				}
			}
		});
		mntmRemoveTolerance.setText("Remove");

		if (readonly) {

			hypLnkAddTolerance.setEnabled(false);
			mntmRemoveTolerance.setEnabled(false);

			// TODO, add other actions here.

		}

	}

	public EMFDataBindingContext initDataBindings_() {

		EMFDataBindingContext context = new EMFDataBindingContext();

		bindInfoSection(context);
		bindNetworkElementSection();
		bindToleranceSection();

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
				ServicesPackage.Literals.SERVICE__SERVICE_NAME);

		IEMFValueProperty descriptionProperty = EMFEditProperties.value(
				editingService.getEditingDomain(),
				ServicesPackage.Literals.SERVICE__SERVICE_DESCRIPTION);

		context.bindValue(nameObservable, nameProperty.observe(service), null,
				null);
		context.bindValue(descriptionObservable,
				descriptionProperty.observe(service), null, null);
	}

	public void bindToleranceSection() {
		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		tolerancesTableViewer.setContentProvider(listContentProvider);
		IObservableMap[] observeMaps = EMFObservables.observeMaps(
				listContentProvider.getKnownElements(),
				new EStructuralFeature[] {
						LibraryPackage.Literals.TOLERANCE__NAME,
						LibraryPackage.Literals.TOLERANCE__LEVEL,
						LibraryPackage.Literals.TOLERANCE__EXPRESSION_REF });
		tolerancesTableViewer
				.setLabelProvider(new ToleranceObservableMapLabelProvider(
						observeMaps));
		IEMFListProperty l = EMFEditProperties.list(
				editingService.getEditingDomain(),
				ServicesPackage.Literals.RFS_SERVICE__TOLERANCE_REFS);

		tolerancesTableViewer.setInput(l.observe(service));
	}

	public void bindNetworkElementSection() {

		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		networkElementsTableViewer.setContentProvider(listContentProvider);
		IObservableMap[] observeMaps = EMFObservables.observeMaps(
				listContentProvider.getKnownElements(),
				new EStructuralFeature[] {
						OperatorsPackage.Literals.NODE__NODE_TYPE,
						OperatorsPackage.Literals.NODE__NODE_ID });
		networkElementsTableViewer
				.setLabelProvider(new NodeInServiceObservableMapLabelProvider(
						observeMaps));
		IEMFListProperty l = EMFEditProperties.list(
				editingService.getEditingDomain(),
				ServicesPackage.Literals.RFS_SERVICE__NODES);

		networkElementsTableViewer.setInput(l.observe(service));
	}

	public void bindServiceUserSection() {

		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		serviceUserTableViewer.setContentProvider(listContentProvider);
		IObservableMap[] observeMaps = EMFObservables
				.observeMaps(
						listContentProvider.getKnownElements(),
						new EStructuralFeature[] { ServicesPackage.Literals.SERVICE_USER__NAME });
		serviceUserTableViewer.setLabelProvider(new ObservableMapLabelProvider(
				observeMaps));
		IEMFListProperty l = EMFEditProperties.list(
				editingService.getEditingDomain(),
				ServicesPackage.Literals.SERVICE__SERVICE_USER_REFS);

		serviceUserTableViewer.setInput(l.observe(service));
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

		if (object != null && object instanceof RFSService) {
			service = (RFSService) object;
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
