package com.netxforge.netxstudio.screens.f4;

import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
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
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;

import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.editing.selector.IDataServiceInjection;

public class MetricSources extends AbstractScreen implements IDataServiceInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Table table;
	private Text txtFilterText;
	private Form frmMetricSources;
	
	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public MetricSources(Composite parent, int style) {
		super(parent, style);
		
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
		setLayout(new FillLayout(SWT.HORIZONTAL));
		
		frmMetricSources = toolkit.createForm(this);
		frmMetricSources.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmMetricSources);
		frmMetricSources.setText("Metric Sources");
		frmMetricSources.getBody().setLayout(new GridLayout(2, false));
		
		Label lblFilterLabel = toolkit.createLabel(frmMetricSources.getBody(), "Filter:", SWT.NONE);
		lblFilterLabel.setAlignment(SWT.RIGHT);
		GridData gd_lblFilterLabel = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_lblFilterLabel.widthHint = 70;
		lblFilterLabel.setLayoutData(gd_lblFilterLabel);
		
		txtFilterText = toolkit.createText(frmMetricSources.getBody(), "New Text", SWT.H_SCROLL | SWT.SEARCH | SWT.CANCEL);
		txtFilterText.setText("");
		txtFilterText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(frmMetricSources.getBody(), SWT.NONE);
		
		TableViewer tableViewer = new TableViewer(frmMetricSources.getBody(), SWT.BORDER | SWT.FULL_SELECTION);
		table = tableViewer.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 4));
		toolkit.paintBordersFor(table);
		
		TableViewerColumn tableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn = tableViewerColumn.getColumn();
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("Name");
		
		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnLocationUrl = tableViewerColumn_1.getColumn();
		tblclmnLocationUrl.setWidth(100);
		tblclmnLocationUrl.setText("Location URL");
		
		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(tableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_1 = tableViewerColumn_2.getColumn();
		tblclmnNewColumn_1.setWidth(100);
		tblclmnNewColumn_1.setText("Statistics");
		
		Menu menu = new Menu(table);
		table.setMenu(menu);
		
		MenuItem mntmScheduleCollectionJob = new MenuItem(menu, SWT.NONE);
		mntmScheduleCollectionJob.setText("Schedule Collection Job...");
		
		MenuItem mntmCollectNow = new MenuItem(menu, SWT.NONE);
		mntmCollectNow.setText("Collect Now");
		
		MenuItem mntmDeleteCollection = new MenuItem(menu, SWT.NONE);
		mntmDeleteCollection.setText("Delete Collection...");
		
		Button btnAddButton = toolkit.createButton(frmMetricSources.getBody(), "+", SWT.NONE);
		GridData gd_btnAddButton = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_btnAddButton.widthHint = 18;
		gd_btnAddButton.heightHint = 18;
		btnAddButton.setLayoutData(gd_btnAddButton);
		
		Button btnRemoveButton_1 = toolkit.createButton(frmMetricSources.getBody(), "-", SWT.NONE);
		GridData gd_btnRemoveButton_1 = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
		gd_btnRemoveButton_1.widthHint = 18;
		gd_btnRemoveButton_1.heightHint = 18;
		btnRemoveButton_1.setLayoutData(gd_btnRemoveButton_1);
		new Label(frmMetricSources.getBody(), SWT.NONE);
	}

	public Viewer getViewer() {
		// TODO Auto-generated method stub
		return null;
	}

	public void injectData() {
//		Resource res = editingService.getData(OperatorsPackage.NETXSTUDIO);
//		if (res.getContents().size() == 0) {
//			Netxstudio netx = NetxstudioFactory.eINSTANCE.createNetxstudio();
//			res.getContents().add(netx);
//			studio = netx;
//		} else {
//			studio = (Netxstudio) res.getContents().get(0);
//		}
//		m_bindingContext = initDataBindings_();
	}
	
	
	public EMFDataBindingContext initDataBindings_() {

		EMFDataBindingContext bindingContext = new EMFDataBindingContext();
//		//
//		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
//		tableViewer.setContentProvider(listContentProvider);
//		//
//		IObservableMap[] observeMaps = EMFObservables.observeMaps(
//				listContentProvider.getKnownElements(),
//				new EStructuralFeature[] { MetricsPackage.Literals.METRIC_SOURCE__NAME,
//						Literals.PERSON__LAST_NAME, Literals.PERSON__LOGIN,
//						Literals.PERSON__EMAIL });
//		tableViewer
//				.setLabelProvider(new ObservableMapLabelProvider(observeMaps));
//
//		IEMFListProperty l = EMFEditProperties.list(
//				editingService.getEditingDomain(),
//				NetxstudioPackage.Literals.NETXSTUDIO__USERS);
//
//		tableViewer.setInput(l.observe(studio));
		return bindingContext;
	}

	
	public void disposeData() {
		if (editingService != null) {
			editingService.disposeData();
		}		
	}
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public Form getScreenForm() {
		return this.frmMetricSources;
	}
}
