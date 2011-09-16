package com.netxforge.netxstudio.screens.f1.details;

import java.util.List;

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
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
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
import org.eclipse.ui.forms.widgets.ColumnLayoutData;
import org.eclipse.ui.forms.widgets.FormText;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.wb.swt.SWTResourceManager;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.netxforge.netxstudio.common.model.RFSServiceSummary;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.library.Tolerance;
import com.netxforge.netxstudio.operators.Network;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.screens.NodeOrNetworkFilterDialog;
import com.netxforge.netxstudio.screens.ServiceUserFilterDialog;
import com.netxforge.netxstudio.screens.ToleranceFilterDialog;
import com.netxforge.netxstudio.screens.details.AbstractDetailsScreen;
import com.netxforge.netxstudio.screens.editing.IEditingService;
import com.netxforge.netxstudio.screens.editing.selector.IDataScreenInjection;
import com.netxforge.netxstudio.screens.editing.selector.Screens;
import com.netxforge.netxstudio.screens.f2.support.ToleranceObservableMapLabelProvider;
import com.netxforge.netxstudio.services.RFSService;
import com.netxforge.netxstudio.services.ServiceMonitor;
import com.netxforge.netxstudio.services.ServiceUser;
import com.netxforge.netxstudio.services.ServicesPackage;

