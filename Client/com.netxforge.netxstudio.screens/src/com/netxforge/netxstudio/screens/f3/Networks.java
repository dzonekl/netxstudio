/*******************************************************************************
 * Copyright (c) May 9, 2011 NetXForge.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  You should have received a copy of the GNU Lesser General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>
 *
 * Contributors:
 *    Christophe Bouhier - initial API and implementation and/or initial documentation
 *******************************************************************************/
package com.netxforge.netxstudio.screens.f3;

import java.util.Collection;
import java.util.List;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.IObservable;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.masterdetail.IObservableFactory;
import org.eclipse.core.databinding.observable.set.IObservableSet;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.databinding.viewers.ObservableListTreeContentProvider;
import org.eclipse.jface.databinding.viewers.TreeStructureAdvisor;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.events.IHyperlinkListener;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ImageHyperlink;
import org.eclipse.wb.swt.ResourceManager;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.netxforge.netxstudio.common.model.ModelUtils;
import com.netxforge.netxstudio.data.actions.ServerRequest;
import com.netxforge.netxstudio.generics.GenericsPackage;
import com.netxforge.netxstudio.library.Equipment;
import com.netxforge.netxstudio.library.Function;
import com.netxforge.netxstudio.library.LibraryPackage;
import com.netxforge.netxstudio.library.NodeType;
import com.netxforge.netxstudio.operators.EquipmentRelationship;
import com.netxforge.netxstudio.operators.FunctionRelationship;
import com.netxforge.netxstudio.operators.Network;
import com.netxforge.netxstudio.operators.Node;
import com.netxforge.netxstudio.operators.Operator;
import com.netxforge.netxstudio.operators.OperatorsFactory;
import com.netxforge.netxstudio.operators.OperatorsPackage;
import com.netxforge.netxstudio.operators.Relationship;
import com.netxforge.netxstudio.operators.Warehouse;
import com.netxforge.netxstudio.scheduling.Job;
import com.netxforge.netxstudio.scheduling.NodeReporterJob;
import com.netxforge.netxstudio.scheduling.SchedulingFactory;
import com.netxforge.netxstudio.scheduling.SchedulingPackage;
import com.netxforge.netxstudio.screens.AbstractScreen;
import com.netxforge.netxstudio.screens.CDOElementComparer;
import com.netxforge.netxstudio.screens.OperatorFilterDialog;
import com.netxforge.netxstudio.screens.SearchFilter;
import com.netxforge.netxstudio.screens.WarehouseFilterDialog;
import com.netxforge.netxstudio.screens.editing.actions.SeparatorAction;
import com.netxforge.netxstudio.screens.editing.actions.WizardUtil;
import com.netxforge.netxstudio.screens.editing.selector.IDataServiceInjection;
import com.netxforge.netxstudio.screens.editing.selector.Screens;
import com.netxforge.netxstudio.screens.f2.NodeHistory;
import com.netxforge.netxstudio.screens.f2.details.NewEditEquipmentLink;
import com.netxforge.netxstudio.screens.f2.details.NewEditFunction;
import com.netxforge.netxstudio.screens.f2.details.NewEditFunctionLink;
import com.netxforge.netxstudio.screens.f2.details.NewEditLink;
import com.netxforge.netxstudio.screens.f2.details.NewEditNetwork;
import com.netxforge.netxstudio.screens.f2.details.NewEditNode;
import com.netxforge.netxstudio.screens.f2.details.NewEditNodeEquipment;
import com.netxforge.netxstudio.screens.f2.details.NewEditNodeType;
import com.netxforge.netxstudio.screens.f3.support.NetworkTreeLabelProvider;
import com.netxforge.netxstudio.screens.f4.NewEditJob;

/**
 * @author Christophe Bouhier christophe.bouhier@netxforge.com
 * 
 */
