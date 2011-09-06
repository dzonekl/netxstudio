package com.netxforge.netxstudio.screens.details;

import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.value.IObservableValue;
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
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.wb.swt.ResourceManager;

import com.netxforge.netxstudio.library.Component;
import com.netxforge.netxstudio.library.Expression;
import com.netxforge.netxstudio.library.LibraryFactory;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.Tolerance;
import com.netxforge.netxstudio.metrics.Metric;
import com.netxforge.netxstudio.metrics.MetricsPackage;
import com.netxforge.netxstudio.screens.ExpressionFilterDialog;
import com.netxforge.netxstudio.screens.MetricFilterDialog;
import com.netxforge.netxstudio.screens.ToleranceFilterDialog;
import com.netxforge.netxstudio.screens.ch9.NewEditExpression;
import com.netxforge.netxstudio.screens.editing.IEditingService;
import com.netxforge.netxstudio.screens.editing.selector.IDataScreenInjection;
import com.netxforge.netxstudio.screens.editing.selector.Screens;
import com.netxforge.netxstudio.screens.f2.NewEditResource;
import com.netxforge.netxstudio.screens.f2.support.ToleranceObservableMapLabelProvider;
import com.netxforge.netxstudio.screens.f4.support.MetricTreeLabelProvider;


/**
 * Abstract Component screen implementation, which can deliver various sections. 
 * 
 * @author dzonekl
 *
 */
public abstract class NewEditComponent extends AbstractDetailsScreen implements IDataScreenInjection {

	final IEditingService editingService;
	
	// Resource section. 
	private Text txtCapExpression;
	private Text txtUtilExpression;
	private TableViewer resourceTableViewer;
	
	// Tolerances section. 
	private TableViewer tolerancesTableViewer;
	
	// Metrics Section
	private TableViewer metricsTableViewer;
	
	
	protected Component comp;
	
	
	
	public NewEditComponent(Composite parent, int style, final IEditingService editingService) {
		super(parent, style);
		this.editingService = editingService;
//		buildUI();
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
	
	
	protected Section buildToleranceSection(boolean readonly){
		
		Section sctnTolerances = toolkit.createSection(this, Section.TWISTIE
				| Section.TITLE_BAR);
		
		toolkit.paintBordersFor(sctnTolerances);
		sctnTolerances.setText("Tolerances");
		sctnTolerances.setExpanded(false);

		Composite cmpTolerances = toolkit
				.createComposite(sctnTolerances, SWT.NONE);
		toolkit.paintBordersFor(cmpTolerances);
		sctnTolerances.setClient(cmpTolerances);
		cmpTolerances.setLayout(new GridLayout(1, false));

		ImageHyperlink hypLnkAddTolerance = toolkit.createImageHyperlink(
				cmpTolerances, SWT.NONE);
		hypLnkAddTolerance.addHyperlinkListener(new IHyperlinkListener() {
			public void linkActivated(HyperlinkEvent e) {
				Resource toleranceResource = editingService
						.getData(LibraryPackage.Literals.TOLERANCE);
				ToleranceFilterDialog dialog = new ToleranceFilterDialog(
						NewEditComponent.this.getShell(), toleranceResource);
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
		Table metricsTable = tolerancesTableViewer.getTable();
		metricsTable.setHeaderVisible(true);
		metricsTable.setLinesVisible(true);
		
		GridData gd = new GridData(SWT.FILL, SWT.FILL, true,
				true, 1, 1);
		gd.heightHint = 100;
		metricsTable.setLayoutData(gd);
		toolkit.paintBordersFor(metricsTable);

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
							.getEditingDomain(), comp.getToleranceRefs(), o);
					editingService.getEditingDomain().getCommandStack()
							.execute(rc);
				}
			}
		});
		mntmRemoveTolerance.setText("Remove");