public class NewEditServiceTree extends AbstractDetailsScreen implements
		IDataScreenInjection {

	final IEditingService editingService;
	
	
	private final FormToolkit formToolkit = new FormToolkit(
			Display.getDefault());
	private Text txtName;
	private Text txtDescription;
	private Table table;
	private TableViewer tolerancesTableViewer;
	private RFSService service;
	private Table tblNetworkElements;
	private TableViewer networkElementsTableViewer;
	private TableViewer serviceUserTableViewer;

	private FormText formTextNumberOfNodes;
	private FormText formTextLastMonitor;

	private FormText formTextRed;

	private FormText formTextAmber;

	private FormText formTextGreen;

	public NewEditServiceTree(Composite parent, int style,
			final IEditingService editingService) {
		super(parent, style);
		this.editingService = editingService;
		// buildUI();
	}

	private void buildUI() {

		// Readonlyness.
		boolean readonly = Screens.isReadOnlyOperation(this.getOperation());
		int widgetStyle = readonly ? SWT.READ_ONLY : SWT.NONE;

		Section sctnInfo = formToolkit.createSection(this, Section.EXPANDED
				| Section.TWISTIE | Section.TITLE_BAR);
		formToolkit.paintBordersFor(sctnInfo);
		sctnInfo.setText("Info");
		sctnInfo.setExpanded(true);

		Composite composite = formToolkit.createComposite(sctnInfo, SWT.NONE);
		formToolkit.paintBordersFor(composite);
		sctnInfo.setClient(composite);
		composite.setLayout(new GridLayout(2, false));

		Label lblName = formToolkit.createLabel(composite, " Name:", SWT.NONE);
		lblName.setAlignment(SWT.RIGHT);
		GridData gd_lblName = new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1);
		gd_lblName.widthHint = 70;
		lblName.setLayoutData(gd_lblName);
		lblName.setBounds(0, 0, 59, 14);

		txtName = formToolkit.createText(composite, "New Text", widgetStyle);
		txtName.setText("");
		GridData gd_txtName = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_txtName.widthHint = 150;
		txtName.setLayoutData(gd_txtName);

		Label lblDescription = formToolkit.createLabel(composite,
				"Description:", SWT.NONE);
		lblDescription.setAlignment(SWT.RIGHT);
		lblDescription.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false,
				false, 1, 1));

		txtDescription = formToolkit.createText(composite, "New Text", SWT.WRAP
				| SWT.MULTI);
		txtDescription.setText("");
		GridData gd_txtDescription = new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1);
		gd_txtDescription.heightHint = 133;
		txtDescription.setLayoutData(gd_txtDescription);

		Section sctnSummary = formToolkit.createSection(this, Section.TWISTIE
				| Section.TITLE_BAR);
		formToolkit.paintBordersFor(sctnSummary);
		sctnSummary.setText("Summary");
		sctnSummary.setExpanded(true);

		Composite composite_2 = formToolkit.createComposite(sctnSummary,
				SWT.NONE);
		formToolkit.paintBordersFor(composite_2);
		sctnSummary.setClient(composite_2);
		composite_2.setLayout(new GridLayout(4, false));

		Label label = formToolkit.createLabel(composite_2, "Last Monitor:",
				SWT.NONE);
		label.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1));
		formTextLastMonitor = formToolkit.createFormText(composite_2, false);
		formToolkit.paintBordersFor(formTextLastMonitor);
		formTextLastMonitor.setText("", false, false);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);

		Label lblMonitoredNodes = formToolkit.createLabel(composite_2,
				"# Monitored NE's:", SWT.NONE);
		lblMonitoredNodes.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
				false, false, 1, 1));

		formTextNumberOfNodes = formToolkit.createFormText(composite_2, false);
		formToolkit.paintBordersFor(formTextNumberOfNodes);
		formTextNumberOfNodes.setText("", false, false);
		new Label(composite_2, SWT.NONE);
		new Label(composite_2, SWT.NONE);

		Composite separator = formToolkit.createCompositeSeparator(composite_2);
		GridData gd_separator = new GridData(SWT.FILL, SWT.CENTER, true, false,
				9, 1);
		gd_separator.heightHint = 2;
		separator.setLayoutData(gd_separator);
		formToolkit.paintBordersFor(separator);

		new Label(composite_2, SWT.NONE);

		Composite cmpRed = formToolkit.createComposite(composite_2, SWT.NONE);
		cmpRed.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
		GridData gd_cmpRed = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_cmpRed.heightHint = 18;
		gd_cmpRed.widthHint = 18;
		cmpRed.setLayoutData(gd_cmpRed);
		formToolkit.paintBordersFor(cmpRed);

		Composite cmpAmber = formToolkit.createComposite(composite_2, SWT.NONE);
		cmpAmber.setBackground(SWTResourceManager.getColor(255, 140, 0));
		GridData gd_cmpAmber = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_cmpAmber.widthHint = 18;
		gd_cmpAmber.heightHint = 18;
		cmpAmber.setLayoutData(gd_cmpAmber);
		formToolkit.paintBordersFor(cmpAmber);

		Composite cmpGreen = formToolkit.createComposite(composite_2, SWT.NONE);
		cmpGreen.setBackground(SWTResourceManager.getColor(173, 255, 47));
		GridData gd_cmpGreen = new GridData(SWT.LEFT, SWT.CENTER, false, false,
				1, 1);
		gd_cmpGreen.widthHint = 18;
		gd_cmpGreen.heightHint = 18;
		cmpGreen.setLayoutData(gd_cmpGreen);
		formToolkit.paintBordersFor(cmpGreen);

		Label lblRagStatus = formToolkit.createLabel(composite_2,
				"RAG Status:", SWT.NONE);
		lblRagStatus.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));

		formTextRed = formToolkit.createFormText(composite_2, false);
		formToolkit.paintBordersFor(formTextRed);
		formTextRed.setText("R", false, false);

		formTextAmber = formToolkit.createFormText(composite_2, false);
		formToolkit.paintBordersFor(formTextAmber);
		formTextAmber.setText("A", false, false);

		formTextGreen = formToolkit.createFormText(composite_2, false);
		formToolkit.paintBordersFor(formTextGreen);
		formTextGreen.setText("G", false, false);

		Section sctnNetworkElements = formToolkit.createSection(this,
				Section.TWISTIE | Section.TITLE_BAR);
		ColumnLayoutData cld_sctnNetworkElements = new ColumnLayoutData();
		cld_sctnNetworkElements.heightHint = 38;
		sctnNetworkElements.setLayoutData(cld_sctnNetworkElements);
		formToolkit.paintBordersFor(sctnNetworkElements);
		sctnNetworkElements.setText("Network Elements");
		sctnNetworkElements.setExpanded(true);

		Composite composite_3 = formToolkit.createComposite(
				sctnNetworkElements, SWT.NONE);
		formToolkit.paintBordersFor(composite_3);
		sctnNetworkElements.setClient(composite_3);
		composite_3.setLayout(new GridLayout(1, false));

		ImageHyperlink mghprlnkAddNetworkElement = formToolkit
				.createImageHyperlink(composite_3, SWT.NONE);
		mghprlnkAddNetworkElement
				.addHyperlinkListener(new IHyperlinkListener() {
					public void linkActivated(HyperlinkEvent e) {

						Resource operatorResource = editingService
								.getData(OperatorsPackage.Literals.OPERATOR);

						NodeOrNetworkFilterDialog dialog = new NodeOrNetworkFilterDialog(
								NewEditServiceTree.this.getShell(),
								operatorResource);

						if (dialog.open() == IDialogConstants.OK_ID) {
							Object o = dialog.getFirstResult();

							List<Node> nodesToAdd = Lists.newArrayList();
							// find non duplicates.
							if (o instanceof Node) {
								nodesToAdd.add((Node) o);
							}
							if (o instanceof Network) {
								nodesToAdd.addAll(((Network) o).getNodes());
							}

							Iterable<Node> filter = Iterables.filter(
									nodesToAdd, new Predicate<Node>() {
										public boolean apply(Node input) {
											return !service.getNodes()
													.contains(input);
										}
									});

							Command c = new AddCommand(editingService
									.getEditingDomain(), service.getNodes(),
									Lists.newArrayList(filter));
							editingService.getEditingDomain().getCommandStack()
									.execute(c);
						}

					}

					public void linkEntered(HyperlinkEvent e) {
					}

					public void linkExited(HyperlinkEvent e) {
					}
				});
		mghprlnkAddNetworkElement.setLayoutData(new GridData(SWT.RIGHT,
				SWT.CENTER, true, false, 1, 1));
		formToolkit.paintBordersFor(mghprlnkAddNetworkElement);
		mghprlnkAddNetworkElement.setText("Add");

		networkElementsTableViewer = new TableViewer(composite_3, SWT.BORDER
				| SWT.FULL_SELECTION | SWT.MULTI);
		tblNetworkElements = networkElementsTableViewer.getTable();
		tblNetworkElements.setLinesVisible(true);
		tblNetworkElements.setHeaderVisible(true);
		GridData gd_table_1 = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_table_1.heightHint = 146;
		tblNetworkElements.setLayoutData(gd_table_1);
		formToolkit.paintBordersFor(tblNetworkElements);

		TableViewerColumn tbvClmnType = new TableViewerColumn(
				networkElementsTableViewer, SWT.NONE);
		TableColumn tblclmnNodeId = tbvClmnType.getColumn();
		tblclmnNodeId.setWidth(79);
		tblclmnNodeId.setText("Type");

		TableViewerColumn tbvClmnNodeID = new TableViewerColumn(
				networkElementsTableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn_1 = tbvClmnNodeID.getColumn();
		tblclmnNewColumn_1.setWidth(64);
		tblclmnNewColumn_1.setText("Node ID");

		Menu menu_2 = new Menu(tblNetworkElements);
		tblNetworkElements.setMenu(menu_2);

		MenuItem mntmRemoveNetworkElement = new MenuItem(menu_2, SWT.NONE);
		mntmRemoveNetworkElement.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ISelection s = networkElementsTableViewer.getSelection();
				if (s instanceof IStructuredSelection) {
					Object o = ((IStructuredSelection) s).toList();
					Command rc = new RemoveCommand(editingService
							.getEditingDomain(), service.getNodes(),
							(List<?>) o);

					// Command rc = new RemoveCommand(editingService
					// .getEditingDomain(), service,
					// ServicesPackage.Literals.RFS_SERVICE__NODES, o);

					editingService.getEditingDomain().getCommandStack()
							.execute(rc);
				}
			}
		});
		mntmRemoveNetworkElement.setText("Remove");

		Section sctnServiceUsers = formToolkit.createSection(this,
				Section.EXPANDED | Section.TWISTIE | Section.TITLE_BAR);
		ColumnLayoutData cld_sctnServiceUsers = new ColumnLayoutData();
		cld_sctnServiceUsers.heightHint = 150;
		sctnServiceUsers.setLayoutData(cld_sctnServiceUsers);
		formToolkit.paintBordersFor(sctnServiceUsers);
		sctnServiceUsers.setText("Service Users");
		sctnServiceUsers.setExpanded(true);

		Composite composite_1 = formToolkit.createComposite(sctnServiceUsers,
				SWT.NONE);
		formToolkit.paintBordersFor(composite_1);
		sctnServiceUsers.setClient(composite_1);
		composite_1.setLayout(new GridLayout(1, false));

		ImageHyperlink mghprlnkAddServiceUser = formToolkit
				.createImageHyperlink(composite_1, SWT.NONE);
		mghprlnkAddServiceUser.setImage(null);
		mghprlnkAddServiceUser.addHyperlinkListener(new IHyperlinkListener() {
			public void linkActivated(HyperlinkEvent e) {
				Resource serviceUserResource = editingService
						.getData(ServicesPackage.Literals.SERVICE_USER);

				ServiceUserFilterDialog dialog = new ServiceUserFilterDialog(
						NewEditServiceTree.this.getShell(), serviceUserResource);

				if (dialog.open() == IDialogConstants.OK_ID) {
					ServiceUser u = (ServiceUser) dialog.getFirstResult();
					if (!service.getServiceUserRefs().contains(u)) {
						Command c = new AddCommand(editingService
								.getEditingDomain(), service
								.getServiceUserRefs(), u);
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
		mghprlnkAddServiceUser.setLayoutData(new GridData(SWT.RIGHT,
				SWT.CENTER, true, false, 1, 1));
		formToolkit.paintBordersFor(mghprlnkAddServiceUser);
		mghprlnkAddServiceUser.setText("Add");

		serviceUserTableViewer = new TableViewer(composite_1, SWT.BORDER
				| SWT.FULL_SELECTION);
		table = serviceUserTableViewer.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		GridData gd_table = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_table.heightHint = 120;
		table.setLayoutData(gd_table);
		formToolkit.paintBordersFor(table);

		TableViewerColumn tableViewerColumn = new TableViewerColumn(
				serviceUserTableViewer, SWT.NONE);
		TableColumn tblclmnName = tableViewerColumn.getColumn();
		tblclmnName.setWidth(120);
		tblclmnName.setText("Name");

		Menu menu_1 = new Menu(table);
		table.setMenu(menu_1);

		MenuItem mntmRemove = new MenuItem(menu_1, SWT.NONE);
		mntmRemove.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ISelection s = serviceUserTableViewer.getSelection();
				if (s instanceof IStructuredSelection) {
					Object o = ((IStructuredSelection) s).toList();
					Command rc = new RemoveCommand(editingService
							.getEditingDomain(), service.getServiceUserRefs(),
							(List<?>) o);
					editingService.getEditingDomain().getCommandStack()
							.execute(rc);
				}
			}
		});
		
		mntmRemove.setText("Remove");

		Section sctnHiarchy = formToolkit.createSection(this, Section.TWISTIE
				| Section.TITLE_BAR);
		formToolkit.paintBordersFor(sctnHiarchy);
		sctnHiarchy.setText("Hierarchy");

		Section sctnTolerances = formToolkit.createSection(this,
				Section.TWISTIE | Section.TITLE_BAR);

		formToolkit.paintBordersFor(sctnTolerances);
		sctnTolerances.setText("Tolerances");
		sctnTolerances.setExpanded(false);

		Composite cmpTolerances = formToolkit.createComposite(sctnTolerances,
				SWT.NONE);
		formToolkit.paintBordersFor(cmpTolerances);
		sctnTolerances.setClient(cmpTolerances);
		cmpTolerances.setLayout(new GridLayout(1, false));

		ImageHyperlink hypLnkAddTolerance = formToolkit.createImageHyperlink(
				cmpTolerances, SWT.NONE);
		hypLnkAddTolerance.addHyperlinkListener(new IHyperlinkListener() {
			public void linkActivated(HyperlinkEvent e) {
				Resource toleranceResource = editingService
						.getData(LibraryPackage.Literals.TOLERANCE);
				ToleranceFilterDialog dialog = new ToleranceFilterDialog(
						NewEditServiceTree.this.getShell(), toleranceResource);
				if (dialog.open() == IDialogConstants.OK_ID) {
					Tolerance tol = (Tolerance) dialog.getFirstResult();
					if (!service.getToleranceRefs().contains(tol)) {
						Command c = new AddCommand(editingService
								.getEditingDomain(),
								service.getToleranceRefs(), tol);
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
		formToolkit.paintBordersFor(hypLnkAddTolerance);
		hypLnkAddTolerance.setText("Add");

		tolerancesTableViewer = new TableViewer(cmpTolerances, SWT.BORDER
				| SWT.FULL_SELECTION);
		Table metricsTable = tolerancesTableViewer.getTable();
		metricsTable.setHeaderVisible(true);
		metricsTable.setLinesVisible(true);

		GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd.heightHint = 100;
		metricsTable.setLayoutData(gd);
		formToolkit.paintBordersFor(metricsTable);

		TableViewerColumn tableViewerColumn_4 = new TableViewerColumn(
				tolerancesTableViewer, SWT.NONE);
		TableColumn tblclmnNewColumn = tableViewerColumn_4.getColumn();
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("Name");

		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(
				tolerancesTableViewer, SWT.NONE);
		TableColumn tblclmnLevel = tableViewerColumn_1.getColumn();
		tblclmnLevel.setWidth(69);
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
							.getEditingDomain(), service.getToleranceRefs(), o);
					editingService.getEditingDomain().getCommandStack()
							.execute(rc);
				}
			}
		});
		mntmRemoveTolerance.setText("Remove");

		if (readonly) {

			hypLnkAddTolerance.setEnabled(false);
			mntmRemoveTolerance.setEnabled(false);

			// TODO, add other actions here.

		}

	}

	public EMFDataBindingContext initDataBindings_() {

		EMFDataBindingContext context = new EMFDataBindingContext();

		RFSServiceSummary summary = new RFSServiceSummary(this.modelUtils, service);
		
		// TODO, It would be nice to make it interactive and be able to browse the Service Monitors! 
		ServiceMonitor sm = modelUtils.lastServiceMonitor(service);
		summary.setRagCountNodes(modelUtils.ragCount(sm));
		summary.setPeriodFormattedString(modelUtils.formatLastMonitorDate(sm));

		formTextLastMonitor.setText(summary.getPeriodFormattedString(),
				false, false);
		formTextNumberOfNodes.setText(
				new Integer(summary.getNodeCount()).toString(), false, false);
		formTextRed.setText(new Integer(summary.getRedCountNodes()).toString(),
				false, false);
		formTextAmber.setText(new Integer(summary.getAmberCountNodes()).toString(),
				false, false);
		formTextGreen.setText(new Integer(summary.getGreenCountNodes()).toString(),
				false, false);

		bindInfoSection(context);
		bindNetworkElementSection();
		bindServiceUserSection();
		bindToleranceSection();

		return context;
	}

	private void bindInfoSection(EMFDataBindingContext context) {
		IObservableValue nameObservable = SWTObservables.observeDelayedValue(
				400, SWTObservables.observeText(txtName, SWT.Modify));

		IObservableValue descriptionObservable = SWTObservables
				.observeDelayedValue(400,
						SWTObservables.observeText(txtDescription, SWT.Modify));

		IEMFValueProperty nameProperty = EMFEditProperties.value(
				editingService.getEditingDomain(),
				ServicesPackage.Literals.SERVICE__SERVICE_NAME);

		IEMFValueProperty descriptionProperty = EMFEditProperties.value(
				editingService.getEditingDomain(),
				ServicesPackage.Literals.SERVICE__SERVICE_DESCRIPTION);

		context.bindValue(nameObservable, nameProperty.observe(service), null,
				null);
		context.bindValue(descriptionObservable,
				descriptionProperty.observe(service), null, null);
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
				ServicesPackage.Literals.RFS_SERVICE__TOLERANCE_REFS);

		tolerancesTableViewer.setInput(l.observe(service));
	}

	public void bindNetworkElementSection() {

		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		networkElementsTableViewer.setContentProvider(listContentProvider);
		IObservableMap[] observeMaps = EMFObservables.observeMaps(
				listContentProvider.getKnownElements(),
				new EStructuralFeature[] {
						OperatorsPackage.Literals.NODE__NODE_TYPE,
						OperatorsPackage.Literals.NODE__NODE_ID });
		networkElementsTableViewer
				.setLabelProvider(new NodeInServiceObservableMapLabelProvider(
						observeMaps));
		IEMFListProperty l = EMFEditProperties.list(
				editingService.getEditingDomain(),
				ServicesPackage.Literals.RFS_SERVICE__NODES);

		networkElementsTableViewer.setInput(l.observe(service));
	}

	public void bindServiceUserSection() {

		ObservableListContentProvider listContentProvider = new ObservableListContentProvider();
		serviceUserTableViewer.setContentProvider(listContentProvider);
		IObservableMap[] observeMaps = EMFObservables
				.observeMaps(
						listContentProvider.getKnownElements(),
						new EStructuralFeature[] { ServicesPackage.Literals.SERVICE_USER__NAME });
		serviceUserTableViewer.setLabelProvider(new ObservableMapLabelProvider(
				observeMaps));
		IEMFListProperty l = EMFEditProperties.list(
				editingService.getEditingDomain(),
				ServicesPackage.Literals.SERVICE__SERVICE_USER_REFS);

		serviceUserTableViewer.setInput(l.observe(service));
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

	public boolean isValid() {
		return false;
	}

	public void injectData(Object owner, Object object) {

		if (object != null && object instanceof RFSService) {
			service = (RFSService) object;
		} else {
			throw new java.lang.IllegalArgumentException(
					"Data injection for screen invalid");
		}

		buildUI();
		this.initDataBindings_();

	}
}