public class Networks extends AbstractScreen implements IDataServiceInjection {

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());
	private Text txtFilterText;
	@SuppressWarnings("unused")
	private DataBindingContext bindingContext;
	private Form frmNetworks;
	private Resource operatorsResource;
	private TreeViewer networkTreeViewer;
	private Composite cmpDetails;
	private SashForm sashForm;

	@Inject
	ServerRequest serverActions;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public Networks(Composite parent, int style) {
		super(parent, style);

		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				// obm.dispose();
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.netxforge.netxstudio.data.IDataServiceInjection#injectData()
	 */
	public void injectData() {
		operatorsResource = editingService
				.getData(OperatorsPackage.Literals.OPERATOR);
		buildUI();
		initDataBindings_();
	}

	private void buildUI() {
		setLayout(new FillLayout(SWT.HORIZONTAL));

		// Readonlyness.
		boolean readonly = Screens.isReadOnlyOperation(this.getOperation());
		String actionText = readonly ? "View: " : "Edit: ";
		int widgetStyle = readonly ? SWT.READ_ONLY : SWT.NONE;

		frmNetworks = toolkit.createForm(this);

		frmNetworks.setSeparatorVisible(true);
		toolkit.paintBordersFor(frmNetworks);

		frmNetworks.setText(actionText + "Network");
		frmNetworks.getBody().setLayout(new FillLayout(SWT.HORIZONTAL));

		sashForm = new SashForm(frmNetworks.getBody(), SWT.VERTICAL);
		sashForm.setOrientation(SWT.HORIZONTAL);
		toolkit.adapt(sashForm);
		toolkit.paintBordersFor(sashForm);

		Composite composite = toolkit.createComposite(sashForm, SWT.NONE);
		toolkit.paintBordersFor(composite);
		composite.setLayout(new GridLayout(3, false));

		Label lblFilterLabel = toolkit.createLabel(composite, "Filter:",
				SWT.NONE);
		lblFilterLabel.setSize(64, 81);

		txtFilterText = toolkit.createText(composite, "New Text", SWT.H_SCROLL
				| SWT.SEARCH | SWT.CANCEL);
		GridData gd_txtFilterText = new GridData(SWT.FILL, SWT.CENTER, true,
				false, 1, 1);
		// gd_txtFilterText.widthHint = 200;
		txtFilterText.setLayoutData(gd_txtFilterText);
		txtFilterText.setSize(64, 81);
		txtFilterText.setText("");

		txtFilterText.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent ke) {
				networkTreeViewer.refresh();
				ViewerFilter[] filters = networkTreeViewer.getFilters();
				for (ViewerFilter viewerFilter : filters) {
					if (viewerFilter instanceof SearchFilter) {
						((SearchFilter) viewerFilter)
								.setSearchText(txtFilterText.getText());
					}
				}
			}
		});

		mghprlnkNewImagehyperlink = toolkit.createImageHyperlink(composite,
				SWT.NONE);
		mghprlnkNewImagehyperlink
				.addHyperlinkListener(new IHyperlinkListener() {
					public void linkActivated(HyperlinkEvent e) {
						OperatorFilterDialog dialog = new OperatorFilterDialog(
								Networks.this.getShell(), operatorsResource);
						int result = dialog.open();
						if (result == Window.OK) {
							Operator operator = (Operator) dialog
									.getFirstResult();
							Network newNetwork = OperatorsFactory.eINSTANCE
									.createNetwork();
							newNetwork.setName("<new network>");
							Command add = AddCommand.create(
									editingService.getEditingDomain(),
									operator, null, newNetwork);
							editingService.getEditingDomain().getCommandStack()
									.execute(add);
						}

					}

					public void linkEntered(HyperlinkEvent e) {
					}

					public void linkExited(HyperlinkEvent e) {
					}
				});
		mghprlnkNewImagehyperlink.setImage(ResourceManager.getPluginImage(
				"com.netxforge.netxstudio.models.edit",
				"icons/full/ctool16/Network_E.png"));
		mghprlnkNewImagehyperlink.setLayoutData(new GridData(SWT.RIGHT,
				SWT.CENTER, false, false, 1, 1));
		toolkit.paintBordersFor(mghprlnkNewImagehyperlink);
		mghprlnkNewImagehyperlink.setText("New");

		networkTreeViewer = new TreeViewer(composite, SWT.BORDER | SWT.VIRTUAL
				| SWT.MULTI | widgetStyle);
		networkTreeViewer.setUseHashlookup(true);
		networkTreeViewer.setComparer(new CDOElementComparer());
		
		networkTreeViewer
				.addSelectionChangedListener(new ISelectionChangedListener() {
					public void selectionChanged(SelectionChangedEvent event) {
						ISelection s = event.getSelection();
						if (s instanceof IStructuredSelection) {
							IStructuredSelection ss = (IStructuredSelection) s;
							final Object o = ss.getFirstElement();
							Networks.this.getDisplay().asyncExec(
									new Runnable() {
										public void run() {
											try {
												handleDetailsSelection(o);
											} catch (Exception e) {
												e.printStackTrace();
											}
										}
									});
						}
					}
				});
		Tree tree = networkTreeViewer.getTree();
		GridData gd_tree = new GridData(SWT.FILL, SWT.FILL, true, true, 3, 2);
		gd_tree.widthHint = 396;
		tree.setLayoutData(gd_tree);
		tree.setSize(74, 81);
		toolkit.paintBordersFor(tree);

		cmpDetails = toolkit.createComposite(sashForm, SWT.NONE);
		toolkit.paintBordersFor(cmpDetails);
		cmpDetails.setLayout(new FillLayout());
		sashForm.setWeights(new int[] { 3, 7 });

	}

	@Override
	public IAction[] getActions() {

		boolean readonly = Screens.isReadOnlyOperation(getOperation());

		List<IAction> actions = Lists.newArrayList();
		actions.add(new HistoryAction("History...", SWT.PUSH));
		actions.add(new SeparatorAction());
		if (!readonly) {
			actions.add(new MoveToWarehouseAction("Decommission", SWT.PUSH));
			actions.add(new SeparatorAction());
		}
		// actions.add(new ScheduleReportingJobAction(
		// "Schedule Reporting Job...", SWT.PUSH));
		actions.add(new ScheduleReportingJobAction(
				"Schedule Reporting Job...", SWT.PUSH));
		actions.add(new ReportNowAction("Report Now", SWT.PUSH));
		actions.add(new SeparatorAction());
		actions.add(new ExportHTMLAction("Export to HTML", SWT.PUSH));
		actions.add(new ExportXLSAction("Export to XLS", SWT.PUSH));
		IAction[] actionArray = new IAction[actions.size()];
		return actions.toArray(actionArray);
	}

	class HistoryAction extends Action {

		public HistoryAction(String text, int style) {
			super(text, style);
		}

		@Override
		public void run() {
			ISelection s = networkTreeViewer.getSelection();
			if (s instanceof IStructuredSelection) {
				Object object = ((IStructuredSelection) s).getFirstElement();
				if (object instanceof Node) {
					NodeHistory nodeHistoryScreen = new NodeHistory(
							screenService.getScreenContainer(), SWT.NONE);
					nodeHistoryScreen.setScreenService(screenService);
					nodeHistoryScreen.setOperation(Screens.OPERATION_READ_ONLY);
					nodeHistoryScreen.injectData(null, object);
					screenService.setActiveScreen(nodeHistoryScreen);
				}
			}
		}
	}

	class ScheduleReportingJobAction extends Action {
		public ScheduleReportingJobAction(String text, int style) {
			super(text, style);
		}

		@Override
		public void run() {
			if (screenService != null) {
				ISelection selection = getViewer().getSelection();
				if (selection instanceof IStructuredSelection) {
					Object o = ((IStructuredSelection) selection)
							.getFirstElement();
					if (o instanceof Node) {

						Node n = (Node) o;

						int operation = -1;

						Resource jobResource = editingService
								.getData(SchedulingPackage.Literals.JOB);

						Job job = modelUtils
								.jobForSingleObject(jobResource,
										SchedulingPackage.Literals.NODE_REPORTER_JOB,
										SchedulingPackage.Literals.NODE_REPORTER_JOB__NODE,
										(Node) o);

						// Edit or New if the Service has a job or not.
						if (job != null) {
							operation = Screens.OPERATION_EDIT;
						} else {
							operation = Screens.OPERATION_NEW;

							job = SchedulingFactory.eINSTANCE
									.createNodeReporterJob();
							job.setName(((Node) o).getNodeID());
							job.setInterval(ModelUtils.SECONDS_IN_A_WEEK);
							job.setStartTime(modelUtils.toXMLDate(modelUtils
									.todayAndNow()));
							if (job instanceof NodeReporterJob) {
								((NodeReporterJob) job).setNode(n);
							}
						}

						NewEditJob newEditJob = new NewEditJob(
								screenService.getScreenContainer(), SWT.NONE);
						newEditJob.setOperation(operation);
						newEditJob.setScreenService(screenService);
						newEditJob.injectData(jobResource, job);
						screenService.setActiveScreen(newEditJob);
					}
				}
			}
		}
	}

	class ReportNowAction extends Action {
		public ReportNowAction(String text, int style) {
			super(text, style);
		}

		@Override
		public void run() {
			ISelection selection = getViewer().getSelection();
			if (selection instanceof IStructuredSelection) {
				
				WizardUtil
				.openWizard(
						"com.netxforge.netxstudio.screens.reporting",
						(IStructuredSelection) selection);
			}	
			
			
//				Object o = ((IStructuredSelection) selection).getFirstElement();
//				if (o instanceof Node) {
//
//					CDOObject target = null;
//					String identifier = "";
//
//					if (o instanceof CDOObject) {
//						target = (CDOObject) o;
//
//					}
//					try {
//						serverActions.setCDOServer(editingService
//								.getDataService().getProvider().getServer());
//
//						PeriodDialog pr = new PeriodDialog(
//								Networks.this.getShell(), modelUtils);
//						pr.open();
//						DateTimeRange dtr = pr.period();
//
//						Date fromDate = modelUtils.start(dtr);
//						Date toDate = modelUtils.end(dtr);
//
//						// TODO, We get the workflow run ID back, which
//						// could be used
//						// to link back to the screen showing the running
//						// workflows.
//
//						if (target instanceof Node) {
//							@SuppressWarnings("unused")
//							String result = serverActions
//									.callNodeReportingAction(target, fromDate,
//											toDate);
//							identifier = ((Node) target).getNodeID();
//						}
//
//						MessageDialog
//								.openInformation(
//										Networks.this.getShell(),
//										"Reporting now succeeded:",
//										"Reporting for: "
//												+ identifier
//												+ "\n has been initiated on the server.");
//
//					} catch (Exception e1) {
//						e1.printStackTrace();
//						MessageDialog
//								.openError(
//										Networks.this.getShell(),
//										"Reporting now failed:",
//										"Reporting for : "
//												+ identifier
//												+ "\n failed. Consult the log for information on the failure");
//
//					}
//
//				}
//			}
		}
	}

	/**
	 * @author dzonekl
	 */
	class ExportHTMLAction extends Action {

		public ExportHTMLAction(String text, int style) {
			super(text, style);
		}

		@Override
		public void run() {
			ISelection s = networkTreeViewer.getSelection();
			if (s instanceof IStructuredSelection) {
				WizardUtil
						.openWizard(
								"com.netxforge.netxstudio.models.export.wizard.ui.node.html",
								(IStructuredSelection) s);
			}
		}
	}

	/**
	 * @author dzonekl
	 */
	class ExportXLSAction extends Action {

		public ExportXLSAction(String text, int style) {
			super(text, style);
		}

		@Override
		public void run() {
			ISelection s = networkTreeViewer.getSelection();
			if (s instanceof IStructuredSelection) {
				WizardUtil
						.openWizard(
								"com.netxforge.netxstudio.models.export.wizard.ui.node.xls",
								(IStructuredSelection) s);
			}
		}
	}

	/**
	 * Action to move objects to the ware house.
	 * 
	 * @author dzonekl
	 * 
	 */
	class MoveToWarehouseAction extends Action {

		public MoveToWarehouseAction(String text, int style) {
			super(text, style);
		}

		@Override
		public void run() {
			ISelection s = networkTreeViewer.getSelection();
			if (s instanceof IStructuredSelection) {
				@SuppressWarnings("unchecked")
				List<Object> selectionList = ((IStructuredSelection) s)
						.toList();
				Collection<Node> nodeToDecommission = Lists.newArrayList();
				Collection<Equipment> equipmentToDecommission = Lists
						.newArrayList();
				for (Object o : selectionList) {
					if (o instanceof Node) {
						nodeToDecommission.add((Node) o);
					}
					if (o instanceof Equipment) {
						equipmentToDecommission.add((Equipment) o);
					}
				}
				if (nodeToDecommission.size() > 0
						|| equipmentToDecommission.size() > 0) {
					Resource warehouseResource = editingService
							.getData(OperatorsPackage.Literals.WAREHOUSE);
					WarehouseFilterDialog dialog = new WarehouseFilterDialog(
							Networks.this.getShell(), warehouseResource);
					if (dialog.open() == IDialogConstants.OK_ID) {
						Warehouse warehouse = (Warehouse) dialog
								.getFirstResult();

						// Loop through the node and find cross references.

						CompoundCommand cc = new CompoundCommand();
						if (nodeToDecommission.size() > 0) {
							Command c = new AddCommand(
									editingService.getEditingDomain(),
									warehouse.getNodes(), nodeToDecommission);
							cc.append(c);
						}
						if (equipmentToDecommission.size() > 0) {
							Command c = new AddCommand(
									editingService.getEditingDomain(),
									warehouse.getEquipments(),
									equipmentToDecommission);
							cc.append(c);
						}

						editingService.getEditingDomain().getCommandStack()
								.execute(cc);
					}
				}
			}
		}
	}

	public void disposeData() {
		if (editingService != null) {
			editingService.disposeData(operatorsResource);
		}
	}

	public EMFDataBindingContext initDataBindings_() {

		EMFDataBindingContext bindingContext = new EMFDataBindingContext();

		ObservableListTreeContentProvider cp = new ObservableListTreeContentProvider(
				new NetworkTreeFactoryImpl(editingService.getEditingDomain()),
				new NetworkTreeStructureAdvisorImpl());
		networkTreeViewer.setContentProvider(cp);

		IObservableSet set = cp.getKnownElements();

		List<IObservableMap> observableMap = Lists.newArrayList();

		observableMap.add(EMFEditProperties.value(
				editingService.getEditingDomain(),
				GenericsPackage.Literals.COMPANY__NAME).observeDetail(set));

		observableMap.add(EMFEditProperties.value(
				editingService.getEditingDomain(),
				OperatorsPackage.Literals.NETWORK__NAME).observeDetail(set));

		observableMap.add(EMFEditProperties.value(
				editingService.getEditingDomain(),
				OperatorsPackage.Literals.NODE__NODE_ID).observeDetail(set));

		observableMap.add(EMFEditProperties.value(
				editingService.getEditingDomain(),
				OperatorsPackage.Literals.NODE__NODE_TYPE).observeDetail(set));

		observableMap.add(EMFEditProperties.value(
				editingService.getEditingDomain(),
				OperatorsPackage.Literals.RELATIONSHIP__NAME)
				.observeDetail(set));

		// Relationship text changes.
		observableMap.add(EMFEditProperties.value(
				editingService.getEditingDomain(),
				OperatorsPackage.Literals.RELATIONSHIP__NODE_ID1_REF)
				.observeDetail(set));

		observableMap.add(EMFEditProperties.value(
				editingService.getEditingDomain(),
				OperatorsPackage.Literals.RELATIONSHIP__NODE_ID2_REF)
				.observeDetail(set));

		observableMap.add(EMFEditProperties.value(
				editingService.getEditingDomain(),
				OperatorsPackage.Literals.RELATIONSHIP__NAME)
				.observeDetail(set));

		observableMap.add(EMFEditProperties.value(
				editingService.getEditingDomain(),
				LibraryPackage.Literals.NODE_TYPE__NAME).observeDetail(set));

		observableMap.add(EMFProperties.value(
				LibraryPackage.Literals.COMPONENT__NAME).observeDetail(set));

		IObservableMap[] map = new IObservableMap[observableMap.size()];
		observableMap.toArray(map);

		networkTreeViewer.setLabelProvider(new NetworkTreeLabelProvider(map));

		IEMFListProperty networksResourceProperty = EMFEditProperties
				.resource(editingService.getEditingDomain());

		IObservableList networksObservableList = networksResourceProperty
				.observe(operatorsResource);

		networkTreeViewer.setInput(networksObservableList);

		return bindingContext;
	}

	class NetworkTreeFactoryImpl implements IObservableFactory {

		EditingDomain domain;

		private IEMFListProperty operatorObservableProperty = EMFEditProperties
				.list(domain, OperatorsPackage.Literals.OPERATOR__NETWORKS);

		private IEMFListProperty networkObservableProperty = EMFEditProperties
				.multiList(
						domain,
						OperatorsPackage.Literals.NETWORK__NODES,
						OperatorsPackage.Literals.NETWORK__NETWORKS,
						OperatorsPackage.Literals.NETWORK__EQUIPMENT_RELATIONSHIPS,
						OperatorsPackage.Literals.NETWORK__FUNCTION_RELATIONSHIPS);

		// private IEMFListProperty nodeObservableProperty = EMFEditProperties
		// .list(domain, OperatorsPackage.Literals.NODE__NODE_TYPE);

		private IEMFListProperty nodeObservableProperty = EMFEditProperties
				.multiList(domain, FeaturePath.fromList(
						OperatorsPackage.Literals.NODE__NODE_TYPE,
						LibraryPackage.Literals.NODE_TYPE__FUNCTIONS),
						FeaturePath.fromList(
								OperatorsPackage.Literals.NODE__NODE_TYPE,
								LibraryPackage.Literals.NODE_TYPE__EQUIPMENTS));

		private IEMFListProperty functionsObservableProperty = EMFEditProperties
				.multiList(domain, LibraryPackage.Literals.FUNCTION__FUNCTIONS);

		private IEMFListProperty equipmentsObservableProperty = EMFEditProperties
				.multiList(domain,
						LibraryPackage.Literals.EQUIPMENT__EQUIPMENTS);

		NetworkTreeFactoryImpl(EditingDomain domain) {
			this.domain = domain;
		}

		public IObservable createObservable(final Object target) {

			IObservable ol = null;

			if (target instanceof IObservableList) {
				ol = (IObservable) target;
			} else if (target instanceof Operator) {
				ol = operatorObservableProperty.observe(target);
			} else if (target instanceof Network) {
				ol = networkObservableProperty.observe(target);
			} else if (target instanceof Node) {
				ol = nodeObservableProperty.observe(target);
			}

			// else if (target instanceof NodeType) {
			// ol = nodeTypeObservableProperty.observe(target);
			// }

			else if (target instanceof Function) {
				ol = functionsObservableProperty.observe(target);
			} else if (target instanceof Equipment) {
				ol = equipmentsObservableProperty.observe(target);
			}
			return ol;
		}
	}

	class NetworkTreeStructureAdvisorImpl extends TreeStructureAdvisor {
		@Override
		public Object getParent(Object element) {
			return null;
		}

		@Override
		public Boolean hasChildren(Object element) {

			if (element instanceof Operator) {
				return ((Operator) element).getNetworks().size() > 0 ? Boolean.TRUE
						: Boolean.FALSE;
			}
			if (element instanceof Network) {
				Network net = (Network) element;
				if (net.getNetworks().size() > 0 || net.getNodes().size() > 0
						|| net.getEquipmentRelationships().size() > 0
						|| net.getFunctionRelationships().size() > 0) {
					return Boolean.TRUE;
				}
			}

			if (element instanceof Node) {
				Node n = (Node) element;
				if (n.getNodeType() != null) {
					return Boolean.TRUE;
				}
			}

			if (element instanceof NodeType
					&& (((NodeType) element).getFunctions().size() > 0 || ((NodeType) element)
							.getEquipments().size() > 0)) {
				return Boolean.TRUE;
			}

			if (element instanceof Function
					&& ((Function) element).getFunctions().size() > 0) {
				return Boolean.TRUE;
			}
			if (element instanceof Equipment
					&& ((Equipment) element).getEquipments().size() > 0) {
				return Boolean.TRUE;
			}
			return super.hasChildren(element);
		}
	}

	Composite currentDetails;
	private ImageHyperlink mghprlnkNewImagehyperlink;

	private void handleDetailsSelection(Object o) {

		if (currentDetails != null) {
			currentDetails.dispose();
		}

		if (o instanceof Network) {
			NewEditNetwork nef = null;
			nef = new NewEditNetwork(this.cmpDetails, SWT.NONE, editingService);
			nef.setScreenService(screenService);
			nef.injectData(null, o);
			this.currentDetails = nef;
			sashForm.layout(true, true);
		}

		if (o instanceof Node) {
			NewEditNode node = null;
			node = new NewEditNode(this.cmpDetails, SWT.NONE, editingService);
			node.setScreenService(screenService);
			node.injectData(null, o);
			this.currentDetails = node;
			sashForm.layout(true, true);
		}

		if (o instanceof Function) {
			NewEditFunction screen = null;
			screen = new NewEditFunction(this.cmpDetails, SWT.NONE,
					editingService);
			screen.setScreenService(screenService);
			screen.injectData(null, o);
			this.currentDetails = screen;
			sashForm.layout(true, true);
		}
		if (o instanceof Equipment) {
			NewEditNodeEquipment screen = null;
			screen = new NewEditNodeEquipment(this.cmpDetails, SWT.NONE,
					editingService);
			screen.setScreenService(screenService);
			screen.injectData(null, o);
			this.currentDetails = screen;
			sashForm.layout(true, true);

		}
		if (o instanceof NodeType) {
			NewEditNodeType nnt = new NewEditNodeType(this.cmpDetails,
					SWT.NONE, editingService);
			nnt.injectData(null, o);
			this.currentDetails = nnt;
			sashForm.layout(true, true);
		}

		if (o instanceof FunctionRelationship) {
			NewEditFunctionLink linkScreen = new NewEditFunctionLink(
					this.cmpDetails, SWT.NONE, editingService);
			linkScreen.injectData(null, o);
			this.currentDetails = linkScreen;
			sashForm.layout(true, true);
			return;
		}

		if (o instanceof EquipmentRelationship) {
			NewEditEquipmentLink linkScreen = new NewEditEquipmentLink(
					this.cmpDetails, SWT.NONE, editingService);
			linkScreen.injectData(null, o);
			this.currentDetails = linkScreen;
			sashForm.layout(true, true);
			return;
		}

		if (o instanceof Relationship) {
			NewEditLink linkScreen = new NewEditLink(this.cmpDetails, SWT.NONE,
					editingService);
			linkScreen.injectData(null, o);
			this.currentDetails = linkScreen;
			sashForm.layout(true, true);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.common.ui.viewer.IViewerProvider#getViewer()
	 */
	public Viewer getViewer() {
		return this.networkTreeViewer;
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
		return this.frmNetworks;
	}

	@Override
	public void setOperation(int operation) {
		this.operation = operation;
	}

}
