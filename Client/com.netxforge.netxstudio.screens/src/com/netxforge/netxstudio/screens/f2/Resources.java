package com.netxforge.netxstudio.screens.f2;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
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
import org.eclipse.swt.graphics.Image;
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
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.wb.swt.ResourceManager;

import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.library.LibraryFactory;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.editing.selector.IDataServiceInjection;
import com.netxforge.netxstudio.screens.editing.selector.Screens;

public class Resources extends AbstractScreen implements IDataServiceInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Table table;
	private Text txtFilterText;

	private TableViewer resourcesTableViewer;
	private Form frmResources;
	private Resource resourcesResource;

	@Inject
	ModelUtils modelUtils;
	private TableViewerColumn tblViewerClmnState;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public Resources(Composite parent, int style) {
		super(parent, style);
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
				obm.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
		setLayout(new FillLayout(SWT.HORIZONTAL));

		frmResources = toolkit.createForm(this);
		frmResources.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmResources);
		frmResources.setText("Resources");
		frmResources.getBody().setLayout(new GridLayout(3, false));

		Label lblFilterLabel = toolkit.createLabel(frmResources.getBody(),
				"Filter:", SWT.NONE);
		GridData gd_lblFilterLabel = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblFilterLabel.widthHint = 44;
		lblFilterLabel.setLayoutData(gd_lblFilterLabel);

		txtFilterText = toolkit.createText(frmResources.getBody(),
				"New Text", SWT.H_SCROLL | SWT.SEARCH | SWT.CANCEL);
		txtFilterText.setText("");
		GridData gd_txtFilterText = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_txtFilterText.widthHint = 200;
		txtFilterText.setLayoutData(gd_txtFilterText);

		ImageHyperlink mghprlnkNew = toolkit.createImageHyperlink(
				frmResources.getBody(), SWT.NONE);
		mghprlnkNew.addHyperlinkListener(new IHyperlinkListener() {
			public void linkActivated(HyperlinkEvent e) {
				if (screenService != null) {
					NewEditResource resourceScreen = new NewEditResource(screenService
							.getScreenContainer(), SWT.NONE);
					resourceScreen.setOperation(Screens.OPERATION_NEW);
					resourceScreen.setScreenService(screenService);
					screenService.setActiveScreen(resourceScreen);
					resourceScreen.injectData(resourcesResource,
							LibraryFactory.eINSTANCE.createNetXResource());
				}

			}

			public void linkEntered(HyperlinkEvent e) {
			}

			public void linkExited(HyperlinkEvent e) {
			}
		});
		mghprlnkNew.setImage(ResourceManager.getPluginImage("com.netxforge.netxstudio.models.edit", "icons/full/ctool16/Equipment_E.png"));
		mghprlnkNew.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		toolkit.paintBordersFor(mghprlnkNew);
		mghprlnkNew.setText("New");

		resourcesTableViewer = new TableViewer(frmResources.getBody(),
				SWT.BORDER | SWT.FULL_SELECTION);
		table = resourcesTableViewer.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 4));
		toolkit.paintBordersFor(table);

		TableViewerColumn tblViewerClmType = new TableViewerColumn(
				resourcesTableViewer, SWT.NONE);
		TableColumn tblclmnJobType = tblViewerClmType.getColumn();
		tblclmnJobType.setWidth(76);
		tblclmnJobType.setText("Short Name");

		TableViewerColumn tableViewerColumn = new TableViewerColumn(
				resourcesTableViewer, SWT.NONE);
		TableColumn tblclmnName = tableViewerColumn.getColumn();
		tblclmnName.setWidth(104);
		tblclmnName.setText("Expression Name");

		tblViewerClmnState = new TableViewerColumn(resourcesTableViewer, SWT.NONE);
		TableColumn tblclmnState = tblViewerClmnState.getColumn();
		tblclmnState.setWidth(207);
		tblclmnState.setText("Long Name");

		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(
				resourcesTableViewer, SWT.NONE);
		TableColumn tblclmnStarttime = tableViewerColumn_2.getColumn();
		tblclmnStarttime.setWidth(68);
		tblclmnStarttime.setText("Unit");

		Menu menu = new Menu(table);
		table.setMenu(menu);

		MenuItem mntmEdit = new MenuItem(menu, SWT.NONE);
		mntmEdit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				ISelection selection = getViewer().getSelection();
				if (selection instanceof IStructuredSelection) {
					Object o = ((IStructuredSelection) selection)
							.getFirstElement();
					NewEditResource job = new NewEditResource(screenService
							.getScreenContainer(), SWT.NONE);
					job.setOperation(Screens.OPERATION_EDIT);
					screenService.setActiveScreen(job);
					job.injectData(resourcesResource, o);
				}
			}
		});
		mntmEdit.setText("Edit...");

		MenuItem mntmRuns = new MenuItem(menu, SWT.NONE);
		mntmRuns.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ISelection selection = getViewer().getSelection();
				if (selection instanceof IStructuredSelection) {
					Object o = ((IStructuredSelection) selection)
							.getFirstElement();
					if(o instanceof NetXResource){
						ResourceMonitor monitorScreen = new ResourceMonitor(screenService.getScreenContainer(), SWT.NONE);
						monitorScreen.setOperation(Screens.OPERATION_READ_ONLY);
						monitorScreen.setScreenService(screenService);
						monitorScreen.injectData(null, o);
						screenService.setActiveScreen(monitorScreen);
					}
				}
			}
		});
		mntmRuns.setText("Monitor...");

		if (editingService != null) {
			injectData();
		}

	}


	public EMFDataBindingContext initDataBindings_() {
		EMFDataBindingContext bindingContext = new EMFDataBindingContext();

		// tblViewerClmnState.setEditingSupport(new CheckBoxEditingSupport(
		// jobsTableViewer, bindingContext));

		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		resourcesTableViewer.setContentProvider(listContentProvider);

		EAttribute dummyAttribute = EcoreFactory.eINSTANCE.createEAttribute();
		
		IObservableMap[] observeMaps = EMFObservables.observeMaps(
				listContentProvider.getKnownElements(),
				new EStructuralFeature[] {dummyAttribute,
						LibraryPackage.Literals.NET_XRESOURCE__SHORT_NAME,
						LibraryPackage.Literals.NET_XRESOURCE__EXPRESSION_NAME,
						LibraryPackage.Literals.NET_XRESOURCE__LONG_NAME,
						LibraryPackage.Literals.NET_XRESOURCE__UNIT_REF,
						});
		resourcesTableViewer.setLabelProvider(new NetXResourceObervableMapLabelProvider(
				observeMaps));

		IEMFListProperty resourcesProperties = EMFEditProperties
				.resource(editingService.getEditingDomain());
		IObservableList resourceList = resourcesProperties.observe(resourcesResource);
		obm.addObservable(resourceList);
		resourcesTableViewer.setInput(resourceList);

		return bindingContext;
	}

	class NetXResourceObervableMapLabelProvider extends ObservableMapLabelProvider {

		public NetXResourceObervableMapLabelProvider(IObservableMap[] attributeMaps) {
			super(attributeMaps);
		}

		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			return super.getColumnImage(element, columnIndex);
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			if (element instanceof NetXResource) {
				NetXResource j = (NetXResource) element;
				switch (columnIndex) {
				case 3:
					if (j.getUnitRef() != null) {
						return j.getUnitRef().getCode();
					}
					break;
				}
			}
			return super.getColumnText(element, columnIndex);
		}
	}

	public void injectData() {
		resourcesResource = editingService.getData(LibraryPackage.Literals.NET_XRESOURCE);
		initDataBindings_();
	}

	public void disposeData() {
		editingService.disposeData(resourcesResource);
	}

	@Override
	public Viewer getViewer() {
		return resourcesTableViewer;
	}

	@Override
	public boolean isValid() {
		return true;
	}

	@Override
	public Form getScreenForm() {
		return frmResources;
	}

	@Override
	public void setOperation(int operation) {
		this.operation = operation;

	}

}
