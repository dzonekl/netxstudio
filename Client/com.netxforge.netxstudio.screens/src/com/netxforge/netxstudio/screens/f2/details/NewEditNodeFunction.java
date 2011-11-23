package com.netxforge.netxstudio.screens.f2.details;

import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.databinding.IEMFValueProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.Section;

import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.operators.Relationship;
import com.netxforge.netxstudio.screens.editing.IEditingService;
import com.netxforge.netxstudio.screens.editing.selector.IScreen;
import com.netxforge.netxstudio.screens.editing.selector.Screens;

public class NewEditNodeFunction extends NewEditComponent implements IScreen {

	private Text txtName;
	private Text txtDescription;
	private TableViewer linksTableViewer;

	public NewEditNodeFunction(Composite parent, int style,
			final IEditingService editingService) {
		super(parent, style, editingService);
		// buildUI();
	}

	public boolean isValid() {
		return false;
	}

	public void buildUI() {

		// Readonlyness.
		boolean readonly = Screens.isReadOnlyOperation(this.getOperation());
		int widgetStyle = readonly ? SWT.READ_ONLY : SWT.NONE;

		buildInfoSection(widgetStyle);
		buildLinksSection(readonly);
		buildLifeCycleSection(readonly);
		buildResourceSection(readonly);
		buildMetricSection(readonly);
		buildToleranceSection(readonly);
		
	}

	private void buildInfoSection(int widgetStyle) {
		Section scnInfo = toolkit.createSection(this, Section.EXPANDED
				| Section.TITLE_BAR);

		toolkit.paintBordersFor(scnInfo);
		scnInfo.setText("Info");

		Composite composite = toolkit.createComposite(scnInfo, SWT.NONE);
		toolkit.paintBordersFor(composite);
		scnInfo.setClient(composite);
		composite.setLayout(new GridLayout(2, false));

		Label lblName = toolkit.createLabel(composite, "Name:", SWT.NONE);
		lblName.setAlignment(SWT.RIGHT);
		GridData gd_lblName = new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1);
		gd_lblName.widthHint = 70;
		lblName.setLayoutData(gd_lblName);

		txtName = toolkit.createText(composite, "New Text", SWT.NONE
				| widgetStyle);
		txtName.setText("");
		GridData gd_txtName = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_txtName.widthHint = 200;
		txtName.setLayoutData(gd_txtName);

