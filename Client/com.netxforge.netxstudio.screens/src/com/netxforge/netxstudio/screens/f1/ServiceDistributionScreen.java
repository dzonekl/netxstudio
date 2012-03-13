package com.netxforge.netxstudio.screens.f1;

import java.util.List;

import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.databinding.IEMFValueProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.command.SetCommand;
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
import org.eclipse.jface.window.Window;
import org.eclipse.nebula.jface.gridviewer.GridTableViewer;
import org.eclipse.nebula.jface.gridviewer.GridViewerColumn;
import org.eclipse.nebula.widgets.grid.Grid;
import org.eclipse.nebula.widgets.grid.GridColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
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
import org.eclipse.wb.swt.ResourceManager;

import com.google.common.collect.Lists;
import com.netxforge.netxstudio.library.Expression;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.dialog.ExpressionFilterDialog;
import com.netxforge.netxstudio.screens.dialog.NetXResourceFilterDialog;
import com.netxforge.netxstudio.screens.editing.selector.IDataScreenInjection;
import com.netxforge.netxstudio.screens.editing.selector.ScreenUtil;
import com.netxforge.netxstudio.services.DerivedResource;
import com.netxforge.netxstudio.services.DistributionEntry;
import com.netxforge.netxstudio.services.RFSService;
import com.netxforge.netxstudio.services.ResourceOriginType;
import com.netxforge.netxstudio.services.Service;
import com.netxforge.netxstudio.services.ServiceDistribution;
import com.netxforge.netxstudio.services.ServicesFactory;
import com.netxforge.netxstudio.services.ServicesPackage;

