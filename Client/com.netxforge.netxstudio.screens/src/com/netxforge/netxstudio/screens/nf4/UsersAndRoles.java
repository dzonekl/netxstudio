package com.netxforge.netxstudio.screens.nf4;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
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
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.wb.swt.ResourceManager;

import com.google.inject.Inject;
import com.netxforge.netxstudio.Netxstudio;
import com.netxforge.netxstudio.NetxstudioFactory;
import com.netxforge.netxstudio.NetxstudioPackage;
import com.netxforge.netxstudio.generics.GenericsFactory;
import com.netxforge.netxstudio.generics.GenericsPackage.Literals;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.SearchFilter;
import com.netxforge.netxstudio.screens.editing.selector.IDataServiceInjection;
import com.netxforge.netxstudio.screens.editing.selector.Screens;

public class UsersAndRoles extends AbstractScreen implements
		IDataServiceInjection {
	@SuppressWarnings("unused")
	private EMFDataBindingContext m_bindingContext;

	private Netxstudio studio;

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());

	private Table table;
	private Text txtTableFilter;

	private TableViewer tableViewer;
	private Form frmUsersAndRoles;

	@Inject
	private SearchFilter searchFilter;

	public UsersAndRoles(Composite parent, int style) {
		super(parent, style);
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
				disposeData();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
		setLayout(new FillLayout(SWT.HORIZONTAL));

		frmUsersAndRoles = toolkit.createForm(this);
		frmUsersAndRoles.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmUsersAndRoles);
		frmUsersAndRoles.setText("Users and Roles");
		frmUsersAndRoles.getBody().setLayout(new GridLayout(3, false));

		Label lblNewLabel = toolkit.createLabel(frmUsersAndRoles.getBody(),
				"Filter:", SWT.NONE);
		lblNewLabel.setAlignment(SWT.RIGHT);
		GridData gd_lblNewLabel = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblNewLabel.widthHint = 36;
		lblNewLabel.setLayoutData(gd_lblNewLabel);

		// Filter.
		txtTableFilter = toolkit.createText(frmUsersAndRoles.getBody(),
				"New Text", SWT.H_SCROLL | SWT.SEARCH | SWT.CANCEL);
		GridData gd_txtTableFilter = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_txtTableFilter.widthHint = 200;
		txtTableFilter.setLayoutData(gd_txtTableFilter);
		txtTableFilter.setText("");

		txtTableFilter.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent ke) {
				tableViewer.refresh();
				ViewerFilter[] filters = tableViewer.getFilters();
				for (ViewerFilter viewerFilter : filters) {
					if (viewerFilter instanceof SearchFilter) {
						((SearchFilter) viewerFilter)
								.setSearchText(txtTableFilter.getText());
					}
				}
			}
		});

		// Conditional widget.
		if (!Screens.isReadOnlyOperation(this.getOperation())) {
			ImageHyperlink mghprlnkNew = toolkit.createImageHyperlink(
					frmUsersAndRoles.getBody(), SWT.NONE);
			mghprlnkNew.addHyperlinkListener(new IHyperlinkListener() {
				public void linkActivated(HyperlinkEvent e) {
					if (screenService != null) {
						NewEditUser user = new NewEditUser(screenService
								.getScreenContainer(), SWT.NONE);
						user.setOperation(Screens.OPERATION_NEW);
						screenService.setActiveScreen(user);
						user.injectData(studio,
								GenericsFactory.eINSTANCE.createPerson());
					}
				}

				public void linkEntered(HyperlinkEvent e) {
				}

				public void linkExited(HyperlinkEvent e) {
				}
			});
			mghprlnkNew.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
					false, false, 1, 1));
			mghprlnkNew.setImage(ResourceManager.getPluginImage(
					"com.netxforge.netxstudio.models.edit",
					"icons/full/ctool16/User_E.png"));
			mghprlnkNew.setBounds(0, 0, 114, 17);
			toolkit.paintBordersFor(mghprlnkNew);
			mghprlnkNew.setText("New");

		}
		new Label(frmUsersAndRoles.getBody(), SWT.NONE);

		tableViewer = new TableViewer(frmUsersAndRoles.getBody(), SWT.BORDER
				| SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));
		toolkit.paintBordersFor(table);

		TableViewerColumn tableViewerColumn = new TableViewerColumn(
				tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn = tableViewerColumn.getColumn();
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("First Name");

		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(
				tableViewer, SWT.NONE);
		TableColumn tblclmnLocationUrl = tableViewerColumn_1.getColumn();
		tblclmnLocationUrl.setWidth(100);
		tblclmnLocationUrl.setText("Last Name");

		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(
				tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_1 = tableViewerColumn_2.getColumn();
		tblclmnNewColumn_1.setWidth(100);
		tblclmnNewColumn_1.setText("Login");

		Menu menu = new Menu(table);
		table.setMenu(menu);

		MenuItem mntmEdit = new MenuItem(menu, SWT.NONE);
		mntmEdit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (screenService != null) {
					ISelection selection = getTableViewerWidget()
							.getSelection();
					if (selection instanceof IStructuredSelection) {
						Object o = ((IStructuredSelection) selection)
								.getFirstElement();
						NewEditUser u = new NewEditUser(screenService
								.getScreenContainer(), SWT.NONE);
						u.setOperation(Screens.OPERATION_EDIT);
						u.injectData(studio, o);
						screenService.setActiveScreen(u);
					}
				}
			}
		});

		mntmEdit.setText("Edit...");

		MenuItem mntmHistory = new MenuItem(menu, SWT.NONE);
		mntmHistory.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (screenService != null) {
					ISelection selection = getTableViewerWidget()
							.getSelection();
					if (selection instanceof IStructuredSelection) {
						Object o = ((IStructuredSelection) selection)
								.getFirstElement();
						UserActivity u = new UserActivity(screenService
								.getScreenContainer(), SWT.NONE);
						u.setOperation(Screens.OPERATION_READ_ONLY);
						u.injectData(studio.getUsers(), o);
						screenService.setActiveScreen(u);
					}
				}
			}
		});
		mntmHistory.setText("History...");

		TableViewerColumn tableViewerColumn_3 = new TableViewerColumn(
				tableViewer, SWT.NONE);
		TableColumn tblclmnEmail = tableViewerColumn_3.getColumn();
		tblclmnEmail.setWidth(100);
		tblclmnEmail.setText("Email");

		tableViewer.addFilter(searchFilter);

		if (editingService != null) {
			injectData();
		}

	}

	public TableViewer getTableViewerWidget() {
		return tableViewer;
	}

	public Table getTableWidget() {
		return table;
	}

	public EMFDataBindingContext initDataBindings_() {

		EMFDataBindingContext bindingContext = new EMFDataBindingContext();
		//
		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		tableViewer.setContentProvider(listContentProvider);
		//
		IObservableMap[] observeMaps = EMFObservables.observeMaps(
				listContentProvider.getKnownElements(),
				new EStructuralFeature[] { Literals.PERSON__FIRST_NAME,
						Literals.PERSON__LAST_NAME, Literals.PERSON__LOGIN,
						Literals.PERSON__EMAIL });
		tableViewer
				.setLabelProvider(new ObservableMapLabelProvider(observeMaps));

		IEMFListProperty l = EMFEditProperties.list(
				editingService.getEditingDomain(),
				NetxstudioPackage.Literals.NETXSTUDIO__USERS);

		tableViewer.setInput(l.observe(studio));
		return bindingContext;
	}

	protected DataBindingContext initDataBindings() {

		DataBindingContext bindingContext = new DataBindingContext();
		//
		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		tableViewer.setContentProvider(listContentProvider);
		//
		IObservableMap[] observeMaps = EMFObservables.observeMaps(
				listContentProvider.getKnownElements(),
				new EStructuralFeature[] { Literals.PERSON__FIRST_NAME,
						Literals.PERSON__LAST_NAME, Literals.PERSON__LOGIN,
						Literals.PERSON__EMAIL });
		tableViewer
				.setLabelProvider(new ObservableMapLabelProvider(observeMaps));

		IObservableList studioUsersObserveList = EMFObservables.observeList(
				Realm.getDefault(), studio,
				NetxstudioPackage.Literals.NETXSTUDIO__USERS);

		tableViewer.setInput(studioUsersObserveList);
		//
		return bindingContext;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.data.IDataInjection#injectData()
	 */
	public void injectData() {
		Resource res = editingService
				.getData(NetxstudioPackage.Literals.NETXSTUDIO);
		if (res.getContents().size() == 0) {
			Netxstudio netx = NetxstudioFactory.eINSTANCE.createNetxstudio();
			res.getContents().add(netx);
			studio = netx;
		} else {
			studio = (Netxstudio) res.getContents().get(0);
		}
		m_bindingContext = initDataBindings_();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.common.ui.viewer.IViewerProvider#getViewer()
	 */
	public Viewer getViewer() {

		return this.getTableViewerWidget();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.data.IDataServiceInjection#disposeData()
	 */
	public void disposeData() {
		if (editingService != null) {
			editingService.disposeData();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.screens.editing.selector.IScreen#isValid()
	 */
	public boolean isValid() {
		return true;
	}

	@Override
	public Form getScreenForm() {
		return frmUsersAndRoles;
	}

	@Override
	public void setOperation(int operation) {
		this.operation = operation;

	}
}
