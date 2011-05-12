package com.netxforge.netxstudio.screens.nf4;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
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
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.wb.swt.ResourceManager;

import com.google.inject.Inject;
import com.netxforge.netxstudio.Netxstudio;
import com.netxforge.netxstudio.NetxstudioPackage;
import com.netxforge.netxstudio.data.IDataService;
import com.netxforge.netxstudio.data.IDataServiceInjection;
import com.netxforge.netxstudio.data.internal.DataActivator;
import com.netxforge.netxstudio.generics.GenericsFactory;
import com.netxforge.netxstudio.generics.GenericsPackage.Literals;
import com.netxforge.netxstudio.screens.editing.IEditingService;
import com.netxforge.netxstudio.screens.selector.IScreenFormService;
import com.netxforge.netxstudio.screens.selector.Screens;

public class UsersAndRoles extends Composite implements IDataServiceInjection {
	@SuppressWarnings("unused")
	private DataBindingContext m_bindingContext;

	private Netxstudio studio;

	@Inject
	private IDataService dataService;
	
	private IEditingService editingService;

	private IScreenFormService screenService;
	
	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());

	private Table table;
	private Text txtNewText;

	private TableViewer tableViewer;

	public UsersAndRoles(Composite parent, int style) {
		this(parent, style, null, null);
	}

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public UsersAndRoles(Composite parent, int style,
			IScreenFormService sService, IEditingService eService) {
		super(parent, SWT.BORDER);

		this.screenService = sService;
		this.editingService = eService;
		
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
		setLayout(new FillLayout(SWT.HORIZONTAL));

		Form frmMetricSources = toolkit.createForm(this);
		frmMetricSources.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmMetricSources);
		frmMetricSources.setText("Users and Roles");
		frmMetricSources.getBody().setLayout(new GridLayout(3, false));

		Label lblNewLabel = toolkit.createLabel(frmMetricSources.getBody(),
				"Filter:", SWT.NONE);
		lblNewLabel.setAlignment(SWT.RIGHT);
		GridData gd_lblNewLabel = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblNewLabel.widthHint = 36;
		lblNewLabel.setLayoutData(gd_lblNewLabel);

		txtNewText = toolkit.createText(frmMetricSources.getBody(), "New Text",
				SWT.H_SCROLL | SWT.SEARCH | SWT.CANCEL);
		GridData gd_txtNewText = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_txtNewText.widthHint = 200;
		txtNewText.setLayoutData(gd_txtNewText);
		txtNewText.setText("");

		ImageHyperlink mghprlnkNew = toolkit.createImageHyperlink(
				frmMetricSources.getBody(), SWT.NONE);
		mghprlnkNew.addHyperlinkListener(new IHyperlinkListener() {
			public void linkActivated(HyperlinkEvent e) {
				if (screenService != null) {
					NewEditUser user = new NewEditUser(screenService
							.getScreenContainer(), SWT.NONE | Screens.NEW, editingService);
					screenService.setActiveScreen(user);
					user.injectData(studio.getUsers(), GenericsFactory.eINSTANCE.createPerson());
				}
			}

			public void linkEntered(HyperlinkEvent e) {
			}

			public void linkExited(HyperlinkEvent e) {
			}
		});
		mghprlnkNew.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		mghprlnkNew.setImage(ResourceManager.getPluginImage(
				"com.netxforge.netxstudio.models.edit",
				"icons/full/obj16/User_H.png"));
		mghprlnkNew.setBounds(0, 0, 114, 17);
		toolkit.paintBordersFor(mghprlnkNew);
		mghprlnkNew.setText("New");

		tableViewer = new TableViewer(frmMetricSources.getBody(), SWT.BORDER
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
					ISelection selection = getTableViewerWidget().getSelection();
					if(selection instanceof IStructuredSelection){
						Object o = ((IStructuredSelection)selection).getFirstElement();
						NewEditUser u = new NewEditUser(screenService
								.getScreenContainer(), SWT.NONE | Screens.EDIT, editingService);
						u.injectData(studio.getUsers(), o);
						screenService.setActiveScreen(u);
					}
					
				}
			}
		});
		mntmEdit.setText("Edit...");

		TableViewerColumn tableViewerColumn_3 = new TableViewerColumn(
				tableViewer, SWT.NONE);
		TableColumn tblclmnEmail = tableViewerColumn_3.getColumn();
		tblclmnEmail.setWidth(100);
		tblclmnEmail.setText("Email");
		injectData();
		
	}

	public TableViewer getTableViewerWidget() {
		return tableViewer;
	}

	public Table getTableWidget() {
		return table;
	}

	protected DataBindingContext initDataBindings_() {

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
		
		IEMFListProperty l = EMFEditProperties.list(editingService.getEditingDomain(), NetxstudioPackage.Literals.NETXSTUDIO__USERS);
		
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
	@Override
	public void injectData() {
		DataActivator.getInjector().injectMembers(this);
		studio = dataService.getProvider().getNetXStudio(editingService.getEditingDomain().getResourceSet());
		// call initbindings.
		m_bindingContext = initDataBindings_();
	}
	
}