public class ServiceDistributionScreen extends AbstractScreen implements
		IDataScreenInjection {
	private final FormToolkit formToolkit = new FormToolkit(
			Display.getDefault());
	private Form frmServiceDistribution;
	private ServiceDistribution serviceDistribution;
	private Table table;
	private Text txtDistributionExpression;
	private TableViewer resourcesTableViewer;
	private RFSService service;

	public ServiceDistributionScreen(Composite parent, int style) {
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
		boolean readonly = ScreenUtil.isReadOnlyOperation(this.getOperation());

		@SuppressWarnings("unused")
		String actionText = readonly ? "View: " : "Edit: ";
		@SuppressWarnings("unused")
		int widgetStyle = readonly ? SWT.READ_ONLY : SWT.NONE;

		frmServiceDistribution = formToolkit.createForm(this);
		formToolkit.paintBordersFor(frmServiceDistribution);

		frmServiceDistribution.setText("Service Distribution");
		ColumnLayout cl = new ColumnLayout();
		cl.maxNumColumns = 2;
		frmServiceDistribution.getBody().setLayout(cl);

		Section sctnResourceProfiles = formToolkit.createSection(
				frmServiceDistribution.getBody(), Section.TWISTIE | Section.TITLE_BAR);
		formToolkit.paintBordersFor(sctnResourceProfiles);
		sctnResourceProfiles.setText("Distribution Resources");
		sctnResourceProfiles.setExpanded(true);

		Composite composite_2 = formToolkit.createComposite(
				sctnResourceProfiles, SWT.NONE);
		formToolkit.paintBordersFor(composite_2);
		sctnResourceProfiles.setClient(composite_2);
		composite_2.setLayout(new GridLayout(5, false));

		ImageHyperlink mghprlnkAdd = formToolkit.createImageHyperlink(
				composite_2, SWT.NONE);
		mghprlnkAdd.addHyperlinkListener(new IHyperlinkListener() {
			public void linkEntered(HyperlinkEvent e) {

			}

			public void linkExited(HyperlinkEvent e) {

			}

			public void linkActivated(HyperlinkEvent e) {
				
				List<NodeType> types = Lists.newArrayList();
				for(Node n : service.getNodes()){
					types.add(n.getNodeType());
				}
				types = modelUtils.uniqueNodeTypes(types);
				List<NetXResource> allResources = modelUtils.resourcesFromNodeTypes(types);
				
				NetXResourceFilterDialog netXResourceFilterDialog = new NetXResourceFilterDialog(
						ServiceDistributionScreen.this.getShell(), allResources);
				
				int result = netXResourceFilterDialog.open();
				if (result == Window.OK) {
					Object selected = netXResourceFilterDialog.getFirstResult();
					if (selected instanceof NetXResource) {
						// Create a new Entry.
						DistributionEntry entry = ServicesFactory.eINSTANCE
								.createDistributionEntry();
						DerivedResource derive = ServicesFactory.eINSTANCE
								.createDerivedResource();
						entry.setResourceRef((NetXResource) selected);
						entry.setDistribution(derive);
						entry.setResourceOrigin(ResourceOriginType.IN_BOUND);

						AddCommand ac = new AddCommand(editingService
								.getEditingDomain(), serviceDistribution
								.getDistributionEntries(), entry);
						editingService.getEditingDomain().getCommandStack()
								.execute(ac);

					}
				}

			}
		});
		mghprlnkAdd.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true,
				false, 5, 1));
		formToolkit.paintBordersFor(mghprlnkAdd);
		mghprlnkAdd.setText("Add");

		resourcesTableViewer = new TableViewer(composite_2, SWT.BORDER
				| SWT.FULL_SELECTION | SWT.MULTI);
		
		table = resourcesTableViewer.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		GridData gd_table = new GridData(SWT.FILL, SWT.FILL, true, true, 5, 1);
		gd_table.heightHint = 112;
		table.setLayoutData(gd_table);
		formToolkit.paintBordersFor(table);

		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(
				resourcesTableViewer, SWT.NONE);
		TableColumn tblclmnNode = tableViewerColumn_1.getColumn();
		tblclmnNode.setWidth(100);
		tblclmnNode.setText("Type");

		TableViewerColumn tableViewerColumn = new TableViewerColumn(
				resourcesTableViewer, SWT.NONE);
		TableColumn tblclmnName = tableViewerColumn.getColumn();
		tblclmnName.setWidth(150);
		tblclmnName.setText("Resource Name");
		
		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(
				resourcesTableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn = tableViewerColumn_2.getColumn();
		tblclmnNewColumn.setWidth(60);
		tblclmnNewColumn.setText("Origin");


		Menu resourcesMenu = new Menu(table);
		table.setMenu(resourcesMenu);

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


		ImageHyperlink imageHyperlink_2 = formToolkit.createImageHyperlink(
				composite_2, SWT.NONE);
		GridData gd_imageHyperlink_2 = new GridData(SWT.LEFT, SWT.CENTER,
				false, false, 1, 1);
		gd_imageHyperlink_2.widthHint = 18;
		imageHyperlink_2.setLayoutData(gd_imageHyperlink_2);
		imageHyperlink_2.setImage(ResourceManager.getPluginImage(
				"com.netxforge.netxstudio.models.edit",
				"icons/full/obj16/Expression_H.png"));
		formToolkit.paintBordersFor(imageHyperlink_2);
		imageHyperlink_2.setText("");

		@SuppressWarnings("unused")
		Label lblDistributionExpression = formToolkit.createLabel(composite_2,
				"Distribution", SWT.NONE);

		txtDistributionExpression = formToolkit.createText(composite_2,
				"New Text", SWT.READ_ONLY);
		GridData gd_txtDistributionExpression = new GridData(SWT.LEFT,
				SWT.CENTER, false, false, 1, 1);
		gd_txtDistributionExpression.widthHint = 150;
		txtDistributionExpression.setLayoutData(gd_txtDistributionExpression);
		txtDistributionExpression.setText("");

		ImageHyperlink imageHyperlink = formToolkit.createImageHyperlink(
				composite_2, SWT.NONE);
		imageHyperlink.addHyperlinkListener(new IHyperlinkListener() {
			public void linkActivated(HyperlinkEvent e) {

				if (serviceDistribution.getExpressionRefs() != null) {
					Command c = new SetCommand(
							editingService.getEditingDomain(),
							serviceDistribution,
							ServicesPackage.Literals.SERVICE_USER__EXPRESSION_REF,
							null);
					editingService.getEditingDomain().getCommandStack()
							.execute(c);
				}
			}

			public void linkEntered(HyperlinkEvent e) {
			}

			public void linkExited(HyperlinkEvent e) {
			}
		});
		imageHyperlink.setImage(ResourceManager.getPluginImage(
				"org.eclipse.ui", "/icons/full/etool16/delete.gif"));
		formToolkit.paintBordersFor(imageHyperlink);
		imageHyperlink.setText("");

		Button btnSelectDistributionExpression = formToolkit.createButton(
				composite_2, "Select", SWT.NONE);

		Section sctnMatrix = formToolkit.createSection(frmServiceDistribution.getBody(),
				Section.TWISTIE | Section.TITLE_BAR);
		ColumnLayoutData cld_sctnMatrix = new ColumnLayoutData();
		cld_sctnMatrix.heightHint = 230;
		sctnMatrix.setLayoutData(cld_sctnMatrix);
		formToolkit.paintBordersFor(sctnMatrix);
		sctnMatrix.setText("Matrix Definition");
		sctnMatrix.setExpanded(true);

		Composite composite = formToolkit.createComposite(sctnMatrix, SWT.NONE);
		formToolkit.paintBordersFor(composite);
		sctnMatrix.setClient(composite);
		composite.setLayout(new GridLayout(1, false));
		
		GridTableViewer gridTableViewer = new GridTableViewer(composite, SWT.BORDER);
		Grid grid = gridTableViewer.getGrid();
		GridData gd_grid = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_grid.heightHint = 200;
		grid.setLayoutData(gd_grid);
		formToolkit.paintBordersFor(grid);
		
		GridViewerColumn gridViewerColumn = new GridViewerColumn(gridTableViewer, SWT.NONE);
		GridColumn gridColumn = gridViewerColumn.getColumn();
		gridColumn.setWidth(100);
		gridColumn.setText("Node");
		btnSelectDistributionExpression
				.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						Resource expressionResource = editingService
								.getData(LibraryPackage.Literals.EXPRESSION);
						ExpressionFilterDialog dialog = new ExpressionFilterDialog(
								ServiceDistributionScreen.this.getShell(),
								expressionResource);
						if (dialog.open() == IDialogConstants.OK_ID) {
							Expression expression = (Expression) dialog
									.getFirstResult();
							Command c = new SetCommand(
									editingService.getEditingDomain(),
									serviceDistribution,
									ServicesPackage.Literals.SERVICE_DISTRIBUTION__EXPRESSION_REFS,
									expression);
							editingService.getEditingDomain().getCommandStack()
									.execute(c);
						}
					}
				});

		if (readonly) {

			// TODO, add other actions here.

		}

	}

	public EMFDataBindingContext initDataBindings_() {

		EMFDataBindingContext context = new EMFDataBindingContext();

		bindResourcesSection(context);

		return context;
	}

	public void bindResourcesSection(EMFDataBindingContext context) {
		IObservableValue capExpressionObservable = SWTObservables.observeText(
				this.txtDistributionExpression, SWT.Modify);

		IEMFValueProperty profileExpressionProperty = EMFEditProperties.value(
				editingService.getEditingDomain(), FeaturePath.fromList(
						ServicesPackage.Literals.SERVICE_USER__EXPRESSION_REF,
						LibraryPackage.Literals.EXPRESSION__NAME));

		context.bindValue(capExpressionObservable,
				profileExpressionProperty.observe(serviceDistribution), null,
				null);

		// binding of resources

		ObservableListContentProvider resourceListContentProvider = new ObservableListContentProvider();
		resourcesTableViewer.setContentProvider(resourceListContentProvider);

		IObservableMap[] observeResourceMaps = EMFObservables
				.observeMaps(
						resourceListContentProvider.getKnownElements(),
						new EStructuralFeature[] { ServicesPackage.Literals.SERVICE_DISTRIBUTION__DISTRIBUTION_ENTRIES });

		resourcesTableViewer
				.setLabelProvider(new DistributionEntryObservableMapLabelProvider(
						observeResourceMaps));
		IEMFListProperty resourcesListProperty = EMFEditProperties
				.list(editingService.getEditingDomain(),
						ServicesPackage.Literals.SERVICE_DISTRIBUTION__DISTRIBUTION_ENTRIES);
		resourcesTableViewer.setInput(resourcesListProperty
				.observe(serviceDistribution));
	}

	public class DistributionEntryObservableMapLabelProvider extends
			ObservableMapLabelProvider {

		public DistributionEntryObservableMapLabelProvider(
				IObservableMap[] attributeMaps) {
			super(attributeMaps);
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			if (element instanceof DistributionEntry) {
				DistributionEntry entry = (DistributionEntry) element;
				switch (columnIndex) {
				case 0: {
					if (entry
							.eIsSet(ServicesPackage.Literals.DISTRIBUTION_ENTRY__RESOURCE_REF)) {
						NetXResource resource = entry.getResourceRef();
						Node node = modelUtils.nodeFor(resource
								.getComponentRef());
						if (node != null) {
							return node.getNodeType().getName();
						}
					}
				}
					break;
				case 1: {
					if (entry
							.eIsSet(ServicesPackage.Literals.DISTRIBUTION_ENTRY__RESOURCE_REF)) {
						return entry.getResourceRef().getShortName();
					}

				}
					break;
				case 2: {
					if (entry
							.eIsSet(ServicesPackage.Literals.DISTRIBUTION_ENTRY__RESOURCE_ORIGIN)) {
						return entry.getResourceOrigin().toString();
					}
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
		return frmServiceDistribution;
	}

	public void injectData(Object owner, Object object) {

		if (object != null && object instanceof Service) {
			service = (RFSService) object;
			if (!service
					.eIsSet(ServicesPackage.Literals.SERVICE__SERVICE_DISTRIBUTION)) {
				service.setServiceDistribution(ServicesFactory.eINSTANCE
						.createServiceDistribution());

			}
			serviceDistribution = service.getServiceDistribution();
		} else {
			throw new java.lang.IllegalArgumentException(
					"Data injection for screen invalid");
		}
		
		// Print the service distribution matrix. 
		Node[][] matrix = modelUtils.matrix(service.getNodes());
		modelUtils.printMatrix(matrix);
		
		buildUI();
		this.initDataBindings_();

	}

	public void addData() {
		if (ScreenUtil.isEditOperation(getOperation())) {
			// If edit, we have been operating on a copy of the object, so we
			// have to replace. However if our original object is invalid, this
			// will
			// cause invalidity, so the action will not occure in case the
			// original is
			// invalid, and we should cancel the action and warn the user.
			if (serviceDistribution.cdoInvalid()) {
				MessageDialog
						.openWarning(Display.getDefault().getActiveShell(),
								"Conflict",
								"There is a conflict with another user. Your changes can't be saved.");
				return;
			}
			System.out.println(serviceDistribution.cdoID() + ""
					+ serviceDistribution.cdoState());

		}
		// After our edit, we shall be dirty
		if (editingService.isDirty()) {
			editingService.doSave(new NullProgressMonitor());
		}

	}
}