		if (readonly) {
			hypLnkAddTolerance.setEnabled(false);
			mntmRemoveTolerance.setEnabled(false);
		}
		return sctnTolerances;
	}
	
	
	protected Section buildMetricSection(boolean readonly){
		
		Section sctnMetrics = toolkit.createSection(this, Section.TWISTIE
				| Section.TITLE_BAR);

		toolkit.paintBordersFor(sctnMetrics);
		sctnMetrics.setText("Metrics");
		sctnMetrics.setExpanded(false);
		
		Composite cmpMetrics = toolkit
				.createComposite(sctnMetrics, SWT.NONE);
		toolkit.paintBordersFor(cmpMetrics);
		sctnMetrics.setClient(cmpMetrics);
		cmpMetrics.setLayout(new GridLayout(1, false));

		ImageHyperlink hypLnkAddMetric = toolkit.createImageHyperlink(
				cmpMetrics, SWT.NONE);
		hypLnkAddMetric.addHyperlinkListener(new IHyperlinkListener() {
			public void linkActivated(HyperlinkEvent e) {
				Resource metriceResource = editingService
						.getData(MetricsPackage.Literals.METRIC);
				
				MetricFilterDialog dialog = new MetricFilterDialog(
						NewEditComponent.this.getShell(), metriceResource);
				if (dialog.open() == IDialogConstants.OK_ID) {
					Metric u = (Metric) dialog.getFirstResult();
					if (!comp.getMetricRefs().contains(u)) {
						Command c = new AddCommand(editingService
								.getEditingDomain(), comp.getMetricRefs(), u);
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
		hypLnkAddMetric.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
				false, false, 1, 1));
		toolkit.paintBordersFor(hypLnkAddMetric);
		hypLnkAddMetric.setText("Add");

//		metricsTreeViewer = new TreeViewer(cmpMetrics, SWT.BORDER | SWT.VIRTUAL);
//		metricsTreeViewer.setUseHashlookup(true);
//		Tree tree = metricsTreeViewer.getTree();
//		tree.setLinesVisible(true);
//		tree.setHeaderVisible(true);
//		GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1);
//		gd.heightHint = 100;
//		tree.setLayoutData(gd);
//		toolkit.paintBordersFor(tree);
//
//		TreeViewerColumn treeViewerColumn = new TreeViewerColumn(
//				metricsTreeViewer, SWT.NONE);
//		TreeColumn trclmnName = treeViewerColumn.getColumn();
//		trclmnName.setWidth(100);
//		trclmnName.setText("Name");
//
//		TreeViewerColumn treeViewerColumn_1 = new TreeViewerColumn(
//				metricsTreeViewer, SWT.NONE);
//		TreeColumn trclmnDescription = treeViewerColumn_1.getColumn();
//		trclmnDescription.setWidth(270);
//		trclmnDescription.setText("Description");
//
//		TreeViewerColumn treeViewerColumn_2 = new TreeViewerColumn(
//				metricsTreeViewer, SWT.NONE);
//		TreeColumn trclmnUnit = treeViewerColumn_2.getColumn();
//		trclmnUnit.setWidth(84);
//		trclmnUnit.setText("Unit");

		
		metricsTableViewer = new TableViewer(cmpMetrics, SWT.BORDER
				| SWT.FULL_SELECTION);
		Table metricsTable = metricsTableViewer.getTable();
		metricsTable.setHeaderVisible(true);
		metricsTable.setLinesVisible(true);
		
		GridData gd = new GridData(SWT.FILL, SWT.FILL, true,
				true, 1, 1);
		gd.heightHint = 100;
		metricsTable.setLayoutData(gd);
		toolkit.paintBordersFor(metricsTable);

		TableViewerColumn tableViewerColumn = new TableViewerColumn(
				metricsTableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn = tableViewerColumn.getColumn();
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("Name");

		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(
				metricsTableViewer, SWT.NONE);
		TableColumn tblclmnLevel = tableViewerColumn_1.getColumn();
		tblclmnLevel.setWidth(150);
		tblclmnLevel.setText("Description");

		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(
				metricsTableViewer, SWT.NONE);
		TableColumn tblclmnExpression = tableViewerColumn_2.getColumn();
		tblclmnExpression.setWidth(30);
		tblclmnExpression.setText("Unit");
		
		Menu menu = new Menu(metricsTable);
		metricsTable.setMenu(menu);

		MenuItem mntmRemoveMetric = new MenuItem(menu, SWT.NONE);
		mntmRemoveMetric.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ISelection s = metricsTableViewer.getSelection();
				if (s instanceof IStructuredSelection) {
					Object o = ((IStructuredSelection) s).getFirstElement();
					// FIXME, we can' delete a child metric. 
					
					Command rc = new RemoveCommand(editingService
							.getEditingDomain(), comp.getMetricRefs(), o);
					editingService.getEditingDomain().getCommandStack()
							.execute(rc);
				}
			}
		});
		mntmRemoveMetric.setText("Remove");

		if (readonly) {
			hypLnkAddMetric.setEnabled(false);
			mntmRemoveMetric.setEnabled(false);
		}
		return sctnMetrics;
	}
	
	
	protected Section buildResourceSection(
			boolean readonly) {
		Section sctnResources = toolkit.createSection(this, Section.TWISTIE
				| Section.TITLE_BAR);
		toolkit.paintBordersFor(sctnResources);
		sctnResources.setText("Resources");

		Composite composite_2 = toolkit
				.createComposite(sctnResources, SWT.NONE);
		toolkit.paintBordersFor(composite_2);
		sctnResources.setClient(composite_2);
		composite_2.setLayout(new GridLayout(7, false));
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);

//		ImageHyperlink hypLnkAddResource = toolkit.createImageHyperlink(
//				composite_2, SWT.NONE);
//		hypLnkAddResource.addHyperlinkListener(new IHyperlinkListener() {
//			public void linkActivated(HyperlinkEvent e) {
//				
////				Resource resourceResource = editingService
////						.getData(LibraryPackage.Literals.NET_XRESOURCE);
//				
//				
//				NetXResourceFilterDialog dialog = new NetXResourceFilterDialog(
//						NewEditComponent.this.getShell(), resourceResource);
//				if (dialog.open() == IDialogConstants.OK_ID) {
//					NetXResource u = (NetXResource) dialog.getFirstResult();
//					if (!comp.getResourceRefs().contains(u)) {
//						Command c = new AddCommand(editingService
//								.getEditingDomain(), comp.getResourceRefs(), u);
//						editingService.getEditingDomain().getCommandStack()
//								.execute(c);
//					}
//				}
//			}
//
//			public void linkEntered(HyperlinkEvent e) {
//			}
//
//			public void linkExited(HyperlinkEvent e) {
//			}
//		});
//		hypLnkAddResource.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
//				false, false, 1, 1));
//		toolkit.paintBordersFor(hypLnkAddResource);
//		hypLnkAddResource.setText("Add");

		ImageHyperlink mghprlnkNewImagehyperlink = toolkit
				.createImageHyperlink(composite_2, SWT.NONE);
		mghprlnkNewImagehyperlink.setLayoutData(new GridData(SWT.RIGHT,
				SWT.CENTER, false, false, 1, 1));
		mghprlnkNewImagehyperlink
				.addHyperlinkListener(new IHyperlinkListener() {
					public void linkActivated(HyperlinkEvent e) {
						NewEditResource resourceScreen = new NewEditResource(
								screenService.getScreenContainer(), SWT.NONE);
						resourceScreen.setOperation(Screens.OPERATION_NEW);
						resourceScreen.setScreenService(screenService);
						
						// The CDO Resource, will depend on the component path. 
						final Resource resourcesResource = editingService.getDataService().getProvider().getResource(
								modelUtils.getResourcePath(comp));
						
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
		Table resourcesTable = resourceTableViewer.getTable();
		resourcesTable.setLinesVisible(true);
		resourcesTable.setHeaderVisible(true);
		
		GridData gd = new GridData(SWT.FILL, SWT.FILL, true,
				true, 8, 3);
		gd.heightHint = 100;
		resourcesTable.setLayoutData(gd);
		toolkit.paintBordersFor(resourcesTable);

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

		Menu menu_1 = new Menu(resourcesTable);
		resourcesTable.setMenu(menu_1);

		MenuItem mntmEditResource = new MenuItem(menu_1, SWT.NONE);
		mntmEditResource.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ISelection s = resourceTableViewer.getSelection();
				if (s instanceof IStructuredSelection) {
					Object object = ((IStructuredSelection) s)
							.getFirstElement();
					NewEditResource editResourceScreen = new NewEditResource(
							screenService.getScreenContainer(), SWT.NONE);
					editResourceScreen.setScreenService(screenService);
					editResourceScreen.setOperation(getOperation());
					// We can probably get away without the resource....
					editResourceScreen.injectData(null, object);
					screenService.setActiveScreen(editResourceScreen);
				}
			}
		});
		mntmEditResource.setText("Edit...");

		MenuItem mntmRemoveResource = new MenuItem(menu_1, SWT.NONE);
		mntmRemoveResource.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ISelection s = resourceTableViewer.getSelection();
				if (s instanceof IStructuredSelection) {

					// Object o = ((IStructuredSelection) s).getFirstElement();
					// Command rc =
					// DeleteCommand.create(editingService.getEditingDomain(),
					// o);
					// editingService.getEditingDomain().getCommandStack().execute(rc);

					Object o = ((IStructuredSelection) s).getFirstElement();
					Command rc = new RemoveCommand(editingService
							.getEditingDomain(), comp.getResourceRefs(), o);
					editingService.getEditingDomain().getCommandStack()
							.execute(rc);
				}
			}
		});
		mntmRemoveResource.setText("Remove");

		ImageHyperlink imageHyperlink_2 = toolkit.createImageHyperlink(
				composite_2, SWT.NONE);
		GridData gd_imageHyperlink_2 = new GridData(SWT.LEFT, SWT.CENTER,
				false, false, 1, 1);
		gd_imageHyperlink_2.widthHint = 18;
		imageHyperlink_2.setLayoutData(gd_imageHyperlink_2);
		imageHyperlink_2.setImage(ResourceManager.getPluginImage(
				"com.netxforge.netxstudio.models.edit",
				"icons/full/obj16/Expression_H.png"));
		toolkit.paintBordersFor(imageHyperlink_2);
		imageHyperlink_2.setText("");

		@SuppressWarnings("unused")
		Label lblCapacityExpression = toolkit.createLabel(composite_2,
				"Capacity", SWT.NONE);

		txtCapExpression = toolkit.createText(composite_2, "New Text",
				SWT.READ_ONLY);
		GridData gd_txtCapExpression = new GridData(SWT.LEFT, SWT.CENTER,
				false, false, 1, 1);
		gd_txtCapExpression.widthHint = 150;
		txtCapExpression.setLayoutData(gd_txtCapExpression);
		txtCapExpression.setText("");

		ImageHyperlink imageHyperlink = toolkit.createImageHyperlink(
				composite_2, SWT.NONE);
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
		imageHyperlink.setImage(ResourceManager.getPluginImage(
				"org.eclipse.ui", "/icons/full/etool16/delete.gif"));
		toolkit.paintBordersFor(imageHyperlink);
		imageHyperlink.setText("");

		Button btnSelectCapExpression = toolkit.createButton(composite_2,
				"Select", SWT.NONE);
		btnSelectCapExpression.setLayoutData(new GridData(SWT.RIGHT,
				SWT.CENTER, false, false, 1, 1));
		btnSelectCapExpression.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Resource expressionResource = editingService
						.getData(LibraryPackage.Literals.EXPRESSION);
				ExpressionFilterDialog dialog = new ExpressionFilterDialog(
						NewEditComponent.this.getShell(), expressionResource);
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

		Label label = new Label(composite_2, SWT.NONE);
		label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1,
				1));
		new Label(composite_2, SWT.NONE);

		ImageHyperlink imageHyperlink_3 = toolkit.createImageHyperlink(
				composite_2, SWT.NONE);
		GridData gd_imageHyperlink_3 = new GridData(SWT.LEFT, SWT.CENTER,
				false, false, 1, 1);
		gd_imageHyperlink_3.widthHint = 18;
		imageHyperlink_3.setLayoutData(gd_imageHyperlink_3);
		imageHyperlink_3.setImage(ResourceManager.getPluginImage(
				"com.netxforge.netxstudio.models.edit",
				"icons/full/obj16/Expression_H.png"));
		toolkit.paintBordersFor(imageHyperlink_3);
		imageHyperlink_3.setText("");

		@SuppressWarnings("unused")
		Label lblUtilizationExpression = toolkit.createLabel(composite_2,
				"Utilization", SWT.NONE);

		txtUtilExpression = toolkit.createText(composite_2, "New Text",
				SWT.NONE | SWT.READ_ONLY);
		GridData gd_txtUtilExpression = new GridData(SWT.LEFT, SWT.CENTER,
				false, false, 1, 1);
		gd_txtUtilExpression.widthHint = 150;
		txtUtilExpression.setLayoutData(gd_txtUtilExpression);
		txtUtilExpression.setText("");

		ImageHyperlink imageHyperlink_1 = toolkit.createImageHyperlink(
				composite_2, SWT.NONE);
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
		imageHyperlink_1.setImage(ResourceManager.getPluginImage(
				"org.eclipse.ui", "/icons/full/etool16/delete.gif"));
		toolkit.paintBordersFor(imageHyperlink_1);
		imageHyperlink_1.setText("");

		Button btnSelectUtilExpression = toolkit.createButton(composite_2,
				"Select", SWT.NONE);
		btnSelectUtilExpression.setLayoutData(new GridData(SWT.RIGHT,
				SWT.CENTER, false, false, 1, 1));

		btnSelectUtilExpression.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Resource expressionResource = editingService
						.getData(LibraryPackage.Literals.EXPRESSION);
				ExpressionFilterDialog dialog = new ExpressionFilterDialog(
						NewEditComponent.this.getShell(), expressionResource);
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
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);

		if (readonly) {
			btnSelectCapExpression.setEnabled(false);
			btnSelectUtilExpression.setEnabled(false);
//			hypLnkAddResource.setEnabled(false);

			mntmEditResource.setEnabled(false);
			mntmRemoveResource.setEnabled(false);
		}
		return sctnResources;
	}
	
	public void injectData(Object owner, Object object) {
		if (object instanceof Component) {
			this.comp = (Component) object;
		} else {
			return;
		}
		buildUI();
		initDataBindings_();
	}
	
	public abstract void buildUI();

	
	public EMFDataBindingContext initDataBindings_() {
		EMFDataBindingContext context = new EMFDataBindingContext();
		return context;
	}


	public void bindResourcesSection(EMFDataBindingContext context) {
		IObservableValue capExpressionObservable = SWTObservables.observeText(
				this.txtCapExpression, SWT.Modify);

		IObservableValue utilExpressionObservable = SWTObservables.observeText(
				this.txtUtilExpression, SWT.Modify);

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
		context.bindValue(capExpressionObservable,
				capacityExpressionProperty.observe(comp), null, null);
		context.bindValue(utilExpressionObservable,
				utilExpressionProperty.observe(comp), null, null);
		
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
				LibraryPackage.Literals.COMPONENT__TOLERANCE_REFS);

		tolerancesTableViewer.setInput(l.observe(comp));
	}
	
	
	public void bindMetricSection() {
		
		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		metricsTableViewer.setContentProvider(listContentProvider);
		IObservableMap[] observeMaps = EMFObservables.observeMaps(
				listContentProvider.getKnownElements(),
				new EStructuralFeature[] {
						MetricsPackage.Literals.METRIC__NAME,
						MetricsPackage.Literals.METRIC__DESCRIPTION,
						MetricsPackage.Literals.METRIC__UNIT_REF});
		metricsTableViewer
				.setLabelProvider(new MetricTreeLabelProvider(observeMaps));
		IEMFListProperty l = EMFEditProperties.list(
				editingService.getEditingDomain(),
				LibraryPackage.Literals.COMPONENT__METRIC_REFS);

		metricsTableViewer.setInput(l.observe(comp));
		
		
//		ObservableListTreeContentProvider listTreeContentProvider = new ObservableListTreeContentProvider(
//				new MetricTreeFactory(editingService.getEditingDomain()), new MetricTreeStructureAdvisor());
//		metricsTreeViewer.setContentProvider(listTreeContentProvider);
//		IObservableSet set = listTreeContentProvider.getKnownElements();
//		
//		IObservableMap[] map = new IObservableMap[2];
//
//		map[0] = EMFProperties.value(MetricsPackage.Literals.METRIC__NAME)
//				.observeDetail(set);
//
//		map[1] = EMFProperties.value(
//				MetricsPackage.Literals.METRIC__DESCRIPTION).observeDetail(set);
//		metricsTreeViewer.setLabelProvider(new MetricTreeLabelProvider(map));
//
//		IEMFListProperty metricsProperty = EMFEditProperties.list(editingService.getEditingDomain(), LibraryPackage.Literals.COMPONENT__METRIC_REFS);
//		IObservableList metricsObservableList = metricsProperty.observe(comp);
//		metricsTreeViewer.setInput(metricsObservableList);
	}
	
}