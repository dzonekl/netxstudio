package com.netxforge.netxstudio.screens.f2;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.databinding.IEMFValueProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.ui.forms.widgets.Section;

import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.Tolerance;
import com.netxforge.netxstudio.screens.ToleranceFilterDialog;
import com.netxforge.netxstudio.screens.editing.IEditingService;
import com.netxforge.netxstudio.screens.editing.selector.IDataScreenInjection;
import com.netxforge.netxstudio.screens.editing.selector.IScreen;
import com.netxforge.netxstudio.screens.f2.support.ToleranceObservableMapLabelProvider;

public class NewEditComponent extends AbstractDetailsComposite implements
		IScreen, IDataScreenInjection {

	private Component comp;
	private FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Text txtName;
	private Text text;
	private IEditingService editingService;
	private Table table;
	private TableViewer tolerancesTableViewer;
	private Text txtCapExpression;
	private Text txtUtilExpression;

	public NewEditComponent(Composite parent, int style,
			final IEditingService editingService) {
		super(parent, style);
		this.editingService = editingService;
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
		this.buildUI();
	}

	public void injectData(Object owner, Object object) {
		if (object instanceof Component) {
			this.comp = (Component) object;
		} else {
			return;
		}
		this.initDataBindings_();
	}

	public boolean isValid() {
		return false;
	}

	private void buildUI() {

		Section scnInfo = toolkit.createSection(this, Section.EXPANDED
				| Section.TITLE_BAR);
		FormData fd_scnInfo = new FormData();
		fd_scnInfo.top = new FormAttachment(0, 10);
		fd_scnInfo.left = new FormAttachment(0, 10);
		fd_scnInfo.bottom = new FormAttachment(0, 180);
		fd_scnInfo.right = new FormAttachment(100, -14);
		scnInfo.setLayoutData(fd_scnInfo);
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

		txtName = toolkit.createText(composite, "New Text", SWT.NONE);
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

		text = toolkit.createText(composite, "New Text", SWT.BORDER | SWT.WRAP
				| SWT.MULTI);
		text.setText("");
		GridData gd_text = new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1);
		gd_text.heightHint = 100;
		gd_text.widthHint = 200;
		text.setLayoutData(gd_text);

		Section sctnExpressions = toolkit.createSection(this, Section.TWISTIE
				| Section.TITLE_BAR);
		FormData fd_sctnExpressions = new FormData();
		fd_sctnExpressions.top = new FormAttachment(scnInfo, 174);
		fd_sctnExpressions.bottom = new FormAttachment(scnInfo, 382, SWT.BOTTOM);
		fd_sctnExpressions.left = new FormAttachment(scnInfo, 0, SWT.LEFT);
		fd_sctnExpressions.right = new FormAttachment(scnInfo, 0, SWT.RIGHT);
		sctnExpressions.setLayoutData(fd_sctnExpressions);
		toolkit.paintBordersFor(sctnExpressions);
		sctnExpressions.setText("Expressions");
		sctnExpressions.setExpanded(true);

		Composite composite_1 = toolkit.createComposite(sctnExpressions,
				SWT.NONE);
		toolkit.paintBordersFor(composite_1);
		sctnExpressions.setClient(composite_1);
		composite_1.setLayout(new GridLayout(3, false));

		Label lblCapacityExpression = toolkit.createLabel(composite_1,
				"Capacity Expression:", SWT.NONE);
		lblCapacityExpression.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
				false, false, 1, 1));

		txtCapExpression = toolkit
				.createText(composite_1, "New Text", SWT.NONE);
		txtCapExpression.setText("");
		txtCapExpression.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));

		Button btnSelect = toolkit
				.createButton(composite_1, "Select", SWT.NONE);
		GridData gd_btnSelect = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnSelect.heightHint = 20;
		btnSelect.setLayoutData(gd_btnSelect);
		btnSelect.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Resource unitResource = editingService.getData(LibraryPackage.Literals.UNIT);
