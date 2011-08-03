package com.netxforge.netxstudio.screens.details;

import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.property.value.IValueProperty;
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
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
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
import org.eclipse.swt.widgets.Combo;
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
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.wb.swt.ResourceManager;

import com.netxforge.netxstudio.generics.ExpansionDuration;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Expression;
import com.netxforge.netxstudio.library.LibraryFactory;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NetXResource;
import com.netxforge.netxstudio.library.Tolerance;
import com.netxforge.netxstudio.screens.ExpressionFilterDialog;
import com.netxforge.netxstudio.screens.NetXResourceFilterDialog;
import com.netxforge.netxstudio.screens.ToleranceFilterDialog;
import com.netxforge.netxstudio.screens.ch9.NewEditExpression;
import com.netxforge.netxstudio.screens.editing.IEditingService;
import com.netxforge.netxstudio.screens.editing.selector.IDataScreenInjection;
import com.netxforge.netxstudio.screens.editing.selector.IScreen;
import com.netxforge.netxstudio.screens.editing.selector.Screens;
import com.netxforge.netxstudio.screens.f2.NewEditResource;
import com.netxforge.netxstudio.screens.f2.support.ToleranceObservableMapLabelProvider;

public class NewEditEquipment extends AbstractDetailsComposite implements
		IScreen, IDataScreenInjection {

	private Equipment comp;
	private FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Text txtName;
	private Text txtDescription;
	private IEditingService editingService;
	private Table table;
	private TableViewer tolerancesTableViewer;
	private Text txtCapExpression;
	private Text txtUtilExpression;
	private Table table_1;
	private TableViewer resourceTableViewer;
	private Text txtCode;
	private ComboViewer cmbViewerExpansionDuration;

	public NewEditEquipment(Composite parent, int style,
			final IEditingService editingService) {
		super(parent, style);
		this.editingService = editingService;
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
//		buildUI();
	}

	public void injectData(Object owner, Object object) {
		if (object instanceof Equipment) {
			this.comp = (Equipment) object;
		} else {
			return;
		}
		this.buildUI();
		this.initDataBindings_();
	}

	public boolean isValid() {
		return false;
	}

	private void buildUI() {

		// Readonlyness.
		boolean readonly = Screens.isReadOnlyOperation(this.getOperation());
		int widgetStyle = readonly ? SWT.READ_ONLY : SWT.NONE;

		Section scnInfo = toolkit.createSection(this, Section.EXPANDED
				| Section.TITLE_BAR);
		FormData fd_scnInfo = new FormData();
		fd_scnInfo.top = new FormAttachment(0, 10);
		fd_scnInfo.left = new FormAttachment(0, 10);
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

		txtName = toolkit.createText(composite, "New Text", SWT.NONE
				| widgetStyle);
		txtName.setText("");
		GridData gd_txtName = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_txtName.widthHint = 200;
		txtName.setLayoutData(gd_txtName);

		Label lblCode = toolkit.createLabel(composite, "Code:", SWT.NONE);
		lblCode.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1));

		txtCode = toolkit.createText(composite, "New Text", SWT.NONE
				| widgetStyle);
		txtCode.setText("");
		txtCode.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false,
				1, 1));

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

		Label lblExpansion = toolkit.createLabel(composite, "Expansion:",
				SWT.NONE);
		lblExpansion.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));

		cmbViewerExpansionDuration = new ComboViewer(composite, SWT.NONE);
		Combo cmbExpansionDuration = cmbViewerExpansionDuration.getCombo();
		cmbExpansionDuration.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				false, false, 1, 1));
		toolkit.paintBordersFor(cmbExpansionDuration);

		Section sctnExpressions = toolkit.createSection(this, Section.TWISTIE
				| Section.TITLE_BAR);
		FormData fd_sctnExpressions = new FormData();
		fd_sctnExpressions.right = new FormAttachment(100, -14);
		fd_sctnExpressions.left = new FormAttachment(0, 10);
		fd_sctnExpressions.bottom = new FormAttachment(100, -10);
		sctnExpressions.setLayoutData(fd_sctnExpressions);
		toolkit.paintBordersFor(sctnExpressions);
		sctnExpressions.setText("Expressions");
		sctnExpressions.setExpanded(true);

		Composite composite_1 = toolkit.createComposite(sctnExpressions,
				SWT.NONE);
		toolkit.paintBordersFor(composite_1);
		sctnExpressions.setClient(composite_1);
		composite_1.setLayout(new GridLayout(4, false));

		Label lblCapacityExpression = toolkit.createLabel(composite_1,
				"Capacity Expression:", SWT.NONE);
		lblCapacityExpression.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
				false, false, 1, 1));

		txtCapExpression = toolkit.createText(composite_1, "New Text",
				SWT.READ_ONLY);
		txtCapExpression.setText("");
		txtCapExpression.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1));

		ImageHyperlink imageHyperlink = toolkit.createImageHyperlink(
				composite_1, SWT.NONE);
		imageHyperlink.addHyperlinkListener(new IHyperlinkListener() {
			public void linkActivated(HyperlinkEvent e) {
				if (comp.getCapacityExpressionRef() != null) {
					Command c = new SetCommand(
							editingService.getEditingDomain(),
							comp,
							LibraryPackage.Literals.COMPONENT__CAPACITY_EXPRESSION_REF,
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
		GridData gd_imageHyperlink = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_imageHyperlink.widthHint = 18;
		imageHyperlink.setLayoutData(gd_imageHyperlink);
		imageHyperlink.setImage(ResourceManager.getPluginImage(
				"org.eclipse.ui", "/icons/full/etool16/delete.gif"));
		toolkit.paintBordersFor(imageHyperlink);
		imageHyperlink.setText("");

		Button btnSelectCapExpression = toolkit.createButton(composite_1,
				"Select", SWT.NONE);
		GridData gd_btnSelectCapExpression = new GridData(SWT.LEFT, SWT.CENTER,
				false, false, 1, 1);
		gd_btnSelectCapExpression.heightHint = 20;
		btnSelectCapExpression.setLayoutData(gd_btnSelectCapExpression);
		btnSelectCapExpression.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Resource expressionResource = editingService
						.getData(LibraryPackage.Literals.EXPRESSION);
				ExpressionFilterDialog dialog = new ExpressionFilterDialog(
						NewEditEquipment.this.getShell(), expressionResource);
				if (dialog.open() == IDialogConstants.OK_ID) {
					Expression expression = (Expression) dialog
							.getFirstResult();
					Command c = new SetCommand(
							editingService.getEditingDomain(),
							comp,
							LibraryPackage.Literals.COMPONENT__CAPACITY_EXPRESSION_REF,
							expression);
					editingService.getEditingDomain().getCommandStack()
							.execute(c);
				}
			}
		});

		Label lblUtilizationExpression = toolkit.createLabel(composite_1,
				"Utilization Expression:", SWT.NONE);
		lblUtilizationExpression.setLayoutData(new GridData(SWT.RIGHT,
				SWT.CENTER, false, false, 1, 1));

		txtUtilExpression = toolkit.createText(composite_1, "New Text",
				SWT.NONE | SWT.READ_ONLY);
		txtUtilExpression.setText("");
		txtUtilExpression.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				true, false, 1, 1));

		ImageHyperlink imageHyperlink_1 = toolkit.createImageHyperlink(
				composite_1, SWT.NONE);
		imageHyperlink_1.addHyperlinkListener(new IHyperlinkListener() {
			public void linkActivated(HyperlinkEvent e) {
				if (comp.getUtilizationExpressionRef() != null) {
					Command c = new SetCommand(
							editingService.getEditingDomain(),
							comp,
							LibraryPackage.Literals.COMPONENT__UTILIZATION_EXPRESSION_REF,
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
		GridData gd_imageHyperlink_1 = new GridData(SWT.LEFT, SWT.CENTER,
				false, false, 1, 1);
		gd_imageHyperlink_1.widthHint = 18;
		imageHyperlink_1.setLayoutData(gd_imageHyperlink_1);
		imageHyperlink_1.setImage(ResourceManager.getPluginImage(
				"org.eclipse.ui", "/icons/full/etool16/delete.gif"));
		toolkit.paintBordersFor(imageHyperlink_1);
		imageHyperlink_1.setText("");

		Button btnSelectUtilExpression = toolkit.createButton(composite_1,
				"Select", SWT.NONE);
		GridData gd_btnSelectUtilExpression = new GridData(SWT.LEFT,
				SWT.CENTER, false, false, 1, 1);
		gd_btnSelectUtilExpression.heightHint = 20;
		btnSelectUtilExpression.setLayoutData(gd_btnSelectUtilExpression);
		btnSelectUtilExpression.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Resource expressionResource = editingService
						.getData(LibraryPackage.Literals.EXPRESSION);
				ExpressionFilterDialog dialog = new ExpressionFilterDialog(
						NewEditEquipment.this.getShell(), expressionResource);
				if (dialog.open() == IDialogConstants.OK_ID) {
					Expression expression = (Expression) dialog
							.getFirstResult();
					Command c = new SetCommand(
							editingService.getEditingDomain(),
							comp,
							LibraryPackage.Literals.COMPONENT__UTILIZATION_EXPRESSION_REF,
							expression);
					editingService.getEditingDomain().getCommandStack()
							.execute(c);
				}
			}
		});

		Section sctnMetrics = toolkit.createSection(this, Section.TWISTIE
				| Section.TITLE_BAR);
		fd_scnInfo.bottom = new FormAttachment(sctnMetrics, -6);
		FormData fd_sctnMetrics = new FormData();
		fd_sctnMetrics.top = new FormAttachment(0, 186);
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

		ImageHyperlink hypLnkAddTolerance = toolkit.createImageHyperlink(
				cmpTolerances, SWT.NONE);
		hypLnkAddTolerance.addHyperlinkListener(new IHyperlinkListener() {
			public void linkActivated(HyperlinkEvent e) {
				Resource toleranceResource = editingService
						.getData(LibraryPackage.Literals.TOLERANCE);
				ToleranceFilterDialog dialog = new ToleranceFilterDialog(
						NewEditEquipment.this.getShell(), toleranceResource);
				if (dialog.open() == IDialogConstants.OK_ID) {
					Tolerance u = (Tolerance) dialog.getFirstResult();
					if (!comp.getToleranceRefs().contains(u)) {
						Command c = new AddCommand(editingService
								.getEditingDomain(), comp.getToleranceRefs(), u);
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
		toolkit.paintBordersFor(hypLnkAddTolerance);
		hypLnkAddTolerance.setText("Add");

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
		
		Menu menu = new Menu(table);
		table.setMenu(menu);
		
		MenuItem mntmRemove = new MenuItem(menu, SWT.NONE);
		mntmRemove.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ISelection s = tolerancesTableViewer.getSelection();
				if(s instanceof IStructuredSelection ){
					Object o = ((IStructuredSelection) s).getFirstElement();
					Command rc = new RemoveCommand(editingService.getEditingDomain(), comp.getToleranceRefs(), o);
					editingService.getEditingDomain().getCommandStack().execute(rc);
				}
			}
		});
		mntmRemove.setText("Remove");

		Section sctnResources = toolkit.createSection(this, Section.TITLE_BAR);
		fd_sctnMetrics.bottom = new FormAttachment(sctnResources, -6);
		fd_sctnExpressions.top = new FormAttachment(0, 482);
		FormData fd_sctnResources = new FormData();
		fd_sctnResources.bottom = new FormAttachment(sctnExpressions, -6);
		fd_sctnResources.top = new FormAttachment(0, 338);
		fd_sctnResources.right = new FormAttachment(100, -14);
		fd_sctnResources.left = new FormAttachment(0, 10);
		sctnResources.setLayoutData(fd_sctnResources);
		toolkit.paintBordersFor(sctnResources);
		sctnResources.setText("Resources");

		Composite composite_2 = toolkit
				.createComposite(sctnResources, SWT.NONE);
		toolkit.paintBordersFor(composite_2);
		sctnResources.setClient(composite_2);
		composite_2.setLayout(new GridLayout(2, false));

		ImageHyperlink hypLnkAddResource = toolkit.createImageHyperlink(
				composite_2, SWT.NONE);
		hypLnkAddResource.addHyperlinkListener(new IHyperlinkListener() {
			public void linkActivated(HyperlinkEvent e) {
				Resource resourceResource = editingService
						.getData(LibraryPackage.Literals.NET_XRESOURCE);
				NetXResourceFilterDialog dialog = new NetXResourceFilterDialog(
						NewEditEquipment.this.getShell(), resourceResource);
				if (dialog.open() == IDialogConstants.OK_ID) {
					NetXResource u = (NetXResource) dialog.getFirstResult();
					if (!comp.getResourceRefs().contains(u)) {
						Command c = new AddCommand(editingService
								.getEditingDomain(), comp.getResourceRefs(), u);
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
		hypLnkAddResource.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
				true, false, 1, 1));
		toolkit.paintBordersFor(hypLnkAddResource);
		hypLnkAddResource.setText("Add");

		ImageHyperlink mghprlnkNewImagehyperlink = toolkit
				.createImageHyperlink(composite_2, SWT.NONE);
		mghprlnkNewImagehyperlink
				.addHyperlinkListener(new IHyperlinkListener() {
					public void linkActivated(HyperlinkEvent e) {
						NewEditResource resourceScreen = new NewEditResource(
								screenService.getScreenContainer(), SWT.NONE);
						resourceScreen.setOperation(Screens.OPERATION_NEW);
						resourceScreen.setScreenService(screenService);

						Resource resourcesResource = editingService
								.getData(LibraryPackage.Literals.NET_XRESOURCE);
						resourceScreen.injectData(resourcesResource, comp,
								LibraryFactory.eINSTANCE.createNetXResource());
						screenService.setActiveScreen(resourceScreen);

					}

					public void linkEntered(HyperlinkEvent e) {
					}

					public void linkExited(HyperlinkEvent e) {
					}
				});
		toolkit.paintBordersFor(mghprlnkNewImagehyperlink);
		mghprlnkNewImagehyperlink.setText("New");

		resourceTableViewer = new TableViewer(composite_2, SWT.BORDER
				| SWT.FULL_SELECTION);
		table_1 = resourceTableViewer.getTable();
		table_1.setLinesVisible(true);
		table_1.setHeaderVisible(true);
		table_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		toolkit.paintBordersFor(table_1);

		TableViewerColumn tableViewerColumn_3 = new TableViewerColumn(
				resourceTableViewer, SWT.NONE);
		TableColumn tblclmnShortName = tableViewerColumn_3.getColumn();
		tblclmnShortName.setWidth(100);
		tblclmnShortName.setText("Short Name");

		TableViewerColumn tableViewerColumn_4 = new TableViewerColumn(
				resourceTableViewer, SWT.NONE);
		TableColumn tblclmnExpressionName = tableViewerColumn_4.getColumn();
		tblclmnExpressionName.setWidth(100);
		tblclmnExpressionName.setText("Expression Name");
		
		Menu menu_1 = new Menu(table_1);
		table_1.setMenu(menu_1);
		
		MenuItem mntmRemove_1 = new MenuItem(menu_1, SWT.NONE);
		mntmRemove_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ISelection s = resourceTableViewer.getSelection();
				if(s instanceof IStructuredSelection ){
					Object o = ((IStructuredSelection) s).getFirstElement();
					Command rc = DeleteCommand.create(editingService.getEditingDomain(), o);
					editingService.getEditingDomain().getCommandStack().execute(rc);
				}
			}
		});
		mntmRemove_1.setText("Remove");

		if (readonly) {
			btnSelectCapExpression.setEnabled(false);
			btnSelectUtilExpression.setEnabled(false);
			hypLnkAddResource.setEnabled(false);
			hypLnkAddTolerance.setEnabled(false);
		}

	}

	@SuppressWarnings("unused")
	private void editUtilizationExpression() {
		NewEditExpression expressionScreen = new NewEditExpression(
				screenService.getScreenContainer(), SWT.NONE);
		expressionScreen.setScreenService(screenService);
		Expression expression = comp.getUtilizationExpressionRef();
		if (expression != null) {
			expressionScreen.setOperation(Screens.OPERATION_EDIT);
			expressionScreen
					.injectData(
							null,
							comp,
							LibraryPackage.Literals.COMPONENT__UTILIZATION_EXPRESSION_REF,
							expression);
		} else {
			Resource expressionResource = editingService
					.getData(LibraryPackage.Literals.EXPRESSION);
			expressionScreen.setOperation(Screens.OPERATION_NEW);
			expressionScreen
					.injectData(
							expressionResource,
							comp,
							LibraryPackage.Literals.COMPONENT__UTILIZATION_EXPRESSION_REF,
							LibraryFactory.eINSTANCE.createExpression());
		}
		screenService.setActiveScreen(expressionScreen);
	}

	@SuppressWarnings("unused")
	private void editCapacityExpression() {
		NewEditExpression expressionScreen = new NewEditExpression(
				screenService.getScreenContainer(), SWT.NONE);
		expressionScreen.setScreenService(screenService);
		Expression expression = comp.getCapacityExpressionRef();
		if (expression != null) {
			expressionScreen.setOperation(Screens.OPERATION_EDIT);
			expressionScreen.injectData(null, comp,
					LibraryPackage.Literals.COMPONENT__CAPACITY_EXPRESSION_REF,
					expression);
		} else {
			Resource expressionResource = editingService
					.getData(LibraryPackage.Literals.EXPRESSION);
			expressionScreen.setOperation(Screens.OPERATION_NEW);
			expressionScreen.injectData(expressionResource, comp,
					LibraryPackage.Literals.COMPONENT__CAPACITY_EXPRESSION_REF,
					LibraryFactory.eINSTANCE.createExpression());

		}
		screenService.setActiveScreen(expressionScreen);
	}

	public EMFDataBindingContext initDataBindings_() {
		EMFDataBindingContext context = new EMFDataBindingContext();

		// Binding of name and Description

		IObservableValue nameObservable = SWTObservables.observeDelayedValue(
				400, SWTObservables.observeText(txtName, SWT.Modify));

		IObservableValue codeObservable = SWTObservables.observeDelayedValue(
				400, SWTObservables.observeText(txtCode, SWT.Modify));

		IObservableValue descriptionObservable = SWTObservables
				.observeDelayedValue(400,
						SWTObservables.observeText(txtDescription, SWT.Modify));

		IObservableValue capExpressionObservable = SWTObservables.observeText(
				this.txtCapExpression, SWT.Modify);

		IObservableValue utilExpressionObservable = SWTObservables.observeText(
				this.txtUtilExpression, SWT.Modify);

		IEMFValueProperty componentNameProperty = EMFEditProperties.value(
				editingService.getEditingDomain(),
				LibraryPackage.Literals.COMPONENT__NAME);

		IEMFValueProperty codeProperty = EMFEditProperties.value(
				editingService.getEditingDomain(),
				LibraryPackage.Literals.EQUIPMENT__EQUIPMENT_CODE);

		IEMFValueProperty componentDescriptionProperty = EMFEditProperties
				.value(editingService.getEditingDomain(),
						LibraryPackage.Literals.COMPONENT__DESCRIPTION);

		IEMFValueProperty capacityExpressionProperty = EMFEditProperties
				.value(editingService.getEditingDomain(),
						FeaturePath
								.fromList(
										LibraryPackage.Literals.COMPONENT__CAPACITY_EXPRESSION_REF,
										LibraryPackage.Literals.EXPRESSION__NAME));

		IEMFValueProperty utilExpressionProperty = EMFEditProperties
				.value(editingService.getEditingDomain(),
						FeaturePath
								.fromList(
										LibraryPackage.Literals.COMPONENT__UTILIZATION_EXPRESSION_REF,
										LibraryPackage.Literals.EXPRESSION__NAME));

		// Expansion duration binding. 
		cmbViewerExpansionDuration
				.setContentProvider(new ArrayContentProvider());
		cmbViewerExpansionDuration.setLabelProvider(new LabelProvider());
		cmbViewerExpansionDuration.setInput(ExpansionDuration.VALUES);

		IEMFValueProperty durationProperty = EMFEditProperties.value(
				editingService.getEditingDomain(),
				LibraryPackage.Literals.EQUIPMENT__DURATION);
		IValueProperty selectionProperty = ViewerProperties.singleSelection();
		IObservableValue expansionDurationObservable = selectionProperty
				.observe(cmbViewerExpansionDuration);
		context.bindValue(expansionDurationObservable,
				durationProperty.observe(comp), null, null);

		context.bindValue(nameObservable, componentNameProperty.observe(comp),
				null, null);
		context.bindValue(codeObservable, codeProperty.observe(comp), null,
				null);
		context.bindValue(descriptionObservable,
				componentDescriptionProperty.observe(comp), null, null);
		context.bindValue(capExpressionObservable,
				capacityExpressionProperty.observe(comp), null, null);
		context.bindValue(utilExpressionObservable,
				utilExpressionProperty.observe(comp), null, null);

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

		tolerancesTableViewer.setInput(l.observe(comp));

		// binding of resources

		ObservableListContentProvider resourceListContentProvider = new ObservableListContentProvider();
		resourceTableViewer.setContentProvider(resourceListContentProvider);
		IObservableMap[] observeResourceMaps = EMFObservables
				.observeMaps(
						resourceListContentProvider.getKnownElements(),
						new EStructuralFeature[] {
								LibraryPackage.Literals.NET_XRESOURCE__SHORT_NAME,
								LibraryPackage.Literals.NET_XRESOURCE__EXPRESSION_NAME });
		resourceTableViewer.setLabelProvider(new ObservableMapLabelProvider(
				observeResourceMaps));
		IEMFListProperty resourcesListProperty = EMFEditProperties.list(
				editingService.getEditingDomain(),
				LibraryPackage.Literals.COMPONENT__RESOURCE_REFS);
		resourceTableViewer.setInput(resourcesListProperty.observe(comp));

		return context;
	}
}
