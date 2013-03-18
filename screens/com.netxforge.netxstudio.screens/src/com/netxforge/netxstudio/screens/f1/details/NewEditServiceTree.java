/*******************************************************************************
 * Copyright (c) 10 dec. 2012 NetXForge.
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details. You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>
 * 
 * Contributors: Christophe Bouhier - initial API and implementation and/or
 * initial documentation
 *******************************************************************************/
package com.netxforge.netxstudio.screens.f1.details;

import java.util.Date;
import java.util.List;

import javax.xml.datatype.XMLGregorianCalendar;

import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.emf.cdo.util.CDOUtil;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.EMFObservables;
import org.eclipse.emf.databinding.EMFUpdateValueStrategy;
import org.eclipse.emf.databinding.FeaturePath;
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
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.nebula.widgets.datechooser.DateChooserCombo;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
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
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.ColumnLayoutData;
import org.eclipse.ui.forms.widgets.FormText;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.progress.UIJob;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.wb.swt.SWTResourceManager;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.netxforge.netxstudio.common.model.RFSServiceSummary;
import com.netxforge.netxstudio.generics.GenericsFactory;
import com.netxforge.netxstudio.generics.GenericsPackage;
import com.netxforge.netxstudio.generics.Lifecycle;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.library.Tolerance;
import com.netxforge.netxstudio.operators.Network;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.screens.AbstractDetailsScreen;
import com.netxforge.netxstudio.screens.dialog.NodeOrNetworkFilterDialog;
import com.netxforge.netxstudio.screens.dialog.ServiceUserFilterDialog;
import com.netxforge.netxstudio.screens.dialog.ToleranceFilterDialog;
import com.netxforge.netxstudio.screens.editing.IEditingService;
import com.netxforge.netxstudio.screens.editing.selector.IDataScreenInjection;
import com.netxforge.netxstudio.screens.editing.selector.ScreenUtil;
import com.netxforge.netxstudio.screens.editing.util.DateChooserComboObservableValue;
import com.netxforge.netxstudio.screens.f1.RFSServiceSummaryJob;
import com.netxforge.netxstudio.screens.f1.ServiceDistributionScreen;
import com.netxforge.netxstudio.screens.f1.ServiceHierarchy;
import com.netxforge.netxstudio.screens.f2.support.ToleranceObservableMapLabelProvider;
import com.netxforge.netxstudio.screens.internal.ScreensActivator;
import com.netxforge.netxstudio.services.RFSService;
import com.netxforge.netxstudio.services.ServiceUser;
import com.netxforge.netxstudio.services.ServicesPackage;