//				UnitFilterDialog dialog = new UnitFilterDialog(
//						NewEditMetric.this.getShell(), unitResource);
//				if (dialog.open() == IDialogConstants.OK_ID) {
//					Unit u = (Unit) dialog.getFirstResult();
//					metric.setUnitRef(u); // Should now show with databinding.
//				}
			}
		});

		Label lblUtilizationExpression = toolkit.createLabel(composite_1,
				"Utilization Expression:", SWT.NONE);
		lblUtilizationExpression.setLayoutData(new GridData(SWT.RIGHT,
				SWT.CENTER, false, false, 1, 1));

		txtUtilExpression = toolkit.createText(composite_1, "New Text",
				SWT.NONE);
		txtUtilExpression.setText("");
		txtUtilExpression.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				true, false, 1, 1));

		Button btnSelect_1 = toolkit.createButton(composite_1, "Select",
				SWT.NONE);
		GridData gd_btnSelect_1 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnSelect_1.heightHint = 20;
		btnSelect_1.setLayoutData(gd_btnSelect_1);
		btnSelect_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});

		Section sctnMetrics = toolkit.createSection(this, Section.TWISTIE
				| Section.TITLE_BAR);
		FormData fd_sctnMetrics = new FormData();
		fd_sctnMetrics.bottom = new FormAttachment(sctnExpressions, -6);
		fd_sctnMetrics.top = new FormAttachment(scnInfo, 6);
		fd_sctnMetrics.left = new FormAttachment(0, 10);
		fd_sctnMetrics.right = new FormAttachment(100, -14);
		sctnMetrics.setLayoutData(fd_sctnMetrics);
		toolkit.paintBordersFor(sctnMetrics);
		sctnMetrics.setText("Tolerances");
		sctnMetrics.setExpanded(true);

		Composite cmpTolerances = toolkit
				.createComposite(sctnMetrics, SWT.NONE);
		toolkit.paintBordersFor(cmpTolerances);
		sctnMetrics.setClient(cmpTolerances);
		cmpTolerances.setLayout(new GridLayout(1, false));

		ImageHyperlink mghprlnkNewImagehyperlink = toolkit
				.createImageHyperlink(cmpTolerances, SWT.NONE);
		mghprlnkNewImagehyperlink
				.addHyperlinkListener(new IHyperlinkListener() {
					public void linkActivated(HyperlinkEvent e) {
						Resource toleranceResource = editingService
								.getData(LibraryPackage.Literals.TOLERANCE);
						ToleranceFilterDialog dialog = new ToleranceFilterDialog(
								NewEditComponent.this.getShell(),
								toleranceResource);
						if (dialog.open() == IDialogConstants.OK_ID) {
							Tolerance u = (Tolerance) dialog.getFirstResult();
							if (!comp.getToleranceRefs().contains(u)) {
								Command c = new AddCommand(editingService
										.getEditingDomain(), comp
										.getToleranceRefs(), u);
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
		mghprlnkNewImagehyperlink.setLayoutData(new GridData(SWT.RIGHT,
				SWT.CENTER, false, false, 1, 1));
		toolkit.paintBordersFor(mghprlnkNewImagehyperlink);
		mghprlnkNewImagehyperlink.setText("Add");

		tolerancesTableViewer = new TableViewer(cmpTolerances, SWT.BORDER
				| SWT.FULL_SELECTION);
		table = tolerancesTableViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		toolkit.paintBordersFor(table);

		TableViewerColumn tableViewerColumn = new TableViewerColumn(
				tolerancesTableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn = tableViewerColumn.getColumn();
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("Name");

		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(
				tolerancesTableViewer, SWT.NONE);
		TableColumn tblclmnLevel = tableViewerColumn_1.getColumn();
		tblclmnLevel.setWidth(70);
		tblclmnLevel.setText("Level");

		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(
				tolerancesTableViewer, SWT.NONE);
		TableColumn tblclmnExpression = tableViewerColumn_2.getColumn();
		tblclmnExpression.setWidth(100);
		tblclmnExpression.setText("Expression");
	}

	public EMFDataBindingContext initDataBindings_() {
		EMFDataBindingContext context = new EMFDataBindingContext();

		// Binding of name and Description

		IObservableValue nameObservable = SWTObservables.observeDelayedValue(
				400, SWTObservables.observeText(txtName, SWT.Modify));
		IObservableValue descriptionObservable = SWTObservables
				.observeDelayedValue(400,
						SWTObservables.observeText(text, SWT.Modify));

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

		// binding of tolerances.

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
				LibraryPackage.Literals.COMPONENT__TOLERANCE_REFS);

		IObservableList toleranceObservableList = l.observe(comp);

		// obm.addObservable(toleranceObservableList);
		tolerancesTableViewer.setInput(toleranceObservableList);

		return context;
	}
}
