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

import com.netxforge.netxstudio.library.Expression;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.ExpressionFilterDialog;
import com.netxforge.netxstudio.screens.editing.selector.IDataScreenInjection;
import com.netxforge.netxstudio.screens.editing.selector.Screens;
import com.netxforge.netxstudio.services.ServiceDistribution;
import com.netxforge.netxstudio.services.ServicesPackage;

public class ServiceDistributionScreen extends AbstractScreen implements
		IDataScreenInjection {
	private final FormToolkit formToolkit = new FormToolkit(
			Display.getDefault());
	private Form frmService;
	private ServiceDistribution serviceDistribution;
	private Resource owner;
	private Table table;
	private Text txtProfileExpression;
	private TableViewer resourcesTableViewer;

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
		boolean readonly = Screens.isReadOnlyOperation(this.getOperation());
		
		@SuppressWarnings("unused")
		String actionText = readonly ? "View: " : "Edit: ";
		@SuppressWarnings("unused")
		int widgetStyle = readonly ? SWT.READ_ONLY : SWT.NONE;

		frmService = formToolkit.createForm(this);
		formToolkit.paintBordersFor(frmService);

		frmService.setText("Service Distribution");
		ColumnLayout cl = new ColumnLayout();
		cl.maxNumColumns = 2;
		frmService.getBody().setLayout(cl);

		Section sctnResourceProfiles = formToolkit.createSection(
				frmService.getBody(), Section.TWISTIE | Section.TITLE_BAR);
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
				
				// TODO, Add resources from an existing Node. 
				// The resources are linked to, for each resource, we 
				// keep a shadow resource which we populate. 
				
				
				
				
//				NewEditServiceProfileResource resourceScreen = new NewEditServiceProfileResource(
//						screenService.getScreenContainer(), SWT.NONE);
//				resourceScreen.setOperation(Screens.OPERATION_NEW);
//				resourceScreen.setScreenService(screenService);
//				resourceScreen.injectData(serviceDistribution.getServiceProfile(),
//						ServicesFactory.eINSTANCE
//								.createServiceProfileResource());
//				screenService.setActiveScreen(resourceScreen);
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
		
		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(resourcesTableViewer, SWT.NONE);
		TableColumn tblclmnNode = tableViewerColumn_1.getColumn();
		tblclmnNode.setWidth(100);
		tblclmnNode.setText("Node");

		TableViewerColumn tableViewerColumn = new TableViewerColumn(
				resourcesTableViewer, SWT.NONE);
		TableColumn tblclmnName = tableViewerColumn.getColumn();
		tblclmnName.setWidth(100);
		tblclmnName.setText("Name");

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
		Label lblCapacityExpression = formToolkit.createLabel(composite_2,
				"Distribution", SWT.NONE);

		txtProfileExpression = formToolkit.createText(composite_2, "New Text",
				SWT.READ_ONLY);
		GridData gd_txtCapExpression = new GridData(SWT.LEFT, SWT.CENTER,
				false, false, 1, 1);
		gd_txtCapExpression.widthHint = 150;
		txtProfileExpression.setLayoutData(gd_txtCapExpression);
		txtProfileExpression.setText("");

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

		Button btnSelectCapExpression = formToolkit.createButton(composite_2,
				"Select", SWT.NONE);
		
		Section sctnMatrix = formToolkit.createSection(frmService.getBody(), Section.TWISTIE | Section.TITLE_BAR);
		ColumnLayoutData cld_sctnMatrix = new ColumnLayoutData();
		cld_sctnMatrix.heightHint = 230;
		sctnMatrix.setLayoutData(cld_sctnMatrix);
		formToolkit.paintBordersFor(sctnMatrix);
		sctnMatrix.setText("Matrix Definition");
		sctnMatrix.setExpanded(true);
		
		Composite composite = formToolkit.createComposite(sctnMatrix, SWT.NONE);
		formToolkit.paintBordersFor(composite);
		sctnMatrix.setClient(composite);
		btnSelectCapExpression.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Resource expressionResource = editingService
						.getData(LibraryPackage.Literals.EXPRESSION);
				ExpressionFilterDialog dialog = new ExpressionFilterDialog(
						ServiceDistributionScreen.this.getShell(), expressionResource);
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
				this.txtProfileExpression, SWT.Modify);

		IEMFValueProperty profileExpressionProperty = EMFEditProperties
				.value(editingService.getEditingDomain(),
						FeaturePath
								.fromList(
										ServicesPackage.Literals.SERVICE_USER__EXPRESSION_REF,
										LibraryPackage.Literals.EXPRESSION__NAME));

		context.bindValue(capExpressionObservable,
				profileExpressionProperty.observe(serviceDistribution), null, null);
		
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
				ServicesPackage.Literals.SERVICE_DISTRIBUTION__DISTRIBUTION_REFS);
		resourcesTableViewer.setInput(resourcesListProperty.observe(serviceDistribution));
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

		if (object != null && object instanceof ServiceDistribution) {
			serviceDistribution = (ServiceDistribution) object;
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
					owner.getContents(), serviceDistribution);
			editingService.getEditingDomain().getCommandStack().execute(ac);

			// We can't add this resource now, we need a referee.
		} else if (Screens.isEditOperation(getOperation())) {
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