/**
 * Component for showing the Service Summary.
 * 
 * 
 * @author Christophe Bouhier
 * 
 */
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

	private FormText formTextLastMonitor;

	private FormText formTextNumberOfNodes;

	private FormText formTextNumberOfResources;

	private FormText formTextRed;

	private FormText formTextAmber;

	private FormText formTextGreen;

	private DateChooserCombo dcProposed;
	private DateChooserCombo dcPlanned;
	private DateChooserCombo dcConstruction;
	private DateChooserCombo dcInService;
	private DateChooserCombo dcOutOfService;

	private RFSServiceSummaryJob job;
	private final RefreshSummaryJob refreshSummaryJob = new RefreshSummaryJob();

	private Section sctnInfo;

	private boolean readonly;

	private int widgetStyle;

	private Section sctnSummary;

	private RFSServiceSummary summary;

	public NewEditServiceTree(Composite parent, int style,
			final IEditingService editingService) {
		super(parent, style);
		this.editingService = editingService;

		this.addDisposeListener(new DisposeListener() {

			public void widgetDisposed(DisposeEvent e) {
				if (job != null && job.isRunning()) {
					job.cancel();
				}
				refreshSummaryJob.cancel();
			}
		});
		// buildUI();
	}

	private void buildUI() {

		// Readonlyness.
		readonly = ScreenUtil.isReadOnlyOperation(this.getOperation());
		widgetStyle = readonly ? SWT.READ_ONLY : SWT.NONE;

		buildInfoSection();
		buildSummarySection();
		buildNetworkElementsSection();
		buildServiceUserSection();
		buildLifeCycleSection();
		buildHierarchySection();
		buildServiceDistributionSection();
		buildToleranceSection();

	}

	private void buildLifeCycleSection() {

		Section sctnLifecycle = toolkit.createSection(this, Section.TITLE_BAR
				| Section.TWISTIE);
		toolkit.paintBordersFor(sctnLifecycle);
		sctnLifecycle.setText("Lifecycle");

		Composite cmpLifeCycle = toolkit.createComposite(sctnLifecycle,
				SWT.NONE);
		toolkit.paintBordersFor(cmpLifeCycle);
		sctnLifecycle.setClient(cmpLifeCycle);
		cmpLifeCycle.setLayout(new GridLayout(2, false));

		Label lblProposed = toolkit.createLabel(cmpLifeCycle, "Proposed:",
				SWT.NONE);
		lblProposed.setAlignment(SWT.RIGHT);
		GridData gd_lblProposed = new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1);
		gd_lblProposed.widthHint = 70;
		lblProposed.setLayoutData(gd_lblProposed);

		dcProposed = new DateChooserCombo(cmpLifeCycle, SWT.BORDER | SWT.FLAT);
		GridData gd_dcProposed = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_dcProposed.heightHint = 20;
		dcProposed.setLayoutData(gd_dcProposed);
		toolkit.adapt(dcProposed);
		toolkit.paintBordersFor(dcProposed);

		Label lblPlanned = toolkit.createLabel(cmpLifeCycle, "Planned:",
				SWT.NONE);
		lblPlanned.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		lblPlanned.setAlignment(SWT.RIGHT);

		dcPlanned = new DateChooserCombo(cmpLifeCycle, SWT.BORDER | SWT.FLAT);
		GridData gd_dcPlanned = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_dcPlanned.heightHint = 20;
		dcPlanned.setLayoutData(gd_dcPlanned);
		toolkit.adapt(dcPlanned);
		toolkit.paintBordersFor(dcPlanned);

		Label lblConstruction = toolkit.createLabel(cmpLifeCycle,
				"Construction:", SWT.NONE);
		lblConstruction.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
				false, false, 1, 1));

		dcConstruction = new DateChooserCombo(cmpLifeCycle, SWT.BORDER
				| SWT.FLAT);
		GridData gd_dcConstruction = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_dcConstruction.heightHint = 20;
		dcConstruction.setLayoutData(gd_dcConstruction);
		toolkit.adapt(dcConstruction);
		toolkit.paintBordersFor(dcConstruction);

		Label lblInService = toolkit.createLabel(cmpLifeCycle, "In Service:",
				SWT.NONE);
		lblInService.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
				false, 1, 1));
		lblInService.setAlignment(SWT.RIGHT);

		dcInService = new DateChooserCombo(cmpLifeCycle, SWT.BORDER | SWT.FLAT);
		GridData gd_dcInService = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_dcInService.heightHint = 20;
		dcInService.setLayoutData(gd_dcInService);
		toolkit.adapt(dcInService);
		toolkit.paintBordersFor(dcInService);

		Label lblOutOfService = toolkit.createLabel(cmpLifeCycle,
				"Out of Service:", SWT.NONE);
		GridData gd_lblOutOfService = new GridData(SWT.RIGHT, SWT.CENTER,
				false, false, 1, 1);
		gd_lblOutOfService.widthHint = 80;
		lblOutOfService.setLayoutData(gd_lblOutOfService);

		dcOutOfService = new DateChooserCombo(cmpLifeCycle, SWT.BORDER
				| SWT.FLAT);
		GridData gd_dcOutOfService = new GridData(SWT.LEFT, SWT.CENTER, false,
				false, 1, 1);
		gd_dcOutOfService.heightHint = 20;
		dcOutOfService.setLayoutData(gd_dcOutOfService);
		dcOutOfService.setWeeksVisible(true);
		toolkit.adapt(dcOutOfService);
		toolkit.paintBordersFor(dcOutOfService);

		if (readonly) {
			dcProposed.setEditable(false);
			dcPlanned.setEditable(false);
			dcConstruction.setEditable(false);
			dcInService.setEditable(false);
			dcOutOfService.setEditable(false);
		}
	}

	private void buildToleranceSection() {
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

		if (!readonly) {
			ImageHyperlink hypLnkAddTolerance = formToolkit
					.createImageHyperlink(cmpTolerances, SWT.NONE);
			hypLnkAddTolerance.addHyperlinkListener(new IHyperlinkListener() {
				public void linkActivated(HyperlinkEvent e) {
					Resource toleranceResource = editingService
							.getData(LibraryPackage.Literals.TOLERANCE);
					ToleranceFilterDialog dialog = new ToleranceFilterDialog(
							NewEditServiceTree.this.getShell(),
							toleranceResource);
					if (dialog.open() == IDialogConstants.OK_ID) {
						Tolerance tol = (Tolerance) dialog.getFirstResult();
						if (!service.getToleranceRefs().contains(tol)) {
							Command c = new AddCommand(editingService
									.getEditingDomain(), service
									.getToleranceRefs(), tol);
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
			hypLnkAddTolerance.setLayoutData(new GridData(SWT.RIGHT,
					SWT.CENTER, false, false, 1, 1));
			formToolkit.paintBordersFor(hypLnkAddTolerance);
			hypLnkAddTolerance.setText("Add");
		}
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
			mntmRemoveTolerance.setEnabled(false);

		}
	}

	private void buildServiceDistributionSection() {
		Section sctnDistribution = formToolkit.createSection(this,
				Section.TWISTIE | Section.TITLE_BAR);
		formToolkit.paintBordersFor(sctnDistribution);
		sctnDistribution.setText("Distribution");
		sctnDistribution.setExpanded(false);

		Composite composite_4 = formToolkit.createComposite(sctnDistribution,
				SWT.NONE);
		formToolkit.paintBordersFor(composite_4);
		sctnDistribution.setClient(composite_4);
		composite_4.setLayout(new GridLayout(1, false));

		ImageHyperlink mghprlnkEdit = formToolkit.createImageHyperlink(
				composite_4, SWT.NONE);
		mghprlnkEdit.addHyperlinkListener(new IHyperlinkListener() {
			public void linkActivated(HyperlinkEvent e) {

				if (service
						.eIsSet(ServicesPackage.Literals.SERVICE__SERVICE_DISTRIBUTION)) {

					ServiceDistributionScreen screen = new ServiceDistributionScreen(
							screenService.getScreenContainer(), SWT.NONE);
					screen.setScreenService(screenService);
					screen.setOperation(getOperation());
					screen.injectData(null, service);
					screenService.setActiveScreen(screen);
				} else {
					MessageDialog.openInformation(
							NewEditServiceTree.this.getShell(),
							"Service Distribution is not existing",
							"A Service distribution object can only be created in edit mode");
				}
			}

			public void linkEntered(HyperlinkEvent e) {
			}

			public void linkExited(HyperlinkEvent e) {
			}
		});
		mghprlnkEdit.setImage(ResourceManager.getPluginImage(
				"com.netxforge.netxstudio.models.edit",
				"icons/full/obj16/Servicedistribution_H.png"));
		formToolkit.paintBordersFor(mghprlnkEdit);

		mghprlnkEdit.setText(this.getOperationText());
	}

	private void buildHierarchySection() {
		Section sctnHiarchy = formToolkit.createSection(this, Section.TWISTIE
				| Section.TITLE_BAR);
		formToolkit.paintBordersFor(sctnHiarchy);
		sctnHiarchy.setText("Hierarchy");

		Composite hierarchyComposite = formToolkit.createComposite(sctnHiarchy,
				SWT.NONE);
		formToolkit.paintBordersFor(hierarchyComposite);
		sctnHiarchy.setClient(hierarchyComposite);
		hierarchyComposite.setLayout(new GridLayout(1, false));

		ImageHyperlink mghprlnkShowHiararchy = formToolkit
				.createImageHyperlink(hierarchyComposite, SWT.NONE);
		mghprlnkShowHiararchy.addHyperlinkListener(new IHyperlinkListener() {
			public void linkActivated(HyperlinkEvent e) {

				ServiceHierarchy sh = new ServiceHierarchy(screenService
						.getScreenContainer(), SWT.NONE);
				sh.setScreenService(screenService);
				sh.setOperation(ScreenUtil.OPERATION_READ_ONLY);
				sh.injectData(null, service);
				screenService.setActiveScreen(sh);
			}

			public void linkEntered(HyperlinkEvent e) {
			}

			public void linkExited(HyperlinkEvent e) {
			}
		});
		formToolkit.paintBordersFor(mghprlnkShowHiararchy);
		mghprlnkShowHiararchy.setText("Show Hierarchy");
	}

	private void buildServiceUserSection() {
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

		if (!readonly) {
			ImageHyperlink mghprlnkAddServiceUser = formToolkit
					.createImageHyperlink(composite_1, SWT.NONE);
			mghprlnkAddServiceUser.setImage(null);
			mghprlnkAddServiceUser
					.addHyperlinkListener(new IHyperlinkListener() {
						public void linkActivated(HyperlinkEvent e) {
							Resource serviceUserResource = editingService
									.getData(ServicesPackage.Literals.SERVICE_USER);

							ServiceUserFilterDialog dialog = new ServiceUserFilterDialog(
									NewEditServiceTree.this.getShell(),
									serviceUserResource);

							if (dialog.open() == IDialogConstants.OK_ID) {
								ServiceUser u = (ServiceUser) dialog
										.getFirstResult();
								if (!service.getServiceUserRefs().contains(u)) {
									Command c = new AddCommand(editingService
											.getEditingDomain(), service
											.getServiceUserRefs(), u);
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
			mghprlnkAddServiceUser.setLayoutData(new GridData(SWT.RIGHT,
					SWT.CENTER, true, false, 1, 1));
			formToolkit.paintBordersFor(mghprlnkAddServiceUser);
			mghprlnkAddServiceUser.setText("Add");
		}

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

		if (readonly) {
			mntmRemove.setEnabled(false);
		}
	}

	private void buildNetworkElementsSection() {
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

		if (!readonly) {
			ImageHyperlink mghprlnkAddNetworkElement = formToolkit
					.createImageHyperlink(composite_3, SWT.NONE);
			mghprlnkAddNetworkElement
					.addHyperlinkListener(new IHyperlinkListener() {
						public void linkActivated(HyperlinkEvent e) {

							Resource operatorResource = editingService
									.getData(OperatorsPackage.Literals.OPERATOR);

							NodeOrNetworkFilterDialog dialog = new NodeOrNetworkFilterDialog(
									NewEditServiceTree.this.getShell(),
									operatorResource, modelUtils);

							if (dialog.open() == IDialogConstants.OK_ID) {
								Object o = dialog.getFirstResult();

								List<Node> nodesToAdd = Lists.newArrayList();
								// find non duplicates.
								if (o instanceof Node) {
									nodesToAdd.add((Node) o);
								}
								if (o instanceof Network) {
									// Adds all closure nodes.
									nodesToAdd.addAll(modelUtils
											.nodesForNetwork((Network) o));
								}

								Iterable<Node> filter = Iterables.filter(
										nodesToAdd, new Predicate<Node>() {
											public boolean apply(Node input) {
												return !service.getNodes()
														.contains(input);
											}
										});

								Command c = new AddCommand(editingService
										.getEditingDomain(),
										service.getNodes(), Lists
												.newArrayList(filter));
								editingService.getEditingDomain()
										.getCommandStack().execute(c);
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

		}

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
		tblclmnNewColumn_1.setWidth(120);
		tblclmnNewColumn_1.setText("ID");

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

		if (readonly) {
			mntmRemoveNetworkElement.setEnabled(false);
		}
	}

	private void buildSummarySection() {

		sctnSummary = formToolkit.createSection(this, Section.TWISTIE
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
		formTextLastMonitor.setLayoutData(new GridData(SWT.FILL, SWT.CENTER,
				true, false, 3, 1));

		Label lblMonitoredNodes = formToolkit.createLabel(composite_2,
				"# Monitored NE's:", SWT.NONE);
		lblMonitoredNodes.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
				false, false, 1, 1));

		formTextNumberOfNodes = formToolkit.createFormText(composite_2, false);
		formTextNumberOfNodes.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER,
				false, false, 3, 1));
		formToolkit.paintBordersFor(formTextNumberOfNodes);
		formTextNumberOfNodes.setText("", false, false);

		Label lblMonitoredRess = new Label(composite_2, SWT.NONE);
		lblMonitoredRess.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER,
				false, false, 1, 1));
		formToolkit.adapt(lblMonitoredRess, true, true);
		lblMonitoredRess.setText("# Monitored RES's:");

		formTextNumberOfResources = formToolkit.createFormText(composite_2,
				false);
		formTextNumberOfResources.setLayoutData(new GridData(SWT.LEFT,
				SWT.CENTER, false, false, 3, 1));
		formToolkit.paintBordersFor(formTextNumberOfResources);
		formTextNumberOfResources.setText("", false, false);

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
				"RAG Status RES's:", SWT.NONE);
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
	}

	private void buildInfoSection() {
		sctnInfo = formToolkit.createSection(this, Section.EXPANDED
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
				| SWT.MULTI | widgetStyle);
		txtDescription.setText("");
		GridData gd_txtDescription = new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1);
		gd_txtDescription.heightHint = 133;
		txtDescription.setLayoutData(gd_txtDescription);
	}

	public EMFDataBindingContext initDataBindings_() {

		EMFDataBindingContext context = new EMFDataBindingContext();

		prepServiceSummary();

		bindInfoSection(context);
		bindLifeCycle(context);
		bindNetworkElementSection();
		bindServiceUserSection();
		bindToleranceSection();

		return context;
	}

	/**
	 * Creates a summary in the background, update relevant UI bits when done.
	 */
	private void prepServiceSummary() {

		if (job == null) {
			job = new RFSServiceSummaryJob(modelUtils);
			job.addNotifier(new JobChangeAdapter() {
				@Override
				public void done(IJobChangeEvent event) {

					summary = job.getSummary();
					// Schedule a refresh.
					refreshSummaryJob.schedule(100);
				}
			});
		}
		if (job.isRunning()) {
			// This will abrupt the job but on demand, so we can't really start
			// a new job here.
			job.cancelMonitor();
		}

		job.setRFSServiceToProcess(service);
		job.go(); // Should spawn a job processing the xls.

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
		IObservableSet set = listContentProvider.getKnownElements();

		List<IObservableMap> mapList = Lists.newArrayList();

		mapList.add(EMFEditProperties.value(editingService.getEditingDomain(),
				ServicesPackage.Literals.RFS_SERVICE__NODES).observeDetail(set));
		mapList.add(EMFEditProperties.value(editingService.getEditingDomain(),
				OperatorsPackage.Literals.NODE__NODE_TYPE).observeDetail(set));
		mapList.add(EMFEditProperties.value(editingService.getEditingDomain(),
				OperatorsPackage.Literals.NODE__NODE_ID).observeDetail(set));

		// IObservableMap[] observeMaps = EMFObservables.observeMaps(
		// listContentProvider.getKnownElements(),
		// new EStructuralFeature[] {,});

		IObservableMap[] map = new IObservableMap[mapList.size()];
		mapList.toArray(map);

		networkElementsTableViewer
				.setLabelProvider(new NodeInServiceObservableMapLabelProvider(
						map));

		IEMFListProperty l = EMFEditProperties.list(
				editingService.getEditingDomain(),
				ServicesPackage.Literals.RFS_SERVICE__NODES);

		networkElementsTableViewer.setInput(l.observe(service));
	}

	protected void bindLifeCycle(EMFDataBindingContext context) {
		IObservableValue dcProposedObservable = new DateChooserComboObservableValue(
				dcProposed, SWT.Modify);

		IObservableValue dcPlannedObservable = new DateChooserComboObservableValue(
				dcPlanned, SWT.Modify);

		IObservableValue dcConstructionObservable = new DateChooserComboObservableValue(
				dcConstruction, SWT.Modify);

		IObservableValue dcInServiceObservable = new DateChooserComboObservableValue(
				dcInService, SWT.Modify);

		IObservableValue dcOutOfServiceObservable = new DateChooserComboObservableValue(
				dcOutOfService, SWT.Modify);

		IEMFValueProperty proposedProperty = EMFEditProperties.value(
				editingService.getEditingDomain(), FeaturePath.fromList(
						ServicesPackage.Literals.SERVICE__LIFECYCLE,
						GenericsPackage.Literals.LIFECYCLE__PROPOSED));

		IEMFValueProperty plannedProperty = EMFEditProperties.value(
				editingService.getEditingDomain(), FeaturePath.fromList(
						ServicesPackage.Literals.SERVICE__LIFECYCLE,
						GenericsPackage.Literals.LIFECYCLE__PLANNED_DATE));

		IEMFValueProperty constructionProperty = EMFEditProperties.value(
				editingService.getEditingDomain(), FeaturePath.fromList(
						ServicesPackage.Literals.SERVICE__LIFECYCLE,
						GenericsPackage.Literals.LIFECYCLE__CONSTRUCTION_DATE));

		IEMFValueProperty inServiceProperty = EMFEditProperties.value(
				editingService.getEditingDomain(), FeaturePath.fromList(
						ServicesPackage.Literals.SERVICE__LIFECYCLE,
						GenericsPackage.Literals.LIFECYCLE__IN_SERVICE_DATE));

		IEMFValueProperty outOfServiceProperty = EMFEditProperties
				.value(editingService.getEditingDomain(),
						FeaturePath
								.fromList(
										ServicesPackage.Literals.SERVICE__LIFECYCLE,
										GenericsPackage.Literals.LIFECYCLE__OUT_OF_SERVICE_DATE));

		EMFUpdateValueStrategy modelToTargetUpdateStrategy = new EMFUpdateValueStrategy();
		modelToTargetUpdateStrategy.setConverter(new IConverter() {

			public Object getFromType() {
				return XMLGregorianCalendar.class;
			}

			public Object getToType() {
				return Date.class;
			}

			public Object convert(Object fromObject) {
				return modelUtils
						.fromXMLDate((XMLGregorianCalendar) fromObject);
			}
		});

		EMFUpdateValueStrategy targetToModelUpdateStrategy = new EMFUpdateValueStrategy();
		targetToModelUpdateStrategy.setConverter(new IConverter() {

			public Object getFromType() {
				return Date.class;
			}

			public Object getToType() {

				return XMLGregorianCalendar.class;
			}

			public Object convert(Object fromObject) {
				return modelUtils.toXMLDate((Date) fromObject);
			}
		});

		// Create a new lifecycle if non-existent.
		if (service.getLifecycle() == null) {
			Lifecycle newLC = GenericsFactory.eINSTANCE.createLifecycle();
			service.setLifecycle(newLC);
		}

		context.bindValue(dcProposedObservable,
				proposedProperty.observe(service), targetToModelUpdateStrategy,
				modelToTargetUpdateStrategy);

		context.bindValue(dcPlannedObservable,
				plannedProperty.observe(service), targetToModelUpdateStrategy,
				modelToTargetUpdateStrategy);

		context.bindValue(dcConstructionObservable,
				constructionProperty.observe(service),
				targetToModelUpdateStrategy, modelToTargetUpdateStrategy);

		context.bindValue(dcInServiceObservable,
				inServiceProperty.observe(service),
				targetToModelUpdateStrategy, modelToTargetUpdateStrategy);

		context.bindValue(dcOutOfServiceObservable,
				outOfServiceProperty.observe(service),
				targetToModelUpdateStrategy, modelToTargetUpdateStrategy);
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

	private void refreshSummaryUI() {

		if (summary == null) {
			formTextLastMonitor.setText("no monitors", false,
					false);
			sctnSummary.layout();
			NewEditServiceTree.this.layout();

			return;
		}

		formTextLastMonitor.setText(summary.getPeriodFormattedString(), false,
				false);

		formTextNumberOfNodes.setText(
				new Integer(summary.getNodeCount()).toString(), false, false);
		formTextNumberOfResources.setText(
				new Integer(summary.getResourcesCount()).toString(), false,
				false);

		formTextRed.setText(
				new Integer(summary.getRedCountResources()).toString(), false,
				false);
		formTextAmber.setText(
				new Integer(summary.getAmberCountResources()).toString(),
				false, false);
		formTextGreen.setText(
				new Integer(summary.getGreenCountResources()).toString(),
				false, false);
		
		sctnSummary.layout();
		NewEditServiceTree.this.layout();
		// getScreenForm().layout();

	}

	public void injectData(Object owner, Object object) {

		if (object != null && object instanceof RFSService) {
			service = (RFSService) object;
		} else {
			throw new java.lang.IllegalArgumentException(
					"Data injection for screen invalid");
		}

		// Hack to clean a stale reference, which was not removed when deleting
		// an object.
		CDOUtil.cleanStaleReference(service,
				ServicesPackage.Literals.RFS_SERVICE__NODES);

		buildUI();
		this.initDataBindings_();

	}
	
	
	/**
	 * Refreshes the RFS Service Summary Section. 
	 * @author Christophe Bouhier
	 */
	class RefreshSummaryJob extends UIJob {

		/**
		 * Creates a new instance of the class.
		 */
		public RefreshSummaryJob() {
			super("refresh");
			setSystem(true);
		}

		@Override
		public IStatus runInUIThread(IProgressMonitor monitor) {
			if (monitor.isCanceled() || NewEditServiceTree.this.isDisposed())
				return new Status(IStatus.OK, ScreensActivator.PLUGIN_ID,
						IStatus.OK, "", null);

			refreshSummaryUI();

			return new Status(IStatus.OK, PlatformUI.PLUGIN_ID, IStatus.OK, "",
					null);
		}

	}

}