		Label lblDescription = toolkit.createLabel(composite, "Description:",
				SWT.NONE);
		lblDescription.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false,
				false, 1, 1));
		lblDescription.setAlignment(SWT.RIGHT);

		txtDescription = toolkit.createText(composite, "New Text", SWT.BORDER
				| SWT.WRAP | SWT.MULTI | widgetStyle);
		txtDescription.setText("");
		GridData gd_text = new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1);
		gd_text.heightHint = 62;
		gd_text.widthHint = 200;
		txtDescription.setLayoutData(gd_text);
	}

	private void buildLinksSection(boolean readonly) {
		// TODO Auto-generated method stub

		Section sctnLinks = toolkit.createSection(this, Section.TWISTIE
				| Section.TITLE_BAR);

		toolkit.paintBordersFor(sctnLinks);
		sctnLinks.setText("Links");
		sctnLinks.setExpanded(false);

		Composite cmpMetrics = toolkit.createComposite(sctnLinks, SWT.NONE);
		toolkit.paintBordersFor(cmpMetrics);
		sctnLinks.setClient(cmpMetrics);
		cmpMetrics.setLayout(new GridLayout(1, false));

		// ImageHyperlink hypLnkAddMetric = toolkit.createImageHyperlink(
		// cmpMetrics, SWT.NONE);
		// hypLnkAddMetric.addHyperlinkListener(new IHyperlinkListener() {
		// public void linkActivated(HyperlinkEvent e) {
		// Resource metriceResource = editingService
		// .getData(MetricsPackage.Literals.METRIC);
		//
		// MetricFilterDialog dialog = new MetricFilterDialog(
		// NewEditComponent.this.getShell(), metriceResource);
		// if (dialog.open() == IDialogConstants.OK_ID) {
		// Metric u = (Metric) dialog.getFirstResult();
		// if (!comp.getMetricRefs().contains(u)) {
		// Command c = new AddCommand(editingService
		// .getEditingDomain(), comp.getMetricRefs(), u);
		// editingService.getEditingDomain().getCommandStack()
		// .execute(c);
		// }
		// }
		// }
		//
		// public void linkEntered(HyperlinkEvent e) {
		// }
		//
		// public void linkExited(HyperlinkEvent e) {
		// }
		// });
		// hypLnkAddMetric.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
		// false, false, 1, 1));
		// toolkit.paintBordersFor(hypLnkAddMetric);
		// hypLnkAddMetric.setText("Add");

		linksTableViewer = new TableViewer(cmpMetrics, SWT.BORDER
				| SWT.FULL_SELECTION);
		Table metricsTable = linksTableViewer.getTable();
		metricsTable.setHeaderVisible(true);
		metricsTable.setLinesVisible(true);

		GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd.heightHint = 100;
		metricsTable.setLayoutData(gd);
		toolkit.paintBordersFor(metricsTable);

		TableViewerColumn tableViewerColumn = new TableViewerColumn(
				linksTableViewer, SWT.NONE);
		TableColumn tblclmnNewName = tableViewerColumn.getColumn();
		tblclmnNewName.setWidth(150);
		tblclmnNewName.setText("Name");

		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(
				linksTableViewer, SWT.NONE);
		TableColumn tblclmnDescription = tableViewerColumn_1.getColumn();
		tblclmnDescription.setWidth(90);
		tblclmnDescription.setText("Protocol");

		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(
				linksTableViewer, SWT.NONE);
		TableColumn tblclmnUnit = tableViewerColumn_2.getColumn();
		tblclmnUnit.setWidth(90);
		tblclmnUnit.setText("Remote Node");

		// Menu menu = new Menu(metricsTable);
		// metricsTable.setMenu(menu);
		//
		// MenuItem mntmRemoveMetric = new MenuItem(menu, SWT.NONE);
		// mntmRemoveMetric.addSelectionListener(new SelectionAdapter() {
		// @Override
		// public void widgetSelected(SelectionEvent e) {
		// ISelection s = linksTableViewer.getSelection();
		// if (s instanceof IStructuredSelection) {
		// Object o = ((IStructuredSelection) s).getFirstElement();
		// // FIXME, we can' delete a child metric.
		//
		// Command rc = new RemoveCommand(editingService
		// .getEditingDomain(), comp.getMetricRefs(), o);
		// editingService.getEditingDomain().getCommandStack()
		// .execute(rc);
		// }
		// }
		// });
		// mntmRemoveMetric.setText("Remove");

		if (readonly) {
		}
	}

	public EMFDataBindingContext initDataBindings_() {
		EMFDataBindingContext context = super.initDataBindings_();

		super.bindResourcesSection(context);
		super.bindToleranceSection();
		super.bindMetricSection();
		super.bindLifeCycle(context);
		bindInfoSection(context);
		return bindLinkSection(context);
	}

	private EMFDataBindingContext bindInfoSection(EMFDataBindingContext context) {
		// Binding of name and Description
		IObservableValue nameObservable = SWTObservables.observeDelayedValue(
				400, SWTObservables.observeText(txtName, SWT.Modify));

		IObservableValue descriptionObservable = SWTObservables
				.observeDelayedValue(400,
						SWTObservables.observeText(txtDescription, SWT.Modify));

		IEMFValueProperty componentNameProperty = EMFEditProperties.value(
				editingService.getEditingDomain(),
				LibraryPackage.Literals.COMPONENT__NAME);

		IEMFValueProperty componentDescriptionProperty = EMFEditProperties
				.value(editingService.getEditingDomain(),
						LibraryPackage.Literals.COMPONENT__DESCRIPTION);

		context.bindValue(nameObservable, componentNameProperty.observe(comp),
				null, null);

		context.bindValue(descriptionObservable,
				componentDescriptionProperty.observe(comp), null, null);

		return context;
	}

	protected EMFDataBindingContext bindLinkSection(
			EMFDataBindingContext context) {

		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		linksTableViewer.setContentProvider(listContentProvider);
		IObservableMap[] observeMaps = EMFObservables.observeMaps(
				listContentProvider.getKnownElements(),
				new EStructuralFeature[] {
						OperatorsPackage.Literals.RELATIONSHIP__NAME,
						OperatorsPackage.Literals.RELATIONSHIP__PROTOCOL_REF,
						OperatorsPackage.Literals.RELATIONSHIP__NODE_ID2_REF });
		linksTableViewer.setLabelProvider(new LinksLabelProvider(
				observeMaps));
		IEMFListProperty l = EMFEditProperties.list(
				editingService.getEditingDomain(),
				LibraryPackage.Literals.FUNCTION__FUNCTION_RELATIONSHIP_REFS);

		linksTableViewer.setInput(l.observe(comp));
		return context;
	}

	class LinksLabelProvider extends ObservableMapLabelProvider {

		@Override
		public String getColumnText(Object element, int columnIndex) {
			
			if( columnIndex == 2){
				if(element instanceof Relationship){
					Relationship link  = (Relationship) element;
					if(!link.eIsSet(OperatorsPackage.Literals.RELATIONSHIP__NODE_ID2_REF)){
						return "Not set";
					}
				}
			}
			return super.getColumnText(element, columnIndex);
		}

		public LinksLabelProvider(IObservableMap[] attributeMaps) {
			super(attributeMaps);
		}
			
	}

}
